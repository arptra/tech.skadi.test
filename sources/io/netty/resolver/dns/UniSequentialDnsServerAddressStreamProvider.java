package io.netty.resolver.dns;

import io.netty.util.internal.ObjectUtil;

abstract class UniSequentialDnsServerAddressStreamProvider implements DnsServerAddressStreamProvider {
    private final DnsServerAddresses addresses;

    public UniSequentialDnsServerAddressStreamProvider(DnsServerAddresses dnsServerAddresses) {
        this.addresses = (DnsServerAddresses) ObjectUtil.checkNotNull(dnsServerAddresses, "addresses");
    }

    public final DnsServerAddressStream nameServerAddressStream(String str) {
        return this.addresses.stream();
    }
}
