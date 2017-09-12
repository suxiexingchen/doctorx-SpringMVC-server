package com.dkt.login.TV;

import com.dkt.entity.UserDoctorInfo;

import java.io.IOException;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-10
 */
public interface TVLoginService {

    public String createMeeting(String VideoType, UserDoctorInfo info) throws IOException;
}
