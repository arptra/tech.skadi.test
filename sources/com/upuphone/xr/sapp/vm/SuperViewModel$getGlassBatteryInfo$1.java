package com.upuphone.xr.sapp.vm;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.BasicGlassInfo;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.vm.SuperViewModel$getGlassBatteryInfo$1", f = "SuperViewModel.kt", i = {}, l = {298}, m = "invokeSuspend", n = {}, s = {})
public final class SuperViewModel$getGlassBatteryInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SuperViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperViewModel$getGlassBatteryInfo$1(SuperViewModel superViewModel, Continuation<? super SuperViewModel$getGlassBatteryInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = superViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SuperViewModel$getGlassBatteryInfo$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SuperViewModel superViewModel = this.this$0;
            this.label = 1;
            obj = superViewModel.R0(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BasicGlassInfo basicGlassInfo = (BasicGlassInfo) obj;
        if (basicGlassInfo != null) {
            SuperViewModel superViewModel2 = this.this$0;
            ULog.Delegate delegate = ULog.f6446a;
            String d = SuperViewModel.O0;
            int battery = basicGlassInfo.getBattery();
            boolean isCharging = basicGlassInfo.isCharging();
            delegate.g(d, "battery :" + battery + " and isCharging is: " + isCharging);
            superViewModel2.d1(basicGlassInfo);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SuperViewModel$getGlassBatteryInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
