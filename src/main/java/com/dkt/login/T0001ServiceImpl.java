package com.dkt.login;

import com.dkt.common.SysConst;
import com.dkt.common.UserCache;
import com.dkt.entity.*;
import com.dkt.online.OnlineDao;
import com.dkt.online.SysOnlineListHistoryDao;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * Created by litai on 2017/6/14.
 */
@Service
public class T0001ServiceImpl implements T0001Service {

    private static final Logger LOG = LoggerFactory.getLogger(T0001Service.class);

    @Autowired
    private T0001Dao t0001Dao;
    @Autowired
    private P0013Service p0013Service;
    @Autowired
    private OnlineDao onlineDao;
    @Autowired
    private SysOnlineListHistoryDao sysOnlineListHistoryDao;

    @Transactional
    @Override
    public T0001ResponseBean findByUp(String userName, String passwd, String appType) throws IllegalAccessException {
        UserOper userOper = t0001Dao.findByUp(userName, Hashing.md5().newHasher()
                .putString(passwd, Charsets.UTF_8).hash().toString());

        T0001ResponseBean trb = new T0001ResponseBean();
        if (null == userOper){
            throw new IllegalArgumentException("用户不存在");
        }
        if(SysConst.OPER_STATUS_LOCKED.equals(userOper.getStatus())){
            throw new IllegalAccessException("账号被锁定");
        }
        trb.setRoles(userOper.getRoles());
        UserDoctorInfo doctor = null;
        switch(userOper.getRoles()) {
            case SysConst.ROLE_DOCTOR:
                doctor = p0013Service.findOne(userOper.getOperId());
                if (null == doctor) {
                    LOG.warn("医生表中不存在登录信息表中的医生信息: id={}", userOper.getOperId());
                } else {
                    trb.setDoctorId(userOper.getOperId());
                    trb.setDoctorPhoto(doctor.getDoctorHeadIcon());
                }
                break;
            default:
                // TODO leave for other case
        }

        trb.setTicket(UserCache.getInstance().save(userOper.getAccount()));
        String casuuid = UUID.randomUUID().toString().replace("-", "");
        trb.setCasUuid(casuuid);

        // 在线表维护
        if (null != doctor) {
            List<SysOnlineList> onlineLists = onlineDao.getListByUserId(doctor.getDoctorId());
            if (CollectionUtils.isEmpty(onlineLists)) {
                onlineDao.add(doctor.getDoctorId(), appType.toLowerCase().endsWith("app") ? SysConst.DEV_TYPE_APP : SysConst.DEV_TYPE_TV);
            } else {
                SysOnlineList onlineOne = onlineLists.get(0);
                SysOnlineListHistory onlineHistory = new SysOnlineListHistory();
                BeanUtils.copyProperties(onlineOne, onlineHistory);
                // 移到历史表
                sysOnlineListHistoryDao.save(onlineHistory);
                // 删除后新增
                onlineDao.delete(onlineOne);
                onlineDao.add(doctor.getDoctorId(), appType.toLowerCase().endsWith("app") ? SysConst.DEV_TYPE_APP : SysConst.DEV_TYPE_TV);
            }
        }
        return trb;
    }
}
