package com.upuphone.xr.interconnect.entity;

import com.google.gson.Gson;

public class Function {
    private Object data;
    @FunctionType
    private int type;

    public Function(int i, Object obj) {
        this.type = i;
        this.data = obj;
    }

    public static Function parse(String str) {
        return (Function) new Gson().fromJson(str, Function.class);
    }

    public int getType() {
        return this.type;
    }

    public <K> K parseData(Class<K> cls) {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(this.data), cls);
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    public String toString(Gson gson) {
        return gson.toJson((Object) this);
    }

    public <K> K parseData(Gson gson, Class<K> cls) {
        return gson.fromJson(gson.toJson(this.data), cls);
    }
}
