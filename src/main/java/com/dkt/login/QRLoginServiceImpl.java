package com.dkt.login;

import com.dkt.common.UserCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by linkd on 2017/7/11.
 */
@Service
public class QRLoginServiceImpl implements QRLoginService {

    @Autowired
    private QRLoginDao dao;

    @Override
    public PollingResponseBean getUserInfo(String token) {

        PollingResponseBean bean = null;
        String account = UserCache.getInstance().getAccount(token);
        bean = dao.getInfo(account);
        if(bean == null) return null;
        bean.setCasUuid(UUID.randomUUID().toString().replace("-",""));
        bean.setTicket(token);
        bean.setHyUserId("");
        return bean;
    }
}
