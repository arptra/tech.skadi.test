package com.upuphone.xr.sapp.vu.input;

import com.google.protobuf.AbstractMessage;
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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.upuphone.runasone.uupcast.CastErrorCode;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class InputEventOuterClass {

    /* renamed from: a  reason: collision with root package name */
    public static final Descriptors.Descriptor f8074a;
    public static final GeneratedMessageV3.FieldAccessorTable b;
    public static Descriptors.FileDescriptor c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010InputEvent.proto\u0012\u001dcom.upuphone.xr.sapp.vu.input\"\u0002\n\nInputEvent\u0012\u000e\n\u0006active\u0018\u0001 \u0001(\b\u0012\u0011\n\ttimestamp\u0018\u0002 \u0001(\u0003\u0012\u0015\n\rtrigger_value\u0018\u0003 \u0001(\u0002\u0012\u0016\n\u000etrackpad_force\u0018\u0004 \u0001(\u0002\u0012\u0012\n\ntrackpad_x\u0018\u0005 \u0001(\u0002\u0012\u0012\n\ntrackpad_y\u0018\u0006 \u0001(\u0002\u0012\u0012\n\nmenu_click\u0018\u0007 \u0001(\b\u0012\u0014\n\fselect_click\u0018\b \u0001(\b\u0012\u0015\n\rtrigger_click\u0018\t \u0001(\b\u0012\u0016\n\u000etrackpad_click\u0018\n \u0001(\b\u0012\u0016\n\u000etrackpad_touch\u0018\u000b \u0001(\b\u0012\u0016\n\u000eshoulder_click\u0018\f \u0001(\bb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    public static final class InputEvent extends GeneratedMessageV3 implements InputEventOrBuilder {
        public static final int ACTIVE_FIELD_NUMBER = 1;
        private static final InputEvent DEFAULT_INSTANCE = new InputEvent();
        public static final int MENU_CLICK_FIELD_NUMBER = 7;
        private static final Parser<InputEvent> PARSER = new AbstractParser<InputEvent>() {
            /* renamed from: a */
            public InputEvent parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Builder newBuilder = InputEvent.newBuilder();
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
        public static final int SELECT_CLICK_FIELD_NUMBER = 8;
        public static final int SHOULDER_CLICK_FIELD_NUMBER = 12;
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        public static final int TRACKPAD_CLICK_FIELD_NUMBER = 10;
        public static final int TRACKPAD_FORCE_FIELD_NUMBER = 4;
        public static final int TRACKPAD_TOUCH_FIELD_NUMBER = 11;
        public static final int TRACKPAD_X_FIELD_NUMBER = 5;
        public static final int TRACKPAD_Y_FIELD_NUMBER = 6;
        public static final int TRIGGER_CLICK_FIELD_NUMBER = 9;
        public static final int TRIGGER_VALUE_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public boolean active_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public boolean menuClick_;
        /* access modifiers changed from: private */
        public boolean selectClick_;
        /* access modifiers changed from: private */
        public boolean shoulderClick_;
        /* access modifiers changed from: private */
        public long timestamp_;
        /* access modifiers changed from: private */
        public boolean trackpadClick_;
        /* access modifiers changed from: private */
        public float trackpadForce_;
        /* access modifiers changed from: private */
        public boolean trackpadTouch_;
        /* access modifiers changed from: private */
        public float trackpadX_;
        /* access modifiers changed from: private */
        public float trackpadY_;
        /* access modifiers changed from: private */
        public boolean triggerClick_;
        /* access modifiers changed from: private */
        public float triggerValue_;

        public static InputEvent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InputEventOuterClass.f8074a;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static InputEvent parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (InputEvent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static InputEvent parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<InputEvent> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof InputEvent)) {
                return super.equals(obj);
            }
            InputEvent inputEvent = (InputEvent) obj;
            return getActive() == inputEvent.getActive() && getTimestamp() == inputEvent.getTimestamp() && Float.floatToIntBits(getTriggerValue()) == Float.floatToIntBits(inputEvent.getTriggerValue()) && Float.floatToIntBits(getTrackpadForce()) == Float.floatToIntBits(inputEvent.getTrackpadForce()) && Float.floatToIntBits(getTrackpadX()) == Float.floatToIntBits(inputEvent.getTrackpadX()) && Float.floatToIntBits(getTrackpadY()) == Float.floatToIntBits(inputEvent.getTrackpadY()) && getMenuClick() == inputEvent.getMenuClick() && getSelectClick() == inputEvent.getSelectClick() && getTriggerClick() == inputEvent.getTriggerClick() && getTrackpadClick() == inputEvent.getTrackpadClick() && getTrackpadTouch() == inputEvent.getTrackpadTouch() && getShoulderClick() == inputEvent.getShoulderClick() && getUnknownFields().equals(inputEvent.getUnknownFields());
        }

        public boolean getActive() {
            return this.active_;
        }

        public boolean getMenuClick() {
            return this.menuClick_;
        }

        public Parser<InputEvent> getParserForType() {
            return PARSER;
        }

        public boolean getSelectClick() {
            return this.selectClick_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            boolean z = this.active_;
            int computeBoolSize = z ? CodedOutputStream.computeBoolSize(1, z) : 0;
            long j = this.timestamp_;
            if (j != 0) {
                computeBoolSize += CodedOutputStream.computeInt64Size(2, j);
            }
            if (Float.floatToRawIntBits(this.triggerValue_) != 0) {
                computeBoolSize += CodedOutputStream.computeFloatSize(3, this.triggerValue_);
            }
            if (Float.floatToRawIntBits(this.trackpadForce_) != 0) {
                computeBoolSize += CodedOutputStream.computeFloatSize(4, this.trackpadForce_);
            }
            if (Float.floatToRawIntBits(this.trackpadX_) != 0) {
                computeBoolSize += CodedOutputStream.computeFloatSize(5, this.trackpadX_);
            }
            if (Float.floatToRawIntBits(this.trackpadY_) != 0) {
                computeBoolSize += CodedOutputStream.computeFloatSize(6, this.trackpadY_);
            }
            boolean z2 = this.menuClick_;
            if (z2) {
                computeBoolSize += CodedOutputStream.computeBoolSize(7, z2);
            }
            boolean z3 = this.selectClick_;
            if (z3) {
                computeBoolSize += CodedOutputStream.computeBoolSize(8, z3);
            }
            boolean z4 = this.triggerClick_;
            if (z4) {
                computeBoolSize += CodedOutputStream.computeBoolSize(9, z4);
            }
            boolean z5 = this.trackpadClick_;
            if (z5) {
                computeBoolSize += CodedOutputStream.computeBoolSize(10, z5);
            }
            boolean z6 = this.trackpadTouch_;
            if (z6) {
                computeBoolSize += CodedOutputStream.computeBoolSize(11, z6);
            }
            boolean z7 = this.shoulderClick_;
            if (z7) {
                computeBoolSize += CodedOutputStream.computeBoolSize(12, z7);
            }
            int serializedSize = computeBoolSize + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public boolean getShoulderClick() {
            return this.shoulderClick_;
        }

        public long getTimestamp() {
            return this.timestamp_;
        }

        public boolean getTrackpadClick() {
            return this.trackpadClick_;
        }

        public float getTrackpadForce() {
            return this.trackpadForce_;
        }

        public boolean getTrackpadTouch() {
            return this.trackpadTouch_;
        }

        public float getTrackpadX() {
            return this.trackpadX_;
        }

        public float getTrackpadY() {
            return this.trackpadY_;
        }

        public boolean getTriggerClick() {
            return this.triggerClick_;
        }

        public float getTriggerValue() {
            return this.triggerValue_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashBoolean(getActive())) * 37) + 2) * 53) + Internal.hashLong(getTimestamp())) * 37) + 3) * 53) + Float.floatToIntBits(getTriggerValue())) * 37) + 4) * 53) + Float.floatToIntBits(getTrackpadForce())) * 37) + 5) * 53) + Float.floatToIntBits(getTrackpadX())) * 37) + 6) * 53) + Float.floatToIntBits(getTrackpadY())) * 37) + 7) * 53) + Internal.hashBoolean(getMenuClick())) * 37) + 8) * 53) + Internal.hashBoolean(getSelectClick())) * 37) + 9) * 53) + Internal.hashBoolean(getTriggerClick())) * 37) + 10) * 53) + Internal.hashBoolean(getTrackpadClick())) * 37) + 11) * 53) + Internal.hashBoolean(getTrackpadTouch())) * 37) + 12) * 53) + Internal.hashBoolean(getShoulderClick())) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InputEventOuterClass.b.ensureFieldAccessorsInitialized(InputEvent.class, Builder.class);
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
            return new InputEvent();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            boolean z = this.active_;
            if (z) {
                codedOutputStream.writeBool(1, z);
            }
            long j = this.timestamp_;
            if (j != 0) {
                codedOutputStream.writeInt64(2, j);
            }
            if (Float.floatToRawIntBits(this.triggerValue_) != 0) {
                codedOutputStream.writeFloat(3, this.triggerValue_);
            }
            if (Float.floatToRawIntBits(this.trackpadForce_) != 0) {
                codedOutputStream.writeFloat(4, this.trackpadForce_);
            }
            if (Float.floatToRawIntBits(this.trackpadX_) != 0) {
                codedOutputStream.writeFloat(5, this.trackpadX_);
            }
            if (Float.floatToRawIntBits(this.trackpadY_) != 0) {
                codedOutputStream.writeFloat(6, this.trackpadY_);
            }
            boolean z2 = this.menuClick_;
            if (z2) {
                codedOutputStream.writeBool(7, z2);
            }
            boolean z3 = this.selectClick_;
            if (z3) {
                codedOutputStream.writeBool(8, z3);
            }
            boolean z4 = this.triggerClick_;
            if (z4) {
                codedOutputStream.writeBool(9, z4);
            }
            boolean z5 = this.trackpadClick_;
            if (z5) {
                codedOutputStream.writeBool(10, z5);
            }
            boolean z6 = this.trackpadTouch_;
            if (z6) {
                codedOutputStream.writeBool(11, z6);
            }
            boolean z7 = this.shoulderClick_;
            if (z7) {
                codedOutputStream.writeBool(12, z7);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InputEventOrBuilder {
            private boolean active_;
            private int bitField0_;
            private boolean menuClick_;
            private boolean selectClick_;
            private boolean shoulderClick_;
            private long timestamp_;
            private boolean trackpadClick_;
            private float trackpadForce_;
            private boolean trackpadTouch_;
            private float trackpadX_;
            private float trackpadY_;
            private boolean triggerClick_;
            private float triggerValue_;

            private void buildPartial0(InputEvent inputEvent) {
                int i = this.bitField0_;
                if ((i & 1) != 0) {
                    inputEvent.active_ = this.active_;
                }
                if ((i & 2) != 0) {
                    inputEvent.timestamp_ = this.timestamp_;
                }
                if ((i & 4) != 0) {
                    inputEvent.triggerValue_ = this.triggerValue_;
                }
                if ((i & 8) != 0) {
                    inputEvent.trackpadForce_ = this.trackpadForce_;
                }
                if ((i & 16) != 0) {
                    inputEvent.trackpadX_ = this.trackpadX_;
                }
                if ((i & 32) != 0) {
                    inputEvent.trackpadY_ = this.trackpadY_;
                }
                if ((i & 64) != 0) {
                    inputEvent.menuClick_ = this.menuClick_;
                }
                if ((i & 128) != 0) {
                    inputEvent.selectClick_ = this.selectClick_;
                }
                if ((i & 256) != 0) {
                    inputEvent.triggerClick_ = this.triggerClick_;
                }
                if ((i & 512) != 0) {
                    inputEvent.trackpadClick_ = this.trackpadClick_;
                }
                if ((i & 1024) != 0) {
                    inputEvent.trackpadTouch_ = this.trackpadTouch_;
                }
                if ((i & 2048) != 0) {
                    inputEvent.shoulderClick_ = this.shoulderClick_;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return InputEventOuterClass.f8074a;
            }

            public Builder clearActive() {
                this.bitField0_ &= -2;
                this.active_ = false;
                onChanged();
                return this;
            }

            public Builder clearMenuClick() {
                this.bitField0_ &= -65;
                this.menuClick_ = false;
                onChanged();
                return this;
            }

            public Builder clearSelectClick() {
                this.bitField0_ &= -129;
                this.selectClick_ = false;
                onChanged();
                return this;
            }

            public Builder clearShoulderClick() {
                this.bitField0_ &= -2049;
                this.shoulderClick_ = false;
                onChanged();
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0_ &= -3;
                this.timestamp_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTrackpadClick() {
                this.bitField0_ &= CastErrorCode.SINK_SURFACE_NOT_SET;
                this.trackpadClick_ = false;
                onChanged();
                return this;
            }

            public Builder clearTrackpadForce() {
                this.bitField0_ &= -9;
                this.trackpadForce_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearTrackpadTouch() {
                this.bitField0_ &= -1025;
                this.trackpadTouch_ = false;
                onChanged();
                return this;
            }

            public Builder clearTrackpadX() {
                this.bitField0_ &= -17;
                this.trackpadX_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearTrackpadY() {
                this.bitField0_ &= -33;
                this.trackpadY_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearTriggerClick() {
                this.bitField0_ &= -257;
                this.triggerClick_ = false;
                onChanged();
                return this;
            }

            public Builder clearTriggerValue() {
                this.bitField0_ &= -5;
                this.triggerValue_ = 0.0f;
                onChanged();
                return this;
            }

            public boolean getActive() {
                return this.active_;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return InputEventOuterClass.f8074a;
            }

            public boolean getMenuClick() {
                return this.menuClick_;
            }

            public boolean getSelectClick() {
                return this.selectClick_;
            }

            public boolean getShoulderClick() {
                return this.shoulderClick_;
            }

            public long getTimestamp() {
                return this.timestamp_;
            }

            public boolean getTrackpadClick() {
                return this.trackpadClick_;
            }

            public float getTrackpadForce() {
                return this.trackpadForce_;
            }

            public boolean getTrackpadTouch() {
                return this.trackpadTouch_;
            }

            public float getTrackpadX() {
                return this.trackpadX_;
            }

            public float getTrackpadY() {
                return this.trackpadY_;
            }

            public boolean getTriggerClick() {
                return this.triggerClick_;
            }

            public float getTriggerValue() {
                return this.triggerValue_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InputEventOuterClass.b.ensureFieldAccessorsInitialized(InputEvent.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setActive(boolean z) {
                this.active_ = z;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setMenuClick(boolean z) {
                this.menuClick_ = z;
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder setSelectClick(boolean z) {
                this.selectClick_ = z;
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder setShoulderClick(boolean z) {
                this.shoulderClick_ = z;
                this.bitField0_ |= 2048;
                onChanged();
                return this;
            }

            public Builder setTimestamp(long j) {
                this.timestamp_ = j;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setTrackpadClick(boolean z) {
                this.trackpadClick_ = z;
                this.bitField0_ |= 512;
                onChanged();
                return this;
            }

            public Builder setTrackpadForce(float f) {
                this.trackpadForce_ = f;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setTrackpadTouch(boolean z) {
                this.trackpadTouch_ = z;
                this.bitField0_ |= 1024;
                onChanged();
                return this;
            }

            public Builder setTrackpadX(float f) {
                this.trackpadX_ = f;
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder setTrackpadY(float f) {
                this.trackpadY_ = f;
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder setTriggerClick(boolean z) {
                this.triggerClick_ = z;
                this.bitField0_ |= 256;
                onChanged();
                return this;
            }

            public Builder setTriggerValue(float f) {
                this.triggerValue_ = f;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            private Builder() {
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public InputEvent build() {
                InputEvent buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public InputEvent buildPartial() {
                InputEvent inputEvent = new InputEvent(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(inputEvent);
                }
                onBuilt();
                return inputEvent;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public InputEvent getDefaultInstanceForType() {
                return InputEvent.getDefaultInstance();
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

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
            }

            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.active_ = false;
                this.timestamp_ = 0;
                this.triggerValue_ = 0.0f;
                this.trackpadForce_ = 0.0f;
                this.trackpadX_ = 0.0f;
                this.trackpadY_ = 0.0f;
                this.menuClick_ = false;
                this.selectClick_ = false;
                this.triggerClick_ = false;
                this.trackpadClick_ = false;
                this.trackpadTouch_ = false;
                this.shoulderClick_ = false;
                return this;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof InputEvent) {
                    return mergeFrom((InputEvent) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(InputEvent inputEvent) {
                if (inputEvent == InputEvent.getDefaultInstance()) {
                    return this;
                }
                if (inputEvent.getActive()) {
                    setActive(inputEvent.getActive());
                }
                if (inputEvent.getTimestamp() != 0) {
                    setTimestamp(inputEvent.getTimestamp());
                }
                if (inputEvent.getTriggerValue() != 0.0f) {
                    setTriggerValue(inputEvent.getTriggerValue());
                }
                if (inputEvent.getTrackpadForce() != 0.0f) {
                    setTrackpadForce(inputEvent.getTrackpadForce());
                }
                if (inputEvent.getTrackpadX() != 0.0f) {
                    setTrackpadX(inputEvent.getTrackpadX());
                }
                if (inputEvent.getTrackpadY() != 0.0f) {
                    setTrackpadY(inputEvent.getTrackpadY());
                }
                if (inputEvent.getMenuClick()) {
                    setMenuClick(inputEvent.getMenuClick());
                }
                if (inputEvent.getSelectClick()) {
                    setSelectClick(inputEvent.getSelectClick());
                }
                if (inputEvent.getTriggerClick()) {
                    setTriggerClick(inputEvent.getTriggerClick());
                }
                if (inputEvent.getTrackpadClick()) {
                    setTrackpadClick(inputEvent.getTrackpadClick());
                }
                if (inputEvent.getTrackpadTouch()) {
                    setTrackpadTouch(inputEvent.getTrackpadTouch());
                }
                if (inputEvent.getShoulderClick()) {
                    setShoulderClick(inputEvent.getShoulderClick());
                }
                mergeUnknownFields(inputEvent.getUnknownFields());
                onChanged();
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                extensionRegistryLite.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                this.active_ = codedInputStream.readBool();
                                this.bitField0_ |= 1;
                                break;
                            case 16:
                                this.timestamp_ = codedInputStream.readInt64();
                                this.bitField0_ |= 2;
                                break;
                            case 29:
                                this.triggerValue_ = codedInputStream.readFloat();
                                this.bitField0_ |= 4;
                                break;
                            case 37:
                                this.trackpadForce_ = codedInputStream.readFloat();
                                this.bitField0_ |= 8;
                                break;
                            case 45:
                                this.trackpadX_ = codedInputStream.readFloat();
                                this.bitField0_ |= 16;
                                break;
                            case 53:
                                this.trackpadY_ = codedInputStream.readFloat();
                                this.bitField0_ |= 32;
                                break;
                            case 56:
                                this.menuClick_ = codedInputStream.readBool();
                                this.bitField0_ |= 64;
                                break;
                            case 64:
                                this.selectClick_ = codedInputStream.readBool();
                                this.bitField0_ |= 128;
                                break;
                            case 72:
                                this.triggerClick_ = codedInputStream.readBool();
                                this.bitField0_ |= 256;
                                break;
                            case 80:
                                this.trackpadClick_ = codedInputStream.readBool();
                                this.bitField0_ |= 512;
                                break;
                            case 88:
                                this.trackpadTouch_ = codedInputStream.readBool();
                                this.bitField0_ |= 1024;
                                break;
                            case 96:
                                this.shoulderClick_ = codedInputStream.readBool();
                                this.bitField0_ |= 2048;
                                break;
                            default:
                                if (super.parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    break;
                                }
                                z = true;
                                break;
                        }
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

        private InputEvent(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.active_ = false;
            this.timestamp_ = 0;
            this.triggerValue_ = 0.0f;
            this.trackpadForce_ = 0.0f;
            this.trackpadX_ = 0.0f;
            this.trackpadY_ = 0.0f;
            this.menuClick_ = false;
            this.selectClick_ = false;
            this.triggerClick_ = false;
            this.trackpadClick_ = false;
            this.trackpadTouch_ = false;
            this.shoulderClick_ = false;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(InputEvent inputEvent) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(inputEvent);
        }

        public static InputEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static InputEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (InputEvent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static InputEvent parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public InputEvent getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static InputEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static InputEvent parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static InputEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static InputEvent parseFrom(InputStream inputStream) throws IOException {
            return (InputEvent) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static InputEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (InputEvent) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static InputEvent parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (InputEvent) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static InputEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (InputEvent) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        private InputEvent() {
            this.active_ = false;
            this.timestamp_ = 0;
            this.triggerValue_ = 0.0f;
            this.trackpadForce_ = 0.0f;
            this.trackpadX_ = 0.0f;
            this.trackpadY_ = 0.0f;
            this.menuClick_ = false;
            this.selectClick_ = false;
            this.triggerClick_ = false;
            this.trackpadClick_ = false;
            this.trackpadTouch_ = false;
            this.shoulderClick_ = false;
            this.memoizedIsInitialized = -1;
        }
    }

    public interface InputEventOrBuilder extends MessageOrBuilder {
        boolean getActive();

        boolean getMenuClick();

        boolean getSelectClick();

        boolean getShoulderClick();

        long getTimestamp();

        boolean getTrackpadClick();

        float getTrackpadForce();

        boolean getTrackpadTouch();

        float getTrackpadX();

        float getTrackpadY();

        boolean getTriggerClick();

        float getTriggerValue();
    }

    static {
        Descriptors.Descriptor descriptor = c().getMessageTypes().get(0);
        f8074a = descriptor;
        b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Active", RtspHeaders.Names.TIMESTAMP, "TriggerValue", "TrackpadForce", "TrackpadX", "TrackpadY", "MenuClick", "SelectClick", "TriggerClick", "TrackpadClick", "TrackpadTouch", "ShoulderClick"});
    }

    public static Descriptors.FileDescriptor c() {
        return c;
    }
}
