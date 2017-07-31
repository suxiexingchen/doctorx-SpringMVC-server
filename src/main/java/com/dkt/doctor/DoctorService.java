package com.dkt.doctor;

import com.dkt.common.SysException;

import java.util.List;

/**
 * Created by litai on 2017/6/17.
 */
public interface DoctorService {
    public List<DoctorListBeanP10012> getList(RequestBeanP10012 bean) throws SysException;

    public DoctorBeanP10013 getDoctorDetail(RequestBeanP10013 bean) throws SysException;

    public DoctorBeanP10009 getDoctorDetail(String ticket) throws SysException;
}
