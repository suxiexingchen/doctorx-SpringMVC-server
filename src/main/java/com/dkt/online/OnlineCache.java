package com.dkt.online;


import com.google.common.cache.*;
import com.platform.base.SysBaseImpl;
import com.platform.tool.JsonTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by litai on 2017/6/23.
 */
public class OnlineCache {

    private static final Logger log = LoggerFactory.getLogger(OnlineCache.class);
    private static OnlineCache onlineCache;

    public static OnlineCache getInstance() {
        if (null == onlineCache) {
            onlineCache = new OnlineCache();
        }
        return onlineCache;
    }

    private Cache<String, String> tokenCache = CacheBuilder.newBuilder()
            .expireAfterAccess(10L, TimeUnit.SECONDS).removalListener(new RemovalListener<String, String>() {

                @Override
                public void onRemoval(RemovalNotification<String, String> notification) {


                    log.debug("开始清除{}的缓存信息:{}", notification.getKey(), notification.getValue());

                    try {
//                        OnlineService service = (OnlineService) SysBaseImpl.getBean("onlineServiceImpl");
//
//                        RequestBeanP10019 bean = JsonTool.readValue(notification.getValue(), RequestBeanP10019.class);
//
//                        service.unbindNum(bean);

                    } catch (Exception e) {
                        log.error("清理online缓存失败", e);
                    }

                }
            }).build();

    /**
     * @param userId
     * @param objStr
     * @return
     */
    public String save(String userId, String objStr) {

        tokenCache.put(userId, objStr);
        return userId;
    }

    /**
     * token验证.
     *
     * @param userId
     * @return
     */
    public boolean check(String userId) {
        return null != tokenCache.getIfPresent(userId);

    }

    /**
     * 获取缓存信息
     *
     * @param userId
     * @return
     */
    public String get(String userId) {

        if (check(userId)) {

            return tokenCache.getIfPresent(userId);

        } else {
            return null;
        }
    }

}