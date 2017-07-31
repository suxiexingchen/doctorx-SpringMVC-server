package com.dkt.online;

import com.dkt.common.SysException;
import com.dkt.entity.SysHuaweiAccount;
import com.dkt.entity.SysOnlineList;
import com.dkt.entity.SysOnlineListHistory;
import com.platform.tool.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

/**
 * Created by litai on 2017/6/21.
 */
@Service
public class OnlineServiceImpl implements OnlineService {

    private static final Logger log = LoggerFactory.getLogger(OnlineServiceImpl.class);

    @Autowired
    private OnlineDao dao;

    @Autowired
    private SysHuaweiAccountDao sysHuaweiAccountDao;

    @Autowired
    private SysOnlineListHistoryDao sysOnlineListHistoryDao;

    @Transactional
    public String bindTVNum(RequestBeanP10019 request) throws SysException {
        String recId = "";
        try {
            List<SysOnlineList> sysOnlineList = dao.getListByUserId(request.getUserId());
            if (sysOnlineList != null && !sysOnlineList.isEmpty()) {
                recId = sysOnlineList.get(0).getRecId();
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new SysException("0", "获取在线信息失败:" + e.getMessage());
        }
        return recId;
    }

    @Transactional
    public HashMap<String, String> obtainNum(RequestBeanP10019 request) {
        HashMap<String, String> map = new HashMap<String, String>();
        try {

            //查询可用华为账号

            List<SysHuaweiAccount> huaweiList = sysHuaweiAccountDao.getList();

            if (huaweiList == null || huaweiList.isEmpty()) {
                throw new SysException("0", "没有可用华为账号");
            }

            //查询用户在线信息，如果在线，将信息移到历史表中
            List<SysOnlineList> sysOnlineList = dao.getListByUserId(request.getUserId());

            SysOnlineList info = null;
            if (sysOnlineList != null && !sysOnlineList.isEmpty()) {
                info = sysOnlineList.get(0);
            } else {
                throw new SysException("0", "用户不在线");
            }

            //获取华为账号，取第一个
            SysHuaweiAccount account = huaweiList.get(0);
            //更新华为账号状态 更新占用资源ID
            account.setCurrentRecId(info.getRecId());
            sysHuaweiAccountDao.update(account);

            //更新用户使用号码
            info.setNumberValue(account.getAccount());
            info.setLastHeartBeatTime(Tools.getCurUnixTime());
            dao.update(info);

            map.put("deviceMacAddr", info.getDeviceMacAddr());
            map.put("numberValue", info.getNumberValue());
            map.put("recId", info.getRecId());


        } catch (SysException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("获取资源失败：" + e.getMessage());
        }
        return map;
    }

    @Transactional
    public HashMap<String, String> unbindNum(RequestBeanP10019 request) {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            List<SysHuaweiAccount> huaweiList = sysHuaweiAccountDao.getListByAccountAndRecId(request.getNumberValue(), request.getRecId());

            if (huaweiList == null || huaweiList.isEmpty()) {
                throw new SysException("0", "没有可释放的华为账号");
            }
            //获取华为账号，取第一个
            SysHuaweiAccount account = huaweiList.get(0);
            account.setCurrentRecId("");
            sysHuaweiAccountDao.update(account);

            //查询用户在线信息，如果在线，将信息移到历史表中
            List<SysOnlineList> sysOnlineList = dao.getListByUserId(request.getUserId());

            SysOnlineList info = null;
            if (sysOnlineList != null && !sysOnlineList.isEmpty()) {
                info = sysOnlineList.get(0);
                info.setNumberValue("");
                info.setLastHeartBeatTime(Tools.getCurUnixTime());
                dao.update(info);
            } else {
                throw new SysException("0", "用户不在线");
            }

            map.put("deviceMacAddr", info.getDeviceMacAddr());

        } catch (SysException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("释放华为账号失败：" + e.getMessage());
        }
        return map;
    }

}
