package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.LazyField;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.util.Iterator;
import java.util.Map;

final class MessageSetSchema<T> implements Schema<T> {

    /* renamed from: a  reason: collision with root package name */
    public final MessageLite f1121a;
    public final UnknownFieldSchema b;
    public final boolean c;
    public final ExtensionSchema d;

    public MessageSetSchema(UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MessageLite messageLite) {
        this.b = unknownFieldSchema;
        this.c = extensionSchema.e(messageLite);
        this.d = extensionSchema;
        this.f1121a = messageLite;
    }

    private int d(UnknownFieldSchema unknownFieldSchema, Object obj) {
        return unknownFieldSchema.i(unknownFieldSchema.g(obj));
    }

    private void e(UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        Object f = unknownFieldSchema.f(obj);
        FieldSet d2 = extensionSchema.d(obj);
        do {
            try {
                if (reader.getFieldNumber() == Integer.MAX_VALUE) {
                    unknownFieldSchema.o(obj, f);
                    return;
                }
            } finally {
                unknownFieldSchema.o(obj, f);
            }
        } while (g(reader, extensionRegistryLite, extensionSchema, d2, unknownFieldSchema, f));
    }

    public static MessageSetSchema f(UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MessageLite messageLite) {
        return new MessageSetSchema(unknownFieldSchema, extensionSchema, messageLite);
    }

    public void a(Object obj, Writer writer) {
        Iterator r = this.d.c(obj).r();
        while (r.hasNext()) {
            Map.Entry entry = (Map.Entry) r.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) entry.getKey();
            if (fieldDescriptorLite.getLiteJavaType() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof LazyField.LazyEntry) {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), ((LazyField.LazyEntry) entry).a().e());
            } else {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), entry.getValue());
            }
        }
        h(this.b, obj, writer);
    }

    public void b(Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        e(this.b, this.d, obj, reader, extensionRegistryLite);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(java.lang.Object r11, byte[] r12, int r13, int r14, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r15) {
        /*
            r10 = this;
            r0 = r11
            androidx.datastore.preferences.protobuf.GeneratedMessageLite r0 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite) r0
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r1 = r0.unknownFields
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r2 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.e()
            if (r1 != r2) goto L_0x0011
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r1 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.l()
            r0.unknownFields = r1
        L_0x0011:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage r11 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage) r11
            androidx.datastore.preferences.protobuf.FieldSet r11 = r11.C()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r13 >= r14) goto L_0x00d7
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r13, r15)
            int r13 = r15.f1052a
            int r3 = androidx.datastore.preferences.protobuf.WireFormat.f1162a
            r5 = 2
            if (r13 == r3) goto L_0x006b
            int r3 = androidx.datastore.preferences.protobuf.WireFormat.b(r13)
            if (r3 != r5) goto L_0x0066
            androidx.datastore.preferences.protobuf.ExtensionSchema r2 = r10.d
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r3 = r15.d
            androidx.datastore.preferences.protobuf.MessageLite r5 = r10.f1121a
            int r6 = androidx.datastore.preferences.protobuf.WireFormat.a(r13)
            java.lang.Object r2 = r2.b(r3, r5, r6)
            r8 = r2
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension r8 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension) r8
            if (r8 == 0) goto L_0x005c
            androidx.datastore.preferences.protobuf.Protobuf r13 = androidx.datastore.preferences.protobuf.Protobuf.a()
            androidx.datastore.preferences.protobuf.MessageLite r2 = r8.b()
            java.lang.Class r2 = r2.getClass()
            androidx.datastore.preferences.protobuf.Schema r13 = r13.d(r2)
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r13, r12, r4, r14, r15)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r2 = r8.b
            java.lang.Object r3 = r15.c
            r11.w(r2, r3)
        L_0x005a:
            r2 = r8
            goto L_0x0019
        L_0x005c:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.G(r2, r3, r4, r5, r6, r7)
            goto L_0x005a
        L_0x0066:
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.N(r13, r12, r4, r14, r15)
            goto L_0x0019
        L_0x006b:
            r13 = 0
            r3 = r0
        L_0x006d:
            if (r4 >= r14) goto L_0x00cb
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r4, r15)
            int r6 = r15.f1052a
            int r7 = androidx.datastore.preferences.protobuf.WireFormat.a(r6)
            int r8 = androidx.datastore.preferences.protobuf.WireFormat.b(r6)
            if (r7 == r5) goto L_0x00ac
            r9 = 3
            if (r7 == r9) goto L_0x0083
            goto L_0x00c1
        L_0x0083:
            if (r2 == 0) goto L_0x00a1
            androidx.datastore.preferences.protobuf.Protobuf r6 = androidx.datastore.preferences.protobuf.Protobuf.a()
            androidx.datastore.preferences.protobuf.MessageLite r7 = r2.b()
            java.lang.Class r7 = r7.getClass()
            androidx.datastore.preferences.protobuf.Schema r6 = r6.d(r7)
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r6, r12, r4, r14, r15)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r6 = r2.b
            java.lang.Object r7 = r15.c
            r11.w(r6, r7)
            goto L_0x006d
        L_0x00a1:
            if (r8 != r5) goto L_0x00c1
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.b(r12, r4, r15)
            java.lang.Object r3 = r15.c
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            goto L_0x006d
        L_0x00ac:
            if (r8 != 0) goto L_0x00c1
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r4, r15)
            int r13 = r15.f1052a
            androidx.datastore.preferences.protobuf.ExtensionSchema r2 = r10.d
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r6 = r15.d
            androidx.datastore.preferences.protobuf.MessageLite r7 = r10.f1121a
            java.lang.Object r2 = r2.b(r6, r7, r13)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension r2 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension) r2
            goto L_0x006d
        L_0x00c1:
            int r7 = androidx.datastore.preferences.protobuf.WireFormat.b
            if (r6 != r7) goto L_0x00c6
            goto L_0x00cb
        L_0x00c6:
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.N(r6, r12, r4, r14, r15)
            goto L_0x006d
        L_0x00cb:
            if (r3 == 0) goto L_0x00d4
            int r13 = androidx.datastore.preferences.protobuf.WireFormat.c(r13, r5)
            r1.n(r13, r3)
        L_0x00d4:
            r13 = r4
            goto L_0x0019
        L_0x00d7:
            if (r13 != r14) goto L_0x00da
            return
        L_0x00da:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r10 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSetSchema.c(java.lang.Object, byte[], int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):void");
    }

    public boolean equals(Object obj, Object obj2) {
        if (!this.b.g(obj).equals(this.b.g(obj2))) {
            return false;
        }
        if (this.c) {
            return this.d.c(obj).equals(this.d.c(obj2));
        }
        return true;
    }

    public final boolean g(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema extensionSchema, FieldSet fieldSet, UnknownFieldSchema unknownFieldSchema, Object obj) {
        int tag = reader.getTag();
        if (tag == WireFormat.f1162a) {
            Object obj2 = null;
            int i = 0;
            ByteString byteString = null;
            while (reader.getFieldNumber() != Integer.MAX_VALUE) {
                int tag2 = reader.getTag();
                if (tag2 == WireFormat.c) {
                    i = reader.readUInt32();
                    obj2 = extensionSchema.b(extensionRegistryLite, this.f1121a, i);
                } else if (tag2 == WireFormat.d) {
                    if (obj2 != null) {
                        extensionSchema.h(reader, obj2, extensionRegistryLite, fieldSet);
                    } else {
                        byteString = reader.readBytes();
                    }
                } else if (!reader.skipField()) {
                    break;
                }
            }
            if (reader.getTag() == WireFormat.b) {
                if (byteString != null) {
                    if (obj2 != null) {
                        extensionSchema.i(byteString, obj2, extensionRegistryLite, fieldSet);
                    } else {
                        unknownFieldSchema.d(obj, i, byteString);
                    }
                }
                return true;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        } else if (WireFormat.b(tag) != 2) {
            return reader.skipField();
        } else {
            Object b2 = extensionSchema.b(extensionRegistryLite, this.f1121a, WireFormat.a(tag));
            if (b2 == null) {
                return unknownFieldSchema.m(obj, reader);
            }
            extensionSchema.h(reader, b2, extensionRegistryLite, fieldSet);
            return true;
        }
    }

    public int getSerializedSize(Object obj) {
        int d2 = d(this.b, obj);
        return this.c ? d2 + this.d.c(obj).i() : d2;
    }

    public final void h(UnknownFieldSchema unknownFieldSchema, Object obj, Writer writer) {
        unknownFieldSchema.s(unknownFieldSchema.g(obj), writer);
    }

    public int hashCode(Object obj) {
        int hashCode = this.b.g(obj).hashCode();
        return this.c ? (hashCode * 53) + this.d.c(obj).hashCode() : hashCode;
    }

    public final boolean isInitialized(Object obj) {
        return this.d.c(obj).o();
    }

    public void makeImmutable(Object obj) {
        this.b.j(obj);
        this.d.f(obj);
    }

    public void mergeFrom(Object obj, Object obj2) {
        SchemaUtil.G(this.b, obj, obj2);
        if (this.c) {
            SchemaUtil.E(this.d, obj, obj2);
        }
    }

    public Object newInstance() {
        return this.f1121a.newBuilderForType().buildPartial();
    }
}
