package com.upuphone.starrynet.strategy.channel;

import com.upuphone.starrynet.api.bean.StDevice;

public interface IMessageChannel {
    public static final int MSG_TYPE_DATA = 1;
    public static final int MSG_TYPE_DATA_CRC32 = 2;
    public static final int MSG_TYPE_STARRY_NET_DATA = 10;
    public static final int MSG_TYPE_STARRY_NET_INIT_DATA = 11;

    int getCTR(int i) {
        if (i == 2) {
            return 1;
        }
        if (i == 10) {
            return 16;
        }
        return i == 11 ? 17 : 0;
    }

    int getMsgType(int i) {
        if (i == 1) {
            return 2;
        }
        if (i == 16) {
            return 10;
        }
        return i == 17 ? 11 : 1;
    }

    int sendMsg(StDevice stDevice, boolean z, byte[] bArr, int i, IMessageCallback iMessageCallback);

    int sendMsg(StDevice stDevice, byte[] bArr);

    int sendMsg(StDevice stDevice, byte[] bArr, int i);

    int sendMsg(StDevice stDevice, byte[] bArr, int i, IMessageCallback iMessageCallback);

    int sendMsg(StDevice stDevice, byte[] bArr, IMessageCallback iMessageCallback);
}
