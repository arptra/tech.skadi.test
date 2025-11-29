package com.xjsd.xr.sapp.asr;

import com.meizu.common.util.LunarCalendar;
import com.upuphone.runasone.relay.api.IntentKey;
import com.xjsd.ai.assistant.net.ws.VirtualWebSocket;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData;
import com.xjsd.xr.sapp.asr.callback.AsrResultCallback;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import com.xjsd.xr.sapp.asr.dao.AsrMessageState;
import com.xjsd.xr.sapp.asr.dao.AsrRequest;
import com.xjsd.xr.sapp.asr.dao.AsrRequestData;
import com.xjsd.xr.sapp.asr.dao.AsrResponse;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.SpeechCancelAudio;
import com.xjsd.xr.sapp.asr.dao.SpeechRequestConfig;
import com.xjsd.xr.sapp.asr.dao.TtsConfig;
import com.xjsd.xr.sapp.asr.thread.ThreadPollHelper;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import com.xjsd.xr.sapp.asr.utils.AsrResultExtKt;
import com.xjsd.xr.sapp.asr.utils.GsonHelper;
import com.xjsd.xr.sapp.asr.utils.UlogExtKt;
import java.net.SocketException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\r\u0018\u0000 82\u00020\u0001:\u000278B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u0006\u0010\u0013\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0003H\u0002J\u001c\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010(H\u0002J\u0014\u0010)\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010(H\u0002J\u000e\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,J\u0016\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\tJ\u0006\u00100\u001a\u00020\u0010J\u001c\u00101\u001a\u00020\u00102\n\u00102\u001a\u00060\u000eR\u00020\u00002\u0006\u00103\u001a\u00020\u0016H\u0002J\u000e\u00104\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u0016J\u0006\u00105\u001a\u00020\u0010J\u0016\u00106\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/xjsd/xr/sapp/asr/ShortUnifiedAsrHelper;", "", "functionUniqueName", "", "(Ljava/lang/String;)V", "mAsrRequest", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequest;", "mCallbackMap", "", "Lcom/xjsd/xr/sapp/asr/callback/AsrResultCallback;", "mFeedCoroutine", "Lkotlinx/coroutines/CoroutineScope;", "mIoScope", "mWebSocket", "Lcom/xjsd/xr/sapp/asr/ShortUnifiedAsrHelper$AsrWebSocket;", "cancelAudioMessage", "", "createFeedScope", "createIoScope", "endAudioMessage", "getSyncAudioInfoRequest", "config", "Lcom/xjsd/xr/sapp/asr/dao/SpeechRequestConfig;", "handleMessage", "response", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "handleMessageSuccess", "asrResponse", "Lcom/xjsd/xr/sapp/asr/dao/AsrResponse;", "notifyAsrResult", "result", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "notifyAsrRunningState", "notifyClosed", "code", "", "reason", "notifyFailed", "t", "", "Lokhttp3/Response;", "notifyOpen", "pushAudio", "bytes", "", "registerAsrResultCallback", "key", "callback", "release", "sendChannelInfo", "socket", "requestConfig", "startRequest", "stopRequest", "unRegisterAsrResultCallback", "AsrWebSocket", "Companion", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nShortUnifiedAsrHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShortUnifiedAsrHelper.kt\ncom/xjsd/xr/sapp/asr/ShortUnifiedAsrHelper\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,471:1\n215#2,2:472\n215#2,2:474\n215#2,2:476\n215#2,2:478\n215#2,2:480\n*S KotlinDebug\n*F\n+ 1 ShortUnifiedAsrHelper.kt\ncom/xjsd/xr/sapp/asr/ShortUnifiedAsrHelper\n*L\n175#1:472,2\n187#1:474,2\n202#1:476,2\n223#1:478,2\n238#1:480,2\n*E\n"})
public final class ShortUnifiedAsrHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "ShortUnifiedAsrHelper";
    /* access modifiers changed from: private */
    @NotNull
    public final String functionUniqueName;
    /* access modifiers changed from: private */
    @Nullable
    public AsrRequest mAsrRequest;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, AsrResultCallback> mCallbackMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    @NotNull
    public CoroutineScope mFeedCoroutine = createFeedScope();
    /* access modifiers changed from: private */
    @NotNull
    public CoroutineScope mIoScope = createIoScope();
    /* access modifiers changed from: private */
    @Nullable
    public AsrWebSocket mWebSocket;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/xjsd/xr/sapp/asr/ShortUnifiedAsrHelper$AsrWebSocket;", "Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket;", "(Lcom/xjsd/xr/sapp/asr/ShortUnifiedAsrHelper;)V", "getFunctionType", "", "getVirtualAppName", "", "onClose", "", "code", "onData", "data", "", "onMsg", "response", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "onParse", "onResume", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AsrWebSocket extends VirtualWebSocket {
        public AsrWebSocket() {
        }

        public int getFunctionType() {
            return 1;
        }

        @NotNull
        public String getVirtualAppName() {
            return ShortUnifiedAsrHelper.this.functionUniqueName;
        }

        public void onClose(int i) {
            if (i == 10005) {
                UlogExtKt.logI("AsrWebSocket onClosed code=" + i, ShortUnifiedAsrHelper.TAG);
                ShortUnifiedAsrHelper.notifyClosed$default(ShortUnifiedAsrHelper.this, i, (String) null, 2, (Object) null);
                return;
            }
            UlogExtKt.logI("AsrWebSocket onFailure code=" + i, ShortUnifiedAsrHelper.TAG);
            ShortUnifiedAsrHelper.notifyFailed$default(ShortUnifiedAsrHelper.this, new SocketException("WebSocket connect error"), (Response) null, 2, (Object) null);
        }

        public void onData(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "data");
        }

        public void onMsg(@NotNull EndToEndResponse endToEndResponse) {
            Intrinsics.checkNotNullParameter(endToEndResponse, "response");
            ShortUnifiedAsrHelper.this.handleMessage(endToEndResponse);
        }

        public void onParse() {
        }

        public void onResume() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/xr/sapp/asr/ShortUnifiedAsrHelper$Companion;", "", "()V", "TAG", "", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ShortUnifiedAsrHelper(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "functionUniqueName");
        this.functionUniqueName = str;
    }

    /* access modifiers changed from: private */
    public final CoroutineScope createFeedScope() {
        return CoroutineScopeKt.a(ExecutorsKt.b(ThreadPollHelper.INSTANCE.newHighPrioritySingleThreadExecutor()).plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    }

    private final CoroutineScope createIoScope() {
        return CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    }

    private final AsrRequest getSyncAudioInfoRequest(SpeechRequestConfig speechRequestConfig) {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String replace$default = StringsKt.replace$default(uuid, LunarCalendar.DATE_SEPARATOR, "", false, 4, (Object) null);
        String deviceId = speechRequestConfig.getDeviceId();
        AsrRequestData asrRequestData = r5;
        AsrRequestData asrRequestData2 = new AsrRequestData(speechRequestConfig.getData().getAudioType(), speechRequestConfig.getData().getSampleRate(), speechRequestConfig.getData().getChannel(), speechRequestConfig.getData().getSampleBytes(), speechRequestConfig.getData().getHotWords(), speechRequestConfig.getData().getEnablePunctuation());
        return new AsrRequest(replace$default, AsrConstants.SYNC_AUDIO_INFO, deviceId, asrRequestData, (String) null, AsrExtKt.asrSha256(speechRequestConfig.getIotDeviceId()), (String) null, speechRequestConfig.getLanguage(), (String) null, false, speechRequestConfig.getSupplier(), speechRequestConfig.getAppName(), (String) null, false, (TtsConfig) null, (Integer) null, (Integer) null, (Long) null, (Long) null, 520256, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final void handleMessage(EndToEndResponse endToEndResponse) {
        UlogExtKt.logI("handleMessage from service response=" + endToEndResponse, TAG);
        try {
            AsrResponse asrResponse = (AsrResponse) endToEndResponse.parsePayload(AsrResponse.class);
            UlogExtKt.logI("handleMessage asrResponse=" + asrResponse, TAG);
            String code = asrResponse.getCode();
            if (Intrinsics.areEqual((Object) code, (Object) "0")) {
                Intrinsics.checkNotNull(asrResponse);
                handleMessageSuccess(asrResponse);
                return;
            }
            UlogExtKt.logI("handleMessage 服务异常error code=" + code + ", desc=" + asrResponse.getMsg(), TAG);
            Intrinsics.checkNotNull(asrResponse);
            notifyAsrRunningState(asrResponse);
            stopRequest();
        } catch (Exception e) {
            UlogExtKt.logI("handleMessage 服务器数据处理异常 " + ExceptionsKt.stackTraceToString(e), TAG);
        }
    }

    private final void handleMessageSuccess(AsrResponse asrResponse) {
        String event = asrResponse.getEvent();
        int hashCode = event.hashCode();
        if (hashCode != -636965025) {
            if (hashCode != 235005312) {
                if (hashCode == 799401263 && event.equals(AsrConstants.TRANSLATION_RESULT_SUCCESS)) {
                    AsrResult translation$default = AsrResultExtKt.translation$default(asrResponse, (AsrRequest) null, 1, (Object) null);
                    UlogExtKt.logI("handleMessageSuccess ASR翻译结果=" + translation$default, TAG);
                    notifyAsrResult(translation$default);
                    return;
                }
            } else if (event.equals(AsrConstants.ASR_RESULT_SUCCESS)) {
                AsrResult transcribed$default = AsrResultExtKt.transcribed$default(asrResponse, (AsrRequest) null, 1, (Object) null);
                UlogExtKt.logI("handleMessageSuccess ASR识别结果=" + transcribed$default, TAG);
                notifyAsrResult(transcribed$default);
                return;
            }
        } else if (event.equals(AsrConstants.SYNC_AUDIO_INFO_SUCCESS)) {
            UlogExtKt.logI("handleMessageSuccess 握手成功！", TAG);
            notifyOpen$default(this, (Response) null, 1, (Object) null);
            notifyAsrRunningState(asrResponse);
            return;
        }
        UlogExtKt.logI("handleMessageSuccess 无需处理的事件=" + event, TAG);
    }

    private final void notifyAsrResult(AsrResult asrResult) {
        for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
            ((AsrResultCallback) value.getValue()).onRemoteAsrResult(asrResult);
        }
    }

    private final void notifyAsrRunningState(AsrResponse asrResponse) {
        try {
            AsrMessageState asrMessageState = new AsrMessageState(asrResponse.getEvent(), asrResponse.getCode(), asrResponse.getMsg(), (String) null, (String) null, 24, (DefaultConstructorMarker) null);
            UlogExtKt.logI("notifyAsrRunningState asrMessageState=" + asrMessageState + ", callback size=" + this.mCallbackMap.size(), TAG);
            for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value.getValue()).onAsrRunningState(asrMessageState);
            }
        } catch (Exception e) {
            UlogExtKt.logI("notifyAsrRunningState error=" + ExceptionsKt.stackTraceToString(e), TAG);
        }
    }

    private final void notifyClosed(int i, String str) {
        for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
            ((AsrResultCallback) value.getValue()).onClosed(i, str);
        }
    }

    public static /* synthetic */ void notifyClosed$default(ShortUnifiedAsrHelper shortUnifiedAsrHelper, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "WebSocket is closed";
        }
        shortUnifiedAsrHelper.notifyClosed(i, str);
    }

    private final void notifyFailed(Throwable th, Response response) {
        stopRequest();
        for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
            ((AsrResultCallback) value.getValue()).onFailure(th, response);
        }
    }

    public static /* synthetic */ void notifyFailed$default(ShortUnifiedAsrHelper shortUnifiedAsrHelper, Throwable th, Response response, int i, Object obj) {
        if ((i & 2) != 0) {
            response = null;
        }
        shortUnifiedAsrHelper.notifyFailed(th, response);
    }

    private final void notifyOpen(Response response) {
        for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
            ((AsrResultCallback) value.getValue()).onOpen(response);
        }
    }

    public static /* synthetic */ void notifyOpen$default(ShortUnifiedAsrHelper shortUnifiedAsrHelper, Response response, int i, Object obj) {
        if ((i & 1) != 0) {
            response = null;
        }
        shortUnifiedAsrHelper.notifyOpen(response);
    }

    /* access modifiers changed from: private */
    public final void sendChannelInfo(AsrWebSocket asrWebSocket, SpeechRequestConfig speechRequestConfig) {
        UlogExtKt.logI("sendChannelInfo requestConfig=" + speechRequestConfig, TAG);
        AsrRequest syncAudioInfoRequest = getSyncAudioInfoRequest(speechRequestConfig);
        this.mAsrRequest = syncAudioInfoRequest;
        if (syncAudioInfoRequest != null) {
            String requestId = syncAudioInfoRequest.getRequestId();
            UlogExtKt.logI("sendChannelInfo tranceId=" + requestId + ", request=" + syncAudioInfoRequest, TAG);
            EndToEndServiceData endToEndServiceData = new EndToEndServiceData();
            endToEndServiceData.setType("asr");
            endToEndServiceData.setPayload(syncAudioInfoRequest);
            Unit unit = Unit.INSTANCE;
            asrWebSocket.sendMsg(requestId, endToEndServiceData);
        }
    }

    public final void cancelAudioMessage() {
        UlogExtKt.logI("cancelAudioMessage asrRequest=" + this.mAsrRequest, TAG);
        AsrRequest asrRequest = this.mAsrRequest;
        if (asrRequest != null) {
            String json = GsonHelper.toJson(new SpeechCancelAudio(asrRequest.getDeviceId(), AsrConstants.CANCEL_AUDIO, asrRequest.getRequestId()));
            String requestId = asrRequest.getRequestId();
            UlogExtKt.logI("cancelAudioMessage traceId=" + requestId + ", json=" + json, TAG);
            AsrWebSocket asrWebSocket = this.mWebSocket;
            if (asrWebSocket != null) {
                EndToEndServiceData endToEndServiceData = new EndToEndServiceData();
                endToEndServiceData.setType("asr");
                endToEndServiceData.setPayload(json);
                Unit unit = Unit.INSTANCE;
                asrWebSocket.sendMsg(requestId, endToEndServiceData);
            }
        }
    }

    public final void endAudioMessage() {
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new ShortUnifiedAsrHelper$endAudioMessage$1(this, (Continuation<? super ShortUnifiedAsrHelper$endAudioMessage$1>) null), 3, (Object) null);
    }

    public final void pushAudio(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Job unused = BuildersKt__Builders_commonKt.d(this.mFeedCoroutine, (CoroutineContext) null, (CoroutineStart) null, new ShortUnifiedAsrHelper$pushAudio$1(this, bArr, (Continuation<? super ShortUnifiedAsrHelper$pushAudio$1>) null), 3, (Object) null);
    }

    public final void registerAsrResultCallback(@NotNull String str, @NotNull AsrResultCallback asrResultCallback) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(asrResultCallback, "callback");
        this.mCallbackMap.put(str, asrResultCallback);
    }

    public final void release() {
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new ShortUnifiedAsrHelper$release$1(this, (Continuation<? super ShortUnifiedAsrHelper$release$1>) null), 3, (Object) null);
    }

    public final void startRequest(@NotNull SpeechRequestConfig speechRequestConfig) {
        Intrinsics.checkNotNullParameter(speechRequestConfig, "requestConfig");
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new ShortUnifiedAsrHelper$startRequest$1(speechRequestConfig, this, (Continuation<? super ShortUnifiedAsrHelper$startRequest$1>) null), 3, (Object) null);
    }

    public final void stopRequest() {
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new ShortUnifiedAsrHelper$stopRequest$1(this, (Continuation<? super ShortUnifiedAsrHelper$stopRequest$1>) null), 3, (Object) null);
    }

    public final void unRegisterAsrResultCallback(@NotNull String str, @NotNull AsrResultCallback asrResultCallback) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(asrResultCallback, "callback");
        this.mCallbackMap.remove(str, asrResultCallback);
    }
}
