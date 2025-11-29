package com.upuphone.runasone.channel.bean.stream;

import com.upuphone.runasone.channel.linker.EnumLinker;

public class AckArg {
    private EnumLinker linker;
    private long reqId;

    public AckArg(EnumLinker enumLinker, long j) {
        this.linker = enumLinker;
        this.reqId = j;
    }

    public EnumLinker getLinker() {
        return this.linker;
    }

    public long getReqId() {
        return this.reqId;
    }
}
