package com.upuphone.xr.sapp.fragment;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.tici.phone.utils.StoragePermission;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/ar/tici/phone/utils/StoragePermission;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PermissionManagerFragment$storagePermission$2 extends Lambda implements Function0<StoragePermission> {
    final /* synthetic */ PermissionManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionManagerFragment$storagePermission$2(PermissionManagerFragment permissionManagerFragment) {
        super(0);
        this.this$0 = permissionManagerFragment;
    }

    @NotNull
    public final StoragePermission invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        return new StoragePermission(requireActivity);
    }
}
