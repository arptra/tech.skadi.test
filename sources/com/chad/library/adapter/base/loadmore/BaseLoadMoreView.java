package com.chad.library.adapter.base.loadmore;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\fJ'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0019\u001a\u00020\u0014*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "f", "(Landroid/view/ViewGroup;)Landroid/view/View;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "e", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)Landroid/view/View;", "b", "c", "d", "", "position", "Lcom/chad/library/adapter/base/loadmore/LoadMoreStatus;", "loadMoreStatus", "", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;ILcom/chad/library/adapter/base/loadmore/LoadMoreStatus;)V", "", "visible", "g", "(Landroid/view/View;Z)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class BaseLoadMoreView {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadMoreStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LoadMoreStatus.Complete.ordinal()] = 1;
            iArr[LoadMoreStatus.Loading.ordinal()] = 2;
            iArr[LoadMoreStatus.Fail.ordinal()] = 3;
            iArr[LoadMoreStatus.End.ordinal()] = 4;
        }
    }

    public void a(BaseViewHolder baseViewHolder, int i, LoadMoreStatus loadMoreStatus) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[loadMoreStatus.ordinal()];
        if (i2 == 1) {
            g(e(baseViewHolder), false);
            g(b(baseViewHolder), true);
            g(d(baseViewHolder), false);
            g(c(baseViewHolder), false);
        } else if (i2 == 2) {
            g(e(baseViewHolder), true);
            g(b(baseViewHolder), false);
            g(d(baseViewHolder), false);
            g(c(baseViewHolder), false);
        } else if (i2 == 3) {
            g(e(baseViewHolder), false);
            g(b(baseViewHolder), false);
            g(d(baseViewHolder), true);
            g(c(baseViewHolder), false);
        } else if (i2 == 4) {
            g(e(baseViewHolder), false);
            g(b(baseViewHolder), false);
            g(d(baseViewHolder), false);
            g(c(baseViewHolder), true);
        }
    }

    public abstract View b(BaseViewHolder baseViewHolder);

    public abstract View c(BaseViewHolder baseViewHolder);

    public abstract View d(BaseViewHolder baseViewHolder);

    public abstract View e(BaseViewHolder baseViewHolder);

    public abstract View f(ViewGroup viewGroup);

    public final void g(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }
}
