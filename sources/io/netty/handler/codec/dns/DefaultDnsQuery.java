package io.netty.handler.codec.dns;

public class DefaultDnsQuery extends AbstractDnsMessage implements DnsQuery {
    public DefaultDnsQuery(int i) {
        super(i);
    }

    public String toString() {
        return DnsMessageUtil.appendQuery(new StringBuilder(128), this).toString();
    }

    public DefaultDnsQuery(int i, DnsOpCode dnsOpCode) {
        super(i, dnsOpCode);
    }

    public DnsQuery setId(int i) {
        return (DnsQuery) super.setId(i);
    }

    public DnsQuery setOpCode(DnsOpCode dnsOpCode) {
        return (DnsQuery) super.setOpCode(dnsOpCode);
    }

    public DnsQuery setRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DnsQuery) super.setRecord(dnsSection, dnsRecord);
    }

    public DnsQuery setRecursionDesired(boolean z) {
        return (DnsQuery) super.setRecursionDesired(z);
    }

    public DnsQuery setZ(int i) {
        return (DnsQuery) super.setZ(i);
    }

    public DnsQuery addRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DnsQuery) super.addRecord(dnsSection, dnsRecord);
    }

    public DnsQuery clear(DnsSection dnsSection) {
        return (DnsQuery) super.clear(dnsSection);
    }

    public DnsQuery addRecord(DnsSection dnsSection, int i, DnsRecord dnsRecord) {
        return (DnsQuery) super.addRecord(dnsSection, i, dnsRecord);
    }

    public DnsQuery clear() {
        return (DnsQuery) super.clear();
    }

    public DnsQuery retain() {
        return (DnsQuery) super.retain();
    }

    public DnsQuery touch() {
        return (DnsQuery) super.touch();
    }

    public DnsQuery retain(int i) {
        return (DnsQuery) super.retain(i);
    }

    public DnsQuery touch(Object obj) {
        return (DnsQuery) super.touch(obj);
    }
}
