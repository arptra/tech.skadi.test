package com.upuphone.ar.transcribe.utils;

import com.alibaba.fastjson.JSON;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/transcribe/utils/JsonUtils;", "", "<init>", "()V", "T", "t", "", "b", "(Ljava/lang/Object;)Ljava/lang/String;", "json", "", "a", "(Ljava/lang/String;)Z", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class JsonUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonUtils f6186a = new JsonUtils();

    public static final boolean a(String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        try {
            JSON.parse(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final String b(Object obj) {
        return JSON.toJSON(obj).toString();
    }
}
