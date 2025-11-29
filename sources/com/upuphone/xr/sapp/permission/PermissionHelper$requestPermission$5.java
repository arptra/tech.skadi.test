package com.upuphone.xr.sapp.permission;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.permission.PermissionHelper$requestPermission$5", f = "PermissionHelper.kt", i = {}, l = {560}, m = "invokeSuspend", n = {}, s = {})
public final class PermissionHelper$requestPermission$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ String[] $permissions;
    final /* synthetic */ boolean $showRejectDialog;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionHelper$requestPermission$5(FragmentActivity fragmentActivity, String[] strArr, boolean z, Function1<? super Boolean, Unit> function1, Continuation<? super PermissionHelper$requestPermission$5> continuation) {
        super(2, continuation);
        this.$activity = fragmentActivity;
        this.$permissions = strArr;
        this.$showRejectDialog = z;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PermissionHelper$requestPermission$5(this.$activity, this.$permissions, this.$showRejectDialog, this.$callback, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PermissionHelper permissionHelper = PermissionHelper.f7819a;
            FragmentActivity fragmentActivity = this.$activity;
            String[] strArr = this.$permissions;
            boolean z = this.$showRejectDialog;
            this.label = 1;
            obj = permissionHelper.p(fragmentActivity, strArr, z, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$callback.invoke(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PermissionHelper$requestPermission$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
