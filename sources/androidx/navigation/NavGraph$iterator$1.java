package androidx.navigation;

import androidx.collection.SparseArrayCompat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"androidx/navigation/NavGraph$iterator$1", "", "Landroidx/navigation/NavDestination;", "", "hasNext", "()Z", "a", "()Landroidx/navigation/NavDestination;", "", "remove", "()V", "", "I", "index", "b", "Z", "wentToNext", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public final class NavGraph$iterator$1 implements Iterator<NavDestination>, KMutableIterator {

    /* renamed from: a  reason: collision with root package name */
    public int f1487a = -1;
    public boolean b;
    public final /* synthetic */ NavGraph c;

    public NavGraph$iterator$1(NavGraph navGraph) {
        this.c = navGraph;
    }

    /* renamed from: a */
    public NavDestination next() {
        if (hasNext()) {
            this.b = true;
            SparseArrayCompat C = this.c.C();
            int i = this.f1487a + 1;
            this.f1487a = i;
            Object q = C.q(i);
            Intrinsics.checkNotNullExpressionValue(q, "nodes.valueAt(++index)");
            return (NavDestination) q;
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        return this.f1487a + 1 < this.c.C().p();
    }

    public void remove() {
        if (this.b) {
            SparseArrayCompat C = this.c.C();
            ((NavDestination) C.q(this.f1487a)).u((NavGraph) null);
            C.n(this.f1487a);
            this.f1487a--;
            this.b = false;
            return;
        }
        throw new IllegalStateException("You must call next() before you can remove an element".toString());
    }
}
