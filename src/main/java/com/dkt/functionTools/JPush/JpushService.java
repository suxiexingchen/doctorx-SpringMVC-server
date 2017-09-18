package com.dkt.functionTools.JPush;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-31
 */

public interface JpushService {
    public JPushBeanP0002 lookWork(JPushRequestBeanP0001 request);

    public Integer sendToAlias(JPushBeanP0002 bean);
}
