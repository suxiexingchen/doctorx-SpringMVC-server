package com.dkt.ehcache;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

import java.util.Properties;

/**
 * Created by linkd on 2017/7/11.
 */
public class QRCacheEventListenerFactory extends CacheEventListenerFactory {
    @Override
    public CacheEventListener createCacheEventListener(Properties properties) {
        return new QRCacheEventListener();
    }
}
