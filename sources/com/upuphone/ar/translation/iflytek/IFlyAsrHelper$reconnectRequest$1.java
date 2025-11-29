package com.upuphone.ar.translation.iflytek;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nIFlyAsrHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IFlyAsrHelper.kt\ncom/upuphone/ar/translation/iflytek/IFlyAsrHelper$reconnectRequest$1\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1396:1\n215#2,2:1397\n*S KotlinDebug\n*F\n+ 1 IFlyAsrHelper.kt\ncom/upuphone/ar/translation/iflytek/IFlyAsrHelper$reconnectRequest$1\n*L\n491#1:1397,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.iflytek.IFlyAsrHelper$reconnectRequest$1", f = "IFlyAsrHelper.kt", i = {0, 0, 1, 1}, l = {502, 510}, m = "invokeSuspend", n = {"tempRemoteConfig", "tempProximalConfig", "tempRemoteConfig", "tempProximalConfig"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class IFlyAsrHelper$reconnectRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isNeedCallBack;
    final /* synthetic */ int $reconnectMark;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ IFlyAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IFlyAsrHelper$reconnectRequest$1(boolean z, IFlyAsrHelper iFlyAsrHelper, int i, Continuation<? super IFlyAsrHelper$reconnectRequest$1> continuation) {
        super(2, continuation);
        this.$isNeedCallBack = z;
        this.this$0 = iFlyAsrHelper;
        this.$reconnectMark = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IFlyAsrHelper$reconnectRequest$1(this.$isNeedCallBack, this.this$0, this.$reconnectMark, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0130  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            java.lang.String r2 = ", proximal="
            r3 = 2
            java.lang.String r4 = "IFlyAsrHelper"
            r5 = 1
            if (r1 == 0) goto L_0x0034
            if (r1 == r5) goto L_0x0027
            if (r1 != r3) goto L_0x001f
            java.lang.Object r0 = r10.L$1
            com.upuphone.ar.translation.iflytek.entity.TransConfig r0 = (com.upuphone.ar.translation.iflytek.entity.TransConfig) r0
            java.lang.Object r1 = r10.L$0
            com.upuphone.ar.translation.iflytek.entity.TransConfig r1 = (com.upuphone.ar.translation.iflytek.entity.TransConfig) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00f0
        L_0x001f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0027:
            java.lang.Object r1 = r10.L$1
            com.upuphone.ar.translation.iflytek.entity.TransConfig r1 = (com.upuphone.ar.translation.iflytek.entity.TransConfig) r1
            java.lang.Object r6 = r10.L$0
            com.upuphone.ar.translation.iflytek.entity.TransConfig r6 = (com.upuphone.ar.translation.iflytek.entity.TransConfig) r6
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r6
            goto L_0x00a2
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r11)
            boolean r11 = r10.$isNeedCallBack
            if (r11 == 0) goto L_0x005f
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r11 = r10.this$0
            java.util.Map r11 = r11.b
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x0049:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r11.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r1 = r1.getValue()
            com.upuphone.ar.translation.iflytek.listener.TranslateMsgListener r1 = (com.upuphone.ar.translation.iflytek.listener.TranslateMsgListener) r1
            r1.onAsrReconnectStart()
            goto L_0x0049
        L_0x005f:
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r11 = r10.this$0
            com.upuphone.ar.translation.iflytek.entity.TransConfig r11 = r11.f
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r1 = r10.this$0
            com.upuphone.ar.translation.iflytek.entity.TransConfig r1 = r1.l
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "1. reconnectRequest remote="
            r6.append(r7)
            r6.append(r11)
            r6.append(r2)
            r6.append(r1)
            java.lang.String r11 = r6.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r11, r4)
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r11 = r10.this$0
            com.upuphone.ar.translation.iflytek.entity.TransConfig r11 = r11.f
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r1 = r10.this$0
            com.upuphone.ar.translation.iflytek.entity.TransConfig r1 = r1.l
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r6 = r10.this$0
            int r7 = r10.$reconnectMark
            r10.L$0 = r11
            r10.L$1 = r1
            r10.label = r5
            java.lang.Object r6 = r6.n0(r7, r10)
            if (r6 != r0) goto L_0x00a2
            return r0
        L_0x00a2:
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r6 = r10.this$0
            r6.f = r11
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r6 = r10.this$0
            r6.l = r1
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r6 = r10.this$0
            com.upuphone.ar.translation.iflytek.entity.TransConfig r6 = r6.f
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r7 = r10.this$0
            com.upuphone.ar.translation.iflytek.entity.TransConfig r7 = r7.l
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "2. reconnectRequest remote="
            r8.append(r9)
            r8.append(r6)
            r8.append(r2)
            r8.append(r7)
            java.lang.String r2 = r8.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r2, r4)
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r2 = r10.this$0
            java.util.concurrent.atomic.AtomicBoolean r2 = r2.v
            r2.set(r5)
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r2 = r10.this$0
            long r6 = r2.T()
            r10.L$0 = r11
            r10.L$1 = r1
            r10.label = r3
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.b(r6, r10)
            if (r2 != r0) goto L_0x00ee
            return r0
        L_0x00ee:
            r0 = r1
            r1 = r11
        L_0x00f0:
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r11 = r10.this$0
            java.util.concurrent.atomic.AtomicBoolean r11 = r11.v
            r2 = 0
            r11.set(r2)
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r11 = r10.this$0
            java.util.concurrent.atomic.AtomicBoolean r11 = r11.q
            boolean r11 = r11.get()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "reconnectRequest mIsUserClosedSocket="
            r3.append(r6)
            r3.append(r11)
            java.lang.String r11 = r3.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r11, r4)
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r11 = r10.this$0
            java.util.concurrent.atomic.AtomicBoolean r11 = r11.q
            boolean r11 = r11.get()
            if (r11 == 0) goto L_0x0130
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r10 = r10.this$0
            java.util.concurrent.atomic.AtomicBoolean r10 = r10.t
            r10.set(r2)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0130:
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r11 = r10.this$0
            r11.r = r5
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r11 = r10.this$0
            r11.w0(r1, r0)
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r10 = r10.this$0
            java.util.concurrent.atomic.AtomicBoolean r10 = r10.t
            r10.set(r2)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.iflytek.IFlyAsrHelper$reconnectRequest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IFlyAsrHelper$reconnectRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
