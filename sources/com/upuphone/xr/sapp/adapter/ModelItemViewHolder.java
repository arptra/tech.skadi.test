package com.upuphone.xr.sapp.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.xr.sapp.databinding.ItemModelBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/ModelItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/ItemModelBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/databinding/ItemModelBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/ItemModelBinding;", "()Lcom/upuphone/xr/sapp/databinding/ItemModelBinding;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ModelItemViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final ItemModelBinding f6614a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModelItemViewHolder(ItemModelBinding itemModelBinding) {
        super(itemModelBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemModelBinding, "binding");
        this.f6614a = itemModelBinding;
    }

    public final ItemModelBinding a() {
        return this.f6614a;
    }
}
