package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
public final class BaseBinderAdapter$bindClick$1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseBinderAdapter f2764a;
    public final /* synthetic */ BaseViewHolder b;

    public BaseBinderAdapter$bindClick$1(BaseBinderAdapter baseBinderAdapter, BaseViewHolder baseViewHolder) {
        this.f2764a = baseBinderAdapter;
        this.b = baseViewHolder;
    }

    public final void onClick(View view) {
        int adapterPosition = this.b.getAdapterPosition();
        if (adapterPosition != -1) {
            int M = adapterPosition - this.f2764a.M();
            BaseItemBinder y0 = this.f2764a.y0(this.b.getItemViewType());
            BaseViewHolder baseViewHolder = this.b;
            Intrinsics.checkExpressionValueIsNotNull(view, "it");
            y0.i(baseViewHolder, view, this.f2764a.getData().get(M), M);
        }
    }
}
