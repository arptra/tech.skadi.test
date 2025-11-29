package com.xjsd.nbs.common.domain.response;

import com.alibaba.fastjson2.JSON;
import java.io.Serializable;

public class CommonResponse<T> implements Serializable {
    private static final long serialVersionUID = -2730725947895731122L;
    Integer code;
    T data;
    String msg;

    public CommonResponse(Integer num, String str) {
        this.code = num;
        this.msg = str;
    }

    public static <T> CommonResponse<T> fail(T t) {
        return new CommonResponse<>((ErrorCode) CommonErrorCode.SERVICE_ERROR, t);
    }

    public static String failString(ErrorCode errorCode) {
        return JSON.toJSONString(fail(errorCode));
    }

    public static <T> CommonResponse<T> getResult(int i, String str) {
        return new CommonResponse<>(Integer.valueOf(i), str);
    }

    private boolean isSuccess() {
        return CommonErrorCode.SUCCESS.getErrorCode() == getCode().intValue();
    }

    public static <T> CommonResponse<T> success() {
        return new CommonResponse<>((ErrorCode) CommonErrorCode.SUCCESS);
    }

    public static String successString() {
        return JSON.toJSONString(success());
    }

    public Integer getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setErrorCode(ErrorCode errorCode) {
        if (errorCode != null) {
            setCode(Integer.valueOf(errorCode.getErrorCode()));
            setMsg(errorCode.getErrorMessage());
        }
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public static <T> CommonResponse<T> fail(ErrorCode errorCode) {
        return new CommonResponse<>(errorCode);
    }

    public static String failString(ErrorCode errorCode, String str) {
        return JSON.toJSONString(fail(errorCode, str));
    }

    public static <T> CommonResponse<T> getResult(ErrorCode errorCode) {
        return new CommonResponse<>(errorCode);
    }

    public static <T> CommonResponse<T> success(T t) {
        return new CommonResponse<>((ErrorCode) CommonErrorCode.SUCCESS, t);
    }

    public static <T> CommonResponse<T> fail(ErrorCode errorCode, T t) {
        return new CommonResponse<>(errorCode, t);
    }

    public CommonResponse(Integer num, String str, T t) {
        this.code = num;
        this.msg = str;
        this.data = t;
    }

    public static <T> CommonResponse<T> fail(ErrorCode errorCode, String str) {
        return new CommonResponse<>(Integer.valueOf(errorCode.getErrorCode()), str);
    }

    public static <T> CommonResponse<T> fail(ErrorCode errorCode, String str, T t) {
        return new CommonResponse<>(Integer.valueOf(errorCode.getErrorCode()), str, t);
    }

    public static <T> CommonResponse<T> fail(int i, String str, T t) {
        return new CommonResponse<>(Integer.valueOf(i), str, t);
    }

    public CommonResponse() {
    }

    public CommonResponse(ErrorCode errorCode) {
        this.code = Integer.valueOf(errorCode.getErrorCode());
        this.msg = errorCode.getErrorMessage();
        this.data = null;
    }

    public CommonResponse(ErrorCode errorCode, T t) {
        this.code = Integer.valueOf(errorCode.getErrorCode());
        this.msg = errorCode.getErrorMessage();
        this.data = t;
    }

    public CommonResponse(T t) {
        this.data = t;
    }
}
