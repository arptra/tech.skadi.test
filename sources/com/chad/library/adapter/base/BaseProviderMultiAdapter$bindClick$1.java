package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
public final class BaseProviderMultiAdapter$bindClick$1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseProviderMultiAdapter f2768a;
    public final /* synthetic */ BaseViewHolder b;

    public BaseProviderMultiAdapter$bindClick$1(BaseProviderMultiAdapter baseProviderMultiAdapter, BaseViewHolder baseViewHolder) {
        this.f2768a = baseProviderMultiAdapter;
        this.b = baseViewHolder;
    }

    public final void onClick(View view) {
        int adapterPosition = this.b.getAdapterPosition();
        if (adapterPosition != -1) {
            int M = adapterPosition - this.f2768a.M();
            int itemViewType = this.b.getItemViewType();
            BaseViewHolder baseViewHolder = this.b;
            Intrinsics.checkExpressionValueIsNotNull(view, "it");
            ((BaseItemProvider) this.f2768a.A0().get(itemViewType)).l(baseViewHolder, view, this.f2768a.getData().get(M), M);
        }
    }
}
