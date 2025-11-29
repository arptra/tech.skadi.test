package com.chad.library.adapter.base.loadmore;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.R;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/chad/library/adapter/base/loadmore/SimpleLoadMoreView;", "Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "f", "(Landroid/view/ViewGroup;)Landroid/view/View;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "e", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)Landroid/view/View;", "b", "c", "d", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public final class SimpleLoadMoreView extends BaseLoadMoreView {
    public View b(BaseViewHolder baseViewHolder) {
        return baseViewHolder.getView(R.id.load_more_load_complete_view);
    }

    public View c(BaseViewHolder baseViewHolder) {
        return baseViewHolder.getView(R.id.load_more_load_end_view);
    }

    public View d(BaseViewHolder baseViewHolder) {
        return baseViewHolder.getView(R.id.load_more_load_fail_view);
    }

    public View e(BaseViewHolder baseViewHolder) {
        return baseViewHolder.getView(R.id.load_more_loading_view);
    }

    public View f(ViewGroup viewGroup) {
        return AdapterUtilsKt.a(viewGroup, R.layout.brvah_quick_view_load_more);
    }
}
