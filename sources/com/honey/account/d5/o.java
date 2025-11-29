package com.honey.account.d5;

import com.upuphone.ar.translation.phone.activity.TranslatorMainActivity;
import com.upuphone.ar.translation.phone.bean.TransStateEvent;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TransStateEvent f4321a;
    public final /* synthetic */ TranslatorMainActivity b;

    public /* synthetic */ o(TransStateEvent transStateEvent, TranslatorMainActivity translatorMainActivity) {
        this.f4321a = transStateEvent;
        this.b = translatorMainActivity;
    }

    public final void run() {
        TranslatorMainActivity.handleTranslateState$lambda$13(this.f4321a, this.b);
    }
}
