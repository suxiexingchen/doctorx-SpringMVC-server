package com.dkt.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Created by linkd on 2017/7/11.
 */
public class QRcodeCache {

    private static QRcodeCache mInstance = null;
    private static Cache cache;

    public final String QR_STATUS_PASSIVE = "0";

    public static QRcodeCache getInstance(){
        if (mInstance == null){
            mInstance = new QRcodeCache();

            CacheManager cacheManager = CacheManager.create();
            cache = cacheManager.getCache("QRCache");
        }
        return mInstance;
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
