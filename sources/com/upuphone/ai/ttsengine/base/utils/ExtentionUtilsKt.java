package com.upuphone.ai.ttsengine.base.utils;

import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a!\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u0000*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/os/Bundle;", "", "", "b", "(Landroid/os/Bundle;)Ljava/util/Map;", "a", "(Ljava/util/Map;)Landroid/os/Bundle;", "aar_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nExtentionUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtentionUtils.kt\ncom/upuphone/ai/ttsengine/base/utils/ExtentionUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,38:1\n1855#2,2:39\n215#3,2:41\n*S KotlinDebug\n*F\n+ 1 ExtentionUtils.kt\ncom/upuphone/ai/ttsengine/base/utils/ExtentionUtilsKt\n*L\n13#1:39,2\n22#1:41,2\n*E\n"})
public final class ExtentionUtilsKt {
    public static final Bundle a(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return bundle;
    }

    public static final Map b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<String> keySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "keySet(...)");
        for (String str : keySet) {
            Intrinsics.checkNotNull(str);
            String string = bundle.getString(str, "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            linkedHashMap.put(str, string);
        }
        return linkedHashMap;
    }
}
