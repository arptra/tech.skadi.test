package androidx.datastore.preferences.protobuf;

public class LazyFieldLite {
    public static final ExtensionRegistryLite e = ExtensionRegistryLite.b();

    /* renamed from: a  reason: collision with root package name */
    public ByteString f1108a;
    public ExtensionRegistryLite b;
    public volatile MessageLite c;
    public volatile ByteString d;

    /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.c = r4;
        r3.d = androidx.datastore.preferences.protobuf.ByteString.EMPTY;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.datastore.preferences.protobuf.MessageLite r4) {
        /*
            r3 = this;
            androidx.datastore.preferences.protobuf.MessageLite r0 = r3.c
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            androidx.datastore.preferences.protobuf.MessageLite r0 = r3.c     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x000e
            monitor-exit(r3)     // Catch:{ all -> 0x000c }
            return
        L_0x000c:
            r4 = move-exception
            goto L_0x0036
        L_0x000e:
            androidx.datastore.preferences.protobuf.ByteString r0 = r3.f1108a     // Catch:{ InvalidProtocolBufferException -> 0x002e }
            if (r0 == 0) goto L_0x0027
            androidx.datastore.preferences.protobuf.Parser r0 = r4.getParserForType()     // Catch:{ InvalidProtocolBufferException -> 0x002e }
            androidx.datastore.preferences.protobuf.ByteString r1 = r3.f1108a     // Catch:{ InvalidProtocolBufferException -> 0x002e }
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r2 = r3.b     // Catch:{ InvalidProtocolBufferException -> 0x002e }
            java.lang.Object r0 = r0.b(r1, r2)     // Catch:{ InvalidProtocolBufferException -> 0x002e }
            androidx.datastore.preferences.protobuf.MessageLite r0 = (androidx.datastore.preferences.protobuf.MessageLite) r0     // Catch:{ InvalidProtocolBufferException -> 0x002e }
            r3.c = r0     // Catch:{ InvalidProtocolBufferException -> 0x002e }
            androidx.datastore.preferences.protobuf.ByteString r0 = r3.f1108a     // Catch:{ InvalidProtocolBufferException -> 0x002e }
            r3.d = r0     // Catch:{ InvalidProtocolBufferException -> 0x002e }
            goto L_0x0034
        L_0x0027:
            r3.c = r4     // Catch:{ InvalidProtocolBufferException -> 0x002e }
            androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.EMPTY     // Catch:{ InvalidProtocolBufferException -> 0x002e }
            r3.d = r0     // Catch:{ InvalidProtocolBufferException -> 0x002e }
            goto L_0x0034
        L_0x002e:
            r3.c = r4     // Catch:{ all -> 0x000c }
            androidx.datastore.preferences.protobuf.ByteString r4 = androidx.datastore.preferences.protobuf.ByteString.EMPTY     // Catch:{ all -> 0x000c }
            r3.d = r4     // Catch:{ all -> 0x000c }
        L_0x0034:
            monitor-exit(r3)     // Catch:{ all -> 0x000c }
            return
        L_0x0036:
            monitor-exit(r3)     // Catch:{ all -> 0x000c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.LazyFieldLite.a(androidx.datastore.preferences.protobuf.MessageLite):void");
    }

    public int b() {
        if (this.d != null) {
            return this.d.size();
        }
        ByteString byteString = this.f1108a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.c != null) {
            return this.c.getSerializedSize();
        }
        return 0;
    }

    public MessageLite c(MessageLite messageLite) {
        a(messageLite);
        return this.c;
    }

    public MessageLite d(MessageLite messageLite) {
        MessageLite messageLite2 = this.c;
        this.f1108a = null;
        this.d = null;
        this.c = messageLite;
        return messageLite2;
    }

    public ByteString e() {
        if (this.d != null) {
            return this.d;
        }
        ByteString byteString = this.f1108a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            try {
                if (this.d != null) {
                    ByteString byteString2 = this.d;
                    return byteString2;
                }
                if (this.c == null) {
                    this.d = ByteString.EMPTY;
                } else {
                    this.d = this.c.toByteString();
                }
                ByteString byteString3 = this.d;
                return byteString3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.c;
        MessageLite messageLite2 = lazyFieldLite.c;
        return (messageLite == null && messageLite2 == null) ? e().equals(lazyFieldLite.e()) : (messageLite == null || messageLite2 == null) ? messageLite != null ? messageLite.equals(lazyFieldLite.c(messageLite.getDefaultInstanceForType())) : c(messageLite2.getDefaultInstanceForType()).equals(messageLite2) : messageLite.equals(messageLite2);
    }

    public int hashCode() {
        return 1;
    }
}
