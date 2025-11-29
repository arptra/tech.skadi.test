package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/window/layout/WindowMetrics;", "", "Landroidx/window/core/Bounds;", "_bounds", "<init>", "(Landroidx/window/core/Bounds;)V", "Landroid/graphics/Rect;", "bounds", "(Landroid/graphics/Rect;)V", "", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "a", "Landroidx/window/core/Bounds;", "()Landroid/graphics/Rect;", "window_release"}, k = 1, mv = {1, 6, 0})
public final class WindowMetrics {

    /* renamed from: a  reason: collision with root package name */
    public final Bounds f2043a;

    public WindowMetrics(Bounds bounds) {
        Intrinsics.checkNotNullParameter(bounds, "_bounds");
        this.f2043a = bounds;
    }

    public final Rect a() {
        return this.f2043a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) WindowMetrics.class, (Object) obj.getClass())) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.f2043a, (Object) ((WindowMetrics) obj).f2043a);
    }

    public int hashCode() {
        return this.f2043a.hashCode();
    }

    public String toString() {
        return "WindowMetrics { bounds: " + a() + " }";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WindowMetrics(Rect rect) {
        this(new Bounds(rect));
        Intrinsics.checkNotNullParameter(rect, "bounds");
    }
}
