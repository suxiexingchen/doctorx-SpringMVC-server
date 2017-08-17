package com.dkt.webhospital;

import com.dkt.common.SysException;
import com.dkt.doctor.DoctorDao;
import com.dkt.entity.UserDeptInfo;
import com.dkt.entity.UserDoctorInfo;
import com.dkt.entity.UserOrgInfo;
import com.dkt.org.DeptDao;
import com.dkt.org.OrgDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @create 2017-08-16
 */
@Service
public class WebHospitalServiceImpl implements WebHospitalService {
    private static final Logger log = LoggerFactory.getLogger(WebHospitalServiceImpl.class);

    @Autowired
    private OrgDao orgDao;
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private DoctorDao doctorDao;
    //获取所有的医院全部信息
    public List<WebHospitalBean> getListWebHospitalBean() throws SysException {

        List<UserOrgInfo> list = orgDao.getList(null, null);

        if (list!=null&&list.size()>0){
            log.debug("开始获取医院信息");
            List<WebHospitalBean> listHos=new ArrayList<>();
            for (UserOrgInfo uoi:list) {
                WebHospitalBean webHospitaBean = new WebHospitalBean();
                BeanUtils.copyProperties(uoi, webHospitaBean);
                listHos.add(webHospitaBean);

                List<UserDeptInfo> listByClinicId = deptDao.getListByClinicId(webHospitaBean.getClinicId());
                if (listByClinicId != null && listByClinicId.size() > 0) {
                    log.debug("开始获取科室信息");
                    List<DepartmentBean> departmentList = new ArrayList<>();
                    for (UserDeptInfo uif : listByClinicId) {
                        DepartmentBean departmentBean = new DepartmentBean();
                        BeanUtils.copyProperties(uif, departmentBean);
                        departmentList.add(departmentBean);

                        List<UserDoctorInfo> webDoctorList = doctorDao.getWebDoctorList(departmentBean.getDepartmentId());
                        if (webDoctorList != null && webDoctorList.size() > 0) {
                            log.debug("开始获取医生信息");
                            List<WebDoctorInfoBean> webDoctorInfoBeanList = new ArrayList<>();
                            for (UserDoctorInfo wd : webDoctorList) {
                                WebDoctorInfoBean bean = new WebDoctorInfoBean();
                                BeanUtils.copyProperties(wd, bean);
                                webDoctorInfoBeanList.add(bean);
                            }
                            departmentBean.setDoctorList(webDoctorList);
                        }
                    }
                    webHospitaBean.setDepartmentList(departmentList);


                }
            }
            return listHos;
        }

        return null;
    }



}
