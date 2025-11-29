package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 1, 16})
public final class BaseProviderMultiAdapter$bindClick$2 implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseProviderMultiAdapter f2769a;
    public final /* synthetic */ BaseViewHolder b;

    public BaseProviderMultiAdapter$bindClick$2(BaseProviderMultiAdapter baseProviderMultiAdapter, BaseViewHolder baseViewHolder) {
        this.f2769a = baseProviderMultiAdapter;
        this.b = baseViewHolder;
    }

    public final boolean onLongClick(View view) {
        int adapterPosition = this.b.getAdapterPosition();
        if (adapterPosition == -1) {
            return false;
        }
        int M = adapterPosition - this.f2769a.M();
        int itemViewType = this.b.getItemViewType();
        BaseViewHolder baseViewHolder = this.b;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        return ((BaseItemProvider) this.f2769a.A0().get(itemViewType)).n(baseViewHolder, view, this.f2769a.getData().get(M), M);
    }
}
