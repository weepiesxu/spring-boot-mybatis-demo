package com.uniubi.entity;

/**
 * Created by uniubi on 2018-02-08.
 */
public class ImgRegCallBack {
    private String deviceKey;
    private String personId;
    private Long time;
    private String imgPath;
    private String faceId;
    private String ip;
    private String featureKey;
    private String feature;
    private String base64Feature;

    public String getBase64Feature() {
        return base64Feature;
    }

    public void setBase64Feature(String base64Feature) {
        this.base64Feature = base64Feature;
    }

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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFeatureKey() {
        return featureKey;
    }

    public void setFeatureKey(String featureKey) {
        this.featureKey = featureKey;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
