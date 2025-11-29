package com.xjsd.xr.sapp.asr;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.geetest.sdk.t;
import com.meizu.common.util.LunarCalendar;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.xjsd.xr.sapp.asr.callback.AsrResultCallback;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import com.xjsd.xr.sapp.asr.dao.AsrMessageState;
import com.xjsd.xr.sapp.asr.dao.AsrRequest;
import com.xjsd.xr.sapp.asr.dao.AsrRequestConfig;
import com.xjsd.xr.sapp.asr.dao.AsrRequestData;
import com.xjsd.xr.sapp.asr.dao.AsrResponse;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExSensitive;
import com.xjsd.xr.sapp.asr.dao.SpeechEndAudio;
import com.xjsd.xr.sapp.asr.dao.TtsData;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import com.xjsd.xr.sapp.asr.utils.AsrResultExtKt;
import com.xjsd.xr.sapp.asr.utils.GsonHelper;
import com.xjsd.xr.sapp.asr.utils.UlogExtKt;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nLongAudioAsrHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongAudioAsrHelper.kt\ncom/xjsd/xr/sapp/asr/LongAudioAsrHelper\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1590:1\n215#2,2:1591\n215#2,2:1593\n215#2,2:1595\n215#2,2:1597\n215#2,2:1599\n215#2,2:1601\n215#2,2:1603\n215#2,2:1605\n215#2,2:1607\n215#2,2:1609\n215#2,2:1611\n215#2,2:1613\n215#2,2:1615\n215#2,2:1617\n215#2,2:1619\n215#2,2:1621\n*S KotlinDebug\n*F\n+ 1 LongAudioAsrHelper.kt\ncom/xjsd/xr/sapp/asr/LongAudioAsrHelper\n*L\n885#1:1591,2\n913#1:1593,2\n923#1:1595,2\n933#1:1597,2\n963#1:1599,2\n972#1:1601,2\n1001#1:1603,2\n1010#1:1605,2\n1037#1:1607,2\n1045#1:1609,2\n1053#1:1611,2\n1108#1:1613,2\n1119#1:1615,2\n1138#1:1617,2\n1166#1:1619,2\n1409#1:1621,2\n*E\n"})
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0019\b\u0007\u0018\u0000 u2\u00020\u0001:\u0006tuvwxyB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\u0004H\u0002J\u0010\u0010/\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u00100\u001a\u00020*2\u0006\u0010.\u001a\u00020\u0004H\u0002J\u0006\u00101\u001a\u00020*J\u0010\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0017H\u0002J\u0010\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020\bH\u0002J\u0010\u00106\u001a\u00020*2\u0006\u00105\u001a\u00020\bH\u0002J\u0010\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020\bH\u0002J\u0010\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020*2\u0006\u00108\u001a\u00020\bH\u0002J\u0010\u0010=\u001a\u00020*2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010>\u001a\u00020*2\b\b\u0002\u0010?\u001a\u00020\u0004J\u001c\u0010@\u001a\u00020*2\u0006\u0010+\u001a\u00020\b2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BH\u0002J\u0010\u0010C\u001a\u00020*2\u0006\u0010+\u001a\u00020\bH\u0002J\"\u0010D\u001a\u00020*2\u0006\u0010+\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\b\b\u0002\u0010F\u001a\u00020\u0004H\u0002J\u0010\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020*2\u0006\u0010:\u001a\u00020;H\u0002J\u0018\u0010K\u001a\u00020*2\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\bH\u0002J\u0018\u0010N\u001a\u00020*2\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\bH\u0002J\u001a\u0010O\u001a\u00020*2\u0006\u0010A\u001a\u00020B2\b\u0010P\u001a\u0004\u0018\u00010QH\u0002J\u0014\u0010R\u001a\u00020*2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010QH\u0002J\u0010\u0010S\u001a\u00020*2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010V\u001a\u00020*2\u0006\u0010T\u001a\u00020UH\u0002J\b\u0010W\u001a\u00020*H\u0002J\u0016\u0010X\u001a\u00020*2\u0006\u0010E\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\tJ\u0006\u0010Z\u001a\u00020*J\b\u0010[\u001a\u00020*H\u0002J\u001c\u0010\\\u001a\u00020\u00042\b\u0010]\u001a\u0004\u0018\u00010\u00172\b\u0010^\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010_\u001a\u00020*2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010aJ\u0006\u0010c\u001a\u00020*J\u000e\u0010d\u001a\u00020*2\u0006\u0010e\u001a\u00020aJ\b\u0010f\u001a\u00020*H\u0002J\u0010\u0010g\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0006\u0010h\u001a\u00020*J\u000e\u0010i\u001a\u00020*2\u0006\u0010e\u001a\u00020aJ\b\u0010j\u001a\u00020*H\u0002J\u0010\u0010k\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0006\u0010l\u001a\u00020*J\u0010\u0010m\u001a\u00020*2\u0006\u0010n\u001a\u00020\u0017H\u0002J\b\u0010o\u001a\u00020*H\u0002J\u0010\u0010p\u001a\u00020*2\u0006\u0010n\u001a\u00020\u0017H\u0002J\b\u0010q\u001a\u00020*H\u0002J\u001e\u0010r\u001a\u00020*2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0017J\u0016\u0010s\u001a\u00020*2\u0006\u0010E\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0018\u00010\u0019R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0018\u00010%R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006z"}, d2 = {"Lcom/xjsd/xr/sapp/asr/LongAudioAsrHelper;", "", "()V", "mAsrChannelType", "", "getMAsrChannelType$annotations", "mCallbackMap", "", "", "Lcom/xjsd/xr/sapp/asr/callback/AsrResultCallback;", "mHttpClient", "Lokhttp3/OkHttpClient;", "mInitChannel", "getMInitChannel$annotations", "mIsProximalClosed", "", "mIsRemoteClosed", "mProximalAsrRequest", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequest;", "mProximalHandler", "Landroid/os/Handler;", "mProximalHasSend", "mProximalRequestConfig", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig;", "mProximalSocketListener", "Lcom/xjsd/xr/sapp/asr/LongAudioAsrHelper$ProximalSocketListener;", "mProximalSocketState", "Lcom/xjsd/xr/sapp/asr/LongAudioAsrHelper$WebSocketState;", "mProximalThread", "Landroid/os/HandlerThread;", "mProximalWebSocket", "Lokhttp3/WebSocket;", "mRemoteAsrRequest", "mRemoteHandler", "mRemoteHasSend", "mRemoteRequestConfig", "mRemoteSocketListener", "Lcom/xjsd/xr/sapp/asr/LongAudioAsrHelper$RemoteSocketListener;", "mRemoteSocketState", "mRemoteThread", "mRemoteWebSocket", "endProximalData", "", "msg", "Landroid/os/Message;", "endProximalRequest", "voiceEndArg", "endRemoteData", "endRemoteRequest", "endRequest", "getSyncAudioInfoRequest", "config", "handleErrorState", "mark", "handleErrorStateDualChannel", "handleProximalMessage", "text", "handleProximalMessageSuccess", "asrResponse", "Lcom/xjsd/xr/sapp/asr/dao/AsrResponse;", "handleRemoteMessage", "handleRemoteMessageSuccess", "init", "initChannel", "logE", "t", "", "logI", "logReachCount", "key", "count", "notifyAsrRunningSensitiveState", "smartExSensitive", "Lcom/xjsd/xr/sapp/asr/dao/SmartExSensitive;", "notifyAsrRunningState", "notifyClosed", "code", "reason", "notifyClosing", "notifyFailed", "response", "Lokhttp3/Response;", "notifyOpen", "notifyProximalAsrResult", "result", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "notifyRemoteAsrResult", "proximalSocketFailedToClose", "registerAsrResultCallback", "callback", "release", "remoteSocketFailedToClose", "requestWebChannelType", "remoteConfig", "proximalConfig", "sendAudioData", "proximalData", "", "remoteData", "sendEndMessage", "sendProximalAudioData", "data", "sendProximalChannelInfo", "sendProximalData", "sendProximalEndMessage", "sendRemoteAudioData", "sendRemoteChannelInfo", "sendRemoteData", "sendRemoteEndMessage", "startProximalRequest", "requestConfig", "startProximalThread", "startRemoteRequest", "startRemoteThread", "startRequest", "unRegisterAsrResultCallback", "AudioMessage", "Companion", "DataHandler", "ProximalSocketListener", "RemoteSocketListener", "WebSocketState", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(message = "当前长语音直连ASR服务已废弃（虽然仍然可用）全部切换为端云一体服务", replaceWith = @ReplaceWith(expression = "请使用端云一体ASR帮助类 [UnifiedAsrHelper]", imports = {}))
public final class LongAudioAsrHelper {
    private static final long CONNECT_TIMEOUT = 5;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String HANDLER_THREAD_PROXIMAL = "LongAudioAsrProximalThread";
    @NotNull
    private static final String HANDLER_THREAD_REMOTE = "LongAudioAsrRemoteThread";
    @NotNull
    private static final String MARK_PROXIMAL = "proximal";
    @NotNull
    private static final String MARK_REMOTE = "remote";
    private static final long PING_INTERVAL = 15;
    private static final int PROXIMAL_AUDIO_DATA_END = 104;
    private static final int PROXIMAL_AUDIO_DATA_SEND = 103;
    private static final int PROXIMAL_CLOSE_CODE = 1001;
    private static final long READ_TIMEOUT = 5;
    private static final int REMOTE_AUDIO_DATA_END = 102;
    private static final int REMOTE_AUDIO_DATA_SEND = 101;
    private static final int REMOTE_CLOSE_CODE = 1000;
    @NotNull
    private static final String TAG = "LongAudioAsrHelper";
    private static final int VOICE_END_NO_REPLY_ARG = 2;
    private static final int VOICE_END_REPLY_ARG = 1;
    private int mAsrChannelType = 2;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, AsrResultCallback> mCallbackMap = new LinkedHashMap();
    @Nullable
    private OkHttpClient mHttpClient;
    private int mInitChannel = 2;
    private boolean mIsProximalClosed;
    private boolean mIsRemoteClosed;
    @Nullable
    private AsrRequest mProximalAsrRequest;
    @Nullable
    private Handler mProximalHandler;
    private boolean mProximalHasSend;
    @Nullable
    private AsrRequestConfig mProximalRequestConfig;
    @Nullable
    private ProximalSocketListener mProximalSocketListener;
    /* access modifiers changed from: private */
    @Nullable
    public WebSocketState mProximalSocketState;
    @Nullable
    private HandlerThread mProximalThread;
    @Nullable
    private WebSocket mProximalWebSocket;
    @Nullable
    private AsrRequest mRemoteAsrRequest;
    @Nullable
    private Handler mRemoteHandler;
    private boolean mRemoteHasSend;
    @Nullable
    private AsrRequestConfig mRemoteRequestConfig;
    @Nullable
    private RemoteSocketListener mRemoteSocketListener;
    /* access modifiers changed from: private */
    @Nullable
    public WebSocketState mRemoteSocketState;
    @Nullable
    private HandlerThread mRemoteThread;
    @Nullable
    private WebSocket mRemoteWebSocket;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/xjsd/xr/sapp/asr/LongAudioAsrHelper$AudioMessage;", "", "audio", "", "([B)V", "getAudio", "()[B", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AudioMessage {
        @NotNull
        private final byte[] audio;

        public AudioMessage(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "audio");
            this.audio = bArr;
        }

        public static /* synthetic */ AudioMessage copy$default(AudioMessage audioMessage, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = audioMessage.audio;
            }
            return audioMessage.copy(bArr);
        }

        @NotNull
        public final byte[] component1() {
            return this.audio;
        }

        @NotNull
        public final AudioMessage copy(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "audio");
            return new AudioMessage(bArr);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) AudioMessage.class, (Object) obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.xjsd.xr.sapp.asr.LongAudioAsrHelper.AudioMessage");
            return Arrays.equals(this.audio, ((AudioMessage) obj).audio);
        }

        @NotNull
        public final byte[] getAudio() {
            return this.audio;
        }

        public int hashCode() {
            return Arrays.hashCode(this.audio);
        }

        @NotNull
        public String toString() {
            return "AudioMessage(audio=" + Arrays.toString(this.audio) + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/xjsd/xr/sapp/asr/LongAudioAsrHelper$Companion;", "", "()V", "CONNECT_TIMEOUT", "", "HANDLER_THREAD_PROXIMAL", "", "HANDLER_THREAD_REMOTE", "MARK_PROXIMAL", "MARK_REMOTE", "PING_INTERVAL", "PROXIMAL_AUDIO_DATA_END", "", "PROXIMAL_AUDIO_DATA_SEND", "PROXIMAL_CLOSE_CODE", "READ_TIMEOUT", "REMOTE_AUDIO_DATA_END", "REMOTE_AUDIO_DATA_SEND", "REMOTE_CLOSE_CODE", "TAG", "VOICE_END_NO_REPLY_ARG", "VOICE_END_REPLY_ARG", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/xjsd/xr/sapp/asr/LongAudioAsrHelper$DataHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "(Lcom/xjsd/xr/sapp/asr/LongAudioAsrHelper;Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class DataHandler extends Handler {
        final /* synthetic */ LongAudioAsrHelper this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataHandler(@NotNull LongAudioAsrHelper longAudioAsrHelper, Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.this$0 = longAudioAsrHelper;
        }

        public void handleMessage(@NotNull Message message) {
            Intrinsics.checkNotNullParameter(message, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
            super.handleMessage(message);
            switch (message.what) {
                case 101:
                    this.this$0.sendRemoteData(message);
                    return;
                case 102:
                    this.this$0.endRemoteData(message);
                    return;
                case 103:
                    this.this$0.sendProximalData(message);
                    return;
                case 104:
                    this.this$0.endProximalData(message);
                    return;
                default:
                    return;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/xjsd/xr/sapp/asr/LongAudioAsrHelper$WebSocketState;", "", "()V", "isClosed", "", "()Z", "setClosed", "(Z)V", "isMsgError", "setMsgError", "isMsgStarted", "setMsgStarted", "isOpened", "setOpened", "toString", "", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* access modifiers changed from: private */
    public final void endProximalData(Message message) {
        if (this.mProximalWebSocket == null) {
            logI("endProximalData websocket is null, closed=" + this.mIsProximalClosed);
            return;
        }
        int i = message.arg1;
        logI("endRemoteData 关闭近端websocket通道，voiceEndArg=" + i + ", mProximalHasSend=" + this.mProximalHasSend);
        WebSocket webSocket = this.mProximalWebSocket;
        if (webSocket != null) {
            webSocket.close(1001, "Proximal websocket is actively closed");
        }
        this.mProximalWebSocket = null;
        this.mProximalSocketListener = null;
        this.mProximalAsrRequest = null;
        this.mProximalRequestConfig = null;
    }

    private final void endProximalRequest(int i) {
        logI("endProximalRequest！");
        this.mIsProximalClosed = true;
        Handler handler = this.mProximalHandler;
        if (handler != null) {
            handler.removeMessages(103);
            Message obtain = Message.obtain();
            obtain.what = 104;
            obtain.arg1 = i;
            handler.sendMessage(obtain);
            return;
        }
        logI("结束近端音频消息异常");
    }

    /* access modifiers changed from: private */
    public final void endRemoteData(Message message) {
        if (this.mRemoteWebSocket == null) {
            logI("endRemoteData websocket is null, closed=" + this.mIsRemoteClosed);
            return;
        }
        int i = message.arg1;
        logI("endRemoteData 关闭远端websocket通道，voiceEndArg=" + i + ", mRemoteHasSend=" + this.mRemoteHasSend);
        WebSocket webSocket = this.mRemoteWebSocket;
        if (webSocket != null) {
            webSocket.close(1000, "Remote websocket is actively closed");
        }
        this.mRemoteWebSocket = null;
        this.mRemoteSocketListener = null;
        this.mRemoteAsrRequest = null;
        this.mRemoteRequestConfig = null;
    }

    private final void endRemoteRequest(int i) {
        logI("endRemoteRequest！");
        this.mIsRemoteClosed = true;
        Handler handler = this.mRemoteHandler;
        if (handler != null) {
            handler.removeMessages(101);
            Message obtain = Message.obtain();
            obtain.what = 102;
            obtain.arg1 = i;
            handler.sendMessage(obtain);
            return;
        }
        logI("结束远端音频消息异常");
    }

    private static /* synthetic */ void getMAsrChannelType$annotations() {
    }

    private static /* synthetic */ void getMInitChannel$annotations() {
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
        return new AsrRequest(replace$default, AsrConstants.SYNC_AUDIO_INFO, deviceId, asrRequestData, (String) null, asrSha256, accountId, srcLang, dstLang, true, supplier, appName, str, asrRequestConfig.getTts() != null, asrRequestConfig.getTts(), asrRequestConfig.getRole(), asrRequestConfig.getConcatenationStratey(), (Long) null, (Long) null, 393216, (DefaultConstructorMarker) null);
    }

    private final void handleErrorState(String str) {
        logI("handleErrorState channelType=" + AsrExtKt.accessChannelToStr(this.mAsrChannelType));
        int i = this.mAsrChannelType;
        if (i == 1) {
            handleErrorStateDualChannel(str);
        } else if (i == 2) {
            endRemoteRequest(2);
        } else if (i != 3) {
            logI("handleRunningState 无效的通道类型，请查看AsrConstants中支持的通道类型！");
        } else {
            endProximalRequest(2);
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
            logI("handleErrorStateDualChannel MARK_REMOTE remoteMsgError=" + isMsgError + ", proximalOpened=" + z);
            if (isMsgError) {
                endRemoteRequest(2);
                if (z) {
                    endProximalRequest(1);
                }
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) MARK_PROXIMAL)) {
            WebSocketState webSocketState3 = this.mProximalSocketState;
            boolean isMsgError2 = webSocketState3 != null ? webSocketState3.isMsgError() : false;
            WebSocketState webSocketState4 = this.mRemoteSocketState;
            if (webSocketState4 != null) {
                z = webSocketState4.isOpened();
            }
            logI("handleErrorStateDualChannel MARK_PROXIMAL proximalMsgError=" + isMsgError2 + ", remoteOpened=" + z);
            if (isMsgError2) {
                endProximalRequest(2);
                if (z) {
                    endRemoteRequest(1);
                }
            }
        } else {
            logI("handleErrorStateDualChannel 无效的标记类型=" + str);
        }
    }

    /* access modifiers changed from: private */
    public final void handleProximalMessage(String str) {
        logI("handleProximalMessage from service text=" + str);
        if (!StringsKt.isBlank(str)) {
            try {
                if (new JSONObject(str).has("type")) {
                    SmartExSensitive smartExSensitive = (SmartExSensitive) GsonHelper.fromJson(str, SmartExSensitive.class);
                    logI("handleProximalMessage smartExSensitive=" + smartExSensitive);
                    notifyAsrRunningSensitiveState(smartExSensitive);
                    return;
                }
                AsrResponse asrResponse = (AsrResponse) GsonHelper.fromJson(str, AsrResponse.class);
                logI("handleProximalMessage asrResponse=" + asrResponse);
                if (Intrinsics.areEqual((Object) asrResponse.getCode(), (Object) "0")) {
                    handleProximalMessageSuccess(asrResponse);
                    return;
                }
                logI("handleProximalMessage 服务异常error code=" + asrResponse.getCode() + ", desc=" + asrResponse.getMsg());
                WebSocketState webSocketState = this.mProximalSocketState;
                if (webSocketState != null) {
                    webSocketState.setMsgError(true);
                }
                notifyAsrRunningState(asrResponse);
                handleErrorState(MARK_PROXIMAL);
            } catch (Exception e) {
                logI("近端数据处理异常=" + ExceptionsKt.stackTraceToString(e));
            }
        }
    }

    private final void handleProximalMessageSuccess(AsrResponse asrResponse) {
        String event = asrResponse.getEvent();
        switch (event.hashCode()) {
            case -636965025:
                if (event.equals(AsrConstants.SYNC_AUDIO_INFO_SUCCESS)) {
                    logI("proximalMessageSuccess 握手成功");
                    WebSocketState webSocketState = this.mProximalSocketState;
                    if (webSocketState != null) {
                        webSocketState.setMsgStarted(true);
                    }
                    notifyOpen$default(this, (Response) null, 1, (Object) null);
                    notifyAsrRunningState(asrResponse);
                    return;
                }
                break;
            case 235005312:
                if (event.equals(AsrConstants.ASR_RESULT_SUCCESS)) {
                    AsrResult transcribed = AsrResultExtKt.transcribed(asrResponse, this.mProximalAsrRequest);
                    logI("proximalMessageSuccess ASR识别结果=" + transcribed);
                    notifyProximalAsrResult(transcribed);
                    return;
                }
                break;
            case 799401263:
                if (event.equals(AsrConstants.TRANSLATION_RESULT_SUCCESS)) {
                    AsrResult translation = AsrResultExtKt.translation(asrResponse, this.mProximalAsrRequest);
                    logI("proximalMessageSuccess ASR翻译结果=" + translation);
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
        logI("proximalMessageSuccess 无需处理的事件=" + event);
    }

    /* access modifiers changed from: private */
    public final void handleRemoteMessage(String str) {
        logI("handleRemoteMessage from service text=" + str);
        if (!StringsKt.isBlank(str)) {
            try {
                if (new JSONObject(str).has("type")) {
                    SmartExSensitive smartExSensitive = (SmartExSensitive) GsonHelper.fromJson(str, SmartExSensitive.class);
                    logI("handleRemoteMessage smartExSensitive=" + smartExSensitive);
                    notifyAsrRunningSensitiveState(smartExSensitive);
                    return;
                }
                AsrResponse asrResponse = (AsrResponse) GsonHelper.fromJson(str, AsrResponse.class);
                logI("handleRemoteMessage asrResponse=" + asrResponse);
                if (Intrinsics.areEqual((Object) asrResponse.getCode(), (Object) "0")) {
                    handleRemoteMessageSuccess(asrResponse);
                    return;
                }
                logI("handleRemoteMessage 服务异常error code=" + asrResponse.getCode() + ", desc=" + asrResponse.getMsg());
                WebSocketState webSocketState = this.mRemoteSocketState;
                if (webSocketState != null) {
                    webSocketState.setMsgError(true);
                }
                notifyAsrRunningState(asrResponse);
                handleErrorState(MARK_REMOTE);
            } catch (Exception e) {
                logI("handleRemoteMessage 服务器数据处理异常 " + ExceptionsKt.stackTraceToString(e));
            }
        }
    }

    private final void handleRemoteMessageSuccess(AsrResponse asrResponse) {
        String event = asrResponse.getEvent();
        switch (event.hashCode()) {
            case -636965025:
                if (event.equals(AsrConstants.SYNC_AUDIO_INFO_SUCCESS)) {
                    logI("remoteMessageSuccess 握手成功！");
                    WebSocketState webSocketState = this.mRemoteSocketState;
                    if (webSocketState != null) {
                        webSocketState.setMsgStarted(true);
                    }
                    notifyOpen$default(this, (Response) null, 1, (Object) null);
                    notifyAsrRunningState(asrResponse);
                    return;
                }
                break;
            case 235005312:
                if (event.equals(AsrConstants.ASR_RESULT_SUCCESS)) {
                    AsrResult transcribed = AsrResultExtKt.transcribed(asrResponse, this.mRemoteAsrRequest);
                    logI("remoteMessageSuccess ASR识别结果=" + transcribed);
                    notifyRemoteAsrResult(transcribed);
                    return;
                }
                break;
            case 799401263:
                if (event.equals(AsrConstants.TRANSLATION_RESULT_SUCCESS)) {
                    AsrResult translation = AsrResultExtKt.translation(asrResponse, this.mRemoteAsrRequest);
                    logI("remoteMessageSuccess ASR翻译结果=" + translation);
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
        logI("remoteMessageSuccess 无需处理的事件=" + event);
    }

    public static /* synthetic */ void init$default(LongAudioAsrHelper longAudioAsrHelper, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        longAudioAsrHelper.init(i);
    }

    private final void logE(String str, Throwable th) {
        UlogExtKt.logE(str, TAG, th);
    }

    public static /* synthetic */ void logE$default(LongAudioAsrHelper longAudioAsrHelper, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        longAudioAsrHelper.logE(str, th);
    }

    /* access modifiers changed from: private */
    public final void logI(String str) {
        UlogExtKt.logI(str, TAG);
    }

    private final void logReachCount(String str, String str2, int i) {
        UlogExtKt.logReachCount(str, TAG, str2, i);
    }

    public static /* synthetic */ void logReachCount$default(LongAudioAsrHelper longAudioAsrHelper, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 100;
        }
        longAudioAsrHelper.logReachCount(str, str2, i);
    }

    private final void notifyAsrRunningSensitiveState(SmartExSensitive smartExSensitive) {
        try {
            SensitivePayload payload = smartExSensitive.getPayload();
            AsrMessageState asrMessageState = new AsrMessageState(payload.getRiskLevel(), Intrinsics.areEqual((Object) smartExSensitive.getType(), (Object) "sensitive_request") ? "2001" : "2002", payload.getRiskDescription(), (String) null, (String) null, 24, (DefaultConstructorMarker) null);
            UlogExtKt.logI("notifyAsrRunningSensitiveState asrMessageState=" + asrMessageState + ", callback size=" + this.mCallbackMap.size(), TAG);
            for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value.getValue()).onAsrRunningState(asrMessageState);
            }
        } catch (Exception e) {
            UlogExtKt.logI("notifyAsrRunningSensitiveState error=" + ExceptionsKt.stackTraceToString(e), TAG);
        }
    }

    private final void notifyAsrRunningState(AsrResponse asrResponse) {
        try {
            AsrMessageState asrMessageState = new AsrMessageState(asrResponse.getEvent(), asrResponse.getCode(), asrResponse.getMsg(), (String) null, (String) null, 24, (DefaultConstructorMarker) null);
            logI("notifyAsrRunningState asrMessageState=" + asrMessageState + ", callback size=" + this.mCallbackMap.size());
            for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value.getValue()).onAsrRunningState(asrMessageState);
            }
        } catch (Exception e) {
            logI("notifyAsrRunningState error=" + ExceptionsKt.stackTraceToString(e));
        }
    }

    /* access modifiers changed from: private */
    public final void notifyClosed(int i, String str) {
        logI("notifyClosed channelType=" + AsrExtKt.accessChannelToStr(this.mAsrChannelType));
        logI("notifyClosed remote=" + this.mRemoteSocketState + ", proximal=" + this.mProximalSocketState);
        int i2 = this.mAsrChannelType;
        if (i2 == 1) {
            WebSocketState webSocketState = this.mRemoteSocketState;
            boolean z = false;
            boolean isClosed = webSocketState != null ? webSocketState.isClosed() : false;
            WebSocketState webSocketState2 = this.mProximalSocketState;
            if (webSocketState2 != null) {
                z = webSocketState2.isClosed();
            }
            logI("notifyClosed remoteClosed=" + isClosed + ", proximalClosed=" + z + ", callback size=" + this.mCallbackMap.size());
            if (isClosed && z) {
                for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
                    ((AsrResultCallback) value.getValue()).onClosed(i, str);
                }
            }
        } else if (i2 == 2 || i2 == 3) {
            logI("notifyClosed callback size=" + this.mCallbackMap.size());
            for (Map.Entry<String, AsrResultCallback> value2 : this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value2.getValue()).onClosed(i, str);
            }
        } else {
            logI("notifyClosed:: 无效的通道类型，请查看TranslationChannel中支持的通道类型！");
        }
    }

    /* access modifiers changed from: private */
    public final void notifyClosing(int i, String str) {
        logI("notifyClosing channelType=" + AsrExtKt.accessChannelToStr(this.mAsrChannelType));
        logI("notifyClosing remote=" + this.mRemoteSocketState + ", proximal=" + this.mProximalSocketState);
        int i2 = this.mAsrChannelType;
        if (i2 == 1) {
            WebSocketState webSocketState = this.mRemoteSocketState;
            boolean z = false;
            boolean isMsgStarted = webSocketState != null ? webSocketState.isMsgStarted() : false;
            WebSocketState webSocketState2 = this.mProximalSocketState;
            if (webSocketState2 != null) {
                z = webSocketState2.isMsgStarted();
            }
            logI("notifyClosing remoteMsgStarted=" + isMsgStarted + ", proximalMsgStarted=" + z + ", callback size=" + this.mCallbackMap.size());
            if (isMsgStarted || z) {
                for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
                    ((AsrResultCallback) value.getValue()).onClosing(i, str);
                }
            }
        } else if (i2 == 2 || i2 == 3) {
            logI("notifyClosing callback size=" + this.mCallbackMap.size());
            for (Map.Entry<String, AsrResultCallback> value2 : this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value2.getValue()).onClosing(i, str);
            }
        } else {
            logI("notifyClosing:: 无效的通道类型，请查看AsrConstants中支持的通道类型！");
        }
    }

    /* access modifiers changed from: private */
    public final void notifyFailed(Throwable th, Response response) {
        logI("notifyFailed channelType=" + AsrExtKt.accessChannelToStr(this.mAsrChannelType));
        logI("notifyFailed remote=" + this.mRemoteSocketState + ", proximal=" + this.mProximalSocketState);
        int i = this.mAsrChannelType;
        if (i == 1) {
            remoteSocketFailedToClose();
            proximalSocketFailedToClose();
            logI("notifyFailed callback size=" + this.mCallbackMap.size());
            for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value.getValue()).onFailure(th, response);
            }
        } else if (i == 2) {
            remoteSocketFailedToClose();
            logI("notifyFailed callback size=" + this.mCallbackMap.size());
            for (Map.Entry<String, AsrResultCallback> value2 : this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value2.getValue()).onFailure(th, response);
            }
        } else if (i != 3) {
            logI("notifyFailed:: 无效的通道类型，请查看AsrConstants中支持的通道类型！");
        } else {
            proximalSocketFailedToClose();
            logI("notifyFailed callback size=" + this.mCallbackMap.size());
            for (Map.Entry<String, AsrResultCallback> value3 : this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value3.getValue()).onFailure(th, response);
            }
        }
    }

    private final void notifyOpen(Response response) {
        logI("notifyOpen channelType=" + AsrExtKt.accessChannelToStr(this.mAsrChannelType));
        logI("notifyOpen remote=" + this.mRemoteSocketState + ", proximal=" + this.mProximalSocketState);
        int i = this.mAsrChannelType;
        boolean z = false;
        if (i == 1) {
            WebSocketState webSocketState = this.mRemoteSocketState;
            boolean isMsgStarted = webSocketState != null ? webSocketState.isMsgStarted() : false;
            WebSocketState webSocketState2 = this.mProximalSocketState;
            if (webSocketState2 != null) {
                z = webSocketState2.isMsgStarted();
            }
            logI("notifyOpen remoteMsgStarted=" + isMsgStarted + ", proximalMsgStarted=" + z + ", callback size=" + this.mCallbackMap.size());
            if (isMsgStarted && z) {
                for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
                    ((AsrResultCallback) value.getValue()).onOpen(response);
                }
            }
        } else if (i == 2) {
            WebSocketState webSocketState3 = this.mRemoteSocketState;
            if (webSocketState3 != null) {
                z = webSocketState3.isMsgStarted();
            }
            logI("notifyOpen remoteMsgStarted=" + z + ", callback size=" + this.mCallbackMap.size());
            if (z) {
                for (Map.Entry<String, AsrResultCallback> value2 : this.mCallbackMap.entrySet()) {
                    ((AsrResultCallback) value2.getValue()).onOpen(response);
                }
            }
        } else if (i != 3) {
            logI("notifyOpen 无效的通道类型，请查看AsrConstants中支持的通道类型！");
        } else {
            WebSocketState webSocketState4 = this.mProximalSocketState;
            if (webSocketState4 != null) {
                z = webSocketState4.isMsgStarted();
            }
            logI("notifyOpen proximalMsgStarted=" + z + ", callback size=" + this.mCallbackMap.size());
            if (z) {
                for (Map.Entry<String, AsrResultCallback> value3 : this.mCallbackMap.entrySet()) {
                    ((AsrResultCallback) value3.getValue()).onOpen(response);
                }
            }
        }
    }

    public static /* synthetic */ void notifyOpen$default(LongAudioAsrHelper longAudioAsrHelper, Response response, int i, Object obj) {
        if ((i & 1) != 0) {
            response = null;
        }
        longAudioAsrHelper.notifyOpen(response);
    }

    private final void notifyProximalAsrResult(AsrResult asrResult) {
        for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
            ((AsrResultCallback) value.getValue()).onProximalAsrResult(asrResult);
        }
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
        logI("proximalSocketFailedToClose proximalOpened=" + isOpened + ", proximalMsgStarted=" + z);
        if (isOpened) {
            endProximalRequest(z ? 1 : 2);
        }
    }

    private final void remoteSocketFailedToClose() {
        WebSocketState webSocketState = this.mRemoteSocketState;
        boolean z = false;
        boolean isOpened = webSocketState != null ? webSocketState.isOpened() : false;
        WebSocketState webSocketState2 = this.mRemoteSocketState;
        if (webSocketState2 != null) {
            z = webSocketState2.isMsgStarted();
        }
        logI("remoteSocketFailedToClose remoteOpened=" + isOpened + ", remoteMsgStarted=" + z);
        if (isOpened) {
            endRemoteRequest(z ? 1 : 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r6 != null) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r6 == null) goto L_0x000c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0012, code lost:
        if (r5 != null) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int requestWebChannelType(com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r5, com.xjsd.xr.sapp.asr.dao.AsrRequestConfig r6) {
        /*
            r4 = this;
            int r4 = r4.mInitChannel
            r0 = 1
            r1 = 3
            r2 = 2
            r3 = 0
            if (r4 == r0) goto L_0x0016
            if (r4 == r2) goto L_0x0012
            if (r4 == r1) goto L_0x000e
        L_0x000c:
            r0 = r3
            goto L_0x0021
        L_0x000e:
            if (r6 == 0) goto L_0x000c
        L_0x0010:
            r0 = r1
            goto L_0x0021
        L_0x0012:
            if (r5 == 0) goto L_0x000c
        L_0x0014:
            r0 = r2
            goto L_0x0021
        L_0x0016:
            if (r5 == 0) goto L_0x001b
            if (r6 == 0) goto L_0x001b
            goto L_0x0021
        L_0x001b:
            if (r5 == 0) goto L_0x001e
            goto L_0x0014
        L_0x001e:
            if (r6 == 0) goto L_0x000c
            goto L_0x0010
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.LongAudioAsrHelper.requestWebChannelType(com.xjsd.xr.sapp.asr.dao.AsrRequestConfig, com.xjsd.xr.sapp.asr.dao.AsrRequestConfig):int");
    }

    /* access modifiers changed from: private */
    public final void sendProximalChannelInfo() {
        logI("sendProximalChannelInfo proximalRequestConfig=" + this.mProximalRequestConfig);
        AsrRequestConfig asrRequestConfig = this.mProximalRequestConfig;
        if (asrRequestConfig != null) {
            AsrRequest syncAudioInfoRequest = getSyncAudioInfoRequest(asrRequestConfig);
            String json = GsonHelper.toJson(syncAudioInfoRequest);
            WebSocket webSocket = this.mProximalWebSocket;
            if (webSocket != null) {
                webSocket.send(json);
            }
            logI("sendProximalChannelInfo proximalRequest=" + syncAudioInfoRequest);
            this.mProximalAsrRequest = syncAudioInfoRequest;
        }
    }

    /* access modifiers changed from: private */
    public final void sendProximalData(Message message) {
        WebSocket webSocket = this.mProximalWebSocket;
        Unit unit = null;
        if (webSocket != null) {
            WebSocketState webSocketState = this.mProximalSocketState;
            if (webSocketState == null || !webSocketState.isMsgStarted()) {
                logReachCount$default(this, "sendProximalData 当前WebSocket传输数据通道未连接无法发送数据", "sendProximalDataNotStarted", 0, 4, (Object) null);
            } else {
                Object obj = message.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.xjsd.xr.sapp.asr.LongAudioAsrHelper.AudioMessage");
                byte[] audio = ((AudioMessage) obj).getAudio();
                byte[] copyOf = Arrays.copyOf(audio, audio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                if (webSocket.send(ByteString.Companion.of(copyOf, 0, copyOf.length))) {
                    this.mProximalHasSend = true;
                } else {
                    logE$default(this, "sendProximalData 发送近端音频数据给服务器异常", (Throwable) null, 2, (Object) null);
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            logReachCount$default(this, "sendProximalData websocket is null, closed=" + this.mIsProximalClosed, "sendProximalDataNullSocket", 0, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void sendRemoteChannelInfo() {
        logI("sendRemoteChannelInfo remoteRequestConfig=" + this.mRemoteRequestConfig);
        AsrRequestConfig asrRequestConfig = this.mRemoteRequestConfig;
        if (asrRequestConfig != null) {
            AsrRequest syncAudioInfoRequest = getSyncAudioInfoRequest(asrRequestConfig);
            String json = GsonHelper.toJson(syncAudioInfoRequest);
            WebSocket webSocket = this.mRemoteWebSocket;
            if (webSocket != null) {
                webSocket.send(json);
            }
            logI("sendRemoteChannelInfo remoteRequest=" + syncAudioInfoRequest);
            this.mRemoteAsrRequest = syncAudioInfoRequest;
        }
    }

    /* access modifiers changed from: private */
    public final void sendRemoteData(Message message) {
        WebSocket webSocket = this.mRemoteWebSocket;
        Unit unit = null;
        if (webSocket != null) {
            WebSocketState webSocketState = this.mRemoteSocketState;
            if (webSocketState == null || !webSocketState.isMsgStarted()) {
                logReachCount$default(this, "sendRemoteData 当前WebSocket传输数据通道未连接无法发送数据", "sendRemoteDataNotStarted", 0, 4, (Object) null);
            } else {
                Object obj = message.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.xjsd.xr.sapp.asr.LongAudioAsrHelper.AudioMessage");
                byte[] audio = ((AudioMessage) obj).getAudio();
                byte[] copyOf = Arrays.copyOf(audio, audio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                if (webSocket.send(ByteString.Companion.of(copyOf, 0, copyOf.length))) {
                    this.mRemoteHasSend = true;
                } else {
                    logE$default(this, "sendRemoteData 发送远端音频数据给服务器异常", (Throwable) null, 2, (Object) null);
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            logReachCount$default(this, "sendRemoteData websocket is null, closed=" + this.mIsRemoteClosed, "sendRemoteDataNullSocket", 0, 4, (Object) null);
        }
    }

    private final void startProximalRequest(AsrRequestConfig asrRequestConfig) {
        logI("startProximalRequest transConfig=" + asrRequestConfig);
        this.mProximalRequestConfig = asrRequestConfig;
        WebSocket webSocket = null;
        if (this.mProximalWebSocket != null) {
            logI("startProximalRequest websocket is not null");
            WebSocket webSocket2 = this.mProximalWebSocket;
            if (webSocket2 != null) {
                webSocket2.cancel();
            }
            this.mProximalWebSocket = null;
            this.mProximalSocketListener = null;
        }
        ProximalSocketListener proximalSocketListener = new ProximalSocketListener();
        OkHttpClient okHttpClient = this.mHttpClient;
        if (okHttpClient != null) {
            webSocket = okHttpClient.newWebSocket(new Request.Builder().url(AsrConstants.INSTANCE.getAsrUrl$asr_release(asrRequestConfig.getWebType())).build(), proximalSocketListener);
        }
        this.mProximalWebSocket = webSocket;
        this.mProximalSocketListener = proximalSocketListener;
        this.mIsProximalClosed = false;
    }

    private final void startProximalThread() {
        logI("startProximalThread 启动近端ASR识别线程");
        HandlerThread handlerThread = new HandlerThread(HANDLER_THREAD_PROXIMAL);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
        this.mProximalHandler = new DataHandler(this, looper);
        this.mProximalThread = handlerThread;
    }

    private final void startRemoteRequest(AsrRequestConfig asrRequestConfig) {
        logI("startRemoteRequest requestConfig=" + asrRequestConfig);
        this.mRemoteRequestConfig = asrRequestConfig;
        WebSocket webSocket = null;
        if (this.mRemoteWebSocket != null) {
            logI("startRemoteRequest websocket is not null");
            WebSocket webSocket2 = this.mRemoteWebSocket;
            if (webSocket2 != null) {
                webSocket2.cancel();
            }
            this.mRemoteWebSocket = null;
            this.mRemoteSocketListener = null;
        }
        RemoteSocketListener remoteSocketListener = new RemoteSocketListener();
        OkHttpClient okHttpClient = this.mHttpClient;
        if (okHttpClient != null) {
            webSocket = okHttpClient.newWebSocket(new Request.Builder().url(AsrConstants.INSTANCE.getAsrUrl$asr_release(asrRequestConfig.getWebType())).build(), remoteSocketListener);
        }
        this.mRemoteWebSocket = webSocket;
        this.mRemoteSocketListener = remoteSocketListener;
        this.mIsRemoteClosed = false;
    }

    private final void startRemoteThread() {
        logI("startRemoteThread 启动远端ASR识别线程");
        HandlerThread handlerThread = new HandlerThread(HANDLER_THREAD_REMOTE);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
        this.mRemoteHandler = new DataHandler(this, looper);
        this.mRemoteThread = handlerThread;
    }

    public static /* synthetic */ void startRequest$default(LongAudioAsrHelper longAudioAsrHelper, AsrRequestConfig asrRequestConfig, AsrRequestConfig asrRequestConfig2, int i, Object obj) {
        if ((i & 1) != 0) {
            asrRequestConfig = null;
        }
        if ((i & 2) != 0) {
            asrRequestConfig2 = null;
        }
        longAudioAsrHelper.startRequest(asrRequestConfig, asrRequestConfig2);
    }

    public final void endRequest() {
        logI("endRequest channelType=" + AsrExtKt.accessChannelToStr(this.mAsrChannelType));
        int i = this.mAsrChannelType;
        if (i == 1) {
            endRemoteRequest(1);
            endProximalRequest(1);
        } else if (i == 2) {
            endRemoteRequest(1);
        } else if (i != 3) {
            logI("endRequest 关闭ASR WebSocket失败");
        } else {
            endProximalRequest(1);
        }
    }

    public final void init(int i) {
        logI("初始化请求ASR服务器帮助类，Channel[type=" + i + ", typeStr=" + AsrExtKt.accessChannelToStr(i) + ']');
        this.mInitChannel = i;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.mHttpClient = builder.connectTimeout(5, timeUnit).readTimeout(5, timeUnit).pingInterval(15, timeUnit).build();
        if (i == 1) {
            startRemoteThread();
            startProximalThread();
        } else if (i == 2) {
            startRemoteThread();
        } else if (i != 3) {
            startRemoteThread();
        } else {
            startProximalThread();
        }
    }

    public final void registerAsrResultCallback(@NotNull String str, @NotNull AsrResultCallback asrResultCallback) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(asrResultCallback, "callback");
        this.mCallbackMap.put(str, asrResultCallback);
    }

    public final void release() {
        logI("release 释放工具类所有资源，跟init成对出现");
        Handler handler = this.mRemoteHandler;
        if (handler != null && handler.hasMessages(102)) {
            Message obtain = Message.obtain();
            obtain.arg1 = 1;
            Intrinsics.checkNotNullExpressionValue(obtain, "apply(...)");
            endRemoteData(obtain);
        }
        Handler handler2 = this.mProximalHandler;
        if (handler2 != null && handler2.hasMessages(104)) {
            Message obtain2 = Message.obtain();
            obtain2.arg1 = 1;
            Intrinsics.checkNotNullExpressionValue(obtain2, "apply(...)");
            endProximalData(obtain2);
        }
        Handler handler3 = this.mRemoteHandler;
        if (handler3 != null) {
            handler3.removeCallbacksAndMessages((Object) null);
        }
        this.mRemoteHandler = null;
        Handler handler4 = this.mProximalHandler;
        if (handler4 != null) {
            handler4.removeCallbacksAndMessages((Object) null);
        }
        this.mProximalHandler = null;
        HandlerThread handlerThread = this.mRemoteThread;
        if (handlerThread != null) {
            handlerThread.interrupt();
        }
        this.mRemoteThread = null;
        HandlerThread handlerThread2 = this.mProximalThread;
        if (handlerThread2 != null) {
            handlerThread2.interrupt();
        }
        this.mProximalThread = null;
        this.mCallbackMap.clear();
        this.mHttpClient = null;
        this.mRemoteWebSocket = null;
        this.mRemoteSocketListener = null;
        this.mIsRemoteClosed = false;
        this.mRemoteHasSend = false;
        this.mRemoteRequestConfig = null;
        this.mRemoteAsrRequest = null;
        this.mProximalWebSocket = null;
        this.mProximalSocketListener = null;
        this.mIsProximalClosed = false;
        this.mProximalHasSend = false;
        this.mProximalRequestConfig = null;
        this.mProximalAsrRequest = null;
        this.mInitChannel = 0;
        UlogExtKt.clearLogCountMap();
    }

    public final void sendAudioData(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr != null) {
            sendProximalAudioData(bArr);
        }
        if (bArr2 != null) {
            sendRemoteAudioData(bArr2);
        }
    }

    public final void sendEndMessage() {
        sendRemoteEndMessage();
        sendProximalEndMessage();
    }

    public final void sendProximalAudioData(@NotNull byte[] bArr) {
        Handler handler;
        Intrinsics.checkNotNullParameter(bArr, "data");
        int i = this.mAsrChannelType;
        if ((i != 1 && i != 3) || (handler = this.mProximalHandler) == null) {
            logI("sendProximalAudioData 发送近端音频消息异常");
        } else if (handler != null) {
            Message obtain = Message.obtain();
            obtain.obj = new AudioMessage(bArr);
            obtain.what = 103;
            handler.sendMessage(obtain);
        }
    }

    public final void sendProximalEndMessage() {
        logI("sendProximalEndMessage asrRequest=" + this.mProximalAsrRequest);
        AsrRequest asrRequest = this.mProximalAsrRequest;
        if (asrRequest != null) {
            String json = GsonHelper.toJson(new SpeechEndAudio(asrRequest.getDeviceId(), AsrConstants.END_AUDIO, asrRequest.getRequestId()));
            WebSocket webSocket = this.mProximalWebSocket;
            if (webSocket != null) {
                webSocket.send(json);
            }
            UlogExtKt.logI(json, "sendProximalEndMessage json=" + json);
        }
    }

    public final void sendRemoteAudioData(@NotNull byte[] bArr) {
        Handler handler;
        Intrinsics.checkNotNullParameter(bArr, "data");
        int i = this.mAsrChannelType;
        if ((i != 1 && i != 2) || (handler = this.mRemoteHandler) == null) {
            logI("sendRemoteAudioData 发送远端音频消息异常");
        } else if (handler != null) {
            Message obtain = Message.obtain();
            obtain.obj = new AudioMessage(bArr);
            obtain.what = 101;
            handler.sendMessage(obtain);
        }
    }

    public final void sendRemoteEndMessage() {
        logI("sendRemoteEndMessage asrRequest=" + this.mRemoteAsrRequest);
        AsrRequest asrRequest = this.mRemoteAsrRequest;
        if (asrRequest != null) {
            String json = GsonHelper.toJson(new SpeechEndAudio(asrRequest.getDeviceId(), AsrConstants.END_AUDIO, asrRequest.getRequestId()));
            WebSocket webSocket = this.mRemoteWebSocket;
            if (webSocket != null) {
                webSocket.send(json);
            }
            UlogExtKt.logI(json, "sendRemoteEndMessage json=" + json);
        }
    }

    public final void startRequest(@Nullable AsrRequestConfig asrRequestConfig, @Nullable AsrRequestConfig asrRequestConfig2) {
        logI("startRequest remoteConfig=" + asrRequestConfig + ", proximalConfig=" + asrRequestConfig2);
        this.mAsrChannelType = requestWebChannelType(asrRequestConfig, asrRequestConfig2);
        logI("startRequest initChannel=" + AsrExtKt.accessChannelToStr(this.mInitChannel) + ", channelType=" + AsrExtKt.accessChannelToStr(this.mAsrChannelType));
        this.mRemoteSocketState = null;
        this.mProximalSocketState = null;
        this.mRemoteSocketState = new WebSocketState();
        this.mProximalSocketState = new WebSocketState();
        logI("startRequest mRemoteSocketState=" + this.mRemoteSocketState + ", mProximalSocketState=" + this.mProximalSocketState);
        int i = this.mAsrChannelType;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    logE$default(this, "startRequest 请设置正确的请求配置！", (Throwable) null, 2, (Object) null);
                } else if (asrRequestConfig2 == null) {
                    logE$default(this, "startRequest 参数传递异常，请求开启近端通道必须传递近端翻译请求配置！", (Throwable) null, 2, (Object) null);
                } else {
                    startProximalRequest(asrRequestConfig2);
                }
            } else if (asrRequestConfig == null) {
                logE$default(this, "startRequest 参数传递异常，请求开启远端通道必须传递远端翻译请求配置！", (Throwable) null, 2, (Object) null);
            } else {
                startRemoteRequest(asrRequestConfig);
            }
        } else if (asrRequestConfig == null || asrRequestConfig2 == null) {
            logE$default(this, "startRequest 参数传递异常，双通道模式下必须同时传递远端翻译请求配置和近端翻译请求配置！", (Throwable) null, 2, (Object) null);
        } else {
            startRemoteRequest(asrRequestConfig);
            startProximalRequest(asrRequestConfig2);
        }
    }

    public final void unRegisterAsrResultCallback(@NotNull String str, @NotNull AsrResultCallback asrResultCallback) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(asrResultCallback, "callback");
        this.mCallbackMap.remove(str, asrResultCallback);
    }

    @SourceDebugExtension({"SMAP\nLongAudioAsrHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongAudioAsrHelper.kt\ncom/xjsd/xr/sapp/asr/LongAudioAsrHelper$ProximalSocketListener\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1590:1\n215#2,2:1591\n*S KotlinDebug\n*F\n+ 1 LongAudioAsrHelper.kt\ncom/xjsd/xr/sapp/asr/LongAudioAsrHelper$ProximalSocketListener\n*L\n1287#1:1591,2\n*E\n"})
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0016"}, d2 = {"Lcom/xjsd/xr/sapp/asr/LongAudioAsrHelper$ProximalSocketListener;", "Lokhttp3/WebSocketListener;", "(Lcom/xjsd/xr/sapp/asr/LongAudioAsrHelper;)V", "onClosed", "", "webSocket", "Lokhttp3/WebSocket;", "code", "", "reason", "", "onClosing", "onFailure", "t", "", "response", "Lokhttp3/Response;", "onMessage", "text", "bytes", "Lokio/ByteString;", "onOpen", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ProximalSocketListener extends WebSocketListener {
        public ProximalSocketListener() {
        }

        public void onClosed(@NotNull WebSocket webSocket, int i, @NotNull String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "reason");
            super.onClosed(webSocket, i, str);
            LongAudioAsrHelper longAudioAsrHelper = LongAudioAsrHelper.this;
            longAudioAsrHelper.logI("ProximalSocketListener onClosed code=" + i + ", reason=" + str);
            WebSocketState access$getMProximalSocketState$p = LongAudioAsrHelper.this.mProximalSocketState;
            if (access$getMProximalSocketState$p != null) {
                access$getMProximalSocketState$p.setClosed(true);
            }
            LongAudioAsrHelper.this.notifyClosed(i, str);
        }

        public void onClosing(@NotNull WebSocket webSocket, int i, @NotNull String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "reason");
            super.onClosing(webSocket, i, str);
            LongAudioAsrHelper longAudioAsrHelper = LongAudioAsrHelper.this;
            longAudioAsrHelper.logI("ProximalSocketListener onClosing code=" + i + ", reason=" + str);
            LongAudioAsrHelper.this.notifyClosing(i, str);
        }

        public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable th, @Nullable Response response) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(th, t.f);
            super.onFailure(webSocket, th, response);
            LongAudioAsrHelper longAudioAsrHelper = LongAudioAsrHelper.this;
            longAudioAsrHelper.logI("ProximalSocketListener onFailure response=" + response + ", t=" + ExceptionsKt.stackTraceToString(th));
            LongAudioAsrHelper.this.notifyFailed(th, response);
            WebSocketState access$getMProximalSocketState$p = LongAudioAsrHelper.this.mProximalSocketState;
            if (access$getMProximalSocketState$p != null) {
                access$getMProximalSocketState$p.setOpened(false);
            }
        }

        public void onMessage(@NotNull WebSocket webSocket, @NotNull String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "text");
            super.onMessage(webSocket, str);
            LongAudioAsrHelper.this.handleProximalMessage(str);
        }

        public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(response, "response");
            super.onOpen(webSocket, response);
            LongAudioAsrHelper longAudioAsrHelper = LongAudioAsrHelper.this;
            longAudioAsrHelper.logI("ProximalSocketListener onOpen response=" + response);
            WebSocketState access$getMProximalSocketState$p = LongAudioAsrHelper.this.mProximalSocketState;
            if (access$getMProximalSocketState$p != null) {
                access$getMProximalSocketState$p.setOpened(true);
            }
            LongAudioAsrHelper.this.sendProximalChannelInfo();
        }

        public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString byteString) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(byteString, "bytes");
            super.onMessage(webSocket, byteString);
            for (Map.Entry value : LongAudioAsrHelper.this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value.getValue()).onProximalTts(new TtsData(byteString.toByteArray(), 0, 2, (DefaultConstructorMarker) null));
            }
        }
    }

    @SourceDebugExtension({"SMAP\nLongAudioAsrHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongAudioAsrHelper.kt\ncom/xjsd/xr/sapp/asr/LongAudioAsrHelper$RemoteSocketListener\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1590:1\n215#2,2:1591\n*S KotlinDebug\n*F\n+ 1 LongAudioAsrHelper.kt\ncom/xjsd/xr/sapp/asr/LongAudioAsrHelper$RemoteSocketListener\n*L\n770#1:1591,2\n*E\n"})
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0016"}, d2 = {"Lcom/xjsd/xr/sapp/asr/LongAudioAsrHelper$RemoteSocketListener;", "Lokhttp3/WebSocketListener;", "(Lcom/xjsd/xr/sapp/asr/LongAudioAsrHelper;)V", "onClosed", "", "webSocket", "Lokhttp3/WebSocket;", "code", "", "reason", "", "onClosing", "onFailure", "t", "", "response", "Lokhttp3/Response;", "onMessage", "text", "bytes", "Lokio/ByteString;", "onOpen", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class RemoteSocketListener extends WebSocketListener {
        public RemoteSocketListener() {
        }

        public void onClosed(@NotNull WebSocket webSocket, int i, @NotNull String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "reason");
            super.onClosed(webSocket, i, str);
            LongAudioAsrHelper longAudioAsrHelper = LongAudioAsrHelper.this;
            longAudioAsrHelper.logI("RemoteSocketListener onClosed code=" + i + ", reason=" + str);
            WebSocketState access$getMRemoteSocketState$p = LongAudioAsrHelper.this.mRemoteSocketState;
            if (access$getMRemoteSocketState$p != null) {
                access$getMRemoteSocketState$p.setClosed(true);
            }
            LongAudioAsrHelper.this.notifyClosed(i, str);
        }

        public void onClosing(@NotNull WebSocket webSocket, int i, @NotNull String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "reason");
            super.onClosing(webSocket, i, str);
            LongAudioAsrHelper longAudioAsrHelper = LongAudioAsrHelper.this;
            longAudioAsrHelper.logI("RemoteSocketListener onClosing code=" + i + ", reason=" + str);
            LongAudioAsrHelper.this.notifyClosing(i, str);
        }

        public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable th, @Nullable Response response) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(th, t.f);
            super.onFailure(webSocket, th, response);
            LongAudioAsrHelper longAudioAsrHelper = LongAudioAsrHelper.this;
            longAudioAsrHelper.logI("RemoteSocketListener onFailure response=" + response + ", t=" + ExceptionsKt.stackTraceToString(th));
            LongAudioAsrHelper.this.notifyFailed(th, response);
            WebSocketState access$getMRemoteSocketState$p = LongAudioAsrHelper.this.mRemoteSocketState;
            if (access$getMRemoteSocketState$p != null) {
                access$getMRemoteSocketState$p.setOpened(false);
            }
        }

        public void onMessage(@NotNull WebSocket webSocket, @NotNull String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "text");
            super.onMessage(webSocket, str);
            LongAudioAsrHelper.this.handleRemoteMessage(str);
        }

        public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(response, "response");
            super.onOpen(webSocket, response);
            LongAudioAsrHelper longAudioAsrHelper = LongAudioAsrHelper.this;
            longAudioAsrHelper.logI("RemoteSocketListener onOpen response=" + response);
            WebSocketState access$getMRemoteSocketState$p = LongAudioAsrHelper.this.mRemoteSocketState;
            if (access$getMRemoteSocketState$p != null) {
                access$getMRemoteSocketState$p.setOpened(true);
            }
            LongAudioAsrHelper.this.sendRemoteChannelInfo();
        }

        public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString byteString) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(byteString, "bytes");
            super.onMessage(webSocket, byteString);
            for (Map.Entry value : LongAudioAsrHelper.this.mCallbackMap.entrySet()) {
                ((AsrResultCallback) value.getValue()).onRemoteTts(new TtsData(byteString.toByteArray(), 0, 2, (DefaultConstructorMarker) null));
            }
        }
    }
}
