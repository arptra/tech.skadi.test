package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class HAProxyTLV extends DefaultByteBufHolder {
    private final Type type;
    private final byte typeByteValue;

    /* renamed from: io.netty.handler.codec.haproxy.HAProxyTLV$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.netty.handler.codec.haproxy.HAProxyTLV$Type[] r0 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type = r0
                io.netty.handler.codec.haproxy.HAProxyTLV$Type r1 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.PP2_TYPE_ALPN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.haproxy.HAProxyTLV$Type r1 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.PP2_TYPE_AUTHORITY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.haproxy.HAProxyTLV$Type r1 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.PP2_TYPE_SSL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.haproxy.HAProxyTLV$Type r1 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.PP2_TYPE_SSL_VERSION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.haproxy.HAProxyTLV$Type r1 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.PP2_TYPE_SSL_CN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.netty.handler.codec.haproxy.HAProxyTLV$Type r1 = io.netty.handler.codec.haproxy.HAProxyTLV.Type.PP2_TYPE_NETNS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.haproxy.HAProxyTLV.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        PP2_TYPE_ALPN,
        PP2_TYPE_AUTHORITY,
        PP2_TYPE_SSL,
        PP2_TYPE_SSL_VERSION,
        PP2_TYPE_SSL_CN,
        PP2_TYPE_NETNS,
        OTHER;

        public static byte byteValueForType(Type type) {
            switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type[type.ordinal()]) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 32;
                case 4:
                    return 33;
                case 5:
                    return 34;
                case 6:
                    return 48;
                default:
                    throw new IllegalArgumentException("unknown type: " + type);
            }
        }

        public static Type typeForByteValue(byte b) {
            if (b == 1) {
                return PP2_TYPE_ALPN;
            }
            if (b == 2) {
                return PP2_TYPE_AUTHORITY;
            }
            if (b == 48) {
                return PP2_TYPE_NETNS;
            }
            switch (b) {
                case 32:
                    return PP2_TYPE_SSL;
                case 33:
                    return PP2_TYPE_SSL_VERSION;
                case 34:
                    return PP2_TYPE_SSL_CN;
                default:
                    return OTHER;
            }
        }
    }

    public HAProxyTLV(byte b, ByteBuf byteBuf) {
        this(Type.typeForByteValue(b), b, byteBuf);
    }

    public int contentNumBytes() {
        return content().readableBytes();
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + "(type: " + type() + ", typeByteValue: " + typeByteValue() + ", content: " + contentToString() + ')';
    }

    public int totalNumBytes() {
        return contentNumBytes() + 3;
    }

    public Type type() {
        return this.type;
    }

    public byte typeByteValue() {
        return this.typeByteValue;
    }

    public HAProxyTLV(Type type2, ByteBuf byteBuf) {
        this(type2, Type.byteValueForType(type2), byteBuf);
    }

    public HAProxyTLV copy() {
        return replace(content().copy());
    }

    public HAProxyTLV duplicate() {
        return replace(content().duplicate());
    }

    public HAProxyTLV replace(ByteBuf byteBuf) {
        return new HAProxyTLV(this.type, this.typeByteValue, byteBuf);
    }

    public HAProxyTLV retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public HAProxyTLV(Type type2, byte b, ByteBuf byteBuf) {
        super(byteBuf);
        this.type = (Type) ObjectUtil.checkNotNull(type2, "type");
        this.typeByteValue = b;
    }

    public HAProxyTLV retain() {
        super.retain();
        return this;
    }

    public HAProxyTLV touch() {
        super.touch();
        return this;
    }

    public HAProxyTLV retain(int i) {
        super.retain(i);
        return this;
    }

    public HAProxyTLV touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
