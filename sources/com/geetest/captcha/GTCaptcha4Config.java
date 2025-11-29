package com.geetest.captcha;

import com.geetest.captcha.GTCaptcha4Client;
import java.util.Map;

public class GTCaptcha4Config implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2841a;
    public final String b;
    public final String c;
    public final String[] d;
    public final String[] e;
    public final Map f;
    public final boolean g;
    public final int h;
    public final int i;
    public final String j;
    public final GTCaptcha4Client.OnDialogShowListener k;

    public static class Builder implements NoProguard {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2842a = false;
        public String b = null;
        public String c = "file:///android_asset/gt4-index.html";
        public String[] d;
        public String[] e;
        public Map f = null;
        public boolean g = true;
        public int h = 10000;
        public int i = 0;
        public String j = null;
        public GTCaptcha4Client.OnDialogShowListener k = null;

        public GTCaptcha4Config q() {
            return new GTCaptcha4Config(this);
        }

        public Builder r(boolean z) {
            this.g = z;
            return this;
        }

        public Builder s(boolean z) {
            this.f2842a = z;
            return this;
        }

        public Builder t(Map map) {
            this.f = map;
            return this;
        }

        public Builder u(int i2) {
            this.h = i2;
            return this;
        }
    }

    public String[] f() {
        return this.d;
    }

    public int g() {
        return this.i;
    }

    public GTCaptcha4Client.OnDialogShowListener h() {
        return this.k;
    }

    public String i() {
        return this.j;
    }

    public String j() {
        return this.c;
    }

    public String k() {
        return this.b;
    }

    public Map l() {
        return this.f;
    }

    public String[] m() {
        return this.e;
    }

    public int n() {
        return this.h;
    }

    public boolean o() {
        return this.g;
    }

    public boolean p() {
        return this.f2841a;
    }

    public GTCaptcha4Config(Builder builder) {
        this.f2841a = builder.f2842a;
        this.b = builder.b;
        this.c = builder.c;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.d = builder.d;
        this.e = builder.e;
    }
}
