package com.upuphone.xr.sapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.c8.d;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.entity.FeedbackCommonInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\"B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00020\u00102\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R?\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/FeedbackCommonAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/xr/sapp/adapter/FeedbackCommonAdapter$ViewHolder;", "", "Lcom/upuphone/xr/sapp/entity/FeedbackCommonInfo;", "list", "<init>", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "j", "(Landroid/view/ViewGroup;I)Lcom/upuphone/xr/sapp/adapter/FeedbackCommonAdapter$ViewHolder;", "holder", "position", "", "h", "(Lcom/upuphone/xr/sapp/adapter/FeedbackCommonAdapter$ViewHolder;I)V", "getItemCount", "()I", "a", "Ljava/util/List;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "b", "Lkotlin/jvm/functions/Function1;", "getItemClick", "()Lkotlin/jvm/functions/Function1;", "k", "(Lkotlin/jvm/functions/Function1;)V", "itemClick", "ViewHolder", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FeedbackCommonAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final List f6607a;
    public Function1 b;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0007\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/FeedbackCommonAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/upuphone/xr/sapp/adapter/FeedbackCommonAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "b", "()Landroid/widget/ImageView;", "setIcImg", "(Landroid/widget/ImageView;)V", "icImg", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "c", "()Landroid/widget/TextView;", "setNameTv", "(Landroid/widget/TextView;)V", "nameTv", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "()Landroid/widget/RelativeLayout;", "setBgLayout", "(Landroid/widget/RelativeLayout;)V", "bgLayout", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f6608a;
        public TextView b;
        public RelativeLayout c;
        public final /* synthetic */ FeedbackCommonAdapter d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(FeedbackCommonAdapter feedbackCommonAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.d = feedbackCommonAdapter;
            View findViewById = view.findViewById(R.id.ic_img);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.f6608a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.name_tv);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.bg_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.c = (RelativeLayout) findViewById3;
        }

        public final RelativeLayout a() {
            return this.c;
        }

        public final ImageView b() {
            return this.f6608a;
        }

        public final TextView c() {
            return this.b;
        }
    }

    public FeedbackCommonAdapter(List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.f6607a = list;
    }

    public static final void i(FeedbackCommonAdapter feedbackCommonAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(feedbackCommonAdapter, "this$0");
        int size = feedbackCommonAdapter.f6607a.size();
        int i2 = 0;
        while (i2 < size) {
            ((FeedbackCommonInfo) feedbackCommonAdapter.f6607a.get(i2)).setSelect(i2 == i);
            i2++;
        }
        Function1 function1 = feedbackCommonAdapter.b;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i));
        }
        feedbackCommonAdapter.notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f6607a.size();
    }

    /* renamed from: h */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        FeedbackCommonInfo feedbackCommonInfo = (FeedbackCommonInfo) this.f6607a.get(i);
        viewHolder.a().setSelected(feedbackCommonInfo.isSelect());
        viewHolder.c().setText(feedbackCommonInfo.getName());
        viewHolder.b().setImageResource(feedbackCommonInfo.getIcon());
        viewHolder.a().setOnClickListener(new d(this, i));
    }

    /* renamed from: j */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feedback_common_item_layout, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(this, inflate);
    }

    public final void k(Function1 function1) {
        this.b = function1;
    }
}
