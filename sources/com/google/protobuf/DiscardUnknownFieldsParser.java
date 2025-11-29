package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DiscardUnknownFieldsParser {
    private DiscardUnknownFieldsParser() {
    }

    public static final <T extends Message> Parser<T> wrap(final Parser<T> parser) {
        return new AbstractParser<T>() {
            public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
                return super.parseDelimitedFrom(inputStream);
            }

            public /* bridge */ /* synthetic */ Object parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return super.parseFrom(byteString);
            }

            public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
                return super.parsePartialDelimitedFrom(inputStream);
            }

            public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(byteString);
            }

            public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.parseDelimitedFrom(inputStream, extensionRegistryLite);
            }

            public /* bridge */ /* synthetic */ Object parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.parseFrom(byteString, extensionRegistryLite);
            }

            public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.parsePartialDelimitedFrom(inputStream, extensionRegistryLite);
            }

            public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(byteString, extensionRegistryLite);
            }

            public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
                return super.parseFrom(codedInputStream);
            }

            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(codedInputStream);
            }

            public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.parseFrom(codedInputStream, extensionRegistryLite);
            }

            public /* bridge */ /* synthetic */ Object parseFrom(InputStream inputStream) throws InvalidProtocolBufferException {
                return super.parseFrom(inputStream);
            }

            public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream inputStream) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(inputStream);
            }

            public /* bridge */ /* synthetic */ Object parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.parseFrom(inputStream, extensionRegistryLite);
            }

            public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(inputStream, extensionRegistryLite);
            }

            public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return super.parseFrom(byteBuffer);
            }

            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(bArr);
            }

            public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(bArr, i, i2);
            }

            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return super.parseFrom(bArr);
            }

            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(bArr, i, i2, extensionRegistryLite);
            }

            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
                return super.parseFrom(bArr, i, i2);
            }

            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.parsePartialFrom(bArr, extensionRegistryLite);
            }

            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.parseFrom(bArr, i, i2, extensionRegistryLite);
            }

            public T parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                try {
                    codedInputStream.discardUnknownFields();
                    return (Message) Parser.this.parsePartialFrom(codedInputStream, extensionRegistryLite);
                } finally {
                    codedInputStream.unsetDiscardUnknownFields();
                }
            }

            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.parseFrom(bArr, extensionRegistryLite);
            }
        };
    }
}
