package com.upuphone.starrynet.api.message;

import com.upuphone.starrynet.api.bean.StMessage;

public interface IReceiveMessageListener {
    void receiveMessage(StMessage stMessage);
}
