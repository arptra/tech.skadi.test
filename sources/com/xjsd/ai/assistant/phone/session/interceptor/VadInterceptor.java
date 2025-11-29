package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.audio.AudioDataUtil;
import com.xjsd.ai.assistant.cloud.CloudAbility;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.phone.AudioFocusManageDelegate;
import com.xjsd.ai.assistant.phone.session.Session;
import com.xjsd.ai.assistant.phone.vad.OfflineAsrResult;
import com.xjsd.ai.assistant.phone.vad.VadAbility;
import com.xjsd.ai.assistant.phone.vad.VadEventListener;
import com.xjsd.ai.assistant.protocol.notify.VadEventData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u0002:;B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H@¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001aH@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001eH@¢\u0006\u0004\b \u0010!R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010&R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00160(8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010)R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b+\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050(8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010)R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b0\u0010#\u001a\u0004\b1\u0010,R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002030(8\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010)R\u001d\u00108\u001a\b\u0012\u0004\u0012\u0002030\u00048\u0006¢\u0006\f\n\u0004\b6\u0010#\u001a\u0004\b7\u0010,¨\u0006<"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/AbsInterceptor;", "Lcom/xjsd/ai/assistant/phone/session/Session;", "session", "Lkotlinx/coroutines/flow/Flow;", "", "audioSource", "Lcom/xjsd/ai/assistant/phone/vad/VadAbility;", "vadAbility", "Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "cacheAbility", "Lcom/xjsd/ai/assistant/cloud/CloudAbility;", "cloudAbility", "<init>", "(Lcom/xjsd/ai/assistant/phone/session/Session;Lkotlinx/coroutines/flow/Flow;Lcom/xjsd/ai/assistant/phone/vad/VadAbility;Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;Lcom/xjsd/ai/assistant/cloud/CloudAbility;)V", "", "f", "()V", "h", "i", "g", "w", "", "type", "v", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/xjsd/ai/assistant/phone/vad/OfflineAsrResult;", "result", "t", "(Lcom/xjsd/ai/assistant/phone/vad/OfflineAsrResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "text", "u", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "Lkotlinx/coroutines/flow/Flow;", "e", "Lcom/xjsd/ai/assistant/phone/vad/VadAbility;", "Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "Lcom/xjsd/ai/assistant/cloud/CloudAbility;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_vadStateFlow", "s", "()Lkotlinx/coroutines/flow/Flow;", "vadFlow", "j", "_detectFlow", "k", "q", "detectFlow", "Lcom/xjsd/ai/assistant/phone/bean/OfflineAsrBean;", "l", "_offAsrFlow", "m", "r", "offAsrFlow", "n", "Companion", "VadResult", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VadInterceptor extends AbsInterceptor {
    public static final Companion n = new Companion((DefaultConstructorMarker) null);
    public final Flow d;
    public final VadAbility e;
    public final CacheAbility f;
    public final CloudAbility g;
    public final MutableSharedFlow h;
    public final Flow i;
    public final MutableSharedFlow j;
    public final Flow k;
    public final MutableSharedFlow l;
    public final Flow m;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult;", "", "()V", "Detect", "OfflineAsr", "OfflineCmd", "State", "Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult$Detect;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult$OfflineAsr;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult$OfflineCmd;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult$State;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class VadResult {

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult$Detect;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult;", "", "data", "<init>", "([B)V", "a", "[B", "()[B", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Detect extends VadResult {

            /* renamed from: a  reason: collision with root package name */
            public final byte[] f8594a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Detect(byte[] bArr) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(bArr, "data");
                this.f8594a = bArr;
            }

            public final byte[] a() {
                return this.f8594a;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult$OfflineAsr;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult;", "Lcom/xjsd/ai/assistant/phone/vad/OfflineAsrResult;", "result", "<init>", "(Lcom/xjsd/ai/assistant/phone/vad/OfflineAsrResult;)V", "a", "Lcom/xjsd/ai/assistant/phone/vad/OfflineAsrResult;", "()Lcom/xjsd/ai/assistant/phone/vad/OfflineAsrResult;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class OfflineAsr extends VadResult {

            /* renamed from: a  reason: collision with root package name */
            public final OfflineAsrResult f8595a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OfflineAsr(OfflineAsrResult offlineAsrResult) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(offlineAsrResult, "result");
                this.f8595a = offlineAsrResult;
            }

            public final OfflineAsrResult a() {
                return this.f8595a;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult$OfflineCmd;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult;", "", "asr", "<init>", "(Ljava/lang/String;)V", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class OfflineCmd extends VadResult {

            /* renamed from: a  reason: collision with root package name */
            public final String f8596a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OfflineCmd(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "asr");
                this.f8596a = str;
            }

            public final String a() {
                return this.f8596a;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult$State;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult;", "", "state", "<init>", "(I)V", "a", "I", "()I", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class State extends VadResult {

            /* renamed from: a  reason: collision with root package name */
            public final int f8597a;

            public State(int i) {
                super((DefaultConstructorMarker) null);
                this.f8597a = i;
            }

            public final int a() {
                return this.f8597a;
            }
        }

        public /* synthetic */ VadResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public VadResult() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VadInterceptor(Session session, Flow flow, VadAbility vadAbility, CacheAbility cacheAbility, CloudAbility cloudAbility) {
        super(session);
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(flow, "audioSource");
        Intrinsics.checkNotNullParameter(vadAbility, "vadAbility");
        Intrinsics.checkNotNullParameter(cacheAbility, "cacheAbility");
        Intrinsics.checkNotNullParameter(cloudAbility, "cloudAbility");
        this.d = flow;
        this.e = vadAbility;
        this.f = cacheAbility;
        this.g = cloudAbility;
        MutableSharedFlow b = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.h = b;
        this.i = b;
        MutableSharedFlow b2 = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.j = b2;
        this.k = b2;
        MutableSharedFlow b3 = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.l = b3;
        this.m = b3;
    }

    public void f() {
        b(this.d, new VadInterceptor$onCreate$1(this, (Continuation<? super VadInterceptor$onCreate$1>) null));
        w();
    }

    public void g() {
        this.e.stop();
    }

    public void h() {
        this.e.start();
    }

    public void i() {
        this.e.setVadEventListener((VadEventListener) null);
    }

    public final Flow q() {
        return this.k;
    }

    public final Flow r() {
        return this.m;
    }

    public final Flow s() {
        return this.i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t(com.xjsd.ai.assistant.phone.vad.OfflineAsrResult r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor$handleOfflineAsr$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor$handleOfflineAsr$1 r0 = (com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor$handleOfflineAsr$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor$handleOfflineAsr$1 r0 = new com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor$handleOfflineAsr$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            com.xjsd.ai.assistant.phone.bean.OfflineAsrBean r7 = (com.xjsd.ai.assistant.phone.bean.OfflineAsrBean) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00b3
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r9)
            boolean r9 = r8.isFinal()
            java.lang.String r2 = "VadInterceptor"
            if (r9 == 0) goto L_0x0066
            java.lang.String r9 = r8.getOriginalSentence()
            java.lang.String r4 = r8.getSentence()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "offline final asr->"
            r5.append(r6)
            r5.append(r9)
            java.lang.String r9 = "/"
            r5.append(r9)
            r5.append(r4)
            java.lang.String r9 = r5.toString()
            com.xjsd.ai.assistant.log.ILog.a(r2, r9)
            goto L_0x007e
        L_0x0066:
            java.lang.String r9 = r8.getOriginalSentence()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "offline mid asr->"
            r4.append(r5)
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            com.xjsd.ai.assistant.log.ILog.a(r2, r9)
        L_0x007e:
            com.xjsd.ai.assistant.phone.bean.OfflineAsrBean r9 = new com.xjsd.ai.assistant.phone.bean.OfflineAsrBean
            r9.<init>()
            com.xjsd.ai.assistant.phone.session.Session r2 = r7.d()
            java.lang.String r2 = r2.b()
            r9.setId(r2)
            java.lang.String r2 = r8.getOriginalSentence()
            r9.setText(r2)
            java.lang.String r2 = r8.getSentence()
            r9.setCmd(r2)
            boolean r8 = r8.isFinal()
            r9.setType(r8)
            r9.setSource(r3)
            kotlinx.coroutines.flow.MutableSharedFlow r7 = r7.l
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r7 = r7.emit(r9, r0)
            if (r7 != r1) goto L_0x00b3
            return r1
        L_0x00b3:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor.t(com.xjsd.ai.assistant.phone.vad.OfflineAsrResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor$handleOfflineCmd$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor$handleOfflineCmd$1 r0 = (com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor$handleOfflineCmd$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor$handleOfflineCmd$1 r0 = new com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor$handleOfflineCmd$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            com.xjsd.ai.assistant.phone.bean.OfflineAsrBean r4 = (com.xjsd.ai.assistant.phone.bean.OfflineAsrBean) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0078
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "offline cmd->"
            r6.append(r2)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            java.lang.String r2 = "VadInterceptor"
            com.xjsd.ai.assistant.log.ILog.a(r2, r6)
            com.xjsd.ai.assistant.phone.bean.OfflineAsrBean r6 = new com.xjsd.ai.assistant.phone.bean.OfflineAsrBean
            r6.<init>()
            com.xjsd.ai.assistant.phone.session.Session r2 = r4.d()
            java.lang.String r2 = r2.b()
            r6.setId(r2)
            r6.setText(r5)
            r6.setCmd(r5)
            r6.setType(r3)
            r5 = 2
            r6.setSource(r5)
            kotlinx.coroutines.flow.MutableSharedFlow r4 = r4.l
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r4 = r4.emit(r6, r0)
            if (r4 != r1) goto L_0x0078
            return r1
        L_0x0078:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor.u(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object v(int i2, Continuation continuation) {
        if (i2 == 1) {
            this.f.cache("isVadStart", Boxing.boxBoolean(true));
            AudioFocusManageDelegate.a(3);
        } else if (i2 == 2) {
            AudioDataUtil.h();
            this.e.stop();
        } else if (i2 == 3) {
            this.e.start();
        }
        VadEventData vadEventData = new VadEventData(i2);
        vadEventData.setSessionId(d().b());
        Communicator.b(104, vadEventData, new VadInterceptor$handleVadEvent$2());
        Object emit = this.h.emit(Boxing.boxInt(i2), continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public final void w() {
        j(c(), new VadInterceptor$initChannel$1(FlowKt.f(new VadInterceptor$initChannel$flow$1(this, (Continuation<? super VadInterceptor$initChannel$flow$1>) null)), this, (Continuation<? super VadInterceptor$initChannel$1>) null));
    }
}
