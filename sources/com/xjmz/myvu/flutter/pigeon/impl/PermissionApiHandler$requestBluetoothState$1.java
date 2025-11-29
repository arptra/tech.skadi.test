package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.xjmz.myvu.MYVUActivity;
import com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.flutter.pigeon.impl.PermissionApiHandler$requestBluetoothState$1", f = "PermissionApiHandler.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
public final class PermissionApiHandler$requestBluetoothState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MYVUActivity $activity;
    final /* synthetic */ AndroidPermissionApi.Result<AndroidPermissionApi.PermissionResult> $result;
    int label;
    final /* synthetic */ PermissionApiHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionApiHandler$requestBluetoothState$1(MYVUActivity mYVUActivity, AndroidPermissionApi.Result<AndroidPermissionApi.PermissionResult> result, PermissionApiHandler permissionApiHandler, Continuation<? super PermissionApiHandler$requestBluetoothState$1> continuation) {
        super(2, continuation);
        this.$activity = mYVUActivity;
        this.$result = result;
        this.this$0 = permissionApiHandler;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PermissionApiHandler$requestBluetoothState$1(this.$activity, this.$result, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PermissionHelper permissionHelper = PermissionHelper.f7819a;
            MYVUActivity mYVUActivity = this.$activity;
            this.label = 1;
            obj = permissionHelper.x(mYVUActivity, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$result.success(this.this$0.p(((Boolean) obj).booleanValue(), "requestBluetoothState"));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PermissionApiHandler$requestBluetoothState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
