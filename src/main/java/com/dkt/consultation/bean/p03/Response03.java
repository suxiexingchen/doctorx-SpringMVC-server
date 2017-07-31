package com.dkt.consultation.bean.p03;

import com.dkt.consultation.bean.ConInfo;

import java.util.List;

/**
 * Created by GD on 2017/6/17.
 */
public class Response03 {
    /**
     * 当前页码.
     */
    private int currentPage;
    /**
     * 一页数据的条数.
     */
    private int pageSize;
    /**
     * 总页数.
     */
    private int totalPage;
    /**
     * 总数据条数.
     */
    private int totalRecord;
    /**
     * 预约数据列表.
     */
    private List<ConInfo> dataSource;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<ConInfo> getDataSource() {
        return dataSource;
    }

    public void setDataSource(List<ConInfo> dataSource) {
        this.dataSource = dataSource;
    }
}
