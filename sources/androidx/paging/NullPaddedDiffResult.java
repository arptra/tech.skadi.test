package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/paging/NullPaddedDiffResult;", "", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diff", "", "hasOverlap", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$DiffResult;Z)V", "a", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "()Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "b", "Z", "()Z", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class NullPaddedDiffResult {

    /* renamed from: a  reason: collision with root package name */
    public final DiffUtil.DiffResult f1561a;
    public final boolean b;

    public NullPaddedDiffResult(DiffUtil.DiffResult diffResult, boolean z) {
        Intrinsics.checkNotNullParameter(diffResult, "diff");
        this.f1561a = diffResult;
        this.b = z;
    }

    public final DiffUtil.DiffResult a() {
        return this.f1561a;
    }

    public final boolean b() {
        return this.b;
    }
}
