package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLEngine;

final class Conscrypt {
    private static final Method IS_CONSCRYPT_SSLENGINE;

    static {
        Method method;
        Class<ConscryptAlpnSslEngine> cls = ConscryptAlpnSslEngine.class;
        if ((PlatformDependent.javaVersion() >= 8 && PlatformDependent.javaVersion() < 15) || PlatformDependent.isAndroid()) {
            try {
                Class.forName("org.conscrypt.OpenSSLProvider", true, PlatformDependent.getClassLoader(cls)).newInstance();
                method = Class.forName("org.conscrypt.Conscrypt", true, PlatformDependent.getClassLoader(cls)).getMethod("isConscrypt", new Class[]{SSLEngine.class});
            } catch (Throwable unused) {
            }
            IS_CONSCRYPT_SSLENGINE = method;
        }
        method = null;
        IS_CONSCRYPT_SSLENGINE = method;
    }

    private Conscrypt() {
    }

    public static boolean isAvailable() {
        return IS_CONSCRYPT_SSLENGINE != null;
    }

    public static boolean isEngineSupported(SSLEngine sSLEngine) {
        try {
            Method method = IS_CONSCRYPT_SSLENGINE;
            return method != null && ((Boolean) method.invoke((Object) null, new Object[]{sSLEngine})).booleanValue();
        } catch (IllegalAccessException unused) {
            return false;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
