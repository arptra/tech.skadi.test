package io.netty.channel.unix;

final class LimitsStaticallyReferencedJniMethods {
    private LimitsStaticallyReferencedJniMethods() {
    }

    public static native int iovMax();

    public static native int sizeOfjlong();

    public static native long ssizeMax();

    public static native int udsSunPathSize();

    public static native int uioMaxIov();
}
