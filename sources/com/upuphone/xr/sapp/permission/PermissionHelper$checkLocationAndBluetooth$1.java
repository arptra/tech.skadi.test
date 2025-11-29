package com.upuphone.xr.sapp.permission;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.permission.PermissionHelper", f = "PermissionHelper.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {695, 699, 704, 710}, m = "checkLocationAndBluetooth", n = {"this", "activity", "needBluetoothPermission", "this", "activity", "needBluetoothPermission", "this", "activity", "needBluetoothPermission"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
public final class PermissionHelper$checkLocationAndBluetooth$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PermissionHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionHelper$checkLocationAndBluetooth$1(PermissionHelper permissionHelper, Continuation<? super PermissionHelper$checkLocationAndBluetooth$1> continuation) {
        super(continuation);
        this.this$0 = permissionHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c((FragmentActivity) null, false, this);
    }
}
