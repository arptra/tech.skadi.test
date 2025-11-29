package kotlinx.serialization.json;

import com.honey.account.constant.AccountConstantKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lkotlinx/serialization/json/JsonElementSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonElement;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "f", "(Lkotlinx/serialization/encoding/Encoder;Lkotlinx/serialization/json/JsonElement;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "e", "(Lkotlinx/serialization/encoding/Decoder;)Lkotlinx/serialization/json/JsonElement;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "b", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@PublishedApi
public final class JsonElementSerializer implements KSerializer<JsonElement> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonElementSerializer f4081a = new JsonElementSerializer();
    public static final SerialDescriptor b = SerialDescriptorsKt.c("kotlinx.serialization.json.JsonElement", PolymorphicKind.SEALED.f3991a, new SerialDescriptor[0], JsonElementSerializer$descriptor$1.INSTANCE);

    /* renamed from: e */
    public JsonElement c(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return JsonElementSerializersKt.d(decoder).t();
    }

    /* renamed from: f */
    public void a(Encoder encoder, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(jsonElement, AccountConstantKt.RESPONSE_VALUE);
        JsonElementSerializersKt.h(encoder);
        if (jsonElement instanceof JsonPrimitive) {
            encoder.e(JsonPrimitiveSerializer.f4091a, jsonElement);
        } else if (jsonElement instanceof JsonObject) {
            encoder.e(JsonObjectSerializer.f4089a, jsonElement);
        } else if (jsonElement instanceof JsonArray) {
            encoder.e(JsonArraySerializer.f4076a, jsonElement);
        }
    }

    public SerialDescriptor getDescriptor() {
        return b;
    }
}
