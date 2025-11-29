package io.netty.handler.codec.http2;

import io.netty.channel.ChannelId;

final class Http2StreamChannelId implements ChannelId {
    private static final long serialVersionUID = -6642338822166867585L;
    private final int id;
    private final ChannelId parentId;

    public Http2StreamChannelId(ChannelId channelId, int i) {
        this.parentId = channelId;
        this.id = i;
    }

    public String asLongText() {
        return this.parentId.asLongText() + '/' + this.id;
    }

    public String asShortText() {
        return this.parentId.asShortText() + '/' + this.id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Http2StreamChannelId)) {
            return false;
        }
        Http2StreamChannelId http2StreamChannelId = (Http2StreamChannelId) obj;
        return this.id == http2StreamChannelId.id && this.parentId.equals(http2StreamChannelId.parentId);
    }

    public int hashCode() {
        return (this.id * 31) + this.parentId.hashCode();
    }

    public String toString() {
        return asShortText();
    }

    public int compareTo(ChannelId channelId) {
        if (!(channelId instanceof Http2StreamChannelId)) {
            return this.parentId.compareTo(channelId);
        }
        Http2StreamChannelId http2StreamChannelId = (Http2StreamChannelId) channelId;
        int compareTo = this.parentId.compareTo(http2StreamChannelId.parentId);
        return compareTo == 0 ? this.id - http2StreamChannelId.id : compareTo;
    }
}
