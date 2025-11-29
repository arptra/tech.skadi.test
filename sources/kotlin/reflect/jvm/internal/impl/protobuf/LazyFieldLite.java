package kotlin.reflect.jvm.internal.impl.protobuf;

public class LazyFieldLite {
    private ByteString bytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile boolean isDirty;
    protected volatile MessageLite value;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:10|11|(1:13)(1:14)|15|16|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ensureInitialized(kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r3) {
        /*
            r2 = this;
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r2.value
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r2)
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r2.value     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x000e
            monitor-exit(r2)     // Catch:{ all -> 0x000c }
            return
        L_0x000c:
            r3 = move-exception
            goto L_0x0027
        L_0x000e:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r0 = r2.bytes     // Catch:{ IOException -> 0x0025 }
            if (r0 == 0) goto L_0x0023
            kotlin.reflect.jvm.internal.impl.protobuf.Parser r3 = r3.getParserForType()     // Catch:{ IOException -> 0x0025 }
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r0 = r2.bytes     // Catch:{ IOException -> 0x0025 }
            kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r1 = r2.extensionRegistry     // Catch:{ IOException -> 0x0025 }
            java.lang.Object r3 = r3.parseFrom((kotlin.reflect.jvm.internal.impl.protobuf.ByteString) r0, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r1)     // Catch:{ IOException -> 0x0025 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r3 = (kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) r3     // Catch:{ IOException -> 0x0025 }
            r2.value = r3     // Catch:{ IOException -> 0x0025 }
            goto L_0x0025
        L_0x0023:
            r2.value = r3     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            monitor-exit(r2)     // Catch:{ all -> 0x000c }
            return
        L_0x0027:
            monitor-exit(r2)     // Catch:{ all -> 0x000c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.LazyFieldLite.ensureInitialized(kotlin.reflect.jvm.internal.impl.protobuf.MessageLite):void");
    }

    public int getSerializedSize() {
        return this.isDirty ? this.value.getSerializedSize() : this.bytes.size();
    }

    public MessageLite getValue(MessageLite messageLite) {
        ensureInitialized(messageLite);
        return this.value;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.value;
        this.value = messageLite;
        this.bytes = null;
        this.isDirty = true;
        return messageLite2;
    }
}
