package com.platform.bean;

/**
 * Created by litai on 2017/5/26.
 */
public class WebRequest<T> {

    private T data;

    private PageInfo pageInfo;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
