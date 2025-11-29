package androidx.core.graphics;

import android.graphics.Rect;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"androidx/core/graphics/RegionKt$iterator$1", "", "Landroid/graphics/Rect;", "", "hasNext", "()Z", "a", "()Landroid/graphics/Rect;", "Landroid/graphics/RegionIterator;", "Landroid/graphics/RegionIterator;", "iterator", "b", "Landroid/graphics/Rect;", "rect", "c", "Z", "hasMore", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class RegionKt$iterator$1 implements Iterator<Rect>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    public final RegionIterator f717a;
    public final Rect b;
    public boolean c;

    /* renamed from: a */
    public Rect next() {
        if (this.c) {
            Rect rect = new Rect(this.b);
            this.c = this.f717a.next(this.b);
            return rect;
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean hasNext() {
        return this.c;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
