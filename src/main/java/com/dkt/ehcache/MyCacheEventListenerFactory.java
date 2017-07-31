package com.dkt.ehcache;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

import java.util.Properties;

/**
 * Created by litai on 2017/6/28.
 */
public class MyCacheEventListenerFactory extends CacheEventListenerFactory {
    @Override
    public CacheEventListener createCacheEventListener(Properties properties) {
        return new MyCacheEventListener();
    }
}
