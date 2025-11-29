package com.upuphone.ar.transcribe.audio;

import android.content.Context;
import com.honey.account.u4.a;
import com.upuphone.ar.transcribe.asr.XJAsrManager;
import com.upuphone.ar.transcribe.audio.debug.AudioDebugHelper;
import com.upuphone.ar.transcribe.audio.thread.ThreadPollHelper;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.helper.IOpusDecoder;
import com.upuphone.ar.transcribe.phone.helper.OpusCodecUtils;
import com.upuphone.ar.transcribe.phone.helper.OpusDecoder;
import com.xjsd.ai.annotation.AudioConfigFile;
import com.xjsd.ai.voice.VoiceAdapter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\b\u0003\n\u0002\b\u0005*\u0002WZ\u0018\u0000 .2\u00020\u0001:\u0001]B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0003J\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0003J\u0001\u0010\u001b\u001a\u00020\u000626\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00060\u001126\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00060\u00112\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\bJ\u000f\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020!H\u0002¢\u0006\u0004\b$\u0010#J\u001f\u0010&\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001dH\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001dH\u0002¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0003J)\u0010,\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010\u0003J\u000f\u0010/\u001a\u00020\u000bH\u0002¢\u0006\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\"\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u000205048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\"\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020:098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\"\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020>098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010<RH\u0010C\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BRH\u0010E\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010BR*\u0010G\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010BR\u0016\u0010J\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010IR\"\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010<R\u0016\u0010Q\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010PR\u0016\u0010S\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010PR\u0016\u0010U\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010PR\u0016\u0010V\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u00102R\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010XR\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010[¨\u0006^"}, d2 = {"Lcom/upuphone/ar/transcribe/audio/AudioAiManager;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "v", "(Landroid/content/Context;)V", "", "bytes", "", "channel", "m", "([BI)V", "B", "A", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "proximalBytes", "muteProximalBytes", "onProximalData", "remoteBytes", "muteRemoteBytes", "onRemoteData", "onState", "l", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "", "x", "()Z", "q", "", "w", "()Ljava/lang/String;", "z", "isMute", "p", "([BZ)V", "o", "s", "t", "feedSize", "u", "([BII)V", "r", "y", "()I", "a", "I", "mAudioAiInitState", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/xjsd/ai/voice/VoiceAdapter;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "voiceAdapterMap", "", "Lcom/upuphone/ar/transcribe/phone/helper/IOpusDecoder;", "c", "Ljava/util/Map;", "opusMapper", "Ljava/util/concurrent/ExecutorService;", "d", "feedExecutorsMap", "e", "Lkotlin/jvm/functions/Function2;", "mOnNoiseReductionProximalData", "f", "mOnNoiseReductionRemoteData", "g", "mOnNoiseReductionState", "h", "Z", "aiAudioRelease", "i", "audioRelease", "j", "excessFeedMap", "k", "[B", "mRemoteArray", "mMuteRemoteArray", "mProximalArray", "n", "mMuteProximalArray", "transType", "com/upuphone/ar/transcribe/audio/AudioAiManager$voiceListenerAdapter$1", "Lcom/upuphone/ar/transcribe/audio/AudioAiManager$voiceListenerAdapter$1;", "voiceListenerAdapter", "com/upuphone/ar/transcribe/audio/AudioAiManager$voiceListenerAdapter2$1", "Lcom/upuphone/ar/transcribe/audio/AudioAiManager$voiceListenerAdapter2$1;", "voiceListenerAdapter2", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAudioAiManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioAiManager.kt\ncom/upuphone/ar/transcribe/audio/AudioAiManager\n+ 2 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,490:1\n32#2,2:491\n1855#3,2:493\n1864#3,3:495\n1855#3,2:498\n1855#3,2:500\n*S KotlinDebug\n*F\n+ 1 AudioAiManager.kt\ncom/upuphone/ar/transcribe/audio/AudioAiManager\n*L\n178#1:491,2\n228#1:493,2\n389#1:495,3\n414#1:498,2\n419#1:500,2\n*E\n"})
public final class AudioAiManager {
    public static final Companion r = new Companion((DefaultConstructorMarker) null);
    public static volatile AudioAiManager s;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f6019a;
    public ConcurrentHashMap b;
    public Map c;
    public Map d;
    public Function2 e;
    public Function2 f;
    public Function2 g;
    public boolean h;
    public boolean i;
    public Map j;
    public byte[] k;
    public byte[] l;
    public byte[] m;
    public byte[] n;
    public int o;
    public AudioAiManager$voiceListenerAdapter$1 p;
    public AudioAiManager$voiceListenerAdapter2$1 q;

    @SourceDebugExtension({"SMAP\nAudioAiManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioAiManager.kt\ncom/upuphone/ar/transcribe/audio/AudioAiManager$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,490:1\n1#2:491\n*E\n"})
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u0003J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/transcribe/audio/AudioAiManager$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/audio/AudioAiManager;", "a", "()Lcom/upuphone/ar/transcribe/audio/AudioAiManager;", "", "c", "", "b", "()Z", "", "INTL_MAX_RECORD_SIZE", "I", "MONO_AUDIO_AI_BUFFER_SIZE", "REDUCTION_NOISE_AUDIO_SIZE", "STEREO_AUDIO_AI_BUFFER_SIZE", "", "TAG", "Ljava/lang/String;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AudioAiManager a() {
            AudioAiManager c = AudioAiManager.s;
            if (c == null) {
                synchronized (this) {
                    LogExt.g("AudioAiManager is create....", "AudioAiManager");
                    c = AudioAiManager.s;
                    if (c == null) {
                        c = new AudioAiManager((DefaultConstructorMarker) null);
                        AudioAiManager.s = c;
                    }
                }
            }
            return c;
        }

        public final boolean b() {
            return AudioAiManager.s == null;
        }

        public final void c() {
            AudioAiManager.s = null;
        }

        public Companion() {
        }
    }

    public /* synthetic */ AudioAiManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final void n(AudioAiManager audioAiManager, byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(audioAiManager, "this$0");
        Intrinsics.checkNotNullParameter(bArr, "$bytes");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        audioAiManager.u(copyOf, i2, i3);
    }

    public final void A() {
        if (!x()) {
            LogExt.g("重置音频降噪引擎数据异常", "AudioAiManager");
            return;
        }
        for (Map.Entry value : this.b.entrySet()) {
            ((VoiceAdapter) value.getValue()).Reset();
        }
    }

    public final void B() {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new AudioAiManager$stop$1(this, (Continuation<? super AudioAiManager$stop$1>) null), 3, (Object) null);
    }

    public final void l(Function2 function2, Function2 function22, Function2 function23) {
        Intrinsics.checkNotNullParameter(function2, "onProximalData");
        Intrinsics.checkNotNullParameter(function22, "onRemoteData");
        Intrinsics.checkNotNullParameter(function23, "onState");
        this.e = function2;
        this.f = function22;
        this.g = function23;
    }

    public final void m(byte[] bArr, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        if (x()) {
            ExecutorService executorService = (ExecutorService) this.d.get(Integer.valueOf(i2));
            if (executorService == null || executorService.isShutdown()) {
                executorService = ThreadPollHelper.f6025a.a();
                this.d.put(Integer.valueOf(i2), executorService);
            }
            executorService.execute(new a(this, bArr, TranscribeConstants.g() ? 512 : 1024, i2));
        }
    }

    public final void o(byte[] bArr, boolean z) {
        byte[] bArr2;
        byte[] bArr3 = this.m;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        this.m = ArraysKt.plus(bArr3, copyOf);
        if (z) {
            byte[] e2 = XJAsrManager.e.a().e();
            bArr2 = Arrays.copyOf(e2, e2.length);
            Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
        } else {
            bArr2 = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
        }
        this.n = ArraysKt.plus(this.n, bArr2);
        while (this.m.length >= y()) {
            byte[] sliceArray = ArraysKt.sliceArray(this.m, RangesKt.until(0, y()));
            byte[] sliceArray2 = ArraysKt.sliceArray(this.n, RangesKt.until(0, y()));
            Function2 function2 = this.e;
            if (function2 != null) {
                function2.invoke(sliceArray, sliceArray2);
            }
            this.m = ArraysKt.sliceArray(this.m, RangesKt.until(y(), this.m.length));
            this.n = ArraysKt.sliceArray(this.n, RangesKt.until(y(), this.n.length));
        }
    }

    public final void p(byte[] bArr, boolean z) {
        byte[] bArr2;
        byte[] bArr3 = this.k;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        this.k = ArraysKt.plus(bArr3, copyOf);
        if (z) {
            byte[] e2 = XJAsrManager.e.a().e();
            bArr2 = Arrays.copyOf(e2, e2.length);
            Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
        } else {
            bArr2 = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
        }
        this.l = ArraysKt.plus(this.l, bArr2);
        while (this.k.length >= y()) {
            byte[] sliceArray = ArraysKt.sliceArray(this.k, RangesKt.until(0, y()));
            byte[] sliceArray2 = ArraysKt.sliceArray(this.l, RangesKt.until(0, y()));
            Function2 function2 = this.f;
            if (function2 != null) {
                function2.invoke(sliceArray, sliceArray2);
            }
            this.k = ArraysKt.sliceArray(this.k, RangesKt.until(y(), this.k.length));
            this.l = ArraysKt.sliceArray(this.l, RangesKt.until(y(), this.l.length));
        }
    }

    public final void q(Context context) {
        try {
            this.b.put(0, new VoiceAdapter());
            this.b.put(1, new VoiceAdapter());
            Collection<VoiceAdapter> values = this.b.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            for (VoiceAdapter init : values) {
                init.init(context, TranscribeConstants.f6027a.m() ? w() : z());
            }
            this.f6019a = 0;
            int i2 = this.f6019a;
            VoiceAdapter voiceAdapter = (VoiceAdapter) this.b.get(0);
            String Version = voiceAdapter != null ? voiceAdapter.Version() : null;
            LogExt.g("handleAudioInit 音频降噪引擎初始化状态(0:成功, -1:失败):" + i2 + "; 版本: " + Version, "AudioAiManager");
            this.k = new byte[0];
            this.l = new byte[0];
            this.m = new byte[0];
            this.n = new byte[0];
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.g("初始化音频降噪引擎异常:: " + stackTraceToString, "AudioAiManager");
        }
    }

    public final void r() {
        if (!x()) {
            boolean z = this.h;
            LogExt.g("释放音频降噪引擎 " + z, "AudioAiManager");
            return;
        }
        this.e = null;
        this.f = null;
        this.g = null;
        this.b.clear();
        this.f6019a = -1;
        LogExt.g("释放音频降噪引擎", "AudioAiManager");
        this.h = true;
    }

    public final void s() {
        int i2 = 0;
        this.i = false;
        Collection values = this.b.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (Object next : values) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            VoiceAdapter voiceAdapter = (VoiceAdapter) next;
            if (i2 == 0) {
                voiceAdapter.registerListener(this.p);
            } else {
                voiceAdapter.registerListener(this.q);
            }
            voiceAdapter.Start();
            i2 = i3;
        }
    }

    public final void t() {
        if (!x()) {
            boolean z = this.i;
            LogExt.g("关闭音频降噪引擎不成功 " + z, "AudioAiManager");
            return;
        }
        Collection<VoiceAdapter> values = this.b.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (VoiceAdapter voiceAdapter : values) {
            voiceAdapter.Stop();
            voiceAdapter.unregisterListener();
            voiceAdapter.Destory();
        }
        for (IOpusDecoder destroy : this.c.values()) {
            destroy.destroy();
        }
        this.c.clear();
        this.i = true;
        LogExt.g("关闭音频降噪引擎", "AudioAiManager");
    }

    public final void u(byte[] bArr, int i2, int i3) {
        if (x()) {
            AudioDebugHelper.f(bArr, i3);
            if (this.c.get(Integer.valueOf(i3)) == null) {
                this.c.put(Integer.valueOf(i3), i3 == 0 ? new OpusCodecUtils() : new OpusDecoder());
            }
            Object obj = this.c.get(Integer.valueOf(i3));
            Intrinsics.checkNotNull(obj);
            byte[] a2 = ((IOpusDecoder) obj).a(bArr);
            Integer valueOf = Integer.valueOf(i3);
            Map map = this.j;
            Object obj2 = map.get(Integer.valueOf(i3));
            Intrinsics.checkNotNull(obj2);
            byte[] copyOf = Arrays.copyOf(a2, a2.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            map.put(valueOf, ArraysKt.plus((byte[]) obj2, copyOf));
            Object obj3 = this.j.get(Integer.valueOf(i3));
            Intrinsics.checkNotNull(obj3);
            if (!(((byte[]) obj3).length == 0)) {
                while (true) {
                    Object obj4 = this.j.get(Integer.valueOf(i3));
                    Intrinsics.checkNotNull(obj4);
                    if (((byte[]) obj4).length < i2) {
                        break;
                    }
                    Object obj5 = this.j.get(Integer.valueOf(i3));
                    Intrinsics.checkNotNull(obj5);
                    byte[] sliceArray = ArraysKt.sliceArray((byte[]) obj5, RangesKt.until(0, i2));
                    LogExt.c("发送数据给算法: " + i3, "AudioAiManager", "handleFeedAudioData", 0, false, 12, (Object) null);
                    VoiceAdapter voiceAdapter = (VoiceAdapter) this.b.get(Integer.valueOf(i3));
                    if (voiceAdapter != null) {
                        voiceAdapter.Feed(sliceArray);
                    }
                    Integer valueOf2 = Integer.valueOf(i3);
                    Map map2 = this.j;
                    Object obj6 = map2.get(Integer.valueOf(i3));
                    Intrinsics.checkNotNull(obj6);
                    Object obj7 = this.j.get(Integer.valueOf(i3));
                    Intrinsics.checkNotNull(obj7);
                    map2.put(valueOf2, ArraysKt.sliceArray((byte[]) obj6, RangesKt.until(i2, ((byte[]) obj7).length)));
                }
            }
            if (i3 == 0) {
                p(a2, false);
            } else {
                o(a2, false);
            }
        }
    }

    public final void v(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new AudioAiManager$init$1(this, context, (Continuation<? super AudioAiManager$init$1>) null), 3, (Object) null);
    }

    public final String w() {
        return TranscribeConstants.o() ? AudioConfigFile.GLOABLE_BFVAD_TRANS_STAR_EN : TranscribeConstants.g() ? AudioConfigFile.GLOABLE_VADONLY_AIR_EN : TranscribeConstants.l() ? AudioConfigFile.GLOABLE_GEVNNBF_TRANS_CONCEPT : AudioConfigFile.GLOABLE_BFVAD_TRANS_STAR_EN;
    }

    public final boolean x() {
        if (this.f6019a == 0) {
            return true;
        }
        LogExt.g("音频降噪引擎未初始化成功", "AudioAiManager");
        return false;
    }

    public final int y() {
        return 3200;
    }

    public final String z() {
        return TranscribeConstants.o() ? AudioConfigFile.GLOABLE_BFVAD_TRANS_STAR : TranscribeConstants.g() ? AudioConfigFile.GLOABLE_VADONLY_AIR : TranscribeConstants.l() ? AudioConfigFile.GLOABLE_GEVNNBF_TRANS_CONCEPT : AudioConfigFile.GLOABLE_BFVAD_TRANS_STAR;
    }

    public AudioAiManager() {
        this.f6019a = -1;
        this.b = new ConcurrentHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.h = true;
        this.i = true;
        this.j = MapsKt.mutableMapOf(TuplesKt.to(0, new byte[0]), TuplesKt.to(1, new byte[0]));
        this.k = new byte[0];
        this.l = new byte[0];
        this.m = new byte[0];
        this.n = new byte[0];
        this.o = 1;
        this.p = new AudioAiManager$voiceListenerAdapter$1(this);
        this.q = new AudioAiManager$voiceListenerAdapter2$1(this);
    }
}
