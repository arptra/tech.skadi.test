package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class GlideUrl implements Key {
    public final Headers b;
    public final URL c;
    public final String d;
    public String e;
    public URL f;
    public volatile byte[] g;
    public int h;

    public GlideUrl(URL url) {
        this(url, Headers.b);
    }

    public void b(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.d;
        return str != null ? str : ((URL) Preconditions.d(this.c)).toString();
    }

    public final byte[] d() {
        if (this.g == null) {
            this.g = c().getBytes(Key.f2451a);
        }
        return this.g;
    }

    public Map e() {
        return this.b.a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl glideUrl = (GlideUrl) obj;
        return c().equals(glideUrl.c()) && this.b.equals(glideUrl.b);
    }

    public final String f() {
        if (TextUtils.isEmpty(this.e)) {
            String str = this.d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) Preconditions.d(this.c)).toString();
            }
            this.e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.e;
    }

    public final URL g() {
        if (this.f == null) {
            this.f = new URL(f());
        }
        return this.f;
    }

    public URL h() {
        return g();
    }

    public int hashCode() {
        if (this.h == 0) {
            int hashCode = c().hashCode();
            this.h = hashCode;
            this.h = (hashCode * 31) + this.b.hashCode();
        }
        return this.h;
    }

    public String toString() {
        return c();
    }

    public GlideUrl(String str) {
        this(str, Headers.b);
    }

    public GlideUrl(URL url, Headers headers) {
        this.c = (URL) Preconditions.d(url);
        this.d = null;
        this.b = (Headers) Preconditions.d(headers);
    }

    public GlideUrl(String str, Headers headers) {
        this.c = null;
        this.d = Preconditions.b(str);
        this.b = (Headers) Preconditions.d(headers);
    }
}
