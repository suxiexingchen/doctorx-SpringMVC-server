package com.dkt.friends;

import java.util.List;

/**
 * Created by litai on 2017/6/18.
 */
public class ResponseBeanP10015 {

    private Integer currentPage;
    private Integer pageSize;
    private Long totalPage;
    private Long totalRecord;
    private List<ApplyListBean> dataSource;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<ApplyListBean> getDataSource() {
        return dataSource;
    }

    public void setDataSource(List<ApplyListBean> dataSource) {
        this.dataSource = dataSource;
    }
}
