package com.chad.library.adapter.base;

import android.view.ViewGroup;
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004J\u0015\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00028\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/chad/library/adapter/base/BaseDelegateMultiAdapter;", "T", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "VH", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/delegate/BaseMultiTypeDelegate;", "u0", "()Lcom/chad/library/adapter/base/delegate/BaseMultiTypeDelegate;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "d0", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "position", "J", "(I)I", "C", "Lcom/chad/library/adapter/base/delegate/BaseMultiTypeDelegate;", "mMultiTypeDelegate", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class BaseDelegateMultiAdapter<T, VH extends BaseViewHolder> extends BaseQuickAdapter<T, VH> {
    public BaseMultiTypeDelegate C;

    public int J(int i) {
        BaseMultiTypeDelegate u0 = u0();
        if (u0 != null) {
            return u0.a(getData(), i);
        }
        throw new IllegalStateException("Please use setMultiTypeDelegate first!".toString());
    }

    public BaseViewHolder d0(ViewGroup viewGroup, int i) {
        BaseMultiTypeDelegate u0 = u0();
        if (u0 != null) {
            return E(viewGroup, u0.b(i));
        }
        throw new IllegalStateException("Please use setMultiTypeDelegate first!".toString());
    }

    public final BaseMultiTypeDelegate u0() {
        return this.C;
    }
}
