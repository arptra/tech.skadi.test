package com.upuphone.ar.tici.phone.utils;

import com.google.gson.Gson;
import com.upuphone.star.core.log.ULog;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0012\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/JsonUtils;", "", "<init>", "()V", "T", "", "json", "Ljava/lang/reflect/Type;", "type", "a", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "any", "c", "(Ljava/lang/Object;)Ljava/lang/String;", "Lcom/google/gson/Gson;", "b", "Lkotlin/Lazy;", "()Lcom/google/gson/Gson;", "gson", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class JsonUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonUtils f5992a = new JsonUtils();
    public static final Lazy b = LazyKt.lazy(JsonUtils$gson$2.INSTANCE);

    public final Object a(String str, Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return b().fromJson(str, type);
        } catch (Throwable th) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c(com.upuphone.star.httplib.JsonUtils.TAG, "fromJson-error: " + th);
            return null;
        }
    }

    public final Gson b() {
        Object value = b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Gson) value;
    }

    public final String c(Object obj) {
        String json = b().toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }
}
