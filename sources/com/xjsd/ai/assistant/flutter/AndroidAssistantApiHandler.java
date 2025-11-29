package com.xjsd.ai.assistant.flutter;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.android.gms.actions.SearchIntents;
import com.honey.account.ca.n;
import com.honey.account.ca.o;
import com.honey.account.ca.p;
import com.honey.account.ca.q;
import com.honey.account.ca.r;
import com.honey.account.ca.s;
import com.xjsd.ai.assistant.asr.engine.protocol.AsrAudioInfo;
import com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudOptions;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.core.util.DotUtil;
import com.xjsd.ai.assistant.env.EnvAbility;
import com.xjsd.ai.assistant.env.Environment;
import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import com.xjsd.ai.assistant.flutter.nlp.ApplicationNlpPreprocessor;
import com.xjsd.ai.assistant.flutter.nlp.CallNlpPreprocessor;
import com.xjsd.ai.assistant.flutter.nlp.ChatNlpPreprocessor;
import com.xjsd.ai.assistant.flutter.nlp.ErrorNlpPreprocessor;
import com.xjsd.ai.assistant.flutter.nlp.GlobalNlpPreprocessor;
import com.xjsd.ai.assistant.flutter.nlp.LlmNlpPreprocessor;
import com.xjsd.ai.assistant.flutter.nlp.MediaNlpPreprocessor;
import com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor;
import com.xjsd.ai.assistant.flutter.nlp.ScheduleNlpPreprocessor;
import com.xjsd.ai.assistant.flutter.nlp.SettingsNlpPreprocessor;
import com.xjsd.ai.assistant.flutter.nlp.TranslateNlpPreprocessor;
import com.xjsd.ai.assistant.flutter.nlp.WeatherNlpPreprocessor;
import com.xjsd.ai.assistant.flutter.nlp.WechatNlpPreprocessor;
import com.xjsd.ai.assistant.flutter.util.AudioRecordHelper;
import com.xjsd.ai.assistant.flutter.util.PcmEncodedData;
import com.xjsd.ai.assistant.flutter.util.PcmEncoder;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.net.ws.VirtualWebSocket;
import com.xjsd.ai.assistant.net.ws.VirtualWebSocketManager;
import com.xjsd.ai.assistant.net.ws.protocol.CloudResType;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData;
import com.xjsd.ai.assistant.nlu.NluAbility;
import com.xjsd.ai.assistant.nlu.bean.MetaData;
import com.xjsd.ai.assistant.nlu.bean.NluRequest;
import com.xjsd.ai.assistant.nlu.bean.TalkInfo;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;
import com.xjsd.ai.assistant.phone.event.NetworkEvent;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0011J\u000e\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%J\u001e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0)H\u0016J\u000e\u0010*\u001a\u00020\fH@¢\u0006\u0002\u0010+J\u001e\u0010,\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0)H\u0016J\b\u0010-\u001a\u00020\fH\u0016J\u0016\u0010.\u001a\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020/0)H\u0016J\b\u00100\u001a\u00020\u0005H\u0002J\b\u00101\u001a\u00020\u0013H\u0002J\u0010\u00102\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0002J\b\u00103\u001a\u00020\u0013H\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\u001e\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0)H\u0016J+\u00107\u001a\u00020!2!\u00108\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020=09H\u0002J\u001e\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020@2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020A0)H\u0016J\b\u0010B\u001a\u00020!H\u0016J\b\u0010C\u001a\u00020\fH\u0002J\b\u0010D\u001a\u00020!H\u0002J\u000e\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020GJ\u0010\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020\u0013H\u0016J\u0010\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010M\u001a\u00020!2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010N\u001a\u00020!H\u0016J\u0010\u0010O\u001a\u00020!2\u0006\u0010$\u001a\u00020PH\u0007J\b\u0010Q\u001a\u00020!H\u0016J\b\u0010R\u001a\u00020!H\u0002J\u0010\u0010S\u001a\u00020\f2\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020VH\u0002J6\u0010W\u001a\u00020!2\u0006\u0010X\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0)H\u0016J&\u0010[\u001a\u00020!2\u0006\u00106\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0)H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006\\"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApiHandler;", "Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket;", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$AssistantHostApi;", "()V", "GLASS_HISTORY_SESSION_ID", "", "TAG", "audioRecordHelper", "Lcom/xjsd/ai/assistant/flutter/util/AudioRecordHelper;", "dotRef", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isManualDisconnect", "", "isNetworkOk", "isParsed", "isWorking", "mAssistantFlutterApi", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$AssistantFlutterApi;", "mLastFunctionType", "", "mLatestSessionId", "mLatestTraceId", "mOriginSessionId", "mWorkerHandler", "Landroid/os/Handler;", "mainHandler", "pcmEncoder", "Lcom/xjsd/ai/assistant/flutter/util/PcmEncoder;", "getPcmEncoder", "()Lcom/xjsd/ai/assistant/flutter/util/PcmEncoder;", "pcmEncoder$delegate", "Lkotlin/Lazy;", "bindFlutterApi", "", "flutterApi", "broadcastEventToFlutter", "event", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$NotifyEvent;", "connectCloud", "sessionId", "result", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$Result;", "connectServer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectCloud", "endSendAudio", "getAiEnvironment", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$AiEnvironment;", "getConvertDeviceId", "getConvertOriginType", "getConvertSessionId", "getFunctionType", "getVirtualAppName", "interrupt", "traceId", "invokeConnect", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "invokeGenericMethod", "request", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$InvokeRequest;", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$InvokeResult;", "iosStopRecorder", "isGlassHistorySession", "launchReconnectTask", "mockSendNlpToFlutter", "response", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "onClose", "code", "onData", "data", "", "onMsg", "onParse", "onReceiveNetworkEvent", "Lcom/xjsd/ai/assistant/phone/event/NetworkEvent;", "onResume", "reconnectServer", "sendAudioToCloud", "sendResToFlutter", "res", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$CloudResponse;", "sendTextToCloud", "text", "resource", "isFirstQuery", "startSendAudio", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AndroidAssistantApiHandler extends VirtualWebSocket implements AndroidAssistantApi.AssistantHostApi {
    @NotNull
    private static final String GLASS_HISTORY_SESSION_ID = "-1";
    @NotNull
    public static final AndroidAssistantApiHandler INSTANCE;
    @NotNull
    private static final String TAG = "AndroidAssistantApiHandler";
    @NotNull
    private static AudioRecordHelper audioRecordHelper = new AudioRecordHelper();
    @NotNull
    private static final AtomicBoolean dotRef = new AtomicBoolean(false);
    private static boolean isManualDisconnect;
    private static boolean isNetworkOk;
    private static boolean isParsed;
    /* access modifiers changed from: private */
    public static boolean isWorking;
    @Nullable
    private static AndroidAssistantApi.AssistantFlutterApi mAssistantFlutterApi;
    private static int mLastFunctionType = 2;
    /* access modifiers changed from: private */
    @NotNull
    public static String mLatestSessionId = "";
    @NotNull
    private static String mLatestTraceId = "";
    @NotNull
    private static String mOriginSessionId = "";
    @NotNull
    private static Handler mWorkerHandler;
    @NotNull
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    @NotNull
    private static final Lazy pcmEncoder$delegate = LazyKt.lazy(AndroidAssistantApiHandler$pcmEncoder$2.INSTANCE);

    static {
        AndroidAssistantApiHandler androidAssistantApiHandler = new AndroidAssistantApiHandler();
        INSTANCE = androidAssistantApiHandler;
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        mWorkerHandler = new Handler(handlerThread.getLooper());
        EventBus.c().o(androidAssistantApiHandler);
        NlpPreprocessorManager nlpPreprocessorManager = NlpPreprocessorManager.f8482a;
        nlpPreprocessorManager.b(new LlmNlpPreprocessor());
        nlpPreprocessorManager.b(new WechatNlpPreprocessor());
        nlpPreprocessorManager.b(new CallNlpPreprocessor());
        nlpPreprocessorManager.b(new NavNlpPreprocessor());
        nlpPreprocessorManager.b(new ErrorNlpPreprocessor());
        nlpPreprocessorManager.b(new GlobalNlpPreprocessor());
        nlpPreprocessorManager.b(new WeatherNlpPreprocessor());
        nlpPreprocessorManager.b(new SettingsNlpPreprocessor());
        nlpPreprocessorManager.b(new ApplicationNlpPreprocessor());
        nlpPreprocessorManager.b(new TranslateNlpPreprocessor());
        nlpPreprocessorManager.b(new MediaNlpPreprocessor());
        nlpPreprocessorManager.b(new ChatNlpPreprocessor());
        nlpPreprocessorManager.b(new ScheduleNlpPreprocessor());
        VirtualWebSocketManager.f8507a.a(androidAssistantApiHandler);
    }

    private AndroidAssistantApiHandler() {
    }

    /* access modifiers changed from: private */
    public static final void broadcastEventToFlutter$lambda$1(AndroidAssistantApi.NotifyEvent notifyEvent) {
        Intrinsics.checkNotNullParameter(notifyEvent, "$event");
        AndroidAssistantApi.AssistantFlutterApi assistantFlutterApi = mAssistantFlutterApi;
        if (assistantFlutterApi != null) {
            assistantFlutterApi.h(notifyEvent, new AndroidAssistantApiHandler$broadcastEventToFlutter$1$1());
        }
    }

    /* access modifiers changed from: private */
    public final Object connectServer(Continuation<? super Boolean> continuation) {
        SuperAppAbilityManager.e().l();
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        INSTANCE.invokeConnect(new AndroidAssistantApiHandler$connectServer$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final String getConvertDeviceId() {
        if (!isGlassHistorySession()) {
            return mLatestSessionId;
        }
        String a2 = DeviceUtils.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getGlassDeviceId(...)");
        return a2;
    }

    private final int getConvertOriginType() {
        return isGlassHistorySession() ? 2 : 1;
    }

    private final String getConvertSessionId(String str) {
        if (!Intrinsics.areEqual((Object) str, (Object) "-1")) {
            return str;
        }
        String a2 = DeviceUtils.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getGlassDeviceId(...)");
        return a2;
    }

    private final PcmEncoder getPcmEncoder() {
        return (PcmEncoder) pcmEncoder$delegate.getValue();
    }

    private final void invokeConnect(Function1<? super Boolean, ? extends Object> function1) {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new AndroidAssistantApiHandler$invokeConnect$1(function1, (Continuation<? super AndroidAssistantApiHandler$invokeConnect$1>) null), 3, (Object) null);
    }

    private final boolean isGlassHistorySession() {
        return Intrinsics.areEqual((Object) mOriginSessionId, (Object) "-1");
    }

    /* access modifiers changed from: private */
    public final void launchReconnectTask() {
        if (isNetworkOk && !isManualDisconnect) {
            ILog.a(TAG, "launchReconnectTask: 2s后重连");
            mWorkerHandler.postDelayed(new n(this), AssistantConstants.TIMEOUT_VAD_MUTE);
        }
    }

    /* access modifiers changed from: private */
    public static final void onClose$lambda$23(int i) {
        AndroidAssistantApi.AssistantFlutterApi assistantFlutterApi = mAssistantFlutterApi;
        if (assistantFlutterApi != null) {
            assistantFlutterApi.i(500L, String.valueOf(i), new AndroidAssistantApiHandler$onClose$1$1());
        }
    }

    /* access modifiers changed from: private */
    public static final void onMsg$lambda$24(EndToEndResponse endToEndResponse) {
        Intrinsics.checkNotNullParameter(endToEndResponse, "$response");
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new AndroidAssistantApiHandler$onMsg$1$1(endToEndResponse, (Continuation<? super AndroidAssistantApiHandler$onMsg$1$1>) null), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void reconnectServer() {
    }

    /* access modifiers changed from: private */
    public final void sendResToFlutter(AndroidAssistantApi.CloudResponse cloudResponse) {
        mainHandler.post(new o(cloudResponse));
    }

    /* access modifiers changed from: private */
    public static final void sendResToFlutter$lambda$25(AndroidAssistantApi.CloudResponse cloudResponse) {
        Intrinsics.checkNotNullParameter(cloudResponse, "$res");
        AndroidAssistantApi.AssistantFlutterApi assistantFlutterApi = mAssistantFlutterApi;
        if (assistantFlutterApi != null) {
            assistantFlutterApi.j(cloudResponse, new AndroidAssistantApiHandler$sendResToFlutter$1$1());
        }
    }

    /* access modifiers changed from: private */
    public static final void startSendAudio$lambda$20(PcmEncodedData pcmEncodedData) {
        if (pcmEncodedData instanceof PcmEncodedData.ByteData) {
            byte[] a2 = ((PcmEncodedData.ByteData) pcmEncodedData).a();
            AndroidAssistantApiHandler androidAssistantApiHandler = INSTANCE;
            if (androidAssistantApiHandler.getCloudErrorCode() == 0) {
                androidAssistantApiHandler.sendData(a2);
            } else {
                ILog.a(TAG, "startSendAudio: ws未连接，打个点");
            }
        } else {
            EndToEndServiceData endToEndServiceData = new EndToEndServiceData();
            endToEndServiceData.setType("asr");
            AsrCloudOptions asrCloudOptions = new AsrCloudOptions();
            asrCloudOptions.setDeviceId(DeviceUtils.a());
            asrCloudOptions.setRequestId(mLatestTraceId);
            asrCloudOptions.setEvent(AsrConstants.END_AUDIO);
            endToEndServiceData.setPayload(asrCloudOptions);
            INSTANCE.sendMsg(mLatestTraceId, endToEndServiceData);
        }
    }

    public final void bindFlutterApi(@NotNull AndroidAssistantApi.AssistantFlutterApi assistantFlutterApi) {
        Intrinsics.checkNotNullParameter(assistantFlutterApi, "flutterApi");
        mAssistantFlutterApi = assistantFlutterApi;
    }

    public final void broadcastEventToFlutter(@NotNull AndroidAssistantApi.NotifyEvent notifyEvent) {
        Intrinsics.checkNotNullParameter(notifyEvent, "event");
        mainHandler.post(new p(notifyEvent));
    }

    public void connectCloud(@NotNull String str, @NotNull AndroidAssistantApi.Result<Boolean> result) {
        Intrinsics.checkNotNullParameter(str, AssistantConstants.Key.SESSION_ID);
        Intrinsics.checkNotNullParameter(result, "result");
        ILog.a(TAG, "connectCloud: sessionId->" + str);
        if (!Intrinsics.areEqual((Object) str, (Object) mOriginSessionId)) {
            NlpPreprocessorManager.f8482a.e();
        }
        isManualDisconnect = false;
        mOriginSessionId = str;
        String convertSessionId = getConvertSessionId(str);
        if (!Intrinsics.areEqual((Object) convertSessionId, (Object) mLatestSessionId)) {
            mWorkerHandler.removeCallbacksAndMessages((Object) null);
        }
        DotUtil.d("flutter_ws_connect", TuplesKt.to(AssistantConstants.Key.SESSION_ID, convertSessionId));
        mLatestSessionId = convertSessionId;
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.b(), (CoroutineContext) null, (CoroutineStart) null, new AndroidAssistantApiHandler$connectCloud$1(convertSessionId, result, (Continuation<? super AndroidAssistantApiHandler$connectCloud$1>) null), 3, (Object) null);
    }

    public void disconnectCloud(@NotNull String str, @NotNull AndroidAssistantApi.Result<Boolean> result) {
        Intrinsics.checkNotNullParameter(str, AssistantConstants.Key.SESSION_ID);
        Intrinsics.checkNotNullParameter(result, "result");
        ILog.a(TAG, "disconnectCloud: sessionId->" + str);
        isManualDisconnect = true;
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new AndroidAssistantApiHandler$disconnectCloud$1((Continuation<? super AndroidAssistantApiHandler$disconnectCloud$1>) null), 3, (Object) null);
        result.success(Boolean.TRUE);
    }

    public void getAiEnvironment(@NotNull AndroidAssistantApi.Result<AndroidAssistantApi.AiEnvironment> result) {
        Environment currentEnv;
        Intrinsics.checkNotNullParameter(result, "result");
        EnvAbility envAbility = (EnvAbility) AbilityManager.b.b(EnvAbility.class);
        if (envAbility != null && (currentEnv = envAbility.getCurrentEnv()) != null) {
            AndroidAssistantApi.AiEnvironment aiEnvironment = new AndroidAssistantApi.AiEnvironment();
            aiEnvironment.d(currentEnv.getAsrUrl());
            aiEnvironment.e(currentEnv.getNluUrl());
            aiEnvironment.c(currentEnv.getAppId());
            aiEnvironment.f(currentEnv.getUserKey());
            aiEnvironment.g(currentEnv.getUserSecret());
            aiEnvironment.b(currentEnv.getAiRecordUrl());
            result.success(aiEnvironment);
        }
    }

    public int getFunctionType() {
        return mLastFunctionType;
    }

    @NotNull
    public String getVirtualAppName() {
        return AssistantConstants.APPLICATION_ID;
    }

    public void interrupt(@NotNull String str, @NotNull AndroidAssistantApi.Result<Boolean> result) {
        Intrinsics.checkNotNullParameter(str, "traceId");
        Intrinsics.checkNotNullParameter(result, "result");
        ILog.a(TAG, "interrupt: 打断会话->" + str);
        result.success(Boolean.TRUE);
    }

    public void invokeGenericMethod(@NotNull AndroidAssistantApi.InvokeRequest invokeRequest, @NotNull AndroidAssistantApi.Result<AndroidAssistantApi.InvokeResult> result) {
        Intrinsics.checkNotNullParameter(invokeRequest, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        ILog.a(TAG, "invokeGenericMethod: 收到flutter端调用");
        if (Intrinsics.areEqual((Object) invokeRequest.c(), (Object) "getLlmRecommends")) {
            String b = invokeRequest.b();
            Intrinsics.checkNotNull(b);
            mLastFunctionType = 7;
            EndToEndServiceData endToEndServiceData = new EndToEndServiceData();
            endToEndServiceData.setType(CloudResType.LLM_RECOMMEND_RESULT);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("chat_stage", (Object) 0);
            endToEndServiceData.setPayload(jSONObject);
            INSTANCE.sendMsg(b, endToEndServiceData);
            AndroidAssistantApi.InvokeResult invokeResult = new AndroidAssistantApi.InvokeResult();
            invokeResult.b(200L);
            invokeResult.c("好的");
            result.success(invokeResult);
            return;
        }
        FlutterInvokeDelegate.f8477a.a(invokeRequest, result);
    }

    public void iosStopRecorder() {
        audioRecordHelper.n();
        audioRecordHelper.k();
    }

    public final void mockSendNlpToFlutter(@NotNull EndToEndResponse endToEndResponse) {
        Intrinsics.checkNotNullParameter(endToEndResponse, "response");
        String e = GsonUtils.e(endToEndResponse);
        ILog.a(TAG, "mockSendNlpToFlutter: 模拟数据->" + e);
        AndroidAssistantApi.CloudResponse a2 = new AndroidAssistantApi.CloudResponse.Builder().c(endToEndResponse.getRequestId()).d(CloudResType.NLU_RESULT).b(GsonUtils.e(endToEndResponse.getPayload())).a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        sendResToFlutter(a2);
    }

    public void onClose(int i) {
        ILog.a(TAG, "onClose: 收到关闭回调code->" + i);
        isWorking = false;
        launchReconnectTask();
        mainHandler.post(new r(i));
    }

    public void onData(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
    }

    public void onMsg(@NotNull EndToEndResponse endToEndResponse) {
        Intrinsics.checkNotNullParameter(endToEndResponse, "response");
        if (Intrinsics.areEqual((Object) endToEndResponse.getType(), (Object) CloudResType.NLU_RESULT)) {
            DotUtil.a("flutter_query", "nlu耗时", TuplesKt.to("traceId", mLatestTraceId));
        } else {
            AtomicBoolean atomicBoolean = dotRef;
            if (atomicBoolean.get() && Intrinsics.areEqual((Object) endToEndResponse.getType(), (Object) CloudResType.LLM_ANSWER_RESULT)) {
                atomicBoolean.set(false);
                DotUtil.a("flutter_query", "大模型返回首帧耗时", TuplesKt.to("traceId", mLatestTraceId));
            }
        }
        mWorkerHandler.post(new q(endToEndResponse));
    }

    public void onParse() {
        ILog.a(TAG, "onParse: 暂停使用，通知MYVU禁用相关功能");
        isParsed = true;
        AndroidAssistantApi.NotifyEvent notifyEvent = new AndroidAssistantApi.NotifyEvent();
        notifyEvent.c("assistant_state");
        notifyEvent.b("launch");
        INSTANCE.broadcastEventToFlutter(notifyEvent);
    }

    @Subscribe
    public final void onReceiveNetworkEvent(@NotNull NetworkEvent networkEvent) {
        Intrinsics.checkNotNullParameter(networkEvent, "event");
        boolean z = isNetworkOk;
        boolean a2 = networkEvent.a();
        isNetworkOk = a2;
        if (!z && a2 && !isManualDisconnect) {
            ILog.a(TAG, "onNetworkStateChange: 网络恢复，重连");
            reconnectServer();
        }
    }

    public void onResume() {
        ILog.a(TAG, "onResume: 恢复使用，通知MYVU启用相关功能");
        isParsed = false;
        AndroidAssistantApi.NotifyEvent notifyEvent = new AndroidAssistantApi.NotifyEvent();
        notifyEvent.c("assistant_state");
        notifyEvent.b("exit");
        INSTANCE.broadcastEventToFlutter(notifyEvent);
        if (!isWorking && isNetworkOk) {
            reconnectServer();
        }
    }

    public /* bridge */ /* synthetic */ void sendTextToCloud(String str, String str2, String str3, Boolean bool, AndroidAssistantApi.Result result) {
        sendTextToCloud(str, str2, str3, bool.booleanValue(), (AndroidAssistantApi.Result<Boolean>) result);
    }

    public /* bridge */ /* synthetic */ void startSendAudio(String str, Boolean bool, AndroidAssistantApi.Result result) {
        startSendAudio(str, bool.booleanValue(), (AndroidAssistantApi.Result<Boolean>) result);
    }

    public boolean endSendAudio() {
        getPcmEncoder().flush();
        return true;
    }

    public boolean sendAudioToCloud(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        getPcmEncoder().encode(bArr);
        return true;
    }

    public void sendTextToCloud(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull AndroidAssistantApi.Result<Boolean> result) {
        NluRequest talkReq;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "traceId");
        Intrinsics.checkNotNullParameter(str3, "resource");
        Intrinsics.checkNotNullParameter(result, "result");
        ILog.a(TAG, "sendTextToCloud: 发送消息给云端->" + str + "，resource->" + str3);
        if (getCloudErrorCode() != 0) {
            result.success(Boolean.FALSE);
            return;
        }
        dotRef.set(true);
        mLatestTraceId = str2;
        mLastFunctionType = 2;
        JSONArray parseArray = JSON.parseArray(str3);
        NluAbility nluAbility = (NluAbility) AbilityManager.b.b(NluAbility.class);
        if (!(nluAbility == null || (talkReq = nluAbility.getTalkReq(new TalkInfo(str2, str, true))) == null)) {
            MetaData metadata = talkReq.getMetadata();
            AndroidAssistantApiHandler androidAssistantApiHandler = INSTANCE;
            metadata.setOriginType(androidAssistantApiHandler.getConvertOriginType());
            talkReq.getMetadata().setDeviceId(androidAssistantApiHandler.getConvertDeviceId());
            talkReq.getMetadata().setSessionFirstFlag(z);
            NlpCompact.b(talkReq);
            EndToEndServiceData endToEndServiceData = new EndToEndServiceData();
            endToEndServiceData.setType("nlp");
            endToEndServiceData.setPayload(talkReq);
            if (parseArray == null || !(!parseArray.isEmpty())) {
                androidAssistantApiHandler.sendMsg(str2, endToEndServiceData);
            } else {
                EndToEndServiceData endToEndServiceData2 = new EndToEndServiceData();
                endToEndServiceData2.setType("myvuLlm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("files", parseArray);
                endToEndServiceData2.setPayload(jSONObject);
                androidAssistantApiHandler.sendMsg(str2, endToEndServiceData, endToEndServiceData2);
            }
            DotUtil.d("flutter_query", TuplesKt.to("traceId", mLatestTraceId), TuplesKt.to(SearchIntents.EXTRA_QUERY, str));
        }
        result.success(Boolean.TRUE);
    }

    public void startSendAudio(@NotNull String str, boolean z, @NotNull AndroidAssistantApi.Result<Boolean> result) {
        Unit unit;
        Intrinsics.checkNotNullParameter(str, "traceId");
        Intrinsics.checkNotNullParameter(result, "result");
        mLatestTraceId = str;
        mLastFunctionType = 0;
        AudioRecordHelper audioRecordHelper2 = audioRecordHelper;
        AudioRecordHelper.j(audioRecordHelper2, 0, 0, AndroidAssistantApiHandler$startSendAudio$1$1.INSTANCE, new AndroidAssistantApiHandler$startSendAudio$1$2(audioRecordHelper2, str), 3, (Object) null);
        audioRecordHelper2.m();
        AbilityManager abilityManager = AbilityManager.b;
        CacheAbility cacheAbility = (CacheAbility) abilityManager.b(CacheAbility.class);
        if (cacheAbility != null) {
            String b = getPcmEncoder().b();
            String str2 = (String) cacheAbility.getCacheWithDefault("IotDeviceId", "");
            String a2 = DeviceUtils.a();
            String str3 = (String) cacheAbility.getCacheWithDefault("mzUid", "");
            AsrAudioInfo asrAudioInfo = new AsrAudioInfo();
            asrAudioInfo.setAudioType(b);
            asrAudioInfo.setChannel(1);
            asrAudioInfo.setSampleBytes(2);
            asrAudioInfo.setSampleRate(16000);
            asrAudioInfo.setEnablePunctuation(true);
            Object cache = cacheAbility.getCache("hotWords");
            if (cache != null) {
                Intrinsics.checkNotNull(cache);
                asrAudioInfo.setHotWords((List) cache);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                asrAudioInfo.setHotWords(CollectionsKt.emptyList());
            }
            EndToEndServiceData endToEndServiceData = new EndToEndServiceData();
            endToEndServiceData.setType("asr");
            AsrCloudOptions asrCloudOptions = new AsrCloudOptions();
            asrCloudOptions.setDeviceId(a2);
            asrCloudOptions.setRequestId(str);
            asrCloudOptions.setIotDeviceId(str2);
            asrCloudOptions.setAccountId(str3);
            asrCloudOptions.setInputLanguageCode("en-GB");
            asrCloudOptions.setData(asrAudioInfo);
            asrCloudOptions.setEvent(AsrConstants.SYNC_AUDIO_INFO);
            endToEndServiceData.setPayload(asrCloudOptions);
            Unit unit2 = Unit.INSTANCE;
            EndToEndServiceData endToEndServiceData2 = new EndToEndServiceData();
            endToEndServiceData2.setType("nlp");
            NluAbility nluAbility = (NluAbility) abilityManager.b(NluAbility.class);
            if (nluAbility != null) {
                NluRequest talkReq = nluAbility.getTalkReq(new TalkInfo(str, "", true));
                MetaData metadata = talkReq.getMetadata();
                AndroidAssistantApiHandler androidAssistantApiHandler = INSTANCE;
                metadata.setOriginType(androidAssistantApiHandler.getConvertOriginType());
                talkReq.getMetadata().setDeviceId(androidAssistantApiHandler.getConvertDeviceId());
                talkReq.getMetadata().setSessionFirstFlag(z);
                Intrinsics.checkNotNull(talkReq);
                NlpCompact.b(talkReq);
                endToEndServiceData2.setPayload(talkReq);
                sendMsg(str, endToEndServiceData, endToEndServiceData2);
                getPcmEncoder().a(new s());
                getPcmEncoder().start();
                result.success(Boolean.TRUE);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
