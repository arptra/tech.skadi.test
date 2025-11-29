package io.netty.resolver.dns;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.dns.DatagramDnsQueryEncoder;
import io.netty.handler.codec.dns.DatagramDnsResponse;
import io.netty.handler.codec.dns.DatagramDnsResponseDecoder;
import io.netty.handler.codec.dns.DefaultDnsRawRecord;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.TcpDnsQueryEncoder;
import io.netty.handler.codec.dns.TcpDnsResponseDecoder;
import io.netty.resolver.DefaultHostsFileEntriesResolver;
import io.netty.resolver.HostsFileEntriesResolver;
import io.netty.resolver.InetNameResolver;
import io.netty.resolver.ResolvedAddressTypes;
import io.netty.util.NetUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.IDN;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DnsNameResolver extends InetNameResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* access modifiers changed from: private */
    public static final DatagramDnsResponseDecoder DATAGRAM_DECODER = new DatagramDnsResponseDecoder() {
        public DnsResponse decodeResponse(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
            DnsResponse decodeResponse = super.decodeResponse(channelHandlerContext, datagramPacket);
            if (((ByteBuf) datagramPacket.content()).isReadable()) {
                decodeResponse.setTruncated(true);
                if (DnsNameResolver.logger.isDebugEnabled()) {
                    DnsNameResolver.logger.debug("{} RECEIVED: UDP truncated packet received, consider adjusting maxPayloadSize for the {}.", channelHandlerContext.channel(), StringUtil.simpleClassName((Class<?>) DnsNameResolver.class));
                }
            }
            return decodeResponse;
        }
    };
    /* access modifiers changed from: private */
    public static final DatagramDnsQueryEncoder DATAGRAM_ENCODER = new DatagramDnsQueryEncoder();
    private static final UnixResolverOptions DEFAULT_OPTIONS;
    static final ResolvedAddressTypes DEFAULT_RESOLVE_ADDRESS_TYPES;
    static final String[] DEFAULT_SEARCH_DOMAINS;
    /* access modifiers changed from: private */
    public static final DnsRecord[] EMPTY_ADDITIONALS = new DnsRecord[0];
    private static final InternetProtocolFamily[] IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV4_ONLY_RESOLVED_RECORD_TYPES;
    private static final InternetProtocolFamily[] IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV4_PREFERRED_RESOLVED_RECORD_TYPES;
    private static final InternetProtocolFamily[] IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV6_ONLY_RESOLVED_RECORD_TYPES;
    private static final InternetProtocolFamily[] IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV6_PREFERRED_RESOLVED_RECORD_TYPES;
    private static final String LOCALHOST = "localhost";
    private static final InetAddress LOCALHOST_ADDRESS;
    /* access modifiers changed from: private */
    public static final TcpDnsQueryEncoder TCP_ENCODER = new TcpDnsQueryEncoder();
    private static final String WINDOWS_HOST_NAME;
    /* access modifiers changed from: private */
    public static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DnsNameResolver.class);
    private final AuthoritativeDnsServerCache authoritativeDnsServerCache;
    final Channel ch;
    final Promise<Channel> channelReadyPromise;
    private final DnsCnameCache cnameCache;
    private final boolean completeOncePreferredResolved;
    private final boolean decodeIdn;
    private final DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory;
    /* access modifiers changed from: private */
    public final DnsServerAddressStreamProvider dnsServerAddressStreamProvider;
    private final HostsFileEntriesResolver hostsFileEntriesResolver;
    private final int maxPayloadSize;
    private final int maxQueriesPerResolve;
    private final FastThreadLocal<DnsServerAddressStream> nameServerAddrStream;
    private final Comparator<InetSocketAddress> nameServerComparator;
    private final int ndots;
    private final boolean optResourceEnabled;
    private final InternetProtocolFamily preferredAddressType;
    final DnsQueryContextManager queryContextManager;
    private final long queryTimeoutMillis;
    private final boolean recursionDesired;
    private final DnsCache resolveCache;
    private final DnsRecordType[] resolveRecordTypes;
    private final ResolvedAddressTypes resolvedAddressTypes;
    private final InternetProtocolFamily[] resolvedInternetProtocolFamilies;
    private final String[] searchDomains;
    /* access modifiers changed from: private */
    public final ChannelFactory<? extends SocketChannel> socketChannelFactory;
    private final boolean supportsAAAARecords;
    private final boolean supportsARecords;

    /* renamed from: io.netty.resolver.dns.DnsNameResolver$8  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$resolver$ResolvedAddressTypes;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.netty.resolver.ResolvedAddressTypes[] r0 = io.netty.resolver.ResolvedAddressTypes.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes = r0
                io.netty.resolver.ResolvedAddressTypes r1 = io.netty.resolver.ResolvedAddressTypes.IPV4_ONLY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$resolver$ResolvedAddressTypes     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.resolver.ResolvedAddressTypes r1 = io.netty.resolver.ResolvedAddressTypes.IPV4_PREFERRED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$resolver$ResolvedAddressTypes     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.resolver.ResolvedAddressTypes r1 = io.netty.resolver.ResolvedAddressTypes.IPV6_ONLY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$resolver$ResolvedAddressTypes     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.resolver.ResolvedAddressTypes r1 = io.netty.resolver.ResolvedAddressTypes.IPV6_PREFERRED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.DnsNameResolver.AnonymousClass8.<clinit>():void");
        }
    }

    public static final class AddressedEnvelopeAdapter implements AddressedEnvelope<DnsResponse, InetSocketAddress> {
        private final InetSocketAddress recipient;
        private final DnsResponse response;
        private final InetSocketAddress sender;

        public AddressedEnvelopeAdapter(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, DnsResponse dnsResponse) {
            this.sender = inetSocketAddress;
            this.recipient = inetSocketAddress2;
            this.response = dnsResponse;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AddressedEnvelope)) {
                return false;
            }
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            if (sender() == null) {
                if (addressedEnvelope.sender() != null) {
                    return false;
                }
            } else if (!sender().equals(addressedEnvelope.sender())) {
                return false;
            }
            if (recipient() == null) {
                if (addressedEnvelope.recipient() != null) {
                    return false;
                }
            } else if (!recipient().equals(addressedEnvelope.recipient())) {
                return false;
            }
            return this.response.equals(obj);
        }

        public int hashCode() {
            int hashCode = this.response.hashCode();
            if (sender() != null) {
                hashCode = (hashCode * 31) + sender().hashCode();
            }
            return recipient() != null ? (hashCode * 31) + recipient().hashCode() : hashCode;
        }

        public int refCnt() {
            return this.response.refCnt();
        }

        public boolean release() {
            return this.response.release();
        }

        public DnsResponse content() {
            return this.response;
        }

        public InetSocketAddress recipient() {
            return this.recipient;
        }

        public boolean release(int i) {
            return this.response.release(i);
        }

        public InetSocketAddress sender() {
            return this.sender;
        }

        public AddressedEnvelope<DnsResponse, InetSocketAddress> retain() {
            this.response.retain();
            return this;
        }

        public AddressedEnvelope<DnsResponse, InetSocketAddress> touch() {
            this.response.touch();
            return this;
        }

        public AddressedEnvelope<DnsResponse, InetSocketAddress> retain(int i) {
            this.response.retain(i);
            return this;
        }

        public AddressedEnvelope<DnsResponse, InetSocketAddress> touch(Object obj) {
            this.response.touch(obj);
            return this;
        }
    }

    public final class DnsResponseHandler extends ChannelInboundHandlerAdapter {
        private final Promise<Channel> channelActivePromise;

        public DnsResponseHandler(Promise<Channel> promise) {
            this.channelActivePromise = promise;
        }

        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.channelActive(channelHandlerContext);
            this.channelActivePromise.trySuccess(channelHandlerContext.channel());
        }

        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            final DatagramDnsResponse datagramDnsResponse = (DatagramDnsResponse) obj;
            final int id = datagramDnsResponse.id();
            if (DnsNameResolver.logger.isDebugEnabled()) {
                DnsNameResolver.logger.debug("{} RECEIVED: UDP [{}: {}], {}", DnsNameResolver.this.ch, Integer.valueOf(id), datagramDnsResponse.sender(), datagramDnsResponse);
            }
            final DnsQueryContext dnsQueryContext = DnsNameResolver.this.queryContextManager.get(datagramDnsResponse.sender(), id);
            if (dnsQueryContext == null) {
                DnsNameResolver.logger.debug("Received a DNS response with an unknown ID: UDP [{}: {}]", DnsNameResolver.this.ch, Integer.valueOf(id));
                datagramDnsResponse.release();
            } else if (!datagramDnsResponse.isTruncated() || DnsNameResolver.this.socketChannelFactory == null) {
                dnsQueryContext.finish(datagramDnsResponse);
            } else {
                Bootstrap bootstrap = new Bootstrap();
                ((Bootstrap) ((Bootstrap) ((Bootstrap) bootstrap.option(ChannelOption.SO_REUSEADDR, Boolean.TRUE)).group(DnsNameResolver.this.executor())).channelFactory(DnsNameResolver.this.socketChannelFactory)).handler(DnsNameResolver.TCP_ENCODER);
                bootstrap.connect(datagramDnsResponse.sender()).addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) {
                        if (!channelFuture.isSuccess()) {
                            if (DnsNameResolver.logger.isDebugEnabled()) {
                                DnsNameResolver.logger.debug("Unable to fallback to TCP [{}]", Integer.valueOf(id), channelFuture.cause());
                            }
                            dnsQueryContext.finish(datagramDnsResponse);
                            return;
                        }
                        final Channel channel = channelFuture.channel();
                        Promise newPromise = channel.eventLoop().newPromise();
                        final TcpDnsQueryContext tcpDnsQueryContext = new TcpDnsQueryContext(DnsNameResolver.this, channel, (InetSocketAddress) channel.remoteAddress(), dnsQueryContext.question(), DnsNameResolver.EMPTY_ADDITIONALS, newPromise);
                        channel.pipeline().addLast(new TcpDnsResponseDecoder());
                        channel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                            public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
                                Channel channel = channelHandlerContext.channel();
                                DnsResponse dnsResponse = (DnsResponse) obj;
                                int id = dnsResponse.id();
                                if (DnsNameResolver.logger.isDebugEnabled()) {
                                    DnsNameResolver.logger.debug("{} RECEIVED: TCP [{}: {}], {}", channel, Integer.valueOf(id), channel.remoteAddress(), dnsResponse);
                                }
                                AnonymousClass1 r2 = AnonymousClass1.this;
                                DnsQueryContext dnsQueryContext = DnsNameResolver.this.queryContextManager.get(datagramDnsResponse.sender(), id);
                                TcpDnsQueryContext tcpDnsQueryContext = tcpDnsQueryContext;
                                if (dnsQueryContext == tcpDnsQueryContext) {
                                    tcpDnsQueryContext.finish(new AddressedEnvelopeAdapter((InetSocketAddress) channelHandlerContext.channel().remoteAddress(), (InetSocketAddress) channelHandlerContext.channel().localAddress(), dnsResponse));
                                    return;
                                }
                                dnsResponse.release();
                                tcpDnsQueryContext.tryFailure("Received TCP DNS response with unexpected ID", (Throwable) null, false);
                                DnsNameResolver.logger.debug("Received a DNS response with an unexpected ID: TCP [{}: {}]", channel, Integer.valueOf(id));
                            }

                            public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
                                if (tcpDnsQueryContext.tryFailure("TCP fallback error", th, false) && DnsNameResolver.logger.isDebugEnabled()) {
                                    DnsNameResolver.logger.debug("{} Error during processing response: TCP [{}: {}]", channelHandlerContext.channel(), Integer.valueOf(id), channelHandlerContext.channel().remoteAddress(), th);
                                }
                            }
                        });
                        newPromise.addListener(new FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>>() {
                            public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
                                channel.close();
                                if (future.isSuccess()) {
                                    dnsQueryContext.finish(future.getNow());
                                    datagramDnsResponse.release();
                                    return;
                                }
                                AnonymousClass1 r1 = AnonymousClass1.this;
                                dnsQueryContext.finish(datagramDnsResponse);
                            }
                        });
                        tcpDnsQueryContext.query(true, channelFuture.channel().newPromise());
                    }
                });
            }
        }

        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
            if (th instanceof CorruptedFrameException) {
                DnsNameResolver.logger.debug("Unable to decode DNS response: UDP [{}]", channelHandlerContext.channel(), th);
            } else {
                DnsNameResolver.logger.warn("Unexpected exception: UDP [{}]", channelHandlerContext.channel(), th);
            }
        }
    }

    static {
        String[] strArr;
        UnixResolverOptions unixResolverOptions;
        DnsRecordType dnsRecordType = DnsRecordType.A;
        IPV4_ONLY_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType};
        InternetProtocolFamily internetProtocolFamily = InternetProtocolFamily.IPv4;
        IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily};
        DnsRecordType dnsRecordType2 = DnsRecordType.AAAA;
        IPV4_PREFERRED_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType, dnsRecordType2};
        InternetProtocolFamily internetProtocolFamily2 = InternetProtocolFamily.IPv6;
        IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily, internetProtocolFamily2};
        IPV6_ONLY_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType2};
        IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily2};
        IPV6_PREFERRED_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType2, dnsRecordType};
        IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily2, internetProtocolFamily};
        if (NetUtil.isIpV4StackPreferred() || !anyInterfaceSupportsIpV6()) {
            DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV4_ONLY;
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
        } else if (NetUtil.isIpV6AddressesPreferred()) {
            DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV6_PREFERRED;
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST6;
        } else {
            DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV4_PREFERRED;
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
        }
        String str = null;
        try {
            if (PlatformDependent.isWindows()) {
                str = InetAddress.getLocalHost().getHostName();
            }
        } catch (Exception unused) {
        }
        WINDOWS_HOST_NAME = str;
        try {
            strArr = (String[]) (PlatformDependent.isWindows() ? getSearchDomainsHack() : UnixResolverDnsServerAddressStreamProvider.parseEtcResolverSearchDomains()).toArray(new String[0]);
        } catch (Exception unused2) {
            strArr = EmptyArrays.EMPTY_STRINGS;
        }
        DEFAULT_SEARCH_DOMAINS = strArr;
        try {
            unixResolverOptions = UnixResolverDnsServerAddressStreamProvider.parseEtcResolverOptions();
        } catch (Exception unused3) {
            unixResolverOptions = UnixResolverOptions.newBuilder().build();
        }
        DEFAULT_OPTIONS = unixResolverOptions;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DnsNameResolver(io.netty.channel.EventLoop r22, io.netty.channel.ChannelFactory<? extends io.netty.channel.socket.DatagramChannel> r23, io.netty.resolver.dns.DnsCache r24, io.netty.resolver.dns.DnsCache r25, io.netty.resolver.dns.DnsQueryLifecycleObserverFactory r26, long r27, io.netty.resolver.ResolvedAddressTypes r29, boolean r30, int r31, boolean r32, int r33, boolean r34, io.netty.resolver.HostsFileEntriesResolver r35, io.netty.resolver.dns.DnsServerAddressStreamProvider r36, java.lang.String[] r37, int r38, boolean r39) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r5 = r26
            r6 = r27
            r8 = r29
            r9 = r30
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            r16 = r37
            r17 = r38
            r18 = r39
            io.netty.resolver.dns.AuthoritativeDnsServerCacheAdapter r4 = new io.netty.resolver.dns.AuthoritativeDnsServerCacheAdapter
            r21 = r4
            r19 = r0
            r0 = r25
            r20 = r1
            r1 = r21
            r21 = r20
            r1.<init>(r0)
            r1 = r21
            r0 = r19
            r0.<init>((io.netty.channel.EventLoop) r1, (io.netty.channel.ChannelFactory<? extends io.netty.channel.socket.DatagramChannel>) r2, (io.netty.resolver.dns.DnsCache) r3, (io.netty.resolver.dns.AuthoritativeDnsServerCache) r4, (io.netty.resolver.dns.DnsQueryLifecycleObserverFactory) r5, (long) r6, (io.netty.resolver.ResolvedAddressTypes) r8, (boolean) r9, (int) r10, (boolean) r11, (int) r12, (boolean) r13, (io.netty.resolver.HostsFileEntriesResolver) r14, (io.netty.resolver.dns.DnsServerAddressStreamProvider) r15, (java.lang.String[]) r16, (int) r17, (boolean) r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.DnsNameResolver.<init>(io.netty.channel.EventLoop, io.netty.channel.ChannelFactory, io.netty.resolver.dns.DnsCache, io.netty.resolver.dns.DnsCache, io.netty.resolver.dns.DnsQueryLifecycleObserverFactory, long, io.netty.resolver.ResolvedAddressTypes, boolean, int, boolean, int, boolean, io.netty.resolver.HostsFileEntriesResolver, io.netty.resolver.dns.DnsServerAddressStreamProvider, java.lang.String[], int, boolean):void");
    }

    private static boolean anyInterfaceSupportsIpV6() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if ((nextElement instanceof Inet6Address) && !nextElement.isAnyLocalAddress() && !nextElement.isLoopbackAddress() && !nextElement.isLinkLocalAddress()) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (SocketException e) {
            logger.debug("Unable to detect if any interface supports IPv6, assuming IPv4-only", (Throwable) e);
            return false;
        }
    }

    private static Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> cast(Promise<?> promise) {
        return promise;
    }

    public static boolean doResolveAllCached(String str, DnsRecord[] dnsRecordArr, Promise<List<InetAddress>> promise, DnsCache dnsCache, InternetProtocolFamily[] internetProtocolFamilyArr) {
        List<? extends DnsCacheEntry> list = dnsCache.get(str, dnsRecordArr);
        if (list == null || list.isEmpty()) {
            return false;
        }
        Throwable cause = ((DnsCacheEntry) list.get(0)).cause();
        if (cause == null) {
            int size = list.size();
            ArrayList arrayList = null;
            for (InternetProtocolFamily internetProtocolFamily : internetProtocolFamilyArr) {
                for (int i = 0; i < size; i++) {
                    DnsCacheEntry dnsCacheEntry = (DnsCacheEntry) list.get(i);
                    if (internetProtocolFamily.addressType().isInstance(dnsCacheEntry.address())) {
                        if (arrayList == null) {
                            arrayList = new ArrayList(size);
                        }
                        arrayList.add(dnsCacheEntry.address());
                    }
                }
            }
            if (arrayList == null) {
                return false;
            }
            trySuccess(promise, arrayList);
            return true;
        }
        tryFailure(promise, cause);
        return true;
    }

    private void doResolveAllUncached(String str, DnsRecord[] dnsRecordArr, Promise<?> promise, Promise<List<InetAddress>> promise2, DnsCache dnsCache, boolean z) {
        EventLoop executor = executor();
        if (executor.inEventLoop()) {
            doResolveAllUncached0(str, dnsRecordArr, promise, promise2, dnsCache, z);
            return;
        }
        final String str2 = str;
        final DnsRecord[] dnsRecordArr2 = dnsRecordArr;
        final Promise<?> promise3 = promise;
        final Promise<List<InetAddress>> promise4 = promise2;
        final DnsCache dnsCache2 = dnsCache;
        final boolean z2 = z;
        executor.execute(new Runnable() {
            public void run() {
                DnsNameResolver.this.doResolveAllUncached0(str2, dnsRecordArr2, promise3, promise4, dnsCache2, z2);
            }
        });
    }

    /* access modifiers changed from: private */
    public void doResolveAllUncached0(String str, DnsRecord[] dnsRecordArr, Promise<?> promise, Promise<List<InetAddress>> promise2, DnsCache dnsCache, boolean z) {
        DnsServerAddressStream nameServerAddressStream = this.dnsServerAddressStreamProvider.nameServerAddressStream(str);
        int i = this.maxQueriesPerResolve;
        AuthoritativeDnsServerCache authoritativeDnsServerCache2 = this.authoritativeDnsServerCache;
        Promise<List<InetAddress>> promise3 = promise2;
        new DnsAddressResolveContext(this, promise, str, dnsRecordArr, nameServerAddressStream, i, dnsCache, authoritativeDnsServerCache2, z).resolve(promise2);
    }

    private boolean doResolveCached(String str, DnsRecord[] dnsRecordArr, Promise<InetAddress> promise, DnsCache dnsCache) {
        List<? extends DnsCacheEntry> list = dnsCache.get(str, dnsRecordArr);
        if (list == null || list.isEmpty()) {
            return false;
        }
        Throwable cause = ((DnsCacheEntry) list.get(0)).cause();
        if (cause == null) {
            int size = list.size();
            for (InternetProtocolFamily internetProtocolFamily : this.resolvedInternetProtocolFamilies) {
                for (int i = 0; i < size; i++) {
                    DnsCacheEntry dnsCacheEntry = (DnsCacheEntry) list.get(i);
                    if (internetProtocolFamily.addressType().isInstance(dnsCacheEntry.address())) {
                        trySuccess(promise, dnsCacheEntry.address());
                        return true;
                    }
                }
            }
            return false;
        }
        tryFailure(promise, cause);
        return true;
    }

    private void doResolveUncached(String str, DnsRecord[] dnsRecordArr, final Promise<InetAddress> promise, DnsCache dnsCache, boolean z) {
        Promise newPromise = executor().newPromise();
        doResolveAllUncached(str, dnsRecordArr, promise, newPromise, dnsCache, true);
        newPromise.addListener(new FutureListener<List<InetAddress>>() {
            public void operationComplete(Future<List<InetAddress>> future) {
                if (future.isSuccess()) {
                    DnsNameResolver.trySuccess(promise, future.getNow().get(0));
                } else {
                    DnsNameResolver.tryFailure(promise, future.cause());
                }
            }
        });
    }

    private static List<String> getSearchDomainsHack() throws Exception {
        if (PlatformDependent.javaVersion() >= 9) {
            return Collections.emptyList();
        }
        Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
        return (List) cls.getMethod("searchlist", (Class[]) null).invoke(cls.getMethod("open", (Class[]) null).invoke((Object) null, (Object[]) null), (Object[]) null);
    }

    private static String hostname(String str) {
        String ascii = IDN.toASCII(str);
        if (!StringUtil.endsWith(str, '.') || StringUtil.endsWith(ascii, '.')) {
            return ascii;
        }
        return ascii + ".";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = WINDOWS_HOST_NAME;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isLocalWindowsHost(java.lang.String r1) {
        /*
            boolean r0 = io.netty.util.internal.PlatformDependent.isWindows()
            if (r0 == 0) goto L_0x001a
            java.lang.String r0 = "localhost"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = WINDOWS_HOST_NAME
            if (r0 == 0) goto L_0x001a
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x001a
        L_0x0018:
            r1 = 1
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.DnsNameResolver.isLocalWindowsHost(java.lang.String):boolean");
    }

    public static boolean isTimeoutError(Throwable th) {
        return th != null && (th.getCause() instanceof DnsNameResolverTimeoutException);
    }

    public static boolean isTransportOrTimeoutError(Throwable th) {
        return th != null && (th.getCause() instanceof DnsNameResolverException);
    }

    private InetAddress loopbackAddress() {
        return preferredAddressType().localhost();
    }

    private InetSocketAddress nextNameServerAddress() {
        return this.nameServerAddrStream.get().next();
    }

    public static InternetProtocolFamily preferredAddressType(ResolvedAddressTypes resolvedAddressTypes2) {
        int i = AnonymousClass8.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[resolvedAddressTypes2.ordinal()];
        if (i == 1 || i == 2) {
            return InternetProtocolFamily.IPv4;
        }
        if (i == 3 || i == 4) {
            return InternetProtocolFamily.IPv6;
        }
        throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes2);
    }

    private List<InetAddress> resolveHostsFileEntries(String str) {
        List<InetAddress> list;
        HostsFileEntriesResolver hostsFileEntriesResolver2 = this.hostsFileEntriesResolver;
        List<InetAddress> list2 = null;
        if (hostsFileEntriesResolver2 == null) {
            return null;
        }
        if (hostsFileEntriesResolver2 instanceof DefaultHostsFileEntriesResolver) {
            list = ((DefaultHostsFileEntriesResolver) hostsFileEntriesResolver2).addresses(str, this.resolvedAddressTypes);
        } else {
            InetAddress address = hostsFileEntriesResolver2.address(str, this.resolvedAddressTypes);
            if (address != null) {
                list2 = Collections.singletonList(address);
            }
            list = list2;
        }
        return (list != null || !isLocalWindowsHost(str)) ? list : Collections.singletonList(LOCALHOST_ADDRESS);
    }

    private InetAddress resolveHostsFileEntry(String str) {
        HostsFileEntriesResolver hostsFileEntriesResolver2 = this.hostsFileEntriesResolver;
        if (hostsFileEntriesResolver2 == null) {
            return null;
        }
        InetAddress address = hostsFileEntriesResolver2.address(str, this.resolvedAddressTypes);
        return (address != null || !isLocalWindowsHost(str)) ? address : LOCALHOST_ADDRESS;
    }

    private static DnsRecord[] toArray(Iterable<DnsRecord> iterable, boolean z) {
        ObjectUtil.checkNotNull(iterable, "additionals");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            for (DnsRecord validateAdditional : iterable) {
                validateAdditional(validateAdditional, z);
            }
            return (DnsRecord[]) collection.toArray(new DnsRecord[collection.size()]);
        }
        Iterator<DnsRecord> it = iterable.iterator();
        if (!it.hasNext()) {
            return EMPTY_ADDITIONALS;
        }
        ArrayList arrayList = new ArrayList();
        do {
            DnsRecord next = it.next();
            validateAdditional(next, z);
            arrayList.add(next);
        } while (it.hasNext());
        return (DnsRecord[]) arrayList.toArray(new DnsRecord[arrayList.size()]);
    }

    /* access modifiers changed from: private */
    public static void tryFailure(Promise<?> promise, Throwable th) {
        if (!promise.tryFailure(th)) {
            logger.trace("Failed to notify failure to a promise: {}", promise, th);
        }
    }

    public static <T> boolean trySuccess(Promise<T> promise, T t) {
        boolean trySuccess = promise.trySuccess(t);
        if (!trySuccess) {
            logger.trace("Failed to notify success ({}) to a promise: {}", t, promise);
        }
        return trySuccess;
    }

    private static void validateAdditional(DnsRecord dnsRecord, boolean z) {
        ObjectUtil.checkNotNull(dnsRecord, "record");
        if (z && (dnsRecord instanceof DnsRawRecord)) {
            throw new IllegalArgumentException("DnsRawRecord implementations not allowed: " + dnsRecord);
        }
    }

    public AuthoritativeDnsServerCache authoritativeDnsServerCache() {
        return this.authoritativeDnsServerCache;
    }

    public void close() {
        if (this.ch.isOpen()) {
            this.ch.close();
        }
    }

    public DnsCnameCache cnameCache() {
        return this.cnameCache;
    }

    public final DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory() {
        return this.dnsQueryLifecycleObserverFactory;
    }

    public void doResolve(String str, Promise<InetAddress> promise) throws Exception {
        doResolve(str, EMPTY_ADDITIONALS, promise, this.resolveCache);
    }

    public void doResolveAll(String str, Promise<List<InetAddress>> promise) throws Exception {
        doResolveAll(str, EMPTY_ADDITIONALS, promise, this.resolveCache);
    }

    public final void flushQueries() {
        this.ch.flush();
    }

    public HostsFileEntriesResolver hostsFileEntriesResolver() {
        return this.hostsFileEntriesResolver;
    }

    public final boolean isDecodeIdn() {
        return this.decodeIdn;
    }

    public boolean isOptResourceEnabled() {
        return this.optResourceEnabled;
    }

    public boolean isRecursionDesired() {
        return this.recursionDesired;
    }

    public int maxPayloadSize() {
        return this.maxPayloadSize;
    }

    public int maxQueriesPerResolve() {
        return this.maxQueriesPerResolve;
    }

    public final int ndots() {
        return this.ndots;
    }

    public final DnsServerAddressStream newNameServerAddressStream(String str) {
        return this.dnsServerAddressStreamProvider.nameServerAddressStream(str);
    }

    public DnsServerAddressStream newRedirectDnsServerStream(String str, List<InetSocketAddress> list) {
        DnsServerAddressStream dnsServerAddressStream = authoritativeDnsServerCache().get(str);
        if (dnsServerAddressStream != null && dnsServerAddressStream.size() != 0) {
            return dnsServerAddressStream;
        }
        Collections.sort(list, this.nameServerComparator);
        return new SequentialDnsServerAddressStream(list, 0);
    }

    public InetSocketAddress newRedirectServerAddress(InetAddress inetAddress) {
        return new InetSocketAddress(inetAddress, 53);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion) {
        return query(nextNameServerAddress(), dnsQuestion);
    }

    public final Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query0(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, boolean z, ChannelPromise channelPromise, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> cast = cast((Promise) ObjectUtil.checkNotNull(promise, "promise"));
        try {
            new DatagramDnsQueryContext(this, inetSocketAddress, dnsQuestion, dnsRecordArr, cast).query(z, channelPromise);
            return cast;
        } catch (Exception e) {
            return cast.setFailure(e);
        }
    }

    public long queryTimeoutMillis() {
        return this.queryTimeoutMillis;
    }

    public final Future<InetAddress> resolve(String str, Iterable<DnsRecord> iterable) {
        return resolve(str, iterable, executor().newPromise());
    }

    public final Future<List<InetAddress>> resolveAll(String str, Iterable<DnsRecord> iterable) {
        return resolveAll(str, iterable, (Promise<List<InetAddress>>) executor().newPromise());
    }

    public DnsCache resolveCache() {
        return this.resolveCache;
    }

    public final DnsRecordType[] resolveRecordTypes() {
        return this.resolveRecordTypes;
    }

    public ResolvedAddressTypes resolvedAddressTypes() {
        return this.resolvedAddressTypes;
    }

    public InternetProtocolFamily[] resolvedInternetProtocolFamiliesUnsafe() {
        return this.resolvedInternetProtocolFamilies;
    }

    public final String[] searchDomains() {
        return this.searchDomains;
    }

    public final boolean supportsAAAARecords() {
        return this.supportsAAAARecords;
    }

    public final boolean supportsARecords() {
        return this.supportsARecords;
    }

    @Deprecated
    public DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsCache dnsCache, AuthoritativeDnsServerCache authoritativeDnsServerCache2, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory2, long j, ResolvedAddressTypes resolvedAddressTypes2, boolean z, int i, boolean z2, int i2, boolean z3, HostsFileEntriesResolver hostsFileEntriesResolver2, DnsServerAddressStreamProvider dnsServerAddressStreamProvider2, String[] strArr, int i3, boolean z4) {
        this(eventLoop, channelFactory, (ChannelFactory<? extends SocketChannel>) null, dnsCache, NoopDnsCnameCache.INSTANCE, authoritativeDnsServerCache2, dnsQueryLifecycleObserverFactory2, j, resolvedAddressTypes2, z, i, z2, i2, z3, hostsFileEntriesResolver2, dnsServerAddressStreamProvider2, strArr, i3, z4, false);
    }

    public void doResolve(String str, DnsRecord[] dnsRecordArr, Promise<InetAddress> promise, DnsCache dnsCache) throws Exception {
        if (str == null || str.isEmpty()) {
            promise.setSuccess(loopbackAddress());
            return;
        }
        InetAddress createInetAddressFromIpAddressString = NetUtil.createInetAddressFromIpAddressString(str);
        if (createInetAddressFromIpAddressString != null) {
            promise.setSuccess(createInetAddressFromIpAddressString);
            return;
        }
        String hostname = hostname(str);
        InetAddress resolveHostsFileEntry = resolveHostsFileEntry(hostname);
        if (resolveHostsFileEntry != null) {
            promise.setSuccess(resolveHostsFileEntry);
        } else if (!doResolveCached(hostname, dnsRecordArr, promise, dnsCache)) {
            doResolveUncached(hostname, dnsRecordArr, promise, dnsCache, true);
        }
    }

    public void doResolveAll(String str, DnsRecord[] dnsRecordArr, Promise<List<InetAddress>> promise, DnsCache dnsCache) throws Exception {
        if (str == null || str.isEmpty()) {
            promise.setSuccess(Collections.singletonList(loopbackAddress()));
            return;
        }
        InetAddress createInetAddressFromIpAddressString = NetUtil.createInetAddressFromIpAddressString(str);
        if (createInetAddressFromIpAddressString != null) {
            promise.setSuccess(Collections.singletonList(createInetAddressFromIpAddressString));
            return;
        }
        String hostname = hostname(str);
        List<InetAddress> resolveHostsFileEntries = resolveHostsFileEntries(hostname);
        if (resolveHostsFileEntries != null) {
            promise.setSuccess(resolveHostsFileEntries);
        } else if (!doResolveAllCached(hostname, dnsRecordArr, promise, dnsCache, this.resolvedInternetProtocolFamilies)) {
            doResolveAllUncached(hostname, dnsRecordArr, promise, promise, dnsCache, this.completeOncePreferredResolved);
        }
    }

    public EventLoop executor() {
        return (EventLoop) super.executor();
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return query(nextNameServerAddress(), dnsQuestion, iterable);
    }

    public final Future<InetAddress> resolve(String str, Iterable<DnsRecord> iterable, Promise<InetAddress> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolve(str, toArray(iterable, true), promise, this.resolveCache);
            return promise;
        } catch (Exception e) {
            return promise.setFailure(e);
        }
    }

    public final Future<List<InetAddress>> resolveAll(String str, Iterable<DnsRecord> iterable, Promise<List<InetAddress>> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolveAll(str, toArray(iterable, true), promise, this.resolveCache);
            return promise;
        } catch (Exception e) {
            return promise.setFailure(e);
        }
    }

    public DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, ChannelFactory<? extends SocketChannel> channelFactory2, DnsCache dnsCache, DnsCnameCache dnsCnameCache, AuthoritativeDnsServerCache authoritativeDnsServerCache2, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory2, long j, ResolvedAddressTypes resolvedAddressTypes2, boolean z, int i, boolean z2, int i2, boolean z3, HostsFileEntriesResolver hostsFileEntriesResolver2, DnsServerAddressStreamProvider dnsServerAddressStreamProvider2, String[] strArr, int i3, boolean z4, boolean z5) {
        this(eventLoop, channelFactory, channelFactory2, dnsCache, dnsCnameCache, authoritativeDnsServerCache2, (SocketAddress) null, dnsQueryLifecycleObserverFactory2, j, resolvedAddressTypes2, z, i, z2, i2, z3, hostsFileEntriesResolver2, dnsServerAddressStreamProvider2, strArr, i3, z4, z5);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query(nextNameServerAddress(), dnsQuestion, Collections.emptyList(), promise);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, ChannelFactory<? extends SocketChannel> channelFactory2, DnsCache dnsCache, DnsCnameCache dnsCnameCache, AuthoritativeDnsServerCache authoritativeDnsServerCache2, SocketAddress socketAddress, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory2, long j, ResolvedAddressTypes resolvedAddressTypes2, boolean z, int i, boolean z2, int i2, boolean z3, HostsFileEntriesResolver hostsFileEntriesResolver2, DnsServerAddressStreamProvider dnsServerAddressStreamProvider2, String[] strArr, int i3, boolean z4, boolean z5) {
        super(eventLoop);
        long j2;
        ResolvedAddressTypes resolvedAddressTypes3;
        int i4;
        DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory3;
        int i5;
        ChannelFuture channelFuture;
        final DnsCache dnsCache2 = dnsCache;
        final DnsCnameCache dnsCnameCache2 = dnsCnameCache;
        final AuthoritativeDnsServerCache authoritativeDnsServerCache3 = authoritativeDnsServerCache2;
        SocketAddress socketAddress2 = socketAddress;
        DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory4 = dnsQueryLifecycleObserverFactory2;
        ResolvedAddressTypes resolvedAddressTypes4 = resolvedAddressTypes2;
        int i6 = i2;
        this.queryContextManager = new DnsQueryContextManager();
        this.nameServerAddrStream = new FastThreadLocal<DnsServerAddressStream>() {
            public DnsServerAddressStream initialValue() {
                return DnsNameResolver.this.dnsServerAddressStreamProvider.nameServerAddressStream("");
            }
        };
        if (j > 0) {
            j2 = j;
        } else {
            j2 = TimeUnit.SECONDS.toMillis((long) DEFAULT_OPTIONS.timeout());
        }
        this.queryTimeoutMillis = j2;
        if (resolvedAddressTypes4 != null) {
            resolvedAddressTypes3 = resolvedAddressTypes4;
        } else {
            resolvedAddressTypes3 = DEFAULT_RESOLVE_ADDRESS_TYPES;
        }
        this.resolvedAddressTypes = resolvedAddressTypes3;
        this.recursionDesired = z;
        if (i > 0) {
            i4 = i;
        } else {
            i4 = DEFAULT_OPTIONS.attempts();
        }
        this.maxQueriesPerResolve = i4;
        this.maxPayloadSize = ObjectUtil.checkPositive(i6, "maxPayloadSize");
        this.optResourceEnabled = z3;
        this.hostsFileEntriesResolver = (HostsFileEntriesResolver) ObjectUtil.checkNotNull(hostsFileEntriesResolver2, "hostsFileEntriesResolver");
        this.dnsServerAddressStreamProvider = (DnsServerAddressStreamProvider) ObjectUtil.checkNotNull(dnsServerAddressStreamProvider2, "dnsServerAddressStreamProvider");
        this.resolveCache = (DnsCache) ObjectUtil.checkNotNull(dnsCache2, "resolveCache");
        this.cnameCache = (DnsCnameCache) ObjectUtil.checkNotNull(dnsCnameCache2, "cnameCache");
        if (z2) {
            dnsQueryLifecycleObserverFactory3 = dnsQueryLifecycleObserverFactory4 instanceof NoopDnsQueryLifecycleObserverFactory ? new LoggingDnsQueryLifeCycleObserverFactory() : new BiDnsQueryLifecycleObserverFactory(new LoggingDnsQueryLifeCycleObserverFactory(), dnsQueryLifecycleObserverFactory4);
        } else {
            dnsQueryLifecycleObserverFactory3 = (DnsQueryLifecycleObserverFactory) ObjectUtil.checkNotNull(dnsQueryLifecycleObserverFactory4, "dnsQueryLifecycleObserverFactory");
        }
        this.dnsQueryLifecycleObserverFactory = dnsQueryLifecycleObserverFactory3;
        this.searchDomains = strArr != null ? (String[]) strArr.clone() : DEFAULT_SEARCH_DOMAINS;
        if (i3 >= 0) {
            i5 = i3;
        } else {
            i5 = DEFAULT_OPTIONS.ndots();
        }
        this.ndots = i5;
        this.decodeIdn = z4;
        this.completeOncePreferredResolved = z5;
        this.socketChannelFactory = channelFactory2;
        int i7 = AnonymousClass8.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[resolvedAddressTypes3.ordinal()];
        if (i7 == 1) {
            this.supportsAAAARecords = false;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV4_ONLY_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES;
        } else if (i7 == 2) {
            this.supportsAAAARecords = true;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV4_PREFERRED_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
        } else if (i7 == 3) {
            this.supportsAAAARecords = true;
            this.supportsARecords = false;
            this.resolveRecordTypes = IPV6_ONLY_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES;
        } else if (i7 == 4) {
            this.supportsAAAARecords = true;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV6_PREFERRED_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
        } else {
            throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes4);
        }
        InternetProtocolFamily preferredAddressType2 = preferredAddressType(resolvedAddressTypes3);
        this.preferredAddressType = preferredAddressType2;
        this.authoritativeDnsServerCache = (AuthoritativeDnsServerCache) ObjectUtil.checkNotNull(authoritativeDnsServerCache3, "authoritativeDnsServerCache");
        this.nameServerComparator = new NameServerComparator(preferredAddressType2.addressType());
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(executor());
        ChannelFactory<? extends DatagramChannel> channelFactory3 = channelFactory;
        bootstrap.channelFactory(channelFactory);
        Promise<Channel> newPromise = executor().newPromise();
        this.channelReadyPromise = newPromise;
        final DnsResponseHandler dnsResponseHandler = new DnsResponseHandler(newPromise);
        bootstrap.handler(new ChannelInitializer<DatagramChannel>() {
            public void initChannel(DatagramChannel datagramChannel) {
                datagramChannel.pipeline().addLast(DnsNameResolver.DATAGRAM_ENCODER, DnsNameResolver.DATAGRAM_DECODER, dnsResponseHandler);
            }
        });
        if (socketAddress2 == null) {
            bootstrap.option(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, Boolean.TRUE);
            channelFuture = bootstrap.register();
        } else {
            channelFuture = bootstrap.bind(socketAddress2);
        }
        if (channelFuture.isDone()) {
            Throwable cause = channelFuture.cause();
            if (cause != null) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                } else if (cause instanceof Error) {
                    throw ((Error) cause);
                } else {
                    throw new IllegalStateException("Unable to create / register Channel", cause);
                }
            }
        } else {
            channelFuture.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) {
                    Throwable cause = channelFuture.cause();
                    if (cause != null) {
                        DnsNameResolver.this.channelReadyPromise.tryFailure(cause);
                    }
                }
            });
        }
        Channel channel = channelFuture.channel();
        this.ch = channel;
        channel.config().setRecvByteBufAllocator(new FixedRecvByteBufAllocator(i6));
        channel.closeFuture().addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) {
                dnsCache2.clear();
                dnsCnameCache2.clear();
                authoritativeDnsServerCache3.clear();
            }
        });
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion) {
        return query0(inetSocketAddress, dnsQuestion, EMPTY_ADDITIONALS, true, this.ch.newPromise(), this.ch.eventLoop().newPromise());
    }

    public final InternetProtocolFamily preferredAddressType() {
        return this.preferredAddressType;
    }

    public final Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion) {
        return resolveAll(dnsQuestion, EMPTY_ADDITIONALS, (Promise<List<DnsRecord>>) executor().newPromise());
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return query0(inetSocketAddress, dnsQuestion, toArray(iterable, false), true, this.ch.newPromise(), this.ch.eventLoop().newPromise());
    }

    public final Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return resolveAll(dnsQuestion, iterable, (Promise<List<DnsRecord>>) executor().newPromise());
    }

    public final Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable, Promise<List<DnsRecord>> promise) {
        return resolveAll(dnsQuestion, toArray(iterable, true), promise);
    }

    private Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, Promise<List<DnsRecord>> promise) {
        List<InetAddress> resolveHostsFileEntries;
        ByteBuf byteBuf;
        Promise<List<DnsRecord>> promise2 = promise;
        DnsQuestion dnsQuestion2 = dnsQuestion;
        ObjectUtil.checkNotNull(dnsQuestion, "question");
        ObjectUtil.checkNotNull(promise2, "promise");
        DnsRecordType type = dnsQuestion.type();
        String name = dnsQuestion.name();
        if ((type == DnsRecordType.A || type == DnsRecordType.AAAA) && (resolveHostsFileEntries = resolveHostsFileEntries(name)) != null) {
            ArrayList arrayList = new ArrayList();
            for (InetAddress next : resolveHostsFileEntries) {
                if (next instanceof Inet4Address) {
                    if (type == DnsRecordType.A) {
                        byteBuf = Unpooled.wrappedBuffer(next.getAddress());
                    }
                    byteBuf = null;
                } else {
                    if ((next instanceof Inet6Address) && type == DnsRecordType.AAAA) {
                        byteBuf = Unpooled.wrappedBuffer(next.getAddress());
                    }
                    byteBuf = null;
                }
                ByteBuf byteBuf2 = byteBuf;
                if (byteBuf2 != null) {
                    arrayList.add(new DefaultDnsRawRecord(name, type, 86400, byteBuf2));
                }
            }
            if (!arrayList.isEmpty()) {
                trySuccess(promise2, arrayList);
                return promise2;
            }
        }
        new DnsRecordResolveContext(this, promise, dnsQuestion, dnsRecordArr, this.dnsServerAddressStreamProvider.nameServerAddressStream(name), this.maxQueriesPerResolve).resolve(promise2);
        return promise2;
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query0(inetSocketAddress, dnsQuestion, EMPTY_ADDITIONALS, true, this.ch.newPromise(), promise);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query0(inetSocketAddress, dnsQuestion, toArray(iterable, false), true, this.ch.newPromise(), promise);
    }
}
