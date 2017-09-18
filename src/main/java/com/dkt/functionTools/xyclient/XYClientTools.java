package com.dkt.functionTools.xyclient;

import com.dkt.common.SysConst;
import com.xylink.model.SdkMeeting;
import com.xylink.model.SdkMeetingReq;
import com.xylink.sdk.conferenceControl.CreateMeetingApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-18
 */
public class XYClientTools {

    private static final Logger log = LoggerFactory.getLogger(XYClientTools.class);

    /**
     * 开启小鱼会议
     * @param meetingName
     * @return
     */
    public static SdkMeeting createMeeting(String meetingName) throws IOException {

        SdkMeeting sdkMeeting = null;

        log.debug("开始创建会议室");
        SdkMeetingReq sdkMeetingReq = new SdkMeetingReq();
        sdkMeetingReq.setMeetingName(meetingName);
        CreateMeetingApi createMeetingApi = new CreateMeetingApi();
        sdkMeeting = createMeetingApi.createMeeting(SysConst.XY_ENTERPRISELD, SysConst.XY_TOKEN, sdkMeetingReq);
        log.info("会议室创建成功" + sdkMeeting.getMeetingNumber());

        return sdkMeeting;
    }

}
