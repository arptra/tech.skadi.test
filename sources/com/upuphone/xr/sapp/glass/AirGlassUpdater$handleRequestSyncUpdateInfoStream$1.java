package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.air.AirHelper;
import com.upuphone.xr.sapp.entity.AirSilentUpdateInfo;
import com.upuphone.xr.sapp.entity.AirUpdateConfig;
import com.upuphone.xr.sapp.glass.AirGlassUpdater;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirGlassUpdater$handleRequestSyncUpdateInfoStream$1", f = "AirGlassUpdater.kt", i = {}, l = {487}, m = "invokeSuspend", n = {}, s = {})
public final class AirGlassUpdater$handleRequestSyncUpdateInfoStream$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AirGlassUpdater this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirGlassUpdater$handleRequestSyncUpdateInfoStream$1(AirGlassUpdater airGlassUpdater, Continuation<? super AirGlassUpdater$handleRequestSyncUpdateInfoStream$1> continuation) {
        super(2, continuation);
        this.this$0 = airGlassUpdater;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AirGlassUpdater$handleRequestSyncUpdateInfoStream$1 airGlassUpdater$handleRequestSyncUpdateInfoStream$1 = new AirGlassUpdater$handleRequestSyncUpdateInfoStream$1(this.this$0, continuation);
        airGlassUpdater$handleRequestSyncUpdateInfoStream$1.L$0 = obj;
        return airGlassUpdater$handleRequestSyncUpdateInfoStream$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            AirUpdateConfig p = this.this$0.e;
            if (p == null) {
                AirGlassUpdater.g.d("handleRequestSyncUpdateInfoStream, airUpdateConfig is null");
                return Unit.INSTANCE;
            }
            AirSilentUpdateInfo airSilentUpdateInfo = new AirSilentUpdateInfo(p.getExistUpdate(), p.getRomMd5(), p.getInfo());
            AirGlassUpdater.Companion companion = AirGlassUpdater.g;
            companion.c("sendSyncUpdateInfoStream, info: " + airSilentUpdateInfo);
            AirHelper airHelper = AirHelper.b;
            this.label = 1;
            if (AirHelper.Y(airHelper, airSilentUpdateInfo, 0, this, 2, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                AirGlassUpdater.Companion companion2 = AirGlassUpdater.g;
                companion2.d("sendSyncUpdateInfoStream, error: " + e);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Unit unit = Unit.INSTANCE;
        AirGlassUpdater.Companion companion3 = AirGlassUpdater.g;
        companion3.c("sendSyncUpdateInfoStream, result: " + unit);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AirGlassUpdater$handleRequestSyncUpdateInfoStream$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
