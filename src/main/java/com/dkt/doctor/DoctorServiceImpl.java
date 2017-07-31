package com.dkt.doctor;

import com.dkt.common.SysException;
import com.dkt.common.UserCache;
import com.dkt.entity.UserDeptInfo;
import com.dkt.entity.UserDoctorInfo;
import com.dkt.org.DeptDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by litai on 2017/6/17.
 */
@Service
public class DoctorServiceImpl implements DoctorService {
    private static final Logger log = LoggerFactory.getLogger(DoctorServiceImpl.class);

    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private DeptDao deptDao;

    public List<DoctorListBeanP10012> getList(RequestBeanP10012 bean) throws SysException {
        List<DoctorListBeanP10012> result = new ArrayList<DoctorListBeanP10012>();

        try {

            List<UserDeptInfo> deptList = deptDao.getListByClinicId(bean.getClinicId());


            for (UserDeptInfo dept : deptList) {

                DoctorListBeanP10012 doctorListBeanP10012 = new DoctorListBeanP10012();
                bean.setDeptId(dept.getDepartmentId());

                List<UserDoctorInfo> list = doctorDao.getList(bean);
                List<DoctorBeanP10012> dl = new ArrayList<DoctorBeanP10012>();

                for (UserDoctorInfo info : list) {
                    DoctorBeanP10012 db = new DoctorBeanP10012();
                    BeanUtils.copyProperties(info, db);
                    dl.add(db);
                }
                doctorListBeanP10012.setDepartmentId(dept.getDepartmentId());
                doctorListBeanP10012.setDepartmentName(dept.getDepartmentName());
                doctorListBeanP10012.setTeleDoctorInfoList(dl);

                result.add(doctorListBeanP10012);
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new SysException("0", "查询机构医生信息失败:" + e.getMessage());
        }

        return result;
    }

    public DoctorBeanP10013 getDoctorDetail(RequestBeanP10013 bean) throws SysException {
        DoctorBeanP10013 db = new DoctorBeanP10013();
        try {

            UserDoctorInfo info = doctorDao.get(UserDoctorInfo.class, bean.getDoctorId());
            if (info != null) {
                BeanUtils.copyProperties(info, db);
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new SysException("0", "查询机构医生详情信息失败:" + e.getMessage());
        }

        return db;
    }

    @Override
    public DoctorBeanP10009 getDoctorDetail(String ticket) throws SysException {

        try{
            String account = UserCache.getInstance().getAccount(ticket);
            List<DoctorBeanP10009> dbList = doctorDao.getList(account);
            if(dbList != null && dbList.size() != 0) return dbList.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
