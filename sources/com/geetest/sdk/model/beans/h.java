package com.geetest.sdk.model.beans;

import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public Map f2951a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public List h;
    public JSONObject i;

    public Map a() {
        return this.f2951a;
    }

    public void b(String str) {
        this.e = str;
    }

    public void c(List list) {
        this.h = list;
    }

    public void d(Map map) {
        this.f2951a = map;
    }

    public void e(JSONObject jSONObject) {
        this.i = jSONObject;
    }

    public JSONObject f() {
        return this.i;
    }

    public void g(String str) {
        this.d = str;
    }

    public void h(String str) {
        this.g = str;
    }

    public void i(String str) {
        this.b = str;
    }

    public void j(String str) {
        this.c = str;
    }

    public void k(String str) {
        this.f = str;
    }

    public String toString() {
        return "GettypeBean{aspect_radio=" + this.f2951a + ", type='" + this.b + '\'' + ", type_value='" + this.c + '\'' + ", geetest='" + this.d + '\'' + ", click='" + this.e + '\'' + ", voice='" + this.f + '\'' + ", slide='" + this.g + '\'' + ", static_servers=" + this.h + ", jsonObject=" + this.i + '}';
    }
}
