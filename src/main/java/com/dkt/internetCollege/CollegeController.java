package com.dkt.internetCollege;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:学院
 * @create 2017-09-09
 */
@RestController
@Scope("session")
public class CollegeController {

    private static final Logger log = LoggerFactory.getLogger(CollegeController.class);
    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/external/getInternetCollege")
    public CommonResponse<List<ProgramBeanP0001<TVActBeanP0001>>> getInternateCollege(@RequestBody CollegeRequestP0001 request){


        if (null==request.getProgramType()||"".equals(request.getProgramType())){
            request.setProgramType(SysConst.programType_INTERNETCollege);
            log.debug("获取网络学院");
        }

        CommonResponse<List<ProgramBeanP0001<TVActBeanP0001>>> wr = null;
        try {
            log.debug("开始获取栏目，节目");
            List<ProgramBeanP0001<TVActBeanP0001>> programAndAct = collegeService.getProgramAndAct(request.getProgramType());

            wr = new CommonResponse<>();
            wr.setResult(programAndAct);
        } catch (Exception e) {
            e.printStackTrace();
            wr.setStatus(SysConst.STATUS_ERROR);

        }
        return wr;
    }

}