package com.upuphone.xr.sapp.pag;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/pag/PagParam;", "", "", "path", "", "repeatTime", "<init>", "(Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "I", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PagParam {

    /* renamed from: a  reason: collision with root package name */
    public final String f7812a;
    public final int b;

    public PagParam(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "path");
        this.f7812a = str;
        this.b = i;
    }

    public final String a() {
        return this.f7812a;
    }

    public final int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PagParam)) {
            return false;
        }
        PagParam pagParam = (PagParam) obj;
        return Intrinsics.areEqual((Object) this.f7812a, (Object) pagParam.f7812a) && this.b == pagParam.b;
    }

    public int hashCode() {
        return (this.f7812a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        String str = this.f7812a;
        int i = this.b;
        return "PagParam(path=" + str + ", repeatTime=" + i + ")";
    }
}
