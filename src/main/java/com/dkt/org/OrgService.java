package com.dkt.org;

import com.dkt.common.SysException;

import java.util.List;

/**
 * Created by litai on 2017/6/17.
 */
public interface OrgService {
    public List<OrgListBean> getListPage(OrgRequestBean bean) throws SysException;
}
