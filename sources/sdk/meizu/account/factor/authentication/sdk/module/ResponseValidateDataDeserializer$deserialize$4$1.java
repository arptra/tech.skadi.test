package sdk.meizu.account.factor.authentication.sdk.module;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "basic", "Lcom/google/gson/JsonObject;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ResponseValidateDataDeserializer$deserialize$4$1 extends Lambda implements Function1<JsonObject, BasicInfoType> {
    public static final ResponseValidateDataDeserializer$deserialize$4$1 INSTANCE = new ResponseValidateDataDeserializer$deserialize$4$1();

    public ResponseValidateDataDeserializer$deserialize$4$1() {
        super(1);
    }

    @Nullable
    public final BasicInfoType invoke(@NotNull JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "basic");
        JsonElement jsonElement = jsonObject.get("validateAccount");
        String asString = jsonElement != null ? jsonElement.getAsString() : null;
        JsonElement jsonElement2 = jsonObject.get("validateType");
        String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
        if (asString == null || asString2 == null) {
            return null;
        }
        return new BasicInfoType(asString2, asString);
    }
}
