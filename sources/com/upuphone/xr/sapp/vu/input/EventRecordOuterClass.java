package com.upuphone.xr.sapp.vu.input;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.upuphone.xr.sapp.vu.input.InputEventOuterClass;
import com.upuphone.xr.sapp.vu.input.RuntimeStatusOuterClass;
import com.upuphone.xr.sapp.vu.input.VersionOuterClass;
import com.upuphone.xr.sapp.vu.input.VibrationOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class EventRecordOuterClass {

    /* renamed from: a  reason: collision with root package name */
    public static final Descriptors.Descriptor f8072a;
    public static final GeneratedMessageV3.FieldAccessorTable b;
    public static Descriptors.FileDescriptor c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011EventRecord.proto\u0012\u001dcom.upuphone.xr.sapp.vu.input\u001a\rVersion.proto\u001a\u0010InputEvent.proto\u001a\u000fVibration.proto\u001a\u0013RuntimeStatus.proto\"«\u0003\n\u000bEventRecord\u00129\n\u0007version\u0018\u0001 \u0001(\u000b2&.com.upuphone.xr.sapp.vu.input.VersionH\u0000\u0012C\n\u000eleftInputEvent\u0018\u0002 \u0001(\u000b2).com.upuphone.xr.sapp.vu.input.InputEventH\u0000\u0012D\n\u000frightInputEvent\u0018\u0003 \u0001(\u000b2).com.upuphone.xr.sapp.vu.input.InputEventH\u0000\u0012A\n\rleftVibration\u0018\u0004 \u0001(\u000b2(.com.upuphone.xr.sapp.vu.input.VibrationH\u0000\u0012B\n\u000erightVibration\u0018\u0005 \u0001(\u000b2(.com.upuphone.xr.sapp.vu.input.VibrationH\u0000\u0012E\n\rruntimeStatus\u0018\u0006 \u0001(\u000b2,.com.upuphone.xr.sapp.vu.input.RuntimeStatusH\u0000B\b\n\u0006recordb\u0006proto3"}, new Descriptors.FileDescriptor[]{VersionOuterClass.c(), InputEventOuterClass.c(), VibrationOuterClass.c(), RuntimeStatusOuterClass.c()});

    /* renamed from: com.upuphone.xr.sapp.vu.input.EventRecordOuterClass$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8073a;

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
                com.upuphone.xr.sapp.vu.input.EventRecordOuterClass$EventRecord$RecordCase[] r0 = com.upuphone.xr.sapp.vu.input.EventRecordOuterClass.EventRecord.RecordCase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8073a = r0
                com.upuphone.xr.sapp.vu.input.EventRecordOuterClass$EventRecord$RecordCase r1 = com.upuphone.xr.sapp.vu.input.EventRecordOuterClass.EventRecord.RecordCase.VERSION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8073a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.upuphone.xr.sapp.vu.input.EventRecordOuterClass$EventRecord$RecordCase r1 = com.upuphone.xr.sapp.vu.input.EventRecordOuterClass.EventRecord.RecordCase.LEFTINPUTEVENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8073a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.upuphone.xr.sapp.vu.input.EventRecordOuterClass$EventRecord$RecordCase r1 = com.upuphone.xr.sapp.vu.input.EventRecordOuterClass.EventRecord.RecordCase.RIGHTINPUTEVENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8073a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.upuphone.xr.sapp.vu.input.EventRecordOuterClass$EventRecord$RecordCase r1 = com.upuphone.xr.sapp.vu.input.EventRecordOuterClass.EventRecord.RecordCase.LEFTVIBRATION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8073a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.upuphone.xr.sapp.vu.input.EventRecordOuterClass$EventRecord$RecordCase r1 = com.upuphone.xr.sapp.vu.input.EventRecordOuterClass.EventRecord.RecordCase.RIGHTVIBRATION     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8073a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.upuphone.xr.sapp.vu.input.EventRecordOuterClass$EventRecord$RecordCase r1 = com.upuphone.xr.sapp.vu.input.EventRecordOuterClass.EventRecord.RecordCase.RUNTIMESTATUS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8073a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.upuphone.xr.sapp.vu.input.EventRecordOuterClass$EventRecord$RecordCase r1 = com.upuphone.xr.sapp.vu.input.EventRecordOuterClass.EventRecord.RecordCase.RECORD_NOT_SET     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.input.EventRecordOuterClass.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class EventRecord extends GeneratedMessageV3 implements EventRecordOrBuilder {
        private static final EventRecord DEFAULT_INSTANCE = new EventRecord();
        public static final int LEFTINPUTEVENT_FIELD_NUMBER = 2;
        public static final int LEFTVIBRATION_FIELD_NUMBER = 4;
        private static final Parser<EventRecord> PARSER = new AbstractParser<EventRecord>() {
            /* renamed from: a */
            public EventRecord parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Builder newBuilder = EventRecord.newBuilder();
                try {
                    newBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                    return newBuilder.buildPartial();
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(newBuilder.buildPartial());
                } catch (UninitializedMessageException e2) {
                    throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(newBuilder.buildPartial());
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(newBuilder.buildPartial());
                }
            }
        };
        public static final int RIGHTINPUTEVENT_FIELD_NUMBER = 3;
        public static final int RIGHTVIBRATION_FIELD_NUMBER = 5;
        public static final int RUNTIMESTATUS_FIELD_NUMBER = 6;
        public static final int VERSION_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public int recordCase_;
        /* access modifiers changed from: private */
        public Object record_;

        public enum RecordCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            VERSION(1),
            LEFTINPUTEVENT(2),
            RIGHTINPUTEVENT(3),
            LEFTVIBRATION(4),
            RIGHTVIBRATION(5),
            RUNTIMESTATUS(6),
            RECORD_NOT_SET(0);
            
            private final int value;

            private RecordCase(int i) {
                this.value = i;
            }

            public static RecordCase forNumber(int i) {
                switch (i) {
                    case 0:
                        return RECORD_NOT_SET;
                    case 1:
                        return VERSION;
                    case 2:
                        return LEFTINPUTEVENT;
                    case 3:
                        return RIGHTINPUTEVENT;
                    case 4:
                        return LEFTVIBRATION;
                    case 5:
                        return RIGHTVIBRATION;
                    case 6:
                        return RUNTIMESTATUS;
                    default:
                        return null;
                }
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static RecordCase valueOf(int i) {
                return forNumber(i);
            }
        }

        public static EventRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EventRecordOuterClass.f8072a;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static EventRecord parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EventRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static EventRecord parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<EventRecord> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EventRecord)) {
                return super.equals(obj);
            }
            EventRecord eventRecord = (EventRecord) obj;
            if (!getRecordCase().equals(eventRecord.getRecordCase())) {
                return false;
            }
            switch (this.recordCase_) {
                case 1:
                    if (!getVersion().equals(eventRecord.getVersion())) {
                        return false;
                    }
                    break;
                case 2:
                    if (!getLeftInputEvent().equals(eventRecord.getLeftInputEvent())) {
                        return false;
                    }
                    break;
                case 3:
                    if (!getRightInputEvent().equals(eventRecord.getRightInputEvent())) {
                        return false;
                    }
                    break;
                case 4:
                    if (!getLeftVibration().equals(eventRecord.getLeftVibration())) {
                        return false;
                    }
                    break;
                case 5:
                    if (!getRightVibration().equals(eventRecord.getRightVibration())) {
                        return false;
                    }
                    break;
                case 6:
                    if (!getRuntimeStatus().equals(eventRecord.getRuntimeStatus())) {
                        return false;
                    }
                    break;
            }
            return getUnknownFields().equals(eventRecord.getUnknownFields());
        }

        public InputEventOuterClass.InputEvent getLeftInputEvent() {
            return this.recordCase_ == 2 ? (InputEventOuterClass.InputEvent) this.record_ : InputEventOuterClass.InputEvent.getDefaultInstance();
        }

        public InputEventOuterClass.InputEventOrBuilder getLeftInputEventOrBuilder() {
            return this.recordCase_ == 2 ? (InputEventOuterClass.InputEvent) this.record_ : InputEventOuterClass.InputEvent.getDefaultInstance();
        }

        public VibrationOuterClass.Vibration getLeftVibration() {
            return this.recordCase_ == 4 ? (VibrationOuterClass.Vibration) this.record_ : VibrationOuterClass.Vibration.getDefaultInstance();
        }

        public VibrationOuterClass.VibrationOrBuilder getLeftVibrationOrBuilder() {
            return this.recordCase_ == 4 ? (VibrationOuterClass.Vibration) this.record_ : VibrationOuterClass.Vibration.getDefaultInstance();
        }

        public Parser<EventRecord> getParserForType() {
            return PARSER;
        }

        public RecordCase getRecordCase() {
            return RecordCase.forNumber(this.recordCase_);
        }

        public InputEventOuterClass.InputEvent getRightInputEvent() {
            return this.recordCase_ == 3 ? (InputEventOuterClass.InputEvent) this.record_ : InputEventOuterClass.InputEvent.getDefaultInstance();
        }

        public InputEventOuterClass.InputEventOrBuilder getRightInputEventOrBuilder() {
            return this.recordCase_ == 3 ? (InputEventOuterClass.InputEvent) this.record_ : InputEventOuterClass.InputEvent.getDefaultInstance();
        }

        public VibrationOuterClass.Vibration getRightVibration() {
            return this.recordCase_ == 5 ? (VibrationOuterClass.Vibration) this.record_ : VibrationOuterClass.Vibration.getDefaultInstance();
        }

        public VibrationOuterClass.VibrationOrBuilder getRightVibrationOrBuilder() {
            return this.recordCase_ == 5 ? (VibrationOuterClass.Vibration) this.record_ : VibrationOuterClass.Vibration.getDefaultInstance();
        }

        public RuntimeStatusOuterClass.RuntimeStatus getRuntimeStatus() {
            return this.recordCase_ == 6 ? (RuntimeStatusOuterClass.RuntimeStatus) this.record_ : RuntimeStatusOuterClass.RuntimeStatus.getDefaultInstance();
        }

        public RuntimeStatusOuterClass.RuntimeStatusOrBuilder getRuntimeStatusOrBuilder() {
            return this.recordCase_ == 6 ? (RuntimeStatusOuterClass.RuntimeStatus) this.record_ : RuntimeStatusOuterClass.RuntimeStatus.getDefaultInstance();
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.recordCase_ == 1 ? CodedOutputStream.computeMessageSize(1, (VersionOuterClass.Version) this.record_) : 0;
            if (this.recordCase_ == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, (InputEventOuterClass.InputEvent) this.record_);
            }
            if (this.recordCase_ == 3) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, (InputEventOuterClass.InputEvent) this.record_);
            }
            if (this.recordCase_ == 4) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, (VibrationOuterClass.Vibration) this.record_);
            }
            if (this.recordCase_ == 5) {
                computeMessageSize += CodedOutputStream.computeMessageSize(5, (VibrationOuterClass.Vibration) this.record_);
            }
            if (this.recordCase_ == 6) {
                computeMessageSize += CodedOutputStream.computeMessageSize(6, (RuntimeStatusOuterClass.RuntimeStatus) this.record_);
            }
            int serializedSize = computeMessageSize + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public VersionOuterClass.Version getVersion() {
            return this.recordCase_ == 1 ? (VersionOuterClass.Version) this.record_ : VersionOuterClass.Version.getDefaultInstance();
        }

        public VersionOuterClass.VersionOrBuilder getVersionOrBuilder() {
            return this.recordCase_ == 1 ? (VersionOuterClass.Version) this.record_ : VersionOuterClass.Version.getDefaultInstance();
        }

        public boolean hasLeftInputEvent() {
            return this.recordCase_ == 2;
        }

        public boolean hasLeftVibration() {
            return this.recordCase_ == 4;
        }

        public boolean hasRightInputEvent() {
            return this.recordCase_ == 3;
        }

        public boolean hasRightVibration() {
            return this.recordCase_ == 5;
        }

        public boolean hasRuntimeStatus() {
            return this.recordCase_ == 6;
        }

        public boolean hasVersion() {
            return this.recordCase_ == 1;
        }

        public int hashCode() {
            int i;
            int hashCode;
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode2 = 779 + getDescriptor().hashCode();
            switch (this.recordCase_) {
                case 1:
                    i = ((hashCode2 * 37) + 1) * 53;
                    hashCode = getVersion().hashCode();
                    break;
                case 2:
                    i = ((hashCode2 * 37) + 2) * 53;
                    hashCode = getLeftInputEvent().hashCode();
                    break;
                case 3:
                    i = ((hashCode2 * 37) + 3) * 53;
                    hashCode = getRightInputEvent().hashCode();
                    break;
                case 4:
                    i = ((hashCode2 * 37) + 4) * 53;
                    hashCode = getLeftVibration().hashCode();
                    break;
                case 5:
                    i = ((hashCode2 * 37) + 5) * 53;
                    hashCode = getRightVibration().hashCode();
                    break;
                case 6:
                    i = ((hashCode2 * 37) + 6) * 53;
                    hashCode = getRuntimeStatus().hashCode();
                    break;
                default:
                    int hashCode3 = (hashCode2 * 29) + getUnknownFields().hashCode();
                    this.memoizedHashCode = hashCode3;
                    return hashCode3;
            }
            hashCode2 = i + hashCode;
            int hashCode32 = (hashCode2 * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode32;
            return hashCode32;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EventRecordOuterClass.b.ensureFieldAccessorsInitialized(EventRecord.class, Builder.class);
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

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new EventRecord();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.recordCase_ == 1) {
                codedOutputStream.writeMessage(1, (VersionOuterClass.Version) this.record_);
            }
            if (this.recordCase_ == 2) {
                codedOutputStream.writeMessage(2, (InputEventOuterClass.InputEvent) this.record_);
            }
            if (this.recordCase_ == 3) {
                codedOutputStream.writeMessage(3, (InputEventOuterClass.InputEvent) this.record_);
            }
            if (this.recordCase_ == 4) {
                codedOutputStream.writeMessage(4, (VibrationOuterClass.Vibration) this.record_);
            }
            if (this.recordCase_ == 5) {
                codedOutputStream.writeMessage(5, (VibrationOuterClass.Vibration) this.record_);
            }
            if (this.recordCase_ == 6) {
                codedOutputStream.writeMessage(6, (RuntimeStatusOuterClass.RuntimeStatus) this.record_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EventRecordOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> leftInputEventBuilder_;
            private SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> leftVibrationBuilder_;
            private int recordCase_;
            private Object record_;
            private SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> rightInputEventBuilder_;
            private SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> rightVibrationBuilder_;
            private SingleFieldBuilderV3<RuntimeStatusOuterClass.RuntimeStatus, RuntimeStatusOuterClass.RuntimeStatus.Builder, RuntimeStatusOuterClass.RuntimeStatusOrBuilder> runtimeStatusBuilder_;
            private SingleFieldBuilderV3<VersionOuterClass.Version, VersionOuterClass.Version.Builder, VersionOuterClass.VersionOrBuilder> versionBuilder_;

            private void buildPartial0(EventRecord eventRecord) {
            }

            private void buildPartialOneofs(EventRecord eventRecord) {
                SingleFieldBuilderV3<RuntimeStatusOuterClass.RuntimeStatus, RuntimeStatusOuterClass.RuntimeStatus.Builder, RuntimeStatusOuterClass.RuntimeStatusOrBuilder> singleFieldBuilderV3;
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV32;
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV33;
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV34;
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV35;
                SingleFieldBuilderV3<VersionOuterClass.Version, VersionOuterClass.Version.Builder, VersionOuterClass.VersionOrBuilder> singleFieldBuilderV36;
                eventRecord.recordCase_ = this.recordCase_;
                eventRecord.record_ = this.record_;
                if (this.recordCase_ == 1 && (singleFieldBuilderV36 = this.versionBuilder_) != null) {
                    eventRecord.record_ = singleFieldBuilderV36.build();
                }
                if (this.recordCase_ == 2 && (singleFieldBuilderV35 = this.leftInputEventBuilder_) != null) {
                    eventRecord.record_ = singleFieldBuilderV35.build();
                }
                if (this.recordCase_ == 3 && (singleFieldBuilderV34 = this.rightInputEventBuilder_) != null) {
                    eventRecord.record_ = singleFieldBuilderV34.build();
                }
                if (this.recordCase_ == 4 && (singleFieldBuilderV33 = this.leftVibrationBuilder_) != null) {
                    eventRecord.record_ = singleFieldBuilderV33.build();
                }
                if (this.recordCase_ == 5 && (singleFieldBuilderV32 = this.rightVibrationBuilder_) != null) {
                    eventRecord.record_ = singleFieldBuilderV32.build();
                }
                if (this.recordCase_ == 6 && (singleFieldBuilderV3 = this.runtimeStatusBuilder_) != null) {
                    eventRecord.record_ = singleFieldBuilderV3.build();
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return EventRecordOuterClass.f8072a;
            }

            private SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> getLeftInputEventFieldBuilder() {
                if (this.leftInputEventBuilder_ == null) {
                    if (this.recordCase_ != 2) {
                        this.record_ = InputEventOuterClass.InputEvent.getDefaultInstance();
                    }
                    this.leftInputEventBuilder_ = new SingleFieldBuilderV3<>((InputEventOuterClass.InputEvent) this.record_, getParentForChildren(), isClean());
                    this.record_ = null;
                }
                this.recordCase_ = 2;
                onChanged();
                return this.leftInputEventBuilder_;
            }

            private SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> getLeftVibrationFieldBuilder() {
                if (this.leftVibrationBuilder_ == null) {
                    if (this.recordCase_ != 4) {
                        this.record_ = VibrationOuterClass.Vibration.getDefaultInstance();
                    }
                    this.leftVibrationBuilder_ = new SingleFieldBuilderV3<>((VibrationOuterClass.Vibration) this.record_, getParentForChildren(), isClean());
                    this.record_ = null;
                }
                this.recordCase_ = 4;
                onChanged();
                return this.leftVibrationBuilder_;
            }

            private SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> getRightInputEventFieldBuilder() {
                if (this.rightInputEventBuilder_ == null) {
                    if (this.recordCase_ != 3) {
                        this.record_ = InputEventOuterClass.InputEvent.getDefaultInstance();
                    }
                    this.rightInputEventBuilder_ = new SingleFieldBuilderV3<>((InputEventOuterClass.InputEvent) this.record_, getParentForChildren(), isClean());
                    this.record_ = null;
                }
                this.recordCase_ = 3;
                onChanged();
                return this.rightInputEventBuilder_;
            }

            private SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> getRightVibrationFieldBuilder() {
                if (this.rightVibrationBuilder_ == null) {
                    if (this.recordCase_ != 5) {
                        this.record_ = VibrationOuterClass.Vibration.getDefaultInstance();
                    }
                    this.rightVibrationBuilder_ = new SingleFieldBuilderV3<>((VibrationOuterClass.Vibration) this.record_, getParentForChildren(), isClean());
                    this.record_ = null;
                }
                this.recordCase_ = 5;
                onChanged();
                return this.rightVibrationBuilder_;
            }

            private SingleFieldBuilderV3<RuntimeStatusOuterClass.RuntimeStatus, RuntimeStatusOuterClass.RuntimeStatus.Builder, RuntimeStatusOuterClass.RuntimeStatusOrBuilder> getRuntimeStatusFieldBuilder() {
                if (this.runtimeStatusBuilder_ == null) {
                    if (this.recordCase_ != 6) {
                        this.record_ = RuntimeStatusOuterClass.RuntimeStatus.getDefaultInstance();
                    }
                    this.runtimeStatusBuilder_ = new SingleFieldBuilderV3<>((RuntimeStatusOuterClass.RuntimeStatus) this.record_, getParentForChildren(), isClean());
                    this.record_ = null;
                }
                this.recordCase_ = 6;
                onChanged();
                return this.runtimeStatusBuilder_;
            }

            private SingleFieldBuilderV3<VersionOuterClass.Version, VersionOuterClass.Version.Builder, VersionOuterClass.VersionOrBuilder> getVersionFieldBuilder() {
                if (this.versionBuilder_ == null) {
                    if (this.recordCase_ != 1) {
                        this.record_ = VersionOuterClass.Version.getDefaultInstance();
                    }
                    this.versionBuilder_ = new SingleFieldBuilderV3<>((VersionOuterClass.Version) this.record_, getParentForChildren(), isClean());
                    this.record_ = null;
                }
                this.recordCase_ = 1;
                onChanged();
                return this.versionBuilder_;
            }

            public Builder clearLeftInputEvent() {
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV3 = this.leftInputEventBuilder_;
                if (singleFieldBuilderV3 != null) {
                    if (this.recordCase_ == 2) {
                        this.recordCase_ = 0;
                        this.record_ = null;
                    }
                    singleFieldBuilderV3.clear();
                } else if (this.recordCase_ == 2) {
                    this.recordCase_ = 0;
                    this.record_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder clearLeftVibration() {
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV3 = this.leftVibrationBuilder_;
                if (singleFieldBuilderV3 != null) {
                    if (this.recordCase_ == 4) {
                        this.recordCase_ = 0;
                        this.record_ = null;
                    }
                    singleFieldBuilderV3.clear();
                } else if (this.recordCase_ == 4) {
                    this.recordCase_ = 0;
                    this.record_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder clearRecord() {
                this.recordCase_ = 0;
                this.record_ = null;
                onChanged();
                return this;
            }

            public Builder clearRightInputEvent() {
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV3 = this.rightInputEventBuilder_;
                if (singleFieldBuilderV3 != null) {
                    if (this.recordCase_ == 3) {
                        this.recordCase_ = 0;
                        this.record_ = null;
                    }
                    singleFieldBuilderV3.clear();
                } else if (this.recordCase_ == 3) {
                    this.recordCase_ = 0;
                    this.record_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder clearRightVibration() {
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV3 = this.rightVibrationBuilder_;
                if (singleFieldBuilderV3 != null) {
                    if (this.recordCase_ == 5) {
                        this.recordCase_ = 0;
                        this.record_ = null;
                    }
                    singleFieldBuilderV3.clear();
                } else if (this.recordCase_ == 5) {
                    this.recordCase_ = 0;
                    this.record_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder clearRuntimeStatus() {
                SingleFieldBuilderV3<RuntimeStatusOuterClass.RuntimeStatus, RuntimeStatusOuterClass.RuntimeStatus.Builder, RuntimeStatusOuterClass.RuntimeStatusOrBuilder> singleFieldBuilderV3 = this.runtimeStatusBuilder_;
                if (singleFieldBuilderV3 != null) {
                    if (this.recordCase_ == 6) {
                        this.recordCase_ = 0;
                        this.record_ = null;
                    }
                    singleFieldBuilderV3.clear();
                } else if (this.recordCase_ == 6) {
                    this.recordCase_ = 0;
                    this.record_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder clearVersion() {
                SingleFieldBuilderV3<VersionOuterClass.Version, VersionOuterClass.Version.Builder, VersionOuterClass.VersionOrBuilder> singleFieldBuilderV3 = this.versionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    if (this.recordCase_ == 1) {
                        this.recordCase_ = 0;
                        this.record_ = null;
                    }
                    singleFieldBuilderV3.clear();
                } else if (this.recordCase_ == 1) {
                    this.recordCase_ = 0;
                    this.record_ = null;
                    onChanged();
                }
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return EventRecordOuterClass.f8072a;
            }

            public InputEventOuterClass.InputEvent getLeftInputEvent() {
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV3 = this.leftInputEventBuilder_;
                return singleFieldBuilderV3 == null ? this.recordCase_ == 2 ? (InputEventOuterClass.InputEvent) this.record_ : InputEventOuterClass.InputEvent.getDefaultInstance() : this.recordCase_ == 2 ? singleFieldBuilderV3.getMessage() : InputEventOuterClass.InputEvent.getDefaultInstance();
            }

            public InputEventOuterClass.InputEvent.Builder getLeftInputEventBuilder() {
                return getLeftInputEventFieldBuilder().getBuilder();
            }

            public InputEventOuterClass.InputEventOrBuilder getLeftInputEventOrBuilder() {
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV3;
                int i = this.recordCase_;
                return (i != 2 || (singleFieldBuilderV3 = this.leftInputEventBuilder_) == null) ? i == 2 ? (InputEventOuterClass.InputEvent) this.record_ : InputEventOuterClass.InputEvent.getDefaultInstance() : singleFieldBuilderV3.getMessageOrBuilder();
            }

            public VibrationOuterClass.Vibration getLeftVibration() {
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV3 = this.leftVibrationBuilder_;
                return singleFieldBuilderV3 == null ? this.recordCase_ == 4 ? (VibrationOuterClass.Vibration) this.record_ : VibrationOuterClass.Vibration.getDefaultInstance() : this.recordCase_ == 4 ? singleFieldBuilderV3.getMessage() : VibrationOuterClass.Vibration.getDefaultInstance();
            }

            public VibrationOuterClass.Vibration.Builder getLeftVibrationBuilder() {
                return getLeftVibrationFieldBuilder().getBuilder();
            }

            public VibrationOuterClass.VibrationOrBuilder getLeftVibrationOrBuilder() {
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV3;
                int i = this.recordCase_;
                return (i != 4 || (singleFieldBuilderV3 = this.leftVibrationBuilder_) == null) ? i == 4 ? (VibrationOuterClass.Vibration) this.record_ : VibrationOuterClass.Vibration.getDefaultInstance() : singleFieldBuilderV3.getMessageOrBuilder();
            }

            public RecordCase getRecordCase() {
                return RecordCase.forNumber(this.recordCase_);
            }

            public InputEventOuterClass.InputEvent getRightInputEvent() {
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV3 = this.rightInputEventBuilder_;
                return singleFieldBuilderV3 == null ? this.recordCase_ == 3 ? (InputEventOuterClass.InputEvent) this.record_ : InputEventOuterClass.InputEvent.getDefaultInstance() : this.recordCase_ == 3 ? singleFieldBuilderV3.getMessage() : InputEventOuterClass.InputEvent.getDefaultInstance();
            }

            public InputEventOuterClass.InputEvent.Builder getRightInputEventBuilder() {
                return getRightInputEventFieldBuilder().getBuilder();
            }

            public InputEventOuterClass.InputEventOrBuilder getRightInputEventOrBuilder() {
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV3;
                int i = this.recordCase_;
                return (i != 3 || (singleFieldBuilderV3 = this.rightInputEventBuilder_) == null) ? i == 3 ? (InputEventOuterClass.InputEvent) this.record_ : InputEventOuterClass.InputEvent.getDefaultInstance() : singleFieldBuilderV3.getMessageOrBuilder();
            }

            public VibrationOuterClass.Vibration getRightVibration() {
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV3 = this.rightVibrationBuilder_;
                return singleFieldBuilderV3 == null ? this.recordCase_ == 5 ? (VibrationOuterClass.Vibration) this.record_ : VibrationOuterClass.Vibration.getDefaultInstance() : this.recordCase_ == 5 ? singleFieldBuilderV3.getMessage() : VibrationOuterClass.Vibration.getDefaultInstance();
            }

            public VibrationOuterClass.Vibration.Builder getRightVibrationBuilder() {
                return getRightVibrationFieldBuilder().getBuilder();
            }

            public VibrationOuterClass.VibrationOrBuilder getRightVibrationOrBuilder() {
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV3;
                int i = this.recordCase_;
                return (i != 5 || (singleFieldBuilderV3 = this.rightVibrationBuilder_) == null) ? i == 5 ? (VibrationOuterClass.Vibration) this.record_ : VibrationOuterClass.Vibration.getDefaultInstance() : singleFieldBuilderV3.getMessageOrBuilder();
            }

            public RuntimeStatusOuterClass.RuntimeStatus getRuntimeStatus() {
                SingleFieldBuilderV3<RuntimeStatusOuterClass.RuntimeStatus, RuntimeStatusOuterClass.RuntimeStatus.Builder, RuntimeStatusOuterClass.RuntimeStatusOrBuilder> singleFieldBuilderV3 = this.runtimeStatusBuilder_;
                return singleFieldBuilderV3 == null ? this.recordCase_ == 6 ? (RuntimeStatusOuterClass.RuntimeStatus) this.record_ : RuntimeStatusOuterClass.RuntimeStatus.getDefaultInstance() : this.recordCase_ == 6 ? singleFieldBuilderV3.getMessage() : RuntimeStatusOuterClass.RuntimeStatus.getDefaultInstance();
            }

            public RuntimeStatusOuterClass.RuntimeStatus.Builder getRuntimeStatusBuilder() {
                return getRuntimeStatusFieldBuilder().getBuilder();
            }

            public RuntimeStatusOuterClass.RuntimeStatusOrBuilder getRuntimeStatusOrBuilder() {
                SingleFieldBuilderV3<RuntimeStatusOuterClass.RuntimeStatus, RuntimeStatusOuterClass.RuntimeStatus.Builder, RuntimeStatusOuterClass.RuntimeStatusOrBuilder> singleFieldBuilderV3;
                int i = this.recordCase_;
                return (i != 6 || (singleFieldBuilderV3 = this.runtimeStatusBuilder_) == null) ? i == 6 ? (RuntimeStatusOuterClass.RuntimeStatus) this.record_ : RuntimeStatusOuterClass.RuntimeStatus.getDefaultInstance() : singleFieldBuilderV3.getMessageOrBuilder();
            }

            public VersionOuterClass.Version getVersion() {
                SingleFieldBuilderV3<VersionOuterClass.Version, VersionOuterClass.Version.Builder, VersionOuterClass.VersionOrBuilder> singleFieldBuilderV3 = this.versionBuilder_;
                return singleFieldBuilderV3 == null ? this.recordCase_ == 1 ? (VersionOuterClass.Version) this.record_ : VersionOuterClass.Version.getDefaultInstance() : this.recordCase_ == 1 ? singleFieldBuilderV3.getMessage() : VersionOuterClass.Version.getDefaultInstance();
            }

            public VersionOuterClass.Version.Builder getVersionBuilder() {
                return getVersionFieldBuilder().getBuilder();
            }

            public VersionOuterClass.VersionOrBuilder getVersionOrBuilder() {
                SingleFieldBuilderV3<VersionOuterClass.Version, VersionOuterClass.Version.Builder, VersionOuterClass.VersionOrBuilder> singleFieldBuilderV3;
                int i = this.recordCase_;
                return (i != 1 || (singleFieldBuilderV3 = this.versionBuilder_) == null) ? i == 1 ? (VersionOuterClass.Version) this.record_ : VersionOuterClass.Version.getDefaultInstance() : singleFieldBuilderV3.getMessageOrBuilder();
            }

            public boolean hasLeftInputEvent() {
                return this.recordCase_ == 2;
            }

            public boolean hasLeftVibration() {
                return this.recordCase_ == 4;
            }

            public boolean hasRightInputEvent() {
                return this.recordCase_ == 3;
            }

            public boolean hasRightVibration() {
                return this.recordCase_ == 5;
            }

            public boolean hasRuntimeStatus() {
                return this.recordCase_ == 6;
            }

            public boolean hasVersion() {
                return this.recordCase_ == 1;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EventRecordOuterClass.b.ensureFieldAccessorsInitialized(EventRecord.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeLeftInputEvent(InputEventOuterClass.InputEvent inputEvent) {
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV3 = this.leftInputEventBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.recordCase_ != 2 || this.record_ == InputEventOuterClass.InputEvent.getDefaultInstance()) {
                        this.record_ = inputEvent;
                    } else {
                        this.record_ = InputEventOuterClass.InputEvent.newBuilder((InputEventOuterClass.InputEvent) this.record_).mergeFrom(inputEvent).buildPartial();
                    }
                    onChanged();
                } else if (this.recordCase_ == 2) {
                    singleFieldBuilderV3.mergeFrom(inputEvent);
                } else {
                    singleFieldBuilderV3.setMessage(inputEvent);
                }
                this.recordCase_ = 2;
                return this;
            }

            public Builder mergeLeftVibration(VibrationOuterClass.Vibration vibration) {
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV3 = this.leftVibrationBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.recordCase_ != 4 || this.record_ == VibrationOuterClass.Vibration.getDefaultInstance()) {
                        this.record_ = vibration;
                    } else {
                        this.record_ = VibrationOuterClass.Vibration.newBuilder((VibrationOuterClass.Vibration) this.record_).mergeFrom(vibration).buildPartial();
                    }
                    onChanged();
                } else if (this.recordCase_ == 4) {
                    singleFieldBuilderV3.mergeFrom(vibration);
                } else {
                    singleFieldBuilderV3.setMessage(vibration);
                }
                this.recordCase_ = 4;
                return this;
            }

            public Builder mergeRightInputEvent(InputEventOuterClass.InputEvent inputEvent) {
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV3 = this.rightInputEventBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.recordCase_ != 3 || this.record_ == InputEventOuterClass.InputEvent.getDefaultInstance()) {
                        this.record_ = inputEvent;
                    } else {
                        this.record_ = InputEventOuterClass.InputEvent.newBuilder((InputEventOuterClass.InputEvent) this.record_).mergeFrom(inputEvent).buildPartial();
                    }
                    onChanged();
                } else if (this.recordCase_ == 3) {
                    singleFieldBuilderV3.mergeFrom(inputEvent);
                } else {
                    singleFieldBuilderV3.setMessage(inputEvent);
                }
                this.recordCase_ = 3;
                return this;
            }

            public Builder mergeRightVibration(VibrationOuterClass.Vibration vibration) {
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV3 = this.rightVibrationBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.recordCase_ != 5 || this.record_ == VibrationOuterClass.Vibration.getDefaultInstance()) {
                        this.record_ = vibration;
                    } else {
                        this.record_ = VibrationOuterClass.Vibration.newBuilder((VibrationOuterClass.Vibration) this.record_).mergeFrom(vibration).buildPartial();
                    }
                    onChanged();
                } else if (this.recordCase_ == 5) {
                    singleFieldBuilderV3.mergeFrom(vibration);
                } else {
                    singleFieldBuilderV3.setMessage(vibration);
                }
                this.recordCase_ = 5;
                return this;
            }

            public Builder mergeRuntimeStatus(RuntimeStatusOuterClass.RuntimeStatus runtimeStatus) {
                SingleFieldBuilderV3<RuntimeStatusOuterClass.RuntimeStatus, RuntimeStatusOuterClass.RuntimeStatus.Builder, RuntimeStatusOuterClass.RuntimeStatusOrBuilder> singleFieldBuilderV3 = this.runtimeStatusBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.recordCase_ != 6 || this.record_ == RuntimeStatusOuterClass.RuntimeStatus.getDefaultInstance()) {
                        this.record_ = runtimeStatus;
                    } else {
                        this.record_ = RuntimeStatusOuterClass.RuntimeStatus.newBuilder((RuntimeStatusOuterClass.RuntimeStatus) this.record_).mergeFrom(runtimeStatus).buildPartial();
                    }
                    onChanged();
                } else if (this.recordCase_ == 6) {
                    singleFieldBuilderV3.mergeFrom(runtimeStatus);
                } else {
                    singleFieldBuilderV3.setMessage(runtimeStatus);
                }
                this.recordCase_ = 6;
                return this;
            }

            public Builder mergeVersion(VersionOuterClass.Version version) {
                SingleFieldBuilderV3<VersionOuterClass.Version, VersionOuterClass.Version.Builder, VersionOuterClass.VersionOrBuilder> singleFieldBuilderV3 = this.versionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.recordCase_ != 1 || this.record_ == VersionOuterClass.Version.getDefaultInstance()) {
                        this.record_ = version;
                    } else {
                        this.record_ = VersionOuterClass.Version.newBuilder((VersionOuterClass.Version) this.record_).mergeFrom(version).buildPartial();
                    }
                    onChanged();
                } else if (this.recordCase_ == 1) {
                    singleFieldBuilderV3.mergeFrom(version);
                } else {
                    singleFieldBuilderV3.setMessage(version);
                }
                this.recordCase_ = 1;
                return this;
            }

            public Builder setLeftInputEvent(InputEventOuterClass.InputEvent inputEvent) {
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV3 = this.leftInputEventBuilder_;
                if (singleFieldBuilderV3 == null) {
                    inputEvent.getClass();
                    this.record_ = inputEvent;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(inputEvent);
                }
                this.recordCase_ = 2;
                return this;
            }

            public Builder setLeftVibration(VibrationOuterClass.Vibration vibration) {
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV3 = this.leftVibrationBuilder_;
                if (singleFieldBuilderV3 == null) {
                    vibration.getClass();
                    this.record_ = vibration;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(vibration);
                }
                this.recordCase_ = 4;
                return this;
            }

            public Builder setRightInputEvent(InputEventOuterClass.InputEvent inputEvent) {
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV3 = this.rightInputEventBuilder_;
                if (singleFieldBuilderV3 == null) {
                    inputEvent.getClass();
                    this.record_ = inputEvent;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(inputEvent);
                }
                this.recordCase_ = 3;
                return this;
            }

            public Builder setRightVibration(VibrationOuterClass.Vibration vibration) {
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV3 = this.rightVibrationBuilder_;
                if (singleFieldBuilderV3 == null) {
                    vibration.getClass();
                    this.record_ = vibration;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(vibration);
                }
                this.recordCase_ = 5;
                return this;
            }

            public Builder setRuntimeStatus(RuntimeStatusOuterClass.RuntimeStatus runtimeStatus) {
                SingleFieldBuilderV3<RuntimeStatusOuterClass.RuntimeStatus, RuntimeStatusOuterClass.RuntimeStatus.Builder, RuntimeStatusOuterClass.RuntimeStatusOrBuilder> singleFieldBuilderV3 = this.runtimeStatusBuilder_;
                if (singleFieldBuilderV3 == null) {
                    runtimeStatus.getClass();
                    this.record_ = runtimeStatus;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(runtimeStatus);
                }
                this.recordCase_ = 6;
                return this;
            }

            public Builder setVersion(VersionOuterClass.Version version) {
                SingleFieldBuilderV3<VersionOuterClass.Version, VersionOuterClass.Version.Builder, VersionOuterClass.VersionOrBuilder> singleFieldBuilderV3 = this.versionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    version.getClass();
                    this.record_ = version;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(version);
                }
                this.recordCase_ = 1;
                return this;
            }

            private Builder() {
                this.recordCase_ = 0;
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public EventRecord build() {
                EventRecord buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public EventRecord buildPartial() {
                EventRecord eventRecord = new EventRecord(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(eventRecord);
                }
                buildPartialOneofs(eventRecord);
                onBuilt();
                return eventRecord;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public EventRecord getDefaultInstanceForType() {
                return EventRecord.getDefaultInstance();
            }

            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.recordCase_ = 0;
            }

            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                SingleFieldBuilderV3<VersionOuterClass.Version, VersionOuterClass.Version.Builder, VersionOuterClass.VersionOrBuilder> singleFieldBuilderV3 = this.versionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.clear();
                }
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV32 = this.leftInputEventBuilder_;
                if (singleFieldBuilderV32 != null) {
                    singleFieldBuilderV32.clear();
                }
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV33 = this.rightInputEventBuilder_;
                if (singleFieldBuilderV33 != null) {
                    singleFieldBuilderV33.clear();
                }
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV34 = this.leftVibrationBuilder_;
                if (singleFieldBuilderV34 != null) {
                    singleFieldBuilderV34.clear();
                }
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV35 = this.rightVibrationBuilder_;
                if (singleFieldBuilderV35 != null) {
                    singleFieldBuilderV35.clear();
                }
                SingleFieldBuilderV3<RuntimeStatusOuterClass.RuntimeStatus, RuntimeStatusOuterClass.RuntimeStatus.Builder, RuntimeStatusOuterClass.RuntimeStatusOrBuilder> singleFieldBuilderV36 = this.runtimeStatusBuilder_;
                if (singleFieldBuilderV36 != null) {
                    singleFieldBuilderV36.clear();
                }
                this.recordCase_ = 0;
                this.record_ = null;
                return this;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof EventRecord) {
                    return mergeFrom((EventRecord) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder setLeftInputEvent(InputEventOuterClass.InputEvent.Builder builder) {
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV3 = this.leftInputEventBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.record_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.recordCase_ = 2;
                return this;
            }

            public Builder setLeftVibration(VibrationOuterClass.Vibration.Builder builder) {
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV3 = this.leftVibrationBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.record_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.recordCase_ = 4;
                return this;
            }

            public Builder setRightInputEvent(InputEventOuterClass.InputEvent.Builder builder) {
                SingleFieldBuilderV3<InputEventOuterClass.InputEvent, InputEventOuterClass.InputEvent.Builder, InputEventOuterClass.InputEventOrBuilder> singleFieldBuilderV3 = this.rightInputEventBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.record_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.recordCase_ = 3;
                return this;
            }

            public Builder setRightVibration(VibrationOuterClass.Vibration.Builder builder) {
                SingleFieldBuilderV3<VibrationOuterClass.Vibration, VibrationOuterClass.Vibration.Builder, VibrationOuterClass.VibrationOrBuilder> singleFieldBuilderV3 = this.rightVibrationBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.record_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.recordCase_ = 5;
                return this;
            }

            public Builder setRuntimeStatus(RuntimeStatusOuterClass.RuntimeStatus.Builder builder) {
                SingleFieldBuilderV3<RuntimeStatusOuterClass.RuntimeStatus, RuntimeStatusOuterClass.RuntimeStatus.Builder, RuntimeStatusOuterClass.RuntimeStatusOrBuilder> singleFieldBuilderV3 = this.runtimeStatusBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.record_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.recordCase_ = 6;
                return this;
            }

            public Builder setVersion(VersionOuterClass.Version.Builder builder) {
                SingleFieldBuilderV3<VersionOuterClass.Version, VersionOuterClass.Version.Builder, VersionOuterClass.VersionOrBuilder> singleFieldBuilderV3 = this.versionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.record_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.recordCase_ = 1;
                return this;
            }

            public Builder mergeFrom(EventRecord eventRecord) {
                if (eventRecord == EventRecord.getDefaultInstance()) {
                    return this;
                }
                switch (AnonymousClass1.f8073a[eventRecord.getRecordCase().ordinal()]) {
                    case 1:
                        mergeVersion(eventRecord.getVersion());
                        break;
                    case 2:
                        mergeLeftInputEvent(eventRecord.getLeftInputEvent());
                        break;
                    case 3:
                        mergeRightInputEvent(eventRecord.getRightInputEvent());
                        break;
                    case 4:
                        mergeLeftVibration(eventRecord.getLeftVibration());
                        break;
                    case 5:
                        mergeRightVibration(eventRecord.getRightVibration());
                        break;
                    case 6:
                        mergeRuntimeStatus(eventRecord.getRuntimeStatus());
                        break;
                }
                mergeUnknownFields(eventRecord.getUnknownFields());
                onChanged();
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                extensionRegistryLite.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                codedInputStream.readMessage((MessageLite.Builder) getVersionFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.recordCase_ = 1;
                            } else if (readTag == 18) {
                                codedInputStream.readMessage((MessageLite.Builder) getLeftInputEventFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.recordCase_ = 2;
                            } else if (readTag == 26) {
                                codedInputStream.readMessage((MessageLite.Builder) getRightInputEventFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.recordCase_ = 3;
                            } else if (readTag == 34) {
                                codedInputStream.readMessage((MessageLite.Builder) getLeftVibrationFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.recordCase_ = 4;
                            } else if (readTag == 42) {
                                codedInputStream.readMessage((MessageLite.Builder) getRightVibrationFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.recordCase_ = 5;
                            } else if (readTag == 50) {
                                codedInputStream.readMessage((MessageLite.Builder) getRuntimeStatusFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.recordCase_ = 6;
                            } else if (super.parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private EventRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.recordCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(EventRecord eventRecord) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(eventRecord);
        }

        public static EventRecord parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static EventRecord parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static EventRecord parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public EventRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static EventRecord parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private EventRecord() {
            this.recordCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static EventRecord parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static EventRecord parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static EventRecord parseFrom(InputStream inputStream) throws IOException {
            return (EventRecord) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static EventRecord parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventRecord) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static EventRecord parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EventRecord) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static EventRecord parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventRecord) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface EventRecordOrBuilder extends MessageOrBuilder {
        InputEventOuterClass.InputEvent getLeftInputEvent();

        InputEventOuterClass.InputEventOrBuilder getLeftInputEventOrBuilder();

        VibrationOuterClass.Vibration getLeftVibration();

        VibrationOuterClass.VibrationOrBuilder getLeftVibrationOrBuilder();

        EventRecord.RecordCase getRecordCase();

        InputEventOuterClass.InputEvent getRightInputEvent();

        InputEventOuterClass.InputEventOrBuilder getRightInputEventOrBuilder();

        VibrationOuterClass.Vibration getRightVibration();

        VibrationOuterClass.VibrationOrBuilder getRightVibrationOrBuilder();

        RuntimeStatusOuterClass.RuntimeStatus getRuntimeStatus();

        RuntimeStatusOuterClass.RuntimeStatusOrBuilder getRuntimeStatusOrBuilder();

        VersionOuterClass.Version getVersion();

        VersionOuterClass.VersionOrBuilder getVersionOrBuilder();

        boolean hasLeftInputEvent();

        boolean hasLeftVibration();

        boolean hasRightInputEvent();

        boolean hasRightVibration();

        boolean hasRuntimeStatus();

        boolean hasVersion();
    }

    static {
        Descriptors.Descriptor descriptor = c().getMessageTypes().get(0);
        f8072a = descriptor;
        b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Version", "LeftInputEvent", "RightInputEvent", "LeftVibration", "RightVibration", "RuntimeStatus", "Record"});
        VersionOuterClass.c();
        InputEventOuterClass.c();
        VibrationOuterClass.c();
        RuntimeStatusOuterClass.c();
    }

    public static Descriptors.FileDescriptor c() {
        return c;
    }
}
