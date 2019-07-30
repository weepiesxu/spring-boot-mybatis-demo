package com.uniubi.entity;

/**
 * Created by uniubi on 2018-02-08.
 */
public class wo_IdentifyCallBack {
    //deviceKey、showTime、ip、personId、photoUrl、cardNo、recMode、aliveType、type和idCardInfo
    private String deviceKey;
    private String personId;
    private String ip;
    private String type;
    private Long showTime;
    private String cardNo;

    public String getPassTimeType() {
        return passTimeType;
    }

    public void setPassTimeType(String passTimeType) {
        this.passTimeType = passTimeType;
    }

    public String getPermissionTimeType() {
        return permissionTimeType;
    }

    public void setPermissionTimeType(String permissionTimeType) {
        this.permissionTimeType = permissionTimeType;
    }

    public String getPhotoUrl() {
        return photoUrl;

    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    private String recMode;
    private String aliveType;
    private String idCardInfo;
    private String photoUrl;
    private String passTimeType;
    private String permissionTimeType;

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getShowTime() {
        return showTime;
    }

    public void setShowTime(Long showTime) {
        this.showTime = showTime;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getRecMode() {
        return recMode;
    }

    public void setRecMode(String recMode) {
        this.recMode = recMode;
    }

    public String getAliveType() {
        return aliveType;
    }

    public void setAliveType(String aliveType) {
        this.aliveType = aliveType;
    }

    public String getIdCardInfo() {
        return idCardInfo;
    }

    public void setIdCardInfo(String idCardInfo) {
        this.idCardInfo = idCardInfo;
    }







}
