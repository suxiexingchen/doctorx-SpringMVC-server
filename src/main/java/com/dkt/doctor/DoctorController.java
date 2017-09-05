package com.dkt.doctor;

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

import java.util.List;

/**
 * Created by litai on 2017/6/17.
 */
@RestController
@Scope("session")
public class DoctorController {

    private static final Logger log = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    private DoctorService service;

    @RequestMapping("/external/tlm/getDoctors")
    public CommonResponse<DoctorListResult<DoctorListBeanP10012>> getListUser(@RequestBody RequestBeanP10012 request) {

        CommonResponse<DoctorListResult<DoctorListBeanP10012>> wr = new CommonResponse<DoctorListResult<DoctorListBeanP10012>>();
        log.debug("开始获取机构医生信息");
         try {
            DoctorListResult dlr = new DoctorListResult();
            List<DoctorListBeanP10012> list = service.getList(request);
            dlr.setDoctorList(list);
            wr.setResult(dlr);
        } catch (SysException e) {
            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode(e.getCode());
            wr.setErrorMsg(e.getError());
        }
        return wr;
    }

    @RequestMapping("/external/ticket/getDoctorInfo")
    public CommonResponse<DoctorBeanP10009> getListUser(@RequestBody RequestBeanP10009 request){

        CommonResponse<DoctorBeanP10009> wr = new CommonResponse<>();
        String ticket = request.getTicket();
        log.debug("开始获取登陆医生详情");
        try{
            DoctorBeanP10009 db09 = service.getDoctorDetail(ticket);
            wr.setResult(db09);
        }catch (SysException e){
            e.printStackTrace();
            wr.setStatus(SysConst.STATUS_SUCCESS);
            wr.setErrorMsg(e.getError());
            wr.setErrorCode(e.getCode());
        }
        return wr;
    }

    @RequestMapping("/external/tlm/getDoctorInfo")
    public CommonResponse<DoctorBeanP10013> getListUser(@RequestBody RequestBeanP10013 request) {

        CommonResponse<DoctorBeanP10013> wr = new CommonResponse<DoctorBeanP10013>();
        log.debug("开始获取机构医生详细信息");
        try {

            DoctorBeanP10013 db = service.getDoctorDetail(request);
            wr.setResult(db);

        } catch (SysException e) {
            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode(e.getCode());
            wr.setErrorMsg(e.getError());
        }
        return wr;
    }

    @RequestMapping("/external/setOnlineStatus")
    public CommonResponse setOnlineStatus(@RequestBody RequestBeanP10014 request){
         CommonResponse wr=new CommonResponse();
        log.debug("设置医生在线状态");
        try {
            service.setOnlineStatus(request);
        } catch (SysException e) {
            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode(e.getCode());
            wr.setErrorMsg(e.getError());
        }

        return wr;
    }

    //设置医生视频通话号码
    @RequestMapping("/external/setTVN")
    public CommonResponse setTVN(@RequestBody RequestBeanP10015 request){
        CommonResponse wr=new CommonResponse();
        try {
            service.setTVN(request);
        } catch (SysException e) {
            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode(e.getCode());
            wr.setErrorMsg(e.getError());
        }
        return wr;
    }
}
