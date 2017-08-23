package com.dkt.login.TV;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import com.dkt.doctor.DoctorDao;
import com.dkt.entity.UserDoctorInfo;
import com.dkt.login.T0001Controller;
import com.dkt.login.T0001RequestBean;
import com.dkt.login.T0001ResponseBean;
import com.dkt.login.T0001Service;
import com.platform.tool.JsonTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 馒头花卷儿
 * @Description:TV端登陆
 * @create 2017-08-20
 */
@RestController
@Scope("session")
public class TVLoginController {

    private static final Logger log = LoggerFactory.getLogger(TVLoginController.class);

    @Autowired
    private T0001Service service;
    @Autowired
    private DoctorDao doctorDao;

    @RequestMapping(value = "external/loginTVByPwd", method = RequestMethod.POST)
    public CommonResponse<TV0001ResponseBean<TV0001DoctorBean>> demo(@RequestBody T0001RequestBean request) {

        log.debug(JsonTool.toJsonStr(request,null));
        CommonResponse<TV0001ResponseBean<TV0001DoctorBean>> result = new CommonResponse();
        TV0001ResponseBean tvResult=new TV0001ResponseBean();
        T0001ResponseBean response = new T0001ResponseBean();
        try {
            if (null == request || StringUtils.isEmpty(request.getUserName())
                    || StringUtils.isEmpty(request.getPassword())) {
                throw new Exception("用户名和密码不可为空");
            }
            response = service.findByUp(request.getUserName(), request.getPassword(), request.getAppType());
            UserDoctorInfo info = doctorDao.get(UserDoctorInfo.class, response.getDoctorId());


            BeanUtils.copyProperties(response, tvResult);

            TV0001DoctorBean bean=new TV0001DoctorBean();
            BeanUtils.copyProperties(info, bean);

            tvResult.setDoctor(bean);

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
        result.setResult(tvResult);
        return result;

    }
}
