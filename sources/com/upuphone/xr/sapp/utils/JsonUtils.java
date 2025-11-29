package com.upuphone.xr.sapp.utils;

import com.google.gson.Gson;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.star.core.log.ULog;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\rJ\u001f\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00128FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/utils/JsonUtils;", "", "<init>", "()V", "T", "", "json", "Ljava/lang/reflect/Type;", "type", "a", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "any", "d", "(Ljava/lang/Object;)Ljava/lang/String;", "value", "e", "b", "(Ljava/lang/String;)Ljava/lang/Object;", "Lcom/google/gson/Gson;", "Lkotlin/Lazy;", "c", "()Lcom/google/gson/Gson;", "gson", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class JsonUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonUtils f7893a = new JsonUtils();
    public static final Lazy b = LazyKt.lazy(JsonUtils$gson$2.INSTANCE);

    public final Object a(String str, Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return c().fromJson(str, type);
        } catch (Throwable th) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c(com.upuphone.star.httplib.JsonUtils.TAG, "fromJson-error: " + th);
            return null;
        }
    }

    public final Object b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("class");
            String string2 = jSONObject.getString("json");
            Class<?> cls = Class.forName(string);
            Intrinsics.checkNotNullExpressionValue(cls, "forName(...)");
            return a(string2, cls);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c(com.upuphone.star.httplib.JsonUtils.TAG, "fromJsonSealed, error: " + e);
            return null;
        }
    }

    public final Gson c() {
        Object value = b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Gson) value;
    }

    public final String d(Object obj) {
        String json = c().toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final String e(Object obj) {
        Intrinsics.checkNotNullParameter(obj, AccountConstantKt.RESPONSE_VALUE);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("class", obj.getClass().getName());
        jSONObject.put("json", f7893a.d(obj));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "run(...)");
        return jSONObject2;
    }
}
