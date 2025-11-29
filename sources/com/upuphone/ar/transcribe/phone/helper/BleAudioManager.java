package com.upuphone.ar.transcribe.phone.helper;

import android.content.Context;
import android.os.SystemClock;
import com.upuphone.ar.transcribe.asr.XJAsrManager;
import com.upuphone.ar.transcribe.audio.AudioAiManager;
import com.upuphone.ar.transcribe.eventtrack.EventTrackingHelper;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.xr.sapp.context.SdkContext;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u001d\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0012J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0012J\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010$R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010$R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020#0'8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010(R\"\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010(¨\u0006,"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/BleAudioManager;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "i", "(Landroid/content/Context;)V", "j", "", "bytes", "", "channel", "f", "([BI)V", "state", "l", "(I)V", "stateCode", "c", "e", "d", "audioState", "g", "(II)V", "k", "h", "", "a", "Z", "mIsRecord", "b", "I", "currentState", "", "J", "mMuteStartTime", "lastMuteLogTime", "", "Ljava/util/Map;", "channelAudioTime", "mLastAudioState", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBleAudioManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleAudioManager.kt\ncom/upuphone/ar/transcribe/phone/helper/BleAudioManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,306:1\n1855#2,2:307\n*S KotlinDebug\n*F\n+ 1 BleAudioManager.kt\ncom/upuphone/ar/transcribe/phone/helper/BleAudioManager\n*L\n112#1:307,2\n*E\n"})
public final class BleAudioManager {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public static final Lazy h = LazyKt.lazy(BleAudioManager$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public boolean f6098a;
    public int b;
    public long c;
    public long d;
    public final Map e = new LinkedHashMap();
    public Map f = MapsKt.mutableMapOf(TuplesKt.to(0, 0), TuplesKt.to(1, 0));

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/BleAudioManager$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/phone/helper/BleAudioManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/upuphone/ar/transcribe/phone/helper/BleAudioManager;", "instance", "", "AUDIO_CHANNEL_TAG", "Ljava/lang/String;", "", "MUTE_FIVE_MINUTES", "J", "MUTE_FIVE_SECONDS", "MUTE_TWO_SECONDS", "TAG", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BleAudioManager a() {
            return (BleAudioManager) BleAudioManager.h.getValue();
        }

        public Companion() {
        }
    }

    public final void c(int i) {
        LogExt.g("callAssistantState 语音助理回调状态=" + i, "BleAudioManager");
        XJAsrManager.e.a().f(i == 21);
        if (i == 21) {
            k();
        } else {
            AudioAiManager.r.a().A();
        }
    }

    public final void d(int i) {
        LogExt.g("callPhoneState 通话回调状态=" + i, "BleAudioManager");
        XJAsrManager.e.a().f(i == 28 || i == 29);
        if (i == 28 || i == 29) {
            k();
        } else {
            AudioAiManager.r.a().A();
        }
    }

    public final void e(int i) {
        LogExt.g("callWechatReply 微信回复回调状态=" + i, "BleAudioManager");
        XJAsrManager.e.a().f(i == 25);
        if (i == 25) {
            k();
        } else {
            AudioAiManager.r.a().A();
        }
    }

    public final void f(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        AudioAiManager.Companion companion = AudioAiManager.r;
        if (!companion.b()) {
            Long l = (Long) this.e.get(Integer.valueOf(i));
            long currentTimeMillis = System.currentTimeMillis();
            if (l != null) {
                long longValue = currentTimeMillis - l.longValue();
                if (longValue > 150) {
                    LogExt.e("audio delay time: " + longValue, "BleAudioManager");
                    EventTrackingHelper.f6058a.a(longValue, currentTimeMillis);
                }
            }
            this.e.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
            companion.a().m(bArr, i);
        }
    }

    public final void g(int i, int i2) {
        Integer num = (Integer) this.f.get(Integer.valueOf(i2));
        if (num == null || num.intValue() != i) {
            this.f.put(Integer.valueOf(i2), Integer.valueOf(i));
        }
        if (!this.f6098a) {
            this.c = 0;
            return;
        }
        if (i != 1) {
            this.c = 0;
        }
        if (i == 1) {
            LogExt.c("handleReduceNoiseAudioVad: mute", "BleAudioManager", "muteState", 0, false, 12, (Object) null);
            h();
        } else if (i == 2) {
            LogExt.g("handleReduceNoiseAudioVad: start", "BleAudioManager");
            TranscribeManager.Companion companion = TranscribeManager.j;
            if (companion.a().n() || this.b == 5) {
                LogExt.g("[handleReduceNoiseAudioVad] ARTranslatorStateManager has release!!!!!", "BleAudioManager");
            } else {
                companion.a().h().H();
            }
            this.b = 5;
        } else if (i == 3) {
            LogExt.c("handleReduceNoiseAudioVad: voice", "BleAudioManager", "voiceState", 0, false, 12, (Object) null);
            k();
        } else if (i == 4) {
            LogExt.g("handleReduceNoiseAudioVad: stop", "BleAudioManager");
            this.b = 6;
        }
    }

    public final void h() {
        if (this.c <= 0) {
            this.c = SystemClock.elapsedRealtime();
            this.b = 1;
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.c;
        if (AssistantConstants.TIMEOUT_VAD_MUTE <= elapsedRealtime && elapsedRealtime < 5000) {
            if (this.b == 1) {
                LogExt.g("voice reduce 2 secs!", "BleAudioManager");
                TranscribeManager.j.a().h().L();
            }
            this.b = 2;
        } else if (5000 <= elapsedRealtime && elapsedRealtime < 300000) {
            if (this.b == 2) {
                LogExt.g("voice reduce 5 secs!", "BleAudioManager");
                this.d = 0;
                TranscribeManager.j.a().h().K();
            }
            if (elapsedRealtime - this.d >= 5000) {
                this.d = elapsedRealtime;
                LogExt.g("voice reduce " + elapsedRealtime + " Millisecond!", "BleAudioManager");
            }
            this.b = 3;
        } else if (elapsedRealtime >= 300000) {
            if (this.b == 3) {
                LogExt.g("voice reduce 5 min!", "BleAudioManager");
                TranscribeManager.j.a().h().J();
            }
            this.b = 4;
        }
    }

    public final void i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AudioAiManager.Companion companion = AudioAiManager.r;
        companion.a().v(context);
        companion.a().l(BleAudioManager$initAudioAi$1.INSTANCE, BleAudioManager$initAudioAi$2.INSTANCE, new BleAudioManager$initAudioAi$3(this));
        XJAsrManager.e.a().j(context);
        SdkContext.f6675a.c().b("Transcribe", new BleAudioManager$initAudioAi$4(this));
    }

    public final void j() {
        AudioAiManager.r.a().B();
        this.c = 0;
        this.b = 0;
        this.f6098a = false;
        for (Number intValue : this.f.keySet()) {
            this.f.put(Integer.valueOf(intValue.intValue()), 0);
        }
        this.e.clear();
        XJAsrManager.e.a().k();
        AudioAiManager.r.c();
        SdkContext.f6675a.c().c("Transcribe");
        LogExt.g("release AudioChannel success...！", "BleAudioManager");
    }

    public final void k() {
        this.c = 0;
        this.b = 1;
    }

    public final void l(int i) {
        boolean z = false;
        this.f6098a = (i == 5) | (i == 4);
        boolean z2 = (i == 1) | (i == 2);
        if (i == 3) {
            z = true;
        }
        if (z2 || z) {
            k();
        }
        LogExt.g("是否正在录音状态，isRecord=" + this.f6098a, "BleAudioManager");
    }
}
