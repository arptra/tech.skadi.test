package kotlinx.serialization.json.internal;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonClassDiscriminator;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0006\u001a\u00020\u00052\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0015\u001a\u00020\u0003*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/serialization/SerializationStrategy;", "serializer", "actualSerializer", "", "classDiscriminator", "", "e", "(Lkotlinx/serialization/SerializationStrategy;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/String;)V", "Lkotlinx/serialization/descriptors/SerialKind;", "kind", "b", "(Lkotlinx/serialization/descriptors/SerialKind;)V", "T", "Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "d", "(Lkotlinx/serialization/json/JsonDecoder;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/json/Json;", "json", "c", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;)Ljava/lang/String;", "kotlinx-serialization-json"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPolymorphic.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Polymorphic.kt\nkotlinx/serialization/json/internal/PolymorphicKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 TreeJsonEncoder.kt\nkotlinx/serialization/json/internal/TreeJsonEncoderKt\n*L\n1#1,103:1\n1#2:104\n252#3,7:105\n*S KotlinDebug\n*F\n+ 1 Polymorphic.kt\nkotlinx/serialization/json/internal/PolymorphicKt\n*L\n81#1:105,7\n*E\n"})
public final class PolymorphicKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 176)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlinx.serialization.json.ClassDiscriminatorMode[] r0 = kotlinx.serialization.json.ClassDiscriminatorMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.serialization.json.ClassDiscriminatorMode r1 = kotlinx.serialization.json.ClassDiscriminatorMode.NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.serialization.json.ClassDiscriminatorMode r1 = kotlinx.serialization.json.ClassDiscriminatorMode.POLYMORPHIC     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.serialization.json.ClassDiscriminatorMode r1 = kotlinx.serialization.json.ClassDiscriminatorMode.ALL_JSON_OBJECTS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.PolymorphicKt.WhenMappings.<clinit>():void");
        }
    }

    public static final void b(SerialKind serialKind) {
        Intrinsics.checkNotNullParameter(serialKind, "kind");
        if (serialKind instanceof SerialKind.ENUM) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        } else if (serialKind instanceof PrimitiveKind) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        } else if (serialKind instanceof PolymorphicKind) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
        }
    }

    public static final String c(SerialDescriptor serialDescriptor, Json json) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        for (Annotation annotation : serialDescriptor.getAnnotations()) {
            if (annotation instanceof JsonClassDiscriminator) {
                return ((JsonClassDiscriminator) annotation).discriminator();
            }
        }
        return json.b().d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0041, code lost:
        r2 = kotlinx.serialization.json.JsonElementKt.j(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(kotlinx.serialization.json.JsonDecoder r5, kotlinx.serialization.DeserializationStrategy r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "deserializer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r6 instanceof kotlinx.serialization.internal.AbstractPolymorphicSerializer
            if (r0 == 0) goto L_0x00aa
            kotlinx.serialization.json.Json r0 = r5.d()
            kotlinx.serialization.json.JsonConfiguration r0 = r0.b()
            boolean r0 = r0.n()
            if (r0 == 0) goto L_0x001e
            goto L_0x00aa
        L_0x001e:
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r6.getDescriptor()
            kotlinx.serialization.json.Json r1 = r5.d()
            java.lang.String r0 = c(r0, r1)
            kotlinx.serialization.json.JsonElement r1 = r5.t()
            kotlinx.serialization.descriptors.SerialDescriptor r2 = r6.getDescriptor()
            boolean r3 = r1 instanceof kotlinx.serialization.json.JsonObject
            r4 = -1
            if (r3 == 0) goto L_0x0072
            kotlinx.serialization.json.JsonObject r1 = (kotlinx.serialization.json.JsonObject) r1
            java.lang.Object r2 = r1.get(r0)
            kotlinx.serialization.json.JsonElement r2 = (kotlinx.serialization.json.JsonElement) r2
            if (r2 == 0) goto L_0x004c
            kotlinx.serialization.json.JsonPrimitive r2 = kotlinx.serialization.json.JsonElementKt.j(r2)
            if (r2 == 0) goto L_0x004c
            java.lang.String r2 = kotlinx.serialization.json.JsonElementKt.f(r2)
            goto L_0x004d
        L_0x004c:
            r2 = 0
        L_0x004d:
            kotlinx.serialization.internal.AbstractPolymorphicSerializer r6 = (kotlinx.serialization.internal.AbstractPolymorphicSerializer) r6     // Catch:{ SerializationException -> 0x0061 }
            kotlinx.serialization.DeserializationStrategy r6 = kotlinx.serialization.PolymorphicSerializerKt.a(r6, r5, r2)     // Catch:{ SerializationException -> 0x0061 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r2)
            kotlinx.serialization.json.Json r5 = r5.d()
            java.lang.Object r5 = kotlinx.serialization.json.internal.TreeJsonDecoderKt.b(r5, r0, r1, r6)
            return r5
        L_0x0061:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            java.lang.String r6 = r1.toString()
            kotlinx.serialization.json.internal.JsonDecodingException r5 = kotlinx.serialization.json.internal.JsonExceptionsKt.f(r4, r5, r6)
            throw r5
        L_0x0072:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Expected "
            r5.append(r6)
            java.lang.Class<kotlinx.serialization.json.JsonObject> r6 = kotlinx.serialization.json.JsonObject.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            r5.append(r6)
            java.lang.String r6 = " as the serialized body of "
            r5.append(r6)
            java.lang.String r6 = r2.h()
            r5.append(r6)
            java.lang.String r6 = ", but had "
            r5.append(r6)
            java.lang.Class r6 = r1.getClass()
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            kotlinx.serialization.json.internal.JsonDecodingException r5 = kotlinx.serialization.json.internal.JsonExceptionsKt.e(r4, r5)
            throw r5
        L_0x00aa:
            java.lang.Object r5 = r6.c(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.PolymorphicKt.d(kotlinx.serialization.json.JsonDecoder, kotlinx.serialization.DeserializationStrategy):java.lang.Object");
    }

    public static final void e(SerializationStrategy serializationStrategy, SerializationStrategy serializationStrategy2, String str) {
        if ((serializationStrategy instanceof SealedClassSerializer) && JsonInternalDependenciesKt.a(serializationStrategy2.getDescriptor()).contains(str)) {
            String h = serializationStrategy.getDescriptor().h();
            String h2 = serializationStrategy2.getDescriptor().h();
            throw new IllegalStateException(("Sealed class '" + h2 + "' cannot be serialized as base class '" + h + "' because it has property name that conflicts with JSON class discriminator '" + str + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
        }
    }
}
