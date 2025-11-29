package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.air.AirHelper;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$cancelSilentUpdate$1", f = "AirSilentUpdateHelper.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
public final class AirSilentUpdateHelper$cancelSilentUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public AirSilentUpdateHelper$cancelSilentUpdate$1(Continuation<? super AirSilentUpdateHelper$cancelSilentUpdate$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AirSilentUpdateHelper$cancelSilentUpdate$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Unit unit;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AirSilentUpdateHelper.b.t("cancelSilentUpdate, start");
            AirHelper airHelper = AirHelper.b;
            this.label = 1;
            if (AirHelper.t(airHelper, 0, this, 1, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                AirSilentUpdateHelper airSilentUpdateHelper = AirSilentUpdateHelper.b;
                airSilentUpdateHelper.v("cancelSilentUpdate, error: " + e);
                unit = null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        unit = Unit.INSTANCE;
        AirSilentUpdateHelper airSilentUpdateHelper2 = AirSilentUpdateHelper.b;
        airSilentUpdateHelper2.t("cancelSilentUpdate, result: " + unit);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AirSilentUpdateHelper$cancelSilentUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
