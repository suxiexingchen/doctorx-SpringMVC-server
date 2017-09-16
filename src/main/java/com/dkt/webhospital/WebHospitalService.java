package com.dkt.webhospital;

import com.dkt.common.SysException;

import java.util.List;

/**
 * @author 馒头花卷儿
 * @create 2017-08-16
 */
public interface WebHospitalService {

    public List<WebHospitalBean> getListWebHospitalBean(String doctorWay) throws SysException;
}
