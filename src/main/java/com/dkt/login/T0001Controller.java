package com.dkt.login;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import com.platform.tool.JsonTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by litai on 2017/6/14.
 */
@RestController
@Scope("session")
public class T0001Controller {
    private static final Logger log = LoggerFactory.getLogger(T0001Controller.class);

    @Autowired
    private T0001Service service;

    @RequestMapping(value = "external/loginByPwd", method = RequestMethod.POST)
    public CommonResponse<T0001ResponseBean> demo(@RequestBody T0001RequestBean request) {
        log.debug(JsonTool.toJsonStr(request,null));
        CommonResponse<T0001ResponseBean> result = new CommonResponse();
        T0001ResponseBean response = new T0001ResponseBean();
        try {
            if (null == request || StringUtils.isEmpty(request.getUserName())
                    || StringUtils.isEmpty(request.getPassword())) {
                throw new Exception("用户名和密码不可为空");
            }
            response = service.findByUp(request.getUserName(), request.getPassword(), request.getAppType());
            result.setSuccessMsg(SysConst.STATUS_SUCCESS);
        } catch(IllegalArgumentException e1) {
            log.error(e1.getMessage());
            result.setErrorMsg(e1.getMessage());
            result.setErrorCode(SysConst.LOGIN_ERROR_UNEXIST);
        } catch(IllegalAccessException e2) {
            log.error(e2.getMessage());
            result.setErrorMsg(e2.getMessage());
            result.setErrorCode(SysConst.LOGIN_ERROR_LOCKED_FOREVER);
        } catch(Exception e) {
            log.error(e.getMessage());
            result.setErrorMsg(e.getMessage());
            result.setErrorCode(SysConst.LOGIN_ERROR_UNKNOW);
        }
        if (!StringUtils.isEmpty(result.getErrorCode())) {
            result.setStatus(SysConst.STATUS_ERROR);
        }
        result.setResult(response);
        return result;

    }
}
