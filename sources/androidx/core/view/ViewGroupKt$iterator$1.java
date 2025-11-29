package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\f¨\u0006\u000e"}, d2 = {"androidx/core/view/ViewGroupKt$iterator$1", "", "Landroid/view/View;", "", "hasNext", "()Z", "a", "()Landroid/view/View;", "", "remove", "()V", "", "I", "index", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class ViewGroupKt$iterator$1 implements Iterator<View>, KMutableIterator {

    /* renamed from: a  reason: collision with root package name */
    public int f894a;
    public final /* synthetic */ ViewGroup b;

    public ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.b = viewGroup;
    }

    /* renamed from: a */
    public View next() {
        ViewGroup viewGroup = this.b;
        int i = this.f894a;
        this.f894a = i + 1;
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean hasNext() {
        return this.f894a < this.b.getChildCount();
    }

    public void remove() {
        ViewGroup viewGroup = this.b;
        int i = this.f894a - 1;
        this.f894a = i;
        viewGroup.removeViewAt(i);
    }
}
