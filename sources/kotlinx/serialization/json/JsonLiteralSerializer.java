package kotlinx.serialization.json;

import com.honey.account.constant.AccountConstantKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.JsonExceptionsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lkotlinx/serialization/json/JsonLiteralSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonLiteral;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "f", "(Lkotlinx/serialization/encoding/Encoder;Lkotlinx/serialization/json/JsonLiteral;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "e", "(Lkotlinx/serialization/encoding/Decoder;)Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "b", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nJsonElementSerializers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsonElementSerializers.kt\nkotlinx/serialization/json/JsonLiteralSerializer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,236:1\n1#2:237\n*E\n"})
final class JsonLiteralSerializer implements KSerializer<JsonLiteral> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonLiteralSerializer f4084a = new JsonLiteralSerializer();
    public static final SerialDescriptor b = SerialDescriptorsKt.a("kotlinx.serialization.json.JsonLiteral", PrimitiveKind.STRING.f4000a);

    /* renamed from: e */
    public JsonLiteral c(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElement t = JsonElementSerializersKt.d(decoder).t();
        if (t instanceof JsonLiteral) {
            return (JsonLiteral) t;
        }
        throw JsonExceptionsKt.f(-1, "Unexpected JSON element, expected JsonLiteral, had " + Reflection.getOrCreateKotlinClass(t.getClass()), t.toString());
    }

    /* renamed from: f */
    public void a(Encoder encoder, JsonLiteral jsonLiteral) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(jsonLiteral, AccountConstantKt.RESPONSE_VALUE);
        JsonElementSerializersKt.h(encoder);
        if (jsonLiteral.d()) {
            encoder.v(jsonLiteral.a());
        } else if (jsonLiteral.c() != null) {
            encoder.h(jsonLiteral.c()).v(jsonLiteral.a());
        } else {
            Long longOrNull = StringsKt.toLongOrNull(jsonLiteral.a());
            if (longOrNull != null) {
                encoder.A(longOrNull.longValue());
                return;
            }
            ULong uLongOrNull = UStringsKt.toULongOrNull(jsonLiteral.a());
            if (uLongOrNull != null) {
                encoder.h(BuiltinSerializersKt.w(ULong.Companion).getDescriptor()).A(uLongOrNull.m246unboximpl());
                return;
            }
            Double doubleOrNull = StringsKt.toDoubleOrNull(jsonLiteral.a());
            if (doubleOrNull != null) {
                encoder.x(doubleOrNull.doubleValue());
                return;
            }
            Boolean booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(jsonLiteral.a());
            if (booleanStrictOrNull != null) {
                encoder.l(booleanStrictOrNull.booleanValue());
            } else {
                encoder.v(jsonLiteral.a());
            }
        }
    }

    public SerialDescriptor getDescriptor() {
        return b;
    }
}
