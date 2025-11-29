package com.xjsd.ai.assistant.core.api.music;

public class MusicExecuteRes {
    private int code;
    private String msg;

    public MusicExecuteRes(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "MusicExecuteRes{code=" + this.code + ", msg='" + this.msg + '\'' + '}';
    }
}
