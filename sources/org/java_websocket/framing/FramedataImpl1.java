package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;
import org.java_websocket.util.ByteBufferUtils;

public abstract class FramedataImpl1 implements Framedata {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3399a = true;
    public Opcode b;
    public ByteBuffer c = ByteBufferUtils.a();
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;

    /* renamed from: org.java_websocket.framing.FramedataImpl1$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3400a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.java_websocket.enums.Opcode[] r0 = org.java_websocket.enums.Opcode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3400a = r0
                org.java_websocket.enums.Opcode r1 = org.java_websocket.enums.Opcode.PING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3400a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.java_websocket.enums.Opcode r1 = org.java_websocket.enums.Opcode.PONG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3400a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.java_websocket.enums.Opcode r1 = org.java_websocket.enums.Opcode.TEXT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3400a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.java_websocket.enums.Opcode r1 = org.java_websocket.enums.Opcode.BINARY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3400a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.java_websocket.enums.Opcode r1 = org.java_websocket.enums.Opcode.CLOSING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3400a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.java_websocket.enums.Opcode r1 = org.java_websocket.enums.Opcode.CONTINUOUS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.framing.FramedataImpl1.AnonymousClass1.<clinit>():void");
        }
    }

    public FramedataImpl1(Opcode opcode) {
        this.b = opcode;
    }

    public static FramedataImpl1 g(Opcode opcode) {
        if (opcode != null) {
            switch (AnonymousClass1.f3400a[opcode.ordinal()]) {
                case 1:
                    return new PingFrame();
                case 2:
                    return new PongFrame();
                case 3:
                    return new TextFrame();
                case 4:
                    return new BinaryFrame();
                case 5:
                    return new CloseFrame();
                case 6:
                    return new ContinuousFrame();
                default:
                    throw new IllegalArgumentException("Supplied opcode is invalid");
            }
        } else {
            throw new IllegalArgumentException("Supplied opcode cannot be null");
        }
    }

    public ByteBuffer a() {
        return this.c;
    }

    public boolean b() {
        return this.e;
    }

    public boolean c() {
        return this.f;
    }

    public Opcode d() {
        return this.b;
    }

    public boolean e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FramedataImpl1 framedataImpl1 = (FramedataImpl1) obj;
        if (this.f3399a != framedataImpl1.f3399a || this.d != framedataImpl1.d || this.e != framedataImpl1.e || this.f != framedataImpl1.f || this.g != framedataImpl1.g || this.b != framedataImpl1.b) {
            return false;
        }
        ByteBuffer byteBuffer = this.c;
        return byteBuffer != null ? byteBuffer.equals(framedataImpl1.c) : framedataImpl1.c == null;
    }

    public boolean f() {
        return this.f3399a;
    }

    public abstract void h();

    public int hashCode() {
        int hashCode = (((this.f3399a ? 1 : 0) * true) + this.b.hashCode()) * 31;
        ByteBuffer byteBuffer = this.c;
        return ((((((((hashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0);
    }

    public void i(boolean z) {
        this.f3399a = z;
    }

    public void j(ByteBuffer byteBuffer) {
        this.c = byteBuffer;
    }

    public void k(boolean z) {
        this.e = z;
    }

    public void l(boolean z) {
        this.f = z;
    }

    public void m(boolean z) {
        this.g = z;
    }

    public void n(boolean z) {
        this.d = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Framedata{ opcode:");
        sb.append(d());
        sb.append(", fin:");
        sb.append(f());
        sb.append(", rsv1:");
        sb.append(b());
        sb.append(", rsv2:");
        sb.append(c());
        sb.append(", rsv3:");
        sb.append(e());
        sb.append(", payload length:[pos:");
        sb.append(this.c.position());
        sb.append(", len:");
        sb.append(this.c.remaining());
        sb.append("], payload:");
        sb.append(this.c.remaining() > 1000 ? "(too big to display)" : new String(this.c.array()));
        sb.append('}');
        return sb.toString();
    }
}
