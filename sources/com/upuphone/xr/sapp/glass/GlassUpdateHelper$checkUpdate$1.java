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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper$checkUpdate$1", f = "GlassUpdateHelper.kt", i = {1, 2, 2}, l = {444, 464, 516}, m = "invokeSuspend", n = {"connectDevice", "connectDevice", "glassInfo"}, s = {"L$0", "L$0", "L$1"})
public final class GlassUpdateHelper$checkUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateHelper$checkUpdate$1(long j, Continuation<? super GlassUpdateHelper$checkUpdate$1> continuation) {
        super(2, continuation);
        this.$delayTime = j;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0() {
        GlassUpdateHelper.i0(GlassUpdateHelper.b, 0, false, 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1() {
        GlassUpdateHelper.i0(GlassUpdateHelper.b, 0, false, 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$2() {
        GlassUpdateHelper.i0(GlassUpdateHelper.b, 0, false, 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$3() {
        GlassUpdateHelper.i0(GlassUpdateHelper.b, 0, false, 3, (Object) null);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassUpdateHelper$checkUpdate$1(this.$delayTime, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0205  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r29) {
        /*
            r28 = this;
            r0 = r28
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 1
            r5 = 2
            java.lang.String r6 = "GlassUpdateHelper"
            r7 = 0
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x003c
            if (r2 == r5) goto L_0x002e
            if (r2 != r3) goto L_0x0026
            java.lang.Object r1 = r0.L$1
            com.upuphone.xr.sapp.entity.BasicGlassInfo r1 = (com.upuphone.xr.sapp.entity.BasicGlassInfo) r1
            java.lang.Object r0 = r0.L$0
            com.upuphone.xr.interconnect.entity.StarryNetDevice r0 = (com.upuphone.xr.interconnect.entity.StarryNetDevice) r0
            kotlin.ResultKt.throwOnFailure(r29)
            r8 = r0
            r0 = r29
            goto L_0x01bf
        L_0x0026:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002e:
            java.lang.Object r2 = r0.L$0
            com.upuphone.xr.interconnect.entity.StarryNetDevice r2 = (com.upuphone.xr.interconnect.entity.StarryNetDevice) r2
            kotlin.ResultKt.throwOnFailure(r29)     // Catch:{ Exception -> 0x0039 }
            r8 = r2
            r2 = r29
            goto L_0x0098
        L_0x0039:
            r0 = move-exception
            goto L_0x0279
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r29)
            goto L_0x004e
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r29)
            long r8 = r0.$delayTime
            r0.label = r4
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.b(r8, r0)
            if (r2 != r1) goto L_0x004e
            return r1
        L_0x004e:
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r8 = "checkUpdate, start"
            r2.a(r6, r8)
            com.upuphone.xr.sapp.glass.GlassHelper r8 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a
            com.upuphone.xr.interconnect.entity.StarryNetDevice r8 = r8.x()
            if (r8 != 0) goto L_0x007d
            java.lang.String r0 = "checkUpdate, connectDevice is null"
            r2.a(r6, r0)
            java.util.concurrent.CopyOnWriteArraySet r0 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.m
            com.upuphone.xr.sapp.glass.c r1 = new com.upuphone.xr.sapp.glass.c
            r1.<init>()
            r0.add(r1)
            androidx.lifecycle.MutableLiveData r0 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.c
            com.upuphone.xr.sapp.entity.GlassCheckUpdateState$Error r1 = new com.upuphone.xr.sapp.entity.GlassCheckUpdateState$Error
            r1.<init>(r5, r7, r5, r7)
            r0.setValue(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x007d:
            androidx.lifecycle.MutableLiveData r9 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.c
            com.upuphone.xr.sapp.entity.GlassCheckUpdateState$Loading r10 = com.upuphone.xr.sapp.entity.GlassCheckUpdateState.Loading.INSTANCE
            r9.setValue(r10)
            java.lang.String r9 = "checkUpdate, getGlassInfo start"
            r2.a(r6, r9)
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r2 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b     // Catch:{ Exception -> 0x0039 }
            r0.L$0 = r8     // Catch:{ Exception -> 0x0039 }
            r0.label = r5     // Catch:{ Exception -> 0x0039 }
            java.lang.Object r2 = r2.l(r8, r0)     // Catch:{ Exception -> 0x0039 }
            if (r2 != r1) goto L_0x0098
            return r1
        L_0x0098:
            com.upuphone.xr.sapp.entity.BasicGlassInfo r2 = (com.upuphone.xr.sapp.entity.BasicGlassInfo) r2     // Catch:{ Exception -> 0x0039 }
            if (r2 != 0) goto L_0x00be
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "checkUpdate, glassInfo is null"
            r0.c(r6, r1)
            java.util.concurrent.CopyOnWriteArraySet r0 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.m
            com.upuphone.xr.sapp.glass.e r1 = new com.upuphone.xr.sapp.glass.e
            r1.<init>()
            r0.add(r1)
            androidx.lifecycle.MutableLiveData r0 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.c
            com.upuphone.xr.sapp.entity.GlassCheckUpdateState$Error r1 = new com.upuphone.xr.sapp.entity.GlassCheckUpdateState$Error
            r1.<init>(r3, r7, r5, r7)
            r0.setValue(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00be:
            androidx.lifecycle.MutableLiveData r9 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.y
            r9.postValue(r2)
            com.upuphone.xr.sapp.utils.NetworkUtils r9 = com.upuphone.xr.sapp.utils.NetworkUtils.f7898a
            boolean r9 = r9.g()
            if (r9 != 0) goto L_0x00ef
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "checkUpdate, hasNetwork = false"
            r0.a(r6, r1)
            java.util.concurrent.CopyOnWriteArraySet r0 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.C
            com.upuphone.xr.sapp.glass.f r1 = new com.upuphone.xr.sapp.glass.f
            r1.<init>()
            r0.add(r1)
            androidx.lifecycle.MutableLiveData r0 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.c
            com.upuphone.xr.sapp.entity.GlassCheckUpdateState$Error r1 = new com.upuphone.xr.sapp.entity.GlassCheckUpdateState$Error
            r1.<init>(r4, r7, r5, r7)
            r0.setValue(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00ef:
            com.upuphone.xr.sapp.context.SdkContext r5 = com.upuphone.xr.sapp.context.SdkContext.f6675a
            com.upuphone.xr.sapp.context.AppContext r5 = r5.c()
            boolean r5 = r5.e()
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r9 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "checkUpdate start, glassInfo: "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.d1(r10)
            java.lang.String r16 = com.upuphone.xr.sapp.entity.BasicGlassInfoKt.getSafeBuildType(r2)
            java.lang.String r17 = com.upuphone.xr.sapp.entity.BasicGlassInfoKt.getSafeVersionType(r2)
            java.lang.String r15 = com.upuphone.xr.sapp.entity.BasicGlassInfoKt.getSafeSubModel(r2)
            com.upuphone.xr.sapp.utils.DataTrackUtil r10 = com.upuphone.xr.sapp.utils.DataTrackUtil.f7875a
            java.lang.String r11 = r2.getSerial()
            java.lang.String r13 = r10.f(r11)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "checkUpdate start, deviceIdEncrypted: "
            r10.append(r11)
            r10.append(r4)
            java.lang.String r4 = ", deviceId: "
            r10.append(r4)
            r10.append(r13)
            java.lang.String r4 = r10.toString()
            r9.d1(r4)
            com.upuphone.xr.sapp.utils.AppUtils r4 = com.upuphone.xr.sapp.utils.AppUtils.f7842a
            android.content.Context r10 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()
            kotlin.Pair r4 = r4.g(r10)
            java.lang.Object r10 = r4.component1()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r4 = r4.component2()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "checkUpdate start, isIntl: "
            r11.append(r12)
            r11.append(r5)
            java.lang.String r5 = ", lang: "
            r11.append(r5)
            r11.append(r10)
            java.lang.String r5 = ", country: "
            r11.append(r5)
            r11.append(r4)
            java.lang.String r5 = r11.toString()
            r9.d1(r5)
            com.upuphone.star.fota.phone.GlassUpdateApiManager r5 = com.upuphone.star.fota.phone.GlassUpdateApiManager.f6471a
            java.lang.String r12 = r2.getModel()
            java.lang.String r14 = r2.getRomVersion()
            long r18 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r10)
            java.lang.String r10 = "_"
            r9.append(r10)
            r9.append(r4)
            java.lang.String r20 = r9.toString()
            com.upuphone.star.fota.phone.CheckGlassUpdateParamV2 r4 = new com.upuphone.star.fota.phone.CheckGlassUpdateParamV2
            r11 = r4
            r26 = 4096(0x1000, float:5.74E-42)
            r27 = 0
            java.lang.String r21 = "2.40.51"
            r22 = 0
            r23 = 0
            r24 = 1
            r25 = 0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27)
            r0.L$0 = r8
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r0 = r5.d(r4, r0)
            if (r0 != r1) goto L_0x01be
            return r1
        L_0x01be:
            r1 = r2
        L_0x01bf:
            com.upuphone.star.fota.phone.GlassCheckUpdateResult r0 = (com.upuphone.star.fota.phone.GlassCheckUpdateResult) r0
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "checkUpdate result: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r2.a(r6, r3)
            androidx.lifecycle.MutableLiveData r3 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.c
            com.upuphone.xr.sapp.entity.GlassCheckUpdateState$Result r4 = new com.upuphone.xr.sapp.entity.GlassCheckUpdateState$Result
            kotlin.Pair r5 = kotlin.TuplesKt.to(r1, r0)
            r4.<init>(r5)
            r3.setValue(r4)
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r3 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b
            r3.k1()
            com.upuphone.star.fota.phone.GlassUpdateInfo r0 = com.upuphone.star.fota.phone.GlassCheckUpdateResultKt.b(r0)     // Catch:{ Exception -> 0x025e }
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r0)
            com.upuphone.xr.sapp.glass.GlassUpdateHelper.w = r1
            boolean r1 = r0.getExistsUpdate()
            r4 = 0
            if (r1 != 0) goto L_0x0205
            r3.u1(r7, r4)
            r3.l0()
            goto L_0x025b
        L_0x0205:
            com.upuphone.xr.sapp.entity.GlassUpdateState r1 = r3.L0()
            boolean r1 = r1 instanceof com.upuphone.xr.sapp.entity.GlassUpdateState.GlassUpdateSuccess
            if (r1 == 0) goto L_0x0215
            java.lang.String r1 = "checkUpdate, clear GlassUpdateSuccess"
            r2.a(r6, r1)
            r3.u1(r7, r4)
        L_0x0215:
            r3.a0(r0)
            boolean r1 = r3.b1()
            if (r1 != 0) goto L_0x0258
            com.upuphone.xr.sapp.air.AirHelper r1 = com.upuphone.xr.sapp.air.AirHelper.b
            boolean r1 = r1.I(r8)
            if (r1 != 0) goto L_0x0258
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = r0.getDigest()
            if (r2 == 0) goto L_0x0255
            com.upuphone.star.download.manager.Utils r4 = com.upuphone.star.download.manager.Utils.f6462a
            android.content.Context r5 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r2 = ".zip"
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            java.lang.String r6 = "glass_ota"
            java.io.File r2 = r4.a(r5, r6, r2)
            boolean r2 = r1.add(r2)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
        L_0x0255:
            r3.m0(r1)
        L_0x0258:
            r3.e0(r0)
        L_0x025b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x025e:
            r0 = move-exception
            r1 = r0
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r0 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "checkUpdate, updateResult error: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.e1(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0279:
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "checkUpdate, getGlassInfo-error: "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.c(r6, r0)
            java.util.concurrent.CopyOnWriteArraySet r0 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.m
            com.upuphone.xr.sapp.glass.d r1 = new com.upuphone.xr.sapp.glass.d
            r1.<init>()
            r0.add(r1)
            androidx.lifecycle.MutableLiveData r0 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.c
            com.upuphone.xr.sapp.entity.GlassCheckUpdateState$Error r1 = new com.upuphone.xr.sapp.entity.GlassCheckUpdateState$Error
            r1.<init>(r3, r7, r5, r7)
            r0.setValue(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassUpdateHelper$checkUpdate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateHelper$checkUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
