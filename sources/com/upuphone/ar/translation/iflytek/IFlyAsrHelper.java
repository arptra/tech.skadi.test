package com.upuphone.ar.translation.iflytek;

import com.geetest.sdk.t;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.audio.thread.ThreadPollHelper;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.iflytek.entity.TransConfig;
import com.upuphone.ar.translation.iflytek.entity.TranslationReqConfig;
import com.upuphone.ar.translation.iflytek.entity.TranslationResult;
import com.upuphone.ar.translation.iflytek.ext.StringExtKt;
import com.upuphone.ar.translation.iflytek.ext.TranslationResultExtKt;
import com.upuphone.ar.translation.iflytek.listener.TranslateMsgListener;
import com.upuphone.ar.translation.utils.GsonUtils;
import com.upuphone.runasone.relay.api.IntentKey;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00012\u00020\u0001:\n\u0001\u0001\u0001 \u0001¡\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ!\u0010\u000f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0003J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0015J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u0003J\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u0003J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u001f\u0010#\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b)\u0010(J\u0018\u0010*\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H@¢\u0006\u0004\b*\u0010+J\u0018\u0010,\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H@¢\u0006\u0004\b,\u0010+J#\u0010-\u001a\u00020%2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b-\u0010.J!\u00101\u001a\u00020\b2\u0006\u0010/\u001a\u00020%2\b\b\u0002\u00100\u001a\u00020\u0017H\u0002¢\u0006\u0004\b1\u00102J\u0018\u00103\u001a\u00020\b2\u0006\u0010/\u001a\u00020%H@¢\u0006\u0004\b3\u0010+J\u0017\u00105\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0004H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0004H\u0002¢\u0006\u0004\b7\u00106J\u0017\u00109\u001a\u00020\b2\u0006\u00108\u001a\u00020\u0004H\u0002¢\u0006\u0004\b9\u00106J\u0017\u0010:\u001a\u00020\b2\u0006\u00108\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u00106J#\u0010?\u001a\u00020\b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020=H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\bH\u0002¢\u0006\u0004\bA\u0010\u0003J\u001f\u0010D\u001a\u00020\b2\u0006\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020\u0004H\u0002¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020\b2\u0006\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020\u0004H\u0002¢\u0006\u0004\bF\u0010EJ!\u0010I\u001a\u00020\b2\u0006\u0010H\u001a\u00020G2\b\u0010<\u001a\u0004\u0018\u00010;H\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\bH\u0002¢\u0006\u0004\bK\u0010\u0003J\u000f\u0010L\u001a\u00020\bH\u0002¢\u0006\u0004\bL\u0010\u0003J\u001f\u0010O\u001a\u00020\b2\u0006\u0010M\u001a\u00020=2\u0006\u0010N\u001a\u00020\u0004H\u0002¢\u0006\u0004\bO\u0010PJ\u001f\u0010R\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0004H\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010T\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\u0004H\u0002¢\u0006\u0004\bT\u00106J\u000f\u0010U\u001a\u00020 H\u0002¢\u0006\u0004\bU\u0010VJ\u000f\u0010X\u001a\u00020WH\u0002¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020WH\u0002¢\u0006\u0004\bZ\u0010YR\u001b\u0010`\u001a\u00020[8BX\u0002¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R \u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060a8\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u001c\u0010h\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\be\u0010f\u0012\u0004\bg\u0010\u0003R\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u001c\u0010p\u001a\b\u0018\u00010mR\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010s\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010w\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bx\u0010\u0018R\u0016\u0010|\u001a\u00020W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010~\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b}\u0010kR\u001f\u0010\u0001\u001a\b\u0018\u00010R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010rR\u001a\u0010\u0001\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0018\u0010\u0001\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010\u0018R\u0018\u0010\u0001\u001a\u00020W8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010{R\u0018\u0010\u0001\u001a\u00020W8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010{R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010\u0018R\u0018\u0010\u0001\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010fR\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bH\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006¢\u0001"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper;", "", "<init>", "()V", "", "key", "Lcom/upuphone/ar/translation/iflytek/listener/TranslateMsgListener;", "listener", "", "o0", "(Ljava/lang/String;Lcom/upuphone/ar/translation/iflytek/listener/TranslateMsgListener;)V", "C0", "Lcom/upuphone/ar/translation/iflytek/entity/TransConfig;", "remoteConfig", "proximalConfig", "w0", "(Lcom/upuphone/ar/translation/iflytek/entity/TransConfig;Lcom/upuphone/ar/translation/iflytek/entity/TransConfig;)V", "B0", "", "data", "s0", "([B)V", "t0", "", "Z", "()Z", "p0", "d0", "transConfig", "v0", "(Lcom/upuphone/ar/translation/iflytek/entity/TransConfig;)V", "u0", "", "seconds", "Lcom/upuphone/ar/translation/iflytek/entity/TranslationReqConfig;", "U", "(Lcom/upuphone/ar/translation/iflytek/entity/TransConfig;J)Lcom/upuphone/ar/translation/iflytek/entity/TranslationReqConfig;", "", "voiceEndArg", "z0", "(I)V", "x0", "A0", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "y0", "r0", "(Lcom/upuphone/ar/translation/iflytek/entity/TransConfig;Lcom/upuphone/ar/translation/iflytek/entity/TransConfig;)I", "reconnectMark", "isNeedCallBack", "l0", "(IZ)V", "n0", "text", "Y", "(Ljava/lang/String;)V", "X", "result", "i0", "g0", "Lokhttp3/Response;", "response", "Lcom/upuphone/ar/translation/iflytek/entity/TranslationResult;", "transResult", "e0", "(Lokhttp3/Response;Lcom/upuphone/ar/translation/iflytek/entity/TranslationResult;)V", "h0", "code", "reason", "b0", "(ILjava/lang/String;)V", "a0", "", "t", "c0", "(Ljava/lang/Throwable;Lokhttp3/Response;)V", "q0", "k0", "translationResult", "action", "j0", "(Lcom/upuphone/ar/translation/iflytek/entity/TranslationResult;Ljava/lang/String;)V", "mark", "V", "(Ljava/lang/String;Ljava/lang/String;)V", "W", "T", "()J", "Lkotlinx/coroutines/CoroutineScope;", "R", "()Lkotlinx/coroutines/CoroutineScope;", "Q", "Lokhttp3/OkHttpClient;", "a", "Lkotlin/Lazy;", "S", "()Lokhttp3/OkHttpClient;", "mHttpClient", "", "b", "Ljava/util/Map;", "mTransCallbackMap", "c", "I", "getMTransChannelType$annotations", "mTransChannelType", "Lokhttp3/WebSocket;", "d", "Lokhttp3/WebSocket;", "mRemoteWebSocket", "Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper$RemoteSocketListener;", "e", "Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper$RemoteSocketListener;", "mRemoteSocketListener", "f", "Lcom/upuphone/ar/translation/iflytek/entity/TransConfig;", "mRemoteTransConfig", "Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper$WebSocketState;", "g", "Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper$WebSocketState;", "mRemoteWebSocketState", "h", "mRemoteHasSend", "i", "Lkotlinx/coroutines/CoroutineScope;", "mRemoteFeedCoroutine", "j", "mProximalWebSocket", "Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper$ProximalSocketListener;", "k", "Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper$ProximalSocketListener;", "mProximalSocketListener", "l", "mProximalTransConfig", "m", "mProximalSocketState", "n", "mProximalHasSend", "o", "mProximalFeedCoroutine", "p", "mIoScope", "Ljava/util/concurrent/atomic/AtomicBoolean;", "q", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsUserClosedSocket", "r", "mIsAutoReconnecting", "s", "mReconnectCount", "mIsExecutingReconnect", "Lkotlinx/coroutines/Job;", "u", "Lkotlinx/coroutines/Job;", "mExecutingReconnectJob", "v", "mIsExecutingReconnectDelay", "w", "AudioMessage", "Companion", "ProximalSocketListener", "RemoteSocketListener", "WebSocketState", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nIFlyAsrHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IFlyAsrHelper.kt\ncom/upuphone/ar/translation/iflytek/IFlyAsrHelper\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1396:1\n215#2,2:1397\n215#2,2:1399\n215#2,2:1401\n215#2,2:1403\n215#2,2:1405\n215#2,2:1407\n215#2,2:1409\n215#2,2:1411\n215#2,2:1413\n215#2,2:1415\n215#2,2:1417\n215#2,2:1419\n215#2,2:1421\n215#2,2:1423\n1#3:1425\n*S KotlinDebug\n*F\n+ 1 IFlyAsrHelper.kt\ncom/upuphone/ar/translation/iflytek/IFlyAsrHelper\n*L\n695#1:1397,2\n706#1:1399,2\n738#1:1401,2\n757#1:1403,2\n776#1:1405,2\n793#1:1407,2\n820#1:1409,2\n829#1:1411,2\n858#1:1413,2\n867#1:1415,2\n894#1:1417,2\n902#1:1419,2\n910#1:1421,2\n971#1:1423,2\n*E\n"})
public final class IFlyAsrHelper {
    public static final Companion w = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f6208a = LazyKt.lazy(IFlyAsrHelper$mHttpClient$2.INSTANCE);
    public final Map b = new LinkedHashMap();
    public int c;
    public WebSocket d;
    public RemoteSocketListener e;
    public TransConfig f;
    public WebSocketState g;
    public boolean h;
    public CoroutineScope i = Q();
    public WebSocket j;
    public ProximalSocketListener k;
    public TransConfig l;
    public WebSocketState m;
    public boolean n;
    public CoroutineScope o = Q();
    public CoroutineScope p = R();
    public AtomicBoolean q = new AtomicBoolean(false);
    public boolean r;
    public int s;
    public AtomicBoolean t = new AtomicBoolean(false);
    public Job u;
    public AtomicBoolean v = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper$AudioMessage;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "a", "[B", "getAudio", "()[B", "audio", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class AudioMessage {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f6209a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) AudioMessage.class, (Object) obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.translation.iflytek.IFlyAsrHelper.AudioMessage");
            return Arrays.equals(this.f6209a, ((AudioMessage) obj).f6209a);
        }

        public int hashCode() {
            return Arrays.hashCode(this.f6209a);
        }

        public String toString() {
            String arrays = Arrays.toString(this.f6209a);
            return "AudioMessage(audio=" + arrays + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper$Companion;", "", "()V", "CONNECT_TIMEOUT", "", "MARK_PROXIMAL", "", "MARK_REMOTE", "PROXIMAL_CLOSE_CODE", "", "READ_TIMEOUT", "RECONNECT_BASE_TIME", "RECONNECT_MARK_INVALID", "RECONNECT_MARK_PROXIMAL", "RECONNECT_MARK_REMOTE", "RECONNECT_MAX_TIME", "REMOTE_CLOSE_CODE", "TAG", "TRANS_ACTION_ERROR", "TRANS_ACTION_RESULT", "TRANS_ACTION_STARTED", "VOICE_END_NO_REPLY_ARG", "VOICE_END_REPLY_ARG", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper$ProximalSocketListener;", "Lokhttp3/WebSocketListener;", "(Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper;)V", "onClosed", "", "webSocket", "Lokhttp3/WebSocket;", "code", "", "reason", "", "onClosing", "onFailure", "t", "", "response", "Lokhttp3/Response;", "onMessage", "text", "onOpen", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ProximalSocketListener extends WebSocketListener {
        public ProximalSocketListener() {
        }

        public void onClosed(WebSocket webSocket, int i, String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "reason");
            super.onClosed(webSocket, i, str);
            LogExt.j("ProximalSocketListener onClosed code=" + i + ", reason=" + str, "IFlyAsrHelper");
            WebSocketState j = IFlyAsrHelper.this.m;
            if (j != null) {
                j.e(true);
            }
            IFlyAsrHelper.this.a0(i, str);
        }

        public void onClosing(WebSocket webSocket, int i, String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "reason");
            super.onClosing(webSocket, i, str);
            LogExt.j("ProximalSocketListener onClosing code=" + i + ", reason=" + str, "IFlyAsrHelper");
            IFlyAsrHelper.this.b0(i, str);
        }

        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            WebSocketState j;
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(th, t.f);
            super.onFailure(webSocket, th, response);
            String stackTraceToString = ExceptionsKt.stackTraceToString(th);
            LogExt.j("ProximalSocketListener onFailure response=" + response + ", t=" + stackTraceToString, "IFlyAsrHelper");
            if (!(th instanceof IOException) || (((j = IFlyAsrHelper.this.m) == null || !j.c()) && !IFlyAsrHelper.this.r)) {
                IFlyAsrHelper.this.c0(th, response);
                WebSocketState j2 = IFlyAsrHelper.this.m;
                if (j2 != null) {
                    j2.h(false);
                    return;
                }
                return;
            }
            IFlyAsrHelper iFlyAsrHelper = IFlyAsrHelper.this;
            iFlyAsrHelper.l0(2, !iFlyAsrHelper.r);
        }

        public void onMessage(WebSocket webSocket, String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "text");
            super.onMessage(webSocket, str);
            IFlyAsrHelper.this.X(str);
        }

        public void onOpen(WebSocket webSocket, Response response) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(response, "response");
            super.onOpen(webSocket, response);
            LogExt.j("ProximalSocketListener onOpen response=" + response, "IFlyAsrHelper");
            WebSocketState j = IFlyAsrHelper.this.m;
            if (j != null) {
                j.h(true);
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper$RemoteSocketListener;", "Lokhttp3/WebSocketListener;", "(Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper;)V", "onClosed", "", "webSocket", "Lokhttp3/WebSocket;", "code", "", "reason", "", "onClosing", "onFailure", "t", "", "response", "Lokhttp3/Response;", "onMessage", "text", "onOpen", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class RemoteSocketListener extends WebSocketListener {
        public RemoteSocketListener() {
        }

        public void onClosed(WebSocket webSocket, int i, String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "reason");
            super.onClosed(webSocket, i, str);
            LogExt.j("RemoteSocketListener onClosed code=" + i + ", reason=" + str, "IFlyAsrHelper");
            WebSocketState q = IFlyAsrHelper.this.g;
            if (q != null) {
                q.e(true);
            }
            IFlyAsrHelper.this.a0(i, str);
        }

        public void onClosing(WebSocket webSocket, int i, String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "reason");
            super.onClosing(webSocket, i, str);
            LogExt.j("RemoteSocketListener onClosing code=" + i + ", reason=" + str, "IFlyAsrHelper");
            IFlyAsrHelper.this.b0(i, str);
        }

        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            WebSocketState q;
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(th, t.f);
            super.onFailure(webSocket, th, response);
            String stackTraceToString = ExceptionsKt.stackTraceToString(th);
            LogExt.j("RemoteSocketListener onFailure response=" + response + ", t=" + stackTraceToString, "IFlyAsrHelper");
            if (!(th instanceof IOException) || (((q = IFlyAsrHelper.this.g) == null || !q.c()) && !IFlyAsrHelper.this.r)) {
                IFlyAsrHelper.this.c0(th, response);
                WebSocketState q2 = IFlyAsrHelper.this.g;
                if (q2 != null) {
                    q2.h(false);
                    return;
                }
                return;
            }
            IFlyAsrHelper iFlyAsrHelper = IFlyAsrHelper.this;
            iFlyAsrHelper.l0(1, !iFlyAsrHelper.r);
        }

        public void onMessage(WebSocket webSocket, String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "text");
            super.onMessage(webSocket, str);
            IFlyAsrHelper.this.Y(str);
        }

        public void onOpen(WebSocket webSocket, Response response) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(response, "response");
            super.onOpen(webSocket, response);
            LogExt.j("RemoteSocketListener onOpen response=" + response, "IFlyAsrHelper");
            WebSocketState q = IFlyAsrHelper.this.g;
            if (q != null) {
                q.h(true);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\b\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper$WebSocketState;", "", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "a", "Z", "d", "()Z", "h", "(Z)V", "isOpened", "b", "e", "isClosed", "c", "g", "isMsgStarted", "f", "isMsgError", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class WebSocketState {

        /* renamed from: a  reason: collision with root package name */
        public boolean f6212a;
        public boolean b;
        public boolean c;
        public boolean d;

        public final boolean a() {
            return this.b;
        }

        public final boolean b() {
            return this.d;
        }

        public final boolean c() {
            return this.c;
        }

        public final boolean d() {
            return this.f6212a;
        }

        public final void e(boolean z) {
            this.b = z;
        }

        public final void f(boolean z) {
            this.d = z;
        }

        public final void g(boolean z) {
            this.c = z;
        }

        public final void h(boolean z) {
            this.f6212a = z;
        }

        public String toString() {
            boolean z = this.f6212a;
            boolean z2 = this.b;
            boolean z3 = this.c;
            boolean z4 = this.d;
            return "WebSocketState(isOpened=" + z + ", isClosed=" + z2 + ", isMsgStarted=" + z3 + ", isMsgError=" + z4 + ")";
        }
    }

    public static /* synthetic */ void f0(IFlyAsrHelper iFlyAsrHelper, Response response, TranslationResult translationResult, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            response = null;
        }
        iFlyAsrHelper.e0(response, translationResult);
    }

    public static /* synthetic */ void m0(IFlyAsrHelper iFlyAsrHelper, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        iFlyAsrHelper.l0(i2, z);
    }

    public final Object A0(int i2, Continuation continuation) {
        boolean z = this.h;
        LogExt.j("stopRemoteRequest voiceEndArg=" + i2 + ", mRemoteHasSend=" + z, "IFlyAsrHelper");
        Object g2 = BuildersKt.g(Dispatchers.b(), new IFlyAsrHelper$stopRemoteRequestNotCoroutine$2(this, i2, (Continuation<? super IFlyAsrHelper$stopRemoteRequestNotCoroutine$2>) null), continuation);
        return g2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g2 : Unit.INSTANCE;
    }

    public final void B0() {
        String a2 = StringExtKt.a(this.c);
        LogExt.j("stopRequest mTransChannelType=" + a2, "IFlyAsrHelper");
        this.q.set(true);
        this.r = false;
        this.s = 0;
        this.t.set(false);
        Job job = this.u;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.u = null;
        this.v.set(false);
        int i2 = this.c;
        if (i2 == 1) {
            z0(1);
            x0(1);
        } else if (i2 == 2) {
            z0(1);
        } else if (i2 != 3) {
            LogExt.j("stopRequest 关闭ASR WebSocket失败，请查看TranslationChannel中支持的通道类型！", "IFlyAsrHelper");
        } else {
            x0(1);
        }
    }

    public final void C0(String str, TranslateMsgListener translateMsgListener) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(translateMsgListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b.remove(str, translateMsgListener);
    }

    public final CoroutineScope Q() {
        return CoroutineScopeKt.a(ExecutorsKt.b(ThreadPollHelper.f6199a.a()).plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    }

    public final CoroutineScope R() {
        return CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    }

    public final OkHttpClient S() {
        return (OkHttpClient) this.f6208a.getValue();
    }

    public final long T() {
        int i2 = this.s;
        this.s = i2 + 1;
        Long valueOf = Long.valueOf(((long) i2) * 5000);
        if (valueOf.longValue() > 60000) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.longValue();
        }
        return 60000;
    }

    public final TranslationReqConfig U(TransConfig transConfig, long j2) {
        return new TranslationReqConfig(transConfig.getUrl(), transConfig.getAppKey(), transConfig.getAppId(), j2 != 0 ? String.valueOf(j2) : null, (String) null, transConfig.getSrcLang(), (String) null, (Integer) null, transConfig.getDstLang(), (String) null, (String) null, (Integer) null, (Integer) null);
    }

    public final void V(String str, String str2) {
        String a2 = StringExtKt.a(this.c);
        LogExt.j("handleErrorState mTransChannelType=" + a2 + ", mark=" + str + ", action=" + str2, "IFlyAsrHelper");
        this.r = false;
        this.s = 0;
        int i2 = this.c;
        if (i2 == 1) {
            W(str);
        } else if (i2 == 2) {
            z0(2);
        } else if (i2 != 3) {
            LogExt.j("handleRunningState:: 无效的通道类型，请查看TranslationChannel中支持的通道类型！", "IFlyAsrHelper");
        } else {
            x0(2);
        }
    }

    public final void W(String str) {
        boolean z = false;
        if (Intrinsics.areEqual((Object) str, (Object) "remote")) {
            WebSocketState webSocketState = this.g;
            boolean b2 = webSocketState != null ? webSocketState.b() : false;
            WebSocketState webSocketState2 = this.m;
            if (webSocketState2 != null) {
                z = webSocketState2.d();
            }
            LogExt.j("handleErrorStateDualChannel MARK_REMOTE isRemoteMsgError=" + b2 + ", isProximalOpened=" + z, "IFlyAsrHelper");
            if (b2) {
                z0(2);
                if (z) {
                    x0(1);
                }
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) "proximal")) {
            WebSocketState webSocketState3 = this.m;
            boolean b3 = webSocketState3 != null ? webSocketState3.b() : false;
            WebSocketState webSocketState4 = this.g;
            if (webSocketState4 != null) {
                z = webSocketState4.d();
            }
            LogExt.j("handleErrorStateDualChannel MARK_PROXIMAL isProximalMsgError=" + b3 + ", isRemoteOpened=" + z, "IFlyAsrHelper");
            if (b3) {
                x0(2);
                if (z) {
                    z0(1);
                }
            }
        } else {
            LogExt.j("handleErrorStateDualChannel 无效的标记类型=" + str, "IFlyAsrHelper");
        }
    }

    public final void X(String str) {
        String str2;
        if (StringsKt.isBlank(str)) {
            LogExt.j("handleProximalMessage 服务器返回近端转写或者翻译结果为空", "IFlyAsrHelper");
            return;
        }
        try {
            TranslationResult translationResult = (TranslationResult) GsonUtils.a(str, TranslationResult.class);
            LogExt.j("handleProximalMessage translationResult=" + translationResult, "IFlyAsrHelper");
            String action = translationResult.getAction();
            int hashCode = action.hashCode();
            if (hashCode != -1897185151) {
                if (hashCode != -934426595) {
                    if (hashCode == 96784904) {
                        if (action.equals("error")) {
                            String code = translationResult.getCode();
                            LogExt.j("handleProximalMessage 数据异常code=" + code + ", desc=" + translationResult + ".desc", "IFlyAsrHelper");
                            WebSocketState webSocketState = this.m;
                            if (webSocketState != null) {
                                webSocketState.f(false);
                            }
                            j0(translationResult, "error");
                            V("proximal", action);
                            return;
                        }
                    }
                } else if (action.equals("result")) {
                    String data = translationResult.getData();
                    if (StringsKt.isBlank(data)) {
                        LogExt.j("handleProximalMessage 服务器返回data数据为空", "IFlyAsrHelper");
                        return;
                    }
                    String optString = new JSONObject(data).optString("biz");
                    if (optString != null) {
                        if (!StringsKt.isBlank(optString)) {
                            str2 = TranslationResultExtKt.c(translationResult);
                            LogExt.j("handleProximalMessage 翻译结果[" + str2 + "]", "IFlyAsrHelper");
                            g0(str2);
                            return;
                        }
                    }
                    str2 = TranslationResultExtKt.b(translationResult);
                    LogExt.j("handleProximalMessage 转写结果[" + str2 + "]", "IFlyAsrHelper");
                    g0(str2);
                    return;
                }
            } else if (action.equals("started")) {
                LogExt.j("handleProximalMessage socket握手成功！", "IFlyAsrHelper");
                WebSocketState webSocketState2 = this.m;
                if (webSocketState2 != null) {
                    webSocketState2.g(true);
                }
                f0(this, (Response) null, translationResult, 1, (Object) null);
                return;
            }
            LogExt.h("handleProximalMessage 翻译异常的action=" + action, "IFlyAsrHelper");
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.h("近端数据处理异常error=" + stackTraceToString, "IFlyAsrHelper");
        }
    }

    public final void Y(String str) {
        String str2;
        if (StringsKt.isBlank(str)) {
            LogExt.j("handleRemoteMessage 服务器返回远端转写或者翻译结果为空", "IFlyAsrHelper");
            return;
        }
        try {
            TranslationResult translationResult = (TranslationResult) GsonUtils.a(str, TranslationResult.class);
            LogExt.j("handleRemoteMessage translationResult=" + translationResult, "IFlyAsrHelper");
            String action = translationResult.getAction();
            int hashCode = action.hashCode();
            if (hashCode != -1897185151) {
                if (hashCode != -934426595) {
                    if (hashCode == 96784904) {
                        if (action.equals("error")) {
                            String code = translationResult.getCode();
                            String desc = translationResult.getDesc();
                            LogExt.j("handleRemoteMessage 数据异常code=" + code + ", desc=" + desc, "IFlyAsrHelper");
                            WebSocketState webSocketState = this.g;
                            if (webSocketState != null) {
                                webSocketState.f(false);
                            }
                            j0(translationResult, "error");
                            V("remote", action);
                            return;
                        }
                    }
                } else if (action.equals("result")) {
                    String data = translationResult.getData();
                    if (StringsKt.isBlank(data)) {
                        LogExt.j("handleRemoteMessage 服务器返回data数据为空", "IFlyAsrHelper");
                        return;
                    }
                    String optString = new JSONObject(data).optString("biz");
                    if (optString != null) {
                        if (!StringsKt.isBlank(optString)) {
                            str2 = TranslationResultExtKt.c(translationResult);
                            LogExt.j("handleRemoteMessage 翻译结果[" + str2 + "]", "IFlyAsrHelper");
                            i0(str2);
                            return;
                        }
                    }
                    str2 = TranslationResultExtKt.b(translationResult);
                    LogExt.j("handleRemoteMessage 转写结果[" + str2 + "]", "IFlyAsrHelper");
                    i0(str2);
                    return;
                }
            } else if (action.equals("started")) {
                LogExt.j("handleRemoteMessage socket握手成功！", "IFlyAsrHelper");
                WebSocketState webSocketState2 = this.g;
                if (webSocketState2 != null) {
                    webSocketState2.g(true);
                }
                f0(this, (Response) null, translationResult, 1, (Object) null);
                return;
            }
            LogExt.h("handleRemoteMessage 远端翻译异常的action=" + action, "IFlyAsrHelper");
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.h("远端数据处理异常=" + stackTraceToString, "IFlyAsrHelper");
        }
    }

    public final boolean Z() {
        return this.r;
    }

    public final void a0(int i2, String str) {
        String a2 = StringExtKt.a(this.c);
        LogExt.j("notifyClosed mTransChannelType=" + a2, "IFlyAsrHelper");
        WebSocketState webSocketState = this.g;
        WebSocketState webSocketState2 = this.m;
        LogExt.j("notifyClosed remote=" + webSocketState + ", proximal=" + webSocketState2, "IFlyAsrHelper");
        int i3 = this.c;
        if (i3 == 1) {
            WebSocketState webSocketState3 = this.g;
            boolean z = false;
            boolean a3 = webSocketState3 != null ? webSocketState3.a() : false;
            WebSocketState webSocketState4 = this.m;
            if (webSocketState4 != null) {
                z = webSocketState4.a();
            }
            int size = this.b.size();
            LogExt.j("notifyClosed remoteClosed=" + a3 + ", proximalClosed=" + z + ", callback size=" + size, "IFlyAsrHelper");
            if (a3 && z) {
                for (Map.Entry value : this.b.entrySet()) {
                    ((TranslateMsgListener) value.getValue()).onClosed(i2, str);
                }
            }
        } else if (i3 == 2 || i3 == 3) {
            int size2 = this.b.size();
            LogExt.j("notifyClosed callback size=" + size2, "IFlyAsrHelper");
            for (Map.Entry value2 : this.b.entrySet()) {
                ((TranslateMsgListener) value2.getValue()).onClosed(i2, str);
            }
        } else {
            LogExt.j("notifyClosed:: 无效的通道类型，请查看TranslationChannel中支持的通道类型！", "IFlyAsrHelper");
        }
    }

    public final void b0(int i2, String str) {
        String a2 = StringExtKt.a(this.c);
        LogExt.j("notifyClosing mTransChannelType=" + a2, "IFlyAsrHelper");
        WebSocketState webSocketState = this.g;
        WebSocketState webSocketState2 = this.m;
        LogExt.j("notifyClosing remote=" + webSocketState + ", proximal=" + webSocketState2, "IFlyAsrHelper");
        int i3 = this.c;
        if (i3 == 1) {
            WebSocketState webSocketState3 = this.g;
            boolean z = false;
            boolean c2 = webSocketState3 != null ? webSocketState3.c() : false;
            WebSocketState webSocketState4 = this.m;
            if (webSocketState4 != null) {
                z = webSocketState4.c();
            }
            int size = this.b.size();
            LogExt.j("notifyClosing remoteMsgStarted=" + c2 + ", proximalMsgStarted=" + z + ", callback size=" + size, "IFlyAsrHelper");
            if (c2 || z) {
                for (Map.Entry value : this.b.entrySet()) {
                    ((TranslateMsgListener) value.getValue()).onClosing(i2, str);
                }
            }
        } else if (i3 == 2 || i3 == 3) {
            int size2 = this.b.size();
            LogExt.j("notifyClosing callback size=" + size2, "IFlyAsrHelper");
            for (Map.Entry value2 : this.b.entrySet()) {
                ((TranslateMsgListener) value2.getValue()).onClosing(i2, str);
            }
        } else {
            LogExt.j("notifyClosing:: 无效的通道类型，请查看TranslationChannel中支持的通道类型！", "IFlyAsrHelper");
        }
    }

    public final void c0(Throwable th, Response response) {
        String a2 = StringExtKt.a(this.c);
        LogExt.j("notifyFailed mTransChannelType=" + a2, "IFlyAsrHelper");
        WebSocketState webSocketState = this.g;
        WebSocketState webSocketState2 = this.m;
        LogExt.j("notifyFailed remote=" + webSocketState + ", proximal=" + webSocketState2, "IFlyAsrHelper");
        int i2 = this.c;
        if (i2 == 1) {
            q0();
            k0();
            int size = this.b.size();
            LogExt.j("notifyFailed callback size=" + size, "IFlyAsrHelper");
            for (Map.Entry value : this.b.entrySet()) {
                ((TranslateMsgListener) value.getValue()).onFailure(th, response);
            }
        } else if (i2 == 2) {
            q0();
            int size2 = this.b.size();
            LogExt.j("notifyFailed callback size=" + size2, "IFlyAsrHelper");
            for (Map.Entry value2 : this.b.entrySet()) {
                ((TranslateMsgListener) value2.getValue()).onFailure(th, response);
            }
        } else if (i2 != 3) {
            LogExt.j("notifyFailed 无效的通道类型，请查看TranslationChannel中支持的通道类型！", "IFlyAsrHelper");
        } else {
            k0();
            int size3 = this.b.size();
            LogExt.j("notifyFailed callback size=" + size3, "IFlyAsrHelper");
            for (Map.Entry value3 : this.b.entrySet()) {
                ((TranslateMsgListener) value3.getValue()).onFailure(th, response);
            }
        }
    }

    public final void d0() {
        boolean z = this.t.get();
        boolean z2 = this.v.get();
        LogExt.j("notifyNetworkConnected mIsExecutingReconnect=" + z + ", mIsExecutingReconnectDelay=" + z2, "IFlyAsrHelper");
        if (this.t.get() && this.v.get()) {
            this.t.set(false);
            this.v.set(false);
            Job job = this.u;
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
            }
            this.u = null;
            this.s = 0;
            m0(this, 0, false, 2, (Object) null);
        }
    }

    public final void e0(Response response, TranslationResult translationResult) {
        String a2 = StringExtKt.a(this.c);
        LogExt.j("notifyOpen mTransChannelType=" + a2, "IFlyAsrHelper");
        WebSocketState webSocketState = this.g;
        WebSocketState webSocketState2 = this.m;
        LogExt.j("notifyOpen remote=" + webSocketState + ", proximal=" + webSocketState2, "IFlyAsrHelper");
        int i2 = this.c;
        boolean z = false;
        if (i2 == 1) {
            WebSocketState webSocketState3 = this.g;
            boolean c2 = webSocketState3 != null ? webSocketState3.c() : false;
            WebSocketState webSocketState4 = this.m;
            if (webSocketState4 != null) {
                z = webSocketState4.c();
            }
            int size = this.b.size();
            LogExt.j("notifyOpen remoteMsgStarted=" + c2 + ", proximalMsgStarted=" + z + ", callback size=" + size, "IFlyAsrHelper");
            if (c2 && z) {
                if (this.r) {
                    h0();
                    return;
                }
                for (Map.Entry value : this.b.entrySet()) {
                    ((TranslateMsgListener) value.getValue()).onOpen(response);
                }
                j0(translationResult, "started");
            }
        } else if (i2 == 2) {
            WebSocketState webSocketState5 = this.g;
            if (webSocketState5 != null) {
                z = webSocketState5.c();
            }
            int size2 = this.b.size();
            LogExt.j("notifyOpen remoteMsgStarted=" + z + ", callback size=" + size2, "IFlyAsrHelper");
            if (z) {
                if (this.r) {
                    h0();
                    return;
                }
                for (Map.Entry value2 : this.b.entrySet()) {
                    ((TranslateMsgListener) value2.getValue()).onOpen(response);
                }
                j0(translationResult, "started");
            }
        } else if (i2 != 3) {
            LogExt.j("notifyOpen 无效的通道类型，请查看TranslationChannel中支持的通道类型！", "IFlyAsrHelper");
        } else {
            WebSocketState webSocketState6 = this.m;
            if (webSocketState6 != null) {
                z = webSocketState6.c();
            }
            int size3 = this.b.size();
            LogExt.j("notifyOpen proximalMsgStarted=" + z + ", callback size=" + size3, "IFlyAsrHelper");
            if (z) {
                if (this.r) {
                    h0();
                    return;
                }
                for (Map.Entry value3 : this.b.entrySet()) {
                    ((TranslateMsgListener) value3.getValue()).onOpen(response);
                }
                j0(translationResult, "started");
            }
        }
    }

    public final void g0(String str) {
        for (Map.Entry value : this.b.entrySet()) {
            ((TranslateMsgListener) value.getValue()).c(str);
        }
    }

    public final void h0() {
        LogExt.j("notifyReconnectSuccess no need to call back Socket open again", "IFlyAsrHelper");
        for (Map.Entry value : this.b.entrySet()) {
            ((TranslateMsgListener) value.getValue()).onAsrReconnectSuccess();
        }
        this.r = false;
        this.s = 0;
    }

    public final void i0(String str) {
        for (Map.Entry value : this.b.entrySet()) {
            ((TranslateMsgListener) value.getValue()).a(str);
        }
    }

    public final void j0(TranslationResult translationResult, String str) {
        try {
            String d2 = GsonUtils.d(TranslationResultExtKt.a(translationResult, str));
            int size = this.b.size();
            LogExt.j("notifyTranslateRunningState runningJson=" + d2 + ", callback size=" + size, "IFlyAsrHelper");
            for (Map.Entry value : this.b.entrySet()) {
                ((TranslateMsgListener) value.getValue()).b(d2);
            }
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.j("notifyTranslateRunningState error=" + stackTraceToString, "IFlyAsrHelper");
        }
    }

    public final void k0() {
        WebSocketState webSocketState = this.m;
        boolean z = false;
        boolean d2 = webSocketState != null ? webSocketState.d() : false;
        WebSocketState webSocketState2 = this.m;
        if (webSocketState2 != null) {
            z = webSocketState2.c();
        }
        LogExt.j("proximalSocketFailedToClose proximalOpened=" + d2 + ", proximalMsgStarted=" + z, "IFlyAsrHelper");
        if (d2) {
            x0(z ? 1 : 2);
        }
    }

    public final void l0(int i2, boolean z) {
        if (this.t.compareAndSet(false, true)) {
            this.u = BuildersKt__Builders_commonKt.d(this.p, (CoroutineContext) null, (CoroutineStart) null, new IFlyAsrHelper$reconnectRequest$1(z, this, i2, (Continuation<? super IFlyAsrHelper$reconnectRequest$1>) null), 3, (Object) null);
        } else {
            LogExt.j("reconnectRequest reconnecting is in progress. Please do not try again.", "IFlyAsrHelper");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n0(int r11, kotlin.coroutines.Continuation r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.upuphone.ar.translation.iflytek.IFlyAsrHelper$reconnectToStopRequest$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper$reconnectToStopRequest$1 r0 = (com.upuphone.ar.translation.iflytek.IFlyAsrHelper$reconnectToStopRequest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper$reconnectToStopRequest$1 r0 = new com.upuphone.ar.translation.iflytek.IFlyAsrHelper$reconnectToStopRequest$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
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
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00b3
        L_0x0034:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003c:
            java.lang.Object r10 = r0.L$0
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r10 = (com.upuphone.ar.translation.iflytek.IFlyAsrHelper) r10
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00a4
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00d0
        L_0x0049:
            java.lang.Object r10 = r0.L$0
            com.upuphone.ar.translation.iflytek.IFlyAsrHelper r10 = (com.upuphone.ar.translation.iflytek.IFlyAsrHelper) r10
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00c1
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r12)
            int r12 = r10.c
            java.lang.String r12 = com.upuphone.ar.translation.iflytek.ext.StringExtKt.a(r12)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = "reconnectToStopRequest reconnectMark["
            r2.append(r8)
            r2.append(r11)
            java.lang.String r9 = "], channelType["
            r2.append(r9)
            r2.append(r12)
            java.lang.String r12 = "]"
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            java.lang.String r2 = "IFlyAsrHelper"
            com.upuphone.ar.translation.ext.LogExt.j(r12, r2)
            if (r11 == r7) goto L_0x00b6
            if (r11 == r6) goto L_0x0099
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r8)
            r10.append(r11)
            java.lang.String r11 = "] error"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r10, r2)
            goto L_0x00d3
        L_0x0099:
            r0.L$0 = r10
            r0.label = r5
            java.lang.Object r11 = r10.y0(r7, r0)
            if (r11 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            int r11 = r10.c
            if (r11 != r7) goto L_0x00d3
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r10 = r10.A0(r7, r0)
            if (r10 != r1) goto L_0x00b3
            return r1
        L_0x00b3:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00b6:
            r0.L$0 = r10
            r0.label = r7
            java.lang.Object r11 = r10.A0(r7, r0)
            if (r11 != r1) goto L_0x00c1
            return r1
        L_0x00c1:
            int r11 = r10.c
            if (r11 != r7) goto L_0x00d3
            r0.L$0 = r3
            r0.label = r6
            java.lang.Object r10 = r10.y0(r7, r0)
            if (r10 != r1) goto L_0x00d0
            return r1
        L_0x00d0:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00d3:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.iflytek.IFlyAsrHelper.n0(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void o0(String str, TranslateMsgListener translateMsgListener) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(translateMsgListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b.put(str, translateMsgListener);
    }

    public final void p0() {
        LogExt.j("release 释放工具类所有资源，跟init成对出现", "IFlyAsrHelper");
        Job unused = BuildersKt__Builders_commonKt.d(this.p, (CoroutineContext) null, (CoroutineStart) null, new IFlyAsrHelper$release$1(this, (Continuation<? super IFlyAsrHelper$release$1>) null), 3, (Object) null);
    }

    public final void q0() {
        WebSocketState webSocketState = this.g;
        boolean z = false;
        boolean d2 = webSocketState != null ? webSocketState.d() : false;
        WebSocketState webSocketState2 = this.g;
        if (webSocketState2 != null) {
            z = webSocketState2.c();
        }
        LogExt.j("remoteSocketFailedToClose remoteOpened=" + d2 + ", remoteMsgStarted=" + z, "IFlyAsrHelper");
        if (d2) {
            z0(z ? 1 : 2);
        }
    }

    public final int r0(TransConfig transConfig, TransConfig transConfig2) {
        if (transConfig != null && transConfig2 != null) {
            return 1;
        }
        if (transConfig != null) {
            return 2;
        }
        return transConfig2 != null ? 3 : 0;
    }

    public final void s0(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        Job unused = BuildersKt__Builders_commonKt.d(this.o, (CoroutineContext) null, (CoroutineStart) null, new IFlyAsrHelper$sendProximalAudioData$1(this, bArr, (Continuation<? super IFlyAsrHelper$sendProximalAudioData$1>) null), 3, (Object) null);
    }

    public final void t0(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        Job unused = BuildersKt__Builders_commonKt.d(this.i, (CoroutineContext) null, (CoroutineStart) null, new IFlyAsrHelper$sendRemoteAudioData$1(this, bArr, (Continuation<? super IFlyAsrHelper$sendRemoteAudioData$1>) null), 3, (Object) null);
    }

    public final void u0(TransConfig transConfig) {
        LogExt.j("startProximalRequest TransConfig=" + transConfig, "IFlyAsrHelper");
        TranslationApp.INSTANCE.getNetworkTimeHelper$ar_translator_intlRelease().f(new IFlyAsrHelper$startProximalRequest$1(this, transConfig));
    }

    public final void v0(TransConfig transConfig) {
        LogExt.j("startRemoteRequest TransConfig=" + transConfig, "IFlyAsrHelper");
        TranslationApp.INSTANCE.getNetworkTimeHelper$ar_translator_intlRelease().f(new IFlyAsrHelper$startRemoteRequest$1(this, transConfig));
    }

    public final void w0(TransConfig transConfig, TransConfig transConfig2) {
        LogExt.j("startRequest remoteConfig=" + transConfig + ", proximalConfig=" + transConfig2, "IFlyAsrHelper");
        int r0 = r0(transConfig, transConfig2);
        this.c = r0;
        String a2 = StringExtKt.a(r0);
        LogExt.j("startRequest channelType=" + a2, "IFlyAsrHelper");
        Unit unit = null;
        this.g = null;
        this.m = null;
        this.g = new WebSocketState();
        WebSocketState webSocketState = new WebSocketState();
        this.m = webSocketState;
        WebSocketState webSocketState2 = this.g;
        LogExt.j("startRequest mRemoteWebSocketState=" + webSocketState2 + ", mProximalSocketState=" + webSocketState, "IFlyAsrHelper");
        this.q.set(false);
        int i2 = this.c;
        if (i2 != 1) {
            if (i2 == 2) {
                if (transConfig != null) {
                    v0(transConfig);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    LogExt.h("startRequest 请求开启远端通道必须传递远端翻译请求配置！", "IFlyAsrHelper");
                }
            } else if (i2 != 3) {
                LogExt.h("startRequest 请设置正确的请求配置！", "IFlyAsrHelper");
            } else {
                if (transConfig2 != null) {
                    u0(transConfig2);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    LogExt.h("startRequest 请求开启近端通道必须传递近端翻译请求配置！", "IFlyAsrHelper");
                }
            }
        } else if (transConfig == null || transConfig2 == null) {
            LogExt.h("startRequest 双通道模式下必须同时传递远端翻译请求配置和近端翻译请求配置！", "IFlyAsrHelper");
        } else {
            v0(transConfig);
            u0(transConfig2);
        }
    }

    public final void x0(int i2) {
        Job unused = BuildersKt__Builders_commonKt.d(this.p, (CoroutineContext) null, (CoroutineStart) null, new IFlyAsrHelper$stopProximalRequest$1(this, i2, (Continuation<? super IFlyAsrHelper$stopProximalRequest$1>) null), 3, (Object) null);
    }

    public final Object y0(int i2, Continuation continuation) {
        boolean z = this.n;
        LogExt.j("stopProximalRequest voiceEndArg=" + i2 + ", mProximalHasSend=" + z, "IFlyAsrHelper");
        Object g2 = BuildersKt.g(Dispatchers.b(), new IFlyAsrHelper$stopProximalRequestNotCoroutine$2(this, i2, (Continuation<? super IFlyAsrHelper$stopProximalRequestNotCoroutine$2>) null), continuation);
        return g2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g2 : Unit.INSTANCE;
    }

    public final void z0(int i2) {
        Job unused = BuildersKt__Builders_commonKt.d(this.p, (CoroutineContext) null, (CoroutineStart) null, new IFlyAsrHelper$stopRemoteRequest$1(this, i2, (Continuation<? super IFlyAsrHelper$stopRemoteRequest$1>) null), 3, (Object) null);
    }
}
