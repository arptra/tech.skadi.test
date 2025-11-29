package androidx.paging;

import androidx.paging.PagingSource;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B=\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR)\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010%¨\u0006&"}, d2 = {"Landroidx/paging/PagingState;", "", "Key", "Value", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "pages", "", "anchorPosition", "Landroidx/paging/PagingConfig;", "config", "leadingPlaceholderCount", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Landroidx/paging/PagingConfig;I)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "b", "(I)Ljava/lang/Object;", "c", "(I)Landroidx/paging/PagingSource$LoadResult$Page;", "", "toString", "()Ljava/lang/String;", "a", "Ljava/util/List;", "f", "()Ljava/util/List;", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "Landroidx/paging/PagingConfig;", "e", "()Landroidx/paging/PagingConfig;", "I", "paging-common"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPagingState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagingState.kt\nandroidx/paging/PagingState\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,151:1\n142#1,8:155\n142#1,8:174\n1726#2,3:152\n223#2,2:163\n451#2,6:165\n1726#2,3:171\n1726#2,3:182\n288#2,2:185\n533#2,6:187\n*S KotlinDebug\n*F\n+ 1 PagingState.kt\nandroidx/paging/PagingState\n*L\n76#1:155,8\n103#1:174,8\n74#1:152,3\n77#1:163,2\n78#1:165,6\n101#1:171,3\n115#1:182,3\n122#1:185,2\n130#1:187,6\n*E\n"})
public final class PagingState<Key, Value> {

    /* renamed from: a  reason: collision with root package name */
    public final List f1622a;
    public final Integer b;
    public final PagingConfig c;
    public final int d;

    public PagingState(List list, Integer num, PagingConfig pagingConfig, int i) {
        Intrinsics.checkNotNullParameter(list, "pages");
        Intrinsics.checkNotNullParameter(pagingConfig, "config");
        this.f1622a = list;
        this.b = num;
        this.c = pagingConfig;
        this.d = i;
    }

    public final Object b(int i) {
        List<PagingSource.LoadResult.Page> list = this.f1622a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        for (PagingSource.LoadResult.Page b2 : list) {
            if (!b2.b().isEmpty()) {
                int a2 = i - this.d;
                int i2 = 0;
                while (i2 < CollectionsKt.getLastIndex(f()) && a2 > CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) f().get(i2)).b())) {
                    a2 -= ((PagingSource.LoadResult.Page) f().get(i2)).b().size();
                    i2++;
                }
                for (PagingSource.LoadResult.Page page : this.f1622a) {
                    if (!page.b().isEmpty()) {
                        List list2 = this.f1622a;
                        ListIterator listIterator = list2.listIterator(list2.size());
                        while (listIterator.hasPrevious()) {
                            PagingSource.LoadResult.Page page2 = (PagingSource.LoadResult.Page) listIterator.previous();
                            if (!page2.b().isEmpty()) {
                                return a2 < 0 ? CollectionsKt.first(page.b()) : (i2 != CollectionsKt.getLastIndex(this.f1622a) || a2 <= CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) CollectionsKt.last(this.f1622a)).b())) ? ((PagingSource.LoadResult.Page) this.f1622a.get(i2)).b().get(a2) : CollectionsKt.last(page2.b());
                            }
                        }
                        throw new NoSuchElementException("List contains no element matching the predicate.");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        return null;
    }

    public final PagingSource.LoadResult.Page c(int i) {
        List<PagingSource.LoadResult.Page> list = this.f1622a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        for (PagingSource.LoadResult.Page b2 : list) {
            if (!b2.b().isEmpty()) {
                int a2 = i - this.d;
                int i2 = 0;
                while (i2 < CollectionsKt.getLastIndex(f()) && a2 > CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) f().get(i2)).b())) {
                    a2 -= ((PagingSource.LoadResult.Page) f().get(i2)).b().size();
                    i2++;
                }
                return a2 < 0 ? (PagingSource.LoadResult.Page) CollectionsKt.first(this.f1622a) : (PagingSource.LoadResult.Page) this.f1622a.get(i2);
            }
        }
        return null;
    }

    public final Integer d() {
        return this.b;
    }

    public final PagingConfig e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PagingState) {
            PagingState pagingState = (PagingState) obj;
            return Intrinsics.areEqual((Object) this.f1622a, (Object) pagingState.f1622a) && Intrinsics.areEqual((Object) this.b, (Object) pagingState.b) && Intrinsics.areEqual((Object) this.c, (Object) pagingState.c) && this.d == pagingState.d;
        }
    }

    public final List f() {
        return this.f1622a;
    }

    public int hashCode() {
        int hashCode = this.f1622a.hashCode();
        Integer num = this.b;
        return hashCode + (num != null ? num.hashCode() : 0) + this.c.hashCode() + Integer.hashCode(this.d);
    }

    public String toString() {
        return "PagingState(pages=" + this.f1622a + ", anchorPosition=" + this.b + ", config=" + this.c + ", leadingPlaceholderCount=" + this.d + ')';
    }
}
