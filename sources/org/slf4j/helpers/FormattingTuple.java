package org.slf4j.helpers;

public class FormattingTuple {
    public static FormattingTuple d = new FormattingTuple((String) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f3461a;
    public final Throwable b;
    public final Object[] c;

    public FormattingTuple(String str) {
        this(str, (Object[]) null, (Throwable) null);
    }

    public Object[] a() {
        return this.c;
    }

    public String b() {
        return this.f3461a;
    }

    public Throwable c() {
        return this.b;
    }

    public FormattingTuple(String str, Object[] objArr, Throwable th) {
        this.f3461a = str;
        this.b = th;
        this.c = objArr;
    }
}
