package com.dkt.user;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import com.dkt.common.SysException;
import com.platform.tool.JsonTool;
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
 * @Description:用户
 * @create 2017-09-14
 */
@RestController
@Scope("session")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "external/getUserInfoByCommunityId")
    public CommonResponse<List<UserResponseU0001>> getUserInfoByCommunityId(@RequestBody UserRequestU0001 request){
        log.debug(request.getCommunityId().toString());
        CommonResponse<List<UserResponseU0001>> wr=new CommonResponse();

        try {
            Integer communityId = request.getCommunityId();
            List<UserResponseU0001> userInfoList=null;
            if (null!=communityId&&!"".equals(communityId)){
                log.debug("参数不为空，开始查询用户信息");
                 userInfoList = userService.getUserInfoByCommunityId(communityId);
            }
            wr.setResult(userInfoList);
        } catch (SysException e) {
            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorCode(e.getCode());
            wr.setErrorMsg(e.getError());
        }
        return wr;
    }

}
