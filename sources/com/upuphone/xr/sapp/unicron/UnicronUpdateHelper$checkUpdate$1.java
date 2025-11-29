package com.upuphone.xr.sapp.unicron;

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
@DebugMetadata(c = "com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$checkUpdate$1", f = "UnicronUpdateHelper.kt", i = {}, l = {249, 268, 280}, m = "invokeSuspend", n = {}, s = {})
public final class UnicronUpdateHelper$checkUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnicronUpdateHelper$checkUpdate$1(long j, Continuation<? super UnicronUpdateHelper$checkUpdate$1> continuation) {
        super(2, continuation);
        this.$delayTime = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UnicronUpdateHelper$checkUpdate$1(this.$delayTime, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0094  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0029
            if (r1 == r4) goto L_0x0025
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x009d
        L_0x0016:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ Exception -> 0x0022 }
            goto L_0x0074
        L_0x0022:
            r11 = move-exception
            goto L_0x00a0
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0037
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r12)
            long r5 = r11.$delayTime
            r11.label = r4
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r5, r11)
            if (r12 != r0) goto L_0x0037
            return r0
        L_0x0037:
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper r12 = com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.b
            java.lang.String r1 = "checkUpdate, start"
            r12.L(r1)
            com.upuphone.xr.sapp.glass.GlassHelper r1 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a
            com.upuphone.xr.interconnect.entity.StarryNetDevice r1 = r1.y()
            if (r1 != 0) goto L_0x0051
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.d = r4
            java.lang.String r11 = "checkUpdate, connectedGlass is null"
            r12.L(r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0051:
            boolean r1 = r12.y(r1)
            if (r1 != 0) goto L_0x005f
            java.lang.String r11 = "checkUpdate, isGlassSupportUnicronUpdate=false"
            r12.L(r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x005f:
            java.lang.String r1 = "checkUpdate, getUnicronInfo start"
            r12.L(r1)
            com.upuphone.xr.sapp.unicron.UnicronHelper r5 = com.upuphone.xr.sapp.unicron.UnicronHelper.f7834a     // Catch:{ Exception -> 0x0022 }
            r11.label = r3     // Catch:{ Exception -> 0x0022 }
            r6 = 0
            r9 = 1
            r10 = 0
            r8 = r11
            java.lang.Object r12 = com.upuphone.xr.sapp.unicron.UnicronHelper.h(r5, r6, r8, r9, r10)     // Catch:{ Exception -> 0x0022 }
            if (r12 != r0) goto L_0x0074
            return r0
        L_0x0074:
            com.upuphone.xr.sapp.entity.UnicronInfo r12 = (com.upuphone.xr.sapp.entity.UnicronInfo) r12     // Catch:{ Exception -> 0x0022 }
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper r1 = com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "checkUpdate, unicronInfo: "
            r3.append(r5)
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            r1.L(r3)
            if (r12 != 0) goto L_0x0094
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.d = r4
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0094:
            r11.label = r2
            java.lang.Object r11 = r1.D(r12, r11)
            if (r11 != r0) goto L_0x009d
            return r0
        L_0x009d:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00a0:
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper r12 = com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "checkUpdate, getUnicronInfo-error: "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r12.M(r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$checkUpdate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UnicronUpdateHelper$checkUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
