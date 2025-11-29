package io.netty.resolver.dns;

import java.util.List;

public final class MultiDnsServerAddressStreamProvider implements DnsServerAddressStreamProvider {
    private final DnsServerAddressStreamProvider[] providers;

    public MultiDnsServerAddressStreamProvider(List<DnsServerAddressStreamProvider> list) {
        this.providers = (DnsServerAddressStreamProvider[]) list.toArray(new DnsServerAddressStreamProvider[0]);
    }

    public DnsServerAddressStream nameServerAddressStream(String str) {
        for (DnsServerAddressStreamProvider nameServerAddressStream : this.providers) {
            DnsServerAddressStream nameServerAddressStream2 = nameServerAddressStream.nameServerAddressStream(str);
            if (nameServerAddressStream2 != null) {
                return nameServerAddressStream2;
            }
        }
        return null;
    }

    public MultiDnsServerAddressStreamProvider(DnsServerAddressStreamProvider... dnsServerAddressStreamProviderArr) {
        this.providers = (DnsServerAddressStreamProvider[]) dnsServerAddressStreamProviderArr.clone();
    }
}
