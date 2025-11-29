package com.upuphone.ar.shorthand.phone.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\t\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/shorthand/phone/utils/RecordGsonUtils;", "", "<init>", "()V", "T", "t", "", "b", "(Ljava/lang/Object;)Ljava/lang/String;", "json", "Ljava/lang/Class;", "clazz", "a", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "mGson", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0})
public final class RecordGsonUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final RecordGsonUtils f5855a = new RecordGsonUtils();
    public static final Gson b;

    static {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        b = create;
    }

    public static final Object a(String str, Class cls) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return b.fromJson(str, cls);
    }

    public static final String b(Object obj) {
        String json = b.toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }
}
