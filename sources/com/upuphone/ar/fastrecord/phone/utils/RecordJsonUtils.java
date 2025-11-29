package com.upuphone.ar.fastrecord.phone.utils;

import com.alibaba.fastjson.JSON;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001b\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u0002H\bH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecordJsonUtils;", "", "()V", "isJsonArr", "", "json", "", "toJson", "T", "t", "(Ljava/lang/Object;)Ljava/lang/String;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordJsonUtils {
    @NotNull
    public static final RecordJsonUtils INSTANCE = new RecordJsonUtils();

    private RecordJsonUtils() {
    }

    @JvmStatic
    public static final boolean isJsonArr(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        try {
            JSON.parse(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    @NotNull
    public static final <T> String toJson(T t) {
        return JSON.toJSON(t).toString();
    }
}
