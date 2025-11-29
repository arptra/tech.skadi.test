package com.geetest.captcha;

import android.webkit.ValueCallback;

public final class d<T> implements ValueCallback<String> {

    /* renamed from: a  reason: collision with root package name */
    public static final d f2849a = new d();

    public void onReceiveValue(Object obj) {
        h0 h0Var = h0.d;
        h0Var.e("DialogController javascript:jsBridge.callback('showBox') return: " + ((String) obj));
    }
}
