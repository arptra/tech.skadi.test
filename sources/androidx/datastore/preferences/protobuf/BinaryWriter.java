package androidx.datastore.preferences.protobuf;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.Utf8;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import com.here.odnp.config.OdnpConfigStatic;
import com.here.posclient.PositionEstimate;
import com.meizu.common.widget.CircularProgressButton;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;

abstract class BinaryWriter extends ByteOutput implements Writer {

    /* renamed from: a  reason: collision with root package name */
    public final BufferAllocator f1055a;
    public final int b;
    public final ArrayDeque c;
    public int d;

    /* renamed from: androidx.datastore.preferences.protobuf.BinaryWriter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1056a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1056a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f1056a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryWriter.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class SafeDirectWriter extends BinaryWriter {
        public ByteBuffer e;
        public int f;
        public int g;

        private int W() {
            return this.f - this.g;
        }

        private int b0() {
            return this.g + 1;
        }

        public void E(int i) {
            if (i >= 0) {
                U(i);
            } else {
                V((long) i);
            }
        }

        public void J(int i) {
            U(CodedOutputStream.i0(i));
        }

        public void M(long j) {
            V(CodedOutputStream.j0(j));
        }

        public void P(int i, int i2) {
            U(WireFormat.c(i, i2));
        }

        public void U(int i) {
            if ((i & -128) == 0) {
                g0(i);
            } else if ((i & -16384) == 0) {
                i0(i);
            } else if ((-2097152 & i) == 0) {
                h0(i);
            } else if ((-268435456 & i) == 0) {
                f0(i);
            } else {
                e0(i);
            }
        }

        public void V(long j) {
            switch (BinaryWriter.k(j)) {
                case 1:
                    o0(j);
                    return;
                case 2:
                    t0(j);
                    return;
                case 3:
                    s0(j);
                    return;
                case 4:
                    m0(j);
                    return;
                case 5:
                    l0(j);
                    return;
                case 6:
                    q0(j);
                    return;
                case 7:
                    p0(j);
                    return;
                case 8:
                    j0(j);
                    return;
                case 9:
                    n0(j);
                    return;
                case 10:
                    r0(j);
                    return;
                default:
                    return;
            }
        }

        public void X() {
            if (this.e != null) {
                this.d += W();
                this.e.position(this.g + 1);
                this.e = null;
                this.g = 0;
                this.f = 0;
            }
        }

        public final void Y() {
            a0(m());
        }

        public final void Z(int i) {
            a0(n(i));
        }

        public void a(int i, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                q(10);
                U(byteString.size());
                P(i, 2);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        public final void a0(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.d()) {
                ByteBuffer f2 = allocatedBuffer.f();
                if (f2.isDirect()) {
                    X();
                    this.c.addFirst(allocatedBuffer);
                    this.e = f2;
                    f2.limit(f2.capacity());
                    this.e.position(0);
                    this.e.order(ByteOrder.LITTLE_ENDIAN);
                    int limit = this.e.limit() - 1;
                    this.f = limit;
                    this.g = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        public void b(int i, Object obj, Schema schema) {
            int l = l();
            schema.a(obj, this);
            q(10);
            U(l() - l);
            P(i, 2);
        }

        public void c0(byte b) {
            ByteBuffer byteBuffer = this.e;
            int i = this.g;
            this.g = i - 1;
            byteBuffer.put(i, b);
        }

        public void d0(String str) {
            int i;
            int i2;
            int i3;
            char charAt;
            q(str.length());
            int length = str.length() - 1;
            this.g -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.e.put(this.g + length, (byte) charAt);
                length--;
            }
            if (length == -1) {
                this.g--;
                return;
            }
            this.g += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i3 = this.g) >= 0) {
                    ByteBuffer byteBuffer = this.e;
                    this.g = i3 - 1;
                    byteBuffer.put(i3, (byte) charAt2);
                } else if (charAt2 < 2048 && (i2 = this.g) > 0) {
                    ByteBuffer byteBuffer2 = this.e;
                    this.g = i2 - 1;
                    byteBuffer2.put(i2, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer3 = this.e;
                    int i4 = this.g;
                    this.g = i4 - 1;
                    byteBuffer3.put(i4, (byte) ((charAt2 >>> 6) | OdnpConfigStatic.UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES));
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i = this.g) > 1) {
                    ByteBuffer byteBuffer4 = this.e;
                    this.g = i - 1;
                    byteBuffer4.put(i, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer5 = this.e;
                    int i5 = this.g;
                    this.g = i5 - 1;
                    byteBuffer5.put(i5, (byte) (((charAt2 >>> 6) & 63) | 128));
                    ByteBuffer byteBuffer6 = this.e;
                    int i6 = this.g;
                    this.g = i6 - 1;
                    byteBuffer6.put(i6, (byte) ((charAt2 >>> 12) | OdnpConfigStatic.UPLOAD_LOW_PRIORITY_DURATION_MINUTES));
                } else if (this.g > 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            ByteBuffer byteBuffer7 = this.e;
                            int i7 = this.g;
                            this.g = i7 - 1;
                            byteBuffer7.put(i7, (byte) ((codePoint & 63) | 128));
                            ByteBuffer byteBuffer8 = this.e;
                            int i8 = this.g;
                            this.g = i8 - 1;
                            byteBuffer8.put(i8, (byte) (((codePoint >>> 6) & 63) | 128));
                            ByteBuffer byteBuffer9 = this.e;
                            int i9 = this.g;
                            this.g = i9 - 1;
                            byteBuffer9.put(i9, (byte) (((codePoint >>> 12) & 63) | 128));
                            ByteBuffer byteBuffer10 = this.e;
                            int i10 = this.g;
                            this.g = i10 - 1;
                            byteBuffer10.put(i10, (byte) ((codePoint >>> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL));
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                } else {
                    q(length);
                    length++;
                }
                length--;
            }
        }

        public void e(int i, Object obj, Schema schema) {
            P(i, 4);
            schema.a(obj, this);
            P(i, 3);
        }

        public final void e0(int i) {
            ByteBuffer byteBuffer = this.e;
            int i2 = this.g;
            this.g = i2 - 1;
            byteBuffer.put(i2, (byte) (i >>> 28));
            int i3 = this.g;
            this.g = i3 - 4;
            this.e.putInt(i3 - 3, (i & 127) | 128 | ((((i >>> 21) & 127) | 128) << 24) | ((((i >>> 14) & 127) | 128) << 16) | ((((i >>> 7) & 127) | 128) << 8));
        }

        public final void f0(int i) {
            int i2 = this.g;
            this.g = i2 - 4;
            this.e.putInt(i2 - 3, (i & 127) | 128 | ((266338304 & i) << 3) | (((2080768 & i) | PositionEstimate.Value.WLAN_AP_COUNT) << 2) | (((i & 16256) | 16384) << 1));
        }

        public void g(byte[] bArr, int i, int i2) {
            if (b0() < i2) {
                Z(i2);
            }
            int i3 = this.g - i2;
            this.g = i3;
            this.e.position(i3 + 1);
            this.e.put(bArr, i, i2);
        }

        public final void g0(int i) {
            ByteBuffer byteBuffer = this.e;
            int i2 = this.g;
            this.g = i2 - 1;
            byteBuffer.put(i2, (byte) i);
        }

        public void h(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (b0() < remaining) {
                this.d += remaining;
                this.c.addFirst(AllocatedBuffer.i(byteBuffer));
                Y();
                return;
            }
            int i = this.g - remaining;
            this.g = i;
            this.e.position(i + 1);
            this.e.put(byteBuffer);
        }

        public final void h0(int i) {
            int i2 = this.g - 3;
            this.g = i2;
            this.e.putInt(i2, (((i & 127) | 128) << 8) | ((2080768 & i) << 10) | (((i & 16256) | 16384) << 9));
        }

        public void i(byte[] bArr, int i, int i2) {
            if (b0() < i2) {
                this.d += i2;
                this.c.addFirst(AllocatedBuffer.k(bArr, i, i2));
                Y();
                return;
            }
            int i3 = this.g - i2;
            this.g = i3;
            this.e.position(i3 + 1);
            this.e.put(bArr, i, i2);
        }

        public final void i0(int i) {
            int i2 = this.g;
            this.g = i2 - 2;
            this.e.putShort(i2 - 1, (short) ((i & 127) | 128 | ((i & 16256) << 1)));
        }

        public final void j0(long j) {
            int i = this.g;
            this.g = i - 8;
            this.e.putLong(i - 7, (j & 127) | 128 | ((71494644084506624L & j) << 7) | (((558551906910208L & j) | 562949953421312L) << 6) | (((4363686772736L & j) | 4398046511104L) << 5) | (((34091302912L & j) | 34359738368L) << 4) | (((266338304 & j) | 268435456) << 3) | (((2080768 & j) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2) | (((16256 & j) | 16384) << 1));
        }

        public final void k0(long j) {
            int i = this.g;
            this.g = i - 8;
            this.e.putLong(i - 7, (j & 127) | 128 | (((71494644084506624L & j) | 72057594037927936L) << 7) | (((558551906910208L & j) | 562949953421312L) << 6) | (((4363686772736L & j) | 4398046511104L) << 5) | (((34091302912L & j) | 34359738368L) << 4) | (((266338304 & j) | 268435456) << 3) | (((2080768 & j) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2) | (((16256 & j) | 16384) << 1));
        }

        public int l() {
            return this.d + W();
        }

        public final void l0(long j) {
            int i = this.g;
            this.g = i - 5;
            this.e.putLong(i - 7, (((j & 127) | 128) << 24) | ((34091302912L & j) << 28) | (((266338304 & j) | 268435456) << 27) | (((2080768 & j) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 26) | (((16256 & j) | 16384) << 25));
        }

        public final void m0(long j) {
            f0((int) j);
        }

        public final void n0(long j) {
            ByteBuffer byteBuffer = this.e;
            int i = this.g;
            this.g = i - 1;
            byteBuffer.put(i, (byte) ((int) (j >>> 56)));
            k0(j & 72057594037927935L);
        }

        public final void o0(long j) {
            g0((int) j);
        }

        public final void p0(long j) {
            int i = this.g - 7;
            this.g = i;
            this.e.putLong(i, (((j & 127) | 128) << 8) | ((558551906910208L & j) << 14) | (((4363686772736L & j) | 4398046511104L) << 13) | (((34091302912L & j) | 34359738368L) << 12) | (((266338304 & j) | 268435456) << 11) | (((2080768 & j) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 10) | (((16256 & j) | 16384) << 9));
        }

        public void q(int i) {
            if (b0() < i) {
                Z(i);
            }
        }

        public final void q0(long j) {
            int i = this.g;
            this.g = i - 6;
            this.e.putLong(i - 7, (((j & 127) | 128) << 16) | ((4363686772736L & j) << 21) | (((34091302912L & j) | 34359738368L) << 20) | (((266338304 & j) | 268435456) << 19) | (((2080768 & j) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 18) | (((16256 & j) | 16384) << 17));
        }

        public void r(boolean z) {
            c0(z ? (byte) 1 : 0);
        }

        public final void r0(long j) {
            ByteBuffer byteBuffer = this.e;
            int i = this.g;
            this.g = i - 1;
            byteBuffer.put(i, (byte) ((int) (j >>> 63)));
            ByteBuffer byteBuffer2 = this.e;
            int i2 = this.g;
            this.g = i2 - 1;
            byteBuffer2.put(i2, (byte) ((int) (((j >>> 56) & 127) | 128)));
            k0(j & 72057594037927935L);
        }

        public final void s0(long j) {
            h0((int) j);
        }

        public final void t0(long j) {
            i0((int) j);
        }

        public void w(int i) {
            int i2 = this.g;
            this.g = i2 - 4;
            this.e.putInt(i2 - 3, i);
        }

        public void writeBool(int i, boolean z) {
            q(6);
            c0(z ? (byte) 1 : 0);
            P(i, 0);
        }

        public void writeEndGroup(int i) {
            P(i, 4);
        }

        public void writeFixed32(int i, int i2) {
            q(9);
            w(i2);
            P(i, 5);
        }

        public void writeFixed64(int i, long j) {
            q(13);
            z(j);
            P(i, 1);
        }

        public void writeInt32(int i, int i2) {
            q(15);
            E(i2);
            P(i, 0);
        }

        public void writeMessage(int i, Object obj) {
            int l = l();
            Protobuf.a().f(obj, this);
            q(10);
            U(l() - l);
            P(i, 2);
        }

        public void writeSInt32(int i, int i2) {
            q(10);
            J(i2);
            P(i, 0);
        }

        public void writeSInt64(int i, long j) {
            q(15);
            M(j);
            P(i, 0);
        }

        public void writeStartGroup(int i) {
            P(i, 3);
        }

        public void writeString(int i, String str) {
            int l = l();
            d0(str);
            q(10);
            U(l() - l);
            P(i, 2);
        }

        public void writeUInt32(int i, int i2) {
            q(10);
            U(i2);
            P(i, 0);
        }

        public void writeUInt64(int i, long j) {
            q(15);
            V(j);
            P(i, 0);
        }

        public void z(long j) {
            int i = this.g;
            this.g = i - 8;
            this.e.putLong(i - 7, j);
        }
    }

    public static final class SafeHeapWriter extends BinaryWriter {
        public AllocatedBuffer e;
        public byte[] f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;

        private void Y() {
            a0(o());
        }

        private void Z(int i2) {
            a0(p(i2));
        }

        private void a0(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.c()) {
                X();
                this.c.addFirst(allocatedBuffer);
                this.e = allocatedBuffer;
                this.f = allocatedBuffer.a();
                int b = allocatedBuffer.b();
                this.h = allocatedBuffer.e() + b;
                int g2 = b + allocatedBuffer.g();
                this.g = g2;
                this.i = g2 - 1;
                int i2 = this.h - 1;
                this.j = i2;
                this.k = i2;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        private void e0(int i2) {
            byte[] bArr = this.f;
            int i3 = this.k;
            bArr[i3] = (byte) (i2 >>> 28);
            bArr[i3 - 1] = (byte) (((i2 >>> 21) & 127) | 128);
            bArr[i3 - 2] = (byte) (((i2 >>> 14) & 127) | 128);
            bArr[i3 - 3] = (byte) (((i2 >>> 7) & 127) | 128);
            this.k = i3 - 5;
            bArr[i3 - 4] = (byte) ((i2 & 127) | 128);
        }

        private void f0(int i2) {
            byte[] bArr = this.f;
            int i3 = this.k;
            bArr[i3] = (byte) (i2 >>> 21);
            bArr[i3 - 1] = (byte) (((i2 >>> 14) & 127) | 128);
            bArr[i3 - 2] = (byte) (((i2 >>> 7) & 127) | 128);
            this.k = i3 - 4;
            bArr[i3 - 3] = (byte) ((i2 & 127) | 128);
        }

        private void g0(int i2) {
            byte[] bArr = this.f;
            int i3 = this.k;
            this.k = i3 - 1;
            bArr[i3] = (byte) i2;
        }

        private void h0(int i2) {
            byte[] bArr = this.f;
            int i3 = this.k;
            bArr[i3] = (byte) (i2 >>> 14);
            bArr[i3 - 1] = (byte) (((i2 >>> 7) & 127) | 128);
            this.k = i3 - 3;
            bArr[i3 - 2] = (byte) ((i2 & 127) | 128);
        }

        private void i0(int i2) {
            byte[] bArr = this.f;
            int i3 = this.k;
            bArr[i3] = (byte) (i2 >>> 7);
            this.k = i3 - 2;
            bArr[i3 - 1] = (byte) ((i2 & 127) | 128);
        }

        private void j0(long j2) {
            byte[] bArr = this.f;
            int i2 = this.k;
            bArr[i2] = (byte) ((int) (j2 >>> 49));
            bArr[i2 - 1] = (byte) ((int) (((j2 >>> 42) & 127) | 128));
            bArr[i2 - 2] = (byte) ((int) (((j2 >>> 35) & 127) | 128));
            bArr[i2 - 3] = (byte) ((int) (((j2 >>> 28) & 127) | 128));
            bArr[i2 - 4] = (byte) ((int) (((j2 >>> 21) & 127) | 128));
            bArr[i2 - 5] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            bArr[i2 - 6] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.k = i2 - 8;
            bArr[i2 - 7] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void k0(long j2) {
            byte[] bArr = this.f;
            int i2 = this.k;
            bArr[i2] = (byte) ((int) (j2 >>> 28));
            bArr[i2 - 1] = (byte) ((int) (((j2 >>> 21) & 127) | 128));
            bArr[i2 - 2] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            bArr[i2 - 3] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.k = i2 - 5;
            bArr[i2 - 4] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void l0(long j2) {
            byte[] bArr = this.f;
            int i2 = this.k;
            bArr[i2] = (byte) ((int) (j2 >>> 21));
            bArr[i2 - 1] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            bArr[i2 - 2] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.k = i2 - 4;
            bArr[i2 - 3] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void m0(long j2) {
            byte[] bArr = this.f;
            int i2 = this.k;
            bArr[i2] = (byte) ((int) (j2 >>> 56));
            bArr[i2 - 1] = (byte) ((int) (((j2 >>> 49) & 127) | 128));
            bArr[i2 - 2] = (byte) ((int) (((j2 >>> 42) & 127) | 128));
            bArr[i2 - 3] = (byte) ((int) (((j2 >>> 35) & 127) | 128));
            bArr[i2 - 4] = (byte) ((int) (((j2 >>> 28) & 127) | 128));
            bArr[i2 - 5] = (byte) ((int) (((j2 >>> 21) & 127) | 128));
            bArr[i2 - 6] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            bArr[i2 - 7] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.k = i2 - 9;
            bArr[i2 - 8] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void n0(long j2) {
            byte[] bArr = this.f;
            int i2 = this.k;
            this.k = i2 - 1;
            bArr[i2] = (byte) ((int) j2);
        }

        private void o0(long j2) {
            byte[] bArr = this.f;
            int i2 = this.k;
            bArr[i2] = (byte) ((int) (j2 >>> 42));
            bArr[i2 - 1] = (byte) ((int) (((j2 >>> 35) & 127) | 128));
            bArr[i2 - 2] = (byte) ((int) (((j2 >>> 28) & 127) | 128));
            bArr[i2 - 3] = (byte) ((int) (((j2 >>> 21) & 127) | 128));
            bArr[i2 - 4] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            bArr[i2 - 5] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.k = i2 - 7;
            bArr[i2 - 6] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void p0(long j2) {
            byte[] bArr = this.f;
            int i2 = this.k;
            bArr[i2] = (byte) ((int) (j2 >>> 35));
            bArr[i2 - 1] = (byte) ((int) (((j2 >>> 28) & 127) | 128));
            bArr[i2 - 2] = (byte) ((int) (((j2 >>> 21) & 127) | 128));
            bArr[i2 - 3] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            bArr[i2 - 4] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.k = i2 - 6;
            bArr[i2 - 5] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void q0(long j2) {
            byte[] bArr = this.f;
            int i2 = this.k;
            bArr[i2] = (byte) ((int) (j2 >>> 63));
            bArr[i2 - 1] = (byte) ((int) (((j2 >>> 56) & 127) | 128));
            bArr[i2 - 2] = (byte) ((int) (((j2 >>> 49) & 127) | 128));
            bArr[i2 - 3] = (byte) ((int) (((j2 >>> 42) & 127) | 128));
            bArr[i2 - 4] = (byte) ((int) (((j2 >>> 35) & 127) | 128));
            bArr[i2 - 5] = (byte) ((int) (((j2 >>> 28) & 127) | 128));
            bArr[i2 - 6] = (byte) ((int) (((j2 >>> 21) & 127) | 128));
            bArr[i2 - 7] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            bArr[i2 - 8] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.k = i2 - 10;
            bArr[i2 - 9] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void r0(long j2) {
            byte[] bArr = this.f;
            int i2 = this.k;
            bArr[i2] = (byte) (((int) j2) >>> 14);
            bArr[i2 - 1] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.k = i2 - 3;
            bArr[i2 - 2] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void s0(long j2) {
            byte[] bArr = this.f;
            int i2 = this.k;
            bArr[i2] = (byte) ((int) (j2 >>> 7));
            this.k = i2 - 2;
            bArr[i2 - 1] = (byte) ((((int) j2) & 127) | 128);
        }

        public void E(int i2) {
            if (i2 >= 0) {
                U(i2);
            } else {
                V((long) i2);
            }
        }

        public void J(int i2) {
            U(CodedOutputStream.i0(i2));
        }

        public void M(long j2) {
            V(CodedOutputStream.j0(j2));
        }

        public void P(int i2, int i3) {
            U(WireFormat.c(i2, i3));
        }

        public void U(int i2) {
            if ((i2 & -128) == 0) {
                g0(i2);
            } else if ((i2 & -16384) == 0) {
                i0(i2);
            } else if ((-2097152 & i2) == 0) {
                h0(i2);
            } else if ((-268435456 & i2) == 0) {
                f0(i2);
            } else {
                e0(i2);
            }
        }

        public void V(long j2) {
            switch (BinaryWriter.k(j2)) {
                case 1:
                    n0(j2);
                    return;
                case 2:
                    s0(j2);
                    return;
                case 3:
                    r0(j2);
                    return;
                case 4:
                    l0(j2);
                    return;
                case 5:
                    k0(j2);
                    return;
                case 6:
                    p0(j2);
                    return;
                case 7:
                    o0(j2);
                    return;
                case 8:
                    j0(j2);
                    return;
                case 9:
                    m0(j2);
                    return;
                case 10:
                    q0(j2);
                    return;
                default:
                    return;
            }
        }

        public int W() {
            return this.j - this.k;
        }

        public void X() {
            if (this.e != null) {
                this.d += W();
                AllocatedBuffer allocatedBuffer = this.e;
                allocatedBuffer.h((this.k - allocatedBuffer.b()) + 1);
                this.e = null;
                this.k = 0;
                this.j = 0;
            }
        }

        public void a(int i2, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                q(10);
                U(byteString.size());
                P(i2, 2);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        public void b(int i2, Object obj, Schema schema) {
            int l = l();
            schema.a(obj, this);
            q(10);
            U(l() - l);
            P(i2, 2);
        }

        public int b0() {
            return this.k - this.i;
        }

        public void c0(byte b) {
            byte[] bArr = this.f;
            int i2 = this.k;
            this.k = i2 - 1;
            bArr[i2] = b;
        }

        public void d0(String str) {
            int i2;
            int i3;
            int i4;
            char charAt;
            q(str.length());
            int length = str.length() - 1;
            this.k -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.f[this.k + length] = (byte) charAt;
                length--;
            }
            if (length == -1) {
                this.k--;
                return;
            }
            this.k += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i4 = this.k) > this.i) {
                    byte[] bArr = this.f;
                    this.k = i4 - 1;
                    bArr[i4] = (byte) charAt2;
                } else if (charAt2 < 2048 && (i3 = this.k) > this.g) {
                    byte[] bArr2 = this.f;
                    bArr2[i3] = (byte) ((charAt2 & '?') | 128);
                    this.k = i3 - 2;
                    bArr2[i3 - 1] = (byte) ((charAt2 >>> 6) | OdnpConfigStatic.UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i2 = this.k) > this.g + 1) {
                    byte[] bArr3 = this.f;
                    bArr3[i2] = (byte) ((charAt2 & '?') | 128);
                    bArr3[i2 - 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    this.k = i2 - 3;
                    bArr3[i2 - 2] = (byte) ((charAt2 >>> 12) | OdnpConfigStatic.UPLOAD_LOW_PRIORITY_DURATION_MINUTES);
                } else if (this.k > this.g + 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            byte[] bArr4 = this.f;
                            int i5 = this.k;
                            bArr4[i5] = (byte) ((codePoint & 63) | 128);
                            bArr4[i5 - 1] = (byte) (((codePoint >>> 6) & 63) | 128);
                            bArr4[i5 - 2] = (byte) (((codePoint >>> 12) & 63) | 128);
                            this.k = i5 - 4;
                            bArr4[i5 - 3] = (byte) ((codePoint >>> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL);
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                } else {
                    q(length);
                    length++;
                }
                length--;
            }
        }

        public void e(int i2, Object obj, Schema schema) {
            P(i2, 4);
            schema.a(obj, this);
            P(i2, 3);
        }

        public void g(byte[] bArr, int i2, int i3) {
            if (b0() < i3) {
                Z(i3);
            }
            int i4 = this.k - i3;
            this.k = i4;
            System.arraycopy(bArr, i2, this.f, i4 + 1, i3);
        }

        public void h(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (b0() < remaining) {
                this.d += remaining;
                this.c.addFirst(AllocatedBuffer.i(byteBuffer));
                Y();
            }
            int i2 = this.k - remaining;
            this.k = i2;
            byteBuffer.get(this.f, i2 + 1, remaining);
        }

        public void i(byte[] bArr, int i2, int i3) {
            if (b0() < i3) {
                this.d += i3;
                this.c.addFirst(AllocatedBuffer.k(bArr, i2, i3));
                Y();
                return;
            }
            int i4 = this.k - i3;
            this.k = i4;
            System.arraycopy(bArr, i2, this.f, i4 + 1, i3);
        }

        public int l() {
            return this.d + W();
        }

        public void q(int i2) {
            if (b0() < i2) {
                Z(i2);
            }
        }

        public void r(boolean z) {
            c0(z ? (byte) 1 : 0);
        }

        public void w(int i2) {
            byte[] bArr = this.f;
            int i3 = this.k;
            bArr[i3] = (byte) ((i2 >> 24) & 255);
            bArr[i3 - 1] = (byte) ((i2 >> 16) & 255);
            bArr[i3 - 2] = (byte) ((i2 >> 8) & 255);
            this.k = i3 - 4;
            bArr[i3 - 3] = (byte) (i2 & 255);
        }

        public void writeBool(int i2, boolean z) {
            q(6);
            c0(z ? (byte) 1 : 0);
            P(i2, 0);
        }

        public void writeEndGroup(int i2) {
            P(i2, 4);
        }

        public void writeFixed32(int i2, int i3) {
            q(9);
            w(i3);
            P(i2, 5);
        }

        public void writeFixed64(int i2, long j2) {
            q(13);
            z(j2);
            P(i2, 1);
        }

        public void writeInt32(int i2, int i3) {
            q(15);
            E(i3);
            P(i2, 0);
        }

        public void writeMessage(int i2, Object obj) {
            int l = l();
            Protobuf.a().f(obj, this);
            q(10);
            U(l() - l);
            P(i2, 2);
        }

        public void writeSInt32(int i2, int i3) {
            q(10);
            J(i3);
            P(i2, 0);
        }

        public void writeSInt64(int i2, long j2) {
            q(15);
            M(j2);
            P(i2, 0);
        }

        public void writeStartGroup(int i2) {
            P(i2, 3);
        }

        public void writeString(int i2, String str) {
            int l = l();
            d0(str);
            q(10);
            U(l() - l);
            P(i2, 2);
        }

        public void writeUInt32(int i2, int i3) {
            q(10);
            U(i3);
            P(i2, 0);
        }

        public void writeUInt64(int i2, long j2) {
            q(15);
            V(j2);
            P(i2, 0);
        }

        public void z(long j2) {
            byte[] bArr = this.f;
            int i2 = this.k;
            bArr[i2] = (byte) (((int) (j2 >> 56)) & 255);
            bArr[i2 - 1] = (byte) (((int) (j2 >> 48)) & 255);
            bArr[i2 - 2] = (byte) (((int) (j2 >> 40)) & 255);
            bArr[i2 - 3] = (byte) (((int) (j2 >> 32)) & 255);
            bArr[i2 - 4] = (byte) (((int) (j2 >> 24)) & 255);
            bArr[i2 - 5] = (byte) (((int) (j2 >> 16)) & 255);
            bArr[i2 - 6] = (byte) (((int) (j2 >> 8)) & 255);
            this.k = i2 - 8;
            bArr[i2 - 7] = (byte) (((int) j2) & 255);
        }
    }

    public static final class UnsafeDirectWriter extends BinaryWriter {
        public ByteBuffer e;
        public long f;
        public long g;
        public long h;

        private int X() {
            return (int) (this.g - this.h);
        }

        private void Z() {
            b0(m());
        }

        private void a0(int i) {
            b0(n(i));
        }

        private void b0(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.d()) {
                ByteBuffer f2 = allocatedBuffer.f();
                if (f2.isDirect()) {
                    Y();
                    this.c.addFirst(allocatedBuffer);
                    this.e = f2;
                    f2.limit(f2.capacity());
                    this.e.position(0);
                    long i = UnsafeUtil.i(this.e);
                    this.f = i;
                    long limit = i + ((long) (this.e.limit() - 1));
                    this.g = limit;
                    this.h = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        private int c0() {
            return W() + 1;
        }

        private void f0(int i) {
            long j = this.h;
            this.h = j - 1;
            UnsafeUtil.N(j, (byte) (i >>> 28));
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) (((i >>> 21) & 127) | 128));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) (((i >>> 14) & 127) | 128));
            long j4 = this.h;
            this.h = j4 - 1;
            UnsafeUtil.N(j4, (byte) (((i >>> 7) & 127) | 128));
            long j5 = this.h;
            this.h = j5 - 1;
            UnsafeUtil.N(j5, (byte) ((i & 127) | 128));
        }

        private void g0(int i) {
            long j = this.h;
            this.h = j - 1;
            UnsafeUtil.N(j, (byte) (i >>> 21));
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) (((i >>> 14) & 127) | 128));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) (((i >>> 7) & 127) | 128));
            long j4 = this.h;
            this.h = j4 - 1;
            UnsafeUtil.N(j4, (byte) ((i & 127) | 128));
        }

        private void h0(int i) {
            long j = this.h;
            this.h = j - 1;
            UnsafeUtil.N(j, (byte) i);
        }

        private void i0(int i) {
            long j = this.h;
            this.h = j - 1;
            UnsafeUtil.N(j, (byte) (i >>> 14));
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) (((i >>> 7) & 127) | 128));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) ((i & 127) | 128));
        }

        private void j0(int i) {
            long j = this.h;
            this.h = j - 1;
            UnsafeUtil.N(j, (byte) (i >>> 7));
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) ((i & 127) | 128));
        }

        private void k0(long j) {
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) ((int) (j >>> 49)));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) ((int) (((j >>> 42) & 127) | 128)));
            long j4 = this.h;
            this.h = j4 - 1;
            UnsafeUtil.N(j4, (byte) ((int) (((j >>> 35) & 127) | 128)));
            long j5 = this.h;
            this.h = j5 - 1;
            UnsafeUtil.N(j5, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j6 = this.h;
            this.h = j6 - 1;
            UnsafeUtil.N(j6, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j7 = this.h;
            this.h = j7 - 1;
            UnsafeUtil.N(j7, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j8 = this.h;
            this.h = j8 - 1;
            UnsafeUtil.N(j8, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j9 = this.h;
            this.h = j9 - 1;
            UnsafeUtil.N(j9, (byte) ((int) ((j & 127) | 128)));
        }

        private void l0(long j) {
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) ((int) (j >>> 28)));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j4 = this.h;
            this.h = j4 - 1;
            UnsafeUtil.N(j4, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j5 = this.h;
            this.h = j5 - 1;
            UnsafeUtil.N(j5, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j6 = this.h;
            this.h = j6 - 1;
            UnsafeUtil.N(j6, (byte) ((int) ((j & 127) | 128)));
        }

        private void m0(long j) {
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) ((int) (j >>> 21)));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j4 = this.h;
            this.h = j4 - 1;
            UnsafeUtil.N(j4, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j5 = this.h;
            this.h = j5 - 1;
            UnsafeUtil.N(j5, (byte) ((int) ((j & 127) | 128)));
        }

        private void n0(long j) {
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) ((int) (j >>> 56)));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) ((int) (((j >>> 49) & 127) | 128)));
            long j4 = this.h;
            this.h = j4 - 1;
            UnsafeUtil.N(j4, (byte) ((int) (((j >>> 42) & 127) | 128)));
            long j5 = this.h;
            this.h = j5 - 1;
            UnsafeUtil.N(j5, (byte) ((int) (((j >>> 35) & 127) | 128)));
            long j6 = this.h;
            this.h = j6 - 1;
            UnsafeUtil.N(j6, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j7 = this.h;
            this.h = j7 - 1;
            UnsafeUtil.N(j7, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j8 = this.h;
            this.h = j8 - 1;
            UnsafeUtil.N(j8, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j9 = this.h;
            this.h = j9 - 1;
            UnsafeUtil.N(j9, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j10 = this.h;
            this.h = j10 - 1;
            UnsafeUtil.N(j10, (byte) ((int) ((j & 127) | 128)));
        }

        private void o0(long j) {
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) ((int) j));
        }

        private void p0(long j) {
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) ((int) (j >>> 42)));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) ((int) (((j >>> 35) & 127) | 128)));
            long j4 = this.h;
            this.h = j4 - 1;
            UnsafeUtil.N(j4, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j5 = this.h;
            this.h = j5 - 1;
            UnsafeUtil.N(j5, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j6 = this.h;
            this.h = j6 - 1;
            UnsafeUtil.N(j6, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j7 = this.h;
            this.h = j7 - 1;
            UnsafeUtil.N(j7, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j8 = this.h;
            this.h = j8 - 1;
            UnsafeUtil.N(j8, (byte) ((int) ((j & 127) | 128)));
        }

        private void q0(long j) {
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) ((int) (j >>> 35)));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j4 = this.h;
            this.h = j4 - 1;
            UnsafeUtil.N(j4, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j5 = this.h;
            this.h = j5 - 1;
            UnsafeUtil.N(j5, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j6 = this.h;
            this.h = j6 - 1;
            UnsafeUtil.N(j6, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j7 = this.h;
            this.h = j7 - 1;
            UnsafeUtil.N(j7, (byte) ((int) ((j & 127) | 128)));
        }

        private void r0(long j) {
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) ((int) (j >>> 63)));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) ((int) (((j >>> 56) & 127) | 128)));
            long j4 = this.h;
            this.h = j4 - 1;
            UnsafeUtil.N(j4, (byte) ((int) (((j >>> 49) & 127) | 128)));
            long j5 = this.h;
            this.h = j5 - 1;
            UnsafeUtil.N(j5, (byte) ((int) (((j >>> 42) & 127) | 128)));
            long j6 = this.h;
            this.h = j6 - 1;
            UnsafeUtil.N(j6, (byte) ((int) (((j >>> 35) & 127) | 128)));
            long j7 = this.h;
            this.h = j7 - 1;
            UnsafeUtil.N(j7, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j8 = this.h;
            this.h = j8 - 1;
            UnsafeUtil.N(j8, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j9 = this.h;
            this.h = j9 - 1;
            UnsafeUtil.N(j9, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j10 = this.h;
            this.h = j10 - 1;
            UnsafeUtil.N(j10, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j11 = this.h;
            this.h = j11 - 1;
            UnsafeUtil.N(j11, (byte) ((int) ((j & 127) | 128)));
        }

        private void s0(long j) {
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) (((int) j) >>> 14));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j4 = this.h;
            this.h = j4 - 1;
            UnsafeUtil.N(j4, (byte) ((int) ((j & 127) | 128)));
        }

        private void t0(long j) {
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) ((int) (j >>> 7)));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) ((((int) j) & 127) | 128));
        }

        public void E(int i) {
            if (i >= 0) {
                U(i);
            } else {
                V((long) i);
            }
        }

        public void J(int i) {
            U(CodedOutputStream.i0(i));
        }

        public void M(long j) {
            V(CodedOutputStream.j0(j));
        }

        public void P(int i, int i2) {
            U(WireFormat.c(i, i2));
        }

        public void U(int i) {
            if ((i & -128) == 0) {
                h0(i);
            } else if ((i & -16384) == 0) {
                j0(i);
            } else if ((-2097152 & i) == 0) {
                i0(i);
            } else if ((-268435456 & i) == 0) {
                g0(i);
            } else {
                f0(i);
            }
        }

        public void V(long j) {
            switch (BinaryWriter.k(j)) {
                case 1:
                    o0(j);
                    return;
                case 2:
                    t0(j);
                    return;
                case 3:
                    s0(j);
                    return;
                case 4:
                    m0(j);
                    return;
                case 5:
                    l0(j);
                    return;
                case 6:
                    q0(j);
                    return;
                case 7:
                    p0(j);
                    return;
                case 8:
                    k0(j);
                    return;
                case 9:
                    n0(j);
                    return;
                case 10:
                    r0(j);
                    return;
                default:
                    return;
            }
        }

        public final int W() {
            return (int) (this.h - this.f);
        }

        public void Y() {
            if (this.e != null) {
                this.d += X();
                this.e.position(W() + 1);
                this.e = null;
                this.h = 0;
                this.g = 0;
            }
        }

        public void a(int i, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                q(10);
                U(byteString.size());
                P(i, 2);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        public void b(int i, Object obj, Schema schema) {
            int l = l();
            schema.a(obj, this);
            q(10);
            U(l() - l);
            P(i, 2);
        }

        public void d0(byte b) {
            long j = this.h;
            this.h = j - 1;
            UnsafeUtil.N(j, b);
        }

        public void e(int i, Object obj, Schema schema) {
            P(i, 4);
            schema.a(obj, this);
            P(i, 3);
        }

        public void e0(String str) {
            char charAt;
            q(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length >= 0 && (charAt = str.charAt(length)) < 128) {
                    long j = this.h;
                    this.h = j - 1;
                    UnsafeUtil.N(j, (byte) charAt);
                }
            }
            if (length != -1) {
                while (length >= 0) {
                    char charAt2 = str.charAt(length);
                    if (charAt2 < 128) {
                        long j2 = this.h;
                        if (j2 >= this.f) {
                            this.h = j2 - 1;
                            UnsafeUtil.N(j2, (byte) charAt2);
                            length--;
                        }
                    }
                    if (charAt2 < 2048) {
                        long j3 = this.h;
                        if (j3 > this.f) {
                            this.h = j3 - 1;
                            UnsafeUtil.N(j3, (byte) ((charAt2 & '?') | 128));
                            long j4 = this.h;
                            this.h = j4 - 1;
                            UnsafeUtil.N(j4, (byte) ((charAt2 >>> 6) | OdnpConfigStatic.UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES));
                            length--;
                        }
                    }
                    if (charAt2 < 55296 || 57343 < charAt2) {
                        long j5 = this.h;
                        if (j5 > this.f + 1) {
                            this.h = j5 - 1;
                            UnsafeUtil.N(j5, (byte) ((charAt2 & '?') | 128));
                            long j6 = this.h;
                            this.h = j6 - 1;
                            UnsafeUtil.N(j6, (byte) (((charAt2 >>> 6) & 63) | 128));
                            long j7 = this.h;
                            this.h = j7 - 1;
                            UnsafeUtil.N(j7, (byte) ((charAt2 >>> 12) | OdnpConfigStatic.UPLOAD_LOW_PRIORITY_DURATION_MINUTES));
                            length--;
                        }
                    }
                    if (this.h > this.f + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                long j8 = this.h;
                                this.h = j8 - 1;
                                UnsafeUtil.N(j8, (byte) ((codePoint & 63) | 128));
                                long j9 = this.h;
                                this.h = j9 - 1;
                                UnsafeUtil.N(j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                long j10 = this.h;
                                this.h = j10 - 1;
                                UnsafeUtil.N(j10, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j11 = this.h;
                                this.h = j11 - 1;
                                UnsafeUtil.N(j11, (byte) ((codePoint >>> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    q(length);
                    length++;
                    length--;
                }
            }
        }

        public void g(byte[] bArr, int i, int i2) {
            if (c0() < i2) {
                a0(i2);
            }
            this.h -= (long) i2;
            this.e.position(W() + 1);
            this.e.put(bArr, i, i2);
        }

        public void h(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (c0() < remaining) {
                this.d += remaining;
                this.c.addFirst(AllocatedBuffer.i(byteBuffer));
                Z();
                return;
            }
            this.h -= (long) remaining;
            this.e.position(W() + 1);
            this.e.put(byteBuffer);
        }

        public void i(byte[] bArr, int i, int i2) {
            if (c0() < i2) {
                this.d += i2;
                this.c.addFirst(AllocatedBuffer.k(bArr, i, i2));
                Z();
                return;
            }
            this.h -= (long) i2;
            this.e.position(W() + 1);
            this.e.put(bArr, i, i2);
        }

        public int l() {
            return this.d + X();
        }

        public void q(int i) {
            if (c0() < i) {
                a0(i);
            }
        }

        public void r(boolean z) {
            d0(z ? (byte) 1 : 0);
        }

        public void w(int i) {
            long j = this.h;
            this.h = j - 1;
            UnsafeUtil.N(j, (byte) ((i >> 24) & 255));
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) ((i >> 16) & 255));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) ((i >> 8) & 255));
            long j4 = this.h;
            this.h = j4 - 1;
            UnsafeUtil.N(j4, (byte) (i & 255));
        }

        public void writeBool(int i, boolean z) {
            q(6);
            d0(z ? (byte) 1 : 0);
            P(i, 0);
        }

        public void writeEndGroup(int i) {
            P(i, 4);
        }

        public void writeFixed32(int i, int i2) {
            q(9);
            w(i2);
            P(i, 5);
        }

        public void writeFixed64(int i, long j) {
            q(13);
            z(j);
            P(i, 1);
        }

        public void writeInt32(int i, int i2) {
            q(15);
            E(i2);
            P(i, 0);
        }

        public void writeMessage(int i, Object obj) {
            int l = l();
            Protobuf.a().f(obj, this);
            q(10);
            U(l() - l);
            P(i, 2);
        }

        public void writeSInt32(int i, int i2) {
            q(10);
            J(i2);
            P(i, 0);
        }

        public void writeSInt64(int i, long j) {
            q(15);
            M(j);
            P(i, 0);
        }

        public void writeStartGroup(int i) {
            P(i, 3);
        }

        public void writeString(int i, String str) {
            int l = l();
            e0(str);
            q(10);
            U(l() - l);
            P(i, 2);
        }

        public void writeUInt32(int i, int i2) {
            q(10);
            U(i2);
            P(i, 0);
        }

        public void writeUInt64(int i, long j) {
            q(15);
            V(j);
            P(i, 0);
        }

        public void z(long j) {
            long j2 = this.h;
            this.h = j2 - 1;
            UnsafeUtil.N(j2, (byte) (((int) (j >> 56)) & 255));
            long j3 = this.h;
            this.h = j3 - 1;
            UnsafeUtil.N(j3, (byte) (((int) (j >> 48)) & 255));
            long j4 = this.h;
            this.h = j4 - 1;
            UnsafeUtil.N(j4, (byte) (((int) (j >> 40)) & 255));
            long j5 = this.h;
            this.h = j5 - 1;
            UnsafeUtil.N(j5, (byte) (((int) (j >> 32)) & 255));
            long j6 = this.h;
            this.h = j6 - 1;
            UnsafeUtil.N(j6, (byte) (((int) (j >> 24)) & 255));
            long j7 = this.h;
            this.h = j7 - 1;
            UnsafeUtil.N(j7, (byte) (((int) (j >> 16)) & 255));
            long j8 = this.h;
            this.h = j8 - 1;
            UnsafeUtil.N(j8, (byte) (((int) (j >> 8)) & 255));
            long j9 = this.h;
            this.h = j9 - 1;
            UnsafeUtil.N(j9, (byte) (((int) j) & 255));
        }
    }

    public static final class UnsafeHeapWriter extends BinaryWriter {
        public AllocatedBuffer e;
        public byte[] f;
        public long g;
        public long h;
        public long i;
        public long j;
        public long k;

        private void Z() {
            b0(o());
        }

        private void a0(int i2) {
            b0(p(i2));
        }

        private void b0(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.c()) {
                Y();
                this.c.addFirst(allocatedBuffer);
                this.e = allocatedBuffer;
                this.f = allocatedBuffer.a();
                int b = allocatedBuffer.b();
                this.h = (long) (allocatedBuffer.e() + b);
                long g2 = (long) (b + allocatedBuffer.g());
                this.g = g2;
                this.i = g2 - 1;
                long j2 = this.h - 1;
                this.j = j2;
                this.k = j2;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        private void f0(int i2) {
            byte[] bArr = this.f;
            long j2 = this.k;
            this.k = j2 - 1;
            UnsafeUtil.O(bArr, j2, (byte) (i2 >>> 28));
            byte[] bArr2 = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr2, j3, (byte) (((i2 >>> 21) & 127) | 128));
            byte[] bArr3 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr3, j4, (byte) (((i2 >>> 14) & 127) | 128));
            byte[] bArr4 = this.f;
            long j5 = this.k;
            this.k = j5 - 1;
            UnsafeUtil.O(bArr4, j5, (byte) (((i2 >>> 7) & 127) | 128));
            byte[] bArr5 = this.f;
            long j6 = this.k;
            this.k = j6 - 1;
            UnsafeUtil.O(bArr5, j6, (byte) ((i2 & 127) | 128));
        }

        private void g0(int i2) {
            byte[] bArr = this.f;
            long j2 = this.k;
            this.k = j2 - 1;
            UnsafeUtil.O(bArr, j2, (byte) (i2 >>> 21));
            byte[] bArr2 = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr2, j3, (byte) (((i2 >>> 14) & 127) | 128));
            byte[] bArr3 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr3, j4, (byte) (((i2 >>> 7) & 127) | 128));
            byte[] bArr4 = this.f;
            long j5 = this.k;
            this.k = j5 - 1;
            UnsafeUtil.O(bArr4, j5, (byte) ((i2 & 127) | 128));
        }

        private void h0(int i2) {
            byte[] bArr = this.f;
            long j2 = this.k;
            this.k = j2 - 1;
            UnsafeUtil.O(bArr, j2, (byte) i2);
        }

        private void i0(int i2) {
            byte[] bArr = this.f;
            long j2 = this.k;
            this.k = j2 - 1;
            UnsafeUtil.O(bArr, j2, (byte) (i2 >>> 14));
            byte[] bArr2 = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr2, j3, (byte) (((i2 >>> 7) & 127) | 128));
            byte[] bArr3 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr3, j4, (byte) ((i2 & 127) | 128));
        }

        private void j0(int i2) {
            byte[] bArr = this.f;
            long j2 = this.k;
            this.k = j2 - 1;
            UnsafeUtil.O(bArr, j2, (byte) (i2 >>> 7));
            byte[] bArr2 = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr2, j3, (byte) ((i2 & 127) | 128));
        }

        private void k0(long j2) {
            byte[] bArr = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr, j3, (byte) ((int) (j2 >>> 49)));
            byte[] bArr2 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr2, j4, (byte) ((int) (((j2 >>> 42) & 127) | 128)));
            byte[] bArr3 = this.f;
            long j5 = this.k;
            this.k = j5 - 1;
            UnsafeUtil.O(bArr3, j5, (byte) ((int) (((j2 >>> 35) & 127) | 128)));
            byte[] bArr4 = this.f;
            long j6 = this.k;
            this.k = j6 - 1;
            UnsafeUtil.O(bArr4, j6, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            byte[] bArr5 = this.f;
            long j7 = this.k;
            this.k = j7 - 1;
            UnsafeUtil.O(bArr5, j7, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            byte[] bArr6 = this.f;
            long j8 = this.k;
            this.k = j8 - 1;
            UnsafeUtil.O(bArr6, j8, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr7 = this.f;
            long j9 = this.k;
            this.k = j9 - 1;
            UnsafeUtil.O(bArr7, j9, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr8 = this.f;
            long j10 = this.k;
            this.k = j10 - 1;
            UnsafeUtil.O(bArr8, j10, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void l0(long j2) {
            byte[] bArr = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr, j3, (byte) ((int) (j2 >>> 28)));
            byte[] bArr2 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr2, j4, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            byte[] bArr3 = this.f;
            long j5 = this.k;
            this.k = j5 - 1;
            UnsafeUtil.O(bArr3, j5, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr4 = this.f;
            long j6 = this.k;
            this.k = j6 - 1;
            UnsafeUtil.O(bArr4, j6, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr5 = this.f;
            long j7 = this.k;
            this.k = j7 - 1;
            UnsafeUtil.O(bArr5, j7, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void m0(long j2) {
            byte[] bArr = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr, j3, (byte) ((int) (j2 >>> 21)));
            byte[] bArr2 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr2, j4, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr3 = this.f;
            long j5 = this.k;
            this.k = j5 - 1;
            UnsafeUtil.O(bArr3, j5, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr4 = this.f;
            long j6 = this.k;
            this.k = j6 - 1;
            UnsafeUtil.O(bArr4, j6, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void n0(long j2) {
            byte[] bArr = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr, j3, (byte) ((int) (j2 >>> 56)));
            byte[] bArr2 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr2, j4, (byte) ((int) (((j2 >>> 49) & 127) | 128)));
            byte[] bArr3 = this.f;
            long j5 = this.k;
            this.k = j5 - 1;
            UnsafeUtil.O(bArr3, j5, (byte) ((int) (((j2 >>> 42) & 127) | 128)));
            byte[] bArr4 = this.f;
            long j6 = this.k;
            this.k = j6 - 1;
            UnsafeUtil.O(bArr4, j6, (byte) ((int) (((j2 >>> 35) & 127) | 128)));
            byte[] bArr5 = this.f;
            long j7 = this.k;
            this.k = j7 - 1;
            UnsafeUtil.O(bArr5, j7, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            byte[] bArr6 = this.f;
            long j8 = this.k;
            this.k = j8 - 1;
            UnsafeUtil.O(bArr6, j8, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            byte[] bArr7 = this.f;
            long j9 = this.k;
            this.k = j9 - 1;
            UnsafeUtil.O(bArr7, j9, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr8 = this.f;
            long j10 = this.k;
            this.k = j10 - 1;
            UnsafeUtil.O(bArr8, j10, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr9 = this.f;
            long j11 = this.k;
            this.k = j11 - 1;
            UnsafeUtil.O(bArr9, j11, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void o0(long j2) {
            byte[] bArr = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr, j3, (byte) ((int) j2));
        }

        private void p0(long j2) {
            byte[] bArr = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr, j3, (byte) ((int) (j2 >>> 42)));
            byte[] bArr2 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr2, j4, (byte) ((int) (((j2 >>> 35) & 127) | 128)));
            byte[] bArr3 = this.f;
            long j5 = this.k;
            this.k = j5 - 1;
            UnsafeUtil.O(bArr3, j5, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            byte[] bArr4 = this.f;
            long j6 = this.k;
            this.k = j6 - 1;
            UnsafeUtil.O(bArr4, j6, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            byte[] bArr5 = this.f;
            long j7 = this.k;
            this.k = j7 - 1;
            UnsafeUtil.O(bArr5, j7, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr6 = this.f;
            long j8 = this.k;
            this.k = j8 - 1;
            UnsafeUtil.O(bArr6, j8, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr7 = this.f;
            long j9 = this.k;
            this.k = j9 - 1;
            UnsafeUtil.O(bArr7, j9, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void q0(long j2) {
            byte[] bArr = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr, j3, (byte) ((int) (j2 >>> 35)));
            byte[] bArr2 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr2, j4, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            byte[] bArr3 = this.f;
            long j5 = this.k;
            this.k = j5 - 1;
            UnsafeUtil.O(bArr3, j5, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            byte[] bArr4 = this.f;
            long j6 = this.k;
            this.k = j6 - 1;
            UnsafeUtil.O(bArr4, j6, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr5 = this.f;
            long j7 = this.k;
            this.k = j7 - 1;
            UnsafeUtil.O(bArr5, j7, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr6 = this.f;
            long j8 = this.k;
            this.k = j8 - 1;
            UnsafeUtil.O(bArr6, j8, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void r0(long j2) {
            byte[] bArr = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr, j3, (byte) ((int) (j2 >>> 63)));
            byte[] bArr2 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr2, j4, (byte) ((int) (((j2 >>> 56) & 127) | 128)));
            byte[] bArr3 = this.f;
            long j5 = this.k;
            this.k = j5 - 1;
            UnsafeUtil.O(bArr3, j5, (byte) ((int) (((j2 >>> 49) & 127) | 128)));
            byte[] bArr4 = this.f;
            long j6 = this.k;
            this.k = j6 - 1;
            UnsafeUtil.O(bArr4, j6, (byte) ((int) (((j2 >>> 42) & 127) | 128)));
            byte[] bArr5 = this.f;
            long j7 = this.k;
            this.k = j7 - 1;
            UnsafeUtil.O(bArr5, j7, (byte) ((int) (((j2 >>> 35) & 127) | 128)));
            byte[] bArr6 = this.f;
            long j8 = this.k;
            this.k = j8 - 1;
            UnsafeUtil.O(bArr6, j8, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            byte[] bArr7 = this.f;
            long j9 = this.k;
            this.k = j9 - 1;
            UnsafeUtil.O(bArr7, j9, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            byte[] bArr8 = this.f;
            long j10 = this.k;
            this.k = j10 - 1;
            UnsafeUtil.O(bArr8, j10, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr9 = this.f;
            long j11 = this.k;
            this.k = j11 - 1;
            UnsafeUtil.O(bArr9, j11, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr10 = this.f;
            long j12 = this.k;
            this.k = j12 - 1;
            UnsafeUtil.O(bArr10, j12, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void s0(long j2) {
            byte[] bArr = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr, j3, (byte) (((int) j2) >>> 14));
            byte[] bArr2 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr2, j4, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr3 = this.f;
            long j5 = this.k;
            this.k = j5 - 1;
            UnsafeUtil.O(bArr3, j5, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void t0(long j2) {
            byte[] bArr = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr, j3, (byte) ((int) (j2 >>> 7)));
            byte[] bArr2 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr2, j4, (byte) ((((int) j2) & 127) | 128));
        }

        public void E(int i2) {
            if (i2 >= 0) {
                U(i2);
            } else {
                V((long) i2);
            }
        }

        public void J(int i2) {
            U(CodedOutputStream.i0(i2));
        }

        public void M(long j2) {
            V(CodedOutputStream.j0(j2));
        }

        public void P(int i2, int i3) {
            U(WireFormat.c(i2, i3));
        }

        public void U(int i2) {
            if ((i2 & -128) == 0) {
                h0(i2);
            } else if ((i2 & -16384) == 0) {
                j0(i2);
            } else if ((-2097152 & i2) == 0) {
                i0(i2);
            } else if ((-268435456 & i2) == 0) {
                g0(i2);
            } else {
                f0(i2);
            }
        }

        public void V(long j2) {
            switch (BinaryWriter.k(j2)) {
                case 1:
                    o0(j2);
                    return;
                case 2:
                    t0(j2);
                    return;
                case 3:
                    s0(j2);
                    return;
                case 4:
                    m0(j2);
                    return;
                case 5:
                    l0(j2);
                    return;
                case 6:
                    q0(j2);
                    return;
                case 7:
                    p0(j2);
                    return;
                case 8:
                    k0(j2);
                    return;
                case 9:
                    n0(j2);
                    return;
                case 10:
                    r0(j2);
                    return;
                default:
                    return;
            }
        }

        public final int W() {
            return (int) this.k;
        }

        public int X() {
            return (int) (this.j - this.k);
        }

        public void Y() {
            if (this.e != null) {
                this.d += X();
                this.e.h((W() - this.e.b()) + 1);
                this.e = null;
                this.k = 0;
                this.j = 0;
            }
        }

        public void a(int i2, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                q(10);
                U(byteString.size());
                P(i2, 2);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        public void b(int i2, Object obj, Schema schema) {
            int l = l();
            schema.a(obj, this);
            q(10);
            U(l() - l);
            P(i2, 2);
        }

        public int c0() {
            return (int) (this.k - this.i);
        }

        public void d0(byte b) {
            byte[] bArr = this.f;
            long j2 = this.k;
            this.k = j2 - 1;
            UnsafeUtil.O(bArr, j2, b);
        }

        public void e(int i2, Object obj, Schema schema) {
            P(i2, 4);
            schema.a(obj, this);
            P(i2, 3);
        }

        public void e0(String str) {
            char charAt;
            q(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length >= 0 && (charAt = str.charAt(length)) < 128) {
                    byte[] bArr = this.f;
                    long j2 = this.k;
                    this.k = j2 - 1;
                    UnsafeUtil.O(bArr, j2, (byte) charAt);
                }
            }
            if (length != -1) {
                while (length >= 0) {
                    char charAt2 = str.charAt(length);
                    if (charAt2 < 128) {
                        long j3 = this.k;
                        if (j3 > this.i) {
                            byte[] bArr2 = this.f;
                            this.k = j3 - 1;
                            UnsafeUtil.O(bArr2, j3, (byte) charAt2);
                            length--;
                        }
                    }
                    if (charAt2 < 2048) {
                        long j4 = this.k;
                        if (j4 > this.g) {
                            byte[] bArr3 = this.f;
                            this.k = j4 - 1;
                            UnsafeUtil.O(bArr3, j4, (byte) ((charAt2 & '?') | 128));
                            byte[] bArr4 = this.f;
                            long j5 = this.k;
                            this.k = j5 - 1;
                            UnsafeUtil.O(bArr4, j5, (byte) ((charAt2 >>> 6) | OdnpConfigStatic.UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES));
                            length--;
                        }
                    }
                    if (charAt2 < 55296 || 57343 < charAt2) {
                        long j6 = this.k;
                        if (j6 > this.g + 1) {
                            byte[] bArr5 = this.f;
                            this.k = j6 - 1;
                            UnsafeUtil.O(bArr5, j6, (byte) ((charAt2 & '?') | 128));
                            byte[] bArr6 = this.f;
                            long j7 = this.k;
                            this.k = j7 - 1;
                            UnsafeUtil.O(bArr6, j7, (byte) (((charAt2 >>> 6) & 63) | 128));
                            byte[] bArr7 = this.f;
                            long j8 = this.k;
                            this.k = j8 - 1;
                            UnsafeUtil.O(bArr7, j8, (byte) ((charAt2 >>> 12) | OdnpConfigStatic.UPLOAD_LOW_PRIORITY_DURATION_MINUTES));
                            length--;
                        }
                    }
                    if (this.k > this.g + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                byte[] bArr8 = this.f;
                                long j9 = this.k;
                                this.k = j9 - 1;
                                UnsafeUtil.O(bArr8, j9, (byte) ((codePoint & 63) | 128));
                                byte[] bArr9 = this.f;
                                long j10 = this.k;
                                this.k = j10 - 1;
                                UnsafeUtil.O(bArr9, j10, (byte) (((codePoint >>> 6) & 63) | 128));
                                byte[] bArr10 = this.f;
                                long j11 = this.k;
                                this.k = j11 - 1;
                                UnsafeUtil.O(bArr10, j11, (byte) (((codePoint >>> 12) & 63) | 128));
                                byte[] bArr11 = this.f;
                                long j12 = this.k;
                                this.k = j12 - 1;
                                UnsafeUtil.O(bArr11, j12, (byte) ((codePoint >>> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    q(length);
                    length++;
                    length--;
                }
            }
        }

        public void g(byte[] bArr, int i2, int i3) {
            if (i2 < 0 || i2 + i3 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
            }
            q(i3);
            this.k -= (long) i3;
            System.arraycopy(bArr, i2, this.f, W() + 1, i3);
        }

        public void h(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (c0() < remaining) {
                this.d += remaining;
                this.c.addFirst(AllocatedBuffer.i(byteBuffer));
                Z();
            }
            this.k -= (long) remaining;
            byteBuffer.get(this.f, W() + 1, remaining);
        }

        public void i(byte[] bArr, int i2, int i3) {
            if (i2 < 0 || i2 + i3 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
            } else if (c0() < i3) {
                this.d += i3;
                this.c.addFirst(AllocatedBuffer.k(bArr, i2, i3));
                Z();
            } else {
                this.k -= (long) i3;
                System.arraycopy(bArr, i2, this.f, W() + 1, i3);
            }
        }

        public int l() {
            return this.d + X();
        }

        public void q(int i2) {
            if (c0() < i2) {
                a0(i2);
            }
        }

        public void r(boolean z) {
            d0(z ? (byte) 1 : 0);
        }

        public void w(int i2) {
            byte[] bArr = this.f;
            long j2 = this.k;
            this.k = j2 - 1;
            UnsafeUtil.O(bArr, j2, (byte) ((i2 >> 24) & 255));
            byte[] bArr2 = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr2, j3, (byte) ((i2 >> 16) & 255));
            byte[] bArr3 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr3, j4, (byte) ((i2 >> 8) & 255));
            byte[] bArr4 = this.f;
            long j5 = this.k;
            this.k = j5 - 1;
            UnsafeUtil.O(bArr4, j5, (byte) (i2 & 255));
        }

        public void writeBool(int i2, boolean z) {
            q(6);
            d0(z ? (byte) 1 : 0);
            P(i2, 0);
        }

        public void writeEndGroup(int i2) {
            P(i2, 4);
        }

        public void writeFixed32(int i2, int i3) {
            q(9);
            w(i3);
            P(i2, 5);
        }

        public void writeFixed64(int i2, long j2) {
            q(13);
            z(j2);
            P(i2, 1);
        }

        public void writeInt32(int i2, int i3) {
            q(15);
            E(i3);
            P(i2, 0);
        }

        public void writeMessage(int i2, Object obj) {
            int l = l();
            Protobuf.a().f(obj, this);
            q(10);
            U(l() - l);
            P(i2, 2);
        }

        public void writeSInt32(int i2, int i3) {
            q(10);
            J(i3);
            P(i2, 0);
        }

        public void writeSInt64(int i2, long j2) {
            q(15);
            M(j2);
            P(i2, 0);
        }

        public void writeStartGroup(int i2) {
            P(i2, 3);
        }

        public void writeString(int i2, String str) {
            int l = l();
            e0(str);
            q(10);
            U(l() - l);
            P(i2, 2);
        }

        public void writeUInt32(int i2, int i3) {
            q(10);
            U(i3);
            P(i2, 0);
        }

        public void writeUInt64(int i2, long j2) {
            q(15);
            V(j2);
            P(i2, 0);
        }

        public void z(long j2) {
            byte[] bArr = this.f;
            long j3 = this.k;
            this.k = j3 - 1;
            UnsafeUtil.O(bArr, j3, (byte) (((int) (j2 >> 56)) & 255));
            byte[] bArr2 = this.f;
            long j4 = this.k;
            this.k = j4 - 1;
            UnsafeUtil.O(bArr2, j4, (byte) (((int) (j2 >> 48)) & 255));
            byte[] bArr3 = this.f;
            long j5 = this.k;
            this.k = j5 - 1;
            UnsafeUtil.O(bArr3, j5, (byte) (((int) (j2 >> 40)) & 255));
            byte[] bArr4 = this.f;
            long j6 = this.k;
            this.k = j6 - 1;
            UnsafeUtil.O(bArr4, j6, (byte) (((int) (j2 >> 32)) & 255));
            byte[] bArr5 = this.f;
            long j7 = this.k;
            this.k = j7 - 1;
            UnsafeUtil.O(bArr5, j7, (byte) (((int) (j2 >> 24)) & 255));
            byte[] bArr6 = this.f;
            long j8 = this.k;
            this.k = j8 - 1;
            UnsafeUtil.O(bArr6, j8, (byte) (((int) (j2 >> 16)) & 255));
            byte[] bArr7 = this.f;
            long j9 = this.k;
            this.k = j9 - 1;
            UnsafeUtil.O(bArr7, j9, (byte) (((int) (j2 >> 8)) & 255));
            byte[] bArr8 = this.f;
            long j10 = this.k;
            this.k = j10 - 1;
            UnsafeUtil.O(bArr8, j10, (byte) (((int) j2) & 255));
        }
    }

    public static final void I(Writer writer, int i, WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.f1056a[fieldType.ordinal()]) {
            case 1:
                writer.writeBool(i, ((Boolean) obj).booleanValue());
                return;
            case 2:
                writer.writeFixed32(i, ((Integer) obj).intValue());
                return;
            case 3:
                writer.writeFixed64(i, ((Long) obj).longValue());
                return;
            case 4:
                writer.writeInt32(i, ((Integer) obj).intValue());
                return;
            case 5:
                writer.writeInt64(i, ((Long) obj).longValue());
                return;
            case 6:
                writer.writeSFixed32(i, ((Integer) obj).intValue());
                return;
            case 7:
                writer.writeSFixed64(i, ((Long) obj).longValue());
                return;
            case 8:
                writer.writeSInt32(i, ((Integer) obj).intValue());
                return;
            case 9:
                writer.writeSInt64(i, ((Long) obj).longValue());
                return;
            case 10:
                writer.writeString(i, (String) obj);
                return;
            case 11:
                writer.writeUInt32(i, ((Integer) obj).intValue());
                return;
            case 12:
                writer.writeUInt64(i, ((Long) obj).longValue());
                return;
            case 13:
                writer.writeFloat(i, ((Float) obj).floatValue());
                return;
            case 14:
                writer.writeDouble(i, ((Double) obj).doubleValue());
                return;
            case 15:
                writer.writeMessage(i, obj);
                return;
            case 16:
                writer.a(i, (ByteString) obj);
                return;
            case 17:
                if (obj instanceof Internal.EnumLite) {
                    writer.writeEnum(i, ((Internal.EnumLite) obj).getNumber());
                    return;
                } else if (obj instanceof Integer) {
                    writer.writeEnum(i, ((Integer) obj).intValue());
                    return;
                } else {
                    throw new IllegalArgumentException("Unexpected type for enum in map.");
                }
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
        }
    }

    public static byte k(long j) {
        byte b2;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            b2 = (byte) 6;
            j >>>= 28;
        } else {
            b2 = 2;
        }
        if ((-2097152 & j) != 0) {
            b2 = (byte) (b2 + 2);
            j >>>= 14;
        }
        return (j & -16384) != 0 ? (byte) (b2 + 1) : b2;
    }

    public final void A(int i, LongArrayList longArrayList, boolean z) {
        if (z) {
            q((longArrayList.size() * 8) + 10);
            int l = l();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                z(longArrayList.getLong(size));
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i, longArrayList.getLong(size2));
        }
    }

    public final void B(int i, List list, boolean z) {
        if (z) {
            q((list.size() * 8) + 10);
            int l = l();
            for (int size = list.size() - 1; size >= 0; size--) {
                z(((Long) list.get(size)).longValue());
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i, ((Long) list.get(size2)).longValue());
        }
    }

    public final void C(int i, FloatArrayList floatArrayList, boolean z) {
        if (z) {
            q((floatArrayList.size() * 4) + 10);
            int l = l();
            for (int size = floatArrayList.size() - 1; size >= 0; size--) {
                w(Float.floatToRawIntBits(floatArrayList.getFloat(size)));
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = floatArrayList.size() - 1; size2 >= 0; size2--) {
            writeFloat(i, floatArrayList.getFloat(size2));
        }
    }

    public final void D(int i, List list, boolean z) {
        if (z) {
            q((list.size() * 4) + 10);
            int l = l();
            for (int size = list.size() - 1; size >= 0; size--) {
                w(Float.floatToRawIntBits(((Float) list.get(size)).floatValue()));
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFloat(i, ((Float) list.get(size2)).floatValue());
        }
    }

    public abstract void E(int i);

    public final void F(int i, IntArrayList intArrayList, boolean z) {
        if (z) {
            q((intArrayList.size() * 10) + 10);
            int l = l();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                E(intArrayList.getInt(size));
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeInt32(i, intArrayList.getInt(size2));
        }
    }

    public final void G(int i, List list, boolean z) {
        if (z) {
            q((list.size() * 10) + 10);
            int l = l();
            for (int size = list.size() - 1; size >= 0; size--) {
                E(((Integer) list.get(size)).intValue());
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeInt32(i, ((Integer) list.get(size2)).intValue());
        }
    }

    public final void H(int i, Object obj) {
        if (obj instanceof String) {
            writeString(i, (String) obj);
        } else {
            a(i, (ByteString) obj);
        }
    }

    public abstract void J(int i);

    public final void K(int i, IntArrayList intArrayList, boolean z) {
        if (z) {
            q((intArrayList.size() * 5) + 10);
            int l = l();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                J(intArrayList.getInt(size));
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i, intArrayList.getInt(size2));
        }
    }

    public final void L(int i, List list, boolean z) {
        if (z) {
            q((list.size() * 5) + 10);
            int l = l();
            for (int size = list.size() - 1; size >= 0; size--) {
                J(((Integer) list.get(size)).intValue());
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i, ((Integer) list.get(size2)).intValue());
        }
    }

    public abstract void M(long j);

    public final void N(int i, LongArrayList longArrayList, boolean z) {
        if (z) {
            q((longArrayList.size() * 10) + 10);
            int l = l();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                M(longArrayList.getLong(size));
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i, longArrayList.getLong(size2));
        }
    }

    public final void O(int i, List list, boolean z) {
        if (z) {
            q((list.size() * 10) + 10);
            int l = l();
            for (int size = list.size() - 1; size >= 0; size--) {
                M(((Long) list.get(size)).longValue());
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i, ((Long) list.get(size2)).longValue());
        }
    }

    public abstract void P(int i, int i2);

    public final void Q(int i, IntArrayList intArrayList, boolean z) {
        if (z) {
            q((intArrayList.size() * 5) + 10);
            int l = l();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                U(intArrayList.getInt(size));
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i, intArrayList.getInt(size2));
        }
    }

    public final void R(int i, List list, boolean z) {
        if (z) {
            q((list.size() * 5) + 10);
            int l = l();
            for (int size = list.size() - 1; size >= 0; size--) {
                U(((Integer) list.get(size)).intValue());
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i, ((Integer) list.get(size2)).intValue());
        }
    }

    public final void S(int i, LongArrayList longArrayList, boolean z) {
        if (z) {
            q((longArrayList.size() * 10) + 10);
            int l = l();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                V(longArrayList.getLong(size));
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i, longArrayList.getLong(size2));
        }
    }

    public final void T(int i, List list, boolean z) {
        if (z) {
            q((list.size() * 10) + 10);
            int l = l();
            for (int size = list.size() - 1; size >= 0; size--) {
                V(((Long) list.get(size)).longValue());
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i, ((Long) list.get(size2)).longValue());
        }
    }

    public abstract void U(int i);

    public abstract void V(long j);

    public void c(int i, MapEntryLite.Metadata metadata, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            int l = l();
            I(this, 2, metadata.c, entry.getValue());
            I(this, 1, metadata.f1117a, entry.getKey());
            U(l() - l);
            P(i, 2);
        }
    }

    public final void d(int i, List list, Schema schema) {
        for (int size = list.size() - 1; size >= 0; size--) {
            e(i, list.get(size), schema);
        }
    }

    public final void f(int i, List list, Schema schema) {
        for (int size = list.size() - 1; size >= 0; size--) {
            b(i, list.get(size), schema);
        }
    }

    public final Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.DESCENDING;
    }

    public abstract int l();

    public final AllocatedBuffer m() {
        return this.f1055a.a(this.b);
    }

    public final AllocatedBuffer n(int i) {
        return this.f1055a.a(Math.max(i, this.b));
    }

    public final AllocatedBuffer o() {
        return this.f1055a.b(this.b);
    }

    public final AllocatedBuffer p(int i) {
        return this.f1055a.b(Math.max(i, this.b));
    }

    public abstract void q(int i);

    public abstract void r(boolean z);

    public final void s(int i, BooleanArrayList booleanArrayList, boolean z) {
        if (z) {
            q(booleanArrayList.size() + 10);
            int l = l();
            for (int size = booleanArrayList.size() - 1; size >= 0; size--) {
                r(booleanArrayList.getBoolean(size));
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = booleanArrayList.size() - 1; size2 >= 0; size2--) {
            writeBool(i, booleanArrayList.getBoolean(size2));
        }
    }

    public final void t(int i, List list, boolean z) {
        if (z) {
            q(list.size() + 10);
            int l = l();
            for (int size = list.size() - 1; size >= 0; size--) {
                r(((Boolean) list.get(size)).booleanValue());
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeBool(i, ((Boolean) list.get(size2)).booleanValue());
        }
    }

    public final void u(int i, DoubleArrayList doubleArrayList, boolean z) {
        if (z) {
            q((doubleArrayList.size() * 8) + 10);
            int l = l();
            for (int size = doubleArrayList.size() - 1; size >= 0; size--) {
                z(Double.doubleToRawLongBits(doubleArrayList.getDouble(size)));
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = doubleArrayList.size() - 1; size2 >= 0; size2--) {
            writeDouble(i, doubleArrayList.getDouble(size2));
        }
    }

    public final void v(int i, List list, boolean z) {
        if (z) {
            q((list.size() * 8) + 10);
            int l = l();
            for (int size = list.size() - 1; size >= 0; size--) {
                z(Double.doubleToRawLongBits(((Double) list.get(size)).doubleValue()));
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeDouble(i, ((Double) list.get(size2)).doubleValue());
        }
    }

    public abstract void w(int i);

    public final void writeBoolList(int i, List list, boolean z) {
        if (list instanceof BooleanArrayList) {
            s(i, (BooleanArrayList) list, z);
        } else {
            t(i, list, z);
        }
    }

    public final void writeBytesList(int i, List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a(i, (ByteString) list.get(size));
        }
    }

    public final void writeDouble(int i, double d2) {
        writeFixed64(i, Double.doubleToRawLongBits(d2));
    }

    public final void writeDoubleList(int i, List list, boolean z) {
        if (list instanceof DoubleArrayList) {
            u(i, (DoubleArrayList) list, z);
        } else {
            v(i, list, z);
        }
    }

    public final void writeEnum(int i, int i2) {
        writeInt32(i, i2);
    }

    public final void writeEnumList(int i, List list, boolean z) {
        writeInt32List(i, list, z);
    }

    public final void writeFixed32List(int i, List list, boolean z) {
        if (list instanceof IntArrayList) {
            x(i, (IntArrayList) list, z);
        } else {
            y(i, list, z);
        }
    }

    public final void writeFixed64List(int i, List list, boolean z) {
        if (list instanceof LongArrayList) {
            A(i, (LongArrayList) list, z);
        } else {
            B(i, list, z);
        }
    }

    public final void writeFloat(int i, float f) {
        writeFixed32(i, Float.floatToRawIntBits(f));
    }

    public final void writeFloatList(int i, List list, boolean z) {
        if (list instanceof FloatArrayList) {
            C(i, (FloatArrayList) list, z);
        } else {
            D(i, list, z);
        }
    }

    public final void writeInt32List(int i, List list, boolean z) {
        if (list instanceof IntArrayList) {
            F(i, (IntArrayList) list, z);
        } else {
            G(i, list, z);
        }
    }

    public final void writeInt64(int i, long j) {
        writeUInt64(i, j);
    }

    public final void writeInt64List(int i, List list, boolean z) {
        writeUInt64List(i, list, z);
    }

    public final void writeMessageSetItem(int i, Object obj) {
        P(1, 4);
        if (obj instanceof ByteString) {
            a(3, (ByteString) obj);
        } else {
            writeMessage(3, obj);
        }
        writeUInt32(2, i);
        P(1, 3);
    }

    public final void writeSFixed32(int i, int i2) {
        writeFixed32(i, i2);
    }

    public final void writeSFixed32List(int i, List list, boolean z) {
        writeFixed32List(i, list, z);
    }

    public final void writeSFixed64(int i, long j) {
        writeFixed64(i, j);
    }

    public final void writeSFixed64List(int i, List list, boolean z) {
        writeFixed64List(i, list, z);
    }

    public final void writeSInt32List(int i, List list, boolean z) {
        if (list instanceof IntArrayList) {
            K(i, (IntArrayList) list, z);
        } else {
            L(i, list, z);
        }
    }

    public final void writeSInt64List(int i, List list, boolean z) {
        if (list instanceof LongArrayList) {
            N(i, (LongArrayList) list, z);
        } else {
            O(i, list, z);
        }
    }

    public final void writeStringList(int i, List list) {
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            for (int size = list.size() - 1; size >= 0; size--) {
                H(i, lazyStringList.getRaw(size));
            }
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeString(i, (String) list.get(size2));
        }
    }

    public final void writeUInt32List(int i, List list, boolean z) {
        if (list instanceof IntArrayList) {
            Q(i, (IntArrayList) list, z);
        } else {
            R(i, list, z);
        }
    }

    public final void writeUInt64List(int i, List list, boolean z) {
        if (list instanceof LongArrayList) {
            S(i, (LongArrayList) list, z);
        } else {
            T(i, list, z);
        }
    }

    public final void x(int i, IntArrayList intArrayList, boolean z) {
        if (z) {
            q((intArrayList.size() * 4) + 10);
            int l = l();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                w(intArrayList.getInt(size));
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i, intArrayList.getInt(size2));
        }
    }

    public final void y(int i, List list, boolean z) {
        if (z) {
            q((list.size() * 4) + 10);
            int l = l();
            for (int size = list.size() - 1; size >= 0; size--) {
                w(((Integer) list.get(size)).intValue());
            }
            U(l() - l);
            P(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i, ((Integer) list.get(size2)).intValue());
        }
    }

    public abstract void z(long j);
}
