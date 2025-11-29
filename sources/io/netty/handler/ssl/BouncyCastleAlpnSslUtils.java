package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class BouncyCastleAlpnSslUtils {
    private static final Class BC_APPLICATION_PROTOCOL_SELECTOR;
    /* access modifiers changed from: private */
    public static final Method BC_APPLICATION_PROTOCOL_SELECTOR_SELECT;
    private static final Class BC_SSL_PARAMETERS;
    private static final Method GET_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method SET_APPLICATION_PROTOCOLS;
    private static final Method SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method SET_PARAMETERS;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) BouncyCastleAlpnSslUtils.class);

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        final Class<?> cls;
        Method method6;
        Method method7;
        Class<?> cls2 = null;
        try {
            final Class<?> cls3 = Class.forName("org.bouncycastle.jsse.BCSSLEngine");
            final Class<?> cls4 = Class.forName("org.bouncycastle.jsse.BCSSLParameters");
            Object newInstance = cls4.newInstance();
            cls = Class.forName("org.bouncycastle.jsse.BCApplicationProtocolSelector");
            method5 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return cls.getMethod("select", new Class[]{Object.class, List.class});
                }
            });
            SSLEngine createSSLEngine = SslUtils.getSSLContext("BCJSSE").createSSLEngine();
            method4 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return cls3.getMethod("setParameters", new Class[]{cls4});
                }
            });
            method4.invoke(createSSLEngine, new Object[]{newInstance});
            method3 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return cls4.getMethod("setApplicationProtocols", new Class[]{String[].class});
                }
            });
            method3.invoke(newInstance, new Object[]{EmptyArrays.EMPTY_STRINGS});
            method6 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return cls3.getMethod("getApplicationProtocol", (Class[]) null);
                }
            });
            method6.invoke(createSSLEngine, (Object[]) null);
            method2 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return cls3.getMethod("getHandshakeApplicationProtocol", (Class[]) null);
                }
            });
            method2.invoke(createSSLEngine, (Object[]) null);
            method = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return cls3.getMethod("setBCHandshakeApplicationProtocolSelector", new Class[]{cls});
                }
            });
            method7 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    return cls3.getMethod("getBCHandshakeApplicationProtocolSelector", (Class[]) null);
                }
            });
            method7.invoke(createSSLEngine, (Object[]) null);
            cls2 = cls4;
        } catch (Throwable th) {
            logger.error("Unable to initialize BouncyCastleAlpnSslUtils.", th);
            method7 = null;
            method6 = null;
            cls = null;
            method5 = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        BC_SSL_PARAMETERS = cls2;
        SET_PARAMETERS = method4;
        SET_APPLICATION_PROTOCOLS = method3;
        GET_APPLICATION_PROTOCOL = method6;
        GET_HANDSHAKE_APPLICATION_PROTOCOL = method2;
        SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method;
        GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method7;
        BC_APPLICATION_PROTOCOL_SELECTOR_SELECT = method5;
        BC_APPLICATION_PROTOCOL_SELECTOR = cls;
    }

    private BouncyCastleAlpnSslUtils() {
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
            final Object invoke = GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine, (Object[]) null);
            return new BiFunction<SSLEngine, List<String>, String>() {
                public String apply(SSLEngine sSLEngine, List<String> list) {
                    try {
                        return (String) BouncyCastleAlpnSslUtils.BC_APPLICATION_PROTOCOL_SELECTOR_SELECT.invoke(invoke, new Object[]{sSLEngine, list});
                    } catch (Exception e) {
                        throw new RuntimeException("Could not call getHandshakeApplicationProtocolSelector", e);
                    }
                }
            };
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static void setApplicationProtocols(SSLEngine sSLEngine, List<String> list) {
        SSLParameters sSLParameters = sSLEngine.getSSLParameters();
        String[] strArr = (String[]) list.toArray(EmptyArrays.EMPTY_STRINGS);
        try {
            Object newInstance = BC_SSL_PARAMETERS.newInstance();
            SET_APPLICATION_PROTOCOLS.invoke(newInstance, new Object[]{strArr});
            SET_PARAMETERS.invoke(sSLEngine, new Object[]{newInstance});
            sSLEngine.setSSLParameters(sSLParameters);
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static void setHandshakeApplicationProtocolSelector(SSLEngine sSLEngine, final BiFunction<SSLEngine, List<String>, String> biFunction) {
        try {
            SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine, new Object[]{Proxy.newProxyInstance(BouncyCastleAlpnSslUtils.class.getClassLoader(), new Class[]{BC_APPLICATION_PROTOCOL_SELECTOR}, new InvocationHandler() {
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    if (method.getName().equals("select")) {
                        try {
                            return biFunction.apply(objArr[0], objArr[1]);
                        } catch (ClassCastException e) {
                            throw new RuntimeException("BCApplicationProtocolSelector select method parameter of invalid type.", e);
                        }
                    } else {
                        throw new UnsupportedOperationException(String.format("Method '%s' not supported.", new Object[]{method.getName()}));
                    }
                }
            })});
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }
}
