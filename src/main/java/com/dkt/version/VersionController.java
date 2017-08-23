package com.dkt.version;

import com.dkt.common.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @author 馒头花卷儿
 * @Description:版本控制
 * @create 2017-08-21
 */
@RestController
@Scope("session")
public class VersionController {

    private static final Logger log = LoggerFactory.getLogger(VersionController.class);

    @Autowired
    private VersionService versionService;
    //版本升级提示
    @RequestMapping("/external/appUpGrade")
    public CommonResponse<VersionBeanV0001> appUpGrade(@RequestBody RequestBeanV0001 request){
        log.debug("开始是否版本升级");
        VersionBeanV0001 versionBeanV0001 = versionService.upGrade(request);
        CommonResponse<VersionBeanV0001> commonResponse=new CommonResponse<>();

        commonResponse.setResult(versionBeanV0001);

        return commonResponse;
    }


}
