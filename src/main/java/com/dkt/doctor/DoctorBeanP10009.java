package com.dkt.doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linkd on 2017/7/6.
 */
public class DoctorBeanP10009 {

    private String doctorId;

    private String doctorPhoto;

    private String realName;

    private String medicineTitle;

    private List<Clinic> clinicList = new ArrayList<>();

    public void addClinic(String clinicId, String clinicName, String isDefault){
        Clinic clinic = new Clinic();
        clinic.setClinicId(clinicId);
        clinic.setClinicName(clinicName);
        clinic.setIsDefault(isDefault);

        clinicList.add(clinic);
    }

    private class Clinic{
        private String clinicId;
        private String clinicName;
        private String isDefault;

        public String getClinicId() {
            return clinicId;
        }

        public void setClinicId(String clinicId) {
            this.clinicId = clinicId;
        }

        public String getClinicName() {
            return clinicName;
        }

        public void setClinicName(String clinicName) {
            this.clinicName = clinicName;
        }

        public String getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(String isDefault) {
            this.isDefault = isDefault;
        }
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorPhoto() {
        return doctorPhoto;
    }

    public void setDoctorPhoto(String doctorPhoto) {
        this.doctorPhoto = doctorPhoto;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMedicineTitle() {
        return medicineTitle;
    }

    public void setMedicineTitle(String medicineTitle) {
        this.medicineTitle = medicineTitle;
    }

    public List<Clinic> getClinicList() {
        return clinicList;
    }

    public void setClinicList(List<Clinic> clinicList) {
        this.clinicList = clinicList;
    }
}
