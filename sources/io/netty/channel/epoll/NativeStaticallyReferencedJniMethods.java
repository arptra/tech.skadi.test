package io.netty.channel.epoll;

final class NativeStaticallyReferencedJniMethods {
    private NativeStaticallyReferencedJniMethods() {
    }

    public static native int epollerr();

    public static native int epollet();

    public static native int epollin();

    public static native int epollout();

    public static native int epollrdhup();

    public static native int iovMax();

    public static native boolean isSupportingRecvmmsg();

    public static native boolean isSupportingSendmmsg();

    public static native String kernelVersion();

    public static native long ssizeMax();

    public static native int tcpFastopenMode();

    public static native int tcpMd5SigMaxKeyLen();

    public static native int uioMaxIov();
}
