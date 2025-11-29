package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;

final class NetUtilInitializations {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NetUtilInitializations.class);

    public static final class NetworkIfaceAndInetAddress {
        private final InetAddress address;
        private final NetworkInterface iface;

        public NetworkIfaceAndInetAddress(NetworkInterface networkInterface, InetAddress inetAddress) {
            this.iface = networkInterface;
            this.address = inetAddress;
        }

        public InetAddress address() {
            return this.address;
        }

        public NetworkInterface iface() {
            return this.iface;
        }
    }

    private NetUtilInitializations() {
    }

    public static Inet4Address createLocalhost4() {
        try {
            return (Inet4Address) InetAddress.getByAddress("localhost", new byte[]{Byte.MAX_VALUE, 0, 0, 1});
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return null;
        }
    }

    public static Inet6Address createLocalhost6() {
        try {
            return (Inet6Address) InetAddress.getByAddress("localhost", new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [java.net.InetAddress, java.net.Inet6Address, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0082, code lost:
        r6 = r5.nextElement();
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (r6 != null) goto L_0x00d9;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.net.Inet4Address, code=java.net.InetAddress, for r8v0, types: [java.lang.Object, java.net.Inet4Address] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.net.Inet6Address, code=java.net.InetAddress, for r9v0, types: [java.net.InetAddress, java.net.Inet6Address, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.netty.util.NetUtilInitializations.NetworkIfaceAndInetAddress determineLoopback(java.net.InetAddress r8, java.net.InetAddress r9) {
        /*
            java.lang.String r0 = "Failed to find the loopback interface"
            java.lang.String r1 = "Using hard-coded IPv4 localhost address: {}"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Enumeration r3 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ SocketException -> 0x0029 }
            if (r3 == 0) goto L_0x0031
        L_0x000f:
            boolean r4 = r3.hasMoreElements()     // Catch:{ SocketException -> 0x0029 }
            if (r4 == 0) goto L_0x0031
            java.lang.Object r4 = r3.nextElement()     // Catch:{ SocketException -> 0x0029 }
            java.net.NetworkInterface r4 = (java.net.NetworkInterface) r4     // Catch:{ SocketException -> 0x0029 }
            java.util.Enumeration r5 = io.netty.util.internal.SocketUtils.addressesFromNetworkInterface(r4)     // Catch:{ SocketException -> 0x0029 }
            boolean r5 = r5.hasMoreElements()     // Catch:{ SocketException -> 0x0029 }
            if (r5 == 0) goto L_0x000f
            r2.add(r4)     // Catch:{ SocketException -> 0x0029 }
            goto L_0x000f
        L_0x0029:
            r3 = move-exception
            io.netty.util.internal.logging.InternalLogger r4 = logger
            java.lang.String r5 = "Failed to retrieve the list of available network interfaces"
            r4.warn((java.lang.String) r5, (java.lang.Throwable) r3)
        L_0x0031:
            java.util.Iterator r3 = r2.iterator()
        L_0x0035:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0058
            java.lang.Object r4 = r3.next()
            java.net.NetworkInterface r4 = (java.net.NetworkInterface) r4
            java.util.Enumeration r5 = io.netty.util.internal.SocketUtils.addressesFromNetworkInterface(r4)
        L_0x0045:
            boolean r6 = r5.hasMoreElements()
            if (r6 == 0) goto L_0x0035
            java.lang.Object r6 = r5.nextElement()
            java.net.InetAddress r6 = (java.net.InetAddress) r6
            boolean r7 = r6.isLoopbackAddress()
            if (r7 == 0) goto L_0x0045
            goto L_0x005a
        L_0x0058:
            r4 = 0
            r6 = r4
        L_0x005a:
            if (r4 != 0) goto L_0x0097
            java.util.Iterator r2 = r2.iterator()     // Catch:{ SocketException -> 0x0088 }
        L_0x0060:
            boolean r3 = r2.hasNext()     // Catch:{ SocketException -> 0x0088 }
            if (r3 == 0) goto L_0x008a
            java.lang.Object r3 = r2.next()     // Catch:{ SocketException -> 0x0088 }
            java.net.NetworkInterface r3 = (java.net.NetworkInterface) r3     // Catch:{ SocketException -> 0x0088 }
            boolean r5 = r3.isLoopback()     // Catch:{ SocketException -> 0x0088 }
            if (r5 == 0) goto L_0x0060
            java.util.Enumeration r5 = io.netty.util.internal.SocketUtils.addressesFromNetworkInterface(r3)     // Catch:{ SocketException -> 0x0088 }
            boolean r7 = r5.hasMoreElements()     // Catch:{ SocketException -> 0x0088 }
            if (r7 == 0) goto L_0x0060
            java.lang.Object r2 = r5.nextElement()     // Catch:{ SocketException -> 0x0085 }
            java.net.InetAddress r2 = (java.net.InetAddress) r2     // Catch:{ SocketException -> 0x0085 }
            r6 = r2
            r4 = r3
            goto L_0x008a
        L_0x0085:
            r2 = move-exception
            r4 = r3
            goto L_0x0092
        L_0x0088:
            r2 = move-exception
            goto L_0x0092
        L_0x008a:
            if (r4 != 0) goto L_0x0097
            io.netty.util.internal.logging.InternalLogger r2 = logger     // Catch:{ SocketException -> 0x0088 }
            r2.warn((java.lang.String) r0)     // Catch:{ SocketException -> 0x0088 }
            goto L_0x0097
        L_0x0092:
            io.netty.util.internal.logging.InternalLogger r3 = logger
            r3.warn((java.lang.String) r0, (java.lang.Throwable) r2)
        L_0x0097:
            if (r4 == 0) goto L_0x00b1
            io.netty.util.internal.logging.InternalLogger r8 = logger
            java.lang.String r9 = r4.getName()
            java.lang.String r0 = r4.getDisplayName()
            java.lang.String r1 = r6.getHostAddress()
            java.lang.Object[] r9 = new java.lang.Object[]{r9, r0, r1}
            java.lang.String r0 = "Loopback interface: {} ({}, {})"
            r8.debug((java.lang.String) r0, (java.lang.Object[]) r9)
            goto L_0x00d9
        L_0x00b1:
            if (r6 != 0) goto L_0x00d9
            java.net.NetworkInterface r0 = java.net.NetworkInterface.getByInetAddress(r9)     // Catch:{ Exception -> 0x00d6, all -> 0x00c1 }
            if (r0 == 0) goto L_0x00c3
            io.netty.util.internal.logging.InternalLogger r0 = logger     // Catch:{ Exception -> 0x00d6, all -> 0x00c1 }
            java.lang.String r2 = "Using hard-coded IPv6 localhost address: {}"
            r0.debug((java.lang.String) r2, (java.lang.Object) r9)     // Catch:{ Exception -> 0x00d6, all -> 0x00c1 }
            goto L_0x00c4
        L_0x00c1:
            r9 = move-exception
            goto L_0x00ce
        L_0x00c3:
            r9 = r6
        L_0x00c4:
            if (r9 != 0) goto L_0x00cc
        L_0x00c6:
            io.netty.util.internal.logging.InternalLogger r9 = logger
            r9.debug((java.lang.String) r1, (java.lang.Object) r8)
            goto L_0x00da
        L_0x00cc:
            r8 = r9
            goto L_0x00da
        L_0x00ce:
            if (r6 != 0) goto L_0x00d5
            io.netty.util.internal.logging.InternalLogger r0 = logger
            r0.debug((java.lang.String) r1, (java.lang.Object) r8)
        L_0x00d5:
            throw r9
        L_0x00d6:
            if (r6 != 0) goto L_0x00d9
            goto L_0x00c6
        L_0x00d9:
            r8 = r6
        L_0x00da:
            io.netty.util.NetUtilInitializations$NetworkIfaceAndInetAddress r9 = new io.netty.util.NetUtilInitializations$NetworkIfaceAndInetAddress
            r9.<init>(r4, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtilInitializations.determineLoopback(java.net.Inet4Address, java.net.Inet6Address):io.netty.util.NetUtilInitializations$NetworkIfaceAndInetAddress");
    }
}
