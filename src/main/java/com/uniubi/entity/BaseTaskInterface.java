package com.uniubi.entity;

/**
 * Created by uniubi on 2018-02-08.
 */
public class BaseTaskInterface {
    //taskNo、interfaceName、result
    private String taskNo;
    private String interfaceName;
    private boolean result;

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

}
