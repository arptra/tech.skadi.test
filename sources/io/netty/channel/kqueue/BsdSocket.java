package io.netty.channel.kqueue;

import com.here.posclient.UpdateOptions;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.NativeInetAddress;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

final class BsdSocket extends Socket {
    private static final int APPLE_SND_LOW_AT_MAX = 131072;
    static final int BSD_SND_LOW_AT_MAX = Math.min(131072, 32768);
    private static final int FREEBSD_SND_LOW_AT_MAX = 32768;
    private static final int UNSPECIFIED_SOURCE_INTERFACE = 0;

    public BsdSocket(int i) {
        super(i);
    }

    private static native int connectx(int i, int i2, boolean z, byte[] bArr, int i3, int i4, boolean z2, byte[] bArr2, int i5, int i6, int i7, long j, int i8, int i9);

    private static native String[] getAcceptFilter(int i) throws IOException;

    private static native PeerCredentials getPeerCredentials(int i) throws IOException;

    private static native int getSndLowAt(int i) throws IOException;

    private static native int getTcpNoPush(int i) throws IOException;

    private static native int isTcpFastOpen(int i) throws IOException;

    public static BsdSocket newSocketDgram() {
        return new BsdSocket(Socket.newSocketDgram0());
    }

    public static BsdSocket newSocketDomain() {
        return new BsdSocket(Socket.newSocketDomain0());
    }

    public static BsdSocket newSocketDomainDgram() {
        return new BsdSocket(Socket.newSocketDomainDgram0());
    }

    public static BsdSocket newSocketStream() {
        return new BsdSocket(Socket.newSocketStream0());
    }

    private static native long sendFile(int i, DefaultFileRegion defaultFileRegion, long j, long j2, long j3) throws IOException;

    private static native void setAcceptFilter(int i, String str, String str2) throws IOException;

    private static native void setSndLowAt(int i, int i2) throws IOException;

    private static native void setTcpFastOpen(int i, int i2) throws IOException;

    private static native void setTcpNoPush(int i, int i2) throws IOException;

    public int connectx(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, IovArray iovArray, boolean z) throws IOException {
        int i;
        int i2;
        byte[] bArr;
        boolean z2;
        int i3;
        byte[] bArr2;
        int i4;
        long j;
        byte[] bArr3;
        int i5;
        IovArray iovArray2 = iovArray;
        ObjectUtil.checkNotNull(inetSocketAddress2, "Destination InetSocketAddress cannot be null.");
        int i6 = 0;
        int i7 = z ? Native.CONNECT_TCP_FASTOPEN : 0;
        if (inetSocketAddress == null) {
            z2 = false;
            i2 = 0;
            i = 0;
            bArr = null;
        } else {
            InetAddress address = inetSocketAddress.getAddress();
            boolean useIpv6 = Socket.useIpv6(this, address);
            if (address instanceof Inet6Address) {
                bArr3 = address.getAddress();
                i5 = ((Inet6Address) address).getScopeId();
            } else {
                bArr3 = NativeInetAddress.ipv4MappedIpv6Address(address.getAddress());
                i5 = 0;
            }
            i2 = i5;
            bArr = bArr3;
            i = inetSocketAddress.getPort();
            z2 = useIpv6;
        }
        InetAddress address2 = inetSocketAddress2.getAddress();
        boolean useIpv62 = Socket.useIpv6(this, address2);
        if (address2 instanceof Inet6Address) {
            byte[] address3 = address2.getAddress();
            i3 = ((Inet6Address) address2).getScopeId();
            bArr2 = address3;
        } else {
            i3 = 0;
            bArr2 = NativeInetAddress.ipv4MappedIpv6Address(address2.getAddress());
        }
        int port = inetSocketAddress2.getPort();
        if (iovArray2 == null || iovArray.count() == 0) {
            i4 = 0;
            j = 0;
        } else {
            long memoryAddress = iovArray2.memoryAddress(0);
            int count = iovArray.count();
            long size = iovArray.size();
            if (size <= UpdateOptions.SOURCE_ANY) {
                j = memoryAddress;
                i4 = count;
                i6 = (int) size;
            } else {
                throw new IOException("IovArray.size() too big: " + size + " bytes.");
            }
        }
        int connectx = connectx(intValue(), 0, z2, bArr, i2, i, useIpv62, bArr2, i3, port, i7, j, i4, i6);
        if (connectx == Errors.ERRNO_EINPROGRESS_NEGATIVE) {
            return -i6;
        }
        return connectx < 0 ? Errors.ioResult("connectx", connectx) : connectx;
    }

    public AcceptFilter getAcceptFilter() throws IOException {
        String[] acceptFilter = getAcceptFilter(intValue());
        return acceptFilter == null ? AcceptFilter.PLATFORM_UNSUPPORTED : new AcceptFilter(acceptFilter[0], acceptFilter[1]);
    }

    public PeerCredentials getPeerCredentials() throws IOException {
        return getPeerCredentials(intValue());
    }

    public int getSndLowAt() throws IOException {
        return getSndLowAt(intValue());
    }

    public boolean isTcpFastOpen() throws IOException {
        return isTcpFastOpen(intValue()) != 0;
    }

    public boolean isTcpNoPush() throws IOException {
        return getTcpNoPush(intValue()) != 0;
    }

    public long sendFile(DefaultFileRegion defaultFileRegion, long j, long j2, long j3) throws IOException {
        defaultFileRegion.open();
        long sendFile = sendFile(intValue(), defaultFileRegion, j, j2, j3);
        if (sendFile >= 0) {
            return sendFile;
        }
        return (long) Errors.ioResult("sendfile", (int) sendFile);
    }

    public void setAcceptFilter(AcceptFilter acceptFilter) throws IOException {
        setAcceptFilter(intValue(), acceptFilter.filterName(), acceptFilter.filterArgs());
    }

    public void setSndLowAt(int i) throws IOException {
        setSndLowAt(intValue(), i);
    }

    public void setTcpFastOpen(boolean z) throws IOException {
        setTcpFastOpen(intValue(), z ? 1 : 0);
    }

    public void setTcpNoPush(boolean z) throws IOException {
        setTcpNoPush(intValue(), z ? 1 : 0);
    }

    public static BsdSocket newSocketDgram(InternetProtocolFamily internetProtocolFamily) {
        return new BsdSocket(Socket.newSocketDgram0(internetProtocolFamily));
    }

    public static BsdSocket newSocketStream(InternetProtocolFamily internetProtocolFamily) {
        return new BsdSocket(Socket.newSocketStream0(internetProtocolFamily));
    }
}
