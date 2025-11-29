package com.xjsd.ai.assistant.connect;

public interface SendMsgCallback {
    void onFail(int i, String str);

    void onSuccess();
}
