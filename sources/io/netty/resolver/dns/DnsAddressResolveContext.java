package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.util.concurrent.Promise;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

final class DnsAddressResolveContext extends DnsResolveContext<InetAddress> {
    private final AuthoritativeDnsServerCache authoritativeDnsServerCache;
    private final boolean completeEarlyIfPossible;
    private final DnsCache resolveCache;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DnsAddressResolveContext(DnsNameResolver dnsNameResolver, Promise<?> promise, String str, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream, int i, DnsCache dnsCache, AuthoritativeDnsServerCache authoritativeDnsServerCache2, boolean z) {
        super(dnsNameResolver, promise, str, 1, dnsNameResolver.resolveRecordTypes(), dnsRecordArr, dnsServerAddressStream, i);
        this.resolveCache = dnsCache;
        this.authoritativeDnsServerCache = authoritativeDnsServerCache2;
        this.completeEarlyIfPossible = z;
    }

    public AuthoritativeDnsServerCache authoritativeDnsServerCache() {
        return this.authoritativeDnsServerCache;
    }

    public void doSearchDomainQuery(String str, Promise<List<InetAddress>> promise) {
        if (!DnsNameResolver.doResolveAllCached(str, this.additionals, promise, this.resolveCache, this.parent.resolvedInternetProtocolFamiliesUnsafe())) {
            super.doSearchDomainQuery(str, promise);
        }
    }

    public List<InetAddress> filterResults(List<InetAddress> list) {
        Collections.sort(list, PreferredAddressTypeComparator.comparator(this.parent.preferredAddressType()));
        return list;
    }

    public boolean isDuplicateAllowed() {
        return false;
    }

    public DnsResolveContext<InetAddress> newResolverContext(DnsNameResolver dnsNameResolver, Promise<?> promise, String str, int i, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream, int i2) {
        return new DnsAddressResolveContext(dnsNameResolver, promise, str, dnsRecordArr, dnsServerAddressStream, i2, this.resolveCache, this.authoritativeDnsServerCache, this.completeEarlyIfPossible);
    }

    public DnsCache resolveCache() {
        return this.resolveCache;
    }

    public void cache(String str, DnsRecord[] dnsRecordArr, DnsRecord dnsRecord, InetAddress inetAddress) {
        this.resolveCache.cache(str, dnsRecordArr, inetAddress, dnsRecord.timeToLive(), this.parent.ch.eventLoop());
    }

    public InetAddress convertRecord(DnsRecord dnsRecord, String str, DnsRecord[] dnsRecordArr, EventLoop eventLoop) {
        return DnsAddressDecoder.decodeAddress(dnsRecord, str, this.parent.isDecodeIdn());
    }

    public boolean isCompleteEarly(InetAddress inetAddress) {
        return this.completeEarlyIfPossible && this.parent.preferredAddressType().addressType() == inetAddress.getClass();
    }

    public void cache(String str, DnsRecord[] dnsRecordArr, UnknownHostException unknownHostException) {
        this.resolveCache.cache(str, dnsRecordArr, unknownHostException, this.parent.ch.eventLoop());
    }
}
