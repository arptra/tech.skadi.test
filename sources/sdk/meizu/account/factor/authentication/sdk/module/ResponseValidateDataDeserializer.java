package sdk.meizu.account.factor.authentication.sdk.module;

import android.util.Log;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.common.helper.ExtKt;
import sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/module/ResponseValidateDataDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lsdk/meizu/account/factor/authentication/sdk/data/ResponseValidateData;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ResponseValidateDataDeserializer implements JsonDeserializer<ResponseValidateData> {
    @NotNull
    public ResponseValidateData deserialize(@Nullable JsonElement jsonElement, @Nullable Type type, @Nullable JsonDeserializationContext jsonDeserializationContext) {
        JsonArray asJsonArray;
        JsonArray asJsonArray2;
        Log.d("ResponseValidateDataDeserializer", "json1: " + jsonElement);
        ResponseValidateData responseValidateData = new ResponseValidateData((List) null, (List) null, 3, (DefaultConstructorMarker) null);
        if (jsonElement != null && jsonElement.isJsonArray()) {
            JsonArray asJsonArray3 = jsonElement.getAsJsonArray();
            Intrinsics.checkNotNullExpressionValue(asJsonArray3, "getAsJsonArray(...)");
            responseValidateData.setUserAnswerValidate(ExtKt.mapToType(asJsonArray3, ResponseValidateDataDeserializer$deserialize$1.INSTANCE));
            JsonArray asJsonArray4 = jsonElement.getAsJsonArray();
            Intrinsics.checkNotNullExpressionValue(asJsonArray4, "getAsJsonArray(...)");
            responseValidateData.setUserBasicInfoValidate(ExtKt.mapToType(asJsonArray4, ResponseValidateDataDeserializer$deserialize$2.INSTANCE));
        } else if (jsonElement != null && jsonElement.isJsonObject()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (!(asJsonObject == null || (asJsonArray2 = asJsonObject.getAsJsonArray("userAnswerValidate")) == null)) {
                responseValidateData.setUserAnswerValidate(ExtKt.mapToType(asJsonArray2, ResponseValidateDataDeserializer$deserialize$3$1.INSTANCE));
            }
            if (!(asJsonObject == null || (asJsonArray = asJsonObject.getAsJsonArray("userBasicInfoValidate")) == null)) {
                responseValidateData.setUserBasicInfoValidate(ExtKt.mapToType(asJsonArray, ResponseValidateDataDeserializer$deserialize$4$1.INSTANCE));
            }
        }
        Log.e("ResponseValidateDataDeserializer", "json2, data: " + responseValidateData);
        return responseValidateData;
    }
}
