package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.paging.LegacyPageFetcher;
import androidx.paging.PagedList;
import androidx.paging.PagingSource;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

@SourceDebugExtension({"SMAP\nPagedStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagedStorage.kt\nandroidx/paging/PagedStorage\n*L\n1#1,360:1\n152#1,15:361\n*S KotlinDebug\n*F\n+ 1 PagedStorage.kt\nandroidx/paging/PagedStorage\n*L\n173#1:361,15\n*E\n"})
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b#\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00010\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005:\u0001WB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\u0007JA\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017JK\u0010\u001a\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\"\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010!2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u0004\u0018\u00018\u00002\u0006\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010\u001eJ\u001d\u0010&\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b(\u0010'J%\u0010*\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b¢\u0006\u0004\b*\u0010\u0017J/\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b,\u0010-J/\u0010.\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b.\u0010-J-\u0010/\u001a\u00020\u00102\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0004\b/\u00100J-\u00101\u001a\u00020\u00102\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0004\b1\u00100J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104R$\u00108\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n058\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R$\u0010>\u001a\u00020\b2\u0006\u00109\u001a\u00020\b8\u0016@RX\u000e¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R$\u0010A\u001a\u00020\b2\u0006\u00109\u001a\u00020\b8\u0016@RX\u000e¢\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b@\u0010=R$\u0010\r\u001a\u00020\b2\u0006\u00109\u001a\u00020\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b<\u0010;\u001a\u0004\bB\u0010=R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010CR$\u0010D\u001a\u00020\b2\u0006\u00109\u001a\u00020\b8\u0016@RX\u000e¢\u0006\f\n\u0004\b\u001d\u0010;\u001a\u0004\b?\u0010=R\u0016\u0010F\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010;R\u0014\u0010I\u001a\u00028\u00008@X\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010K\u001a\u00028\u00008@X\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010HR$\u0010P\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\bM\u0010=\"\u0004\bN\u0010OR\u0011\u0010R\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bQ\u0010=R\u0016\u0010T\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\bS\u0010HR\u0016\u0010U\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b6\u0010HR\u0014\u0010V\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010=¨\u0006X"}, d2 = {"Landroidx/paging/PagedStorage;", "", "T", "Ljava/util/AbstractList;", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "Landroidx/paging/NullPaddedList;", "<init>", "()V", "", "leadingNulls", "Landroidx/paging/PagingSource$LoadResult$Page;", "page", "trailingNulls", "positionOffset", "", "counted", "", "p", "(ILandroidx/paging/PagingSource$LoadResult$Page;IIZ)V", "maxSize", "requiredRemaining", "localPageIndex", "q", "(III)Z", "Landroidx/paging/PagedStorage$Callback;", "callback", "o", "(ILandroidx/paging/PagingSource$LoadResult$Page;IILandroidx/paging/PagedStorage$Callback;Z)V", "localIndex", "f", "(I)Ljava/lang/Object;", "Landroidx/paging/PagedList$Config;", "config", "Landroidx/paging/PagingState;", "n", "(Landroidx/paging/PagedList$Config;)Landroidx/paging/PagingState;", "index", "get", "s", "(II)Z", "r", "countToBeAdded", "v", "insertNulls", "x", "(ZIILandroidx/paging/PagedStorage$Callback;)Z", "w", "t", "(Landroidx/paging/PagingSource$LoadResult$Page;Landroidx/paging/PagedStorage$Callback;)V", "i", "", "toString", "()Ljava/lang/String;", "", "a", "Ljava/util/List;", "pages", "<set-?>", "b", "I", "d", "()I", "placeholdersBefore", "c", "e", "placeholdersAfter", "getPositionOffset", "Z", "storageCount", "g", "lastLoadAroundLocalIndex", "j", "()Ljava/lang/Object;", "firstLoadedItem", "l", "lastLoadedItem", "value", "k", "setLastLoadAroundIndex", "(I)V", "lastLoadAroundIndex", "m", "middleOfLoadedRange", "h", "prevKey", "nextKey", "size", "Callback", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class PagedStorage<T> extends AbstractList<T> implements LegacyPageFetcher.KeyProvider<Object>, NullPaddedList<T> {

    /* renamed from: a  reason: collision with root package name */
    public final List f1595a = new ArrayList();
    public int b;
    public int c;
    public int d;
    public boolean e = true;
    public int f;
    public int g;

    @RestrictTo
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0010ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/paging/PagedStorage$Callback;", "", "", "count", "", "c", "(I)V", "leadingNulls", "changed", "added", "a", "(III)V", "endPosition", "h", "startOfDrops", "f", "(II)V", "e", "paging-common"}, k = 1, mv = {1, 8, 0})
    public interface Callback {
        void a(int i, int i2, int i3);

        void c(int i);

        void e(int i, int i2);

        void f(int i, int i2);

        void h(int i, int i2, int i3);
    }

    public Object a() {
        if (!this.e || e() > 0) {
            return ((PagingSource.LoadResult.Page) CollectionsKt.last(this.f1595a)).e();
        }
        return null;
    }

    public int b() {
        return d() + c() + e();
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }

    public Object f(int i) {
        int size = this.f1595a.size();
        int i2 = 0;
        while (i2 < size) {
            int size2 = ((PagingSource.LoadResult.Page) this.f1595a.get(i2)).b().size();
            if (size2 > i) {
                break;
            }
            i -= size2;
            i2++;
        }
        return ((PagingSource.LoadResult.Page) this.f1595a.get(i2)).b().get(i);
    }

    public Object get(int i) {
        int d2 = i - d();
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size());
        } else if (d2 < 0 || d2 >= c()) {
            return null;
        } else {
            return f(d2);
        }
    }

    public Object h() {
        if (!this.e || d() + this.d > 0) {
            return ((PagingSource.LoadResult.Page) CollectionsKt.first(this.f1595a)).f();
        }
        return null;
    }

    public final void i(PagingSource.LoadResult.Page page, Callback callback) {
        Intrinsics.checkNotNullParameter(page, "page");
        int size = page.b().size();
        if (size != 0) {
            this.f1595a.add(page);
            this.f = c() + size;
            int min = Math.min(e(), size);
            int i = size - min;
            if (min != 0) {
                this.c = e() - min;
            }
            if (callback != null) {
                callback.h((d() + c()) - size, min, i);
            }
        }
    }

    public final Object j() {
        return CollectionsKt.first(((PagingSource.LoadResult.Page) CollectionsKt.first(this.f1595a)).b());
    }

    public final int k() {
        return d() + this.g;
    }

    public final Object l() {
        return CollectionsKt.last(((PagingSource.LoadResult.Page) CollectionsKt.last(this.f1595a)).b());
    }

    public final int m() {
        return d() + (c() / 2);
    }

    public final PagingState n(PagedList.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.f1595a.isEmpty()) {
            return null;
        }
        List list = CollectionsKt.toList(this.f1595a);
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<androidx.paging.PagingSource.LoadResult.Page<kotlin.Any, T of androidx.paging.PagedStorage>>");
        return new PagingState(list, Integer.valueOf(k()), new PagingConfig(config.f1591a, config.b, config.c, config.d, config.e, 0, 32, (DefaultConstructorMarker) null), d());
    }

    public final void o(int i, PagingSource.LoadResult.Page page, int i2, int i3, Callback callback, boolean z) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(callback, "callback");
        p(i, page, i2, i3, z);
        callback.c(size());
    }

    public final void p(int i, PagingSource.LoadResult.Page page, int i2, int i3, boolean z) {
        this.b = i;
        this.f1595a.clear();
        this.f1595a.add(page);
        this.c = i2;
        this.d = i3;
        this.f = page.b().size();
        this.e = z;
        this.g = page.b().size() / 2;
    }

    public final boolean q(int i, int i2, int i3) {
        return c() > i && this.f1595a.size() > 2 && c() - ((PagingSource.LoadResult.Page) this.f1595a.get(i3)).b().size() >= i2;
    }

    public final boolean r(int i, int i2) {
        return q(i, i2, this.f1595a.size() - 1);
    }

    public final /* bridge */ Object remove(int i) {
        return u(i);
    }

    public final boolean s(int i, int i2) {
        return q(i, i2, 0);
    }

    public final /* bridge */ int size() {
        return b();
    }

    public final void t(PagingSource.LoadResult.Page page, Callback callback) {
        Intrinsics.checkNotNullParameter(page, "page");
        int size = page.b().size();
        if (size != 0) {
            this.f1595a.add(0, page);
            this.f = c() + size;
            int min = Math.min(d(), size);
            int i = size - min;
            if (min != 0) {
                this.b = d() - min;
            }
            this.d -= i;
            if (callback != null) {
                callback.a(d(), min, i);
            }
        }
    }

    public String toString() {
        return "leading " + d() + ", storage " + c() + ", trailing " + e() + ' ' + CollectionsKt.joinToString$default(this.f1595a, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public /* bridge */ Object u(int i) {
        return super.remove(i);
    }

    public final boolean v(int i, int i2, int i3) {
        return c() + i3 > i && this.f1595a.size() > 1 && c() >= i2;
    }

    public final boolean w(boolean z, int i, int i2, Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i3 = 0;
        while (r(i, i2)) {
            List list = this.f1595a;
            int size = ((PagingSource.LoadResult.Page) list.remove(list.size() - 1)).b().size();
            i3 += size;
            this.f = c() - size;
        }
        this.g = RangesKt.coerceAtMost(this.g, c() - 1);
        if (i3 > 0) {
            int d2 = d() + c();
            if (z) {
                this.c = e() + i3;
                callback.e(d2, i3);
            } else {
                callback.f(d2, i3);
            }
        }
        return i3 > 0;
    }

    public final boolean x(boolean z, int i, int i2, Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i3 = 0;
        while (s(i, i2)) {
            int size = ((PagingSource.LoadResult.Page) this.f1595a.remove(0)).b().size();
            i3 += size;
            this.f = c() - size;
        }
        this.g = RangesKt.coerceAtLeast(this.g - i3, 0);
        if (i3 > 0) {
            if (z) {
                int d2 = d();
                this.b = d() + i3;
                callback.e(d2, i3);
            } else {
                this.d += i3;
                callback.f(d(), i3);
            }
        }
        return i3 > 0;
    }
}
