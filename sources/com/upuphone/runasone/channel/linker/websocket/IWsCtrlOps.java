package com.upuphone.runasone.channel.linker.websocket;

import com.upuphone.runasone.StreamReq;

public interface IWsCtrlOps {
    boolean notifyTearDownSync(String str, StreamReq streamReq);

    void setSession(String str, String str2);

    boolean trigger(String str, StreamReq streamReq);
}
