package io.netty.resolver.dns;

import io.netty.resolver.dns.UnixResolverOptions;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class UnixResolverDnsServerAddressStreamProvider implements DnsServerAddressStreamProvider {
    private static final String DOMAIN_ROW_LABEL = "domain";
    private static final String ETC_RESOLVER_DIR = "/etc/resolver";
    private static final String ETC_RESOLV_CONF_FILE = "/etc/resolv.conf";
    private static final String NAMESERVER_ROW_LABEL = "nameserver";
    private static final String OPTIONS_ROTATE_FLAG = "rotate";
    private static final String OPTIONS_ROW_LABEL = "options ";
    private static final String PORT_ROW_LABEL = "port";
    private static final String RES_OPTIONS = System.getenv("RES_OPTIONS");
    private static final String SEARCH_ROW_LABEL = "search";
    private static final String SORTLIST_ROW_LABEL = "sortlist";
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) UnixResolverDnsServerAddressStreamProvider.class);
    private final DnsServerAddresses defaultNameServerAddresses;
    private final Map<String, DnsServerAddresses> domainToNameServerStreamMap;

    public UnixResolverDnsServerAddressStreamProvider(File file, File... fileArr) throws IOException {
        Map<String, DnsServerAddresses> parse = parse((File) ObjectUtil.checkNotNull(file, "etcResolvConf"));
        boolean z = (fileArr == null || fileArr.length == 0) ? false : true;
        Map<String, DnsServerAddresses> parse2 = z ? parse(fileArr) : parse;
        this.domainToNameServerStreamMap = parse2;
        DnsServerAddresses dnsServerAddresses = parse.get(file.getName());
        if (dnsServerAddresses == null) {
            Collection<DnsServerAddresses> values = parse.values();
            if (!values.isEmpty()) {
                this.defaultNameServerAddresses = values.iterator().next();
            } else {
                throw new IllegalArgumentException(file + " didn't provide any name servers");
            }
        } else {
            this.defaultNameServerAddresses = dnsServerAddresses;
        }
        if (z) {
            parse2.putAll(parse);
        }
    }

    private boolean mayOverrideNameServers() {
        return !this.domainToNameServerStreamMap.isEmpty() || this.defaultNameServerAddresses.stream().next() != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:162:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0286  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map<java.lang.String, io.netty.resolver.dns.DnsServerAddresses> parse(java.io.File... r20) throws java.io.IOException {
        /*
            r1 = r20
            java.lang.String r2 = "sortlist"
            java.util.HashMap r3 = new java.util.HashMap
            int r0 = r1.length
            r4 = 1
            int r0 = r0 << r4
            r3.<init>(r0)
            java.lang.String r0 = RES_OPTIONS
            java.lang.String r5 = "rotate"
            if (r0 == 0) goto L_0x0019
            boolean r0 = r0.contains(r5)
            if (r0 == 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r4 = 0
        L_0x001a:
            int r7 = r1.length
            r8 = 0
        L_0x001c:
            if (r8 >= r7) goto L_0x028a
            r9 = r1[r8]
            boolean r0 = r9.isFile()
            if (r0 != 0) goto L_0x002f
            r16 = r4
            r17 = r5
            r18 = r7
            r5 = 0
            goto L_0x0273
        L_0x002f:
            java.io.FileReader r10 = new java.io.FileReader
            r10.<init>(r9)
            r11 = 0
            java.io.BufferedReader r12 = new java.io.BufferedReader     // Catch:{ all -> 0x027f }
            r12.<init>(r10)     // Catch:{ all -> 0x027f }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x008c }
            r11 = 2
            r0.<init>(r11)     // Catch:{ all -> 0x008c }
            java.lang.String r13 = r9.getName()     // Catch:{ all -> 0x008c }
            r14 = 53
            r11 = r4
            r15 = r14
            r14 = r13
            r13 = r0
        L_0x004a:
            java.lang.String r0 = r12.readLine()     // Catch:{ all -> 0x008c }
            if (r0 == 0) goto L_0x0260
            java.lang.String r6 = r0.trim()     // Catch:{ all -> 0x008c }
            boolean r0 = r6.isEmpty()     // Catch:{ IllegalArgumentException -> 0x0235 }
            if (r0 != 0) goto L_0x0067
            r1 = 0
            char r0 = r6.charAt(r1)     // Catch:{ IllegalArgumentException -> 0x0240 }
            r1 = 35
            if (r0 == r1) goto L_0x0067
            r1 = 59
            if (r0 != r1) goto L_0x0073
        L_0x0067:
            r16 = r4
            r17 = r5
            r18 = r7
            r19 = r15
            r4 = 2
            r5 = 0
            goto L_0x024c
        L_0x0073:
            if (r11 != 0) goto L_0x009b
            java.lang.String r0 = "options "
            boolean r0 = r6.startsWith(r0)     // Catch:{ IllegalArgumentException -> 0x0090 }
            if (r0 == 0) goto L_0x009b
            boolean r0 = r6.contains(r5)     // Catch:{ IllegalArgumentException -> 0x0090 }
            r11 = r0
            r16 = r4
            r17 = r5
            r18 = r7
            r4 = 2
            r5 = 0
            goto L_0x022b
        L_0x008c:
            r0 = move-exception
            r11 = r12
            goto L_0x0280
        L_0x0090:
            r0 = move-exception
            r16 = r4
            r17 = r5
            r18 = r7
        L_0x0097:
            r4 = 2
            r5 = 0
            goto L_0x0258
        L_0x009b:
            java.lang.String r0 = "nameserver"
            boolean r0 = r6.startsWith(r0)     // Catch:{ IllegalArgumentException -> 0x0235 }
            if (r0 == 0) goto L_0x0182
            r0 = 10
            int r0 = io.netty.util.internal.StringUtil.indexOfNonWhiteSpace(r6, r0)     // Catch:{ IllegalArgumentException -> 0x017c }
            java.lang.String r1 = ". value: "
            r16 = r4
            java.lang.String r4 = "error parsing label nameserver in file "
            if (r0 < 0) goto L_0x015a
            r17 = r5
            int r5 = io.netty.util.internal.StringUtil.indexOfWhiteSpace(r6, r0)     // Catch:{ IllegalArgumentException -> 0x0153 }
            r18 = r7
            r7 = -1
            if (r5 != r7) goto L_0x00c5
            java.lang.String r0 = r6.substring(r0)     // Catch:{ IllegalArgumentException -> 0x00c3 }
            r19 = r15
            goto L_0x00d9
        L_0x00c3:
            r0 = move-exception
            goto L_0x0097
        L_0x00c5:
            r19 = r15
            int r15 = io.netty.util.internal.StringUtil.indexOfNonWhiteSpace(r6, r5)     // Catch:{ IllegalArgumentException -> 0x0105 }
            if (r15 == r7) goto L_0x0137
            char r7 = r6.charAt(r15)     // Catch:{ IllegalArgumentException -> 0x0105 }
            r15 = 35
            if (r7 != r15) goto L_0x0137
            java.lang.String r0 = r6.substring(r0, r5)     // Catch:{ IllegalArgumentException -> 0x0105 }
        L_0x00d9:
            boolean r1 = io.netty.util.NetUtil.isValidIpV4Address((java.lang.String) r0)     // Catch:{ IllegalArgumentException -> 0x0105 }
            if (r1 != 0) goto L_0x012a
            boolean r1 = io.netty.util.NetUtil.isValidIpV6Address((java.lang.String) r0)     // Catch:{ IllegalArgumentException -> 0x0105 }
            if (r1 != 0) goto L_0x012a
            r1 = 46
            int r1 = r0.lastIndexOf(r1)     // Catch:{ IllegalArgumentException -> 0x0105 }
            int r5 = r1 + 1
            int r7 = r0.length()     // Catch:{ IllegalArgumentException -> 0x0105 }
            if (r5 >= r7) goto L_0x010a
            java.lang.String r4 = r0.substring(r5)     // Catch:{ IllegalArgumentException -> 0x0105 }
            int r15 = java.lang.Integer.parseInt(r4)     // Catch:{ IllegalArgumentException -> 0x0105 }
            r5 = 0
            java.lang.String r0 = r0.substring(r5, r1)     // Catch:{ IllegalArgumentException -> 0x0101 }
            goto L_0x012d
        L_0x0101:
            r0 = move-exception
        L_0x0102:
            r4 = 2
            goto L_0x0258
        L_0x0105:
            r0 = move-exception
            r5 = 0
        L_0x0107:
            r15 = r19
            goto L_0x0102
        L_0x010a:
            r5 = 0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0128 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0128 }
            r1.<init>()     // Catch:{ IllegalArgumentException -> 0x0128 }
            r1.append(r4)     // Catch:{ IllegalArgumentException -> 0x0128 }
            r1.append(r9)     // Catch:{ IllegalArgumentException -> 0x0128 }
            java.lang.String r4 = ". invalid IP value: "
            r1.append(r4)     // Catch:{ IllegalArgumentException -> 0x0128 }
            r1.append(r6)     // Catch:{ IllegalArgumentException -> 0x0128 }
            java.lang.String r1 = r1.toString()     // Catch:{ IllegalArgumentException -> 0x0128 }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x0128 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0128 }
        L_0x0128:
            r0 = move-exception
            goto L_0x0107
        L_0x012a:
            r5 = 0
            r15 = r19
        L_0x012d:
            java.net.InetSocketAddress r0 = io.netty.util.internal.SocketUtils.socketAddress(r0, r15)     // Catch:{ IllegalArgumentException -> 0x0101 }
            r13.add(r0)     // Catch:{ IllegalArgumentException -> 0x0101 }
            r4 = 2
            goto L_0x022b
        L_0x0137:
            r5 = 0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0128 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0128 }
            r7.<init>()     // Catch:{ IllegalArgumentException -> 0x0128 }
            r7.append(r4)     // Catch:{ IllegalArgumentException -> 0x0128 }
            r7.append(r9)     // Catch:{ IllegalArgumentException -> 0x0128 }
            r7.append(r1)     // Catch:{ IllegalArgumentException -> 0x0128 }
            r7.append(r6)     // Catch:{ IllegalArgumentException -> 0x0128 }
            java.lang.String r1 = r7.toString()     // Catch:{ IllegalArgumentException -> 0x0128 }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x0128 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0128 }
        L_0x0153:
            r0 = move-exception
        L_0x0154:
            r18 = r7
            r19 = r15
            r5 = 0
            goto L_0x0102
        L_0x015a:
            r17 = r5
            r18 = r7
            r19 = r15
            r5 = 0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0128 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0128 }
            r7.<init>()     // Catch:{ IllegalArgumentException -> 0x0128 }
            r7.append(r4)     // Catch:{ IllegalArgumentException -> 0x0128 }
            r7.append(r9)     // Catch:{ IllegalArgumentException -> 0x0128 }
            r7.append(r1)     // Catch:{ IllegalArgumentException -> 0x0128 }
            r7.append(r6)     // Catch:{ IllegalArgumentException -> 0x0128 }
            java.lang.String r1 = r7.toString()     // Catch:{ IllegalArgumentException -> 0x0128 }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x0128 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0128 }
        L_0x017c:
            r0 = move-exception
            r16 = r4
            r17 = r5
            goto L_0x0154
        L_0x0182:
            r16 = r4
            r17 = r5
            r18 = r7
            r19 = r15
            r5 = 0
            java.lang.String r0 = "domain"
            boolean r0 = r6.startsWith(r0)     // Catch:{ IllegalArgumentException -> 0x01c3 }
            java.lang.String r1 = " value: "
            if (r0 == 0) goto L_0x01e6
            r0 = 6
            int r0 = io.netty.util.internal.StringUtil.indexOfNonWhiteSpace(r6, r0)     // Catch:{ IllegalArgumentException -> 0x01c3 }
            if (r0 < 0) goto L_0x01c6
            java.lang.String r1 = r6.substring(r0)     // Catch:{ IllegalArgumentException -> 0x01c3 }
            boolean r0 = r13.isEmpty()     // Catch:{ IllegalArgumentException -> 0x01c0 }
            if (r0 != 0) goto L_0x01ae
            putIfAbsent(r3, r1, r13, r11)     // Catch:{ IllegalArgumentException -> 0x01aa }
            goto L_0x01ae
        L_0x01aa:
            r0 = move-exception
            r14 = r1
            goto L_0x0107
        L_0x01ae:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ IllegalArgumentException -> 0x01c0 }
            r4 = 2
            r0.<init>(r4)     // Catch:{ IllegalArgumentException -> 0x01ba }
            r13 = r0
            r14 = r1
        L_0x01b6:
            r15 = r19
            goto L_0x022b
        L_0x01ba:
            r0 = move-exception
        L_0x01bb:
            r14 = r1
        L_0x01bc:
            r15 = r19
            goto L_0x0258
        L_0x01c0:
            r0 = move-exception
            r4 = 2
            goto L_0x01bb
        L_0x01c3:
            r0 = move-exception
            r4 = 2
            goto L_0x01bc
        L_0x01c6:
            r4 = 2
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01e4 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x01e4 }
            r7.<init>()     // Catch:{ IllegalArgumentException -> 0x01e4 }
            java.lang.String r15 = "error parsing label domain in file "
            r7.append(r15)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            r7.append(r9)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            r7.append(r1)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            r7.append(r6)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            java.lang.String r1 = r7.toString()     // Catch:{ IllegalArgumentException -> 0x01e4 }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x01e4 }
        L_0x01e4:
            r0 = move-exception
            goto L_0x01bc
        L_0x01e6:
            r4 = 2
            java.lang.String r0 = "port"
            boolean r0 = r6.startsWith(r0)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            if (r0 == 0) goto L_0x021d
            r0 = 4
            int r0 = io.netty.util.internal.StringUtil.indexOfNonWhiteSpace(r6, r0)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            if (r0 < 0) goto L_0x0200
            java.lang.String r0 = r6.substring(r0)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            r15 = r0
            goto L_0x022b
        L_0x0200:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01e4 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x01e4 }
            r7.<init>()     // Catch:{ IllegalArgumentException -> 0x01e4 }
            java.lang.String r15 = "error parsing label port in file "
            r7.append(r15)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            r7.append(r9)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            r7.append(r1)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            r7.append(r6)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            java.lang.String r1 = r7.toString()     // Catch:{ IllegalArgumentException -> 0x01e4 }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x01e4 }
        L_0x021d:
            boolean r0 = r6.startsWith(r2)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            if (r0 == 0) goto L_0x01b6
            io.netty.util.internal.logging.InternalLogger r0 = logger     // Catch:{ IllegalArgumentException -> 0x01e4 }
            java.lang.String r1 = "row type {} not supported. Ignoring line: {}"
            r0.info(r1, r2, r6)     // Catch:{ IllegalArgumentException -> 0x01e4 }
            goto L_0x01b6
        L_0x022b:
            r1 = r20
            r4 = r16
            r5 = r17
            r7 = r18
            goto L_0x004a
        L_0x0235:
            r0 = move-exception
            r16 = r4
            r17 = r5
            r18 = r7
            r19 = r15
            goto L_0x0097
        L_0x0240:
            r0 = move-exception
            r16 = r4
            r17 = r5
            r18 = r7
            r19 = r15
            r4 = 2
            r5 = r1
            goto L_0x0258
        L_0x024c:
            r1 = r20
            r4 = r16
            r5 = r17
            r7 = r18
            r15 = r19
            goto L_0x004a
        L_0x0258:
            io.netty.util.internal.logging.InternalLogger r1 = logger     // Catch:{ all -> 0x008c }
            java.lang.String r7 = "Could not parse entry. Ignoring line: {}"
            r1.warn(r7, r6, r0)     // Catch:{ all -> 0x008c }
            goto L_0x022b
        L_0x0260:
            r16 = r4
            r17 = r5
            r18 = r7
            r5 = 0
            boolean r0 = r13.isEmpty()     // Catch:{ all -> 0x008c }
            if (r0 != 0) goto L_0x0270
            putIfAbsent(r3, r14, r13, r11)     // Catch:{ all -> 0x008c }
        L_0x0270:
            r12.close()
        L_0x0273:
            int r8 = r8 + 1
            r1 = r20
            r4 = r16
            r5 = r17
            r7 = r18
            goto L_0x001c
        L_0x027f:
            r0 = move-exception
        L_0x0280:
            if (r11 != 0) goto L_0x0286
            r10.close()
            goto L_0x0289
        L_0x0286:
            r11.close()
        L_0x0289:
            throw r0
        L_0x028a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider.parse(java.io.File[]):java.util.Map");
    }

    public static UnixResolverOptions parseEtcResolverOptions() throws IOException {
        return parseEtcResolverOptions(new File(ETC_RESOLV_CONF_FILE));
    }

    public static List<String> parseEtcResolverSearchDomains() throws IOException {
        return parseEtcResolverSearchDomains(new File(ETC_RESOLV_CONF_FILE));
    }

    private static int parseResIntOption(String str, String str2) {
        return Integer.parseInt(str.substring(str2.length()));
    }

    private static void parseResOptions(String str, UnixResolverOptions.Builder builder) {
        for (String str2 : WHITESPACE_PATTERN.split(str)) {
            try {
                if (str2.startsWith("ndots:")) {
                    builder.setNdots(parseResIntOption(str2, "ndots:"));
                } else if (str2.startsWith("attempts:")) {
                    builder.setAttempts(parseResIntOption(str2, "attempts:"));
                } else if (str2.startsWith("timeout:")) {
                    builder.setTimeout(parseResIntOption(str2, "timeout:"));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static DnsServerAddressStreamProvider parseSilently() {
        try {
            UnixResolverDnsServerAddressStreamProvider unixResolverDnsServerAddressStreamProvider = new UnixResolverDnsServerAddressStreamProvider(ETC_RESOLV_CONF_FILE, ETC_RESOLVER_DIR);
            return unixResolverDnsServerAddressStreamProvider.mayOverrideNameServers() ? unixResolverDnsServerAddressStreamProvider : DefaultDnsServerAddressStreamProvider.INSTANCE;
        } catch (Exception e) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("failed to parse {} and/or {}", ETC_RESOLV_CONF_FILE, ETC_RESOLVER_DIR, e);
            }
            return DefaultDnsServerAddressStreamProvider.INSTANCE;
        }
    }

    private static void putIfAbsent(Map<String, DnsServerAddresses> map, String str, List<InetSocketAddress> list, boolean z) {
        DnsServerAddresses dnsServerAddresses;
        if (z) {
            dnsServerAddresses = DnsServerAddresses.rotational((Iterable<? extends InetSocketAddress>) list);
        } else {
            dnsServerAddresses = DnsServerAddresses.sequential((Iterable<? extends InetSocketAddress>) list);
        }
        putIfAbsent(map, str, dnsServerAddresses);
    }

    public DnsServerAddressStream nameServerAddressStream(String str) {
        while (true) {
            int indexOf = str.indexOf(46, 1);
            if (indexOf >= 0 && indexOf != str.length() - 1) {
                DnsServerAddresses dnsServerAddresses = this.domainToNameServerStreamMap.get(str);
                if (dnsServerAddresses != null) {
                    return dnsServerAddresses.stream();
                }
                str = str.substring(indexOf + 1);
            }
        }
        return this.defaultNameServerAddresses.stream();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.netty.resolver.dns.UnixResolverOptions parseEtcResolverOptions(java.io.File r4) throws java.io.IOException {
        /*
            io.netty.resolver.dns.UnixResolverOptions$Builder r0 = io.netty.resolver.dns.UnixResolverOptions.newBuilder()
            java.io.FileReader r1 = new java.io.FileReader
            r1.<init>(r4)
            r4 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0038 }
            r2.<init>(r1)     // Catch:{ all -> 0x0038 }
        L_0x000f:
            java.lang.String r4 = r2.readLine()     // Catch:{ all -> 0x0027 }
            if (r4 == 0) goto L_0x0029
            java.lang.String r3 = "options "
            boolean r3 = r4.startsWith(r3)     // Catch:{ all -> 0x0027 }
            if (r3 == 0) goto L_0x000f
            r3 = 8
            java.lang.String r4 = r4.substring(r3)     // Catch:{ all -> 0x0027 }
            parseResOptions(r4, r0)     // Catch:{ all -> 0x0027 }
            goto L_0x0029
        L_0x0027:
            r4 = move-exception
            goto L_0x003b
        L_0x0029:
            r2.close()
            java.lang.String r4 = RES_OPTIONS
            if (r4 == 0) goto L_0x0033
            parseResOptions(r4, r0)
        L_0x0033:
            io.netty.resolver.dns.UnixResolverOptions r4 = r0.build()
            return r4
        L_0x0038:
            r0 = move-exception
            r2 = r4
            r4 = r0
        L_0x003b:
            if (r2 != 0) goto L_0x0041
            r1.close()
            goto L_0x0044
        L_0x0041:
            r2.close()
        L_0x0044:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider.parseEtcResolverOptions(java.io.File):io.netty.resolver.dns.UnixResolverOptions");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> parseEtcResolverSearchDomains(java.io.File r6) throws java.io.IOException {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.io.FileReader r1 = new java.io.FileReader
            r1.<init>(r6)
            r6 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x005a }
            r2.<init>(r1)     // Catch:{ all -> 0x005a }
        L_0x0010:
            java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x002c }
            if (r3 == 0) goto L_0x004a
            r4 = 6
            if (r6 != 0) goto L_0x002e
            java.lang.String r5 = "domain"
            boolean r5 = r3.startsWith(r5)     // Catch:{ all -> 0x002c }
            if (r5 == 0) goto L_0x002e
            int r4 = io.netty.util.internal.StringUtil.indexOfNonWhiteSpace(r3, r4)     // Catch:{ all -> 0x002c }
            if (r4 < 0) goto L_0x0010
            java.lang.String r6 = r3.substring(r4)     // Catch:{ all -> 0x002c }
            goto L_0x0010
        L_0x002c:
            r6 = move-exception
            goto L_0x005d
        L_0x002e:
            java.lang.String r5 = "search"
            boolean r5 = r3.startsWith(r5)     // Catch:{ all -> 0x002c }
            if (r5 == 0) goto L_0x0010
            int r4 = io.netty.util.internal.StringUtil.indexOfNonWhiteSpace(r3, r4)     // Catch:{ all -> 0x002c }
            if (r4 < 0) goto L_0x0010
            java.util.regex.Pattern r5 = WHITESPACE_PATTERN     // Catch:{ all -> 0x002c }
            java.lang.String r3 = r3.substring(r4)     // Catch:{ all -> 0x002c }
            java.lang.String[] r3 = r5.split(r3)     // Catch:{ all -> 0x002c }
            java.util.Collections.addAll(r0, r3)     // Catch:{ all -> 0x002c }
            goto L_0x0010
        L_0x004a:
            r2.close()
            if (r6 == 0) goto L_0x0059
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0059
            java.util.List r0 = java.util.Collections.singletonList(r6)
        L_0x0059:
            return r0
        L_0x005a:
            r0 = move-exception
            r2 = r6
            r6 = r0
        L_0x005d:
            if (r2 != 0) goto L_0x0063
            r1.close()
            goto L_0x0066
        L_0x0063:
            r2.close()
        L_0x0066:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider.parseEtcResolverSearchDomains(java.io.File):java.util.List");
    }

    private static void putIfAbsent(Map<String, DnsServerAddresses> map, String str, DnsServerAddresses dnsServerAddresses) {
        DnsServerAddresses put = map.put(str, dnsServerAddresses);
        if (put != null) {
            map.put(str, put);
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Domain name {} already maps to addresses {} so new addresses {} will be discarded", str, put, dnsServerAddresses);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UnixResolverDnsServerAddressStreamProvider(String str, String str2) throws IOException {
        this(str == null ? null : new File(str), str2 != null ? new File(str2).listFiles() : null);
    }
}
