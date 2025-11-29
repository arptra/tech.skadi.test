package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Landroidx/collection/SparseArrayCompat;", "", "a", "(Landroidx/collection/SparseArrayCompat;)Ljava/util/Iterator;", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class SparseArrayKt {
    public static final Iterator a(SparseArrayCompat sparseArrayCompat) {
        return new SparseArrayKt$valueIterator$1(sparseArrayCompat);
    }
}
