package com.upuphone.xr.sapp.permission;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.permission.PermissionHelper", f = "PermissionHelper.kt", i = {0, 1}, l = {578, 584}, m = "waitForLocationState", n = {"activity", "activity"}, s = {"L$0", "L$0"})
public final class PermissionHelper$waitForLocationState$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PermissionHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionHelper$waitForLocationState$1(PermissionHelper permissionHelper, Continuation<? super PermissionHelper$waitForLocationState$1> continuation) {
        super(continuation);
        this.this$0 = permissionHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.y((FragmentActivity) null, this);
    }
}
