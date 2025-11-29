package com.upuphone.xr.sapp.monitor.sport;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/sapp/monitor/sport/SportInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.sport.DefaultSportInfoProvider$update$1$sportInfo$1", f = "DefaultSportInfoProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultSportInfoProvider$update$1$sportInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SportInfo>, Object> {
    int label;
    final /* synthetic */ DefaultSportInfoProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultSportInfoProvider$update$1$sportInfo$1(DefaultSportInfoProvider defaultSportInfoProvider, Continuation<? super DefaultSportInfoProvider$update$1$sportInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultSportInfoProvider;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultSportInfoProvider$update$1$sportInfo$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                return this.this$0.e();
            } catch (Exception e) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.g("DefaultSportInfoProvider", "updateStepInfo error: " + e);
                return new SportInfo(0, 0.0d, 0, 0, 8, (DefaultConstructorMarker) null);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SportInfo> continuation) {
        return ((DefaultSportInfoProvider$update$1$sportInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
