package com.dkt.functionTools.JPush;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-31
 */
@RestController
@Scope("session")
public class JPushController {
    private static final Logger log = LoggerFactory.getLogger(JPushController.class);

    @Autowired
    private JpushService jpushService;

    @RequestMapping("/external/sendToAlias")
    public CommonResponse<Integer> sendToAlias(@RequestBody JPushRequestBeanP0001 request) {
        log.debug("开始进行信息推送");
        CommonResponse<Integer> wr = new CommonResponse<Integer>();
        JPushBeanP0002 bean = jpushService.lookWork(request);
        Integer status = jpushService.sendToAlias(bean);
        wr.setStatus(SysConst.STATUS_SUCCESS);
        //0推送失败，1推送成功
        wr.setResult(status);
        return wr;
    }


}
