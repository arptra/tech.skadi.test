package org.apache.tika.parser.txt;

import java.io.InputStream;

public class CharsetMatch implements Comparable<CharsetMatch> {

    /* renamed from: a  reason: collision with root package name */
    public int f3262a;
    public byte[] b = null;
    public int c;
    public InputStream d = null;
    public String e;
    public String f;

    public CharsetMatch(CharsetDetector charsetDetector, CharsetRecognizer charsetRecognizer, int i) {
        this.f3262a = i;
        InputStream inputStream = charsetDetector.i;
        if (inputStream == null) {
            this.b = charsetDetector.g;
            this.c = charsetDetector.h;
        }
        this.d = inputStream;
        this.e = charsetRecognizer.b();
        this.f = charsetRecognizer.a();
    }

    /* renamed from: a */
    public int compareTo(CharsetMatch charsetMatch) {
        int i = this.f3262a;
        int i2 = charsetMatch.f3262a;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    public int d() {
        return this.f3262a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof CharsetMatch) && this.f3262a == ((CharsetMatch) obj).f3262a;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        String name = getName();
        String str = "_rtl";
        if (!name.contains(str)) {
            str = "_ltr";
        }
        int indexOf = name.indexOf(str);
        return indexOf > 0 ? name.substring(0, indexOf) : name;
    }

    public String getName() {
        return this.e;
    }

    public int hashCode() {
        return this.f3262a;
    }

    public String toString() {
        String str = "Match of " + this.e;
        if (f() != null) {
            str = str + " in " + f();
        }
        return str + " with confidence " + this.f3262a;
    }

    public CharsetMatch(CharsetDetector charsetDetector, CharsetRecognizer charsetRecognizer, int i, String str, String str2) {
        this.f3262a = i;
        InputStream inputStream = charsetDetector.i;
        if (inputStream == null) {
            this.b = charsetDetector.g;
            this.c = charsetDetector.h;
        }
        this.d = inputStream;
        this.e = str;
        this.f = str2;
    }
}
