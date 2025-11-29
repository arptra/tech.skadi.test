package io.netty.channel.udt.nio;

import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.channel.udt.UdtChannel;

@Deprecated
public class NioUdtMessageAcceptorChannel extends NioUdtAcceptorChannel {
    public NioUdtMessageAcceptorChannel() {
        super(TypeUDT.DATAGRAM);
    }

    public UdtChannel newConnectorChannel(SocketChannelUDT socketChannelUDT) {
        return new NioUdtMessageConnectorChannel(this, socketChannelUDT);
    }
}
