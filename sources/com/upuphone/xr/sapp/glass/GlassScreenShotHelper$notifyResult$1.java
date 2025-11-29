package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.entity.GlassScreenShotState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassScreenShotHelper$notifyResult$1", f = "GlassScreenShotHelper.kt", i = {}, l = {318}, m = "invokeSuspend", n = {}, s = {})
public final class GlassScreenShotHelper$notifyResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $errorCode;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassScreenShotHelper$notifyResult$1(int i, Continuation<? super GlassScreenShotHelper$notifyResult$1> continuation) {
        super(2, continuation);
        this.$errorCode = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassScreenShotHelper$notifyResult$1(this.$errorCode, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GlassScreenShotHelper glassScreenShotHelper = GlassScreenShotHelper.b;
            glassScreenShotHelper.B(this.$errorCode);
            if (this.$errorCode == 0) {
                GlassScreenShotHelper.g.postValue(GlassScreenShotState.Success.INSTANCE);
                this.label = 1;
                if (DelayKt.b(100, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                glassScreenShotHelper.x();
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GlassScreenShotHelper.b.x();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassScreenShotHelper$notifyResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
