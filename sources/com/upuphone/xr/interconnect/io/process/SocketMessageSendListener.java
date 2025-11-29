package com.upuphone.xr.interconnect.io.process;

public interface SocketMessageSendListener {
    void onFail(String str, String str2);

    void onSuccess(String str);
}
