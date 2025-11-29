package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.Map;

public class ExtensionRegistryLite {
    public static boolean b = true;
    public static final Class c = c();
    public static volatile ExtensionRegistryLite d;
    public static final ExtensionRegistryLite e = new ExtensionRegistryLite(true);

    /* renamed from: a  reason: collision with root package name */
    public final Map f1077a = Collections.emptyMap();

    public static final class ObjectIntPair {

        /* renamed from: a  reason: collision with root package name */
        public final Object f1078a;
        public final int b;

        public ObjectIntPair(Object obj, int i) {
            this.f1078a = obj;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            return this.f1078a == objectIntPair.f1078a && this.b == objectIntPair.b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f1078a) * 65535) + this.b;
        }
    }

    public ExtensionRegistryLite(boolean z) {
    }

    public static ExtensionRegistryLite b() {
        ExtensionRegistryLite extensionRegistryLite = d;
        if (extensionRegistryLite == null) {
            synchronized (ExtensionRegistryLite.class) {
                try {
                    extensionRegistryLite = d;
                    if (extensionRegistryLite == null) {
                        extensionRegistryLite = b ? ExtensionRegistryFactory.a() : e;
                        d = extensionRegistryLite;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return extensionRegistryLite;
    }

    public static Class c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public GeneratedMessageLite.GeneratedExtension a(MessageLite messageLite, int i) {
        return (GeneratedMessageLite.GeneratedExtension) this.f1077a.get(new ObjectIntPair(messageLite, i));
    }
}
