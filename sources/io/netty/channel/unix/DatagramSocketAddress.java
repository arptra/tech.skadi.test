package io.netty.channel.unix;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public final class DatagramSocketAddress extends InetSocketAddress {
    private static final long serialVersionUID = 3094819287843178401L;
    private final DatagramSocketAddress localAddress;
    private final int receivedAmount;

    public DatagramSocketAddress(byte[] bArr, int i, int i2, int i3, DatagramSocketAddress datagramSocketAddress) throws UnknownHostException {
        super(newAddress(bArr, i), i2);
        this.receivedAmount = i3;
        this.localAddress = datagramSocketAddress;
    }

    private static InetAddress newAddress(byte[] bArr, int i) throws UnknownHostException {
        return bArr.length == 4 ? InetAddress.getByAddress(bArr) : Inet6Address.getByAddress((String) null, bArr, i);
    }

    public DatagramSocketAddress localAddress() {
        return this.localAddress;
    }

    public int receivedAmount() {
        return this.receivedAmount;
    }
}
