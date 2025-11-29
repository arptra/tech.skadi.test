package com.xjsd.ai.assistant.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\t\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0007¢\u0006\u0004\b\f\u0010\rJ1\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00042\u0006\u0010\t\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0011\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/xjsd/ai/assistant/json/GsonUtils;", "", "<init>", "()V", "T", "t", "", "e", "(Ljava/lang/Object;)Ljava/lang/String;", "json", "Ljava/lang/Class;", "clazz", "a", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "", "b", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/util/List;", "obj", "c", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/List;", "Lcom/google/gson/Gson;", "d", "()Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "mGson", "lib_assistant_release"}, k = 1, mv = {1, 9, 0})
public final class GsonUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final GsonUtils f8498a = new GsonUtils();
    public static final Gson b;

    static {
        Gson create = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").enableComplexMapKeySerialization().disableHtmlEscaping().create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        b = create;
    }

    public static final Object a(String str, Class cls) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return b.fromJson(str, cls);
    }

    public static final List b(String str, Class cls) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = JsonParser.parseString(str).getAsJsonArray().iterator();
        while (it.hasNext()) {
            arrayList.add(f8498a.d().fromJson(it.next(), cls));
        }
        return arrayList;
    }

    public static final List c(Object obj, Class cls) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = JsonParser.parseString(f8498a.d().toJson(obj)).getAsJsonArray().iterator();
        while (it.hasNext()) {
            arrayList.add(f8498a.d().fromJson(it.next(), cls));
        }
        return arrayList;
    }

    public static final String e(Object obj) {
        String json = b.toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final Gson d() {
        return b;
    }
}
