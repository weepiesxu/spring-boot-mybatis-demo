package com.uniubi.entity;


public class BaseResult {
    public static final byte CALL_RESULT_FAILED = 0;
    public static final byte CALL_RESULT_SUCCEED = 1;
    public static  boolean  callfailed= false;
    public static boolean  callsuccessd = true;
    protected  boolean result;
    protected String code;
    private boolean success ;

    public BaseResult(boolean result, String code, boolean success) {
        this.result = result;
        this.code = code;
        this.success = success;
    }

    public BaseResult(boolean result, String code) {
        this.result = result;
        this.code = code;
    }

    public BaseResult(String code) {
        this.result = callsuccessd;
        this.code = code;
        this.success = callsuccessd;
    }

    public BaseResult() {
        this.result = callsuccessd;
        this.code = code;
        this.success = success;
    }




    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public boolean isSuccess() {
        return true ;
    }
}
