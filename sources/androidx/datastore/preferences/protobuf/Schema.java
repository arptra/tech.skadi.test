package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ArrayDecoders;

interface Schema<T> {
    void a(Object obj, Writer writer);

    void b(Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite);

    void c(Object obj, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers);

    boolean equals(Object obj, Object obj2);

    int getSerializedSize(Object obj);

    int hashCode(Object obj);

    boolean isInitialized(Object obj);

    void makeImmutable(Object obj);

    void mergeFrom(Object obj, Object obj2);

    Object newInstance();
}
