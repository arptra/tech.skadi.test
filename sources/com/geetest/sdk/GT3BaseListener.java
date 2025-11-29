package com.geetest.sdk;

public interface GT3BaseListener extends NoProguard {
    void onButtonClick();

    void onClosed(int i);

    void onFailed(GT3ErrorBean gT3ErrorBean);

    void onReceiveCaptchaCode(int i);

    void onStatistics(String str);

    void onSuccess(String str);
}
