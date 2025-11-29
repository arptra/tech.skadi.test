package sdk.meizu.account.factor.authentication.sdk.module;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.honey.account.constant.AccountConstantKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.data.AnswerType;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lsdk/meizu/account/factor/authentication/sdk/data/AnswerType;", "answer", "Lcom/google/gson/JsonObject;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ResponseValidateDataDeserializer$deserialize$3$1 extends Lambda implements Function1<JsonObject, AnswerType> {
    public static final ResponseValidateDataDeserializer$deserialize$3$1 INSTANCE = new ResponseValidateDataDeserializer$deserialize$3$1();

    public ResponseValidateDataDeserializer$deserialize$3$1() {
        super(1);
    }

    @Nullable
    public final AnswerType invoke(@NotNull JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "answer");
        JsonElement jsonElement = jsonObject.get("desc");
        String asString = jsonElement != null ? jsonElement.getAsString() : null;
        JsonElement jsonElement2 = jsonObject.get(AccountConstantKt.RESPONSE_VALUE);
        Integer valueOf = jsonElement2 != null ? Integer.valueOf(jsonElement2.getAsInt()) : null;
        if (asString == null || valueOf == null) {
            return null;
        }
        return new AnswerType(asString, valueOf.intValue(), (String) null, 4, (DefaultConstructorMarker) null);
    }
}
