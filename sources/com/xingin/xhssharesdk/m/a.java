package com.xingin.xhssharesdk.m;

import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f8192a;
    public final String b;
    public final String c;
    public final long d;
    public final boolean e;
    public final int f;
    public final String g;

    public a(String str, String str2, String str3, long j, boolean z, int i, String str4) {
        this.f8192a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
        this.e = z;
        this.f = i;
        this.g = str4;
    }

    public static a a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new a(jSONObject.optString("appVersion"), jSONObject.optString("appPackage"), jSONObject.optString("sdkVersion"), jSONObject.getLong("timeStamp"), jSONObject.getBoolean("valid"), jSONObject.getInt("errorCode"), jSONObject.optString("errorMessage"));
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("appVersion", this.f8192a);
        jSONObject.putOpt("appPackage", this.b);
        jSONObject.putOpt("sdkVersion", this.c);
        jSONObject.putOpt("timeStamp", Long.valueOf(this.d));
        jSONObject.putOpt("valid", Boolean.valueOf(this.e));
        jSONObject.putOpt("errorCode", Integer.valueOf(this.f));
        jSONObject.putOpt("errorMessage", this.g);
        return jSONObject;
    }
}
