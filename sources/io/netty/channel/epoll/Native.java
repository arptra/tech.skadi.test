package io.netty.channel.epoll;

import io.netty.channel.epoll.NativeDatagramPacketArray;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import java.io.IOException;

public final class Native {
    public static final int EPOLLERR = NativeStaticallyReferencedJniMethods.epollerr();
    public static final int EPOLLET = NativeStaticallyReferencedJniMethods.epollet();
    public static final int EPOLLIN = NativeStaticallyReferencedJniMethods.epollin();
    public static final int EPOLLOUT = NativeStaticallyReferencedJniMethods.epollout();
    public static final int EPOLLRDHUP = NativeStaticallyReferencedJniMethods.epollrdhup();
    static final boolean IS_SUPPORTING_RECVMMSG = NativeStaticallyReferencedJniMethods.isSupportingRecvmmsg();
    public static final boolean IS_SUPPORTING_SENDMMSG = NativeStaticallyReferencedJniMethods.isSupportingSendmmsg();
    @Deprecated
    public static final boolean IS_SUPPORTING_TCP_FASTOPEN;
    static final boolean IS_SUPPORTING_TCP_FASTOPEN_CLIENT;
    static final boolean IS_SUPPORTING_TCP_FASTOPEN_SERVER;
    static final boolean IS_SUPPORTING_UDP_SEGMENT = isSupportingUdpSegment();
    public static final String KERNEL_VERSION = NativeStaticallyReferencedJniMethods.kernelVersion();
    private static final int TCP_FASTOPEN_MODE;
    public static final int TCP_MD5SIG_MAXKEYLEN = NativeStaticallyReferencedJniMethods.tcpMd5SigMaxKeyLen();
    private static final int TFO_ENABLED_CLIENT_MASK = 1;
    private static final int TFO_ENABLED_SERVER_MASK = 2;
    private static final InternalLogger logger;

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        loadNativeLibrary();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if (r1 == null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0097, code lost:
        if (r1 != null) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r1 != null) goto L_0x0024;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002b */
    static {
        /*
            java.lang.Class<io.netty.channel.epoll.Native> r0 = io.netty.channel.epoll.Native.class
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.util.internal.logging.InternalLoggerFactory.getInstance((java.lang.Class<?>) r0)
            logger = r1
            java.nio.channels.Selector r1 = java.nio.channels.Selector.open()     // Catch:{ IOException -> 0x000d }
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            java.lang.Class<java.io.FileDescriptor> r2 = java.io.FileDescriptor.class
            java.lang.Class<io.netty.channel.epoll.NativeDatagramPacketArray$NativeDatagramPacket> r3 = io.netty.channel.epoll.NativeDatagramPacketArray.NativeDatagramPacket.class
            java.lang.Class<io.netty.channel.unix.PeerCredentials> r4 = io.netty.channel.unix.PeerCredentials.class
            java.lang.Class<io.netty.channel.DefaultFileRegion> r5 = io.netty.channel.DefaultFileRegion.class
            java.lang.Class<java.nio.channels.FileChannel> r6 = java.nio.channels.FileChannel.class
            java.lang.Class[] r2 = new java.lang.Class[]{r4, r5, r6, r2, r3}
            io.netty.util.internal.ClassInitializerUtil.tryLoadClasses(r0, r2)
            offsetofEpollData()     // Catch:{ UnsatisfiedLinkError -> 0x002b }
            if (r1 == 0) goto L_0x0031
        L_0x0024:
            r1.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0031
        L_0x0028:
            r0 = move-exception
            goto L_0x0097
        L_0x002b:
            loadNativeLibrary()     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0031
            goto L_0x0024
        L_0x0031:
            io.netty.channel.epoll.Native$1 r0 = new io.netty.channel.epoll.Native$1
            r0.<init>()
            io.netty.channel.unix.Unix.registerInternal(r0)
            int r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollin()
            EPOLLIN = r0
            int r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollout()
            EPOLLOUT = r0
            int r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollrdhup()
            EPOLLRDHUP = r0
            int r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollet()
            EPOLLET = r0
            int r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.epollerr()
            EPOLLERR = r0
            boolean r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.isSupportingSendmmsg()
            IS_SUPPORTING_SENDMMSG = r0
            boolean r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.isSupportingRecvmmsg()
            IS_SUPPORTING_RECVMMSG = r0
            boolean r0 = isSupportingUdpSegment()
            IS_SUPPORTING_UDP_SEGMENT = r0
            int r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.tcpFastopenMode()
            TCP_FASTOPEN_MODE = r0
            r1 = r0 & 1
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x0077
            r1 = r3
            goto L_0x0078
        L_0x0077:
            r1 = r2
        L_0x0078:
            IS_SUPPORTING_TCP_FASTOPEN_CLIENT = r1
            r4 = 2
            r0 = r0 & r4
            if (r0 != r4) goto L_0x0080
            r0 = r3
            goto L_0x0081
        L_0x0080:
            r0 = r2
        L_0x0081:
            IS_SUPPORTING_TCP_FASTOPEN_SERVER = r0
            if (r1 != 0) goto L_0x0087
            if (r0 == 0) goto L_0x0088
        L_0x0087:
            r2 = r3
        L_0x0088:
            IS_SUPPORTING_TCP_FASTOPEN = r2
            int r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.tcpMd5SigMaxKeyLen()
            TCP_MD5SIG_MAXKEYLEN = r0
            java.lang.String r0 = io.netty.channel.epoll.NativeStaticallyReferencedJniMethods.kernelVersion()
            KERNEL_VERSION = r0
            return
        L_0x0097:
            if (r1 == 0) goto L_0x009c
            r1.close()     // Catch:{ IOException -> 0x009c }
        L_0x009c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.Native.<clinit>():void");
    }

    private Native() {
    }

    public static int epollBusyWait(FileDescriptor fileDescriptor, EpollEventArray epollEventArray) throws IOException {
        int epollBusyWait0 = epollBusyWait0(fileDescriptor.intValue(), epollEventArray.memoryAddress(), epollEventArray.length());
        if (epollBusyWait0 >= 0) {
            return epollBusyWait0;
        }
        throw Errors.newIOException("epoll_wait", epollBusyWait0);
    }

    private static native int epollBusyWait0(int i, long j, int i2);

    private static native int epollCreate();

    public static void epollCtlAdd(int i, int i2, int i3) throws IOException {
        int epollCtlAdd0 = epollCtlAdd0(i, i2, i3);
        if (epollCtlAdd0 < 0) {
            throw Errors.newIOException("epoll_ctl", epollCtlAdd0);
        }
    }

    private static native int epollCtlAdd0(int i, int i2, int i3);

    public static void epollCtlDel(int i, int i2) throws IOException {
        int epollCtlDel0 = epollCtlDel0(i, i2);
        if (epollCtlDel0 < 0) {
            throw Errors.newIOException("epoll_ctl", epollCtlDel0);
        }
    }

    private static native int epollCtlDel0(int i, int i2);

    public static void epollCtlMod(int i, int i2, int i3) throws IOException {
        int epollCtlMod0 = epollCtlMod0(i, i2, i3);
        if (epollCtlMod0 < 0) {
            throw Errors.newIOException("epoll_ctl", epollCtlMod0);
        }
    }

    private static native int epollCtlMod0(int i, int i2, int i3);

    public static int epollReady(long j) {
        return (int) (j >> 32);
    }

    public static boolean epollTimerWasUsed(long j) {
        return (j & 255) != 0;
    }

    private static native int epollWait(int i, long j, int i2, int i3);

    @Deprecated
    public static int epollWait(FileDescriptor fileDescriptor, EpollEventArray epollEventArray, FileDescriptor fileDescriptor2, int i, int i2) throws IOException {
        return epollReady(epollWait(fileDescriptor, epollEventArray, fileDescriptor2, i, i2, -1));
    }

    private static native long epollWait0(int i, long j, int i2, int i3, int i4, int i5, long j2);

    private static native int eventFd();

    public static native void eventFdRead(int i);

    public static native void eventFdWrite(int i, long j);

    private static native boolean isSupportingUdpSegment();

    private static void loadNativeLibrary() {
        if ("linux".equals(PlatformDependent.normalizedOs())) {
            String str = "netty_transport_native_epoll" + '_' + PlatformDependent.normalizedArch();
            ClassLoader classLoader = PlatformDependent.getClassLoader(Native.class);
            try {
                NativeLibraryLoader.load(str, classLoader);
            } catch (UnsatisfiedLinkError e) {
                try {
                    NativeLibraryLoader.load("netty_transport_native_epoll", classLoader);
                    logger.debug("Failed to load {}", str, e);
                } catch (UnsatisfiedLinkError e2) {
                    ThrowableUtil.addSuppressed((Throwable) e, (Throwable) e2);
                    throw e;
                }
            }
        } else {
            throw new IllegalStateException("Only supported on Linux");
        }
    }

    public static FileDescriptor newEpollCreate() {
        return new FileDescriptor(epollCreate());
    }

    public static FileDescriptor newEventFd() {
        return new FileDescriptor(eventFd());
    }

    public static FileDescriptor newTimerFd() {
        return new FileDescriptor(timerFd());
    }

    public static native int offsetofEpollData();

    public static int recvmmsg(int i, boolean z, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3) throws IOException {
        int recvmmsg0 = recvmmsg0(i, z, nativeDatagramPacketArr, i2, i3);
        return recvmmsg0 >= 0 ? recvmmsg0 : Errors.ioResult("recvmmsg", recvmmsg0);
    }

    private static native int recvmmsg0(int i, boolean z, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3);

    public static int recvmsg(int i, boolean z, NativeDatagramPacketArray.NativeDatagramPacket nativeDatagramPacket) throws IOException {
        int recvmsg0 = recvmsg0(i, z, nativeDatagramPacket);
        return recvmsg0 >= 0 ? recvmsg0 : Errors.ioResult("recvmsg", recvmsg0);
    }

    private static native int recvmsg0(int i, boolean z, NativeDatagramPacketArray.NativeDatagramPacket nativeDatagramPacket);

    /* access modifiers changed from: private */
    public static native int registerUnix();

    @Deprecated
    public static int sendmmsg(int i, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3) throws IOException {
        return sendmmsg(i, Socket.isIPv6Preferred(), nativeDatagramPacketArr, i2, i3);
    }

    private static native int sendmmsg0(int i, boolean z, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3);

    public static native int sizeofEpollEvent();

    public static int splice(int i, long j, int i2, long j2, long j3) throws IOException {
        int splice0 = splice0(i, j, i2, j2, j3);
        return splice0 >= 0 ? splice0 : Errors.ioResult("splice", splice0);
    }

    private static native int splice0(int i, long j, int i2, long j2, long j3);

    private static native int timerFd();

    public static int sendmmsg(int i, boolean z, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3) throws IOException {
        int sendmmsg0 = sendmmsg0(i, z, nativeDatagramPacketArr, i2, i3);
        if (sendmmsg0 >= 0) {
            return sendmmsg0;
        }
        return Errors.ioResult("sendmmsg", sendmmsg0);
    }

    public static long epollWait(FileDescriptor fileDescriptor, EpollEventArray epollEventArray, FileDescriptor fileDescriptor2, int i, int i2, long j) throws IOException {
        int i3;
        int i4;
        int i5 = i;
        if (i5 == 0 && i2 == 0) {
            FileDescriptor fileDescriptor3 = fileDescriptor;
            EpollEventArray epollEventArray2 = epollEventArray;
            return ((long) epollWait(fileDescriptor, epollEventArray, 0)) << 32;
        }
        FileDescriptor fileDescriptor4 = fileDescriptor;
        EpollEventArray epollEventArray3 = epollEventArray;
        if (i5 == Integer.MAX_VALUE) {
            i4 = 0;
            i3 = 0;
        } else {
            i3 = i2;
            i4 = i5;
        }
        long epollWait0 = epollWait0(fileDescriptor.intValue(), epollEventArray.memoryAddress(), epollEventArray.length(), fileDescriptor2.intValue(), i4, i3, j);
        int epollReady = epollReady(epollWait0);
        if (epollReady >= 0) {
            return epollWait0;
        }
        throw Errors.newIOException("epoll_wait", epollReady);
    }

    public static int epollWait(FileDescriptor fileDescriptor, EpollEventArray epollEventArray, boolean z) throws IOException {
        return epollWait(fileDescriptor, epollEventArray, z ? 0 : -1);
    }

    public static int epollWait(FileDescriptor fileDescriptor, EpollEventArray epollEventArray, int i) throws IOException {
        int epollWait = epollWait(fileDescriptor.intValue(), epollEventArray.memoryAddress(), epollEventArray.length(), i);
        if (epollWait >= 0) {
            return epollWait;
        }
        throw Errors.newIOException("epoll_wait", epollWait);
    }
}
