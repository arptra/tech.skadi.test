package io.netty.channel.epoll;

public final class Epoll {
    private static final Throwable UNAVAILABILITY_CAUSE;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002d A[Catch:{ Exception -> 0x0030 }] */
    static {
        /*
            java.lang.String r0 = "io.netty.transport.noNative"
            r1 = 0
            boolean r0 = io.netty.util.internal.SystemPropertyUtil.getBoolean(r0, r1)
            if (r0 == 0) goto L_0x0011
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = "Native transport was explicit disabled with -Dio.netty.transport.noNative=true"
            r0.<init>(r1)
            goto L_0x0030
        L_0x0011:
            r0 = 0
            io.netty.channel.unix.FileDescriptor r1 = io.netty.channel.epoll.Native.newEpollCreate()     // Catch:{ all -> 0x0027 }
            io.netty.channel.unix.FileDescriptor r2 = io.netty.channel.epoll.Native.newEventFd()     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x001f
            r1.close()     // Catch:{ Exception -> 0x001f }
        L_0x001f:
            if (r2 == 0) goto L_0x0030
            r2.close()     // Catch:{ Exception -> 0x0030 }
            goto L_0x0030
        L_0x0025:
            r0 = move-exception
            goto L_0x002b
        L_0x0027:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x002b:
            if (r1 == 0) goto L_0x0030
            r1.close()     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            UNAVAILABILITY_CAUSE = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.Epoll.<clinit>():void");
    }

    private Epoll() {
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
