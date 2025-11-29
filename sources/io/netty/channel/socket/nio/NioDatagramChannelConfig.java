package io.netty.channel.socket.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.channel.socket.DefaultDatagramChannelConfig;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.channels.DatagramChannel;
import java.util.Enumeration;
import java.util.Map;

class NioDatagramChannelConfig extends DefaultDatagramChannelConfig {
    private static final Method GET_OPTION;
    private static final Object IP_MULTICAST_IF;
    private static final Object IP_MULTICAST_LOOP;
    private static final Object IP_MULTICAST_TTL;
    private static final Method SET_OPTION;
    private final DatagramChannel javaChannel;

    static {
        Class<?> cls;
        Class<?> cls2;
        Object obj;
        Object obj2;
        Method method;
        Method method2;
        Class<?> cls3;
        ClassLoader classLoader = PlatformDependent.getClassLoader(DatagramChannel.class);
        Object obj3 = null;
        try {
            cls = Class.forName("java.net.SocketOption", true, classLoader);
        } catch (Exception unused) {
            cls = null;
        }
        try {
            cls2 = Class.forName("java.net.StandardSocketOptions", true, classLoader);
        } catch (Exception unused2) {
            cls2 = null;
        }
        if (cls != null) {
            try {
                Object obj4 = cls2.getDeclaredField("IP_MULTICAST_TTL").get((Object) null);
                try {
                    obj = cls2.getDeclaredField("IP_MULTICAST_IF").get((Object) null);
                    try {
                        obj2 = cls2.getDeclaredField("IP_MULTICAST_LOOP").get((Object) null);
                        try {
                            cls3 = Class.forName("java.nio.channels.NetworkChannel", true, classLoader);
                        } catch (Throwable unused3) {
                            cls3 = null;
                        }
                        if (cls3 == null) {
                            method2 = null;
                            method = null;
                        } else {
                            try {
                                Method declaredMethod = cls3.getDeclaredMethod("getOption", new Class[]{cls});
                                try {
                                    method = cls3.getDeclaredMethod("setOption", new Class[]{cls, Object.class});
                                    method2 = declaredMethod;
                                } catch (Exception e) {
                                    throw new Error("cannot locate the setOption() method", e);
                                }
                            } catch (Exception e2) {
                                throw new Error("cannot locate the getOption() method", e2);
                            }
                        }
                        obj3 = obj4;
                    } catch (Exception e3) {
                        throw new Error("cannot locate the IP_MULTICAST_LOOP field", e3);
                    }
                } catch (Exception e4) {
                    throw new Error("cannot locate the IP_MULTICAST_IF field", e4);
                }
            } catch (Exception e5) {
                throw new Error("cannot locate the IP_MULTICAST_TTL field", e5);
            }
        } else {
            method2 = null;
            method = null;
            obj2 = null;
            obj = null;
        }
        IP_MULTICAST_TTL = obj3;
        IP_MULTICAST_IF = obj;
        IP_MULTICAST_LOOP = obj2;
        GET_OPTION = method2;
        SET_OPTION = method;
    }

    public NioDatagramChannelConfig(NioDatagramChannel nioDatagramChannel, DatagramChannel datagramChannel) {
        super(nioDatagramChannel, datagramChannel.socket());
        this.javaChannel = datagramChannel;
    }

    private Object getOption0(Object obj) {
        Method method = GET_OPTION;
        if (method != null) {
            try {
                return method.invoke(this.javaChannel, new Object[]{obj});
            } catch (Exception e) {
                throw new ChannelException((Throwable) e);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private void setOption0(Object obj, Object obj2) {
        Method method = SET_OPTION;
        if (method != null) {
            try {
                method.invoke(this.javaChannel, new Object[]{obj, obj2});
            } catch (Exception e) {
                throw new ChannelException((Throwable) e);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void autoReadCleared() {
        ((NioDatagramChannel) this.channel).clearReadPending0();
    }

    public InetAddress getInterface() {
        NetworkInterface networkInterface = getNetworkInterface();
        if (networkInterface == null) {
            return null;
        }
        Enumeration<InetAddress> addressesFromNetworkInterface = SocketUtils.addressesFromNetworkInterface(networkInterface);
        if (addressesFromNetworkInterface.hasMoreElements()) {
            return addressesFromNetworkInterface.nextElement();
        }
        return null;
    }

    public NetworkInterface getNetworkInterface() {
        return (NetworkInterface) getOption0(IP_MULTICAST_IF);
    }

    public <T> T getOption(ChannelOption<T> channelOption) {
        return (PlatformDependent.javaVersion() < 7 || !(channelOption instanceof NioChannelOption)) ? super.getOption(channelOption) : NioChannelOption.getOption(this.javaChannel, (NioChannelOption) channelOption);
    }

    public Map<ChannelOption<?>, Object> getOptions() {
        return PlatformDependent.javaVersion() >= 7 ? getOptions(super.getOptions(), NioChannelOption.getOptions(this.javaChannel)) : super.getOptions();
    }

    public int getTimeToLive() {
        return ((Integer) getOption0(IP_MULTICAST_TTL)).intValue();
    }

    public boolean isLoopbackModeDisabled() {
        return ((Boolean) getOption0(IP_MULTICAST_LOOP)).booleanValue();
    }

    public DatagramChannelConfig setInterface(InetAddress inetAddress) {
        try {
            setNetworkInterface(NetworkInterface.getByInetAddress(inetAddress));
            return this;
        } catch (SocketException e) {
            throw new ChannelException((Throwable) e);
        }
    }

    public DatagramChannelConfig setLoopbackModeDisabled(boolean z) {
        setOption0(IP_MULTICAST_LOOP, Boolean.valueOf(z));
        return this;
    }

    public DatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface) {
        setOption0(IP_MULTICAST_IF, networkInterface);
        return this;
    }

    public <T> boolean setOption(ChannelOption<T> channelOption, T t) {
        return (PlatformDependent.javaVersion() < 7 || !(channelOption instanceof NioChannelOption)) ? super.setOption(channelOption, t) : NioChannelOption.setOption(this.javaChannel, (NioChannelOption) channelOption, t);
    }

    public DatagramChannelConfig setTimeToLive(int i) {
        setOption0(IP_MULTICAST_TTL, Integer.valueOf(i));
        return this;
    }

    public DatagramChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }
}
