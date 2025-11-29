package androidx.paging;

import androidx.paging.ViewportHint;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\b\b\u0018\u0000 !*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001)B5\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bB\u001f\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\n\u0010\rJ5\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u001bR\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b&\u0010%¨\u0006*"}, d2 = {"Landroidx/paging/TransformablePage;", "", "T", "", "originalPageOffsets", "", "data", "", "hintOriginalPageOffset", "hintOriginalIndices", "<init>", "([ILjava/util/List;ILjava/util/List;)V", "originalPageOffset", "(ILjava/util/List;)V", "index", "presentedItemsBefore", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "Landroidx/paging/ViewportHint$Access;", "f", "(IIIII)Landroidx/paging/ViewportHint$Access;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "[I", "e", "()[I", "b", "Ljava/util/List;", "()Ljava/util/List;", "c", "I", "d", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class TransformablePage<T> {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public static final TransformablePage f = new TransformablePage(0, CollectionsKt.emptyList());

    /* renamed from: a  reason: collision with root package name */
    public final int[] f1638a;
    public final List b;
    public final int c;
    public final List d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/paging/TransformablePage$Companion;", "", "<init>", "()V", "Landroidx/paging/TransformablePage;", "EMPTY_INITIAL_PAGE", "Landroidx/paging/TransformablePage;", "a", "()Landroidx/paging/TransformablePage;", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransformablePage a() {
            return TransformablePage.f;
        }

        public Companion() {
        }
    }

    public TransformablePage(int[] iArr, List list, int i, List list2) {
        Intrinsics.checkNotNullParameter(iArr, "originalPageOffsets");
        Intrinsics.checkNotNullParameter(list, "data");
        this.f1638a = iArr;
        this.b = list;
        this.c = i;
        this.d = list2;
        if (!(!(iArr.length == 0))) {
            throw new IllegalArgumentException("originalPageOffsets cannot be empty when constructing TransformablePage".toString());
        } else if (list2 != null && list2.size() != list.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("If originalIndices (size = ");
            Intrinsics.checkNotNull(list2);
            sb.append(list2.size());
            sb.append(") is provided, it must be same length as data (size = ");
            sb.append(list.size());
            sb.append(')');
            throw new IllegalArgumentException(sb.toString().toString());
        }
    }

    public final List b() {
        return this.b;
    }

    public final List c() {
        return this.d;
    }

    public final int d() {
        return this.c;
    }

    public final int[] e() {
        return this.f1638a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) TransformablePage.class, (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.paging.TransformablePage<*>");
        TransformablePage transformablePage = (TransformablePage) obj;
        return Arrays.equals(this.f1638a, transformablePage.f1638a) && Intrinsics.areEqual((Object) this.b, (Object) transformablePage.b) && this.c == transformablePage.c && Intrinsics.areEqual((Object) this.d, (Object) transformablePage.d);
    }

    public final ViewportHint.Access f(int i, int i2, int i3, int i4, int i5) {
        IntRange indices;
        int i6 = this.c;
        List list = this.d;
        if (!(list == null || (indices = CollectionsKt.getIndices(list)) == null || !indices.contains(i))) {
            i = ((Number) this.d.get(i)).intValue();
        }
        return new ViewportHint.Access(i6, i, i2, i3, i4, i5);
    }

    public int hashCode() {
        int hashCode = ((((Arrays.hashCode(this.f1638a) * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        List list = this.d;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "TransformablePage(originalPageOffsets=" + Arrays.toString(this.f1638a) + ", data=" + this.b + ", hintOriginalPageOffset=" + this.c + ", hintOriginalIndices=" + this.d + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransformablePage(int i, List list) {
        this(new int[]{i}, list, i, (List) null);
        Intrinsics.checkNotNullParameter(list, "data");
    }
}
