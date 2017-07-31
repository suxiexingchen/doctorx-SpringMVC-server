package com.dkt.login;

/**
 * Created by litai on 2017/6/14.
 */
public interface T0001Service {
    T0001ResponseBean findByUp(String userName, String passwd, String appType) throws IllegalAccessException;
}
