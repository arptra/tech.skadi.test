package io.netty.channel.udt.nio;

import com.barchart.udt.SocketUDT;
import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.ChannelUDT;
import com.barchart.udt.nio.KindUDT;
import com.barchart.udt.nio.RendezvousChannelUDT;
import com.barchart.udt.nio.SelectorProviderUDT;
import com.barchart.udt.nio.ServerSocketChannelUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFactory;
import io.netty.channel.udt.UdtChannel;
import io.netty.channel.udt.UdtServerChannel;
import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;

@Deprecated
public final class NioUdtProvider<T extends UdtChannel> implements ChannelFactory<T> {
    public static final ChannelFactory<UdtServerChannel> BYTE_ACCEPTOR = new NioUdtProvider(TypeUDT.STREAM, KindUDT.ACCEPTOR);
    public static final ChannelFactory<UdtChannel> BYTE_CONNECTOR = new NioUdtProvider(TypeUDT.STREAM, KindUDT.CONNECTOR);
    public static final SelectorProvider BYTE_PROVIDER = SelectorProviderUDT.STREAM;
    public static final ChannelFactory<UdtChannel> BYTE_RENDEZVOUS = new NioUdtProvider(TypeUDT.STREAM, KindUDT.RENDEZVOUS);
    public static final ChannelFactory<UdtServerChannel> MESSAGE_ACCEPTOR = new NioUdtProvider(TypeUDT.DATAGRAM, KindUDT.ACCEPTOR);
    public static final ChannelFactory<UdtChannel> MESSAGE_CONNECTOR = new NioUdtProvider(TypeUDT.DATAGRAM, KindUDT.CONNECTOR);
    public static final SelectorProvider MESSAGE_PROVIDER = SelectorProviderUDT.DATAGRAM;
    public static final ChannelFactory<UdtChannel> MESSAGE_RENDEZVOUS = new NioUdtProvider(TypeUDT.DATAGRAM, KindUDT.RENDEZVOUS);
    private final KindUDT kind;
    private final TypeUDT type;

    /* renamed from: io.netty.channel.udt.nio.NioUdtProvider$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$barchart$udt$TypeUDT;
        static final /* synthetic */ int[] $SwitchMap$com$barchart$udt$nio$KindUDT;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        static {
            /*
                com.barchart.udt.nio.KindUDT[] r0 = com.barchart.udt.nio.KindUDT.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$barchart$udt$nio$KindUDT = r0
                r1 = 1
                com.barchart.udt.nio.KindUDT r2 = com.barchart.udt.nio.KindUDT.ACCEPTOR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$barchart$udt$nio$KindUDT     // Catch:{ NoSuchFieldError -> 0x001d }
                com.barchart.udt.nio.KindUDT r3 = com.barchart.udt.nio.KindUDT.CONNECTOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = $SwitchMap$com$barchart$udt$nio$KindUDT     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.barchart.udt.nio.KindUDT r3 = com.barchart.udt.nio.KindUDT.RENDEZVOUS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.barchart.udt.TypeUDT[] r2 = com.barchart.udt.TypeUDT.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$barchart$udt$TypeUDT = r2
                com.barchart.udt.TypeUDT r3 = com.barchart.udt.TypeUDT.DATAGRAM     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$com$barchart$udt$TypeUDT     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.barchart.udt.TypeUDT r2 = com.barchart.udt.TypeUDT.STREAM     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.udt.nio.NioUdtProvider.AnonymousClass1.<clinit>():void");
        }
    }

    private NioUdtProvider(TypeUDT typeUDT, KindUDT kindUDT) {
        this.type = typeUDT;
        this.kind = kindUDT;
    }

    public static ChannelUDT channelUDT(Channel channel) {
        if (channel instanceof NioUdtByteAcceptorChannel) {
            return ((NioUdtByteAcceptorChannel) channel).javaChannel();
        }
        if (channel instanceof NioUdtByteRendezvousChannel) {
            return ((NioUdtByteRendezvousChannel) channel).javaChannel();
        }
        if (channel instanceof NioUdtByteConnectorChannel) {
            return ((NioUdtByteConnectorChannel) channel).javaChannel();
        }
        if (channel instanceof NioUdtMessageAcceptorChannel) {
            return ((NioUdtMessageAcceptorChannel) channel).javaChannel();
        }
        if (channel instanceof NioUdtMessageRendezvousChannel) {
            return ((NioUdtMessageRendezvousChannel) channel).javaChannel();
        }
        if (channel instanceof NioUdtMessageConnectorChannel) {
            return ((NioUdtMessageConnectorChannel) channel).javaChannel();
        }
        return null;
    }

    public static ServerSocketChannelUDT newAcceptorChannelUDT(TypeUDT typeUDT) {
        try {
            return SelectorProviderUDT.from(typeUDT).openServerSocketChannel();
        } catch (IOException e) {
            throw new ChannelException("failed to open a server socket channel", e);
        }
    }

    public static SocketChannelUDT newConnectorChannelUDT(TypeUDT typeUDT) {
        try {
            return SelectorProviderUDT.from(typeUDT).openSocketChannel();
        } catch (IOException e) {
            throw new ChannelException("failed to open a socket channel", e);
        }
    }

    public static RendezvousChannelUDT newRendezvousChannelUDT(TypeUDT typeUDT) {
        try {
            return SelectorProviderUDT.from(typeUDT).openRendezvousChannel();
        } catch (IOException e) {
            throw new ChannelException("failed to open a rendezvous channel", e);
        }
    }

    public static SocketUDT socketUDT(Channel channel) {
        ChannelUDT channelUDT = channelUDT(channel);
        if (channelUDT == null) {
            return null;
        }
        return channelUDT.socketUDT();
    }

    public KindUDT kind() {
        return this.kind;
    }

    public TypeUDT type() {
        return this.type;
    }

    public T newChannel() {
        int i = AnonymousClass1.$SwitchMap$com$barchart$udt$nio$KindUDT[this.kind.ordinal()];
        if (i == 1) {
            int i2 = AnonymousClass1.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
            if (i2 == 1) {
                return new NioUdtMessageAcceptorChannel();
            }
            if (i2 == 2) {
                return new NioUdtByteAcceptorChannel();
            }
            throw new IllegalStateException("wrong type=" + this.type);
        } else if (i == 2) {
            int i3 = AnonymousClass1.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
            if (i3 == 1) {
                return new NioUdtMessageConnectorChannel();
            }
            if (i3 == 2) {
                return new NioUdtByteConnectorChannel();
            }
            throw new IllegalStateException("wrong type=" + this.type);
        } else if (i == 3) {
            int i4 = AnonymousClass1.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
            if (i4 == 1) {
                return new NioUdtMessageRendezvousChannel();
            }
            if (i4 == 2) {
                return new NioUdtByteRendezvousChannel();
            }
            throw new IllegalStateException("wrong type=" + this.type);
        } else {
            throw new IllegalStateException("wrong kind=" + this.kind);
        }
    }
}
