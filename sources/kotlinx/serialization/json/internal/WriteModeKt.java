package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "desc", "Lkotlinx/serialization/json/internal/WriteMode;", "b", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/json/internal/WriteMode;", "Lkotlinx/serialization/modules/SerializersModule;", "module", "a", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/modules/SerializersModule;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-json"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nWriteMode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WriteMode.kt\nkotlinx/serialization/json/internal/WriteModeKt\n*L\n1#1,53:1\n36#1,9:54\n*S KotlinDebug\n*F\n+ 1 WriteMode.kt\nkotlinx/serialization/json/internal/WriteModeKt\n*L\n26#1:54,9\n*E\n"})
public final class WriteModeKt {
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        r3 = a(r0, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlinx.serialization.descriptors.SerialDescriptor a(kotlinx.serialization.descriptors.SerialDescriptor r2, kotlinx.serialization.modules.SerializersModule r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "module"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlinx.serialization.descriptors.SerialKind r0 = r2.getKind()
            kotlinx.serialization.descriptors.SerialKind$CONTEXTUAL r1 = kotlinx.serialization.descriptors.SerialKind.CONTEXTUAL.f4006a
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0025
            kotlinx.serialization.descriptors.SerialDescriptor r0 = kotlinx.serialization.descriptors.ContextAwareKt.b(r3, r2)
            if (r0 == 0) goto L_0x0034
            kotlinx.serialization.descriptors.SerialDescriptor r3 = a(r0, r3)
            if (r3 != 0) goto L_0x0023
            goto L_0x0034
        L_0x0023:
            r2 = r3
            goto L_0x0034
        L_0x0025:
            boolean r0 = r2.isInline()
            if (r0 == 0) goto L_0x0034
            r0 = 0
            kotlinx.serialization.descriptors.SerialDescriptor r2 = r2.d(r0)
            kotlinx.serialization.descriptors.SerialDescriptor r2 = a(r2, r3)
        L_0x0034:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.WriteModeKt.a(kotlinx.serialization.descriptors.SerialDescriptor, kotlinx.serialization.modules.SerializersModule):kotlinx.serialization.descriptors.SerialDescriptor");
    }

    public static final WriteMode b(Json json, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(serialDescriptor, "desc");
        SerialKind kind = serialDescriptor.getKind();
        if (kind instanceof PolymorphicKind) {
            return WriteMode.POLY_OBJ;
        }
        if (Intrinsics.areEqual((Object) kind, (Object) StructureKind.LIST.f4009a)) {
            return WriteMode.LIST;
        }
        if (!Intrinsics.areEqual((Object) kind, (Object) StructureKind.MAP.f4010a)) {
            return WriteMode.OBJ;
        }
        SerialDescriptor a2 = a(serialDescriptor.d(0), json.c());
        SerialKind kind2 = a2.getKind();
        if ((kind2 instanceof PrimitiveKind) || Intrinsics.areEqual((Object) kind2, (Object) SerialKind.ENUM.f4007a)) {
            return WriteMode.MAP;
        }
        if (json.b().b()) {
            return WriteMode.LIST;
        }
        throw JsonExceptionsKt.d(a2);
    }
}
