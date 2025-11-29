package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.security.SecureRandom;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.TrustManager;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class JdkAlpnSslUtils {
    private static final Method GET_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method SET_APPLICATION_PROTOCOLS;
    private static final Method SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) JdkAlpnSslUtils.class);

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5 = null;
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
            SSLEngine createSSLEngine = instance.createSSLEngine();
            Method method6 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return SSLEngine.class.getMethod("getHandshakeApplicationProtocol", (Class[]) null);
                }
            });
            method6.invoke(createSSLEngine, (Object[]) null);
            method4 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return SSLEngine.class.getMethod("getApplicationProtocol", (Class[]) null);
                }
            });
            method4.invoke(createSSLEngine, (Object[]) null);
            method3 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class});
                }
            });
            method3.invoke(createSSLEngine.getSSLParameters(), new Object[]{EmptyArrays.EMPTY_STRINGS});
            method2 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return SSLEngine.class.getMethod("setHandshakeApplicationProtocolSelector", new Class[]{BiFunction.class});
                }
            });
            method2.invoke(createSSLEngine, new Object[]{new BiFunction<SSLEngine, List<String>, String>() {
                public String apply(SSLEngine sSLEngine, List<String> list) {
                    return null;
                }
            }});
            method = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return SSLEngine.class.getMethod("getHandshakeApplicationProtocolSelector", (Class[]) null);
                }
            });
            method.invoke(createSSLEngine, (Object[]) null);
            method5 = method6;
        } catch (Throwable th) {
            int javaVersion = PlatformDependent.javaVersion();
            if (javaVersion >= 9) {
                logger.error("Unable to initialize JdkAlpnSslUtils, but the detected java version was: {}", Integer.valueOf(javaVersion), th);
            }
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        GET_HANDSHAKE_APPLICATION_PROTOCOL = method5;
        GET_APPLICATION_PROTOCOL = method4;
        SET_APPLICATION_PROTOCOLS = method3;
        SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method2;
        GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method;
    }

    private JdkAlpnSslUtils() {
    }

    public static String getApplicationProtocol(SSLEngine sSLEngine) {
        try {
            return (String) GET_APPLICATION_PROTOCOL.invoke(sSLEngine, (Object[]) null);
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static String getHandshakeApplicationProtocol(SSLEngine sSLEngine) {
        try {
            return (String) GET_HANDSHAKE_APPLICATION_PROTOCOL.invoke(sSLEngine, (Object[]) null);
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector(SSLEngine sSLEngine) {
        try {
            return (BiFunction) GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine, (Object[]) null);
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static void setApplicationProtocols(SSLEngine sSLEngine, List<String> list) {
        SSLParameters sSLParameters = sSLEngine.getSSLParameters();
        try {
            SET_APPLICATION_PROTOCOLS.invoke(sSLParameters, new Object[]{(String[]) list.toArray(EmptyArrays.EMPTY_STRINGS)});
            sSLEngine.setSSLParameters(sSLParameters);
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static void setHandshakeApplicationProtocolSelector(SSLEngine sSLEngine, BiFunction<SSLEngine, List<String>, String> biFunction) {
        try {
            SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine, new Object[]{biFunction});
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static boolean supportsAlpn() {
        return GET_APPLICATION_PROTOCOL != null;
    }
}
