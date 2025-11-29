package com.xjsd.ai.assistant.phone.session.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\u0010&\n\u0002\b\u0003\u001a;\u0010\u0004\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a;\u0010\u0006\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0003¢\u0006\u0004\b\u0006\u0010\u0005\u001aC\u0010\b\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00032\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\t\u001aK\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b0\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"K", "V", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "c", "(Ljava/util/LinkedHashMap;)Ljava/lang/Object;", "b", "key", "a", "(Ljava/util/LinkedHashMap;Ljava/lang/Object;)Ljava/lang/Object;", "", "", "d", "(Ljava/util/LinkedHashMap;)Ljava/util/Iterator;", "ar-assistant_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nASyncLifecycleRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ASyncLifecycleRegistry.kt\ncom/xjsd/ai/assistant/phone/session/utils/ASyncLifecycleRegistryKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,229:1\n1855#2,2:230\n1855#2,2:232\n*S KotlinDebug\n*F\n+ 1 ASyncLifecycleRegistry.kt\ncom/xjsd/ai/assistant/phone/session/utils/ASyncLifecycleRegistryKt\n*L\n213#1:230,2\n225#1:232,2\n*E\n"})
public final class ASyncLifecycleRegistryKt {
    public static final Object a(LinkedHashMap linkedHashMap, Object obj) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
        Set keySet = linkedHashMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        Object obj2 = null;
        for (Object next : keySet) {
            if (Intrinsics.areEqual(obj, next)) {
                break;
            }
            obj2 = linkedHashMap.get(next);
        }
        return obj2;
    }

    public static final Object b(LinkedHashMap linkedHashMap) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
        Collection values = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return CollectionsKt.firstOrNull(values);
    }

    public static final Object c(LinkedHashMap linkedHashMap) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
        Collection values = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return CollectionsKt.lastOrNull(values);
    }

    public static final Iterator d(LinkedHashMap linkedHashMap) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
        ArrayList arrayList = new ArrayList();
        Set<Map.Entry> entrySet = linkedHashMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
        for (Map.Entry entry : entrySet) {
            Intrinsics.checkNotNull(entry);
            arrayList.add(entry);
        }
        return CollectionsKt.reversed(arrayList).iterator();
    }
}
