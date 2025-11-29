package io.netty.resolver.dns;

import io.netty.util.internal.PlatformDependent;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.List;

final class ShuffledDnsServerAddressStream implements DnsServerAddressStream {
    private final List<InetSocketAddress> addresses;
    private int i;

    public ShuffledDnsServerAddressStream(List<InetSocketAddress> list) {
        this.addresses = list;
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(this.addresses, PlatformDependent.threadLocalRandom());
    }

    public InetSocketAddress next() {
        int i2 = this.i;
        InetSocketAddress inetSocketAddress = this.addresses.get(i2);
        int i3 = i2 + 1;
        if (i3 < this.addresses.size()) {
            this.i = i3;
        } else {
            this.i = 0;
            shuffle();
        }
        return inetSocketAddress;
    }

    public int size() {
        return this.addresses.size();
    }

    public String toString() {
        return SequentialDnsServerAddressStream.toString("shuffled", this.i, this.addresses);
    }

    public ShuffledDnsServerAddressStream duplicate() {
        return new ShuffledDnsServerAddressStream(this.addresses, this.i);
    }

    private ShuffledDnsServerAddressStream(List<InetSocketAddress> list, int i2) {
        this.addresses = list;
        this.i = i2;
    }
}
