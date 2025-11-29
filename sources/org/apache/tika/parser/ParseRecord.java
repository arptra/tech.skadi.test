package org.apache.tika.parser;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ParseRecord {
    public static int g = 100;

    /* renamed from: a  reason: collision with root package name */
    public int f3248a = 0;
    public final Set b = new LinkedHashSet();
    public final List c = new ArrayList();
    public final List d = new ArrayList();
    public final List e = new ArrayList();
    public boolean f = false;

    public void a(Exception exc) {
        if (this.c.size() < 100) {
            this.c.add(exc);
        }
    }

    public void b(String str) {
        if (this.b.size() < g) {
            this.b.add(str);
        }
    }

    public void c() {
        this.f3248a--;
    }

    public void d() {
        this.f3248a++;
    }

    public int e() {
        return this.f3248a;
    }

    public List f() {
        return this.c;
    }

    public List g() {
        return this.e;
    }

    public String[] h() {
        return (String[]) this.b.toArray(new String[0]);
    }

    public List i() {
        return this.d;
    }

    public boolean j() {
        return this.f;
    }

    public void k(boolean z) {
        this.f = z;
    }
}
