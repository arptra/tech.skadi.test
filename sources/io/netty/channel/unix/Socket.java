package io.netty.channel.unix;

import io.netty.channel.ChannelException;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;

public class Socket extends FileDescriptor {
    @Deprecated
    public static final int UDS_SUN_PATH_SIZE = 100;
    private static volatile boolean isIpv6Preferred;
    protected final boolean ipv6;

    public Socket(int i) {
        super(i);
        this.ipv6 = isIPv6(i);
    }

    private static native int accept(int i, byte[] bArr);

    private static native int bind(int i, boolean z, byte[] bArr, int i2, int i3);

    private static native int bindDomainSocket(int i, byte[] bArr);

    private static native int connect(int i, boolean z, byte[] bArr, int i2, int i3);

    private static native int connectDomainSocket(int i, byte[] bArr);

    private static native int disconnect(int i, boolean z);

    private static native int finishConnect(int i);

    private static native int getIntOpt(int i, int i2, int i3) throws IOException;

    private static native void getRawOptAddress(int i, int i2, int i3, long j, int i4) throws IOException;

    private static native void getRawOptArray(int i, int i2, int i3, byte[] bArr, int i4, int i5) throws IOException;

    private static native int getReceiveBufferSize(int i) throws IOException;

    private static native int getSendBufferSize(int i) throws IOException;

    private static native int getSoError(int i) throws IOException;

    private static native int getSoLinger(int i) throws IOException;

    private static native int getTrafficClass(int i, boolean z) throws IOException;

    public static void initialize() {
        isIpv6Preferred = isIPv6Preferred0(NetUtil.isIpV4StackPreferred());
    }

    private static native int isBroadcast(int i) throws IOException;

    private static native boolean isIPv6(int i);

    public static boolean isIPv6Preferred() {
        return isIpv6Preferred;
    }

    private static native boolean isIPv6Preferred0(boolean z);

    private static native int isKeepAlive(int i) throws IOException;

    private static native int isReuseAddress(int i) throws IOException;

    private static native int isReusePort(int i) throws IOException;

    private static native int isTcpNoDelay(int i) throws IOException;

    private static native int listen(int i, int i2);

    private static native byte[] localAddress(int i);

    private static native int msgFastopen();

    public static Socket newSocketDgram() {
        return new Socket(newSocketDgram0());
    }

    public static int newSocketDgram0() {
        return newSocketDgram0(isIPv6Preferred());
    }

    private static native int newSocketDgramFd(boolean z);

    public static Socket newSocketDomain() {
        return new Socket(newSocketDomain0());
    }

    public static int newSocketDomain0() {
        int newSocketDomainFd = newSocketDomainFd();
        if (newSocketDomainFd >= 0) {
            return newSocketDomainFd;
        }
        throw new ChannelException((Throwable) Errors.newIOException("newSocketDomain", newSocketDomainFd));
    }

    public static Socket newSocketDomainDgram() {
        return new Socket(newSocketDomainDgram0());
    }

    public static int newSocketDomainDgram0() {
        int newSocketDomainDgramFd = newSocketDomainDgramFd();
        if (newSocketDomainDgramFd >= 0) {
            return newSocketDomainDgramFd;
        }
        throw new ChannelException((Throwable) Errors.newIOException("newSocketDomainDgram", newSocketDomainDgramFd));
    }

    private static native int newSocketDomainDgramFd();

    private static native int newSocketDomainFd();

    public static Socket newSocketStream() {
        return new Socket(newSocketStream0());
    }

    public static int newSocketStream0() {
        return newSocketStream0(isIPv6Preferred());
    }

    private static native int newSocketStreamFd(boolean z);

    private static native int recv(int i, ByteBuffer byteBuffer, int i2, int i3);

    private static native int recvAddress(int i, long j, int i2, int i3);

    private static native int recvFd(int i);

    private static native DatagramSocketAddress recvFrom(int i, ByteBuffer byteBuffer, int i2, int i3) throws IOException;

    private static native DatagramSocketAddress recvFromAddress(int i, long j, int i2, int i3) throws IOException;

    private static native DomainDatagramSocketAddress recvFromAddressDomainSocket(int i, long j, int i2, int i3) throws IOException;

    private static native DomainDatagramSocketAddress recvFromDomainSocket(int i, ByteBuffer byteBuffer, int i2, int i3) throws IOException;

    private static native byte[] remoteAddress(int i);

    private static native int send(int i, ByteBuffer byteBuffer, int i2, int i3);

    private static native int sendAddress(int i, long j, int i2, int i3);

    private static native int sendFd(int i, int i2);

    private static native int sendTo(int i, boolean z, ByteBuffer byteBuffer, int i2, int i3, byte[] bArr, int i4, int i5, int i6);

    private static native int sendToAddress(int i, boolean z, long j, int i2, int i3, byte[] bArr, int i4, int i5, int i6);

    private static native int sendToAddressDomainSocket(int i, long j, int i2, int i3, byte[] bArr);

    private static native int sendToAddresses(int i, boolean z, long j, int i2, byte[] bArr, int i3, int i4, int i5);

    private static native int sendToAddressesDomainSocket(int i, long j, int i2, byte[] bArr);

    private static native int sendToDomainSocket(int i, ByteBuffer byteBuffer, int i2, int i3, byte[] bArr);

    private static native void setBroadcast(int i, int i2) throws IOException;

    private static native void setIntOpt(int i, int i2, int i3, int i4) throws IOException;

    private static native void setKeepAlive(int i, int i2) throws IOException;

    private static native void setRawOptAddress(int i, int i2, int i3, long j, int i4) throws IOException;

    private static native void setRawOptArray(int i, int i2, int i3, byte[] bArr, int i4, int i5) throws IOException;

    private static native void setReceiveBufferSize(int i, int i2) throws IOException;

    private static native void setReuseAddress(int i, int i2) throws IOException;

    private static native void setReusePort(int i, int i2) throws IOException;

    private static native void setSendBufferSize(int i, int i2) throws IOException;

    private static native void setSoLinger(int i, int i2) throws IOException;

    private static native void setTcpNoDelay(int i, int i2) throws IOException;

    private static native void setTrafficClass(int i, boolean z, int i2) throws IOException;

    public static boolean shouldUseIpv6(InternetProtocolFamily internetProtocolFamily) {
        return internetProtocolFamily == null ? isIPv6Preferred() : internetProtocolFamily == InternetProtocolFamily.IPv6;
    }

    private static native int shutdown(int i, boolean z, boolean z2);

    private boolean useIpv6(InetAddress inetAddress) {
        return useIpv6(this, inetAddress);
    }

    public final int accept(byte[] bArr) throws IOException {
        int accept = accept(this.fd, bArr);
        if (accept >= 0) {
            return accept;
        }
        if (accept == Errors.ERRNO_EAGAIN_NEGATIVE || accept == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return -1;
        }
        throw Errors.newIOException("accept", accept);
    }

    public final void bind(SocketAddress socketAddress) throws IOException {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            InetAddress address = inetSocketAddress.getAddress();
            NativeInetAddress newInstance = NativeInetAddress.newInstance(address);
            int bind = bind(this.fd, useIpv6(address), newInstance.address, newInstance.scopeId, inetSocketAddress.getPort());
            if (bind < 0) {
                throw Errors.newIOException("bind", bind);
            }
        } else if (socketAddress instanceof DomainSocketAddress) {
            int bindDomainSocket = bindDomainSocket(this.fd, ((DomainSocketAddress) socketAddress).path().getBytes(CharsetUtil.UTF_8));
            if (bindDomainSocket < 0) {
                throw Errors.newIOException("bind", bindDomainSocket);
            }
        } else {
            throw new Error("Unexpected SocketAddress implementation " + socketAddress);
        }
    }

    public final boolean connect(SocketAddress socketAddress) throws IOException {
        int i;
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            InetAddress address = inetSocketAddress.getAddress();
            NativeInetAddress newInstance = NativeInetAddress.newInstance(address);
            i = connect(this.fd, useIpv6(address), newInstance.address, newInstance.scopeId, inetSocketAddress.getPort());
        } else if (socketAddress instanceof DomainSocketAddress) {
            i = connectDomainSocket(this.fd, ((DomainSocketAddress) socketAddress).path().getBytes(CharsetUtil.UTF_8));
        } else {
            throw new Error("Unexpected SocketAddress implementation " + socketAddress);
        }
        if (i < 0) {
            return Errors.handleConnectErrno("connect", i);
        }
        return true;
    }

    public final void disconnect() throws IOException {
        int disconnect = disconnect(this.fd, this.ipv6);
        if (disconnect < 0) {
            Errors.handleConnectErrno("disconnect", disconnect);
        }
    }

    public final boolean finishConnect() throws IOException {
        int finishConnect = finishConnect(this.fd);
        if (finishConnect < 0) {
            return Errors.handleConnectErrno("finishConnect", finishConnect);
        }
        return true;
    }

    public int getIntOpt(int i, int i2) throws IOException {
        return getIntOpt(this.fd, i, i2);
    }

    public void getRawOpt(int i, int i2, ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBuffer2 = byteBuffer;
        if (byteBuffer.isDirect()) {
            int i3 = i;
            int i4 = i2;
            getRawOptAddress(this.fd, i3, i4, ((long) byteBuffer.position()) + Buffer.memoryAddress(byteBuffer), byteBuffer.remaining());
        } else if (byteBuffer.hasArray()) {
            getRawOptArray(this.fd, i, i2, byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
        } else {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            getRawOptArray(this.fd, i, i2, bArr, 0, remaining);
            byteBuffer2.put(bArr);
        }
        byteBuffer2.position(byteBuffer.limit());
    }

    public final int getReceiveBufferSize() throws IOException {
        return getReceiveBufferSize(this.fd);
    }

    public final int getSendBufferSize() throws IOException {
        return getSendBufferSize(this.fd);
    }

    public final int getSoError() throws IOException {
        return getSoError(this.fd);
    }

    public final int getSoLinger() throws IOException {
        return getSoLinger(this.fd);
    }

    public final int getTrafficClass() throws IOException {
        return getTrafficClass(this.fd, this.ipv6);
    }

    public final boolean isBroadcast() throws IOException {
        return isBroadcast(this.fd) != 0;
    }

    public final boolean isInputShutdown() {
        return FileDescriptor.isInputShutdown(this.state);
    }

    public final boolean isKeepAlive() throws IOException {
        return isKeepAlive(this.fd) != 0;
    }

    public final boolean isOutputShutdown() {
        return FileDescriptor.isOutputShutdown(this.state);
    }

    public final boolean isReuseAddress() throws IOException {
        return isReuseAddress(this.fd) != 0;
    }

    public final boolean isReusePort() throws IOException {
        return isReusePort(this.fd) != 0;
    }

    public final boolean isShutdown() {
        int i = this.state;
        return FileDescriptor.isInputShutdown(i) && FileDescriptor.isOutputShutdown(i);
    }

    public final boolean isTcpNoDelay() throws IOException {
        return isTcpNoDelay(this.fd) != 0;
    }

    public final void listen(int i) throws IOException {
        int listen = listen(this.fd, i);
        if (listen < 0) {
            throw Errors.newIOException("listen", listen);
        }
    }

    public final InetSocketAddress localAddress() {
        byte[] localAddress = localAddress(this.fd);
        if (localAddress == null) {
            return null;
        }
        return NativeInetAddress.address(localAddress, 0, localAddress.length);
    }

    public int recv(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        int recv = recv(intValue(), byteBuffer, i, i2);
        if (recv > 0) {
            return recv;
        }
        if (recv == 0) {
            return -1;
        }
        return Errors.ioResult("recv", recv);
    }

    public int recvAddress(long j, int i, int i2) throws IOException {
        int recvAddress = recvAddress(intValue(), j, i, i2);
        if (recvAddress > 0) {
            return recvAddress;
        }
        if (recvAddress == 0) {
            return -1;
        }
        return Errors.ioResult("recvAddress", recvAddress);
    }

    public final int recvFd() throws IOException {
        int recvFd = recvFd(this.fd);
        if (recvFd > 0) {
            return recvFd;
        }
        if (recvFd == 0) {
            return -1;
        }
        if (recvFd == Errors.ERRNO_EAGAIN_NEGATIVE || recvFd == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        throw Errors.newIOException("recvFd", recvFd);
    }

    public final DatagramSocketAddress recvFrom(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        return recvFrom(this.fd, byteBuffer, i, i2);
    }

    public final DatagramSocketAddress recvFromAddress(long j, int i, int i2) throws IOException {
        return recvFromAddress(this.fd, j, i, i2);
    }

    public final DomainDatagramSocketAddress recvFromAddressDomainSocket(long j, int i, int i2) throws IOException {
        return recvFromAddressDomainSocket(this.fd, j, i, i2);
    }

    public final DomainDatagramSocketAddress recvFromDomainSocket(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        return recvFromDomainSocket(this.fd, byteBuffer, i, i2);
    }

    public final InetSocketAddress remoteAddress() {
        byte[] remoteAddress = remoteAddress(this.fd);
        if (remoteAddress == null) {
            return null;
        }
        return NativeInetAddress.address(remoteAddress, 0, remoteAddress.length);
    }

    public int send(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        int send = send(intValue(), byteBuffer, i, i2);
        if (send >= 0) {
            return send;
        }
        return Errors.ioResult("send", send);
    }

    public int sendAddress(long j, int i, int i2) throws IOException {
        int sendAddress = sendAddress(intValue(), j, i, i2);
        if (sendAddress >= 0) {
            return sendAddress;
        }
        return Errors.ioResult("sendAddress", sendAddress);
    }

    public final int sendFd(int i) throws IOException {
        int sendFd = sendFd(this.fd, i);
        if (sendFd >= 0) {
            return sendFd;
        }
        if (sendFd == Errors.ERRNO_EAGAIN_NEGATIVE || sendFd == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return -1;
        }
        throw Errors.newIOException("sendFd", sendFd);
    }

    public final int sendTo(ByteBuffer byteBuffer, int i, int i2, InetAddress inetAddress, int i3) throws IOException {
        return sendTo(byteBuffer, i, i2, inetAddress, i3, false);
    }

    public final int sendToAddress(long j, int i, int i2, InetAddress inetAddress, int i3) throws IOException {
        return sendToAddress(j, i, i2, inetAddress, i3, false);
    }

    public final int sendToAddressDomainSocket(long j, int i, int i2, byte[] bArr) throws IOException {
        int sendToAddressDomainSocket = sendToAddressDomainSocket(this.fd, j, i, i2, bArr);
        if (sendToAddressDomainSocket >= 0) {
            return sendToAddressDomainSocket;
        }
        return Errors.ioResult("sendToAddressDomainSocket", sendToAddressDomainSocket);
    }

    public final int sendToAddresses(long j, int i, InetAddress inetAddress, int i2) throws IOException {
        return sendToAddresses(j, i, inetAddress, i2, false);
    }

    public final int sendToAddressesDomainSocket(long j, int i, byte[] bArr) throws IOException {
        int sendToAddressesDomainSocket = sendToAddressesDomainSocket(this.fd, j, i, bArr);
        if (sendToAddressesDomainSocket >= 0) {
            return sendToAddressesDomainSocket;
        }
        return Errors.ioResult("sendToAddressesDomainSocket", sendToAddressesDomainSocket);
    }

    public final int sendToDomainSocket(ByteBuffer byteBuffer, int i, int i2, byte[] bArr) throws IOException {
        int sendToDomainSocket = sendToDomainSocket(this.fd, byteBuffer, i, i2, bArr);
        if (sendToDomainSocket >= 0) {
            return sendToDomainSocket;
        }
        return Errors.ioResult("sendToDomainSocket", sendToDomainSocket);
    }

    public final void setBroadcast(boolean z) throws IOException {
        setBroadcast(this.fd, z ? 1 : 0);
    }

    public void setIntOpt(int i, int i2, int i3) throws IOException {
        setIntOpt(this.fd, i, i2, i3);
    }

    public final void setKeepAlive(boolean z) throws IOException {
        setKeepAlive(this.fd, z ? 1 : 0);
    }

    public void setRawOpt(int i, int i2, ByteBuffer byteBuffer) throws IOException {
        int limit = byteBuffer.limit();
        if (byteBuffer.isDirect()) {
            int i3 = i;
            int i4 = i2;
            setRawOptAddress(this.fd, i3, i4, ((long) byteBuffer.position()) + Buffer.memoryAddress(byteBuffer), byteBuffer.remaining());
        } else if (byteBuffer.hasArray()) {
            setRawOptArray(this.fd, i, i2, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        } else {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.duplicate().get(bArr);
            setRawOptArray(this.fd, i, i2, bArr, 0, remaining);
        }
        byteBuffer.position(limit);
    }

    public final void setReceiveBufferSize(int i) throws IOException {
        setReceiveBufferSize(this.fd, i);
    }

    public final void setReuseAddress(boolean z) throws IOException {
        setReuseAddress(this.fd, z ? 1 : 0);
    }

    public final void setReusePort(boolean z) throws IOException {
        setReusePort(this.fd, z ? 1 : 0);
    }

    public final void setSendBufferSize(int i) throws IOException {
        setSendBufferSize(this.fd, i);
    }

    public final void setSoLinger(int i) throws IOException {
        setSoLinger(this.fd, i);
    }

    public final void setTcpNoDelay(boolean z) throws IOException {
        setTcpNoDelay(this.fd, z ? 1 : 0);
    }

    public final void setTrafficClass(int i) throws IOException {
        setTrafficClass(this.fd, this.ipv6, i);
    }

    public final void shutdown() throws IOException {
        shutdown(true, true);
    }

    public String toString() {
        return "Socket{fd=" + this.fd + '}';
    }

    public static int newSocketDgram0(InternetProtocolFamily internetProtocolFamily) {
        return newSocketDgram0(shouldUseIpv6(internetProtocolFamily));
    }

    public static int newSocketStream0(InternetProtocolFamily internetProtocolFamily) {
        return newSocketStream0(shouldUseIpv6(internetProtocolFamily));
    }

    public static boolean useIpv6(Socket socket, InetAddress inetAddress) {
        return socket.ipv6 || (inetAddress instanceof Inet6Address);
    }

    public final int sendTo(ByteBuffer byteBuffer, int i, int i2, InetAddress inetAddress, int i3, boolean z) throws IOException {
        int i4;
        byte[] bArr;
        InetAddress inetAddress2 = inetAddress;
        if (inetAddress2 instanceof Inet6Address) {
            bArr = inetAddress.getAddress();
            i4 = ((Inet6Address) inetAddress2).getScopeId();
        } else {
            bArr = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            i4 = 0;
        }
        int sendTo = sendTo(this.fd, useIpv6(inetAddress2), byteBuffer, i, i2, bArr, i4, i3, z ? msgFastopen() : 0);
        if (sendTo >= 0) {
            return sendTo;
        }
        if (sendTo == Errors.ERRNO_EINPROGRESS_NEGATIVE && z) {
            return 0;
        }
        if (sendTo != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return Errors.ioResult("sendTo", sendTo);
        }
        throw new PortUnreachableException("sendTo failed");
    }

    public final int sendToAddress(long j, int i, int i2, InetAddress inetAddress, int i3, boolean z) throws IOException {
        int i4;
        byte[] bArr;
        InetAddress inetAddress2 = inetAddress;
        if (inetAddress2 instanceof Inet6Address) {
            bArr = inetAddress.getAddress();
            i4 = ((Inet6Address) inetAddress2).getScopeId();
        } else {
            bArr = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            i4 = 0;
        }
        int sendToAddress = sendToAddress(this.fd, useIpv6(inetAddress2), j, i, i2, bArr, i4, i3, z ? msgFastopen() : 0);
        if (sendToAddress >= 0) {
            return sendToAddress;
        }
        if (sendToAddress == Errors.ERRNO_EINPROGRESS_NEGATIVE && z) {
            return 0;
        }
        if (sendToAddress != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return Errors.ioResult("sendToAddress", sendToAddress);
        }
        throw new PortUnreachableException("sendToAddress failed");
    }

    public final int sendToAddresses(long j, int i, InetAddress inetAddress, int i2, boolean z) throws IOException {
        int i3;
        byte[] bArr;
        InetAddress inetAddress2 = inetAddress;
        if (inetAddress2 instanceof Inet6Address) {
            bArr = inetAddress.getAddress();
            i3 = ((Inet6Address) inetAddress2).getScopeId();
        } else {
            bArr = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            i3 = 0;
        }
        int sendToAddresses = sendToAddresses(this.fd, useIpv6(inetAddress2), j, i, bArr, i3, i2, z ? msgFastopen() : 0);
        if (sendToAddresses >= 0) {
            return sendToAddresses;
        }
        if (sendToAddresses == Errors.ERRNO_EINPROGRESS_NEGATIVE && z) {
            return 0;
        }
        if (sendToAddresses != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return Errors.ioResult("sendToAddresses", sendToAddresses);
        }
        throw new PortUnreachableException("sendToAddresses failed");
    }

    public final void shutdown(boolean z, boolean z2) throws IOException {
        int i;
        int inputShutdown;
        do {
            i = this.state;
            if (!FileDescriptor.isClosed(i)) {
                inputShutdown = (!z || FileDescriptor.isInputShutdown(i)) ? i : FileDescriptor.inputShutdown(i);
                if (z2 && !FileDescriptor.isOutputShutdown(inputShutdown)) {
                    inputShutdown = FileDescriptor.outputShutdown(inputShutdown);
                }
                if (inputShutdown == i) {
                    return;
                }
            } else {
                throw new ClosedChannelException();
            }
        } while (!casState(i, inputShutdown));
        int shutdown = shutdown(this.fd, z, z2);
        if (shutdown < 0) {
            Errors.ioResult("shutdown", shutdown);
        }
    }

    public static int newSocketDgram0(boolean z) {
        int newSocketDgramFd = newSocketDgramFd(z);
        if (newSocketDgramFd >= 0) {
            return newSocketDgramFd;
        }
        throw new ChannelException((Throwable) Errors.newIOException("newSocketDgram", newSocketDgramFd));
    }

    public static int newSocketStream0(boolean z) {
        int newSocketStreamFd = newSocketStreamFd(z);
        if (newSocketStreamFd >= 0) {
            return newSocketStreamFd;
        }
        throw new ChannelException((Throwable) Errors.newIOException("newSocketStream", newSocketStreamFd));
    }
}
