package com.dkt.login;

import org.springframework.stereotype.Service;

/**
 * Created by linkd on 2017/7/11.
 */
public interface QRLoginService {
    PollingResponseBean getUserInfo(String token);
}
