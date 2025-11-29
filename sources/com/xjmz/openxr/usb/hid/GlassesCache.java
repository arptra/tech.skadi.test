package com.xjmz.openxr.usb.hid;

public class GlassesCache implements IHidInterface {

    /* renamed from: a  reason: collision with root package name */
    public final SvHidWrapper f8373a;
    public volatile String b;
    public volatile String c;
    public volatile String d;
    public volatile String e;
    public volatile String f;
    public volatile String g;
    public volatile int h = -99996;

    public GlassesCache(SvHidWrapper svHidWrapper) {
        this.f8373a = svHidWrapper;
    }

    public void a() {
        this.b = null;
        this.c = null;
        this.e = null;
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = -99996;
    }

    public String b() {
        if (this.d == null) {
            this.d = this.f8373a.svHidGetAIDspVersion();
        }
        return this.d;
    }

    public String c() {
        if (this.g == null) {
            this.g = this.f8373a.svHidGetDeviceName();
        }
        return this.g;
    }

    public String d() {
        if (this.e == null) {
            this.e = this.f8373a.svHidGetDisplayChipVersion();
        }
        return this.e;
    }

    public String e() {
        if (this.c == null) {
            this.c = this.f8373a.svHidGetMCUAPPVersion();
        }
        return this.c;
    }

    public String f() {
        if (this.b == null) {
            this.b = this.f8373a.svHidGetMCUBootVersion();
        }
        return this.b;
    }

    public int g(String str) {
        int svHidSetDeviceName = this.f8373a.svHidSetDeviceName(str);
        if (svHidSetDeviceName == 0) {
            this.g = str;
        } else {
            this.g = this.f8373a.svHidGetDeviceName();
        }
        return svHidSetDeviceName;
    }
}
