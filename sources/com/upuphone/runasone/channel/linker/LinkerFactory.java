package com.upuphone.runasone.channel.linker;

import com.upuphone.runasone.channel.linker.bt.BtLinkerImpl;
import com.upuphone.runasone.channel.linker.simplified.SimplifiedLinkerImpl;
import com.upuphone.runasone.channel.linker.websocket.WsLinkerImpl;

public class LinkerFactory {
    private LinkerFactory() {
    }

    public static ILinker getInstance(EnumLinker enumLinker) {
        if (EnumLinker.TYPE_LINK_BT == enumLinker || EnumLinker.TYPE_LINK_SPP == enumLinker) {
            return new BtLinkerImpl(enumLinker);
        }
        if (EnumLinker.TYPE_LINK_WS == enumLinker) {
            return new WsLinkerImpl(enumLinker);
        }
        if (EnumLinker.TYPE_LINK_SIMPLIFIED == enumLinker) {
            return new SimplifiedLinkerImpl(enumLinker);
        }
        return null;
    }
}
