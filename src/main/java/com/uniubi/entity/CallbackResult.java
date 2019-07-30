package com.uniubi.entity;

import java.util.Map;

public class CallbackResult<T> extends BaseResult {
    private T data;

    public CallbackResult() {
        super();
    }

    public CallbackResult(String code) {
        super(code);
    }

    public CallbackResult(String code, T t) {
        super(code);
        this.data = t;
    }

    public CallbackResult(boolean result, String code, boolean success , T t) {
        super(result, code,success);
        this.data = t;
    }

    public CallbackResult(boolean result, String code, T t) {
        super(result, code);
        this.data = t;
    }

    public CallbackResult( String code,boolean success,  T t) {
        super(success, code);
        this.data = t;
    }



    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CallbackResult{" +
                "data=" + data +
                ", result=" + result +
                ", code='" + code + '\'' +
                '}';
    }
}