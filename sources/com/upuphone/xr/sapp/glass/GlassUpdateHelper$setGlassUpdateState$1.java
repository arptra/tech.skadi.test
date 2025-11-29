package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.entity.GlassUpdateState;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper$setGlassUpdateState$1", f = "GlassUpdateHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GlassUpdateHelper$setGlassUpdateState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needNotify;
    final /* synthetic */ GlassUpdateState $updateState;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateHelper$setGlassUpdateState$1(GlassUpdateState glassUpdateState, boolean z, Continuation<? super GlassUpdateHelper$setGlassUpdateState$1> continuation) {
        super(2, continuation);
        this.$updateState = glassUpdateState;
        this.$needNotify = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassUpdateHelper$setGlassUpdateState$1(this.$updateState, this.$needNotify, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
            glassUpdateHelper.d1("setGlassUpdateState: " + this.$updateState + ", needNotify: " + this.$needNotify);
            if (Intrinsics.areEqual(glassUpdateHelper.M0().getValue(), (Object) this.$updateState)) {
                glassUpdateHelper.d1("setGlassUpdateState, same updateState, ignore");
            } else {
                glassUpdateHelper.M0().setValue(this.$updateState);
            }
            GlassUpdateState glassUpdateState = this.$updateState;
            if (!(glassUpdateState instanceof GlassUpdateState.DownloadFail ? true : glassUpdateState instanceof GlassUpdateState.VerifyFail ? true : glassUpdateState instanceof GlassUpdateState.TransferFail ? true : glassUpdateState instanceof GlassUpdateState.InstallFail ? true : glassUpdateState instanceof GlassUpdateState.UpdateDisconnected ? true : glassUpdateState instanceof GlassUpdateState.GlassUpdateFail)) {
                glassUpdateState = null;
            }
            glassUpdateHelper.B1(glassUpdateState);
            if (this.$needNotify) {
                glassUpdateHelper.g1(this.$updateState);
            }
            GlassUpdateState glassUpdateState2 = this.$updateState;
            if (glassUpdateState2 instanceof GlassUpdateState.TransferFail ? true : glassUpdateState2 instanceof GlassUpdateState.InstallFail ? true : glassUpdateState2 instanceof GlassUpdateState.GlassUpdateFail) {
                glassUpdateHelper.y1(false);
                Job j = GlassUpdateHelper.u;
                if (j != null) {
                    Job.DefaultImpls.a(j, (CancellationException) null, 1, (Object) null);
                }
                GlassUpdateHelper.g.setValue((Object) null);
            } else if (glassUpdateState2 instanceof GlassUpdateState.GlassUpdateIdle) {
                glassUpdateHelper.y1(false);
                Job j2 = GlassUpdateHelper.u;
                if (j2 != null) {
                    Job.DefaultImpls.a(j2, (CancellationException) null, 1, (Object) null);
                }
                GlassUpdateHelper.g.setValue((Object) null);
            } else if (glassUpdateState2 instanceof GlassUpdateState.GlassUpdateSuccess) {
                glassUpdateHelper.y1(false);
                Job j3 = GlassUpdateHelper.u;
                if (j3 != null) {
                    Job.DefaultImpls.a(j3, (CancellationException) null, 1, (Object) null);
                }
                GlassUpdateHelper.g.setValue((Object) null);
                glassUpdateHelper.l0();
                GlassUpdateHelper.i0(glassUpdateHelper, 0, false, 3, (Object) null);
            } else if (glassUpdateState2 instanceof GlassUpdateState.Installing) {
                glassUpdateHelper.y1(true);
                glassUpdateHelper.n1(((GlassUpdateState.Installing) this.$updateState).getGlassUpdateInfo().getLatestVersion(), ((GlassUpdateState.Installing) this.$updateState).getGlassUpdateInfo().getDigest(), ((GlassUpdateState.Installing) this.$updateState).getUid());
            } else if (glassUpdateState2 instanceof GlassUpdateState.AirTransferring) {
                glassUpdateHelper.n1(((GlassUpdateState.AirTransferring) glassUpdateState2).getGlassUpdateInfo().getLatestVersion(), ((GlassUpdateState.AirTransferring) this.$updateState).getGlassUpdateInfo().getDigest(), ((GlassUpdateState.AirTransferring) this.$updateState).getUid());
            } else if (glassUpdateState2 instanceof GlassUpdateState.StarTransferring) {
                glassUpdateHelper.n1(((GlassUpdateState.StarTransferring) glassUpdateState2).getGlassUpdateInfo().getLatestVersion(), ((GlassUpdateState.StarTransferring) this.$updateState).getGlassUpdateInfo().getDigest(), ((GlassUpdateState.StarTransferring) this.$updateState).getUid());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateHelper$setGlassUpdateState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
