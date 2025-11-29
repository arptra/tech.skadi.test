package com.upuphone.ai.ttsengine.base.service;

import com.upuphone.ai.ttsengine.base.ITtsStatusListener;
import com.upuphone.ai.ttsengine.base.service.TtsImpl;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"com/upuphone/ai/ttsengine/base/service/TtsImpl$initListener$1", "Lcom/upuphone/ai/ttsengine/base/ITtsStatusListener;", "", "d", "()V", "g", "b", "c", "a", "", "errorCode", "h", "(I)V", "", "bytes", "sampleRate", "e", "([BI)V", "arg1", "arg2", "percent", "f", "(III)V", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TtsImpl$initListener$1 implements ITtsStatusListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TtsImpl f5514a;

    public TtsImpl$initListener$1(TtsImpl ttsImpl) {
        this.f5514a = ttsImpl;
    }

    public void a() {
        AILOG a2 = this.f5514a.f5513a;
        String e = this.f5514a.e;
        a2.c("playEnd, mPackageName = " + e, new Object[0]);
        this.f5514a.i = false;
        Object d = this.f5514a.b;
        TtsImpl ttsImpl = this.f5514a;
        synchronized (d) {
            TtsImpl.TtsCallback c = ttsImpl.d;
            if (c != null) {
                c.b();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void b() {
        this.f5514a.f5513a.c("playPause", new Object[0]);
    }

    public void c() {
        this.f5514a.f5513a.c("playResume", new Object[0]);
    }

    public void d() {
        AILOG a2 = this.f5514a.f5513a;
        String e = this.f5514a.e;
        a2.c("playStart, mPackageName = " + e, new Object[0]);
        Object d = this.f5514a.b;
        TtsImpl ttsImpl = this.f5514a;
        synchronized (d) {
            TtsImpl.TtsCallback c = ttsImpl.d;
            if (c != null) {
                c.onStart();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void e(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        this.f5514a.f5513a.c("onSynthesizedData: ", new Object[0]);
    }

    public void f(int i, int i2, int i3) {
        AILOG a2 = this.f5514a.f5513a;
        a2.c("playProgress=" + i + ", " + i2 + ", percent=" + i3, new Object[0]);
    }

    public void g() {
        this.f5514a.f5513a.c("playSoundStart", new Object[0]);
    }

    public void h(int i) {
        AILOG a2 = this.f5514a.f5513a;
        String e = this.f5514a.e;
        a2.c("playError: " + i + ", mPackageName =" + e, new Object[0]);
        Object d = this.f5514a.b;
        TtsImpl ttsImpl = this.f5514a;
        synchronized (d) {
            TtsImpl.TtsCallback c = ttsImpl.d;
            if (c != null) {
                c.onError(i);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
