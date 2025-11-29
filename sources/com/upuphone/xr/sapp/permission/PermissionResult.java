package com.upuphone.xr.sapp.permission;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/permission/PermissionResult;", "", "", "", "permissions", "", "Lcom/upuphone/xr/sapp/permission/PermissionDetail;", "details", "", "hasRequested", "<init>", "([Ljava/lang/String;Ljava/util/List;Z)V", "toString", "()Ljava/lang/String;", "a", "[Ljava/lang/String;", "getPermissions", "()[Ljava/lang/String;", "b", "Ljava/util/List;", "()Ljava/util/List;", "c", "Z", "getHasRequested", "()Z", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PermissionResult {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f7821a;
    public final List b;
    public final boolean c;

    public PermissionResult(String[] strArr, List list, boolean z) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(list, "details");
        this.f7821a = strArr;
        this.b = list;
        this.c = z;
    }

    public final List a() {
        return this.b;
    }

    public String toString() {
        String arrays = Arrays.toString(this.f7821a);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        List list = this.b;
        boolean z = this.c;
        return "PermissionResult(permissions=" + arrays + ", details=" + list + ", hasRequested=" + z + ")";
    }
}
