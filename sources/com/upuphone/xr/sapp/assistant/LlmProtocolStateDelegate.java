package com.upuphone.xr.sapp.assistant;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.AIModelResult;
import com.upuphone.xr.sapp.tips.TipsKey;
import com.upuphone.xr.sapp.tips.TipsManager;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.HttpRequestUtil;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\u0018\u0000 12\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H@¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\u0003J\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010\u0012J\u0010\u0010#\u001a\u00020\u0004H@¢\u0006\u0004\b#\u0010\u0006J\u000f\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b&\u0010\u0010J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b'\u0010\u0012J\"\u0010(\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\rH@¢\u0006\u0004\b(\u0010)R\u001b\u0010-\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010%R\u001b\u00100\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010%¨\u00063"}, d2 = {"Lcom/upuphone/xr/sapp/assistant/LlmProtocolStateDelegate;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/entity/AIModelResult;", "p", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "xjAccountId", "j", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "u", "", "action", "r", "(I)Lcom/upuphone/xr/sapp/entity/AIModelResult;", "w", "(I)V", "l", "()I", "", "time", "y", "(J)V", "m", "()J", "", "hasSync", "x", "(Z)V", "o", "()Z", "status", "h", "q", "i", "()Lcom/upuphone/xr/sapp/entity/AIModelResult;", "s", "v", "t", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lkotlin/Lazy;", "n", "timeoutAiState", "b", "k", "errorAiState", "c", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nLlmProtocolStateDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LlmProtocolStateDelegate.kt\ncom/upuphone/xr/sapp/assistant/LlmProtocolStateDelegate\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,255:1\n314#2,11:256\n314#2,11:267\n*S KotlinDebug\n*F\n+ 1 LlmProtocolStateDelegate.kt\ncom/upuphone/xr/sapp/assistant/LlmProtocolStateDelegate\n*L\n142#1:256,11\n227#1:267,11\n*E\n"})
public final class LlmProtocolStateDelegate {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f6637a = LazyKt.lazy(LlmProtocolStateDelegate$timeoutAiState$2.INSTANCE);
    public final Lazy b = LazyKt.lazy(LlmProtocolStateDelegate$errorAiState$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/assistant/LlmProtocolStateDelegate$Companion;", "", "()V", "LOCAL_AI_AUTH_STATE", "", "LOCAL_AI_AUTH_STATE_SYNC_FLAG", "LOCAL_AI_AUTH_STATE_SYNC_TIME", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final void h(int i) {
        if (i == Integer.parseInt("1")) {
            TipsManager.f7827a.d(TipsKey.TIPS_PRIVACY_AI);
        }
    }

    public final AIModelResult i() {
        int l = l();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("LlmProtocolStateDelegate", "getAiStateFromLocal: state->" + l);
        return new AIModelResult(true, Integer.parseInt(l == 1 ? "1" : "2"), true);
    }

    public final Object j(String str, Continuation continuation) {
        if (str == null) {
            return k();
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        HttpRequestUtil.f7890a.w(str, new LlmProtocolStateDelegate$getAiStateFromServer$2$1(cancellableContinuationImpl, this));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public final AIModelResult k() {
        return (AIModelResult) this.b.getValue();
    }

    public final int l() {
        return ((Number) DataStoreUtils.j(DataStoreUtils.e.a(), "LOCAL_AI_MODEL", 2, true, (Context) null, 8, (Object) null)).intValue();
    }

    public final long m() {
        return ((Number) DataStoreUtils.j(DataStoreUtils.e.a(), "LOCAL_AI_MODEL_TIME", -1L, true, (Context) null, 8, (Object) null)).longValue();
    }

    public final AIModelResult n() {
        return (AIModelResult) this.f6637a.getValue();
    }

    public final boolean o() {
        return ((Boolean) DataStoreUtils.j(DataStoreUtils.e.a(), "aiAuthStateSyncFlag", Boolean.FALSE, true, (Context) null, 8, (Object) null)).booleanValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object p(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate$requestAiState$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate$requestAiState$1 r0 = (com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate$requestAiState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate$requestAiState$1 r0 = new com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate$requestAiState$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004a
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            com.upuphone.xr.sapp.utils.NetworkUtils r5 = com.upuphone.xr.sapp.utils.NetworkUtils.f7898a
            boolean r5 = r5.g()
            if (r5 != 0) goto L_0x0041
            com.upuphone.xr.sapp.entity.AIModelResult r4 = r4.i()
            goto L_0x004d
        L_0x0041:
            r0.label = r3
            java.lang.Object r5 = r4.q(r0)
            if (r5 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r4 = r5
            com.upuphone.xr.sapp.entity.AIModelResult r4 = (com.upuphone.xr.sapp.entity.AIModelResult) r4
        L_0x004d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate.p(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object q(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate$requestAiState2$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate$requestAiState2$1 r0 = (com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate$requestAiState2$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate$requestAiState2$1 r0 = new com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate$requestAiState2$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "LlmProtocolStateDelegate"
            r4 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            java.lang.Object r9 = r0.L$1
            com.upuphone.xr.sapp.entity.AIModelResult r9 = (com.upuphone.xr.sapp.entity.AIModelResult) r9
            java.lang.Object r0 = r0.L$0
            com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate r0 = (com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0075
        L_0x0033:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r10)
            com.upuphone.xr.sapp.entity.AIModelResult r10 = r9.i()
            int r2 = r10.getState()
            java.lang.String r5 = "1"
            int r5 = java.lang.Integer.parseInt(r5)
            if (r2 != r5) goto L_0x0056
            com.upuphone.star.core.log.ULog$Delegate r9 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = "requestAiState2: 本地已同意大模型协议，直接返回"
            r9.a(r3, r0)
            return r10
        L_0x0056:
            com.upuphone.xr.sapp.common.MzAccountManager$Companion r2 = com.upuphone.xr.sapp.common.MzAccountManager.c
            com.upuphone.xr.sapp.entity.AccountInfo r2 = r2.a()
            com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate$requestAiState2$result$1 r5 = new com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate$requestAiState2$result$1
            r6 = 0
            r5.<init>(r9, r2, r6)
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r4
            r6 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r0 = kotlinx.coroutines.TimeoutKt.d(r6, r5, r0)
            if (r0 != r1) goto L_0x0071
            return r1
        L_0x0071:
            r8 = r0
            r0 = r9
            r9 = r10
            r10 = r8
        L_0x0075:
            com.upuphone.xr.sapp.entity.AIModelResult r10 = (com.upuphone.xr.sapp.entity.AIModelResult) r10
            if (r10 == 0) goto L_0x00b1
            int r1 = r10.getState()
            if (r1 >= 0) goto L_0x0080
            goto L_0x00b1
        L_0x0080:
            int r1 = r10.getState()
            int r2 = r9.getState()
            if (r1 == r2) goto L_0x00b0
            long r1 = r0.m()
            r4 = -1
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x009c
            com.upuphone.star.core.log.ULog$Delegate r9 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = "requestAiState2: 本地未点击过同意或未同意，以云端为主"
            r9.a(r3, r0)
            goto L_0x00b0
        L_0x009c:
            boolean r1 = r0.o()
            if (r1 == 0) goto L_0x00b1
            int r9 = r10.getState()
            r0.w(r9)
            int r9 = r10.getState()
            r0.h(r9)
        L_0x00b0:
            r9 = r10
        L_0x00b1:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate.q(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final AIModelResult r(int i) {
        AIModelResult s = s(i);
        v(i);
        return s;
    }

    public final AIModelResult s(int i) {
        w(i);
        x(false);
        return new AIModelResult(true, i, true);
    }

    public final Object t(String str, int i, Continuation continuation) {
        if (str == null) {
            return k();
        }
        String str2 = i == 1 ? "1" : "2";
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        HttpRequestUtil.f7890a.y(str, str2, new LlmProtocolStateDelegate$submitAiStateToServer$2$1(cancellableContinuationImpl, this, i));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public final void u() {
        if (!o()) {
            int l = l();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("LlmProtocolStateDelegate", "上报大模型协议授权状态，state->" + l);
            v(l);
        }
    }

    public final void v(int i) {
        if (NetworkUtils.f7898a.g()) {
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new LlmProtocolStateDelegate$syncAiAuthState$1(this, i, (Continuation<? super LlmProtocolStateDelegate$syncAiAuthState$1>) null), 3, (Object) null);
        }
    }

    public final void w(int i) {
        y(System.currentTimeMillis());
        DataStoreUtils.e.a().p("LOCAL_AI_MODEL", Integer.valueOf(i), true);
    }

    public final void x(boolean z) {
        DataStoreUtils.e.a().p("aiAuthStateSyncFlag", Boolean.valueOf(z), true);
    }

    public final void y(long j) {
        DataStoreUtils.e.a().p("LOCAL_AI_MODEL_TIME", Long.valueOf(j), true);
    }
}
