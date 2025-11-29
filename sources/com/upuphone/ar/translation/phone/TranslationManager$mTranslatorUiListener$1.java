package com.upuphone.ar.translation.phone;

import com.upuphone.ar.translation.statemachine.listener.TranslatorUiListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"com/upuphone/ar/translation/phone/TranslationManager$mTranslatorUiListener$1", "Lcom/upuphone/ar/translation/statemachine/listener/TranslatorUiListener;", "", "state", "expCode", "", "a", "(II)V", "", "obj", "c", "(Ljava/lang/Object;)V", "b", "d", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslationManager$mTranslatorUiListener$1 implements TranslatorUiListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslationManager f6218a;

    public TranslationManager$mTranslatorUiListener$1(TranslationManager translationManager) {
        this.f6218a = translationManager;
    }

    public void a(int i, int i2) {
        this.f6218a.v(i, i2);
    }

    public void b(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.f6218a.t(obj);
    }

    public void c(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.f6218a.u(obj);
    }

    public void d(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.f6218a.A("TransServiceRunning", new TranslationManager$mTranslatorUiListener$1$notifyTranslateServerRunningState$1(obj));
    }
}
