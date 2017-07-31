package com.dkt.friends;

import com.dkt.common.SysException;

import java.util.HashMap;

/**
 * Created by litai on 2017/6/18.
 */
public interface ApplyService {

    public void addApply(RequestBeanP10014 bean) throws SysException;

    public ResponseBeanP10015 getList(RequestBeanP10015 bean) throws SysException;

    public void updateApply(RequestBeanP10016 bean) throws SysException;

    public HashMap getContactsInfo(RequestBeanP10016 bean) throws SysException;

    public HashMap getContactsList(RequestBeanP10016 bean) throws SysException;
}
