package com.platform.base;

public class SysException extends Exception {

    private static final long serialVersionUID = 2295129033357234705L;

    public SysException(String error) {
        super(error);
    }
}
