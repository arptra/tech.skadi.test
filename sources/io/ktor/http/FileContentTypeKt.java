package io.ktor.http;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u001aC\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00030\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000b\"-\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e\"-\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0012"}, d2 = {"A", "B", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "", "", "a", "(Lkotlin/sequences/Sequence;)Ljava/util/Map;", "", "Lio/ktor/http/ContentType;", "b", "(Ljava/lang/String;)Lio/ktor/http/ContentType;", "Lkotlin/Lazy;", "getContentTypesByExtensions", "()Ljava/util/Map;", "contentTypesByExtensions", "getExtensionsByContentType", "extensionsByContentType", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFileContentType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileContentType.kt\nio/ktor/http/FileContentTypeKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,81:1\n970#2:82\n999#2,3:83\n1002#2,3:93\n361#3,7:86\n442#3:96\n392#3:97\n1238#4,2:98\n1549#4:100\n1620#4,3:101\n1241#4:104\n*S KotlinDebug\n*F\n+ 1 FileContentType.kt\nio/ktor/http/FileContentTypeKt\n*L\n73#1:82\n73#1:83,3\n73#1:93,3\n73#1:86,7\n74#1:96\n74#1:97\n74#1:98,2\n74#1:100\n74#1:101,3\n74#1:104\n*E\n"})
public final class FileContentTypeKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Lazy f8957a = LazyKt.lazy(FileContentTypeKt$contentTypesByExtensions$2.INSTANCE);
    public static final Lazy b = LazyKt.lazy(FileContentTypeKt$extensionsByContentType$2.INSTANCE);

    public static final Map a(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : sequence) {
            Object first = ((Pair) next).getFirst();
            Object obj = linkedHashMap.get(first);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(first, obj);
            }
            ((List) obj).add(next);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Iterable<Pair> iterable = (Iterable) entry.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Pair second : iterable) {
                arrayList.add(second.getSecond());
            }
            linkedHashMap2.put(key, arrayList);
        }
        return linkedHashMap2;
    }

    public static final ContentType b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return ContentType.f.b(str);
        } catch (Throwable th) {
            throw new IllegalArgumentException("Failed to parse " + str, th);
        }
    }
}
