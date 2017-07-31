package com.dkt.consultation;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import com.dkt.consultation.bean.p01.Request01;
import com.dkt.consultation.bean.p01.Response01;
import com.dkt.consultation.bean.p02.Request02;
import com.dkt.consultation.bean.p02.Response02;
import com.dkt.consultation.bean.p03.Request03;
import com.dkt.consultation.bean.p03.Response03;
import com.dkt.consultation.bean.p04.Request04;
import com.dkt.consultation.bean.p04.Response04;
import com.dkt.consultation.bean.p05.Request05;
import com.dkt.consultation.bean.p06.Request06;
import com.dkt.consultation.bean.p07.Request07;
import com.dkt.consultation.bean.p08.Request08;
import com.dkt.consultation.bean.p08.Response08;
import com.dkt.consultation.bean.p09.Request09;
import com.dkt.consultation.bean.p09.Response09;
import com.dkt.consultation.bean.p10.Request10;
import com.dkt.consultation.bean.p11.Request11;
import com.dkt.consultation.service.BizConService;
import io.swagger.annotations.*;
import org.omg.CORBA.Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by GD on 2017/6/17.
 */
@Api(value = "会诊接口")
@RestController
@Scope("session")
public class BizConController {
    private static final Logger LOG = LoggerFactory.getLogger(BizConController.class);

    @Autowired
    private BizConService bizConService;

    /**
     * 01-提交预约申请.
     *
     * @param request
     * @return
     */
    @ApiOperation(httpMethod = "POST", produces = "application/json", value = "01-提交预约申请", notes = "用于发起会诊预约时登记患者的基本信息和会诊请求描述")
    @PostMapping("external/tlm/applyConsultation")
    public CommonResponse<Response01> applyConsultation(@ApiParam(name="r01") @RequestBody Request01 request) {
        CommonResponse<Response01> result = new CommonResponse();
        Response01 response = new Response01();
        try {
            Assert.notNull(request, "请求协议错误");
            response = bizConService.applyConsultation(request);
            result.setSuccessMsg(SysConst.STATUS_SUCCESS);
        } catch(Exception e) {
            LOG.error(e.getMessage());
            result.setStatus(SysConst.STATUS_ERROR);
            result.setErrorMsg(e.getMessage());
        }
        result.setResult(response);
        return result;
    }

    /**
     * 02-预约提醒.
     *
     * <p>
     *     暂时没有区分专家和普通医生，直接提醒待确认。
     * </p>
     *
     * @param request
     * @return
     */
    @PostMapping("external/tlm/getNewNotice")
    public CommonResponse<Response02> getNewNotice(@RequestBody Request02 request) {
        CommonResponse<Response02> result = new CommonResponse();
        Response02 rb = new Response02();
        try {
            Assert.notNull(request, "post数据转换异常");
            Assert.notNull(request.getUserId(), "userId不可为空");
            Assert.notNull(request.getClinicId(), "clinicId不可为空");
            rb = bizConService.consultationCount(request);
            result.setSuccessMsg(SysConst.STATUS_SUCCESS);
        } catch(Exception e) {
            LOG.error(e.getMessage());
            result.setStatus(SysConst.STATUS_ERROR);
            result.setErrorMsg(e.getMessage());
            // TODO 异常信息使用定义好的异常代码
        }
        result.setResult(rb);
        return result;
    }

    /**
     * 03-获取预约列表.
     *
     * @param request
     * @return
     */
    @PostMapping("external/tlm/listNews")
    public CommonResponse<Response03> listNews(@RequestBody Request03 request) {
        CommonResponse<Response03> result = new CommonResponse();
        Response03 response = new Response03();
        try {
            Assert.notNull(request, "post数据转换异常");
            Assert.notNull(request.getUserId(), "userId不可为空");
            Assert.notNull(request.getStatus(), "status不可为空");
            response = bizConService.listNews(request);
            result.setSuccessMsg(SysConst.STATUS_SUCCESS);
        } catch(Exception e) {
            LOG.error(e.getMessage());
            result.setStatus(SysConst.STATUS_ERROR);
            result.setErrorMsg(e.getMessage());
        }
        result.setResult(response);
        return result;
    }

    /**
     * 04-获取预约详情, 获取会诊详情.
     *
     * <p>
     *     暂时只验证会诊信息主键，是否需要校验，只有本人才能看到本人提交的会诊。
     *     目前不校验，可以方便的支持预约和会诊。
     *
     *     和接口03相比较，只差图片，有必要吗？
     * </p>
     *
     * @param request
     * @return
     */
    @PostMapping("external/tlm/getConsultationDetail")
    public CommonResponse<Response04> getConsultationDetail(@RequestBody Request04 request) {
        CommonResponse<Response04> result = new CommonResponse();
        Response04 response = new Response04();
        try {
            Assert.notNull(request, "post数据转换异常");
            Assert.notNull(request.getConsultationId(), "consultationId不可为空");
            response = bizConService.getDetail(request);
            result.setSuccessMsg(SysConst.STATUS_SUCCESS);
        } catch(Exception e) {
            LOG.error(e.getMessage());
            result.setStatus(SysConst.STATUS_ERROR);
            result.setErrorMsg(e.getMessage());
        }
        result.setResult(response);
        return result;
    }

    /**
     * 05-开始通话时设置通话状态.
     *
     * <p>
     *     暂时只根据会诊ID来设置，没限制用户。是否有必要。
     * </p>
     *
     * @param request
     * @return
     */
    @PostMapping("external/tlm/startVedio")
    public CommonResponse<Object> startVedio(@RequestBody Request05 request) {
        CommonResponse<Object> result = new CommonResponse();
        try {
            Assert.notNull(request, "post数据转换异常");
            Assert.notNull(request.getConsultationId(), "consultationId不可为空");
            bizConService.startVedio(request);
            result.setSuccessMsg(SysConst.STATUS_SUCCESS);
        } catch(Exception e) {
            LOG.error(e.getMessage());
            result.setStatus(SysConst.STATUS_ERROR);
            result.setErrorMsg(e.getMessage());
        }
        result.setResult(null);
        return result;
    }

    /**
     * 06-结束通话时设置通话状态.
     *
     * <p>
     *     暂时只根据会诊ID来设置，没限制用户。是否有必要。
     * </p>
     *
     * @param request
     * @return
     */
    @PostMapping("external/tlm/finishVedio")
    public CommonResponse<Object> finishVedio(@RequestBody Request06 request) {
        CommonResponse<Object> result = new CommonResponse();
        try {
            Assert.notNull(request, "post数据转换异常");
            Assert.notNull(request.getConsultationId(), "consultationId不可为空");
            bizConService.finishVedio(request);
            result.setSuccessMsg(SysConst.STATUS_SUCCESS);
        } catch(Exception e) {
            LOG.error(e.getMessage());
            result.setStatus(SysConst.STATUS_ERROR);
            result.setErrorMsg(e.getMessage());
        }
        result.setResult(null);
        return result;
    }

    /**
     * 07-录入会诊意见.
     *
     * @param request
     * @return
     */
    @PostMapping("external/tlm/feedbackOpinion")
    public CommonResponse<Object> feedbackOpinion(@RequestBody Request07 request) {
        CommonResponse<Object> result = new CommonResponse();
        try {
            Assert.notNull(request, "post数据转换异常");
            Assert.notNull(request.getConsultationId(), "consultationId不可为空");
            Assert.notNull(request.getConsultationDoctorSuggest(), "consultationDoctorSuggest不可为空");
            bizConService.feedbackOpinion(request);
            result.setSuccessMsg(SysConst.STATUS_SUCCESS);
        } catch(Exception e) {
            LOG.error(e.getMessage());
            result.setStatus(SysConst.STATUS_ERROR);
            result.setErrorMsg(e.getMessage());
        }
        result.setResult(null);
        return result;
    }

    /**
     * 08-会诊结束提醒.
     *
     * @param request
     * @return
     */
    @PostMapping("external/tlm/getFinishedNotice")
    public CommonResponse<Response08> getFinishedNotice(@RequestBody Request08 request) {
        CommonResponse<Response08> result = new CommonResponse();
        Response08 response = new Response08();
        try {
            Assert.notNull(request, "post数据转换异常");
            Assert.notNull(request.getUserId(), "userId不可为空");
            response = bizConService.getFinishedNotice(request);
            result.setSuccessMsg(SysConst.STATUS_SUCCESS);
        } catch(Exception e) {
            LOG.error(e.getMessage());
            result.setStatus(SysConst.STATUS_ERROR);
            result.setErrorMsg(e.getMessage());
        }
        result.setResult(response);
        return result;
    }

    /**
     * 09-获取会诊记录列表.
     *
     * <p>
     *     功能与03接口重叠
     * </p>
     *
     * @param request
     * @return
     */
    @PostMapping("external/tlm/listFinished")
    public CommonResponse<Response09> listFinished(@RequestBody Request09 request) {
        CommonResponse<Response09> result = new CommonResponse();
        Response09 response = new Response09();
        try {
            Assert.notNull(request, "post数据转换异常");
            Assert.notNull(request.getUserId(), "userId不可为空");
            //Assert.notNull(request.getStatus(), "status不可为空");
            response = bizConService.listFinished(request);
            result.setSuccessMsg(SysConst.STATUS_SUCCESS);
        } catch(Exception e) {
            LOG.error(e.getMessage());
            result.setStatus(SysConst.STATUS_ERROR);
            result.setErrorMsg(e.getMessage());
        }
        result.setResult(response);
        return result;
    }

    /**
     * 10-确认会诊预约时间.
     *
     * <p>
     *     现在是否区分专家和医生
     *     接口地址自己定的，需要和终端对。
     * </p>
     *
     * @param request
     * @return
     */
    @PostMapping("external/tlm/confirmDTime")
    public CommonResponse<Object> confirmDTime(@RequestBody Request10 request) {
        CommonResponse<Object> result = new CommonResponse();
        try {
            Assert.notNull(request, "post数据转换异常");
            Assert.notNull(request.getConsultationId(), "consultationId不可为空");
            Assert.notNull(request.getApptTime(), "apptTime不可为空");
            bizConService.updateApptTime(request);
            result.setSuccessMsg(SysConst.STATUS_SUCCESS);
        } catch(Exception e) {
            LOG.error(e.getMessage());
            result.setStatus(SysConst.STATUS_ERROR);
            result.setErrorMsg(e.getMessage());
        }
        result.setResult(null);
        return result;
    }

    @PostMapping("external/tlm/updateConsultationStatus")
    public CommonResponse<Object> updateBizConStatus(@RequestBody Request11 request){
        CommonResponse<Object> result = new CommonResponse();
        try {
            Assert.notNull(request, "post数据转换异常");
            Assert.notNull(request.getConsultationId(), "consultationId不可为空");
            Assert.notNull(request.getStatus(), "status不可为空");
            bizConService.updateStatus(request);
            result.setSuccessMsg(SysConst.STATUS_SUCCESS);
        } catch (Exception e){
            LOG.error(e.getMessage());
            result.setStatus(SysConst.STATUS_ERROR);
            result.setErrorMsg(e.getMessage());
        }
        result.setResult(null);
        return result;
    }
}
