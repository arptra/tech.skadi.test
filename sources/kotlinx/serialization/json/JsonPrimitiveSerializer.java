package kotlinx.serialization.json;

import com.honey.account.constant.AccountConstantKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.JsonExceptionsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lkotlinx/serialization/json/JsonPrimitiveSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonPrimitive;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "f", "(Lkotlinx/serialization/encoding/Encoder;Lkotlinx/serialization/json/JsonPrimitive;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "e", "(Lkotlinx/serialization/encoding/Decoder;)Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "b", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@PublishedApi
public final class JsonPrimitiveSerializer implements KSerializer<JsonPrimitive> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonPrimitiveSerializer f4091a = new JsonPrimitiveSerializer();
    public static final SerialDescriptor b = SerialDescriptorsKt.d("kotlinx.serialization.json.JsonPrimitive", PrimitiveKind.STRING.f4000a, new SerialDescriptor[0], (Function1) null, 8, (Object) null);

    /* renamed from: e */
    public JsonPrimitive c(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElement t = JsonElementSerializersKt.d(decoder).t();
        if (t instanceof JsonPrimitive) {
            return (JsonPrimitive) t;
        }
        throw JsonExceptionsKt.f(-1, "Unexpected JSON element, expected JsonPrimitive, had " + Reflection.getOrCreateKotlinClass(t.getClass()), t.toString());
    }

    /* renamed from: f */
    public void a(Encoder encoder, JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(jsonPrimitive, AccountConstantKt.RESPONSE_VALUE);
        JsonElementSerializersKt.h(encoder);
        if (jsonPrimitive instanceof JsonNull) {
            encoder.e(JsonNullSerializer.f4087a, JsonNull.INSTANCE);
        } else {
            encoder.e(JsonLiteralSerializer.f4084a, (JsonLiteral) jsonPrimitive);
        }
    }

    public SerialDescriptor getDescriptor() {
        return b;
    }
}
