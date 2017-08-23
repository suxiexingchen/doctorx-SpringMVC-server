package com.dkt.version;

import com.dkt.common.SysConst;
import com.dkt.entity.AppVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-21
 */
@Service
public class VersionServiceImpl implements VersionService{
    private static final Logger log = LoggerFactory.getLogger(VersionServiceImpl.class);
    @Autowired
    private VersionDao versionDao;

    @Override
    public VersionBeanV0001 upGrade(RequestBeanV0001 request) {

        if (null!=request.getApp()&&null!=request.getChannel()&&null!=request.getDevType()&&null!=request.getCode()){
            AppVersion appVersion = versionDao.upGrade(request);
            VersionBeanV0001 versionBeanV0001=new VersionBeanV0001();
            if (null!=appVersion) {
                log.debug("版本需要升级");

                BeanUtils.copyProperties(appVersion, versionBeanV0001);
                versionBeanV0001.setCreateTime(appVersion.getCreateTime().toString());
                versionBeanV0001.setUrl(SysConst.PREFIX_URL+appVersion.getUrl());
            }else{
                return null;
            }
            return versionBeanV0001;

        }
        return null;
    }
}
