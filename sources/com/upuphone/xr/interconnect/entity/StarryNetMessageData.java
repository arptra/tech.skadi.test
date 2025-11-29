package com.upuphone.xr.interconnect.entity;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class StarryNetMessageData extends GeneratedMessageLite<StarryNetMessageData, Builder> implements StarryNetMessageDataOrBuilder {
    public static final int DATA_FIELD_NUMBER = 5;
    /* access modifiers changed from: private */
    public static final StarryNetMessageData DEFAULT_INSTANCE;
    public static final int IDENTIFIER_FIELD_NUMBER = 6;
    public static final int MESSAGE_FIELD_NUMBER = 4;
    private static volatile Parser<StarryNetMessageData> PARSER = null;
    public static final int RECEIVERPKG_FIELD_NUMBER = 3;
    public static final int SENDERPKG_FIELD_NUMBER = 2;
    private ByteString data_ = ByteString.EMPTY;
    private int identifier_;
    private String message_ = "";
    private String receiverPkg_ = "";
    private String senderPkg_ = "";

    /* renamed from: com.upuphone.xr.interconnect.entity.StarryNetMessageData$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.entity.StarryNetMessageData.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<StarryNetMessageData, Builder> implements StarryNetMessageDataOrBuilder {
        public Builder clearData() {
            copyOnWrite();
            ((StarryNetMessageData) this.instance).clearData();
            return this;
        }

        public Builder clearIdentifier() {
            copyOnWrite();
            ((StarryNetMessageData) this.instance).clearIdentifier();
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((StarryNetMessageData) this.instance).clearMessage();
            return this;
        }

        public Builder clearReceiverPkg() {
            copyOnWrite();
            ((StarryNetMessageData) this.instance).clearReceiverPkg();
            return this;
        }

        public Builder clearSenderPkg() {
            copyOnWrite();
            ((StarryNetMessageData) this.instance).clearSenderPkg();
            return this;
        }

        public ByteString getData() {
            return ((StarryNetMessageData) this.instance).getData();
        }

        public int getIdentifier() {
            return ((StarryNetMessageData) this.instance).getIdentifier();
        }

        public String getMessage() {
            return ((StarryNetMessageData) this.instance).getMessage();
        }

        public ByteString getMessageBytes() {
            return ((StarryNetMessageData) this.instance).getMessageBytes();
        }

        public String getReceiverPkg() {
            return ((StarryNetMessageData) this.instance).getReceiverPkg();
        }

        public ByteString getReceiverPkgBytes() {
            return ((StarryNetMessageData) this.instance).getReceiverPkgBytes();
        }

        public String getSenderPkg() {
            return ((StarryNetMessageData) this.instance).getSenderPkg();
        }

        public ByteString getSenderPkgBytes() {
            return ((StarryNetMessageData) this.instance).getSenderPkgBytes();
        }

        public Builder setData(ByteString byteString) {
            copyOnWrite();
            ((StarryNetMessageData) this.instance).setData(byteString);
            return this;
        }

        public Builder setIdentifier(int i) {
            copyOnWrite();
            ((StarryNetMessageData) this.instance).setIdentifier(i);
            return this;
        }

        public Builder setMessage(String str) {
            copyOnWrite();
            ((StarryNetMessageData) this.instance).setMessage(str);
            return this;
        }

        public Builder setMessageBytes(ByteString byteString) {
            copyOnWrite();
            ((StarryNetMessageData) this.instance).setMessageBytes(byteString);
            return this;
        }

        public Builder setReceiverPkg(String str) {
            copyOnWrite();
            ((StarryNetMessageData) this.instance).setReceiverPkg(str);
            return this;
        }

        public Builder setReceiverPkgBytes(ByteString byteString) {
            copyOnWrite();
            ((StarryNetMessageData) this.instance).setReceiverPkgBytes(byteString);
            return this;
        }

        public Builder setSenderPkg(String str) {
            copyOnWrite();
            ((StarryNetMessageData) this.instance).setSenderPkg(str);
            return this;
        }

        public Builder setSenderPkgBytes(ByteString byteString) {
            copyOnWrite();
            ((StarryNetMessageData) this.instance).setSenderPkgBytes(byteString);
            return this;
        }

        private Builder() {
            super(StarryNetMessageData.DEFAULT_INSTANCE);
        }
    }

    static {
        StarryNetMessageData starryNetMessageData = new StarryNetMessageData();
        DEFAULT_INSTANCE = starryNetMessageData;
        GeneratedMessageLite.registerDefaultInstance(StarryNetMessageData.class, starryNetMessageData);
    }

    private StarryNetMessageData() {
    }

    /* access modifiers changed from: private */
    public void clearData() {
        this.data_ = getDefaultInstance().getData();
    }

    /* access modifiers changed from: private */
    public void clearIdentifier() {
        this.identifier_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    /* access modifiers changed from: private */
    public void clearReceiverPkg() {
        this.receiverPkg_ = getDefaultInstance().getReceiverPkg();
    }

    /* access modifiers changed from: private */
    public void clearSenderPkg() {
        this.senderPkg_ = getDefaultInstance().getSenderPkg();
    }

    public static StarryNetMessageData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static StarryNetMessageData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StarryNetMessageData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StarryNetMessageData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StarryNetMessageData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StarryNetMessageData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setData(ByteString byteString) {
        byteString.getClass();
        this.data_ = byteString;
    }

    /* access modifiers changed from: private */
    public void setIdentifier(int i) {
        this.identifier_ = i;
    }

    /* access modifiers changed from: private */
    public void setMessage(String str) {
        str.getClass();
        this.message_ = str;
    }

    /* access modifiers changed from: private */
    public void setMessageBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.message_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setReceiverPkg(String str) {
        str.getClass();
        this.receiverPkg_ = str;
    }

    /* access modifiers changed from: private */
    public void setReceiverPkgBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.receiverPkg_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setSenderPkg(String str) {
        str.getClass();
        this.senderPkg_ = str;
    }

    /* access modifiers changed from: private */
    public void setSenderPkgBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.senderPkg_ = byteString.toStringUtf8();
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new StarryNetMessageData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0002\u0006\u0005\u0000\u0000\u0000\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\n\u0006\u0004", new Object[]{"senderPkg_", "receiverPkg_", "message_", "data_", "identifier_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StarryNetMessageData> parser = PARSER;
                if (parser == null) {
                    synchronized (StarryNetMessageData.class) {
                        try {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public ByteString getData() {
        return this.data_;
    }

    public int getIdentifier() {
        return this.identifier_;
    }

    public String getMessage() {
        return this.message_;
    }

    public ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
    }

    public String getReceiverPkg() {
        return this.receiverPkg_;
    }

    public ByteString getReceiverPkgBytes() {
        return ByteString.copyFromUtf8(this.receiverPkg_);
    }

    public String getSenderPkg() {
        return this.senderPkg_;
    }

    public ByteString getSenderPkgBytes() {
        return ByteString.copyFromUtf8(this.senderPkg_);
    }

    public static Builder newBuilder(StarryNetMessageData starryNetMessageData) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(starryNetMessageData);
    }

    public static StarryNetMessageData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StarryNetMessageData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StarryNetMessageData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StarryNetMessageData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StarryNetMessageData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StarryNetMessageData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StarryNetMessageData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StarryNetMessageData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StarryNetMessageData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StarryNetMessageData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StarryNetMessageData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StarryNetMessageData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StarryNetMessageData parseFrom(InputStream inputStream) throws IOException {
        return (StarryNetMessageData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StarryNetMessageData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StarryNetMessageData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StarryNetMessageData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StarryNetMessageData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StarryNetMessageData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StarryNetMessageData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
