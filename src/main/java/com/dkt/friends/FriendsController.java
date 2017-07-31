package com.dkt.friends;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import com.dkt.common.SysException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by litai on 2017/6/18.
 */
@RestController
@Scope("session")
public class FriendsController {

    private static final Logger log = LoggerFactory.getLogger(FriendsController.class);

    @Autowired
    private ApplyService applyService;

    @RequestMapping("/external/tlm/addContacts")
    public CommonResponse<String> getListUser(@RequestBody RequestBeanP10014 request) {

        CommonResponse<String> wr = new CommonResponse<String>();
        log.debug("开始添加好友申请信息");
        try {

            applyService.addApply(request);

        } catch (SysException e) {

            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode(e.getCode());
            wr.setErrorMsg(e.getError());
        }
        return wr;
    }

    @RequestMapping("/external/tlm/getContactsRequestPageList")
    public CommonResponse<ResponseBeanP10015> getContactsRequestPageList(@RequestBody RequestBeanP10015 request) {

        CommonResponse<ResponseBeanP10015> wr = new CommonResponse<ResponseBeanP10015>();
        log.debug("开始查询好友申请信息");
        try {

            ResponseBeanP10015 bean = applyService.getList(request);
            wr.setResult(bean);

        } catch (SysException e) {

            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode(e.getCode());
            wr.setErrorMsg(e.getError());
        }
        return wr;
    }

    @RequestMapping("/external/tlm/confirmContactsRequest")
    public CommonResponse<String> confirmContactsRequest(@RequestBody RequestBeanP10016 request) {

        CommonResponse<String> wr = new CommonResponse<String>();
        log.debug("开始更新好友申请信息");
        try {

            applyService.updateApply(request);

        } catch (SysException e) {

            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode(e.getCode());
            wr.setErrorMsg(e.getError());
        } catch (Exception e) {

            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode("0");
            wr.setErrorMsg("更新失败");
        }
        return wr;
    }

    @RequestMapping("/external/tlm/getContactsInfo")
    public CommonResponse<HashMap> getContactsInfo(@RequestBody RequestBeanP10016 request) {

        CommonResponse<HashMap> wr = new CommonResponse<>();
        log.debug("开始查询好友申请详情信息");
        try {

            wr.setResult(applyService.getContactsInfo(request));

        } catch (SysException e) {

            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode(e.getCode());
            wr.setErrorMsg(e.getError());
        }
        return wr;
    }

    @RequestMapping("/external/tlm/getContactsList")
    public CommonResponse<HashMap> getContactsList(@RequestBody RequestBeanP10016 request) {

        CommonResponse<HashMap> wr = new CommonResponse<>();
        log.debug("开始查询好友列表详情信息");
        try {

            wr.setResult(applyService.getContactsList(request));

        } catch (SysException e) {

            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode(e.getCode());
            wr.setErrorMsg(e.getError());
        }
        return wr;
    }
}
