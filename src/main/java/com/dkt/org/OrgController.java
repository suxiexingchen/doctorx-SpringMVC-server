package com.dkt.org;

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
public class OrgController {

    private static final Logger log = LoggerFactory.getLogger(OrgController.class);

    @Autowired
    private OrgService service;


    @RequestMapping("/external/tlm/getTeleClinics")
    public CommonResponse<OrgListResult<OrgListBean>> getListUser(@RequestBody OrgRequestBean request) {

        CommonResponse<OrgListResult<OrgListBean>> wr = new CommonResponse<OrgListResult<OrgListBean>>();
        log.debug("开始获取机构信息");
        try {

            List<OrgListBean> list = service.getListPage(request);
            OrgListResult olr = new OrgListResult();
            olr.setDataSource(list);
            wr.setResult(olr);

        } catch (SysException e) {

            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode(e.getCode());
            wr.setErrorMsg(e.getError());
        }
        return wr;
    }
}
