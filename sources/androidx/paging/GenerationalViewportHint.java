package androidx.paging;

import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/paging/GenerationalViewportHint;", "", "", "generationId", "Landroidx/paging/ViewportHint;", "hint", "<init>", "(ILandroidx/paging/ViewportHint;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "Landroidx/paging/ViewportHint;", "()Landroidx/paging/ViewportHint;", "paging-common"}, k = 1, mv = {1, 8, 0})
@VisibleForTesting
public final class GenerationalViewportHint {

    /* renamed from: a  reason: collision with root package name */
    public final int f1539a;
    public final ViewportHint b;

    public GenerationalViewportHint(int i, ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(viewportHint, "hint");
        this.f1539a = i;
        this.b = viewportHint;
    }

    public final int a() {
        return this.f1539a;
    }

    public final ViewportHint b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenerationalViewportHint)) {
            return false;
        }
        GenerationalViewportHint generationalViewportHint = (GenerationalViewportHint) obj;
        return this.f1539a == generationalViewportHint.f1539a && Intrinsics.areEqual((Object) this.b, (Object) generationalViewportHint.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.f1539a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "GenerationalViewportHint(generationId=" + this.f1539a + ", hint=" + this.b + ')';
    }
}
