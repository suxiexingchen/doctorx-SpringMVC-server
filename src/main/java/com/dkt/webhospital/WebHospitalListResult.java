package com.dkt.webhospital;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @create 2017-08-16
 */
public class WebHospitalListResult<T> {

    private List<T> webHospital
            = new ArrayList<>();

    public List<T> getWebHospital() {
        return webHospital;
    }

    public void setWebHospital(List<T> webHospital) {
        this.webHospital = webHospital;
    }
}
