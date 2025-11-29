package org.apache.tika.sax.xpath;

public class CompositeMatcher extends Matcher {
    public final Matcher b;
    public final Matcher c;

    public CompositeMatcher(Matcher matcher, Matcher matcher2) {
        this.b = matcher;
        this.c = matcher2;
    }

    public Matcher a(String str, String str2) {
        Matcher a2 = this.b.a(str, str2);
        Matcher a3 = this.c.a(str, str2);
        Matcher matcher = Matcher.f3334a;
        return a2 == matcher ? a3 : a3 == matcher ? a2 : (this.b == a2 && this.c == a3) ? this : new CompositeMatcher(a2, a3);
    }

    public boolean b(String str, String str2) {
        return this.b.b(str, str2) || this.c.b(str, str2);
    }

    public boolean c() {
        return this.b.c() || this.c.c();
    }

    public boolean d() {
        return this.b.d() || this.c.d();
    }
}
