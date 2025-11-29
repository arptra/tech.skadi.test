package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Promise;
import java.net.UnknownHostException;
import java.util.List;

final class DnsRecordResolveContext extends DnsResolveContext<DnsRecord> {
    public DnsRecordResolveContext(DnsNameResolver dnsNameResolver, Promise<?> promise, DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream, int i) {
        this(dnsNameResolver, promise, dnsQuestion.name(), dnsQuestion.dnsClass(), new DnsRecordType[]{dnsQuestion.type()}, dnsRecordArr, dnsServerAddressStream, i);
    }

    public void cache(String str, DnsRecord[] dnsRecordArr, DnsRecord dnsRecord, DnsRecord dnsRecord2) {
    }

    public DnsCnameCache cnameCache() {
        return NoopDnsCnameCache.INSTANCE;
    }

    public List<DnsRecord> filterResults(List<DnsRecord> list) {
        return list;
    }

    public boolean isCompleteEarly(DnsRecord dnsRecord) {
        return false;
    }

    public boolean isDuplicateAllowed() {
        return true;
    }

    public DnsResolveContext<DnsRecord> newResolverContext(DnsNameResolver dnsNameResolver, Promise<?> promise, String str, int i, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream, int i2) {
        return new DnsRecordResolveContext(dnsNameResolver, promise, str, i, dnsRecordTypeArr, dnsRecordArr, dnsServerAddressStream, i2);
    }

    public void cache(String str, DnsRecord[] dnsRecordArr, UnknownHostException unknownHostException) {
    }

    public DnsRecord convertRecord(DnsRecord dnsRecord, String str, DnsRecord[] dnsRecordArr, EventLoop eventLoop) {
        return (DnsRecord) ReferenceCountUtil.retain(dnsRecord);
    }

    private DnsRecordResolveContext(DnsNameResolver dnsNameResolver, Promise<?> promise, String str, int i, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream, int i2) {
        super(dnsNameResolver, promise, str, i, dnsRecordTypeArr, dnsRecordArr, dnsServerAddressStream, i2);
    }
}
