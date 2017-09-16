package com.dkt.doctor;

import com.dkt.common.SysException;
import com.dkt.common.UserCache;
import com.dkt.entity.UserDeptInfo;
import com.dkt.entity.UserDoctorInfo;
import com.dkt.entity.UserOrgInfo;
import com.dkt.org.DeptDao;
import com.dkt.org.OrgDao;
import com.platform.tool.Tools;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Autowired
    private OrgDao orgDao;

    public List<DoctorListBeanP10012> getList(RequestBeanP10012 bean) throws SysException {
        List<DoctorListBeanP10012> result = new ArrayList<DoctorListBeanP10012>();

        try {
            //科室信息
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

    @Transactional
    public void setOnlineStatus(RequestBeanP10014 request) throws SysException {
        UserDoctorInfo doctor =null;
        if (request.getDoctorId()!=null) {
            doctor = doctorDao.get(UserDoctorInfo.class, request.getDoctorId());
        }else{
            throw new SysException(null,"ID不能为空");
        }
        if (doctor!=null) {
            doctor.setOnlinestatus(request.getOnlineStatus());
            doctorDao.update(doctor);
        }else{
            throw new SysException(null,"医生找不到");
        }

    }

    @Transactional
    public void setTVN(RequestBeanP10015 request) throws SysException {

        List<UserDoctorInfo> doctorList = doctorDao.getDoctorByTVN(request.getTvn());
        for (UserDoctorInfo doctor:doctorList) {
            doctor.setTvn(null);
            doctorDao.update(doctor);


        }
        UserDoctorInfo info = doctorDao.get(UserDoctorInfo.class, request.getDoctorId());
        if (info!=null) {
            info.setTvn(request.getTvn());
            doctorDao.update(info);
        }

    }

    @Override
    public List getFamilyDoctorsByCommunityId(Integer communityId) throws SysException {

        List<ResponseClinicC0001<ResponseDepartmentD0001<ResponseDoctorT0001>>> list=new ArrayList<>();

        List<UserOrgInfo> OrgByList = orgDao.getDoctorOrgByCommunityId(communityId);

        if (Tools.isListNotNull(OrgByList)){
            log.debug("已获取到医院信息");
            for (UserOrgInfo org:OrgByList) {

                ResponseClinicC0001 responseClinicC0001=new ResponseClinicC0001();
                BeanUtils.copyProperties(org,responseClinicC0001);

                if(null!=org.getClinicId()){
                    List<UserDeptInfo> deptlist = deptDao.getListByClinicId(org.getClinicId());
                    List<ResponseDepartmentD0001<ResponseDoctorT0001>> departmentList=new ArrayList<>();

                    if (Tools.isListNotNull(deptlist)){
                        log.debug("已获取到科室信息");
                        for (UserDeptInfo dep:deptlist) {
                            ResponseDepartmentD0001 responseDepartmentD0001=new ResponseDepartmentD0001();
                            BeanUtils.copyProperties(dep,responseDepartmentD0001);

                                if (null!=dep.getDepartmentId()){
                                    List<ResponseDoctorT0001> doctorList=new ArrayList<>();
                                    List<UserDoctorInfo> doctorIsFamily = doctorDao.getDoctorIsFamily(dep.getDepartmentId());

                                    if (Tools.isListNotNull(doctorIsFamily)){
                                        log.debug("已获取到家庭医生信息");

                                        for (UserDoctorInfo doc:doctorIsFamily) {
                                            ResponseDoctorT0001 responseDoctorT0001=new ResponseDoctorT0001();
                                            BeanUtils.copyProperties(doc,responseDoctorT0001);
                                            doctorList.add(responseDoctorT0001);
                                        }
                                        responseDepartmentD0001.setDoctorList(doctorList);
                                    }


                                }

                            departmentList.add(responseDepartmentD0001);
                        }
                        responseClinicC0001.setDepartmentList(departmentList);
                    }


                }

                list.add(responseClinicC0001);
            }


        }


        return list;
    }

}
