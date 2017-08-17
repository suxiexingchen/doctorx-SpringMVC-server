package com.dkt.webhospital;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import com.dkt.common.SysException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 网络医院
 * @author 馒头花卷儿
 * @create 2017-08-16
 */
@RestController
@Scope("session")
public class HospitalController {

    @Autowired
    private WebHospitalService webHospitalService;

    private static final Logger log = LoggerFactory.getLogger(HospitalController.class);

    @RequestMapping("/external/tlm/getWebDoctor")
    public CommonResponse<List<WebHospitalBean<DepartmentBean<WebDoctorInfoBean>>>> getWebHospital(){
        CommonResponse<List<WebHospitalBean<DepartmentBean<WebDoctorInfoBean>>>> web=new CommonResponse<>();

        log.debug("开始获取机构医生信息");

        try {
            List<WebHospitalBean> webHospital=webHospitalService.getListWebHospitalBean();
            List list=new ArrayList();
            if (list!=null&&list.size()>0) {
                for (WebHospitalBean hospial : webHospital) {
                    list.add(hospial);
                }
                web.setResult(list);
            }
        } catch (SysException e) {
            web.setStatus(SysConst.STATUS_ERROR);
            web.setErrorCode(e.getCode());
            web.setErrorMsg(e.getError());
            log.debug("获取网络医院失败");
        }

        return web;

    }


}
