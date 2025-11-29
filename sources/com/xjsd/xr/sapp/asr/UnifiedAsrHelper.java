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
import com.xjsd.xr.sapp.asr.dao.AsrRequestConfig;
import com.xjsd.xr.sapp.asr.dao.AsrRequestData;
import com.xjsd.xr.sapp.asr.dao.AsrResponse;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.TtsConfig;
import com.xjsd.xr.sapp.asr.dao.TtsData;
import com.xjsd.xr.sapp.asr.thread.ThreadPollHelper;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import com.xjsd.xr.sapp.asr.utils.AsrResultExtKt;
import com.xjsd.xr.sapp.asr.utils.UlogExtKt;
import java.net.SocketException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u00012\u00020\u0001:\b\u0001\u0001\u0001\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010.\u001a\u00020\u0011H\u0002J\b\u0010/\u001a\u00020\u0011H\u0002J\b\u00100\u001a\u000201H\u0002J\u0014\u00102\u001a\u0004\u0018\u00010\u001d2\b\u00103\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u00104\u001a\u00020 H\u0002J\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001dH\u0002J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0003H\u0002J\u0010\u0010:\u001a\u0002082\u0006\u00109\u001a\u00020\u0003H\u0002J\u0010\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u0002082\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010B\u001a\u0002082\u0006\u0010?\u001a\u00020@H\u0002J\u0006\u0010C\u001a\u00020\u0005J\u001a\u0010D\u001a\u0002082\b\b\u0002\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u0002082\u0006\u0010?\u001a\u00020@H\u0002J\u001a\u0010I\u001a\u0002082\u0006\u0010J\u001a\u00020\b2\b\b\u0002\u0010K\u001a\u00020\u0003H\u0002J\u001c\u0010L\u001a\u0002082\u0006\u0010M\u001a\u00020N2\n\b\u0002\u0010<\u001a\u0004\u0018\u000101H\u0002J\u0006\u0010O\u001a\u000208J\u001c\u0010P\u001a\u0002082\n\b\u0002\u0010<\u001a\u0004\u0018\u0001012\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010Q\u001a\u0002082\u0006\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u000208H\u0002J\u0010\u0010U\u001a\u0002082\u0006\u0010R\u001a\u00020SH\u0002J\b\u0010V\u001a\u000208H\u0002J\u0010\u0010W\u001a\u00020S2\u0006\u0010X\u001a\u00020SH\u0002J\u001a\u0010Y\u001a\u0002082\u0006\u0010Z\u001a\u00020\b2\b\b\u0002\u0010[\u001a\u00020\u0005H\u0002J\u0019\u0010\\\u001a\u0002082\u0006\u0010Z\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010]J\u0016\u0010^\u001a\u0002082\u0006\u0010_\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\rJ\u0006\u0010a\u001a\u000208J\b\u0010b\u001a\u000208H\u0002J\u0010\u0010c\u001a\u00020S2\u0006\u0010X\u001a\u00020SH\u0002J\u001c\u0010d\u001a\u00020\b2\b\u0010e\u001a\u0004\u0018\u00010\u001d2\b\u0010f\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010g\u001a\u000208H\u0002J\u0006\u0010h\u001a\u000208J\u000e\u0010i\u001a\u0002082\u0006\u0010j\u001a\u00020kJ\u001c\u0010l\u001a\u0002082\n\u0010m\u001a\u00060nR\u00020\u00002\u0006\u00103\u001a\u00020\u001dH\u0002J\u0006\u0010o\u001a\u000208J\u000e\u0010p\u001a\u0002082\u0006\u0010j\u001a\u00020kJ\u001c\u0010q\u001a\u0002082\n\u0010m\u001a\u00060rR\u00020\u00002\u0006\u00103\u001a\u00020\u001dH\u0002J\u0006\u0010s\u001a\u000208J\u0010\u0010t\u001a\u0002082\u0006\u00103\u001a\u00020\u001dH\u0002J\u0010\u0010u\u001a\u0002082\u0006\u00103\u001a\u00020\u001dH\u0002J\u001e\u0010v\u001a\u0002082\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u001dJ2\u0010v\u001a\u0002082\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010w\u001a\u00020\u00052\b\b\u0002\u0010x\u001a\u00020\u0005J\b\u0010y\u001a\u000208H\u0002J\u0011\u0010z\u001a\u000208H@ø\u0001\u0000¢\u0006\u0002\u0010{J\b\u0010|\u001a\u000208H\u0002J\u0011\u0010}\u001a\u000208H@ø\u0001\u0000¢\u0006\u0002\u0010{J\u0006\u0010~\u001a\u000208J\u0016\u0010\u001a\u0002082\u0006\u0010_\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper;", "", "functionUniqueName", "", "isReturnPerResultFirstTime", "", "(Ljava/lang/String;Z)V", "mAsrChannelType", "", "getMAsrChannelType$annotations", "()V", "mCallbackMap", "", "Lcom/xjsd/xr/sapp/asr/callback/AsrResultCallback;", "mExecutingReconnectJob", "Lkotlinx/coroutines/Job;", "mIoScope", "Lkotlinx/coroutines/CoroutineScope;", "mIsAutoReconnect", "mIsAutoReconnecting", "mIsExecutingReconnect", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsExecutingReconnectDelay", "mIsProximalResultFirstPrint", "mIsRemoteResultFirstPrint", "mIsUserClosedSocket", "mProximalAsrRequest", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequest;", "mProximalAsrRequestConfig", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig;", "mProximalFeedCoroutine", "mProximalSendAudioFirstTime", "", "mProximalSendAudioLen", "mProximalSocketState", "Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper$WebSocketState;", "mProximalWebSocket", "Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket;", "mReconnectCount", "mRemoteAsrRequest", "mRemoteAsrRequestConfig", "mRemoteFeedCoroutine", "mRemoteSendAudioFirstTime", "mRemoteSendAudioLen", "mRemoteSocketState", "mRemoteWebSocket", "createFeedScope", "createIoScope", "getNetworkErrorResponse", "Lokhttp3/Response;", "getReconnectAsrRequestConfig", "requestConfig", "getReconnectTime", "getSyncAudioInfoRequest", "config", "handleErrorState", "", "mark", "handleErrorStateDualChannel", "handleProximalMessage", "response", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "handleProximalMessageSuccess", "asrResponse", "Lcom/xjsd/xr/sapp/asr/dao/AsrResponse;", "handleRemoteMessage", "handleRemoteMessageSuccess", "isAutoReconnecting", "notifyAsrRunningSensitiveState", "type", "sensitivePayload", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "notifyAsrRunningState", "notifyClosed", "code", "reason", "notifyFailed", "t", "", "notifyNetworkConnected", "notifyOpen", "notifyProximalAsrResult", "result", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "notifyReconnectSuccess", "notifyRemoteAsrResult", "proximalSocketFailedToClose", "proximalTranscribedIntervalTime", "finalResult", "reconnectRequest", "reconnectMark", "isNeedCallBack", "reconnectToStopRequest", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerAsrResultCallback", "key", "callback", "release", "remoteSocketFailedToClose", "remoteTranscribedIntervalTime", "requestWebChannelType", "remoteConfig", "proximalConfig", "resetSendAudioLen", "sendEndMessage", "sendProximalAudioData", "data", "", "sendProximalChannelInfo", "socket", "Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper$ProximalWebSocket;", "sendProximalEndMessage", "sendRemoteAudioData", "sendRemoteChannelInfo", "Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper$RemoteWebSocket;", "sendRemoteEndMessage", "startProximalRequest", "startRemoteRequest", "startRequest", "isAutoReconnect", "isCalculateFirstResultTime", "stopProximalRequest", "stopProximalRequestNotCoroutine", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopRemoteRequest", "stopRemoteRequestNotCoroutine", "stopRequest", "unRegisterAsrResultCallback", "Companion", "ProximalWebSocket", "RemoteWebSocket", "WebSocketState", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUnifiedAsrHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnifiedAsrHelper.kt\ncom/xjsd/xr/sapp/asr/UnifiedAsrHelper\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1787:1\n215#2,2:1788\n215#2,2:1790\n215#2,2:1792\n215#2,2:1794\n215#2,2:1796\n215#2,2:1798\n215#2,2:1800\n215#2,2:1802\n215#2,2:1804\n215#2,2:1806\n215#2,2:1808\n215#2,2:1810\n215#2,2:1812\n215#2,2:1814\n215#2,2:1816\n1#3:1818\n*S KotlinDebug\n*F\n+ 1 UnifiedAsrHelper.kt\ncom/xjsd/xr/sapp/asr/UnifiedAsrHelper\n*L\n776#1:1788,2\n908#1:1790,2\n961#1:1792,2\n972#1:1794,2\n1004#1:1796,2\n1024#1:1798,2\n1044#1:1800,2\n1061#1:1802,2\n1088#1:1804,2\n1097#1:1806,2\n1124#1:1808,2\n1132#1:1810,2\n1140#1:1812,2\n1194#1:1814,2\n1225#1:1816,2\n*E\n"})
public final class UnifiedAsrHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String MARK_PROXIMAL = "proximal";
    @NotNull
    private static final String MARK_REMOTE = "remote";
    private static final long RECONNECT_BASE_TIME = 5000;
    private static final int RECONNECT_MARK_INVALID = 0;
    private static final int RECONNECT_MARK_PROXIMAL = 2;
    private static final int RECONNECT_MARK_REMOTE = 1;
    private static final long RECONNECT_MAX_TIME = 60000;
    @NotNull
    private static final String TAG = "UnifiedAsrHelper";
    /* access modifiers changed from: private */
    @NotNull
    public final String functionUniqueName;
    private final boolean isReturnPerResultFirstTime;
    /* access modifiers changed from: private */
    public int mAsrChannelType;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, AsrResultCallback> mCallbackMap;
    @Nullable
    private Job mExecutingReconnectJob;
    /* access modifiers changed from: private */
    @NotNull
    public CoroutineScope mIoScope;
    /* access modifiers changed from: private */
    public boolean mIsAutoReconnect;
    /* access modifiers changed from: private */
    public boolean mIsAutoReconnecting;
    /* access modifiers changed from: private */
    @NotNull
    public AtomicBoolean mIsExecutingReconnect;
    /* access modifiers changed from: private */
    @NotNull
    public AtomicBoolean mIsExecutingReconnectDelay;
    /* access modifiers changed from: private */
    public boolean mIsProximalResultFirstPrint;
    /* access modifiers changed from: private */
    public boolean mIsRemoteResultFirstPrint;
    /* access modifiers changed from: private */
    @NotNull
    public AtomicBoolean mIsUserClosedSocket;
    /* access modifiers changed from: private */
    @Nullable
    public AsrRequest mProximalAsrRequest;
    /* access modifiers changed from: private */
    @Nullable
    public AsrRequestConfig mProximalAsrRequestConfig;
    /* access modifiers changed from: private */
    @NotNull
    public CoroutineScope mProximalFeedCoroutine;
    /* access modifiers changed from: private */
    public long mProximalSendAudioFirstTime;
    /* access modifiers changed from: private */
    public long mProximalSendAudioLen;
    /* access modifiers changed from: private */
    @Nullable
    public WebSocketState mProximalSocketState;
    /* access modifiers changed from: private */
    @Nullable
    public VirtualWebSocket mProximalWebSocket;
    /* access modifiers changed from: private */
    public int mReconnectCount;
    /* access modifiers changed from: private */
    @Nullable
    public AsrRequest mRemoteAsrRequest;
    /* access modifiers changed from: private */
    @Nullable
    public AsrRequestConfig mRemoteAsrRequestConfig;
    /* access modifiers changed from: private */
    @NotNull
    public CoroutineScope mRemoteFeedCoroutine;
    /* access modifiers changed from: private */
    public long mRemoteSendAudioFirstTime;
    /* access modifiers changed from: private */
    public long mRemoteSendAudioLen;
    /* access modifiers changed from: private */
    @Nullable
    public WebSocketState mRemoteSocketState;
    /* access modifiers changed from: private */
    @Nullable
    public VirtualWebSocket mRemoteWebSocket;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper$Companion;", "", "()V", "MARK_PROXIMAL", "", "MARK_REMOTE", "RECONNECT_BASE_TIME", "", "RECONNECT_MARK_INVALID", "", "RECONNECT_MARK_PROXIMAL", "RECONNECT_MARK_REMOTE", "RECONNECT_MAX_TIME", "TAG", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @SourceDebugExtension({"SMAP\nUnifiedAsrHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnifiedAsrHelper.kt\ncom/xjsd/xr/sapp/asr/UnifiedAsrHelper$ProximalWebSocket\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1787:1\n215#2,2:1788\n*S KotlinDebug\n*F\n+ 1 UnifiedAsrHelper.kt\ncom/xjsd/xr/sapp/asr/UnifiedAsrHelper$ProximalWebSocket\n*L\n280#1:1788,2\n*E\n"})
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper$ProximalWebSocket;", "Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket;", "(Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper;)V", "getFunctionType", "", "getVirtualAppName", "", "onClose", "", "code", "onData", "data", "", "onMsg", "response", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "onParse", "onResume", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ProximalWebSocket extends VirtualWebSocket {
        public ProximalWebSocket() {
        }

        public int getFunctionType() {
            return 3;
        }

        @NotNull
        public String getVirtualAppName() {
            return UnifiedAsrHelper.this.functionUniqueName;
        }

        public void onClose(int i) {
            UnifiedAsrHelper.this.mIsAutoReconnecting = false;
            UnifiedAsrHelper.this.mReconnectCount = 0;
            if (i == 10005) {
                UlogExtKt.logI("ProximalWebSocket onClosed code=" + i, UnifiedAsrHelper.TAG);
                WebSocketState access$getMProximalSocketState$p = UnifiedAsrHelper.this.mProximalSocketState;
                if (access$getMProximalSocketState$p != null) {
                    access$getMProximalSocketState$p.setClosed(true);
                }
                UnifiedAsrHelper.notifyClosed$default(UnifiedAsrHelper.this, i, (String) null, 2, (Object) null);
            } else if (i != 10011) {
                UlogExtKt.logI("RemoteWebSocket onFailure other error[code:" + i + ']', UnifiedAsrHelper.TAG);
                UnifiedAsrHelper.notifyFailed$default(UnifiedAsrHelper.this, new SocketException("Proximal webSocket use connect error"), (Response) null, 2, (Object) null);
                WebSocketState access$getMProximalSocketState$p2 = UnifiedAsrHelper.this.mProximalSocketState;
                if (access$getMProximalSocketState$p2 != null) {
                    access$getMProximalSocketState$p2.setOpened(false);
                }
            } else if (UnifiedAsrHelper.this.mIsAutoReconnect) {
                UlogExtKt.logI("ProximalWebSocket reconnect code=" + i, UnifiedAsrHelper.TAG);
                UnifiedAsrHelper.this.reconnectRequest(2, true);
            } else {
                UlogExtKt.logI("ProximalWebSocket onFailure network error[code:" + i + ']', UnifiedAsrHelper.TAG);
                UnifiedAsrHelper.this.notifyFailed(new SocketException("Proximal webSocket use connect error"), UnifiedAsrHelper.this.getNetworkErrorResponse());
                WebSocketState access$getMProximalSocketState$p3 = UnifiedAsrHelper.this.mProximalSocketState;
                if (access$getMProximalSocketState$p3 != null) {
                    access$getMProximalSocketState$p3.setOpened(false);
                }
            }
        }

        public void onData(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "data");
            for (Map.Entry value : UnifiedAsrHelper.this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value.getValue()).onProximalTts(new TtsData(bArr, 0, 2, (DefaultConstructorMarker) null));
            }
        }

        public void onMsg(@NotNull EndToEndResponse endToEndResponse) {
            Intrinsics.checkNotNullParameter(endToEndResponse, "response");
            UnifiedAsrHelper.this.handleProximalMessage(endToEndResponse);
        }

        public void onParse() {
        }

        public void onResume() {
        }
    }

    @SourceDebugExtension({"SMAP\nUnifiedAsrHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnifiedAsrHelper.kt\ncom/xjsd/xr/sapp/asr/UnifiedAsrHelper$RemoteWebSocket\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1787:1\n215#2,2:1788\n*S KotlinDebug\n*F\n+ 1 UnifiedAsrHelper.kt\ncom/xjsd/xr/sapp/asr/UnifiedAsrHelper$RemoteWebSocket\n*L\n209#1:1788,2\n*E\n"})
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper$RemoteWebSocket;", "Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket;", "(Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper;)V", "getFunctionType", "", "getVirtualAppName", "", "onClose", "", "code", "onData", "data", "", "onMsg", "response", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "onParse", "onResume", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class RemoteWebSocket extends VirtualWebSocket {
        public RemoteWebSocket() {
        }

        public int getFunctionType() {
            return 3;
        }

        @NotNull
        public String getVirtualAppName() {
            return UnifiedAsrHelper.this.functionUniqueName;
        }

        public void onClose(int i) {
            UnifiedAsrHelper.this.mIsAutoReconnecting = false;
            UnifiedAsrHelper.this.mReconnectCount = 0;
            if (i == 10005) {
                UlogExtKt.logI("RemoteWebSocket onClosed code=" + i, UnifiedAsrHelper.TAG);
                WebSocketState access$getMRemoteSocketState$p = UnifiedAsrHelper.this.mRemoteSocketState;
                if (access$getMRemoteSocketState$p != null) {
                    access$getMRemoteSocketState$p.setClosed(true);
                }
                UnifiedAsrHelper.notifyClosed$default(UnifiedAsrHelper.this, i, (String) null, 2, (Object) null);
            } else if (i != 10011) {
                UlogExtKt.logI("RemoteWebSocket onFailure other error[code:" + i + ']', UnifiedAsrHelper.TAG);
                UnifiedAsrHelper.notifyFailed$default(UnifiedAsrHelper.this, new SocketException("Remote webSocket use connect error"), (Response) null, 2, (Object) null);
                WebSocketState access$getMRemoteSocketState$p2 = UnifiedAsrHelper.this.mRemoteSocketState;
                if (access$getMRemoteSocketState$p2 != null) {
                    access$getMRemoteSocketState$p2.setOpened(false);
                }
            } else if (UnifiedAsrHelper.this.mIsAutoReconnect) {
                UlogExtKt.logI("RemoteWebSocket reconnect code=" + i, UnifiedAsrHelper.TAG);
                UnifiedAsrHelper.this.reconnectRequest(1, true);
            } else {
                UlogExtKt.logI("RemoteWebSocket onFailure network error[code:" + i + ']', UnifiedAsrHelper.TAG);
                UnifiedAsrHelper.this.notifyFailed(new SocketException("Remote webSocket use connect error"), UnifiedAsrHelper.this.getNetworkErrorResponse());
                WebSocketState access$getMRemoteSocketState$p3 = UnifiedAsrHelper.this.mRemoteSocketState;
                if (access$getMRemoteSocketState$p3 != null) {
                    access$getMRemoteSocketState$p3.setOpened(false);
                }
            }
        }

        public void onData(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "data");
            for (Map.Entry value : UnifiedAsrHelper.this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value.getValue()).onRemoteTts(new TtsData(bArr, 0, 2, (DefaultConstructorMarker) null));
            }
        }

        public void onMsg(@NotNull EndToEndResponse endToEndResponse) {
            Intrinsics.checkNotNullParameter(endToEndResponse, "response");
            UnifiedAsrHelper.this.handleRemoteMessage(endToEndResponse);
        }

        public void onParse() {
        }

        public void onResume() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper$WebSocketState;", "", "()V", "isClosed", "", "()Z", "setClosed", "(Z)V", "isMsgError", "setMsgError", "isMsgStarted", "setMsgStarted", "isOpened", "setOpened", "toString", "", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class WebSocketState {
        private boolean isClosed;
        private boolean isMsgError;
        private boolean isMsgStarted;
        private boolean isOpened;

        public final boolean isClosed() {
            return this.isClosed;
        }

        public final boolean isMsgError() {
            return this.isMsgError;
        }

        public final boolean isMsgStarted() {
            return this.isMsgStarted;
        }

        public final boolean isOpened() {
            return this.isOpened;
        }

        public final void setClosed(boolean z) {
            this.isClosed = z;
        }

        public final void setMsgError(boolean z) {
            this.isMsgError = z;
        }

        public final void setMsgStarted(boolean z) {
            this.isMsgStarted = z;
        }

        public final void setOpened(boolean z) {
            this.isOpened = z;
        }

        @NotNull
        public String toString() {
            return "WebSocketState(isOpened=" + this.isOpened + ", isClosed=" + this.isClosed + ", isMsgStarted=" + this.isMsgStarted + ", isMsgError=" + this.isMsgError + ')';
        }
    }

    public UnifiedAsrHelper(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "functionUniqueName");
        this.functionUniqueName = str;
        this.isReturnPerResultFirstTime = z;
        this.mCallbackMap = new LinkedHashMap();
        this.mRemoteFeedCoroutine = createFeedScope();
        this.mProximalFeedCoroutine = createFeedScope();
        this.mIoScope = createIoScope();
        this.mIsUserClosedSocket = new AtomicBoolean(false);
        this.mIsExecutingReconnect = new AtomicBoolean(false);
        this.mIsExecutingReconnectDelay = new AtomicBoolean(false);
    }

    /* access modifiers changed from: private */
    public final CoroutineScope createFeedScope() {
        return CoroutineScopeKt.a(ExecutorsKt.b(ThreadPollHelper.INSTANCE.newHighPrioritySingleThreadExecutor()).plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    }

    private final CoroutineScope createIoScope() {
        return CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    }

    private static /* synthetic */ void getMAsrChannelType$annotations() {
    }

    /* access modifiers changed from: private */
    public final Response getNetworkErrorResponse() {
        return new Response.Builder().request(new Request.Builder().url("http://example.com").build()).protocol(Protocol.HTTP_1_1).code(10011).message("WebSocket network error").build();
    }

    /* access modifiers changed from: private */
    public final AsrRequestConfig getReconnectAsrRequestConfig(AsrRequestConfig asrRequestConfig) {
        TtsConfig ttsConfig = null;
        if (asrRequestConfig == null) {
            return null;
        }
        TtsConfig tts = asrRequestConfig.getTts();
        if (tts != null) {
            ttsConfig = new TtsConfig.Builder().voiceId(tts.getVoiceId()).reqId(tts.getReqId()).text("").audioFormat(tts.getAudioFormat()).returnFormat(tts.getReturnFormat()).compressionRate(tts.getCompressionRate()).language(tts.getLanguage()).gender(tts.getGender()).textType(tts.getTextType()).build();
        }
        return new AsrRequestConfig.Builder().webType(asrRequestConfig.getWebType()).srcLang(asrRequestConfig.getSrcLang()).dstLang(asrRequestConfig.getDstLang()).deviceId(asrRequestConfig.getDeviceId()).iotDeviceId(asrRequestConfig.getIotDeviceId()).supplier(asrRequestConfig.getSupplier()).appName(asrRequestConfig.getAppName()).data(asrRequestConfig.getData()).recognizeData(asrRequestConfig.getRecognizeData()).accountId(asrRequestConfig.getAccountId()).tts(ttsConfig).role(asrRequestConfig.getRole()).concatenationStratey(asrRequestConfig.getConcatenationStratey()).audioSize(asrRequestConfig.getAudioSize()).audioTotalDuration(asrRequestConfig.getAudioTotalDuration()).build();
    }

    /* access modifiers changed from: private */
    public final long getReconnectTime() {
        int i = this.mReconnectCount;
        this.mReconnectCount = i + 1;
        Long valueOf = Long.valueOf(((long) i) * 5000);
        if (valueOf.longValue() > 60000) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.longValue();
        }
        return 60000;
    }

    private final AsrRequest getSyncAudioInfoRequest(AsrRequestConfig asrRequestConfig) {
        String str;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String replace$default = StringsKt.replace$default(uuid, LunarCalendar.DATE_SEPARATOR, "", false, 4, (Object) null);
        String deviceId = asrRequestConfig.getDeviceId();
        AsrRequestData asrRequestData = new AsrRequestData(asrRequestConfig.getData().getAudioType(), asrRequestConfig.getData().getSampleRate(), asrRequestConfig.getData().getChannel(), asrRequestConfig.getData().getSampleBytes(), asrRequestConfig.getData().getHotWords(), asrRequestConfig.getData().getEnablePunctuation());
        String asrSha256 = AsrExtKt.asrSha256(asrRequestConfig.getIotDeviceId());
        String accountId = asrRequestConfig.getAccountId();
        String srcLang = asrRequestConfig.getSrcLang();
        String dstLang = !Intrinsics.areEqual((Object) asrRequestConfig.getSrcLang(), (Object) asrRequestConfig.getDstLang()) ? asrRequestConfig.getDstLang() : null;
        String supplier = asrRequestConfig.getSupplier();
        String appName = asrRequestConfig.getAppName();
        AsrRequestConfig.RecognizeData recognizeData = asrRequestConfig.getRecognizeData();
        if (recognizeData == null || (str = AsrExtKt.toRecognizeId(recognizeData)) == null) {
            str = "";
        }
        return new AsrRequest(replace$default, AsrConstants.SYNC_AUDIO_INFO, deviceId, asrRequestData, (String) null, asrSha256, accountId, srcLang, dstLang, true, supplier, appName, str, asrRequestConfig.getTts() != null, asrRequestConfig.getTts(), asrRequestConfig.getRole(), asrRequestConfig.getConcatenationStratey(), asrRequestConfig.getAudioSize(), asrRequestConfig.getAudioTotalDuration());
    }

    private final void handleErrorState(String str) {
        UlogExtKt.logI("handleErrorState channelType=" + AsrExtKt.accessChannelToStr(this.mAsrChannelType), TAG);
        this.mIsAutoReconnecting = false;
        this.mReconnectCount = 0;
        int i = this.mAsrChannelType;
        if (i == 1) {
            handleErrorStateDualChannel(str);
        } else if (i == 2) {
            stopRemoteRequest();
        } else if (i != 3) {
            UlogExtKt.logI("handleRunningState 无效的通道类型，请查看AsrConstants中支持的通道类型！", TAG);
        } else {
            stopProximalRequest();
        }
    }

    private final void handleErrorStateDualChannel(String str) {
        boolean z = false;
        if (Intrinsics.areEqual((Object) str, (Object) MARK_REMOTE)) {
            WebSocketState webSocketState = this.mRemoteSocketState;
            boolean isMsgError = webSocketState != null ? webSocketState.isMsgError() : false;
            WebSocketState webSocketState2 = this.mProximalSocketState;
            if (webSocketState2 != null) {
                z = webSocketState2.isOpened();
            }
            UlogExtKt.logI("handleErrorStateDualChannel MARK_REMOTE remoteMsgError=" + isMsgError + ", proximalOpened=" + z, TAG);
            if (isMsgError) {
                stopRemoteRequest();
                if (z) {
                    stopProximalRequest();
                }
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) MARK_PROXIMAL)) {
            WebSocketState webSocketState3 = this.mProximalSocketState;
            boolean isMsgError2 = webSocketState3 != null ? webSocketState3.isMsgError() : false;
            WebSocketState webSocketState4 = this.mRemoteSocketState;
            if (webSocketState4 != null) {
                z = webSocketState4.isOpened();
            }
            UlogExtKt.logI("handleErrorStateDualChannel MARK_PROXIMAL proximalMsgError=" + isMsgError2 + ", remoteOpened=" + z, TAG);
            if (isMsgError2) {
                stopProximalRequest();
                if (z) {
                    stopRemoteRequest();
                }
            }
        } else {
            UlogExtKt.logI("handleErrorStateDualChannel 无效的标记类型=" + str, TAG);
        }
    }

    /* access modifiers changed from: private */
    public final void handleProximalMessage(EndToEndResponse endToEndResponse) {
        UlogExtKt.logI("handleProximalMessage from service response=" + endToEndResponse, TAG);
        try {
            String type = endToEndResponse.getType();
            if (type != null) {
                int hashCode = type.hashCode();
                if (hashCode != -2070309533) {
                    if (hashCode != -1996684826) {
                        if (hashCode == -1769541146) {
                            if (!type.equals("sensitive_request")) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!type.equals("sensitive_result")) {
                        return;
                    }
                    SensitivePayload sensitivePayload = (SensitivePayload) endToEndResponse.parsePayload(SensitivePayload.class);
                    UlogExtKt.logI("handleProximalMessage sensitivePayload=" + sensitivePayload, TAG);
                    String type2 = endToEndResponse.getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                    Intrinsics.checkNotNull(sensitivePayload);
                    notifyAsrRunningSensitiveState(type2, sensitivePayload);
                } else if (type.equals("infinite-asr-result")) {
                    AsrResponse asrResponse = (AsrResponse) endToEndResponse.parsePayload(AsrResponse.class);
                    UlogExtKt.logI("handleProximalMessage asrResponse=" + asrResponse, TAG);
                    if (Intrinsics.areEqual((Object) asrResponse.getCode(), (Object) "0")) {
                        Intrinsics.checkNotNull(asrResponse);
                        handleProximalMessageSuccess(asrResponse);
                        return;
                    }
                    UlogExtKt.logI("handleProximalMessage 服务异常error code=" + asrResponse.getCode() + ", desc=" + asrResponse.getMsg(), TAG);
                    WebSocketState webSocketState = this.mProximalSocketState;
                    if (webSocketState != null) {
                        webSocketState.setMsgError(true);
                    }
                    Intrinsics.checkNotNull(asrResponse);
                    notifyAsrRunningState(asrResponse);
                    handleErrorState(MARK_PROXIMAL);
                }
            }
        } catch (Exception e) {
            UlogExtKt.logI("handleProximalMessage 服务器数据处理异常 " + ExceptionsKt.stackTraceToString(e), TAG);
        }
    }

    private final void handleProximalMessageSuccess(AsrResponse asrResponse) {
        String event = asrResponse.getEvent();
        switch (event.hashCode()) {
            case -636965025:
                if (event.equals(AsrConstants.SYNC_AUDIO_INFO_SUCCESS)) {
                    UlogExtKt.logI("proximalMessageSuccess 握手成功", TAG);
                    WebSocketState webSocketState = this.mProximalSocketState;
                    if (webSocketState != null) {
                        webSocketState.setMsgStarted(true);
                    }
                    notifyOpen$default(this, (Response) null, asrResponse, 1, (Object) null);
                    return;
                }
                break;
            case 235005312:
                if (event.equals(AsrConstants.ASR_RESULT_SUCCESS)) {
                    AsrResult transcribed = AsrResultExtKt.transcribed(asrResponse, this.mProximalAsrRequest);
                    if (this.isReturnPerResultFirstTime) {
                        transcribed = proximalTranscribedIntervalTime(transcribed);
                    }
                    UlogExtKt.logI("proximalMessageSuccess ASR识别结果=" + transcribed, TAG);
                    notifyProximalAsrResult(transcribed);
                    return;
                }
                break;
            case 799401263:
                if (event.equals(AsrConstants.TRANSLATION_RESULT_SUCCESS)) {
                    AsrResult translation = AsrResultExtKt.translation(asrResponse, this.mProximalAsrRequest);
                    UlogExtKt.logI("proximalMessageSuccess ASR翻译结果=" + translation, TAG);
                    notifyProximalAsrResult(translation);
                    return;
                }
                break;
            case 1962221176:
                if (event.equals(AsrConstants.ASR_TTS_SUCCESS)) {
                    TtsData ttsData = AsrResultExtKt.ttsData(asrResponse);
                    for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
                        ((AsrResultCallback) value.getValue()).onProximalTts(ttsData);
                    }
                    return;
                }
                break;
        }
        UlogExtKt.logI("proximalMessageSuccess 无需处理的事件=" + event, TAG);
    }

    /* access modifiers changed from: private */
    public final void handleRemoteMessage(EndToEndResponse endToEndResponse) {
        UlogExtKt.logI("handleRemoteMessage from service response=" + endToEndResponse, TAG);
        try {
            String type = endToEndResponse.getType();
            if (type != null) {
                int hashCode = type.hashCode();
                if (hashCode != -2070309533) {
                    if (hashCode != -1996684826) {
                        if (hashCode == -1769541146) {
                            if (!type.equals("sensitive_request")) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!type.equals("sensitive_result")) {
                        return;
                    }
                    SensitivePayload sensitivePayload = (SensitivePayload) endToEndResponse.parsePayload(SensitivePayload.class);
                    UlogExtKt.logI("handleRemoteMessage sensitivePayload=" + sensitivePayload, TAG);
                    String type2 = endToEndResponse.getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                    Intrinsics.checkNotNull(sensitivePayload);
                    notifyAsrRunningSensitiveState(type2, sensitivePayload);
                } else if (type.equals("infinite-asr-result")) {
                    AsrResponse asrResponse = (AsrResponse) endToEndResponse.parsePayload(AsrResponse.class);
                    UlogExtKt.logI("handleRemoteMessage asrResponse=" + asrResponse, TAG);
                    if (Intrinsics.areEqual((Object) asrResponse.getCode(), (Object) "0")) {
                        Intrinsics.checkNotNull(asrResponse);
                        handleRemoteMessageSuccess(asrResponse);
                        return;
                    }
                    UlogExtKt.logI("handleRemoteMessage 服务异常error code=" + asrResponse.getCode() + ", desc=" + asrResponse.getMsg(), TAG);
                    WebSocketState webSocketState = this.mRemoteSocketState;
                    if (webSocketState != null) {
                        webSocketState.setMsgError(true);
                    }
                    Intrinsics.checkNotNull(asrResponse);
                    notifyAsrRunningState(asrResponse);
                    handleErrorState(MARK_REMOTE);
                }
            }
        } catch (Exception e) {
            UlogExtKt.logI("handleRemoteMessage 服务器数据处理异常 " + ExceptionsKt.stackTraceToString(e), TAG);
        }
    }

    private final void handleRemoteMessageSuccess(AsrResponse asrResponse) {
        String event = asrResponse.getEvent();
        switch (event.hashCode()) {
            case -636965025:
                if (event.equals(AsrConstants.SYNC_AUDIO_INFO_SUCCESS)) {
                    UlogExtKt.logI("remoteMessageSuccess 握手成功！", TAG);
                    WebSocketState webSocketState = this.mRemoteSocketState;
                    if (webSocketState != null) {
                        webSocketState.setMsgStarted(true);
                    }
                    notifyOpen$default(this, (Response) null, asrResponse, 1, (Object) null);
                    return;
                }
                break;
            case 235005312:
                if (event.equals(AsrConstants.ASR_RESULT_SUCCESS)) {
                    AsrResult transcribed = AsrResultExtKt.transcribed(asrResponse, this.mRemoteAsrRequest);
                    if (this.isReturnPerResultFirstTime) {
                        transcribed = remoteTranscribedIntervalTime(transcribed);
                    }
                    UlogExtKt.logI("remoteMessageSuccess ASR识别结果=" + transcribed, TAG);
                    notifyRemoteAsrResult(transcribed);
                    return;
                }
                break;
            case 799401263:
                if (event.equals(AsrConstants.TRANSLATION_RESULT_SUCCESS)) {
                    AsrResult translation = AsrResultExtKt.translation(asrResponse, this.mRemoteAsrRequest);
                    UlogExtKt.logI("remoteMessageSuccess ASR翻译结果=" + translation, TAG);
                    notifyRemoteAsrResult(translation);
                    return;
                }
                break;
            case 1962221176:
                if (event.equals(AsrConstants.ASR_TTS_SUCCESS)) {
                    TtsData ttsData = AsrResultExtKt.ttsData(asrResponse);
                    for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
                        ((AsrResultCallback) value.getValue()).onRemoteTts(ttsData);
                    }
                    return;
                }
                break;
        }
        UlogExtKt.logI("remoteMessageSuccess 无需处理的事件=" + event, TAG);
    }

    private final void notifyAsrRunningSensitiveState(String str, SensitivePayload sensitivePayload) {
        try {
            AsrMessageState asrMessageState = new AsrMessageState(sensitivePayload.getRiskLevel(), Intrinsics.areEqual((Object) str, (Object) "sensitive_request") ? "2001" : "2002", sensitivePayload.getRiskDescription(), (String) null, (String) null, 24, (DefaultConstructorMarker) null);
            UlogExtKt.logI("notifyAsrRunningSensitiveState asrMessageState=" + asrMessageState + ", callback size=" + this.mCallbackMap.size(), TAG);
            for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value.getValue()).onAsrRunningState(asrMessageState);
            }
        } catch (Exception e) {
            UlogExtKt.logI("notifyAsrRunningSensitiveState error=" + ExceptionsKt.stackTraceToString(e), TAG);
        }
    }

    public static /* synthetic */ void notifyAsrRunningSensitiveState$default(UnifiedAsrHelper unifiedAsrHelper, String str, SensitivePayload sensitivePayload, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "sensitive_request";
        }
        unifiedAsrHelper.notifyAsrRunningSensitiveState(str, sensitivePayload);
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
        UlogExtKt.logI("notifyClosed channelType=" + AsrExtKt.accessChannelToStr(this.mAsrChannelType), TAG);
        UlogExtKt.logI("notifyClosed remote=" + this.mRemoteSocketState + ", proximal=" + this.mProximalSocketState, TAG);
        int i2 = this.mAsrChannelType;
        if (i2 == 1) {
            WebSocketState webSocketState = this.mRemoteSocketState;
            boolean z = false;
            boolean isClosed = webSocketState != null ? webSocketState.isClosed() : false;
            WebSocketState webSocketState2 = this.mProximalSocketState;
            if (webSocketState2 != null) {
                z = webSocketState2.isClosed();
            }
            UlogExtKt.logI("notifyClosed remoteClosed=" + isClosed + ", proximalClosed=" + z + ", callback size=" + this.mCallbackMap.size(), TAG);
            if (isClosed && z) {
                for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
                    ((AsrResultCallback) value.getValue()).onClosed(i, str);
                }
            }
        } else if (i2 == 2 || i2 == 3) {
            UlogExtKt.logI("notifyClosed callback size=" + this.mCallbackMap.size(), TAG);
            for (Map.Entry<String, AsrResultCallback> value2 : this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value2.getValue()).onClosed(i, str);
            }
        } else {
            UlogExtKt.logI("notifyClosed:: 无效的通道类型，请查看TranslationChannel中支持的通道类型！", TAG);
        }
    }

    public static /* synthetic */ void notifyClosed$default(UnifiedAsrHelper unifiedAsrHelper, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "WebSocket is closed";
        }
        unifiedAsrHelper.notifyClosed(i, str);
    }

    /* access modifiers changed from: private */
    public final void notifyFailed(Throwable th, Response response) {
        UlogExtKt.logI("notifyFailed channelType=" + AsrExtKt.accessChannelToStr(this.mAsrChannelType), TAG);
        UlogExtKt.logI("notifyFailed remote=" + this.mRemoteSocketState + ", proximal=" + this.mProximalSocketState, TAG);
        int i = this.mAsrChannelType;
        if (i == 1) {
            remoteSocketFailedToClose();
            proximalSocketFailedToClose();
            UlogExtKt.logI("notifyFailed callback size=" + this.mCallbackMap.size(), TAG);
            for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value.getValue()).onFailure(th, response);
            }
        } else if (i == 2) {
            remoteSocketFailedToClose();
            UlogExtKt.logI("notifyFailed callback size=" + this.mCallbackMap.size(), TAG);
            for (Map.Entry<String, AsrResultCallback> value2 : this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value2.getValue()).onFailure(th, response);
            }
        } else if (i != 3) {
            UlogExtKt.logI("notifyFailed:: 无效的通道类型，请查看AsrConstants中支持的通道类型！", TAG);
        } else {
            proximalSocketFailedToClose();
            UlogExtKt.logI("notifyFailed callback size=" + this.mCallbackMap.size(), TAG);
            for (Map.Entry<String, AsrResultCallback> value3 : this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value3.getValue()).onFailure(th, response);
            }
        }
    }

    public static /* synthetic */ void notifyFailed$default(UnifiedAsrHelper unifiedAsrHelper, Throwable th, Response response, int i, Object obj) {
        if ((i & 2) != 0) {
            response = null;
        }
        unifiedAsrHelper.notifyFailed(th, response);
    }

    private final void notifyOpen(Response response, AsrResponse asrResponse) {
        UlogExtKt.logI("notifyOpen channelType=" + AsrExtKt.accessChannelToStr(this.mAsrChannelType), TAG);
        UlogExtKt.logI("notifyOpen remote=" + this.mRemoteSocketState + ", proximal=" + this.mProximalSocketState, TAG);
        int i = this.mAsrChannelType;
        boolean z = false;
        if (i == 1) {
            WebSocketState webSocketState = this.mRemoteSocketState;
            boolean isMsgStarted = webSocketState != null ? webSocketState.isMsgStarted() : false;
            WebSocketState webSocketState2 = this.mProximalSocketState;
            if (webSocketState2 != null) {
                z = webSocketState2.isMsgStarted();
            }
            UlogExtKt.logI("notifyOpen remoteMsgStarted=" + isMsgStarted + ", proximalMsgStarted=" + z + ", callback size=" + this.mCallbackMap.size(), TAG);
            if (isMsgStarted && z) {
                if (this.mIsAutoReconnecting) {
                    notifyReconnectSuccess();
                    return;
                }
                for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
                    ((AsrResultCallback) value.getValue()).onOpen(response);
                }
                notifyAsrRunningState(asrResponse);
            }
        } else if (i == 2) {
            WebSocketState webSocketState3 = this.mRemoteSocketState;
            if (webSocketState3 != null) {
                z = webSocketState3.isMsgStarted();
            }
            UlogExtKt.logI("notifyOpen remoteMsgStarted=" + z + ", callback size=" + this.mCallbackMap.size(), TAG);
            if (z) {
                if (this.mIsAutoReconnecting) {
                    notifyReconnectSuccess();
                    return;
                }
                for (Map.Entry<String, AsrResultCallback> value2 : this.mCallbackMap.entrySet()) {
                    ((AsrResultCallback) value2.getValue()).onOpen(response);
                }
                notifyAsrRunningState(asrResponse);
            }
        } else if (i != 3) {
            UlogExtKt.logI("notifyOpen 无效的通道类型，请查看AsrConstants中支持的通道类型！", TAG);
        } else {
            WebSocketState webSocketState4 = this.mProximalSocketState;
            if (webSocketState4 != null) {
                z = webSocketState4.isMsgStarted();
            }
            UlogExtKt.logI("notifyOpen proximalMsgStarted=" + z + ", callback size=" + this.mCallbackMap.size(), TAG);
            if (z) {
                if (this.mIsAutoReconnecting) {
                    notifyReconnectSuccess();
                    return;
                }
                for (Map.Entry<String, AsrResultCallback> value3 : this.mCallbackMap.entrySet()) {
                    ((AsrResultCallback) value3.getValue()).onOpen(response);
                }
                notifyAsrRunningState(asrResponse);
            }
        }
    }

    public static /* synthetic */ void notifyOpen$default(UnifiedAsrHelper unifiedAsrHelper, Response response, AsrResponse asrResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            response = null;
        }
        unifiedAsrHelper.notifyOpen(response, asrResponse);
    }

    private final void notifyProximalAsrResult(AsrResult asrResult) {
        for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
            ((AsrResultCallback) value.getValue()).onProximalAsrResult(asrResult);
        }
    }

    private final void notifyReconnectSuccess() {
        UlogExtKt.logI("notifyReconnectSuccess no need to call back Socket open again", TAG);
        for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
            ((AsrResultCallback) value.getValue()).onAsrReconnectSuccess();
        }
        this.mIsAutoReconnecting = false;
        this.mReconnectCount = 0;
    }

    private final void notifyRemoteAsrResult(AsrResult asrResult) {
        for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
            ((AsrResultCallback) value.getValue()).onRemoteAsrResult(asrResult);
        }
    }

    private final void proximalSocketFailedToClose() {
        WebSocketState webSocketState = this.mProximalSocketState;
        boolean z = false;
        boolean isOpened = webSocketState != null ? webSocketState.isOpened() : false;
        WebSocketState webSocketState2 = this.mProximalSocketState;
        if (webSocketState2 != null) {
            z = webSocketState2.isMsgStarted();
        }
        UlogExtKt.logI("proximalSocketFailedToClose proximalOpened=" + isOpened + ", proximalMsgStarted=" + z, TAG);
        if (isOpened) {
            stopProximalRequest();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.xjsd.xr.sapp.asr.dao.AsrResult proximalTranscribedIntervalTime(com.xjsd.xr.sapp.asr.dao.AsrResult r9) {
        /*
            r8 = this;
            com.xjsd.xr.sapp.asr.dao.Src r0 = r9.getSrc()
            r1 = 0
            if (r0 == 0) goto L_0x0038
            int r2 = r0.getType()
            if (r2 != 0) goto L_0x0010
            r2 = 0
            r8.mIsProximalResultFirstPrint = r2
        L_0x0010:
            boolean r2 = r8.mIsProximalResultFirstPrint
            if (r2 != 0) goto L_0x0038
            int r2 = r0.getType()
            r3 = 1
            if (r2 != r3) goto L_0x0038
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r6 = r8.mProximalSendAudioFirstTime
            long r4 = r4 - r6
            long r6 = r0.getEndTime()
            long r4 = r4 - r6
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            long r4 = r8.mProximalSendAudioLen
            r2 = 32
            long r6 = (long) r2
            long r4 = r4 / r6
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r8.mIsProximalResultFirstPrint = r3
            goto L_0x003a
        L_0x0038:
            r0 = r1
            r2 = r0
        L_0x003a:
            if (r0 == 0) goto L_0x005d
            com.xjsd.xr.sapp.asr.dao.ResultExt r8 = r9.getExt()
            if (r8 == 0) goto L_0x004f
            com.xjsd.xr.sapp.asr.dao.ResultExt r1 = new com.xjsd.xr.sapp.asr.dao.ResultExt
            java.lang.String r3 = r8.getRequestId()
            java.lang.String r8 = r8.getRecognizeId()
            r1.<init>(r3, r8, r0, r2)
        L_0x004f:
            com.xjsd.xr.sapp.asr.dao.AsrResult r8 = new com.xjsd.xr.sapp.asr.dao.AsrResult
            com.xjsd.xr.sapp.asr.dao.Src r0 = r9.getSrc()
            com.xjsd.xr.sapp.asr.dao.Dst r9 = r9.getDst()
            r8.<init>(r0, r9, r1)
            r9 = r8
        L_0x005d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.UnifiedAsrHelper.proximalTranscribedIntervalTime(com.xjsd.xr.sapp.asr.dao.AsrResult):com.xjsd.xr.sapp.asr.dao.AsrResult");
    }

    /* access modifiers changed from: private */
    public final void reconnectRequest(int i, boolean z) {
        if (this.mIsExecutingReconnect.compareAndSet(false, true)) {
            this.mExecutingReconnectJob = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new UnifiedAsrHelper$reconnectRequest$1(z, this, i, (Continuation<? super UnifiedAsrHelper$reconnectRequest$1>) null), 3, (Object) null);
        } else {
            UlogExtKt.logI("reconnectRequest reconnecting is in progress. Please do not try again.", TAG);
        }
    }

    public static /* synthetic */ void reconnectRequest$default(UnifiedAsrHelper unifiedAsrHelper, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        unifiedAsrHelper.reconnectRequest(i, z);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object reconnectToStopRequest(int r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.xjsd.xr.sapp.asr.UnifiedAsrHelper$reconnectToStopRequest$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper$reconnectToStopRequest$1 r0 = (com.xjsd.xr.sapp.asr.UnifiedAsrHelper$reconnectToStopRequest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper$reconnectToStopRequest$1 r0 = new com.xjsd.xr.sapp.asr.UnifiedAsrHelper$reconnectToStopRequest$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x0051
            if (r2 == r7) goto L_0x0049
            if (r2 == r6) goto L_0x0044
            if (r2 == r5) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00b3
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003c:
            java.lang.Object r9 = r0.L$0
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r9 = (com.xjsd.xr.sapp.asr.UnifiedAsrHelper) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00a4
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00d0
        L_0x0049:
            java.lang.Object r9 = r0.L$0
            com.xjsd.xr.sapp.asr.UnifiedAsrHelper r9 = (com.xjsd.xr.sapp.asr.UnifiedAsrHelper) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c1
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r2 = "reconnectToStopRequest reconnectMark["
            r11.append(r2)
            r11.append(r10)
            java.lang.String r8 = "], channelType["
            r11.append(r8)
            int r8 = r9.mAsrChannelType
            java.lang.String r8 = com.xjsd.xr.sapp.asr.utils.AsrExtKt.accessChannelToStr(r8)
            r11.append(r8)
            r8 = 93
            r11.append(r8)
            java.lang.String r11 = r11.toString()
            java.lang.String r8 = "UnifiedAsrHelper"
            com.xjsd.xr.sapp.asr.utils.UlogExtKt.logD(r11, r8)
            if (r10 == r7) goto L_0x00b6
            if (r10 == r6) goto L_0x0099
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r10)
            java.lang.String r10 = "] error"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.xjsd.xr.sapp.asr.utils.UlogExtKt.logI(r9, r8)
            goto L_0x00d3
        L_0x0099:
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r10 = r9.stopProximalRequestNotCoroutine(r0)
            if (r10 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            int r10 = r9.mAsrChannelType
            if (r10 != r7) goto L_0x00d3
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r9 = r9.stopRemoteRequestNotCoroutine(r0)
            if (r9 != r1) goto L_0x00b3
            return r1
        L_0x00b3:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00b6:
            r0.L$0 = r9
            r0.label = r7
            java.lang.Object r10 = r9.stopRemoteRequestNotCoroutine(r0)
            if (r10 != r1) goto L_0x00c1
            return r1
        L_0x00c1:
            int r10 = r9.mAsrChannelType
            if (r10 != r7) goto L_0x00d3
            r0.L$0 = r3
            r0.label = r6
            java.lang.Object r9 = r9.stopProximalRequestNotCoroutine(r0)
            if (r9 != r1) goto L_0x00d0
            return r1
        L_0x00d0:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00d3:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.UnifiedAsrHelper.reconnectToStopRequest(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void remoteSocketFailedToClose() {
        WebSocketState webSocketState = this.mRemoteSocketState;
        boolean z = false;
        boolean isOpened = webSocketState != null ? webSocketState.isOpened() : false;
        WebSocketState webSocketState2 = this.mRemoteSocketState;
        if (webSocketState2 != null) {
            z = webSocketState2.isMsgStarted();
        }
        UlogExtKt.logI("remoteSocketFailedToClose remoteOpened=" + isOpened + ", remoteMsgStarted=" + z, TAG);
        if (isOpened) {
            stopRemoteRequest();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.xjsd.xr.sapp.asr.dao.AsrResult remoteTranscribedIntervalTime(com.xjsd.xr.sapp.asr.dao.AsrResult r9) {
        /*
            r8 = this;
            com.xjsd.xr.sapp.asr.dao.Src r0 = r9.getSrc()
            r1 = 0
            if (r0 == 0) goto L_0x0038
            int r2 = r0.getType()
            if (r2 != 0) goto L_0x0010
            r2 = 0
            r8.mIsRemoteResultFirstPrint = r2
        L_0x0010:
            boolean r2 = r8.mIsRemoteResultFirstPrint
            if (r2 != 0) goto L_0x0038
            int r2 = r0.getType()
            r3 = 1
            if (r2 != r3) goto L_0x0038
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r6 = r8.mRemoteSendAudioFirstTime
            long r4 = r4 - r6
            long r6 = r0.getEndTime()
            long r4 = r4 - r6
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            long r4 = r8.mRemoteSendAudioLen
            r2 = 32
            long r6 = (long) r2
            long r4 = r4 / r6
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r8.mIsRemoteResultFirstPrint = r3
            goto L_0x003a
        L_0x0038:
            r0 = r1
            r2 = r0
        L_0x003a:
            if (r0 == 0) goto L_0x005d
            com.xjsd.xr.sapp.asr.dao.ResultExt r8 = r9.getExt()
            if (r8 == 0) goto L_0x004f
            com.xjsd.xr.sapp.asr.dao.ResultExt r1 = new com.xjsd.xr.sapp.asr.dao.ResultExt
            java.lang.String r3 = r8.getRequestId()
            java.lang.String r8 = r8.getRecognizeId()
            r1.<init>(r3, r8, r0, r2)
        L_0x004f:
            com.xjsd.xr.sapp.asr.dao.AsrResult r8 = new com.xjsd.xr.sapp.asr.dao.AsrResult
            com.xjsd.xr.sapp.asr.dao.Src r0 = r9.getSrc()
            com.xjsd.xr.sapp.asr.dao.Dst r9 = r9.getDst()
            r8.<init>(r0, r9, r1)
            r9 = r8
        L_0x005d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.UnifiedAsrHelper.remoteTranscribedIntervalTime(com.xjsd.xr.sapp.asr.dao.AsrResult):com.xjsd.xr.sapp.asr.dao.AsrResult");
    }

    private final int requestWebChannelType(AsrRequestConfig asrRequestConfig, AsrRequestConfig asrRequestConfig2) {
        if (asrRequestConfig != null && asrRequestConfig2 != null) {
            return 1;
        }
        if (asrRequestConfig != null) {
            return 2;
        }
        return asrRequestConfig2 != null ? 3 : 0;
    }

    private final void resetSendAudioLen() {
        long j = (long) 32;
        long j2 = this.mRemoteSendAudioLen / j;
        long j3 = this.mProximalSendAudioLen / j;
        AsrRequest asrRequest = this.mRemoteAsrRequest;
        String str = null;
        String requestId = asrRequest != null ? asrRequest.getRequestId() : null;
        AsrRequest asrRequest2 = this.mProximalAsrRequest;
        if (asrRequest2 != null) {
            str = asrRequest2.getRequestId();
        }
        UlogExtKt.logI("resetSendAudioLen Remote[sendTime=" + j2 + "(ms), requestId=" + requestId + "] ,Proximal[sendTime=" + j3 + "(ms), requestId=" + str + ']', TAG);
        this.mRemoteSendAudioLen = 0;
        this.mProximalSendAudioLen = 0;
    }

    /* access modifiers changed from: private */
    public final void sendProximalChannelInfo(ProximalWebSocket proximalWebSocket, AsrRequestConfig asrRequestConfig) {
        Unit unit;
        UlogExtKt.logI("sendProximalChannelInfo requestConfig=" + asrRequestConfig, TAG);
        AsrRequest syncAudioInfoRequest = getSyncAudioInfoRequest(asrRequestConfig);
        this.mProximalAsrRequest = syncAudioInfoRequest;
        if (syncAudioInfoRequest != null) {
            String requestId = syncAudioInfoRequest.getRequestId();
            UlogExtKt.logI("sendProximalChannelInfo tranceId=" + requestId + ", proximalRequest=" + syncAudioInfoRequest, TAG);
            if (asrRequestConfig.getTts() != null) {
                EndToEndServiceData endToEndServiceData = new EndToEndServiceData();
                endToEndServiceData.setType("asr");
                endToEndServiceData.setPayload(syncAudioInfoRequest);
                Unit unit2 = Unit.INSTANCE;
                EndToEndServiceData endToEndServiceData2 = new EndToEndServiceData();
                endToEndServiceData2.setType("tts");
                endToEndServiceData2.setPayload(asrRequestConfig.getTts());
                proximalWebSocket.sendMsg(requestId, endToEndServiceData, endToEndServiceData2);
            } else {
                EndToEndServiceData endToEndServiceData3 = new EndToEndServiceData();
                endToEndServiceData3.setType("asr");
                endToEndServiceData3.setPayload(syncAudioInfoRequest);
                Unit unit3 = Unit.INSTANCE;
                proximalWebSocket.sendMsg(requestId, endToEndServiceData3);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            UlogExtKt.logI("sendProximalChannelInfo proximalRequest is null", TAG);
        }
    }

    /* access modifiers changed from: private */
    public final void sendRemoteChannelInfo(RemoteWebSocket remoteWebSocket, AsrRequestConfig asrRequestConfig) {
        Unit unit;
        UlogExtKt.logI("sendRemoteChannelInfo requestConfig=" + asrRequestConfig, TAG);
        AsrRequest syncAudioInfoRequest = getSyncAudioInfoRequest(asrRequestConfig);
        this.mRemoteAsrRequest = syncAudioInfoRequest;
        if (syncAudioInfoRequest != null) {
            String requestId = syncAudioInfoRequest.getRequestId();
            UlogExtKt.logI("sendRemoteChannelInfo tranceId=" + requestId + ", remoteRequest=" + syncAudioInfoRequest, TAG);
            if (asrRequestConfig.getTts() != null) {
                EndToEndServiceData endToEndServiceData = new EndToEndServiceData();
                endToEndServiceData.setType("asr");
                endToEndServiceData.setPayload(syncAudioInfoRequest);
                Unit unit2 = Unit.INSTANCE;
                EndToEndServiceData endToEndServiceData2 = new EndToEndServiceData();
                endToEndServiceData2.setType("tts");
                endToEndServiceData2.setPayload(asrRequestConfig.getTts());
                remoteWebSocket.sendMsg(requestId, endToEndServiceData, endToEndServiceData2);
            } else {
                EndToEndServiceData endToEndServiceData3 = new EndToEndServiceData();
                endToEndServiceData3.setType("asr");
                endToEndServiceData3.setPayload(syncAudioInfoRequest);
                Unit unit3 = Unit.INSTANCE;
                remoteWebSocket.sendMsg(requestId, endToEndServiceData3);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            UlogExtKt.logI("sendRemoteChannelInfo remoteRequest is null", TAG);
        }
    }

    private final void startProximalRequest(AsrRequestConfig asrRequestConfig) {
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new UnifiedAsrHelper$startProximalRequest$1(asrRequestConfig, this, (Continuation<? super UnifiedAsrHelper$startProximalRequest$1>) null), 3, (Object) null);
    }

    private final void startRemoteRequest(AsrRequestConfig asrRequestConfig) {
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new UnifiedAsrHelper$startRemoteRequest$1(asrRequestConfig, this, (Continuation<? super UnifiedAsrHelper$startRemoteRequest$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ void startRequest$default(UnifiedAsrHelper unifiedAsrHelper, AsrRequestConfig asrRequestConfig, AsrRequestConfig asrRequestConfig2, int i, Object obj) {
        if ((i & 1) != 0) {
            asrRequestConfig = null;
        }
        if ((i & 2) != 0) {
            asrRequestConfig2 = null;
        }
        unifiedAsrHelper.startRequest(asrRequestConfig, asrRequestConfig2);
    }

    private final void stopProximalRequest() {
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new UnifiedAsrHelper$stopProximalRequest$1(this, (Continuation<? super UnifiedAsrHelper$stopProximalRequest$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object stopProximalRequestNotCoroutine(Continuation<? super Unit> continuation) {
        Object g = BuildersKt.g(Dispatchers.b(), new UnifiedAsrHelper$stopProximalRequestNotCoroutine$2(this, (Continuation<? super UnifiedAsrHelper$stopProximalRequestNotCoroutine$2>) null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }

    private final void stopRemoteRequest() {
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new UnifiedAsrHelper$stopRemoteRequest$1(this, (Continuation<? super UnifiedAsrHelper$stopRemoteRequest$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object stopRemoteRequestNotCoroutine(Continuation<? super Unit> continuation) {
        Object g = BuildersKt.g(Dispatchers.b(), new UnifiedAsrHelper$stopRemoteRequestNotCoroutine$2(this, (Continuation<? super UnifiedAsrHelper$stopRemoteRequestNotCoroutine$2>) null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }

    public final boolean isAutoReconnecting() {
        return this.mIsAutoReconnecting;
    }

    public final void notifyNetworkConnected() {
        UlogExtKt.logI("notifyNetworkConnected mIsAutoReconnect=" + this.mIsAutoReconnect + ", mIsExecutingReconnect=" + this.mIsExecutingReconnect.get() + ", mIsExecutingReconnectDelay=" + this.mIsExecutingReconnectDelay.get(), TAG);
        if (this.mIsAutoReconnect && this.mIsExecutingReconnect.get() && this.mIsExecutingReconnectDelay.get()) {
            this.mIsExecutingReconnect.set(false);
            this.mIsExecutingReconnectDelay.set(false);
            Job job = this.mExecutingReconnectJob;
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
            }
            this.mExecutingReconnectJob = null;
            this.mReconnectCount = 0;
            reconnectRequest$default(this, 0, false, 2, (Object) null);
        }
    }

    public final void registerAsrResultCallback(@NotNull String str, @NotNull AsrResultCallback asrResultCallback) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(asrResultCallback, "callback");
        this.mCallbackMap.put(str, asrResultCallback);
    }

    public final void release() {
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new UnifiedAsrHelper$release$1(this, (Continuation<? super UnifiedAsrHelper$release$1>) null), 3, (Object) null);
    }

    public final void sendEndMessage() {
        sendRemoteEndMessage();
        sendProximalEndMessage();
    }

    public final void sendProximalAudioData(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        Job unused = BuildersKt__Builders_commonKt.d(this.mProximalFeedCoroutine, (CoroutineContext) null, (CoroutineStart) null, new UnifiedAsrHelper$sendProximalAudioData$1(this, bArr, (Continuation<? super UnifiedAsrHelper$sendProximalAudioData$1>) null), 3, (Object) null);
    }

    public final void sendProximalEndMessage() {
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new UnifiedAsrHelper$sendProximalEndMessage$1(this, (Continuation<? super UnifiedAsrHelper$sendProximalEndMessage$1>) null), 3, (Object) null);
    }

    public final void sendRemoteAudioData(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        Job unused = BuildersKt__Builders_commonKt.d(this.mRemoteFeedCoroutine, (CoroutineContext) null, (CoroutineStart) null, new UnifiedAsrHelper$sendRemoteAudioData$1(this, bArr, (Continuation<? super UnifiedAsrHelper$sendRemoteAudioData$1>) null), 3, (Object) null);
    }

    public final void sendRemoteEndMessage() {
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoScope, (CoroutineContext) null, (CoroutineStart) null, new UnifiedAsrHelper$sendRemoteEndMessage$1(this, (Continuation<? super UnifiedAsrHelper$sendRemoteEndMessage$1>) null), 3, (Object) null);
    }

    public final void startRequest(@Nullable AsrRequestConfig asrRequestConfig, @Nullable AsrRequestConfig asrRequestConfig2) {
        startRequest$default(this, asrRequestConfig, asrRequestConfig2, false, false, 8, (Object) null);
    }

    public final void stopRequest() {
        UlogExtKt.logI("stopRequest channelType=" + AsrExtKt.accessChannelToStr(this.mAsrChannelType), TAG);
        this.mIsUserClosedSocket.set(true);
        this.mIsAutoReconnect = false;
        this.mIsAutoReconnecting = false;
        this.mReconnectCount = 0;
        this.mIsExecutingReconnect.set(false);
        Job job = this.mExecutingReconnectJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.mExecutingReconnectJob = null;
        this.mIsExecutingReconnectDelay.set(false);
        resetSendAudioLen();
        int i = this.mAsrChannelType;
        if (i == 1) {
            stopRemoteRequest();
            stopProximalRequest();
        } else if (i == 2) {
            stopRemoteRequest();
        } else if (i != 3) {
            UlogExtKt.logI("stopRequest 关闭ASR WebSocket失败", TAG);
        } else {
            stopProximalRequest();
        }
    }

    public final void unRegisterAsrResultCallback(@NotNull String str, @NotNull AsrResultCallback asrResultCallback) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(asrResultCallback, "callback");
        this.mCallbackMap.remove(str, asrResultCallback);
    }

    public static /* synthetic */ void startRequest$default(UnifiedAsrHelper unifiedAsrHelper, AsrRequestConfig asrRequestConfig, AsrRequestConfig asrRequestConfig2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            asrRequestConfig = null;
        }
        if ((i & 2) != 0) {
            asrRequestConfig2 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        unifiedAsrHelper.startRequest(asrRequestConfig, asrRequestConfig2, z, z2);
    }

    public final void startRequest(@Nullable AsrRequestConfig asrRequestConfig, @Nullable AsrRequestConfig asrRequestConfig2, boolean z, boolean z2) {
        Unit unit;
        Unit unit2;
        UlogExtKt.logI("startRequest remoteConfig=" + asrRequestConfig + ", proximalConfig=" + asrRequestConfig2, TAG);
        this.mAsrChannelType = requestWebChannelType(asrRequestConfig, asrRequestConfig2);
        StringBuilder sb = new StringBuilder();
        sb.append("startRequest channelType=");
        sb.append(AsrExtKt.accessChannelToStr(this.mAsrChannelType));
        UlogExtKt.logI(sb.toString(), TAG);
        this.mRemoteSocketState = null;
        this.mProximalSocketState = null;
        this.mRemoteSocketState = new WebSocketState();
        this.mProximalSocketState = new WebSocketState();
        UlogExtKt.logI("startRequest RemoteSocketState=" + this.mRemoteSocketState + ", ProximalSocketState=" + this.mProximalSocketState, TAG);
        this.mIsUserClosedSocket.set(false);
        this.mIsAutoReconnect = z;
        int i = this.mAsrChannelType;
        if (i != 1) {
            if (i == 2) {
                if (asrRequestConfig != null) {
                    startRemoteRequest(asrRequestConfig);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    UlogExtKt.logE$default("startRequest 请求开启远端通道必须传递远端翻译请求配置！", TAG, (Throwable) null, 2, (Object) null);
                }
            } else if (i != 3) {
                UlogExtKt.logE$default("startRequest 请设置正确的请求配置！", TAG, (Throwable) null, 2, (Object) null);
            } else {
                if (asrRequestConfig2 != null) {
                    startProximalRequest(asrRequestConfig2);
                    unit2 = Unit.INSTANCE;
                } else {
                    unit2 = null;
                }
                if (unit2 == null) {
                    UlogExtKt.logE$default("startRequest 请求开启近端通道必须传递近端翻译请求配置！", TAG, (Throwable) null, 2, (Object) null);
                }
            }
        } else if (asrRequestConfig == null || asrRequestConfig2 == null) {
            UlogExtKt.logE$default("startRequest 双通道模式下必须同时传递远端翻译请求配置和近端翻译请求配置！", TAG, (Throwable) null, 2, (Object) null);
        } else {
            startRemoteRequest(asrRequestConfig);
            startProximalRequest(asrRequestConfig2);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnifiedAsrHelper(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }
}
