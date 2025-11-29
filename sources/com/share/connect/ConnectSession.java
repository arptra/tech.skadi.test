package com.share.connect;

import com.easy.logger.EasyLog;

class ConnectSession {

    /* renamed from: a  reason: collision with root package name */
    public int f9870a = 1;
    public String b;
    public String c;
    public String d;
    public int e;

    public int a() {
        return this.f9870a;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.d;
    }

    public void e() {
        EasyLog.e("ConnectSession", "Reset.");
        h((String) null);
        i((String) null);
        f(1);
        j((String) null);
        g(0);
    }

    public ConnectSession f(int i) {
        this.f9870a = i;
        return this;
    }

    public ConnectSession g(int i) {
        this.e = i;
        return this;
    }

    public ConnectSession h(String str) {
        this.b = str;
        return this;
    }

    public ConnectSession i(String str) {
        this.c = str;
        return this;
    }

    public ConnectSession j(String str) {
        this.d = str;
        return this;
    }

    public String toString() {
        return "ConnectSession{Id='" + this.b + '\'' + ", Name=" + this.c + ", Band=" + this.f9870a + ", P2pMac=" + this.d + ", ConnectType=" + this.e + '}';
    }
}
