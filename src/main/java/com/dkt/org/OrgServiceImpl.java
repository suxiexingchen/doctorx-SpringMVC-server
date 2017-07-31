package com.dkt.org;

import com.dkt.common.SysException;
import com.dkt.entity.UserOrgInfo;
import com.platform.bean.PageInfo;
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
public class OrgServiceImpl implements OrgService {
    private static final Logger log = LoggerFactory.getLogger(OrgServiceImpl.class);

    @Autowired
    private OrgDao dao;

    public List<OrgListBean> getListPage(OrgRequestBean bean) throws SysException {
        List<OrgListBean> result = new ArrayList<OrgListBean>();

        try {


            PageInfo pageInfo = new PageInfo();

            pageInfo.setPageNo(bean.getCurrentPage());
            pageInfo.setPageSize(bean.getPageSize());


            List<UserOrgInfo> list = dao.getList(bean, pageInfo);

            for (UserOrgInfo info : list) {

                OrgListBean orb = new OrgListBean();
                BeanUtils.copyProperties(info, orb);
                result.add(orb);
            }
        } catch (Exception e) {
            throw new SysException("0", "查询机构信息失败:" + e.getMessage());
        }

        return result;
    }

}
