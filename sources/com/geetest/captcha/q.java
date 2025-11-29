package com.geetest.captcha;

import com.geetest.captcha.GTCaptcha4Client;

public final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f2877a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;

    public q(p pVar, boolean z, String str) {
        this.f2877a = pVar;
        this.b = z;
        this.c = str;
    }

    public final void run() {
        GTCaptcha4Client.OnSuccessListener onSuccessListener = this.f2877a.d;
        if (onSuccessListener != null) {
            onSuccessListener.e(this.b, this.c);
        }
    }
}
