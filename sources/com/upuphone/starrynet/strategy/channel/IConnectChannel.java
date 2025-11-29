package com.upuphone.starrynet.strategy.channel;

import com.upuphone.starrynet.api.bean.StDevice;

public interface IConnectChannel {
    public static final int PROFILE_CHANNEL_AP = 12;
    public static final int PROFILE_CHANNEL_BLE_CLIENT = 1;
    public static final int PROFILE_CHANNEL_BLE_SERVER = 2;
    public static final int PROFILE_CHANNEL_BR_EDR_MASTER = 20;
    public static final int PROFILE_CHANNEL_BR_EDR_SLAVE = 21;
    public static final int PROFILE_CHANNEL_MYVU_RING_BLE_CLIENT = 25;
    public static final int PROFILE_CHANNEL_P2P_GC = 11;
    public static final int PROFILE_CHANNEL_P2P_GO = 10;
    public static final int PROFILE_CHANNEL_SIMPLE_BLE_CLIENT = 22;
    public static final int PROFILE_CHANNEL_SPP_CLIENT = 23;
    public static final int PROFILE_CHANNEL_SPP_SERVER = 24;
    public static final int PROFILE_CHANNEL_STA = 13;
    public static final int PROFILE_CHANNEL_USB_MASTER = 3;
    public static final int PROFILE_CHANNEL_USB_SLAVE = 4;

    int connect(StDevice stDevice);

    int disconnect(StDevice stDevice);

    int getProfile();

    void setCallback(IChannelCallback iChannelCallback);
}
