package com.upuphone.xr.sapp.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.c8.l;
import com.upuphone.xr.sapp.databinding.ItemEditScheduleColorBinding;
import flyme.support.v7.widget.MzRecyclerView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\r2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R'\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/ScheduleColoAdapter;", "Lflyme/support/v7/widget/MzRecyclerView$Adapter;", "Lcom/upuphone/xr/sapp/adapter/ScheduleColoAdapter$ScheduleColoAdapterHolder;", "<init>", "()V", "Landroid/view/ViewGroup;", "group", "", "p1", "l", "(Landroid/view/ViewGroup;I)Lcom/upuphone/xr/sapp/adapter/ScheduleColoAdapter$ScheduleColoAdapterHolder;", "holder", "position", "", "j", "(Lcom/upuphone/xr/sapp/adapter/ScheduleColoAdapter$ScheduleColoAdapterHolder;I)V", "getItemCount", "()I", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "h", "()Ljava/util/ArrayList;", "adapterColor", "b", "I", "i", "m", "(I)V", "selectIndex", "ScheduleColoAdapterHolder", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleColoAdapter extends MzRecyclerView.Adapter<ScheduleColoAdapterHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f6618a = CollectionsKt.arrayListOf("#FA5700", "#EB9C00", "#289F53", "#00A3A3", "#0D57D9", "#651FD6", "#FF9F6B", "#FFD35C", "#68D991", "#4CD4D4", "#639BFD", "#A579EC");
    public int b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/ScheduleColoAdapter$ScheduleColoAdapterHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/ItemEditScheduleColorBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/adapter/ScheduleColoAdapter;Lcom/upuphone/xr/sapp/databinding/ItemEditScheduleColorBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/ItemEditScheduleColorBinding;", "()Lcom/upuphone/xr/sapp/databinding/ItemEditScheduleColorBinding;", "setBinding", "(Lcom/upuphone/xr/sapp/databinding/ItemEditScheduleColorBinding;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class ScheduleColoAdapterHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ItemEditScheduleColorBinding f6619a;
        public final /* synthetic */ ScheduleColoAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ScheduleColoAdapterHolder(ScheduleColoAdapter scheduleColoAdapter, ItemEditScheduleColorBinding itemEditScheduleColorBinding) {
            super(itemEditScheduleColorBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemEditScheduleColorBinding, "binding");
            this.b = scheduleColoAdapter;
            this.f6619a = itemEditScheduleColorBinding;
        }

        public final ItemEditScheduleColorBinding a() {
            return this.f6619a;
        }
    }

    public static final void k(ScheduleColoAdapter scheduleColoAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(scheduleColoAdapter, "this$0");
        scheduleColoAdapter.b = i;
        scheduleColoAdapter.notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f6618a.size();
    }

    public final ArrayList h() {
        return this.f6618a;
    }

    public final int i() {
        return this.b;
    }

    /* renamed from: j */
    public void onBindViewHolder(ScheduleColoAdapterHolder scheduleColoAdapterHolder, int i) {
        Intrinsics.checkNotNullParameter(scheduleColoAdapterHolder, "holder");
        super.onBindViewHolder(scheduleColoAdapterHolder, i);
        scheduleColoAdapterHolder.a().b.setColor(Color.parseColor((String) this.f6618a.get(i)));
        scheduleColoAdapterHolder.a().b.setNeedShowOuter(i == this.b);
        scheduleColoAdapterHolder.a().getRoot().setOnClickListener(new l(this, i));
    }

    /* renamed from: l */
    public ScheduleColoAdapterHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ItemEditScheduleColorBinding c = ItemEditScheduleColorBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        return new ScheduleColoAdapterHolder(this, c);
    }

    public final void m(int i) {
        this.b = i;
    }
}
