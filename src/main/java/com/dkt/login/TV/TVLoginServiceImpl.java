package com.dkt.login.TV;

import com.dkt.common.SysConst;
import com.dkt.doctor.DoctorDao;
import com.dkt.entity.UserDoctorInfo;
import com.xylink.model.SdkMeeting;
import com.xylink.model.SdkMeetingReq;
import com.xylink.sdk.conferenceControl.CreateMeetingApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-10
 */
@Service
public class TVLoginServiceImpl implements TVLoginService{

    private static final Logger log = LoggerFactory.getLogger(TVLoginServiceImpl.class);

    @Autowired
    private DoctorDao doctorDao;
    @Transactional
    public String createMeeting(String VideoType,UserDoctorInfo info) throws IOException {
        String tvn = null;
        if (null != VideoType && VideoType.equals(SysConst.VIDEOTYPE_XY)) {

            if (null == info.getTvn() || info.getTvn().equals("")) {
                log.debug("开始创建会议室");
                SdkMeetingReq sdkMeetingReq = new SdkMeetingReq();
                sdkMeetingReq.setMeetingName(info.getDoctorName());

                CreateMeetingApi createMeetingApi = new CreateMeetingApi();
                SdkMeeting sdkMeeting = createMeetingApi.createMeeting("f6ad6abb325d19cece25642d92b95ec5a133bc2a", "c2af3c8fcda71a10a58bc9e0f4fa860828e0e9409fd0ee5e9c4550c2253bfa22", sdkMeetingReq);
                log.info("会议室创建成功" + sdkMeeting.getMeetingNumber());

                info.setTvn(sdkMeeting.getMeetingNumber());
                doctorDao.update(info);
                Assert.notNull(info.getTvn(), "会议室创建失败，请重新登陆");
                tvn = sdkMeeting.getMeetingNumber();
            }

        } else {
            return tvn;
        }
        return tvn;
    }
}
