package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MessageLite;

public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    public static final ExtensionRegistryLite f1044a = ExtensionRegistryLite.b();

    public final MessageLite c(MessageLite messageLite) {
        if (messageLite == null || messageLite.isInitialized()) {
            return messageLite;
        }
        throw d(messageLite).asInvalidProtocolBufferException().setUnfinishedMessage(messageLite);
    }

    public final UninitializedMessageException d(MessageLite messageLite) {
        return messageLite instanceof AbstractMessageLite ? ((AbstractMessageLite) messageLite).g() : new UninitializedMessageException(messageLite);
    }

    /* renamed from: e */
    public MessageLite b(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return c(f(byteString, extensionRegistryLite));
    }

    public MessageLite f(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        CodedInputStream newCodedInput = byteString.newCodedInput();
        MessageLite messageLite = (MessageLite) a(newCodedInput, extensionRegistryLite);
        try {
            newCodedInput.a(0);
            return messageLite;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(messageLite);
        }
    }
}
