package com.upuphone.xr.sapp.utils;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.GenericWindowResult;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.DeviceHelper$unbindViewWithAsk$1", f = "DeviceHelper.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
public final class DeviceHelper$unbindViewWithAsk$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceHelper$unbindViewWithAsk$1(FragmentActivity fragmentActivity, Function1<? super Boolean, Unit> function1, Continuation<? super DeviceHelper$unbindViewWithAsk$1> continuation) {
        super(2, continuation);
        this.$activity = fragmentActivity;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DeviceHelper$unbindViewWithAsk$1(this.$activity, this.$callback, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FragmentActivity fragmentActivity = this.$activity;
            this.label = 1;
            obj = GenericWindowExtKt.b(fragmentActivity, MSG.MSG_PREPARING_RETRY, (Object) null, true, true, this, 2, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GenericWindowResult.ButtonAction buttonAction = (GenericWindowResult.ButtonAction) obj;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DeviceHelper", "unbindAirGlassWithAsk, dialogResult: " + buttonAction);
        if (buttonAction.getActionType() == 1101) {
            VuGlassControlModel.f8109a.D();
            delegate.a("DeviceHelper", "unbindViewWithAsk, result: true");
            this.$callback.invoke(Boxing.boxBoolean(true));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DeviceHelper$unbindViewWithAsk$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
