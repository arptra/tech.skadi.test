package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Descriptors;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.Message;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public final class MapEntry<K, V> extends AbstractMessage {
    private volatile int cachedSerializedSize;
    /* access modifiers changed from: private */
    public final K key;
    private final Metadata<K, V> metadata;
    /* access modifiers changed from: private */
    public final V value;

    public static class Builder<K, V> extends AbstractMessage.Builder<Builder<K, V>> {
        private boolean hasKey;
        private boolean hasValue;
        private K key;
        private final Metadata<K, V> metadata;
        private V value;

        private void checkFieldDescriptor(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != this.metadata.descriptor) {
                throw new RuntimeException("Wrong FieldDescriptor \"" + fieldDescriptor.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
            }
        }

        public Builder<K, V> clearKey() {
            this.key = this.metadata.defaultKey;
            this.hasKey = false;
            return this;
        }

        public Builder<K, V> clearValue() {
            this.value = this.metadata.defaultValue;
            this.hasValue = false;
            return this;
        }

        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            TreeMap treeMap = new TreeMap();
            for (Descriptors.FieldDescriptor next : this.metadata.descriptor.getFields()) {
                if (hasField(next)) {
                    treeMap.put(next, getField(next));
                }
            }
            return Collections.unmodifiableMap(treeMap);
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return this.metadata.descriptor;
        }

        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            checkFieldDescriptor(fieldDescriptor);
            Object key2 = fieldDescriptor.getNumber() == 1 ? getKey() : getValue();
            return fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.ENUM ? fieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown(((Integer) key2).intValue()) : key2;
        }

        public K getKey() {
            return this.key;
        }

        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        public UnknownFieldSet getUnknownFields() {
            return UnknownFieldSet.getDefaultInstance();
        }

        public V getValue() {
            return this.value;
        }

        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            checkFieldDescriptor(fieldDescriptor);
            return fieldDescriptor.getNumber() == 1 ? this.hasKey : this.hasValue;
        }

        public boolean isInitialized() {
            return MapEntry.isInitialized(this.metadata, this.value);
        }

        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            checkFieldDescriptor(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 2 && fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return ((Message) this.value).newBuilderForType();
            }
            throw new RuntimeException("\"" + fieldDescriptor.getFullName() + "\" is not a message value field.");
        }

        public Builder<K, V> setKey(K k) {
            this.key = k;
            this.hasKey = true;
            return this;
        }

        public Builder<K, V> setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return this;
        }

        public Builder<K, V> setValue(V v) {
            this.value = v;
            this.hasValue = true;
            return this;
        }

        public Builder<K, V> addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        public Builder<K, V> clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            checkFieldDescriptor(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 1) {
                clearKey();
            } else {
                clearValue();
            }
            return this;
        }

        public Builder<K, V> setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            checkFieldDescriptor(fieldDescriptor);
            if (obj != null) {
                if (fieldDescriptor.getNumber() == 1) {
                    setKey(obj);
                } else {
                    if (fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.ENUM) {
                        obj = Integer.valueOf(((Descriptors.EnumValueDescriptor) obj).getNumber());
                    } else if (fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !this.metadata.defaultValue.getClass().isInstance(obj)) {
                        obj = ((Message) this.metadata.defaultValue).toBuilder().mergeFrom((Message) obj).build();
                    }
                    setValue(obj);
                }
                return this;
            }
            throw new NullPointerException(fieldDescriptor.getFullName() + " is null");
        }

        public Builder<K, V> setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        private Builder(Metadata<K, V> metadata2) {
            this(metadata2, metadata2.defaultKey, metadata2.defaultValue, false, false);
        }

        public MapEntry<K, V> build() {
            MapEntry<K, V> buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
        }

        public MapEntry<K, V> buildPartial() {
            return new MapEntry<>((Metadata) this.metadata, (Object) this.key, (Object) this.value);
        }

        public MapEntry<K, V> getDefaultInstanceForType() {
            Metadata<K, V> metadata2 = this.metadata;
            return new MapEntry<>((Metadata) metadata2, (Object) metadata2.defaultKey, (Object) metadata2.defaultValue);
        }

        private Builder(Metadata<K, V> metadata2, K k, V v, boolean z, boolean z2) {
            this.metadata = metadata2;
            this.key = k;
            this.value = v;
            this.hasKey = z;
            this.hasValue = z2;
        }

        public Builder<K, V> clone() {
            return new Builder(this.metadata, this.key, this.value, this.hasKey, this.hasValue);
        }
    }

    public static final class Metadata<K, V> extends MapEntryLite.Metadata<K, V> {
        public final Descriptors.Descriptor descriptor;
        public final Parser<MapEntry<K, V>> parser = new AbstractParser<MapEntry<K, V>>() {
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

            public MapEntry<K, V> parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MapEntry<>(Metadata.this, codedInputStream, extensionRegistryLite);
            }

            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.parseFrom(bArr, extensionRegistryLite);
            }
        };

        public Metadata(Descriptors.Descriptor descriptor2, MapEntry<K, V> mapEntry, WireFormat.FieldType fieldType, WireFormat.FieldType fieldType2) {
            super(fieldType, mapEntry.key, fieldType2, mapEntry.value);
            this.descriptor = descriptor2;
        }
    }

    private void checkFieldDescriptor(Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.getContainingType() != this.metadata.descriptor) {
            throw new RuntimeException("Wrong FieldDescriptor \"" + fieldDescriptor.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
        }
    }

    public static <K, V> MapEntry<K, V> newDefaultInstance(Descriptors.Descriptor descriptor, WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        return new MapEntry(descriptor, fieldType, k, fieldType2, v);
    }

    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        TreeMap treeMap = new TreeMap();
        for (Descriptors.FieldDescriptor next : this.metadata.descriptor.getFields()) {
            if (hasField(next)) {
                treeMap.put(next, getField(next));
            }
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public Descriptors.Descriptor getDescriptorForType() {
        return this.metadata.descriptor;
    }

    public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        checkFieldDescriptor(fieldDescriptor);
        Object key2 = fieldDescriptor.getNumber() == 1 ? getKey() : getValue();
        return fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.ENUM ? fieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown(((Integer) key2).intValue()) : key2;
    }

    public K getKey() {
        return this.key;
    }

    public final Metadata<K, V> getMetadata() {
        return this.metadata;
    }

    public Parser<MapEntry<K, V>> getParserForType() {
        return this.metadata.parser;
    }

    public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    public int getSerializedSize() {
        if (this.cachedSerializedSize != -1) {
            return this.cachedSerializedSize;
        }
        int computeSerializedSize = MapEntryLite.computeSerializedSize(this.metadata, this.key, this.value);
        this.cachedSerializedSize = computeSerializedSize;
        return computeSerializedSize;
    }

    public UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    public V getValue() {
        return this.value;
    }

    public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        checkFieldDescriptor(fieldDescriptor);
        return true;
    }

    public boolean isInitialized() {
        return isInitialized(this.metadata, this.value);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        MapEntryLite.writeTo(codedOutputStream, this.metadata, this.key, this.value);
    }

    /* access modifiers changed from: private */
    public static <V> boolean isInitialized(Metadata metadata2, V v) {
        if (metadata2.valueType.getJavaType() == WireFormat.JavaType.MESSAGE) {
            return ((MessageLite) v).isInitialized();
        }
        return true;
    }

    private MapEntry(Descriptors.Descriptor descriptor, WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        this.cachedSerializedSize = -1;
        this.key = k;
        this.value = v;
        this.metadata = new Metadata<>(descriptor, this, fieldType, fieldType2);
    }

    public MapEntry<K, V> getDefaultInstanceForType() {
        Metadata<K, V> metadata2 = this.metadata;
        return new MapEntry<>((Metadata) metadata2, metadata2.defaultKey, metadata2.defaultValue);
    }

    public Builder<K, V> newBuilderForType() {
        return new Builder<>(this.metadata);
    }

    public Builder<K, V> toBuilder() {
        return new Builder(this.metadata, this.key, this.value, true, true);
    }

    private MapEntry(Metadata metadata2, K k, V v) {
        this.cachedSerializedSize = -1;
        this.key = k;
        this.value = v;
        this.metadata = metadata2;
    }

    private MapEntry(Metadata<K, V> metadata2, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.cachedSerializedSize = -1;
        try {
            this.metadata = metadata2;
            Map.Entry<K, V> parseEntry = MapEntryLite.parseEntry(codedInputStream, metadata2, extensionRegistryLite);
            this.key = parseEntry.getKey();
            this.value = parseEntry.getValue();
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(this);
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
        }
    }
}
