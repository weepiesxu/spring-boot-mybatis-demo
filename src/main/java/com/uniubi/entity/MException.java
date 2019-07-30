package com.uniubi.entity;

/**
 * Created by uniubi on 2018-02-08.
 */
public class MException {

    private  String errorCode;
    private  String deviceSN;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDeviceSN() {
        return deviceSN;
    }

    public void setDeviceSN(String deviceSN) {
        this.deviceSN = deviceSN;
    }
}
