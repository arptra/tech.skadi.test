package com.upuphone.xr.sapp.fragment;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.air.AirHelper;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.glass.GlassHelper;
import com.upuphone.xr.sapp.unicron.UnicronUpdateHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.StandbyPositionFragment$checkGlassAndRingInfo$1", f = "StandbyPositionFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class StandbyPositionFragment$checkGlassAndRingInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StandbyPositionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StandbyPositionFragment$checkGlassAndRingInfo$1(StandbyPositionFragment standbyPositionFragment, Continuation<? super StandbyPositionFragment$checkGlassAndRingInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = standbyPositionFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        StandbyPositionFragment$checkGlassAndRingInfo$1 standbyPositionFragment$checkGlassAndRingInfo$1 = new StandbyPositionFragment$checkGlassAndRingInfo$1(this.this$0, continuation);
        standbyPositionFragment$checkGlassAndRingInfo$1.L$0 = obj;
        return standbyPositionFragment$checkGlassAndRingInfo$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (!UnicronUpdateHelper.b.K()) {
                ULog.f6446a.a("StandbyPositionFragment", "checkGlassAndRingInfo, isFeatureEnable=false");
                this.this$0.A1(false);
                return Unit.INSTANCE;
            }
            StarryNetDevice w = GlassHelper.f7049a.w();
            if (w == null) {
                StandbyPositionFragment standbyPositionFragment = this.this$0;
                ULog.f6446a.a("StandbyPositionFragment", "checkGlassAndRingInfo, bondedGlass is null");
                standbyPositionFragment.A1(false);
                return Unit.INSTANCE;
            }
            SdkContext sdkContext = SdkContext.f6675a;
            int e = sdkContext.e().e();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("StandbyPositionFragment", "checkGlassAndRingInfo, peerVersion: " + e);
            Integer boxInt = AirHelper.b.I(w) ? Boxing.boxInt(5) : null;
            boolean z = boxInt != null && e >= boxInt.intValue();
            delegate.a("StandbyPositionFragment", "checkGlassAndRingInfo, isNewGlassVersion: " + z);
            if (!z) {
                this.this$0.A1(false);
                return Unit.INSTANCE;
            }
            Boolean a2 = sdkContext.g().a();
            delegate.a("StandbyPositionFragment", "checkGlassAndRingInfo, isNewRingVersion: " + a2);
            this.this$0.A1(Intrinsics.areEqual((Object) a2, (Object) Boxing.boxBoolean(true)));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StandbyPositionFragment$checkGlassAndRingInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
