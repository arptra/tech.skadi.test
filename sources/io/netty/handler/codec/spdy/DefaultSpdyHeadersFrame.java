package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;
import java.util.Map;

public class DefaultSpdyHeadersFrame extends DefaultSpdyStreamFrame implements SpdyHeadersFrame {
    private final SpdyHeaders headers;
    private boolean invalid;
    private boolean truncated;

    public DefaultSpdyHeadersFrame(int i) {
        this(i, true);
    }

    public void appendHeaders(StringBuilder sb) {
        for (Map.Entry entry : headers()) {
            sb.append("    ");
            sb.append((CharSequence) entry.getKey());
            sb.append(": ");
            sb.append((CharSequence) entry.getValue());
            sb.append(StringUtil.NEWLINE);
        }
    }

    public SpdyHeaders headers() {
        return this.headers;
    }

    public boolean isInvalid() {
        return this.invalid;
    }

    public boolean isTruncated() {
        return this.truncated;
    }

    public SpdyHeadersFrame setInvalid() {
        this.invalid = true;
        return this;
    }

    public SpdyHeadersFrame setTruncated() {
        this.truncated = true;
        return this;
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

    public DefaultSpdyHeadersFrame(int i, boolean z) {
        super(i);
        this.headers = new DefaultSpdyHeaders(z);
    }

    public SpdyHeadersFrame setLast(boolean z) {
        super.setLast(z);
        return this;
    }

    public SpdyHeadersFrame setStreamId(int i) {
        super.setStreamId(i);
        return this;
    }
}
