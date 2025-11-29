package org.apache.tika.sax.xpath;

public class SubtreeMatcher extends Matcher {
    public final Matcher b;

    public SubtreeMatcher(Matcher matcher) {
        this.b = matcher;
    }

    public Matcher a(String str, String str2) {
        Matcher a2 = this.b.a(str, str2);
        return (a2 == Matcher.f3334a || a2 == this.b) ? this : new CompositeMatcher(a2, this);
    }

    public boolean b(String str, String str2) {
        return this.b.b(str, str2);
    }

    public boolean c() {
        return this.b.c();
    }

    public boolean d() {
        return this.b.d();
    }
}
