package com.xjsd.iot.starrynetstack.jni;

import androidx.annotation.Keep;

@Keep
public interface IStarrySocketListener {
    public static final int KCP_ACCEPTED = 8;
    public static final int KCP_CLIENT_CONNECT_ERROR = -3;
    public static final int KCP_CLIENT_INIT_ERROR = -1;
    public static final int KCP_CONNECTED = 4;
    public static final int KCP_EVENT_CLIENT_INIT = 1;
    public static final int KCP_EVENT_SERVER_INIT = 2;
    public static final int KCP_SERVER_INIT_ERROR = -2;

    byte[] getContainer(int i);

    void onAccept(int i, String str);

    void onConnect();

    void onData(int i, byte[] bArr, int i2);

    void onData(int i, byte[] bArr, int i2, String str, int i3) {
    }

    void onError(int i);

    void onEvent(int i);

    void onMessage(int i, byte[] bArr, int i2);
}
