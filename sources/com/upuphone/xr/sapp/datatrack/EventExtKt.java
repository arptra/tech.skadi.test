package com.upuphone.xr.sapp.datatrack;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/DataTrackEvent;", "T", "event", "", "", "b", "(Lcom/upuphone/xr/sapp/datatrack/DataTrackEvent;)Ljava/util/Map;", "", "data", "a", "(Ljava/lang/Object;)Ljava/util/Map;", "Ljava/lang/Class;", "startClass", "exclusiveParent", "", "Ljava/lang/reflect/Field;", "c", "(Ljava/lang/Class;Ljava/lang/Class;)Ljava/util/List;", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nEventExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventExt.kt\ncom/upuphone/xr/sapp/datatrack/EventExtKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1855#2,2:44\n*S KotlinDebug\n*F\n+ 1 EventExt.kt\ncom/upuphone/xr/sapp/datatrack/EventExtKt\n*L\n16#1:44,2\n*E\n"})
public final class EventExtKt {
    public static final Map a(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Field field : c(obj.getClass(), (Class) null)) {
            field.setAccessible(true);
            if (!Intrinsics.areEqual((Object) field.getName(), (Object) "_event_name_")) {
                Object obj2 = field.get(obj);
                String obj3 = obj2 != null ? obj2.toString() : null;
                if (obj3 != null) {
                    String name = field.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    linkedHashMap.put(name, obj3);
                }
            }
        }
        return linkedHashMap;
    }

    public static final Map b(DataTrackEvent dataTrackEvent) {
        Intrinsics.checkNotNullParameter(dataTrackEvent, "event");
        return a(dataTrackEvent);
    }

    public static final List c(Class cls, Class cls2) {
        Intrinsics.checkNotNullParameter(cls, "startClass");
        ArrayList arrayList = new ArrayList();
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        CollectionsKt.addAll(arrayList, (T[]) declaredFields);
        Class superclass = cls.getSuperclass();
        if (superclass != null && (cls2 == null || !Intrinsics.areEqual((Object) superclass, (Object) cls2))) {
            arrayList.addAll(c(superclass, cls2));
        }
        return arrayList;
    }
}
