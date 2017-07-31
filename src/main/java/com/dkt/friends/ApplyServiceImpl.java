package com.dkt.friends;

import com.dkt.common.SysException;
import com.dkt.doctor.DoctorDao;
import com.dkt.entity.*;
import com.dkt.org.DeptDao;
import com.dkt.org.OrgDao;
import com.platform.bean.PageInfo;
import com.platform.tool.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by litai on 2017/6/18.
 */
@Service
public class ApplyServiceImpl implements ApplyService {
    private static final Logger log = LoggerFactory.getLogger(ApplyServiceImpl.class);

    @Autowired
    private ApplyDao applyDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private OrgDao orgDao;

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private RelationDao relationDao;


    @Transactional
    public void addApply(RequestBeanP10014 bean) throws SysException {

        try {
            UserContactApply info = new UserContactApply();

            info.setApplyDate(Tools.getCurUnixTime());
            info.setApplyRemark(bean.getApplyRemark());
            info.setContactUserId(bean.getContactUserId());
            info.setUserType(bean.getUserType());
            info.setContactUserType(bean.getContactUserType());
            info.setIsAgree("0");
            info.setUserId(bean.getUserId());

            applyDao.save(info);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new SysException("0", "添加好友申请信息失败:" + e.getMessage());
        }
    }

    public ResponseBeanP10015 getList(RequestBeanP10015 bean) throws SysException {
        ResponseBeanP10015 response = new ResponseBeanP10015();
        List<ApplyListBean> result = new ArrayList<ApplyListBean>();

        try {
            PageInfo pageInfo = new PageInfo();
            pageInfo.setPageSize(bean.getPageSize());
            pageInfo.setPageNo(bean.getCurrentPage());

            List<UserContactApply> list = applyDao.getListPage(bean, pageInfo);

            for (UserContactApply apply : list) {

                ApplyListBean al = new ApplyListBean();
                al.setApplyDate(apply.getApplyDate());
                al.setApplyRemark(apply.getApplyRemark());
                al.setContactsId(apply.getContactsId());

                UserDoctorInfo di = doctorDao.get(UserDoctorInfo.class, apply.getUserId());
                if (di != null) {
                    al.setEmployeeName(di.getDoctorName());
                    al.setHeadIcon(di.getDoctorHeadIcon());
                }

                result.add(al);
            }

            response.setDataSource(result);
            response.setCurrentPage(bean.getCurrentPage());
            response.setPageSize(bean.getPageSize());

            Long total = pageInfo.getTotal();

            Long totalPageNum = (total + pageInfo.getPageSize() - 1) / pageInfo.getPageSize();
            response.setTotalPage(totalPageNum);
            response.setTotalRecord(pageInfo.getTotal());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new SysException("0", "查询好友申请信息失败:" + e.getMessage());
        }
        return response;
    }

    @Transactional
    public void updateApply(RequestBeanP10016 bean) throws SysException {
        try {

            List<UserContactApply> list = applyDao.getListByTwoId(bean, "0");
            for (UserContactApply info : list) {

                info.setIsAgree(bean.isAgree() ? "1" : "2");
                info.setOperationRemark(bean.getOperationRemark());
                applyDao.update(info);

                //TODO contactsId取ContactUserId
                // 同意后，录入到好友关系表中
                if (bean.isAgree()) {
                    UserContactRelation relation = new UserContactRelation();
                    relation.setContactUserId(info.getContactUserId());
                    relation.setContactUserType(info.getContactUserType());
                    relation.setUserId(info.getUserId());
                    relation.setUserType(info.getUserType());
                    relation.setInputTime(Tools.getCurUnixTime());
                    relationDao.save(relation);

                    UserContactRelation relation2 = new UserContactRelation();
                    relation2.setContactUserId(info.getUserId());
                    relation2.setContactUserType(info.getContactUserType());
                    relation2.setUserId(info.getContactUserId());
                    relation2.setUserType(info.getUserType());
                    relation2.setInputTime(Tools.getCurUnixTime());
                    relationDao.save(relation2);
                }

/*                UserContactRelation relation = new UserContactRelation();
                relation.setContactUserId(info.getContactUserId());
                relation.setUserId(info.getUserId());
                relationDao.delete(relation);*/
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    public HashMap getContactsInfo(RequestBeanP10016 bean) throws SysException {

        HashMap map = new HashMap();

        try {

            List<UserContactApply> list = applyDao.getListByTwoId(bean, null);
            if (list == null || list.isEmpty()) {

                return map;

            }

            UserContactApply apply = list.get(0);
            map.put("applyRemark", apply.getApplyRemark());

            UserDoctorInfo di = doctorDao.get(UserDoctorInfo.class, apply.getUserId());
            if (di != null) {
                HashMap user = new HashMap();
                user.put("headIcon", di.getDoctorHeadIcon());
                user.put("userId", di.getDoctorId());
                user.put("employeeName", di.getDoctorName());

                List<UserOrgInfo> orgs = orgDao.getDoctorOrg(di.getDoctorId());

                List<HashMap> os = getOrgDetail(orgs, di.getDoctorId());

                user.put("clinicInfoVoList", os);


                map.put("sendContactsInfo", user);

            }

            di = doctorDao.get(UserDoctorInfo.class, apply.getContactUserId());
            if (di != null) {
                HashMap user = new HashMap();
                user.put("headIcon", di.getDoctorHeadIcon());
                user.put("userId", di.getDoctorId());
                user.put("employeeName", di.getDoctorName());

                List<UserOrgInfo> orgs = orgDao.getDoctorOrg(di.getDoctorId());

                List<HashMap> os = getOrgDetail(orgs, di.getDoctorId());

                user.put("clinicInfoVoList", os);


                map.put("acceptContactsInfo", user);

            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new SysException("0", "查询申请详情信息失败:" + e.getMessage());
        }
        return map;
    }

    private List<HashMap> getOrgDetail(List<UserOrgInfo> orgs, String doctorId) {
        List<HashMap> os = new ArrayList<>();
        for (UserOrgInfo org : orgs) {

            HashMap o = new HashMap();
            o.put("clinicName", org.getClinicName());
            o.put("clinicId", org.getClinicId());
            o.put("postName", "");

            List<UserDeptInfo> depts = deptDao.getListByClinicIdAndDoctorId(org.getClinicId(), doctorId);

            List<HashMap> ds = new ArrayList<>();
            for (UserDeptInfo dept : depts) {
                HashMap<String, String> d = new HashMap();

                d.put("departmentName", dept.getDepartmentName());
                d.put("departmentId", dept.getDepartmentId());

                ds.add(d);
            }
            o.put("departmentInfoVoList", ds);

            os.add(o);
        }
        return os;
    }

    public HashMap getContactsList(RequestBeanP10016 bean) throws SysException {

        HashMap result = new HashMap();
        try {
            List list = new ArrayList();

            List<UserContactRelation> ucs = relationDao.getList(bean.getUserId());

            for (UserContactRelation relation : ucs) {

                UserDoctorInfo di = doctorDao.get(UserDoctorInfo.class, relation.getContactUserId());
                if (di != null) {
                    HashMap user = new HashMap();
                    user.put("headIcon", di.getDoctorHeadIcon());
                    user.put("userId", di.getDoctorId());
                    user.put("employeeName", di.getDoctorName());

                    List<UserOrgInfo> orgs = orgDao.getDoctorOrg(di.getDoctorId());

                    List<HashMap> os = getOrgDetail(orgs, di.getDoctorId());

                    user.put("clinicInfoVoList", os);
                    user.put("relationState", 0);
                    list.add(user);

                }
            }

            result.put("contactsListVo", list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new SysException("0", "查询好友列表信息失败:" + e.getMessage());
        }
        return result;
    }

}
