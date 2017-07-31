package com.dkt.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Created by litai on 2017/6/28.
 */
public class OnlineCacheSpring {


    private static OnlineCacheSpring onlineCacheSpring;
    private static Cache cache;

    public static OnlineCacheSpring getInstance() {

        if (onlineCacheSpring == null) {
            onlineCacheSpring = new OnlineCacheSpring();

            CacheManager cacheManager = CacheManager.create();
            cache = cacheManager.getCache("onlineCache");
        }

        return onlineCacheSpring;
    }


    public void put(String key, String value) {

        Element putCache = new Element(key, value);
        cache.put(putCache);

    }

    public void delete(String key) {
        cache.remove(key);
    }

    public String get(String key) {
        Element c = cache.get(key);
        return c.getValue().toString();
    }

    public Boolean isCache(String key) {
        return null != cache.get(key);
    }


}
