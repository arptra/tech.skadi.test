package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import android.os.SystemClock;
import com.upuphone.ar.translation.audio.AudioAiManager;
import com.upuphone.ar.translation.audio.debug.AudioDebugHelper;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J!\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u0014J\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u001f\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010#J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010\rJ\u0017\u0010(\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\nH\u0002¢\u0006\u0004\b(\u0010\rR\u0016\u0010+\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00101R\u0016\u00105\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010-R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010;¨\u0006="}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/BleAudioHelper;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "t", "(Landroid/content/Context;)V", "u", "", "bytes", "l", "([B)V", "", "state", "extCode", "w", "(II)V", "m", "(I)V", "stateCode", "", "isReset", "f", "(IZ)V", "j", "h", "audioState", "o", "v", "s", "proximalBytes", "muteProximalBytes", "n", "([B[B)V", "remoteBytes", "muteRemoteBytes", "p", "q", "r", "b", "Z", "mIsRecord", "c", "I", "currentState", "", "d", "J", "mMuteStartTime", "e", "lastMuteLogTime", "mLastAudioState", "Lcom/upuphone/ar/translation/audio/AudioAiManager;", "g", "Lcom/upuphone/ar/translation/audio/AudioAiManager;", "mAudioAiManager", "", "[F", "mRoleVprintArray", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class BleAudioHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final BleAudioHelper f6295a = new BleAudioHelper();
    public static boolean b;
    public static int c;
    public static long d;
    public static long e;
    public static int f;
    public static AudioAiManager g;
    public static float[] h = new float[0];

    public static /* synthetic */ void g(BleAudioHelper bleAudioHelper, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        bleAudioHelper.f(i, z);
    }

    public static /* synthetic */ void i(BleAudioHelper bleAudioHelper, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        bleAudioHelper.h(i, z);
    }

    public static /* synthetic */ void k(BleAudioHelper bleAudioHelper, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        bleAudioHelper.j(i, z);
    }

    public final void f(int i, boolean z) {
        AudioAiManager audioAiManager;
        LogExt.j("callAssistantState 语音助理回调状态=" + i + ", isReset=" + z, "BleAudioHelper");
        TranslationAsrHelper.h(TranslationAsrHelper.f6306a, i == 21, 0, 2, (Object) null);
        if (i == 21) {
            v();
        } else if (z && (audioAiManager = g) != null) {
            audioAiManager.C();
        }
    }

    public final void h(int i, boolean z) {
        AudioAiManager audioAiManager;
        LogExt.j("callPhoneState 通话回调状态=" + i + ", isReset=" + z, "BleAudioHelper");
        TranslationAsrHelper.h(TranslationAsrHelper.f6306a, i == 28, 0, 2, (Object) null);
        if (i == 28) {
            v();
        } else if (z && (audioAiManager = g) != null) {
            audioAiManager.C();
        }
    }

    public final void j(int i, boolean z) {
        AudioAiManager audioAiManager;
        LogExt.j("callWechatReply 微信回复回调状态=" + i + ", isReset=" + z, "BleAudioHelper");
        TranslationAsrHelper.h(TranslationAsrHelper.f6306a, i == 25, 0, 2, (Object) null);
        if (i == 25) {
            v();
        } else if (z && (audioAiManager = g) != null) {
            audioAiManager.C();
        }
    }

    public final void l(byte[] bArr) {
        AudioAiManager audioAiManager;
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        TranslationManager.Companion companion = TranslationManager.q;
        TranslateStateManager p = companion.a().p();
        if (p != null && p.h() && (audioAiManager = g) != null) {
            audioAiManager.k(bArr, TranslatorConstants.isMono(), companion.a().y(), h);
        }
    }

    public final void m(int i) {
        switch (i) {
            case 21:
            case 22:
                g(this, i, false, 2, (Object) null);
                return;
            case 25:
            case 26:
                k(this, i, false, 2, (Object) null);
                return;
            case 27:
            case 28:
            case 29:
                i(this, i, false, 2, (Object) null);
                return;
            default:
                return;
        }
    }

    public final void n(byte[] bArr, byte[] bArr2) {
        LogExt.f("音频降噪算法返回近端数据", "BleAudioHelper", "handleProximalData", 0, 4, (Object) null);
        AudioDebugHelper audioDebugHelper = AudioDebugHelper.f6196a;
        audioDebugHelper.k(bArr, "noise_proximal_ai_audio_phone.pcm");
        audioDebugHelper.g(bArr2, "mute_noise_proximal_ai_audio_phone.pcm");
        TranslationManager.Companion companion = TranslationManager.q;
        if (!companion.a().z() && !companion.a().y()) {
            if (TranslatorConstants.isConcept() || TranslatorConstants.isStar()) {
                TranslationAsrHelper.f6306a.o(bArr2);
            }
        }
    }

    public final void o(int i) {
        if (f != i) {
            LogExt.j("音频帧降噪音频状态:: " + i, "BleAudioHelper");
        }
        f = i;
        if (!b) {
            d = 0;
            return;
        }
        if (i != 1) {
            d = 0;
        }
        if (i == 1) {
            LogExt.f("handleReduceNoiseAudioVad: mute", "BleAudioHelper", "muteState", 0, 4, (Object) null);
            s();
        } else if (i == 2) {
            LogExt.j("handleReduceNoiseAudioVad: start", "BleAudioHelper");
            TranslationManager.Companion companion = TranslationManager.q;
            if (companion.a().z() || c == 5) {
                LogExt.j("[handleReduceNoiseAudioVad] ARTranslatorStateManager has release!!!!!", "BleAudioHelper");
            } else {
                TranslateStateManager p = companion.a().p();
                if (p != null) {
                    p.B();
                }
            }
            c = 5;
        } else if (i == 3) {
            LogExt.f("handleReduceNoiseAudioVad: voice", "BleAudioHelper", "voiceState", 0, 4, (Object) null);
            v();
        } else if (i == 4) {
            LogExt.j("handleReduceNoiseAudioVad: stop", "BleAudioHelper");
            c = 6;
        }
    }

    public final void p(byte[] bArr, byte[] bArr2) {
        LogExt.f("音频降噪算法返回远端数据", "BleAudioHelper", "handleRemoteData", 0, 4, (Object) null);
        AudioDebugHelper audioDebugHelper = AudioDebugHelper.f6196a;
        audioDebugHelper.n(bArr, "noise_remote_ai_audio_phone.pcm");
        audioDebugHelper.h(bArr2, "mute_noise_remote_ai_audio_phone.pcm");
        TranslationManager.Companion companion = TranslationManager.q;
        if (!companion.a().z() && !companion.a().y()) {
            TranslationAsrHelper translationAsrHelper = TranslationAsrHelper.f6306a;
            if (!TranslatorConstants.isMicroSoftAsr()) {
                bArr = bArr2;
            }
            translationAsrHelper.p(bArr);
        }
    }

    public final void q(byte[] bArr) {
        int length = bArr.length;
        LogExt.f("角色分离算法返回近端数据[size=" + length + "]", "BleAudioHelper", "handleRoleProximalData", 0, 4, (Object) null);
        AudioDebugHelper.f6196a.p(bArr, "role_proximal_ai_audio_phone.pcm");
        TranslationAsrHelper.f6306a.o(bArr);
    }

    public final void r(byte[] bArr) {
        int length = bArr.length;
        LogExt.f("角色分离算法返回远端数据[size=" + length + "]", "BleAudioHelper", "handleRoleRemoteData", 0, 4, (Object) null);
        AudioDebugHelper.f6196a.q(bArr, "role_remote_ai_audio_phone.pcm");
        TranslationAsrHelper.f6306a.p(bArr);
    }

    public final void s() {
        if (d <= 0) {
            d = SystemClock.elapsedRealtime();
            c = 1;
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - d;
        if (1200 <= elapsedRealtime && elapsedRealtime < 5000) {
            if (c == 1) {
                LogExt.j("voice reduce 2 secs!", "BleAudioHelper");
                TranslateStateManager p = TranslationManager.q.a().p();
                if (p != null) {
                    p.F();
                }
            }
            c = 2;
        } else if (5000 <= elapsedRealtime && elapsedRealtime < 300000) {
            if (c == 2) {
                LogExt.j("voice reduce 5 secs!", "BleAudioHelper");
                e = 0;
                TranslateStateManager p2 = TranslationManager.q.a().p();
                if (p2 != null) {
                    p2.E();
                }
            }
            if (elapsedRealtime - e >= 5000) {
                e = elapsedRealtime;
                LogExt.j("voice reduce " + elapsedRealtime + " Millisecond!", "BleAudioHelper");
            }
            c = 3;
        } else if (elapsedRealtime >= 300000) {
            if (c == 3) {
                LogExt.j("voice reduce 5 min!", "BleAudioHelper");
                TranslateStateManager p3 = TranslationManager.q.a().p();
                if (p3 != null) {
                    p3.D();
                }
            }
            c = 4;
        }
    }

    public final void t(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogExt.j("initAudioAi", "BleAudioHelper");
        AudioAiManager audioAiManager = new AudioAiManager();
        audioAiManager.x(context);
        audioAiManager.i(BleAudioHelper$initAudioAi$1$1.INSTANCE, BleAudioHelper$initAudioAi$1$2.INSTANCE, BleAudioHelper$initAudioAi$1$3.INSTANCE, BleAudioHelper$initAudioAi$1$4.INSTANCE);
        g = audioAiManager;
        TranslationAsrHelper.f6306a.j(context);
    }

    public final void u() {
        AudioAiManager audioAiManager = g;
        if (audioAiManager != null) {
            audioAiManager.F();
        }
        g = null;
        d = 0;
        c = 0;
        b = false;
        f = 0;
        h = new float[0];
        TranslationAsrHelper.f6306a.k();
        LogExt.j("releaseAudioAi", "BleAudioHelper");
    }

    public final void v() {
        d = 0;
        c = 1;
    }

    public final void w(int i, int i2) {
        boolean z = (i == 5) | (i == 4);
        b = z;
        LogExt.j("setTranslateState 是否正在录音状态，isRecord=" + z, "BleAudioHelper");
        if (((i == 1 && i2 == -1) | (i == 2 && InterconnectMsgCodExtKt.d(i2))) || (i == 3 && i2 == -1)) {
            v();
        }
        if ((i == 3 && i2 == -1) || (i == 4 && i2 == 34)) {
            float[] roleVprint = TranslatorConstants.getRoleVprint();
            h = roleVprint;
            int length = roleVprint.length;
            LogExt.j("setTranslateState 获取角色分离声纹 " + length, "BleAudioHelper");
            v();
            AudioAiManager audioAiManager = g;
            if (audioAiManager != null) {
                audioAiManager.C();
            }
            AudioAiManager audioAiManager2 = g;
            if (audioAiManager2 != null) {
                audioAiManager2.D();
            }
            TranslationAsrHelper.f6306a.l(false);
        }
        if (i == 2 && InterconnectMsgCodExtKt.d(i2)) {
            TranslationAsrHelper.m(TranslationAsrHelper.f6306a, false, 1, (Object) null);
            f(22, false);
            j(26, false);
            h(27, false);
        }
        m(i2);
    }
}
