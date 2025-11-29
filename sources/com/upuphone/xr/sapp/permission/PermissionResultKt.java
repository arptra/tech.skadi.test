package com.upuphone.xr.sapp.permission;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/permission/PermissionResult;", "", "a", "(Lcom/upuphone/xr/sapp/permission/PermissionResult;)Z", "isAllGranted", "b", "isAllRejectTwice", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPermissionResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionResult.kt\ncom/upuphone/xr/sapp/permission/PermissionResultKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,38:1\n1726#2,3:39\n1726#2,3:42\n*S KotlinDebug\n*F\n+ 1 PermissionResult.kt\ncom/upuphone/xr/sapp/permission/PermissionResultKt\n*L\n29#1:39,3\n37#1:42,3\n*E\n"})
public final class PermissionResultKt {
    public static final boolean a(PermissionResult permissionResult) {
        Intrinsics.checkNotNullParameter(permissionResult, "<this>");
        List<PermissionDetail> a2 = permissionResult.a();
        if ((a2 instanceof Collection) && a2.isEmpty()) {
            return true;
        }
        for (PermissionDetail a3 : a2) {
            if (!a3.a()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean b(PermissionResult permissionResult) {
        Intrinsics.checkNotNullParameter(permissionResult, "<this>");
        List<PermissionDetail> a2 = permissionResult.a();
        if ((a2 instanceof Collection) && a2.isEmpty()) {
            return true;
        }
        for (PermissionDetail b : a2) {
            if (b.b() < 2) {
                return false;
            }
        }
        return true;
    }
}
