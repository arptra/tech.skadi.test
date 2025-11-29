package com.upuphone.starrynet.api.message;

public interface IMessageResponseListener {
    void onFail(int i, String str);

    void onSuccess();
}
