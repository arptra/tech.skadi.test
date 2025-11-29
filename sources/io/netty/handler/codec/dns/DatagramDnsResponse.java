package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;
import java.net.InetSocketAddress;

public class DatagramDnsResponse extends DefaultDnsResponse implements AddressedEnvelope<DatagramDnsResponse, InetSocketAddress> {
    private final InetSocketAddress recipient;
    private final InetSocketAddress sender;

    public DatagramDnsResponse(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i) {
        this(inetSocketAddress, inetSocketAddress2, i, DnsOpCode.QUERY, DnsResponseCode.NOERROR);
    }

    public DatagramDnsResponse content() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || !(obj instanceof AddressedEnvelope)) {
            return false;
        }
        AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
        if (sender() == null) {
            if (addressedEnvelope.sender() != null) {
                return false;
            }
        } else if (!sender().equals(addressedEnvelope.sender())) {
            return false;
        }
        return recipient() == null ? addressedEnvelope.recipient() == null : recipient().equals(addressedEnvelope.recipient());
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        if (sender() != null) {
            hashCode = (hashCode * 31) + sender().hashCode();
        }
        return recipient() != null ? (hashCode * 31) + recipient().hashCode() : hashCode;
    }

    public DatagramDnsResponse(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i, DnsOpCode dnsOpCode) {
        this(inetSocketAddress, inetSocketAddress2, i, dnsOpCode, DnsResponseCode.NOERROR);
    }

    public InetSocketAddress recipient() {
        return this.recipient;
    }

    public InetSocketAddress sender() {
        return this.sender;
    }

    public DatagramDnsResponse setAuthoritativeAnswer(boolean z) {
        return (DatagramDnsResponse) super.setAuthoritativeAnswer(z);
    }

    public DatagramDnsResponse setCode(DnsResponseCode dnsResponseCode) {
        return (DatagramDnsResponse) super.setCode(dnsResponseCode);
    }

    public DatagramDnsResponse setRecursionAvailable(boolean z) {
        return (DatagramDnsResponse) super.setRecursionAvailable(z);
    }

    public DatagramDnsResponse setTruncated(boolean z) {
        return (DatagramDnsResponse) super.setTruncated(z);
    }

    public DatagramDnsResponse(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode) {
        super(i, dnsOpCode, dnsResponseCode);
        if (inetSocketAddress2 == null && inetSocketAddress == null) {
            throw new NullPointerException("recipient and sender");
        }
        this.sender = inetSocketAddress;
        this.recipient = inetSocketAddress2;
    }

    public DatagramDnsResponse setId(int i) {
        return (DatagramDnsResponse) super.setId(i);
    }

    public DatagramDnsResponse setOpCode(DnsOpCode dnsOpCode) {
        return (DatagramDnsResponse) super.setOpCode(dnsOpCode);
    }

    public DatagramDnsResponse setRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DatagramDnsResponse) super.setRecord(dnsSection, dnsRecord);
    }

    public DatagramDnsResponse setRecursionDesired(boolean z) {
        return (DatagramDnsResponse) super.setRecursionDesired(z);
    }

    public DatagramDnsResponse setZ(int i) {
        return (DatagramDnsResponse) super.setZ(i);
    }

    public DatagramDnsResponse addRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DatagramDnsResponse) super.addRecord(dnsSection, dnsRecord);
    }

    public DatagramDnsResponse clear(DnsSection dnsSection) {
        return (DatagramDnsResponse) super.clear(dnsSection);
    }

    public DatagramDnsResponse addRecord(DnsSection dnsSection, int i, DnsRecord dnsRecord) {
        return (DatagramDnsResponse) super.addRecord(dnsSection, i, dnsRecord);
    }

    public DatagramDnsResponse clear() {
        return (DatagramDnsResponse) super.clear();
    }

    public DatagramDnsResponse retain() {
        return (DatagramDnsResponse) super.retain();
    }

    public DatagramDnsResponse touch() {
        return (DatagramDnsResponse) super.touch();
    }

    public DatagramDnsResponse retain(int i) {
        return (DatagramDnsResponse) super.retain(i);
    }

    public DatagramDnsResponse touch(Object obj) {
        return (DatagramDnsResponse) super.touch(obj);
    }
}
