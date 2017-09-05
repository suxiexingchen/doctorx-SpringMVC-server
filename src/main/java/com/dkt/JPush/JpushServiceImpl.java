package com.dkt.JPush;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-31
 */
@Service
public class JpushServiceImpl implements JpushService{
    private static final Logger log = LoggerFactory.getLogger(JpushServiceImpl.class);

    @Override
    public JPushBeanP0002 lookWork(JPushRequestBeanP0001 request) {
        JPushBeanP0002 bean=new JPushBeanP0002();
        if (request.getAlias()!=null&&request.getName()!=null&&request.getWork()!=null){
            if (1==request.getWork()){
                //@param notification_title 通知内容标题
                bean.setNotification_title(request.getName()+"向您发起了会诊预约。");
                //@param msg_title 消息内容标题
                bean.setMsg_title("消息内容标题");
                //@param msg_content 消息内容
                bean.setMsg_content("");
                //@param extrasparam 扩展字段
                bean.setExtrasparam("");

                bean.setAlias(request.getAlias());
            }else{
                log.debug("推送业务，未找到");
            }
        }else{
            log.debug("参数不能为空");
        }
        return bean;
    }

    @Override
    public Integer sendToAlias(JPushBeanP0002 bean) {

        int status = JpushClientUtil.sendToAlias(
                bean.getAlias(),
                bean.getNotification_title(),
                bean.getMsg_title(),
                bean.getMsg_content(),
                bean.getExtrasparam()
        );
        if (1==status){
            log.debug("信息推送成功");
        }else{
            log.debug("信息推送失败");
        }

        return status;
    }
}
