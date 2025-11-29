package com.upuphone.runasone.uupcast.api;

import com.upuphone.hub.annotation.Hub;
import com.upuphone.starryiccoaproto.UCarMessage;

@Hub
public interface IHandleReceiverCarMessageListener {
    void handleReceiverCarMessage(UCarMessage uCarMessage);
}
