package com.upuphone.xr.sapp.vm;

import android.app.Application;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.honey.account.z8.m;
import com.honey.account.z8.n;
import com.upuphone.ai.ttsengine.TtsSdk;
import com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.audio.AudioRecordChannel;
import com.upuphone.xr.sapp.audio.VoiceAiAdapter;
import com.upuphone.xr.sapp.context.IPhoneCallStatus;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.utils.FileUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.xjmz.ai.voice.SpeakerVerificationType;
import com.xjmz.ai.voice.VoiceManager;
import com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils;
import com.xjsd.ai.assistant.phone.helper.WakeupVoiceStorage;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ^2\u00020\u0001:\u0002_`B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bH@¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ+\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u000eJ\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u000eJ\r\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010\u000eJ\r\u0010 \u001a\u00020\b¢\u0006\u0004\b \u0010\u000eR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u00102\u001a\n /*\u0004\u0018\u00010.0.8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u00105R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010\u001fR\u0016\u0010S\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010\u001fR\u0016\u0010U\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010JR\u0016\u0010W\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010JR\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020\"0X8\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\¨\u0006a"}, d2 = {"Lcom/upuphone/xr/sapp/vm/WakeupRecordingViewmodel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "", "text", "", "P", "(Ljava/lang/String;)V", "X", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Y", "()V", "a0", "O", "()Ljava/lang/String;", "b0", "R", "id", "", "param", "K", "(Ljava/lang/String;Ljava/util/Map;)V", "V", "U", "", "N", "()Z", "W", "Z", "S", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/upuphone/xr/sapp/vm/RecordState;", "b", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_recordStatusFlow", "Lcom/upuphone/xr/sapp/audio/AudioRecordChannel;", "c", "Lcom/upuphone/xr/sapp/audio/AudioRecordChannel;", "audioRecorder", "Lcom/upuphone/xr/sapp/audio/VoiceAiAdapter;", "d", "Lcom/upuphone/xr/sapp/audio/VoiceAiAdapter;", "voiceAiAdapter", "Landroid/media/AudioFocusRequest;", "kotlin.jvm.PlatformType", "e", "Landroid/media/AudioFocusRequest;", "focusRequest", "", "f", "I", "count", "Lkotlinx/coroutines/Job;", "g", "Lkotlinx/coroutines/Job;", "timerJob", "h", "failedCount", "", "i", "J", "wakeupVoiceEngine", "", "j", "[B", "audioBuffer", "", "k", "[F", "embeddedArray", "l", "Ljava/lang/String;", "vuId", "Landroid/media/AudioManager;", "m", "Landroid/media/AudioManager;", "audioManager", "n", "isGlassWakeupOn", "o", "isDebuggable", "p", "debugFilePath", "q", "debugTempFilePath", "Lkotlinx/coroutines/flow/Flow;", "r", "Lkotlinx/coroutines/flow/Flow;", "M", "()Lkotlinx/coroutines/flow/Flow;", "recordStatusFlow", "s", "Companion", "WordSpeed", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nWakeupRecordingViewmodel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WakeupRecordingViewmodel.kt\ncom/upuphone/xr/sapp/vm/WakeupRecordingViewmodel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,344:1\n13424#2,3:345\n*S KotlinDebug\n*F\n+ 1 WakeupRecordingViewmodel.kt\ncom/upuphone/xr/sapp/vm/WakeupRecordingViewmodel\n*L\n290#1:345,3\n*E\n"})
public final class WakeupRecordingViewmodel extends AndroidViewModel {
    public static final Companion s = new Companion((DefaultConstructorMarker) null);
    public static final List t = CollectionsKt.listOf("小溪小溪", "Hey Aicy", "Xiaoxi, Xiaoxi");
    public static final List u = CollectionsKt.listOf(new WordSpeed(GlobalExtKt.h(R.string.wakeup_record_say), 1.0f), new WordSpeed(GlobalExtKt.h(R.string.wakeup_record_say_slow), 0.8f), new WordSpeed(GlobalExtKt.h(R.string.wakeup_record_say_more_slow), 0.6f), new WordSpeed(GlobalExtKt.h(R.string.wakeup_record_say_faster), 1.2f), new WordSpeed(GlobalExtKt.h(R.string.wakeup_record_say_more_faster), 1.5f));
    public final MutableSharedFlow b;
    public final AudioRecordChannel c;
    public final VoiceAiAdapter d;
    public final AudioFocusRequest e = new AudioFocusRequest.Builder(1).setOnAudioFocusChangeListener(new n()).build();
    public int f = 1;
    public Job g;
    public int h;
    public long i;
    public byte[] j = new byte[0];
    public float[] k = new float[128];
    public String l = "";
    public AudioManager m;
    public boolean n;
    public boolean o = true;
    public String p;
    public String q;
    public final Flow r;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/vm/WakeupRecordingViewmodel$Companion;", "", "()V", "DOT_ID_FAILED", "", "DOT_ID_RECORD", "DOT_PARAM_ID", "DOT_PARAM_TYPE", "RETRY_COUNT", "", "SP_KEY_RECORD_ID", "TAG", "TWO_SECONDS_AUDIO_SIZE", "WAKE_UP_WORD", "", "WORD_SPEED_LIST", "Lcom/upuphone/xr/sapp/vm/WakeupRecordingViewmodel$WordSpeed;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/vm/WakeupRecordingViewmodel$WordSpeed;", "", "", "word", "", "speed", "<init>", "(Ljava/lang/String;F)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "F", "()F", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class WordSpeed {

        /* renamed from: a  reason: collision with root package name */
        public final String f8013a;
        public final float b;

        public WordSpeed(String str, float f) {
            Intrinsics.checkNotNullParameter(str, "word");
            this.f8013a = str;
            this.b = f;
        }

        public final float a() {
            return this.b;
        }

        public final String b() {
            return this.f8013a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WordSpeed)) {
                return false;
            }
            WordSpeed wordSpeed = (WordSpeed) obj;
            return Intrinsics.areEqual((Object) this.f8013a, (Object) wordSpeed.f8013a) && Float.compare(this.b, wordSpeed.b) == 0;
        }

        public int hashCode() {
            return (this.f8013a.hashCode() * 31) + Float.hashCode(this.b);
        }

        public String toString() {
            String str = this.f8013a;
            float f = this.b;
            return "WordSpeed(word=" + str + ", speed=" + f + ")";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupRecordingViewmodel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        String str = null;
        MutableSharedFlow b2 = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.b = b2;
        AudioRecordChannel audioRecordChannel = new AudioRecordChannel();
        audioRecordChannel.k(12, 1024, new WakeupRecordingViewmodel$audioRecorder$1$1(this), new WakeupRecordingViewmodel$audioRecorder$1$2(this));
        this.c = audioRecordChannel;
        this.d = new VoiceAiAdapter(application, new WakeupRecordingViewmodel$voiceAiAdapter$1(this));
        this.r = b2;
        VoiceManager.Companion companion = VoiceManager.Companion;
        companion.getInstance().init(GlobalExtKt.f());
        long spkRecogInit = companion.getInstance().spkRecogInit(GlobalExtKt.f(), SpeakerVerificationType.SV_Wakeup, SdkContext.f6675a.c().e());
        this.i = spkRecogInit;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WakeupRecordingViewmodel", "wakeupVoiceEngine: " + spkRecogInit);
        Object systemService = GlobalExtKt.f().getSystemService("audio");
        this.m = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        try {
            File externalFilesDir = GlobalExtKt.f().getExternalFilesDir((String) null);
            if (externalFilesDir != null) {
                str = externalFilesDir.getAbsolutePath();
            }
        } catch (Exception unused) {
            str = GlobalExtKt.f().getFilesDir().getAbsolutePath();
        }
        this.p = str + "/wakeup_voice";
        this.q = str + "/wakeup_voice_temp";
    }

    public static final void L(int i2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WakeupRecordingViewmodel", "focus changed: " + i2);
    }

    /* access modifiers changed from: private */
    public final boolean N() {
        IPhoneCallStatus iPhoneCallStatus = (IPhoneCallStatus) SdkContext.f6675a.c().h().getValue();
        return iPhoneCallStatus != null && iPhoneCallStatus.getCallStatus() == 2;
    }

    /* access modifiers changed from: private */
    public final void P(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WakeupRecordingViewmodel", "start tts: " + str);
        TtsSdk ttsSdk = TtsSdk.f5490a;
        Bundle bundle = new Bundle();
        bundle.putInt("caller_priority", 1);
        bundle.putString("voice_id", "BV700_streaming");
        Unit unit = Unit.INSTANCE;
        ttsSdk.p("WakeupRecordingViewmodel", str, 0, bundle, String.valueOf(System.currentTimeMillis()), new m(this));
    }

    public static final void Q(WakeupRecordingViewmodel wakeupRecordingViewmodel, int i2, int i3) {
        Intrinsics.checkNotNullParameter(wakeupRecordingViewmodel, "this$0");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(wakeupRecordingViewmodel), (CoroutineContext) null, (CoroutineStart) null, new WakeupRecordingViewmodel$playTts$2$1(wakeupRecordingViewmodel, i2, (Continuation<? super WakeupRecordingViewmodel$playTts$2$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void a0() {
        this.c.p();
        this.d.d();
    }

    public final void K(String str, Map map) {
        SdkContext.f6675a.d().reportEvent(str, map);
    }

    public final Flow M() {
        return this.r;
    }

    public final String O() {
        boolean z;
        ULog.Delegate delegate = ULog.f6446a;
        int i2 = this.f;
        delegate.a("WakeupRecordingViewmodel", "collect count " + i2);
        WordSpeed wordSpeed = (WordSpeed) u.get(this.f - 1);
        String b2 = wordSpeed.b();
        for (String str : t) {
            if (StringsKt.indexOf$default((CharSequence) b2, str, 0, false, 6, (Object) null) != -1) {
                float a2 = wordSpeed.a();
                String replace$default = StringsKt.replace$default(b2, str, "<prosody speed=\"" + a2 + "\">" + str + "</prosody>", false, 4, (Object) null);
                StringBuilder sb = new StringBuilder();
                sb.append("<speak>");
                sb.append(replace$default);
                sb.append("</speak>");
                b2 = sb.toString();
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return b2;
    }

    public final void R() {
        int length = this.j.length;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WakeupRecordingViewmodel", "get emb audio input size: " + length);
        if (length > 64000) {
            this.j = ArraysKt.copyOfRange(this.j, length - 64000, length);
        }
        VoiceManager instance = VoiceManager.Companion.getInstance();
        long j2 = this.i;
        byte[] bArr = this.j;
        float[] spkRecogGetEmb = instance.spkRecogGetEmb(j2, bArr, bArr.length);
        delegate.a("WakeupRecordingViewmodel", "embedded size: " + spkRecogGetEmb.length);
        if (spkRecogGetEmb.length != this.k.length) {
            this.k = new float[spkRecogGetEmb.length];
        }
        int length2 = spkRecogGetEmb.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            float f2 = spkRecogGetEmb[i2];
            float[] fArr = this.k;
            fArr[i3] = fArr[i3] + (f2 / ((float) 5));
            i2++;
            i3++;
        }
        V();
        ULog.f6446a.a("WakeupRecordingViewmodel", "finished register");
    }

    public final void S() {
        this.c.m();
        this.d.b();
        VoiceManager.Companion.getInstance().spkRecogDelete(this.i);
    }

    public final void U() {
        if (this.o) {
            if (new File(this.p).exists()) {
                FileUtils.f7881a.c(this.p);
            }
            new File(this.q).renameTo(new File(this.p));
        }
    }

    public final void V() {
        if (this.o) {
            String str = this.q;
            int i2 = this.f;
            File file = new File(str + "/record_" + i2 + RecordFileUtils.LAST_PEX);
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
            } else {
                file.delete();
            }
            file.createNewFile();
            byte[] bArr = this.j;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            FilesKt.writeBytes(file, copyOf);
        }
    }

    public final void W() {
        AudioManager audioManager = this.m;
        if (audioManager != null) {
            audioManager.requestAudioFocus(this.e);
        }
        boolean e2 = AssistantSettingUtils.b.e(GlobalExtKt.f(), "low_power_wakeup");
        this.n = e2;
        if (e2) {
            WakeupVoiceStorage.INSTANCE.mark(true);
        }
        P(O());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object X(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$startRecord$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$startRecord$1 r0 = (com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$startRecord$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$startRecord$1 r0 = new com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$startRecord$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r4 = (com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0066
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            java.util.UUID r5 = java.util.UUID.randomUUID()
            java.lang.String r5 = r5.toString()
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            r4.l = r5
            r5 = 0
            byte[] r5 = new byte[r5]
            r4.j = r5
            com.upuphone.xr.sapp.audio.VoiceAiAdapter r5 = r4.d
            r5.c()
            com.upuphone.xr.sapp.audio.AudioRecordChannel r5 = r4.c
            r5.o()
            kotlinx.coroutines.flow.MutableSharedFlow r5 = r4.b
            com.upuphone.xr.sapp.vm.RecordState$Recording r2 = com.upuphone.xr.sapp.vm.RecordState.Recording.f8002a
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.emit(r2, r0)
            if (r5 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r4.Y()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel.X(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void Y() {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.a(), (CoroutineStart) null, new WakeupRecordingViewmodel$startTimer$1(this, (Continuation<? super WakeupRecordingViewmodel$startTimer$1>) null), 2, (Object) null);
    }

    public final void Z() {
        Job job = this.g;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        TtsSdk.u(TtsSdk.f5490a, "WakeupRecordingViewmodel", (String) null, 2, (Object) null);
        a0();
        this.j = new byte[0];
        if (this.n) {
            Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.a(), (CoroutineStart) null, new WakeupRecordingViewmodel$stop$1((Continuation<? super WakeupRecordingViewmodel$stop$1>) null), 2, (Object) null);
        }
    }

    public final void b0() {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.a(), (CoroutineStart) null, new WakeupRecordingViewmodel$wakeup$1(this, (Continuation<? super WakeupRecordingViewmodel$wakeup$1>) null), 2, (Object) null);
    }
}
