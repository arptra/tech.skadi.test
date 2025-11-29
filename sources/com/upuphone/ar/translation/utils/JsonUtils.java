package com.upuphone.ar.translation.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.honey.account.l5.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\bJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/upuphone/ar/translation/utils/JsonUtils;", "", "<init>", "()V", "T", "t", "", "d", "(Ljava/lang/Object;)Ljava/lang/String;", "json", "", "b", "(Ljava/lang/String;)Z", "e", "c", "Lcom/alibaba/fastjson/serializer/ValueFilter;", "Lcom/alibaba/fastjson/serializer/ValueFilter;", "valueFilter", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class JsonUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonUtils f6365a = new JsonUtils();
    public static final ValueFilter b = new a();

    public static final boolean b(String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        try {
            JSON.parse(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final String d(Object obj) {
        return JSON.toJSON(obj).toString();
    }

    public static final Object f(Object obj, String str, Object obj2) {
        if (Intrinsics.areEqual(obj2, (Object) "") || obj2 == null) {
            return null;
        }
        return obj2;
    }

    public final boolean c(String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        try {
            return JSON.parseObject(str).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    public final String e(Object obj) {
        String jSONString = JSON.toJSONString(obj, (SerializeFilter) b, new SerializerFeature[0]);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
        return jSONString;
    }
}
