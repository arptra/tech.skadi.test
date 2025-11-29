package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import java.util.List;

final class CodedInputStreamReader implements Reader {

    /* renamed from: a  reason: collision with root package name */
    public final CodedInputStream f1066a;
    public int b;
    public int c;
    public int d = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.CodedInputStreamReader$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1067a;

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
                f1067a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f1067a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStreamReader.AnonymousClass1.<clinit>():void");
        }
    }

    public CodedInputStreamReader(CodedInputStream codedInputStream) {
        CodedInputStream codedInputStream2 = (CodedInputStream) Internal.b(codedInputStream, "input");
        this.f1066a = codedInputStream2;
        codedInputStream2.d = this;
    }

    public static CodedInputStreamReader h(CodedInputStream codedInputStream) {
        CodedInputStreamReader codedInputStreamReader = codedInputStream.d;
        return codedInputStreamReader != null ? codedInputStreamReader : new CodedInputStreamReader(codedInputStream);
    }

    private Object i(WireFormat.FieldType fieldType, Class cls, ExtensionRegistryLite extensionRegistryLite) {
        switch (AnonymousClass1.f1067a[fieldType.ordinal()]) {
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

    private Object j(Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        int i = this.c;
        this.c = WireFormat.c(WireFormat.a(this.b), 4);
        try {
            Object newInstance = schema.newInstance();
            schema.b(newInstance, this, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            if (this.b == this.c) {
                return newInstance;
            }
            throw InvalidProtocolBufferException.parseFailure();
        } finally {
            this.c = i;
        }
    }

    private Object k(Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        int D = this.f1066a.D();
        CodedInputStream codedInputStream = this.f1066a;
        if (codedInputStream.f1064a < codedInputStream.b) {
            int m = codedInputStream.m(D);
            Object newInstance = schema.newInstance();
            this.f1066a.f1064a++;
            schema.b(newInstance, this, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            this.f1066a.a(0);
            CodedInputStream codedInputStream2 = this.f1066a;
            codedInputStream2.f1064a--;
            codedInputStream2.l(m);
            return newInstance;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    private void m(int i) {
        if (this.f1066a.d() != i) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void n(int i) {
        if (WireFormat.b(this.b) != i) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    private void o(int i) {
        if ((i & 3) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    private void p(int i) {
        if ((i & 7) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    public Object a(Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        n(3);
        return j(schema, extensionRegistryLite);
    }

    public Object b(Class cls, ExtensionRegistryLite extensionRegistryLite) {
        n(2);
        return k(Protobuf.a().d(cls), extensionRegistryLite);
    }

    public Object c(Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        n(2);
        return k(schema, extensionRegistryLite);
    }

    public void d(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        int C;
        if (WireFormat.b(this.b) == 2) {
            int i = this.b;
            do {
                list.add(k(schema, extensionRegistryLite));
                if (!this.f1066a.e() && this.d == 0) {
                    C = this.f1066a.C();
                } else {
                    return;
                }
            } while (C == i);
            this.d = C;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public Object e(Class cls, ExtensionRegistryLite extensionRegistryLite) {
        n(3);
        return j(Protobuf.a().d(cls), extensionRegistryLite);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (skipField() != false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException(r6);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(java.util.Map r8, androidx.datastore.preferences.protobuf.MapEntryLite.Metadata r9, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r10) {
        /*
            r7 = this;
            r0 = 2
            r7.n(r0)
            androidx.datastore.preferences.protobuf.CodedInputStream r1 = r7.f1066a
            int r1 = r1.D()
            androidx.datastore.preferences.protobuf.CodedInputStream r2 = r7.f1066a
            int r1 = r2.m(r1)
            java.lang.Object r2 = r9.b
            java.lang.Object r3 = r9.d
        L_0x0014:
            int r4 = r7.getFieldNumber()     // Catch:{ all -> 0x003a }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005e
            androidx.datastore.preferences.protobuf.CodedInputStream r5 = r7.f1066a     // Catch:{ all -> 0x003a }
            boolean r5 = r5.e()     // Catch:{ all -> 0x003a }
            if (r5 == 0) goto L_0x0026
            goto L_0x005e
        L_0x0026:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0049
            if (r4 == r0) goto L_0x003c
            boolean r4 = r7.skipField()     // Catch:{ InvalidWireTypeException -> 0x0051 }
            if (r4 == 0) goto L_0x0034
            goto L_0x0014
        L_0x0034:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidWireTypeException -> 0x0051 }
            r4.<init>((java.lang.String) r6)     // Catch:{ InvalidWireTypeException -> 0x0051 }
            throw r4     // Catch:{ InvalidWireTypeException -> 0x0051 }
        L_0x003a:
            r8 = move-exception
            goto L_0x0067
        L_0x003c:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.c     // Catch:{ InvalidWireTypeException -> 0x0051 }
            java.lang.Object r5 = r9.d     // Catch:{ InvalidWireTypeException -> 0x0051 }
            java.lang.Class r5 = r5.getClass()     // Catch:{ InvalidWireTypeException -> 0x0051 }
            java.lang.Object r3 = r7.i(r4, r5, r10)     // Catch:{ InvalidWireTypeException -> 0x0051 }
            goto L_0x0014
        L_0x0049:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f1117a     // Catch:{ InvalidWireTypeException -> 0x0051 }
            r5 = 0
            java.lang.Object r2 = r7.i(r4, r5, r5)     // Catch:{ InvalidWireTypeException -> 0x0051 }
            goto L_0x0014
        L_0x0051:
            boolean r4 = r7.skipField()     // Catch:{ all -> 0x003a }
            if (r4 == 0) goto L_0x0058
            goto L_0x0014
        L_0x0058:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x003a }
            r8.<init>((java.lang.String) r6)     // Catch:{ all -> 0x003a }
            throw r8     // Catch:{ all -> 0x003a }
        L_0x005e:
            r8.put(r2, r3)     // Catch:{ all -> 0x003a }
            androidx.datastore.preferences.protobuf.CodedInputStream r7 = r7.f1066a
            r7.l(r1)
            return
        L_0x0067:
            androidx.datastore.preferences.protobuf.CodedInputStream r7 = r7.f1066a
            r7.l(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStreamReader.f(java.util.Map, androidx.datastore.preferences.protobuf.MapEntryLite$Metadata, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    public void g(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        int C;
        if (WireFormat.b(this.b) == 3) {
            int i = this.b;
            do {
                list.add(j(schema, extensionRegistryLite));
                if (!this.f1066a.e() && this.d == 0) {
                    C = this.f1066a.C();
                } else {
                    return;
                }
            } while (C == i);
            this.d = C;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public int getFieldNumber() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.f1066a.C();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return WireFormat.a(i2);
    }

    public int getTag() {
        return this.b;
    }

    public void l(List list, boolean z) {
        int C;
        int C2;
        if (WireFormat.b(this.b) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        } else if (!(list instanceof LazyStringList) || z) {
            do {
                list.add(z ? readStringRequireUtf8() : readString());
                if (!this.f1066a.e()) {
                    C = this.f1066a.C();
                } else {
                    return;
                }
            } while (C == this.b);
            this.d = C;
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            do {
                lazyStringList.g(readBytes());
                if (!this.f1066a.e()) {
                    C2 = this.f1066a.C();
                } else {
                    return;
                }
            } while (C2 == this.b);
            this.d = C2;
        }
    }

    public boolean readBool() {
        n(0);
        return this.f1066a.n();
    }

    public void readBoolList(List list) {
        int C;
        int C2;
        if (list instanceof BooleanArrayList) {
            BooleanArrayList booleanArrayList = (BooleanArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                do {
                    booleanArrayList.addBoolean(this.f1066a.n());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else if (b2 == 2) {
                int d2 = this.f1066a.d() + this.f1066a.D();
                do {
                    booleanArrayList.addBoolean(this.f1066a.n());
                } while (this.f1066a.d() < d2);
                m(d2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f1066a.n()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else if (b3 == 2) {
                int d3 = this.f1066a.d() + this.f1066a.D();
                do {
                    list.add(Boolean.valueOf(this.f1066a.n()));
                } while (this.f1066a.d() < d3);
                m(d3);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public ByteString readBytes() {
        n(2);
        return this.f1066a.o();
    }

    public void readBytesList(List list) {
        int C;
        if (WireFormat.b(this.b) == 2) {
            do {
                list.add(readBytes());
                if (!this.f1066a.e()) {
                    C = this.f1066a.C();
                } else {
                    return;
                }
            } while (C == this.b);
            this.d = C;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public double readDouble() {
        n(1);
        return this.f1066a.p();
    }

    public void readDoubleList(List list) {
        int C;
        int C2;
        if (list instanceof DoubleArrayList) {
            DoubleArrayList doubleArrayList = (DoubleArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 1) {
                do {
                    doubleArrayList.addDouble(this.f1066a.p());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else if (b2 == 2) {
                int D = this.f1066a.D();
                p(D);
                int d2 = this.f1066a.d() + D;
                do {
                    doubleArrayList.addDouble(this.f1066a.p());
                } while (this.f1066a.d() < d2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 1) {
                do {
                    list.add(Double.valueOf(this.f1066a.p()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else if (b3 == 2) {
                int D2 = this.f1066a.D();
                p(D2);
                int d3 = this.f1066a.d() + D2;
                do {
                    list.add(Double.valueOf(this.f1066a.p()));
                } while (this.f1066a.d() < d3);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public int readEnum() {
        n(0);
        return this.f1066a.q();
    }

    public void readEnumList(List list) {
        int C;
        int C2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                do {
                    intArrayList.addInt(this.f1066a.q());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else if (b2 == 2) {
                int d2 = this.f1066a.d() + this.f1066a.D();
                do {
                    intArrayList.addInt(this.f1066a.q());
                } while (this.f1066a.d() < d2);
                m(d2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f1066a.q()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else if (b3 == 2) {
                int d3 = this.f1066a.d() + this.f1066a.D();
                do {
                    list.add(Integer.valueOf(this.f1066a.q()));
                } while (this.f1066a.d() < d3);
                m(d3);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public int readFixed32() {
        n(5);
        return this.f1066a.r();
    }

    public void readFixed32List(List list) {
        int C;
        int C2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 2) {
                int D = this.f1066a.D();
                o(D);
                int d2 = this.f1066a.d() + D;
                do {
                    intArrayList.addInt(this.f1066a.r());
                } while (this.f1066a.d() < d2);
            } else if (b2 == 5) {
                do {
                    intArrayList.addInt(this.f1066a.r());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 2) {
                int D2 = this.f1066a.D();
                o(D2);
                int d3 = this.f1066a.d() + D2;
                do {
                    list.add(Integer.valueOf(this.f1066a.r()));
                } while (this.f1066a.d() < d3);
            } else if (b3 == 5) {
                do {
                    list.add(Integer.valueOf(this.f1066a.r()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readFixed64() {
        n(1);
        return this.f1066a.s();
    }

    public void readFixed64List(List list) {
        int C;
        int C2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 1) {
                do {
                    longArrayList.addLong(this.f1066a.s());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else if (b2 == 2) {
                int D = this.f1066a.D();
                p(D);
                int d2 = this.f1066a.d() + D;
                do {
                    longArrayList.addLong(this.f1066a.s());
                } while (this.f1066a.d() < d2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 1) {
                do {
                    list.add(Long.valueOf(this.f1066a.s()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else if (b3 == 2) {
                int D2 = this.f1066a.D();
                p(D2);
                int d3 = this.f1066a.d() + D2;
                do {
                    list.add(Long.valueOf(this.f1066a.s()));
                } while (this.f1066a.d() < d3);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public float readFloat() {
        n(5);
        return this.f1066a.t();
    }

    public void readFloatList(List list) {
        int C;
        int C2;
        if (list instanceof FloatArrayList) {
            FloatArrayList floatArrayList = (FloatArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 2) {
                int D = this.f1066a.D();
                o(D);
                int d2 = this.f1066a.d() + D;
                do {
                    floatArrayList.addFloat(this.f1066a.t());
                } while (this.f1066a.d() < d2);
            } else if (b2 == 5) {
                do {
                    floatArrayList.addFloat(this.f1066a.t());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 2) {
                int D2 = this.f1066a.D();
                o(D2);
                int d3 = this.f1066a.d() + D2;
                do {
                    list.add(Float.valueOf(this.f1066a.t()));
                } while (this.f1066a.d() < d3);
            } else if (b3 == 5) {
                do {
                    list.add(Float.valueOf(this.f1066a.t()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public int readInt32() {
        n(0);
        return this.f1066a.u();
    }

    public void readInt32List(List list) {
        int C;
        int C2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                do {
                    intArrayList.addInt(this.f1066a.u());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else if (b2 == 2) {
                int d2 = this.f1066a.d() + this.f1066a.D();
                do {
                    intArrayList.addInt(this.f1066a.u());
                } while (this.f1066a.d() < d2);
                m(d2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f1066a.u()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else if (b3 == 2) {
                int d3 = this.f1066a.d() + this.f1066a.D();
                do {
                    list.add(Integer.valueOf(this.f1066a.u()));
                } while (this.f1066a.d() < d3);
                m(d3);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readInt64() {
        n(0);
        return this.f1066a.v();
    }

    public void readInt64List(List list) {
        int C;
        int C2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                do {
                    longArrayList.addLong(this.f1066a.v());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else if (b2 == 2) {
                int d2 = this.f1066a.d() + this.f1066a.D();
                do {
                    longArrayList.addLong(this.f1066a.v());
                } while (this.f1066a.d() < d2);
                m(d2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 0) {
                do {
                    list.add(Long.valueOf(this.f1066a.v()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else if (b3 == 2) {
                int d3 = this.f1066a.d() + this.f1066a.D();
                do {
                    list.add(Long.valueOf(this.f1066a.v()));
                } while (this.f1066a.d() < d3);
                m(d3);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public int readSFixed32() {
        n(5);
        return this.f1066a.w();
    }

    public void readSFixed32List(List list) {
        int C;
        int C2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 2) {
                int D = this.f1066a.D();
                o(D);
                int d2 = this.f1066a.d() + D;
                do {
                    intArrayList.addInt(this.f1066a.w());
                } while (this.f1066a.d() < d2);
            } else if (b2 == 5) {
                do {
                    intArrayList.addInt(this.f1066a.w());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 2) {
                int D2 = this.f1066a.D();
                o(D2);
                int d3 = this.f1066a.d() + D2;
                do {
                    list.add(Integer.valueOf(this.f1066a.w()));
                } while (this.f1066a.d() < d3);
            } else if (b3 == 5) {
                do {
                    list.add(Integer.valueOf(this.f1066a.w()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readSFixed64() {
        n(1);
        return this.f1066a.x();
    }

    public void readSFixed64List(List list) {
        int C;
        int C2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 1) {
                do {
                    longArrayList.addLong(this.f1066a.x());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else if (b2 == 2) {
                int D = this.f1066a.D();
                p(D);
                int d2 = this.f1066a.d() + D;
                do {
                    longArrayList.addLong(this.f1066a.x());
                } while (this.f1066a.d() < d2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 1) {
                do {
                    list.add(Long.valueOf(this.f1066a.x()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else if (b3 == 2) {
                int D2 = this.f1066a.D();
                p(D2);
                int d3 = this.f1066a.d() + D2;
                do {
                    list.add(Long.valueOf(this.f1066a.x()));
                } while (this.f1066a.d() < d3);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public int readSInt32() {
        n(0);
        return this.f1066a.y();
    }

    public void readSInt32List(List list) {
        int C;
        int C2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                do {
                    intArrayList.addInt(this.f1066a.y());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else if (b2 == 2) {
                int d2 = this.f1066a.d() + this.f1066a.D();
                do {
                    intArrayList.addInt(this.f1066a.y());
                } while (this.f1066a.d() < d2);
                m(d2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f1066a.y()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else if (b3 == 2) {
                int d3 = this.f1066a.d() + this.f1066a.D();
                do {
                    list.add(Integer.valueOf(this.f1066a.y()));
                } while (this.f1066a.d() < d3);
                m(d3);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readSInt64() {
        n(0);
        return this.f1066a.z();
    }

    public void readSInt64List(List list) {
        int C;
        int C2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                do {
                    longArrayList.addLong(this.f1066a.z());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else if (b2 == 2) {
                int d2 = this.f1066a.d() + this.f1066a.D();
                do {
                    longArrayList.addLong(this.f1066a.z());
                } while (this.f1066a.d() < d2);
                m(d2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 0) {
                do {
                    list.add(Long.valueOf(this.f1066a.z()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else if (b3 == 2) {
                int d3 = this.f1066a.d() + this.f1066a.D();
                do {
                    list.add(Long.valueOf(this.f1066a.z()));
                } while (this.f1066a.d() < d3);
                m(d3);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public String readString() {
        n(2);
        return this.f1066a.A();
    }

    public void readStringList(List list) {
        l(list, false);
    }

    public void readStringListRequireUtf8(List list) {
        l(list, true);
    }

    public String readStringRequireUtf8() {
        n(2);
        return this.f1066a.B();
    }

    public int readUInt32() {
        n(0);
        return this.f1066a.D();
    }

    public void readUInt32List(List list) {
        int C;
        int C2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                do {
                    intArrayList.addInt(this.f1066a.D());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else if (b2 == 2) {
                int d2 = this.f1066a.d() + this.f1066a.D();
                do {
                    intArrayList.addInt(this.f1066a.D());
                } while (this.f1066a.d() < d2);
                m(d2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f1066a.D()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else if (b3 == 2) {
                int d3 = this.f1066a.d() + this.f1066a.D();
                do {
                    list.add(Integer.valueOf(this.f1066a.D()));
                } while (this.f1066a.d() < d3);
                m(d3);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readUInt64() {
        n(0);
        return this.f1066a.E();
    }

    public void readUInt64List(List list) {
        int C;
        int C2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                do {
                    longArrayList.addLong(this.f1066a.E());
                    if (!this.f1066a.e()) {
                        C2 = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C2 == this.b);
                this.d = C2;
            } else if (b2 == 2) {
                int d2 = this.f1066a.d() + this.f1066a.D();
                do {
                    longArrayList.addLong(this.f1066a.E());
                } while (this.f1066a.d() < d2);
                m(d2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int b3 = WireFormat.b(this.b);
            if (b3 == 0) {
                do {
                    list.add(Long.valueOf(this.f1066a.E()));
                    if (!this.f1066a.e()) {
                        C = this.f1066a.C();
                    } else {
                        return;
                    }
                } while (C == this.b);
                this.d = C;
            } else if (b3 == 2) {
                int d3 = this.f1066a.d() + this.f1066a.D();
                do {
                    list.add(Long.valueOf(this.f1066a.E()));
                } while (this.f1066a.d() < d3);
                m(d3);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public boolean skipField() {
        int i;
        if (this.f1066a.e() || (i = this.b) == this.c) {
            return false;
        }
        return this.f1066a.F(i);
    }
}
