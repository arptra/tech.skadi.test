package io.netty.channel.kqueue;

import io.netty.channel.unix.FileDescriptor;
import io.netty.util.internal.SystemPropertyUtil;

public final class KQueue {
    private static final Throwable UNAVAILABILITY_CAUSE;

    static {
        if (SystemPropertyUtil.getBoolean("io.netty.transport.noNative", false)) {
            th = new UnsupportedOperationException("Native transport was explicit disabled with -Dio.netty.transport.noNative=true");
        } else {
            try {
                FileDescriptor newKQueue = Native.newKQueue();
                if (newKQueue != null) {
                    try {
                        newKQueue.close();
                    } catch (Exception unused) {
                    }
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
        }
        UNAVAILABILITY_CAUSE = th;
    }

    private KQueue() {
    }

    public static void ensureAvailability() {
        Throwable th = UNAVAILABILITY_CAUSE;
        if (th != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(th));
        }
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static boolean isTcpFastOpenClientSideAvailable() {
        return isAvailable() && Native.IS_SUPPORTING_TCP_FASTOPEN_CLIENT;
    }

    public static boolean isTcpFastOpenServerSideAvailable() {
        return isAvailable() && Native.IS_SUPPORTING_TCP_FASTOPEN_SERVER;
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }
}
