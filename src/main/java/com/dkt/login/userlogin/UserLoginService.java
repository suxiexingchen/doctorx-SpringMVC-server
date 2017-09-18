package com.dkt.login.userlogin;

import com.dkt.entity.UserInfo;

import java.io.IOException;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-18
 */
public interface UserLoginService {

    public UserInfo findByPw(String userName, String password)throws IllegalAccessException;

    public String createMeeting(String VideoType,UserInfo info) throws IOException;
}
