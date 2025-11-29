package io.netty.resolver.dns;

import io.netty.util.NetUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DefaultDnsServerAddressStreamProvider implements DnsServerAddressStreamProvider {
    private static final DnsServerAddresses DEFAULT_NAME_SERVERS;
    private static final List<InetSocketAddress> DEFAULT_NAME_SERVER_LIST;
    static final int DNS_PORT = 53;
    public static final DefaultDnsServerAddressStreamProvider INSTANCE = new DefaultDnsServerAddressStreamProvider();
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultDnsServerAddressStreamProvider.class);

    static {
        ArrayList arrayList = new ArrayList(2);
        if (!PlatformDependent.isAndroid()) {
            DirContextUtils.addNameServers(arrayList, 53);
        }
        if (PlatformDependent.javaVersion() < 9 && arrayList.isEmpty()) {
            try {
                Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
                for (String str : (List) cls.getMethod("nameservers", (Class[]) null).invoke(cls.getMethod("open", (Class[]) null).invoke((Object) null, (Object[]) null), (Object[]) null)) {
                    if (str != null) {
                        arrayList.add(new InetSocketAddress(SocketUtils.addressByName(str), 53));
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (!arrayList.isEmpty()) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Default DNS servers: {} (sun.net.dns.ResolverConfiguration)", (Object) arrayList);
            }
        } else {
            if (NetUtil.isIpV6AddressesPreferred() || ((NetUtil.LOCALHOST instanceof Inet6Address) && !NetUtil.isIpV4StackPreferred())) {
                Collections.addAll(arrayList, new InetSocketAddress[]{SocketUtils.socketAddress("2001:4860:4860::8888", 53), SocketUtils.socketAddress("2001:4860:4860::8844", 53)});
            } else {
                Collections.addAll(arrayList, new InetSocketAddress[]{SocketUtils.socketAddress("8.8.8.8", 53), SocketUtils.socketAddress("8.8.4.4", 53)});
            }
            InternalLogger internalLogger2 = logger;
            if (internalLogger2.isWarnEnabled()) {
                internalLogger2.warn("Default DNS servers: {} (Google Public DNS as a fallback)", (Object) arrayList);
            }
        }
        List<InetSocketAddress> unmodifiableList = Collections.unmodifiableList(arrayList);
        DEFAULT_NAME_SERVER_LIST = unmodifiableList;
        DEFAULT_NAME_SERVERS = DnsServerAddresses.sequential((Iterable<? extends InetSocketAddress>) unmodifiableList);
    }

    private DefaultDnsServerAddressStreamProvider() {
    }

    public static List<InetSocketAddress> defaultAddressList() {
        return DEFAULT_NAME_SERVER_LIST;
    }

    public static DnsServerAddresses defaultAddresses() {
        return DEFAULT_NAME_SERVERS;
    }

    public DnsServerAddressStream nameServerAddressStream(String str) {
        return DEFAULT_NAME_SERVERS.stream();
    }
}
