package com.upuphone.xr.sapp.unicron;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.entity.BasicGlassResponse;
import com.upuphone.xr.sapp.entity.UnicronUpdateInfo;
import com.upuphone.xr.sapp.glass.GlassHelper;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$syncUnicronUpdateInfo$1", f = "UnicronUpdateHelper.kt", i = {}, l = {420}, m = "invokeSuspend", n = {}, s = {})
public final class UnicronUpdateHelper$syncUnicronUpdateInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnicronUpdateHelper$syncUnicronUpdateInfo$1(GlassUpdateInfo glassUpdateInfo, Continuation<? super UnicronUpdateHelper$syncUnicronUpdateInfo$1> continuation) {
        super(2, continuation);
        this.$glassUpdateInfo = glassUpdateInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UnicronUpdateHelper$syncUnicronUpdateInfo$1(this.$glassUpdateInfo, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        BasicGlassResponse basicGlassResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StarryNetDevice y = GlassHelper.f7049a.y();
            if (y == null) {
                UnicronUpdateHelper.b.L("syncUnicronUpdateInfo, connectedGlass is null");
                return Unit.INSTANCE;
            }
            UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
            if (!unicronUpdateHelper.y(y)) {
                unicronUpdateHelper.L("syncUnicronUpdateInfo, isGlassSupportUnicronUpdate=false");
                return Unit.INSTANCE;
            }
            unicronUpdateHelper.L("syncUnicronUpdateInfo start");
            UnicronHelper unicronHelper = UnicronHelper.f7834a;
            UnicronUpdateInfo unicronUpdateInfo = new UnicronUpdateInfo(this.$glassUpdateInfo.getLatestVersion(), this.$glassUpdateInfo.getDigest(), this.$glassUpdateInfo.getReleaseNote(), this.$glassUpdateInfo.getExistsUpdate());
            this.label = 1;
            obj = UnicronHelper.m(unicronHelper, unicronUpdateInfo, 0, this, 2, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                UnicronUpdateHelper unicronUpdateHelper2 = UnicronUpdateHelper.b;
                unicronUpdateHelper2.M("syncUnicronUpdateInfo error: " + e);
                basicGlassResponse = null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        basicGlassResponse = (BasicGlassResponse) obj;
        UnicronUpdateHelper unicronUpdateHelper3 = UnicronUpdateHelper.b;
        unicronUpdateHelper3.L("syncUnicronUpdateInfo result: " + basicGlassResponse);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UnicronUpdateHelper$syncUnicronUpdateInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
