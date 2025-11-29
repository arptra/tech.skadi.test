package com.upuphone.xr.sapp.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.c8.m;
import com.honey.account.c8.n;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.ItemScheduleDisplayBinding;
import com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager;
import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;
import com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType;
import flyme.support.v7.widget.MzRecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001&B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00020\u00102\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0007R?\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/ScheduleDisplayAdapter;", "Lflyme/support/v7/widget/MzRecyclerView$Adapter;", "Lcom/upuphone/xr/sapp/adapter/ScheduleDisplayAdapter$ScheduleDisplayAdapterHolder;", "", "Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;", "data", "<init>", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "p1", "l", "(Landroid/view/ViewGroup;I)Lcom/upuphone/xr/sapp/adapter/ScheduleDisplayAdapter$ScheduleDisplayAdapterHolder;", "holder", "position", "", "i", "(Lcom/upuphone/xr/sapp/adapter/ScheduleDisplayAdapter$ScheduleDisplayAdapterHolder;I)V", "getItemCount", "()I", "a", "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "b", "Lkotlin/jvm/functions/Function1;", "getItemClick", "()Lkotlin/jvm/functions/Function1;", "m", "(Lkotlin/jvm/functions/Function1;)V", "itemClick", "ScheduleDisplayAdapterHolder", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleDisplayAdapter extends MzRecyclerView.Adapter<ScheduleDisplayAdapterHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List f6620a;
    public Function1 b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/ScheduleDisplayAdapter$ScheduleDisplayAdapterHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/ItemScheduleDisplayBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/adapter/ScheduleDisplayAdapter;Lcom/upuphone/xr/sapp/databinding/ItemScheduleDisplayBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/ItemScheduleDisplayBinding;", "()Lcom/upuphone/xr/sapp/databinding/ItemScheduleDisplayBinding;", "setBinding", "(Lcom/upuphone/xr/sapp/databinding/ItemScheduleDisplayBinding;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class ScheduleDisplayAdapterHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ItemScheduleDisplayBinding f6621a;
        public final /* synthetic */ ScheduleDisplayAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ScheduleDisplayAdapterHolder(ScheduleDisplayAdapter scheduleDisplayAdapter, ItemScheduleDisplayBinding itemScheduleDisplayBinding) {
            super(itemScheduleDisplayBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemScheduleDisplayBinding, "binding");
            this.b = scheduleDisplayAdapter;
            this.f6621a = itemScheduleDisplayBinding;
        }

        public final ItemScheduleDisplayBinding a() {
            return this.f6621a;
        }
    }

    public ScheduleDisplayAdapter(List list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f6620a = list;
    }

    public static final void j(LocalScheduleModel localScheduleModel, ScheduleDisplayAdapter scheduleDisplayAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(localScheduleModel, "$localScheduleModel");
        Intrinsics.checkNotNullParameter(scheduleDisplayAdapter, "this$0");
        ScheduleAccountManager.f7776a.h(localScheduleModel);
        localScheduleModel.i(!localScheduleModel.f());
        scheduleDisplayAdapter.notifyItemChanged(i);
    }

    public static final void k(LocalScheduleModel localScheduleModel, ScheduleDisplayAdapter scheduleDisplayAdapter, View view) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(localScheduleModel, "$localScheduleModel");
        Intrinsics.checkNotNullParameter(scheduleDisplayAdapter, "this$0");
        if (localScheduleModel.e() != SubscribeType.calendar && (function1 = scheduleDisplayAdapter.b) != null) {
            function1.invoke(localScheduleModel.c());
        }
    }

    public int getItemCount() {
        return this.f6620a.size();
    }

    /* renamed from: i */
    public void onBindViewHolder(ScheduleDisplayAdapterHolder scheduleDisplayAdapterHolder, int i) {
        Intrinsics.checkNotNullParameter(scheduleDisplayAdapterHolder, "holder");
        super.onBindViewHolder(scheduleDisplayAdapterHolder, i);
        LocalScheduleModel localScheduleModel = (LocalScheduleModel) this.f6620a.get(i);
        scheduleDisplayAdapterHolder.a().c.setBackgroundColor(Color.parseColor(localScheduleModel.a()));
        scheduleDisplayAdapterHolder.a().d.setImageResource(localScheduleModel.f() ? R.drawable.schedule_display_selected : R.drawable.schedule_display_unselected);
        scheduleDisplayAdapterHolder.a().b.setText(localScheduleModel.b());
        scheduleDisplayAdapterHolder.a().d.setOnClickListener(new m(localScheduleModel, this, i));
        scheduleDisplayAdapterHolder.a().getRoot().setOnClickListener(new n(localScheduleModel, this));
    }

    /* renamed from: l */
    public ScheduleDisplayAdapterHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemScheduleDisplayBinding c = ItemScheduleDisplayBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        return new ScheduleDisplayAdapterHolder(this, c);
    }

    public final void m(Function1 function1) {
        this.b = function1;
    }
}
