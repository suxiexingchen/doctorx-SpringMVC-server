package com.dkt.common;

/**
 * Created by litai on 2017/6/17.
 */
public class  SysException extends Exception {

    private static final long serialVersionUID = 2295129033357234705L;

    private String error;

    private String code;

    public SysException(String code, String error) {
        this.code = code;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}