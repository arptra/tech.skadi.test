package androidx.webkit;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public class WebMessageCompat {

    /* renamed from: a  reason: collision with root package name */
    public final WebMessagePortCompat[] f1959a;
    public final String b;
    public final byte[] c;
    public final int d;

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public WebMessageCompat(String str, WebMessagePortCompat[] webMessagePortCompatArr) {
        this.b = str;
        this.c = null;
        this.f1959a = webMessagePortCompatArr;
        this.d = 0;
    }

    public final void a(int i) {
        if (i != this.d) {
            throw new IllegalStateException("Wrong data accessor type detected. " + f(this.d) + " expected, but got " + f(i));
        }
    }

    public byte[] b() {
        a(1);
        Objects.requireNonNull(this.c);
        return this.c;
    }

    public String c() {
        a(0);
        return this.b;
    }

    public WebMessagePortCompat[] d() {
        return this.f1959a;
    }

    public int e() {
        return this.d;
    }

    public final String f(int i) {
        return i != 0 ? i != 1 ? "Unknown" : "ArrayBuffer" : "String";
    }

    public WebMessageCompat(byte[] bArr, WebMessagePortCompat[] webMessagePortCompatArr) {
        Objects.requireNonNull(bArr);
        this.c = bArr;
        this.b = null;
        this.f1959a = webMessagePortCompatArr;
        this.d = 1;
    }
}
