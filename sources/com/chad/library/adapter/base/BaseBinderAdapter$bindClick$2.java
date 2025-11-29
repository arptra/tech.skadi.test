package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 1, 16})
public final class BaseBinderAdapter$bindClick$2 implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseBinderAdapter f2765a;
    public final /* synthetic */ BaseViewHolder b;

    public BaseBinderAdapter$bindClick$2(BaseBinderAdapter baseBinderAdapter, BaseViewHolder baseViewHolder) {
        this.f2765a = baseBinderAdapter;
        this.b = baseViewHolder;
    }

    public final boolean onLongClick(View view) {
        int adapterPosition = this.b.getAdapterPosition();
        if (adapterPosition == -1) {
            return false;
        }
        int M = adapterPosition - this.f2765a.M();
        BaseItemBinder y0 = this.f2765a.y0(this.b.getItemViewType());
        BaseViewHolder baseViewHolder = this.b;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        return y0.l(baseViewHolder, view, this.f2765a.getData().get(M), M);
    }
}
