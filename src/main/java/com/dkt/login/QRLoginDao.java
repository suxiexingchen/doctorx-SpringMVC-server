package com.dkt.login;

/**
 * Created by linkd on 2017/7/11.
 */
public interface QRLoginDao {

    PollingResponseBean getInfo(String account);
}
