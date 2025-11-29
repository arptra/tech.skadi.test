package org.apache.tika.utils;

public class FileProcessResult {

    /* renamed from: a  reason: collision with root package name */
    public String f3340a = "";
    public String b = "";
    public int c = -1;
    public long d = -1;
    public boolean e = false;
    public long f = -1;
    public long g = -1;
    public boolean h = false;
    public boolean i = false;

    public int a() {
        return this.c;
    }

    public String b() {
        return this.f3340a;
    }

    public long c() {
        return this.g;
    }

    public String d() {
        return this.b;
    }

    public long e() {
        return this.f;
    }

    public boolean f() {
        return this.h;
    }

    public boolean g() {
        return this.i;
    }

    public boolean h() {
        return this.e;
    }

    public String toString() {
        return "FileProcessResult{stderr='" + this.f3340a + '\'' + ", stdout='" + this.b + '\'' + ", exitValue=" + this.c + ", processTimeMillis=" + this.d + ", isTimeout=" + this.e + ", stdoutLength=" + this.f + ", stderrLength=" + this.g + ", stderrTruncated=" + this.h + ", stdoutTruncated=" + this.i + '}';
    }
}
