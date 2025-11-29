package com.upuphone.xr.sapp.entity;

import android.view.View;
import com.upuphone.xr.sapp.permission.Permission;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/PermissionManageItem;", "", "permission", "Lcom/upuphone/xr/sapp/permission/Permission;", "hasPermission", "", "view", "Landroid/view/View;", "(Lcom/upuphone/xr/sapp/permission/Permission;ZLandroid/view/View;)V", "getHasPermission", "()Z", "getPermission", "()Lcom/upuphone/xr/sapp/permission/Permission;", "getView", "()Landroid/view/View;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PermissionManageItem {
    private final boolean hasPermission;
    @NotNull
    private final Permission permission;
    @NotNull
    private final View view;

    public PermissionManageItem(@NotNull Permission permission2, boolean z, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(permission2, "permission");
        Intrinsics.checkNotNullParameter(view2, "view");
        this.permission = permission2;
        this.hasPermission = z;
        this.view = view2;
    }

    public final boolean getHasPermission() {
        return this.hasPermission;
    }

    @NotNull
    public final Permission getPermission() {
        return this.permission;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }
}
