package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.entity.PermissionManageItem;
import com.upuphone.xr.sapp.permission.Permission;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/PermissionManageItem;", "invoke", "(Lcom/upuphone/xr/sapp/entity/PermissionManageItem;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PermissionManagerFragment$addPermissionManageItem$1 extends Lambda implements Function1<PermissionManageItem, Boolean> {
    final /* synthetic */ Permission $permission;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionManagerFragment$addPermissionManageItem$1(Permission permission) {
        super(1);
        this.$permission = permission;
    }

    @NotNull
    public final Boolean invoke(@NotNull PermissionManageItem permissionManageItem) {
        Intrinsics.checkNotNullParameter(permissionManageItem, "it");
        return Boolean.valueOf(permissionManageItem.getPermission() == this.$permission);
    }
}
