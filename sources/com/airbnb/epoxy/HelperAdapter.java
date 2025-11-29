package com.airbnb.epoxy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/airbnb/epoxy/HelperAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/airbnb/epoxy/EpoxyViewHolder;", "<init>", "()V", "Landroid/view/ViewParent;", "modelGroupParent", "Lcom/airbnb/epoxy/EpoxyModel;", "model", "Landroid/view/ViewGroup;", "parent", "", "viewType", "g", "(Landroid/view/ViewParent;Lcom/airbnb/epoxy/EpoxyModel;Landroid/view/ViewGroup;I)Lcom/airbnb/epoxy/EpoxyViewHolder;", "i", "(Landroid/view/ViewGroup;I)Lcom/airbnb/epoxy/EpoxyViewHolder;", "holder", "position", "", "h", "(Lcom/airbnb/epoxy/EpoxyViewHolder;I)V", "getItemCount", "()I", "a", "Lcom/airbnb/epoxy/EpoxyModel;", "b", "Landroid/view/ViewParent;", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
final class HelperAdapter extends RecyclerView.Adapter<EpoxyViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public EpoxyModel f2306a;
    public ViewParent b;

    public final EpoxyViewHolder g(ViewParent viewParent, EpoxyModel epoxyModel, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewParent, "modelGroupParent");
        Intrinsics.checkNotNullParameter(epoxyModel, "model");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f2306a = epoxyModel;
        this.b = viewParent;
        RecyclerView.ViewHolder createViewHolder = createViewHolder(viewGroup, i);
        Intrinsics.checkNotNullExpressionValue(createViewHolder, "createViewHolder(parent, viewType)");
        EpoxyViewHolder epoxyViewHolder = (EpoxyViewHolder) createViewHolder;
        this.f2306a = null;
        this.b = null;
        return epoxyViewHolder;
    }

    public int getItemCount() {
        return 1;
    }

    /* renamed from: h */
    public void onBindViewHolder(EpoxyViewHolder epoxyViewHolder, int i) {
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "holder");
    }

    /* renamed from: i */
    public EpoxyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ViewParent viewParent = this.b;
        EpoxyModel epoxyModel = this.f2306a;
        Intrinsics.checkNotNull(epoxyModel);
        View w = epoxyModel.w(viewGroup);
        EpoxyModel epoxyModel2 = this.f2306a;
        Intrinsics.checkNotNull(epoxyModel2);
        return new EpoxyViewHolder(viewParent, w, epoxyModel2.P());
    }
}
