package com.upuphone.xr.sapp.permission;

import com.upuphone.xr.sapp.permission.PermissionChain;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PermissionChain$waitForPermissionResult$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ PermissionChain.PermissionTask $task;
    final /* synthetic */ PermissionChain this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionChain$waitForPermissionResult$2$1(PermissionChain permissionChain, PermissionChain.PermissionTask permissionTask) {
        super(1);
        this.this$0 = permissionChain;
        this.$task = permissionTask;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        this.this$0.c(this.$task);
    }
}
