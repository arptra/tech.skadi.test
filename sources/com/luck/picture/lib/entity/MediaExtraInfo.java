package com.luck.picture.lib.entity;

public class MediaExtraInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f9421a;
    public int b;
    public int c;
    public long d;
    public String e;

    public long a() {
        return this.d;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public void d(long j) {
        this.d = j;
    }

    public void e(int i) {
        this.c = i;
    }

    public void f(String str) {
        this.e = str;
    }

    public void g(String str) {
        this.f9421a = str;
    }

    public void h(int i) {
        this.b = i;
    }

    public String toString() {
        return "MediaExtraInfo{videoThumbnail='" + this.f9421a + '\'' + ", width=" + this.b + ", height=" + this.c + ", duration=" + this.d + ", orientation='" + this.e + '\'' + '}';
    }
}
