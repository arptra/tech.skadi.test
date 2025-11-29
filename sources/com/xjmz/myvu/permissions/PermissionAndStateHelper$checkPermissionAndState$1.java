package com.xjmz.myvu.permissions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.permissions.PermissionAndStateHelper", f = "PermissionAndStateHelper.kt", i = {0, 1, 2, 3, 4, 5, 6}, l = {173, 181, 188, 198, 203, 208, 216}, m = "checkPermissionAndState", n = {"this", "this", "this", "this", "this", "this", "this"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0"})
public final class PermissionAndStateHelper$checkPermissionAndState$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PermissionAndStateHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionAndStateHelper$checkPermissionAndState$1(PermissionAndStateHelper permissionAndStateHelper, Continuation<? super PermissionAndStateHelper$checkPermissionAndState$1> continuation) {
        super(continuation);
        this.this$0 = permissionAndStateHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(this);
    }
}
