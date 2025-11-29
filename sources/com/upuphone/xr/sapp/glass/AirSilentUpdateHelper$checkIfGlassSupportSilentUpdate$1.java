package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.air.AirHelper;
import com.upuphone.xr.sapp.entity.AirSilentUpdateVersion;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$checkIfGlassSupportSilentUpdate$1", f = "AirSilentUpdateHelper.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
public final class AirSilentUpdateHelper$checkIfGlassSupportSilentUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public AirSilentUpdateHelper$checkIfGlassSupportSilentUpdate$1(Continuation<? super AirSilentUpdateHelper$checkIfGlassSupportSilentUpdate$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AirSilentUpdateHelper$checkIfGlassSupportSilentUpdate$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        AirSilentUpdateVersion airSilentUpdateVersion;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AirSilentUpdateHelper airSilentUpdateHelper = AirSilentUpdateHelper.b;
            airSilentUpdateHelper.t("checkIfGlassSupportSilentUpdate, start");
            if (!AirSilentUpdateHelper.d) {
                airSilentUpdateHelper.t("checkIfGlassSupportSilentUpdate, isFeatureEnabled=false");
                return Unit.INSTANCE;
            }
            AirHelper airHelper = AirHelper.b;
            this.label = 1;
            obj = AirHelper.B(airHelper, 0, this, 1, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                AirSilentUpdateHelper airSilentUpdateHelper2 = AirSilentUpdateHelper.b;
                airSilentUpdateHelper2.v("checkIfGlassSupportSilentUpdate, error: " + e);
                airSilentUpdateVersion = null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        airSilentUpdateVersion = (AirSilentUpdateVersion) obj;
        AirSilentUpdateHelper airSilentUpdateHelper3 = AirSilentUpdateHelper.b;
        airSilentUpdateHelper3.t("checkIfGlassSupportSilentUpdate, result: " + airSilentUpdateVersion);
        if (airSilentUpdateVersion == null) {
            z = false;
        }
        AirSilentUpdateHelper.c = z;
        if (AirSilentUpdateHelper.c) {
            GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
            if (glassUpdateHelper.I0().getValue() == null) {
                GlassUpdateHelper.i0(glassUpdateHelper, 0, false, 3, (Object) null);
            } else {
                airSilentUpdateHelper3.r();
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AirSilentUpdateHelper$checkIfGlassSupportSilentUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
