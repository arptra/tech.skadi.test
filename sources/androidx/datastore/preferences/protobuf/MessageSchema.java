package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.upuphone.runasone.uupcast.CaptureType;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class MessageSchema<T> implements Schema<T> {
    public static final int[] r = new int[0];
    public static final Unsafe s = UnsafeUtil.G();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f1119a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final MessageLite e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int[] j;
    public final int k;
    public final int l;
    public final NewInstanceSchema m;
    public final ListFieldSchema n;
    public final UnknownFieldSchema o;
    public final ExtensionSchema p;
    public final MapFieldSchema q;

    /* renamed from: androidx.datastore.preferences.protobuf.MessageSchema$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1120a;

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
                f1120a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f1120a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.AnonymousClass1.<clinit>():void");
        }
    }

    public MessageSchema(int[] iArr, Object[] objArr, int i2, int i3, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i4, int i5, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        this.f1119a = iArr;
        this.b = objArr;
        this.c = i2;
        this.d = i3;
        this.g = messageLite instanceof GeneratedMessageLite;
        this.h = z;
        this.f = extensionSchema != null && extensionSchema.e(messageLite);
        this.i = z2;
        this.j = iArr2;
        this.k = i4;
        this.l = i5;
        this.m = newInstanceSchema;
        this.n = listFieldSchema;
        this.o = unknownFieldSchema;
        this.p = extensionSchema;
        this.e = messageLite;
        this.q = mapFieldSchema;
    }

    public static boolean C(int i2) {
        return (i2 & CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED) != 0;
    }

    public static List D(Object obj, long j2) {
        return (List) UnsafeUtil.F(obj, j2);
    }

    public static long E(Object obj, long j2) {
        return UnsafeUtil.D(obj, j2);
    }

    public static MessageSchema K(Class cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? M((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : L((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    public static MessageSchema L(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        int i2;
        int i3;
        int i4;
        boolean z = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] b2 = structuralMessageInfo.b();
        if (b2.length == 0) {
            i3 = 0;
            i2 = 0;
        } else {
            i3 = b2[0].h();
            i2 = b2[b2.length - 1].h();
        }
        int length = b2.length;
        int[] iArr = new int[(length * 3)];
        Object[] objArr = new Object[(length * 2)];
        int i5 = 0;
        int i6 = 0;
        for (FieldInfo fieldInfo : b2) {
            if (fieldInfo.n() == FieldType.MAP) {
                i5++;
            } else if (fieldInfo.n().id() >= 18 && fieldInfo.n().id() <= 49) {
                i6++;
            }
        }
        int[] iArr2 = null;
        int[] iArr3 = i5 > 0 ? new int[i5] : null;
        if (i6 > 0) {
            iArr2 = new int[i6];
        }
        int[] a2 = structuralMessageInfo.a();
        if (a2 == null) {
            a2 = r;
        }
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i7 < b2.length) {
            FieldInfo fieldInfo2 = b2[i7];
            int h2 = fieldInfo2.h();
            k0(fieldInfo2, iArr, i8, z, objArr);
            if (i9 < a2.length && a2[i9] == h2) {
                a2[i9] = i8;
                i9++;
            }
            if (fieldInfo2.n() == FieldType.MAP) {
                iArr3[i10] = i8;
                i10++;
            } else if (fieldInfo2.n().id() >= 18 && fieldInfo2.n().id() <= 49) {
                i4 = i8;
                iArr2[i11] = (int) UnsafeUtil.J(fieldInfo2.g());
                i11++;
                i7++;
                i8 = i4 + 3;
            }
            i4 = i8;
            i7++;
            i8 = i4 + 3;
        }
        if (iArr3 == null) {
            iArr3 = r;
        }
        if (iArr2 == null) {
            iArr2 = r;
        }
        int[] iArr4 = new int[(a2.length + iArr3.length + iArr2.length)];
        System.arraycopy(a2, 0, iArr4, 0, a2.length);
        System.arraycopy(iArr3, 0, iArr4, a2.length, iArr3.length);
        System.arraycopy(iArr2, 0, iArr4, a2.length + iArr3.length, iArr2.length);
        return new MessageSchema(iArr, objArr, i3, i2, structuralMessageInfo.getDefaultInstance(), z, true, iArr4, a2.length, a2.length + iArr3.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0353  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x03a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.datastore.preferences.protobuf.MessageSchema M(androidx.datastore.preferences.protobuf.RawMessageInfo r35, androidx.datastore.preferences.protobuf.NewInstanceSchema r36, androidx.datastore.preferences.protobuf.ListFieldSchema r37, androidx.datastore.preferences.protobuf.UnknownFieldSchema r38, androidx.datastore.preferences.protobuf.ExtensionSchema r39, androidx.datastore.preferences.protobuf.MapFieldSchema r40) {
        /*
            androidx.datastore.preferences.protobuf.ProtoSyntax r0 = r35.getSyntax()
            androidx.datastore.preferences.protobuf.ProtoSyntax r1 = androidx.datastore.preferences.protobuf.ProtoSyntax.PROTO3
            r2 = 0
            if (r0 != r1) goto L_0x000b
            r10 = 1
            goto L_0x000c
        L_0x000b:
            r10 = r2
        L_0x000c:
            java.lang.String r0 = r35.b()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r6) goto L_0x0035
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r7 = 1
            r8 = 13
        L_0x0022:
            int r9 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0032
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r8
            r4 = r4 | r7
            int r8 = r8 + 13
            r7 = r9
            goto L_0x0022
        L_0x0032:
            int r7 = r7 << r8
            r4 = r4 | r7
            goto L_0x0036
        L_0x0035:
            r9 = 1
        L_0x0036:
            int r7 = r9 + 1
            char r8 = r0.charAt(r9)
            if (r8 < r6) goto L_0x0055
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0042:
            int r11 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0052
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r8 = r8 | r7
            int r9 = r9 + 13
            r7 = r11
            goto L_0x0042
        L_0x0052:
            int r7 = r7 << r9
            r8 = r8 | r7
            r7 = r11
        L_0x0055:
            if (r8 != 0) goto L_0x0062
            int[] r8 = r
            r9 = r2
            r11 = r9
            r12 = r11
            r14 = r12
            r15 = r14
            r13 = r8
            r8 = r15
            goto L_0x0177
        L_0x0062:
            int r8 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0081
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x006e:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r6) goto L_0x007e
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r7 = r7 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x006e
        L_0x007e:
            int r8 = r8 << r9
            r7 = r7 | r8
            r8 = r11
        L_0x0081:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r6) goto L_0x00a0
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x008d:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r6) goto L_0x009d
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x008d
        L_0x009d:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00a0:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r6) goto L_0x00bf
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00ac:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r6) goto L_0x00bc
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00ac
        L_0x00bc:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00bf:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r6) goto L_0x00de
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00cb:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r6) goto L_0x00db
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00cb
        L_0x00db:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00de:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r6) goto L_0x00fd
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00ea:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r6) goto L_0x00fa
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00ea
        L_0x00fa:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00fd:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r6) goto L_0x011e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0109:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r6) goto L_0x011a
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x0109
        L_0x011a:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x011e:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r6) goto L_0x0141
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x012a:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r6) goto L_0x013c
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x012a
        L_0x013c:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0141:
            int r16 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r6) goto L_0x0166
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r2 = r16
            r16 = 13
        L_0x014f:
            int r18 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r6) goto L_0x0161
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r16
            r15 = r15 | r2
            int r16 = r16 + 13
            r2 = r18
            goto L_0x014f
        L_0x0161:
            int r2 = r2 << r16
            r15 = r15 | r2
            r16 = r18
        L_0x0166:
            int r2 = r15 + r13
            int r2 = r2 + r14
            int[] r2 = new int[r2]
            int r14 = r7 * 2
            int r14 = r14 + r8
            r8 = r7
            r7 = r16
            r34 = r13
            r13 = r2
            r2 = r9
            r9 = r34
        L_0x0177:
            sun.misc.Unsafe r5 = s
            java.lang.Object[] r18 = r35.a()
            androidx.datastore.preferences.protobuf.MessageLite r19 = r35.getDefaultInstance()
            java.lang.Class r3 = r19.getClass()
            int r6 = r12 * 3
            int[] r6 = new int[r6]
            int r12 = r12 * 2
            java.lang.Object[] r12 = new java.lang.Object[r12]
            int r21 = r15 + r9
            r23 = r15
            r24 = r21
            r9 = 0
            r22 = 0
        L_0x0196:
            if (r7 >= r1) goto L_0x03f2
            int r25 = r7 + 1
            char r7 = r0.charAt(r7)
            r26 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r1) goto L_0x01ca
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r1 = r25
            r25 = 13
        L_0x01ab:
            int r27 = r1 + 1
            char r1 = r0.charAt(r1)
            r28 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r15) goto L_0x01c4
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r25
            r7 = r7 | r1
            int r25 = r25 + 13
            r1 = r27
            r15 = r28
            goto L_0x01ab
        L_0x01c4:
            int r1 = r1 << r25
            r7 = r7 | r1
            r1 = r27
            goto L_0x01ce
        L_0x01ca:
            r28 = r15
            r1 = r25
        L_0x01ce:
            int r15 = r1 + 1
            char r1 = r0.charAt(r1)
            r25 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r15) goto L_0x0200
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r15 = r25
            r25 = 13
        L_0x01e1:
            int r27 = r15 + 1
            char r15 = r0.charAt(r15)
            r29 = r10
            r10 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r10) goto L_0x01fa
            r10 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r25
            r1 = r1 | r10
            int r25 = r25 + 13
            r15 = r27
            r10 = r29
            goto L_0x01e1
        L_0x01fa:
            int r10 = r15 << r25
            r1 = r1 | r10
            r15 = r27
            goto L_0x0204
        L_0x0200:
            r29 = r10
            r15 = r25
        L_0x0204:
            r10 = r1 & 255(0xff, float:3.57E-43)
            r25 = r11
            r11 = r1 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0211
            int r11 = r9 + 1
            r13[r9] = r22
            r9 = r11
        L_0x0211:
            r11 = 51
            r31 = r9
            if (r10 < r11) goto L_0x02b6
            int r11 = r15 + 1
            char r15 = r0.charAt(r15)
            r9 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r9) goto L_0x0240
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r32 = 13
        L_0x0226:
            int r33 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r9) goto L_0x023b
            r9 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r32
            r15 = r15 | r9
            int r32 = r32 + 13
            r11 = r33
            r9 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0226
        L_0x023b:
            int r9 = r11 << r32
            r15 = r15 | r9
            r11 = r33
        L_0x0240:
            int r9 = r10 + -51
            r32 = r11
            r11 = 9
            if (r9 == r11) goto L_0x0263
            r11 = 17
            if (r9 != r11) goto L_0x024d
            goto L_0x0263
        L_0x024d:
            r11 = 12
            if (r9 != r11) goto L_0x0270
            r9 = r4 & 1
            r11 = 1
            if (r9 != r11) goto L_0x0270
            int r9 = r22 / 3
            int r9 = r9 * 2
            int r9 = r9 + r11
            int r11 = r14 + 1
            r14 = r18[r14]
            r12[r9] = r14
        L_0x0261:
            r14 = r11
            goto L_0x0270
        L_0x0263:
            int r9 = r22 / 3
            int r9 = r9 * 2
            r11 = 1
            int r9 = r9 + r11
            int r11 = r14 + 1
            r14 = r18[r14]
            r12[r9] = r14
            goto L_0x0261
        L_0x0270:
            int r15 = r15 * 2
            r9 = r18[r15]
            boolean r11 = r9 instanceof java.lang.reflect.Field
            if (r11 == 0) goto L_0x027e
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
        L_0x027a:
            r11 = r6
            r33 = r7
            goto L_0x0287
        L_0x027e:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = g0(r3, r9)
            r18[r15] = r9
            goto L_0x027a
        L_0x0287:
            long r6 = r5.objectFieldOffset(r9)
            int r6 = (int) r6
            int r15 = r15 + 1
            r7 = r18[r15]
            boolean r9 = r7 instanceof java.lang.reflect.Field
            if (r9 == 0) goto L_0x0298
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
        L_0x0296:
            r9 = r6
            goto L_0x02a1
        L_0x0298:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = g0(r3, r7)
            r18[r15] = r7
            goto L_0x0296
        L_0x02a1:
            long r6 = r5.objectFieldOffset(r7)
            int r6 = (int) r6
            r27 = r2
            r19 = r4
            r4 = r6
            r6 = r9
            r2 = r14
            r7 = r32
            r14 = 0
            r9 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            goto L_0x03bb
        L_0x02b6:
            r11 = r6
            r33 = r7
            int r6 = r14 + 1
            r7 = r18[r14]
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = g0(r3, r7)
            r9 = 9
            if (r10 == r9) goto L_0x02cb
            r9 = 17
            if (r10 != r9) goto L_0x02d0
        L_0x02cb:
            r27 = r2
            r2 = 1
            goto L_0x0339
        L_0x02d0:
            r9 = 27
            if (r10 == r9) goto L_0x02d8
            r9 = 49
            if (r10 != r9) goto L_0x02dc
        L_0x02d8:
            r27 = r2
            r2 = 1
            goto L_0x032d
        L_0x02dc:
            r9 = 12
            if (r10 == r9) goto L_0x0318
            r9 = 30
            if (r10 == r9) goto L_0x0318
            r9 = 44
            if (r10 != r9) goto L_0x02e9
            goto L_0x0318
        L_0x02e9:
            r9 = 50
            if (r10 != r9) goto L_0x0314
            int r9 = r23 + 1
            r13[r23] = r22
            int r23 = r22 / 3
            int r23 = r23 * 2
            int r27 = r14 + 2
            r6 = r18[r6]
            r12[r23] = r6
            r6 = r1 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x030d
            int r23 = r23 + 1
            int r6 = r14 + 3
            r14 = r18[r27]
            r12[r23] = r14
            r27 = r2
            r23 = r9
        L_0x030b:
            r9 = r3
            goto L_0x0345
        L_0x030d:
            r23 = r9
            r6 = r27
            r27 = r2
            goto L_0x030b
        L_0x0314:
            r27 = r2
            r2 = 1
            goto L_0x030b
        L_0x0318:
            r9 = r4 & 1
            r27 = r2
            r2 = 1
            if (r9 != r2) goto L_0x030b
            int r9 = r22 / 3
            int r9 = r9 * 2
            int r9 = r9 + r2
            int r14 = r14 + 2
            r6 = r18[r6]
            r12[r9] = r6
        L_0x032a:
            r9 = r3
            r6 = r14
            goto L_0x0345
        L_0x032d:
            int r9 = r22 / 3
            int r9 = r9 * 2
            int r9 = r9 + r2
            int r14 = r14 + 2
            r6 = r18[r6]
            r12[r9] = r6
            goto L_0x032a
        L_0x0339:
            int r9 = r22 / 3
            int r9 = r9 * 2
            int r9 = r9 + r2
            java.lang.Class r14 = r7.getType()
            r12[r9] = r14
            goto L_0x030b
        L_0x0345:
            long r2 = r5.objectFieldOffset(r7)
            int r2 = (int) r2
            r3 = r4 & 1
            r7 = 1
            if (r3 != r7) goto L_0x03a0
            r3 = 17
            if (r10 > r3) goto L_0x03a0
            int r3 = r15 + 1
            char r14 = r0.charAt(r15)
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r15) goto L_0x0379
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r19 = 13
        L_0x0362:
            int r20 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r15) goto L_0x0374
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r19
            r14 = r14 | r3
            int r19 = r19 + 13
            r3 = r20
            goto L_0x0362
        L_0x0374:
            int r3 = r3 << r19
            r14 = r14 | r3
            r3 = r20
        L_0x0379:
            int r19 = r8 * 2
            int r20 = r14 / 32
            int r19 = r19 + r20
            r7 = r18[r19]
            boolean r15 = r7 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x038b
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
        L_0x0387:
            r15 = r3
            r19 = r4
            goto L_0x0394
        L_0x038b:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = g0(r9, r7)
            r18[r19] = r7
            goto L_0x0387
        L_0x0394:
            long r3 = r5.objectFieldOffset(r7)
            int r3 = (int) r3
            int r14 = r14 % 32
            r4 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            goto L_0x03a7
        L_0x03a0:
            r19 = r4
            r3 = 55296(0xd800, float:7.7486E-41)
            r4 = 0
            r14 = 0
        L_0x03a7:
            r7 = 18
            if (r10 < r7) goto L_0x03b5
            r7 = 49
            if (r10 > r7) goto L_0x03b5
            int r7 = r24 + 1
            r13[r24] = r2
            r24 = r7
        L_0x03b5:
            r7 = r15
            r34 = r6
            r6 = r2
            r2 = r34
        L_0x03bb:
            int r15 = r22 + 1
            r11[r22] = r33
            int r30 = r22 + 2
            r3 = r1 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x03c8
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03c9
        L_0x03c8:
            r3 = 0
        L_0x03c9:
            r1 = r1 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x03d0
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03d1
        L_0x03d0:
            r1 = 0
        L_0x03d1:
            r1 = r1 | r3
            int r3 = r10 << 20
            r1 = r1 | r3
            r1 = r1 | r6
            r11[r15] = r1
            int r22 = r22 + 3
            int r1 = r14 << 20
            r1 = r1 | r4
            r11[r30] = r1
            r14 = r2
            r3 = r9
            r6 = r11
            r4 = r19
            r11 = r25
            r1 = r26
            r2 = r27
            r15 = r28
            r10 = r29
            r9 = r31
            goto L_0x0196
        L_0x03f2:
            r27 = r2
            r29 = r10
            r25 = r11
            r28 = r15
            r11 = r6
            androidx.datastore.preferences.protobuf.MessageSchema r0 = new androidx.datastore.preferences.protobuf.MessageSchema
            androidx.datastore.preferences.protobuf.MessageLite r9 = r35.getDefaultInstance()
            r1 = 0
            r4 = r0
            r5 = r11
            r6 = r12
            r7 = r27
            r8 = r25
            r11 = r1
            r12 = r13
            r13 = r28
            r14 = r21
            r15 = r36
            r16 = r37
            r17 = r38
            r18 = r39
            r19 = r40
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.M(androidx.datastore.preferences.protobuf.RawMessageInfo, androidx.datastore.preferences.protobuf.NewInstanceSchema, androidx.datastore.preferences.protobuf.ListFieldSchema, androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, androidx.datastore.preferences.protobuf.MapFieldSchema):androidx.datastore.preferences.protobuf.MessageSchema");
    }

    public static long O(int i2) {
        return (long) (i2 & 1048575);
    }

    public static boolean P(Object obj, long j2) {
        return ((Boolean) UnsafeUtil.F(obj, j2)).booleanValue();
    }

    public static double Q(Object obj, long j2) {
        return ((Double) UnsafeUtil.F(obj, j2)).doubleValue();
    }

    public static float R(Object obj, long j2) {
        return ((Float) UnsafeUtil.F(obj, j2)).floatValue();
    }

    public static int S(Object obj, long j2) {
        return ((Integer) UnsafeUtil.F(obj, j2)).intValue();
    }

    public static long T(Object obj, long j2) {
        return ((Long) UnsafeUtil.F(obj, j2)).longValue();
    }

    public static boolean e(Object obj, long j2) {
        return UnsafeUtil.s(obj, j2);
    }

    public static Field g0(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static double h(Object obj, long j2) {
        return UnsafeUtil.z(obj, j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void k0(androidx.datastore.preferences.protobuf.FieldInfo r8, int[] r9, int r10, boolean r11, java.lang.Object[] r12) {
        /*
            androidx.datastore.preferences.protobuf.OneofInfo r0 = r8.k()
            r1 = 0
            if (r0 == 0) goto L_0x0027
            androidx.datastore.preferences.protobuf.FieldType r11 = r8.n()
            int r11 = r11.id()
            int r11 = r11 + 51
            java.lang.reflect.Field r2 = r0.b()
            long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.J(r2)
            int r2 = (int) r2
            java.lang.reflect.Field r0 = r0.a()
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.J(r0)
            int r0 = (int) r3
        L_0x0023:
            r3 = r2
            r2 = r0
            r0 = r1
            goto L_0x0073
        L_0x0027:
            androidx.datastore.preferences.protobuf.FieldType r0 = r8.n()
            java.lang.reflect.Field r2 = r8.g()
            long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.J(r2)
            int r2 = (int) r2
            int r3 = r0.id()
            if (r11 != 0) goto L_0x005d
            boolean r11 = r0.isList()
            if (r11 != 0) goto L_0x005d
            boolean r11 = r0.isMap()
            if (r11 != 0) goto L_0x005d
            java.lang.reflect.Field r11 = r8.l()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.J(r11)
            int r0 = (int) r4
            int r11 = r8.m()
            int r11 = java.lang.Integer.numberOfTrailingZeros(r11)
            r7 = r0
            r0 = r11
            r11 = r3
            r3 = r2
            r2 = r7
            goto L_0x0073
        L_0x005d:
            java.lang.reflect.Field r11 = r8.d()
            if (r11 != 0) goto L_0x0068
            r0 = r1
            r11 = r3
            r3 = r2
            r2 = r0
            goto L_0x0073
        L_0x0068:
            java.lang.reflect.Field r11 = r8.d()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.J(r11)
            int r0 = (int) r4
            r11 = r3
            goto L_0x0023
        L_0x0073:
            int r4 = r8.h()
            r9[r10] = r4
            int r4 = r10 + 1
            boolean r5 = r8.o()
            if (r5 == 0) goto L_0x0084
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0085
        L_0x0084:
            r5 = r1
        L_0x0085:
            boolean r6 = r8.p()
            if (r6 == 0) goto L_0x008d
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x008d:
            r1 = r1 | r5
            int r11 = r11 << 20
            r11 = r11 | r1
            r11 = r11 | r3
            r9[r4] = r11
            int r11 = r10 + 2
            int r0 = r0 << 20
            r0 = r0 | r2
            r9[r11] = r0
            java.lang.Class r9 = r8.j()
            java.lang.Object r11 = r8.i()
            if (r11 == 0) goto L_0x00c5
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r11 = r8.i()
            r12[r10] = r11
            if (r9 == 0) goto L_0x00b6
            int r10 = r10 + 1
            r12[r10] = r9
            goto L_0x00e2
        L_0x00b6:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.f()
            if (r9 == 0) goto L_0x00e2
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.f()
            r12[r10] = r8
            goto L_0x00e2
        L_0x00c5:
            if (r9 == 0) goto L_0x00d0
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r12[r10] = r9
            goto L_0x00e2
        L_0x00d0:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.f()
            if (r9 == 0) goto L_0x00e2
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.f()
            r12[r10] = r8
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.k0(androidx.datastore.preferences.protobuf.FieldInfo, int[], int, boolean, java.lang.Object[]):void");
    }

    public static float l(Object obj, long j2) {
        return UnsafeUtil.A(obj, j2);
    }

    public static int l0(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    public static UnknownFieldSetLite p(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.e()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite l2 = UnknownFieldSetLite.l();
        generatedMessageLite.unknownFields = l2;
        return l2;
    }

    public static int t(Object obj, long j2) {
        return UnsafeUtil.B(obj, j2);
    }

    public static boolean u(int i2) {
        return (i2 & 536870912) != 0;
    }

    public static boolean x(Object obj, int i2, Schema schema) {
        return schema.isInitialized(UnsafeUtil.F(obj, O(i2)));
    }

    public final boolean A(Object obj, Object obj2, int i2) {
        long b0 = (long) (b0(i2) & 1048575);
        return UnsafeUtil.B(obj, b0) == UnsafeUtil.B(obj2, b0);
    }

    public final boolean B(Object obj, int i2, int i3) {
        return UnsafeUtil.B(obj, (long) (b0(i3) & 1048575)) == i2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:146:0x05cc */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x05d2 A[Catch:{ all -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x05ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void F(androidx.datastore.preferences.protobuf.UnknownFieldSchema r17, androidx.datastore.preferences.protobuf.ExtensionSchema r18, java.lang.Object r19, androidx.datastore.preferences.protobuf.Reader r20, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r21) {
        /*
            r16 = this;
            r8 = r16
            r9 = r17
            r10 = r19
            r0 = r20
            r11 = r21
            r12 = 0
            r13 = r12
            r14 = r13
        L_0x000d:
            int r1 = r20.getFieldNumber()     // Catch:{ all -> 0x004e }
            int r3 = r8.Z(r1)     // Catch:{ all -> 0x004e }
            if (r3 >= 0) goto L_0x0092
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0033
            int r0 = r8.k
        L_0x001e:
            int r1 = r8.l
            if (r0 >= r1) goto L_0x002d
            int[] r1 = r8.j
            r1 = r1[r0]
            java.lang.Object r13 = r8.j(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x001e
        L_0x002d:
            if (r13 == 0) goto L_0x0032
            r9.o(r10, r13)
        L_0x0032:
            return
        L_0x0033:
            boolean r2 = r8.f     // Catch:{ all -> 0x004e }
            if (r2 != 0) goto L_0x003b
            r15 = r18
            r3 = r12
            goto L_0x0044
        L_0x003b:
            androidx.datastore.preferences.protobuf.MessageLite r2 = r8.e     // Catch:{ all -> 0x004e }
            r15 = r18
            java.lang.Object r1 = r15.b(r11, r2, r1)     // Catch:{ all -> 0x004e }
            r3 = r1
        L_0x0044:
            if (r3 == 0) goto L_0x0060
            if (r14 != 0) goto L_0x0051
            androidx.datastore.preferences.protobuf.FieldSet r1 = r18.d(r19)     // Catch:{ all -> 0x004e }
            r14 = r1
            goto L_0x0051
        L_0x004e:
            r0 = move-exception
            goto L_0x0613
        L_0x0051:
            r1 = r18
            r2 = r20
            r4 = r21
            r5 = r14
            r6 = r13
            r7 = r17
            java.lang.Object r13 = r1.g(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x004e }
            goto L_0x000d
        L_0x0060:
            boolean r1 = r9.q(r0)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x006d
            boolean r1 = r20.skipField()     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x007b
            goto L_0x000d
        L_0x006d:
            if (r13 != 0) goto L_0x0074
            java.lang.Object r1 = r9.f(r10)     // Catch:{ all -> 0x004e }
            r13 = r1
        L_0x0074:
            boolean r1 = r9.m(r13, r0)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x007b
            goto L_0x000d
        L_0x007b:
            int r0 = r8.k
        L_0x007d:
            int r1 = r8.l
            if (r0 >= r1) goto L_0x008c
            int[] r1 = r8.j
            r1 = r1[r0]
            java.lang.Object r13 = r8.j(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x007d
        L_0x008c:
            if (r13 == 0) goto L_0x0091
            r9.o(r10, r13)
        L_0x0091:
            return
        L_0x0092:
            r15 = r18
            int r4 = r8.m0(r3)     // Catch:{ all -> 0x004e }
            int r2 = l0(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            switch(r2) {
                case 0: goto L_0x05bc;
                case 1: goto L_0x05ac;
                case 2: goto L_0x059c;
                case 3: goto L_0x058c;
                case 4: goto L_0x057c;
                case 5: goto L_0x056c;
                case 6: goto L_0x055c;
                case 7: goto L_0x054c;
                case 8: goto L_0x0544;
                case 9: goto L_0x050d;
                case 10: goto L_0x04fd;
                case 11: goto L_0x04ed;
                case 12: goto L_0x04ca;
                case 13: goto L_0x04ba;
                case 14: goto L_0x04aa;
                case 15: goto L_0x049a;
                case 16: goto L_0x048a;
                case 17: goto L_0x0453;
                case 18: goto L_0x0444;
                case 19: goto L_0x0435;
                case 20: goto L_0x0426;
                case 21: goto L_0x0417;
                case 22: goto L_0x0408;
                case 23: goto L_0x03f9;
                case 24: goto L_0x03ea;
                case 25: goto L_0x03db;
                case 26: goto L_0x03d6;
                case 27: goto L_0x03c4;
                case 28: goto L_0x03b5;
                case 29: goto L_0x03a6;
                case 30: goto L_0x038f;
                case 31: goto L_0x0380;
                case 32: goto L_0x0371;
                case 33: goto L_0x0362;
                case 34: goto L_0x0353;
                case 35: goto L_0x0344;
                case 36: goto L_0x0335;
                case 37: goto L_0x0326;
                case 38: goto L_0x0317;
                case 39: goto L_0x0308;
                case 40: goto L_0x02f9;
                case 41: goto L_0x02ea;
                case 42: goto L_0x02db;
                case 43: goto L_0x02cc;
                case 44: goto L_0x02b5;
                case 45: goto L_0x02a6;
                case 46: goto L_0x0297;
                case 47: goto L_0x0288;
                case 48: goto L_0x0279;
                case 49: goto L_0x0263;
                case 50: goto L_0x0252;
                case 51: goto L_0x023e;
                case 52: goto L_0x022a;
                case 53: goto L_0x0216;
                case 54: goto L_0x0202;
                case 55: goto L_0x01ee;
                case 56: goto L_0x01da;
                case 57: goto L_0x01c6;
                case 58: goto L_0x01b2;
                case 59: goto L_0x01aa;
                case 60: goto L_0x0171;
                case 61: goto L_0x0161;
                case 62: goto L_0x014d;
                case 63: goto L_0x0126;
                case 64: goto L_0x0112;
                case 65: goto L_0x00fe;
                case 66: goto L_0x00ea;
                case 67: goto L_0x00d6;
                case 68: goto L_0x00c2;
                default: goto L_0x009f;
            }     // Catch:{ InvalidWireTypeException -> 0x05cc }
        L_0x009f:
            if (r13 != 0) goto L_0x00a5
            java.lang.Object r13 = r17.n()     // Catch:{ InvalidWireTypeException -> 0x05cc }
        L_0x00a5:
            boolean r1 = r9.m(r13, r0)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.k
        L_0x00ad:
            int r1 = r8.l
            if (r0 >= r1) goto L_0x00bc
            int[] r1 = r8.j
            r1 = r1[r0]
            java.lang.Object r13 = r8.j(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x00ad
        L_0x00bc:
            if (r13 == 0) goto L_0x00c1
            r9.o(r10, r13)
        L_0x00c1:
            return
        L_0x00c2:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.Schema r2 = r8.o(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r2 = r0.a(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x00d6:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r6 = r20.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x00ea:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            int r2 = r20.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x00fe:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r6 = r20.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0112:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            int r2 = r20.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0126:
            int r2 = r20.readEnum()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r5 = r8.m(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            if (r5 == 0) goto L_0x013d
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            if (r5 == 0) goto L_0x0137
            goto L_0x013d
        L_0x0137:
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.SchemaUtil.L(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x013d:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x014d:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            int r2 = r20.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0161:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.ByteString r2 = r20.readBytes()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0171:
            boolean r2 = r8.B(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            if (r2 == 0) goto L_0x0193
            long r5 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r10, r5)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.Schema r5 = r8.o(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r5 = r0.c(r5, r11)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r2 = androidx.datastore.preferences.protobuf.Internal.h(r2, r5)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x01a5
        L_0x0193:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.Schema r2 = r8.o(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r2 = r0.c(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
        L_0x01a5:
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x01aa:
            r8.e0(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x01b2:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            boolean r2 = r20.readBool()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x01c6:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            int r2 = r20.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x01da:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r6 = r20.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x01ee:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            int r2 = r20.readInt32()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0202:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r6 = r20.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0216:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r6 = r20.readInt64()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x022a:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            float r2 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x023e:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            double r6 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Double r2 = java.lang.Double.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.i0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0252:
            java.lang.Object r4 = r8.n(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r1 = r16
            r2 = r19
            r5 = r21
            r6 = r20
            r1.G(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0263:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.Schema r6 = r8.o(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r1 = r16
            r2 = r19
            r3 = r4
            r5 = r20
            r7 = r21
            r1.c0(r2, r3, r5, r6, r7)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0279:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readSInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0288:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readSInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0297:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readSFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x02a6:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readSFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x02b5:
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r2 = r2.e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readEnumList(r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r3 = r8.m(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.SchemaUtil.A(r1, r2, r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x02cc:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x02db:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readBoolList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x02ea:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x02f9:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0308:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0317:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readUInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0326:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0335:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readFloatList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0344:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readDoubleList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0353:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readSInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0362:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readSInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0371:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readSFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0380:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readSFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x038f:
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r2 = r2.e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readEnumList(r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r3 = r8.m(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.SchemaUtil.A(r1, r2, r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x03a6:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x03b5:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readBytesList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x03c4:
            androidx.datastore.preferences.protobuf.Schema r5 = r8.o(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r1 = r16
            r2 = r19
            r3 = r4
            r4 = r20
            r6 = r21
            r1.d0(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x03d6:
            r8.f0(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x03db:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readBoolList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x03ea:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x03f9:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0408:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0417:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readUInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0426:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0435:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readFloatList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0444:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.n     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r0.readDoubleList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0453:
            boolean r1 = r8.v(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            if (r1 == 0) goto L_0x0476
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.Schema r2 = r8.o(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r2 = r0.a(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.h(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r2, r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0476:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.Schema r4 = r8.o(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r4 = r0.a(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x048a:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r4 = r20.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x049a:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            int r4 = r20.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x04aa:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r4 = r20.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x04ba:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            int r4 = r20.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x04ca:
            int r2 = r20.readEnum()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r5 = r8.m(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            if (r5 == 0) goto L_0x04e1
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            if (r5 == 0) goto L_0x04db
            goto L_0x04e1
        L_0x04db:
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.SchemaUtil.L(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x04e1:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.T(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x04ed:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            int r4 = r20.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x04fd:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.ByteString r4 = r20.readBytes()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x050d:
            boolean r1 = r8.v(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            if (r1 == 0) goto L_0x0530
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.Schema r2 = r8.o(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r2 = r0.c(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.h(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r2, r1)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0530:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.Schema r4 = r8.o(r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            java.lang.Object r4 = r0.c(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.V(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x0544:
            r8.e0(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x054c:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            boolean r4 = r20.readBool()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.K(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x055c:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            int r4 = r20.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x056c:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r4 = r20.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x057c:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            int r4 = r20.readInt32()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x058c:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r4 = r20.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x059c:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            long r4 = r20.readInt64()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x05ac:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            float r4 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.S(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x05bc:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            double r4 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05cc }
            androidx.datastore.preferences.protobuf.UnsafeUtil.R(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            r8.h0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cc }
            goto L_0x000d
        L_0x05cc:
            boolean r1 = r9.q(r0)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x05ef
            boolean r1 = r20.skipField()     // Catch:{ all -> 0x004e }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.k
        L_0x05da:
            int r1 = r8.l
            if (r0 >= r1) goto L_0x05e9
            int[] r1 = r8.j
            r1 = r1[r0]
            java.lang.Object r13 = r8.j(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05da
        L_0x05e9:
            if (r13 == 0) goto L_0x05ee
            r9.o(r10, r13)
        L_0x05ee:
            return
        L_0x05ef:
            if (r13 != 0) goto L_0x05f6
            java.lang.Object r1 = r9.f(r10)     // Catch:{ all -> 0x004e }
            r13 = r1
        L_0x05f6:
            boolean r1 = r9.m(r13, r0)     // Catch:{ all -> 0x004e }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.k
        L_0x05fe:
            int r1 = r8.l
            if (r0 >= r1) goto L_0x060d
            int[] r1 = r8.j
            r1 = r1[r0]
            java.lang.Object r13 = r8.j(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05fe
        L_0x060d:
            if (r13 == 0) goto L_0x0612
            r9.o(r10, r13)
        L_0x0612:
            return
        L_0x0613:
            int r1 = r8.k
        L_0x0615:
            int r2 = r8.l
            if (r1 >= r2) goto L_0x0624
            int[] r2 = r8.j
            r2 = r2[r1]
            java.lang.Object r13 = r8.j(r10, r2, r13, r9)
            int r1 = r1 + 1
            goto L_0x0615
        L_0x0624:
            if (r13 == 0) goto L_0x0629
            r9.o(r10, r13)
        L_0x0629:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.F(androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, java.lang.Object, androidx.datastore.preferences.protobuf.Reader, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    public final void G(Object obj, int i2, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) {
        long O = O(m0(i2));
        Object F = UnsafeUtil.F(obj, O);
        if (F == null) {
            F = this.q.newMapField(obj2);
            UnsafeUtil.V(obj, O, F);
        } else if (this.q.isImmutable(F)) {
            Object newMapField = this.q.newMapField(obj2);
            this.q.mergeFrom(newMapField, F);
            UnsafeUtil.V(obj, O, newMapField);
            F = newMapField;
        }
        reader.f(this.q.forMutableMapData(F), this.q.forMapMetadata(obj2), extensionRegistryLite);
    }

    public final void H(Object obj, Object obj2, int i2) {
        long O = O(m0(i2));
        if (v(obj2, i2)) {
            Object F = UnsafeUtil.F(obj, O);
            Object F2 = UnsafeUtil.F(obj2, O);
            if (F != null && F2 != null) {
                UnsafeUtil.V(obj, O, Internal.h(F, F2));
                h0(obj, i2);
            } else if (F2 != null) {
                UnsafeUtil.V(obj, O, F2);
                h0(obj, i2);
            }
        }
    }

    public final void I(Object obj, Object obj2, int i2) {
        int m0 = m0(i2);
        int N = N(i2);
        long O = O(m0);
        if (B(obj2, N, i2)) {
            Object F = UnsafeUtil.F(obj, O);
            Object F2 = UnsafeUtil.F(obj2, O);
            if (F != null && F2 != null) {
                UnsafeUtil.V(obj, O, Internal.h(F, F2));
                i0(obj, N, i2);
            } else if (F2 != null) {
                UnsafeUtil.V(obj, O, F2);
                i0(obj, N, i2);
            }
        }
    }

    public final void J(Object obj, Object obj2, int i2) {
        int m0 = m0(i2);
        long O = O(m0);
        int N = N(i2);
        switch (l0(m0)) {
            case 0:
                if (v(obj2, i2)) {
                    UnsafeUtil.R(obj, O, UnsafeUtil.z(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 1:
                if (v(obj2, i2)) {
                    UnsafeUtil.S(obj, O, UnsafeUtil.A(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 2:
                if (v(obj2, i2)) {
                    UnsafeUtil.U(obj, O, UnsafeUtil.D(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 3:
                if (v(obj2, i2)) {
                    UnsafeUtil.U(obj, O, UnsafeUtil.D(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 4:
                if (v(obj2, i2)) {
                    UnsafeUtil.T(obj, O, UnsafeUtil.B(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 5:
                if (v(obj2, i2)) {
                    UnsafeUtil.U(obj, O, UnsafeUtil.D(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 6:
                if (v(obj2, i2)) {
                    UnsafeUtil.T(obj, O, UnsafeUtil.B(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 7:
                if (v(obj2, i2)) {
                    UnsafeUtil.K(obj, O, UnsafeUtil.s(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 8:
                if (v(obj2, i2)) {
                    UnsafeUtil.V(obj, O, UnsafeUtil.F(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 9:
                H(obj, obj2, i2);
                return;
            case 10:
                if (v(obj2, i2)) {
                    UnsafeUtil.V(obj, O, UnsafeUtil.F(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 11:
                if (v(obj2, i2)) {
                    UnsafeUtil.T(obj, O, UnsafeUtil.B(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 12:
                if (v(obj2, i2)) {
                    UnsafeUtil.T(obj, O, UnsafeUtil.B(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 13:
                if (v(obj2, i2)) {
                    UnsafeUtil.T(obj, O, UnsafeUtil.B(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 14:
                if (v(obj2, i2)) {
                    UnsafeUtil.U(obj, O, UnsafeUtil.D(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 15:
                if (v(obj2, i2)) {
                    UnsafeUtil.T(obj, O, UnsafeUtil.B(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 16:
                if (v(obj2, i2)) {
                    UnsafeUtil.U(obj, O, UnsafeUtil.D(obj2, O));
                    h0(obj, i2);
                    return;
                }
                return;
            case 17:
                H(obj, obj2, i2);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /*46*/:
            case 47:
            case 48:
            case 49:
                this.n.d(obj, obj2, O);
                return;
            case 50:
                SchemaUtil.F(this.q, obj, obj2, O);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (B(obj2, N, i2)) {
                    UnsafeUtil.V(obj, O, UnsafeUtil.F(obj2, O));
                    i0(obj, N, i2);
                    return;
                }
                return;
            case 60:
                I(obj, obj2, i2);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (B(obj2, N, i2)) {
                    UnsafeUtil.V(obj, O, UnsafeUtil.F(obj2, O));
                    i0(obj, N, i2);
                    return;
                }
                return;
            case 68:
                I(obj, obj2, i2);
                return;
            default:
                return;
        }
    }

    public final int N(int i2) {
        return this.f1119a[i2];
    }

    public final int U(Object obj, byte[] bArr, int i2, int i3, int i4, long j2, ArrayDecoders.Registers registers) {
        Object obj2 = obj;
        long j3 = j2;
        Unsafe unsafe = s;
        int i5 = i4;
        Object n2 = n(i4);
        Object object = unsafe.getObject(obj, j3);
        if (this.q.isImmutable(object)) {
            Object newMapField = this.q.newMapField(n2);
            this.q.mergeFrom(newMapField, object);
            unsafe.putObject(obj, j3, newMapField);
            object = newMapField;
        }
        return f(bArr, i2, i3, this.q.forMapMetadata(n2), this.q.forMutableMapData(object), registers);
    }

    public final int V(Object obj, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, ArrayDecoders.Registers registers) {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i10 = i2;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        long j3 = j2;
        int i14 = i9;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe = s;
        long j4 = (long) (this.f1119a[i14 + 2] & 1048575);
        switch (i8) {
            case 51:
                if (i13 == 1) {
                    unsafe.putObject(obj2, j3, Double.valueOf(ArrayDecoders.d(bArr, i2)));
                    int i15 = i10 + 8;
                    unsafe.putInt(obj2, j4, i12);
                    return i15;
                }
                break;
            case 52:
                if (i13 == 5) {
                    unsafe.putObject(obj2, j3, Float.valueOf(ArrayDecoders.l(bArr, i2)));
                    int i16 = i10 + 4;
                    unsafe.putInt(obj2, j4, i12);
                    return i16;
                }
                break;
            case 53:
            case 54:
                if (i13 == 0) {
                    int L = ArrayDecoders.L(bArr2, i10, registers2);
                    unsafe.putObject(obj2, j3, Long.valueOf(registers2.b));
                    unsafe.putInt(obj2, j4, i12);
                    return L;
                }
                break;
            case 55:
            case 62:
                if (i13 == 0) {
                    int I = ArrayDecoders.I(bArr2, i10, registers2);
                    unsafe.putObject(obj2, j3, Integer.valueOf(registers2.f1052a));
                    unsafe.putInt(obj2, j4, i12);
                    return I;
                }
                break;
            case 56:
            case 65:
                if (i13 == 1) {
                    unsafe.putObject(obj2, j3, Long.valueOf(ArrayDecoders.j(bArr, i2)));
                    int i17 = i10 + 8;
                    unsafe.putInt(obj2, j4, i12);
                    return i17;
                }
                break;
            case 57:
            case 64:
                if (i13 == 5) {
                    unsafe.putObject(obj2, j3, Integer.valueOf(ArrayDecoders.h(bArr, i2)));
                    int i18 = i10 + 4;
                    unsafe.putInt(obj2, j4, i12);
                    return i18;
                }
                break;
            case 58:
                if (i13 == 0) {
                    int L2 = ArrayDecoders.L(bArr2, i10, registers2);
                    unsafe.putObject(obj2, j3, Boolean.valueOf(registers2.b != 0));
                    unsafe.putInt(obj2, j4, i12);
                    return L2;
                }
                break;
            case 59:
                if (i13 == 2) {
                    int I2 = ArrayDecoders.I(bArr2, i10, registers2);
                    int i19 = registers2.f1052a;
                    if (i19 == 0) {
                        unsafe.putObject(obj2, j3, "");
                    } else if ((i7 & 536870912) == 0 || Utf8.u(bArr2, I2, I2 + i19)) {
                        unsafe.putObject(obj2, j3, new String(bArr2, I2, i19, Internal.f1098a));
                        I2 += i19;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putInt(obj2, j4, i12);
                    return I2;
                }
                break;
            case 60:
                if (i13 == 2) {
                    int p2 = ArrayDecoders.p(o(i14), bArr2, i10, i3, registers2);
                    Object object = unsafe.getInt(obj2, j4) == i12 ? unsafe.getObject(obj2, j3) : null;
                    if (object == null) {
                        unsafe.putObject(obj2, j3, registers2.c);
                    } else {
                        unsafe.putObject(obj2, j3, Internal.h(object, registers2.c));
                    }
                    unsafe.putInt(obj2, j4, i12);
                    return p2;
                }
                break;
            case 61:
                if (i13 == 2) {
                    int b2 = ArrayDecoders.b(bArr2, i10, registers2);
                    unsafe.putObject(obj2, j3, registers2.c);
                    unsafe.putInt(obj2, j4, i12);
                    return b2;
                }
                break;
            case 63:
                if (i13 == 0) {
                    int I3 = ArrayDecoders.I(bArr2, i10, registers2);
                    int i20 = registers2.f1052a;
                    Internal.EnumVerifier m2 = m(i14);
                    if (m2 == null || m2.isInRange(i20)) {
                        unsafe.putObject(obj2, j3, Integer.valueOf(i20));
                        unsafe.putInt(obj2, j4, i12);
                    } else {
                        p(obj).n(i11, Long.valueOf((long) i20));
                    }
                    return I3;
                }
                break;
            case 66:
                if (i13 == 0) {
                    int I4 = ArrayDecoders.I(bArr2, i10, registers2);
                    unsafe.putObject(obj2, j3, Integer.valueOf(CodedInputStream.b(registers2.f1052a)));
                    unsafe.putInt(obj2, j4, i12);
                    return I4;
                }
                break;
            case 67:
                if (i13 == 0) {
                    int L3 = ArrayDecoders.L(bArr2, i10, registers2);
                    unsafe.putObject(obj2, j3, Long.valueOf(CodedInputStream.c(registers2.b)));
                    unsafe.putInt(obj2, j4, i12);
                    return L3;
                }
                break;
            case 68:
                if (i13 == 3) {
                    int n2 = ArrayDecoders.n(o(i14), bArr, i2, i3, (i11 & -8) | 4, registers);
                    Object object2 = unsafe.getInt(obj2, j4) == i12 ? unsafe.getObject(obj2, j3) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj2, j3, registers2.c);
                    } else {
                        unsafe.putObject(obj2, j3, Internal.h(object2, registers2.c));
                    }
                    unsafe.putInt(obj2, j4, i12);
                    return n2;
                }
                break;
        }
        return i10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v68, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0351, code lost:
        if (r0 != r15) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x036d, code lost:
        r2 = r0;
        r8 = r25;
        r0 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03a1, code lost:
        if (r0 != r15) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x03c4, code lost:
        if (r0 != r15) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d8, code lost:
        r11 = r34;
        r2 = r8;
        r3 = r13;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e8, code lost:
        r12 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ea, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010a, code lost:
        r6 = r6 | r20;
        r2 = r8;
        r0 = r11;
        r3 = r13;
        r1 = r17;
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0113, code lost:
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x012f, code lost:
        r6 = r6 | r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01a7, code lost:
        r6 = r6 | r20;
        r2 = r8;
        r3 = r13;
        r1 = r17;
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01b4, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x023d, code lost:
        r0 = r11 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02ae, code lost:
        r0 = r34;
        r22 = r6;
        r19 = r7;
        r20 = r8;
        r27 = r10;
        r2 = r11;
        r8 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x03e7  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x03f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int W(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r35) {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = s
            r16 = 0
            r0 = r32
            r2 = r16
            r3 = r2
            r6 = r3
            r1 = -1
            r7 = -1
        L_0x0018:
            if (r0 >= r13) goto L_0x041c
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.H(r0, r12, r3, r9)
            int r3 = r9.f1052a
            r4 = r0
            r5 = r3
            goto L_0x002b
        L_0x0029:
            r5 = r0
            r4 = r3
        L_0x002b:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x003a
            int r2 = r2 / r8
            int r1 = r15.a0(r3, r2)
        L_0x0037:
            r2 = r1
            r1 = -1
            goto L_0x003f
        L_0x003a:
            int r1 = r15.Z(r3)
            goto L_0x0037
        L_0x003f:
            if (r2 != r1) goto L_0x0050
            r17 = r3
            r2 = r4
            r8 = r5
            r22 = r6
            r19 = r7
            r27 = r10
            r0 = r11
            r20 = r16
            goto L_0x03c7
        L_0x0050:
            int[] r1 = r15.f1119a
            int r18 = r2 + 1
            r1 = r1[r18]
            int r8 = l0(r1)
            long r11 = O(r1)
            r18 = r5
            r5 = 17
            r19 = r1
            if (r8 > r5) goto L_0x02bc
            int[] r5 = r15.f1119a
            int r20 = r2 + 2
            r5 = r5[r20]
            int r20 = r5 >>> 20
            r1 = 1
            int r20 = r1 << r20
            r22 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r22
            if (r5 == r7) goto L_0x0089
            r13 = -1
            r17 = r2
            if (r7 == r13) goto L_0x0081
            long r1 = (long) r7
            r10.putInt(r14, r1, r6)
        L_0x0081:
            long r1 = (long) r5
            int r1 = r10.getInt(r14, r1)
            r6 = r1
            r7 = r5
            goto L_0x008c
        L_0x0089:
            r17 = r2
            r13 = -1
        L_0x008c:
            r1 = 5
            switch(r8) {
                case 0: goto L_0x0295;
                case 1: goto L_0x027a;
                case 2: goto L_0x025c;
                case 3: goto L_0x025c;
                case 4: goto L_0x0241;
                case 5: goto L_0x021e;
                case 6: goto L_0x0203;
                case 7: goto L_0x01de;
                case 8: goto L_0x01b7;
                case 9: goto L_0x0178;
                case 10: goto L_0x0162;
                case 11: goto L_0x0241;
                case 12: goto L_0x0132;
                case 13: goto L_0x0203;
                case 14: goto L_0x021e;
                case 15: goto L_0x0117;
                case 16: goto L_0x00ef;
                case 17: goto L_0x009f;
                default: goto L_0x0090;
            }
        L_0x0090:
            r12 = r31
            r11 = r4
            r8 = r17
            r17 = r3
            r28 = r18
            r18 = r13
            r13 = r28
            goto L_0x02ae
        L_0x009f:
            r1 = 3
            if (r0 != r1) goto L_0x00e2
            int r0 = r3 << 3
            r5 = r0 | 4
            r2 = r17
            androidx.datastore.preferences.protobuf.Schema r0 = r15.o(r2)
            r1 = r31
            r8 = r2
            r2 = r4
            r17 = r3
            r3 = r33
            r4 = r5
            r13 = r18
            r5 = r35
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.n(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r20
            if (r1 != 0) goto L_0x00c7
            java.lang.Object r1 = r9.c
            r10.putObject(r14, r11, r1)
            goto L_0x00d4
        L_0x00c7:
            java.lang.Object r1 = r10.getObject(r14, r11)
            java.lang.Object r2 = r9.c
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.h(r1, r2)
            r10.putObject(r14, r11, r1)
        L_0x00d4:
            r6 = r6 | r20
            r12 = r31
        L_0x00d8:
            r11 = r34
            r2 = r8
            r3 = r13
            r1 = r17
        L_0x00de:
            r13 = r33
            goto L_0x0018
        L_0x00e2:
            r8 = r17
            r13 = r18
            r17 = r3
        L_0x00e8:
            r12 = r31
        L_0x00ea:
            r11 = r4
            r18 = -1
            goto L_0x02ae
        L_0x00ef:
            r8 = r17
            r13 = r18
            r17 = r3
            if (r0 != 0) goto L_0x00e8
            r2 = r11
            r12 = r31
            int r11 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r4, r9)
            long r0 = r9.b
            long r4 = androidx.datastore.preferences.protobuf.CodedInputStream.c(r0)
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
        L_0x010a:
            r6 = r6 | r20
            r2 = r8
            r0 = r11
            r3 = r13
            r1 = r17
            r13 = r33
        L_0x0113:
            r11 = r34
            goto L_0x0018
        L_0x0117:
            r8 = r17
            r13 = r18
            r17 = r3
            r2 = r11
            r12 = r31
            if (r0 != 0) goto L_0x00ea
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r4, r9)
            int r1 = r9.f1052a
            int r1 = androidx.datastore.preferences.protobuf.CodedInputStream.b(r1)
            r10.putInt(r14, r2, r1)
        L_0x012f:
            r6 = r6 | r20
            goto L_0x00d8
        L_0x0132:
            r8 = r17
            r13 = r18
            r17 = r3
            r2 = r11
            r12 = r31
            if (r0 != 0) goto L_0x00ea
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r4, r9)
            int r1 = r9.f1052a
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r4 = r15.m(r8)
            if (r4 == 0) goto L_0x015e
            boolean r4 = r4.isInRange(r1)
            if (r4 == 0) goto L_0x0150
            goto L_0x015e
        L_0x0150:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r2 = p(r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.n(r13, r1)
            goto L_0x00d8
        L_0x015e:
            r10.putInt(r14, r2, r1)
            goto L_0x012f
        L_0x0162:
            r8 = r17
            r13 = r18
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r31
            if (r0 != r1) goto L_0x00ea
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.b(r12, r4, r9)
            java.lang.Object r1 = r9.c
            r10.putObject(r14, r2, r1)
            goto L_0x012f
        L_0x0178:
            r8 = r17
            r13 = r18
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r31
            if (r0 != r1) goto L_0x01b0
            androidx.datastore.preferences.protobuf.Schema r0 = r15.o(r8)
            r11 = r33
            r18 = -1
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r0, r12, r4, r11, r9)
            r1 = r6 & r20
            if (r1 != 0) goto L_0x019a
            java.lang.Object r1 = r9.c
            r10.putObject(r14, r2, r1)
            goto L_0x01a7
        L_0x019a:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.c
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.h(r1, r4)
            r10.putObject(r14, r2, r1)
        L_0x01a7:
            r6 = r6 | r20
            r2 = r8
            r3 = r13
            r1 = r17
            r13 = r11
            goto L_0x0113
        L_0x01b0:
            r11 = r33
            r18 = -1
        L_0x01b4:
            r11 = r4
            goto L_0x02ae
        L_0x01b7:
            r8 = r17
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r33
            r28 = r18
            r18 = r13
            r13 = r28
            if (r0 != r1) goto L_0x01b4
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r19 & r0
            if (r0 != 0) goto L_0x01d4
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.C(r12, r4, r9)
            goto L_0x01d8
        L_0x01d4:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.F(r12, r4, r9)
        L_0x01d8:
            java.lang.Object r1 = r9.c
            r10.putObject(r14, r2, r1)
            goto L_0x01a7
        L_0x01de:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r33
            r28 = r18
            r18 = r13
            r13 = r28
            if (r0 != 0) goto L_0x01b4
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r4, r9)
            long r4 = r9.b
            r23 = 0
            int r1 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r1 == 0) goto L_0x01fd
            r1 = 1
            goto L_0x01ff
        L_0x01fd:
            r1 = r16
        L_0x01ff:
            androidx.datastore.preferences.protobuf.UnsafeUtil.K(r14, r2, r1)
            goto L_0x01a7
        L_0x0203:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r33
            r28 = r18
            r18 = r13
            r13 = r28
            if (r0 != r1) goto L_0x01b4
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.h(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
            goto L_0x01a7
        L_0x021e:
            r8 = r17
            r1 = 1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r33
            r28 = r18
            r18 = r13
            r13 = r28
            if (r0 != r1) goto L_0x01b4
            long r21 = androidx.datastore.preferences.protobuf.ArrayDecoders.j(r12, r4)
            r0 = r10
            r1 = r30
            r11 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
        L_0x023d:
            int r0 = r11 + 8
            goto L_0x012f
        L_0x0241:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r4
            r28 = r18
            r18 = r13
            r13 = r28
            if (r0 != 0) goto L_0x02ae
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r11, r9)
            int r1 = r9.f1052a
            r10.putInt(r14, r2, r1)
            goto L_0x012f
        L_0x025c:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r4
            r28 = r18
            r18 = r13
            r13 = r28
            if (r0 != 0) goto L_0x02ae
            int r11 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r11, r9)
            long r4 = r9.b
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            goto L_0x010a
        L_0x027a:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r4
            r28 = r18
            r18 = r13
            r13 = r28
            if (r0 != r1) goto L_0x02ae
            float r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.l(r12, r11)
            androidx.datastore.preferences.protobuf.UnsafeUtil.S(r14, r2, r0)
            int r0 = r11 + 4
            goto L_0x012f
        L_0x0295:
            r8 = r17
            r1 = 1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r4
            r28 = r18
            r18 = r13
            r13 = r28
            if (r0 != r1) goto L_0x02ae
            double r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.d(r12, r11)
            androidx.datastore.preferences.protobuf.UnsafeUtil.R(r14, r2, r0)
            goto L_0x023d
        L_0x02ae:
            r0 = r34
            r22 = r6
            r19 = r7
            r20 = r8
            r27 = r10
            r2 = r11
            r8 = r13
            goto L_0x03c7
        L_0x02bc:
            r5 = r2
            r17 = r3
            r2 = r11
            r13 = r18
            r18 = -1
            r12 = r31
            r11 = r4
            r1 = 27
            if (r8 != r1) goto L_0x031a
            r1 = 2
            if (r0 != r1) goto L_0x030d
            java.lang.Object r0 = r10.getObject(r14, r2)
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r0
            boolean r1 = r0.isModifiable()
            if (r1 != 0) goto L_0x02ec
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02e3
            r1 = 10
            goto L_0x02e5
        L_0x02e3:
            int r1 = r1 * 2
        L_0x02e5:
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = r0.mutableCopyWithCapacity(r1)
            r10.putObject(r14, r2, r0)
        L_0x02ec:
            r8 = r0
            androidx.datastore.preferences.protobuf.Schema r0 = r15.o(r5)
            r1 = r13
            r2 = r31
            r3 = r11
            r4 = r33
            r20 = r5
            r5 = r8
            r22 = r6
            r6 = r35
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.q(r0, r1, r2, r3, r4, r5, r6)
            r11 = r34
            r3 = r13
            r1 = r17
            r2 = r20
            r6 = r22
            goto L_0x00de
        L_0x030d:
            r20 = r5
            r22 = r6
            r19 = r7
            r27 = r10
            r15 = r11
            r25 = r13
            goto L_0x03a4
        L_0x031a:
            r20 = r5
            r22 = r6
            r1 = 49
            if (r8 > r1) goto L_0x0374
            r1 = r19
            long r5 = (long) r1
            r4 = r0
            r0 = r29
            r1 = r30
            r23 = r2
            r2 = r31
            r3 = r11
            r32 = r4
            r4 = r33
            r25 = r5
            r5 = r13
            r6 = r17
            r19 = r7
            r7 = r32
            r18 = r8
            r8 = r20
            r27 = r10
            r9 = r25
            r15 = r11
            r11 = r18
            r25 = r13
            r12 = r23
            r14 = r35
            int r0 = r0.Y(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x036d
        L_0x0353:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r1 = r17
            r7 = r19
            r2 = r20
            r6 = r22
            r3 = r25
        L_0x0369:
            r10 = r27
            goto L_0x0018
        L_0x036d:
            r2 = r0
            r8 = r25
            r0 = r34
            goto L_0x03c7
        L_0x0374:
            r32 = r0
            r23 = r2
            r18 = r8
            r27 = r10
            r15 = r11
            r25 = r13
            r1 = r19
            r19 = r7
            r0 = 50
            r9 = r18
            if (r9 != r0) goto L_0x03aa
            r7 = r32
            r0 = 2
            if (r7 != r0) goto L_0x03a4
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r20
            r6 = r23
            r8 = r35
            int r0 = r0.U(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x036d
            goto L_0x0353
        L_0x03a4:
            r0 = r34
            r2 = r15
            r8 = r25
            goto L_0x03c7
        L_0x03aa:
            r7 = r32
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r25
            r6 = r17
            r10 = r23
            r12 = r20
            r13 = r35
            int r0 = r0.V(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x036d
            goto L_0x0353
        L_0x03c7:
            if (r8 != r0) goto L_0x03d6
            if (r0 == 0) goto L_0x03d6
            r9 = r29
            r10 = r0
            r0 = r2
            r3 = r8
            r7 = r19
            r6 = r22
        L_0x03d4:
            r1 = -1
            goto L_0x0425
        L_0x03d6:
            r9 = r29
            r10 = r0
            boolean r0 = r9.f
            r11 = r35
            if (r0 == 0) goto L_0x03f9
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r0 = r11.d
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r1 = androidx.datastore.preferences.protobuf.ExtensionRegistryLite.b()
            if (r0 == r1) goto L_0x03f9
            androidx.datastore.preferences.protobuf.MessageLite r5 = r9.e
            androidx.datastore.preferences.protobuf.UnknownFieldSchema r6 = r9.o
            r0 = r8
            r1 = r31
            r3 = r33
            r4 = r30
            r7 = r35
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.g(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x0408
        L_0x03f9:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r4 = p(r30)
            r0 = r8
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.G(r0, r1, r2, r3, r4, r5)
        L_0x0408:
            r14 = r30
            r12 = r31
            r13 = r33
            r3 = r8
            r15 = r9
            r9 = r11
            r1 = r17
            r7 = r19
            r2 = r20
            r6 = r22
            r11 = r10
            goto L_0x0369
        L_0x041c:
            r22 = r6
            r19 = r7
            r27 = r10
            r10 = r11
            r9 = r15
            goto L_0x03d4
        L_0x0425:
            if (r7 == r1) goto L_0x0430
            long r1 = (long) r7
            r4 = r30
            r5 = r27
            r5.putInt(r4, r1, r6)
            goto L_0x0432
        L_0x0430:
            r4 = r30
        L_0x0432:
            int r1 = r9.k
            r2 = 0
        L_0x0435:
            int r5 = r9.l
            if (r1 >= r5) goto L_0x0448
            int[] r5 = r9.j
            r5 = r5[r1]
            androidx.datastore.preferences.protobuf.UnknownFieldSchema r6 = r9.o
            java.lang.Object r2 = r9.j(r4, r5, r2, r6)
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r2 = (androidx.datastore.preferences.protobuf.UnknownFieldSetLite) r2
            int r1 = r1 + 1
            goto L_0x0435
        L_0x0448:
            if (r2 == 0) goto L_0x044f
            androidx.datastore.preferences.protobuf.UnknownFieldSchema r1 = r9.o
            r1.o(r4, r2)
        L_0x044f:
            if (r10 != 0) goto L_0x045b
            r1 = r33
            if (r0 != r1) goto L_0x0456
            goto L_0x0461
        L_0x0456:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r0
        L_0x045b:
            r1 = r33
            if (r0 > r1) goto L_0x0462
            if (r3 != r10) goto L_0x0462
        L_0x0461:
            return r0
        L_0x0462:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.W(java.lang.Object, byte[], int, int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0084, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009b, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bd, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012c, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01dd, code lost:
        if (r0 != r15) goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x021f, code lost:
        if (r0 != r15) goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x023e, code lost:
        if (r0 != r15) goto L_0x01df;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int X(java.lang.Object r28, byte[] r29, int r30, int r31, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r32) {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            sun.misc.Unsafe r9 = s
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = r10
            r2 = r16
        L_0x0014:
            if (r0 >= r13) goto L_0x0252
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0026
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.H(r0, r12, r3, r11)
            int r3 = r11.f1052a
            r8 = r0
            r17 = r3
            goto L_0x0029
        L_0x0026:
            r17 = r0
            r8 = r3
        L_0x0029:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x0037
            int r2 = r2 / 3
            int r0 = r15.a0(r7, r2)
        L_0x0035:
            r4 = r0
            goto L_0x003c
        L_0x0037:
            int r0 = r15.Z(r7)
            goto L_0x0035
        L_0x003c:
            if (r4 != r10) goto L_0x0049
            r24 = r7
            r2 = r8
            r18 = r9
            r25 = r10
            r19 = r16
            goto L_0x0241
        L_0x0049:
            int[] r0 = r15.f1119a
            int r1 = r4 + 1
            r5 = r0[r1]
            int r3 = l0(r5)
            long r1 = O(r5)
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x016d
            r0 = 1
            switch(r3) {
                case 0: goto L_0x0161;
                case 1: goto L_0x0151;
                case 2: goto L_0x013f;
                case 3: goto L_0x013f;
                case 4: goto L_0x0130;
                case 5: goto L_0x011d;
                case 6: goto L_0x010f;
                case 7: goto L_0x00f8;
                case 8: goto L_0x00e1;
                case 9: goto L_0x00c0;
                case 10: goto L_0x00b1;
                case 11: goto L_0x0130;
                case 12: goto L_0x00a3;
                case 13: goto L_0x010f;
                case 14: goto L_0x011d;
                case 15: goto L_0x0089;
                case 16: goto L_0x006b;
                default: goto L_0x0060;
            }
        L_0x0060:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x0067:
            r25 = -1
            goto L_0x0222
        L_0x006b:
            if (r6 != 0) goto L_0x0060
            int r6 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r8, r11)
            r19 = r1
            long r0 = r11.b
            long r21 = androidx.datastore.preferences.protobuf.CodedInputStream.c(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
        L_0x0084:
            r0 = r6
        L_0x0085:
            r1 = r7
            r2 = r10
        L_0x0087:
            r10 = -1
            goto L_0x0014
        L_0x0089:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x009b
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r8, r11)
            int r1 = r11.f1052a
            int r1 = androidx.datastore.preferences.protobuf.CodedInputStream.b(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x0085
        L_0x009b:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x0067
        L_0x00a3:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x009b
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r8, r11)
            int r1 = r11.f1052a
            r9.putInt(r14, r2, r1)
            goto L_0x0085
        L_0x00b1:
            r2 = r1
            if (r6 != r10) goto L_0x0060
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.b(r12, r8, r11)
            java.lang.Object r1 = r11.c
            r9.putObject(r14, r2, r1)
        L_0x00bd:
            r2 = r4
            r1 = r7
            goto L_0x0087
        L_0x00c0:
            r2 = r1
            if (r6 != r10) goto L_0x0060
            androidx.datastore.preferences.protobuf.Schema r0 = r15.o(r4)
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r0, r12, r8, r13, r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00d7
            java.lang.Object r1 = r11.c
            r9.putObject(r14, r2, r1)
            goto L_0x00bd
        L_0x00d7:
            java.lang.Object r5 = r11.c
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.h(r1, r5)
            r9.putObject(r14, r2, r1)
            goto L_0x00bd
        L_0x00e1:
            r2 = r1
            if (r6 != r10) goto L_0x0060
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00ee
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.C(r12, r8, r11)
            goto L_0x00f2
        L_0x00ee:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.F(r12, r8, r11)
        L_0x00f2:
            java.lang.Object r1 = r11.c
            r9.putObject(r14, r2, r1)
            goto L_0x00bd
        L_0x00f8:
            r2 = r1
            if (r6 != 0) goto L_0x0060
            int r1 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r8, r11)
            long r5 = r11.b
            r19 = 0
            int r5 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r5 == 0) goto L_0x0108
            goto L_0x010a
        L_0x0108:
            r0 = r16
        L_0x010a:
            androidx.datastore.preferences.protobuf.UnsafeUtil.K(r14, r2, r0)
            r0 = r1
            goto L_0x00bd
        L_0x010f:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x0060
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.h(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
            goto L_0x00bd
        L_0x011d:
            r2 = r1
            if (r6 != r0) goto L_0x0060
            long r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.j(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
        L_0x012c:
            int r0 = r8 + 8
            goto L_0x0085
        L_0x0130:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x009b
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r8, r11)
            int r1 = r11.f1052a
            r9.putInt(r14, r2, r1)
            goto L_0x0085
        L_0x013f:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x009b
            int r6 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r8, r11)
            long r4 = r11.b
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
            goto L_0x0084
        L_0x0151:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x009b
            float r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.l(r12, r8)
            androidx.datastore.preferences.protobuf.UnsafeUtil.S(r14, r2, r0)
            int r0 = r8 + 4
            goto L_0x0085
        L_0x0161:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x009b
            double r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.d(r12, r8)
            androidx.datastore.preferences.protobuf.UnsafeUtil.R(r14, r2, r0)
            goto L_0x012c
        L_0x016d:
            r0 = 27
            if (r3 != r0) goto L_0x01aa
            if (r6 != r10) goto L_0x0060
            java.lang.Object r0 = r9.getObject(r14, r1)
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r0
            boolean r3 = r0.isModifiable()
            if (r3 != 0) goto L_0x0191
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0188
            r3 = 10
            goto L_0x018a
        L_0x0188:
            int r3 = r3 * 2
        L_0x018a:
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = r0.mutableCopyWithCapacity(r3)
            r9.putObject(r14, r1, r0)
        L_0x0191:
            r5 = r0
            androidx.datastore.preferences.protobuf.Schema r0 = r15.o(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.q(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x0087
        L_0x01aa:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01f5
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r26 = r10
            r25 = -1
            r9 = r22
            r11 = r26
            r12 = r20
            r14 = r32
            int r0 = r0.Y(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x01f3
        L_0x01df:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
            r10 = r25
            goto L_0x0014
        L_0x01f3:
            r2 = r0
            goto L_0x0241
        L_0x01f5:
            r20 = r1
            r26 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r25 = -1
            r0 = 50
            r9 = r26
            if (r9 != r0) goto L_0x0224
            r7 = r30
            if (r7 != r10) goto L_0x0222
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.U(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x01f3
            goto L_0x01df
        L_0x0222:
            r2 = r15
            goto L_0x0241
        L_0x0224:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.V(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x01f3
            goto L_0x01df
        L_0x0241:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r4 = p(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.G(r0, r1, r2, r3, r4, r5)
            goto L_0x01df
        L_0x0252:
            r1 = r13
            if (r0 != r1) goto L_0x0256
            return r0
        L_0x0256:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.X(java.lang.Object, byte[], int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    public final int Y(Object obj, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, long j3, ArrayDecoders.Registers registers) {
        int i9;
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i10 = i2;
        int i11 = i6;
        int i12 = i7;
        long j4 = j3;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe = s;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(obj, j4);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j4, protobufList);
        }
        switch (i8) {
            case 18:
            case 35:
                if (i11 == 2) {
                    return ArrayDecoders.s(bArr, i10, protobufList, registers2);
                }
                if (i11 == 1) {
                    return ArrayDecoders.e(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 19:
            case 36:
                if (i11 == 2) {
                    return ArrayDecoders.v(bArr, i10, protobufList, registers2);
                }
                if (i11 == 5) {
                    return ArrayDecoders.m(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i11 == 2) {
                    return ArrayDecoders.z(bArr, i10, protobufList, registers2);
                }
                if (i11 == 0) {
                    return ArrayDecoders.M(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i11 == 2) {
                    return ArrayDecoders.y(bArr, i10, protobufList, registers2);
                }
                if (i11 == 0) {
                    return ArrayDecoders.J(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /*46*/:
                if (i11 == 2) {
                    return ArrayDecoders.u(bArr, i10, protobufList, registers2);
                }
                if (i11 == 1) {
                    return ArrayDecoders.k(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i11 == 2) {
                    return ArrayDecoders.t(bArr, i10, protobufList, registers2);
                }
                if (i11 == 5) {
                    return ArrayDecoders.i(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 25:
            case 42:
                if (i11 == 2) {
                    return ArrayDecoders.r(bArr, i10, protobufList, registers2);
                }
                if (i11 == 0) {
                    return ArrayDecoders.a(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 26:
                if (i11 == 2) {
                    return (j2 & 536870912) == 0 ? ArrayDecoders.D(i4, bArr, i2, i3, protobufList, registers) : ArrayDecoders.E(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 27:
                if (i11 == 2) {
                    return ArrayDecoders.q(o(i12), i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 28:
                if (i11 == 2) {
                    return ArrayDecoders.c(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 30:
            case 44:
                if (i11 == 2) {
                    i9 = ArrayDecoders.y(bArr, i10, protobufList, registers2);
                } else if (i11 == 0) {
                    i9 = ArrayDecoders.J(i4, bArr, i2, i3, protobufList, registers);
                }
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj2;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.e()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.A(i5, protobufList, m(i12), unknownFieldSetLite, this.o);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return i9;
            case 33:
            case 47:
                if (i11 == 2) {
                    return ArrayDecoders.w(bArr, i10, protobufList, registers2);
                }
                if (i11 == 0) {
                    return ArrayDecoders.A(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 34:
            case 48:
                if (i11 == 2) {
                    return ArrayDecoders.x(bArr, i10, protobufList, registers2);
                }
                if (i11 == 0) {
                    return ArrayDecoders.B(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 49:
                if (i11 == 3) {
                    return ArrayDecoders.o(o(i12), i4, bArr, i2, i3, protobufList, registers);
                }
                break;
        }
        return i10;
    }

    public final int Z(int i2) {
        if (i2 < this.c || i2 > this.d) {
            return -1;
        }
        return j0(i2, 0);
    }

    public void a(Object obj, Writer writer) {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            p0(obj, writer);
        } else if (this.h) {
            o0(obj, writer);
        } else {
            n0(obj, writer);
        }
    }

    public final int a0(int i2, int i3) {
        if (i2 < this.c || i2 > this.d) {
            return -1;
        }
        return j0(i2, i3);
    }

    public void b(Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.getClass();
        F(this.o, this.p, obj, reader, extensionRegistryLite);
    }

    public final int b0(int i2) {
        return this.f1119a[i2 + 2];
    }

    public void c(Object obj, byte[] bArr, int i2, int i3, ArrayDecoders.Registers registers) {
        if (this.h) {
            X(obj, bArr, i2, i3, registers);
        } else {
            W(obj, bArr, i2, i3, 0, registers);
        }
    }

    public final void c0(Object obj, long j2, Reader reader, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.g(this.n.e(obj, j2), schema, extensionRegistryLite);
    }

    public final boolean d(Object obj, Object obj2, int i2) {
        return v(obj, i2) == v(obj2, i2);
    }

    public final void d0(Object obj, int i2, Reader reader, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.d(this.n.e(obj, O(i2)), schema, extensionRegistryLite);
    }

    public final void e0(Object obj, int i2, Reader reader) {
        if (u(i2)) {
            UnsafeUtil.V(obj, O(i2), reader.readStringRequireUtf8());
        } else if (this.g) {
            UnsafeUtil.V(obj, O(i2), reader.readString());
        } else {
            UnsafeUtil.V(obj, O(i2), reader.readBytes());
        }
    }

    public boolean equals(Object obj, Object obj2) {
        int length = this.f1119a.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            if (!i(obj, obj2, i2)) {
                return false;
            }
        }
        if (!this.o.g(obj).equals(this.o.g(obj2))) {
            return false;
        }
        if (this.f) {
            return this.p.c(obj).equals(this.p.c(obj2));
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r0v6, types: [byte, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int f(byte[] r15, int r16, int r17, androidx.datastore.preferences.protobuf.MapEntryLite.Metadata r18, java.util.Map r19, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r20) {
        /*
            r14 = this;
            r7 = r15
            r8 = r17
            r9 = r18
            r0 = r16
            r10 = r20
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r15, r0, r10)
            int r1 = r10.f1052a
            if (r1 < 0) goto L_0x0081
            int r2 = r8 - r0
            if (r1 > r2) goto L_0x0081
            int r11 = r0 + r1
            java.lang.Object r1 = r9.b
            java.lang.Object r2 = r9.d
            r12 = r1
            r13 = r2
        L_0x001d:
            if (r0 >= r11) goto L_0x0074
            int r1 = r0 + 1
            byte r0 = r7[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.H(r0, r15, r1, r10)
            int r1 = r10.f1052a
            r2 = r0
            r0 = r1
            goto L_0x002f
        L_0x002e:
            r2 = r1
        L_0x002f:
            int r1 = r0 >>> 3
            r3 = r0 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0057
            r4 = 2
            if (r1 == r4) goto L_0x003a
            goto L_0x006f
        L_0x003a:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r9.c
            int r1 = r1.getWireType()
            if (r3 != r1) goto L_0x006f
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.c
            java.lang.Object r0 = r9.d
            java.lang.Class r5 = r0.getClass()
            r0 = r14
            r1 = r15
            r3 = r17
            r6 = r20
            int r0 = r0.g(r1, r2, r3, r4, r5, r6)
            java.lang.Object r13 = r10.c
            goto L_0x001d
        L_0x0057:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r9.f1117a
            int r1 = r1.getWireType()
            if (r3 != r1) goto L_0x006f
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f1117a
            r5 = 0
            r0 = r14
            r1 = r15
            r3 = r17
            r6 = r20
            int r0 = r0.g(r1, r2, r3, r4, r5, r6)
            java.lang.Object r12 = r10.c
            goto L_0x001d
        L_0x006f:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.N(r0, r15, r2, r8, r10)
            goto L_0x001d
        L_0x0074:
            if (r0 != r11) goto L_0x007c
            r0 = r19
            r0.put(r12, r13)
            return r11
        L_0x007c:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r0
        L_0x0081:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.f(byte[], int, int, androidx.datastore.preferences.protobuf.MapEntryLite$Metadata, java.util.Map, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    public final void f0(Object obj, int i2, Reader reader) {
        if (u(i2)) {
            reader.readStringListRequireUtf8(this.n.e(obj, O(i2)));
        } else {
            reader.readStringList(this.n.e(obj, O(i2)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int g(byte[] r1, int r2, int r3, androidx.datastore.preferences.protobuf.WireFormat.FieldType r4, java.lang.Class r5, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r6) {
        /*
            r0 = this;
            int[] r0 = androidx.datastore.preferences.protobuf.MessageSchema.AnonymousClass1.f1120a
            int r4 = r4.ordinal()
            r0 = r0[r4]
            switch(r0) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0089;
                case 4: goto L_0x007e;
                case 5: goto L_0x007e;
                case 6: goto L_0x0071;
                case 7: goto L_0x0071;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "unsupported field type."
            r0.<init>(r1)
            throw r0
        L_0x0013:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.F(r1, r2, r6)
            goto L_0x00ae
        L_0x0019:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r1, r2, r6)
            long r1 = r6.b
            long r1 = androidx.datastore.preferences.protobuf.CodedInputStream.c(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r6.c = r1
            goto L_0x00ae
        L_0x002b:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r1, r2, r6)
            int r1 = r6.f1052a
            int r1 = androidx.datastore.preferences.protobuf.CodedInputStream.b(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.c = r1
            goto L_0x00ae
        L_0x003d:
            androidx.datastore.preferences.protobuf.Protobuf r0 = androidx.datastore.preferences.protobuf.Protobuf.a()
            androidx.datastore.preferences.protobuf.Schema r0 = r0.d(r5)
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r0, r1, r2, r3, r6)
            goto L_0x00ae
        L_0x004a:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r1, r2, r6)
            long r1 = r6.b
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r6.c = r1
            goto L_0x00ae
        L_0x0057:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r1, r2, r6)
            int r1 = r6.f1052a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.c = r1
            goto L_0x00ae
        L_0x0064:
            float r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.l(r1, r2)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r6.c = r0
        L_0x006e:
            int r0 = r2 + 4
            goto L_0x00ae
        L_0x0071:
            long r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.j(r1, r2)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r6.c = r0
        L_0x007b:
            int r0 = r2 + 8
            goto L_0x00ae
        L_0x007e:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.h(r1, r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6.c = r0
            goto L_0x006e
        L_0x0089:
            double r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.d(r1, r2)
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r6.c = r0
            goto L_0x007b
        L_0x0094:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.b(r1, r2, r6)
            goto L_0x00ae
        L_0x0099:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r1, r2, r6)
            long r1 = r6.b
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00a7
            r1 = 1
            goto L_0x00a8
        L_0x00a7:
            r1 = 0
        L_0x00a8:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r6.c = r1
        L_0x00ae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.g(byte[], int, int, androidx.datastore.preferences.protobuf.WireFormat$FieldType, java.lang.Class, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    public int getSerializedSize(Object obj) {
        return this.h ? r(obj) : q(obj);
    }

    public final void h0(Object obj, int i2) {
        if (!this.h) {
            int b0 = b0(i2);
            long j2 = (long) (b0 & 1048575);
            UnsafeUtil.T(obj, j2, UnsafeUtil.B(obj, j2) | (1 << (b0 >>> 20)));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x016b, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0229, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode(java.lang.Object r9) {
        /*
            r8 = this;
            int[] r0 = r8.f1119a
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022d
            int r3 = r8.m0(r1)
            int r4 = r8.N(r1)
            long r5 = O(r3)
            int r3 = l0(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020d;
                case 2: goto L_0x0201;
                case 3: goto L_0x01f5;
                case 4: goto L_0x01ed;
                case 5: goto L_0x01e1;
                case 6: goto L_0x01d9;
                case 7: goto L_0x01cd;
                case 8: goto L_0x01bf;
                case 9: goto L_0x01b4;
                case 10: goto L_0x01a8;
                case 11: goto L_0x01a0;
                case 12: goto L_0x0198;
                case 13: goto L_0x0190;
                case 14: goto L_0x0184;
                case 15: goto L_0x017c;
                case 16: goto L_0x0170;
                case 17: goto L_0x0161;
                case 18: goto L_0x0155;
                case 19: goto L_0x0155;
                case 20: goto L_0x0155;
                case 21: goto L_0x0155;
                case 22: goto L_0x0155;
                case 23: goto L_0x0155;
                case 24: goto L_0x0155;
                case 25: goto L_0x0155;
                case 26: goto L_0x0155;
                case 27: goto L_0x0155;
                case 28: goto L_0x0155;
                case 29: goto L_0x0155;
                case 30: goto L_0x0155;
                case 31: goto L_0x0155;
                case 32: goto L_0x0155;
                case 33: goto L_0x0155;
                case 34: goto L_0x0155;
                case 35: goto L_0x0155;
                case 36: goto L_0x0155;
                case 37: goto L_0x0155;
                case 38: goto L_0x0155;
                case 39: goto L_0x0155;
                case 40: goto L_0x0155;
                case 41: goto L_0x0155;
                case 42: goto L_0x0155;
                case 43: goto L_0x0155;
                case 44: goto L_0x0155;
                case 45: goto L_0x0155;
                case 46: goto L_0x0155;
                case 47: goto L_0x0155;
                case 48: goto L_0x0155;
                case 49: goto L_0x0155;
                case 50: goto L_0x0149;
                case 51: goto L_0x0133;
                case 52: goto L_0x0121;
                case 53: goto L_0x010f;
                case 54: goto L_0x00fd;
                case 55: goto L_0x00ef;
                case 56: goto L_0x00dd;
                case 57: goto L_0x00cf;
                case 58: goto L_0x00bd;
                case 59: goto L_0x00a9;
                case 60: goto L_0x0098;
                case 61: goto L_0x0087;
                case 62: goto L_0x007a;
                case 63: goto L_0x006d;
                case 64: goto L_0x0060;
                case 65: goto L_0x004f;
                case 66: goto L_0x0042;
                case 67: goto L_0x0031;
                case 68: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0229
        L_0x001e:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
        L_0x002e:
            int r2 = r2 + r3
            goto L_0x0229
        L_0x0031:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = T(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.f(r3)
            goto L_0x002e
        L_0x0042:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = S(r9, r5)
            goto L_0x002e
        L_0x004f:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = T(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.f(r3)
            goto L_0x002e
        L_0x0060:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = S(r9, r5)
            goto L_0x002e
        L_0x006d:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = S(r9, r5)
            goto L_0x002e
        L_0x007a:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = S(r9, r5)
            goto L_0x002e
        L_0x0087:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x0098:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x00a9:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x00bd:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            boolean r3 = P(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.c(r3)
            goto L_0x002e
        L_0x00cf:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = S(r9, r5)
            goto L_0x002e
        L_0x00dd:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = T(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.f(r3)
            goto L_0x002e
        L_0x00ef:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = S(r9, r5)
            goto L_0x002e
        L_0x00fd:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = T(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.f(r3)
            goto L_0x002e
        L_0x010f:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = T(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.f(r3)
            goto L_0x002e
        L_0x0121:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            float r3 = R(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x002e
        L_0x0133:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            double r3 = Q(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = androidx.datastore.preferences.protobuf.Internal.f(r3)
            goto L_0x002e
        L_0x0149:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x0155:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x0161:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r9, r5)
            if (r3 == 0) goto L_0x016b
            int r7 = r3.hashCode()
        L_0x016b:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0229
        L_0x0170:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.D(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.f(r3)
            goto L_0x002e
        L_0x017c:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.B(r9, r5)
            goto L_0x002e
        L_0x0184:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.D(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.f(r3)
            goto L_0x002e
        L_0x0190:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.B(r9, r5)
            goto L_0x002e
        L_0x0198:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.B(r9, r5)
            goto L_0x002e
        L_0x01a0:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.B(r9, r5)
            goto L_0x002e
        L_0x01a8:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x01b4:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r9, r5)
            if (r3 == 0) goto L_0x016b
            int r7 = r3.hashCode()
            goto L_0x016b
        L_0x01bf:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x01cd:
            int r2 = r2 * 53
            boolean r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.s(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.c(r3)
            goto L_0x002e
        L_0x01d9:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.B(r9, r5)
            goto L_0x002e
        L_0x01e1:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.D(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.f(r3)
            goto L_0x002e
        L_0x01ed:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.B(r9, r5)
            goto L_0x002e
        L_0x01f5:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.D(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.f(r3)
            goto L_0x002e
        L_0x0201:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.D(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.f(r3)
            goto L_0x002e
        L_0x020d:
            int r2 = r2 * 53
            float r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.A(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x002e
        L_0x0219:
            int r2 = r2 * 53
            double r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.z(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = androidx.datastore.preferences.protobuf.Internal.f(r3)
            goto L_0x002e
        L_0x0229:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022d:
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.UnknownFieldSchema r0 = r8.o
            java.lang.Object r0 = r0.g(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f
            if (r0 == 0) goto L_0x024b
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.ExtensionSchema r8 = r8.p
            androidx.datastore.preferences.protobuf.FieldSet r8 = r8.c(r9)
            int r8 = r8.hashCode()
            int r2 = r2 + r8
        L_0x024b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.hashCode(java.lang.Object):int");
    }

    public final boolean i(Object obj, Object obj2, int i2) {
        int m0 = m0(i2);
        long O = O(m0);
        switch (l0(m0)) {
            case 0:
                return d(obj, obj2, i2) && Double.doubleToLongBits(UnsafeUtil.z(obj, O)) == Double.doubleToLongBits(UnsafeUtil.z(obj2, O));
            case 1:
                return d(obj, obj2, i2) && Float.floatToIntBits(UnsafeUtil.A(obj, O)) == Float.floatToIntBits(UnsafeUtil.A(obj2, O));
            case 2:
                return d(obj, obj2, i2) && UnsafeUtil.D(obj, O) == UnsafeUtil.D(obj2, O);
            case 3:
                return d(obj, obj2, i2) && UnsafeUtil.D(obj, O) == UnsafeUtil.D(obj2, O);
            case 4:
                return d(obj, obj2, i2) && UnsafeUtil.B(obj, O) == UnsafeUtil.B(obj2, O);
            case 5:
                return d(obj, obj2, i2) && UnsafeUtil.D(obj, O) == UnsafeUtil.D(obj2, O);
            case 6:
                return d(obj, obj2, i2) && UnsafeUtil.B(obj, O) == UnsafeUtil.B(obj2, O);
            case 7:
                return d(obj, obj2, i2) && UnsafeUtil.s(obj, O) == UnsafeUtil.s(obj2, O);
            case 8:
                return d(obj, obj2, i2) && SchemaUtil.K(UnsafeUtil.F(obj, O), UnsafeUtil.F(obj2, O));
            case 9:
                return d(obj, obj2, i2) && SchemaUtil.K(UnsafeUtil.F(obj, O), UnsafeUtil.F(obj2, O));
            case 10:
                return d(obj, obj2, i2) && SchemaUtil.K(UnsafeUtil.F(obj, O), UnsafeUtil.F(obj2, O));
            case 11:
                return d(obj, obj2, i2) && UnsafeUtil.B(obj, O) == UnsafeUtil.B(obj2, O);
            case 12:
                return d(obj, obj2, i2) && UnsafeUtil.B(obj, O) == UnsafeUtil.B(obj2, O);
            case 13:
                return d(obj, obj2, i2) && UnsafeUtil.B(obj, O) == UnsafeUtil.B(obj2, O);
            case 14:
                return d(obj, obj2, i2) && UnsafeUtil.D(obj, O) == UnsafeUtil.D(obj2, O);
            case 15:
                return d(obj, obj2, i2) && UnsafeUtil.B(obj, O) == UnsafeUtil.B(obj2, O);
            case 16:
                return d(obj, obj2, i2) && UnsafeUtil.D(obj, O) == UnsafeUtil.D(obj2, O);
            case 17:
                return d(obj, obj2, i2) && SchemaUtil.K(UnsafeUtil.F(obj, O), UnsafeUtil.F(obj2, O));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /*46*/:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.K(UnsafeUtil.F(obj, O), UnsafeUtil.F(obj2, O));
            case 50:
                return SchemaUtil.K(UnsafeUtil.F(obj, O), UnsafeUtil.F(obj2, O));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                return A(obj, obj2, i2) && SchemaUtil.K(UnsafeUtil.F(obj, O), UnsafeUtil.F(obj2, O));
            default:
                return true;
        }
    }

    public final void i0(Object obj, int i2, int i3) {
        UnsafeUtil.T(obj, (long) (b0(i3) & 1048575), i2);
    }

    public final boolean isInitialized(Object obj) {
        int i2;
        int i3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < this.k; i5++) {
            int i6 = this.j[i5];
            int N = N(i6);
            int m0 = m0(i6);
            if (!this.h) {
                int i7 = this.f1119a[i6 + 2];
                int i8 = 1048575 & i7;
                i2 = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = s.getInt(obj, (long) i8);
                    i3 = i8;
                }
            } else {
                i2 = 0;
            }
            if (C(m0) && !w(obj, i6, i4, i2)) {
                return false;
            }
            int l0 = l0(m0);
            if (l0 != 9 && l0 != 17) {
                if (l0 != 27) {
                    if (l0 == 60 || l0 == 68) {
                        if (B(obj, N, i6) && !x(obj, m0, o(i6))) {
                            return false;
                        }
                    } else if (l0 != 49) {
                        if (l0 == 50 && !z(obj, m0, i6)) {
                            return false;
                        }
                    }
                }
                if (!y(obj, m0, i6)) {
                    return false;
                }
            } else if (w(obj, i6, i4, i2) && !x(obj, m0, o(i6))) {
                return false;
            }
        }
        return !this.f || this.p.c(obj).o();
    }

    public final Object j(Object obj, int i2, Object obj2, UnknownFieldSchema unknownFieldSchema) {
        Internal.EnumVerifier m2;
        int N = N(i2);
        Object F = UnsafeUtil.F(obj, O(m0(i2)));
        if (F == null || (m2 = m(i2)) == null) {
            return obj2;
        }
        return k(i2, N, this.q.forMutableMapData(F), m2, obj2, unknownFieldSchema);
    }

    public final int j0(int i2, int i3) {
        int length = (this.f1119a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int N = N(i5);
            if (i2 == N) {
                return i5;
            }
            if (i2 < N) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    public final Object k(int i2, int i3, Map map, Internal.EnumVerifier enumVerifier, Object obj, UnknownFieldSchema unknownFieldSchema) {
        MapEntryLite.Metadata forMapMetadata = this.q.forMapMetadata(n(i2));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!enumVerifier.isInRange(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = unknownFieldSchema.n();
                }
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.b(forMapMetadata, entry.getKey(), entry.getValue()));
                try {
                    MapEntryLite.e(newCodedBuilder.b(), forMapMetadata, entry.getKey(), entry.getValue());
                    unknownFieldSchema.d(obj, i3, newCodedBuilder.a());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return obj;
    }

    public final Internal.EnumVerifier m(int i2) {
        return (Internal.EnumVerifier) this.b[((i2 / 3) * 2) + 1];
    }

    public final int m0(int i2) {
        return this.f1119a[i2 + 1];
    }

    public void makeImmutable(Object obj) {
        int i2;
        int i3 = this.k;
        while (true) {
            i2 = this.l;
            if (i3 >= i2) {
                break;
            }
            long O = O(m0(this.j[i3]));
            Object F = UnsafeUtil.F(obj, O);
            if (F != null) {
                UnsafeUtil.V(obj, O, this.q.toImmutable(F));
            }
            i3++;
        }
        int length = this.j.length;
        while (i2 < length) {
            this.n.c(obj, (long) this.j[i2]);
            i2++;
        }
        this.o.j(obj);
        if (this.f) {
            this.p.f(obj);
        }
    }

    public void mergeFrom(Object obj, Object obj2) {
        obj2.getClass();
        for (int i2 = 0; i2 < this.f1119a.length; i2 += 3) {
            J(obj, obj2, i2);
        }
        if (!this.h) {
            SchemaUtil.G(this.o, obj, obj2);
            if (this.f) {
                SchemaUtil.E(this.p, obj, obj2);
            }
        }
    }

    public final Object n(int i2) {
        return this.b[(i2 / 3) * 2];
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n0(java.lang.Object r18, androidx.datastore.preferences.protobuf.Writer r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.f
            if (r3 == 0) goto L_0x0021
            androidx.datastore.preferences.protobuf.ExtensionSchema r3 = r0.p
            androidx.datastore.preferences.protobuf.FieldSet r3 = r3.c(r1)
            boolean r5 = r3.m()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.r()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            int[] r6 = r0.f1119a
            int r6 = r6.length
            sun.misc.Unsafe r7 = s
            r9 = -1
            r10 = 0
            r11 = 0
        L_0x002b:
            if (r10 >= r6) goto L_0x049a
            int r12 = r0.m0(r10)
            int r13 = r0.N(r10)
            int r14 = l0(r12)
            boolean r15 = r0.h
            if (r15 != 0) goto L_0x005e
            r15 = 17
            if (r14 > r15) goto L_0x005e
            int[] r15 = r0.f1119a
            int r16 = r10 + 2
            r15 = r15[r16]
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r15 & r16
            r16 = r5
            if (r8 == r9) goto L_0x0056
            long r4 = (long) r8
            int r11 = r7.getInt(r1, r4)
            r9 = r8
        L_0x0056:
            int r4 = r15 >>> 20
            r5 = 1
            int r4 = r5 << r4
            r5 = r16
            goto L_0x0063
        L_0x005e:
            r16 = r5
            r5 = r16
            r4 = 0
        L_0x0063:
            if (r5 == 0) goto L_0x0081
            androidx.datastore.preferences.protobuf.ExtensionSchema r8 = r0.p
            int r8 = r8.a(r5)
            if (r8 > r13) goto L_0x0081
            androidx.datastore.preferences.protobuf.ExtensionSchema r8 = r0.p
            r8.j(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007f
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0063
        L_0x007f:
            r5 = 0
            goto L_0x0063
        L_0x0081:
            r15 = r5
            r8 = r6
            long r5 = O(r12)
            switch(r14) {
                case 0: goto L_0x0489;
                case 1: goto L_0x047d;
                case 2: goto L_0x0471;
                case 3: goto L_0x0465;
                case 4: goto L_0x0459;
                case 5: goto L_0x044d;
                case 6: goto L_0x0441;
                case 7: goto L_0x0435;
                case 8: goto L_0x0429;
                case 9: goto L_0x0418;
                case 10: goto L_0x0409;
                case 11: goto L_0x03fc;
                case 12: goto L_0x03ef;
                case 13: goto L_0x03e2;
                case 14: goto L_0x03d5;
                case 15: goto L_0x03c8;
                case 16: goto L_0x03bb;
                case 17: goto L_0x03aa;
                case 18: goto L_0x039a;
                case 19: goto L_0x038a;
                case 20: goto L_0x037a;
                case 21: goto L_0x036a;
                case 22: goto L_0x035a;
                case 23: goto L_0x034a;
                case 24: goto L_0x033a;
                case 25: goto L_0x032a;
                case 26: goto L_0x031b;
                case 27: goto L_0x0308;
                case 28: goto L_0x02f9;
                case 29: goto L_0x02e9;
                case 30: goto L_0x02d9;
                case 31: goto L_0x02c9;
                case 32: goto L_0x02b9;
                case 33: goto L_0x02a9;
                case 34: goto L_0x0299;
                case 35: goto L_0x0289;
                case 36: goto L_0x0279;
                case 37: goto L_0x0269;
                case 38: goto L_0x0259;
                case 39: goto L_0x0249;
                case 40: goto L_0x0239;
                case 41: goto L_0x0229;
                case 42: goto L_0x0219;
                case 43: goto L_0x0209;
                case 44: goto L_0x01f9;
                case 45: goto L_0x01e9;
                case 46: goto L_0x01d9;
                case 47: goto L_0x01c9;
                case 48: goto L_0x01b9;
                case 49: goto L_0x01a6;
                case 50: goto L_0x019d;
                case 51: goto L_0x018e;
                case 52: goto L_0x017f;
                case 53: goto L_0x0170;
                case 54: goto L_0x0161;
                case 55: goto L_0x0152;
                case 56: goto L_0x0143;
                case 57: goto L_0x0134;
                case 58: goto L_0x0125;
                case 59: goto L_0x0116;
                case 60: goto L_0x0103;
                case 61: goto L_0x00f3;
                case 62: goto L_0x00e5;
                case 63: goto L_0x00d7;
                case 64: goto L_0x00c9;
                case 65: goto L_0x00bb;
                case 66: goto L_0x00ad;
                case 67: goto L_0x009f;
                case 68: goto L_0x008d;
                default: goto L_0x008a;
            }
        L_0x008a:
            r12 = 0
            goto L_0x0494
        L_0x008d:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.Schema r5 = r0.o(r10)
            r2.e(r13, r4, r5)
            goto L_0x008a
        L_0x009f:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = T(r1, r5)
            r2.writeSInt64(r13, r4)
            goto L_0x008a
        L_0x00ad:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = S(r1, r5)
            r2.writeSInt32(r13, r4)
            goto L_0x008a
        L_0x00bb:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = T(r1, r5)
            r2.writeSFixed64(r13, r4)
            goto L_0x008a
        L_0x00c9:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = S(r1, r5)
            r2.writeSFixed32(r13, r4)
            goto L_0x008a
        L_0x00d7:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = S(r1, r5)
            r2.writeEnum(r13, r4)
            goto L_0x008a
        L_0x00e5:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = S(r1, r5)
            r2.writeUInt32(r13, r4)
            goto L_0x008a
        L_0x00f3:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r2.a(r13, r4)
            goto L_0x008a
        L_0x0103:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.Schema r5 = r0.o(r10)
            r2.b(r13, r4, r5)
            goto L_0x008a
        L_0x0116:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r7.getObject(r1, r5)
            r0.r0(r13, r4, r2)
            goto L_0x008a
        L_0x0125:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            boolean r4 = P(r1, r5)
            r2.writeBool(r13, r4)
            goto L_0x008a
        L_0x0134:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = S(r1, r5)
            r2.writeFixed32(r13, r4)
            goto L_0x008a
        L_0x0143:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = T(r1, r5)
            r2.writeFixed64(r13, r4)
            goto L_0x008a
        L_0x0152:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = S(r1, r5)
            r2.writeInt32(r13, r4)
            goto L_0x008a
        L_0x0161:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = T(r1, r5)
            r2.writeUInt64(r13, r4)
            goto L_0x008a
        L_0x0170:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = T(r1, r5)
            r2.writeInt64(r13, r4)
            goto L_0x008a
        L_0x017f:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            float r4 = R(r1, r5)
            r2.writeFloat(r13, r4)
            goto L_0x008a
        L_0x018e:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            double r4 = Q(r1, r5)
            r2.writeDouble(r13, r4)
            goto L_0x008a
        L_0x019d:
            java.lang.Object r4 = r7.getObject(r1, r5)
            r0.q0(r2, r13, r4, r10)
            goto L_0x008a
        L_0x01a6:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.Schema r6 = r0.o(r10)
            androidx.datastore.preferences.protobuf.SchemaUtil.U(r4, r5, r2, r6)
            goto L_0x008a
        L_0x01b9:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 1
            androidx.datastore.preferences.protobuf.SchemaUtil.b0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01c9:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.a0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01d9:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.Z(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01e9:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.Y(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01f9:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.Q(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0209:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.d0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0219:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.N(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0229:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.R(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0239:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.S(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0249:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.V(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0259:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.e0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0269:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.W(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0279:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.T(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0289:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.P(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0299:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            androidx.datastore.preferences.protobuf.SchemaUtil.b0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02a9:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.a0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02b9:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.Z(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02c9:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.Y(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02d9:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.Q(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02e9:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.d0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02f9:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.O(r4, r5, r2)
            goto L_0x008a
        L_0x0308:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.Schema r6 = r0.o(r10)
            androidx.datastore.preferences.protobuf.SchemaUtil.X(r4, r5, r2, r6)
            goto L_0x008a
        L_0x031b:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.c0(r4, r5, r2)
            goto L_0x008a
        L_0x032a:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            androidx.datastore.preferences.protobuf.SchemaUtil.N(r4, r5, r2, r12)
            goto L_0x0494
        L_0x033a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.R(r4, r5, r2, r12)
            goto L_0x0494
        L_0x034a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.S(r4, r5, r2, r12)
            goto L_0x0494
        L_0x035a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.V(r4, r5, r2, r12)
            goto L_0x0494
        L_0x036a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.e0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x037a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.W(r4, r5, r2, r12)
            goto L_0x0494
        L_0x038a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.T(r4, r5, r2, r12)
            goto L_0x0494
        L_0x039a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.P(r4, r5, r2, r12)
            goto L_0x0494
        L_0x03aa:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.Schema r5 = r0.o(r10)
            r2.e(r13, r4, r5)
            goto L_0x0494
        L_0x03bb:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.writeSInt64(r13, r4)
            goto L_0x0494
        L_0x03c8:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.writeSInt32(r13, r4)
            goto L_0x0494
        L_0x03d5:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.writeSFixed64(r13, r4)
            goto L_0x0494
        L_0x03e2:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.writeSFixed32(r13, r4)
            goto L_0x0494
        L_0x03ef:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.writeEnum(r13, r4)
            goto L_0x0494
        L_0x03fc:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.writeUInt32(r13, r4)
            goto L_0x0494
        L_0x0409:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r2.a(r13, r4)
            goto L_0x0494
        L_0x0418:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.Schema r5 = r0.o(r10)
            r2.b(r13, r4, r5)
            goto L_0x0494
        L_0x0429:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r7.getObject(r1, r5)
            r0.r0(r13, r4, r2)
            goto L_0x0494
        L_0x0435:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            boolean r4 = e(r1, r5)
            r2.writeBool(r13, r4)
            goto L_0x0494
        L_0x0441:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.writeFixed32(r13, r4)
            goto L_0x0494
        L_0x044d:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.writeFixed64(r13, r4)
            goto L_0x0494
        L_0x0459:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.writeInt32(r13, r4)
            goto L_0x0494
        L_0x0465:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.writeUInt64(r13, r4)
            goto L_0x0494
        L_0x0471:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.writeInt64(r13, r4)
            goto L_0x0494
        L_0x047d:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            float r4 = l(r1, r5)
            r2.writeFloat(r13, r4)
            goto L_0x0494
        L_0x0489:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            double r4 = h(r1, r5)
            r2.writeDouble(r13, r4)
        L_0x0494:
            int r10 = r10 + 3
            r6 = r8
            r5 = r15
            goto L_0x002b
        L_0x049a:
            r16 = r5
        L_0x049c:
            if (r5 == 0) goto L_0x04b3
            androidx.datastore.preferences.protobuf.ExtensionSchema r4 = r0.p
            r4.j(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04b1
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x049c
        L_0x04b1:
            r5 = 0
            goto L_0x049c
        L_0x04b3:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema r3 = r0.o
            r0.s0(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.n0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    public Object newInstance() {
        return this.m.newInstance(this.e);
    }

    public final Schema o(int i2) {
        int i3 = (i2 / 3) * 2;
        Schema schema = (Schema) this.b[i3];
        if (schema != null) {
            return schema;
        }
        Schema d2 = Protobuf.a().d((Class) this.b[i3 + 1]);
        this.b[i3] = d2;
        return d2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0588  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o0(java.lang.Object r13, androidx.datastore.preferences.protobuf.Writer r14) {
        /*
            r12 = this;
            boolean r0 = r12.f
            r1 = 0
            if (r0 == 0) goto L_0x001c
            androidx.datastore.preferences.protobuf.ExtensionSchema r0 = r12.p
            androidx.datastore.preferences.protobuf.FieldSet r0 = r0.c(r13)
            boolean r2 = r0.m()
            if (r2 != 0) goto L_0x001c
            java.util.Iterator r0 = r0.r()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x001e
        L_0x001c:
            r0 = r1
            r2 = r0
        L_0x001e:
            int[] r3 = r12.f1119a
            int r3 = r3.length
            r4 = 0
            r5 = r4
        L_0x0023:
            if (r5 >= r3) goto L_0x0586
            int r6 = r12.m0(r5)
            int r7 = r12.N(r5)
        L_0x002d:
            if (r2 == 0) goto L_0x004b
            androidx.datastore.preferences.protobuf.ExtensionSchema r8 = r12.p
            int r8 = r8.a(r2)
            if (r8 > r7) goto L_0x004b
            androidx.datastore.preferences.protobuf.ExtensionSchema r8 = r12.p
            r8.j(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x002d
        L_0x0049:
            r2 = r1
            goto L_0x002d
        L_0x004b:
            int r8 = l0(r6)
            r9 = 1
            switch(r8) {
                case 0: goto L_0x0571;
                case 1: goto L_0x055f;
                case 2: goto L_0x054d;
                case 3: goto L_0x053b;
                case 4: goto L_0x0529;
                case 5: goto L_0x0517;
                case 6: goto L_0x0505;
                case 7: goto L_0x04f2;
                case 8: goto L_0x04df;
                case 9: goto L_0x04c8;
                case 10: goto L_0x04b3;
                case 11: goto L_0x04a0;
                case 12: goto L_0x048d;
                case 13: goto L_0x047a;
                case 14: goto L_0x0467;
                case 15: goto L_0x0454;
                case 16: goto L_0x0441;
                case 17: goto L_0x042a;
                case 18: goto L_0x0417;
                case 19: goto L_0x0404;
                case 20: goto L_0x03f1;
                case 21: goto L_0x03de;
                case 22: goto L_0x03cb;
                case 23: goto L_0x03b8;
                case 24: goto L_0x03a5;
                case 25: goto L_0x0392;
                case 26: goto L_0x037f;
                case 27: goto L_0x0368;
                case 28: goto L_0x0355;
                case 29: goto L_0x0342;
                case 30: goto L_0x032f;
                case 31: goto L_0x031c;
                case 32: goto L_0x0309;
                case 33: goto L_0x02f6;
                case 34: goto L_0x02e3;
                case 35: goto L_0x02d0;
                case 36: goto L_0x02bd;
                case 37: goto L_0x02aa;
                case 38: goto L_0x0297;
                case 39: goto L_0x0284;
                case 40: goto L_0x0271;
                case 41: goto L_0x025e;
                case 42: goto L_0x024b;
                case 43: goto L_0x0238;
                case 44: goto L_0x0225;
                case 45: goto L_0x0212;
                case 46: goto L_0x01ff;
                case 47: goto L_0x01ec;
                case 48: goto L_0x01d9;
                case 49: goto L_0x01c2;
                case 50: goto L_0x01b5;
                case 51: goto L_0x01a2;
                case 52: goto L_0x018f;
                case 53: goto L_0x017c;
                case 54: goto L_0x0169;
                case 55: goto L_0x0156;
                case 56: goto L_0x0143;
                case 57: goto L_0x0130;
                case 58: goto L_0x011d;
                case 59: goto L_0x010a;
                case 60: goto L_0x00f3;
                case 61: goto L_0x00de;
                case 62: goto L_0x00cb;
                case 63: goto L_0x00b8;
                case 64: goto L_0x00a5;
                case 65: goto L_0x0092;
                case 66: goto L_0x007f;
                case 67: goto L_0x006c;
                case 68: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x0582
        L_0x0055:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.o(r5)
            r14.e(r7, r6, r8)
            goto L_0x0582
        L_0x006c:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = T(r13, r8)
            r14.writeSInt64(r7, r8)
            goto L_0x0582
        L_0x007f:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = S(r13, r8)
            r14.writeSInt32(r7, r6)
            goto L_0x0582
        L_0x0092:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = T(r13, r8)
            r14.writeSFixed64(r7, r8)
            goto L_0x0582
        L_0x00a5:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = S(r13, r8)
            r14.writeSFixed32(r7, r6)
            goto L_0x0582
        L_0x00b8:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = S(r13, r8)
            r14.writeEnum(r7, r6)
            goto L_0x0582
        L_0x00cb:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = S(r13, r8)
            r14.writeUInt32(r7, r6)
            goto L_0x0582
        L_0x00de:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            r14.a(r7, r6)
            goto L_0x0582
        L_0x00f3:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.o(r5)
            r14.b(r7, r6, r8)
            goto L_0x0582
        L_0x010a:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            r12.r0(r7, r6, r14)
            goto L_0x0582
        L_0x011d:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            boolean r6 = P(r13, r8)
            r14.writeBool(r7, r6)
            goto L_0x0582
        L_0x0130:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = S(r13, r8)
            r14.writeFixed32(r7, r6)
            goto L_0x0582
        L_0x0143:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = T(r13, r8)
            r14.writeFixed64(r7, r8)
            goto L_0x0582
        L_0x0156:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = S(r13, r8)
            r14.writeInt32(r7, r6)
            goto L_0x0582
        L_0x0169:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = T(r13, r8)
            r14.writeUInt64(r7, r8)
            goto L_0x0582
        L_0x017c:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = T(r13, r8)
            r14.writeInt64(r7, r8)
            goto L_0x0582
        L_0x018f:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            float r6 = R(r13, r8)
            r14.writeFloat(r7, r6)
            goto L_0x0582
        L_0x01a2:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            double r8 = Q(r13, r8)
            r14.writeDouble(r7, r8)
            goto L_0x0582
        L_0x01b5:
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            r12.q0(r14, r7, r6, r5)
            goto L_0x0582
        L_0x01c2:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.Schema r8 = r12.o(r5)
            androidx.datastore.preferences.protobuf.SchemaUtil.U(r7, r6, r14, r8)
            goto L_0x0582
        L_0x01d9:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.b0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ec:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.a0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ff:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.Z(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0212:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.Y(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0225:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.Q(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0238:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.d0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x024b:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.N(r7, r6, r14, r9)
            goto L_0x0582
        L_0x025e:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.R(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0271:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.S(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0284:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.V(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0297:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.e0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02aa:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.W(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02bd:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.T(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02d0:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.P(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02e3:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.b0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x02f6:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.a0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0309:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.Z(r7, r6, r14, r4)
            goto L_0x0582
        L_0x031c:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.Y(r7, r6, r14, r4)
            goto L_0x0582
        L_0x032f:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.Q(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0342:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.d0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0355:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.O(r7, r6, r14)
            goto L_0x0582
        L_0x0368:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.Schema r8 = r12.o(r5)
            androidx.datastore.preferences.protobuf.SchemaUtil.X(r7, r6, r14, r8)
            goto L_0x0582
        L_0x037f:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.c0(r7, r6, r14)
            goto L_0x0582
        L_0x0392:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.N(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03a5:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.R(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03b8:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.S(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03cb:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.V(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03de:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.e0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03f1:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.W(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0404:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.T(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0417:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.P(r7, r6, r14, r4)
            goto L_0x0582
        L_0x042a:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.o(r5)
            r14.e(r7, r6, r8)
            goto L_0x0582
        L_0x0441:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = E(r13, r8)
            r14.writeSInt64(r7, r8)
            goto L_0x0582
        L_0x0454:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = t(r13, r8)
            r14.writeSInt32(r7, r6)
            goto L_0x0582
        L_0x0467:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = E(r13, r8)
            r14.writeSFixed64(r7, r8)
            goto L_0x0582
        L_0x047a:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = t(r13, r8)
            r14.writeSFixed32(r7, r6)
            goto L_0x0582
        L_0x048d:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = t(r13, r8)
            r14.writeEnum(r7, r6)
            goto L_0x0582
        L_0x04a0:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = t(r13, r8)
            r14.writeUInt32(r7, r6)
            goto L_0x0582
        L_0x04b3:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            r14.a(r7, r6)
            goto L_0x0582
        L_0x04c8:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.o(r5)
            r14.b(r7, r6, r8)
            goto L_0x0582
        L_0x04df:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r13, r8)
            r12.r0(r7, r6, r14)
            goto L_0x0582
        L_0x04f2:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            boolean r6 = e(r13, r8)
            r14.writeBool(r7, r6)
            goto L_0x0582
        L_0x0505:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = t(r13, r8)
            r14.writeFixed32(r7, r6)
            goto L_0x0582
        L_0x0517:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = E(r13, r8)
            r14.writeFixed64(r7, r8)
            goto L_0x0582
        L_0x0529:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = t(r13, r8)
            r14.writeInt32(r7, r6)
            goto L_0x0582
        L_0x053b:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = E(r13, r8)
            r14.writeUInt64(r7, r8)
            goto L_0x0582
        L_0x054d:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = E(r13, r8)
            r14.writeInt64(r7, r8)
            goto L_0x0582
        L_0x055f:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            float r6 = l(r13, r8)
            r14.writeFloat(r7, r6)
            goto L_0x0582
        L_0x0571:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            double r8 = h(r13, r8)
            r14.writeDouble(r7, r8)
        L_0x0582:
            int r5 = r5 + 3
            goto L_0x0023
        L_0x0586:
            if (r2 == 0) goto L_0x059c
            androidx.datastore.preferences.protobuf.ExtensionSchema r3 = r12.p
            r3.j(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x059a
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0586
        L_0x059a:
            r2 = r1
            goto L_0x0586
        L_0x059c:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema r0 = r12.o
            r12.s0(r0, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.o0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p0(java.lang.Object r11, androidx.datastore.preferences.protobuf.Writer r12) {
        /*
            r10 = this;
            androidx.datastore.preferences.protobuf.UnknownFieldSchema r0 = r10.o
            r10.s0(r0, r11, r12)
            boolean r0 = r10.f
            r1 = 0
            if (r0 == 0) goto L_0x0021
            androidx.datastore.preferences.protobuf.ExtensionSchema r0 = r10.p
            androidx.datastore.preferences.protobuf.FieldSet r0 = r0.c(r11)
            boolean r2 = r0.m()
            if (r2 != 0) goto L_0x0021
            java.util.Iterator r0 = r0.g()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0023
        L_0x0021:
            r0 = r1
            r2 = r0
        L_0x0023:
            int[] r3 = r10.f1119a
            int r3 = r3.length
            int r3 = r3 + -3
        L_0x0028:
            if (r3 < 0) goto L_0x058c
            int r4 = r10.m0(r3)
            int r5 = r10.N(r3)
        L_0x0032:
            if (r2 == 0) goto L_0x0050
            androidx.datastore.preferences.protobuf.ExtensionSchema r6 = r10.p
            int r6 = r6.a(r2)
            if (r6 <= r5) goto L_0x0050
            androidx.datastore.preferences.protobuf.ExtensionSchema r6 = r10.p
            r6.j(r12, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0032
        L_0x004e:
            r2 = r1
            goto L_0x0032
        L_0x0050:
            int r6 = l0(r4)
            r7 = 0
            r8 = 1
            switch(r6) {
                case 0: goto L_0x0577;
                case 1: goto L_0x0565;
                case 2: goto L_0x0553;
                case 3: goto L_0x0541;
                case 4: goto L_0x052f;
                case 5: goto L_0x051d;
                case 6: goto L_0x050b;
                case 7: goto L_0x04f8;
                case 8: goto L_0x04e5;
                case 9: goto L_0x04ce;
                case 10: goto L_0x04b9;
                case 11: goto L_0x04a6;
                case 12: goto L_0x0493;
                case 13: goto L_0x0480;
                case 14: goto L_0x046d;
                case 15: goto L_0x045a;
                case 16: goto L_0x0447;
                case 17: goto L_0x0430;
                case 18: goto L_0x041d;
                case 19: goto L_0x040a;
                case 20: goto L_0x03f7;
                case 21: goto L_0x03e4;
                case 22: goto L_0x03d1;
                case 23: goto L_0x03be;
                case 24: goto L_0x03ab;
                case 25: goto L_0x0398;
                case 26: goto L_0x0385;
                case 27: goto L_0x036e;
                case 28: goto L_0x035b;
                case 29: goto L_0x0348;
                case 30: goto L_0x0335;
                case 31: goto L_0x0322;
                case 32: goto L_0x030f;
                case 33: goto L_0x02fc;
                case 34: goto L_0x02e9;
                case 35: goto L_0x02d6;
                case 36: goto L_0x02c3;
                case 37: goto L_0x02b0;
                case 38: goto L_0x029d;
                case 39: goto L_0x028a;
                case 40: goto L_0x0277;
                case 41: goto L_0x0264;
                case 42: goto L_0x0251;
                case 43: goto L_0x023e;
                case 44: goto L_0x022b;
                case 45: goto L_0x0218;
                case 46: goto L_0x0205;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01df;
                case 49: goto L_0x01c8;
                case 50: goto L_0x01bb;
                case 51: goto L_0x01a8;
                case 52: goto L_0x0195;
                case 53: goto L_0x0182;
                case 54: goto L_0x016f;
                case 55: goto L_0x015c;
                case 56: goto L_0x0149;
                case 57: goto L_0x0136;
                case 58: goto L_0x0123;
                case 59: goto L_0x0110;
                case 60: goto L_0x00f9;
                case 61: goto L_0x00e4;
                case 62: goto L_0x00d1;
                case 63: goto L_0x00be;
                case 64: goto L_0x00ab;
                case 65: goto L_0x0098;
                case 66: goto L_0x0085;
                case 67: goto L_0x0072;
                case 68: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x0588
        L_0x005b:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.o(r3)
            r12.e(r5, r4, r6)
            goto L_0x0588
        L_0x0072:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = T(r11, r6)
            r12.writeSInt64(r5, r6)
            goto L_0x0588
        L_0x0085:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = S(r11, r6)
            r12.writeSInt32(r5, r4)
            goto L_0x0588
        L_0x0098:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = T(r11, r6)
            r12.writeSFixed64(r5, r6)
            goto L_0x0588
        L_0x00ab:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = S(r11, r6)
            r12.writeSFixed32(r5, r4)
            goto L_0x0588
        L_0x00be:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = S(r11, r6)
            r12.writeEnum(r5, r4)
            goto L_0x0588
        L_0x00d1:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = S(r11, r6)
            r12.writeUInt32(r5, r4)
            goto L_0x0588
        L_0x00e4:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r12.a(r5, r4)
            goto L_0x0588
        L_0x00f9:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.o(r3)
            r12.b(r5, r4, r6)
            goto L_0x0588
        L_0x0110:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            r10.r0(r5, r4, r12)
            goto L_0x0588
        L_0x0123:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            boolean r4 = P(r11, r6)
            r12.writeBool(r5, r4)
            goto L_0x0588
        L_0x0136:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = S(r11, r6)
            r12.writeFixed32(r5, r4)
            goto L_0x0588
        L_0x0149:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = T(r11, r6)
            r12.writeFixed64(r5, r6)
            goto L_0x0588
        L_0x015c:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = S(r11, r6)
            r12.writeInt32(r5, r4)
            goto L_0x0588
        L_0x016f:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = T(r11, r6)
            r12.writeUInt64(r5, r6)
            goto L_0x0588
        L_0x0182:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = T(r11, r6)
            r12.writeInt64(r5, r6)
            goto L_0x0588
        L_0x0195:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            float r4 = R(r11, r6)
            r12.writeFloat(r5, r4)
            goto L_0x0588
        L_0x01a8:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            double r6 = Q(r11, r6)
            r12.writeDouble(r5, r6)
            goto L_0x0588
        L_0x01bb:
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            r10.q0(r12, r5, r4, r3)
            goto L_0x0588
        L_0x01c8:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.Schema r6 = r10.o(r3)
            androidx.datastore.preferences.protobuf.SchemaUtil.U(r5, r4, r12, r6)
            goto L_0x0588
        L_0x01df:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.b0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x01f2:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.a0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0205:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.Z(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0218:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.Y(r5, r4, r12, r8)
            goto L_0x0588
        L_0x022b:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.Q(r5, r4, r12, r8)
            goto L_0x0588
        L_0x023e:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.d0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0251:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.N(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0264:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.R(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0277:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.S(r5, r4, r12, r8)
            goto L_0x0588
        L_0x028a:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.V(r5, r4, r12, r8)
            goto L_0x0588
        L_0x029d:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.e0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02b0:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.W(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02c3:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.T(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02d6:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.P(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02e9:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.b0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02fc:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.a0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x030f:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.Z(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0322:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.Y(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0335:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.Q(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0348:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.d0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x035b:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.O(r5, r4, r12)
            goto L_0x0588
        L_0x036e:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.Schema r6 = r10.o(r3)
            androidx.datastore.preferences.protobuf.SchemaUtil.X(r5, r4, r12, r6)
            goto L_0x0588
        L_0x0385:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.c0(r5, r4, r12)
            goto L_0x0588
        L_0x0398:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.N(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03ab:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.R(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03be:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.S(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03d1:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.V(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03e4:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.e0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03f7:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.W(r5, r4, r12, r7)
            goto L_0x0588
        L_0x040a:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.T(r5, r4, r12, r7)
            goto L_0x0588
        L_0x041d:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.P(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0430:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.o(r3)
            r12.e(r5, r4, r6)
            goto L_0x0588
        L_0x0447:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = E(r11, r6)
            r12.writeSInt64(r5, r6)
            goto L_0x0588
        L_0x045a:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = t(r11, r6)
            r12.writeSInt32(r5, r4)
            goto L_0x0588
        L_0x046d:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = E(r11, r6)
            r12.writeSFixed64(r5, r6)
            goto L_0x0588
        L_0x0480:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = t(r11, r6)
            r12.writeSFixed32(r5, r4)
            goto L_0x0588
        L_0x0493:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = t(r11, r6)
            r12.writeEnum(r5, r4)
            goto L_0x0588
        L_0x04a6:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = t(r11, r6)
            r12.writeUInt32(r5, r4)
            goto L_0x0588
        L_0x04b9:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r12.a(r5, r4)
            goto L_0x0588
        L_0x04ce:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.o(r3)
            r12.b(r5, r4, r6)
            goto L_0x0588
        L_0x04e5:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r11, r6)
            r10.r0(r5, r4, r12)
            goto L_0x0588
        L_0x04f8:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            boolean r4 = e(r11, r6)
            r12.writeBool(r5, r4)
            goto L_0x0588
        L_0x050b:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = t(r11, r6)
            r12.writeFixed32(r5, r4)
            goto L_0x0588
        L_0x051d:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = E(r11, r6)
            r12.writeFixed64(r5, r6)
            goto L_0x0588
        L_0x052f:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = t(r11, r6)
            r12.writeInt32(r5, r4)
            goto L_0x0588
        L_0x0541:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = E(r11, r6)
            r12.writeUInt64(r5, r6)
            goto L_0x0588
        L_0x0553:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = E(r11, r6)
            r12.writeInt64(r5, r6)
            goto L_0x0588
        L_0x0565:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            float r4 = l(r11, r6)
            r12.writeFloat(r5, r4)
            goto L_0x0588
        L_0x0577:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            double r6 = h(r11, r6)
            r12.writeDouble(r5, r6)
        L_0x0588:
            int r3 = r3 + -3
            goto L_0x0028
        L_0x058c:
            if (r2 == 0) goto L_0x05a3
            androidx.datastore.preferences.protobuf.ExtensionSchema r11 = r10.p
            r11.j(r12, r2)
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x05a1
            java.lang.Object r11 = r0.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            r2 = r11
            goto L_0x058c
        L_0x05a1:
            r2 = r1
            goto L_0x058c
        L_0x05a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.p0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x034e, code lost:
        r6 = r6 + r3;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x051d, code lost:
        r5 = r5 + 3;
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b0, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01bd, code lost:
        r4 = (r4 + r8) + r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int q(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            sun.misc.Unsafe r2 = s
            r4 = -1
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x000a:
            int[] r8 = r0.f1119a
            int r8 = r8.length
            if (r5 >= r8) goto L_0x0522
            int r8 = r0.m0(r5)
            int r9 = r0.N(r5)
            int r10 = l0(r8)
            r11 = 17
            r12 = 1048575(0xfffff, float:1.469367E-39)
            r13 = 1
            if (r10 > r11) goto L_0x0039
            int[] r11 = r0.f1119a
            int r14 = r5 + 2
            r11 = r11[r14]
            r12 = r12 & r11
            int r14 = r11 >>> 20
            int r14 = r13 << r14
            r15 = r14
            if (r12 == r4) goto L_0x0037
            long r13 = (long) r12
            int r7 = r2.getInt(r1, r13)
            r4 = r12
        L_0x0037:
            r14 = r15
            goto L_0x0058
        L_0x0039:
            boolean r11 = r0.i
            if (r11 == 0) goto L_0x0056
            androidx.datastore.preferences.protobuf.FieldType r11 = androidx.datastore.preferences.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r11 = r11.id()
            if (r10 < r11) goto L_0x0056
            androidx.datastore.preferences.protobuf.FieldType r11 = androidx.datastore.preferences.protobuf.FieldType.SINT64_LIST_PACKED
            int r11 = r11.id()
            if (r10 > r11) goto L_0x0056
            int[] r11 = r0.f1119a
            int r13 = r5 + 2
            r11 = r11[r13]
            r11 = r11 & r12
        L_0x0054:
            r14 = 0
            goto L_0x0058
        L_0x0056:
            r11 = 0
            goto L_0x0054
        L_0x0058:
            long r12 = O(r8)
            r15 = r4
            r8 = 0
            r3 = 0
            switch(r10) {
                case 0: goto L_0x0511;
                case 1: goto L_0x0507;
                case 2: goto L_0x04f9;
                case 3: goto L_0x04eb;
                case 4: goto L_0x04dd;
                case 5: goto L_0x04d3;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04bd;
                case 8: goto L_0x04a1;
                case 9: goto L_0x048f;
                case 10: goto L_0x047f;
                case 11: goto L_0x0471;
                case 12: goto L_0x0463;
                case 13: goto L_0x0458;
                case 14: goto L_0x044e;
                case 15: goto L_0x0440;
                case 16: goto L_0x0432;
                case 17: goto L_0x041e;
                case 18: goto L_0x0411;
                case 19: goto L_0x0404;
                case 20: goto L_0x03f7;
                case 21: goto L_0x03ea;
                case 22: goto L_0x03dd;
                case 23: goto L_0x03d0;
                case 24: goto L_0x03c3;
                case 25: goto L_0x03b7;
                case 26: goto L_0x03ab;
                case 27: goto L_0x039b;
                case 28: goto L_0x038f;
                case 29: goto L_0x0382;
                case 30: goto L_0x0376;
                case 31: goto L_0x036a;
                case 32: goto L_0x035e;
                case 33: goto L_0x0352;
                case 34: goto L_0x0343;
                case 35: goto L_0x0325;
                case 36: goto L_0x0307;
                case 37: goto L_0x02e9;
                case 38: goto L_0x02cb;
                case 39: goto L_0x02ad;
                case 40: goto L_0x028f;
                case 41: goto L_0x0271;
                case 42: goto L_0x0253;
                case 43: goto L_0x0235;
                case 44: goto L_0x0218;
                case 45: goto L_0x01fb;
                case 46: goto L_0x01de;
                case 47: goto L_0x01c1;
                case 48: goto L_0x01a1;
                case 49: goto L_0x0191;
                case 50: goto L_0x0181;
                case 51: goto L_0x0173;
                case 52: goto L_0x0167;
                case 53: goto L_0x0157;
                case 54: goto L_0x0147;
                case 55: goto L_0x0137;
                case 56: goto L_0x012b;
                case 57: goto L_0x011f;
                case 58: goto L_0x0112;
                case 59: goto L_0x00f4;
                case 60: goto L_0x00e1;
                case 61: goto L_0x00d0;
                case 62: goto L_0x00c1;
                case 63: goto L_0x00b2;
                case 64: goto L_0x00a5;
                case 65: goto L_0x009a;
                case 66: goto L_0x008b;
                case 67: goto L_0x007c;
                case 68: goto L_0x0064;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x0079
        L_0x0064:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.MessageLite r3 = (androidx.datastore.preferences.protobuf.MessageLite) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.o(r5)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.A(r9, r3, r4)
        L_0x0078:
            int r6 = r6 + r3
        L_0x0079:
            r10 = 0
            goto L_0x051d
        L_0x007c:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            long r3 = T(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.Z(r9, r3)
            goto L_0x0078
        L_0x008b:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = S(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r9, r3)
            goto L_0x0078
        L_0x009a:
            boolean r8 = r0.B(r1, r9, r5)
            if (r8 == 0) goto L_0x0079
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9, r3)
            goto L_0x0078
        L_0x00a5:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            r3 = 0
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.T(r9, r3)
        L_0x00b0:
            int r6 = r6 + r4
            goto L_0x0079
        L_0x00b2:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = S(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.s(r9, r3)
            goto L_0x0078
        L_0x00c1:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = S(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.e0(r9, r3)
            goto L_0x0078
        L_0x00d0:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.o(r9, r3)
            goto L_0x0078
        L_0x00e1:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.Schema r4 = r0.o(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.o(r9, r3, r4)
            goto L_0x0078
        L_0x00f4:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r12)
            boolean r4 = r3 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r4 == 0) goto L_0x010a
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.o(r9, r3)
            goto L_0x0078
        L_0x010a:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.b0(r9, r3)
            goto L_0x0078
        L_0x0112:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            r3 = 1
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.l(r9, r3)
            goto L_0x0078
        L_0x011f:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            r3 = 0
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.u(r9, r3)
            goto L_0x00b0
        L_0x012b:
            boolean r8 = r0.B(r1, r9, r5)
            if (r8 == 0) goto L_0x0079
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.w(r9, r3)
            goto L_0x0078
        L_0x0137:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = S(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.D(r9, r3)
            goto L_0x0078
        L_0x0147:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            long r3 = T(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.g0(r9, r3)
            goto L_0x0078
        L_0x0157:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            long r3 = T(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.F(r9, r3)
            goto L_0x0078
        L_0x0167:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.y(r9, r8)
            goto L_0x0078
        L_0x0173:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            r3 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.q(r9, r3)
            goto L_0x0078
        L_0x0181:
            androidx.datastore.preferences.protobuf.MapFieldSchema r3 = r0.q
            java.lang.Object r4 = r2.getObject(r1, r12)
            java.lang.Object r8 = r0.n(r5)
            int r3 = r3.getSerializedSize(r9, r4, r8)
            goto L_0x0078
        L_0x0191:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.o(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.j(r9, r3, r4)
            goto L_0x0078
        L_0x01a1:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.t(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x01b5
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x01b5:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
        L_0x01bd:
            int r4 = r4 + r8
            int r4 = r4 + r3
            goto L_0x00b0
        L_0x01c1:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.r(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x01d5
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x01d5:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
            goto L_0x01bd
        L_0x01de:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x01f2
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x01f2:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
            goto L_0x01bd
        L_0x01fb:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x020f
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x020f:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
            goto L_0x01bd
        L_0x0218:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.e(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x022c
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x022c:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
            goto L_0x01bd
        L_0x0235:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.w(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x0249
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x0249:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
            goto L_0x01bd
        L_0x0253:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.b(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x0267
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x0267:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
            goto L_0x01bd
        L_0x0271:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x0285
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x0285:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
            goto L_0x01bd
        L_0x028f:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x02a3
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x02a3:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
            goto L_0x01bd
        L_0x02ad:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.l(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x02c1
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x02c1:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
            goto L_0x01bd
        L_0x02cb:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.y(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x02df
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x02df:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
            goto L_0x01bd
        L_0x02e9:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.n(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x02fd
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x02fd:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
            goto L_0x01bd
        L_0x0307:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x031b
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x031b:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
            goto L_0x01bd
        L_0x0325:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.i
            if (r4 == 0) goto L_0x0339
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x0339:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r3)
            goto L_0x01bd
        L_0x0343:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.s(r9, r3, r4)
        L_0x034e:
            int r6 = r6 + r3
            r10 = r4
            goto L_0x051d
        L_0x0352:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.q(r9, r3, r4)
            goto L_0x034e
        L_0x035e:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r9, r3, r4)
            goto L_0x034e
        L_0x036a:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r9, r3, r4)
            goto L_0x034e
        L_0x0376:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.d(r9, r3, r4)
            goto L_0x034e
        L_0x0382:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.v(r9, r3, r4)
            goto L_0x0078
        L_0x038f:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.c(r9, r3)
            goto L_0x0078
        L_0x039b:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.o(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.p(r9, r3, r4)
            goto L_0x0078
        L_0x03ab:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.u(r9, r3)
            goto L_0x0078
        L_0x03b7:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.a(r9, r3, r4)
            goto L_0x034e
        L_0x03c3:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r9, r3, r4)
            goto L_0x034e
        L_0x03d0:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r9, r3, r4)
            goto L_0x034e
        L_0x03dd:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.k(r9, r3, r4)
            goto L_0x034e
        L_0x03ea:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.x(r9, r3, r4)
            goto L_0x034e
        L_0x03f7:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.m(r9, r3, r4)
            goto L_0x034e
        L_0x0404:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r9, r3, r4)
            goto L_0x034e
        L_0x0411:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r9, r3, r4)
            goto L_0x0078
        L_0x041e:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.MessageLite r3 = (androidx.datastore.preferences.protobuf.MessageLite) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.o(r5)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.A(r9, r3, r4)
            goto L_0x0078
        L_0x0432:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            long r3 = r2.getLong(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.Z(r9, r3)
            goto L_0x0078
        L_0x0440:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            int r3 = r2.getInt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r9, r3)
            goto L_0x0078
        L_0x044e:
            r10 = r7 & r14
            if (r10 == 0) goto L_0x0079
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9, r3)
            goto L_0x0078
        L_0x0458:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            r3 = 0
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.T(r9, r3)
            goto L_0x00b0
        L_0x0463:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            int r3 = r2.getInt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.s(r9, r3)
            goto L_0x0078
        L_0x0471:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            int r3 = r2.getInt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.e0(r9, r3)
            goto L_0x0078
        L_0x047f:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.o(r9, r3)
            goto L_0x0078
        L_0x048f:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.Schema r4 = r0.o(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.o(r9, r3, r4)
            goto L_0x0078
        L_0x04a1:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r12)
            boolean r4 = r3 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r4 == 0) goto L_0x04b5
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.o(r9, r3)
            goto L_0x0078
        L_0x04b5:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.b0(r9, r3)
            goto L_0x0078
        L_0x04bd:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            r3 = 1
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.l(r9, r3)
            goto L_0x0078
        L_0x04c8:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            r10 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.u(r9, r10)
        L_0x04d1:
            int r6 = r6 + r3
            goto L_0x051d
        L_0x04d3:
            r10 = 0
            r8 = r7 & r14
            if (r8 == 0) goto L_0x051d
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.w(r9, r3)
            goto L_0x04d1
        L_0x04dd:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051d
            int r3 = r2.getInt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.D(r9, r3)
            goto L_0x04d1
        L_0x04eb:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051d
            long r3 = r2.getLong(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.g0(r9, r3)
            goto L_0x04d1
        L_0x04f9:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051d
            long r3 = r2.getLong(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.F(r9, r3)
            goto L_0x04d1
        L_0x0507:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051d
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.y(r9, r8)
            goto L_0x04d1
        L_0x0511:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051d
            r3 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.q(r9, r3)
            goto L_0x04d1
        L_0x051d:
            int r5 = r5 + 3
            r4 = r15
            goto L_0x000a
        L_0x0522:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema r2 = r0.o
            int r2 = r0.s(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.f
            if (r2 == 0) goto L_0x0538
            androidx.datastore.preferences.protobuf.ExtensionSchema r0 = r0.p
            androidx.datastore.preferences.protobuf.FieldSet r0 = r0.c(r1)
            int r0 = r0.k()
            int r6 = r6 + r0
        L_0x0538:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.q(java.lang.Object):int");
    }

    public final void q0(Writer writer, int i2, Object obj, int i3) {
        if (obj != null) {
            writer.c(i2, this.q.forMapMetadata(n(i3)), this.q.forMapData(obj));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int r(java.lang.Object r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = s
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0008:
            int[] r6 = r0.f1119a
            int r6 = r6.length
            if (r4 >= r6) goto L_0x04ed
            int r6 = r15.m0(r4)
            int r7 = l0(r6)
            int r8 = r15.N(r4)
            long r9 = O(r6)
            androidx.datastore.preferences.protobuf.FieldType r6 = androidx.datastore.preferences.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r6 = r6.id()
            if (r7 < r6) goto L_0x0038
            androidx.datastore.preferences.protobuf.FieldType r6 = androidx.datastore.preferences.protobuf.FieldType.SINT64_LIST_PACKED
            int r6 = r6.id()
            if (r7 > r6) goto L_0x0038
            int[] r6 = r0.f1119a
            int r11 = r4 + 2
            r6 = r6[r11]
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r6 & r11
            goto L_0x0039
        L_0x0038:
            r6 = r3
        L_0x0039:
            r13 = 0
            r14 = 1
            r11 = 0
            switch(r7) {
                case 0: goto L_0x04db;
                case 1: goto L_0x04cf;
                case 2: goto L_0x04bf;
                case 3: goto L_0x04af;
                case 4: goto L_0x049f;
                case 5: goto L_0x0493;
                case 6: goto L_0x0487;
                case 7: goto L_0x047b;
                case 8: goto L_0x045d;
                case 9: goto L_0x0449;
                case 10: goto L_0x0437;
                case 11: goto L_0x0427;
                case 12: goto L_0x0417;
                case 13: goto L_0x040b;
                case 14: goto L_0x03ff;
                case 15: goto L_0x03ef;
                case 16: goto L_0x03df;
                case 17: goto L_0x03c9;
                case 18: goto L_0x03bf;
                case 19: goto L_0x03b5;
                case 20: goto L_0x03ab;
                case 21: goto L_0x03a1;
                case 22: goto L_0x0397;
                case 23: goto L_0x038d;
                case 24: goto L_0x0383;
                case 25: goto L_0x0379;
                case 26: goto L_0x036f;
                case 27: goto L_0x0361;
                case 28: goto L_0x0357;
                case 29: goto L_0x034d;
                case 30: goto L_0x0343;
                case 31: goto L_0x0339;
                case 32: goto L_0x032f;
                case 33: goto L_0x0325;
                case 34: goto L_0x031b;
                case 35: goto L_0x02fd;
                case 36: goto L_0x02df;
                case 37: goto L_0x02c1;
                case 38: goto L_0x02a3;
                case 39: goto L_0x0285;
                case 40: goto L_0x0267;
                case 41: goto L_0x0249;
                case 42: goto L_0x022b;
                case 43: goto L_0x020d;
                case 44: goto L_0x01f0;
                case 45: goto L_0x01d3;
                case 46: goto L_0x01b6;
                case 47: goto L_0x0199;
                case 48: goto L_0x0179;
                case 49: goto L_0x016b;
                case 50: goto L_0x015b;
                case 51: goto L_0x014d;
                case 52: goto L_0x0141;
                case 53: goto L_0x0131;
                case 54: goto L_0x0121;
                case 55: goto L_0x0111;
                case 56: goto L_0x0105;
                case 57: goto L_0x00f9;
                case 58: goto L_0x00ed;
                case 59: goto L_0x00cf;
                case 60: goto L_0x00bc;
                case 61: goto L_0x00ab;
                case 62: goto L_0x009c;
                case 63: goto L_0x008d;
                case 64: goto L_0x0082;
                case 65: goto L_0x0077;
                case 66: goto L_0x0068;
                case 67: goto L_0x0059;
                case 68: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x04e9
        L_0x0042:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r1, r9)
            androidx.datastore.preferences.protobuf.MessageLite r6 = (androidx.datastore.preferences.protobuf.MessageLite) r6
            androidx.datastore.preferences.protobuf.Schema r7 = r15.o(r4)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.A(r8, r6, r7)
        L_0x0056:
            int r5 = r5 + r6
            goto L_0x04e9
        L_0x0059:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            long r6 = T(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.Z(r8, r6)
            goto L_0x0056
        L_0x0068:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = S(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r8, r6)
            goto L_0x0056
        L_0x0077:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8, r11)
            goto L_0x0056
        L_0x0082:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.T(r8, r3)
            goto L_0x0056
        L_0x008d:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = S(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.s(r8, r6)
            goto L_0x0056
        L_0x009c:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = S(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.e0(r8, r6)
            goto L_0x0056
        L_0x00ab:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r1, r9)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.o(r8, r6)
            goto L_0x0056
        L_0x00bc:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r1, r9)
            androidx.datastore.preferences.protobuf.Schema r7 = r15.o(r4)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.o(r8, r6, r7)
            goto L_0x0056
        L_0x00cf:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r1, r9)
            boolean r7 = r6 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r7 == 0) goto L_0x00e5
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.o(r8, r6)
            goto L_0x0056
        L_0x00e5:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.b0(r8, r6)
            goto L_0x0056
        L_0x00ed:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.l(r8, r14)
            goto L_0x0056
        L_0x00f9:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.u(r8, r3)
            goto L_0x0056
        L_0x0105:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.w(r8, r11)
            goto L_0x0056
        L_0x0111:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = S(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.D(r8, r6)
            goto L_0x0056
        L_0x0121:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            long r6 = T(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.g0(r8, r6)
            goto L_0x0056
        L_0x0131:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            long r6 = T(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.F(r8, r6)
            goto L_0x0056
        L_0x0141:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.y(r8, r13)
            goto L_0x0056
        L_0x014d:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04e9
            r6 = 0
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.q(r8, r6)
            goto L_0x0056
        L_0x015b:
            androidx.datastore.preferences.protobuf.MapFieldSchema r6 = r0.q
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r1, r9)
            java.lang.Object r9 = r15.n(r4)
            int r6 = r6.getSerializedSize(r8, r7, r9)
            goto L_0x0056
        L_0x016b:
            java.util.List r6 = D(r1, r9)
            androidx.datastore.preferences.protobuf.Schema r7 = r15.o(r4)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.j(r8, r6, r7)
            goto L_0x0056
        L_0x0179:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.t(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x018d
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x018d:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
        L_0x0195:
            int r6 = r6 + r8
            int r6 = r6 + r7
            goto L_0x0056
        L_0x0199:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.r(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x01ad
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01ad:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
            goto L_0x0195
        L_0x01b6:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x01ca
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01ca:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
            goto L_0x0195
        L_0x01d3:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x01e7
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01e7:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
            goto L_0x0195
        L_0x01f0:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.e(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x0204
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0204:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
            goto L_0x0195
        L_0x020d:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.w(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x0221
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0221:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
            goto L_0x0195
        L_0x022b:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.b(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x023f
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x023f:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
            goto L_0x0195
        L_0x0249:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x025d
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x025d:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
            goto L_0x0195
        L_0x0267:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x027b
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x027b:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
            goto L_0x0195
        L_0x0285:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.l(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x0299
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0299:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
            goto L_0x0195
        L_0x02a3:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.y(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x02b7
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02b7:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
            goto L_0x0195
        L_0x02c1:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.n(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x02d5
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02d5:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
            goto L_0x0195
        L_0x02df:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x02f3
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02f3:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
            goto L_0x0195
        L_0x02fd:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r7)
            if (r7 <= 0) goto L_0x04e9
            boolean r9 = r0.i
            if (r9 == 0) goto L_0x0311
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0311:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.f0(r7)
            goto L_0x0195
        L_0x031b:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.s(r8, r6, r3)
            goto L_0x0056
        L_0x0325:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.q(r8, r6, r3)
            goto L_0x0056
        L_0x032f:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r8, r6, r3)
            goto L_0x0056
        L_0x0339:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r8, r6, r3)
            goto L_0x0056
        L_0x0343:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.d(r8, r6, r3)
            goto L_0x0056
        L_0x034d:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.v(r8, r6, r3)
            goto L_0x0056
        L_0x0357:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.c(r8, r6)
            goto L_0x0056
        L_0x0361:
            java.util.List r6 = D(r1, r9)
            androidx.datastore.preferences.protobuf.Schema r7 = r15.o(r4)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.p(r8, r6, r7)
            goto L_0x0056
        L_0x036f:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.u(r8, r6)
            goto L_0x0056
        L_0x0379:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.a(r8, r6, r3)
            goto L_0x0056
        L_0x0383:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r8, r6, r3)
            goto L_0x0056
        L_0x038d:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r8, r6, r3)
            goto L_0x0056
        L_0x0397:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.k(r8, r6, r3)
            goto L_0x0056
        L_0x03a1:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.x(r8, r6, r3)
            goto L_0x0056
        L_0x03ab:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.m(r8, r6, r3)
            goto L_0x0056
        L_0x03b5:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r8, r6, r3)
            goto L_0x0056
        L_0x03bf:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r8, r6, r3)
            goto L_0x0056
        L_0x03c9:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r1, r9)
            androidx.datastore.preferences.protobuf.MessageLite r6 = (androidx.datastore.preferences.protobuf.MessageLite) r6
            androidx.datastore.preferences.protobuf.Schema r7 = r15.o(r4)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.A(r8, r6, r7)
            goto L_0x0056
        L_0x03df:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            long r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.Z(r8, r6)
            goto L_0x0056
        L_0x03ef:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.B(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r8, r6)
            goto L_0x0056
        L_0x03ff:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8, r11)
            goto L_0x0056
        L_0x040b:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.T(r8, r3)
            goto L_0x0056
        L_0x0417:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.B(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.s(r8, r6)
            goto L_0x0056
        L_0x0427:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.B(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.e0(r8, r6)
            goto L_0x0056
        L_0x0437:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r1, r9)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.o(r8, r6)
            goto L_0x0056
        L_0x0449:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r1, r9)
            androidx.datastore.preferences.protobuf.Schema r7 = r15.o(r4)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.o(r8, r6, r7)
            goto L_0x0056
        L_0x045d:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r1, r9)
            boolean r7 = r6 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r7 == 0) goto L_0x0473
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.o(r8, r6)
            goto L_0x0056
        L_0x0473:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.b0(r8, r6)
            goto L_0x0056
        L_0x047b:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.l(r8, r14)
            goto L_0x0056
        L_0x0487:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.u(r8, r3)
            goto L_0x0056
        L_0x0493:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.w(r8, r11)
            goto L_0x0056
        L_0x049f:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.B(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.D(r8, r6)
            goto L_0x0056
        L_0x04af:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            long r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.g0(r8, r6)
            goto L_0x0056
        L_0x04bf:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            long r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.F(r8, r6)
            goto L_0x0056
        L_0x04cf:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.y(r8, r13)
            goto L_0x0056
        L_0x04db:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04e9
            r6 = 0
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.q(r8, r6)
            goto L_0x0056
        L_0x04e9:
            int r4 = r4 + 3
            goto L_0x0008
        L_0x04ed:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema r2 = r0.o
            int r0 = r15.s(r2, r1)
            int r5 = r5 + r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.r(java.lang.Object):int");
    }

    public final void r0(int i2, Object obj, Writer writer) {
        if (obj instanceof String) {
            writer.writeString(i2, (String) obj);
        } else {
            writer.a(i2, (ByteString) obj);
        }
    }

    public final int s(UnknownFieldSchema unknownFieldSchema, Object obj) {
        return unknownFieldSchema.h(unknownFieldSchema.g(obj));
    }

    public final void s0(UnknownFieldSchema unknownFieldSchema, Object obj, Writer writer) {
        unknownFieldSchema.t(unknownFieldSchema.g(obj), writer);
    }

    public final boolean v(Object obj, int i2) {
        if (this.h) {
            int m0 = m0(i2);
            long O = O(m0);
            switch (l0(m0)) {
                case 0:
                    return UnsafeUtil.z(obj, O) != 0.0d;
                case 1:
                    return UnsafeUtil.A(obj, O) != 0.0f;
                case 2:
                    return UnsafeUtil.D(obj, O) != 0;
                case 3:
                    return UnsafeUtil.D(obj, O) != 0;
                case 4:
                    return UnsafeUtil.B(obj, O) != 0;
                case 5:
                    return UnsafeUtil.D(obj, O) != 0;
                case 6:
                    return UnsafeUtil.B(obj, O) != 0;
                case 7:
                    return UnsafeUtil.s(obj, O);
                case 8:
                    Object F = UnsafeUtil.F(obj, O);
                    if (F instanceof String) {
                        return !((String) F).isEmpty();
                    }
                    if (F instanceof ByteString) {
                        return !ByteString.EMPTY.equals(F);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return UnsafeUtil.F(obj, O) != null;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.F(obj, O));
                case 11:
                    return UnsafeUtil.B(obj, O) != 0;
                case 12:
                    return UnsafeUtil.B(obj, O) != 0;
                case 13:
                    return UnsafeUtil.B(obj, O) != 0;
                case 14:
                    return UnsafeUtil.D(obj, O) != 0;
                case 15:
                    return UnsafeUtil.B(obj, O) != 0;
                case 16:
                    return UnsafeUtil.D(obj, O) != 0;
                case 17:
                    return UnsafeUtil.F(obj, O) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int b0 = b0(i2);
            return (UnsafeUtil.B(obj, (long) (b0 & 1048575)) & (1 << (b0 >>> 20))) != 0;
        }
    }

    public final boolean w(Object obj, int i2, int i3, int i4) {
        return this.h ? v(obj, i2) : (i3 & i4) != 0;
    }

    public final boolean y(Object obj, int i2, int i3) {
        List list = (List) UnsafeUtil.F(obj, O(i2));
        if (list.isEmpty()) {
            return true;
        }
        Schema o2 = o(i3);
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (!o2.isInitialized(list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    public final boolean z(Object obj, int i2, int i3) {
        Map forMapData = this.q.forMapData(UnsafeUtil.F(obj, O(i2)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.q.forMapMetadata(n(i3)).c.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema schema = null;
        for (Object next : forMapData.values()) {
            if (schema == null) {
                schema = Protobuf.a().d(next.getClass());
            }
            if (!schema.isInitialized(next)) {
                return false;
            }
        }
        return true;
    }
}
