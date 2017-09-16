package com.dkt.webhospital;

/**
 * @author 馒头花卷儿
 * @Description:请求参数
 * @create 2017-09-15
 */
public class WeHospitalRequestW0001 {

    /**
     * 系统内医生类别 0-值班医生，1-专家，2-网络医生
     */
    private String doctorWay;

    public String getDoctorWay() {
        return doctorWay;
    }

    public void setDoctorWay(String doctorWay) {
        this.doctorWay = doctorWay;
    }
}
