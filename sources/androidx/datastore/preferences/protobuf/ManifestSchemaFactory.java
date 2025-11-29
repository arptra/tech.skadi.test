package androidx.datastore.preferences.protobuf;

final class ManifestSchemaFactory implements SchemaFactory {
    public static final MessageInfoFactory b = new MessageInfoFactory() {
        public boolean isSupported(Class cls) {
            return false;
        }

        public MessageInfo messageInfoFor(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final MessageInfoFactory f1113a;

    public static class CompositeMessageInfoFactory implements MessageInfoFactory {

        /* renamed from: a  reason: collision with root package name */
        public MessageInfoFactory[] f1114a;

        public CompositeMessageInfoFactory(MessageInfoFactory... messageInfoFactoryArr) {
            this.f1114a = messageInfoFactoryArr;
        }

        public boolean isSupported(Class cls) {
            for (MessageInfoFactory isSupported : this.f1114a) {
                if (isSupported.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        public MessageInfo messageInfoFor(Class cls) {
            for (MessageInfoFactory messageInfoFactory : this.f1114a) {
                if (messageInfoFactory.isSupported(cls)) {
                    return messageInfoFactory.messageInfoFor(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }
    }

    public ManifestSchemaFactory() {
        this(a());
    }

    public static MessageInfoFactory a() {
        return new CompositeMessageInfoFactory(GeneratedMessageInfoFactory.a(), b());
    }

    public static MessageInfoFactory b() {
        try {
            return (MessageInfoFactory) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            return b;
        }
    }

    public static boolean c(MessageInfo messageInfo) {
        return messageInfo.getSyntax() == ProtoSyntax.PROTO2;
    }

    public static Schema d(Class cls, MessageInfo messageInfo) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            if (c(messageInfo)) {
                return MessageSchema.K(cls, messageInfo, NewInstanceSchemas.b(), ListFieldSchema.b(), SchemaUtil.M(), ExtensionSchemas.b(), MapFieldSchemas.b());
            }
            return MessageSchema.K(cls, messageInfo, NewInstanceSchemas.b(), ListFieldSchema.b(), SchemaUtil.M(), (ExtensionSchema) null, MapFieldSchemas.b());
        } else if (c(messageInfo)) {
            return MessageSchema.K(cls, messageInfo, NewInstanceSchemas.a(), ListFieldSchema.a(), SchemaUtil.H(), ExtensionSchemas.a(), MapFieldSchemas.a());
        } else {
            return MessageSchema.K(cls, messageInfo, NewInstanceSchemas.a(), ListFieldSchema.a(), SchemaUtil.I(), (ExtensionSchema) null, MapFieldSchemas.a());
        }
    }

    public Schema createSchema(Class cls) {
        SchemaUtil.J(cls);
        MessageInfo messageInfoFor = this.f1113a.messageInfoFor(cls);
        return messageInfoFor.isMessageSetWireFormat() ? GeneratedMessageLite.class.isAssignableFrom(cls) ? MessageSetSchema.f(SchemaUtil.M(), ExtensionSchemas.b(), messageInfoFor.getDefaultInstance()) : MessageSetSchema.f(SchemaUtil.H(), ExtensionSchemas.a(), messageInfoFor.getDefaultInstance()) : d(cls, messageInfoFor);
    }

    public ManifestSchemaFactory(MessageInfoFactory messageInfoFactory) {
        this.f1113a = (MessageInfoFactory) Internal.b(messageInfoFactory, "messageInfoFactory");
    }
}
