package com.dkt.webhospital;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import com.dkt.common.SysException;
import com.google.gson.Gson;
import com.platform.tool.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
    public CommonResponse<List<WebHospitalBean<DepartmentBean<WebDoctorInfoBean>>>> getWebHospital(HttpServletRequest request){
        CommonResponse<List<WebHospitalBean<DepartmentBean<WebDoctorInfoBean>>>> web=new CommonResponse<>();

        log.debug("开始获取机构医生信息");

        try {
            List<WebHospitalBean> webHospital=webHospitalService.getListWebHospitalBean();

            List list=new ArrayList();
            if (webHospital!=null&&webHospital.size()>0) {
                for (WebHospitalBean hospial : webHospital) {

                    String logolcon = hospial.getLogolcon();
                    String logoURL = SysConst.PREFIX_URL+logolcon;
                    hospial.setLogolcon(logoURL);
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
