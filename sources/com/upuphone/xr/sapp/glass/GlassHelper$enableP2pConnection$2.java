package com.upuphone.xr.sapp.glass;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.api.StarryNetDeviceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGlassHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper$enableP2pConnection$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,649:1\n314#2,11:650\n*S KotlinDebug\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper$enableP2pConnection$2\n*L\n255#1:650,11\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassHelper$enableP2pConnection$2", f = "GlassHelper.kt", i = {}, l = {650}, m = "invokeSuspend", n = {}, s = {})
public final class GlassHelper$enableP2pConnection$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $identifier;
    final /* synthetic */ StarryNetDeviceManager $starryNetDeviceManager;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassHelper$enableP2pConnection$2(String str, StarryNetDeviceManager starryNetDeviceManager, Continuation<? super GlassHelper$enableP2pConnection$2> continuation) {
        super(2, continuation);
        this.$identifier = str;
        this.$starryNetDeviceManager = starryNetDeviceManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassHelper$enableP2pConnection$2(this.$identifier, this.$starryNetDeviceManager, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$identifier;
            StarryNetDeviceManager starryNetDeviceManager = this.$starryNetDeviceManager;
            this.L$0 = str;
            this.L$1 = starryNetDeviceManager;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("GlassHelper", "enableP2pConnection-tryAcquireP2p, identifier: " + str);
            starryNetDeviceManager.tryAcquireP2p(str, new GlassHelper$enableP2pConnection$2$1$1(cancellableContinuationImpl));
            obj = cancellableContinuationImpl.u();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            StarryNetDeviceManager starryNetDeviceManager2 = (StarryNetDeviceManager) this.L$1;
            String str2 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((GlassHelper$enableP2pConnection$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
