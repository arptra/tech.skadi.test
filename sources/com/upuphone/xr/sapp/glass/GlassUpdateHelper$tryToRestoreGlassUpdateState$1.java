package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper$tryToRestoreGlassUpdateState$1", f = "GlassUpdateHelper.kt", i = {0}, l = {1682}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class GlassUpdateHelper$tryToRestoreGlassUpdateState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public GlassUpdateHelper$tryToRestoreGlassUpdateState$1(Continuation<? super GlassUpdateHelper$tryToRestoreGlassUpdateState$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GlassUpdateHelper$tryToRestoreGlassUpdateState$1 glassUpdateHelper$tryToRestoreGlassUpdateState$1 = new GlassUpdateHelper$tryToRestoreGlassUpdateState$1(continuation);
        glassUpdateHelper$tryToRestoreGlassUpdateState$1.L$0 = obj;
        return glassUpdateHelper$tryToRestoreGlassUpdateState$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GlassUpdateHelper.b.d1("tryToRestoreGlassUpdateState, start");
            GlassUpdateAdapter glassUpdateAdapter = GlassUpdateAdapter.b;
            StarryNetDevice x = GlassHelper.f7049a.x();
            this.L$0 = (CoroutineScope) this.L$0;
            this.label = 1;
            obj = glassUpdateAdapter.g(x, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Number) obj).intValue() == 1) {
            GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
            glassUpdateHelper.d1("tryToRestoreGlassUpdateState, isUpdating=true");
            GlassUpdateInfo n = glassUpdateHelper.H0();
            if (n == null) {
                glassUpdateHelper.e1("tryToRestoreGlassUpdateState, glassUpdateInfo is null");
                return Unit.INSTANCE;
            }
            glassUpdateHelper.d1("tryToRestoreGlassUpdateState, success");
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            glassUpdateHelper.v1(new GlassUpdateState.Installing(n, uuid));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateHelper$tryToRestoreGlassUpdateState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
