package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.entity.BasicGlassResponse;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import com.upuphone.xr.sapp.utils.SuperFunctionUtils;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper$installUpdateNow$1", f = "GlassUpdateHelper.kt", i = {0}, l = {1074}, m = "invokeSuspend", n = {"uid"}, s = {"L$0"})
public final class GlassUpdateHelper$installUpdateNow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateHelper$installUpdateNow$1(GlassUpdateInfo glassUpdateInfo, Continuation<? super GlassUpdateHelper$installUpdateNow$1> continuation) {
        super(2, continuation);
        this.$glassUpdateInfo = glassUpdateInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassUpdateHelper$installUpdateNow$1(this.$glassUpdateInfo, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        GlassUpdateState glassUpdateState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
            glassUpdateHelper.j1();
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            StarryNetDevice x = GlassHelper.f7049a.x();
            if (x == null) {
                glassUpdateHelper.d1("installUpdateNow, connectedDevice is null");
                glassUpdateHelper.v1(new GlassUpdateState.InstallFail(uuid, this.$glassUpdateInfo, 101));
                return Unit.INSTANCE;
            }
            GlassUpdateAdapter glassUpdateAdapter = GlassUpdateAdapter.b;
            this.L$0 = uuid;
            this.label = 1;
            obj = glassUpdateAdapter.w(x, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = uuid;
        } else if (i == 1) {
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BasicGlassResponse basicGlassResponse = (BasicGlassResponse) obj;
        GlassUpdateHelper glassUpdateHelper2 = GlassUpdateHelper.b;
        glassUpdateHelper2.d1("installUpdateNow, sendInstallUpdateCmd, response: " + basicGlassResponse);
        if (basicGlassResponse == null || !basicGlassResponse.isSuccess()) {
            glassUpdateState = new GlassUpdateState.InstallFail(str, this.$glassUpdateInfo, 115);
        } else {
            glassUpdateHelper2.d1("installUpdateNow, closeNavi");
            SuperFunctionUtils.b.a().c();
            glassUpdateState = new GlassUpdateState.Installing(this.$glassUpdateInfo, str);
        }
        glassUpdateHelper2.v1(glassUpdateState);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateHelper$installUpdateNow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
