package com.upuphone.xr.sapp.vu.utils;

import com.upuphone.star.core.log.ULog;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper$cancelCheckActive$1", f = "VuGlassesActiveHelper.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
public final class VuGlassesActiveHelper$cancelCheckActive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public VuGlassesActiveHelper$cancelCheckActive$1(Continuation<? super VuGlassesActiveHelper$cancelCheckActive$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassesActiveHelper$cancelCheckActive$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.b(5000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ULog.f6446a.a("VuGlassesActiveHelper", "cancel check active");
        Job a2 = VuGlassesActiveHelper.c;
        if (a2 != null && a2.isActive()) {
            Job a3 = VuGlassesActiveHelper.c;
            if (a3 != null) {
                Job.DefaultImpls.a(a3, (CancellationException) null, 1, (Object) null);
            }
            VuGlassesActiveHelper.c = null;
            VuGlassesActiveHelper.f = false;
        }
        VuGlassesActiveHelper.d = null;
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuGlassesActiveHelper$cancelCheckActive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
