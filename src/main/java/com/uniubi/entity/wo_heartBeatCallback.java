package com.uniubi.entity;

/**
 * Created by uniubi on 2018-02-08.
 */
public class wo_heartBeatCallback {
    //deviceKey、createTime、ip、personCount、faceCount、version、 freeDiskSpace、 cpuUsageRate、 cpuTemperature和 memoryUsageRate
    private String deviceKey;
    private String createTime;
    private String ip;
    private String personCount;
    private Long faceCount;
    private String version;
    private String freeDiskSpace;
    private String cpuUsageRate;
    private String cpuTemperature;
    private String memoryUsageRate;


    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPersonCount() {
        return personCount;
    }

    public void setPersonCount(String personCount) {
        this.personCount = personCount;
    }

    public Long getFaceCount() {
        return faceCount;
    }

    public void setFaceCount(Long faceCount) {
        this.faceCount = faceCount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFreeDiskSpace() {
        return freeDiskSpace;
    }

    public void setFreeDiskSpace(String freeDiskSpace) {
        this.freeDiskSpace = freeDiskSpace;
    }

    public String getCpuUsageRate() {
        return cpuUsageRate;
    }

    public void setCpuUsageRate(String cpuUsageRate) {
        this.cpuUsageRate = cpuUsageRate;
    }

    public String getCpuTemperature() {
        return cpuTemperature;
    }

    public void setCpuTemperature(String cpuTemperature) {
        this.cpuTemperature = cpuTemperature;
    }

    public String getMemoryUsageRate() {
        return memoryUsageRate;
    }

    public void setMemoryUsageRate(String memoryUsageRate) {
        this.memoryUsageRate = memoryUsageRate;
    }
}
