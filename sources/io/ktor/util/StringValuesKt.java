package io.ktor.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001aO\u0010\u000f\u001a\u00020\u000e2\u001e\u0010\f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00010\u000b0\n2\u001e\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00010\u000b0\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a7\u0010\u0014\u001a\u00020\u00122\u001e\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00010\u000b0\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/util/StringValues;", "", "Lkotlin/Pair;", "", "f", "(Lio/ktor/util/StringValues;)Ljava/util/List;", "Lio/ktor/util/StringValuesBuilder;", "builder", "c", "(Lio/ktor/util/StringValuesBuilder;Lio/ktor/util/StringValuesBuilder;)Lio/ktor/util/StringValuesBuilder;", "", "", "a", "b", "", "d", "(Ljava/util/Set;Ljava/util/Set;)Z", "entries", "", "seed", "e", "(Ljava/util/Set;I)I", "ktor-utils"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nStringValues.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringValues.kt\nio/ktor/util/StringValuesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,422:1\n1855#2,2:423\n1238#2,4:425\n1360#2:429\n1446#2,2:430\n1549#2:432\n1620#2,3:433\n1448#2,3:436\n1855#2:439\n857#2,2:440\n1856#2:442\n1855#2,2:443\n*S KotlinDebug\n*F\n+ 1 StringValues.kt\nio/ktor/util/StringValuesKt\n*L\n330#1:423,2\n338#1:425,4\n343#1:429\n343#1:430,2\n344#1:432\n344#1:433,3\n343#1:436,3\n363#1:439\n364#1:440,2\n363#1:442\n394#1:443,2\n*E\n"})
public final class StringValuesKt {
    public static final StringValuesBuilder c(StringValuesBuilder stringValuesBuilder, StringValuesBuilder stringValuesBuilder2) {
        Intrinsics.checkNotNullParameter(stringValuesBuilder, "<this>");
        Intrinsics.checkNotNullParameter(stringValuesBuilder2, "builder");
        for (Map.Entry entry : stringValuesBuilder2.entries()) {
            stringValuesBuilder.c((String) entry.getKey(), (List) entry.getValue());
        }
        return stringValuesBuilder;
    }

    public static final boolean d(Set set, Set set2) {
        return Intrinsics.areEqual((Object) set, (Object) set2);
    }

    public static final int e(Set set, int i) {
        return (i * 31) + set.hashCode();
    }

    public static final List f(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "<this>");
        Set<Map.Entry> entries = stringValues.entries();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : entries) {
            Iterable<String> iterable = (Iterable) entry.getValue();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String str : iterable) {
                arrayList2.add(TuplesKt.to(entry.getKey(), str));
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }
}
