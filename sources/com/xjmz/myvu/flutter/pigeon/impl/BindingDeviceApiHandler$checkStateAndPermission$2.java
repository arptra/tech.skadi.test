package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.xjmz.myvu.MYVUActivity;
import com.xjmz.myvu.flutter.pigeon.AndroidBindingDeviceApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.flutter.pigeon.impl.BindingDeviceApiHandler$checkStateAndPermission$2", f = "BindingDeviceApiHandler.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
public final class BindingDeviceApiHandler$checkStateAndPermission$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MYVUActivity $activity;
    final /* synthetic */ AndroidBindingDeviceApi.Result<Boolean> $result;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BindingDeviceApiHandler$checkStateAndPermission$2(MYVUActivity mYVUActivity, AndroidBindingDeviceApi.Result<Boolean> result, Continuation<? super BindingDeviceApiHandler$checkStateAndPermission$2> continuation) {
        super(2, continuation);
        this.$activity = mYVUActivity;
        this.$result = result;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BindingDeviceApiHandler$checkStateAndPermission$2(this.$activity, this.$result, continuation);
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
            obj = PermissionHelper.d(permissionHelper, mYVUActivity, false, this, 2, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$result.success(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BindingDeviceApiHandler$checkStateAndPermission$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
