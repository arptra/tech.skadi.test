package com.upuphone.ar.transcribe.asr;

import android.content.Context;
import android.util.Base64;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u0003J\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010\bR\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/upuphone/ar/transcribe/asr/AbsAsrImpl;", "Lcom/upuphone/ar/transcribe/asr/AsrImpl;", "<init>", "()V", "", "bytes", "", "n", "([B)V", "m", "", "keep", "f", "(Z)V", "h", "i", "Landroid/content/Context;", "context", "j", "(Landroid/content/Context;)V", "k", "", "d", "()I", "l", "", "base64Str", "c", "(Ljava/lang/String;)[B", "g", "()[B", "a", "[B", "e", "o", "muteData", "Lkotlinx/coroutines/Job;", "b", "Lkotlinx/coroutines/Job;", "mKeepLiveJob", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class AbsAsrImpl implements AsrImpl {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public byte[] f6018a = new byte[0];
    public Job b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/asr/AbsAsrImpl$Companion;", "", "()V", "TAG", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final byte[] c(String str) {
        byte[] decode = Base64.decode(str, 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
        return decode;
    }

    public final int d() {
        TranscribeManager.Companion companion = TranscribeManager.j;
        int l = companion.a().l();
        LogExt.d("transType: " + l, "AbsAsrImpl");
        return companion.a().l() == 4 ? 1 : 2;
    }

    public final byte[] e() {
        return this.f6018a;
    }

    public void f(boolean z) {
        if (!z) {
            LogExt.g("语音助理退出取消保活数据灌输", "AbsAsrImpl");
            Job job = this.b;
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
                return;
            }
            return;
        }
        Job job2 = this.b;
        if (job2 != null) {
            Job.DefaultImpls.a(job2, (CancellationException) null, 1, (Object) null);
        }
        this.b = null;
        this.b = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new AbsAsrImpl$keepAlive$1(this, (Continuation<? super AbsAsrImpl$keepAlive$1>) null), 3, (Object) null);
    }

    public final byte[] g() {
        byte[] bArr = new byte[0];
        for (int i = 0; i < 10; i++) {
            bArr = ArraysKt.plus(bArr, this.f6018a);
        }
        return bArr;
    }

    public final void h() {
        m(g());
    }

    public final void i() {
        n(g());
    }

    public void j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new AbsAsrImpl$loadAudioMuteData$1(context, this, (Continuation<? super AbsAsrImpl$loadAudioMuteData$1>) null), 3, (Object) null);
    }

    public void k() {
        Job job = this.b;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.f6018a = new byte[0];
    }

    public final void l() {
        byte[] g = g();
        if (TranscribeManager.j.a().l() == 4) {
            m(g);
        }
        n(g);
    }

    public abstract void m(byte[] bArr);

    public abstract void n(byte[] bArr);

    public final void o(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.f6018a = bArr;
    }
}
