package com.dkt.online;

import com.dkt.common.SysException;

import java.util.HashMap;

/**
 * Created by litai on 2017/6/21.
 */
public interface OnlineService {
    public String bindTVNum(RequestBeanP10019 request) throws SysException;

    public HashMap<String, String> obtainNum(RequestBeanP10019 request);

    public HashMap<String, String> unbindNum(RequestBeanP10019 request);
}
