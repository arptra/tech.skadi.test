package io.netty.resolver.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.dns.DefaultDnsQuestion;
import io.netty.handler.codec.dns.DefaultDnsRecordDecoder;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.LongCompanionObject;

abstract class DnsResolveContext<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final RuntimeException CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION;
    private static final RuntimeException NAME_SERVERS_EXHAUSTED_EXCEPTION;
    private static final RuntimeException NO_MATCHING_RECORD_QUERY_FAILED_EXCEPTION;
    private static final RuntimeException NXDOMAIN_QUERY_FAILED_EXCEPTION;
    private static final RuntimeException UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION;
    private static final InternalLogger logger;
    final DnsRecord[] additionals;
    /* access modifiers changed from: private */
    public int allowedQueries;
    private boolean completeEarly;
    private final int dnsClass;
    private final DnsRecordType[] expectedTypes;
    private List<T> finalResult;
    /* access modifiers changed from: private */
    public final String hostname;
    private final DnsServerAddressStream nameServerAddrs;
    private final Promise<?> originalPromise;
    final DnsNameResolver parent;
    /* access modifiers changed from: private */
    public final Set<Future<AddressedEnvelope<DnsResponse, InetSocketAddress>>> queriesInProgress = Collections.newSetFromMap(new IdentityHashMap());
    private boolean triedCNAME;

    public static final class AuthoritativeNameServerList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private AuthoritativeNameServer head;
        private int nameServerCount;
        private final String questionName;

        public AuthoritativeNameServerList(String str) {
            this.questionName = str.toLowerCase(Locale.US);
        }

        private static void cache(AuthoritativeNameServer authoritativeNameServer, AuthoritativeDnsServerCache authoritativeDnsServerCache, EventLoop eventLoop) {
            if (!authoritativeNameServer.isRootServer()) {
                authoritativeDnsServerCache.cache(authoritativeNameServer.domainName, authoritativeNameServer.address, authoritativeNameServer.ttl, eventLoop);
            }
        }

        private static void cacheUnresolved(AuthoritativeNameServer authoritativeNameServer, AuthoritativeDnsServerCache authoritativeDnsServerCache, EventLoop eventLoop) {
            InetSocketAddress unused = authoritativeNameServer.address = InetSocketAddress.createUnresolved(authoritativeNameServer.nsName, 53);
            cache(authoritativeNameServer, authoritativeDnsServerCache, eventLoop);
        }

        public void add(DnsRecord dnsRecord) {
            String decodeDomainName;
            if (dnsRecord.type() == DnsRecordType.NS && (dnsRecord instanceof DnsRawRecord) && this.questionName.length() >= dnsRecord.name().length()) {
                String lowerCase = dnsRecord.name().toLowerCase(Locale.US);
                int length = lowerCase.length() - 1;
                int length2 = this.questionName.length() - 1;
                int i = 0;
                while (length >= 0) {
                    char charAt = lowerCase.charAt(length);
                    if (this.questionName.charAt(length2) == charAt) {
                        if (charAt == '.') {
                            i++;
                        }
                        length--;
                        length2--;
                    } else {
                        return;
                    }
                }
                AuthoritativeNameServer authoritativeNameServer = this.head;
                if ((authoritativeNameServer == null || authoritativeNameServer.dots <= i) && (decodeDomainName = DnsResolveContext.decodeDomainName(((ByteBufHolder) dnsRecord).content())) != null) {
                    AuthoritativeNameServer authoritativeNameServer2 = this.head;
                    if (authoritativeNameServer2 == null || authoritativeNameServer2.dots < i) {
                        this.nameServerCount = 1;
                        this.head = new AuthoritativeNameServer(i, dnsRecord.timeToLive(), lowerCase, decodeDomainName);
                    } else if (this.head.dots == i) {
                        AuthoritativeNameServer authoritativeNameServer3 = this.head;
                        while (true) {
                            AuthoritativeNameServer authoritativeNameServer4 = authoritativeNameServer3.next;
                            if (authoritativeNameServer4 != null) {
                                authoritativeNameServer3 = authoritativeNameServer4;
                            } else {
                                authoritativeNameServer3.next = new AuthoritativeNameServer(i, dnsRecord.timeToLive(), lowerCase, decodeDomainName);
                                this.nameServerCount++;
                                return;
                            }
                        }
                    }
                }
            }
        }

        public List<InetSocketAddress> addressList() {
            ArrayList arrayList = new ArrayList(this.nameServerCount);
            for (AuthoritativeNameServer authoritativeNameServer = this.head; authoritativeNameServer != null; authoritativeNameServer = authoritativeNameServer.next) {
                if (authoritativeNameServer.address != null) {
                    arrayList.add(authoritativeNameServer.address);
                }
            }
            return arrayList;
        }

        public void handleWithAdditional(DnsNameResolver dnsNameResolver, DnsRecord dnsRecord, AuthoritativeDnsServerCache authoritativeDnsServerCache) {
            AuthoritativeNameServer authoritativeNameServer = this.head;
            String name = dnsRecord.name();
            InetAddress decodeAddress = DnsAddressDecoder.decodeAddress(dnsRecord, name, dnsNameResolver.isDecodeIdn());
            if (decodeAddress != null) {
                while (authoritativeNameServer != null) {
                    if (authoritativeNameServer.nsName.equalsIgnoreCase(name)) {
                        if (authoritativeNameServer.address != null) {
                            while (true) {
                                AuthoritativeNameServer authoritativeNameServer2 = authoritativeNameServer.next;
                                if (authoritativeNameServer2 == null || !authoritativeNameServer2.isCopy) {
                                    AuthoritativeNameServer authoritativeNameServer3 = new AuthoritativeNameServer(authoritativeNameServer);
                                    authoritativeNameServer3.next = authoritativeNameServer.next;
                                    authoritativeNameServer.next = authoritativeNameServer3;
                                    this.nameServerCount++;
                                    authoritativeNameServer = authoritativeNameServer3;
                                } else {
                                    authoritativeNameServer = authoritativeNameServer2;
                                }
                            }
                            AuthoritativeNameServer authoritativeNameServer32 = new AuthoritativeNameServer(authoritativeNameServer);
                            authoritativeNameServer32.next = authoritativeNameServer.next;
                            authoritativeNameServer.next = authoritativeNameServer32;
                            this.nameServerCount++;
                            authoritativeNameServer = authoritativeNameServer32;
                        }
                        authoritativeNameServer.update(dnsNameResolver.newRedirectServerAddress(decodeAddress), dnsRecord.timeToLive());
                        cache(authoritativeNameServer, authoritativeDnsServerCache, dnsNameResolver.executor());
                        return;
                    }
                    authoritativeNameServer = authoritativeNameServer.next;
                }
            }
        }

        public void handleWithoutAdditionals(DnsNameResolver dnsNameResolver, DnsCache dnsCache, AuthoritativeDnsServerCache authoritativeDnsServerCache) {
            InetAddress address;
            AuthoritativeNameServer authoritativeNameServer = this.head;
            while (authoritativeNameServer != null) {
                if (authoritativeNameServer.address == null) {
                    cacheUnresolved(authoritativeNameServer, authoritativeDnsServerCache, dnsNameResolver.executor());
                    List<? extends DnsCacheEntry> list = dnsCache.get(authoritativeNameServer.nsName, (DnsRecord[]) null);
                    if (!(list == null || list.isEmpty() || (address = ((DnsCacheEntry) list.get(0)).address()) == null)) {
                        authoritativeNameServer.update(dnsNameResolver.newRedirectServerAddress(address));
                        int i = 1;
                        while (i < list.size()) {
                            InetAddress address2 = ((DnsCacheEntry) list.get(i)).address();
                            AuthoritativeNameServer authoritativeNameServer2 = new AuthoritativeNameServer(authoritativeNameServer);
                            authoritativeNameServer2.next = authoritativeNameServer.next;
                            authoritativeNameServer.next = authoritativeNameServer2;
                            authoritativeNameServer2.update(dnsNameResolver.newRedirectServerAddress(address2));
                            this.nameServerCount++;
                            i++;
                            authoritativeNameServer = authoritativeNameServer2;
                        }
                    }
                }
                authoritativeNameServer = authoritativeNameServer.next;
            }
        }

        public boolean isEmpty() {
            return this.nameServerCount == 0;
        }
    }

    public final class CombinedDnsServerAddressStream implements DnsServerAddressStream {
        private final DnsServerAddressStream originalStream;
        private final InetSocketAddress replaced;
        private Iterator<InetAddress> resolved;
        private final List<InetAddress> resolvedAddresses;

        public CombinedDnsServerAddressStream(InetSocketAddress inetSocketAddress, List<InetAddress> list, DnsServerAddressStream dnsServerAddressStream) {
            this.replaced = inetSocketAddress;
            this.resolvedAddresses = list;
            this.originalStream = dnsServerAddressStream;
            this.resolved = list.iterator();
        }

        private InetSocketAddress nextResolved0() {
            return DnsResolveContext.this.parent.newRedirectServerAddress(this.resolved.next());
        }

        public DnsServerAddressStream duplicate() {
            return new CombinedDnsServerAddressStream(this.replaced, this.resolvedAddresses, this.originalStream.duplicate());
        }

        public InetSocketAddress next() {
            if (this.resolved.hasNext()) {
                return nextResolved0();
            }
            InetSocketAddress next = this.originalStream.next();
            if (!next.equals(this.replaced)) {
                return next;
            }
            this.resolved = this.resolvedAddresses.iterator();
            return nextResolved0();
        }

        public int size() {
            return (this.originalStream.size() + this.resolvedAddresses.size()) - 1;
        }
    }

    public static final class DnsAddressStreamList extends AbstractList<InetSocketAddress> {
        private List<InetSocketAddress> addresses;
        /* access modifiers changed from: private */
        public final DnsServerAddressStream duplicate;

        public DnsAddressStreamList(DnsServerAddressStream dnsServerAddressStream) {
            this.duplicate = dnsServerAddressStream.duplicate();
        }

        public Iterator<InetSocketAddress> iterator() {
            return new Iterator<InetSocketAddress>() {
                private int i;
                private final DnsServerAddressStream stream;

                {
                    this.stream = DnsAddressStreamList.this.duplicate.duplicate();
                }

                public boolean hasNext() {
                    return this.i < this.stream.size();
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }

                public InetSocketAddress next() {
                    if (hasNext()) {
                        this.i++;
                        return this.stream.next();
                    }
                    throw new NoSuchElementException();
                }
            };
        }

        public int size() {
            return this.duplicate.size();
        }

        public InetSocketAddress get(int i) {
            if (this.addresses == null) {
                DnsServerAddressStream duplicate2 = this.duplicate.duplicate();
                this.addresses = new ArrayList(size());
                for (int i2 = 0; i2 < duplicate2.size(); i2++) {
                    this.addresses.add(duplicate2.next());
                }
            }
            return this.addresses.get(i);
        }
    }

    public static final class DnsResolveContextException extends RuntimeException {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long serialVersionUID = 1209303419266433003L;

        private DnsResolveContextException(String str) {
            super(str);
        }

        public static DnsResolveContextException newStatic(String str, Class<?> cls, String str2) {
            return (DnsResolveContextException) ThrowableUtil.unknownStackTrace(PlatformDependent.javaVersion() >= 7 ? new DnsResolveContextException(str, true) : new DnsResolveContextException(str), cls, str2);
        }

        public Throwable fillInStackTrace() {
            return this;
        }

        @SuppressJava6Requirement(reason = "uses Java 7+ Exception.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
        private DnsResolveContextException(String str, boolean z) {
            super(str, (Throwable) null, false, true);
        }
    }

    public static final class RedirectAuthoritativeDnsServerCache implements AuthoritativeDnsServerCache {
        private final AuthoritativeDnsServerCache wrapped;

        public RedirectAuthoritativeDnsServerCache(AuthoritativeDnsServerCache authoritativeDnsServerCache) {
            this.wrapped = authoritativeDnsServerCache;
        }

        public void cache(String str, InetSocketAddress inetSocketAddress, long j, EventLoop eventLoop) {
            this.wrapped.cache(str, inetSocketAddress, j, eventLoop);
        }

        public void clear() {
            this.wrapped.clear();
        }

        public DnsServerAddressStream get(String str) {
            return null;
        }

        public boolean clear(String str) {
            return this.wrapped.clear(str);
        }
    }

    public static final class SearchDomainUnknownHostException extends UnknownHostException {
        private static final long serialVersionUID = -8573510133644997085L;

        public SearchDomainUnknownHostException(Throwable th, String str, String[] strArr) {
            super("Failed to resolve '" + str + "' and search domain query for configured domains failed as well: " + Arrays.toString(strArr));
            setStackTrace(th.getStackTrace());
            initCause(th.getCause());
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static {
        Class<DnsResolveContext> cls = DnsResolveContext.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        NXDOMAIN_QUERY_FAILED_EXCEPTION = DnsResolveContextException.newStatic("No answer found and NXDOMAIN response code returned", cls, "onResponse(..)");
        CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION = DnsResolveContextException.newStatic("No matching CNAME record found", cls, "onResponseCNAME(..)");
        NO_MATCHING_RECORD_QUERY_FAILED_EXCEPTION = DnsResolveContextException.newStatic("No matching record type found", cls, "onResponseAorAAAA(..)");
        UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION = DnsResolveContextException.newStatic("Response type was unrecognized", cls, "onResponse(..)");
        NAME_SERVERS_EXHAUSTED_EXCEPTION = DnsResolveContextException.newStatic("No name servers returned an answer", cls, "tryToFinishResolve(..)");
    }

    public DnsResolveContext(DnsNameResolver dnsNameResolver, Promise<?> promise, String str, int i, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream, int i2) {
        this.parent = dnsNameResolver;
        this.originalPromise = promise;
        this.hostname = str;
        this.dnsClass = i;
        this.expectedTypes = dnsRecordTypeArr;
        this.additionals = dnsRecordArr;
        this.nameServerAddrs = (DnsServerAddressStream) ObjectUtil.checkNotNull(dnsServerAddressStream, "nameServerAddrs");
        this.allowedQueries = i2;
    }

    private static Map<String, String> buildAliasMap(DnsResponse dnsResponse, DnsCnameCache dnsCnameCache, EventLoop eventLoop) {
        String decodeDomainName;
        int count = dnsResponse.count(DnsSection.ANSWER);
        HashMap hashMap = null;
        for (int i = 0; i < count; i++) {
            DnsRecord recordAt = dnsResponse.recordAt(DnsSection.ANSWER, i);
            if (recordAt.type() == DnsRecordType.CNAME && (recordAt instanceof DnsRawRecord) && (decodeDomainName = decodeDomainName(((ByteBufHolder) recordAt).content())) != null) {
                if (hashMap == null) {
                    hashMap = new HashMap(Math.min(8, count));
                }
                String name = recordAt.name();
                Locale locale = Locale.US;
                String lowerCase = name.toLowerCase(locale);
                String lowerCase2 = decodeDomainName.toLowerCase(locale);
                String hostnameWithDot = hostnameWithDot(lowerCase);
                String hostnameWithDot2 = hostnameWithDot(lowerCase2);
                if (!hostnameWithDot.equalsIgnoreCase(hostnameWithDot2)) {
                    dnsCnameCache.cache(hostnameWithDot, hostnameWithDot2, recordAt.timeToLive(), eventLoop);
                    hashMap.put(lowerCase, lowerCase2);
                }
            }
        }
        return hashMap != null ? hashMap : Collections.emptyMap();
    }

    private static void checkCnameLoop(String str, String str2, String str3) throws UnknownHostException {
        if (str2.equals(str3)) {
            throw new UnknownHostException("CNAME loop detected for '" + str + '\'');
        }
    }

    public static String cnameResolveFromCache(DnsCnameCache dnsCnameCache, String str) throws UnknownHostException {
        String str2 = dnsCnameCache.get(hostnameWithDot(str));
        if (str2 == null) {
            return str;
        }
        String str3 = dnsCnameCache.get(hostnameWithDot(str2));
        if (str3 == null) {
            return str2;
        }
        checkCnameLoop(str, str2, str3);
        return cnameResolveFromCacheLoop(dnsCnameCache, str, str2, str3);
    }

    private static String cnameResolveFromCacheLoop(DnsCnameCache dnsCnameCache, String str, String str2, String str3) throws UnknownHostException {
        boolean z = false;
        while (true) {
            String str4 = dnsCnameCache.get(hostnameWithDot(str3));
            if (str4 == null) {
                return str3;
            }
            checkCnameLoop(str, str2, str4);
            if (z) {
                str2 = dnsCnameCache.get(str2);
            }
            z = !z;
            str3 = str4;
        }
    }

    /* JADX INFO: finally extract failed */
    public static String decodeDomainName(ByteBuf byteBuf) {
        byteBuf.markReaderIndex();
        try {
            String decodeName = DefaultDnsRecordDecoder.decodeName(byteBuf);
            byteBuf.resetReaderIndex();
            return decodeName;
        } catch (CorruptedFrameException unused) {
            byteBuf.resetReaderIndex();
            return null;
        } catch (Throwable th) {
            byteBuf.resetReaderIndex();
            throw th;
        }
    }

    private static AuthoritativeNameServerList extractAuthoritativeNameServers(String str, DnsResponse dnsResponse) {
        int count = dnsResponse.count(DnsSection.AUTHORITY);
        if (count == 0) {
            return null;
        }
        AuthoritativeNameServerList authoritativeNameServerList = new AuthoritativeNameServerList(str);
        for (int i = 0; i < count; i++) {
            authoritativeNameServerList.add(dnsResponse.recordAt(DnsSection.AUTHORITY, i));
        }
        if (authoritativeNameServerList.isEmpty()) {
            return null;
        }
        return authoritativeNameServerList;
    }

    private void finishResolve(Promise<List<T>> promise, Throwable th) {
        if (!this.completeEarly && !this.queriesInProgress.isEmpty()) {
            Iterator<Future<AddressedEnvelope<DnsResponse, InetSocketAddress>>> it = this.queriesInProgress.iterator();
            while (it.hasNext()) {
                it.remove();
                it.next().cancel(false);
            }
        }
        if (this.finalResult == null) {
            int maxQueriesPerResolve = this.parent.maxQueriesPerResolve();
            int i = maxQueriesPerResolve - this.allowedQueries;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Failed to resolve '");
            sb.append(this.hostname);
            sb.append('\'');
            if (i > 1) {
                if (i < maxQueriesPerResolve) {
                    sb.append(" after ");
                    sb.append(i);
                    sb.append(" queries ");
                } else {
                    sb.append(". Exceeded max queries per resolve ");
                    sb.append(maxQueriesPerResolve);
                    sb.append(' ');
                }
            }
            UnknownHostException unknownHostException = new UnknownHostException(sb.toString());
            if (th == null) {
                cache(this.hostname, this.additionals, unknownHostException);
            } else {
                unknownHostException.initCause(th);
            }
            promise.tryFailure(unknownHostException);
        } else if (!promise.isDone()) {
            List<T> filterResults = filterResults(this.finalResult);
            if (!DnsNameResolver.trySuccess(promise, filterResults)) {
                for (T safeRelease : filterResults) {
                    ReferenceCountUtil.safeRelease(safeRelease);
                }
            }
        }
    }

    private void followCname(DnsQuestion dnsQuestion, String str, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        try {
            String cnameResolveFromCache = cnameResolveFromCache(cnameCache(), str);
            DnsServerAddressStream nameServers = getNameServers(cnameResolveFromCache);
            DefaultDnsQuestion defaultDnsQuestion = new DefaultDnsQuestion(cnameResolveFromCache, dnsQuestion.type(), this.dnsClass);
            query(nameServers, 0, defaultDnsQuestion, dnsQueryLifecycleObserver.queryCNAMEd(defaultDnsQuestion), true, promise, (Throwable) null);
        } catch (Throwable th) {
            dnsQueryLifecycleObserver.queryFailed(th);
            PlatformDependent.throwException(th);
        }
    }

    private DnsServerAddressStream getNameServers(String str) {
        DnsServerAddressStream nameServersFromCache = getNameServersFromCache(str);
        return nameServersFromCache == null ? str.equals(this.hostname) ? this.nameServerAddrs.duplicate() : this.parent.newNameServerAddressStream(str) : nameServersFromCache;
    }

    private DnsServerAddressStream getNameServersFromCache(String str) {
        DnsServerAddressStream dnsServerAddressStream;
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (str.charAt(length - 1) != '.') {
            str = str + ".";
        }
        int indexOf = str.indexOf(46);
        if (indexOf == str.length() - 1) {
            return null;
        }
        do {
            str = str.substring(indexOf + 1);
            indexOf = str.indexOf(46);
            if (indexOf <= 0 || indexOf == str.length() - 1) {
                return null;
            }
            dnsServerAddressStream = authoritativeDnsServerCache().get(str);
        } while (dnsServerAddressStream == null);
        return dnsServerAddressStream;
    }

    private boolean handleRedirect(DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        AuthoritativeNameServerList extractAuthoritativeNameServers;
        DnsResponse content = addressedEnvelope.content();
        if (content.count(DnsSection.ANSWER) == 0 && (extractAuthoritativeNameServers = extractAuthoritativeNameServers(dnsQuestion.name(), content)) != null) {
            int count = content.count(DnsSection.ADDITIONAL);
            AuthoritativeDnsServerCache authoritativeDnsServerCache = authoritativeDnsServerCache();
            for (int i = 0; i < count; i++) {
                DnsRecord recordAt = content.recordAt(DnsSection.ADDITIONAL, i);
                if ((recordAt.type() != DnsRecordType.A || this.parent.supportsARecords()) && (recordAt.type() != DnsRecordType.AAAA || this.parent.supportsAAAARecords())) {
                    extractAuthoritativeNameServers.handleWithAdditional(this.parent, recordAt, authoritativeDnsServerCache);
                }
            }
            extractAuthoritativeNameServers.handleWithoutAdditionals(this.parent, resolveCache(), authoritativeDnsServerCache);
            DnsServerAddressStream newRedirectDnsServerStream = this.parent.newRedirectDnsServerStream(dnsQuestion.name(), extractAuthoritativeNameServers.addressList());
            if (newRedirectDnsServerStream != null) {
                query(newRedirectDnsServerStream, 0, dnsQuestion, dnsQueryLifecycleObserver.queryRedirected(new DnsAddressStreamList(newRedirectDnsServerStream)), true, promise, (Throwable) null);
                return true;
            }
        }
        return false;
    }

    private boolean hasNDots() {
        int i = 0;
        for (int length = this.hostname.length() - 1; length >= 0; length--) {
            if (this.hostname.charAt(length) == '.' && (i = i + 1) >= this.parent.ndots()) {
                return true;
            }
        }
        return false;
    }

    private static String hostnameWithDot(String str) {
        if (StringUtil.endsWith(str, '.')) {
            return str;
        }
        return str + '.';
    }

    /* access modifiers changed from: private */
    public void internalResolve(String str, Promise<List<T>> promise) {
        try {
            String cnameResolveFromCache = cnameResolveFromCache(cnameCache(), str);
            try {
                DnsServerAddressStream nameServers = getNameServers(cnameResolveFromCache);
                int length = this.expectedTypes.length - 1;
                int i = 0;
                while (i < length) {
                    if (query(cnameResolveFromCache, this.expectedTypes[i], nameServers.duplicate(), false, promise)) {
                        i++;
                    } else {
                        return;
                    }
                }
                query(cnameResolveFromCache, this.expectedTypes[length], nameServers, false, promise);
                this.parent.flushQueries();
            } finally {
                this.parent.flushQueries();
            }
        } catch (Throwable th) {
            promise.tryFailure(th);
        }
    }

    /* access modifiers changed from: private */
    public DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion dnsQuestion) {
        return this.parent.dnsQueryLifecycleObserverFactory().newDnsQueryLifecycleObserver(dnsQuestion);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onExpectedResponse(io.netty.handler.codec.dns.DnsQuestion r19, io.netty.channel.AddressedEnvelope<io.netty.handler.codec.dns.DnsResponse, java.net.InetSocketAddress> r20, io.netty.resolver.dns.DnsQueryLifecycleObserver r21, io.netty.util.concurrent.Promise<java.util.List<T>> r22) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = r20.content()
            io.netty.handler.codec.dns.DnsResponse r1 = (io.netty.handler.codec.dns.DnsResponse) r1
            io.netty.resolver.dns.DnsCnameCache r2 = r18.cnameCache()
            io.netty.resolver.dns.DnsNameResolver r3 = r0.parent
            io.netty.channel.EventLoop r3 = r3.executor()
            java.util.Map r2 = buildAliasMap(r1, r2, r3)
            io.netty.handler.codec.dns.DnsSection r3 = io.netty.handler.codec.dns.DnsSection.ANSWER
            int r3 = r1.count(r3)
            boolean r4 = r0.completeEarly
            r6 = 0
            r7 = 0
        L_0x0020:
            r8 = 1
            if (r6 >= r3) goto L_0x0153
            io.netty.handler.codec.dns.DnsSection r9 = io.netty.handler.codec.dns.DnsSection.ANSWER
            io.netty.handler.codec.dns.DnsRecord r9 = r1.recordAt(r9, r6)
            io.netty.handler.codec.dns.DnsRecordType r10 = r9.type()
            io.netty.handler.codec.dns.DnsRecordType[] r11 = r0.expectedTypes
            int r12 = r11.length
            r13 = 0
        L_0x0031:
            if (r13 >= r12) goto L_0x014b
            r14 = r11[r13]
            if (r10 != r14) goto L_0x0144
            java.lang.String r10 = r19.name()
            java.util.Locale r11 = java.util.Locale.US
            java.lang.String r10 = r10.toLowerCase(r11)
            java.lang.String r12 = r9.name()
            java.lang.String r11 = r12.toLowerCase(r11)
            boolean r12 = r11.equals(r10)
            if (r12 != 0) goto L_0x00dc
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>(r2)
            r13 = r10
        L_0x0055:
            java.lang.Object r13 = r12.remove(r13)
            java.lang.String r13 = (java.lang.String) r13
            boolean r14 = r11.equals(r13)
            if (r14 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            if (r13 != 0) goto L_0x0055
        L_0x0064:
            if (r13 != 0) goto L_0x00dc
            io.netty.resolver.dns.DnsNameResolver r12 = r0.parent
            java.lang.String[] r12 = r12.searchDomains()
            int r14 = r12.length
            r15 = 0
        L_0x006e:
            if (r15 >= r14) goto L_0x00ba
            r5 = r12[r15]
            boolean r16 = r5.isEmpty()
            if (r16 == 0) goto L_0x007b
            r17 = r1
            goto L_0x00b4
        L_0x007b:
            int r16 = r5.length()
            r17 = r1
            int r1 = r16 + -1
            char r1 = r5.charAt(r1)
            r8 = 46
            if (r1 != r8) goto L_0x009b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            goto L_0x00ad
        L_0x009b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            r1.append(r5)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
        L_0x00ad:
            boolean r1 = r11.equals(r1)
            if (r1 == 0) goto L_0x00b4
            goto L_0x00bd
        L_0x00b4:
            int r15 = r15 + 1
            r1 = r17
            r8 = 1
            goto L_0x006e
        L_0x00ba:
            r17 = r1
            r11 = r13
        L_0x00bd:
            if (r11 != 0) goto L_0x00de
            io.netty.util.internal.logging.InternalLogger r1 = logger
            boolean r5 = r1.isDebugEnabled()
            if (r5 == 0) goto L_0x014d
            java.lang.String r5 = r9.toString()
            io.netty.resolver.dns.DnsNameResolver r8 = r0.parent
            java.lang.String[] r8 = r8.searchDomains()
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r10, r2, r8}
            java.lang.String r8 = "Ignoring record {} as it contains a different name than the question name [{}]. Cnames: {}, Search domains: {}"
            r1.debug((java.lang.String) r8, (java.lang.Object[]) r5)
            goto L_0x014d
        L_0x00dc:
            r17 = r1
        L_0x00de:
            java.lang.String r1 = r0.hostname
            io.netty.handler.codec.dns.DnsRecord[] r5 = r0.additionals
            io.netty.resolver.dns.DnsNameResolver r8 = r0.parent
            io.netty.channel.EventLoop r8 = r8.executor()
            java.lang.Object r1 = r0.convertRecord(r9, r1, r5, r8)
            if (r1 != 0) goto L_0x0108
            io.netty.util.internal.logging.InternalLogger r1 = logger
            boolean r5 = r1.isDebugEnabled()
            if (r5 == 0) goto L_0x014d
            java.lang.String r5 = r9.toString()
            java.lang.String r8 = r0.hostname
            io.netty.handler.codec.dns.DnsRecord[] r9 = r0.additionals
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r8, r9}
            java.lang.String r8 = "Ignoring record {} as the converted record is null. hostname [{}], Additionals: {}"
            r1.debug((java.lang.String) r8, (java.lang.Object[]) r5)
            goto L_0x014d
        L_0x0108:
            if (r4 != 0) goto L_0x010e
            boolean r4 = r0.isCompleteEarly(r1)
        L_0x010e:
            java.util.List<T> r5 = r0.finalResult
            if (r5 != 0) goto L_0x011f
            java.util.ArrayList r5 = new java.util.ArrayList
            r7 = 8
            r5.<init>(r7)
            r0.finalResult = r5
            r5.add(r1)
            goto L_0x0135
        L_0x011f:
            boolean r5 = r18.isDuplicateAllowed()
            if (r5 != 0) goto L_0x0130
            java.util.List<T> r5 = r0.finalResult
            boolean r5 = r5.contains(r1)
            if (r5 != 0) goto L_0x012e
            goto L_0x0130
        L_0x012e:
            r5 = 1
            goto L_0x0136
        L_0x0130:
            java.util.List<T> r5 = r0.finalResult
            r5.add(r1)
        L_0x0135:
            r5 = 0
        L_0x0136:
            java.lang.String r7 = r0.hostname
            io.netty.handler.codec.dns.DnsRecord[] r8 = r0.additionals
            r0.cache(r7, r8, r9, r1)
            if (r5 == 0) goto L_0x0142
            io.netty.util.ReferenceCountUtil.release(r1)
        L_0x0142:
            r7 = 1
            goto L_0x014d
        L_0x0144:
            r17 = r1
            int r13 = r13 + 1
            r8 = 1
            goto L_0x0031
        L_0x014b:
            r17 = r1
        L_0x014d:
            int r6 = r6 + 1
            r1 = r17
            goto L_0x0020
        L_0x0153:
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L_0x016c
            if (r7 == 0) goto L_0x0164
            if (r4 == 0) goto L_0x0160
            r1 = 1
            r0.completeEarly = r1
        L_0x0160:
            r21.querySucceed()
            return
        L_0x0164:
            java.lang.RuntimeException r0 = NO_MATCHING_RECORD_QUERY_FAILED_EXCEPTION
            r1 = r21
            r1.queryFailed(r0)
            goto L_0x017c
        L_0x016c:
            r1 = r21
            r21.querySucceed()
            io.netty.resolver.dns.DnsQueryLifecycleObserver r1 = r18.newDnsQueryLifecycleObserver(r19)
            r3 = r19
            r4 = r22
            r0.onResponseCNAME(r3, r2, r1, r4)
        L_0x017c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.DnsResolveContext.onExpectedResponse(io.netty.handler.codec.dns.DnsQuestion, io.netty.channel.AddressedEnvelope, io.netty.resolver.dns.DnsQueryLifecycleObserver, io.netty.util.concurrent.Promise):void");
    }

    /* access modifiers changed from: private */
    public void onResponse(DnsServerAddressStream dnsServerAddressStream, int i, DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        DnsQuestion dnsQuestion2 = dnsQuestion;
        AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope2 = addressedEnvelope;
        DnsQueryLifecycleObserver dnsQueryLifecycleObserver2 = dnsQueryLifecycleObserver;
        Promise<List<T>> promise2 = promise;
        try {
            DnsResponse content = addressedEnvelope.content();
            DnsResponseCode code = content.code();
            if (code != DnsResponseCode.NOERROR) {
                if (code != DnsResponseCode.NXDOMAIN) {
                    query(dnsServerAddressStream, i + 1, dnsQuestion, dnsQueryLifecycleObserver2.queryNoAnswer(code), true, promise, (Throwable) null);
                } else {
                    dnsQueryLifecycleObserver2.queryFailed(NXDOMAIN_QUERY_FAILED_EXCEPTION);
                    if (!content.isAuthoritativeAnswer()) {
                        query(dnsServerAddressStream, i + 1, dnsQuestion, newDnsQueryLifecycleObserver(dnsQuestion), true, promise, (Throwable) null);
                    }
                }
                ReferenceCountUtil.safeRelease(addressedEnvelope);
            } else if (!handleRedirect(dnsQuestion, addressedEnvelope, dnsQueryLifecycleObserver2, promise2)) {
                DnsRecordType type = dnsQuestion.type();
                if (type == DnsRecordType.CNAME) {
                    onResponseCNAME(dnsQuestion, buildAliasMap(addressedEnvelope.content(), cnameCache(), this.parent.executor()), dnsQueryLifecycleObserver2, promise2);
                    ReferenceCountUtil.safeRelease(addressedEnvelope);
                    return;
                }
                for (DnsRecordType dnsRecordType : this.expectedTypes) {
                    if (type == dnsRecordType) {
                        onExpectedResponse(dnsQuestion, addressedEnvelope, dnsQueryLifecycleObserver2, promise2);
                        ReferenceCountUtil.safeRelease(addressedEnvelope);
                        return;
                    }
                }
                dnsQueryLifecycleObserver2.queryFailed(UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION);
                ReferenceCountUtil.safeRelease(addressedEnvelope);
            }
        } finally {
            ReferenceCountUtil.safeRelease(addressedEnvelope);
        }
    }

    private void onResponseCNAME(DnsQuestion dnsQuestion, Map<String, String> map, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        String remove;
        String lowerCase = dnsQuestion.name().toLowerCase(Locale.US);
        boolean z = false;
        while (!map.isEmpty() && (remove = map.remove(lowerCase)) != null) {
            z = true;
            lowerCase = remove;
        }
        if (z) {
            followCname(dnsQuestion, lowerCase, dnsQueryLifecycleObserver, promise);
        } else {
            dnsQueryLifecycleObserver.queryFailed(CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION);
        }
    }

    /* access modifiers changed from: private */
    public void query(DnsServerAddressStream dnsServerAddressStream, int i, DnsQuestion dnsQuestion, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, boolean z, Promise<List<T>> promise, Throwable th) {
        if (this.completeEarly) {
            int i2 = i;
        } else if (i < dnsServerAddressStream.size() && this.allowedQueries != 0 && !this.originalPromise.isCancelled() && !promise.isCancelled()) {
            this.allowedQueries--;
            InetSocketAddress next = dnsServerAddressStream.next();
            if (next.isUnresolved()) {
                queryUnresolvedNameServer(next, dnsServerAddressStream, i, dnsQuestion, dnsQueryLifecycleObserver, promise, th);
                return;
            }
            ChannelPromise newPromise = this.parent.ch.newPromise();
            Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query0 = this.parent.query0(next, dnsQuestion, this.additionals, z, newPromise, this.parent.ch.eventLoop().newPromise());
            this.queriesInProgress.add(query0);
            dnsQueryLifecycleObserver.queryWritten(next, newPromise);
            final Promise<List<T>> promise2 = promise;
            final DnsQueryLifecycleObserver dnsQueryLifecycleObserver2 = dnsQueryLifecycleObserver;
            final DnsServerAddressStream dnsServerAddressStream2 = dnsServerAddressStream;
            final int i3 = i;
            final DnsQuestion dnsQuestion2 = dnsQuestion;
            query0.addListener(new FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>>() {
                public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
                    DnsResolveContext.this.queriesInProgress.remove(future);
                    if (promise2.isDone() || future.isCancelled()) {
                        dnsQueryLifecycleObserver2.queryCancelled(DnsResolveContext.this.allowedQueries);
                        AddressedEnvelope now = future.getNow();
                        if (now != null) {
                            now.release();
                            return;
                        }
                        return;
                    }
                    Throwable cause = future.cause();
                    if (cause == null) {
                        try {
                            DnsResolveContext.this.onResponse(dnsServerAddressStream2, i3, dnsQuestion2, future.getNow(), dnsQueryLifecycleObserver2, promise2);
                        } finally {
                            DnsResolveContext.this.tryToFinishResolve(dnsServerAddressStream2, i3, dnsQuestion2, NoopDnsQueryLifecycleObserver.INSTANCE, promise2, cause);
                        }
                    } else {
                        dnsQueryLifecycleObserver2.queryFailed(cause);
                        DnsResolveContext dnsResolveContext = DnsResolveContext.this;
                        DnsQuestion dnsQuestion = dnsQuestion2;
                        dnsResolveContext.query(dnsServerAddressStream2, i3 + 1, dnsQuestion, dnsResolveContext.newDnsQueryLifecycleObserver(dnsQuestion), true, promise2, cause);
                    }
                }
            });
            return;
        }
        DnsQueryLifecycleObserver dnsQueryLifecycleObserver3 = dnsQueryLifecycleObserver;
        tryToFinishResolve(dnsServerAddressStream, i, dnsQuestion, dnsQueryLifecycleObserver, promise, th);
    }

    private void queryUnresolvedNameServer(InetSocketAddress inetSocketAddress, DnsServerAddressStream dnsServerAddressStream, int i, DnsQuestion dnsQuestion, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise, Throwable th) {
        String hostString = PlatformDependent.javaVersion() >= 7 ? inetSocketAddress.getHostString() : inetSocketAddress.getHostName();
        final Future newSucceededFuture = this.parent.executor().newSucceededFuture(null);
        this.queriesInProgress.add(newSucceededFuture);
        Promise newPromise = this.parent.executor().newPromise();
        final InetSocketAddress inetSocketAddress2 = inetSocketAddress;
        final DnsServerAddressStream dnsServerAddressStream2 = dnsServerAddressStream;
        final int i2 = i;
        final DnsQuestion dnsQuestion2 = dnsQuestion;
        final DnsQueryLifecycleObserver dnsQueryLifecycleObserver2 = dnsQueryLifecycleObserver;
        final Promise<List<T>> promise2 = promise;
        final Throwable th2 = th;
        newPromise.addListener(new FutureListener<List<InetAddress>>() {
            public void operationComplete(Future<List<InetAddress>> future) {
                DnsResolveContext.this.queriesInProgress.remove(newSucceededFuture);
                if (future.isSuccess()) {
                    DnsResolveContext.this.query(new CombinedDnsServerAddressStream(inetSocketAddress2, future.getNow(), dnsServerAddressStream2), i2, dnsQuestion2, dnsQueryLifecycleObserver2, true, promise2, th2);
                    return;
                }
                DnsResolveContext.this.query(dnsServerAddressStream2, i2 + 1, dnsQuestion2, dnsQueryLifecycleObserver2, true, promise2, th2);
            }
        });
        DnsCache resolveCache = resolveCache();
        if (!DnsNameResolver.doResolveAllCached(hostString, this.additionals, newPromise, resolveCache, this.parent.resolvedInternetProtocolFamiliesUnsafe())) {
            DnsNameResolver dnsNameResolver = this.parent;
            new DnsAddressResolveContext(dnsNameResolver, this.originalPromise, hostString, this.additionals, dnsNameResolver.newNameServerAddressStream(hostString), this.allowedQueries, resolveCache, redirectAuthoritativeDnsServerCache(authoritativeDnsServerCache()), false).resolve(newPromise);
        }
    }

    private static AuthoritativeDnsServerCache redirectAuthoritativeDnsServerCache(AuthoritativeDnsServerCache authoritativeDnsServerCache) {
        return authoritativeDnsServerCache instanceof RedirectAuthoritativeDnsServerCache ? authoritativeDnsServerCache : new RedirectAuthoritativeDnsServerCache(authoritativeDnsServerCache);
    }

    /* access modifiers changed from: private */
    public void tryToFinishResolve(DnsServerAddressStream dnsServerAddressStream, int i, DnsQuestion dnsQuestion, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise, Throwable th) {
        if (this.completeEarly || this.queriesInProgress.isEmpty()) {
            if (this.finalResult != null) {
                dnsQueryLifecycleObserver.queryCancelled(this.allowedQueries);
            } else if (i >= dnsServerAddressStream.size()) {
                dnsQueryLifecycleObserver.queryFailed(NAME_SERVERS_EXHAUSTED_EXCEPTION);
                if (th == null && !this.triedCNAME && (dnsQuestion.type() == DnsRecordType.A || dnsQuestion.type() == DnsRecordType.AAAA)) {
                    this.triedCNAME = true;
                    String str = this.hostname;
                    query(str, DnsRecordType.CNAME, getNameServers(str), true, promise);
                    return;
                }
            } else if (dnsQueryLifecycleObserver == NoopDnsQueryLifecycleObserver.INSTANCE) {
                query(dnsServerAddressStream, i + 1, dnsQuestion, newDnsQueryLifecycleObserver(dnsQuestion), true, promise, th);
                return;
            } else {
                query(dnsServerAddressStream, i + 1, dnsQuestion, dnsQueryLifecycleObserver, true, promise, th);
                return;
            }
            finishResolve(promise, th);
            return;
        }
        dnsQueryLifecycleObserver.queryCancelled(this.allowedQueries);
    }

    public AuthoritativeDnsServerCache authoritativeDnsServerCache() {
        return this.parent.authoritativeDnsServerCache();
    }

    public abstract void cache(String str, DnsRecord[] dnsRecordArr, DnsRecord dnsRecord, T t);

    public abstract void cache(String str, DnsRecord[] dnsRecordArr, UnknownHostException unknownHostException);

    public DnsCnameCache cnameCache() {
        return this.parent.cnameCache();
    }

    public abstract T convertRecord(DnsRecord dnsRecord, String str, DnsRecord[] dnsRecordArr, EventLoop eventLoop);

    public void doSearchDomainQuery(String str, Promise<List<T>> promise) {
        DnsNameResolver dnsNameResolver = this.parent;
        newResolverContext(dnsNameResolver, this.originalPromise, str, this.dnsClass, this.expectedTypes, this.additionals, this.nameServerAddrs, dnsNameResolver.maxQueriesPerResolve()).internalResolve(str, promise);
    }

    public abstract List<T> filterResults(List<T> list);

    public abstract boolean isCompleteEarly(T t);

    public abstract boolean isDuplicateAllowed();

    public abstract DnsResolveContext<T> newResolverContext(DnsNameResolver dnsNameResolver, Promise<?> promise, String str, int i, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream, int i2);

    public void resolve(Promise<List<T>> promise) {
        String str;
        String[] searchDomains = this.parent.searchDomains();
        if (searchDomains.length == 0 || this.parent.ndots() == 0 || StringUtil.endsWith(this.hostname, '.')) {
            internalResolve(this.hostname, promise);
            return;
        }
        boolean hasNDots = hasNDots();
        if (hasNDots) {
            str = this.hostname;
        } else {
            str = this.hostname + '.' + searchDomains[0];
        }
        Promise newPromise = this.parent.executor().newPromise();
        newPromise.addListener(new FutureListener<List<T>>(hasNDots ^ true ? 1 : 0, promise, searchDomains, hasNDots) {
            private int searchDomainIdx;
            final /* synthetic */ int val$initialSearchDomainIdx;
            final /* synthetic */ Promise val$promise;
            final /* synthetic */ String[] val$searchDomains;
            final /* synthetic */ boolean val$startWithoutSearchDomain;

            {
                this.val$initialSearchDomainIdx = r2;
                this.val$promise = r3;
                this.val$searchDomains = r4;
                this.val$startWithoutSearchDomain = r5;
                this.searchDomainIdx = r2;
            }

            public void operationComplete(Future<List<T>> future) {
                Throwable cause = future.cause();
                if (cause == null) {
                    List<Object> now = future.getNow();
                    if (!this.val$promise.trySuccess(now)) {
                        for (Object safeRelease : now) {
                            ReferenceCountUtil.safeRelease(safeRelease);
                        }
                    }
                } else if (DnsNameResolver.isTransportOrTimeoutError(cause)) {
                    this.val$promise.tryFailure(new SearchDomainUnknownHostException(cause, DnsResolveContext.this.hostname, this.val$searchDomains));
                } else if (this.searchDomainIdx < this.val$searchDomains.length) {
                    Promise newPromise = DnsResolveContext.this.parent.executor().newPromise();
                    newPromise.addListener(this);
                    DnsResolveContext dnsResolveContext = DnsResolveContext.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(DnsResolveContext.this.hostname);
                    sb.append('.');
                    String[] strArr = this.val$searchDomains;
                    int i = this.searchDomainIdx;
                    this.searchDomainIdx = i + 1;
                    sb.append(strArr[i]);
                    dnsResolveContext.doSearchDomainQuery(sb.toString(), newPromise);
                } else if (!this.val$startWithoutSearchDomain) {
                    DnsResolveContext dnsResolveContext2 = DnsResolveContext.this;
                    dnsResolveContext2.internalResolve(dnsResolveContext2.hostname, this.val$promise);
                } else {
                    this.val$promise.tryFailure(new SearchDomainUnknownHostException(cause, DnsResolveContext.this.hostname, this.val$searchDomains));
                }
            }
        });
        doSearchDomainQuery(str, newPromise);
    }

    public DnsCache resolveCache() {
        return this.parent.resolveCache();
    }

    public static final class AuthoritativeNameServer {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        /* access modifiers changed from: private */
        public InetSocketAddress address;
        /* access modifiers changed from: private */
        public final String domainName;
        /* access modifiers changed from: private */
        public final int dots;
        final boolean isCopy = false;
        AuthoritativeNameServer next;
        final String nsName;
        /* access modifiers changed from: private */
        public long ttl;

        public AuthoritativeNameServer(int i, long j, String str, String str2) {
            this.dots = i;
            this.ttl = j;
            this.nsName = str2;
            this.domainName = str;
        }

        public boolean isRootServer() {
            return this.dots == 1;
        }

        public void update(InetSocketAddress inetSocketAddress, long j) {
            this.address = inetSocketAddress;
            this.ttl = Math.min(this.ttl, j);
        }

        public void update(InetSocketAddress inetSocketAddress) {
            update(inetSocketAddress, LongCompanionObject.MAX_VALUE);
        }

        public AuthoritativeNameServer(AuthoritativeNameServer authoritativeNameServer) {
            this.dots = authoritativeNameServer.dots;
            this.ttl = authoritativeNameServer.ttl;
            this.nsName = authoritativeNameServer.nsName;
            this.domainName = authoritativeNameServer.domainName;
        }
    }

    private boolean query(String str, DnsRecordType dnsRecordType, DnsServerAddressStream dnsServerAddressStream, boolean z, Promise<List<T>> promise) {
        try {
            DefaultDnsQuestion defaultDnsQuestion = new DefaultDnsQuestion(str, dnsRecordType, this.dnsClass);
            query(dnsServerAddressStream, 0, defaultDnsQuestion, newDnsQueryLifecycleObserver(defaultDnsQuestion), z, promise, (Throwable) null);
            return true;
        } catch (Throwable th) {
            promise.tryFailure(new IllegalArgumentException("Unable to create DNS Question for: [" + str + ", " + dnsRecordType + ']', th));
            return false;
        }
    }
}
