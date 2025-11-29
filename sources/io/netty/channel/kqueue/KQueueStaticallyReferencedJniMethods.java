package io.netty.channel.kqueue;

final class KQueueStaticallyReferencedJniMethods {
    private KQueueStaticallyReferencedJniMethods() {
    }

    public static native int connectDataIdempotent();

    public static native int connectResumeOnReadWrite();

    public static native short evAdd();

    public static native short evClear();

    public static native short evDelete();

    public static native short evDisable();

    public static native short evEOF();

    public static native short evEnable();

    public static native short evError();

    public static native short evfiltRead();

    public static native short evfiltSock();

    public static native short evfiltUser();

    public static native short evfiltWrite();

    public static native int fastOpenClient();

    public static native int fastOpenServer();

    public static native short noteConnReset();

    public static native short noteDisconnected();

    public static native short noteReadClosed();
}
