package com.upuphone.starrynet.strategy.message;

import androidx.core.util.Pair;

public interface IMessageSender {
    Pair<Integer, String> preCheck(StarryMessage starryMessage);

    void sendMessage(StarryMessage starryMessage, ISendMessageListener iSendMessageListener);

    void sendShortMessageAtOnce(StarryMessage starryMessage);
}
