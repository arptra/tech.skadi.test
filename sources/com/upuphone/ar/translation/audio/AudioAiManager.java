package com.upuphone.ar.translation.audio;

import android.content.Context;
import android.os.SystemClock;
import com.upuphone.ar.translation.audio.debug.AudioDebugHelper;
import com.upuphone.ar.translation.audio.thread.ThreadPollHelper;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.ByteArrayExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.helper.TranslationAsrHelper;
import com.upuphone.ar.translation.phone.helper.TranslatorOpusCodec;
import com.upuphone.ar.translation.utils.BytesUtils;
import com.xjmz.ai.voice.VoiceManager;
import com.xjmz.ai.vprint.Output;
import com.xjsd.ai.annotation.AudioConfigFile;
import com.xjsd.ai.voice.VoiceAdapter;
import io.flutter.plugin.platform.PlatformPlugin;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\b\u0006*\u0001o\u0018\u0000 72\u00020\u0001:\u0001sB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0003J\r\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0003JÑ\u0001\u0010!\u001a\u00020\u000628\b\u0002\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00060\u001428\b\u0002\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00060\u00142\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00060\u001d28\b\u0002\u0010 \u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00060\u0014¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0006¢\u0006\u0004\b%\u0010\u0003J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010\bJ\u000f\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020'H\u0002¢\u0006\u0004\b*\u0010)J)\u0010.\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\t2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u001eH\u0002¢\u0006\u0004\b.\u0010/J\u001f\u00101\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u00100\u001a\u00020\u000bH\u0002¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u00100\u001a\u00020\u000bH\u0002¢\u0006\u0004\b3\u00102J\u000f\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\u0003J\u000f\u00105\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u0010\u0003J1\u00107\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u00106\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b7\u00108J'\u00109\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u00106\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b9\u0010:J!\u0010;\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u00106\u001a\u00020\u001eH\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b=\u0010>J'\u0010A\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\bA\u0010BJ\u0013\u0010C\u001a\u00020\u001e*\u00020\tH\u0002¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010\u0003J\u000f\u0010F\u001a\u00020\u001eH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010I\u001a\u00020HH\u0002¢\u0006\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PRH\u0010T\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010SRH\u0010V\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010SRH\u0010X\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010SR$\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010cR\u0016\u0010e\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010cR\u0016\u0010f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010cR\u0016\u0010g\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010cR\u0016\u0010h\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010cR\u0016\u0010i\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010cR\u0016\u0010j\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010cR\u0016\u0010k\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010cR\u0016\u0010l\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u0010LR\u0016\u0010m\u001a\u00020\\8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010^R\u0014\u0010n\u001a\u00020H8\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010aR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bp\u0010q¨\u0006t"}, d2 = {"Lcom/upuphone/ar/translation/audio/AudioAiManager;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "x", "(Landroid/content/Context;)V", "", "bytes", "", "isMono", "isRoleSeparate", "", "roleVprintArray", "k", "([BZZ[F)V", "F", "C", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "proximalBytes", "muteProximalBytes", "onProximalData", "remoteBytes", "muteRemoteBytes", "onRemoteData", "Lkotlin/Function1;", "", "onState", "onRoleSeparateData", "i", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "z", "()Z", "D", "o", "", "y", "()Ljava/lang/String;", "B", "data", "iSta", "channelIndex", "l", "([BII)V", "isMute", "n", "([BZ)V", "m", "q", "r", "feedSize", "u", "([BIZ[F)V", "w", "([BI[F)V", "s", "([BI)V", "H", "([B)[B", "leftBytes", "rightBytes", "E", "([B[B[F)V", "G", "([B)I", "p", "A", "()I", "Lkotlinx/coroutines/CoroutineScope;", "j", "()Lkotlinx/coroutines/CoroutineScope;", "a", "I", "mAudioAiInitState", "Lcom/xjsd/ai/voice/VoiceAdapter;", "b", "Lcom/xjsd/ai/voice/VoiceAdapter;", "mVoiceAdapter", "c", "Lkotlin/jvm/functions/Function2;", "mOnNoiseReductionProximalData", "d", "mOnNoiseReductionRemoteData", "e", "mOnRoleSeparateData", "f", "Lkotlin/jvm/functions/Function1;", "mOnNoiseReductionState", "", "g", "J", "mVpSrEngine", "h", "Lkotlinx/coroutines/CoroutineScope;", "mFeedCoroutine", "[B", "excessFeedBytes", "separateFeedBytes", "mRemoteArray", "mMuteRemoteArray", "mRoleRemoteArray", "mProximalArray", "mMuteProximalArray", "mRoleProximalArray", "mRoleFeedCount", "mRoleLogStartTime", "mIoCoroutine", "com/upuphone/ar/translation/audio/AudioAiManager$mVoiceListenerAdapter$1", "t", "Lcom/upuphone/ar/translation/audio/AudioAiManager$mVoiceListenerAdapter$1;", "mVoiceListenerAdapter", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AudioAiManager {
    public static final Companion u = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public int f6194a = -1;
    public VoiceAdapter b = new VoiceAdapter();
    public Function2 c;
    public Function2 d;
    public Function2 e;
    public Function1 f;
    public long g;
    public CoroutineScope h = j();
    public byte[] i = new byte[0];
    public byte[] j = new byte[0];
    public byte[] k = new byte[0];
    public byte[] l = new byte[0];
    public byte[] m = new byte[0];
    public byte[] n = new byte[0];
    public byte[] o = new byte[0];
    public byte[] p = new byte[0];
    public int q;
    public long r;
    public final CoroutineScope s = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    public AudioAiManager$mVoiceListenerAdapter$1 t = new AudioAiManager$mVoiceListenerAdapter$1(this);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/translation/audio/AudioAiManager$Companion;", "", "()V", "CHANNEL_PROXIMAL", "", "CHANNEL_REMOTE", "DUAL_AUDIO_AI_BUFFER_SIZE", "INTL_MAX_RECORD_SIZE", "MAX_RECORD_SIZE", "MONO_AUDIO_AI_BUFFER_SIZE", "REDUCTION_NOISE_AUDIO_SIZE", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static /* synthetic */ void t(AudioAiManager audioAiManager, byte[] bArr, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1024;
        }
        audioAiManager.s(bArr, i2);
    }

    public static /* synthetic */ void v(AudioAiManager audioAiManager, byte[] bArr, int i2, boolean z, float[] fArr, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 512;
        }
        audioAiManager.u(bArr, i2, z, fArr);
    }

    public final int A() {
        if (!TranslatorConstants.isIntlVersion() && !TranslatorConstants.isAirPro()) {
            return PlatformPlugin.DEFAULT_SYSTEM_UI;
        }
        return 3200;
    }

    public final String B() {
        return TranslatorConstants.isStar() ? AudioConfigFile.GLOABLE_BFVAD_TRANS_STAR : TranslatorConstants.isAir() ? AudioConfigFile.GLOABLE_VADONLY_AIR : TranslatorConstants.isConcept() ? AudioConfigFile.GLOABLE_GEVNNBF_TRANS_CONCEPT : TranslatorConstants.isAirPro() ? AudioConfigFile.GLOABLE_VADONLY_AIR_EN : AudioConfigFile.GLOABLE_BFVAD_TRANS_STAR;
    }

    public final void C() {
        Job unused = BuildersKt__Builders_commonKt.d(this.s, (CoroutineContext) null, (CoroutineStart) null, new AudioAiManager$reset$1(this, (Continuation<? super AudioAiManager$reset$1>) null), 3, (Object) null);
    }

    public final void D() {
        this.i = new byte[0];
        this.j = new byte[0];
        this.k = new byte[0];
        this.l = new byte[0];
        this.m = new byte[0];
        this.n = new byte[0];
        this.o = new byte[0];
        this.p = new byte[0];
        this.q = 0;
        this.r = 0;
    }

    public final void E(byte[] bArr, byte[] bArr2, float[] fArr) {
        short[] e2 = ByteArrayExtKt.e(bArr, false, 1, (Object) null);
        short[] e3 = ByteArrayExtKt.e(bArr2, false, 1, (Object) null);
        if (e2.length == 0 || e3.length == 0 || fArr.length == 0) {
            LogExt.f("角色分离数据或声纹为空 [leftShortArr=" + e2.length + ", rightShortArr=" + e3.length + ", vprint=" + fArr.length + "]", "AudioAiManager", "emptySeparateAudio", 0, 4, (Object) null);
            return;
        }
        Output output = new Output();
        if (this.q == 0) {
            this.r = SystemClock.elapsedRealtime();
            LogExt.c("角色分离算法调用[Start]", "AudioAiManager");
        }
        this.q++;
        VoiceManager.Companion companion = VoiceManager.Companion;
        companion.getInstance().sspExtractFrame(this.g, fArr, companion.getInstance().getSSP_EMBEDDING_SIZE(), e2, e3, e2.length, output);
        byte[] targetOutput = output.getTargetOutput();
        if (targetOutput != null) {
            byte[] bArr3 = this.p;
            byte[] copyOf = Arrays.copyOf(targetOutput, targetOutput.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.p = ArraysKt.plus(bArr3, copyOf);
        }
        byte[] interfOutput = output.getInterfOutput();
        if (interfOutput != null) {
            byte[] bArr4 = this.m;
            byte[] copyOf2 = Arrays.copyOf(interfOutput, interfOutput.length);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
            this.m = ArraysKt.plus(bArr4, copyOf2);
        }
        if (this.q == 100) {
            LogExt.c("角色分离算法调用[End], " + this.q + "次耗时=" + (SystemClock.elapsedRealtime() - this.r), "AudioAiManager");
            this.q = 0;
        }
        while (this.p.length >= A()) {
            byte[] sliceArray = ArraysKt.sliceArray(this.p, RangesKt.until(0, A()));
            byte[] sliceArray2 = ArraysKt.sliceArray(this.m, RangesKt.until(0, A()));
            Function2 function2 = this.e;
            if (function2 != null) {
                function2.invoke(sliceArray, sliceArray2);
            }
            this.p = ArraysKt.sliceArray(this.p, RangesKt.until(A(), this.p.length));
            this.m = ArraysKt.sliceArray(this.m, RangesKt.until(A(), this.m.length));
        }
    }

    public final void F() {
        Job unused = BuildersKt__Builders_commonKt.d(this.s, (CoroutineContext) null, (CoroutineStart) null, new AudioAiManager$stop$1(this, (Continuation<? super AudioAiManager$stop$1>) null), 3, (Object) null);
    }

    public final int G(byte[] bArr) {
        return BytesUtils.a(bArr);
    }

    public final byte[] H(byte[] bArr) {
        byte[] bArr2;
        ByteBuffer allocate = ByteBuffer.allocate(5200);
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            int i4 = i2 + 4;
            i2 = G(ArraysKt.copyOfRange(bArr, i2, i4)) + i4;
            ArraysKt.copyOfRange(bArr, i4, i2);
            TranslatorOpusCodec n2 = TranslationManager.q.a().n();
            if (n2 == null || (bArr2 = n2.a(bArr, 40)) == null) {
                bArr2 = new byte[0];
            }
            allocate.put(bArr2, 0, bArr2.length);
            i3 += bArr2.length;
        }
        byte[] array = allocate.array();
        Intrinsics.checkNotNullExpressionValue(array, "array(...)");
        return ArraysKt.copyOfRange(array, 0, i3);
    }

    public final void i(Function2 function2, Function2 function22, Function1 function1, Function2 function23) {
        Intrinsics.checkNotNullParameter(function2, "onProximalData");
        Intrinsics.checkNotNullParameter(function22, "onRemoteData");
        Intrinsics.checkNotNullParameter(function1, "onState");
        Intrinsics.checkNotNullParameter(function23, "onRoleSeparateData");
        this.c = function2;
        this.d = function22;
        this.f = function1;
        this.e = function23;
    }

    public final CoroutineScope j() {
        return CoroutineScopeKt.a(ExecutorsKt.b(ThreadPollHelper.f6199a.a()).plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    }

    public final void k(byte[] bArr, boolean z, boolean z2, float[] fArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(fArr, "roleVprintArray");
        if (!CoroutineScopeKt.h(this.h)) {
            this.h = j();
        }
        Job unused = BuildersKt__Builders_commonKt.d(this.h, (CoroutineContext) null, (CoroutineStart) null, new AudioAiManager$feedData$1(z, this, bArr, z2, fArr, (Continuation<? super AudioAiManager$feedData$1>) null), 3, (Object) null);
    }

    public final void l(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            Function1 function1 = this.f;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i2));
            }
            boolean z = false;
            if (i3 == 0) {
                if (i2 == 1) {
                    z = true;
                }
                n(bArr, z);
            } else if (i3 != 1) {
                LogExt.j("AI SDK返回错误的通道类型, channelIndex:: " + i3, "AudioAiManager");
            } else {
                if (i2 == 1) {
                    z = true;
                }
                m(bArr, z);
            }
        }
    }

    public final void m(byte[] bArr, boolean z) {
        byte[] bArr2;
        try {
            byte[] bArr3 = this.n;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.n = ArraysKt.plus(bArr3, copyOf);
            if (z) {
                byte[] f2 = TranslationAsrHelper.f6306a.f();
                bArr2 = Arrays.copyOf(f2, f2.length);
                Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
            } else {
                bArr2 = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
            }
            this.o = ArraysKt.plus(this.o, bArr2);
            while (this.n.length >= A()) {
                byte[] sliceArray = ArraysKt.sliceArray(this.n, RangesKt.until(0, A()));
                byte[] sliceArray2 = ArraysKt.sliceArray(this.o, RangesKt.until(0, A()));
                Function2 function2 = this.c;
                if (function2 != null) {
                    function2.invoke(sliceArray, sliceArray2);
                }
                this.n = ArraysKt.sliceArray(this.n, RangesKt.until(A(), this.n.length));
                this.o = ArraysKt.sliceArray(this.o, RangesKt.until(A(), this.o.length));
            }
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.j("handleAiProximalData error=" + stackTraceToString, "AudioAiManager");
        }
    }

    public final void n(byte[] bArr, boolean z) {
        byte[] bArr2;
        try {
            byte[] bArr3 = this.k;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.k = ArraysKt.plus(bArr3, copyOf);
            if (z) {
                byte[] f2 = TranslationAsrHelper.f6306a.f();
                bArr2 = Arrays.copyOf(f2, f2.length);
                Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
            } else {
                bArr2 = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
            }
            this.l = ArraysKt.plus(this.l, bArr2);
            while (this.k.length >= A()) {
                byte[] sliceArray = ArraysKt.sliceArray(this.k, RangesKt.until(0, A()));
                byte[] sliceArray2 = ArraysKt.sliceArray(this.l, RangesKt.until(0, A()));
                Function2 function2 = this.d;
                if (function2 != null) {
                    function2.invoke(sliceArray, sliceArray2);
                }
                this.k = ArraysKt.sliceArray(this.k, RangesKt.until(A(), this.k.length));
                this.l = ArraysKt.sliceArray(this.l, RangesKt.until(A(), this.l.length));
            }
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.j("handleAiRemoteData error=" + stackTraceToString, "AudioAiManager");
        }
    }

    public final void o(Context context) {
        try {
            VoiceAdapter voiceAdapter = this.b;
            if (voiceAdapter != null) {
                voiceAdapter.init(context, TranslatorConstants.isIntlVersion() ? y() : B());
            }
            this.f6194a = 0;
            VoiceAdapter voiceAdapter2 = this.b;
            String Version = voiceAdapter2 != null ? voiceAdapter2.Version() : null;
            LogExt.j("handleAudioInit 音频降噪引擎初始化状态(0:成功, -1:失败):" + 0 + "; 版本: " + Version, "AudioAiManager");
            D();
            VoiceAdapter voiceAdapter3 = this.b;
            if (voiceAdapter3 != null) {
                voiceAdapter3.registerListener(this.t);
            }
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.j("初始化音频降噪引擎异常:: " + stackTraceToString, "AudioAiManager");
        }
    }

    public final void p() {
        if (!z()) {
            LogExt.j("释放音频降噪引擎", "AudioAiManager");
            return;
        }
        VoiceAdapter voiceAdapter = this.b;
        if (voiceAdapter != null) {
            voiceAdapter.unregisterListener();
        }
        VoiceAdapter voiceAdapter2 = this.b;
        if (voiceAdapter2 != null) {
            voiceAdapter2.Destory();
        }
        this.b = null;
        this.f6194a = -1;
        this.g = 0;
        this.c = null;
        this.d = null;
        this.f = null;
        this.e = null;
        LogExt.j("释放音频降噪引擎", "AudioAiManager");
    }

    public final void q() {
        if (!z()) {
            LogExt.j("开启音频降噪引擎失败", "AudioAiManager");
            return;
        }
        VoiceAdapter voiceAdapter = this.b;
        Integer valueOf = voiceAdapter != null ? Integer.valueOf(voiceAdapter.Start()) : null;
        LogExt.j("开启音频降噪引擎state:: " + valueOf, "AudioAiManager");
    }

    public final void r() {
        if (!z()) {
            LogExt.j("关闭音频降噪引擎不成功", "AudioAiManager");
            return;
        }
        VoiceAdapter voiceAdapter = this.b;
        if (voiceAdapter != null) {
            voiceAdapter.Stop();
        }
        LogExt.j("关闭音频降噪引擎", "AudioAiManager");
    }

    public final void s(byte[] bArr, int i2) {
        try {
            byte[] H = H(bArr);
            AudioDebugHelper.i(bArr, "opus_ai_audio_phone.pcm");
            AudioDebugHelper.f(H, "ai_audio_phone.pcm");
            if (z()) {
                this.i = ArraysKt.plus(this.i, H);
                while (true) {
                    byte[] bArr2 = this.i;
                    if (bArr2.length >= i2) {
                        byte[] sliceArray = ArraysKt.sliceArray(bArr2, RangesKt.until(0, i2));
                        LogExt.f("双声道发送数据给算法", "AudioAiManager", "handleFeedDualAudioData", 0, 4, (Object) null);
                        VoiceAdapter voiceAdapter = this.b;
                        if (voiceAdapter != null) {
                            byte[] copyOf = Arrays.copyOf(sliceArray, sliceArray.length);
                            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                            voiceAdapter.Feed(copyOf);
                        }
                        byte[] bArr3 = this.i;
                        this.i = ArraysKt.sliceArray(bArr3, RangesKt.until(i2, bArr3.length));
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.j("handleFeedDualAudioData error=" + stackTraceToString, "AudioAiManager");
        }
    }

    public final void u(byte[] bArr, int i2, boolean z, float[] fArr) {
        byte[] bArr2;
        if (z) {
            try {
                w(bArr, i2, fArr);
            } catch (Exception e2) {
                String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
                LogExt.j("handleFeedMonoAudioData error=" + stackTraceToString, "AudioAiManager");
            }
        } else {
            TranslatorOpusCodec n2 = TranslationManager.q.a().n();
            if (n2 == null || (bArr2 = n2.a(bArr, 60)) == null) {
                bArr2 = new byte[0];
            }
            AudioDebugHelper.i(bArr, "opus_ai_audio_phone.pcm");
            AudioDebugHelper.f(bArr2, "ai_audio_phone.pcm");
            if (z()) {
                this.i = ArraysKt.plus(this.i, bArr2);
                while (true) {
                    byte[] bArr3 = this.i;
                    if (bArr3.length >= i2) {
                        byte[] sliceArray = ArraysKt.sliceArray(bArr3, RangesKt.until(0, i2));
                        LogExt.f("单声道发送数据给算法", "AudioAiManager", "handleFeedMonoAudioData", 0, 4, (Object) null);
                        VoiceAdapter voiceAdapter = this.b;
                        if (voiceAdapter != null) {
                            byte[] copyOf = Arrays.copyOf(sliceArray, sliceArray.length);
                            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                            voiceAdapter.Feed(copyOf);
                        }
                        byte[] bArr4 = this.i;
                        this.i = ArraysKt.sliceArray(bArr4, RangesKt.until(i2, bArr4.length));
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        if (r0 == null) goto L_0x0051;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043 A[Catch:{ Exception -> 0x0034 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d A[Catch:{ Exception -> 0x0034 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e A[Catch:{ Exception -> 0x0034 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w(byte[] r13, int r14, float[] r15) {
        /*
            r12 = this;
            int r0 = r13.length     // Catch:{ Exception -> 0x0034 }
            int r0 = r0 / 2
            r1 = 0
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt.until((int) r1, (int) r0)     // Catch:{ Exception -> 0x0034 }
            byte[] r2 = kotlin.collections.ArraysKt.sliceArray((byte[]) r13, (kotlin.ranges.IntRange) r2)     // Catch:{ Exception -> 0x0034 }
            int r3 = r13.length     // Catch:{ Exception -> 0x0034 }
            kotlin.ranges.IntRange r0 = kotlin.ranges.RangesKt.until((int) r0, (int) r3)     // Catch:{ Exception -> 0x0034 }
            byte[] r13 = kotlin.collections.ArraysKt.sliceArray((byte[]) r13, (kotlin.ranges.IntRange) r0)     // Catch:{ Exception -> 0x0034 }
            com.upuphone.ar.translation.phone.TranslationManager$Companion r0 = com.upuphone.ar.translation.phone.TranslationManager.q     // Catch:{ Exception -> 0x0034 }
            com.upuphone.ar.translation.phone.TranslationManager r3 = r0.a()     // Catch:{ Exception -> 0x0034 }
            com.upuphone.ar.translation.phone.helper.TranslatorOpusCodec r3 = r3.n()     // Catch:{ Exception -> 0x0034 }
            r4 = 60
            java.lang.String r5 = "copyOf(...)"
            if (r3 == 0) goto L_0x0037
            int r6 = r2.length     // Catch:{ Exception -> 0x0034 }
            byte[] r6 = java.util.Arrays.copyOf(r2, r6)     // Catch:{ Exception -> 0x0034 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)     // Catch:{ Exception -> 0x0034 }
            byte[] r3 = r3.a(r6, r4)     // Catch:{ Exception -> 0x0034 }
            if (r3 != 0) goto L_0x0039
            goto L_0x0037
        L_0x0034:
            r12 = move-exception
            goto L_0x00df
        L_0x0037:
            byte[] r3 = new byte[r1]     // Catch:{ Exception -> 0x0034 }
        L_0x0039:
            com.upuphone.ar.translation.phone.TranslationManager r0 = r0.a()     // Catch:{ Exception -> 0x0034 }
            com.upuphone.ar.translation.phone.helper.TranslatorOpusCodec r0 = r0.l()     // Catch:{ Exception -> 0x0034 }
            if (r0 == 0) goto L_0x0051
            int r6 = r13.length     // Catch:{ Exception -> 0x0034 }
            byte[] r6 = java.util.Arrays.copyOf(r13, r6)     // Catch:{ Exception -> 0x0034 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)     // Catch:{ Exception -> 0x0034 }
            byte[] r0 = r0.a(r6, r4)     // Catch:{ Exception -> 0x0034 }
            if (r0 != 0) goto L_0x0053
        L_0x0051:
            byte[] r0 = new byte[r1]     // Catch:{ Exception -> 0x0034 }
        L_0x0053:
            java.lang.String r4 = "opus_ai_audio_phone_1.pcm"
            com.upuphone.ar.translation.audio.debug.AudioDebugHelper.i(r2, r4)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r2 = "opus_ai_audio_phone_2.pcm"
            com.upuphone.ar.translation.audio.debug.AudioDebugHelper.s(r13, r2)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r13 = "ai_audio_phone_1.pcm"
            com.upuphone.ar.translation.audio.debug.AudioDebugHelper.f(r3, r13)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r13 = "ai_audio_phone_2.pcm"
            com.upuphone.ar.translation.audio.debug.AudioDebugHelper.r(r0, r13)     // Catch:{ Exception -> 0x0034 }
            boolean r13 = r12.z()     // Catch:{ Exception -> 0x0034 }
            if (r13 != 0) goto L_0x006e
            return
        L_0x006e:
            byte[] r13 = r12.i     // Catch:{ Exception -> 0x0034 }
            byte[] r13 = kotlin.collections.ArraysKt.plus((byte[]) r13, (byte[]) r3)     // Catch:{ Exception -> 0x0034 }
            r12.i = r13     // Catch:{ Exception -> 0x0034 }
            byte[] r13 = r12.j     // Catch:{ Exception -> 0x0034 }
            byte[] r13 = kotlin.collections.ArraysKt.plus((byte[]) r13, (byte[]) r0)     // Catch:{ Exception -> 0x0034 }
            r12.j = r13     // Catch:{ Exception -> 0x0034 }
        L_0x007e:
            byte[] r13 = r12.i     // Catch:{ Exception -> 0x0034 }
            int r0 = r13.length     // Catch:{ Exception -> 0x0034 }
            if (r0 < r14) goto L_0x00f9
            kotlin.ranges.IntRange r0 = kotlin.ranges.RangesKt.until((int) r1, (int) r14)     // Catch:{ Exception -> 0x0034 }
            byte[] r13 = kotlin.collections.ArraysKt.sliceArray((byte[]) r13, (kotlin.ranges.IntRange) r0)     // Catch:{ Exception -> 0x0034 }
            byte[] r0 = r12.j     // Catch:{ Exception -> 0x0034 }
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt.until((int) r1, (int) r14)     // Catch:{ Exception -> 0x0034 }
            byte[] r0 = kotlin.collections.ArraysKt.sliceArray((byte[]) r0, (kotlin.ranges.IntRange) r2)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r6 = "角色分离发送数据给算法"
            java.lang.String r7 = "AudioAiManager"
            java.lang.String r8 = "handleFeedSeparateAudioData"
            r10 = 4
            r11 = 0
            r9 = 0
            com.upuphone.ar.translation.ext.LogExt.f(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0034 }
            com.xjsd.ai.voice.VoiceAdapter r2 = r12.b     // Catch:{ Exception -> 0x0034 }
            if (r2 == 0) goto L_0x00b1
            int r3 = r13.length     // Catch:{ Exception -> 0x0034 }
            byte[] r3 = java.util.Arrays.copyOf(r13, r3)     // Catch:{ Exception -> 0x0034 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ Exception -> 0x0034 }
            r2.Feed(r3)     // Catch:{ Exception -> 0x0034 }
        L_0x00b1:
            int r2 = r13.length     // Catch:{ Exception -> 0x0034 }
            byte[] r13 = java.util.Arrays.copyOf(r13, r2)     // Catch:{ Exception -> 0x0034 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r5)     // Catch:{ Exception -> 0x0034 }
            int r2 = r0.length     // Catch:{ Exception -> 0x0034 }
            byte[] r0 = java.util.Arrays.copyOf(r0, r2)     // Catch:{ Exception -> 0x0034 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ Exception -> 0x0034 }
            r12.E(r13, r0, r15)     // Catch:{ Exception -> 0x0034 }
            byte[] r13 = r12.i     // Catch:{ Exception -> 0x0034 }
            int r0 = r13.length     // Catch:{ Exception -> 0x0034 }
            kotlin.ranges.IntRange r0 = kotlin.ranges.RangesKt.until((int) r14, (int) r0)     // Catch:{ Exception -> 0x0034 }
            byte[] r13 = kotlin.collections.ArraysKt.sliceArray((byte[]) r13, (kotlin.ranges.IntRange) r0)     // Catch:{ Exception -> 0x0034 }
            r12.i = r13     // Catch:{ Exception -> 0x0034 }
            byte[] r13 = r12.j     // Catch:{ Exception -> 0x0034 }
            int r0 = r13.length     // Catch:{ Exception -> 0x0034 }
            kotlin.ranges.IntRange r0 = kotlin.ranges.RangesKt.until((int) r14, (int) r0)     // Catch:{ Exception -> 0x0034 }
            byte[] r13 = kotlin.collections.ArraysKt.sliceArray((byte[]) r13, (kotlin.ranges.IntRange) r0)     // Catch:{ Exception -> 0x0034 }
            r12.j = r13     // Catch:{ Exception -> 0x0034 }
            goto L_0x007e
        L_0x00df:
            java.lang.String r12 = kotlin.ExceptionsKt.stackTraceToString(r12)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "handleFeedSeparateAudioData error="
            r13.append(r14)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            java.lang.String r13 = "AudioAiManager"
            com.upuphone.ar.translation.ext.LogExt.j(r12, r13)
        L_0x00f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.audio.AudioAiManager.w(byte[], int, float[]):void");
    }

    public final void x(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Job unused = BuildersKt__Builders_commonKt.d(this.s, (CoroutineContext) null, (CoroutineStart) null, new AudioAiManager$init$1(this, context, (Continuation<? super AudioAiManager$init$1>) null), 3, (Object) null);
    }

    public final String y() {
        if (TranslatorConstants.isStar()) {
            return AudioConfigFile.GLOABLE_BFVAD_TRANS_STAR_EN;
        }
        if (!TranslatorConstants.isAir()) {
            if (TranslatorConstants.isConcept()) {
                return AudioConfigFile.GLOABLE_GEVNNBF_TRANS_CONCEPT;
            }
            if (!TranslatorConstants.isAirPro()) {
                return AudioConfigFile.GLOABLE_BFVAD_TRANS_STAR_EN;
            }
        }
        return AudioConfigFile.GLOABLE_VADONLY_AIR_EN;
    }

    public final boolean z() {
        if (this.f6194a == 0) {
            return true;
        }
        LogExt.j("音频降噪引擎未初始化成功", "AudioAiManager");
        return false;
    }
}
