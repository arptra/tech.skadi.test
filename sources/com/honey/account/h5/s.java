package com.honey.account.h5;

import com.upuphone.ar.translation.phone.view.TranslatorLoadingView;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorLoadingView f4526a;

    public /* synthetic */ s(TranslatorLoadingView translatorLoadingView) {
        this.f4526a = translatorLoadingView;
    }

    public final void run() {
        TranslatorLoadingView.k(this.f4526a);
    }
}
