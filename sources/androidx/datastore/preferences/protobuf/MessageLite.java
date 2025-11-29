package androidx.datastore.preferences.protobuf;

public interface MessageLite extends MessageLiteOrBuilder {

    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        Builder a(MessageLite messageLite);

        MessageLite build();

        MessageLite buildPartial();

        Builder mergeFrom(byte[] bArr);
    }

    void b(CodedOutputStream codedOutputStream);

    Parser getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    byte[] toByteArray();

    ByteString toByteString();
}
