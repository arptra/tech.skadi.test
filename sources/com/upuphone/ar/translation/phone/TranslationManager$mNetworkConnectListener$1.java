package com.upuphone.ar.translation.phone;

import com.upuphone.ar.translation.phone.network.INetworkConnectListener;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"com/upuphone/ar/translation/phone/TranslationManager$mNetworkConnectListener$1", "Lcom/upuphone/ar/translation/phone/network/INetworkConnectListener;", "", "a", "()V", "c", "d", "b", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslationManager$mNetworkConnectListener$1 implements INetworkConnectListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslationManager f6217a;

    public TranslationManager$mNetworkConnectListener$1(TranslationManager translationManager) {
        this.f6217a = translationManager;
    }

    public void a() {
        TranslateStateManager p = this.f6217a.p();
        if (p != null) {
            p.k();
        }
    }

    public void b() {
        TranslateStateManager p = this.f6217a.p();
        if (p != null) {
            p.l();
        }
    }

    public void c() {
        TranslateStateManager p = this.f6217a.p();
        if (p != null) {
            p.j();
        }
    }

    public void d() {
        TranslateStateManager p = this.f6217a.p();
        if (p != null) {
            p.m();
        }
    }
}
