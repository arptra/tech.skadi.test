package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;

public class DefaultSpdySynReplyFrame extends DefaultSpdyHeadersFrame implements SpdySynReplyFrame {
    public DefaultSpdySynReplyFrame(int i) {
        super(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName((Object) this));
        sb.append("(last: ");
        sb.append(isLast());
        sb.append(')');
        String str = StringUtil.NEWLINE;
        sb.append(str);
        sb.append("--> Stream-ID = ");
        sb.append(streamId());
        sb.append(str);
        sb.append("--> Headers:");
        sb.append(str);
        appendHeaders(sb);
        sb.setLength(sb.length() - str.length());
        return sb.toString();
    }

    public DefaultSpdySynReplyFrame(int i, boolean z) {
        super(i, z);
    }

    public SpdySynReplyFrame setInvalid() {
        super.setInvalid();
        return this;
    }

    public SpdySynReplyFrame setLast(boolean z) {
        super.setLast(z);
        return this;
    }

    public SpdySynReplyFrame setStreamId(int i) {
        super.setStreamId(i);
        return this;
    }
}
