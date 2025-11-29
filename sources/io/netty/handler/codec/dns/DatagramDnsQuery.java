package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;
import java.net.InetSocketAddress;

public class DatagramDnsQuery extends DefaultDnsQuery implements AddressedEnvelope<DatagramDnsQuery, InetSocketAddress> {
    private final InetSocketAddress recipient;
    private final InetSocketAddress sender;

    public DatagramDnsQuery(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i) {
        this(inetSocketAddress, inetSocketAddress2, i, DnsOpCode.QUERY);
    }

    public DatagramDnsQuery content() {
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
        if (recipient() == null) {
            if (addressedEnvelope.recipient() != null) {
                return false;
            }
        } else if (!recipient().equals(addressedEnvelope.recipient())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        if (sender() != null) {
            hashCode = (hashCode * 31) + sender().hashCode();
        }
        return recipient() != null ? (hashCode * 31) + recipient().hashCode() : hashCode;
    }

    public DatagramDnsQuery(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i, DnsOpCode dnsOpCode) {
        super(i, dnsOpCode);
        if (inetSocketAddress2 == null && inetSocketAddress == null) {
            throw new NullPointerException("recipient and sender");
        }
        this.sender = inetSocketAddress;
        this.recipient = inetSocketAddress2;
    }

    public InetSocketAddress recipient() {
        return this.recipient;
    }

    public InetSocketAddress sender() {
        return this.sender;
    }

    public DatagramDnsQuery setId(int i) {
        return (DatagramDnsQuery) super.setId(i);
    }

    public DatagramDnsQuery setOpCode(DnsOpCode dnsOpCode) {
        return (DatagramDnsQuery) super.setOpCode(dnsOpCode);
    }

    public DatagramDnsQuery setRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DatagramDnsQuery) super.setRecord(dnsSection, dnsRecord);
    }

    public DatagramDnsQuery setRecursionDesired(boolean z) {
        return (DatagramDnsQuery) super.setRecursionDesired(z);
    }

    public DatagramDnsQuery setZ(int i) {
        return (DatagramDnsQuery) super.setZ(i);
    }

    public DatagramDnsQuery addRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DatagramDnsQuery) super.addRecord(dnsSection, dnsRecord);
    }

    public DatagramDnsQuery clear(DnsSection dnsSection) {
        return (DatagramDnsQuery) super.clear(dnsSection);
    }

    public DatagramDnsQuery addRecord(DnsSection dnsSection, int i, DnsRecord dnsRecord) {
        return (DatagramDnsQuery) super.addRecord(dnsSection, i, dnsRecord);
    }

    public DatagramDnsQuery clear() {
        return (DatagramDnsQuery) super.clear();
    }

    public DatagramDnsQuery retain() {
        return (DatagramDnsQuery) super.retain();
    }

    public DatagramDnsQuery touch() {
        return (DatagramDnsQuery) super.touch();
    }

    public DatagramDnsQuery retain(int i) {
        return (DatagramDnsQuery) super.retain(i);
    }

    public DatagramDnsQuery touch(Object obj) {
        return (DatagramDnsQuery) super.touch(obj);
    }
}
