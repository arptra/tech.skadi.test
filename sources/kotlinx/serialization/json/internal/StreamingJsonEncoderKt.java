package kotlinx.serialization.json.internal;

import java.util.Set;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElementKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003\"\u0018\u0010\b\u001a\u00020\u0005*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\t\u001a\u00020\u0005*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0007¨\u0006\n"}, d2 = {"", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "a", "Ljava/util/Set;", "unsignedNumberDescriptors", "", "b", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "isUnsignedNumber", "isUnquotedLiteral", "kotlinx-serialization-json"}, k = 2, mv = {1, 9, 0})
public final class StreamingJsonEncoderKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f4119a = SetsKt.setOf(BuiltinSerializersKt.v(UInt.Companion).getDescriptor(), BuiltinSerializersKt.w(ULong.Companion).getDescriptor(), BuiltinSerializersKt.u(UByte.Companion).getDescriptor(), BuiltinSerializersKt.x(UShort.Companion).getDescriptor());

    public static final boolean a(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return serialDescriptor.isInline() && Intrinsics.areEqual((Object) serialDescriptor, (Object) JsonElementKt.k());
    }

    public static final boolean b(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return serialDescriptor.isInline() && f4119a.contains(serialDescriptor);
    }
}
