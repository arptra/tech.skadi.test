package com.xjsd.ai.assistant.protocol;

import com.google.gson.Gson;

public class Cmd {
    private static Gson PARSER = new Gson();
    private final int code;
    private Object payload;

    public Cmd(int i) {
        this.code = i;
    }

    public static Cmd parse(String str) {
        return (Cmd) PARSER.fromJson(str, Cmd.class);
    }

    public int getCode() {
        return this.code;
    }

    public Object getPayload() {
        return this.payload;
    }

    public <K> K parsePayload(Class<K> cls) {
        Gson gson = PARSER;
        return gson.fromJson(gson.toJson(this.payload), cls);
    }

    public void setPayload(Object obj) {
        this.payload = obj;
    }

    public String toString() {
        return PARSER.toJson((Object) this);
    }
}
