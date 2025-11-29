package com.honey.account.controller;

import android.app.Activity;
import com.geetest.captcha.GTCaptcha4Client;

public final /* synthetic */ class a implements GTCaptcha4Client.OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GTCaptcha4Client f9186a;
    public final /* synthetic */ Activity b;

    public /* synthetic */ a(GTCaptcha4Client gTCaptcha4Client, Activity activity) {
        this.f9186a = gTCaptcha4Client;
        this.b = activity;
    }

    public final void e(boolean z, String str) {
        CaptchaController$showCaptcha$1.invokeSuspend$lambda$6$lambda$4(this.f9186a, this.b, z, str);
    }
}
