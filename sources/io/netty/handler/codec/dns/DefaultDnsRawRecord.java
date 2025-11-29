package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultDnsRawRecord extends AbstractDnsRecord implements DnsRawRecord {
    private final ByteBuf content;

    public DefaultDnsRawRecord(String str, DnsRecordType dnsRecordType, long j, ByteBuf byteBuf) {
        this(str, dnsRecordType, 1, j, byteBuf);
    }

    public ByteBuf content() {
        return this.content;
    }

    public int refCnt() {
        return content().refCnt();
    }

    public boolean release() {
        return content().release();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName((Object) this));
        sb.append('(');
        DnsRecordType type = type();
        if (type != DnsRecordType.OPT) {
            sb.append(name().isEmpty() ? "<root>" : name());
            sb.append(' ');
            sb.append(timeToLive());
            sb.append(' ');
            StringBuilder appendRecordClass = DnsMessageUtil.appendRecordClass(sb, dnsClass());
            appendRecordClass.append(' ');
            appendRecordClass.append(type.name());
        } else {
            sb.append("OPT flags:");
            sb.append(timeToLive());
            sb.append(" udp:");
            sb.append(dnsClass());
        }
        sb.append(' ');
        sb.append(content().readableBytes());
        sb.append("B)");
        return sb.toString();
    }

    public DefaultDnsRawRecord(String str, DnsRecordType dnsRecordType, int i, long j, ByteBuf byteBuf) {
        super(str, dnsRecordType, i, j);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
    }

    public DnsRawRecord copy() {
        return replace(content().copy());
    }

    public DnsRawRecord duplicate() {
        return replace(content().duplicate());
    }

    public boolean release(int i) {
        return content().release(i);
    }

    public DnsRawRecord replace(ByteBuf byteBuf) {
        return new DefaultDnsRawRecord(name(), type(), dnsClass(), timeToLive(), byteBuf);
    }

    public DnsRawRecord retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public DnsRawRecord retain() {
        content().retain();
        return this;
    }

    public DnsRawRecord touch() {
        content().touch();
        return this;
    }

    public DnsRawRecord retain(int i) {
        content().retain(i);
        return this;
    }

    public DnsRawRecord touch(Object obj) {
        content().touch(obj);
        return this;
    }
}
