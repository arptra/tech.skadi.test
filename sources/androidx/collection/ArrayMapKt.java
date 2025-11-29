package androidx.collection;

import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00030\u0002\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"K", "V", "", "Lkotlin/Pair;", "pairs", "Landroidx/collection/ArrayMap;", "a", "([Lkotlin/Pair;)Landroidx/collection/ArrayMap;", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class ArrayMapKt {
    public static final ArrayMap a(Pair... pairArr) {
        ArrayMap arrayMap = new ArrayMap(pairArr.length);
        for (Pair pair : pairArr) {
            arrayMap.put(pair.getFirst(), pair.getSecond());
        }
        return arrayMap;
    }
}
