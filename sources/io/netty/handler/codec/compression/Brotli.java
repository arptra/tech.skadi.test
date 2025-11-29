package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.Brotli4jLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public final class Brotli {
    private static final ClassNotFoundException CNFE;
    private static Throwable cause;
    private static final InternalLogger logger;

    static {
        Class<Brotli> cls = Brotli.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        try {
            Class.forName("com.aayushatharva.brotli4j.Brotli4jLoader", false, PlatformDependent.getClassLoader(cls));
            e = null;
        } catch (ClassNotFoundException e) {
            e = e;
            logger.debug("brotli4j not in the classpath; Brotli support will be unavailable.");
        }
        CNFE = e;
        if (e == null) {
            Throwable unavailabilityCause = Brotli4jLoader.getUnavailabilityCause();
            cause = unavailabilityCause;
            if (unavailabilityCause != null) {
                logger.debug("Failed to load brotli4j; Brotli support will be unavailable.", unavailabilityCause);
            }
        }
    }

    private Brotli() {
    }

    public static Throwable cause() {
        return cause;
    }

    public static void ensureAvailability() throws Throwable {
        ClassNotFoundException classNotFoundException = CNFE;
        if (classNotFoundException == null) {
            Brotli4jLoader.ensureAvailability();
            return;
        }
        throw classNotFoundException;
    }

    public static boolean isAvailable() {
        return CNFE == null && Brotli4jLoader.isAvailable();
    }
}
