package com.upuphone.xr.sapp.vu.ota;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001c\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u0012R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\"\u001a\u0004\b\u001b\u0010\u0014¨\u0006#"}, d2 = {"Lcom/upuphone/xr/sapp/vu/ota/VuUpdateInfo;", "", "", "version", "checkVersion", "language", "country", "description", "Ljava/io/File;", "otaFile", "", "code", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;I)V", "", "h", "()Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "g", "b", "c", "e", "d", "f", "Ljava/io/File;", "()Ljava/io/File;", "I", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuUpdateInfo {

    /* renamed from: a  reason: collision with root package name */
    public final String f8083a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final File f;
    public final int g;

    public VuUpdateInfo(String str, String str2, String str3, String str4, String str5, File file, int i) {
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(str2, "checkVersion");
        Intrinsics.checkNotNullParameter(str3, "language");
        Intrinsics.checkNotNullParameter(str4, "country");
        Intrinsics.checkNotNullParameter(str5, "description");
        this.f8083a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = file;
        this.g = i;
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.g;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VuUpdateInfo)) {
            return false;
        }
        VuUpdateInfo vuUpdateInfo = (VuUpdateInfo) obj;
        return Intrinsics.areEqual((Object) this.f8083a, (Object) vuUpdateInfo.f8083a) && Intrinsics.areEqual((Object) this.b, (Object) vuUpdateInfo.b) && Intrinsics.areEqual((Object) this.c, (Object) vuUpdateInfo.c) && Intrinsics.areEqual((Object) this.d, (Object) vuUpdateInfo.d) && Intrinsics.areEqual((Object) this.e, (Object) vuUpdateInfo.e) && Intrinsics.areEqual((Object) this.f, (Object) vuUpdateInfo.f) && this.g == vuUpdateInfo.g;
    }

    public final File f() {
        return this.f;
    }

    public final String g() {
        return this.f8083a;
    }

    public final boolean h() {
        return this.g == 0 && this.f != null;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f8083a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        File file = this.f;
        return ((hashCode + (file == null ? 0 : file.hashCode())) * 31) + Integer.hashCode(this.g);
    }

    public String toString() {
        String str = this.f8083a;
        String str2 = this.b;
        String str3 = this.c;
        String str4 = this.d;
        String str5 = this.e;
        File file = this.f;
        int i = this.g;
        return "VuUpdateInfo(version=" + str + ", checkVersion=" + str2 + ", language=" + str3 + ", country=" + str4 + ", description=" + str5 + ", otaFile=" + file + ", code=" + i + ")";
    }
}
