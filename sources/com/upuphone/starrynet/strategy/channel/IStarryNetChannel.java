package com.upuphone.starrynet.strategy.channel;

public interface IStarryNetChannel extends IConnectChannel, IMessageChannel {
    boolean isConnected(String str);
}
