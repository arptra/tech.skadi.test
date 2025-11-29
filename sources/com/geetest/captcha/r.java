package com.geetest.captcha;

import com.geetest.captcha.GTCaptcha4Client;

public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f2878a;

    public r(p pVar) {
        this.f2878a = pVar;
    }

    public final void run() {
        GTCaptcha4Client.OnWebViewShowListener onWebViewShowListener = this.f2878a.f;
        if (onWebViewShowListener != null) {
            onWebViewShowListener.c();
        }
    }
}
