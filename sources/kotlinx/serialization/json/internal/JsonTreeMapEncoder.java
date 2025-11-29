package kotlinx.serialization.json.internal;

import com.upuphone.runasone.relay.api.IntentKey;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArraySerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeMapEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeEncoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonElement;", "", "nodeConsumer", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)V", "", "key", "element", "z0", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)V", "v0", "()Lkotlinx/serialization/json/JsonElement;", "g", "Ljava/lang/String;", "tag", "", "h", "Z", "isKey", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
final class JsonTreeMapEncoder extends JsonTreeEncoder {
    public String g;
    public boolean h = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeMapEncoder(Json json, Function1 function1) {
        super(json, function1);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(function1, "nodeConsumer");
    }

    public JsonElement v0() {
        return new JsonObject(A0());
    }

    public void z0(String str, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        if (!this.h) {
            Map A0 = A0();
            String str2 = this.g;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tag");
                str2 = null;
            }
            A0.put(str2, jsonElement);
            this.h = true;
        } else if (jsonElement instanceof JsonPrimitive) {
            this.g = ((JsonPrimitive) jsonElement).a();
            this.h = false;
        } else if (jsonElement instanceof JsonObject) {
            throw JsonExceptionsKt.d(JsonObjectSerializer.f4089a.getDescriptor());
        } else if (jsonElement instanceof JsonArray) {
            throw JsonExceptionsKt.d(JsonArraySerializer.f4076a.getDescriptor());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
