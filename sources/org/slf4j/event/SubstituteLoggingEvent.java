package org.slf4j.event;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

public class SubstituteLoggingEvent implements LoggingEvent {

    /* renamed from: a  reason: collision with root package name */
    public Level f3457a;
    public List b;
    public String c;
    public SubstituteLogger d;
    public String e;
    public String f;
    public Object[] g;
    public long h;
    public Throwable i;

    public void a(Marker marker) {
        if (marker != null) {
            if (this.b == null) {
                this.b = new ArrayList(2);
            }
            this.b.add(marker);
        }
    }

    public Level b() {
        return this.f3457a;
    }

    public SubstituteLogger c() {
        return this.d;
    }

    public void d(Object[] objArr) {
        this.g = objArr;
    }

    public void e(Level level) {
        this.f3457a = level;
    }

    public void f(SubstituteLogger substituteLogger) {
        this.d = substituteLogger;
    }

    public void g(String str) {
        this.c = str;
    }

    public void h(String str) {
        this.f = str;
    }

    public void i(String str) {
        this.e = str;
    }

    public void j(Throwable th) {
        this.i = th;
    }

    public void k(long j) {
        this.h = j;
    }
}
