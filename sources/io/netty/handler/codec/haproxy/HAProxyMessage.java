package io.netty.handler.codec.haproxy;

import com.meizu.common.widget.MzContactsContract;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.haproxy.HAProxyProxiedProtocol;
import io.netty.handler.codec.haproxy.HAProxyTLV;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HAProxyMessage extends AbstractReferenceCounted {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ResourceLeakDetector<HAProxyMessage> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(HAProxyMessage.class);
    private final HAProxyCommand command;
    private final String destinationAddress;
    private final int destinationPort;
    private final ResourceLeakTracker<HAProxyMessage> leak;
    private final HAProxyProtocolVersion protocolVersion;
    private final HAProxyProxiedProtocol proxiedProtocol;
    private final String sourceAddress;
    private final int sourcePort;
    private final List<HAProxyTLV> tlvs;

    /* renamed from: io.netty.handler.codec.haproxy.HAProxyMessage$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        static {
            /*
                io.netty.handler.codec.haproxy.HAProxyProxiedProtocol$AddressFamily[] r0 = io.netty.handler.codec.haproxy.HAProxyProxiedProtocol.AddressFamily.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily = r0
                r1 = 1
                io.netty.handler.codec.haproxy.HAProxyProxiedProtocol$AddressFamily r2 = io.netty.handler.codec.haproxy.HAProxyProxiedProtocol.AddressFamily.AF_UNSPEC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.haproxy.HAProxyProxiedProtocol$AddressFamily r3 = io.netty.handler.codec.haproxy.HAProxyProxiedProtocol.AddressFamily.AF_UNIX     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.haproxy.HAProxyProxiedProtocol$AddressFamily r4 = io.netty.handler.codec.haproxy.HAProxyProxiedProtocol.AddressFamily.AF_IPv4     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.haproxy.HAProxyProxiedProtocol$AddressFamily r5 = io.netty.handler.codec.haproxy.HAProxyProxiedProtocol.AddressFamily.AF_IPv6     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                io.netty.handler.codec.haproxy.HAProxyTLV$Type[] r4 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type = r4
                io.netty.handler.codec.haproxy.HAProxyTLV$Type r5 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.PP2_TYPE_SSL     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type     // Catch:{ NoSuchFieldError -> 0x004e }
                io.netty.handler.codec.haproxy.HAProxyTLV$Type r4 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.PP2_TYPE_ALPN     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type     // Catch:{ NoSuchFieldError -> 0x0058 }
                io.netty.handler.codec.haproxy.HAProxyTLV$Type r1 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.PP2_TYPE_AUTHORITY     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type     // Catch:{ NoSuchFieldError -> 0x0062 }
                io.netty.handler.codec.haproxy.HAProxyTLV$Type r1 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.PP2_TYPE_SSL_VERSION     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type     // Catch:{ NoSuchFieldError -> 0x006d }
                io.netty.handler.codec.haproxy.HAProxyTLV$Type r1 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.PP2_TYPE_SSL_CN     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.netty.handler.codec.haproxy.HAProxyTLV$Type r1 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.PP2_TYPE_NETNS     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type     // Catch:{ NoSuchFieldError -> 0x0083 }
                io.netty.handler.codec.haproxy.HAProxyTLV$Type r1 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.OTHER     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.haproxy.HAProxyMessage.AnonymousClass1.<clinit>():void");
        }
    }

    private HAProxyMessage(HAProxyProtocolVersion hAProxyProtocolVersion, HAProxyCommand hAProxyCommand, HAProxyProxiedProtocol hAProxyProxiedProtocol, String str, String str2, String str3, String str4) {
        this(hAProxyProtocolVersion, hAProxyCommand, hAProxyProxiedProtocol, str, str2, portStringToInt(str3), portStringToInt(str4));
    }

    private static void checkAddress(String str, HAProxyProxiedProtocol.AddressFamily addressFamily) {
        ObjectUtil.checkNotNull(addressFamily, "addrFamily");
        int[] iArr = AnonymousClass1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily;
        int i = iArr[addressFamily.ordinal()];
        if (i != 1) {
            if (i != 2) {
                ObjectUtil.checkNotNull(str, MzContactsContract.MzContactColumns.ADDRESS);
                int i2 = iArr[addressFamily.ordinal()];
                if (i2 != 3) {
                    if (i2 != 4) {
                        throw new IllegalArgumentException("unexpected addrFamily: " + addressFamily);
                    } else if (!NetUtil.isValidIpV6Address(str)) {
                        throw new IllegalArgumentException("invalid IPv6 address: " + str);
                    }
                } else if (!NetUtil.isValidIpV4Address(str)) {
                    throw new IllegalArgumentException("invalid IPv4 address: " + str);
                }
            } else {
                ObjectUtil.checkNotNull(str, MzContactsContract.MzContactColumns.ADDRESS);
                if (str.getBytes(CharsetUtil.US_ASCII).length > 108) {
                    throw new IllegalArgumentException("invalid AF_UNIX address: " + str);
                }
            }
        } else if (str != null) {
            throw new IllegalArgumentException("unable to validate an AF_UNSPEC address: " + str);
        }
    }

    private static void checkPort(int i, HAProxyProxiedProtocol.AddressFamily addressFamily) {
        int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[addressFamily.ordinal()];
        if (i2 == 1 || i2 == 2) {
            if (i != 0) {
                throw new IllegalArgumentException("port cannot be specified with addrFamily: " + addressFamily);
            }
        } else if (i2 != 3 && i2 != 4) {
            throw new IllegalArgumentException("unexpected addrFamily: " + addressFamily);
        } else if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("invalid port: " + i + " (expected: 0 ~ 65535)");
        }
    }

    public static HAProxyMessage decodeHeader(ByteBuf byteBuf) {
        int i;
        int i2;
        String str;
        String str2;
        ObjectUtil.checkNotNull(byteBuf, "header");
        int i3 = 16;
        if (byteBuf.readableBytes() >= 16) {
            byteBuf.skipBytes(12);
            byte readByte = byteBuf.readByte();
            try {
                HAProxyProtocolVersion valueOf = HAProxyProtocolVersion.valueOf(readByte);
                HAProxyProtocolVersion hAProxyProtocolVersion = HAProxyProtocolVersion.V2;
                if (valueOf == hAProxyProtocolVersion) {
                    try {
                        HAProxyCommand valueOf2 = HAProxyCommand.valueOf(readByte);
                        HAProxyCommand hAProxyCommand = HAProxyCommand.LOCAL;
                        if (valueOf2 == hAProxyCommand) {
                            return unknownMsg(hAProxyProtocolVersion, hAProxyCommand);
                        }
                        try {
                            HAProxyProxiedProtocol valueOf3 = HAProxyProxiedProtocol.valueOf(byteBuf.readByte());
                            if (valueOf3 == HAProxyProxiedProtocol.UNKNOWN) {
                                return unknownMsg(hAProxyProtocolVersion, HAProxyCommand.PROXY);
                            }
                            int readUnsignedShort = byteBuf.readUnsignedShort();
                            HAProxyProxiedProtocol.AddressFamily addressFamily = valueOf3.addressFamily();
                            if (addressFamily != HAProxyProxiedProtocol.AddressFamily.AF_UNIX) {
                                if (addressFamily == HAProxyProxiedProtocol.AddressFamily.AF_IPv4) {
                                    if (readUnsignedShort < 12 || byteBuf.readableBytes() < 12) {
                                        throw new HAProxyProtocolException("incomplete IPv4 address information: " + Math.min(readUnsignedShort, byteBuf.readableBytes()) + " bytes (expected: 12+ bytes)");
                                    }
                                    i3 = 4;
                                } else if (addressFamily != HAProxyProxiedProtocol.AddressFamily.AF_IPv6) {
                                    throw new HAProxyProtocolException("unable to parse address information (unknown address family: " + addressFamily + ')');
                                } else if (readUnsignedShort < 36 || byteBuf.readableBytes() < 36) {
                                    throw new HAProxyProtocolException("incomplete IPv6 address information: " + Math.min(readUnsignedShort, byteBuf.readableBytes()) + " bytes (expected: 36+ bytes)");
                                }
                                str2 = ipBytesToString(byteBuf, i3);
                                str = ipBytesToString(byteBuf, i3);
                                i2 = byteBuf.readUnsignedShort();
                                i = byteBuf.readUnsignedShort();
                            } else if (readUnsignedShort < 216 || byteBuf.readableBytes() < 216) {
                                throw new HAProxyProtocolException("incomplete UNIX socket address information: " + Math.min(readUnsignedShort, byteBuf.readableBytes()) + " bytes (expected: 216+ bytes)");
                            } else {
                                int readerIndex = byteBuf.readerIndex();
                                ByteProcessor byteProcessor = ByteProcessor.FIND_NUL;
                                int i4 = 108;
                                int forEachByte = byteBuf.forEachByte(readerIndex, 108, byteProcessor);
                                int i5 = forEachByte == -1 ? 108 : forEachByte - readerIndex;
                                Charset charset = CharsetUtil.US_ASCII;
                                str2 = byteBuf.toString(readerIndex, i5, charset);
                                int i6 = readerIndex + 108;
                                int forEachByte2 = byteBuf.forEachByte(i6, 108, byteProcessor);
                                if (forEachByte2 != -1) {
                                    i4 = forEachByte2 - i6;
                                }
                                String byteBuf2 = byteBuf.toString(i6, i4, charset);
                                byteBuf.readerIndex(readerIndex + 216);
                                i2 = 0;
                                i = 0;
                                str = byteBuf2;
                            }
                            return new HAProxyMessage(valueOf, valueOf2, valueOf3, str2, str, i2, i, readTlvs(byteBuf));
                        } catch (IllegalArgumentException e) {
                            throw new HAProxyProtocolException((Throwable) e);
                        }
                    } catch (IllegalArgumentException e2) {
                        throw new HAProxyProtocolException((Throwable) e2);
                    }
                } else {
                    throw new HAProxyProtocolException("version 1 unsupported: 0x" + Integer.toHexString(readByte));
                }
            } catch (IllegalArgumentException e3) {
                throw new HAProxyProtocolException((Throwable) e3);
            }
        } else {
            throw new HAProxyProtocolException("incomplete header: " + byteBuf.readableBytes() + " bytes (expected: 16+ bytes)");
        }
    }

    private static String ipBytesToString(ByteBuf byteBuf, int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (i == 4) {
            while (i2 < 4) {
                sb.append(byteBuf.readByte() & 255);
                sb.append('.');
                i2++;
            }
        } else {
            while (i2 < 8) {
                sb.append(Integer.toHexString(byteBuf.readUnsignedShort()));
                sb.append(':');
                i2++;
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private static int portStringToInt(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt > 0 && parseInt <= 65535) {
                return parseInt;
            }
            throw new IllegalArgumentException("invalid port: " + str + " (expected: 1 ~ 65535)");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid port: " + str, e);
        }
    }

    private static HAProxyTLV readNextTLV(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 4) {
            return null;
        }
        byte readByte = byteBuf.readByte();
        HAProxyTLV.Type typeForByteValue = HAProxyTLV.Type.typeForByteValue(readByte);
        int readUnsignedShort = byteBuf.readUnsignedShort();
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type[typeForByteValue.ordinal()]) {
            case 1:
                ByteBuf retainedSlice = byteBuf.retainedSlice(byteBuf.readerIndex(), readUnsignedShort);
                ByteBuf readSlice = byteBuf.readSlice(readUnsignedShort);
                byte readByte2 = readSlice.readByte();
                int readInt = readSlice.readInt();
                if (readSlice.readableBytes() < 4) {
                    return new HAProxySSLTLV(readInt, readByte2, Collections.emptyList(), retainedSlice);
                }
                ArrayList arrayList = new ArrayList(4);
                do {
                    HAProxyTLV readNextTLV = readNextTLV(readSlice);
                    if (readNextTLV != null) {
                        arrayList.add(readNextTLV);
                    }
                    return new HAProxySSLTLV(readInt, readByte2, arrayList, retainedSlice);
                } while (readSlice.readableBytes() >= 4);
                return new HAProxySSLTLV(readInt, readByte2, arrayList, retainedSlice);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return new HAProxyTLV(typeForByteValue, readByte, byteBuf.readRetainedSlice(readUnsignedShort));
            default:
                return null;
        }
    }

    private static List<HAProxyTLV> readTlvs(ByteBuf byteBuf) {
        HAProxyTLV readNextTLV = readNextTLV(byteBuf);
        if (readNextTLV == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(4);
        do {
            arrayList.add(readNextTLV);
            if (readNextTLV instanceof HAProxySSLTLV) {
                arrayList.addAll(((HAProxySSLTLV) readNextTLV).encapsulatedTLVs());
            }
            readNextTLV = readNextTLV(byteBuf);
        } while (readNextTLV != null);
        return arrayList;
    }

    private void tryRecord() {
        ResourceLeakTracker<HAProxyMessage> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record();
        }
    }

    private static HAProxyMessage unknownMsg(HAProxyProtocolVersion hAProxyProtocolVersion, HAProxyCommand hAProxyCommand) {
        return new HAProxyMessage(hAProxyProtocolVersion, hAProxyCommand, HAProxyProxiedProtocol.UNKNOWN, (String) null, (String) null, 0, 0);
    }

    public HAProxyCommand command() {
        return this.command;
    }

    public void deallocate() {
        try {
            for (HAProxyTLV release : this.tlvs) {
                release.release();
            }
        } finally {
            ResourceLeakTracker<HAProxyMessage> resourceLeakTracker = this.leak;
            if (resourceLeakTracker != null) {
                resourceLeakTracker.close(this);
            }
        }
    }

    public String destinationAddress() {
        return this.destinationAddress;
    }

    public int destinationPort() {
        return this.destinationPort;
    }

    public HAProxyProtocolVersion protocolVersion() {
        return this.protocolVersion;
    }

    public HAProxyProxiedProtocol proxiedProtocol() {
        return this.proxiedProtocol;
    }

    public boolean release() {
        tryRecord();
        return super.release();
    }

    public String sourceAddress() {
        return this.sourceAddress;
    }

    public int sourcePort() {
        return this.sourcePort;
    }

    public int tlvNumBytes() {
        int i = 0;
        for (int i2 = 0; i2 < this.tlvs.size(); i2++) {
            i += this.tlvs.get(i2).totalNumBytes();
        }
        return i;
    }

    public List<HAProxyTLV> tlvs() {
        return this.tlvs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append(StringUtil.simpleClassName((Object) this));
        sb.append("(protocolVersion: ");
        sb.append(this.protocolVersion);
        sb.append(", command: ");
        sb.append(this.command);
        sb.append(", proxiedProtocol: ");
        sb.append(this.proxiedProtocol);
        sb.append(", sourceAddress: ");
        sb.append(this.sourceAddress);
        sb.append(", destinationAddress: ");
        sb.append(this.destinationAddress);
        sb.append(", sourcePort: ");
        sb.append(this.sourcePort);
        sb.append(", destinationPort: ");
        sb.append(this.destinationPort);
        sb.append(", tlvs: [");
        if (!this.tlvs.isEmpty()) {
            for (HAProxyTLV append : this.tlvs) {
                sb.append(append);
                sb.append(", ");
            }
            sb.setLength(sb.length() - 2);
        }
        sb.append("])");
        return sb.toString();
    }

    public HAProxyMessage(HAProxyProtocolVersion hAProxyProtocolVersion, HAProxyCommand hAProxyCommand, HAProxyProxiedProtocol hAProxyProxiedProtocol, String str, String str2, int i, int i2) {
        this(hAProxyProtocolVersion, hAProxyCommand, hAProxyProxiedProtocol, str, str2, i, i2, Collections.emptyList());
    }

    public boolean release(int i) {
        tryRecord();
        return super.release(i);
    }

    public HAProxyMessage retain() {
        tryRecord();
        return (HAProxyMessage) super.retain();
    }

    public HAProxyMessage touch() {
        tryRecord();
        return (HAProxyMessage) super.touch();
    }

    public HAProxyMessage(HAProxyProtocolVersion hAProxyProtocolVersion, HAProxyCommand hAProxyCommand, HAProxyProxiedProtocol hAProxyProxiedProtocol, String str, String str2, int i, int i2, List<? extends HAProxyTLV> list) {
        ObjectUtil.checkNotNull(hAProxyProtocolVersion, "protocolVersion");
        ObjectUtil.checkNotNull(hAProxyProxiedProtocol, "proxiedProtocol");
        ObjectUtil.checkNotNull(list, "tlvs");
        HAProxyProxiedProtocol.AddressFamily addressFamily = hAProxyProxiedProtocol.addressFamily();
        checkAddress(str, addressFamily);
        checkAddress(str2, addressFamily);
        checkPort(i, addressFamily);
        checkPort(i2, addressFamily);
        this.protocolVersion = hAProxyProtocolVersion;
        this.command = hAProxyCommand;
        this.proxiedProtocol = hAProxyProxiedProtocol;
        this.sourceAddress = str;
        this.destinationAddress = str2;
        this.sourcePort = i;
        this.destinationPort = i2;
        this.tlvs = Collections.unmodifiableList(list);
        this.leak = leakDetector.track(this);
    }

    public HAProxyMessage retain(int i) {
        tryRecord();
        return (HAProxyMessage) super.retain(i);
    }

    public HAProxyMessage touch(Object obj) {
        ResourceLeakTracker<HAProxyMessage> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record(obj);
        }
        return this;
    }

    public static HAProxyMessage decodeHeader(String str) {
        if (str != null) {
            String[] split = str.split(" ");
            int length = split.length;
            if (length < 2) {
                throw new HAProxyProtocolException("invalid header: " + str + " (expected: 'PROXY' and proxied protocol values)");
            } else if ("PROXY".equals(split[0])) {
                try {
                    HAProxyProxiedProtocol valueOf = HAProxyProxiedProtocol.valueOf(split[1]);
                    if (valueOf != HAProxyProxiedProtocol.TCP4 && valueOf != HAProxyProxiedProtocol.TCP6 && valueOf != HAProxyProxiedProtocol.UNKNOWN) {
                        throw new HAProxyProtocolException("unsupported v1 proxied protocol: " + split[1]);
                    } else if (valueOf == HAProxyProxiedProtocol.UNKNOWN) {
                        return unknownMsg(HAProxyProtocolVersion.V1, HAProxyCommand.PROXY);
                    } else {
                        if (length == 6) {
                            try {
                                return new HAProxyMessage(HAProxyProtocolVersion.V1, HAProxyCommand.PROXY, valueOf, split[2], split[3], split[4], split[5]);
                            } catch (RuntimeException e) {
                                throw new HAProxyProtocolException("invalid HAProxy message", e);
                            }
                        } else {
                            throw new HAProxyProtocolException("invalid TCP4/6 header: " + str + " (expected: 6 parts)");
                        }
                    }
                } catch (IllegalArgumentException e2) {
                    throw new HAProxyProtocolException((Throwable) e2);
                }
            } else {
                throw new HAProxyProtocolException("unknown identifier: " + split[0]);
            }
        } else {
            throw new HAProxyProtocolException("header");
        }
    }
}
