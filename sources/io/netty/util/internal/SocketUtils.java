package io.netty.util.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Collections;
import java.util.Enumeration;

public final class SocketUtils {
    private static final Enumeration<Object> EMPTY = Collections.enumeration(Collections.emptyList());

    private SocketUtils() {
    }

    public static SocketChannel accept(final ServerSocketChannel serverSocketChannel) throws IOException {
        try {
            return (SocketChannel) AccessController.doPrivileged(new PrivilegedExceptionAction<SocketChannel>() {
                public SocketChannel run() throws IOException {
                    return serverSocketChannel.accept();
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getCause());
        }
    }

    public static InetAddress addressByName(final String str) throws UnknownHostException {
        try {
            return (InetAddress) AccessController.doPrivileged(new PrivilegedExceptionAction<InetAddress>() {
                public InetAddress run() throws UnknownHostException {
                    return InetAddress.getByName(str);
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((UnknownHostException) e.getCause());
        }
    }

    public static Enumeration<InetAddress> addressesFromNetworkInterface(final NetworkInterface networkInterface) {
        Enumeration<InetAddress> enumeration = (Enumeration) AccessController.doPrivileged(new PrivilegedAction<Enumeration<InetAddress>>() {
            public Enumeration<InetAddress> run() {
                return networkInterface.getInetAddresses();
            }
        });
        return enumeration == null ? empty() : enumeration;
    }

    public static InetAddress[] allAddressesByName(final String str) throws UnknownHostException {
        try {
            return (InetAddress[]) AccessController.doPrivileged(new PrivilegedExceptionAction<InetAddress[]>() {
                public InetAddress[] run() throws UnknownHostException {
                    return InetAddress.getAllByName(str);
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((UnknownHostException) e.getCause());
        }
    }

    public static void bind(final Socket socket, final SocketAddress socketAddress) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
                public Void run() throws IOException {
                    socket.bind(socketAddress);
                    return null;
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getCause());
        }
    }

    public static void connect(final Socket socket, final SocketAddress socketAddress, final int i) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
                public Void run() throws IOException {
                    socket.connect(socketAddress, i);
                    return null;
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getCause());
        }
    }

    private static <T> Enumeration<T> empty() {
        return EMPTY;
    }

    public static byte[] hardwareAddressFromNetworkInterface(final NetworkInterface networkInterface) throws SocketException {
        try {
            return (byte[]) AccessController.doPrivileged(new PrivilegedExceptionAction<byte[]>() {
                public byte[] run() throws SocketException {
                    return networkInterface.getHardwareAddress();
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((SocketException) e.getCause());
        }
    }

    public static SocketAddress localSocketAddress(final ServerSocket serverSocket) {
        return (SocketAddress) AccessController.doPrivileged(new PrivilegedAction<SocketAddress>() {
            public SocketAddress run() {
                return serverSocket.getLocalSocketAddress();
            }
        });
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static InetAddress loopbackAddress() {
        return (InetAddress) AccessController.doPrivileged(new PrivilegedAction<InetAddress>() {
            public InetAddress run() {
                if (PlatformDependent.javaVersion() >= 7) {
                    return InetAddress.getLoopbackAddress();
                }
                try {
                    return InetAddress.getByName((String) null);
                } catch (UnknownHostException e) {
                    throw new IllegalStateException(e);
                }
            }
        });
    }

    public static InetSocketAddress socketAddress(final String str, final int i) {
        return (InetSocketAddress) AccessController.doPrivileged(new PrivilegedAction<InetSocketAddress>() {
            public InetSocketAddress run() {
                return new InetSocketAddress(str, i);
            }
        });
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static void bind(final SocketChannel socketChannel, final SocketAddress socketAddress) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
                public Void run() throws IOException {
                    socketChannel.bind(socketAddress);
                    return null;
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getCause());
        }
    }

    public static boolean connect(final SocketChannel socketChannel, final SocketAddress socketAddress) throws IOException {
        try {
            return ((Boolean) AccessController.doPrivileged(new PrivilegedExceptionAction<Boolean>() {
                public Boolean run() throws IOException {
                    return Boolean.valueOf(socketChannel.connect(socketAddress));
                }
            })).booleanValue();
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getCause());
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static void bind(final DatagramChannel datagramChannel, final SocketAddress socketAddress) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
                public Void run() throws IOException {
                    datagramChannel.bind(socketAddress);
                    return null;
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getCause());
        }
    }
}
