package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected int memoizedSerializedSize = -1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.e();

    /* renamed from: androidx.datastore.preferences.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1092a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$JavaType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1092a = r0
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1092a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.GeneratedMessageLite.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        public final GeneratedMessageLite f1093a;
        public GeneratedMessageLite b;
        public boolean c = false;

        public Builder(GeneratedMessageLite generatedMessageLite) {
            this.f1093a = generatedMessageLite;
            this.b = (GeneratedMessageLite) generatedMessageLite.m(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        /* renamed from: n */
        public final GeneratedMessageLite build() {
            GeneratedMessageLite o = buildPartial();
            if (o.isInitialized()) {
                return o;
            }
            throw AbstractMessageLite.Builder.m(o);
        }

        /* renamed from: o */
        public GeneratedMessageLite buildPartial() {
            if (this.c) {
                return this.b;
            }
            this.b.u();
            this.c = true;
            return this.b;
        }

        /* renamed from: p */
        public Builder e() {
            Builder w = getDefaultInstanceForType().newBuilderForType();
            w.u(buildPartial());
            return w;
        }

        public void q() {
            if (this.c) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) this.b.m(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                x(generatedMessageLite, this.b);
                this.b = generatedMessageLite;
                this.c = false;
            }
        }

        /* renamed from: r */
        public GeneratedMessageLite getDefaultInstanceForType() {
            return this.f1093a;
        }

        /* renamed from: s */
        public Builder g(GeneratedMessageLite generatedMessageLite) {
            return u(generatedMessageLite);
        }

        /* renamed from: t */
        public Builder i(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            q();
            try {
                Protobuf.a().e(this.b).b(this.b, CodedInputStreamReader.h(codedInputStream), extensionRegistryLite);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public Builder u(GeneratedMessageLite generatedMessageLite) {
            q();
            x(this.b, generatedMessageLite);
            return this;
        }

        /* renamed from: v */
        public Builder l(byte[] bArr, int i, int i2) {
            return w(bArr, i, i2, ExtensionRegistryLite.b());
        }

        public Builder w(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
            q();
            try {
                Protobuf.a().e(this.b).c(this.b, bArr, i, i + i2, new ArrayDecoders.Registers(extensionRegistryLite));
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        public final void x(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2) {
            Protobuf.a().e(generatedMessageLite).mergeFrom(generatedMessageLite, generatedMessageLite2);
        }
    }

    public static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        public final GeneratedMessageLite b;

        public DefaultInstanceBasedParser(GeneratedMessageLite generatedMessageLite) {
            this.b = generatedMessageLite;
        }

        /* renamed from: g */
        public GeneratedMessageLite a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return GeneratedMessageLite.z(this.b, codedInputStream, extensionRegistryLite);
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        public void q() {
            if (this.c) {
                super.q();
                GeneratedMessageLite generatedMessageLite = this.b;
                ((ExtendableMessage) generatedMessageLite).extensions = ((ExtendableMessage) generatedMessageLite).extensions.clone();
            }
        }

        /* renamed from: y */
        public final ExtendableMessage o() {
            if (this.c) {
                return (ExtendableMessage) this.b;
            }
            ((ExtendableMessage) this.b).extensions.s();
            return (ExtendableMessage) super.buildPartial();
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions;

        public class ExtensionWriter {
        }

        public FieldSet C() {
            if (this.extensions.n()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return GeneratedMessageLite.super.getDefaultInstanceForType();
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return GeneratedMessageLite.super.newBuilderForType();
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return GeneratedMessageLite.super.toBuilder();
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
    }

    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Internal.EnumLiteMap f1094a;
        public final int b;
        public final WireFormat.FieldType c;
        public final boolean d;
        public final boolean e;

        /* renamed from: a */
        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.b - extensionDescriptor.b;
        }

        public MessageLite.Builder c(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).u((GeneratedMessageLite) messageLite);
        }

        public Internal.EnumLiteMap d() {
            return this.f1094a;
        }

        public WireFormat.JavaType getLiteJavaType() {
            return this.c.getJavaType();
        }

        public WireFormat.FieldType getLiteType() {
            return this.c;
        }

        public int getNumber() {
            return this.b;
        }

        public boolean isPacked() {
            return this.e;
        }

        public boolean isRepeated() {
            return this.d;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        public final MessageLite f1095a;
        public final ExtensionDescriptor b;

        public WireFormat.FieldType a() {
            return this.b.getLiteType();
        }

        public MessageLite b() {
            return this.f1095a;
        }

        public int c() {
            return this.b.getNumber();
        }

        public boolean d() {
            return this.b.d;
        }
    }

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        public SerializedForm(MessageLite messageLite) {
            Class<?> cls = messageLite.getClass();
            this.messageClass = cls;
            this.messageClassName = cls.getName();
            this.asBytes = messageLite.toByteArray();
        }

        public static SerializedForm of(MessageLite messageLite) {
            return new SerializedForm(messageLite);
        }

        @Deprecated
        private Object readResolveFallback() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get((Object) null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
            } catch (NoSuchFieldException e2) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e2);
            } catch (SecurityException e3) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Unable to call parsePartialFrom", e4);
            } catch (InvalidProtocolBufferException e5) {
                throw new RuntimeException("Unable to understand proto buffer", e5);
            }
        }

        private Class<?> resolveMessageClass() throws ClassNotFoundException {
            Class<?> cls = this.messageClass;
            return cls != null ? cls : Class.forName(this.messageClassName);
        }

        public Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get((Object) null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
            } catch (NoSuchFieldException unused) {
                return readResolveFallback();
            } catch (SecurityException e2) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Unable to call parsePartialFrom", e3);
            } catch (InvalidProtocolBufferException e4) {
                throw new RuntimeException("Unable to understand proto buffer", e4);
            }
        }
    }

    public static void A(Class cls, GeneratedMessageLite generatedMessageLite) {
        defaultInstanceMap.put(cls, generatedMessageLite);
    }

    public static GeneratedMessageLite k(GeneratedMessageLite generatedMessageLite) {
        if (generatedMessageLite == null || generatedMessageLite.isInitialized()) {
            return generatedMessageLite;
        }
        throw generatedMessageLite.g().asInvalidProtocolBufferException().setUnfinishedMessage(generatedMessageLite);
    }

    public static Internal.ProtobufList p() {
        return ProtobufArrayList.c();
    }

    public static GeneratedMessageLite q(Class cls) {
        GeneratedMessageLite generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (generatedMessageLite == null) {
            generatedMessageLite = ((GeneratedMessageLite) UnsafeUtil.j(cls)).getDefaultInstanceForType();
            if (generatedMessageLite != null) {
                defaultInstanceMap.put(cls, generatedMessageLite);
            } else {
                throw new IllegalStateException();
            }
        }
        return generatedMessageLite;
    }

    public static Object s(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static final boolean t(GeneratedMessageLite generatedMessageLite, boolean z) {
        byte byteValue = ((Byte) generatedMessageLite.m(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean isInitialized = Protobuf.a().e(generatedMessageLite).isInitialized(generatedMessageLite);
        if (z) {
            generatedMessageLite.n(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, isInitialized ? generatedMessageLite : null);
        }
        return isInitialized;
    }

    public static Internal.ProtobufList v(Internal.ProtobufList protobufList) {
        int size = protobufList.size();
        return protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    public static Object x(MessageLite messageLite, String str, Object[] objArr) {
        return new RawMessageInfo(messageLite, str, objArr);
    }

    public static GeneratedMessageLite y(GeneratedMessageLite generatedMessageLite, InputStream inputStream) {
        return k(z(generatedMessageLite, CodedInputStream.f(inputStream), ExtensionRegistryLite.b()));
    }

    public static GeneratedMessageLite z(GeneratedMessageLite generatedMessageLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        GeneratedMessageLite generatedMessageLite2 = (GeneratedMessageLite) generatedMessageLite.m(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            Schema e = Protobuf.a().e(generatedMessageLite2);
            e.b(generatedMessageLite2, CodedInputStreamReader.h(codedInputStream), extensionRegistryLite);
            e.makeImmutable(generatedMessageLite2);
            return generatedMessageLite2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(generatedMessageLite2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e3.getCause());
            }
            throw e3;
        }
    }

    /* renamed from: B */
    public final Builder toBuilder() {
        Builder builder = (Builder) m(MethodToInvoke.NEW_BUILDER);
        builder.u(this);
        return builder;
    }

    public void b(CodedOutputStream codedOutputStream) {
        Protobuf.a().e(this).a(this, CodedOutputStreamWriter.g(codedOutputStream));
    }

    public int d() {
        return this.memoizedSerializedSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return Protobuf.a().e(this).equals(this, (GeneratedMessageLite) obj);
    }

    public final Parser getParserForType() {
        return (Parser) m(MethodToInvoke.GET_PARSER);
    }

    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = Protobuf.a().e(this).getSerializedSize(this);
        }
        return this.memoizedSerializedSize;
    }

    public void h(int i) {
        this.memoizedSerializedSize = i;
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = Protobuf.a().e(this).hashCode(this);
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public final boolean isInitialized() {
        return t(this, true);
    }

    public Object j() {
        return m(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    public final Builder l() {
        return (Builder) m(MethodToInvoke.NEW_BUILDER);
    }

    public Object m(MethodToInvoke methodToInvoke) {
        return o(methodToInvoke, (Object) null, (Object) null);
    }

    public Object n(MethodToInvoke methodToInvoke, Object obj) {
        return o(methodToInvoke, obj, (Object) null);
    }

    public abstract Object o(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    /* renamed from: r */
    public final GeneratedMessageLite getDefaultInstanceForType() {
        return (GeneratedMessageLite) m(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public String toString() {
        return MessageLiteToString.e(this, super.toString());
    }

    public void u() {
        Protobuf.a().e(this).makeImmutable(this);
    }

    /* renamed from: w */
    public final Builder newBuilderForType() {
        return (Builder) m(MethodToInvoke.NEW_BUILDER);
    }
}
