package io.netty.handler.codec.compression;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public final class Zstd {
    private static final Throwable cause;
    private static final InternalLogger logger;

    static {
        Class<Zstd> cls = Zstd.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        try {
            Class.forName("com.github.luben.zstd.Zstd", false, PlatformDependent.getClassLoader(cls));
            th = null;
        } catch (ClassNotFoundException e) {
            th = e;
            logger.debug("zstd-jni not in the classpath; Zstd support will be unavailable.");
        } catch (Throwable th) {
            th = th;
            logger.debug("Failed to load zstd-jni; Zstd support will be unavailable.", (Throwable) th);
        }
        cause = th;
    }

    private Zstd() {
    }

    public static Throwable cause() {
        return cause;
    }

    public static void ensureAvailability() throws Throwable {
        Throwable th = cause;
        if (th != null) {
            throw th;
        }
    }

    public static boolean isAvailable() {
        return cause == null;
    }
}
