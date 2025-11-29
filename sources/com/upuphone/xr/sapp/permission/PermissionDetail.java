package com.upuphone.xr.sapp.permission;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0011\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0014\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/permission/PermissionDetail;", "", "", "permission", "", "granted", "", "rejectCount", "<init>", "(Ljava/lang/String;ZI)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getPermission", "b", "Z", "()Z", "c", "I", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PermissionDetail {

    /* renamed from: a  reason: collision with root package name */
    public final String f7817a;
    public final boolean b;
    public final int c;

    public PermissionDetail(String str, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "permission");
        this.f7817a = str;
        this.b = z;
        this.c = i;
    }

    public final boolean a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionDetail)) {
            return false;
        }
        PermissionDetail permissionDetail = (PermissionDetail) obj;
        return Intrinsics.areEqual((Object) this.f7817a, (Object) permissionDetail.f7817a) && this.b == permissionDetail.b && this.c == permissionDetail.c;
    }

    public int hashCode() {
        return (((this.f7817a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        String str = this.f7817a;
        boolean z = this.b;
        int i = this.c;
        return "PermissionDetail(permission=" + str + ", granted=" + z + ", rejectCount=" + i + ")";
    }
}
