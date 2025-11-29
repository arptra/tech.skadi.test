package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

final class CodedOutputStreamWriter implements Writer {

    /* renamed from: a  reason: collision with root package name */
    public final CodedOutputStream f1069a;

    /* renamed from: androidx.datastore.preferences.protobuf.CodedOutputStreamWriter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1070a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1070a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1070a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1070a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1070a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1070a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f1070a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f1070a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f1070a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f1070a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f1070a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f1070a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f1070a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedOutputStreamWriter.AnonymousClass1.<clinit>():void");
        }
    }

    public CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.b(codedOutputStream, "output");
        this.f1069a = codedOutputStream2;
        codedOutputStream2.f1068a = this;
    }

    public static CodedOutputStreamWriter g(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.f1068a;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private void m(int i, Object obj) {
        if (obj instanceof String) {
            this.f1069a.writeString(i, (String) obj);
        } else {
            this.f1069a.a(i, (ByteString) obj);
        }
    }

    public void a(int i, ByteString byteString) {
        this.f1069a.a(i, byteString);
    }

    public void b(int i, Object obj, Schema schema) {
        this.f1069a.I0(i, (MessageLite) obj, schema);
    }

    public void c(int i, MapEntryLite.Metadata metadata, Map map) {
        if (this.f1069a.m0()) {
            k(i, metadata, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f1069a.R0(i, 2);
            this.f1069a.S0(MapEntryLite.b(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.e(this.f1069a, metadata, entry.getKey(), entry.getValue());
        }
    }

    public void d(int i, List list, Schema schema) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            e(i, list.get(i2), schema);
        }
    }

    public void e(int i, Object obj, Schema schema) {
        this.f1069a.C0(i, (MessageLite) obj, schema);
    }

    public void f(int i, List list, Schema schema) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, list.get(i2), schema);
        }
    }

    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public final void h(int i, boolean z, Object obj, MapEntryLite.Metadata metadata) {
        this.f1069a.R0(i, 2);
        this.f1069a.S0(MapEntryLite.b(metadata, Boolean.valueOf(z), obj));
        MapEntryLite.e(this.f1069a, metadata, Boolean.valueOf(z), obj);
    }

    public final void i(int i, MapEntryLite.Metadata metadata, Map map) {
        int size = map.size();
        int[] iArr = new int[size];
        int i2 = 0;
        for (Integer intValue : map.keySet()) {
            iArr[i2] = intValue.intValue();
            i2++;
        }
        Arrays.sort(iArr);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            Object obj = map.get(Integer.valueOf(i4));
            this.f1069a.R0(i, 2);
            this.f1069a.S0(MapEntryLite.b(metadata, Integer.valueOf(i4), obj));
            MapEntryLite.e(this.f1069a, metadata, Integer.valueOf(i4), obj);
        }
    }

    public final void j(int i, MapEntryLite.Metadata metadata, Map map) {
        int size = map.size();
        long[] jArr = new long[size];
        int i2 = 0;
        for (Long longValue : map.keySet()) {
            jArr[i2] = longValue.longValue();
            i2++;
        }
        Arrays.sort(jArr);
        for (int i3 = 0; i3 < size; i3++) {
            long j = jArr[i3];
            Object obj = map.get(Long.valueOf(j));
            this.f1069a.R0(i, 2);
            this.f1069a.S0(MapEntryLite.b(metadata, Long.valueOf(j), obj));
            MapEntryLite.e(this.f1069a, metadata, Long.valueOf(j), obj);
        }
    }

    public final void k(int i, MapEntryLite.Metadata metadata, Map map) {
        switch (AnonymousClass1.f1070a[metadata.f1117a.ordinal()]) {
            case 1:
                Object obj = map.get(Boolean.FALSE);
                if (obj != null) {
                    h(i, false, obj, metadata);
                }
                Object obj2 = map.get(Boolean.TRUE);
                if (obj2 != null) {
                    h(i, true, obj2, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                i(i, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                j(i, metadata, map);
                return;
            case 12:
                l(i, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.f1117a);
        }
    }

    public final void l(int i, MapEntryLite.Metadata metadata, Map map) {
        int size = map.size();
        String[] strArr = new String[size];
        int i2 = 0;
        for (String str : map.keySet()) {
            strArr[i2] = str;
            i2++;
        }
        Arrays.sort(strArr);
        for (int i3 = 0; i3 < size; i3++) {
            String str2 = strArr[i3];
            Object obj = map.get(str2);
            this.f1069a.R0(i, 2);
            this.f1069a.S0(MapEntryLite.b(metadata, str2, obj));
            MapEntryLite.e(this.f1069a, metadata, str2, obj);
        }
    }

    public void writeBool(int i, boolean z) {
        this.f1069a.writeBool(i, z);
    }

    public void writeBoolList(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.m(((Boolean) list.get(i4)).booleanValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.s0(((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeBool(i, ((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    public void writeBytesList(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f1069a.a(i, (ByteString) list.get(i2));
        }
    }

    public void writeDouble(int i, double d) {
        this.f1069a.writeDouble(i, d);
    }

    public void writeDoubleList(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.r(((Double) list.get(i4)).doubleValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.w0(((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeDouble(i, ((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    public void writeEndGroup(int i) {
        this.f1069a.R0(i, 4);
    }

    public void writeEnum(int i, int i2) {
        this.f1069a.writeEnum(i, i2);
    }

    public void writeEnumList(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.t(((Integer) list.get(i4)).intValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.x0(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeEnum(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public void writeFixed32(int i, int i2) {
        this.f1069a.writeFixed32(i, i2);
    }

    public void writeFixed32List(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.v(((Integer) list.get(i4)).intValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.y0(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeFixed32(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public void writeFixed64(int i, long j) {
        this.f1069a.writeFixed64(i, j);
    }

    public void writeFixed64List(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.x(((Long) list.get(i4)).longValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.z0(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeFixed64(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public void writeFloat(int i, float f) {
        this.f1069a.writeFloat(i, f);
    }

    public void writeFloatList(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.z(((Float) list.get(i4)).floatValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.A0(((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeFloat(i, ((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    public void writeInt32(int i, int i2) {
        this.f1069a.writeInt32(i, i2);
    }

    public void writeInt32List(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.E(((Integer) list.get(i4)).intValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.F0(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeInt32(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public void writeInt64(int i, long j) {
        this.f1069a.writeInt64(i, j);
    }

    public void writeInt64List(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.G(((Long) list.get(i4)).longValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.G0(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeInt64(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public void writeMessage(int i, Object obj) {
        this.f1069a.H0(i, (MessageLite) obj);
    }

    public final void writeMessageSetItem(int i, Object obj) {
        if (obj instanceof ByteString) {
            this.f1069a.L0(i, (ByteString) obj);
        } else {
            this.f1069a.K0(i, (MessageLite) obj);
        }
    }

    public void writeSFixed32(int i, int i2) {
        this.f1069a.writeSFixed32(i, i2);
    }

    public void writeSFixed32List(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.U(((Integer) list.get(i4)).intValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.M0(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeSFixed32(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public void writeSFixed64(int i, long j) {
        this.f1069a.writeSFixed64(i, j);
    }

    public void writeSFixed64List(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.W(((Long) list.get(i4)).longValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.N0(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeSFixed64(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public void writeSInt32(int i, int i2) {
        this.f1069a.writeSInt32(i, i2);
    }

    public void writeSInt32List(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.Y(((Integer) list.get(i4)).intValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.O0(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeSInt32(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public void writeSInt64(int i, long j) {
        this.f1069a.writeSInt64(i, j);
    }

    public void writeSInt64List(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.a0(((Long) list.get(i4)).longValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.P0(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeSInt64(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public void writeStartGroup(int i) {
        this.f1069a.R0(i, 3);
    }

    public void writeString(int i, String str) {
        this.f1069a.writeString(i, str);
    }

    public void writeStringList(int i, List list) {
        int i2 = 0;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i2 < list.size()) {
                m(i, lazyStringList.getRaw(i2));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeString(i, (String) list.get(i2));
            i2++;
        }
    }

    public void writeUInt32(int i, int i2) {
        this.f1069a.writeUInt32(i, i2);
    }

    public void writeUInt32List(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.f0(((Integer) list.get(i4)).intValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.S0(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeUInt32(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public void writeUInt64(int i, long j) {
        this.f1069a.writeUInt64(i, j);
    }

    public void writeUInt64List(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1069a.R0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.h0(((Long) list.get(i4)).longValue());
            }
            this.f1069a.S0(i3);
            while (i2 < list.size()) {
                this.f1069a.T0(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1069a.writeUInt64(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }
}
