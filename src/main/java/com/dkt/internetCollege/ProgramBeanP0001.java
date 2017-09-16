package com.dkt.internetCollege;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-09
 */
public class ProgramBeanP0001<T> {

    private String programName;
    private List<T> tvactList
            = new ArrayList<>();


    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<T> getTvactList() {
        return tvactList;
    }

    public void setTvactList(List<T> tvactList) {
        this.tvactList = tvactList;
    }
}
