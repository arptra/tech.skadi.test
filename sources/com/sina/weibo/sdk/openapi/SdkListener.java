package com.sina.weibo.sdk.openapi;

public interface SdkListener {
    void onInitFailure(Exception exc);

    void onInitSuccess();
}
