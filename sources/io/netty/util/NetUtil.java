package io.netty.util;

import io.netty.util.NetUtilInitializations;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;

public final class NetUtil {
    private static final int IPV4_MAX_CHAR_BETWEEN_SEPARATOR = 3;
    private static final boolean IPV4_PREFERRED;
    private static final int IPV4_SEPARATORS = 3;
    private static final boolean IPV6_ADDRESSES_PREFERRED;
    private static final int IPV6_BYTE_COUNT = 16;
    private static final int IPV6_MAX_CHAR_BETWEEN_SEPARATOR = 4;
    private static final int IPV6_MAX_CHAR_COUNT = 39;
    private static final int IPV6_MAX_SEPARATORS = 8;
    private static final int IPV6_MIN_SEPARATORS = 2;
    private static final int IPV6_WORD_COUNT = 8;
    public static final InetAddress LOCALHOST;
    public static final Inet4Address LOCALHOST4;
    public static final Inet6Address LOCALHOST6;
    public static final NetworkInterface LOOPBACK_IF;
    public static final int SOMAXCONN = ((Integer) AccessController.doPrivileged(new SoMaxConnAction())).intValue();
    /* access modifiers changed from: private */
    public static final InternalLogger logger;

    public static final class SoMaxConnAction implements PrivilegedAction<Integer> {
        private SoMaxConnAction() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:39:0x0095 A[Catch:{ all -> 0x0045 }] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00a6 A[SYNTHETIC, Splitter:B:41:0x00a6] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00b0 A[SYNTHETIC, Splitter:B:47:0x00b0] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer run() {
            /*
                r7 = this;
                java.lang.String r7 = "Failed to get SOMAXCONN from sysctl and file {}. Default: {}"
                boolean r0 = io.netty.util.internal.PlatformDependent.isWindows()
                if (r0 == 0) goto L_0x000b
                r0 = 200(0xc8, float:2.8E-43)
                goto L_0x000d
            L_0x000b:
                r0 = 128(0x80, float:1.794E-43)
            L_0x000d:
                java.io.File r1 = new java.io.File
                java.lang.String r2 = "/proc/sys/net/core/somaxconn"
                r1.<init>(r2)
                r2 = 0
                boolean r3 = r1.exists()     // Catch:{ Exception -> 0x004f, all -> 0x004d }
                if (r3 == 0) goto L_0x0054
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x004f, all -> 0x004d }
                java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x004f, all -> 0x004d }
                r4.<init>(r1)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
                r3.<init>(r4)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
                java.lang.String r2 = r3.readLine()     // Catch:{ Exception -> 0x0049 }
                int r0 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0049 }
                io.netty.util.internal.logging.InternalLogger r2 = io.netty.util.NetUtil.logger     // Catch:{ Exception -> 0x0049 }
                boolean r2 = r2.isDebugEnabled()     // Catch:{ Exception -> 0x0049 }
                if (r2 == 0) goto L_0x004b
                io.netty.util.internal.logging.InternalLogger r2 = io.netty.util.NetUtil.logger     // Catch:{ Exception -> 0x0049 }
                java.lang.String r4 = "{}: {}"
                java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0049 }
                r2.debug(r4, r1, r5)     // Catch:{ Exception -> 0x0049 }
                goto L_0x004b
            L_0x0045:
                r7 = move-exception
                r2 = r3
                goto L_0x00ae
            L_0x0049:
                r2 = move-exception
                goto L_0x008b
            L_0x004b:
                r2 = r3
                goto L_0x0085
            L_0x004d:
                r7 = move-exception
                goto L_0x00ae
            L_0x004f:
                r3 = move-exception
                r6 = r3
                r3 = r2
                r2 = r6
                goto L_0x008b
            L_0x0054:
                java.lang.String r3 = "io.netty.net.somaxconn.trySysctl"
                r4 = 0
                boolean r3 = io.netty.util.internal.SystemPropertyUtil.getBoolean(r3, r4)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
                if (r3 == 0) goto L_0x0077
                java.lang.String r3 = "kern.ipc.somaxconn"
                java.lang.Integer r3 = io.netty.util.NetUtil.sysctlGetInt(r3)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
                if (r3 != 0) goto L_0x0072
                java.lang.String r3 = "kern.ipc.soacceptqueue"
                java.lang.Integer r3 = io.netty.util.NetUtil.sysctlGetInt(r3)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
                if (r3 == 0) goto L_0x0078
                int r0 = r3.intValue()     // Catch:{ Exception -> 0x004f, all -> 0x004d }
                goto L_0x0078
            L_0x0072:
                int r0 = r3.intValue()     // Catch:{ Exception -> 0x004f, all -> 0x004d }
                goto L_0x0078
            L_0x0077:
                r3 = r2
            L_0x0078:
                if (r3 != 0) goto L_0x0085
                io.netty.util.internal.logging.InternalLogger r3 = io.netty.util.NetUtil.logger     // Catch:{ Exception -> 0x004f, all -> 0x004d }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
                r3.debug(r7, r1, r4)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            L_0x0085:
                if (r2 == 0) goto L_0x00a9
                r2.close()     // Catch:{ Exception -> 0x00a9 }
                goto L_0x00a9
            L_0x008b:
                io.netty.util.internal.logging.InternalLogger r4 = io.netty.util.NetUtil.logger     // Catch:{ all -> 0x0045 }
                boolean r4 = r4.isDebugEnabled()     // Catch:{ all -> 0x0045 }
                if (r4 == 0) goto L_0x00a4
                io.netty.util.internal.logging.InternalLogger r4 = io.netty.util.NetUtil.logger     // Catch:{ all -> 0x0045 }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0045 }
                java.lang.Object[] r1 = new java.lang.Object[]{r1, r5, r2}     // Catch:{ all -> 0x0045 }
                r4.debug((java.lang.String) r7, (java.lang.Object[]) r1)     // Catch:{ all -> 0x0045 }
            L_0x00a4:
                if (r3 == 0) goto L_0x00a9
                r3.close()     // Catch:{ Exception -> 0x00a9 }
            L_0x00a9:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
                return r7
            L_0x00ae:
                if (r2 == 0) goto L_0x00b3
                r2.close()     // Catch:{ Exception -> 0x00b3 }
            L_0x00b3:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.SoMaxConnAction.run():java.lang.Integer");
        }
    }

    static {
        boolean z = SystemPropertyUtil.getBoolean("java.net.preferIPv4Stack", false);
        IPV4_PREFERRED = z;
        boolean z2 = SystemPropertyUtil.getBoolean("java.net.preferIPv6Addresses", false);
        IPV6_ADDRESSES_PREFERRED = z2;
        InternalLogger instance = InternalLoggerFactory.getInstance((Class<?>) NetUtil.class);
        logger = instance;
        instance.debug("-Djava.net.preferIPv4Stack: {}", (Object) Boolean.valueOf(z));
        instance.debug("-Djava.net.preferIPv6Addresses: {}", (Object) Boolean.valueOf(z2));
        Inet4Address createLocalhost4 = NetUtilInitializations.createLocalhost4();
        LOCALHOST4 = createLocalhost4;
        Inet6Address createLocalhost6 = NetUtilInitializations.createLocalhost6();
        LOCALHOST6 = createLocalhost6;
        NetUtilInitializations.NetworkIfaceAndInetAddress determineLoopback = NetUtilInitializations.determineLoopback(createLocalhost4, createLocalhost6);
        LOOPBACK_IF = determineLoopback.iface();
        LOCALHOST = determineLoopback.address();
    }

    private NetUtil() {
    }

    public static String bytesToIpAddress(byte[] bArr) {
        return bytesToIpAddress(bArr, 0, bArr.length);
    }

    public static byte[] createByteArrayFromIpAddressString(String str) {
        if (isValidIpV4Address(str)) {
            return validIpV4ToBytes(str);
        }
        if (!isValidIpV6Address(str)) {
            return null;
        }
        if (str.charAt(0) == '[') {
            str = str.substring(1, str.length() - 1);
        }
        int indexOf = str.indexOf(37);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        return getIPv6ByName(str, true);
    }

    public static InetAddress createInetAddressFromIpAddressString(String str) {
        if (isValidIpV4Address(str)) {
            try {
                return InetAddress.getByAddress(validIpV4ToBytes(str));
            } catch (UnknownHostException e) {
                throw new IllegalStateException(e);
            }
        } else if (!isValidIpV6Address(str)) {
            return null;
        } else {
            if (str.charAt(0) == '[') {
                str = str.substring(1, str.length() - 1);
            }
            int indexOf = str.indexOf(37);
            if (indexOf >= 0) {
                try {
                    int parseInt = Integer.parseInt(str.substring(indexOf + 1));
                    byte[] iPv6ByName = getIPv6ByName(str.substring(0, indexOf), true);
                    if (iPv6ByName == null) {
                        return null;
                    }
                    return Inet6Address.getByAddress((String) null, iPv6ByName, parseInt);
                } catch (UnknownHostException e2) {
                    throw new IllegalStateException(e2);
                } catch (NumberFormatException unused) {
                    return null;
                }
            } else {
                byte[] iPv6ByName2 = getIPv6ByName(str, true);
                if (iPv6ByName2 == null) {
                    return null;
                }
                try {
                    return InetAddress.getByAddress(iPv6ByName2);
                } catch (UnknownHostException e3) {
                    throw new IllegalStateException(e3);
                }
            }
        }
    }

    private static int decimalDigit(String str, int i) {
        return str.charAt(i) - '0';
    }

    public static Inet6Address getByName(CharSequence charSequence) {
        return getByName(charSequence, true);
    }

    public static String getHostname(InetSocketAddress inetSocketAddress) {
        return PlatformDependent.javaVersion() >= 7 ? inetSocketAddress.getHostString() : inetSocketAddress.getHostName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0187, code lost:
        if (r7 <= 2) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01d2, code lost:
        if (r0.charAt(r12) != ':') goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0201, code lost:
        if (r0.charAt(r3 - 2) == ':') goto L_0x0206;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x015a, code lost:
        if ((r6 - r9) <= 3) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0175, code lost:
        if (r0.charAt(0) == ':') goto L_0x017b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getIPv6ByName(java.lang.CharSequence r17, boolean r18) {
        /*
            r0 = r17
            r1 = 16
            byte[] r2 = new byte[r1]
            int r3 = r17.length()
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = -1
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0012:
            r16 = 0
            r15 = 58
            r4 = 4
            r5 = 2
            if (r6 >= r3) goto L_0x014e
            char r1 = r0.charAt(r6)
            r14 = 46
            if (r1 == r14) goto L_0x00ab
            if (r1 == r15) goto L_0x0049
            boolean r14 = isValidHexChar(r1)
            if (r14 == 0) goto L_0x0048
            if (r8 <= 0) goto L_0x0033
            boolean r14 = isValidNumericChar(r1)
            if (r14 != 0) goto L_0x0033
            goto L_0x0048
        L_0x0033:
            if (r9 >= 0) goto L_0x0037
            r9 = r6
            goto L_0x003c
        L_0x0037:
            int r14 = r6 - r9
            if (r14 <= r4) goto L_0x003c
            return r16
        L_0x003c:
            int r1 = io.netty.util.internal.StringUtil.decodeHexNibble(r1)
            int r4 = r6 - r9
            int r4 = r4 << r5
            int r1 = r1 << r4
            int r13 = r13 + r1
            r1 = 1
            goto L_0x0148
        L_0x0048:
            return r16
        L_0x0049:
            int r1 = r10 + 1
            int r9 = r6 - r9
            if (r9 > r4) goto L_0x00aa
            if (r8 > 0) goto L_0x00aa
            r14 = 8
            if (r1 > r14) goto L_0x00aa
            int r14 = r11 + 1
            r15 = 16
            if (r14 < r15) goto L_0x005c
            goto L_0x00aa
        L_0x005c:
            int r9 = 4 - r9
            int r5 = r9 << 2
            int r5 = r13 << r5
            if (r12 <= 0) goto L_0x0066
            int r12 = r12 + -2
        L_0x0066:
            r9 = r5 & 15
            int r9 = r9 << r4
            int r13 = r5 >> 4
            r13 = r13 & 15
            r9 = r9 | r13
            byte r9 = (byte) r9
            r2[r11] = r9
            int r11 = r11 + 2
            int r9 = r5 >> 8
            r9 = r9 & 15
            int r4 = r9 << 4
            r9 = 12
            int r5 = r5 >> r9
            r5 = r5 & 15
            r4 = r4 | r5
            byte r4 = (byte) r4
            r2[r14] = r4
            int r4 = r6 + 1
            if (r4 >= r3) goto L_0x00a4
            char r5 = r0.charAt(r4)
            r9 = 58
            if (r5 != r9) goto L_0x00a4
            int r6 = r6 + 2
            if (r7 != 0) goto L_0x00a3
            if (r6 >= r3) goto L_0x009b
            char r1 = r0.charAt(r6)
            if (r1 != r9) goto L_0x009b
            goto L_0x00a3
        L_0x009b:
            int r10 = r10 + 2
            int r1 = 14 - r11
            r12 = r1
            r6 = r4
            r7 = r11
            goto L_0x00a5
        L_0x00a3:
            return r16
        L_0x00a4:
            r10 = r1
        L_0x00a5:
            r1 = 1
            r9 = -1
            r13 = 0
            goto L_0x0148
        L_0x00aa:
            return r16
        L_0x00ab:
            int r8 = r8 + 1
            int r1 = r6 - r9
            r4 = 3
            if (r1 > r4) goto L_0x014d
            if (r9 < 0) goto L_0x014d
            if (r8 > r4) goto L_0x014d
            if (r10 <= 0) goto L_0x00be
            int r4 = r11 + r12
            r9 = 12
            if (r4 < r9) goto L_0x014d
        L_0x00be:
            int r4 = r6 + 1
            if (r4 >= r3) goto L_0x014d
            r4 = 16
            if (r11 >= r4) goto L_0x014d
            r4 = 1
            if (r8 != r4) goto L_0x0124
            if (r18 == 0) goto L_0x014d
            if (r11 == 0) goto L_0x00d3
            boolean r4 = isValidIPv4Mapped(r2, r11, r7, r12)
            if (r4 == 0) goto L_0x014d
        L_0x00d3:
            r4 = 3
            if (r1 != r4) goto L_0x00fa
            int r4 = r6 + -1
            char r4 = r0.charAt(r4)
            boolean r4 = isValidNumericChar(r4)
            if (r4 == 0) goto L_0x014d
            int r4 = r6 + -2
            char r4 = r0.charAt(r4)
            boolean r4 = isValidNumericChar(r4)
            if (r4 == 0) goto L_0x014d
            int r4 = r6 + -3
            char r4 = r0.charAt(r4)
            boolean r4 = isValidNumericChar(r4)
            if (r4 == 0) goto L_0x014d
        L_0x00fa:
            if (r1 != r5) goto L_0x0114
            int r4 = r6 + -1
            char r4 = r0.charAt(r4)
            boolean r4 = isValidNumericChar(r4)
            if (r4 == 0) goto L_0x014d
            int r4 = r6 + -2
            char r4 = r0.charAt(r4)
            boolean r4 = isValidNumericChar(r4)
            if (r4 == 0) goto L_0x014d
        L_0x0114:
            r4 = 1
            if (r1 != r4) goto L_0x0124
            int r4 = r6 + -1
            char r4 = r0.charAt(r4)
            boolean r4 = isValidNumericChar(r4)
            if (r4 != 0) goto L_0x0124
            goto L_0x014d
        L_0x0124:
            int r1 = 3 - r1
            int r1 = r1 << r5
            int r1 = r13 << r1
            r4 = r1 & 15
            int r4 = r4 * 100
            int r5 = r1 >> 4
            r5 = r5 & 15
            r9 = 10
            int r5 = r5 * r9
            int r4 = r4 + r5
            r5 = 8
            int r1 = r1 >> r5
            r1 = r1 & 15
            int r4 = r4 + r1
            r1 = 255(0xff, float:3.57E-43)
            if (r4 <= r1) goto L_0x0140
            return r16
        L_0x0140:
            int r1 = r11 + 1
            byte r4 = (byte) r4
            r2[r11] = r4
            r11 = r1
            goto L_0x00a5
        L_0x0148:
            int r6 = r6 + r1
            r1 = 16
            goto L_0x0012
        L_0x014d:
            return r16
        L_0x014e:
            r1 = 1
            if (r7 <= 0) goto L_0x0152
            goto L_0x0153
        L_0x0152:
            r1 = 0
        L_0x0153:
            if (r8 <= 0) goto L_0x01b3
            if (r9 <= 0) goto L_0x015d
            int r3 = r6 - r9
            r4 = 3
            if (r3 > r4) goto L_0x01b2
            goto L_0x015e
        L_0x015d:
            r4 = 3
        L_0x015e:
            if (r8 != r4) goto L_0x01b2
            r3 = 16
            if (r11 < r3) goto L_0x0165
            goto L_0x01b2
        L_0x0165:
            if (r10 == 0) goto L_0x018a
            if (r10 < r5) goto L_0x0189
            if (r1 != 0) goto L_0x0178
            r3 = 6
            if (r10 != r3) goto L_0x0178
            r3 = 0
            char r4 = r0.charAt(r3)
            r12 = 58
            if (r4 != r12) goto L_0x018a
            goto L_0x017b
        L_0x0178:
            r3 = 0
            r12 = 58
        L_0x017b:
            if (r1 == 0) goto L_0x0189
            r1 = 8
            if (r10 >= r1) goto L_0x0189
            char r0 = r0.charAt(r3)
            if (r0 != r12) goto L_0x018a
            if (r7 <= r5) goto L_0x018a
        L_0x0189:
            return r16
        L_0x018a:
            int r6 = r6 - r9
            r0 = 3
            int r4 = 3 - r6
            int r0 = r4 << 2
            int r0 = r13 << r0
            r1 = r0 & 15
            int r1 = r1 * 100
            int r3 = r0 >> 4
            r3 = r3 & 15
            r4 = 10
            int r3 = r3 * r4
            int r1 = r1 + r3
            r3 = 8
            int r0 = r0 >> r3
            r0 = r0 & 15
            int r1 = r1 + r0
            r0 = 255(0xff, float:3.57E-43)
            if (r1 <= r0) goto L_0x01a9
            return r16
        L_0x01a9:
            int r0 = r11 + 1
            byte r1 = (byte) r1
            r2[r11] = r1
        L_0x01ae:
            r1 = 16
            goto L_0x023d
        L_0x01b2:
            return r16
        L_0x01b3:
            int r12 = r3 + -1
            if (r9 <= 0) goto L_0x01bb
            int r14 = r6 - r9
            if (r14 > r4) goto L_0x0255
        L_0x01bb:
            if (r10 < r5) goto L_0x0255
            if (r1 != 0) goto L_0x01d5
            int r14 = r10 + 1
            r15 = 8
            if (r14 != r15) goto L_0x0255
            r14 = 0
            char r4 = r0.charAt(r14)
            r14 = 58
            if (r4 == r14) goto L_0x0255
            char r4 = r0.charAt(r12)
            if (r4 == r14) goto L_0x0255
            goto L_0x01d9
        L_0x01d5:
            r14 = 58
            r15 = 8
        L_0x01d9:
            if (r1 == 0) goto L_0x01f2
            if (r10 > r15) goto L_0x0255
            if (r10 != r15) goto L_0x01f2
            if (r7 > r5) goto L_0x01e8
            r1 = 0
            char r4 = r0.charAt(r1)
            if (r4 != r14) goto L_0x0255
        L_0x01e8:
            r1 = 14
            if (r7 < r1) goto L_0x01f2
            char r1 = r0.charAt(r12)
            if (r1 != r14) goto L_0x0255
        L_0x01f2:
            int r1 = r11 + 1
            r4 = 16
            if (r1 >= r4) goto L_0x0255
            if (r9 >= 0) goto L_0x0204
            int r3 = r3 - r5
            char r3 = r0.charAt(r3)
            r4 = 58
            if (r3 != r4) goto L_0x0255
            goto L_0x0206
        L_0x0204:
            r4 = 58
        L_0x0206:
            if (r7 <= r5) goto L_0x0210
            r3 = 0
            char r0 = r0.charAt(r3)
            if (r0 != r4) goto L_0x0210
            goto L_0x0255
        L_0x0210:
            if (r9 < 0) goto L_0x021c
            int r6 = r6 - r9
            r0 = 4
            if (r6 > r0) goto L_0x021d
            int r4 = 4 - r6
            int r3 = r4 << 2
            int r13 = r13 << r3
            goto L_0x021d
        L_0x021c:
            r0 = 4
        L_0x021d:
            r3 = r13 & 15
            int r3 = r3 << r0
            int r4 = r13 >> 4
            r4 = r4 & 15
            r3 = r3 | r4
            byte r3 = (byte) r3
            r2[r11] = r3
            int r3 = r11 + 2
            int r4 = r13 >> 8
            r4 = r4 & 15
            int r0 = r4 << 4
            r4 = 12
            int r4 = r13 >> 12
            r4 = r4 & 15
            r0 = r0 | r4
            byte r0 = (byte) r0
            r2[r1] = r0
            r0 = r3
            goto L_0x01ae
        L_0x023d:
            if (r0 >= r1) goto L_0x0249
            int r0 = r0 - r7
            int r1 = 16 - r0
            java.lang.System.arraycopy(r2, r7, r2, r1, r0)
            r0 = 0
            java.util.Arrays.fill(r2, r7, r1, r0)
        L_0x0249:
            if (r8 <= 0) goto L_0x0254
            r0 = 11
            r1 = -1
            r2[r0] = r1
            r0 = 10
            r2[r0] = r1
        L_0x0254:
            return r2
        L_0x0255:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.getIPv6ByName(java.lang.CharSequence, boolean):byte[]");
    }

    private static boolean inRangeEndExclusive(int i, int i2, int i3) {
        return i >= i2 && i < i3;
    }

    public static String intToIpAddress(int i) {
        StringBuilder sb = new StringBuilder(15);
        sb.append((i >> 24) & 255);
        sb.append('.');
        sb.append((i >> 16) & 255);
        sb.append('.');
        sb.append((i >> 8) & 255);
        sb.append('.');
        sb.append(i & 255);
        return sb.toString();
    }

    public static int ipv4AddressToInt(Inet4Address inet4Address) {
        byte[] address = inet4Address.getAddress();
        return (address[3] & 255) | ((address[0] & 255) << 24) | ((address[1] & 255) << 16) | ((address[2] & 255) << 8);
    }

    private static byte ipv4WordToByte(String str, int i, int i2) {
        int decimalDigit = decimalDigit(str, i);
        int i3 = i + 1;
        if (i3 == i2) {
            return (byte) decimalDigit;
        }
        int decimalDigit2 = (decimalDigit * 10) + decimalDigit(str, i3);
        int i4 = i + 2;
        return i4 == i2 ? (byte) decimalDigit2 : (byte) ((decimalDigit2 * 10) + decimalDigit(str, i4));
    }

    public static boolean isIpV4StackPreferred() {
        return IPV4_PREFERRED;
    }

    public static boolean isIpV6AddressesPreferred() {
        return IPV6_ADDRESSES_PREFERRED;
    }

    private static boolean isValidHexChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    private static boolean isValidIPv4Mapped(byte[] bArr, int i, int i2, int i3) {
        boolean z = i3 + i2 >= 14;
        if (i > 12 || i < 2) {
            return false;
        }
        return (!z || i2 < 12) && isValidIPv4MappedSeparators(bArr[i + -1], bArr[i + -2], z) && PlatformDependent.isZero(bArr, 0, i + -3);
    }

    private static boolean isValidIPv4MappedChar(char c) {
        return c == 'f' || c == 'F';
    }

    private static boolean isValidIPv4MappedSeparators(byte b, byte b2, boolean z) {
        return b == b2 && (b == 0 || (!z && b2 == -1));
    }

    public static boolean isValidIpV4Address(CharSequence charSequence) {
        return isValidIpV4Address(charSequence, 0, charSequence.length());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r0 = io.netty.util.AsciiString.indexOf(r3, '.', (r4 = io.netty.util.AsciiString.indexOf(r3, '.', (r0 = io.netty.util.AsciiString.indexOf(r3, '.', r4 + 1)) + 2)) + 2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isValidIpV4Address0(java.lang.CharSequence r3, int r4, int r5) {
        /*
            int r0 = r5 - r4
            r1 = 15
            if (r0 > r1) goto L_0x0040
            r1 = 7
            if (r0 < r1) goto L_0x0040
            int r0 = r4 + 1
            r1 = 46
            int r0 = io.netty.util.AsciiString.indexOf(r3, r1, r0)
            if (r0 <= 0) goto L_0x0040
            boolean r4 = isValidIpV4Word(r3, r4, r0)
            if (r4 == 0) goto L_0x0040
            int r4 = r0 + 2
            int r4 = io.netty.util.AsciiString.indexOf(r3, r1, r4)
            if (r4 <= 0) goto L_0x0040
            r2 = 1
            int r0 = r0 + r2
            boolean r0 = isValidIpV4Word(r3, r0, r4)
            if (r0 == 0) goto L_0x0040
            int r0 = r4 + 2
            int r0 = io.netty.util.AsciiString.indexOf(r3, r1, r0)
            if (r0 <= 0) goto L_0x0040
            int r4 = r4 + r2
            boolean r4 = isValidIpV4Word(r3, r4, r0)
            if (r4 == 0) goto L_0x0040
            int r0 = r0 + r2
            boolean r3 = isValidIpV4Word(r3, r0, r5)
            if (r3 == 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r2 = 0
        L_0x0041:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.isValidIpV4Address0(java.lang.CharSequence, int, int):boolean");
    }

    private static boolean isValidIpV4Word(CharSequence charSequence, int i, int i2) {
        char charAt;
        char charAt2;
        int i3 = i2 - i;
        if (i3 < 1 || i3 > 3 || (charAt = charSequence.charAt(i)) < '0') {
            return false;
        }
        if (i3 == 3) {
            char charAt3 = charSequence.charAt(i + 1);
            if (charAt3 < '0' || (charAt2 = charSequence.charAt(i + 2)) < '0') {
                return false;
            }
            if (charAt > '1' || charAt3 > '9' || charAt2 > '9') {
                if (charAt != '2' || charAt3 > '5') {
                    return false;
                }
                if (charAt2 > '5' && (charAt3 >= '5' || charAt2 > '9')) {
                    return false;
                }
            }
            return true;
        } else if (charAt <= '9') {
            return i3 == 1 || isValidNumericChar(charSequence.charAt(i + 1));
        } else {
            return false;
        }
    }

    public static boolean isValidIpV6Address(String str) {
        return isValidIpV6Address((CharSequence) str);
    }

    private static boolean isValidNumericChar(char c) {
        return c >= '0' && c <= '9';
    }

    private static StringBuilder newSocketAddressStringBuilder(String str, String str2, boolean z) {
        int length = str.length();
        if (z) {
            StringBuilder sb = new StringBuilder(length + 1 + str2.length());
            sb.append(str);
            return sb;
        }
        StringBuilder sb2 = new StringBuilder(length + 3 + str2.length());
        if (length > 1 && str.charAt(0) == '[' && str.charAt(length - 1) == ']') {
            sb2.append(str);
            return sb2;
        }
        sb2.append('[');
        sb2.append(str);
        sb2.append(']');
        return sb2;
    }

    /* access modifiers changed from: private */
    public static Integer sysctlGetInt(String str) throws IOException {
        BufferedReader bufferedReader;
        Process start = new ProcessBuilder(new String[]{"sysctl", str}).start();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.startsWith(str)) {
                int length = readLine.length();
                while (true) {
                    length--;
                    if (length > str.length()) {
                        if (!Character.isDigit(readLine.charAt(length))) {
                            Integer valueOf = Integer.valueOf(readLine.substring(length + 1));
                            bufferedReader.close();
                            start.destroy();
                            return valueOf;
                        }
                    }
                }
            }
            bufferedReader.close();
            start.destroy();
            return null;
        } catch (Throwable th) {
            start.destroy();
            throw th;
        }
    }

    public static String toAddressString(InetAddress inetAddress) {
        return toAddressString(inetAddress, false);
    }

    public static String toSocketAddressString(InetSocketAddress inetSocketAddress) {
        StringBuilder sb;
        String valueOf = String.valueOf(inetSocketAddress.getPort());
        if (inetSocketAddress.isUnresolved()) {
            String hostname = getHostname(inetSocketAddress);
            sb = newSocketAddressStringBuilder(hostname, valueOf, !isValidIpV6Address(hostname));
        } else {
            InetAddress address = inetSocketAddress.getAddress();
            sb = newSocketAddressStringBuilder(toAddressString(address), valueOf, address instanceof Inet4Address);
        }
        sb.append(':');
        sb.append(valueOf);
        return sb.toString();
    }

    public static byte[] validIpV4ToBytes(String str) {
        int indexOf = str.indexOf(46, 1);
        byte ipv4WordToByte = ipv4WordToByte(str, 0, indexOf);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(46, indexOf + 2);
        byte ipv4WordToByte2 = ipv4WordToByte(str, i, indexOf2);
        int indexOf3 = str.indexOf(46, indexOf2 + 2);
        return new byte[]{ipv4WordToByte, ipv4WordToByte2, ipv4WordToByte(str, indexOf2 + 1, indexOf3), ipv4WordToByte(str, indexOf3 + 1, str.length())};
    }

    public static String bytesToIpAddress(byte[] bArr, int i, int i2) {
        if (i2 == 4) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(bArr[i] & 255);
            sb.append('.');
            sb.append(bArr[i + 1] & 255);
            sb.append('.');
            sb.append(bArr[i + 2] & 255);
            sb.append('.');
            sb.append(bArr[i + 3] & 255);
            return sb.toString();
        } else if (i2 == 16) {
            return toAddressString(bArr, i, false);
        } else {
            throw new IllegalArgumentException("length: " + i2 + " (expected: 4 or 16)");
        }
    }

    public static Inet6Address getByName(CharSequence charSequence, boolean z) {
        byte[] iPv6ByName = getIPv6ByName(charSequence, z);
        if (iPv6ByName == null) {
            return null;
        }
        try {
            return Inet6Address.getByAddress((String) null, iPv6ByName, -1);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isValidIpV4Address(String str) {
        return isValidIpV4Address(str, 0, str.length());
    }

    public static boolean isValidIpV6Address(CharSequence charSequence) {
        int i;
        int i2;
        int length = charSequence.length();
        int i3 = 2;
        if (length < 2) {
            return false;
        }
        char charAt = charSequence.charAt(0);
        if (charAt == '[') {
            length--;
            if (charSequence.charAt(length) != ']') {
                return false;
            }
            charAt = charSequence.charAt(1);
            i = 1;
        } else {
            i = 0;
        }
        if (charAt != ':') {
            i2 = -1;
            i3 = 0;
        } else if (charSequence.charAt(i + 1) != ':') {
            return false;
        } else {
            int i4 = i;
            i += 2;
            i2 = i4;
        }
        int i5 = 0;
        int i6 = i;
        while (true) {
            if (i6 >= length) {
                break;
            }
            char charAt2 = charSequence.charAt(i6);
            if (!isValidHexChar(charAt2)) {
                if (charAt2 == '%') {
                    length = i6;
                    break;
                } else if (charAt2 != '.') {
                    if (charAt2 != ':' || i3 > 7) {
                        return false;
                    }
                    int i7 = i6 - 1;
                    if (charSequence.charAt(i7) != ':') {
                        i5 = 0;
                    } else if (i2 >= 0) {
                        return false;
                    } else {
                        i2 = i7;
                    }
                    i3++;
                } else if ((i2 < 0 && i3 != 6) || ((i3 == 7 && i2 >= i) || i3 > 7)) {
                    return false;
                } else {
                    int i8 = i6 - i5;
                    int i9 = i8 - 2;
                    if (isValidIPv4MappedChar(charSequence.charAt(i9))) {
                        if (!isValidIPv4MappedChar(charSequence.charAt(i8 - 3)) || !isValidIPv4MappedChar(charSequence.charAt(i8 - 4)) || !isValidIPv4MappedChar(charSequence.charAt(i8 - 5))) {
                            return false;
                        }
                        i9 = i8 - 7;
                    }
                    while (i9 >= i) {
                        char charAt3 = charSequence.charAt(i9);
                        if (charAt3 != '0' && charAt3 != ':') {
                            return false;
                        }
                        i9--;
                    }
                    int indexOf = AsciiString.indexOf(charSequence, '%', i8 + 7);
                    if (indexOf >= 0) {
                        length = indexOf;
                    }
                    return isValidIpV4Address(charSequence, i8, length);
                }
            } else if (i5 >= 4) {
                return false;
            } else {
                i5++;
            }
            i6++;
        }
        if (i2 >= 0) {
            if (i2 + 2 != length) {
                if (i5 <= 0) {
                    return false;
                }
                if (i3 >= 8 && i2 > i) {
                    return false;
                }
            }
            return true;
        } else if (i3 != 7 || i5 <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static String toAddressString(InetAddress inetAddress, boolean z) {
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        if (inetAddress instanceof Inet6Address) {
            return toAddressString(inetAddress.getAddress(), 0, z);
        }
        throw new IllegalArgumentException("Unhandled type: " + inetAddress);
    }

    private static boolean isValidIpV4Address(CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof String) {
            return isValidIpV4Address((String) charSequence, i, i2);
        }
        if (charSequence instanceof AsciiString) {
            return isValidIpV4Address((AsciiString) charSequence, i, i2);
        }
        return isValidIpV4Address0(charSequence, i, i2);
    }

    private static boolean isValidIpV4Address(String str, int i, int i2) {
        int indexOf;
        int indexOf2;
        int indexOf3;
        int i3 = i2 - i;
        if (i3 > 15 || i3 < 7 || (indexOf = str.indexOf(46, i + 1)) <= 0 || !isValidIpV4Word(str, i, indexOf) || (indexOf2 = str.indexOf(46, indexOf + 2)) <= 0 || !isValidIpV4Word(str, indexOf + 1, indexOf2) || (indexOf3 = str.indexOf(46, indexOf2 + 2)) <= 0 || !isValidIpV4Word(str, indexOf2 + 1, indexOf3) || !isValidIpV4Word(str, indexOf3 + 1, i2)) {
            return false;
        }
        return true;
    }

    private static String toAddressString(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        int[] iArr = new int[8];
        int i4 = i + 8;
        while (true) {
            i2 = 1;
            if (i >= i4) {
                break;
            }
            int i5 = i << 1;
            iArr[i] = (bArr[i5 + 1] & 255) | ((bArr[i5] & 255) << 8);
            i++;
        }
        int i6 = -1;
        boolean z2 = false;
        int i7 = -1;
        int i8 = -1;
        int i9 = 0;
        int i10 = 0;
        while (i9 < 8) {
            if (iArr[i9] == 0) {
                if (i7 < 0) {
                    i7 = i9;
                }
            } else if (i7 >= 0) {
                int i11 = i9 - i7;
                if (i11 > i10) {
                    i10 = i11;
                } else {
                    i7 = i8;
                }
                i8 = i7;
                i7 = -1;
            }
            i9++;
        }
        if (i7 < 0 || (i3 = i9 - i7) <= i10) {
            i7 = i8;
        } else {
            i10 = i3;
        }
        if (i10 == 1) {
            i10 = 0;
        } else {
            i6 = i7;
        }
        int i12 = i10 + i6;
        StringBuilder sb = new StringBuilder(39);
        if (i12 < 0) {
            sb.append(Integer.toHexString(iArr[0]));
            while (i2 < 8) {
                sb.append(':');
                sb.append(Integer.toHexString(iArr[i2]));
                i2++;
            }
        } else {
            if (inRangeEndExclusive(0, i6, i12)) {
                sb.append("::");
                if (z && i12 == 5 && iArr[5] == 65535) {
                    z2 = true;
                }
            } else {
                sb.append(Integer.toHexString(iArr[0]));
            }
            while (i2 < 8) {
                if (!inRangeEndExclusive(i2, i6, i12)) {
                    if (!inRangeEndExclusive(i2 - 1, i6, i12)) {
                        if (!z2 || i2 == 6) {
                            sb.append(':');
                        } else {
                            sb.append('.');
                        }
                    }
                    if (!z2 || i2 <= 5) {
                        sb.append(Integer.toHexString(iArr[i2]));
                    } else {
                        sb.append(iArr[i2] >> 8);
                        sb.append('.');
                        sb.append(iArr[i2] & 255);
                    }
                } else if (!inRangeEndExclusive(i2 - 1, i6, i12)) {
                    sb.append("::");
                }
                i2++;
            }
        }
        return sb.toString();
    }

    public static String toSocketAddressString(String str, int i) {
        String valueOf = String.valueOf(i);
        StringBuilder newSocketAddressStringBuilder = newSocketAddressStringBuilder(str, valueOf, !isValidIpV6Address(str));
        newSocketAddressStringBuilder.append(':');
        newSocketAddressStringBuilder.append(valueOf);
        return newSocketAddressStringBuilder.toString();
    }

    private static boolean isValidIpV4Address(AsciiString asciiString, int i, int i2) {
        int indexOf;
        int indexOf2;
        int indexOf3;
        int i3 = i2 - i;
        if (i3 > 15 || i3 < 7 || (indexOf = asciiString.indexOf('.', i + 1)) <= 0 || !isValidIpV4Word(asciiString, i, indexOf) || (indexOf2 = asciiString.indexOf('.', indexOf + 2)) <= 0 || !isValidIpV4Word(asciiString, indexOf + 1, indexOf2) || (indexOf3 = asciiString.indexOf('.', indexOf2 + 2)) <= 0 || !isValidIpV4Word(asciiString, indexOf2 + 1, indexOf3) || !isValidIpV4Word(asciiString, indexOf3 + 1, i2)) {
            return false;
        }
        return true;
    }
}
