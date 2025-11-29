package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import android.util.Base64;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.iflytek.IFlyAsrHelper;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.statemachine.handler.XunFeiChannelHandler;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.xjsd.xr.sapp.asr.UnifiedAsrHelper;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0015R\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010(¨\u0006+"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/TranslationAsrHelper;", "", "<init>", "()V", "", "bytes", "", "p", "([B)V", "o", "", "isKeepAlive", "", "delayTime", "g", "(ZJ)V", "Landroid/content/Context;", "context", "j", "(Landroid/content/Context;)V", "f", "()[B", "k", "isEnd", "l", "(Z)V", "n", "", "base64Str", "e", "(Ljava/lang/String;)[B", "i", "b", "[B", "mMuteData", "Lkotlinx/coroutines/Job;", "c", "Lkotlinx/coroutines/Job;", "mKeepLiveJob", "d", "J", "mProximalSendAudioLen", "mRemoteSendAudioLen", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslationAsrHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final TranslationAsrHelper f6306a = new TranslationAsrHelper();
    public static byte[] b = new byte[0];
    public static Job c;
    public static long d;
    public static long e;

    public static /* synthetic */ void h(TranslationAsrHelper translationAsrHelper, boolean z, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 1000;
        }
        translationAsrHelper.g(z, j);
    }

    public static /* synthetic */ void m(TranslationAsrHelper translationAsrHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        translationAsrHelper.l(z);
    }

    public final byte[] e(String str) {
        byte[] decode = Base64.decode(str, 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
        return decode;
    }

    public final byte[] f() {
        return b;
    }

    public final void g(boolean z, long j) {
        if (!z) {
            Job job = c;
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
                return;
            }
            return;
        }
        Job job2 = c;
        if (job2 != null) {
            Job.DefaultImpls.a(job2, (CancellationException) null, 1, (Object) null);
        }
        c = null;
        c = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new TranslationAsrHelper$keepAlive$1(j, (Continuation<? super TranslationAsrHelper$keepAlive$1>) null), 3, (Object) null);
    }

    public final byte[] i() {
        byte[] bArr = new byte[0];
        int i = TranslatorConstants.isMicroSoftAsr() ? 10 : 4;
        for (int i2 = 0; i2 < i; i2++) {
            bArr = ArraysKt.plus(bArr, b);
        }
        return bArr;
    }

    public final void j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new TranslationAsrHelper$loadAudioMuteData$1(context, (Continuation<? super TranslationAsrHelper$loadAudioMuteData$1>) null), 3, (Object) null);
    }

    public final void k() {
        Job job = c;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        b = new byte[0];
        m(this, false, 1, (Object) null);
    }

    public final void l(boolean z) {
        if (z) {
            long j = (long) 32;
            long j2 = e / j;
            long j3 = d / j;
            LogExt.j("resetSendAudioLen Remote[sendTime=" + j2 + "(ms)] ,Proximal[sendTime=" + j3 + "(ms)", "TranslationAsrHelper");
        }
        e = 0;
        d = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r1 = r1.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n() {
        /*
            r3 = this;
            byte[] r0 = r3.i()
            com.upuphone.ar.translation.phone.TranslationManager$Companion r1 = com.upuphone.ar.translation.phone.TranslationManager.q
            com.upuphone.ar.translation.phone.TranslationManager r1 = r1.a()
            com.upuphone.ar.translation.statemachine.machine.TranslateStateManager r1 = r1.p()
            if (r1 == 0) goto L_0x001b
            com.upuphone.ar.translation.statemachine.handler.XunFeiChannelHandler r1 = r1.a()
            if (r1 == 0) goto L_0x001b
            int r1 = r1.v()
            goto L_0x001c
        L_0x001b:
            r1 = -1
        L_0x001c:
            r2 = 1
            if (r1 == r2) goto L_0x0031
            r2 = 2
            if (r1 == r2) goto L_0x002d
            r2 = 3
            if (r1 == r2) goto L_0x0026
            goto L_0x0034
        L_0x0026:
            r3.p(r0)
            r3.o(r0)
            goto L_0x0034
        L_0x002d:
            r3.o(r0)
            goto L_0x0034
        L_0x0031:
            r3.p(r0)
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.helper.TranslationAsrHelper.n():void");
    }

    public final void o(byte[] bArr) {
        XunFeiChannelHandler a2;
        IFlyAsrHelper u;
        XunFeiChannelHandler a3;
        UnifiedAsrHelper t;
        XunFeiChannelHandler a4;
        UnifiedAsrHelper t2;
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        int length = copyOf.length;
        d += (long) length;
        if (TranslatorConstants.isIntlVersion()) {
            LogExt.e("发送[近]端音频到服务器[国际版], byteSize=" + length, "TranslationAsrHelper", "sendProximalData_xunfei", 50);
            TranslateStateManager p = TranslationManager.q.a().p();
            if (p != null && (a4 = p.a()) != null && (t2 = a4.t()) != null) {
                t2.sendProximalAudioData(copyOf);
                return;
            }
            return;
        }
        LogExt.e("发送[近]端音频到服务器[国内版], byteSize=" + length, "TranslationAsrHelper", "sendProximalData_xunfei", 50);
        if (TranslatorConstants.isAirPro()) {
            TranslateStateManager p2 = TranslationManager.q.a().p();
            if (p2 != null && (a3 = p2.a()) != null && (t = a3.t()) != null) {
                t.sendProximalAudioData(copyOf);
                return;
            }
            return;
        }
        TranslateStateManager p3 = TranslationManager.q.a().p();
        if (p3 != null && (a2 = p3.a()) != null && (u = a2.u()) != null) {
            u.s0(copyOf);
        }
    }

    public final void p(byte[] bArr) {
        XunFeiChannelHandler a2;
        IFlyAsrHelper u;
        XunFeiChannelHandler a3;
        UnifiedAsrHelper t;
        XunFeiChannelHandler a4;
        UnifiedAsrHelper t2;
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        int length = copyOf.length;
        e += (long) length;
        if (TranslatorConstants.isIntlVersion()) {
            LogExt.e("发送[远]端音频到服务器[国际版], byteSize=" + length, "TranslationAsrHelper", "sendRemoteData_xunfei", 50);
            TranslateStateManager p = TranslationManager.q.a().p();
            if (p != null && (a4 = p.a()) != null && (t2 = a4.t()) != null) {
                t2.sendRemoteAudioData(copyOf);
                return;
            }
            return;
        }
        LogExt.e("发送[远]端音频到服务器[国内版], byteSize=" + length, "TranslationAsrHelper", "sendRemoteData_xunfei", 50);
        if (TranslatorConstants.isAirPro()) {
            TranslateStateManager p2 = TranslationManager.q.a().p();
            if (p2 != null && (a3 = p2.a()) != null && (t = a3.t()) != null) {
                t.sendRemoteAudioData(copyOf);
                return;
            }
            return;
        }
        TranslateStateManager p3 = TranslationManager.q.a().p();
        if (p3 != null && (a2 = p3.a()) != null && (u = a2.u()) != null) {
            u.t0(copyOf);
        }
    }
}
