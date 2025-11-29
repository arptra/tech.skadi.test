package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"androidx/paging/NullPaddedListDiffHelperKt$computeDiff$diffResult$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NullPaddedListDiffHelperKt$computeDiff$diffResult$1 extends DiffUtil.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NullPaddedList f1562a;
    public final /* synthetic */ NullPaddedList b;
    public final /* synthetic */ DiffUtil.ItemCallback c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public NullPaddedListDiffHelperKt$computeDiff$diffResult$1(NullPaddedList nullPaddedList, NullPaddedList nullPaddedList2, DiffUtil.ItemCallback itemCallback, int i, int i2) {
        this.f1562a = nullPaddedList;
        this.b = nullPaddedList2;
        this.c = itemCallback;
        this.d = i;
        this.e = i2;
    }

    public boolean areContentsTheSame(int i, int i2) {
        Object f = this.f1562a.f(i);
        Object f2 = this.b.f(i2);
        if (f == f2) {
            return true;
        }
        return this.c.areContentsTheSame(f, f2);
    }

    public boolean areItemsTheSame(int i, int i2) {
        Object f = this.f1562a.f(i);
        Object f2 = this.b.f(i2);
        if (f == f2) {
            return true;
        }
        return this.c.areItemsTheSame(f, f2);
    }

    public Object getChangePayload(int i, int i2) {
        Object f = this.f1562a.f(i);
        Object f2 = this.b.f(i2);
        return f == f2 ? Boolean.TRUE : this.c.getChangePayload(f, f2);
    }

    public int getNewListSize() {
        return this.e;
    }

    public int getOldListSize() {
        return this.d;
    }
}
