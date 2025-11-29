package io.netty.resolver.dns;

import io.netty.channel.ChannelFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.DatagramChannel;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.AddressResolverGroup;
import io.netty.resolver.InetSocketAddressResolver;
import io.netty.resolver.NameResolver;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class DnsAddressResolverGroup extends AddressResolverGroup<InetSocketAddress> {
    private final DnsNameResolverBuilder dnsResolverBuilder;
    private final ConcurrentMap<String, Promise<List<InetAddress>>> resolveAllsInProgress = PlatformDependent.newConcurrentHashMap();
    private final ConcurrentMap<String, Promise<InetAddress>> resolvesInProgress = PlatformDependent.newConcurrentHashMap();

    public DnsAddressResolverGroup(DnsNameResolverBuilder dnsNameResolverBuilder) {
        this.dnsResolverBuilder = dnsNameResolverBuilder.copy();
    }

    public AddressResolver<InetSocketAddress> newAddressResolver(EventLoop eventLoop, NameResolver<InetAddress> nameResolver) throws Exception {
        return new InetSocketAddressResolver(eventLoop, nameResolver);
    }

    public NameResolver<InetAddress> newNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsServerAddressStreamProvider dnsServerAddressStreamProvider) throws Exception {
        return this.dnsResolverBuilder.copy().eventLoop(eventLoop).channelFactory(channelFactory).nameServerProvider(dnsServerAddressStreamProvider).build();
    }

    public final AddressResolver<InetSocketAddress> newResolver(EventExecutor eventExecutor) throws Exception {
        if (eventExecutor instanceof EventLoop) {
            EventLoop eventLoop = this.dnsResolverBuilder.eventLoop;
            if (eventLoop == null) {
                eventLoop = (EventLoop) eventExecutor;
            }
            return newResolver(eventLoop, this.dnsResolverBuilder.channelFactory(), this.dnsResolverBuilder.nameServerProvider());
        }
        throw new IllegalStateException("unsupported executor type: " + StringUtil.simpleClassName((Object) eventExecutor) + " (expected: " + StringUtil.simpleClassName((Class<?>) EventLoop.class));
    }

    public DnsAddressResolverGroup(Class<? extends DatagramChannel> cls, DnsServerAddressStreamProvider dnsServerAddressStreamProvider) {
        DnsNameResolverBuilder dnsNameResolverBuilder = new DnsNameResolverBuilder();
        this.dnsResolverBuilder = dnsNameResolverBuilder;
        dnsNameResolverBuilder.channelType(cls).nameServerProvider(dnsServerAddressStreamProvider);
    }

    public DnsAddressResolverGroup(ChannelFactory<? extends DatagramChannel> channelFactory, DnsServerAddressStreamProvider dnsServerAddressStreamProvider) {
        DnsNameResolverBuilder dnsNameResolverBuilder = new DnsNameResolverBuilder();
        this.dnsResolverBuilder = dnsNameResolverBuilder;
        dnsNameResolverBuilder.channelFactory(channelFactory).nameServerProvider(dnsServerAddressStreamProvider);
    }

    @Deprecated
    public AddressResolver<InetSocketAddress> newResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsServerAddressStreamProvider dnsServerAddressStreamProvider) throws Exception {
        return newAddressResolver(eventLoop, new InflightNameResolver(eventLoop, newNameResolver(eventLoop, channelFactory, dnsServerAddressStreamProvider), this.resolvesInProgress, this.resolveAllsInProgress));
    }
}
