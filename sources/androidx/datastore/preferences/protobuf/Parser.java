package androidx.datastore.preferences.protobuf;

public interface Parser<MessageType> {
    Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

    Object b(ByteString byteString, ExtensionRegistryLite extensionRegistryLite);
}
