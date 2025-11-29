package com.upuphone.runasone.channel.bean.stream;

public class RetransmissionArg {
    private long length;
    private long start;

    public RetransmissionArg(long j, long j2) {
        this.start = j;
        this.length = j2;
    }

    public long getLength() {
        return this.length;
    }

    public long getStart() {
        return this.start;
    }
}
