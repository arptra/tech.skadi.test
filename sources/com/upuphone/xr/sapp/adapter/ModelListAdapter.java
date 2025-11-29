package com.upuphone.xr.sapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.c8.k;
import com.upuphone.xr.sapp.databinding.ItemModelBinding;
import com.upuphone.xr.sapp.entity.ModelInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/ModelListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "()I", "holder", "position", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Lcom/upuphone/xr/sapp/adapter/IModelClickCallback;", "a", "Lcom/upuphone/xr/sapp/adapter/IModelClickCallback;", "modelCallback", "", "Lcom/upuphone/xr/sapp/entity/ModelInfo;", "b", "Ljava/util/List;", "modelList", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nModelListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModelListAdapter.kt\ncom/upuphone/xr/sapp/adapter/ModelListAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,84:1\n1864#2,3:85\n256#3,2:88\n*S KotlinDebug\n*F\n+ 1 ModelListAdapter.kt\ncom/upuphone/xr/sapp/adapter/ModelListAdapter\n*L\n41#1:85,3\n69#1:88,2\n*E\n"})
public final class ModelListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final IModelClickCallback f6615a;
    public List b;

    public static final void h(ModelListAdapter modelListAdapter, ModelInfo modelInfo, View view) {
        Intrinsics.checkNotNullParameter(modelListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(modelInfo, "$item");
        IModelClickCallback iModelClickCallback = modelListAdapter.f6615a;
        if (iModelClickCallback != null) {
            iModelClickCallback.a(modelInfo.getModelID());
        }
    }

    public int getItemCount() {
        return this.b.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ModelInfo modelInfo = (ModelInfo) this.b.get(i);
        ModelItemViewHolder modelItemViewHolder = (ModelItemViewHolder) viewHolder;
        modelItemViewHolder.a().c.setImageDrawable(modelInfo.getLogoRes());
        modelItemViewHolder.a().d.setText(modelInfo.getName());
        TextView textView = modelItemViewHolder.a().e;
        Intrinsics.checkNotNullExpressionValue(textView, "tvRedTips");
        textView.setVisibility(modelInfo.getShowBadge() ? 0 : 8);
        modelItemViewHolder.a().getRoot().setOnClickListener(new k(this, modelInfo));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemModelBinding c = ItemModelBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        return new ModelItemViewHolder(c);
    }
}
