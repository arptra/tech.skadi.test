package com.upuphone.xr.sapp.glass;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper$checkUpdateStateResult$1", f = "GlassUpdateHelper.kt", i = {}, l = {604, 610}, m = "invokeSuspend", n = {}, s = {})
public final class GlassUpdateHelper$checkUpdateStateResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateHelper$checkUpdateStateResult$1(long j, Continuation<? super GlassUpdateHelper$checkUpdateStateResult$1> continuation) {
        super(2, continuation);
        this.$delayTime = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassUpdateHelper$checkUpdateStateResult$1(this.$delayTime, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0051
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x002c
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r7)
            long r4 = r6.$delayTime
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r4, r6)
            if (r7 != r0) goto L_0x002c
            return r0
        L_0x002c:
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r7 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b
            boolean r7 = r7.Q0()
            if (r7 != 0) goto L_0x0040
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r7 = "GlassUpdateHelper"
            java.lang.String r0 = "checkUpdateStateResult, needCheckGlassUpdateResult=false, return"
            r6.a(r7, r0)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0040:
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r7 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b
            com.upuphone.xr.sapp.glass.GlassHelper r1 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a
            com.upuphone.xr.interconnect.entity.StarryNetDevice r1 = r1.x()
            r6.label = r2
            java.lang.Object r7 = r7.h(r1, r6)
            if (r7 != r0) goto L_0x0051
            return r0
        L_0x0051:
            com.upuphone.xr.sapp.entity.GlassUpdateState r7 = (com.upuphone.xr.sapp.entity.GlassUpdateState) r7
            if (r7 == 0) goto L_0x006e
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r6 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "fetchGlassUpdateState, result: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r6.d1(r0)
            r6.v1(r7)
        L_0x006e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassUpdateHelper$checkUpdateStateResult$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateHelper$checkUpdateStateResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
