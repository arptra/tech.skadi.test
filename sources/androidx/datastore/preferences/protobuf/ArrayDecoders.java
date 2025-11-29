package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;

final class ArrayDecoders {

    /* renamed from: androidx.datastore.preferences.protobuf.ArrayDecoders$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1051a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1051a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f1051a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Registers {

        /* renamed from: a  reason: collision with root package name */
        public int f1052a;
        public long b;
        public Object c;
        public final ExtensionRegistryLite d;

        public Registers(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.d = extensionRegistryLite;
        }
    }

    public static int A(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i2, registers);
        intArrayList.addInt(CodedInputStream.b(registers.f1052a));
        while (I < i3) {
            int I2 = I(bArr, I, registers);
            if (i != registers.f1052a) {
                break;
            }
            I = I(bArr, I2, registers);
            intArrayList.addInt(CodedInputStream.b(registers.f1052a));
        }
        return I;
    }

    public static int B(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int L = L(bArr, i2, registers);
        longArrayList.addLong(CodedInputStream.c(registers.b));
        while (L < i3) {
            int I = I(bArr, L, registers);
            if (i != registers.f1052a) {
                break;
            }
            L = L(bArr, I, registers);
            longArrayList.addLong(CodedInputStream.c(registers.b));
        }
        return L;
    }

    public static int C(byte[] bArr, int i, Registers registers) {
        int I = I(bArr, i, registers);
        int i2 = registers.f1052a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i2 == 0) {
            registers.c = "";
            return I;
        } else {
            registers.c = new String(bArr, I, i2, Internal.f1098a);
            return I + i2;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[EDGE_INSN: B:21:0x0044->B:17:0x0044 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    public static int D(int r4, byte[] r5, int r6, int r7, androidx.datastore.preferences.protobuf.Internal.ProtobufList r8, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r9) {
        /*
            int r6 = I(r5, r6, r9)
            int r0 = r9.f1052a
            if (r0 < 0) goto L_0x0045
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r8.add(r1)
            goto L_0x001b
        L_0x0010:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = androidx.datastore.preferences.protobuf.Internal.f1098a
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
        L_0x001a:
            int r6 = r6 + r0
        L_0x001b:
            if (r6 >= r7) goto L_0x0044
            int r0 = I(r5, r6, r9)
            int r2 = r9.f1052a
            if (r4 == r2) goto L_0x0026
            goto L_0x0044
        L_0x0026:
            int r6 = I(r5, r0, r9)
            int r0 = r9.f1052a
            if (r0 < 0) goto L_0x003f
            if (r0 != 0) goto L_0x0034
            r8.add(r1)
            goto L_0x001b
        L_0x0034:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = androidx.datastore.preferences.protobuf.Internal.f1098a
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
            goto L_0x001a
        L_0x003f:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r4
        L_0x0044:
            return r6
        L_0x0045:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.D(int, byte[], int, int, androidx.datastore.preferences.protobuf.Internal$ProtobufList, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        r2 = r7 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (androidx.datastore.preferences.protobuf.Utf8.u(r6, r7, r2) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        r9.add(new java.lang.String(r6, r7, r0, androidx.datastore.preferences.protobuf.Internal.f1098a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidUtf8();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059 A[EDGE_INSN: B:28:0x0059->B:23:0x0059 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int E(int r5, byte[] r6, int r7, int r8, androidx.datastore.preferences.protobuf.Internal.ProtobufList r9, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r10) {
        /*
            int r7 = I(r6, r7, r10)
            int r0 = r10.f1052a
            if (r0 < 0) goto L_0x005f
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r9.add(r1)
            goto L_0x0023
        L_0x0010:
            int r2 = r7 + r0
            boolean r3 = androidx.datastore.preferences.protobuf.Utf8.u(r6, r7, r2)
            if (r3 == 0) goto L_0x005a
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = androidx.datastore.preferences.protobuf.Internal.f1098a
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
        L_0x0022:
            r7 = r2
        L_0x0023:
            if (r7 >= r8) goto L_0x0059
            int r0 = I(r6, r7, r10)
            int r2 = r10.f1052a
            if (r5 == r2) goto L_0x002e
            goto L_0x0059
        L_0x002e:
            int r7 = I(r6, r0, r10)
            int r0 = r10.f1052a
            if (r0 < 0) goto L_0x0054
            if (r0 != 0) goto L_0x003c
            r9.add(r1)
            goto L_0x0023
        L_0x003c:
            int r2 = r7 + r0
            boolean r3 = androidx.datastore.preferences.protobuf.Utf8.u(r6, r7, r2)
            if (r3 == 0) goto L_0x004f
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = androidx.datastore.preferences.protobuf.Internal.f1098a
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
            goto L_0x0022
        L_0x004f:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidUtf8()
            throw r5
        L_0x0054:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r5
        L_0x0059:
            return r7
        L_0x005a:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidUtf8()
            throw r5
        L_0x005f:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.E(int, byte[], int, int, androidx.datastore.preferences.protobuf.Internal$ProtobufList, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    public static int F(byte[] bArr, int i, Registers registers) {
        int I = I(bArr, i, registers);
        int i2 = registers.f1052a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i2 == 0) {
            registers.c = "";
            return I;
        } else {
            registers.c = Utf8.h(bArr, I, i2);
            return I + i2;
        }
    }

    public static int G(int i, byte[] bArr, int i2, int i3, UnknownFieldSetLite unknownFieldSetLite, Registers registers) {
        if (WireFormat.a(i) != 0) {
            int b = WireFormat.b(i);
            if (b == 0) {
                int L = L(bArr, i2, registers);
                unknownFieldSetLite.n(i, Long.valueOf(registers.b));
                return L;
            } else if (b == 1) {
                unknownFieldSetLite.n(i, Long.valueOf(j(bArr, i2)));
                return i2 + 8;
            } else if (b == 2) {
                int I = I(bArr, i2, registers);
                int i4 = registers.f1052a;
                if (i4 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                } else if (i4 <= bArr.length - I) {
                    if (i4 == 0) {
                        unknownFieldSetLite.n(i, ByteString.EMPTY);
                    } else {
                        unknownFieldSetLite.n(i, ByteString.copyFrom(bArr, I, i4));
                    }
                    return I + i4;
                } else {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } else if (b == 3) {
                UnknownFieldSetLite l = UnknownFieldSetLite.l();
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int I2 = I(bArr, i2, registers);
                    int i7 = registers.f1052a;
                    if (i7 == i5) {
                        i6 = i7;
                        i2 = I2;
                        break;
                    }
                    i6 = i7;
                    i2 = G(i7, bArr, I2, i3, l, registers);
                }
                if (i2 > i3 || i6 != i5) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
                unknownFieldSetLite.n(i, l);
                return i2;
            } else if (b == 5) {
                unknownFieldSetLite.n(i, Integer.valueOf(h(bArr, i2)));
                return i2 + 4;
            } else {
                throw InvalidProtocolBufferException.invalidTag();
            }
        } else {
            throw InvalidProtocolBufferException.invalidTag();
        }
    }

    public static int H(int i, byte[] bArr, int i2, Registers registers) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            registers.f1052a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            registers.f1052a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            registers.f1052a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            registers.f1052a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                registers.f1052a = i11;
                return i12;
            }
        }
    }

    public static int I(byte[] bArr, int i, Registers registers) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return H(b, bArr, i2, registers);
        }
        registers.f1052a = b;
        return i2;
    }

    public static int J(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i2, registers);
        intArrayList.addInt(registers.f1052a);
        while (I < i3) {
            int I2 = I(bArr, I, registers);
            if (i != registers.f1052a) {
                break;
            }
            I = I(bArr, I2, registers);
            intArrayList.addInt(registers.f1052a);
        }
        return I;
    }

    public static int K(long j, byte[] bArr, int i, Registers registers) {
        int i2 = i + 1;
        byte b = bArr[i];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i3 = 7;
        while (b < 0) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            i3 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i3;
            byte b3 = b2;
            i2 = i4;
            b = b3;
        }
        registers.b = j2;
        return i2;
    }

    public static int L(byte[] bArr, int i, Registers registers) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j < 0) {
            return K(j, bArr, i2, registers);
        }
        registers.b = j;
        return i2;
    }

    public static int M(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int L = L(bArr, i2, registers);
        longArrayList.addLong(registers.b);
        while (L < i3) {
            int I = I(bArr, L, registers);
            if (i != registers.f1052a) {
                break;
            }
            L = L(bArr, I, registers);
            longArrayList.addLong(registers.b);
        }
        return L;
    }

    public static int N(int i, byte[] bArr, int i2, int i3, Registers registers) {
        if (WireFormat.a(i) != 0) {
            int b = WireFormat.b(i);
            if (b == 0) {
                return L(bArr, i2, registers);
            }
            if (b == 1) {
                return i2 + 8;
            }
            if (b == 2) {
                return I(bArr, i2, registers) + registers.f1052a;
            }
            if (b == 3) {
                int i4 = (i & -8) | 4;
                int i5 = 0;
                while (i2 < i3) {
                    i2 = I(bArr, i2, registers);
                    i5 = registers.f1052a;
                    if (i5 == i4) {
                        break;
                    }
                    i2 = N(i5, bArr, i2, i3, registers);
                }
                if (i2 <= i3 && i5 == i4) {
                    return i2;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } else if (b == 5) {
                return i2 + 4;
            } else {
                throw InvalidProtocolBufferException.invalidTag();
            }
        } else {
            throw InvalidProtocolBufferException.invalidTag();
        }
    }

    public static int a(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList protobufList, Registers registers) {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int L = L(bArr, i2, registers);
        booleanArrayList.addBoolean(registers.b != 0);
        while (L < i3) {
            int I = I(bArr, L, registers);
            if (i != registers.f1052a) {
                break;
            }
            L = L(bArr, I, registers);
            booleanArrayList.addBoolean(registers.b != 0);
        }
        return L;
    }

    public static int b(byte[] bArr, int i, Registers registers) {
        int I = I(bArr, i, registers);
        int i2 = registers.f1052a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i2 > bArr.length - I) {
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (i2 == 0) {
            registers.c = ByteString.EMPTY;
            return I;
        } else {
            registers.c = ByteString.copyFrom(bArr, I, i2);
            return I + i2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[EDGE_INSN: B:30:0x004d->B:22:0x004d ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int c(int r2, byte[] r3, int r4, int r5, androidx.datastore.preferences.protobuf.Internal.ProtobufList r6, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r7) {
        /*
            int r4 = I(r3, r4, r7)
            int r0 = r7.f1052a
            if (r0 < 0) goto L_0x0053
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x004e
            if (r0 != 0) goto L_0x0014
            androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x0014:
            androidx.datastore.preferences.protobuf.ByteString r1 = androidx.datastore.preferences.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
        L_0x001b:
            int r4 = r4 + r0
        L_0x001c:
            if (r4 >= r5) goto L_0x004d
            int r0 = I(r3, r4, r7)
            int r1 = r7.f1052a
            if (r2 == r1) goto L_0x0027
            goto L_0x004d
        L_0x0027:
            int r4 = I(r3, r0, r7)
            int r0 = r7.f1052a
            if (r0 < 0) goto L_0x0048
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x0043
            if (r0 != 0) goto L_0x003b
            androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x003b:
            androidx.datastore.preferences.protobuf.ByteString r1 = androidx.datastore.preferences.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
            goto L_0x001b
        L_0x0043:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r2
        L_0x0048:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r2
        L_0x004d:
            return r4
        L_0x004e:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r2
        L_0x0053:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.c(int, byte[], int, int, androidx.datastore.preferences.protobuf.Internal$ProtobufList, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    public static double d(byte[] bArr, int i) {
        return Double.longBitsToDouble(j(bArr, i));
    }

    public static int e(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.addDouble(d(bArr, i2));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int I = I(bArr, i4, registers);
            if (i != registers.f1052a) {
                break;
            }
            doubleArrayList.addDouble(d(bArr, I));
            i4 = I + 8;
        }
        return i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01cc, code lost:
        r9 = r9 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01d7, code lost:
        r9 = r9 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int f(int r7, byte[] r8, int r9, int r10, androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage r11, androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension r12, androidx.datastore.preferences.protobuf.UnknownFieldSchema r13, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r14) {
        /*
            androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r0 = r11.extensions
            int r7 = r7 >>> 3
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r1 = r12.b
            boolean r1 = r1.isRepeated()
            r2 = 0
            if (r1 == 0) goto L_0x00fb
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r1 = r12.b
            boolean r1 = r1.isPacked()
            if (r1 == 0) goto L_0x00fb
            int[] r10 = androidx.datastore.preferences.protobuf.ArrayDecoders.AnonymousClass1.f1051a
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r12.a()
            int r1 = r1.ordinal()
            r10 = r10[r1]
            switch(r10) {
                case 1: goto L_0x00eb;
                case 2: goto L_0x00db;
                case 3: goto L_0x00cb;
                case 4: goto L_0x00cb;
                case 5: goto L_0x00bb;
                case 6: goto L_0x00bb;
                case 7: goto L_0x00ab;
                case 8: goto L_0x00ab;
                case 9: goto L_0x009b;
                case 10: goto L_0x009b;
                case 11: goto L_0x008b;
                case 12: goto L_0x007b;
                case 13: goto L_0x006b;
                case 14: goto L_0x0041;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Type cannot be packed: "
            r8.append(r9)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.b
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0041:
            androidx.datastore.preferences.protobuf.IntArrayList r10 = new androidx.datastore.preferences.protobuf.IntArrayList
            r10.<init>()
            int r8 = y(r8, r9, r10, r14)
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r9 = r11.unknownFields
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r14 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.e()
            if (r9 != r14) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r2 = r9
        L_0x0054:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.b
            androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r9 = r9.d()
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.SchemaUtil.z(r7, r10, r9, r2, r13)
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r7 = (androidx.datastore.preferences.protobuf.UnknownFieldSetLite) r7
            if (r7 == 0) goto L_0x0064
            r11.unknownFields = r7
        L_0x0064:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.b
            r0.w(r7, r10)
            goto L_0x0235
        L_0x006b:
            androidx.datastore.preferences.protobuf.LongArrayList r7 = new androidx.datastore.preferences.protobuf.LongArrayList
            r7.<init>()
            int r8 = x(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.b
            r0.w(r9, r7)
            goto L_0x0235
        L_0x007b:
            androidx.datastore.preferences.protobuf.IntArrayList r7 = new androidx.datastore.preferences.protobuf.IntArrayList
            r7.<init>()
            int r8 = w(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.b
            r0.w(r9, r7)
            goto L_0x0235
        L_0x008b:
            androidx.datastore.preferences.protobuf.BooleanArrayList r7 = new androidx.datastore.preferences.protobuf.BooleanArrayList
            r7.<init>()
            int r8 = r(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.b
            r0.w(r9, r7)
            goto L_0x0235
        L_0x009b:
            androidx.datastore.preferences.protobuf.IntArrayList r7 = new androidx.datastore.preferences.protobuf.IntArrayList
            r7.<init>()
            int r8 = t(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.b
            r0.w(r9, r7)
            goto L_0x0235
        L_0x00ab:
            androidx.datastore.preferences.protobuf.LongArrayList r7 = new androidx.datastore.preferences.protobuf.LongArrayList
            r7.<init>()
            int r8 = u(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.b
            r0.w(r9, r7)
            goto L_0x0235
        L_0x00bb:
            androidx.datastore.preferences.protobuf.IntArrayList r7 = new androidx.datastore.preferences.protobuf.IntArrayList
            r7.<init>()
            int r8 = y(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.b
            r0.w(r9, r7)
            goto L_0x0235
        L_0x00cb:
            androidx.datastore.preferences.protobuf.LongArrayList r7 = new androidx.datastore.preferences.protobuf.LongArrayList
            r7.<init>()
            int r8 = z(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.b
            r0.w(r9, r7)
            goto L_0x0235
        L_0x00db:
            androidx.datastore.preferences.protobuf.FloatArrayList r7 = new androidx.datastore.preferences.protobuf.FloatArrayList
            r7.<init>()
            int r8 = v(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.b
            r0.w(r9, r7)
            goto L_0x0235
        L_0x00eb:
            androidx.datastore.preferences.protobuf.DoubleArrayList r7 = new androidx.datastore.preferences.protobuf.DoubleArrayList
            r7.<init>()
            int r8 = s(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.b
            r0.w(r9, r7)
            goto L_0x0235
        L_0x00fb:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r12.a()
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM
            if (r1 != r3) goto L_0x0131
            int r9 = I(r8, r9, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r12.b
            androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r8 = r8.d()
            int r10 = r14.f1052a
            androidx.datastore.preferences.protobuf.Internal$EnumLite r8 = r8.findValueByNumber(r10)
            if (r8 != 0) goto L_0x0129
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r8 = r11.unknownFields
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r10 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.e()
            if (r8 != r10) goto L_0x0123
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r8 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.l()
            r11.unknownFields = r8
        L_0x0123:
            int r10 = r14.f1052a
            androidx.datastore.preferences.protobuf.SchemaUtil.L(r7, r10, r8, r13)
            return r9
        L_0x0129:
            int r7 = r14.f1052a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0202
        L_0x0131:
            int[] r11 = androidx.datastore.preferences.protobuf.ArrayDecoders.AnonymousClass1.f1051a
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r13 = r12.a()
            int r13 = r13.ordinal()
            r11 = r11[r13]
            switch(r11) {
                case 1: goto L_0x01f9;
                case 2: goto L_0x01f0;
                case 3: goto L_0x01e5;
                case 4: goto L_0x01e5;
                case 5: goto L_0x01da;
                case 6: goto L_0x01da;
                case 7: goto L_0x01cf;
                case 8: goto L_0x01cf;
                case 9: goto L_0x01c4;
                case 10: goto L_0x01c4;
                case 11: goto L_0x01b0;
                case 12: goto L_0x01a1;
                case 13: goto L_0x0192;
                case 14: goto L_0x018a;
                case 15: goto L_0x0182;
                case 16: goto L_0x017a;
                case 17: goto L_0x015a;
                case 18: goto L_0x0142;
                default: goto L_0x0140;
            }
        L_0x0140:
            goto L_0x0202
        L_0x0142:
            androidx.datastore.preferences.protobuf.Protobuf r7 = androidx.datastore.preferences.protobuf.Protobuf.a()
            androidx.datastore.preferences.protobuf.MessageLite r11 = r12.b()
            java.lang.Class r11 = r11.getClass()
            androidx.datastore.preferences.protobuf.Schema r7 = r7.d(r11)
            int r9 = p(r7, r8, r9, r10, r14)
            java.lang.Object r2 = r14.c
            goto L_0x0202
        L_0x015a:
            int r7 = r7 << 3
            r5 = r7 | 4
            androidx.datastore.preferences.protobuf.Protobuf r7 = androidx.datastore.preferences.protobuf.Protobuf.a()
            androidx.datastore.preferences.protobuf.MessageLite r11 = r12.b()
            java.lang.Class r11 = r11.getClass()
            androidx.datastore.preferences.protobuf.Schema r1 = r7.d(r11)
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r14
            int r9 = n(r1, r2, r3, r4, r5, r6)
            java.lang.Object r2 = r14.c
            goto L_0x0202
        L_0x017a:
            int r9 = C(r8, r9, r14)
            java.lang.Object r2 = r14.c
            goto L_0x0202
        L_0x0182:
            int r9 = b(r8, r9, r14)
            java.lang.Object r2 = r14.c
            goto L_0x0202
        L_0x018a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Shouldn't reach here."
            r7.<init>(r8)
            throw r7
        L_0x0192:
            int r9 = L(r8, r9, r14)
            long r7 = r14.b
            long r7 = androidx.datastore.preferences.protobuf.CodedInputStream.c(r7)
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x0202
        L_0x01a1:
            int r9 = I(r8, r9, r14)
            int r7 = r14.f1052a
            int r7 = androidx.datastore.preferences.protobuf.CodedInputStream.b(r7)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0202
        L_0x01b0:
            int r9 = L(r8, r9, r14)
            long r7 = r14.b
            r10 = 0
            int r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r7 == 0) goto L_0x01be
            r7 = 1
            goto L_0x01bf
        L_0x01be:
            r7 = 0
        L_0x01bf:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r7)
            goto L_0x0202
        L_0x01c4:
            int r7 = h(r8, r9)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
        L_0x01cc:
            int r9 = r9 + 4
            goto L_0x0202
        L_0x01cf:
            long r7 = j(r8, r9)
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
        L_0x01d7:
            int r9 = r9 + 8
            goto L_0x0202
        L_0x01da:
            int r9 = I(r8, r9, r14)
            int r7 = r14.f1052a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0202
        L_0x01e5:
            int r9 = L(r8, r9, r14)
            long r7 = r14.b
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x0202
        L_0x01f0:
            float r7 = l(r8, r9)
            java.lang.Float r2 = java.lang.Float.valueOf(r7)
            goto L_0x01cc
        L_0x01f9:
            double r7 = d(r8, r9)
            java.lang.Double r2 = java.lang.Double.valueOf(r7)
            goto L_0x01d7
        L_0x0202:
            boolean r7 = r12.d()
            if (r7 == 0) goto L_0x020e
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.b
            r0.a(r7, r2)
            goto L_0x0234
        L_0x020e:
            int[] r7 = androidx.datastore.preferences.protobuf.ArrayDecoders.AnonymousClass1.f1051a
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r8 = r12.a()
            int r8 = r8.ordinal()
            r7 = r7[r8]
            r8 = 17
            if (r7 == r8) goto L_0x0223
            r8 = 18
            if (r7 == r8) goto L_0x0223
            goto L_0x022f
        L_0x0223:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.b
            java.lang.Object r7 = r0.h(r7)
            if (r7 == 0) goto L_0x022f
            java.lang.Object r2 = androidx.datastore.preferences.protobuf.Internal.h(r7, r2)
        L_0x022f:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.b
            r0.w(r7, r2)
        L_0x0234:
            r8 = r9
        L_0x0235:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.f(int, byte[], int, int, androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage, androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension, androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    public static int g(int i, byte[] bArr, int i2, int i3, Object obj, MessageLite messageLite, UnknownFieldSchema unknownFieldSchema, Registers registers) {
        GeneratedMessageLite.GeneratedExtension a2 = registers.d.a(messageLite, i >>> 3);
        if (a2 == null) {
            return G(i, bArr, i2, i3, MessageSchema.p(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.C();
        return f(i, bArr, i2, i3, extendableMessage, a2, unknownFieldSchema, registers);
    }

    public static int h(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int i(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.addInt(h(bArr, i2));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int I = I(bArr, i4, registers);
            if (i != registers.f1052a) {
                break;
            }
            intArrayList.addInt(h(bArr, I));
            i4 = I + 4;
        }
        return i4;
    }

    public static long j(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static int k(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.addLong(j(bArr, i2));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int I = I(bArr, i4, registers);
            if (i != registers.f1052a) {
                break;
            }
            longArrayList.addLong(j(bArr, I));
            i4 = I + 8;
        }
        return i4;
    }

    public static float l(byte[] bArr, int i) {
        return Float.intBitsToFloat(h(bArr, i));
    }

    public static int m(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.addFloat(l(bArr, i2));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int I = I(bArr, i4, registers);
            if (i != registers.f1052a) {
                break;
            }
            floatArrayList.addFloat(l(bArr, I));
            i4 = I + 4;
        }
        return i4;
    }

    public static int n(Schema schema, byte[] bArr, int i, int i2, int i3, Registers registers) {
        MessageSchema messageSchema = (MessageSchema) schema;
        Object newInstance = messageSchema.newInstance();
        int W = messageSchema.W(newInstance, bArr, i, i2, i3, registers);
        messageSchema.makeImmutable(newInstance);
        registers.c = newInstance;
        return W;
    }

    public static int o(Schema schema, int i, byte[] bArr, int i2, int i3, Internal.ProtobufList protobufList, Registers registers) {
        int i4 = (i & -8) | 4;
        int n = n(schema, bArr, i2, i3, i4, registers);
        protobufList.add(registers.c);
        while (n < i3) {
            int I = I(bArr, n, registers);
            if (i != registers.f1052a) {
                break;
            }
            n = n(schema, bArr, I, i3, i4, registers);
            protobufList.add(registers.c);
        }
        return n;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int p(androidx.datastore.preferences.protobuf.Schema r6, byte[] r7, int r8, int r9, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r10) {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = H(r8, r7, r0, r10)
            int r8 = r10.f1052a
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.c(r1, r2, r3, r4, r5)
            r6.makeImmutable(r9)
            r10.c = r9
            return r8
        L_0x0025:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r6 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.p(androidx.datastore.preferences.protobuf.Schema, byte[], int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    public static int q(Schema schema, int i, byte[] bArr, int i2, int i3, Internal.ProtobufList protobufList, Registers registers) {
        int p = p(schema, bArr, i2, i3, registers);
        protobufList.add(registers.c);
        while (p < i3) {
            int I = I(bArr, p, registers);
            if (i != registers.f1052a) {
                break;
            }
            p = p(schema, bArr, I, i3, registers);
            protobufList.add(registers.c);
        }
        return p;
    }

    public static int r(byte[] bArr, int i, Internal.ProtobufList protobufList, Registers registers) {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int I = I(bArr, i, registers);
        int i2 = registers.f1052a + I;
        while (I < i2) {
            I = L(bArr, I, registers);
            booleanArrayList.addBoolean(registers.b != 0);
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int s(byte[] bArr, int i, Internal.ProtobufList protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int I = I(bArr, i, registers);
        int i2 = registers.f1052a + I;
        while (I < i2) {
            doubleArrayList.addDouble(d(bArr, I));
            I += 8;
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int t(byte[] bArr, int i, Internal.ProtobufList protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i, registers);
        int i2 = registers.f1052a + I;
        while (I < i2) {
            intArrayList.addInt(h(bArr, I));
            I += 4;
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int u(byte[] bArr, int i, Internal.ProtobufList protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i, registers);
        int i2 = registers.f1052a + I;
        while (I < i2) {
            longArrayList.addLong(j(bArr, I));
            I += 8;
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int v(byte[] bArr, int i, Internal.ProtobufList protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int I = I(bArr, i, registers);
        int i2 = registers.f1052a + I;
        while (I < i2) {
            floatArrayList.addFloat(l(bArr, I));
            I += 4;
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int w(byte[] bArr, int i, Internal.ProtobufList protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i, registers);
        int i2 = registers.f1052a + I;
        while (I < i2) {
            I = I(bArr, I, registers);
            intArrayList.addInt(CodedInputStream.b(registers.f1052a));
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int x(byte[] bArr, int i, Internal.ProtobufList protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i, registers);
        int i2 = registers.f1052a + I;
        while (I < i2) {
            I = L(bArr, I, registers);
            longArrayList.addLong(CodedInputStream.c(registers.b));
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int y(byte[] bArr, int i, Internal.ProtobufList protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i, registers);
        int i2 = registers.f1052a + I;
        while (I < i2) {
            I = I(bArr, I, registers);
            intArrayList.addInt(registers.f1052a);
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int z(byte[] bArr, int i, Internal.ProtobufList protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i, registers);
        int i2 = registers.f1052a + I;
        while (I < i2) {
            I = L(bArr, I, registers);
            longArrayList.addLong(registers.b);
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
}
