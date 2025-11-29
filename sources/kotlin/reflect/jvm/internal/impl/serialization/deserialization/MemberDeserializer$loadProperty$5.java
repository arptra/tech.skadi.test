package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.Nullable;

public final class MemberDeserializer$loadProperty$5 extends Lambda implements Function0<NullableLazyValue<? extends ConstantValue<?>>> {
    final /* synthetic */ DeserializedPropertyDescriptor $property;
    final /* synthetic */ ProtoBuf.Property $proto;
    final /* synthetic */ MemberDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MemberDeserializer$loadProperty$5(MemberDeserializer memberDeserializer, ProtoBuf.Property property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$proto = property;
        this.$property = deserializedPropertyDescriptor;
    }

    public final NullableLazyValue<ConstantValue<?>> invoke() {
        StorageManager storageManager = this.this$0.c.getStorageManager();
        final MemberDeserializer memberDeserializer = this.this$0;
        final ProtoBuf.Property property = this.$proto;
        final DeserializedPropertyDescriptor deserializedPropertyDescriptor = this.$property;
        return storageManager.createNullableLazyValue(new Function0<ConstantValue<?>>() {
            @Nullable
            public final ConstantValue<?> invoke() {
                MemberDeserializer memberDeserializer = memberDeserializer;
                ProtoContainer access$asProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.c.getContainingDeclaration());
                Intrinsics.checkNotNull(access$asProtoContainer);
                AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = memberDeserializer.c.getComponents().getAnnotationAndConstantLoader();
                ProtoBuf.Property property = property;
                KotlinType returnType = deserializedPropertyDescriptor.getReturnType();
                Intrinsics.checkNotNullExpressionValue(returnType, "property.returnType");
                return annotationAndConstantLoader.loadAnnotationDefaultValue(access$asProtoContainer, property, returnType);
            }
        });
    }
}
