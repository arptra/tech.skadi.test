package com.upuphone.starrynet.strategy.message;

public interface ISendMessageListener {
    void onSendFail(StarryMessage starryMessage, int i, String str);

    void onSendSuccess(StarryMessage starryMessage);
}
