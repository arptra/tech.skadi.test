package com.xjsd.xr.sapp.asr.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0007¢\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\r\"\u0006\b\u0000\u0010\u0006\u0018\u00012\u0006\u0010\u0007\u001a\u00020\bH\bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\r\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0007J-\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00060\u000f\"\u0006\b\u0000\u0010\u0010\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u00012\u0006\u0010\u0007\u001a\u00020\bH\bJ\u0006\u0010\u0011\u001a\u00020\u0004J\u001b\u0010\u0012\u001a\u00020\b\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0013\u001a\u0002H\u0006H\u0007¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/xjsd/xr/sapp/asr/utils/GsonHelper;", "", "()V", "mGson", "Lcom/google/gson/Gson;", "fromJson", "T", "json", "", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "fromJsonForList", "", "fromJsonForMap", "", "K", "getGson", "toJson", "t", "(Ljava/lang/Object;)Ljava/lang/String;", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GsonHelper {
    @NotNull
    public static final GsonHelper INSTANCE = new GsonHelper();
    @NotNull
    private static final Gson mGson;

    static {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        mGson = create;
    }

    private GsonHelper() {
    }

    @JvmStatic
    public static final <T> T fromJson(@NotNull String str, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return mGson.fromJson(str, cls);
    }

    @JvmStatic
    public static final /* synthetic */ <T> List<T> fromJsonForList(String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.needClassReification();
        Object fromJson = new Gson().fromJson(str, new GsonHelper$fromJsonForList$type$1().getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        return (List) fromJson;
    }

    @JvmStatic
    public static final /* synthetic */ <K, T> Map<K, T> fromJsonForMap(String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.needClassReification();
        Object fromJson = INSTANCE.getGson().fromJson(str, new GsonHelper$fromJsonForMap$type$1().getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        return (Map) fromJson;
    }

    @JvmStatic
    @NotNull
    public static final <T> String toJson(T t) {
        String json = mGson.toJson((Object) t);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    @NotNull
    public final Gson getGson() {
        return mGson;
    }

    @JvmStatic
    @NotNull
    public static final <T> List<T> fromJsonForList(@NotNull String str, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = JsonParser.parseString(str).getAsJsonArray().iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.getGson().fromJson(it.next(), cls));
        }
        return arrayList;
    }
}
