package com.upuphone.runasone.ble;

import com.upuphone.hub.annotation.Callback;

public interface SessionApi {
    void initSession(String str, SessionConfig sessionConfig, @Callback InitSessionCallback initSessionCallback);

    void openNotify(String str, String str2, @Callback OpenNotifyCallback openNotifyCallback);

    void read(String str, String str2, @Callback ReadCallback readCallback);

    void registerSessionCallback(String str, @Callback SessionCallback sessionCallback);

    void setMtu(String str, int i, @Callback MtuCallback mtuCallback);

    void unregisterSessionCallback(String str);

    void write(String str, String str2, byte[] bArr, @Callback WriteCallback writeCallback);
}
