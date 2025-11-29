package com.upuphone.ai.ttsengine.engines.cloud;

import android.app.Application;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.Keep;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.nl.languageid.LanguageIdentification;
import com.google.mlkit.nl.languageid.LanguageIdentifier;
import com.upuphone.ai.ttsengine.base.AbsTtsAgent;
import com.upuphone.ai.ttsengine.base.bean.CacheKey;
import com.upuphone.ai.ttsengine.base.enums.TtsAgentType;
import com.upuphone.ai.ttsengine.base.helper.TextSplitter;
import com.upuphone.ai.ttsengine.base.player.PcmPlayer;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.base.utils.NetUtils;
import com.upuphone.ai.ttsengine.base.utils.StringUtilsKt;
import com.upuphone.ai.ttsengine.base.utils.TtsAudioUtils;
import com.upuphone.ai.ttsengine.engines.cache.CacheManager;
import com.upuphone.ai.ttsengine.engines.cloud.Status;
import com.upuphone.oggopus.OggOpus;
import com.upuphone.runasone.relay.api.IntentKey;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nCloudEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CloudEngine.kt\ncom/upuphone/ai/ttsengine/engines/cloud/CloudEngine\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 5 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,659:1\n48#2,4:660\n1#3:664\n120#4,10:665\n1313#5,2:675\n1855#6,2:677\n*S KotlinDebug\n*F\n+ 1 CloudEngine.kt\ncom/upuphone/ai/ttsengine/engines/cloud/CloudEngine\n*L\n68#1:660,4\n334#1:665,10\n615#1:675,2\n619#1:677,2\n*E\n"})
@Keep
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0002\u0004%\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0002Z[B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0014H@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001bH\u0002J\u0010\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001bH\u0002J\b\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\fH\u0002J\u0010\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\tH\u0016J\b\u0010@\u001a\u000209H\u0002J\b\u0010A\u001a\u000209H\u0016J\u0010\u0010B\u001a\u0002092\u0006\u0010C\u001a\u00020\u001dH\u0016J\b\u0010D\u001a\u000209H\u0016J\u0010\u0010E\u001a\u0002092\u0006\u0010:\u001a\u00020\fH\u0002J\b\u0010F\u001a\u000209H\u0002J\u0018\u0010G\u001a\u00020\u00142\b\b\u0002\u0010,\u001a\u00020\u0014H@¢\u0006\u0002\u0010-J\u0010\u0010H\u001a\u0002092\u0006\u0010I\u001a\u00020\u0014H\u0002J\u0016\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001bH@¢\u0006\u0002\u0010LJ\u0018\u0010M\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u001dH\u0016J\u0018\u0010P\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u001dH\u0016J\u001e\u0010P\u001a\u00020\u00142\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010S\u001a\u00020\u001dH\u0016J\b\u0010T\u001a\u00020\u0014H\u0016J\b\u0010U\u001a\u000209H\u0002J\u0010\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020\u001dH\u0002J\u0010\u0010X\u001a\u0002092\u0006\u0010:\u001a\u00020YH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/CloudEngine;", "Lcom/upuphone/ai/ttsengine/base/AbsTtsAgent;", "()V", "audioListener", "com/upuphone/ai/ttsengine/engines/cloud/CloudEngine$audioListener$1", "Lcom/upuphone/ai/ttsengine/engines/cloud/CloudEngine$audioListener$1;", "audioPlayer", "Lcom/upuphone/ai/ttsengine/base/player/PcmPlayer;", "cacheKey", "Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/upuphone/ai/ttsengine/engines/cloud/Status$AudioData;", "connectLock", "Lkotlinx/coroutines/sync/Mutex;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "disconnectJob", "Lkotlinx/coroutines/Job;", "isNovelMode", "", "languageIdentifier", "Lcom/google/mlkit/nl/languageid/LanguageIdentifier;", "oggOpus", "Lcom/upuphone/oggopus/OggOpus;", "pendingText", "", "", "playedSize", "", "requestSize", "sessionId", "singleDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "speakingText", "testFileName", "ttsPlayListener", "com/upuphone/ai/ttsengine/engines/cloud/CloudEngine$ttsPlayListener$1", "Lcom/upuphone/ai/ttsengine/engines/cloud/CloudEngine$ttsPlayListener$1;", "voiceByLan", "voiceGender", "webSocket", "Lcom/upuphone/ai/ttsengine/engines/cloud/TtsWebsocket;", "connect", "report", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decodeMp3ToPcm", "Lcom/upuphone/ai/ttsengine/engines/cloud/CloudEngine$PcmData;", "mediaDataSource", "Landroid/media/MediaDataSource;", "filterInvalid", "input", "formatText", "src", "getAgentType", "Lcom/upuphone/ai/ttsengine/base/enums/TtsAgentType;", "handleAudio", "", "data", "init", "context", "Landroid/app/Application;", "isSupport", "key", "launchChannel", "onPlayEnd", "onPlayError", "errorCode", "prepare", "processAudio", "releaseChannel", "request", "scheduleCloseWS", "delay", "selectLanguage", "text", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setParam", "paramInt1", "paramInt2", "startSpeak", "paramString", "streamType", "streamtype", "stopTTS", "synthesisEnd", "synthesisStart", "type", "synthesising", "", "Companion", "PcmData", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CloudEngine extends AbsTtsAgent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final Regex DATE_REGEX = new Regex("([12]\\d{3}[-/]\\d{2}[-/]\\d{2})");
    @NotNull
    private static final Regex DOT_NUM_REGEX = new Regex("(?<=\\D)\\.(?=\\d)");
    @NotNull
    private static final Regex EMOJIS_PATTERN = new Regex("[🌀-🗿😀-🙏🚀-🛿🤀-🧿☀-⛿✀-➿]+");
    @NotNull
    private static final Regex INVALID_CHAR_REGEX = new Regex("#+|\\*+|(^\\s*\\.)");
    @NotNull
    private static final Regex SSML_REGEX = new Regex("(</?[a-z]+>)|(<[a-z]+\\s[^<>]+>)");
    @NotNull
    private static final String TEXT_TYPE_PLAIN = "plain";
    @NotNull
    private static final String TEXT_TYPE_SSML = "ssml";
    /* access modifiers changed from: private */
    @NotNull
    public final CloudEngine$audioListener$1 audioListener = new CloudEngine$audioListener$1(this);
    /* access modifiers changed from: private */
    @Nullable
    public PcmPlayer audioPlayer;
    @Nullable
    private CacheKey cacheKey;
    /* access modifiers changed from: private */
    @Nullable
    public Channel<Status.AudioData> channel;
    /* access modifiers changed from: private */
    @NotNull
    public final Mutex connectLock = MutexKt.b(false, 1, (Object) null);
    @NotNull
    private final CoroutineScope coroutineScope = CoroutineScopeKt.a(SupervisorKt.b((Job) null, 1, (Object) null).plus(Dispatchers.b()).plus(new CloudEngine$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.a0, this)));
    @Nullable
    private Job disconnectJob;
    /* access modifiers changed from: private */
    public boolean isNovelMode;
    @Nullable
    private LanguageIdentifier languageIdentifier;
    @Nullable
    private OggOpus oggOpus;
    /* access modifiers changed from: private */
    @NotNull
    public List<String> pendingText = new ArrayList();
    /* access modifiers changed from: private */
    public int playedSize;
    /* access modifiers changed from: private */
    public int requestSize;
    @NotNull
    private String sessionId = "";
    @Nullable
    private ExecutorCoroutineDispatcher singleDispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public String speakingText = "";
    @Nullable
    private String testFileName;
    @NotNull
    private final CloudEngine$ttsPlayListener$1 ttsPlayListener = new CloudEngine$ttsPlayListener$1(this);
    private boolean voiceByLan;
    private int voiceGender = -1;
    /* access modifiers changed from: private */
    @Nullable
    public TtsWebsocket webSocket;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/CloudEngine$Companion;", "", "()V", "DATE_REGEX", "Lkotlin/text/Regex;", "DOT_NUM_REGEX", "EMOJIS_PATTERN", "INVALID_CHAR_REGEX", "SSML_REGEX", "TEXT_TYPE_PLAIN", "", "TEXT_TYPE_SSML", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/CloudEngine$PcmData;", "", "", "sample", "channel", "", "data", "<init>", "(II[B)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "I", "c", "b", "[B", "()[B", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class PcmData {

        /* renamed from: a  reason: collision with root package name */
        public final int f5549a;
        public final int b;
        public final byte[] c;

        public PcmData(int i, int i2, byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "data");
            this.f5549a = i;
            this.b = i2;
            this.c = bArr;
        }

        public final int a() {
            return this.b;
        }

        public final byte[] b() {
            return this.c;
        }

        public final int c() {
            return this.f5549a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) PcmData.class, (Object) obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ai.ttsengine.engines.cloud.CloudEngine.PcmData");
            PcmData pcmData = (PcmData) obj;
            return this.f5549a == pcmData.f5549a && this.b == pcmData.b && Arrays.equals(this.c, pcmData.c);
        }

        public int hashCode() {
            return (((this.f5549a * 31) + this.b) * 31) + Arrays.hashCode(this.c);
        }

        public String toString() {
            int i = this.f5549a;
            int i2 = this.b;
            String arrays = Arrays.toString(this.c);
            return "PcmData(sample=" + i + ", channel=" + i2 + ", data=" + arrays + ")";
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[Catch:{ all -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ae A[SYNTHETIC, Splitter:B:32:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object connect(boolean r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$connect$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$connect$1 r0 = (com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$connect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$connect$1 r0 = new com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$connect$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            boolean r7 = r0.Z$0
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r0 = r0.L$0
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine r0 = (com.upuphone.ai.ttsengine.engines.cloud.CloudEngine) r0
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r6
            r6 = r0
            goto L_0x005b
        L_0x0036:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.Job r8 = r6.disconnectJob
            if (r8 == 0) goto L_0x0048
            kotlinx.coroutines.Job.DefaultImpls.a(r8, r4, r3, r4)
        L_0x0048:
            r6.disconnectJob = r4
            kotlinx.coroutines.sync.Mutex r8 = r6.connectLock
            r0.L$0 = r6
            r0.L$1 = r8
            r0.Z$0 = r7
            r0.label = r3
            java.lang.Object r0 = r8.c(r4, r0)
            if (r0 != r1) goto L_0x005b
            return r1
        L_0x005b:
            com.upuphone.ai.ttsengine.engines.cloud.TtsWebsocket r0 = r6.webSocket     // Catch:{ all -> 0x009f }
            r1 = 0
            if (r0 != 0) goto L_0x00ae
            com.upuphone.ai.ttsengine.base.utils.AILOG r0 = r6.getAiLog()     // Catch:{ all -> 0x009f }
            java.lang.String r2 = "create new websocket"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x009f }
            r0.c(r2, r5)     // Catch:{ all -> 0x009f }
            com.upuphone.ai.ttsengine.engines.cloud.TtsWebsocket r0 = new com.upuphone.ai.ttsengine.engines.cloud.TtsWebsocket     // Catch:{ all -> 0x009f }
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$audioListener$1 r2 = r6.audioListener     // Catch:{ all -> 0x009f }
            r0.<init>(r2)     // Catch:{ all -> 0x009f }
            r6.webSocket = r0     // Catch:{ all -> 0x009f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x009f }
            java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x009f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x009f }
            java.lang.String r5 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)     // Catch:{ all -> 0x009f }
            boolean r0 = r0.connect(r2)     // Catch:{ all -> 0x009f }
            if (r0 != 0) goto L_0x00cb
            com.upuphone.ai.ttsengine.base.utils.AILOG r0 = r6.getAiLog()     // Catch:{ all -> 0x009f }
            java.lang.String r2 = "websocket connect failed"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x009f }
            r0.c(r2, r3)     // Catch:{ all -> 0x009f }
            if (r7 == 0) goto L_0x00a1
            r7 = 16
            r6.onPlayError(r7)     // Catch:{ all -> 0x009f }
            goto L_0x00a6
        L_0x009f:
            r6 = move-exception
            goto L_0x00d5
        L_0x00a1:
            r6.setAudioPlaying(r1)     // Catch:{ all -> 0x009f }
            r6.webSocket = r4     // Catch:{ all -> 0x009f }
        L_0x00a6:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)     // Catch:{ all -> 0x009f }
            r8.d(r4)
            return r6
        L_0x00ae:
            com.upuphone.ai.ttsengine.base.utils.AILOG r7 = r6.getAiLog()     // Catch:{ all -> 0x009f }
            com.upuphone.ai.ttsengine.engines.cloud.TtsWebsocket r6 = r6.webSocket     // Catch:{ all -> 0x009f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            r0.<init>()     // Catch:{ all -> 0x009f }
            java.lang.String r2 = "websocket reused: "
            r0.append(r2)     // Catch:{ all -> 0x009f }
            r0.append(r6)     // Catch:{ all -> 0x009f }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x009f }
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x009f }
            r7.c(r6, r0)     // Catch:{ all -> 0x009f }
        L_0x00cb:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009f }
            r8.d(r4)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        L_0x00d5:
            r8.d(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.engines.cloud.CloudEngine.connect(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final PcmData decodeMp3ToPcm(MediaDataSource mediaDataSource) {
        int i;
        long j;
        int i2;
        int i3;
        int dequeueInputBuffer;
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(mediaDataSource);
        int i4 = 0;
        mediaExtractor.selectTrack(0);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(0);
        Intrinsics.checkNotNullExpressionValue(trackFormat, "getTrackFormat(...)");
        String string = trackFormat.getString("mime");
        if (string != null) {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
            createDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
            createDecoderByType.start();
            Intrinsics.checkNotNullExpressionValue(createDecoderByType, "apply(...)");
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteBuffer[] inputBuffers = createDecoderByType.getInputBuffers();
            Intrinsics.checkNotNullExpressionValue(inputBuffers, "getInputBuffers(...)");
            ByteBuffer[] outputBuffers = createDecoderByType.getOutputBuffers();
            Intrinsics.checkNotNullExpressionValue(outputBuffers, "getOutputBuffers(...)");
            int integer = trackFormat.getInteger("sample-rate");
            int integer2 = trackFormat.getInteger("channel-count");
            getAiLog().c("mp3 sample: " + integer + ", mp3 channel: " + integer2, new Object[0]);
            boolean z = false;
            ByteBuffer[] byteBufferArr = outputBuffers;
            while (true) {
                if (z || (dequeueInputBuffer = createDecoderByType.dequeueInputBuffer(10000)) < 0) {
                    i = integer2;
                    j = 10000;
                } else {
                    int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i4);
                    if (readSampleData < 0) {
                        i = integer2;
                        j = 10000;
                        createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                        z = true;
                    } else {
                        i = integer2;
                        j = 10000;
                        createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                        mediaExtractor.advance();
                    }
                }
                int dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, j);
                if (dequeueOutputBuffer >= 0) {
                    ByteBuffer byteBuffer = byteBufferArr[dequeueOutputBuffer];
                    int i5 = bufferInfo.size;
                    if (i5 > 0) {
                        byte[] bArr = new byte[i5];
                        byteBuffer.get(bArr);
                        byteBuffer.clear();
                        byteArrayOutputStream.write(bArr);
                    }
                    i3 = 0;
                    createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((bufferInfo.flags & 4) != 0) {
                        createDecoderByType.stop();
                        createDecoderByType.release();
                        mediaExtractor.release();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                        return new PcmData(integer, i, byteArray);
                    }
                    i2 = i;
                } else {
                    i2 = i;
                    i3 = 0;
                    if (dequeueOutputBuffer == -3) {
                        ByteBuffer[] outputBuffers2 = createDecoderByType.getOutputBuffers();
                        Intrinsics.checkNotNullExpressionValue(outputBuffers2, "getOutputBuffers(...)");
                        byteBufferArr = outputBuffers2;
                    }
                }
                i4 = i3;
                integer2 = i2;
            }
        } else {
            throw new IllegalArgumentException("MIME type is null");
        }
    }

    private final String filterInvalid(String str) {
        String replace = EMOJIS_PATTERN.replace((CharSequence) DOT_NUM_REGEX.replace((CharSequence) INVALID_CHAR_REGEX.replace((CharSequence) str, ""), ". "), "");
        return replace.length() == 0 ? " " : replace;
    }

    private final String formatText(String str) {
        String filterInvalid = filterInvalid(str);
        if (!Intrinsics.areEqual((Object) getVoiceId(), (Object) "google") || StringUtilsKt.a(filterInvalid)) {
            return filterInvalid;
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (MatchResult value : Regex.findAll$default(DATE_REGEX, filterInvalid, 0, 2, (Object) null)) {
            linkedHashSet.add(value.getValue());
        }
        if (!(!linkedHashSet.isEmpty())) {
            return filterInvalid;
        }
        String str2 = filterInvalid;
        for (String str3 : linkedHashSet) {
            str2 = StringsKt.replace$default(str2, str3, "<say-as interpret-as=\"date\" format=\"yyyymmdd\" detail=\"1\">" + str3 + "</say-as>", false, 4, (Object) null);
        }
        return "<speak>" + str2 + "</speak>";
    }

    /* access modifiers changed from: private */
    public final void handleAudio(Status.AudioData audioData) {
        if (!StringsKt.startsWith$default(audioData.getRequestId(), this.sessionId, false, 2, (Object) null)) {
            getAiLog().c("session not equal", new Object[0]);
            return;
        }
        ExecutorCoroutineDispatcher executorCoroutineDispatcher = this.singleDispatcher;
        if (executorCoroutineDispatcher != null) {
            Intrinsics.checkNotNull(executorCoroutineDispatcher);
            if (JobKt.l(executorCoroutineDispatcher)) {
                CoroutineScope coroutineScope2 = this.coroutineScope;
                ExecutorCoroutineDispatcher executorCoroutineDispatcher2 = this.singleDispatcher;
                Intrinsics.checkNotNull(executorCoroutineDispatcher2);
                Job unused = BuildersKt__Builders_commonKt.d(coroutineScope2, executorCoroutineDispatcher2, (CoroutineStart) null, new CloudEngine$handleAudio$1(this, audioData, (Continuation<? super CloudEngine$handleAudio$1>) null), 2, (Object) null);
                return;
            }
        }
        AILOG aiLog = getAiLog();
        ExecutorCoroutineDispatcher executorCoroutineDispatcher3 = this.singleDispatcher;
        aiLog.c("single dispatcher closed: " + executorCoroutineDispatcher3, new Object[0]);
    }

    private final void launchChannel() {
        this.channel = ChannelKt.b(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.singleDispatcher = ThreadPoolDispatcherKt.b("audioChannel");
        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudEngine$launchChannel$1(this, (Continuation<? super CloudEngine$launchChannel$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009b, code lost:
        if (r2.z() == 16000) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011a, code lost:
        if (r1.z() == r14.c()) goto L_0x0140;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void processAudio(com.upuphone.ai.ttsengine.engines.cloud.Status.AudioData r14) {
        /*
            r13 = this;
            kotlinx.coroutines.channels.Channel<com.upuphone.ai.ttsengine.engines.cloud.Status$AudioData> r0 = r13.channel
            r1 = 0
            if (r0 == 0) goto L_0x0165
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.D()
            if (r0 == 0) goto L_0x0010
            goto L_0x0165
        L_0x0010:
            com.upuphone.ai.ttsengine.base.utils.AILOG r0 = r13.getAiLog()
            int r2 = r14.getSequence()
            byte[] r3 = r14.getAudioBytes()
            if (r3 == 0) goto L_0x0024
            int r3 = r3.length
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0025
        L_0x0024:
            r3 = 0
        L_0x0025:
            java.lang.String r4 = r14.getRequestId()
            java.lang.String r5 = r14.getEncoding()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "sequence: "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = ", source size: "
            r6.append(r2)
            r6.append(r3)
            java.lang.String r2 = ", requestId: "
            r6.append(r2)
            r6.append(r4)
            java.lang.String r2 = ", format: "
            r6.append(r2)
            r6.append(r5)
            java.lang.String r2 = r6.toString()
            java.lang.Object[] r3 = new java.lang.Object[r1]
            r0.c(r2, r3)
            byte[] r0 = r14.getAudioBytes()
            if (r0 != 0) goto L_0x006b
            int r14 = r14.getSequence()
            if (r14 >= 0) goto L_0x006a
            r13.synthesisEnd()
        L_0x006a:
            return
        L_0x006b:
            java.lang.String r2 = r14.getEncoding()
            java.lang.String r3 = "ogg_opus"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            java.lang.String r3 = "copyOf(...)"
            r4 = 1
            if (r2 == 0) goto L_0x00ec
            int r2 = r14.getSequence()
            int r2 = java.lang.Math.abs(r2)
            if (r2 != r4) goto L_0x00bf
            com.upuphone.ai.ttsengine.base.player.PcmPlayer r2 = r13.audioPlayer
            if (r2 == 0) goto L_0x009e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r2 = r2.h()
            if (r2 == 0) goto L_0x009e
            com.upuphone.ai.ttsengine.base.player.PcmPlayer r2 = r13.audioPlayer
            if (r2 == 0) goto L_0x009e
            int r2 = r2.z()
            r4 = 16000(0x3e80, float:2.2421E-41)
            if (r2 != r4) goto L_0x009e
            goto L_0x00bc
        L_0x009e:
            com.upuphone.ai.ttsengine.base.player.PcmPlayer r2 = new com.upuphone.ai.ttsengine.base.player.PcmPlayer
            android.app.Application r6 = r13.getApplication()
            boolean r10 = r13.getDisableBT()
            r11 = 14
            r12 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$ttsPlayListener$1 r4 = r13.ttsPlayListener
            r2.m(r4)
            r2.o()
            r13.audioPlayer = r2
        L_0x00bc:
            r13.synthesisStart(r1)
        L_0x00bf:
            com.upuphone.oggopus.OggOpus r1 = r13.oggOpus
            if (r1 == 0) goto L_0x00e1
            int r2 = r0.length
            long r4 = (long) r2
            byte[] r0 = r1.decode(r0, r4)
            if (r0 == 0) goto L_0x00e1
            com.upuphone.ai.ttsengine.base.player.PcmPlayer r4 = r13.audioPlayer
            if (r4 == 0) goto L_0x00de
            int r1 = r0.length
            byte[] r5 = java.util.Arrays.copyOf(r0, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            int r6 = r0.length
            r8 = 4
            r9 = 0
            r7 = 0
            com.upuphone.ai.ttsengine.base.player.PcmPlayer.w(r4, r5, r6, r7, r8, r9)
        L_0x00de:
            r13.synthesising(r0)
        L_0x00e1:
            int r14 = r14.getSequence()
            if (r14 >= 0) goto L_0x0164
            r13.synthesisEnd()
            goto L_0x0164
        L_0x00ec:
            java.lang.String r14 = r14.getEncoding()
            java.lang.String r1 = "mp3"
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r1)
            if (r14 == 0) goto L_0x0164
            com.upuphone.ai.ttsengine.engines.cloud.CacheDataSource r14 = new com.upuphone.ai.ttsengine.engines.cloud.CacheDataSource
            r14.<init>(r0)
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$PcmData r14 = r13.decodeMp3ToPcm(r14)
            com.upuphone.ai.ttsengine.base.player.PcmPlayer r1 = r13.audioPlayer
            if (r1 == 0) goto L_0x011d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r1 = r1.h()
            if (r1 == 0) goto L_0x011d
            com.upuphone.ai.ttsengine.base.player.PcmPlayer r1 = r13.audioPlayer
            if (r1 == 0) goto L_0x011d
            int r1 = r1.z()
            int r2 = r14.c()
            if (r1 != r2) goto L_0x011d
            goto L_0x0140
        L_0x011d:
            com.upuphone.ai.ttsengine.base.player.PcmPlayer r1 = new com.upuphone.ai.ttsengine.base.player.PcmPlayer
            android.app.Application r6 = r13.getApplication()
            int r8 = r14.c()
            int r9 = r14.a()
            boolean r10 = r13.getDisableBT()
            r11 = 2
            r12 = 0
            r7 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$ttsPlayListener$1 r2 = r13.ttsPlayListener
            r1.m(r2)
            r1.o()
            r13.audioPlayer = r1
        L_0x0140:
            r13.synthesisStart(r4)
            com.upuphone.ai.ttsengine.base.player.PcmPlayer r5 = r13.audioPlayer
            if (r5 == 0) goto L_0x015e
            byte[] r1 = r14.b()
            int r2 = r1.length
            byte[] r6 = java.util.Arrays.copyOf(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            byte[] r14 = r14.b()
            int r7 = r14.length
            r9 = 4
            r10 = 0
            r8 = 0
            com.upuphone.ai.ttsengine.base.player.PcmPlayer.w(r5, r6, r7, r8, r9, r10)
        L_0x015e:
            r13.synthesising(r0)
            r13.synthesisEnd()
        L_0x0164:
            return
        L_0x0165:
            com.upuphone.ai.ttsengine.base.utils.AILOG r13 = r13.getAiLog()
            java.lang.String r14 = "process audio but channel closed"
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r13.c(r14, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.engines.cloud.CloudEngine.processAudio(com.upuphone.ai.ttsengine.engines.cloud.Status$AudioData):void");
    }

    /* access modifiers changed from: private */
    public final void releaseChannel() {
        Channel<Status.AudioData> channel2 = this.channel;
        if (channel2 != null) {
            SendChannel.DefaultImpls.a(channel2, (Throwable) null, 1, (Object) null);
        }
        ExecutorCoroutineDispatcher executorCoroutineDispatcher = this.singleDispatcher;
        if (executorCoroutineDispatcher != null) {
            executorCoroutineDispatcher.close();
        }
        this.singleDispatcher = null;
        this.channel = null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object request(boolean r26, kotlin.coroutines.Continuation<? super java.lang.Boolean> r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r27
            boolean r2 = r1 instanceof com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$request$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$request$1 r2 = (com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$request$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$request$1 r2 = new com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$request$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x007a
            if (r4 == r6) goto L_0x0072
            if (r4 != r5) goto L_0x006a
            int r7 = r2.I$1
            int r0 = r2.I$0
            java.lang.Object r3 = r2.L$12
            com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData[] r3 = (com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData[]) r3
            java.lang.Object r4 = r2.L$11
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r8 = r2.L$10
            com.upuphone.ai.ttsengine.engines.cloud.TtsWebsocket r8 = (com.upuphone.ai.ttsengine.engines.cloud.TtsWebsocket) r8
            java.lang.Object r9 = r2.L$9
            com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData r9 = (com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData) r9
            java.lang.Object r10 = r2.L$8
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r2.L$7
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r2.L$6
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r2.L$5
            com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData r13 = (com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData) r13
            java.lang.Object r14 = r2.L$4
            com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData[] r14 = (com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData[]) r14
            java.lang.Object r15 = r2.L$3
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r5 = r2.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r2.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r2.L$0
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine r2 = (com.upuphone.ai.ttsengine.engines.cloud.CloudEngine) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x01dd
        L_0x006a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0072:
            java.lang.Object r0 = r2.L$0
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine r0 = (com.upuphone.ai.ttsengine.engines.cloud.CloudEngine) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0096
        L_0x007a:
            kotlin.ResultKt.throwOnFailure(r1)
            boolean r1 = r25.isAudioPlaying()
            if (r1 != 0) goto L_0x0088
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r0
        L_0x0088:
            r2.L$0 = r0
            r1 = 1
            r2.label = r1
            r1 = r26
            java.lang.Object r1 = r0.connect(r1, r2)
            if (r1 != r3) goto L_0x0096
            return r3
        L_0x0096:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x00a3
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r0
        L_0x00a3:
            java.util.List<java.lang.String> r1 = r0.pendingText
            java.lang.Object r1 = kotlin.collections.CollectionsKt.removeFirstOrNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x025b
            boolean r4 = kotlin.text.StringsKt.isBlank(r1)
            if (r4 == 0) goto L_0x00b5
            goto L_0x025b
        L_0x00b5:
            r0.speakingText = r1
            com.upuphone.ai.ttsengine.base.utils.AILOG r1 = r0.getAiLog()
            java.util.List<java.lang.String> r4 = r0.pendingText
            int r4 = r4.size()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "remain size: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r1.c(r4, r5)
            java.lang.String r1 = r0.speakingText
            java.lang.String r6 = r0.formatText(r1)
            com.upuphone.ai.ttsengine.base.utils.AILOG r1 = r0.getAiLog()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "speaking text: "
            r4.append(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r1.c(r4, r5)
            boolean r1 = com.upuphone.ai.ttsengine.base.utils.StringUtilsKt.a(r6)
            if (r1 == 0) goto L_0x0101
            java.lang.String r1 = "ssml"
        L_0x00ff:
            r5 = r1
            goto L_0x0104
        L_0x0101:
            java.lang.String r1 = "plain"
            goto L_0x00ff
        L_0x0104:
            int r1 = r0.requestSize
            r4 = 1
            int r1 = r1 + r4
            r0.requestSize = r1
            java.lang.String r4 = r0.sessionId
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r4)
            java.lang.String r4 = "_"
            r8.append(r4)
            r8.append(r1)
            java.lang.String r4 = r8.toString()
            com.upuphone.ai.ttsengine.base.utils.AILOG r1 = r0.getAiLog()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "request id: "
            r8.append(r9)
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r1.c(r8, r9)
            com.upuphone.ai.ttsengine.engines.cloud.TtsWebsocket r8 = r0.webSocket
            if (r8 == 0) goto L_0x0255
            r1 = 1
            com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData[] r9 = new com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData[r1]
            com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData r1 = new com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData
            r1.<init>()
            java.lang.String r10 = "tts"
            r1.setType(r10)
            java.lang.String r12 = r0.getVoiceId()
            boolean r10 = r0.isNovelMode
            if (r10 == 0) goto L_0x0156
            r10 = r7
            goto L_0x0158
        L_0x0156:
            r10 = 125(0x7d, float:1.75E-43)
        L_0x0158:
            boolean r11 = r0.voiceByLan
            java.lang.String r13 = "BV700_streaming"
            java.lang.String r14 = "google"
            java.lang.String r15 = "http"
            if (r11 == 0) goto L_0x0170
            java.lang.String r11 = r0.getLanguage()
            java.lang.String r7 = "ko"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0170
        L_0x016e:
            r11 = r15
            goto L_0x0186
        L_0x0170:
            java.lang.String r7 = r0.getVoiceId()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r13)
            if (r7 == 0) goto L_0x017e
            java.lang.String r7 = "stream"
            r11 = r7
            goto L_0x0186
        L_0x017e:
            java.lang.String r7 = r0.getVoiceId()
            kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r14)
            goto L_0x016e
        L_0x0186:
            java.lang.String r7 = r0.getVoiceId()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r13)
            if (r7 != 0) goto L_0x019e
            java.lang.String r7 = r0.getVoiceId()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r14)
            if (r7 == 0) goto L_0x019b
            goto L_0x019e
        L_0x019b:
            java.lang.String r7 = "mp3"
            goto L_0x01a0
        L_0x019e:
            java.lang.String r7 = "ogg_opus"
        L_0x01a0:
            java.lang.String r13 = r0.getVoiceId()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r13 == 0) goto L_0x01f3
            r2.L$0 = r0
            r2.L$1 = r6
            r2.L$2 = r5
            r2.L$3 = r4
            r2.L$4 = r9
            r2.L$5 = r1
            r2.L$6 = r12
            r2.L$7 = r11
            r2.L$8 = r7
            r2.L$9 = r1
            r2.L$10 = r8
            r2.L$11 = r4
            r2.L$12 = r9
            r2.I$0 = r10
            r13 = 0
            r2.I$1 = r13
            r13 = 2
            r2.label = r13
            java.lang.Object r2 = r0.selectLanguage(r6, r2)
            if (r2 != r3) goto L_0x01d3
            return r3
        L_0x01d3:
            r13 = r1
            r15 = r4
            r3 = r9
            r14 = r3
            r9 = r13
            r1 = r2
            r2 = r0
            r0 = r10
            r10 = r7
            r7 = 0
        L_0x01dd:
            java.lang.String r1 = (java.lang.String) r1
            r17 = r3
            r16 = r7
            r18 = r11
            r3 = r15
            r7 = r0
            r11 = r1
            r0 = r2
            r2 = r12
            r15 = r13
            r13 = r4
            r4 = r6
            r12 = r8
            r6 = r5
            r5 = r10
            r10 = r14
            r14 = r9
            goto L_0x020a
        L_0x01f3:
            java.lang.String r2 = r0.getLanguage()
            r14 = r1
            r15 = r14
            r3 = r4
            r13 = r3
            r4 = r6
            r17 = r9
            r18 = r11
            r16 = 0
            r11 = r2
            r6 = r5
            r5 = r7
            r7 = r10
            r2 = r12
            r12 = r8
            r10 = r17
        L_0x020a:
            int r1 = r0.voiceGender
            r8 = 0
            if (r1 == 0) goto L_0x021a
            r9 = 1
            if (r1 == r9) goto L_0x0215
            r19 = r8
            goto L_0x021d
        L_0x0215:
            java.lang.String r1 = "female"
        L_0x0217:
            r19 = r1
            goto L_0x021d
        L_0x021a:
            java.lang.String r1 = "male"
            goto L_0x0217
        L_0x021d:
            boolean r0 = r0.voiceByLan
            if (r0 == 0) goto L_0x0227
            r0 = 2
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            goto L_0x0228
        L_0x0227:
            r0 = r8
        L_0x0228:
            com.upuphone.ai.ttsengine.engines.cloud.Request r9 = new com.upuphone.ai.ttsengine.engines.cloud.Request
            r1 = 5
            java.lang.Integer r20 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r8 = 2
            r1 = r9
            r21 = r9
            r9 = r20
            r22 = r10
            r10 = r18
            r23 = r12
            r12 = r19
            r24 = r13
            r13 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r0 = r21
            r14.setPayload(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r17[r16] = r15
            r14 = r22
            r8 = r23
            r4 = r24
            r8.sendMsg(r4, r14)
        L_0x0255:
            r0 = 1
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r0
        L_0x025b:
            com.upuphone.ai.ttsengine.base.utils.AILOG r0 = r0.getAiLog()
            java.lang.String r1 = "null text"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.c(r1, r3)
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.engines.cloud.CloudEngine.request(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object request$default(CloudEngine cloudEngine, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return cloudEngine.request(z, continuation);
    }

    /* access modifiers changed from: private */
    public final void scheduleCloseWS(boolean z) {
        Job job = this.disconnectJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.disconnectJob = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudEngine$scheduleCloseWS$1(this, z, (Continuation<? super CloudEngine$scheduleCloseWS$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object selectLanguage(String str, Continuation<? super String> continuation) {
        Task<String> identifyLanguage;
        Task<String> addOnSuccessListener;
        getAiLog().c("begin detect language", new Object[0]);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        String replace = StringUtilsKt.a(str) ? SSML_REGEX.replace((CharSequence) str, "") : StringsKt.replace$default(str, "Kuala Lumpur", "", false, 4, (Object) null);
        LanguageIdentifier languageIdentifier2 = this.languageIdentifier;
        if (((languageIdentifier2 == null || (identifyLanguage = languageIdentifier2.identifyLanguage(replace)) == null || (addOnSuccessListener = identifyLanguage.addOnSuccessListener(new CloudEngine$sam$com_google_android_gms_tasks_OnSuccessListener$0(new CloudEngine$selectLanguage$2$1(this, safeContinuation)))) == null) ? null : addOnSuccessListener.addOnFailureListener(new CloudEngine$selectLanguage$2$2(this, safeContinuation))) == null) {
            getAiLog().c("language identifier null", new Object[0]);
            safeContinuation.resumeWith(Result.m20constructorimpl("en"));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final void synthesisEnd() {
        this.playedSize++;
        getAiLog().c("synthesis end playedSize: " + this.playedSize + ", requestSize: " + this.requestSize + ", pending size: " + this.pendingText.size(), new Object[0]);
        if (!this.isNovelMode || this.requestSize == this.playedSize) {
            if (this.pendingText.isEmpty()) {
                PcmPlayer pcmPlayer = this.audioPlayer;
                if (pcmPlayer != null) {
                    pcmPlayer.x();
                }
            } else {
                Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, Dispatchers.b(), (CoroutineStart) null, new CloudEngine$synthesisEnd$1(this, (Continuation<? super CloudEngine$synthesisEnd$1>) null), 2, (Object) null);
            }
        }
        if (this.isNovelMode) {
            return;
        }
        if (isTestTool()) {
            TtsAudioUtils.a(this.testFileName, true, false, 16000);
            return;
        }
        CacheKey cacheKey2 = this.cacheKey;
        if (cacheKey2 != null) {
            CacheManager.f5534a.c(cacheKey2);
        }
    }

    private final void synthesisStart(int i) {
        File file = null;
        if (!this.isNovelMode) {
            if (isTestTool()) {
                Application application = getApplication();
                if (application != null) {
                    file = application.getExternalFilesDir((String) null);
                }
                String voiceId = getVoiceId();
                String str = this.speakingText;
                this.testFileName = file + "/autoVoice/" + voiceId + "/" + str + ".wav";
                AILOG aiLog = getAiLog();
                CacheKey cacheKey2 = this.cacheKey;
                StringBuilder sb = new StringBuilder();
                sb.append("save file path: ");
                sb.append(cacheKey2);
                aiLog.c(sb.toString(), new Object[0]);
                TtsAudioUtils.c(this.testFileName, 1, true);
                return;
            }
            CacheKey cacheKey3 = new CacheKey(getVoiceId(), getLanguage(), this.speakingText);
            this.cacheKey = cacheKey3;
            CacheManager cacheManager = CacheManager.f5534a;
            Intrinsics.checkNotNull(cacheKey3);
            cacheManager.b(cacheKey3, i);
        } else if (!this.pendingText.isEmpty()) {
            AILOG aiLog2 = getAiLog();
            int size = this.pendingText.size();
            aiLog2.c("begin play next pending size: " + size, new Object[0]);
            Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, Dispatchers.b(), (CoroutineStart) null, new CloudEngine$synthesisStart$1(this, (Continuation<? super CloudEngine$synthesisStart$1>) null), 2, (Object) null);
        }
    }

    private final void synthesising(byte[] bArr) {
        if (this.isNovelMode) {
            return;
        }
        if (isTestTool()) {
            String str = this.testFileName;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            TtsAudioUtils.e(str, copyOf, bArr.length, true);
            return;
        }
        CacheKey cacheKey2 = this.cacheKey;
        if (cacheKey2 != null) {
            CacheManager cacheManager = CacheManager.f5534a;
            byte[] copyOf2 = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
            cacheManager.a(cacheKey2, copyOf2, bArr.length);
        }
    }

    @NotNull
    public TtsAgentType getAgentType() {
        return TtsAgentType.CLOUD;
    }

    public /* bridge */ /* synthetic */ int getPriority() {
        return super.getPriority();
    }

    public boolean init(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        super.init(application);
        OggOpus.Builder builder = new OggOpus.Builder();
        builder.c(0);
        builder.d(16000);
        builder.b(1);
        OggOpus a2 = builder.a();
        a2.init();
        this.oggOpus = a2;
        try {
            Result.Companion companion = Result.Companion;
            this.languageIdentifier = LanguageIdentification.getClient();
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        return true;
    }

    public boolean isSupport(@NotNull CacheKey cacheKey2) {
        Intrinsics.checkNotNullParameter(cacheKey2, IntentKey.ACTIVITY.ACTION_KEY);
        NetUtils netUtils = NetUtils.f5527a;
        Application application = getApplication();
        Intrinsics.checkNotNull(application);
        return netUtils.a(application);
    }

    public void onPlayEnd() {
        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudEngine$onPlayEnd$1(this, (Continuation<? super CloudEngine$onPlayEnd$1>) null), 3, (Object) null);
    }

    public void onPlayError(int i) {
        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudEngine$onPlayError$1(this, (Continuation<? super CloudEngine$onPlayError$1>) null), 3, (Object) null);
        CacheKey cacheKey2 = this.cacheKey;
        if (cacheKey2 != null) {
            CacheManager.f5534a.g(cacheKey2);
            this.cacheKey = null;
        }
        super.onPlayError(i);
    }

    public void prepare() {
        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudEngine$prepare$1(this, (Continuation<? super CloudEngine$prepare$1>) null), 3, (Object) null);
    }

    public /* bridge */ /* synthetic */ void reload() {
        super.reload();
    }

    public boolean setParam(int i, int i2) {
        switch (i) {
            case 1234567897:
                this.voiceGender = i2;
                break;
            case 1234567898:
                this.voiceByLan = i2 == 1;
                break;
            default:
                super.setParam(i, i2);
                break;
        }
        return true;
    }

    public boolean startSpeak(@NotNull List<String> list, int i) {
        Intrinsics.checkNotNullParameter(list, "paramString");
        if (isAudioPlaying()) {
            stopTTS();
        }
        this.playedSize = 0;
        this.requestSize = 0;
        setAudioPlaying(true);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.sessionId = uuid;
        launchChannel();
        if (i != 3) {
            return super.startSpeak(list, i);
        }
        this.isNovelMode = true;
        this.pendingText = list;
        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudEngine$startSpeak$1(this, (Continuation<? super CloudEngine$startSpeak$1>) null), 3, (Object) null);
        return true;
    }

    public boolean stopTTS() {
        getAiLog().c("stop", new Object[0]);
        CacheKey cacheKey2 = this.cacheKey;
        if (cacheKey2 != null) {
            CacheManager.f5534a.g(cacheKey2);
            this.cacheKey = null;
        }
        this.requestSize = 0;
        this.playedSize = 0;
        this.speakingText = "";
        this.pendingText.clear();
        this.pendingText = new ArrayList();
        releaseChannel();
        if (!isAudioPlaying()) {
            return true;
        }
        setAudioPlaying(false);
        onPlayInterrupted();
        PcmPlayer pcmPlayer = this.audioPlayer;
        if (pcmPlayer != null) {
            pcmPlayer.p();
        }
        PcmPlayer pcmPlayer2 = this.audioPlayer;
        if (pcmPlayer2 != null) {
            pcmPlayer2.j();
        }
        this.audioPlayer = null;
        getAiLog().c("stop release finished", new Object[0]);
        return true;
    }

    public boolean startSpeak(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "paramString");
        this.pendingText = new ArrayList();
        if (StringUtilsKt.a(str)) {
            this.pendingText.add(str);
        } else {
            this.pendingText.addAll(TextSplitter.f5506a.c(str, CmdCode.CODE_WAKEUP_RECORDING));
        }
        this.isNovelMode = this.pendingText.size() > 1;
        return ((Boolean) BuildersKt__BuildersKt.b((CoroutineContext) null, new CloudEngine$startSpeak$2(this, (Continuation<? super CloudEngine$startSpeak$2>) null), 1, (Object) null)).booleanValue();
    }
}
