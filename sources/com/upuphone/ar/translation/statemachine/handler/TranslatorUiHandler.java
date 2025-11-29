package com.upuphone.ar.translation.statemachine.handler;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.ar.translation.statemachine.listener.TranslatorUiListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/upuphone/ar/translation/statemachine/handler/TranslatorUiHandler;", "", "Lcom/upuphone/ar/translation/statemachine/listener/TranslatorUiListener;", "listener", "<init>", "(Lcom/upuphone/ar/translation/statemachine/listener/TranslatorUiListener;)V", "", "state", "expCode", "", "c", "(II)V", "obj", "b", "(Ljava/lang/Object;)V", "a", "d", "Lcom/upuphone/ar/translation/statemachine/listener/TranslatorUiListener;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslatorUiHandler {

    /* renamed from: a  reason: collision with root package name */
    public final TranslatorUiListener f6353a;

    public TranslatorUiHandler(TranslatorUiListener translatorUiListener) {
        Intrinsics.checkNotNullParameter(translatorUiListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f6353a = translatorUiListener;
    }

    public final void a(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.f6353a.b(obj);
    }

    public final void b(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.f6353a.c(obj);
    }

    public final void c(int i, int i2) {
        this.f6353a.a(i, i2);
    }

    public final void d(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.f6353a.d(obj);
    }
}
