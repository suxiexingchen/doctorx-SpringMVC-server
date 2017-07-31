package com.dkt.online;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import com.dkt.common.SysException;
import com.dkt.ehcache.OnlineCacheSpring;
import com.dkt.friends.FriendsController;
import com.platform.tool.JsonTool;
import com.platform.tool.Tools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by litai on 2017/6/21.
 */
@RestController
@Scope("session")
public class OnlineController {

    private static final Logger log = LoggerFactory.getLogger(OnlineController.class);

    @Autowired
    private OnlineService service;

    @RequestMapping("/external/tlm/test")
    public CommonResponse<HashMap> test(@RequestBody RequestBeanP10019 request) {

        CommonResponse<HashMap> wr = new CommonResponse<HashMap>();
        log.debug("开始添加绑定信息");

        try {

//            OnlineCache.getInstance().save(request.getUserId(), JsonTool.toJsonStr(request, null));

            OnlineCacheSpring.getInstance().put(request.getUserId(), JsonTool.toJsonStr(request, null));


            HashMap<String, String> map = new HashMap<String, String>();
            map.put("numberValue", request.getNumberValue());
            map.put("recId", request.getRecId());
            map.put("deviceMacAddr", request.getDeviceMacAddr());

            wr.setResult(map);

        } catch (Exception e) {
            log.error("",e);
            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode("0");
            wr.setErrorMsg("添加绑定信息失败");
        }
        return wr;
    }

    @RequestMapping("/external/tlm/bindTVNum")
    public CommonResponse<HashMap> bindTVNum(@RequestBody RequestBeanP10019 request) {

        CommonResponse<HashMap> wr = new CommonResponse<HashMap>();
        log.debug("开始添加绑定信息");

        try {

            String recId = service.bindTVNum(request);

            if (StringUtils.isBlank(recId)) {
                wr.setStatus(SysConst.STATUS_ERROR);
                wr.setErrorCode("0");
                wr.setErrorMsg("用户不在线");

                return wr;

            }
            request.setRecId(recId);
            request.setLastHeartBeat(Tools.getCurUnixTime());

            OnlineCacheSpring.getInstance().put(request.getUserId(), JsonTool.toJsonStr(request, null));
           // OnlineCache.getInstance().save(request.getUserId(), JsonTool.toJsonStr(request, null));
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("numberValue", request.getNumberValue());
            map.put("recId", request.getRecId());
            map.put("deviceMacAddr", request.getDeviceMacAddr());

            wr.setResult(map);

        } catch (Exception e) {

            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode("0");
            wr.setErrorMsg("添加绑定信息失败");
        }
        return wr;
    }

    @RequestMapping("/external/tlm/obtainNum")
    public CommonResponse<HashMap> obtainNum(@RequestBody RequestBeanP10019 request) {

        CommonResponse<HashMap> wr = new CommonResponse<HashMap>();
        log.debug("开始获取华为账号信息");

        try {

            wr.setResult(service.obtainNum(request));

        } catch (Exception e) {

            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode("0");
            wr.setErrorMsg("获取华为账号失败：" + e.getMessage());
        }
        return wr;
    }

    @RequestMapping("/external/tlm/unbindNum")
    public CommonResponse<HashMap> unbindNum(@RequestBody RequestBeanP10019 request) {

        CommonResponse<HashMap> wr = new CommonResponse<HashMap>();
        log.debug("开始释放华为账号信息");

        try {

            wr.setResult(service.unbindNum(request));

        } catch (Exception e) {

            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode("0");
            wr.setErrorMsg("释放华为账号失败：" + e.getMessage());
        }
        return wr;
    }

    @RequestMapping("/external/tlm/numHeartbeat")
    public CommonResponse<HashMap> numHeartbeat(@RequestBody RequestBeanP10019 request) {

        CommonResponse<HashMap> wr = new CommonResponse<HashMap>();
        log.debug("收到心跳信息");

        try {

            Boolean flag = OnlineCacheSpring.getInstance().isCache(request.getUserId());

            if (!flag) {
                wr.setStatus(SysConst.STATUS_ERROR);
                wr.setErrorCode("0");
                wr.setErrorMsg("没有缓存信息");
                return wr;
            }

            // 读取缓存
//            String json = OnlineCache.getInstance().get(request.getUserId());

//            if (StringUtils.isBlank(json)) {
//                wr.setStatus(SysConst.STATUS_ERROR);
//                wr.setErrorCode("0");
//                wr.setErrorMsg("没有缓存信息");
//                return wr;
//            }

//            RequestBeanP10019 cache = JsonTool.readValue(json, RequestBeanP10019.class);
//
//            cache.setLastHeartBeat(Tools.getCurUnixTime());
//            OnlineCache.getInstance().save(request.getUserId(), JsonTool.toJsonStr(cache, null));


        } catch (Exception e) {

            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode("0");
            wr.setErrorMsg("更新心跳信息失败：" + e.getMessage());
        }
        return wr;
    }
}
