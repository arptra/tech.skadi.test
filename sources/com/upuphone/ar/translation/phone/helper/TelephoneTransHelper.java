package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import android.os.SystemClock;
import com.upuphone.ar.translation.audio.debug.AudioDebugHelper;
import com.upuphone.ar.translation.audio.thread.ThreadPollHelper;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.xr.sapp.context.IPhoneCallStatus;
import com.upuphone.xr.sapp.context.SdkContext;
import com.xjsd.ai.annotation.AudioConfigFile;
import com.xjsd.ai.voice.VoiceAdapter;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J2\u0010\u0010\u001a\u00020\u00062#\b\u0002\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0003J\r\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001d\u0010\u0018J\u000f\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010 J\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010$J\u000f\u0010&\u001a\u00020\"H\u0002¢\u0006\u0004\b&\u0010$J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b'\u0010\u0018J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b(\u0010\u0018J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010\u0003R\u0016\u00100\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00105\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010<\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u00107R\u0016\u0010>\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u00107R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010AR\u0016\u0010I\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010/R\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010L¨\u0006O"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/TelephoneTransHelper;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "y", "(Landroid/content/Context;)V", "E", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isTelephoneTrans", "callback", "C", "(Lkotlin/jvm/functions/Function1;)V", "D", "A", "()Z", "", "bytes", "q", "([B)V", "p", "proximalBytes", "u", "remoteBytes", "v", "Lkotlinx/coroutines/CoroutineScope;", "o", "()Lkotlinx/coroutines/CoroutineScope;", "n", "", "r", "()Ljava/lang/String;", "z", "B", "t", "s", "", "audioState", "x", "(I)V", "w", "b", "Lkotlinx/coroutines/CoroutineScope;", "mRemoteFeedCoroutine", "c", "mProximalFeedCoroutine", "d", "Z", "mIsTelephoneTrans", "e", "[B", "mFeedRemoteArray", "f", "mFeedProximalArray", "g", "mRemoteArray", "h", "mProximalArray", "", "i", "J", "mMuteStartTime", "j", "I", "mCurrentState", "k", "mLastMuteLogTime", "l", "mIoScope", "Lcom/xjsd/ai/voice/VoiceAdapter;", "m", "Lcom/xjsd/ai/voice/VoiceAdapter;", "mRemoteVoiceAdapter", "mProximalVoiceAdapter", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TelephoneTransHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final TelephoneTransHelper f6305a;
    public static CoroutineScope b;
    public static CoroutineScope c;
    public static boolean d;
    public static byte[] e = new byte[0];
    public static byte[] f = new byte[0];
    public static byte[] g = new byte[0];
    public static byte[] h = new byte[0];
    public static long i;
    public static int j;
    public static long k;
    public static CoroutineScope l;
    public static VoiceAdapter m;
    public static VoiceAdapter n;

    static {
        TelephoneTransHelper telephoneTransHelper = new TelephoneTransHelper();
        f6305a = telephoneTransHelper;
        b = telephoneTransHelper.n();
        c = telephoneTransHelper.n();
        l = telephoneTransHelper.o();
    }

    public final boolean A() {
        return d;
    }

    public final String B() {
        return TranslatorConstants.isStar() ? AudioConfigFile.GLOABLE_BFVAD_TRANS_STAR : TranslatorConstants.isAir() ? AudioConfigFile.GLOABLE_VADONLY_AIR : TranslatorConstants.isConcept() ? AudioConfigFile.GLOABLE_GEVNNBF_TRANS_CONCEPT : TranslatorConstants.isAirPro() ? AudioConfigFile.GLOABLE_VADONLY_AIR_EN : AudioConfigFile.GLOABLE_BFVAD_TRANS_STAR;
    }

    public final void C(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        IPhoneCallStatus value = TranslatorConstants.getPhoneCallStatus().getValue();
        boolean z = value != null && value.getCallStatus() == 2;
        d = z;
        function1.invoke(Boolean.valueOf(z));
        boolean z2 = d;
        LogExt.j("startTelephoneTranslation isTelephoneTrans=" + z2, "TelephoneTransHelper");
        e = new byte[0];
        f = new byte[0];
        g = new byte[0];
        h = new byte[0];
        i = 0;
        j = 0;
        k = 0;
        b = n();
        c = n();
    }

    public final void D() {
        boolean z = d;
        LogExt.j("stopTelephoneTranslation isTelephoneTrans=" + z, "TelephoneTransHelper");
        d = false;
        e = new byte[0];
        f = new byte[0];
        g = new byte[0];
        h = new byte[0];
        CoroutineScopeKt.e(b, (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.e(c, (CancellationException) null, 1, (Object) null);
        i = 0;
        j = 0;
        k = 0;
    }

    public final void E() {
        LogExt.j("unInit telephone translation", "TelephoneTransHelper");
        SdkContext.f6675a.c().c("TelephoneTransHelper");
        VoiceAdapter voiceAdapter = m;
        if (voiceAdapter != null) {
            voiceAdapter.Stop();
        }
        VoiceAdapter voiceAdapter2 = m;
        if (voiceAdapter2 != null) {
            voiceAdapter2.unregisterListener();
        }
        VoiceAdapter voiceAdapter3 = m;
        if (voiceAdapter3 != null) {
            voiceAdapter3.Destory();
        }
        m = null;
        VoiceAdapter voiceAdapter4 = n;
        if (voiceAdapter4 != null) {
            voiceAdapter4.Stop();
        }
        VoiceAdapter voiceAdapter5 = n;
        if (voiceAdapter5 != null) {
            voiceAdapter5.unregisterListener();
        }
        VoiceAdapter voiceAdapter6 = n;
        if (voiceAdapter6 != null) {
            voiceAdapter6.Destory();
        }
        n = null;
        CoroutineScopeKt.e(l, (CancellationException) null, 1, (Object) null);
    }

    public final CoroutineScope n() {
        return CoroutineScopeKt.a(ExecutorsKt.b(ThreadPollHelper.f6199a.a()).plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    }

    public final CoroutineScope o() {
        return CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    }

    public final void p(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        if (d) {
            Job unused = BuildersKt__Builders_commonKt.d(c, (CoroutineContext) null, (CoroutineStart) null, new TelephoneTransHelper$feedProximalAudio$1(bArr, (Continuation<? super TelephoneTransHelper$feedProximalAudio$1>) null), 3, (Object) null);
        }
    }

    public final void q(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        if (d) {
            Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new TelephoneTransHelper$feedRemoteAudio$1(bArr, (Continuation<? super TelephoneTransHelper$feedRemoteAudio$1>) null), 3, (Object) null);
        }
    }

    public final String r() {
        return TranslatorConstants.isIntlVersion() ? z() : B();
    }

    public final void s(byte[] bArr) {
        if (d) {
            byte[] bArr2 = h;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            h = ArraysKt.plus(bArr2, copyOf);
            while (true) {
                byte[] bArr3 = h;
                if (bArr3.length >= 3200) {
                    u(ArraysKt.sliceArray(bArr3, RangesKt.until(0, 3200)));
                    byte[] bArr4 = h;
                    h = ArraysKt.sliceArray(bArr4, RangesKt.until(3200, bArr4.length));
                } else {
                    return;
                }
            }
        }
    }

    public final void t(byte[] bArr) {
        if (d) {
            byte[] bArr2 = g;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            g = ArraysKt.plus(bArr2, copyOf);
            while (true) {
                byte[] bArr3 = g;
                if (bArr3.length >= 3200) {
                    v(ArraysKt.sliceArray(bArr3, RangesKt.until(0, 3200)));
                    byte[] bArr4 = g;
                    g = ArraysKt.sliceArray(bArr4, RangesKt.until(3200, bArr4.length));
                } else {
                    return;
                }
            }
        }
    }

    public final void u(byte[] bArr) {
        int length = bArr.length;
        LogExt.e("通话翻译发送云端近端数据[size=" + length + "]", "TelephoneTransHelper", "handleTelephoneProximalData", 50);
        AudioDebugHelper.f6196a.v(bArr, "tele_proximal_audio_phone.pcm");
        TranslationAsrHelper.f6306a.o(bArr);
    }

    public final void v(byte[] bArr) {
        int length = bArr.length;
        LogExt.e("通话翻译发送云端远端数据[size=" + length + "]", "TelephoneTransHelper", "handleTelephoneRemoteData", 50);
        AudioDebugHelper.f6196a.y(bArr, "tele_remote_audio_phone.pcm");
        TranslationAsrHelper.f6306a.p(bArr);
    }

    public final void w() {
        if (i <= 0) {
            i = SystemClock.elapsedRealtime();
            j = 1;
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - i;
        if (1200 <= elapsedRealtime && elapsedRealtime < 5000) {
            if (j == 1) {
                LogExt.j("voice reduce 2 secs!", "TelephoneTransHelper");
                TranslateStateManager p = TranslationManager.q.a().p();
                if (p != null) {
                    p.F();
                }
            }
            j = 2;
        } else if (5000 <= elapsedRealtime && elapsedRealtime < 300000) {
            if (j == 2) {
                LogExt.j("voice reduce 5 secs!", "TelephoneTransHelper");
                k = 0;
                TranslateStateManager p2 = TranslationManager.q.a().p();
                if (p2 != null) {
                    p2.E();
                }
            }
            if (elapsedRealtime - k >= 5000) {
                k = elapsedRealtime;
                LogExt.j("voice reduce " + elapsedRealtime + " Millisecond!", "TelephoneTransHelper");
            }
            j = 3;
        } else if (elapsedRealtime >= 300000) {
            if (j == 3) {
                LogExt.j("voice reduce 5 min!", "TelephoneTransHelper");
                TranslateStateManager p3 = TranslationManager.q.a().p();
                if (p3 != null) {
                    p3.D();
                }
            }
            j = 4;
        }
    }

    public final void x(int i2) {
        TranslateStateManager p;
        if (d) {
            if (i2 != 1) {
                i = 0;
            }
            if (i2 == 1) {
                w();
            } else if (i2 == 2) {
                if (!(j == 5 || (p = TranslationManager.q.a().p()) == null)) {
                    p.B();
                }
                j = 5;
            } else if (i2 == 4) {
                j = 6;
            }
        }
    }

    public final void y(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CoroutineScope o = o();
        l = o;
        Job unused = BuildersKt__Builders_commonKt.d(o, (CoroutineContext) null, (CoroutineStart) null, new TelephoneTransHelper$init$1(context, (Continuation<? super TelephoneTransHelper$init$1>) null), 3, (Object) null);
        SdkContext.f6675a.c().b("TelephoneTransHelper", TelephoneTransHelper$init$2.INSTANCE);
    }

    public final String z() {
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
}
