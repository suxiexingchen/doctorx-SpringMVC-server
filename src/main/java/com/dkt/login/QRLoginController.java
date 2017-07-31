package com.dkt.login;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import com.dkt.common.UserCache;
import com.dkt.ehcache.QRcodeCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by liuhuanchao on 2017/7/11.
 */
@RestController
public class QRLoginController {

    private static final Logger log = LoggerFactory.getLogger(QRLoginController.class);

    @Autowired
    private QRLoginService service;

    @RequestMapping(value = "external/getLoginQRCode", method = RequestMethod.POST)
    public CommonResponse<QRCodeResponseBean> generateLoginQRCode(){
        log.debug("开始获取登陆二维码");
        CommonResponse<QRCodeResponseBean> wr = new CommonResponse<>();
        try{
            QRCodeResponseBean rb = new QRCodeResponseBean();
            String qrcode = UUID.randomUUID().toString().replace("-","");
            rb.setQrCodeKey(qrcode);
            wr.setResult(rb);

            QRcodeCache.getInstance().put(qrcode, QRcodeCache.getInstance().QR_STATUS_PASSIVE);

        }catch (Exception e){
            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorMsg(e.getMessage());
        }
        return wr;
    }

    @RequestMapping(value = "external/checkLoginQRCode", method = RequestMethod.POST)
    public CommonResponse<Boolean> checkQRcode(@RequestBody CheckQRRequestBean request){
        log.debug("验证qrcode有效性:" + request.getQrcode());
        CommonResponse<Boolean> wr = new CommonResponse<>();
        try{
            Boolean isCache = QRcodeCache.getInstance().isCache(request.getQrcode());
            wr.setResult(isCache);
        }catch (Exception e){
            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorMsg(e.getMessage());
        }
        return wr;
    }

    @RequestMapping(value = "external/ticket/loginByQrCode", method = RequestMethod.POST)
    public CommonResponse<String> loginByQRCode(@RequestBody QRLoginRequestBean request){
        log.debug("开始扫码登陆");
        CommonResponse<String> wr = new CommonResponse<>();
        try {
            // 验证ticket有效性
            Boolean isExist = UserCache.getInstance().check(request.getTicket());
            if(!isExist){
                wr.setStatus(SysConst.STATUS_ERROR);
                wr.setErrorMsg("loginTimeOut");
                return wr;
            }

            //验证qrcode有效性
            if(!QRcodeCache.getInstance().isCache(request.getQrCodeKey())){
                wr.setStatus(SysConst.STATUS_ERROR);
                wr.setErrorMsg("qrCodeExpired");
                return wr;
            }

            // 缓存ticket
            QRcodeCache.getInstance().put(request.getQrCodeKey(), request.getTicket());

        }catch (Exception e){
            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorMsg("error");
        }

        return wr;
    }

    @RequestMapping(value = "external/web/loginByQrCode", method = RequestMethod.POST)
    public CommonResponse<PollingResponseBean> polling(@RequestBody PollingRequestBean request){
        log.debug("轮询接口调用：qrcode=" + request.getQrcode());
        CommonResponse<PollingResponseBean> wr = new CommonResponse<>();
        try {

            //验证二维码是否过期
            if(!QRcodeCache.getInstance().isCache(request.getQrcode())){
                wr.setStatus(SysConst.STATUS_ERROR);
                wr.setErrorMsg("二维码已过期");
                return wr;
            }

            //验证二维码是否已扫描
            String ticket = QRcodeCache.getInstance().get(request.getQrcode());
            if(ticket.equals(QRcodeCache.getInstance().QR_STATUS_PASSIVE)){
                wr.setResult(null);
                wr.setStatus(SysConst.STATUS_ERROR);
                return wr;
            }

            PollingResponseBean bean = service.getUserInfo(ticket);
            if (bean == null){
                wr.setStatus(SysConst.STATUS_ERROR);
                wr.setErrorMsg("error");
            }

            wr.setResult(bean);

        }catch (Exception e){
            wr.setStatus(SysConst.STATUS_ERROR);
            wr.setErrorMsg("error");
        }

        return wr;
    }
}
