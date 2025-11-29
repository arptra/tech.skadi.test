package com.xjsd.xr.sapp.asr;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.geetest.sdk.t;
import com.meizu.common.util.LunarCalendar;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.xjsd.xr.sapp.asr.callback.AsrResultCallback;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import com.xjsd.xr.sapp.asr.dao.AsrMessageState;
import com.xjsd.xr.sapp.asr.dao.AsrRequest;
import com.xjsd.xr.sapp.asr.dao.AsrRequestData;
import com.xjsd.xr.sapp.asr.dao.AsrResponse;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.SpeechCancelAudio;
import com.xjsd.xr.sapp.asr.dao.SpeechEndAudio;
import com.xjsd.xr.sapp.asr.dao.SpeechRequestConfig;
import com.xjsd.xr.sapp.asr.dao.TtsConfig;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import com.xjsd.xr.sapp.asr.utils.AsrResultExtKt;
import com.xjsd.xr.sapp.asr.utils.GsonHelper;
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

@SourceDebugExtension({"SMAP\nShortAudioAsrHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShortAudioAsrHelper.kt\ncom/xjsd/xr/sapp/asr/ShortAudioAsrHelper\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,595:1\n215#2,2:596\n215#2,2:598\n215#2,2:600\n215#2,2:602\n215#2,2:604\n215#2,2:606\n*S KotlinDebug\n*F\n+ 1 ShortAudioAsrHelper.kt\ncom/xjsd/xr/sapp/asr/ShortAudioAsrHelper\n*L\n424#1:596,2\n436#1:598,2\n448#1:600,2\n463#1:602,2\n482#1:604,2\n497#1:606,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 B2\u00020\u0001:\u0004ABCDB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0006\u0010\u0018\u001a\u00020\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020\u0016J\u001c\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0007H\u0002J\u0018\u0010.\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0007H\u0002J\u001a\u0010/\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0014\u00102\u001a\u00020\u00162\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0002J\u000e\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u000205J\u0016\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\bJ\u0006\u00109\u001a\u00020\u0016J\u0010\u0010:\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020\u0016H\u0002J\u000e\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u0010J\u0006\u0010?\u001a\u00020\u0016J\u0016\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/xjsd/xr/sapp/asr/ShortAudioAsrHelper;", "", "()V", "mAsrRequest", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequest;", "mCallbackMap", "", "", "Lcom/xjsd/xr/sapp/asr/callback/AsrResultCallback;", "mDataHandler", "Landroid/os/Handler;", "mHandlerThread", "Landroid/os/HandlerThread;", "mHttpClient", "Lokhttp3/OkHttpClient;", "mRequestConfig", "Lcom/xjsd/xr/sapp/asr/dao/SpeechRequestConfig;", "mSocketListener", "Lcom/xjsd/xr/sapp/asr/ShortAudioAsrHelper$SocketListener;", "mWebSocket", "Lokhttp3/WebSocket;", "cancelAudioMessage", "", "endAudioData", "endAudioMessage", "getSyncAudioInfoRequest", "config", "handleMessage", "text", "handleMessageSuccess", "asrResponse", "Lcom/xjsd/xr/sapp/asr/dao/AsrResponse;", "init", "logE", "msg", "t", "", "logI", "notifyAsrResult", "result", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "notifyAsrRunningState", "notifyClosed", "code", "", "reason", "notifyClosing", "notifyFailed", "response", "Lokhttp3/Response;", "notifyOpen", "pushAudio", "bytes", "", "registerAsrResultCallback", "key", "callback", "release", "sendAudioData", "Landroid/os/Message;", "sendChannelInfo", "startRequest", "requestConfig", "stopRequest", "unRegisterAsrResultCallback", "AudioMessage", "Companion", "DataHandler", "SocketListener", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(message = "当前短语音直连ASR服务已废弃（虽然仍然可用）全部切换为端云一体服务", replaceWith = @ReplaceWith(expression = "请使用端云一体ASR帮助类 [ShortUnifiedAsrHelper]", imports = {}))
public final class ShortAudioAsrHelper {
    private static final int AUDIO_DATA_END = 102;
    private static final int AUDIO_DATA_SEND = 101;
    private static final long CONNECT_TIMEOUT = 5;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String HANDLER_THREAD_MARK = "ShortAudioAsrHelperThread";
    private static final long PING_INTERVAL = 15;
    private static final long READ_TIMEOUT = 5;
    private static final int REMOTE_CLOSE_CODE = 1000;
    @NotNull
    private static final String TAG = "ShortAudioAsrHelper";
    @Nullable
    private AsrRequest mAsrRequest;
    @NotNull
    private final Map<String, AsrResultCallback> mCallbackMap = new LinkedHashMap();
    @Nullable
    private Handler mDataHandler;
    @Nullable
    private HandlerThread mHandlerThread;
    @Nullable
    private OkHttpClient mHttpClient;
    @Nullable
    private SpeechRequestConfig mRequestConfig;
    @Nullable
    private SocketListener mSocketListener;
    @Nullable
    private WebSocket mWebSocket;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/xjsd/xr/sapp/asr/ShortAudioAsrHelper$AudioMessage;", "", "audio", "", "([B)V", "getAudio", "()[B", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.xjsd.xr.sapp.asr.ShortAudioAsrHelper.AudioMessage");
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

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/xjsd/xr/sapp/asr/ShortAudioAsrHelper$Companion;", "", "()V", "AUDIO_DATA_END", "", "AUDIO_DATA_SEND", "CONNECT_TIMEOUT", "", "HANDLER_THREAD_MARK", "", "PING_INTERVAL", "READ_TIMEOUT", "REMOTE_CLOSE_CODE", "TAG", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/xjsd/xr/sapp/asr/ShortAudioAsrHelper$DataHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "(Lcom/xjsd/xr/sapp/asr/ShortAudioAsrHelper;Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class DataHandler extends Handler {
        final /* synthetic */ ShortAudioAsrHelper this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataHandler(@NotNull ShortAudioAsrHelper shortAudioAsrHelper, Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.this$0 = shortAudioAsrHelper;
        }

        public void handleMessage(@NotNull Message message) {
            Intrinsics.checkNotNullParameter(message, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
            super.handleMessage(message);
            int i = message.what;
            if (i == 101) {
                this.this$0.sendAudioData(message);
            } else if (i == 102) {
                this.this$0.endAudioData();
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0014"}, d2 = {"Lcom/xjsd/xr/sapp/asr/ShortAudioAsrHelper$SocketListener;", "Lokhttp3/WebSocketListener;", "(Lcom/xjsd/xr/sapp/asr/ShortAudioAsrHelper;)V", "onClosed", "", "webSocket", "Lokhttp3/WebSocket;", "code", "", "reason", "", "onClosing", "onFailure", "t", "", "response", "Lokhttp3/Response;", "onMessage", "text", "onOpen", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class SocketListener extends WebSocketListener {
        public SocketListener() {
        }

        public void onClosed(@NotNull WebSocket webSocket, int i, @NotNull String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "reason");
            super.onClosed(webSocket, i, str);
            ShortAudioAsrHelper shortAudioAsrHelper = ShortAudioAsrHelper.this;
            shortAudioAsrHelper.logI("SocketListener onClosed code=" + i + ", reason=" + str);
            ShortAudioAsrHelper.this.notifyClosed(i, str);
        }

        public void onClosing(@NotNull WebSocket webSocket, int i, @NotNull String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "reason");
            super.onClosing(webSocket, i, str);
            ShortAudioAsrHelper shortAudioAsrHelper = ShortAudioAsrHelper.this;
            shortAudioAsrHelper.logI("SocketListener onClosing code=" + i + ", reason=" + str);
            ShortAudioAsrHelper.this.notifyClosing(i, str);
        }

        public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable th, @Nullable Response response) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(th, t.f);
            super.onFailure(webSocket, th, response);
            ShortAudioAsrHelper shortAudioAsrHelper = ShortAudioAsrHelper.this;
            shortAudioAsrHelper.logI("SocketListener onFailure response=" + response + ", t=" + ExceptionsKt.stackTraceToString(th));
            ShortAudioAsrHelper.this.notifyFailed(th, response);
        }

        public void onMessage(@NotNull WebSocket webSocket, @NotNull String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "text");
            super.onMessage(webSocket, str);
            ShortAudioAsrHelper.this.handleMessage(str);
        }

        public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(response, "response");
            super.onOpen(webSocket, response);
            ShortAudioAsrHelper shortAudioAsrHelper = ShortAudioAsrHelper.this;
            shortAudioAsrHelper.logI("SocketListener onOpen response=" + response);
            ShortAudioAsrHelper.this.sendChannelInfo();
        }
    }

    /* access modifiers changed from: private */
    public final void endAudioData() {
        WebSocket webSocket = this.mWebSocket;
        if (webSocket == null) {
            logI("endAudioData websocket is null");
            return;
        }
        if (webSocket != null) {
            webSocket.close(1000, "Websocket is actively closed");
        }
        this.mWebSocket = null;
        this.mSocketListener = null;
        this.mRequestConfig = null;
        this.mAsrRequest = null;
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
    public final void handleMessage(String str) {
        logI("handleMessage from service text=" + str);
        if (!StringsKt.isBlank(str)) {
            try {
                AsrResponse asrResponse = (AsrResponse) GsonHelper.fromJson(str, AsrResponse.class);
                logI("handleMessage asrResponse=" + asrResponse);
                String code = asrResponse.getCode();
                if (Intrinsics.areEqual((Object) code, (Object) "0")) {
                    handleMessageSuccess(asrResponse);
                    return;
                }
                logI("handleMessage 服务异常error code=" + code + ", desc=" + asrResponse.getMsg());
                notifyAsrRunningState(asrResponse);
                stopRequest();
            } catch (Exception e) {
                logI("handleMessage 服务器数据处理异常 " + ExceptionsKt.stackTraceToString(e));
            }
        }
    }

    private final void handleMessageSuccess(AsrResponse asrResponse) {
        String event = asrResponse.getEvent();
        int hashCode = event.hashCode();
        if (hashCode != -636965025) {
            if (hashCode != 235005312) {
                if (hashCode == 799401263 && event.equals(AsrConstants.TRANSLATION_RESULT_SUCCESS)) {
                    AsrResult translation$default = AsrResultExtKt.translation$default(asrResponse, (AsrRequest) null, 1, (Object) null);
                    logI("handleMessageSuccess ASR翻译结果=" + translation$default);
                    notifyAsrResult(translation$default);
                    return;
                }
            } else if (event.equals(AsrConstants.ASR_RESULT_SUCCESS)) {
                AsrResult transcribed$default = AsrResultExtKt.transcribed$default(asrResponse, (AsrRequest) null, 1, (Object) null);
                logI("handleMessageSuccess ASR识别结果=" + transcribed$default);
                notifyAsrResult(transcribed$default);
                return;
            }
        } else if (event.equals(AsrConstants.SYNC_AUDIO_INFO_SUCCESS)) {
            logI("handleMessageSuccess 握手成功！");
            notifyOpen$default(this, (Response) null, 1, (Object) null);
            notifyAsrRunningState(asrResponse);
            return;
        }
        logI("handleMessageSuccess 无需处理的事件=" + event);
    }

    private final void logE(String str, Throwable th) {
        ULog.f6446a.d(TAG, str, th);
    }

    public static /* synthetic */ void logE$default(ShortAudioAsrHelper shortAudioAsrHelper, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        shortAudioAsrHelper.logE(str, th);
    }

    /* access modifiers changed from: private */
    public final void logI(String str) {
        ULog.f6446a.g(TAG, str);
    }

    private final void notifyAsrResult(AsrResult asrResult) {
        for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
            ((AsrResultCallback) value.getValue()).onRemoteAsrResult(asrResult);
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
        for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
            ((AsrResultCallback) value.getValue()).onClosed(i, str);
        }
    }

    /* access modifiers changed from: private */
    public final void notifyClosing(int i, String str) {
        for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
            ((AsrResultCallback) value.getValue()).onClosing(i, str);
        }
    }

    /* access modifiers changed from: private */
    public final void notifyFailed(Throwable th, Response response) {
        stopRequest();
        for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
            ((AsrResultCallback) value.getValue()).onFailure(th, response);
        }
    }

    private final void notifyOpen(Response response) {
        for (Map.Entry<String, AsrResultCallback> value : this.mCallbackMap.entrySet()) {
            ((AsrResultCallback) value.getValue()).onOpen(response);
        }
    }

    public static /* synthetic */ void notifyOpen$default(ShortAudioAsrHelper shortAudioAsrHelper, Response response, int i, Object obj) {
        if ((i & 1) != 0) {
            response = null;
        }
        shortAudioAsrHelper.notifyOpen(response);
    }

    /* access modifiers changed from: private */
    public final void sendAudioData(Message message) {
        WebSocket webSocket = this.mWebSocket;
        Unit unit = null;
        if (webSocket != null) {
            Object obj = message.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.xjsd.xr.sapp.asr.ShortAudioAsrHelper.AudioMessage");
            byte[] audio = ((AudioMessage) obj).getAudio();
            byte[] copyOf = Arrays.copyOf(audio, audio.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            if (!webSocket.send(ByteString.Companion.of(copyOf, 0, copyOf.length))) {
                logE$default(this, "sendRemoteData 发送远端音频数据给服务器异常", (Throwable) null, 2, (Object) null);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            logI("sendRemoteData websocket is null");
        }
    }

    /* access modifiers changed from: private */
    public final void sendChannelInfo() {
        logI("sendChannelInfo requestConfig=" + this.mRequestConfig);
        SpeechRequestConfig speechRequestConfig = this.mRequestConfig;
        if (speechRequestConfig != null) {
            AsrRequest syncAudioInfoRequest = getSyncAudioInfoRequest(speechRequestConfig);
            String json = GsonHelper.toJson(syncAudioInfoRequest);
            WebSocket webSocket = this.mWebSocket;
            if (webSocket != null) {
                webSocket.send(json);
            }
            logI("sendChannelInfo requestJson=" + json);
            this.mAsrRequest = syncAudioInfoRequest;
        }
    }

    public final void cancelAudioMessage() {
        logI("cancelAudioMessage asrRequest=" + this.mAsrRequest);
        AsrRequest asrRequest = this.mAsrRequest;
        if (asrRequest != null) {
            String json = GsonHelper.toJson(new SpeechCancelAudio(asrRequest.getDeviceId(), AsrConstants.CANCEL_AUDIO, asrRequest.getRequestId()));
            WebSocket webSocket = this.mWebSocket;
            if (webSocket != null) {
                webSocket.send(json);
            }
            logI("cancelAudioMessage json=" + json);
        }
    }

    public final void endAudioMessage() {
        logI("endAudioMessage asrRequest=" + this.mAsrRequest);
        AsrRequest asrRequest = this.mAsrRequest;
        if (asrRequest != null) {
            String json = GsonHelper.toJson(new SpeechEndAudio(asrRequest.getDeviceId(), AsrConstants.END_AUDIO, asrRequest.getRequestId()));
            WebSocket webSocket = this.mWebSocket;
            if (webSocket != null) {
                webSocket.send(json);
            }
            logI("endAudioMessage json=" + json);
        }
    }

    public final void init() {
        logI("初始化语音助理ASR识别工具类");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.mHttpClient = builder.connectTimeout(5, timeUnit).readTimeout(5, timeUnit).pingInterval(15, timeUnit).build();
        HandlerThread handlerThread = new HandlerThread(HANDLER_THREAD_MARK);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
        this.mDataHandler = new DataHandler(this, looper);
        this.mHandlerThread = handlerThread;
    }

    public final void pushAudio(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Handler handler = this.mDataHandler;
        if (handler != null) {
            Message obtain = Message.obtain();
            obtain.obj = new AudioMessage(bArr);
            obtain.what = 101;
            handler.sendMessage(obtain);
            return;
        }
        logI("sendAudioData 发送音频消息异常");
    }

    public final void registerAsrResultCallback(@NotNull String str, @NotNull AsrResultCallback asrResultCallback) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(asrResultCallback, "callback");
        this.mCallbackMap.put(str, asrResultCallback);
    }

    public final void release() {
        Handler handler = this.mDataHandler;
        if (handler != null && handler.hasMessages(102)) {
            endAudioData();
        }
        Handler handler2 = this.mDataHandler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
        this.mDataHandler = null;
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.interrupt();
        }
        this.mHandlerThread = null;
        this.mCallbackMap.clear();
        this.mHttpClient = null;
        this.mWebSocket = null;
        this.mSocketListener = null;
        this.mRequestConfig = null;
        this.mAsrRequest = null;
    }

    public final void startRequest(@NotNull SpeechRequestConfig speechRequestConfig) {
        Intrinsics.checkNotNullParameter(speechRequestConfig, "requestConfig");
        logI("startRequest requestConfig=" + speechRequestConfig);
        this.mRequestConfig = speechRequestConfig;
        WebSocket webSocket = null;
        if (this.mWebSocket != null) {
            logI("startRequest websocket is not null");
            WebSocket webSocket2 = this.mWebSocket;
            if (webSocket2 != null) {
                webSocket2.cancel();
            }
            this.mWebSocket = null;
            this.mSocketListener = null;
        }
        SocketListener socketListener = new SocketListener();
        OkHttpClient okHttpClient = this.mHttpClient;
        if (okHttpClient != null) {
            webSocket = okHttpClient.newWebSocket(new Request.Builder().url(AsrConstants.INSTANCE.getAsrUrl$asr_release(speechRequestConfig.getWebType())).build(), socketListener);
        }
        this.mWebSocket = webSocket;
        this.mSocketListener = socketListener;
    }

    public final void stopRequest() {
        logI("stopRequest");
        Handler handler = this.mDataHandler;
        if (handler != null) {
            handler.removeMessages(101);
            Message obtain = Message.obtain();
            obtain.what = 102;
            handler.sendMessage(obtain);
            return;
        }
        logI("关闭WebSocket通道异常");
    }

    public final void unRegisterAsrResultCallback(@NotNull String str, @NotNull AsrResultCallback asrResultCallback) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(asrResultCallback, "callback");
        this.mCallbackMap.remove(str, asrResultCallback);
    }
}
