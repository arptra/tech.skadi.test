package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Descriptors;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistry;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class ExtensionSchemaFull extends ExtensionSchema<Descriptors.FieldDescriptor> {
    private static final long EXTENSION_FIELD_OFFSET = getExtensionsFieldOffset();

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f9704a = 0;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

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
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType[] r0 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull.AnonymousClass1.<clinit>():void");
        }
    }

    private static <T> long getExtensionsFieldOffset() {
        try {
            return UnsafeUtil.objectFieldOffset(GeneratedMessageV3.ExtendableMessage.class.getDeclaredField("extensions"));
        } catch (Throwable unused) {
            throw new IllegalStateException("Unable to lookup extension field offset");
        }
    }

    public int extensionNumber(Map.Entry<?, ?> entry) {
        return ((Descriptors.FieldDescriptor) entry.getKey()).getNumber();
    }

    public Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i) {
        return ((ExtensionRegistry) extensionRegistryLite).findExtensionByNumber(((Message) messageLite).getDescriptorForType(), i);
    }

    public FieldSet<Descriptors.FieldDescriptor> getExtensions(Object obj) {
        return (FieldSet) UnsafeUtil.getObject(obj, EXTENSION_FIELD_OFFSET);
    }

    public FieldSet<Descriptors.FieldDescriptor> getMutableExtensions(Object obj) {
        FieldSet<Descriptors.FieldDescriptor> extensions = getExtensions(obj);
        if (!extensions.isImmutable()) {
            return extensions;
        }
        FieldSet<Descriptors.FieldDescriptor> clone = extensions.clone();
        setExtensions(obj, clone);
        return clone;
    }

    public boolean hasExtensions(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageV3.ExtendableMessage;
    }

    public void makeImmutable(Object obj) {
        getExtensions(obj).makeImmutable();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0084, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f3, code lost:
        r6.setField(r4.descriptor, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <UT, UB> UB parseExtension(com.google.crypto.tink.shaded.protobuf.Reader r3, java.lang.Object r4, com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r5, com.google.crypto.tink.shaded.protobuf.FieldSet<com.google.crypto.tink.shaded.protobuf.Descriptors.FieldDescriptor> r6, UB r7, com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<UT, UB> r8) throws java.io.IOException {
        /*
            r2 = this;
            com.google.crypto.tink.shaded.protobuf.ExtensionRegistry$ExtensionInfo r4 = (com.google.crypto.tink.shaded.protobuf.ExtensionRegistry.ExtensionInfo) r4
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r2 = r4.descriptor
            int r2 = r2.getNumber()
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r0 = r4.descriptor
            boolean r0 = r0.isRepeated()
            if (r0 == 0) goto L_0x00fa
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r0 = r4.descriptor
            boolean r0 = r0.isPacked()
            if (r0 == 0) goto L_0x00fa
            int[] r5 = com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r0 = r4.descriptor
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r0 = r0.getLiteType()
            int r0 = r0.ordinal()
            r5 = r5[r0]
            switch(r5) {
                case 1: goto L_0x00ea;
                case 2: goto L_0x00e1;
                case 3: goto L_0x00d8;
                case 4: goto L_0x00cf;
                case 5: goto L_0x00c6;
                case 6: goto L_0x00bd;
                case 7: goto L_0x00b4;
                case 8: goto L_0x00ab;
                case 9: goto L_0x00a2;
                case 10: goto L_0x0099;
                case 11: goto L_0x0090;
                case 12: goto L_0x0087;
                case 13: goto L_0x007c;
                case 14: goto L_0x0046;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Type cannot be packed: "
            r3.append(r5)
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r4 = r4.descriptor
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r4 = r4.getLiteType()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x0046:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r3.readEnumList(r5)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x0057:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00f3
            java.lang.Object r0 = r5.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r1 = r4.descriptor
            com.google.crypto.tink.shaded.protobuf.Descriptors$EnumDescriptor r1 = r1.getEnumType()
            com.google.crypto.tink.shaded.protobuf.Descriptors$EnumValueDescriptor r1 = r1.findValueByNumber((int) r0)
            if (r1 == 0) goto L_0x0077
            r3.add(r1)
            goto L_0x0057
        L_0x0077:
            java.lang.Object r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.storeUnknownEnum(r2, r0, r7, r8)
            goto L_0x0057
        L_0x007c:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.readSInt64List(r2)
        L_0x0084:
            r3 = r2
            goto L_0x00f3
        L_0x0087:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.readSInt32List(r2)
            goto L_0x0084
        L_0x0090:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.readSFixed64List(r2)
            goto L_0x0084
        L_0x0099:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.readSFixed32List(r2)
            goto L_0x0084
        L_0x00a2:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.readUInt32List(r2)
            goto L_0x0084
        L_0x00ab:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.readBoolList(r2)
            goto L_0x0084
        L_0x00b4:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.readFixed32List(r2)
            goto L_0x0084
        L_0x00bd:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.readFixed64List(r2)
            goto L_0x0084
        L_0x00c6:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.readInt32List(r2)
            goto L_0x0084
        L_0x00cf:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.readUInt64List(r2)
            goto L_0x0084
        L_0x00d8:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.readInt64List(r2)
            goto L_0x0084
        L_0x00e1:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.readFloatList(r2)
            goto L_0x0084
        L_0x00ea:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.readDoubleList(r2)
            goto L_0x0084
        L_0x00f3:
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r2 = r4.descriptor
            r6.setField(r2, r3)
            goto L_0x0204
        L_0x00fa:
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r0 = r4.descriptor
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r0 = r0.getLiteType()
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.ENUM
            if (r0 != r1) goto L_0x0119
            int r3 = r3.readInt32()
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r5 = r4.descriptor
            com.google.crypto.tink.shaded.protobuf.Descriptors$EnumDescriptor r5 = r5.getEnumType()
            com.google.crypto.tink.shaded.protobuf.Descriptors$EnumValueDescriptor r5 = r5.findValueByNumber((int) r3)
            if (r5 != 0) goto L_0x01ce
            java.lang.Object r2 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.storeUnknownEnum(r2, r3, r7, r8)
            return r2
        L_0x0119:
            int[] r2 = com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r8 = r4.descriptor
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r8 = r8.getLiteType()
            int r8 = r8.ordinal()
            r2 = r2[r8]
            switch(r2) {
                case 1: goto L_0x01c6;
                case 2: goto L_0x01bd;
                case 3: goto L_0x01b4;
                case 4: goto L_0x01ab;
                case 5: goto L_0x01a2;
                case 6: goto L_0x0199;
                case 7: goto L_0x0190;
                case 8: goto L_0x0187;
                case 9: goto L_0x017e;
                case 10: goto L_0x0175;
                case 11: goto L_0x016c;
                case 12: goto L_0x0163;
                case 13: goto L_0x0159;
                case 14: goto L_0x0151;
                case 15: goto L_0x014b;
                case 16: goto L_0x0145;
                case 17: goto L_0x0139;
                case 18: goto L_0x012d;
                default: goto L_0x012a;
            }
        L_0x012a:
            r5 = 0
            goto L_0x01ce
        L_0x012d:
            com.google.crypto.tink.shaded.protobuf.Message r2 = r4.defaultInstance
            java.lang.Class r2 = r2.getClass()
            java.lang.Object r5 = r3.readMessage(r2, r5)
            goto L_0x01ce
        L_0x0139:
            com.google.crypto.tink.shaded.protobuf.Message r2 = r4.defaultInstance
            java.lang.Class r2 = r2.getClass()
            java.lang.Object r5 = r3.readGroup(r2, r5)
            goto L_0x01ce
        L_0x0145:
            java.lang.String r5 = r3.readString()
            goto L_0x01ce
        L_0x014b:
            com.google.crypto.tink.shaded.protobuf.ByteString r5 = r3.readBytes()
            goto L_0x01ce
        L_0x0151:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "Shouldn't reach here."
            r2.<init>(r3)
            throw r2
        L_0x0159:
            long r2 = r3.readSInt64()
            java.lang.Long r5 = java.lang.Long.valueOf(r2)
            goto L_0x01ce
        L_0x0163:
            int r2 = r3.readSInt32()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            goto L_0x01ce
        L_0x016c:
            long r2 = r3.readSFixed64()
            java.lang.Long r5 = java.lang.Long.valueOf(r2)
            goto L_0x01ce
        L_0x0175:
            int r2 = r3.readSFixed32()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            goto L_0x01ce
        L_0x017e:
            int r2 = r3.readUInt32()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            goto L_0x01ce
        L_0x0187:
            boolean r2 = r3.readBool()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)
            goto L_0x01ce
        L_0x0190:
            int r2 = r3.readFixed32()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            goto L_0x01ce
        L_0x0199:
            long r2 = r3.readFixed64()
            java.lang.Long r5 = java.lang.Long.valueOf(r2)
            goto L_0x01ce
        L_0x01a2:
            int r2 = r3.readInt32()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            goto L_0x01ce
        L_0x01ab:
            long r2 = r3.readUInt64()
            java.lang.Long r5 = java.lang.Long.valueOf(r2)
            goto L_0x01ce
        L_0x01b4:
            long r2 = r3.readInt64()
            java.lang.Long r5 = java.lang.Long.valueOf(r2)
            goto L_0x01ce
        L_0x01bd:
            float r2 = r3.readFloat()
            java.lang.Float r5 = java.lang.Float.valueOf(r2)
            goto L_0x01ce
        L_0x01c6:
            double r2 = r3.readDouble()
            java.lang.Double r5 = java.lang.Double.valueOf(r2)
        L_0x01ce:
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r2 = r4.descriptor
            boolean r2 = r2.isRepeated()
            if (r2 == 0) goto L_0x01dc
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r2 = r4.descriptor
            r6.addRepeatedField(r2, r5)
            goto L_0x0204
        L_0x01dc:
            int[] r2 = com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r3 = r4.descriptor
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r3 = r3.getLiteType()
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 17
            if (r2 == r3) goto L_0x01f3
            r3 = 18
            if (r2 == r3) goto L_0x01f3
            goto L_0x01ff
        L_0x01f3:
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r2 = r4.descriptor
            java.lang.Object r2 = r6.getField(r2)
            if (r2 == 0) goto L_0x01ff
            java.lang.Object r5 = com.google.crypto.tink.shaded.protobuf.Internal.mergeMessage(r2, r5)
        L_0x01ff:
            com.google.crypto.tink.shaded.protobuf.Descriptors$FieldDescriptor r2 = r4.descriptor
            r6.setField(r2, r5)
        L_0x0204:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull.parseExtension(com.google.crypto.tink.shaded.protobuf.Reader, java.lang.Object, com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite, com.google.crypto.tink.shaded.protobuf.FieldSet, java.lang.Object, com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema):java.lang.Object");
    }

    public void parseLengthPrefixedMessageSetItem(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> fieldSet) throws IOException {
        ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo) obj;
        if (ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            fieldSet.setField(extensionInfo.descriptor, reader.readMessage(extensionInfo.defaultInstance.getClass(), extensionRegistryLite));
            return;
        }
        fieldSet.setField(extensionInfo.descriptor, new LazyField(extensionInfo.defaultInstance, extensionRegistryLite, reader.readBytes()));
    }

    public void parseMessageSetItem(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> fieldSet) throws IOException {
        ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo) obj;
        Message buildPartial = extensionInfo.defaultInstance.newBuilderForType().buildPartial();
        if (ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            BinaryReader newInstance = BinaryReader.newInstance(ByteBuffer.wrap(byteString.toByteArray()), true);
            Protobuf.getInstance().mergeFrom(buildPartial, newInstance, extensionRegistryLite);
            fieldSet.setField(extensionInfo.descriptor, buildPartial);
            if (newInstance.getFieldNumber() != Integer.MAX_VALUE) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
            return;
        }
        fieldSet.setField(extensionInfo.descriptor, new LazyField(extensionInfo.defaultInstance, extensionRegistryLite, byteString));
    }

    public void serializeExtension(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) entry.getKey();
        if (fieldDescriptor.isRepeated()) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldDescriptor.getLiteType().ordinal()]) {
                case 1:
                    SchemaUtil.writeDoubleList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 2:
                    SchemaUtil.writeFloatList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 3:
                    SchemaUtil.writeInt64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 4:
                    SchemaUtil.writeUInt64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 5:
                    SchemaUtil.writeInt32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 6:
                    SchemaUtil.writeFixed64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 7:
                    SchemaUtil.writeFixed32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 8:
                    SchemaUtil.writeBoolList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 9:
                    SchemaUtil.writeUInt32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 10:
                    SchemaUtil.writeSFixed32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 11:
                    SchemaUtil.writeSFixed64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 12:
                    SchemaUtil.writeSInt32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 13:
                    SchemaUtil.writeSInt64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 14:
                    ArrayList arrayList = new ArrayList();
                    for (Descriptors.EnumValueDescriptor number : (List) entry.getValue()) {
                        arrayList.add(Integer.valueOf(number.getNumber()));
                    }
                    SchemaUtil.writeInt32List(fieldDescriptor.getNumber(), arrayList, writer, fieldDescriptor.isPacked());
                    return;
                case 15:
                    SchemaUtil.writeBytesList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 16:
                    SchemaUtil.writeStringList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 17:
                    SchemaUtil.writeGroupList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 18:
                    SchemaUtil.writeMessageList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                default:
                    return;
            }
        } else {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldDescriptor.getLiteType().ordinal()]) {
                case 1:
                    writer.writeDouble(fieldDescriptor.getNumber(), ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    writer.writeFloat(fieldDescriptor.getNumber(), ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    writer.writeInt64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    writer.writeUInt64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    writer.writeInt32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    writer.writeFixed64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    writer.writeFixed32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    writer.writeBool(fieldDescriptor.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    writer.writeUInt32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    writer.writeSFixed32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    writer.writeSFixed64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    writer.writeSInt32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    writer.writeSInt64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    writer.writeInt32(fieldDescriptor.getNumber(), ((Descriptors.EnumValueDescriptor) entry.getValue()).getNumber());
                    return;
                case 15:
                    writer.writeBytes(fieldDescriptor.getNumber(), (ByteString) entry.getValue());
                    return;
                case 16:
                    writer.writeString(fieldDescriptor.getNumber(), (String) entry.getValue());
                    return;
                case 17:
                    writer.writeGroup(fieldDescriptor.getNumber(), entry.getValue());
                    return;
                case 18:
                    writer.writeMessage(fieldDescriptor.getNumber(), entry.getValue());
                    return;
                default:
                    return;
            }
        }
    }

    public void setExtensions(Object obj, FieldSet<Descriptors.FieldDescriptor> fieldSet) {
        UnsafeUtil.putObject(obj, EXTENSION_FIELD_OFFSET, (Object) fieldSet);
    }
}
