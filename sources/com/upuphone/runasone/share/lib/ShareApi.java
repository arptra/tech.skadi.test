package com.upuphone.runasone.share.lib;

import com.alibaba.fastjson.asm.Opcodes;
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
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class ShareApi {
    /* access modifiers changed from: private */
    public static Descriptors.FileDescriptor descriptor;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Message_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Message_fieldAccessorTable;

    public static final class Message extends GeneratedMessageV3 implements MessageOrBuilder {
        public static final int BEGINSTART_FIELD_NUMBER = 17;
        public static final int CHUNKDATA_FIELD_NUMBER = 14;
        public static final int CHUNKEND_FIELD_NUMBER = 22;
        public static final int CHUNKSIZE_FIELD_NUMBER = 13;
        public static final int CHUNKSTART_FIELD_NUMBER = 18;
        public static final int COUNT_FIELD_NUMBER = 16;
        private static final Message DEFAULT_INSTANCE = new Message();
        public static final int DIRPATH_FIELD_NUMBER = 2;
        public static final int EXTRA_FIELD_NUMBER = 5;
        public static final int FILEINFOS_FIELD_NUMBER = 4;
        public static final int FILENAME_FIELD_NUMBER = 21;
        public static final int FILERESUMEINFO_FIELD_NUMBER = 11;
        public static final int IPADDRESS_FIELD_NUMBER = 10;
        public static final int MD5_FIELD_NUMBER = 20;
        public static final int OPERATOR_FIELD_NUMBER = 7;
        public static final int ORDER_FIELD_NUMBER = 19;
        public static final int PACKAGENAME_FIELD_NUMBER = 8;
        /* access modifiers changed from: private */
        public static final Parser<Message> PARSER = new AbstractParser<Message>() {
            public Message parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Message(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PATHS_FIELD_NUMBER = 6;
        public static final int PORT_FIELD_NUMBER = 9;
        public static final int STATUS_FIELD_NUMBER = 12;
        public static final int TASKID_FIELD_NUMBER = 3;
        public static final int TOTALSIZE_FIELD_NUMBER = 15;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public long beginStart_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public ByteString chunkData_;
        /* access modifiers changed from: private */
        public long chunkEnd_;
        /* access modifiers changed from: private */
        public long chunkSize_;
        /* access modifiers changed from: private */
        public long chunkStart_;
        /* access modifiers changed from: private */
        public int count_;
        /* access modifiers changed from: private */
        public volatile Object dirPath_;
        /* access modifiers changed from: private */
        public volatile Object extra_;
        /* access modifiers changed from: private */
        public volatile Object fileInfos_;
        /* access modifiers changed from: private */
        public volatile Object fileName_;
        /* access modifiers changed from: private */
        public volatile Object fileResumeInfo_;
        /* access modifiers changed from: private */
        public volatile Object ipAddress_;
        /* access modifiers changed from: private */
        public volatile Object md5_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public int operator_;
        /* access modifiers changed from: private */
        public int order_;
        /* access modifiers changed from: private */
        public volatile Object packageName_;
        /* access modifiers changed from: private */
        public LazyStringList paths_;
        /* access modifiers changed from: private */
        public int port_;
        /* access modifiers changed from: private */
        public int status_;
        /* access modifiers changed from: private */
        public volatile Object taskId_;
        /* access modifiers changed from: private */
        public long totalSize_;
        /* access modifiers changed from: private */
        public int type_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MessageOrBuilder {
            private long beginStart_;
            private int bitField0_;
            private ByteString chunkData_;
            private long chunkEnd_;
            private long chunkSize_;
            private long chunkStart_;
            private int count_;
            private Object dirPath_;
            private Object extra_;
            private Object fileInfos_;
            private Object fileName_;
            private Object fileResumeInfo_;
            private Object ipAddress_;
            private Object md5_;
            private int operator_;
            private int order_;
            private Object packageName_;
            private LazyStringList paths_;
            private int port_;
            private int status_;
            private Object taskId_;
            private long totalSize_;
            private int type_;

            private void ensurePathsIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.paths_ = new LazyStringArrayList(this.paths_);
                    this.bitField0_ |= 32;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ShareApi.internal_static_Message_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder addAllPaths(Iterable<String> iterable) {
                ensurePathsIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.paths_);
                onChanged();
                return this;
            }

            public Builder addPaths(String str) {
                str.getClass();
                ensurePathsIsMutable();
                this.paths_.add(str);
                onChanged();
                return this;
            }

            public Builder addPathsBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                ensurePathsIsMutable();
                this.paths_.add(byteString);
                onChanged();
                return this;
            }

            public Builder clearBeginStart() {
                this.beginStart_ = 0;
                onChanged();
                return this;
            }

            public Builder clearChunkData() {
                this.chunkData_ = Message.getDefaultInstance().getChunkData();
                onChanged();
                return this;
            }

            public Builder clearChunkEnd() {
                this.chunkEnd_ = 0;
                onChanged();
                return this;
            }

            public Builder clearChunkSize() {
                this.chunkSize_ = 0;
                onChanged();
                return this;
            }

            public Builder clearChunkStart() {
                this.chunkStart_ = 0;
                onChanged();
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
                onChanged();
                return this;
            }

            public Builder clearDirPath() {
                this.dirPath_ = Message.getDefaultInstance().getDirPath();
                onChanged();
                return this;
            }

            public Builder clearExtra() {
                this.extra_ = Message.getDefaultInstance().getExtra();
                onChanged();
                return this;
            }

            public Builder clearFileInfos() {
                this.fileInfos_ = Message.getDefaultInstance().getFileInfos();
                onChanged();
                return this;
            }

            public Builder clearFileName() {
                this.fileName_ = Message.getDefaultInstance().getFileName();
                onChanged();
                return this;
            }

            public Builder clearFileResumeInfo() {
                this.fileResumeInfo_ = Message.getDefaultInstance().getFileResumeInfo();
                onChanged();
                return this;
            }

            public Builder clearIpAddress() {
                this.ipAddress_ = Message.getDefaultInstance().getIpAddress();
                onChanged();
                return this;
            }

            public Builder clearMd5() {
                this.md5_ = Message.getDefaultInstance().getMd5();
                onChanged();
                return this;
            }

            public Builder clearOperator() {
                this.operator_ = 0;
                onChanged();
                return this;
            }

            public Builder clearOrder() {
                this.order_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPackageName() {
                this.packageName_ = Message.getDefaultInstance().getPackageName();
                onChanged();
                return this;
            }

            public Builder clearPaths() {
                this.paths_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }

            public Builder clearPort() {
                this.port_ = 0;
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.status_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTaskId() {
                this.taskId_ = Message.getDefaultInstance().getTaskId();
                onChanged();
                return this;
            }

            public Builder clearTotalSize() {
                this.totalSize_ = 0;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            public long getBeginStart() {
                return this.beginStart_;
            }

            public ByteString getChunkData() {
                return this.chunkData_;
            }

            public long getChunkEnd() {
                return this.chunkEnd_;
            }

            public long getChunkSize() {
                return this.chunkSize_;
            }

            public long getChunkStart() {
                return this.chunkStart_;
            }

            public int getCount() {
                return this.count_;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ShareApi.internal_static_Message_descriptor;
            }

            public String getDirPath() {
                Object obj = this.dirPath_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.dirPath_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getDirPathBytes() {
                Object obj = this.dirPath_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.dirPath_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getExtra() {
                Object obj = this.extra_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.extra_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getExtraBytes() {
                Object obj = this.extra_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.extra_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getFileInfos() {
                Object obj = this.fileInfos_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.fileInfos_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getFileInfosBytes() {
                Object obj = this.fileInfos_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fileInfos_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getFileName() {
                Object obj = this.fileName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.fileName_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getFileNameBytes() {
                Object obj = this.fileName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fileName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getFileResumeInfo() {
                Object obj = this.fileResumeInfo_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.fileResumeInfo_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getFileResumeInfoBytes() {
                Object obj = this.fileResumeInfo_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fileResumeInfo_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getIpAddress() {
                Object obj = this.ipAddress_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ipAddress_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getIpAddressBytes() {
                Object obj = this.ipAddress_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ipAddress_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getMd5() {
                Object obj = this.md5_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.md5_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getMd5Bytes() {
                Object obj = this.md5_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.md5_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public int getOperator() {
                return this.operator_;
            }

            public int getOrder() {
                return this.order_;
            }

            public String getPackageName() {
                Object obj = this.packageName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.packageName_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getPackageNameBytes() {
                Object obj = this.packageName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.packageName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getPaths(int i) {
                return (String) this.paths_.get(i);
            }

            public ByteString getPathsBytes(int i) {
                return this.paths_.getByteString(i);
            }

            public int getPathsCount() {
                return this.paths_.size();
            }

            public int getPort() {
                return this.port_;
            }

            public int getStatus() {
                return this.status_;
            }

            public String getTaskId() {
                Object obj = this.taskId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.taskId_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getTaskIdBytes() {
                Object obj = this.taskId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.taskId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getTotalSize() {
                return this.totalSize_;
            }

            public StreamType getType() {
                StreamType valueOf = StreamType.valueOf(this.type_);
                return valueOf == null ? StreamType.UNRECOGNIZED : valueOf;
            }

            public int getTypeValue() {
                return this.type_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShareApi.internal_static_Message_fieldAccessorTable.ensureFieldAccessorsInitialized(Message.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setBeginStart(long j) {
                this.beginStart_ = j;
                onChanged();
                return this;
            }

            public Builder setChunkData(ByteString byteString) {
                byteString.getClass();
                this.chunkData_ = byteString;
                onChanged();
                return this;
            }

            public Builder setChunkEnd(long j) {
                this.chunkEnd_ = j;
                onChanged();
                return this;
            }

            public Builder setChunkSize(long j) {
                this.chunkSize_ = j;
                onChanged();
                return this;
            }

            public Builder setChunkStart(long j) {
                this.chunkStart_ = j;
                onChanged();
                return this;
            }

            public Builder setCount(int i) {
                this.count_ = i;
                onChanged();
                return this;
            }

            public Builder setDirPath(String str) {
                str.getClass();
                this.dirPath_ = str;
                onChanged();
                return this;
            }

            public Builder setDirPathBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.dirPath_ = byteString;
                onChanged();
                return this;
            }

            public Builder setExtra(String str) {
                str.getClass();
                this.extra_ = str;
                onChanged();
                return this;
            }

            public Builder setExtraBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.extra_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFileInfos(String str) {
                str.getClass();
                this.fileInfos_ = str;
                onChanged();
                return this;
            }

            public Builder setFileInfosBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.fileInfos_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFileName(String str) {
                str.getClass();
                this.fileName_ = str;
                onChanged();
                return this;
            }

            public Builder setFileNameBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.fileName_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFileResumeInfo(String str) {
                str.getClass();
                this.fileResumeInfo_ = str;
                onChanged();
                return this;
            }

            public Builder setFileResumeInfoBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.fileResumeInfo_ = byteString;
                onChanged();
                return this;
            }

            public Builder setIpAddress(String str) {
                str.getClass();
                this.ipAddress_ = str;
                onChanged();
                return this;
            }

            public Builder setIpAddressBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.ipAddress_ = byteString;
                onChanged();
                return this;
            }

            public Builder setMd5(String str) {
                str.getClass();
                this.md5_ = str;
                onChanged();
                return this;
            }

            public Builder setMd5Bytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.md5_ = byteString;
                onChanged();
                return this;
            }

            public Builder setOperator(int i) {
                this.operator_ = i;
                onChanged();
                return this;
            }

            public Builder setOrder(int i) {
                this.order_ = i;
                onChanged();
                return this;
            }

            public Builder setPackageName(String str) {
                str.getClass();
                this.packageName_ = str;
                onChanged();
                return this;
            }

            public Builder setPackageNameBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.packageName_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPaths(int i, String str) {
                str.getClass();
                ensurePathsIsMutable();
                this.paths_.set(i, str);
                onChanged();
                return this;
            }

            public Builder setPort(int i) {
                this.port_ = i;
                onChanged();
                return this;
            }

            public Builder setStatus(int i) {
                this.status_ = i;
                onChanged();
                return this;
            }

            public Builder setTaskId(String str) {
                str.getClass();
                this.taskId_ = str;
                onChanged();
                return this;
            }

            public Builder setTaskIdBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.taskId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTotalSize(long j) {
                this.totalSize_ = j;
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

            public ProtocolStringList getPathsList() {
                return this.paths_.getUnmodifiableView();
            }

            private Builder() {
                this.type_ = 0;
                this.dirPath_ = "";
                this.taskId_ = "";
                this.fileInfos_ = "";
                this.extra_ = "";
                this.paths_ = LazyStringArrayList.EMPTY;
                this.packageName_ = "";
                this.ipAddress_ = "";
                this.fileResumeInfo_ = "";
                this.chunkData_ = ByteString.EMPTY;
                this.md5_ = "";
                this.fileName_ = "";
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
                Object unused2 = message.dirPath_ = this.dirPath_;
                Object unused3 = message.taskId_ = this.taskId_;
                Object unused4 = message.fileInfos_ = this.fileInfos_;
                Object unused5 = message.extra_ = this.extra_;
                if ((this.bitField0_ & 32) == 32) {
                    this.paths_ = this.paths_.getUnmodifiableView();
                    this.bitField0_ &= -33;
                }
                LazyStringList unused6 = message.paths_ = this.paths_;
                int unused7 = message.operator_ = this.operator_;
                Object unused8 = message.packageName_ = this.packageName_;
                int unused9 = message.port_ = this.port_;
                Object unused10 = message.ipAddress_ = this.ipAddress_;
                Object unused11 = message.fileResumeInfo_ = this.fileResumeInfo_;
                int unused12 = message.status_ = this.status_;
                long unused13 = message.chunkSize_ = this.chunkSize_;
                ByteString unused14 = message.chunkData_ = this.chunkData_;
                long unused15 = message.totalSize_ = this.totalSize_;
                int unused16 = message.count_ = this.count_;
                long unused17 = message.beginStart_ = this.beginStart_;
                long unused18 = message.chunkStart_ = this.chunkStart_;
                int unused19 = message.order_ = this.order_;
                Object unused20 = message.md5_ = this.md5_;
                Object unused21 = message.fileName_ = this.fileName_;
                long unused22 = message.chunkEnd_ = this.chunkEnd_;
                int unused23 = message.bitField0_ = 0;
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
                this.dirPath_ = "";
                this.taskId_ = "";
                this.fileInfos_ = "";
                this.extra_ = "";
                this.paths_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -33;
                this.operator_ = 0;
                this.packageName_ = "";
                this.port_ = 0;
                this.ipAddress_ = "";
                this.fileResumeInfo_ = "";
                this.status_ = 0;
                this.chunkSize_ = 0;
                this.chunkData_ = ByteString.EMPTY;
                this.totalSize_ = 0;
                this.count_ = 0;
                this.beginStart_ = 0;
                this.chunkStart_ = 0;
                this.order_ = 0;
                this.md5_ = "";
                this.fileName_ = "";
                this.chunkEnd_ = 0;
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
                if (!message.getDirPath().isEmpty()) {
                    this.dirPath_ = message.dirPath_;
                    onChanged();
                }
                if (!message.getTaskId().isEmpty()) {
                    this.taskId_ = message.taskId_;
                    onChanged();
                }
                if (!message.getFileInfos().isEmpty()) {
                    this.fileInfos_ = message.fileInfos_;
                    onChanged();
                }
                if (!message.getExtra().isEmpty()) {
                    this.extra_ = message.extra_;
                    onChanged();
                }
                if (!message.paths_.isEmpty()) {
                    if (this.paths_.isEmpty()) {
                        this.paths_ = message.paths_;
                        this.bitField0_ &= -33;
                    } else {
                        ensurePathsIsMutable();
                        this.paths_.addAll(message.paths_);
                    }
                    onChanged();
                }
                if (message.getOperator() != 0) {
                    setOperator(message.getOperator());
                }
                if (!message.getPackageName().isEmpty()) {
                    this.packageName_ = message.packageName_;
                    onChanged();
                }
                if (message.getPort() != 0) {
                    setPort(message.getPort());
                }
                if (!message.getIpAddress().isEmpty()) {
                    this.ipAddress_ = message.ipAddress_;
                    onChanged();
                }
                if (!message.getFileResumeInfo().isEmpty()) {
                    this.fileResumeInfo_ = message.fileResumeInfo_;
                    onChanged();
                }
                if (message.getStatus() != 0) {
                    setStatus(message.getStatus());
                }
                if (message.getChunkSize() != 0) {
                    setChunkSize(message.getChunkSize());
                }
                if (message.getChunkData() != ByteString.EMPTY) {
                    setChunkData(message.getChunkData());
                }
                if (message.getTotalSize() != 0) {
                    setTotalSize(message.getTotalSize());
                }
                if (message.getCount() != 0) {
                    setCount(message.getCount());
                }
                if (message.getBeginStart() != 0) {
                    setBeginStart(message.getBeginStart());
                }
                if (message.getChunkStart() != 0) {
                    setChunkStart(message.getChunkStart());
                }
                if (message.getOrder() != 0) {
                    setOrder(message.getOrder());
                }
                if (!message.getMd5().isEmpty()) {
                    this.md5_ = message.md5_;
                    onChanged();
                }
                if (!message.getFileName().isEmpty()) {
                    this.fileName_ = message.fileName_;
                    onChanged();
                }
                if (message.getChunkEnd() != 0) {
                    setChunkEnd(message.getChunkEnd());
                }
                mergeUnknownFields(message.unknownFields);
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.type_ = 0;
                this.dirPath_ = "";
                this.taskId_ = "";
                this.fileInfos_ = "";
                this.extra_ = "";
                this.paths_ = LazyStringArrayList.EMPTY;
                this.packageName_ = "";
                this.ipAddress_ = "";
                this.fileResumeInfo_ = "";
                this.chunkData_ = ByteString.EMPTY;
                this.md5_ = "";
                this.fileName_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.upuphone.runasone.share.lib.ShareApi.Message.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.upuphone.runasone.share.lib.ShareApi.Message.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    com.upuphone.runasone.share.lib.ShareApi$Message r3 = (com.upuphone.runasone.share.lib.ShareApi.Message) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((com.upuphone.runasone.share.lib.ShareApi.Message) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    com.upuphone.runasone.share.lib.ShareApi$Message r4 = (com.upuphone.runasone.share.lib.ShareApi.Message) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((com.upuphone.runasone.share.lib.ShareApi.Message) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.share.lib.ShareApi.Message.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.upuphone.runasone.share.lib.ShareApi$Message$Builder");
            }
        }

        public static Message getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ShareApi.internal_static_Message_descriptor;
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

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Message)) {
                return super.equals(obj);
            }
            Message message = (Message) obj;
            return this.type_ == message.type_ && getDirPath().equals(message.getDirPath()) && getTaskId().equals(message.getTaskId()) && getFileInfos().equals(message.getFileInfos()) && getExtra().equals(message.getExtra()) && getPathsList().equals(message.getPathsList()) && getOperator() == message.getOperator() && getPackageName().equals(message.getPackageName()) && getPort() == message.getPort() && getIpAddress().equals(message.getIpAddress()) && getFileResumeInfo().equals(message.getFileResumeInfo()) && getStatus() == message.getStatus() && getChunkSize() == message.getChunkSize() && getChunkData().equals(message.getChunkData()) && getTotalSize() == message.getTotalSize() && getCount() == message.getCount() && getBeginStart() == message.getBeginStart() && getChunkStart() == message.getChunkStart() && getOrder() == message.getOrder() && getMd5().equals(message.getMd5()) && getFileName().equals(message.getFileName()) && getChunkEnd() == message.getChunkEnd() && this.unknownFields.equals(message.unknownFields);
        }

        public long getBeginStart() {
            return this.beginStart_;
        }

        public ByteString getChunkData() {
            return this.chunkData_;
        }

        public long getChunkEnd() {
            return this.chunkEnd_;
        }

        public long getChunkSize() {
            return this.chunkSize_;
        }

        public long getChunkStart() {
            return this.chunkStart_;
        }

        public int getCount() {
            return this.count_;
        }

        public String getDirPath() {
            Object obj = this.dirPath_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.dirPath_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDirPathBytes() {
            Object obj = this.dirPath_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.dirPath_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getExtra() {
            Object obj = this.extra_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.extra_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getExtraBytes() {
            Object obj = this.extra_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.extra_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getFileInfos() {
            Object obj = this.fileInfos_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fileInfos_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getFileInfosBytes() {
            Object obj = this.fileInfos_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fileInfos_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getFileName() {
            Object obj = this.fileName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fileName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getFileNameBytes() {
            Object obj = this.fileName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fileName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getFileResumeInfo() {
            Object obj = this.fileResumeInfo_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fileResumeInfo_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getFileResumeInfoBytes() {
            Object obj = this.fileResumeInfo_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fileResumeInfo_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getIpAddress() {
            Object obj = this.ipAddress_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.ipAddress_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getIpAddressBytes() {
            Object obj = this.ipAddress_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ipAddress_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getMd5() {
            Object obj = this.md5_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.md5_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getMd5Bytes() {
            Object obj = this.md5_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.md5_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public int getOperator() {
            return this.operator_;
        }

        public int getOrder() {
            return this.order_;
        }

        public String getPackageName() {
            Object obj = this.packageName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.packageName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getPackageNameBytes() {
            Object obj = this.packageName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.packageName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<Message> getParserForType() {
            return PARSER;
        }

        public String getPaths(int i) {
            return (String) this.paths_.get(i);
        }

        public ByteString getPathsBytes(int i) {
            return this.paths_.getByteString(i);
        }

        public int getPathsCount() {
            return this.paths_.size();
        }

        public int getPort() {
            return this.port_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = this.type_ != StreamType.DEFAULT.getNumber() ? CodedOutputStream.computeEnumSize(1, this.type_) : 0;
            if (!getDirPathBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(2, this.dirPath_);
            }
            if (!getTaskIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(3, this.taskId_);
            }
            if (!getFileInfosBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(4, this.fileInfos_);
            }
            if (!getExtraBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(5, this.extra_);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.paths_.size(); i3++) {
                i2 += GeneratedMessageV3.computeStringSizeNoTag(this.paths_.getRaw(i3));
            }
            int size = computeEnumSize + i2 + getPathsList().size();
            int i4 = this.operator_;
            if (i4 != 0) {
                size += CodedOutputStream.computeInt32Size(7, i4);
            }
            if (!getPackageNameBytes().isEmpty()) {
                size += GeneratedMessageV3.computeStringSize(8, this.packageName_);
            }
            int i5 = this.port_;
            if (i5 != 0) {
                size += CodedOutputStream.computeInt32Size(9, i5);
            }
            if (!getIpAddressBytes().isEmpty()) {
                size += GeneratedMessageV3.computeStringSize(10, this.ipAddress_);
            }
            if (!getFileResumeInfoBytes().isEmpty()) {
                size += GeneratedMessageV3.computeStringSize(11, this.fileResumeInfo_);
            }
            int i6 = this.status_;
            if (i6 != 0) {
                size += CodedOutputStream.computeInt32Size(12, i6);
            }
            long j = this.chunkSize_;
            if (j != 0) {
                size += CodedOutputStream.computeInt64Size(13, j);
            }
            if (!this.chunkData_.isEmpty()) {
                size += CodedOutputStream.computeBytesSize(14, this.chunkData_);
            }
            long j2 = this.totalSize_;
            if (j2 != 0) {
                size += CodedOutputStream.computeInt64Size(15, j2);
            }
            int i7 = this.count_;
            if (i7 != 0) {
                size += CodedOutputStream.computeInt32Size(16, i7);
            }
            long j3 = this.beginStart_;
            if (j3 != 0) {
                size += CodedOutputStream.computeInt64Size(17, j3);
            }
            long j4 = this.chunkStart_;
            if (j4 != 0) {
                size += CodedOutputStream.computeInt64Size(18, j4);
            }
            int i8 = this.order_;
            if (i8 != 0) {
                size += CodedOutputStream.computeInt32Size(19, i8);
            }
            if (!getMd5Bytes().isEmpty()) {
                size += GeneratedMessageV3.computeStringSize(20, this.md5_);
            }
            if (!getFileNameBytes().isEmpty()) {
                size += GeneratedMessageV3.computeStringSize(21, this.fileName_);
            }
            long j5 = this.chunkEnd_;
            if (j5 != 0) {
                size += CodedOutputStream.computeInt64Size(22, j5);
            }
            int serializedSize = size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public int getStatus() {
            return this.status_;
        }

        public String getTaskId() {
            Object obj = this.taskId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.taskId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getTaskIdBytes() {
            Object obj = this.taskId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.taskId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getTotalSize() {
            return this.totalSize_;
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
            int hashCode = ((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.type_) * 37) + 2) * 53) + getDirPath().hashCode()) * 37) + 3) * 53) + getTaskId().hashCode()) * 37) + 4) * 53) + getFileInfos().hashCode()) * 37) + 5) * 53) + getExtra().hashCode();
            if (getPathsCount() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + getPathsList().hashCode();
            }
            int operator = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 37) + 7) * 53) + getOperator()) * 37) + 8) * 53) + getPackageName().hashCode()) * 37) + 9) * 53) + getPort()) * 37) + 10) * 53) + getIpAddress().hashCode()) * 37) + 11) * 53) + getFileResumeInfo().hashCode()) * 37) + 12) * 53) + getStatus()) * 37) + 13) * 53) + Internal.hashLong(getChunkSize())) * 37) + 14) * 53) + getChunkData().hashCode()) * 37) + 15) * 53) + Internal.hashLong(getTotalSize())) * 37) + 16) * 53) + getCount()) * 37) + 17) * 53) + Internal.hashLong(getBeginStart())) * 37) + 18) * 53) + Internal.hashLong(getChunkStart())) * 37) + 19) * 53) + getOrder()) * 37) + 20) * 53) + getMd5().hashCode()) * 37) + 21) * 53) + getFileName().hashCode()) * 37) + 22) * 53) + Internal.hashLong(getChunkEnd())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = operator;
            return operator;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShareApi.internal_static_Message_fieldAccessorTable.ensureFieldAccessorsInitialized(Message.class, Builder.class);
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
            if (this.type_ != StreamType.DEFAULT.getNumber()) {
                codedOutputStream.writeEnum(1, this.type_);
            }
            if (!getDirPathBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.dirPath_);
            }
            if (!getTaskIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.taskId_);
            }
            if (!getFileInfosBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.fileInfos_);
            }
            if (!getExtraBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.extra_);
            }
            for (int i = 0; i < this.paths_.size(); i++) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.paths_.getRaw(i));
            }
            int i2 = this.operator_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(7, i2);
            }
            if (!getPackageNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.packageName_);
            }
            int i3 = this.port_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(9, i3);
            }
            if (!getIpAddressBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.ipAddress_);
            }
            if (!getFileResumeInfoBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.fileResumeInfo_);
            }
            int i4 = this.status_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(12, i4);
            }
            long j = this.chunkSize_;
            if (j != 0) {
                codedOutputStream.writeInt64(13, j);
            }
            if (!this.chunkData_.isEmpty()) {
                codedOutputStream.writeBytes(14, this.chunkData_);
            }
            long j2 = this.totalSize_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(15, j2);
            }
            int i5 = this.count_;
            if (i5 != 0) {
                codedOutputStream.writeInt32(16, i5);
            }
            long j3 = this.beginStart_;
            if (j3 != 0) {
                codedOutputStream.writeInt64(17, j3);
            }
            long j4 = this.chunkStart_;
            if (j4 != 0) {
                codedOutputStream.writeInt64(18, j4);
            }
            int i6 = this.order_;
            if (i6 != 0) {
                codedOutputStream.writeInt32(19, i6);
            }
            if (!getMd5Bytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 20, this.md5_);
            }
            if (!getFileNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 21, this.fileName_);
            }
            long j5 = this.chunkEnd_;
            if (j5 != 0) {
                codedOutputStream.writeInt64(22, j5);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static Builder newBuilder(Message message) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(message);
        }

        public static Message parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public ProtocolStringList getPathsList() {
            return this.paths_;
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
            this.dirPath_ = "";
            this.taskId_ = "";
            this.fileInfos_ = "";
            this.extra_ = "";
            this.paths_ = LazyStringArrayList.EMPTY;
            this.operator_ = 0;
            this.packageName_ = "";
            this.port_ = 0;
            this.ipAddress_ = "";
            this.fileResumeInfo_ = "";
            this.status_ = 0;
            this.chunkSize_ = 0;
            this.chunkData_ = ByteString.EMPTY;
            this.totalSize_ = 0;
            this.count_ = 0;
            this.beginStart_ = 0;
            this.chunkStart_ = 0;
            this.order_ = 0;
            this.md5_ = "";
            this.fileName_ = "";
            this.chunkEnd_ = 0;
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
                            this.dirPath_ = codedInputStream.readStringRequireUtf8();
                            break;
                        case 26:
                            this.taskId_ = codedInputStream.readStringRequireUtf8();
                            break;
                        case 34:
                            this.fileInfos_ = codedInputStream.readStringRequireUtf8();
                            break;
                        case 42:
                            this.extra_ = codedInputStream.readStringRequireUtf8();
                            break;
                        case 50:
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            if (!(z2 & true)) {
                                this.paths_ = new LazyStringArrayList();
                                z2 = true;
                            }
                            this.paths_.add(readStringRequireUtf8);
                            break;
                        case 56:
                            this.operator_ = codedInputStream.readInt32();
                            break;
                        case 66:
                            this.packageName_ = codedInputStream.readStringRequireUtf8();
                            break;
                        case 72:
                            this.port_ = codedInputStream.readInt32();
                            break;
                        case 82:
                            this.ipAddress_ = codedInputStream.readStringRequireUtf8();
                            break;
                        case ORIENTATION_90_VALUE:
                            this.fileResumeInfo_ = codedInputStream.readStringRequireUtf8();
                            break;
                        case 96:
                            this.status_ = codedInputStream.readInt32();
                            break;
                        case 104:
                            this.chunkSize_ = codedInputStream.readInt64();
                            break;
                        case 114:
                            this.chunkData_ = codedInputStream.readBytes();
                            break;
                        case 120:
                            this.totalSize_ = codedInputStream.readInt64();
                            break;
                        case 128:
                            this.count_ = codedInputStream.readInt32();
                            break;
                        case 136:
                            this.beginStart_ = codedInputStream.readInt64();
                            break;
                        case AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW /*144*/:
                            this.chunkStart_ = codedInputStream.readInt64();
                            break;
                        case 152:
                            this.order_ = codedInputStream.readInt32();
                            break;
                        case Opcodes.IF_ICMPGE:
                            this.md5_ = codedInputStream.readStringRequireUtf8();
                            break;
                        case 170:
                            this.fileName_ = codedInputStream.readStringRequireUtf8();
                            break;
                        case 176:
                            this.chunkEnd_ = codedInputStream.readInt64();
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
                        this.paths_ = this.paths_.getUnmodifiableView();
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.paths_ = this.paths_.getUnmodifiableView();
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }
    }

    public interface MessageOrBuilder extends com.google.protobuf.MessageOrBuilder {
        long getBeginStart();

        ByteString getChunkData();

        long getChunkEnd();

        long getChunkSize();

        long getChunkStart();

        int getCount();

        String getDirPath();

        ByteString getDirPathBytes();

        String getExtra();

        ByteString getExtraBytes();

        String getFileInfos();

        ByteString getFileInfosBytes();

        String getFileName();

        ByteString getFileNameBytes();

        String getFileResumeInfo();

        ByteString getFileResumeInfoBytes();

        String getIpAddress();

        ByteString getIpAddressBytes();

        String getMd5();

        ByteString getMd5Bytes();

        int getOperator();

        int getOrder();

        String getPackageName();

        ByteString getPackageNameBytes();

        String getPaths(int i);

        ByteString getPathsBytes(int i);

        int getPathsCount();

        List<String> getPathsList();

        int getPort();

        int getStatus();

        String getTaskId();

        ByteString getTaskIdBytes();

        long getTotalSize();

        StreamType getType();

        int getTypeValue();
    }

    public enum StreamType implements ProtocolMessageEnum {
        DEFAULT(0),
        PULL(1),
        SIGNAL(2),
        CANCEL(3),
        SENDER_SYN(4),
        RECEIVER_ACK(5),
        SENDER_DATA(6),
        SENDER_FINISH(7),
        RECEIVER_FINISH(8),
        SENDER_FAIL(9),
        SENDER_CANCEL(10),
        RECEIVER_CANCEL(11),
        RECEIVER_FAIL(12),
        RECEIVE_OTA_FINISH(13),
        RECEIVER_DATA_ACK(14),
        UNRECOGNIZED(-1);
        
        public static final int CANCEL_VALUE = 3;
        public static final int DEFAULT_VALUE = 0;
        public static final int PULL_VALUE = 1;
        public static final int RECEIVER_ACK_VALUE = 5;
        public static final int RECEIVER_CANCEL_VALUE = 11;
        public static final int RECEIVER_DATA_ACK_VALUE = 14;
        public static final int RECEIVER_FAIL_VALUE = 12;
        public static final int RECEIVER_FINISH_VALUE = 8;
        public static final int RECEIVE_OTA_FINISH_VALUE = 13;
        public static final int SENDER_CANCEL_VALUE = 10;
        public static final int SENDER_DATA_VALUE = 6;
        public static final int SENDER_FAIL_VALUE = 9;
        public static final int SENDER_FINISH_VALUE = 7;
        public static final int SENDER_SYN_VALUE = 4;
        public static final int SIGNAL_VALUE = 2;
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
                    return DEFAULT;
                case 1:
                    return PULL;
                case 2:
                    return SIGNAL;
                case 3:
                    return CANCEL;
                case 4:
                    return SENDER_SYN;
                case 5:
                    return RECEIVER_ACK;
                case 6:
                    return SENDER_DATA;
                case 7:
                    return SENDER_FINISH;
                case 8:
                    return RECEIVER_FINISH;
                case 9:
                    return SENDER_FAIL;
                case 10:
                    return SENDER_CANCEL;
                case 11:
                    return RECEIVER_CANCEL;
                case 12:
                    return RECEIVER_FAIL;
                case 13:
                    return RECEIVE_OTA_FINISH;
                case 14:
                    return RECEIVER_DATA_ACK;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ShareApi.getDescriptor().getEnumTypes().get(0);
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
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fshare_api.proto\"\u0003\n\u0007Message\u0012\u0019\n\u0004type\u0018\u0001 \u0001(\u000e2\u000b.StreamType\u0012\u000f\n\u0007dirPath\u0018\u0002 \u0001(\t\u0012\u000e\n\u0006taskId\u0018\u0003 \u0001(\t\u0012\u0011\n\tfileInfos\u0018\u0004 \u0001(\t\u0012\r\n\u0005extra\u0018\u0005 \u0001(\t\u0012\r\n\u0005paths\u0018\u0006 \u0003(\t\u0012\u0010\n\boperator\u0018\u0007 \u0001(\u0005\u0012\u0013\n\u000bpackageName\u0018\b \u0001(\t\u0012\f\n\u0004port\u0018\t \u0001(\u0005\u0012\u0011\n\tipAddress\u0018\n \u0001(\t\u0012\u0016\n\u000efileResumeInfo\u0018\u000b \u0001(\t\u0012\u000e\n\u0006status\u0018\f \u0001(\u0005\u0012\u0011\n\tchunkSize\u0018\r \u0001(\u0003\u0012\u0011\n\tchunkData\u0018\u000e \u0001(\f\u0012\u0011\n\ttotalSize\u0018\u000f \u0001(\u0003\u0012\r\n\u0005count\u0018\u0010 \u0001(\u0005\u0012\u0012\n\nbeginStart\u0018\u0011 \u0001(\u0003\u0012\u0012\n\nchunkStart\u0018\u0012 \u0001(\u0003\u0012\r\n\u0005order\u0018\u0013 \u0001(\u0005\u0012\u000b\n\u0003md5\u0018\u0014 \u0001(\t\u0012\u0010\n\bfileName\u0018\u0015 \u0001(\t\u0012\u0010\n\bchunkEnd\u0018\u0016 \u0001(\u0003*\u0002\n\nStreamType\u0012\u000b\n\u0007DEFAULT\u0010\u0000\u0012\b\n\u0004PULL\u0010\u0001\u0012\n\n\u0006SIGNAL\u0010\u0002\u0012\n\n\u0006CANCEL\u0010\u0003\u0012\u000e\n\nSENDER_SYN\u0010\u0004\u0012\u0010\n\fRECEIVER_ACK\u0010\u0005\u0012\u000f\n\u000bSENDER_DATA\u0010\u0006\u0012\u0011\n\rSENDER_FINISH\u0010\u0007\u0012\u0013\n\u000fRECEIVER_FINISH\u0010\b\u0012\u000f\n\u000bSENDER_FAIL\u0010\t\u0012\u0011\n\rSENDER_CANCEL\u0010\n\u0012\u0013\n\u000fRECEIVER_CANCEL\u0010\u000b\u0012\u0011\n\rRECEIVER_FAIL\u0010\f\u0012\u0016\n\u0012RECEIVE_OTA_FINISH\u0010\r\u0012\u0015\n\u0011RECEIVER_DATA_ACK\u0010\u000eB!\n\u001fcom.upuphone.runasone.share.libb\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = ShareApi.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_Message_descriptor = descriptor2;
        internal_static_Message_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Type", "DirPath", "TaskId", "FileInfos", "Extra", "Paths", "Operator", "PackageName", "Port", "IpAddress", "FileResumeInfo", "Status", "ChunkSize", "ChunkData", "TotalSize", "Count", "BeginStart", "ChunkStart", "Order", "Md5", "FileName", "ChunkEnd"});
    }

    private ShareApi() {
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
