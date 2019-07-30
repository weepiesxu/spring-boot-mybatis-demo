package com.uniubi.entity;

/**
 * Created by uniubi on 2018-02-08.
 */
public class TaskProcessingResults {


    //deviceKey 、taskNo、result
    private String deviceKey;
    private String taskNo;
    private String result;
    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
