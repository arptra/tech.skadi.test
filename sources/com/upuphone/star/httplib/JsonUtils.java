package com.upuphone.star.httplib;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.upuphone.star.core.log.ULog;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J*\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0006\b\u0000\u0010\f\u0018\u00012\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\b¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/upuphone/star/httplib/JsonUtils;", "", "()V", "TAG", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "fromJson", "T", "json", "type", "Ljava/lang/reflect/Type;", "throwException", "", "(Ljava/lang/String;Ljava/lang/reflect/Type;Z)Ljava/lang/Object;", "(Ljava/lang/String;Z)Ljava/lang/Object;", "toJson", "any", "super-http-lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Keep
public final class JsonUtils {
    @NotNull
    public static final JsonUtils INSTANCE = new JsonUtils();
    @NotNull
    public static final String TAG = "JsonUtils";
    @NotNull
    private static final Lazy gson$delegate = LazyKt.lazy(JsonUtils$gson$2.INSTANCE);

    private JsonUtils() {
    }

    public static /* synthetic */ Object fromJson$default(JsonUtils jsonUtils, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.needClassReification();
        Type type = new JsonUtils$fromJson$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<T>() {}.type");
        return jsonUtils.fromJson(str, type, z);
    }

    public final /* synthetic */ <T> T fromJson(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.needClassReification();
        Type type = new JsonUtils$fromJson$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<T>() {}.type");
        return fromJson(str, type, z);
    }

    @NotNull
    public final Gson getGson() {
        Object value = gson$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gson>(...)");
        return (Gson) value;
    }

    @NotNull
    public final String toJson(@Nullable Object obj) {
        String json = getGson().toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(any)");
        return json;
    }

    @Nullable
    public final <T> T fromJson(@NotNull String str, @NotNull Type type, boolean z) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            return getGson().fromJson(str, type);
        } catch (Throwable th) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c(TAG, "fromJson-error: " + th);
            if (!z) {
                return null;
            }
            throw th;
        }
    }

    public static /* synthetic */ Object fromJson$default(JsonUtils jsonUtils, String str, Type type, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return jsonUtils.fromJson(str, type, z);
    }
}
