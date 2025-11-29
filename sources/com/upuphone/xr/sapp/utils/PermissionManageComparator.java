package com.upuphone.xr.sapp.utils;

import com.upuphone.xr.sapp.entity.PermissionManageItem;
import com.upuphone.xr.sapp.permission.Permission;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0018\u0010\u0011\u001a\u00020\b*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u00020\b*\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/utils/PermissionManageComparator;", "Ljava/util/Comparator;", "Lcom/upuphone/xr/sapp/entity/PermissionManageItem;", "Lkotlin/Comparator;", "<init>", "()V", "o1", "o2", "", "a", "(Lcom/upuphone/xr/sapp/entity/PermissionManageItem;Lcom/upuphone/xr/sapp/entity/PermissionManageItem;)I", "", "Lcom/upuphone/xr/sapp/permission/Permission;", "Ljava/util/List;", "orderList", "b", "(Lcom/upuphone/xr/sapp/entity/PermissionManageItem;)I", "order", "c", "(Lcom/upuphone/xr/sapp/permission/Permission;)I", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPermissionManageComparator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionManageComparator.kt\ncom/upuphone/xr/sapp/utils/PermissionManageComparator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,55:1\n1#2:56\n*E\n"})
public final class PermissionManageComparator implements Comparator<PermissionManageItem> {

    /* renamed from: a  reason: collision with root package name */
    public final List f7908a = CollectionsKt.listOf(Permission.PostNotification, Permission.Location, Permission.Bluetooth, Permission.CallPhone, Permission.ReadContact, Permission.CallLog, Permission.NotificationListener, Permission.FileAccess, Permission.Accessibility, Permission.RecordAudio, Permission.Camera, Permission.Album, Permission.Calendar, Permission.AlertWindow, Permission.AppOverlay, Permission.SportsHealth);

    /* renamed from: a */
    public int compare(PermissionManageItem permissionManageItem, PermissionManageItem permissionManageItem2) {
        Intrinsics.checkNotNullParameter(permissionManageItem, "o1");
        Intrinsics.checkNotNullParameter(permissionManageItem2, "o2");
        return (!permissionManageItem.getHasPermission() || !permissionManageItem2.getHasPermission()) ? (permissionManageItem.getHasPermission() || permissionManageItem2.getHasPermission()) ? permissionManageItem.getHasPermission() ? 1 : -1 : Intrinsics.compare(b(permissionManageItem), b(permissionManageItem2)) : Intrinsics.compare(b(permissionManageItem), b(permissionManageItem2));
    }

    public final int b(PermissionManageItem permissionManageItem) {
        return c(permissionManageItem.getPermission());
    }

    public final int c(Permission permission) {
        Integer valueOf = Integer.valueOf(this.f7908a.indexOf(permission));
        if (valueOf.intValue() < 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return Integer.MAX_VALUE;
    }
}
