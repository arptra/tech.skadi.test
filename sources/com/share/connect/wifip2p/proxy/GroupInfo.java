package com.share.connect.wifip2p.proxy;

public class GroupInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f9964a;
    public String b;
    public int c;
    public int d;
    public boolean e;
    public String f;

    public int a() {
        return this.d;
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.f9964a;
    }

    public String d() {
        return this.b;
    }

    public GroupInfo e(int i) {
        this.d = i;
        return this;
    }

    public GroupInfo f(int i) {
        this.c = i;
        return this;
    }

    public GroupInfo g(String str) {
        this.f = str;
        return this;
    }

    public GroupInfo h(boolean z) {
        this.e = z;
        return this;
    }

    public GroupInfo i(String str) {
        this.f9964a = str;
        return this;
    }

    public GroupInfo j(String str) {
        this.b = str;
        return this;
    }

    public String toString() {
        return "GroupInfo{mNetworkName='" + this.f9964a + '\'' + ", mPassphrase='" + this.b + '\'' + ", mFrequency=" + this.c + ", mIsGroupOwner=" + this.e + ", mGroupOwnerMac='" + this.f + '\'' + '}';
    }
}
