package org.apache.tika.sax;

class LinkBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final String f3323a;
    public final StringBuilder b = new StringBuilder();
    public String c = "";
    public String d = "";
    public String e = "";

    public LinkBuilder(String str) {
        this.f3323a = str;
    }

    public void a(char[] cArr, int i, int i2) {
        this.b.append(cArr, i, i2);
    }

    public Link b(boolean z) {
        String sb = this.b.toString();
        if (z) {
            sb = sb.replaceAll("\\s+", " ").trim();
        }
        return new Link(this.f3323a, this.c, this.d, sb, this.e);
    }

    public String c() {
        return this.f3323a;
    }

    public void d(String str) {
        if (str != null) {
            this.e = str;
        } else {
            this.e = "";
        }
    }

    public void e(String str) {
        if (str != null) {
            this.d = str;
        } else {
            this.d = "";
        }
    }

    public void f(String str) {
        if (str != null) {
            this.c = str;
        } else {
            this.c = "";
        }
    }
}
