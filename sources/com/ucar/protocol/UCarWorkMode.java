package com.ucar.protocol;

public class UCarWorkMode {

    /* renamed from: a  reason: collision with root package name */
    public int f9642a;

    public UCarWorkMode(int i) {
        this.f9642a = i;
    }

    public static UCarWorkMode a(int i) {
        return new UCarWorkMode(i);
    }

    public boolean b() {
        return (this.f9642a & 4) > 0;
    }

    public boolean c() {
        return (this.f9642a & 8) > 0;
    }

    public boolean d() {
        return (this.f9642a & 16) > 0;
    }

    public boolean e() {
        return (this.f9642a & 2) > 0;
    }

    public boolean f() {
        return (this.f9642a & 32) > 0;
    }

    public boolean g() {
        return (this.f9642a & 128) > 0;
    }

    public boolean h() {
        return (this.f9642a & 64) > 0;
    }

    public boolean i() {
        return (this.f9642a & 1) > 0;
    }

    public int j(int i) {
        return this.f9642a & i;
    }

    public int k() {
        return this.f9642a;
    }

    public String toString() {
        return "workMode: " + this.f9642a;
    }
}
