package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

final class RotationalDnsServerAddresses extends DefaultDnsServerAddresses {
    private static final AtomicIntegerFieldUpdater<RotationalDnsServerAddresses> startIdxUpdater = AtomicIntegerFieldUpdater.newUpdater(RotationalDnsServerAddresses.class, "startIdx");
    private volatile int startIdx;

    public RotationalDnsServerAddresses(List<InetSocketAddress> list) {
        super("rotational", list);
    }

    public DnsServerAddressStream stream() {
        int i;
        int i2;
        do {
            i = this.startIdx;
            i2 = i + 1;
            if (i2 >= this.addresses.size()) {
                i2 = 0;
            }
        } while (!startIdxUpdater.compareAndSet(this, i, i2));
        return new SequentialDnsServerAddressStream(this.addresses, i);
    }
}
