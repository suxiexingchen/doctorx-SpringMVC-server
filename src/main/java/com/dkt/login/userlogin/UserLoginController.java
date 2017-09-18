package com.dkt.login.userlogin;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import com.dkt.entity.UserInfo;
import com.dkt.functionTools.xyclient.XYClientTools;
import com.platform.tool.JsonTool;
import net.bytebuddy.implementation.bytecode.Throw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 馒头花卷儿
 * @Description:用户登陆
 * @create 2017-09-18
 */
@RestController
@Scope("session")
public class UserLoginController {

    private static final Logger log = LoggerFactory.getLogger(UserLoginController.class);
    @Autowired
    private UserLoginService service;

    @RequestMapping(value = "/external/userLogin", method = RequestMethod.POST)
    public CommonResponse<UserBeanResponseR0001> userLogin(@RequestBody UserLoginRequestBean request) {

        log.debug(JsonTool.toJsonStr(request, null));
        CommonResponse<UserBeanResponseR0001> result = new CommonResponse();
        UserBeanResponseR0001 response = new UserBeanResponseR0001();
        try {
            if (null == request || StringUtils.isEmpty(request.getUserName())
                    || StringUtils.isEmpty(request.getPassword())) {
                throw new Exception("用户名和密码不可为空");
            }
            UserInfo userInfo = service.findByPw(request.getUserName(), request.getPassword());
            if (null != userInfo) {
                //创建会议室
                String meetingNumber = service.createMeeting(request.getVideoType(), userInfo);
                if (null != meetingNumber) {
                    userInfo.setTvn(meetingNumber);
                    BeanUtils.copyProperties(userInfo, response);
                }
            }else {
                throw new IllegalArgumentException("用户不存在");
            }

            result.setResult(response);

            result.setSuccessMsg(SysConst.STATUS_SUCCESS);
        } catch (IllegalArgumentException e1) {
            log.error(e1.getMessage());
            result.setErrorMsg(e1.getMessage());
            result.setErrorCode(SysConst.LOGIN_ERROR_UNEXIST);
        } catch (IllegalAccessException e2) {
            log.error(e2.getMessage());
            result.setErrorMsg(e2.getMessage());
            result.setErrorCode(SysConst.LOGIN_ERROR_LOCKED_FOREVER);
        } catch (Exception e) {
            log.error(e.getMessage());
            result.setErrorMsg(e.getMessage());
            result.setErrorCode(SysConst.LOGIN_ERROR_UNKNOW);
        }

        return result;
    }
}
