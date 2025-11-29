package io.netty.resolver.dns;

import java.net.InetSocketAddress;

final class SingletonDnsServerAddresses extends DnsServerAddresses {
    /* access modifiers changed from: private */
    public final InetSocketAddress address;
    private final DnsServerAddressStream stream = new DnsServerAddressStream() {
        public DnsServerAddressStream duplicate() {
            return this;
        }

        public InetSocketAddress next() {
            return SingletonDnsServerAddresses.this.address;
        }

        public int size() {
            return 1;
        }

        public String toString() {
            return SingletonDnsServerAddresses.this.toString();
        }
    };

    public SingletonDnsServerAddresses(InetSocketAddress inetSocketAddress) {
        this.address = inetSocketAddress;
    }

    public DnsServerAddressStream stream() {
        return this.stream;
    }

    public String toString() {
        return "singleton(" + this.address + ")";
    }
}
