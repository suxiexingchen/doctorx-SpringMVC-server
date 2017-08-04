package com.dkt.common;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * token管理.
 *
 * Created by GD on 2017/6/16.
 */
public class UserCache {

    private static UserCache userCache;
    public static UserCache getInstance() {
        if (null == userCache) {
            userCache = new UserCache();
        }
        return userCache;
    }
    // expireAfterAccess(long, TimeUnit)：最后一次访问后的一段时间移出；
    private Cache<String, String> tokenCache = CacheBuilder.newBuilder()
            .expireAfterAccess(30L, TimeUnit.MINUTES).build();

    /**
     * 生成并缓存token.
     *
     * @param account
     * @return
     */
    public String save(String account) {
        String token = UUID.randomUUID().toString().replace("-", "");
        tokenCache.put(token, account);
        return token;
    }

    /**
     * token验证.
     *
     * @param token
     * @return
     */
    public boolean check(String token) {
        return null != tokenCache.getIfPresent(token);

    }

    public String getAccount(String token){
        return tokenCache.asMap().get(token);
    }
}
