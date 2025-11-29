package org.apache.tika.sax;

public class StandardReference {

    /* renamed from: a  reason: collision with root package name */
    public String f3327a;
    public String b;
    public String c;
    public String d;
    public double e;

    public static class StandardReferenceBuilder {

        /* renamed from: a  reason: collision with root package name */
        public final String f3328a;
        public final String b;
        public String c = null;
        public String d = null;
        public double e;

        public StandardReferenceBuilder(String str, String str2) {
            this.f3328a = str;
            this.b = str2;
            this.e = 0.0d;
        }

        public StandardReference a() {
            return new StandardReference(this.f3328a, this.c, this.d, this.b, this.e);
        }

        public StandardReferenceBuilder b(double d2) {
            this.e = d2;
            return this;
        }

        public StandardReferenceBuilder c(String str, String str2) {
            this.c = str;
            this.d = str2;
            return this;
        }
    }

    public String toString() {
        String str = this.f3327a;
        String str2 = this.b;
        if (str2 != null && !str2.isEmpty()) {
            str = str + this.b + this.c;
        }
        return str + " " + this.d;
    }

    public StandardReference(String str, String str2, String str3, String str4, double d2) {
        this.f3327a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = d2;
    }
}
