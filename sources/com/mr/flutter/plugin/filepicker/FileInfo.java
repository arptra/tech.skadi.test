package com.mr.flutter.plugin.filepicker;

import android.net.Uri;
import java.util.HashMap;

public class FileInfo {

    /* renamed from: a  reason: collision with root package name */
    public final String f9805a;
    public final String b;
    public final Uri c;
    public final long d;
    public final byte[] e;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f9806a;
        public String b;
        public Uri c;
        public long d;
        public byte[] e;

        public FileInfo a() {
            return new FileInfo(this.f9806a, this.b, this.c, this.d, this.e);
        }

        public Builder b(byte[] bArr) {
            this.e = bArr;
            return this;
        }

        public Builder c(String str) {
            this.b = str;
            return this;
        }

        public Builder d(String str) {
            this.f9806a = str;
            return this;
        }

        public Builder e(long j) {
            this.d = j;
            return this;
        }

        public Builder f(Uri uri) {
            this.c = uri;
            return this;
        }
    }

    public FileInfo(String str, String str2, Uri uri, long j, byte[] bArr) {
        this.f9805a = str;
        this.b = str2;
        this.d = j;
        this.e = bArr;
        this.c = uri;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("path", this.f9805a);
        hashMap.put("name", this.b);
        hashMap.put("size", Long.valueOf(this.d));
        hashMap.put("bytes", this.e);
        hashMap.put("identifier", this.c.toString());
        return hashMap;
    }
}
