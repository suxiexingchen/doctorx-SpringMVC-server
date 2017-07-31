package com.dkt.ehcache;

import com.dkt.online.OnlineService;
import com.dkt.online.RequestBeanP10019;
import com.platform.base.SysBaseImpl;
import com.platform.tool.JsonTool;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by litai on 2017/6/28.
 */
public class MyCacheEventListener implements CacheEventListener {
    private static final Logger log = LoggerFactory.getLogger(MyCacheEventListener.class);

    @Override
    public void notifyElementRemoved(Ehcache ehcache, Element element) throws CacheException {

        log.debug("删除监听：{}", element.getKey());
    }

    @Override
    public void notifyElementPut(Ehcache ehcache, Element element) throws CacheException {
        log.debug("添加监听：{}", element.getKey());
    }

    @Override
    public void notifyElementUpdated(Ehcache ehcache, Element element) throws CacheException {
        log.debug("更新监听：{}", element.getKey());
    }

    @Override
    public void notifyElementExpired(Ehcache ehcache, Element element) {
        log.debug("到期清除：{}", element.getKey());

        try {

            OnlineService onlineService = (OnlineService)SysBaseImpl.getBean("onlineServiceImpl");
            RequestBeanP10019 bean = JsonTool.readValue(element.getValue().toString(), RequestBeanP10019.class);

            onlineService.unbindNum(bean);
        } catch (Exception e) {
            log.error("清除缓存释放绑定信息失败",e);
        }
    }

    @Override
    public void notifyElementEvicted(Ehcache ehcache, Element element) {
        log.debug("主动清除调用：{}", element.getKey());
        try {
            OnlineService onlineService = (OnlineService)SysBaseImpl.getBean("onlineServiceImpl");
            RequestBeanP10019 bean = JsonTool.readValue(element.getValue().toString(), RequestBeanP10019.class);

            onlineService.unbindNum(bean);
        } catch (Exception e) {
            log.error("清除缓存释放绑定信息失败",e);
        }
    }

    @Override
    public void notifyRemoveAll(Ehcache ehcache) {
    }

    @Override
    public void dispose() {

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }
}
