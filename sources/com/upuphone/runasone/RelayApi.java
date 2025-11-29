package com.upuphone.runasone;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import com.upuphone.runasone.ble.BleConstants;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public final class RelayApi {
    /* access modifiers changed from: private */
    public static Descriptors.FileDescriptor descriptor;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Message_AbilityKeyMapEntry_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_Message_AbilityKeyMapEntry_fieldAccessorTable;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Message_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Message_fieldAccessorTable;

    public enum AppUniteCodeType implements ProtocolMessageEnum {
        ADD(0),
        DEL(1),
        UNRECOGNIZED(-1);
        
        public static final int ADD_VALUE = 0;
        public static final int DEL_VALUE = 1;
        private static final AppUniteCodeType[] VALUES = null;
        private static final Internal.EnumLiteMap<AppUniteCodeType> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<AppUniteCodeType>() {
                public AppUniteCodeType findValueByNumber(int i) {
                    return AppUniteCodeType.forNumber(i);
                }
            };
            VALUES = values();
        }

        private AppUniteCodeType(int i) {
            this.value = i;
        }

        public static AppUniteCodeType forNumber(int i) {
            if (i == 0) {
                return ADD;
            }
            if (i != 1) {
                return null;
            }
            return DEL;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return RelayApi.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<AppUniteCodeType> internalGetValueMap() {
            return internalValueMap;
        }

        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        @Deprecated
        public static AppUniteCodeType valueOf(int i) {
            return forNumber(i);
        }

        public static AppUniteCodeType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[enumValueDescriptor.getIndex()];
            }
        }
    }

    public static final class Message extends GeneratedMessageV3 implements MessageOrBuilder {
        public static final int ABILITYKEYMAP_FIELD_NUMBER = 13;
        public static final int ABILITYKEY_FIELD_NUMBER = 3;
        public static final int APPUNITECODETYPE_FIELD_NUMBER = 6;
        private static final Message DEFAULT_INSTANCE = new Message();
        public static final int ERRORCODE_FIELD_NUMBER = 7;
        public static final int LISTENERID_FIELD_NUMBER = 12;
        public static final int MSGUNIQUEKEY_FIELD_NUMBER = 5;
        public static final int MSG_FIELD_NUMBER = 4;
        public static final int NEEDCALLBACK_FIELD_NUMBER = 9;
        public static final int OPENTYPE_FIELD_NUMBER = 11;
        /* access modifiers changed from: private */
        public static final Parser<Message> PARSER = new AbstractParser<Message>() {
            public Message parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Message(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RECEIVEAPPUNITECODE_FIELD_NUMBER = 10;
        public static final int RECEIVEAUCNUM_FIELD_NUMBER = 15;
        public static final int SENDAPPUNITECODE_FIELD_NUMBER = 2;
        public static final int SENDAUCNUM_FIELD_NUMBER = 14;
        public static final int SUCCESSCODE_FIELD_NUMBER = 8;
        public static final int SUPPORTMAP_FIELD_NUMBER = 16;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public MapField<String, Integer> abilityKeyMap_;
        /* access modifiers changed from: private */
        public LazyStringList abilityKey_;
        /* access modifiers changed from: private */
        public int appUniteCodeType_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int errorCode_;
        /* access modifiers changed from: private */
        public int listenerId_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public volatile Object msgUniqueKey_;
        /* access modifiers changed from: private */
        public ByteString msg_;
        /* access modifiers changed from: private */
        public boolean needCallBack_;
        /* access modifiers changed from: private */
        public int openType_;
        /* access modifiers changed from: private */
        public int receiveAUCNum_;
        /* access modifiers changed from: private */
        public volatile Object receiveAppUniteCode_;
        /* access modifiers changed from: private */
        public int sendAUCNum_;
        /* access modifiers changed from: private */
        public volatile Object sendAppUniteCode_;
        /* access modifiers changed from: private */
        public int successCode_;
        /* access modifiers changed from: private */
        public boolean supportMap_;
        /* access modifiers changed from: private */
        public int type_;

        public static final class AbilityKeyMapDefaultEntryHolder {
            static final MapEntry<String, Integer> defaultEntry = MapEntry.newDefaultInstance(RelayApi.internal_static_Message_AbilityKeyMapEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT32, 0);

            private AbilityKeyMapDefaultEntryHolder() {
            }
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MessageOrBuilder {
            private MapField<String, Integer> abilityKeyMap_;
            private LazyStringList abilityKey_;
            private int appUniteCodeType_;
            private int bitField0_;
            private int errorCode_;
            private int listenerId_;
            private Object msgUniqueKey_;
            private ByteString msg_;
            private boolean needCallBack_;
            private int openType_;
            private int receiveAUCNum_;
            private Object receiveAppUniteCode_;
            private int sendAUCNum_;
            private Object sendAppUniteCode_;
            private int successCode_;
            private boolean supportMap_;
            private int type_;

            private void ensureAbilityKeyIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.abilityKey_ = new LazyStringArrayList(this.abilityKey_);
                    this.bitField0_ |= 4;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return RelayApi.internal_static_Message_descriptor;
            }

            private MapField<String, Integer> internalGetAbilityKeyMap() {
                MapField<String, Integer> mapField = this.abilityKeyMap_;
                return mapField == null ? MapField.emptyMapField(AbilityKeyMapDefaultEntryHolder.defaultEntry) : mapField;
            }

            private MapField<String, Integer> internalGetMutableAbilityKeyMap() {
                onChanged();
                if (this.abilityKeyMap_ == null) {
                    this.abilityKeyMap_ = MapField.newMapField(AbilityKeyMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.abilityKeyMap_.isMutable()) {
                    this.abilityKeyMap_ = this.abilityKeyMap_.copy();
                }
                return this.abilityKeyMap_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder addAbilityKey(String str) {
                str.getClass();
                ensureAbilityKeyIsMutable();
                this.abilityKey_.add(str);
                onChanged();
                return this;
            }

            public Builder addAbilityKeyBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                ensureAbilityKeyIsMutable();
                this.abilityKey_.add(byteString);
                onChanged();
                return this;
            }

            public Builder addAllAbilityKey(Iterable<String> iterable) {
                ensureAbilityKeyIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.abilityKey_);
                onChanged();
                return this;
            }

            public Builder clearAbilityKey() {
                this.abilityKey_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            public Builder clearAbilityKeyMap() {
                internalGetMutableAbilityKeyMap().getMutableMap().clear();
                return this;
            }

            public Builder clearAppUniteCodeType() {
                this.appUniteCodeType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrorCode() {
                this.errorCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearListenerId() {
                this.listenerId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearMsg() {
                this.msg_ = Message.getDefaultInstance().getMsg();
                onChanged();
                return this;
            }

            public Builder clearMsgUniqueKey() {
                this.msgUniqueKey_ = Message.getDefaultInstance().getMsgUniqueKey();
                onChanged();
                return this;
            }

            public Builder clearNeedCallBack() {
                this.needCallBack_ = false;
                onChanged();
                return this;
            }

            public Builder clearOpenType() {
                this.openType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearReceiveAUCNum() {
                this.receiveAUCNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearReceiveAppUniteCode() {
                this.receiveAppUniteCode_ = Message.getDefaultInstance().getReceiveAppUniteCode();
                onChanged();
                return this;
            }

            public Builder clearSendAUCNum() {
                this.sendAUCNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSendAppUniteCode() {
                this.sendAppUniteCode_ = Message.getDefaultInstance().getSendAppUniteCode();
                onChanged();
                return this;
            }

            public Builder clearSuccessCode() {
                this.successCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSupportMap() {
                this.supportMap_ = false;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            public boolean containsAbilityKeyMap(String str) {
                str.getClass();
                return internalGetAbilityKeyMap().getMap().containsKey(str);
            }

            public String getAbilityKey(int i) {
                return (String) this.abilityKey_.get(i);
            }

            public ByteString getAbilityKeyBytes(int i) {
                return this.abilityKey_.getByteString(i);
            }

            public int getAbilityKeyCount() {
                return this.abilityKey_.size();
            }

            @Deprecated
            public Map<String, Integer> getAbilityKeyMap() {
                return getAbilityKeyMapMap();
            }

            public int getAbilityKeyMapCount() {
                return internalGetAbilityKeyMap().getMap().size();
            }

            public Map<String, Integer> getAbilityKeyMapMap() {
                return internalGetAbilityKeyMap().getMap();
            }

            public int getAbilityKeyMapOrDefault(String str, int i) {
                str.getClass();
                Map<String, Integer> map = internalGetAbilityKeyMap().getMap();
                return map.containsKey(str) ? map.get(str).intValue() : i;
            }

            public int getAbilityKeyMapOrThrow(String str) {
                str.getClass();
                Map<String, Integer> map = internalGetAbilityKeyMap().getMap();
                if (map.containsKey(str)) {
                    return map.get(str).intValue();
                }
                throw new IllegalArgumentException();
            }

            public AppUniteCodeType getAppUniteCodeType() {
                AppUniteCodeType valueOf = AppUniteCodeType.valueOf(this.appUniteCodeType_);
                return valueOf == null ? AppUniteCodeType.UNRECOGNIZED : valueOf;
            }

            public int getAppUniteCodeTypeValue() {
                return this.appUniteCodeType_;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RelayApi.internal_static_Message_descriptor;
            }

            public int getErrorCode() {
                return this.errorCode_;
            }

            public int getListenerId() {
                return this.listenerId_;
            }

            public ByteString getMsg() {
                return this.msg_;
            }

            public String getMsgUniqueKey() {
                Object obj = this.msgUniqueKey_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.msgUniqueKey_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getMsgUniqueKeyBytes() {
                Object obj = this.msgUniqueKey_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.msgUniqueKey_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Deprecated
            public Map<String, Integer> getMutableAbilityKeyMap() {
                return internalGetMutableAbilityKeyMap().getMutableMap();
            }

            public boolean getNeedCallBack() {
                return this.needCallBack_;
            }

            public int getOpenType() {
                return this.openType_;
            }

            public int getReceiveAUCNum() {
                return this.receiveAUCNum_;
            }

            public String getReceiveAppUniteCode() {
                Object obj = this.receiveAppUniteCode_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.receiveAppUniteCode_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getReceiveAppUniteCodeBytes() {
                Object obj = this.receiveAppUniteCode_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.receiveAppUniteCode_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public int getSendAUCNum() {
                return this.sendAUCNum_;
            }

            public String getSendAppUniteCode() {
                Object obj = this.sendAppUniteCode_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.sendAppUniteCode_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getSendAppUniteCodeBytes() {
                Object obj = this.sendAppUniteCode_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sendAppUniteCode_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public int getSuccessCode() {
                return this.successCode_;
            }

            public boolean getSupportMap() {
                return this.supportMap_;
            }

            public StreamType getType() {
                StreamType valueOf = StreamType.valueOf(this.type_);
                return valueOf == null ? StreamType.UNRECOGNIZED : valueOf;
            }

            public int getTypeValue() {
                return this.type_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RelayApi.internal_static_Message_fieldAccessorTable.ensureFieldAccessorsInitialized(Message.class, Builder.class);
            }

            public MapField internalGetMapField(int i) {
                if (i == 13) {
                    return internalGetAbilityKeyMap();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            public MapField internalGetMutableMapField(int i) {
                if (i == 13) {
                    return internalGetMutableAbilityKeyMap();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder putAbilityKeyMap(String str, int i) {
                str.getClass();
                internalGetMutableAbilityKeyMap().getMutableMap().put(str, Integer.valueOf(i));
                return this;
            }

            public Builder putAllAbilityKeyMap(Map<String, Integer> map) {
                internalGetMutableAbilityKeyMap().getMutableMap().putAll(map);
                return this;
            }

            public Builder removeAbilityKeyMap(String str) {
                str.getClass();
                internalGetMutableAbilityKeyMap().getMutableMap().remove(str);
                return this;
            }

            public Builder setAbilityKey(int i, String str) {
                str.getClass();
                ensureAbilityKeyIsMutable();
                this.abilityKey_.set(i, str);
                onChanged();
                return this;
            }

            public Builder setAppUniteCodeType(AppUniteCodeType appUniteCodeType) {
                appUniteCodeType.getClass();
                this.appUniteCodeType_ = appUniteCodeType.getNumber();
                onChanged();
                return this;
            }

            public Builder setAppUniteCodeTypeValue(int i) {
                this.appUniteCodeType_ = i;
                onChanged();
                return this;
            }

            public Builder setErrorCode(int i) {
                this.errorCode_ = i;
                onChanged();
                return this;
            }

            public Builder setListenerId(int i) {
                this.listenerId_ = i;
                onChanged();
                return this;
            }

            public Builder setMsg(ByteString byteString) {
                byteString.getClass();
                this.msg_ = byteString;
                onChanged();
                return this;
            }

            public Builder setMsgUniqueKey(String str) {
                str.getClass();
                this.msgUniqueKey_ = str;
                onChanged();
                return this;
            }

            public Builder setMsgUniqueKeyBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.msgUniqueKey_ = byteString;
                onChanged();
                return this;
            }

            public Builder setNeedCallBack(boolean z) {
                this.needCallBack_ = z;
                onChanged();
                return this;
            }

            public Builder setOpenType(int i) {
                this.openType_ = i;
                onChanged();
                return this;
            }

            public Builder setReceiveAUCNum(int i) {
                this.receiveAUCNum_ = i;
                onChanged();
                return this;
            }

            public Builder setReceiveAppUniteCode(String str) {
                str.getClass();
                this.receiveAppUniteCode_ = str;
                onChanged();
                return this;
            }

            public Builder setReceiveAppUniteCodeBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.receiveAppUniteCode_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSendAUCNum(int i) {
                this.sendAUCNum_ = i;
                onChanged();
                return this;
            }

            public Builder setSendAppUniteCode(String str) {
                str.getClass();
                this.sendAppUniteCode_ = str;
                onChanged();
                return this;
            }

            public Builder setSendAppUniteCodeBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.sendAppUniteCode_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSuccessCode(int i) {
                this.successCode_ = i;
                onChanged();
                return this;
            }

            public Builder setSupportMap(boolean z) {
                this.supportMap_ = z;
                onChanged();
                return this;
            }

            public Builder setType(StreamType streamType) {
                streamType.getClass();
                this.type_ = streamType.getNumber();
                onChanged();
                return this;
            }

            public Builder setTypeValue(int i) {
                this.type_ = i;
                onChanged();
                return this;
            }

            public ProtocolStringList getAbilityKeyList() {
                return this.abilityKey_.getUnmodifiableView();
            }

            private Builder() {
                this.type_ = 0;
                this.sendAppUniteCode_ = "";
                this.abilityKey_ = LazyStringArrayList.EMPTY;
                this.msg_ = ByteString.EMPTY;
                this.msgUniqueKey_ = "";
                this.appUniteCodeType_ = 0;
                this.receiveAppUniteCode_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public Message build() {
                Message buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public Message buildPartial() {
                Message message = new Message((GeneratedMessageV3.Builder) this);
                int unused = message.type_ = this.type_;
                Object unused2 = message.sendAppUniteCode_ = this.sendAppUniteCode_;
                if ((this.bitField0_ & 4) == 4) {
                    this.abilityKey_ = this.abilityKey_.getUnmodifiableView();
                    this.bitField0_ &= -5;
                }
                LazyStringList unused3 = message.abilityKey_ = this.abilityKey_;
                ByteString unused4 = message.msg_ = this.msg_;
                Object unused5 = message.msgUniqueKey_ = this.msgUniqueKey_;
                int unused6 = message.appUniteCodeType_ = this.appUniteCodeType_;
                int unused7 = message.errorCode_ = this.errorCode_;
                int unused8 = message.successCode_ = this.successCode_;
                boolean unused9 = message.needCallBack_ = this.needCallBack_;
                Object unused10 = message.receiveAppUniteCode_ = this.receiveAppUniteCode_;
                int unused11 = message.openType_ = this.openType_;
                int unused12 = message.listenerId_ = this.listenerId_;
                MapField unused13 = message.abilityKeyMap_ = internalGetAbilityKeyMap();
                message.abilityKeyMap_.makeImmutable();
                int unused14 = message.sendAUCNum_ = this.sendAUCNum_;
                int unused15 = message.receiveAUCNum_ = this.receiveAUCNum_;
                boolean unused16 = message.supportMap_ = this.supportMap_;
                int unused17 = message.bitField0_ = 0;
                onBuilt();
                return message;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Message getDefaultInstanceForType() {
                return Message.getDefaultInstance();
            }

            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFieldsProto3(unknownFieldSet);
            }

            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder clear() {
                super.clear();
                this.type_ = 0;
                this.sendAppUniteCode_ = "";
                this.abilityKey_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -5;
                this.msg_ = ByteString.EMPTY;
                this.msgUniqueKey_ = "";
                this.appUniteCodeType_ = 0;
                this.errorCode_ = 0;
                this.successCode_ = 0;
                this.needCallBack_ = false;
                this.receiveAppUniteCode_ = "";
                this.openType_ = 0;
                this.listenerId_ = 0;
                internalGetMutableAbilityKeyMap().clear();
                this.sendAUCNum_ = 0;
                this.receiveAUCNum_ = 0;
                this.supportMap_ = false;
                return this;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof Message) {
                    return mergeFrom((Message) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Message message) {
                if (message == Message.getDefaultInstance()) {
                    return this;
                }
                if (message.type_ != 0) {
                    setTypeValue(message.getTypeValue());
                }
                if (!message.getSendAppUniteCode().isEmpty()) {
                    this.sendAppUniteCode_ = message.sendAppUniteCode_;
                    onChanged();
                }
                if (!message.abilityKey_.isEmpty()) {
                    if (this.abilityKey_.isEmpty()) {
                        this.abilityKey_ = message.abilityKey_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureAbilityKeyIsMutable();
                        this.abilityKey_.addAll(message.abilityKey_);
                    }
                    onChanged();
                }
                if (message.getMsg() != ByteString.EMPTY) {
                    setMsg(message.getMsg());
                }
                if (!message.getMsgUniqueKey().isEmpty()) {
                    this.msgUniqueKey_ = message.msgUniqueKey_;
                    onChanged();
                }
                if (message.appUniteCodeType_ != 0) {
                    setAppUniteCodeTypeValue(message.getAppUniteCodeTypeValue());
                }
                if (message.getErrorCode() != 0) {
                    setErrorCode(message.getErrorCode());
                }
                if (message.getSuccessCode() != 0) {
                    setSuccessCode(message.getSuccessCode());
                }
                if (message.getNeedCallBack()) {
                    setNeedCallBack(message.getNeedCallBack());
                }
                if (!message.getReceiveAppUniteCode().isEmpty()) {
                    this.receiveAppUniteCode_ = message.receiveAppUniteCode_;
                    onChanged();
                }
                if (message.getOpenType() != 0) {
                    setOpenType(message.getOpenType());
                }
                if (message.getListenerId() != 0) {
                    setListenerId(message.getListenerId());
                }
                internalGetMutableAbilityKeyMap().mergeFrom(message.internalGetAbilityKeyMap());
                if (message.getSendAUCNum() != 0) {
                    setSendAUCNum(message.getSendAUCNum());
                }
                if (message.getReceiveAUCNum() != 0) {
                    setReceiveAUCNum(message.getReceiveAUCNum());
                }
                if (message.getSupportMap()) {
                    setSupportMap(message.getSupportMap());
                }
                mergeUnknownFields(message.unknownFields);
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.type_ = 0;
                this.sendAppUniteCode_ = "";
                this.abilityKey_ = LazyStringArrayList.EMPTY;
                this.msg_ = ByteString.EMPTY;
                this.msgUniqueKey_ = "";
                this.appUniteCodeType_ = 0;
                this.receiveAppUniteCode_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.upuphone.runasone.RelayApi.Message.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.upuphone.runasone.RelayApi.Message.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    com.upuphone.runasone.RelayApi$Message r3 = (com.upuphone.runasone.RelayApi.Message) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((com.upuphone.runasone.RelayApi.Message) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    com.upuphone.runasone.RelayApi$Message r4 = (com.upuphone.runasone.RelayApi.Message) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((com.upuphone.runasone.RelayApi.Message) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.RelayApi.Message.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.upuphone.runasone.RelayApi$Message$Builder");
            }
        }

        public static Message getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RelayApi.internal_static_Message_descriptor;
        }

        /* access modifiers changed from: private */
        public MapField<String, Integer> internalGetAbilityKeyMap() {
            MapField<String, Integer> mapField = this.abilityKeyMap_;
            return mapField == null ? MapField.emptyMapField(AbilityKeyMapDefaultEntryHolder.defaultEntry) : mapField;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Message parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Message) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Message parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Message> parser() {
            return PARSER;
        }

        public boolean containsAbilityKeyMap(String str) {
            str.getClass();
            return internalGetAbilityKeyMap().getMap().containsKey(str);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Message)) {
                return super.equals(obj);
            }
            Message message = (Message) obj;
            return this.type_ == message.type_ && getSendAppUniteCode().equals(message.getSendAppUniteCode()) && getAbilityKeyList().equals(message.getAbilityKeyList()) && getMsg().equals(message.getMsg()) && getMsgUniqueKey().equals(message.getMsgUniqueKey()) && this.appUniteCodeType_ == message.appUniteCodeType_ && getErrorCode() == message.getErrorCode() && getSuccessCode() == message.getSuccessCode() && getNeedCallBack() == message.getNeedCallBack() && getReceiveAppUniteCode().equals(message.getReceiveAppUniteCode()) && getOpenType() == message.getOpenType() && getListenerId() == message.getListenerId() && internalGetAbilityKeyMap().equals(message.internalGetAbilityKeyMap()) && getSendAUCNum() == message.getSendAUCNum() && getReceiveAUCNum() == message.getReceiveAUCNum() && getSupportMap() == message.getSupportMap() && this.unknownFields.equals(message.unknownFields);
        }

        public String getAbilityKey(int i) {
            return (String) this.abilityKey_.get(i);
        }

        public ByteString getAbilityKeyBytes(int i) {
            return this.abilityKey_.getByteString(i);
        }

        public int getAbilityKeyCount() {
            return this.abilityKey_.size();
        }

        @Deprecated
        public Map<String, Integer> getAbilityKeyMap() {
            return getAbilityKeyMapMap();
        }

        public int getAbilityKeyMapCount() {
            return internalGetAbilityKeyMap().getMap().size();
        }

        public Map<String, Integer> getAbilityKeyMapMap() {
            return internalGetAbilityKeyMap().getMap();
        }

        public int getAbilityKeyMapOrDefault(String str, int i) {
            str.getClass();
            Map<String, Integer> map = internalGetAbilityKeyMap().getMap();
            return map.containsKey(str) ? map.get(str).intValue() : i;
        }

        public int getAbilityKeyMapOrThrow(String str) {
            str.getClass();
            Map<String, Integer> map = internalGetAbilityKeyMap().getMap();
            if (map.containsKey(str)) {
                return map.get(str).intValue();
            }
            throw new IllegalArgumentException();
        }

        public AppUniteCodeType getAppUniteCodeType() {
            AppUniteCodeType valueOf = AppUniteCodeType.valueOf(this.appUniteCodeType_);
            return valueOf == null ? AppUniteCodeType.UNRECOGNIZED : valueOf;
        }

        public int getAppUniteCodeTypeValue() {
            return this.appUniteCodeType_;
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public int getListenerId() {
            return this.listenerId_;
        }

        public ByteString getMsg() {
            return this.msg_;
        }

        public String getMsgUniqueKey() {
            Object obj = this.msgUniqueKey_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.msgUniqueKey_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getMsgUniqueKeyBytes() {
            Object obj = this.msgUniqueKey_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.msgUniqueKey_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean getNeedCallBack() {
            return this.needCallBack_;
        }

        public int getOpenType() {
            return this.openType_;
        }

        public Parser<Message> getParserForType() {
            return PARSER;
        }

        public int getReceiveAUCNum() {
            return this.receiveAUCNum_;
        }

        public String getReceiveAppUniteCode() {
            Object obj = this.receiveAppUniteCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.receiveAppUniteCode_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getReceiveAppUniteCodeBytes() {
            Object obj = this.receiveAppUniteCode_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.receiveAppUniteCode_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public int getSendAUCNum() {
            return this.sendAUCNum_;
        }

        public String getSendAppUniteCode() {
            Object obj = this.sendAppUniteCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.sendAppUniteCode_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getSendAppUniteCodeBytes() {
            Object obj = this.sendAppUniteCode_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.sendAppUniteCode_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = this.type_ != StreamType.OPEN.getNumber() ? CodedOutputStream.computeEnumSize(1, this.type_) : 0;
            if (!getSendAppUniteCodeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(2, this.sendAppUniteCode_);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.abilityKey_.size(); i3++) {
                i2 += GeneratedMessageV3.computeStringSizeNoTag(this.abilityKey_.getRaw(i3));
            }
            int size = computeEnumSize + i2 + getAbilityKeyList().size();
            if (!this.msg_.isEmpty()) {
                size += CodedOutputStream.computeBytesSize(4, this.msg_);
            }
            if (!getMsgUniqueKeyBytes().isEmpty()) {
                size += GeneratedMessageV3.computeStringSize(5, this.msgUniqueKey_);
            }
            if (this.appUniteCodeType_ != AppUniteCodeType.ADD.getNumber()) {
                size += CodedOutputStream.computeEnumSize(6, this.appUniteCodeType_);
            }
            int i4 = this.errorCode_;
            if (i4 != 0) {
                size += CodedOutputStream.computeInt32Size(7, i4);
            }
            int i5 = this.successCode_;
            if (i5 != 0) {
                size += CodedOutputStream.computeInt32Size(8, i5);
            }
            boolean z = this.needCallBack_;
            if (z) {
                size += CodedOutputStream.computeBoolSize(9, z);
            }
            if (!getReceiveAppUniteCodeBytes().isEmpty()) {
                size += GeneratedMessageV3.computeStringSize(10, this.receiveAppUniteCode_);
            }
            int i6 = this.openType_;
            if (i6 != 0) {
                size += CodedOutputStream.computeInt32Size(11, i6);
            }
            int i7 = this.listenerId_;
            if (i7 != 0) {
                size += CodedOutputStream.computeInt32Size(12, i7);
            }
            for (Map.Entry next : internalGetAbilityKeyMap().getMap().entrySet()) {
                size += CodedOutputStream.computeMessageSize(13, AbilityKeyMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey((String) next.getKey()).setValue((Integer) next.getValue()).build());
            }
            int i8 = this.sendAUCNum_;
            if (i8 != 0) {
                size += CodedOutputStream.computeInt32Size(14, i8);
            }
            int i9 = this.receiveAUCNum_;
            if (i9 != 0) {
                size += CodedOutputStream.computeInt32Size(15, i9);
            }
            boolean z2 = this.supportMap_;
            if (z2) {
                size += CodedOutputStream.computeBoolSize(16, z2);
            }
            int serializedSize = size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public int getSuccessCode() {
            return this.successCode_;
        }

        public boolean getSupportMap() {
            return this.supportMap_;
        }

        public StreamType getType() {
            StreamType valueOf = StreamType.valueOf(this.type_);
            return valueOf == null ? StreamType.UNRECOGNIZED : valueOf;
        }

        public int getTypeValue() {
            return this.type_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.type_) * 37) + 2) * 53) + getSendAppUniteCode().hashCode();
            if (getAbilityKeyCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getAbilityKeyList().hashCode();
            }
            int hashCode2 = (((((((((((((((((((((((((((((((((((hashCode * 37) + 4) * 53) + getMsg().hashCode()) * 37) + 5) * 53) + getMsgUniqueKey().hashCode()) * 37) + 6) * 53) + this.appUniteCodeType_) * 37) + 7) * 53) + getErrorCode()) * 37) + 8) * 53) + getSuccessCode()) * 37) + 9) * 53) + Internal.hashBoolean(getNeedCallBack())) * 37) + 10) * 53) + getReceiveAppUniteCode().hashCode()) * 37) + 11) * 53) + getOpenType()) * 37) + 12) * 53) + getListenerId();
            if (!internalGetAbilityKeyMap().getMap().isEmpty()) {
                hashCode2 = (((hashCode2 * 37) + 13) * 53) + internalGetAbilityKeyMap().hashCode();
            }
            int sendAUCNum = (((((((((((((hashCode2 * 37) + 14) * 53) + getSendAUCNum()) * 37) + 15) * 53) + getReceiveAUCNum()) * 37) + 16) * 53) + Internal.hashBoolean(getSupportMap())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = sendAUCNum;
            return sendAUCNum;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RelayApi.internal_static_Message_fieldAccessorTable.ensureFieldAccessorsInitialized(Message.class, Builder.class);
        }

        public MapField internalGetMapField(int i) {
            if (i == 13) {
                return internalGetAbilityKeyMap();
            }
            throw new RuntimeException("Invalid map field number: " + i);
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.type_ != StreamType.OPEN.getNumber()) {
                codedOutputStream.writeEnum(1, this.type_);
            }
            if (!getSendAppUniteCodeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.sendAppUniteCode_);
            }
            for (int i = 0; i < this.abilityKey_.size(); i++) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.abilityKey_.getRaw(i));
            }
            if (!this.msg_.isEmpty()) {
                codedOutputStream.writeBytes(4, this.msg_);
            }
            if (!getMsgUniqueKeyBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.msgUniqueKey_);
            }
            if (this.appUniteCodeType_ != AppUniteCodeType.ADD.getNumber()) {
                codedOutputStream.writeEnum(6, this.appUniteCodeType_);
            }
            int i2 = this.errorCode_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(7, i2);
            }
            int i3 = this.successCode_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(8, i3);
            }
            boolean z = this.needCallBack_;
            if (z) {
                codedOutputStream.writeBool(9, z);
            }
            if (!getReceiveAppUniteCodeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.receiveAppUniteCode_);
            }
            int i4 = this.openType_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(11, i4);
            }
            int i5 = this.listenerId_;
            if (i5 != 0) {
                codedOutputStream.writeInt32(12, i5);
            }
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetAbilityKeyMap(), AbilityKeyMapDefaultEntryHolder.defaultEntry, 13);
            int i6 = this.sendAUCNum_;
            if (i6 != 0) {
                codedOutputStream.writeInt32(14, i6);
            }
            int i7 = this.receiveAUCNum_;
            if (i7 != 0) {
                codedOutputStream.writeInt32(15, i7);
            }
            boolean z2 = this.supportMap_;
            if (z2) {
                codedOutputStream.writeBool(16, z2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(Message message) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(message);
        }

        public static Message parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public ProtocolStringList getAbilityKeyList() {
            return this.abilityKey_;
        }

        private Message(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static Message parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Message) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Message parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public Message getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static Message parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Message() {
            this.memoizedIsInitialized = -1;
            this.type_ = 0;
            this.sendAppUniteCode_ = "";
            this.abilityKey_ = LazyStringArrayList.EMPTY;
            this.msg_ = ByteString.EMPTY;
            this.msgUniqueKey_ = "";
            this.appUniteCodeType_ = 0;
            this.errorCode_ = 0;
            this.successCode_ = 0;
            this.needCallBack_ = false;
            this.receiveAppUniteCode_ = "";
            this.openType_ = 0;
            this.listenerId_ = 0;
            this.sendAUCNum_ = 0;
            this.receiveAUCNum_ = 0;
            this.supportMap_ = false;
        }

        public static Message parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static Message parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Message parseFrom(InputStream inputStream) throws IOException {
            return (Message) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Message parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Message) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Message parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Message) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Message parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Message) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        private Message(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            z = true;
                            break;
                        case 8:
                            this.type_ = codedInputStream.readEnum();
                            break;
                        case 18:
                            this.sendAppUniteCode_ = codedInputStream.readStringRequireUtf8();
                            break;
                        case 26:
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            if (!(z2 & true)) {
                                this.abilityKey_ = new LazyStringArrayList();
                                z2 |= true;
                            }
                            this.abilityKey_.add(readStringRequireUtf8);
                            break;
                        case 34:
                            this.msg_ = codedInputStream.readBytes();
                            break;
                        case 42:
                            this.msgUniqueKey_ = codedInputStream.readStringRequireUtf8();
                            break;
                        case 48:
                            this.appUniteCodeType_ = codedInputStream.readEnum();
                            break;
                        case 56:
                            this.errorCode_ = codedInputStream.readInt32();
                            break;
                        case 64:
                            this.successCode_ = codedInputStream.readInt32();
                            break;
                        case 72:
                            this.needCallBack_ = codedInputStream.readBool();
                            break;
                        case 82:
                            this.receiveAppUniteCode_ = codedInputStream.readStringRequireUtf8();
                            break;
                        case 88:
                            this.openType_ = codedInputStream.readInt32();
                            break;
                        case 96:
                            this.listenerId_ = codedInputStream.readInt32();
                            break;
                        case 106:
                            if (!(z2 & true)) {
                                this.abilityKeyMap_ = MapField.newMapField(AbilityKeyMapDefaultEntryHolder.defaultEntry);
                                z2 |= true;
                            }
                            MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(AbilityKeyMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                            this.abilityKeyMap_.getMutableMap().put((String) mapEntry.getKey(), (Integer) mapEntry.getValue());
                            break;
                        case 112:
                            this.sendAUCNum_ = codedInputStream.readInt32();
                            break;
                        case 120:
                            this.receiveAUCNum_ = codedInputStream.readInt32();
                            break;
                        case 128:
                            this.supportMap_ = codedInputStream.readBool();
                            break;
                        default:
                            if (parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                break;
                            }
                            z = true;
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.abilityKey_ = this.abilityKey_.getUnmodifiableView();
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.abilityKey_ = this.abilityKey_.getUnmodifiableView();
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }
    }

    public interface MessageOrBuilder extends com.google.protobuf.MessageOrBuilder {
        boolean containsAbilityKeyMap(String str);

        String getAbilityKey(int i);

        ByteString getAbilityKeyBytes(int i);

        int getAbilityKeyCount();

        List<String> getAbilityKeyList();

        @Deprecated
        Map<String, Integer> getAbilityKeyMap();

        int getAbilityKeyMapCount();

        Map<String, Integer> getAbilityKeyMapMap();

        int getAbilityKeyMapOrDefault(String str, int i);

        int getAbilityKeyMapOrThrow(String str);

        AppUniteCodeType getAppUniteCodeType();

        int getAppUniteCodeTypeValue();

        int getErrorCode();

        int getListenerId();

        ByteString getMsg();

        String getMsgUniqueKey();

        ByteString getMsgUniqueKeyBytes();

        boolean getNeedCallBack();

        int getOpenType();

        int getReceiveAUCNum();

        String getReceiveAppUniteCode();

        ByteString getReceiveAppUniteCodeBytes();

        int getSendAUCNum();

        String getSendAppUniteCode();

        ByteString getSendAppUniteCodeBytes();

        int getSuccessCode();

        boolean getSupportMap();

        StreamType getType();

        int getTypeValue();
    }

    public enum StreamType implements ProtocolMessageEnum {
        OPEN(0),
        CLOSE(1),
        CMD(2),
        SEND_LIST(3),
        GET_LIST(4),
        SEND_MSG(5),
        MSG_SUCCESS(6),
        MSG_FAILED(7),
        REMOTE_SUCCESS(8),
        REMOTE_FAILED(9),
        OPEN_ACTIVITY(10),
        LIST_SUCCESS(11),
        BINDER_LIST(12),
        UNRECOGNIZED(-1);
        
        public static final int BINDER_LIST_VALUE = 12;
        public static final int CLOSE_VALUE = 1;
        public static final int CMD_VALUE = 2;
        public static final int GET_LIST_VALUE = 4;
        public static final int LIST_SUCCESS_VALUE = 11;
        public static final int MSG_FAILED_VALUE = 7;
        public static final int MSG_SUCCESS_VALUE = 6;
        public static final int OPEN_ACTIVITY_VALUE = 10;
        public static final int OPEN_VALUE = 0;
        public static final int REMOTE_FAILED_VALUE = 9;
        public static final int REMOTE_SUCCESS_VALUE = 8;
        public static final int SEND_LIST_VALUE = 3;
        public static final int SEND_MSG_VALUE = 5;
        private static final StreamType[] VALUES = null;
        private static final Internal.EnumLiteMap<StreamType> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<StreamType>() {
                public StreamType findValueByNumber(int i) {
                    return StreamType.forNumber(i);
                }
            };
            VALUES = values();
        }

        private StreamType(int i) {
            this.value = i;
        }

        public static StreamType forNumber(int i) {
            switch (i) {
                case 0:
                    return OPEN;
                case 1:
                    return CLOSE;
                case 2:
                    return CMD;
                case 3:
                    return SEND_LIST;
                case 4:
                    return GET_LIST;
                case 5:
                    return SEND_MSG;
                case 6:
                    return MSG_SUCCESS;
                case 7:
                    return MSG_FAILED;
                case 8:
                    return REMOTE_SUCCESS;
                case 9:
                    return REMOTE_FAILED;
                case 10:
                    return OPEN_ACTIVITY;
                case 11:
                    return LIST_SUCCESS;
                case 12:
                    return BINDER_LIST;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return RelayApi.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<StreamType> internalGetValueMap() {
            return internalValueMap;
        }

        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        @Deprecated
        public static StreamType valueOf(int i) {
            return forNumber(i);
        }

        public static StreamType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[enumValueDescriptor.getIndex()];
            }
        }
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000frelay_api.proto\"Ì\u0003\n\u0007Message\u0012\u0019\n\u0004type\u0018\u0001 \u0001(\u000e2\u000b.StreamType\u0012\u0018\n\u0010sendAppUniteCode\u0018\u0002 \u0001(\t\u0012\u0012\n\nabilityKey\u0018\u0003 \u0003(\t\u0012\u000b\n\u0003msg\u0018\u0004 \u0001(\f\u0012\u0014\n\fmsgUniqueKey\u0018\u0005 \u0001(\t\u0012+\n\u0010appUniteCodeType\u0018\u0006 \u0001(\u000e2\u0011.AppUniteCodeType\u0012\u0011\n\terrorCode\u0018\u0007 \u0001(\u0005\u0012\u0013\n\u000bsuccessCode\u0018\b \u0001(\u0005\u0012\u0014\n\fneedCallBack\u0018\t \u0001(\b\u0012\u001b\n\u0013receiveAppUniteCode\u0018\n \u0001(\t\u0012\u0010\n\bOpenType\u0018\u000b \u0001(\u0005\u0012\u0012\n\nlistenerId\u0018\f \u0001(\u0005\u00122\n\rabilityKeyMap\u0018\r \u0003(\u000b2\u001b.Message.AbilityKeyMapEntry\u0012\u0012\n\nsendAUCNum\u0018\u000e \u0001(\u0005\u0012\u0015\n\rreceiveAUCNum\u0018\u000f \u0001(\u0005\u0012\u0012\n\nsupportMap\u0018\u0010 \u0001(\b\u001a4\n\u0012AbilityKeyMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\u0005:\u00028\u0001*Ó\u0001\n\nStreamType\u0012\b\n\u0004OPEN\u0010\u0000\u0012\t\n\u0005CLOSE\u0010\u0001\u0012\u0007\n\u0003CMD\u0010\u0002\u0012\r\n\tSEND_LIST\u0010\u0003\u0012\f\n\bGET_LIST\u0010\u0004\u0012\f\n\bSEND_MSG\u0010\u0005\u0012\u000f\n\u000bMSG_SUCCESS\u0010\u0006\u0012\u000e\n\nMSG_FAILED\u0010\u0007\u0012\u0012\n\u000eREMOTE_SUCCESS\u0010\b\u0012\u0011\n\rREMOTE_FAILED\u0010\t\u0012\u0011\n\rOPEN_ACTIVITY\u0010\n\u0012\u0010\n\fLIST_SUCCESS\u0010\u000b\u0012\u000f\n\u000bBINDER_LIST\u0010\f*$\n\u0010AppUniteCodeType\u0012\u0007\n\u0003ADD\u0010\u0000\u0012\u0007\n\u0003DEL\u0010\u0001B\u0017\n\u0015com.upuphone.runasoneb\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = RelayApi.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_Message_descriptor = descriptor2;
        internal_static_Message_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Type", "SendAppUniteCode", "AbilityKey", "Msg", "MsgUniqueKey", "AppUniteCodeType", "ErrorCode", "SuccessCode", "NeedCallBack", "ReceiveAppUniteCode", "OpenType", "ListenerId", "AbilityKeyMap", "SendAUCNum", "ReceiveAUCNum", "SupportMap"});
        Descriptors.Descriptor descriptor3 = descriptor2.getNestedTypes().get(0);
        internal_static_Message_AbilityKeyMapEntry_descriptor = descriptor3;
        internal_static_Message_AbilityKeyMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Key", BleConstants.EXTRA_MESSAGE2});
    }

    private RelayApi() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }
}
