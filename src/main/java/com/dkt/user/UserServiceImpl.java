package com.dkt.user;

import com.dkt.common.SysException;
import com.dkt.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-14
 */
@Service
public class UserServiceImpl implements UserService{
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    public List<UserResponseU0001> getUserInfoByCommunityId(Integer communityId) throws SysException {

        List<UserResponseU0001> list=new ArrayList<>();

        List<UserInfo> userInfoList = userDao.getUserInfoByCommunityId(communityId);
        if (null!=userInfoList&&userInfoList.size()>0){
            log.debug("已获取到用户信息");
            for (UserInfo user:userInfoList) {
                UserResponseU0001 userResponseU0001 = new UserResponseU0001();
                BeanUtils.copyProperties(user,userResponseU0001);
                list.add(userResponseU0001);
            }

        }

        return list;
    }
}
