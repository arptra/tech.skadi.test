package zmq;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.upuphone.runasone.share.lib.TransferHandler;
import com.upuphone.runasone.uupcast.CastEventCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import zmq.ZError;
import zmq.io.coder.IDecoder;
import zmq.io.coder.IEncoder;
import zmq.io.mechanism.Mechanisms;
import zmq.io.net.SelectorProviderChooser;
import zmq.io.net.tcp.TcpAddress;
import zmq.msg.MsgAllocator;
import zmq.msg.MsgAllocatorThreshold;
import zmq.util.Errno;
import zmq.util.ValueReference;

public class Options {
    public int A;
    public int B;
    public int C;
    public int D;
    public final List E = new ArrayList();
    public final List F = new ArrayList();
    public Mechanisms G;
    public boolean H;
    public String I;
    public String J;
    public String K;
    public byte[] L;
    public byte[] M;
    public byte[] N;
    public String O;
    public String P;
    public boolean Q;
    public int R;
    public boolean S;
    public int T;
    public int U;
    public int V;
    public int W;
    public byte[] X;
    public Class Y;
    public Class Z;

    /* renamed from: a  reason: collision with root package name */
    public int f3601a;
    public MsgAllocator a0;
    public int b;
    public SelectorProviderChooser b0;
    public long c;
    public Msg c0;
    public short d;
    public boolean d0;
    public byte[] e;
    public Msg e0;
    public String f;
    public boolean f0;
    public int g;
    public Msg g0;
    public int h;
    public boolean h0;
    public int i;
    public int i0;
    public int j;
    public int j0;
    public int k;
    public final Errno k0;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public long r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public String z;

    public Options() {
        Mechanisms mechanisms = Mechanisms.NULL;
        this.G = mechanisms;
        this.I = "";
        this.k0 = new Errno();
        this.f3601a = 1000;
        this.b = 1000;
        this.c = 0;
        this.g = 100;
        this.h = 10000;
        this.i = 1;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = -1;
        this.n = -1;
        this.o = 100;
        this.p = 0;
        this.q = 100;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = ZMQ.g;
        this.v = true;
        this.w = false;
        this.x = false;
        this.y = false;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.G = mechanisms;
        this.H = false;
        this.Q = false;
        this.R = 0;
        this.S = false;
        this.T = TransferHandler.TIMEOUT;
        this.U = 0;
        this.V = 0;
        this.W = -1;
        this.X = new byte[0];
        this.e = new byte[0];
        this.d = 0;
        this.L = new byte[32];
        this.M = new byte[32];
        this.N = new byte[32];
        this.a0 = new MsgAllocatorThreshold(Config.MSG_ALLOCATION_HEAP_THRESHOLD.getValue());
        this.b0 = null;
        this.d0 = false;
        this.c0 = null;
        this.f0 = false;
        this.e0 = null;
        this.h0 = false;
        this.g0 = null;
        this.i0 = -1;
        this.j0 = 0;
    }

    public static boolean e(int i2, Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() != 0;
        }
        throw new IllegalArgumentException(obj + " is neither an integer or a boolean for option " + i2);
    }

    public static byte[] f(int i2, Object obj) {
        if (obj instanceof String) {
            return ((String) obj).getBytes(ZMQ.c);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException(obj + " is neither a string or an array of bytes for option " + i2);
    }

    public static String g(int i2, Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof byte[]) {
            return new String((byte[]) obj, ZMQ.c);
        }
        throw new IllegalArgumentException(obj + " is neither a string or an array of bytes for option " + i2);
    }

    public final MsgAllocator a(Class cls) {
        try {
            return (MsgAllocator) cls.asSubclass(MsgAllocator.class).newInstance();
        } catch (InstantiationException e2) {
            throw new IllegalArgumentException(e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public final Class b(Object obj, Class cls) {
        Class cls2 = (Class) obj;
        if (cls.isAssignableFrom(cls2)) {
            Class asSubclass = cls2.asSubclass(cls);
            try {
                asSubclass.getConstructor(new Class[]{Integer.TYPE, Long.TYPE});
                return asSubclass;
            } catch (NoSuchMethodException | SecurityException e2) {
                throw new ZError.InstantiationException("Custom " + cls2.getCanonicalName() + " has no required constructor <init>(int bufferSize, long maxMsgSize)", e2);
            }
        } else {
            throw new ZError.InstantiationException("Custom " + cls2.getCanonicalName() + " is not assignable from " + cls.getCanonicalName());
        }
    }

    public final SelectorProviderChooser c(Class cls) {
        try {
            return (SelectorProviderChooser) cls.asSubclass(SelectorProviderChooser.class).newInstance();
        } catch (ClassCastException e2) {
            throw new IllegalArgumentException(e2);
        } catch (IllegalAccessException | InstantiationException e3) {
            throw new ZError.InstantiationException(e3);
        }
    }

    public Object d(int i2) {
        if (i2 == 4) {
            return Long.valueOf(this.c);
        }
        if (i2 == 5) {
            return this.e;
        }
        if (i2 == 8) {
            return Integer.valueOf(this.g);
        }
        if (i2 == 9) {
            return Integer.valueOf(this.h);
        }
        if (i2 == 11) {
            return Integer.valueOf(this.j);
        }
        if (i2 == 12) {
            return Integer.valueOf(this.k);
        }
        if (i2 == 27) {
            return Integer.valueOf(this.s);
        }
        if (i2 == 28) {
            return Integer.valueOf(this.t);
        }
        boolean z2 = true;
        if (i2 == 31) {
            return Boolean.valueOf(!this.u);
        }
        if (i2 == 32) {
            return this.f;
        }
        if (i2 == 54) {
            return Boolean.valueOf(this.S);
        }
        if (i2 == 55) {
            return this.I;
        }
        switch (i2) {
            case 16:
                return Integer.valueOf(this.m);
            case 17:
                return Integer.valueOf(this.n);
            case 18:
                return Integer.valueOf(this.o);
            case 19:
                return Integer.valueOf(this.q);
            default:
                switch (i2) {
                    case 21:
                        return Integer.valueOf(this.p);
                    case 22:
                        return Long.valueOf(this.r);
                    case 23:
                        return Integer.valueOf(this.f3601a);
                    case 24:
                        return Integer.valueOf(this.b);
                    case 25:
                        return Integer.valueOf(this.i);
                    default:
                        switch (i2) {
                            case 34:
                                return Integer.valueOf(this.A);
                            case 35:
                            case 36:
                            case 37:
                                return 0;
                            default:
                                switch (i2) {
                                    case 39:
                                        return Boolean.valueOf(!this.v);
                                    case 42:
                                        return Boolean.valueOf(this.u);
                                    case 43:
                                        return this.G;
                                    case 44:
                                        if (!this.H || this.G != Mechanisms.PLAIN) {
                                            z2 = false;
                                        }
                                        return Boolean.valueOf(z2);
                                    case 45:
                                        return this.J;
                                    case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /*46*/:
                                        return this.K;
                                    case 47:
                                        if (!this.H || this.G != Mechanisms.CURVE) {
                                            z2 = false;
                                        }
                                        return Boolean.valueOf(z2);
                                    case 48:
                                        return this.L;
                                    case 49:
                                        return this.M;
                                    case 50:
                                        return this.N;
                                    case 57:
                                        return Integer.valueOf(this.l);
                                    case 62:
                                        if (!this.H || this.G != Mechanisms.GSSAPI) {
                                            z2 = false;
                                        }
                                        return Boolean.valueOf(z2);
                                    case 63:
                                        return this.O;
                                    case 64:
                                        return this.P;
                                    case 65:
                                        return Boolean.valueOf(this.Q);
                                    case 66:
                                        return Integer.valueOf(this.T);
                                    case 67:
                                        return this.z;
                                    case 75:
                                        return Integer.valueOf(this.V);
                                    case 76:
                                        return Integer.valueOf(this.U * 100);
                                    case CastEventCode.SINK_VIDEO_SIZE_DETERMINED /*77*/:
                                        return Integer.valueOf(this.W);
                                    case 80:
                                        return Integer.valueOf(this.i0);
                                    case 1003:
                                        return this.a0;
                                    case 1004:
                                        MsgAllocator msgAllocator = this.a0;
                                        if (msgAllocator instanceof MsgAllocatorThreshold) {
                                            return Integer.valueOf(((MsgAllocatorThreshold) msgAllocator).f3647a);
                                        }
                                        return -1;
                                    case 1005:
                                        return this.X;
                                    case 1006:
                                        return this.b0;
                                    case 1039:
                                        return Boolean.valueOf(this.v);
                                    default:
                                        throw new IllegalArgumentException("option=" + i2);
                                }
                        }
                }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] h(int r6, java.lang.Object r7, zmq.util.ValueReference r8) {
        /*
            r5 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0009
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r8.b(r5)
            return r0
        L_0x0009:
            boolean r1 = r7 instanceof byte[]
            r2 = 32
            r3 = 0
            if (r1 == 0) goto L_0x0022
            r1 = r7
            byte[] r1 = (byte[]) r1
            int r4 = r1.length
            if (r4 != r2) goto L_0x0022
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r8.b(r6)
            zmq.util.Errno r6 = r5.k0
            r6.c(r3)
            r0 = r1
            goto L_0x005c
        L_0x0022:
            java.lang.String r6 = g(r6, r7)
            int r7 = r6.length()
            r1 = 40
            if (r7 != r1) goto L_0x003d
            byte[] r0 = zmq.util.Z85.a(r6)
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r8.b(r6)
            zmq.util.Errno r6 = r5.k0
            r6.c(r3)
            goto L_0x005c
        L_0x003d:
            if (r7 != r2) goto L_0x0050
            java.nio.charset.Charset r7 = zmq.ZMQ.c
            byte[] r0 = r6.getBytes(r7)
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r8.b(r6)
            zmq.util.Errno r6 = r5.k0
            r6.c(r3)
            goto L_0x005c
        L_0x0050:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r8.b(r6)
            zmq.util.Errno r6 = r5.k0
            r7 = 22
            r6.c(r7)
        L_0x005c:
            if (r0 == 0) goto L_0x0062
            zmq.io.mechanism.Mechanisms r6 = zmq.io.mechanism.Mechanisms.CURVE
            r5.G = r6
        L_0x0062:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zmq.Options.h(int, java.lang.Object, zmq.util.ValueReference):byte[]");
    }

    public boolean i(int i2, Object obj) {
        ValueReference valueReference = new ValueReference(Boolean.FALSE);
        if (i2 == 4) {
            this.c = ((Long) obj).longValue();
            return true;
        } else if (i2 == 5) {
            byte[] f2 = f(i2, obj);
            if (f2 == null || f2.length > 255) {
                throw new IllegalArgumentException("identity must not be null or less than 255 " + obj);
            }
            byte[] copyOf = Arrays.copyOf(f2, f2.length);
            this.e = copyOf;
            this.d = (short) copyOf.length;
            return true;
        } else if (i2 == 8) {
            this.g = ((Integer) obj).intValue();
            return true;
        } else if (i2 == 9) {
            this.h = ((Integer) obj).intValue();
            return true;
        } else if (i2 == 11) {
            this.j = ((Integer) obj).intValue();
            return true;
        } else if (i2 == 12) {
            this.k = ((Integer) obj).intValue();
            return true;
        } else if (i2 == 27) {
            this.s = ((Integer) obj).intValue();
            return true;
        } else if (i2 == 28) {
            this.t = ((Integer) obj).intValue();
            return true;
        } else if (i2 == 54) {
            this.S = e(i2, obj);
            return true;
        } else if (i2 != 55) {
            switch (i2) {
                case 17:
                    this.n = ((Integer) obj).intValue();
                    return true;
                case 18:
                    int intValue = ((Integer) obj).intValue();
                    this.o = intValue;
                    if (intValue >= -1) {
                        return true;
                    }
                    throw new IllegalArgumentException("reconnectIvl " + obj);
                case 19:
                    this.q = ((Integer) obj).intValue();
                    return true;
                default:
                    switch (i2) {
                        case 21:
                            int intValue2 = ((Integer) obj).intValue();
                            this.p = intValue2;
                            if (intValue2 >= 0) {
                                return true;
                            }
                            throw new IllegalArgumentException("reconnectIvlMax " + obj);
                        case 22:
                            this.r = ((Long) obj).longValue();
                            return true;
                        case 23:
                            int intValue3 = ((Integer) obj).intValue();
                            this.f3601a = intValue3;
                            if (intValue3 >= 0) {
                                return true;
                            }
                            throw new IllegalArgumentException("sendHwm " + obj);
                        case 24:
                            int intValue4 = ((Integer) obj).intValue();
                            this.b = intValue4;
                            if (intValue4 >= 0) {
                                return true;
                            }
                            throw new IllegalArgumentException("recvHwm " + obj);
                        case 25:
                            this.i = ((Integer) obj).intValue();
                            return true;
                        default:
                            switch (i2) {
                                case 31:
                                    return i(42, Boolean.valueOf(!e(i2, obj)));
                                case 42:
                                    this.u = e(i2, obj);
                                    return true;
                                case 44:
                                    boolean e2 = e(i2, obj);
                                    this.H = e2;
                                    this.G = e2 ? Mechanisms.PLAIN : Mechanisms.NULL;
                                    return true;
                                case 45:
                                    if (obj == null) {
                                        this.G = Mechanisms.NULL;
                                        this.H = false;
                                        return true;
                                    }
                                    this.J = g(i2, obj);
                                    this.H = false;
                                    this.G = Mechanisms.PLAIN;
                                    return true;
                                case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /*46*/:
                                    if (obj == null) {
                                        this.G = Mechanisms.NULL;
                                        this.H = false;
                                        return true;
                                    }
                                    this.K = g(i2, obj);
                                    this.H = false;
                                    this.G = Mechanisms.PLAIN;
                                    return true;
                                case 47:
                                    boolean e3 = e(i2, obj);
                                    this.H = e3;
                                    this.G = e3 ? Mechanisms.CURVE : Mechanisms.NULL;
                                    return true;
                                case 48:
                                    this.L = h(i2, obj, valueReference);
                                    return ((Boolean) valueReference.a()).booleanValue();
                                case 49:
                                    this.M = h(i2, obj, valueReference);
                                    return ((Boolean) valueReference.a()).booleanValue();
                                case 50:
                                    byte[] h2 = h(i2, obj, valueReference);
                                    this.N = h2;
                                    if (h2 == null) {
                                        this.H = false;
                                    }
                                    return ((Boolean) valueReference.a()).booleanValue();
                                case 57:
                                    this.l = ((Integer) obj).intValue();
                                    return true;
                                case 75:
                                    int intValue5 = ((Integer) obj).intValue();
                                    this.V = intValue5;
                                    if (intValue5 >= 0) {
                                        return true;
                                    }
                                    throw new IllegalArgumentException("heartbeatInterval only accept positive values " + obj);
                                case 76:
                                    int intValue6 = ((Integer) obj).intValue() / 100;
                                    if (intValue6 < 0 || intValue6 > 6553) {
                                        throw new IllegalArgumentException("heartbeatTtl is out of range [0..655399]" + obj);
                                    }
                                    this.U = intValue6;
                                    return true;
                                case CastEventCode.SINK_VIDEO_SIZE_DETERMINED /*77*/:
                                    int intValue7 = ((Integer) obj).intValue();
                                    this.W = intValue7;
                                    if (intValue7 >= 0) {
                                        return true;
                                    }
                                    throw new IllegalArgumentException("heartbeatTimeout only accept positive values " + obj);
                                case 79:
                                    if (obj == null) {
                                        this.c0 = null;
                                    } else {
                                        byte[] f3 = f(i2, obj);
                                        if (f3.length == 0) {
                                            this.c0 = null;
                                        } else {
                                            this.c0 = new Msg(Arrays.copyOf(f3, f3.length));
                                        }
                                    }
                                    return true;
                                case 80:
                                    this.i0 = ((Integer) obj).intValue();
                                    return true;
                                case CastEventCode.SINK_AUDIO_FOCUS_LOST /*81*/:
                                    if (obj == null) {
                                        this.e0 = null;
                                    } else {
                                        byte[] f4 = f(i2, obj);
                                        if (f4.length == 0) {
                                            this.e0 = null;
                                        } else {
                                            this.e0 = new Msg(Arrays.copyOf(f4, f4.length));
                                        }
                                    }
                                    return true;
                                case 82:
                                    if (obj == null) {
                                        this.g0 = null;
                                    } else {
                                        byte[] f5 = f(i2, obj);
                                        if (f5.length == 0) {
                                            this.g0 = null;
                                        } else {
                                            this.g0 = new Msg(Arrays.copyOf(f5, f5.length));
                                        }
                                    }
                                    return true;
                                case 1001:
                                    this.Z = b(obj, IEncoder.class);
                                    this.y = true;
                                    return true;
                                case 1002:
                                    this.Y = b(obj, IDecoder.class);
                                    this.y = true;
                                    return true;
                                case 1003:
                                    if (obj instanceof String) {
                                        try {
                                            this.a0 = a(Class.forName((String) obj));
                                            return true;
                                        } catch (ClassNotFoundException e4) {
                                            throw new IllegalArgumentException(e4);
                                        }
                                    } else if (obj instanceof Class) {
                                        this.a0 = a((Class) obj);
                                        return true;
                                    } else if (!(obj instanceof MsgAllocator)) {
                                        return false;
                                    } else {
                                        this.a0 = (MsgAllocator) obj;
                                        return true;
                                    }
                                case 1004:
                                    this.a0 = new MsgAllocatorThreshold(((Integer) obj).intValue());
                                    return true;
                                case 1005:
                                    byte[] bArr = (byte[]) obj;
                                    this.X = bArr;
                                    if (bArr != null) {
                                        return true;
                                    }
                                    throw new IllegalArgumentException("heartbeatContext cannot be null");
                                case 1006:
                                    if (obj instanceof String) {
                                        try {
                                            this.b0 = c(Class.forName((String) obj));
                                            return true;
                                        } catch (ClassNotFoundException e5) {
                                            throw new IllegalArgumentException(e5);
                                        }
                                    } else if (obj instanceof Class) {
                                        this.b0 = c((Class) obj);
                                        return true;
                                    } else if (!(obj instanceof SelectorProviderChooser)) {
                                        return false;
                                    } else {
                                        this.b0 = (SelectorProviderChooser) obj;
                                        return true;
                                    }
                                case 1039:
                                    this.v = e(i2, obj);
                                    return true;
                                default:
                                    switch (i2) {
                                        case 34:
                                            int intValue8 = ((Number) obj).intValue();
                                            this.A = intValue8;
                                            if (intValue8 == -1 || intValue8 == 0 || intValue8 == 1) {
                                                return true;
                                            }
                                            throw new IllegalArgumentException("tcpKeepAlive only accepts one of -1,0,1 " + obj);
                                        case 35:
                                        case 36:
                                        case 37:
                                            return false;
                                        case 38:
                                            String g2 = g(i2, obj);
                                            if (g2 == null) {
                                                this.E.clear();
                                            } else if (g2.length() == 0 || g2.length() > 255) {
                                                throw new IllegalArgumentException("tcp_accept_filter " + obj);
                                            } else {
                                                this.E.add(new TcpAddress.TcpAddressMask(g2, this.u));
                                            }
                                            return true;
                                        case 39:
                                            this.v = !e(i2, obj);
                                            return true;
                                        default:
                                            switch (i2) {
                                                case 62:
                                                    this.H = e(i2, obj);
                                                    this.G = Mechanisms.GSSAPI;
                                                    return true;
                                                case 63:
                                                    this.O = g(i2, obj);
                                                    this.G = Mechanisms.GSSAPI;
                                                    return true;
                                                case 64:
                                                    this.P = g(i2, obj);
                                                    this.G = Mechanisms.GSSAPI;
                                                    return true;
                                                case 65:
                                                    this.Q = e(i2, obj);
                                                    return true;
                                                case 66:
                                                    int intValue9 = ((Integer) obj).intValue();
                                                    this.T = intValue9;
                                                    if (intValue9 >= 0) {
                                                        return true;
                                                    }
                                                    throw new IllegalArgumentException("handshakeIvl only accept positive values " + obj);
                                                case 67:
                                                    this.z = g(i2, obj);
                                                    return true;
                                                default:
                                                    throw new IllegalArgumentException("Unknown Option " + i2);
                                            }
                                    }
                            }
                    }
            }
        } else {
            String g3 = g(i2, obj);
            if (g3 == null || g3.length() >= 256) {
                throw new IllegalArgumentException("zap domain length shall be < 256 : " + obj);
            }
            this.I = g3;
            return true;
        }
    }
}
