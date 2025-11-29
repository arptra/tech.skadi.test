package sdk.meizu.account.factor.authentication.sdk.module;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.honey.account.constant.AccountConstantKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"sdk/meizu/account/factor/authentication/sdk/module/NullOrEmptyTypeAdapterFactory$create$1", "Lcom/google/gson/TypeAdapter;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NullOrEmptyTypeAdapterFactory$create$1 extends TypeAdapter<T> {
    final /* synthetic */ TypeAdapter<T> $delegateAdapter;

    public NullOrEmptyTypeAdapterFactory$create$1(TypeAdapter<T> typeAdapter) {
        this.$delegateAdapter = typeAdapter;
    }

    @Nullable
    public T read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "in");
        JsonObject asJsonObject = JsonParser.parseReader(jsonReader).getAsJsonObject();
        if (asJsonObject.has(AccountConstantKt.RESPONSE_VALUE) && asJsonObject.get(AccountConstantKt.RESPONSE_VALUE).isJsonPrimitive()) {
            String asString = asJsonObject.get(AccountConstantKt.RESPONSE_VALUE).getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
            if (asString.length() == 0) {
                asJsonObject.remove(AccountConstantKt.RESPONSE_VALUE);
            }
        }
        return this.$delegateAdapter.fromJsonTree(asJsonObject);
    }

    public void write(@NotNull JsonWriter jsonWriter, T t) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        this.$delegateAdapter.write(jsonWriter, t);
    }
}
