package com.xjsd.xr.sapp.asr;

import com.xjsd.ai.assistant.net.ws.VirtualWebSocket;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;
import com.xjsd.xr.sapp.asr.callback.ISmartExCallback;
import com.xjsd.xr.sapp.asr.dao.SmartExSummary;
import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import com.xjsd.xr.sapp.asr.dao.SmartExtractionConfig;
import com.xjsd.xr.sapp.asr.utils.UlogExtKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u0006H\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\u000fJ\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0018\u00010\nR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/xjsd/xr/sapp/asr/SmartExtractionHelper;", "", "functionUniqueName", "", "(Ljava/lang/String;)V", "mIoScope", "Lkotlinx/coroutines/CoroutineScope;", "mSmartExCallback", "Lcom/xjsd/xr/sapp/asr/callback/ISmartExCallback;", "mSummarySocket", "Lcom/xjsd/xr/sapp/asr/SmartExtractionHelper$SummaryWebSocket;", "mTotoSocket", "Lcom/xjsd/xr/sapp/asr/SmartExtractionHelper$TodoWebSocket;", "createIoScope", "getSummary", "", "config", "Lcom/xjsd/xr/sapp/asr/dao/SmartExtractionConfig;", "getTodo", "handleSummary", "response", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "handleTodo", "registerCallback", "callback", "release", "stopSummarySocket", "stopTodoSocket", "Companion", "SummaryWebSocket", "TodoWebSocket", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SmartExtractionHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int RESPONSE_STATUS_NOT_ORIGINAL_DATA = 2;
    public static final int RESPONSE_STATUS_NOT_RESULT = 1;
    public static final int RESPONSE_STATUS_SUCCESS = 0;
    @NotNull
    public static final String SENSITIVE_RISKLEVEL_LOCKED = "LOCKED";
    @NotNull
    private static final String TAG = "SmartExtractionHelper";
    /* access modifiers changed from: private */
    @NotNull
    public final String functionUniqueName;
    /* access modifiers changed from: private */
    @NotNull
    public CoroutineScope mIoScope = createIoScope();
    /* access modifiers changed from: private */
    @Nullable
    public ISmartExCallback mSmartExCallback;
    /* access modifiers changed from: private */
    @Nullable
    public SummaryWebSocket mSummarySocket;
    /* access modifiers changed from: private */
    @Nullable
    public TodoWebSocket mTotoSocket;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/xjsd/xr/sapp/asr/SmartExtractionHelper$Companion;", "", "()V", "RESPONSE_STATUS_NOT_ORIGINAL_DATA", "", "RESPONSE_STATUS_NOT_RESULT", "RESPONSE_STATUS_SUCCESS", "SENSITIVE_RISKLEVEL_LOCKED", "", "TAG", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/xjsd/xr/sapp/asr/SmartExtractionHelper$SummaryWebSocket;", "Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket;", "(Lcom/xjsd/xr/sapp/asr/SmartExtractionHelper;)V", "getFunctionType", "", "getVirtualAppName", "", "onClose", "", "code", "onData", "data", "", "onMsg", "response", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "onParse", "onResume", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class SummaryWebSocket extends VirtualWebSocket {
        public SummaryWebSocket() {
        }

        public int getFunctionType() {
            return 4;
        }

        @NotNull
        public String getVirtualAppName() {
            return SmartExtractionHelper.this.functionUniqueName;
        }

        public void onClose(int i) {
            UlogExtKt.logI("Summary close code=" + i, SmartExtractionHelper.TAG);
            if (i != 10005) {
                ISmartExCallback access$getMSmartExCallback$p = SmartExtractionHelper.this.mSmartExCallback;
                if (access$getMSmartExCallback$p != null) {
                    access$getMSmartExCallback$p.onSummary((SmartExSummary) null);
                }
                SmartExtractionHelper.this.stopSummarySocket();
                return;
            }
            UlogExtKt.logI("Summary close for server", SmartExtractionHelper.TAG);
            ISmartExCallback access$getMSmartExCallback$p2 = SmartExtractionHelper.this.mSmartExCallback;
            if (access$getMSmartExCallback$p2 != null) {
                access$getMSmartExCallback$p2.onSummary((SmartExSummary) null);
            }
            SmartExtractionHelper.this.stopSummarySocket();
        }

        public void onData(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "data");
        }

        public void onMsg(@NotNull EndToEndResponse endToEndResponse) {
            Intrinsics.checkNotNullParameter(endToEndResponse, "response");
            SmartExtractionHelper.this.handleSummary(endToEndResponse);
        }

        public void onParse() {
        }

        public void onResume() {
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/xjsd/xr/sapp/asr/SmartExtractionHelper$TodoWebSocket;", "Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket;", "(Lcom/xjsd/xr/sapp/asr/SmartExtractionHelper;)V", "getFunctionType", "", "getVirtualAppName", "", "onClose", "", "code", "onData", "data", "", "onMsg", "response", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "onParse", "onResume", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class TodoWebSocket extends VirtualWebSocket {
        public TodoWebSocket() {
        }

        public int getFunctionType() {
            return 4;
        }

        @NotNull
        public String getVirtualAppName() {
            return SmartExtractionHelper.this.functionUniqueName;
        }

        public void onClose(int i) {
            UlogExtKt.logI("Todo close code=" + i, SmartExtractionHelper.TAG);
            if (i != 10005) {
                ISmartExCallback access$getMSmartExCallback$p = SmartExtractionHelper.this.mSmartExCallback;
                if (access$getMSmartExCallback$p != null) {
                    access$getMSmartExCallback$p.onTodo((SmartExTodo) null);
                }
                SmartExtractionHelper.this.stopTodoSocket();
                return;
            }
            UlogExtKt.logI("Todo close for server", SmartExtractionHelper.TAG);
            ISmartExCallback access$getMSmartExCallback$p2 = SmartExtractionHelper.this.mSmartExCallback;
            if (access$getMSmartExCallback$p2 != null) {
                access$getMSmartExCallback$p2.onTodo((SmartExTodo) null);
            }
            SmartExtractionHelper.this.stopTodoSocket();
        }

        public void onData(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "data");
        }

        public void onMsg(@NotNull EndToEndResponse endToEndResponse) {
            Intrinsics.checkNotNullParameter(endToEndResponse, "response");
            SmartExtractionHelper.this.handleTodo(endToEndResponse);
        }

        public void onParse() {
        }

        public void onResume() {
        }
    }

    public SmartExtractionHelper(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "functionUniqueName");
        this.functionUniqueName = str;
    }

    private final CoroutineScope createIoScope() {
        return CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        if (r0.equals("sensitive_result") != false) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleSummary(com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse r14) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handleSummary response="
            r0.append(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "SmartExtractionHelper"
            com.xjsd.xr.sapp.asr.utils.UlogExtKt.logI(r0, r1)
            r13.stopSummarySocket()
            java.lang.String r0 = r14.getType()
            java.lang.String r8 = "sensitive_result"
            java.lang.String r9 = "sensitive_request"
            r10 = 0
            if (r0 == 0) goto L_0x009a
            int r2 = r0.hashCode()     // Catch:{ Exception -> 0x0061 }
            r3 = -1996684826(0xffffffff88fd01e6, float:-1.522733E-33)
            if (r2 == r3) goto L_0x006a
            r3 = -1769541146(0xffffffff9686f1e6, float:-2.1801527E-25)
            if (r2 == r3) goto L_0x0063
            r3 = -1765979544(0xffffffff96bd4a68, float:-3.0581554E-25)
            if (r2 == r3) goto L_0x0038
            goto L_0x009a
        L_0x0038:
            java.lang.String r2 = "llm_summary_result"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x0061 }
            if (r2 != 0) goto L_0x0041
            goto L_0x009a
        L_0x0041:
            com.xjsd.xr.sapp.asr.callback.ISmartExCallback r2 = r13.mSmartExCallback     // Catch:{ Exception -> 0x0061 }
            if (r2 == 0) goto L_0x00d6
            java.lang.Class<com.xjsd.xr.sapp.asr.dao.SmartExSummary> r3 = com.xjsd.xr.sapp.asr.dao.SmartExSummary.class
            java.lang.Object r3 = r14.parsePayload(r3)     // Catch:{ Exception -> 0x0061 }
            r4 = r3
            com.xjsd.xr.sapp.asr.dao.SmartExSummary r4 = (com.xjsd.xr.sapp.asr.dao.SmartExSummary) r4     // Catch:{ Exception -> 0x0061 }
            java.lang.String r14 = r14.getRequestId()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r5 = "getRequestId(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r5)     // Catch:{ Exception -> 0x0061 }
            r4.setRequestId(r14)     // Catch:{ Exception -> 0x0061 }
            com.xjsd.xr.sapp.asr.dao.SmartExSummary r3 = (com.xjsd.xr.sapp.asr.dao.SmartExSummary) r3     // Catch:{ Exception -> 0x0061 }
            r2.onSummary(r3)     // Catch:{ Exception -> 0x0061 }
            goto L_0x00d6
        L_0x0061:
            r14 = move-exception
            goto L_0x00a2
        L_0x0063:
            boolean r2 = r0.equals(r9)     // Catch:{ Exception -> 0x0061 }
            if (r2 != 0) goto L_0x0070
            goto L_0x009a
        L_0x006a:
            boolean r2 = r0.equals(r8)     // Catch:{ Exception -> 0x0061 }
            if (r2 == 0) goto L_0x009a
        L_0x0070:
            java.lang.Class<com.xjsd.xr.sapp.asr.dao.SensitivePayload> r2 = com.xjsd.xr.sapp.asr.dao.SensitivePayload.class
            java.lang.Object r14 = r14.parsePayload(r2)     // Catch:{ Exception -> 0x0061 }
            com.xjsd.xr.sapp.asr.dao.SensitivePayload r14 = (com.xjsd.xr.sapp.asr.dao.SensitivePayload) r14     // Catch:{ Exception -> 0x0061 }
            com.xjsd.xr.sapp.asr.callback.ISmartExCallback r11 = r13.mSmartExCallback     // Catch:{ Exception -> 0x0061 }
            if (r11 == 0) goto L_0x00d6
            com.xjsd.xr.sapp.asr.dao.SensitivePayload r12 = new com.xjsd.xr.sapp.asr.dao.SensitivePayload     // Catch:{ Exception -> 0x0061 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r4 = r14.getRequestId()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r5 = r14.getRequestStatus()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r6 = r14.getRiskDescription()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r7 = r14.getRiskLevel()     // Catch:{ Exception -> 0x0061 }
            r2 = r12
            r3 = r0
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0061 }
            r11.onSummarySensitive(r12)     // Catch:{ Exception -> 0x0061 }
            goto L_0x00d6
        L_0x009a:
            com.xjsd.xr.sapp.asr.callback.ISmartExCallback r14 = r13.mSmartExCallback     // Catch:{ Exception -> 0x0061 }
            if (r14 == 0) goto L_0x00d6
            r14.onSummary(r10)     // Catch:{ Exception -> 0x0061 }
            goto L_0x00d6
        L_0x00a2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "handleSummary error="
            r2.append(r3)
            java.lang.String r14 = kotlin.ExceptionsKt.stackTraceToString(r14)
            r2.append(r14)
            java.lang.String r14 = r2.toString()
            com.xjsd.xr.sapp.asr.utils.UlogExtKt.logI(r14, r1)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r9)
            if (r14 != 0) goto L_0x00cf
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r8)
            if (r14 == 0) goto L_0x00c7
            goto L_0x00cf
        L_0x00c7:
            com.xjsd.xr.sapp.asr.callback.ISmartExCallback r13 = r13.mSmartExCallback
            if (r13 == 0) goto L_0x00d6
            r13.onSummary(r10)
            goto L_0x00d6
        L_0x00cf:
            com.xjsd.xr.sapp.asr.callback.ISmartExCallback r13 = r13.mSmartExCallback
            if (r13 == 0) goto L_0x00d6
            r13.onSummarySensitive(r10)
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.SmartExtractionHelper.handleSummary(com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        if (r0.equals("sensitive_result") != false) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleTodo(com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse r14) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handleTodo response="
            r0.append(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "SmartExtractionHelper"
            com.xjsd.xr.sapp.asr.utils.UlogExtKt.logI(r0, r1)
            r13.stopTodoSocket()
            java.lang.String r0 = r14.getType()
            java.lang.String r8 = "sensitive_result"
            java.lang.String r9 = "sensitive_request"
            r10 = 0
            if (r0 == 0) goto L_0x009a
            int r2 = r0.hashCode()     // Catch:{ Exception -> 0x003f }
            r3 = -1996684826(0xffffffff88fd01e6, float:-1.522733E-33)
            if (r2 == r3) goto L_0x006a
            r3 = -1777180735(0xffffffff96125fc1, float:-1.1824001E-25)
            if (r2 == r3) goto L_0x0041
            r3 = -1769541146(0xffffffff9686f1e6, float:-2.1801527E-25)
            if (r2 == r3) goto L_0x0038
            goto L_0x009a
        L_0x0038:
            boolean r2 = r0.equals(r9)     // Catch:{ Exception -> 0x003f }
            if (r2 != 0) goto L_0x0070
            goto L_0x009a
        L_0x003f:
            r14 = move-exception
            goto L_0x00a2
        L_0x0041:
            java.lang.String r2 = "llm_todos_result"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x003f }
            if (r2 != 0) goto L_0x004a
            goto L_0x009a
        L_0x004a:
            com.xjsd.xr.sapp.asr.callback.ISmartExCallback r2 = r13.mSmartExCallback     // Catch:{ Exception -> 0x003f }
            if (r2 == 0) goto L_0x00d6
            java.lang.Class<com.xjsd.xr.sapp.asr.dao.SmartExTodo> r3 = com.xjsd.xr.sapp.asr.dao.SmartExTodo.class
            java.lang.Object r3 = r14.parsePayload(r3)     // Catch:{ Exception -> 0x003f }
            r4 = r3
            com.xjsd.xr.sapp.asr.dao.SmartExTodo r4 = (com.xjsd.xr.sapp.asr.dao.SmartExTodo) r4     // Catch:{ Exception -> 0x003f }
            java.lang.String r14 = r14.getRequestId()     // Catch:{ Exception -> 0x003f }
            java.lang.String r5 = "getRequestId(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r5)     // Catch:{ Exception -> 0x003f }
            r4.setRequestId(r14)     // Catch:{ Exception -> 0x003f }
            com.xjsd.xr.sapp.asr.dao.SmartExTodo r3 = (com.xjsd.xr.sapp.asr.dao.SmartExTodo) r3     // Catch:{ Exception -> 0x003f }
            r2.onTodo(r3)     // Catch:{ Exception -> 0x003f }
            goto L_0x00d6
        L_0x006a:
            boolean r2 = r0.equals(r8)     // Catch:{ Exception -> 0x003f }
            if (r2 == 0) goto L_0x009a
        L_0x0070:
            java.lang.Class<com.xjsd.xr.sapp.asr.dao.SensitivePayload> r2 = com.xjsd.xr.sapp.asr.dao.SensitivePayload.class
            java.lang.Object r14 = r14.parsePayload(r2)     // Catch:{ Exception -> 0x003f }
            com.xjsd.xr.sapp.asr.dao.SensitivePayload r14 = (com.xjsd.xr.sapp.asr.dao.SensitivePayload) r14     // Catch:{ Exception -> 0x003f }
            com.xjsd.xr.sapp.asr.callback.ISmartExCallback r11 = r13.mSmartExCallback     // Catch:{ Exception -> 0x003f }
            if (r11 == 0) goto L_0x00d6
            com.xjsd.xr.sapp.asr.dao.SensitivePayload r12 = new com.xjsd.xr.sapp.asr.dao.SensitivePayload     // Catch:{ Exception -> 0x003f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ Exception -> 0x003f }
            java.lang.String r4 = r14.getRequestId()     // Catch:{ Exception -> 0x003f }
            java.lang.String r5 = r14.getRequestStatus()     // Catch:{ Exception -> 0x003f }
            java.lang.String r6 = r14.getRiskDescription()     // Catch:{ Exception -> 0x003f }
            java.lang.String r7 = r14.getRiskLevel()     // Catch:{ Exception -> 0x003f }
            r2 = r12
            r3 = r0
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x003f }
            r11.onTodoSensitive(r12)     // Catch:{ Exception -> 0x003f }
            goto L_0x00d6
        L_0x009a:
            com.xjsd.xr.sapp.asr.callback.ISmartExCallback r14 = r13.mSmartExCallback     // Catch:{ Exception -> 0x003f }
            if (r14 == 0) goto L_0x00d6
            r14.onTodo(r10)     // Catch:{ Exception -> 0x003f }
            goto L_0x00d6
        L_0x00a2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "handleTodo error="
            r2.append(r3)
            java.lang.String r14 = kotlin.ExceptionsKt.stackTraceToString(r14)
            r2.append(r14)
            java.lang.String r14 = r2.toString()
            com.xjsd.xr.sapp.asr.utils.UlogExtKt.logI(r14, r1)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r9)
            if (r14 != 0) goto L_0x00cf
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r8)
            if (r14 == 0) goto L_0x00c7
            goto L_0x00cf
        L_0x00c7:
            com.xjsd.xr.sapp.asr.callback.ISmartExCallback r13 = r13.mSmartExCallback
            if (r13 == 0) goto L_0x00d6
            r13.onTodo(r10)
            goto L_0x00d6
        L_0x00cf:
            com.xjsd.xr.sapp.asr.callback.ISmartExCallback r13 = r13.mSmartExCallback
            if (r13 == 0) goto L_0x00d6
            r13.onTodoSensitive(r10)
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.SmartExtractionHelper.handleTodo(com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse):void");
    }

    /* access modifiers changed from: private */
    public final void stopSummarySocket() {
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new SmartExtractionHelper$stopSummarySocket$1(this, (Continuation<? super SmartExtractionHelper$stopSummarySocket$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void stopTodoSocket() {
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new SmartExtractionHelper$stopTodoSocket$1(this, (Continuation<? super SmartExtractionHelper$stopTodoSocket$1>) null), 3, (Object) null);
    }

    public final void getSummary(@NotNull SmartExtractionConfig smartExtractionConfig) {
        Intrinsics.checkNotNullParameter(smartExtractionConfig, "config");
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new SmartExtractionHelper$getSummary$1(smartExtractionConfig, this, (Continuation<? super SmartExtractionHelper$getSummary$1>) null), 3, (Object) null);
    }

    public final void getTodo(@NotNull SmartExtractionConfig smartExtractionConfig) {
        Intrinsics.checkNotNullParameter(smartExtractionConfig, "config");
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new SmartExtractionHelper$getTodo$1(smartExtractionConfig, this, (Continuation<? super SmartExtractionHelper$getTodo$1>) null), 3, (Object) null);
    }

    public final void registerCallback(@NotNull ISmartExCallback iSmartExCallback) {
        Intrinsics.checkNotNullParameter(iSmartExCallback, "callback");
        this.mSmartExCallback = iSmartExCallback;
    }

    public final void release() {
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new SmartExtractionHelper$release$1(this, (Continuation<? super SmartExtractionHelper$release$1>) null), 3, (Object) null);
    }
}
