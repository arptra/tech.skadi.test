package com.chad.library.adapter.base.binder;

import android.view.ViewGroup;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/chad/library/adapter/base/binder/QuickItemBinder;", "T", "Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "", "p", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "j", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class QuickItemBinder<T> extends BaseItemBinder<T, BaseViewHolder> {
    public BaseViewHolder j(ViewGroup viewGroup, int i) {
        return new BaseViewHolder(AdapterUtilsKt.a(viewGroup, p()));
    }

    public abstract int p();
}
