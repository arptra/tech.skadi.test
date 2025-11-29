package com.honey.account.controller;

import com.geetest.captcha.GTCaptcha4Client;

public final /* synthetic */ class b implements GTCaptcha4Client.OnFailureListener {
    public final void onFailure(String str) {
        CaptchaController$showCaptcha$1.invokeSuspend$lambda$6$lambda$5(str);
    }
}
