package androidx.datastore.preferences.protobuf;

class GeneratedMessageInfoFactory implements MessageInfoFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final GeneratedMessageInfoFactory f1091a = new GeneratedMessageInfoFactory();

    public static GeneratedMessageInfoFactory a() {
        return f1091a;
    }

    public boolean isSupported(Class cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    public MessageInfo messageInfoFor(Class cls) {
        Class<GeneratedMessageLite> cls2 = GeneratedMessageLite.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (MessageInfo) GeneratedMessageLite.q(cls.asSubclass(cls2)).j();
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for " + cls.getName(), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
    }
}
