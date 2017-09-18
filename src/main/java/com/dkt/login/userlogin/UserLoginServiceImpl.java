package com.dkt.login.userlogin;

import com.dkt.common.SysConst;
import com.dkt.entity.UserInfo;
import com.dkt.entity.UserOper;
import com.dkt.functionTools.xyclient.XYClientTools;
import com.dkt.login.T0001Dao;
import com.dkt.user.UserDao;
import com.dkt.user.UserService;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.xylink.model.SdkMeeting;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.io.IOException;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-18
 */
@Service
public class UserLoginServiceImpl implements UserLoginService{

    private static final Logger log = LoggerFactory.getLogger(UserLoginServiceImpl.class);
    @Autowired
    private T0001Dao t0001Dao;
    @Autowired
    private UserDao userDao;

    public UserInfo findByPw(String userName, String password) throws IllegalAccessException {
        UserInfo userInfo=null;
        UserOper userOper = t0001Dao.findByUp(userName, Hashing.md5().newHasher()
                .putString(password, Charsets.UTF_8).hash().toString());

        if (null == userOper){
            throw new IllegalArgumentException("用户不存在");
        }
        if(SysConst.OPER_STATUS_LOCKED.equals(userOper.getStatus())){
            throw new IllegalAccessException("账号被锁定");
        }

        if (SysConst.ROLE_USER.equals(userOper.getRoles())){

             userInfo = userDao.get(UserInfo.class, userOper.getOperId());
        }

        return userInfo;
    }


    @Transactional
    public String createMeeting(String VideoType, UserInfo info) throws IOException {
        String tvn = null;
        if (null != VideoType && VideoType.equals(SysConst.VIDEOTYPE_XY)) {

            if (StringUtils.isBlank(info.getTvn())) {

                SdkMeeting sdkMeeting = XYClientTools.createMeeting(info.getName());
                if (null!=sdkMeeting){
                    info.setTvn(sdkMeeting.getMeetingNumber());
                    userDao.update(info);
                    Assert.notNull(info.getTvn(), "会议室创建失败，请重新登陆");
                    tvn = sdkMeeting.getMeetingNumber();
                }

            }else{
                tvn=info.getTvn();
            }

        }

        return tvn;
    }
}
