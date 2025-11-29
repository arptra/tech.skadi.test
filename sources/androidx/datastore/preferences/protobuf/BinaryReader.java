package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import java.nio.ByteBuffer;
import java.util.List;

abstract class BinaryReader implements Reader {

    /* renamed from: androidx.datastore.preferences.protobuf.BinaryReader$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1053a;

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
                f1053a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f1053a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryReader.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class SafeHeapReader extends BinaryReader {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f1054a;
        public final byte[] b;
        public int c;
        public final int d;
        public int e;
        public int f;
        public int g;

        public SafeHeapReader(ByteBuffer byteBuffer, boolean z) {
            super((AnonymousClass1) null);
            this.f1054a = z;
            this.b = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.c = arrayOffset;
            this.d = arrayOffset;
            this.e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        /* JADX WARNING: Removed duplicated region for block: B:1:0x000f A[LOOP:0: B:1:0x000f->B:4:0x001c, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void A() {
            /*
                r3 = this;
                int r0 = r3.g
                int r1 = r3.f
                int r1 = androidx.datastore.preferences.protobuf.WireFormat.a(r1)
                r2 = 4
                int r1 = androidx.datastore.preferences.protobuf.WireFormat.c(r1, r2)
                r3.g = r1
            L_0x000f:
                int r1 = r3.getFieldNumber()
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r2) goto L_0x001e
                boolean r1 = r3.skipField()
                if (r1 != 0) goto L_0x000f
            L_0x001e:
                int r1 = r3.f
                int r2 = r3.g
                if (r1 != r2) goto L_0x0027
                r3.g = r0
                return
            L_0x0027:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r3 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryReader.SafeHeapReader.A():void");
        }

        public final void B() {
            int i = this.e;
            int i2 = this.c;
            if (i - i2 >= 10) {
                byte[] bArr = this.b;
                int i3 = 0;
                while (i3 < 10) {
                    int i4 = i2 + 1;
                    if (bArr[i2] >= 0) {
                        this.c = i4;
                        return;
                    } else {
                        i3++;
                        i2 = i4;
                    }
                }
            }
            C();
        }

        public final void C() {
            int i = 0;
            while (i < 10) {
                if (j() < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void D(int i) {
            w(i);
            if ((i & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        public final void E(int i) {
            w(i);
            if ((i & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        public Object a(Schema schema, ExtensionRegistryLite extensionRegistryLite) {
            y(3);
            return l(schema, extensionRegistryLite);
        }

        public Object b(Class cls, ExtensionRegistryLite extensionRegistryLite) {
            y(2);
            return q(Protobuf.a().d(cls), extensionRegistryLite);
        }

        public Object c(Schema schema, ExtensionRegistryLite extensionRegistryLite) {
            y(2);
            return q(schema, extensionRegistryLite);
        }

        public void d(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
            int i;
            if (WireFormat.b(this.f) == 2) {
                int i2 = this.f;
                do {
                    list.add(q(schema, extensionRegistryLite));
                    if (!i()) {
                        i = this.c;
                    } else {
                        return;
                    }
                } while (t() == i2);
                this.c = i;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        public Object e(Class cls, ExtensionRegistryLite extensionRegistryLite) {
            y(3);
            return l(Protobuf.a().d(cls), extensionRegistryLite);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:20|21|(2:23|35)(3:30|24|25)) */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
            if (skipField() != false) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
            throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Unable to parse map entry.");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0050 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f(java.util.Map r8, androidx.datastore.preferences.protobuf.MapEntryLite.Metadata r9, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r10) {
            /*
                r7 = this;
                r0 = 2
                r7.y(r0)
                int r1 = r7.t()
                r7.w(r1)
                int r2 = r7.e
                int r3 = r7.c
                int r3 = r3 + r1
                r7.e = r3
                java.lang.Object r1 = r9.b     // Catch:{ all -> 0x0025 }
                java.lang.Object r3 = r9.d     // Catch:{ all -> 0x0025 }
            L_0x0016:
                int r4 = r7.getFieldNumber()     // Catch:{ all -> 0x0025 }
                r5 = 2147483647(0x7fffffff, float:NaN)
                if (r4 != r5) goto L_0x0027
                r8.put(r1, r3)     // Catch:{ all -> 0x0025 }
                r7.e = r2
                return
            L_0x0025:
                r8 = move-exception
                goto L_0x005d
            L_0x0027:
                r5 = 1
                java.lang.String r6 = "Unable to parse map entry."
                if (r4 == r5) goto L_0x0048
                if (r4 == r0) goto L_0x003b
                boolean r4 = r7.skipField()     // Catch:{ InvalidWireTypeException -> 0x0050 }
                if (r4 == 0) goto L_0x0035
                goto L_0x0016
            L_0x0035:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidWireTypeException -> 0x0050 }
                r4.<init>((java.lang.String) r6)     // Catch:{ InvalidWireTypeException -> 0x0050 }
                throw r4     // Catch:{ InvalidWireTypeException -> 0x0050 }
            L_0x003b:
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.c     // Catch:{ InvalidWireTypeException -> 0x0050 }
                java.lang.Object r5 = r9.d     // Catch:{ InvalidWireTypeException -> 0x0050 }
                java.lang.Class r5 = r5.getClass()     // Catch:{ InvalidWireTypeException -> 0x0050 }
                java.lang.Object r3 = r7.k(r4, r5, r10)     // Catch:{ InvalidWireTypeException -> 0x0050 }
                goto L_0x0016
            L_0x0048:
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f1117a     // Catch:{ InvalidWireTypeException -> 0x0050 }
                r5 = 0
                java.lang.Object r1 = r7.k(r4, r5, r5)     // Catch:{ InvalidWireTypeException -> 0x0050 }
                goto L_0x0016
            L_0x0050:
                boolean r4 = r7.skipField()     // Catch:{ all -> 0x0025 }
                if (r4 == 0) goto L_0x0057
                goto L_0x0016
            L_0x0057:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0025 }
                r8.<init>((java.lang.String) r6)     // Catch:{ all -> 0x0025 }
                throw r8     // Catch:{ all -> 0x0025 }
            L_0x005d:
                r7.e = r2
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryReader.SafeHeapReader.f(java.util.Map, androidx.datastore.preferences.protobuf.MapEntryLite$Metadata, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
        }

        public void g(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
            int i;
            if (WireFormat.b(this.f) == 3) {
                int i2 = this.f;
                do {
                    list.add(l(schema, extensionRegistryLite));
                    if (!i()) {
                        i = this.c;
                    } else {
                        return;
                    }
                } while (t() == i2);
                this.c = i;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        public int getFieldNumber() {
            if (i()) {
                return Integer.MAX_VALUE;
            }
            int t = t();
            this.f = t;
            if (t == this.g) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.a(t);
        }

        public int getTag() {
            return this.f;
        }

        public final boolean i() {
            return this.c == this.e;
        }

        public final byte j() {
            int i = this.c;
            if (i != this.e) {
                byte[] bArr = this.b;
                this.c = i + 1;
                return bArr[i];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final Object k(WireFormat.FieldType fieldType, Class cls, ExtensionRegistryLite extensionRegistryLite) {
            switch (AnonymousClass1.f1053a[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(readBool());
                case 2:
                    return readBytes();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(readEnum());
                case 5:
                    return Integer.valueOf(readFixed32());
                case 6:
                    return Long.valueOf(readFixed64());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(readInt32());
                case 9:
                    return Long.valueOf(readInt64());
                case 10:
                    return b(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(readSFixed32());
                case 12:
                    return Long.valueOf(readSFixed64());
                case 13:
                    return Integer.valueOf(readSInt32());
                case 14:
                    return Long.valueOf(readSInt64());
                case 15:
                    return readStringRequireUtf8();
                case 16:
                    return Integer.valueOf(readUInt32());
                case 17:
                    return Long.valueOf(readUInt64());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        public final Object l(Schema schema, ExtensionRegistryLite extensionRegistryLite) {
            int i = this.g;
            this.g = WireFormat.c(WireFormat.a(this.f), 4);
            try {
                Object newInstance = schema.newInstance();
                schema.b(newInstance, this, extensionRegistryLite);
                schema.makeImmutable(newInstance);
                if (this.f == this.g) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } finally {
                this.g = i;
            }
        }

        public final int m() {
            w(4);
            return n();
        }

        public final int n() {
            int i = this.c;
            byte[] bArr = this.b;
            this.c = i + 4;
            return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
        }

        public final long o() {
            w(8);
            return p();
        }

        public final long p() {
            int i = this.c;
            byte[] bArr = this.b;
            this.c = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        public final Object q(Schema schema, ExtensionRegistryLite extensionRegistryLite) {
            int t = t();
            w(t);
            int i = this.e;
            int i2 = this.c + t;
            this.e = i2;
            try {
                Object newInstance = schema.newInstance();
                schema.b(newInstance, this, extensionRegistryLite);
                schema.makeImmutable(newInstance);
                if (this.c == i2) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } finally {
                this.e = i;
            }
        }

        public String r(boolean z) {
            y(2);
            int t = t();
            if (t == 0) {
                return "";
            }
            w(t);
            if (z) {
                byte[] bArr = this.b;
                int i = this.c;
                if (!Utf8.u(bArr, i, i + t)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String str = new String(this.b, this.c, t, Internal.f1098a);
            this.c += t;
            return str;
        }

        public boolean readBool() {
            y(0);
            return t() != 0;
        }

        public void readBoolList(List list) {
            int i;
            int i2;
            if (list instanceof BooleanArrayList) {
                BooleanArrayList booleanArrayList = (BooleanArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    do {
                        booleanArrayList.addBoolean(readBool());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else if (b2 == 2) {
                    int t = this.c + t();
                    while (this.c < t) {
                        booleanArrayList.addBoolean(t() != 0);
                    }
                    x(t);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 0) {
                    do {
                        list.add(Boolean.valueOf(readBool()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else if (b3 == 2) {
                    int t2 = this.c + t();
                    while (this.c < t2) {
                        list.add(Boolean.valueOf(t() != 0));
                    }
                    x(t2);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public ByteString readBytes() {
            y(2);
            int t = t();
            if (t == 0) {
                return ByteString.EMPTY;
            }
            w(t);
            ByteString wrap = this.f1054a ? ByteString.wrap(this.b, this.c, t) : ByteString.copyFrom(this.b, this.c, t);
            this.c += t;
            return wrap;
        }

        public void readBytesList(List list) {
            int i;
            if (WireFormat.b(this.f) == 2) {
                do {
                    list.add(readBytes());
                    if (!i()) {
                        i = this.c;
                    } else {
                        return;
                    }
                } while (t() == this.f);
                this.c = i;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        public double readDouble() {
            y(1);
            return Double.longBitsToDouble(o());
        }

        public void readDoubleList(List list) {
            int i;
            int i2;
            if (list instanceof DoubleArrayList) {
                DoubleArrayList doubleArrayList = (DoubleArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 1) {
                    do {
                        doubleArrayList.addDouble(readDouble());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else if (b2 == 2) {
                    int t = t();
                    E(t);
                    int i3 = this.c + t;
                    while (this.c < i3) {
                        doubleArrayList.addDouble(Double.longBitsToDouble(p()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else if (b3 == 2) {
                    int t2 = t();
                    E(t2);
                    int i4 = this.c + t2;
                    while (this.c < i4) {
                        list.add(Double.valueOf(Double.longBitsToDouble(p())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readEnum() {
            y(0);
            return t();
        }

        public void readEnumList(List list) {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    do {
                        intArrayList.addInt(readEnum());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else if (b2 == 2) {
                    int t = this.c + t();
                    while (this.c < t) {
                        intArrayList.addInt(t());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 0) {
                    do {
                        list.add(Integer.valueOf(readEnum()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else if (b3 == 2) {
                    int t2 = this.c + t();
                    while (this.c < t2) {
                        list.add(Integer.valueOf(t()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readFixed32() {
            y(5);
            return m();
        }

        public void readFixed32List(List list) {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 2) {
                    int t = t();
                    D(t);
                    int i3 = this.c + t;
                    while (this.c < i3) {
                        intArrayList.addInt(n());
                    }
                } else if (b2 == 5) {
                    do {
                        intArrayList.addInt(readFixed32());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 2) {
                    int t2 = t();
                    D(t2);
                    int i4 = this.c + t2;
                    while (this.c < i4) {
                        list.add(Integer.valueOf(n()));
                    }
                } else if (b3 == 5) {
                    do {
                        list.add(Integer.valueOf(readFixed32()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readFixed64() {
            y(1);
            return o();
        }

        public void readFixed64List(List list) {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 1) {
                    do {
                        longArrayList.addLong(readFixed64());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else if (b2 == 2) {
                    int t = t();
                    E(t);
                    int i3 = this.c + t;
                    while (this.c < i3) {
                        longArrayList.addLong(p());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 1) {
                    do {
                        list.add(Long.valueOf(readFixed64()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else if (b3 == 2) {
                    int t2 = t();
                    E(t2);
                    int i4 = this.c + t2;
                    while (this.c < i4) {
                        list.add(Long.valueOf(p()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public float readFloat() {
            y(5);
            return Float.intBitsToFloat(m());
        }

        public void readFloatList(List list) {
            int i;
            int i2;
            if (list instanceof FloatArrayList) {
                FloatArrayList floatArrayList = (FloatArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 2) {
                    int t = t();
                    D(t);
                    int i3 = this.c + t;
                    while (this.c < i3) {
                        floatArrayList.addFloat(Float.intBitsToFloat(n()));
                    }
                } else if (b2 == 5) {
                    do {
                        floatArrayList.addFloat(readFloat());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 2) {
                    int t2 = t();
                    D(t2);
                    int i4 = this.c + t2;
                    while (this.c < i4) {
                        list.add(Float.valueOf(Float.intBitsToFloat(n())));
                    }
                } else if (b3 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readInt32() {
            y(0);
            return t();
        }

        public void readInt32List(List list) {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    do {
                        intArrayList.addInt(readInt32());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else if (b2 == 2) {
                    int t = this.c + t();
                    while (this.c < t) {
                        intArrayList.addInt(t());
                    }
                    x(t);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 0) {
                    do {
                        list.add(Integer.valueOf(readInt32()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else if (b3 == 2) {
                    int t2 = this.c + t();
                    while (this.c < t2) {
                        list.add(Integer.valueOf(t()));
                    }
                    x(t2);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readInt64() {
            y(0);
            return u();
        }

        public void readInt64List(List list) {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    do {
                        longArrayList.addLong(readInt64());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else if (b2 == 2) {
                    int t = this.c + t();
                    while (this.c < t) {
                        longArrayList.addLong(u());
                    }
                    x(t);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 0) {
                    do {
                        list.add(Long.valueOf(readInt64()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else if (b3 == 2) {
                    int t2 = this.c + t();
                    while (this.c < t2) {
                        list.add(Long.valueOf(u()));
                    }
                    x(t2);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readSFixed32() {
            y(5);
            return m();
        }

        public void readSFixed32List(List list) {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 2) {
                    int t = t();
                    D(t);
                    int i3 = this.c + t;
                    while (this.c < i3) {
                        intArrayList.addInt(n());
                    }
                } else if (b2 == 5) {
                    do {
                        intArrayList.addInt(readSFixed32());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 2) {
                    int t2 = t();
                    D(t2);
                    int i4 = this.c + t2;
                    while (this.c < i4) {
                        list.add(Integer.valueOf(n()));
                    }
                } else if (b3 == 5) {
                    do {
                        list.add(Integer.valueOf(readSFixed32()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readSFixed64() {
            y(1);
            return o();
        }

        public void readSFixed64List(List list) {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 1) {
                    do {
                        longArrayList.addLong(readSFixed64());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else if (b2 == 2) {
                    int t = t();
                    E(t);
                    int i3 = this.c + t;
                    while (this.c < i3) {
                        longArrayList.addLong(p());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 1) {
                    do {
                        list.add(Long.valueOf(readSFixed64()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else if (b3 == 2) {
                    int t2 = t();
                    E(t2);
                    int i4 = this.c + t2;
                    while (this.c < i4) {
                        list.add(Long.valueOf(p()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readSInt32() {
            y(0);
            return CodedInputStream.b(t());
        }

        public void readSInt32List(List list) {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    do {
                        intArrayList.addInt(readSInt32());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else if (b2 == 2) {
                    int t = this.c + t();
                    while (this.c < t) {
                        intArrayList.addInt(CodedInputStream.b(t()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 0) {
                    do {
                        list.add(Integer.valueOf(readSInt32()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else if (b3 == 2) {
                    int t2 = this.c + t();
                    while (this.c < t2) {
                        list.add(Integer.valueOf(CodedInputStream.b(t())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readSInt64() {
            y(0);
            return CodedInputStream.c(u());
        }

        public void readSInt64List(List list) {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    do {
                        longArrayList.addLong(readSInt64());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else if (b2 == 2) {
                    int t = this.c + t();
                    while (this.c < t) {
                        longArrayList.addLong(CodedInputStream.c(u()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 0) {
                    do {
                        list.add(Long.valueOf(readSInt64()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else if (b3 == 2) {
                    int t2 = this.c + t();
                    while (this.c < t2) {
                        list.add(Long.valueOf(CodedInputStream.c(u())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public String readString() {
            return r(false);
        }

        public void readStringList(List list) {
            s(list, false);
        }

        public void readStringListRequireUtf8(List list) {
            s(list, true);
        }

        public String readStringRequireUtf8() {
            return r(true);
        }

        public int readUInt32() {
            y(0);
            return t();
        }

        public void readUInt32List(List list) {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    do {
                        intArrayList.addInt(readUInt32());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else if (b2 == 2) {
                    int t = this.c + t();
                    while (this.c < t) {
                        intArrayList.addInt(t());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 0) {
                    do {
                        list.add(Integer.valueOf(readUInt32()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else if (b3 == 2) {
                    int t2 = this.c + t();
                    while (this.c < t2) {
                        list.add(Integer.valueOf(t()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readUInt64() {
            y(0);
            return u();
        }

        public void readUInt64List(List list) {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    do {
                        longArrayList.addLong(readUInt64());
                        if (!i()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i2;
                } else if (b2 == 2) {
                    int t = this.c + t();
                    while (this.c < t) {
                        longArrayList.addLong(u());
                    }
                    x(t);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b3 = WireFormat.b(this.f);
                if (b3 == 0) {
                    do {
                        list.add(Long.valueOf(readUInt64()));
                        if (!i()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (t() == this.f);
                    this.c = i;
                } else if (b3 == 2) {
                    int t2 = this.c + t();
                    while (this.c < t2) {
                        list.add(Long.valueOf(u()));
                    }
                    x(t2);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public void s(List list, boolean z) {
            int i;
            int i2;
            if (WireFormat.b(this.f) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            } else if (!(list instanceof LazyStringList) || z) {
                do {
                    list.add(r(z));
                    if (!i()) {
                        i = this.c;
                    } else {
                        return;
                    }
                } while (t() == this.f);
                this.c = i;
            } else {
                LazyStringList lazyStringList = (LazyStringList) list;
                do {
                    lazyStringList.g(readBytes());
                    if (!i()) {
                        i2 = this.c;
                    } else {
                        return;
                    }
                } while (t() == this.f);
                this.c = i2;
            }
        }

        public boolean skipField() {
            int i;
            if (i() || (i = this.f) == this.g) {
                return false;
            }
            int b2 = WireFormat.b(i);
            if (b2 == 0) {
                B();
                return true;
            } else if (b2 == 1) {
                z(8);
                return true;
            } else if (b2 == 2) {
                z(t());
                return true;
            } else if (b2 == 3) {
                A();
                return true;
            } else if (b2 == 5) {
                z(4);
                return true;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final int t() {
            byte b2;
            byte b3;
            int i = this.c;
            int i2 = this.e;
            if (i2 != i) {
                byte[] bArr = this.b;
                int i3 = i + 1;
                byte b4 = bArr[i];
                if (b4 >= 0) {
                    this.c = i3;
                    return b4;
                } else if (i2 - i3 < 9) {
                    return (int) v();
                } else {
                    int i4 = i + 2;
                    byte b5 = (bArr[i3] << 7) ^ b4;
                    if (b5 < 0) {
                        b2 = b5 ^ Byte.MIN_VALUE;
                    } else {
                        int i5 = i + 3;
                        byte b6 = (bArr[i4] << 14) ^ b5;
                        if (b6 >= 0) {
                            b3 = b6 ^ 16256;
                        } else {
                            int i6 = i + 4;
                            byte b7 = b6 ^ (bArr[i5] << 21);
                            if (b7 < 0) {
                                b2 = -2080896 ^ b7;
                            } else {
                                i5 = i + 5;
                                byte b8 = bArr[i6];
                                byte b9 = (b7 ^ (b8 << 28)) ^ 266354560;
                                if (b8 < 0) {
                                    i6 = i + 6;
                                    if (bArr[i5] < 0) {
                                        i5 = i + 7;
                                        if (bArr[i6] < 0) {
                                            i6 = i + 8;
                                            if (bArr[i5] < 0) {
                                                i5 = i + 9;
                                                if (bArr[i6] < 0) {
                                                    int i7 = i + 10;
                                                    if (bArr[i5] >= 0) {
                                                        byte b10 = b9;
                                                        i4 = i7;
                                                        b2 = b10;
                                                    } else {
                                                        throw InvalidProtocolBufferException.malformedVarint();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b2 = b9;
                                }
                                b3 = b9;
                            }
                            i4 = i6;
                        }
                        i4 = i5;
                    }
                    this.c = i4;
                    return b2;
                }
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public long u() {
            long j;
            long j2;
            long j3;
            int i = this.c;
            int i2 = this.e;
            if (i2 != i) {
                byte[] bArr = this.b;
                int i3 = i + 1;
                byte b2 = bArr[i];
                if (b2 >= 0) {
                    this.c = i3;
                    return (long) b2;
                } else if (i2 - i3 < 9) {
                    return v();
                } else {
                    int i4 = i + 2;
                    byte b3 = (bArr[i3] << 7) ^ b2;
                    if (b3 < 0) {
                        j = (long) (b3 ^ Byte.MIN_VALUE);
                    } else {
                        int i5 = i + 3;
                        byte b4 = (bArr[i4] << 14) ^ b3;
                        if (b4 >= 0) {
                            j = (long) (b4 ^ 16256);
                            i4 = i5;
                        } else {
                            int i6 = i + 4;
                            byte b5 = b4 ^ (bArr[i5] << 21);
                            if (b5 < 0) {
                                i4 = i6;
                                j = (long) (-2080896 ^ b5);
                            } else {
                                long j4 = (long) b5;
                                int i7 = i + 5;
                                long j5 = j4 ^ (((long) bArr[i6]) << 28);
                                if (j5 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    int i8 = i + 6;
                                    long j6 = j5 ^ (((long) bArr[i7]) << 35);
                                    if (j6 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        i7 = i + 7;
                                        j5 = j6 ^ (((long) bArr[i8]) << 42);
                                        if (j5 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            i8 = i + 8;
                                            j6 = j5 ^ (((long) bArr[i7]) << 49);
                                            if (j6 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                i4 = i + 9;
                                                long j7 = (j6 ^ (((long) bArr[i8]) << 56)) ^ 71499008037633920L;
                                                if (j7 < 0) {
                                                    int i9 = i + 10;
                                                    if (((long) bArr[i4]) >= 0) {
                                                        i4 = i9;
                                                    } else {
                                                        throw InvalidProtocolBufferException.malformedVarint();
                                                    }
                                                }
                                                j = j7;
                                            }
                                        }
                                    }
                                    j = j6 ^ j2;
                                    i4 = i8;
                                }
                                j = j5 ^ j3;
                            }
                        }
                    }
                    this.c = i4;
                    return j;
                }
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final long v() {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte j2 = j();
                j |= ((long) (j2 & Byte.MAX_VALUE)) << i;
                if ((j2 & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void w(int i) {
            if (i < 0 || i > this.e - this.c) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final void x(int i) {
            if (this.c != i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final void y(int i) {
            if (WireFormat.b(this.f) != i) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final void z(int i) {
            w(i);
            this.c += i;
        }
    }

    public /* synthetic */ BinaryReader(AnonymousClass1 r1) {
        this();
    }

    public static BinaryReader h(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return new SafeHeapReader(byteBuffer, z);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    public BinaryReader() {
    }
}
