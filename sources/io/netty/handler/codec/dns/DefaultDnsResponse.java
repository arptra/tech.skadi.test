package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;

public class DefaultDnsResponse extends AbstractDnsMessage implements DnsResponse {
    private boolean authoritativeAnswer;
    private DnsResponseCode code;
    private boolean recursionAvailable;
    private boolean truncated;

    public DefaultDnsResponse(int i) {
        this(i, DnsOpCode.QUERY, DnsResponseCode.NOERROR);
    }

    public DnsResponseCode code() {
        return this.code;
    }

    public boolean isAuthoritativeAnswer() {
        return this.authoritativeAnswer;
    }

    public boolean isRecursionAvailable() {
        return this.recursionAvailable;
    }

    public boolean isTruncated() {
        return this.truncated;
    }

    public DnsResponse setAuthoritativeAnswer(boolean z) {
        this.authoritativeAnswer = z;
        return this;
    }

    public DnsResponse setCode(DnsResponseCode dnsResponseCode) {
        this.code = (DnsResponseCode) ObjectUtil.checkNotNull(dnsResponseCode, "code");
        return this;
    }

    public DnsResponse setRecursionAvailable(boolean z) {
        this.recursionAvailable = z;
        return this;
    }

    public DnsResponse setTruncated(boolean z) {
        this.truncated = z;
        return this;
    }

    public String toString() {
        return DnsMessageUtil.appendResponse(new StringBuilder(128), this).toString();
    }

    public DefaultDnsResponse(int i, DnsOpCode dnsOpCode) {
        this(i, dnsOpCode, DnsResponseCode.NOERROR);
    }

    public DnsResponse setId(int i) {
        return (DnsResponse) super.setId(i);
    }

    public DnsResponse setOpCode(DnsOpCode dnsOpCode) {
        return (DnsResponse) super.setOpCode(dnsOpCode);
    }

    public DnsResponse setRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DnsResponse) super.setRecord(dnsSection, dnsRecord);
    }

    public DnsResponse setRecursionDesired(boolean z) {
        return (DnsResponse) super.setRecursionDesired(z);
    }

    public DnsResponse setZ(int i) {
        return (DnsResponse) super.setZ(i);
    }

    public DefaultDnsResponse(int i, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode) {
        super(i, dnsOpCode);
        setCode(dnsResponseCode);
    }

    public DnsResponse addRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DnsResponse) super.addRecord(dnsSection, dnsRecord);
    }

    public DnsResponse clear(DnsSection dnsSection) {
        return (DnsResponse) super.clear(dnsSection);
    }

    public DnsResponse addRecord(DnsSection dnsSection, int i, DnsRecord dnsRecord) {
        return (DnsResponse) super.addRecord(dnsSection, i, dnsRecord);
    }

    public DnsResponse clear() {
        return (DnsResponse) super.clear();
    }

    public DnsResponse retain() {
        return (DnsResponse) super.retain();
    }

    public DnsResponse touch() {
        return (DnsResponse) super.touch();
    }

    public DnsResponse retain(int i) {
        return (DnsResponse) super.retain(i);
    }

    public DnsResponse touch(Object obj) {
        return (DnsResponse) super.touch(obj);
    }
}
