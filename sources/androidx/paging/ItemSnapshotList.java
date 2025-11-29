package androidx.paging;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractList;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000e\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/paging/ItemSnapshotList;", "T", "Lkotlin/collections/AbstractList;", "", "index", "get", "(I)Ljava/lang/Object;", "a", "I", "getPlaceholdersBefore", "()I", "placeholdersBefore", "b", "getPlaceholdersAfter", "placeholdersAfter", "", "c", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "getSize", "size", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class ItemSnapshotList<T> extends AbstractList<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f1549a;
    public final int b;
    public final List c;

    public Object get(int i) {
        if (i >= 0 && i < this.f1549a) {
            return null;
        }
        int i2 = this.f1549a;
        if (i < this.c.size() + i2 && i2 <= i) {
            return this.c.get(i - this.f1549a);
        }
        int size = this.f1549a + this.c.size();
        if (i < size() && size <= i) {
            return null;
        }
        throw new IndexOutOfBoundsException("Illegal attempt to access index " + i + " in ItemSnapshotList of size " + size());
    }

    public int getSize() {
        return this.f1549a + this.c.size() + this.b;
    }
}
