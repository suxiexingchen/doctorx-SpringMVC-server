package com.dkt.org;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linkd on 2017/6/28.
 */
public class OrgListResult<T> {
    private int lastResult;
    private List<String> totalDataRow
            = new ArrayList<>();
    private int totalPage;
    private int firstResult;
    private int pageSize;
    private int currentPage;
    private int totalRecord;
    private List<T> dataSource
            = new ArrayList<T>();

    public int getLastResult() {
        return lastResult;
    }

    public void setLastResult(int lastResult) {
        this.lastResult = lastResult;
    }

    public List<String> getTotalDataRow() {
        return totalDataRow;
    }

    public void setTotalDataRow(List<String> totalDataRow) {
        this.totalDataRow = totalDataRow;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getDataSource() {
        return dataSource;
    }

    public void setDataSource(List<T> dataSource) {
        this.dataSource = dataSource;
    }
}