package com.xjsd.xr.sapp.asr;

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

@SourceDebugExtension({"SMAP\nUnifiedAsrHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnifiedAsrHelper.kt\ncom/xjsd/xr/sapp/asr/UnifiedAsrHelper$reconnectRequest$1\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1787:1\n215#2,2:1788\n*S KotlinDebug\n*F\n+ 1 UnifiedAsrHelper.kt\ncom/xjsd/xr/sapp/asr/UnifiedAsrHelper$reconnectRequest$1\n*L\n346#1:1788,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.xr.sapp.asr.UnifiedAsrHelper$reconnectRequest$1", f = "UnifiedAsrHelper.kt", i = {0, 0, 1, 1}, l = {357, 365}, m = "invokeSuspend", n = {"tempRemoteConfig", "tempProximalConfig", "tempRemoteConfig", "tempProximalConfig"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class UnifiedAsrHelper$reconnectRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isNeedCallBack;
    final /* synthetic */ int $reconnectMark;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ UnifiedAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnifiedAsrHelper$reconnectRequest$1(boolean z, UnifiedAsrHelper unifiedAsrHelper, int i, Continuation<? super UnifiedAsrHelper$reconnectRequest$1> continuation) {
        super(2, continuation);
        this.$isNeedCallBack = z;
        this.this$0 = unifiedAsrHelper;
        this.$reconnectMark = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UnifiedAsrHelper$reconnectRequest$1(this.$isNeedCallBack, this.this$0, this.$reconnectMark, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x013a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            java.lang.String r2 = ", proximal="
            r3 = 2
            java.lang.String r4 = "UnifiedAsrHelper"
            r5 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 == r5) goto L_0x0029
            if (r1 != r3) goto L_0x0021
            java.lang.Object r0 = r13.L$1
            com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r0 = (com.xjsd.xr.sapp.asr.dao.AsrRequestConfig) r0
            java.lang.Object r1 = r13.L$0
            com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r1 = (com.xjsd.xr.sapp.asr.dao.AsrRequestConfig) r1
            kotlin.ResultKt.throwOnFailure(r14)
            r8 = r0
            r7 = r1
            goto L_0x00fa
        L_0x0021:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0029:
            java.lang.Object r1 = r13.L$1
            com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r1 = (com.xjsd.xr.sapp.asr.dao.AsrRequestConfig) r1
            java.lang.Object r6 = r13.L$0
            com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r6 = (com.xjsd.xr.sapp.asr.dao.AsrRequestConfig) r6
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = r6
            goto L_0x00ac
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r14)
            boolean r14 = r13.$isNeedCallBack
            if (r14 == 0) goto L_0x0061
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r14 = r13.this$0
            java.util.Map r14 = r14.mCallbackMap
            java.util.Set r14 = r14.entrySet()
            java.util.Iterator r14 = r14.iterator()
        L_0x004b:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x0061
            java.lang.Object r1 = r14.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r1 = r1.getValue()
            com.xjsd.xr.sapp.asr.callback.AsrResultCallback r1 = (com.xjsd.xr.sapp.asr.callback.AsrResultCallback) r1
            r1.onAsrReconnectStart()
            goto L_0x004b
        L_0x0061:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r1 = "1. reconnectRequest remote="
            r14.append(r1)
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r1 = r13.this$0
            com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r1 = r1.mRemoteAsrRequestConfig
            r14.append(r1)
            r14.append(r2)
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r1 = r13.this$0
            com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r1 = r1.mProximalAsrRequestConfig
            r14.append(r1)
            java.lang.String r14 = r14.toString()
            com.xjsd.xr.sapp.asr.utils.UlogExtKt.logI(r14, r4)
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r14 = r13.this$0
            com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r1 = r14.mRemoteAsrRequestConfig
            com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r14 = r14.getReconnectAsrRequestConfig(r1)
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r1 = r13.this$0
            com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r6 = r1.mProximalAsrRequestConfig
            com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r1 = r1.getReconnectAsrRequestConfig(r6)
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r6 = r13.this$0
            int r7 = r13.$reconnectMark
            r13.L$0 = r14
            r13.L$1 = r1
            r13.label = r5
            java.lang.Object r6 = r6.reconnectToStopRequest(r7, r13)
            if (r6 != r0) goto L_0x00ac
            return r0
        L_0x00ac:
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r6 = r13.this$0
            r6.mRemoteAsrRequestConfig = r14
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r6 = r13.this$0
            r6.mProximalAsrRequestConfig = r1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "2. reconnectRequest remote="
            r6.append(r7)
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r7 = r13.this$0
            com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r7 = r7.mRemoteAsrRequestConfig
            r6.append(r7)
            r6.append(r2)
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r2 = r13.this$0
            com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r2 = r2.mProximalAsrRequestConfig
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            com.xjsd.xr.sapp.asr.utils.UlogExtKt.logI(r2, r4)
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r2 = r13.this$0
            java.util.concurrent.atomic.AtomicBoolean r2 = r2.mIsExecutingReconnectDelay
            r2.set(r5)
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r2 = r13.this$0
            long r6 = r2.getReconnectTime()
            r13.L$0 = r14
            r13.L$1 = r1
            r13.label = r3
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.b(r6, r13)
            if (r2 != r0) goto L_0x00f8
            return r0
        L_0x00f8:
            r7 = r14
            r8 = r1
        L_0x00fa:
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r14 = r13.this$0
            java.util.concurrent.atomic.AtomicBoolean r14 = r14.mIsExecutingReconnectDelay
            r0 = 0
            r14.set(r0)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r1 = "reconnectRequest mIsUserClosedSocket="
            r14.append(r1)
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r1 = r13.this$0
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.mIsUserClosedSocket
            boolean r1 = r1.get()
            r14.append(r1)
            java.lang.String r14 = r14.toString()
            com.xjsd.xr.sapp.asr.utils.UlogExtKt.logI(r14, r4)
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r14 = r13.this$0
            java.util.concurrent.atomic.AtomicBoolean r14 = r14.mIsUserClosedSocket
            boolean r14 = r14.get()
            if (r14 == 0) goto L_0x013a
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r13 = r13.this$0
            java.util.concurrent.atomic.AtomicBoolean r13 = r13.mIsExecutingReconnect
            r13.set(r0)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x013a:
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r14 = r13.this$0
            r14.mIsAutoReconnecting = r5
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r6 = r13.this$0
            r11 = 8
            r12 = 0
            r9 = 1
            r10 = 0
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper.startRequest$default(r6, r7, r8, r9, r10, r11, r12)
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r13 = r13.this$0
            java.util.concurrent.atomic.AtomicBoolean r13 = r13.mIsExecutingReconnect
            r13.set(r0)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.UnifiedAsrHelper$reconnectRequest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UnifiedAsrHelper$reconnectRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
