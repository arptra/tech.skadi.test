package com.upuphone.xr.sapp.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.c8.o;
import com.honey.account.c8.p;
import com.honey.account.c8.q;
import com.honey.account.c8.r;
import com.honey.account.c8.s;
import com.honey.account.c8.t;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.RecyclerItemStandbyComponentBinding;
import com.upuphone.xr.sapp.databinding.RecyclerItemStandbyComponentMaxBinding;
import com.upuphone.xr.sapp.entity.StandbyWidgetInfo;
import com.upuphone.xr.sapp.view.StandbyComponentBottomSheet;
import com.upuphone.xr.sapp.view.StandbyComponentChange;
import flyme.support.v7.app.AlertDialog;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002CDBM\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u001cH\u0002¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00104\u001a\u00020\t8\u0002XD¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002XD¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010:\u001a\u00020\t8\u0002XD¢\u0006\u0006\n\u0004\b9\u00103R\u0014\u0010<\u001a\u00020\t8\u0002XD¢\u0006\u0006\n\u0004\b;\u00103R\u0014\u0010@\u001a\u00020=8\u0002XD¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020=8\u0002XD¢\u0006\u0006\n\u0004\bA\u0010?¨\u0006E"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/StandbyWidgetRecyclerviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "context", "Ljava/util/LinkedList;", "Lcom/upuphone/xr/sapp/entity/StandbyWidgetInfo;", "widgetList", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "widgetsMap", "Lcom/upuphone/xr/sapp/view/StandbyComponentChange;", "componentChange", "<init>", "(Landroid/content/Context;Ljava/util/LinkedList;Ljava/util/LinkedHashMap;Lcom/upuphone/xr/sapp/view/StandbyComponentChange;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "()I", "position", "getItemViewType", "(I)I", "holder", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/widget/CompoundButton;", "button", "", "m", "(Landroid/widget/CompoundButton;)Z", "Landroid/view/View;", "view", "s", "(Landroid/view/View;)V", "t", "()V", "a", "Landroid/content/Context;", "b", "Ljava/util/LinkedList;", "c", "Ljava/util/LinkedHashMap;", "d", "Lcom/upuphone/xr/sapp/view/StandbyComponentChange;", "e", "Ljava/lang/String;", "TAG", "", "f", "J", "animationDuration", "g", "scaleX", "h", "scaleY", "", "i", "F", "animationFrom", "j", "animationTo", "StandbyViewHolder", "StandbyViewHolderMaxWidth", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class StandbyWidgetRecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6622a;
    public final LinkedList b;
    public final LinkedHashMap c;
    public StandbyComponentChange d;
    public final String e = "StandbyWidgetRecyclerviewAdapter";
    public final long f = 200;
    public final String g = "scaleX";
    public final String h = "scaleY";
    public final float i = 0.8f;
    public final float j = 1.0f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/StandbyWidgetRecyclerviewAdapter$StandbyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/RecyclerItemStandbyComponentBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/adapter/StandbyWidgetRecyclerviewAdapter;Lcom/upuphone/xr/sapp/databinding/RecyclerItemStandbyComponentBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/RecyclerItemStandbyComponentBinding;", "()Lcom/upuphone/xr/sapp/databinding/RecyclerItemStandbyComponentBinding;", "setBinding", "(Lcom/upuphone/xr/sapp/databinding/RecyclerItemStandbyComponentBinding;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class StandbyViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerItemStandbyComponentBinding f6623a;
        public final /* synthetic */ StandbyWidgetRecyclerviewAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StandbyViewHolder(StandbyWidgetRecyclerviewAdapter standbyWidgetRecyclerviewAdapter, RecyclerItemStandbyComponentBinding recyclerItemStandbyComponentBinding) {
            super(recyclerItemStandbyComponentBinding.getRoot());
            Intrinsics.checkNotNullParameter(recyclerItemStandbyComponentBinding, "binding");
            this.b = standbyWidgetRecyclerviewAdapter;
            this.f6623a = recyclerItemStandbyComponentBinding;
        }

        public final RecyclerItemStandbyComponentBinding a() {
            return this.f6623a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/StandbyWidgetRecyclerviewAdapter$StandbyViewHolderMaxWidth;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/RecyclerItemStandbyComponentMaxBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/adapter/StandbyWidgetRecyclerviewAdapter;Lcom/upuphone/xr/sapp/databinding/RecyclerItemStandbyComponentMaxBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/RecyclerItemStandbyComponentMaxBinding;", "()Lcom/upuphone/xr/sapp/databinding/RecyclerItemStandbyComponentMaxBinding;", "setBinding", "(Lcom/upuphone/xr/sapp/databinding/RecyclerItemStandbyComponentMaxBinding;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class StandbyViewHolderMaxWidth extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerItemStandbyComponentMaxBinding f6624a;
        public final /* synthetic */ StandbyWidgetRecyclerviewAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StandbyViewHolderMaxWidth(StandbyWidgetRecyclerviewAdapter standbyWidgetRecyclerviewAdapter, RecyclerItemStandbyComponentMaxBinding recyclerItemStandbyComponentMaxBinding) {
            super(recyclerItemStandbyComponentMaxBinding.getRoot());
            Intrinsics.checkNotNullParameter(recyclerItemStandbyComponentMaxBinding, "binding");
            this.b = standbyWidgetRecyclerviewAdapter;
            this.f6624a = recyclerItemStandbyComponentMaxBinding;
        }

        public final RecyclerItemStandbyComponentMaxBinding a() {
            return this.f6624a;
        }
    }

    public StandbyWidgetRecyclerviewAdapter(Context context, LinkedList linkedList, LinkedHashMap linkedHashMap, StandbyComponentChange standbyComponentChange) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(linkedList, "widgetList");
        Intrinsics.checkNotNullParameter(linkedHashMap, "widgetsMap");
        this.f6622a = context;
        this.b = linkedList;
        this.c = linkedHashMap;
        this.d = standbyComponentChange;
    }

    public static final void n(Function2 function2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        function2.invoke(obj, obj2);
    }

    public static final void o(StandbyWidgetRecyclerviewAdapter standbyWidgetRecyclerviewAdapter, View view) {
        Intrinsics.checkNotNullParameter(standbyWidgetRecyclerviewAdapter, "this$0");
        Intrinsics.checkNotNull(view);
        standbyWidgetRecyclerviewAdapter.s(view);
    }

    public static final void p(StandbyWidgetRecyclerviewAdapter standbyWidgetRecyclerviewAdapter, int i2, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(standbyWidgetRecyclerviewAdapter, "this$0");
        ((StandbyWidgetInfo) standbyWidgetRecyclerviewAdapter.b.get(i2)).setChecked(z);
        if (z) {
            Intrinsics.checkNotNull(compoundButton);
            if (standbyWidgetRecyclerviewAdapter.m(compoundButton)) {
                standbyWidgetRecyclerviewAdapter.c.put(((StandbyWidgetInfo) standbyWidgetRecyclerviewAdapter.b.get(i2)).getWidgetName(), 1);
                ULog.Delegate delegate = ULog.f6446a;
                String str = standbyWidgetRecyclerviewAdapter.e;
                LinkedHashMap linkedHashMap = standbyWidgetRecyclerviewAdapter.c;
                delegate.a(str, "widgetsMap：" + linkedHashMap);
                StandbyComponentChange standbyComponentChange = standbyWidgetRecyclerviewAdapter.d;
                if (standbyComponentChange != null) {
                    standbyComponentChange.a(standbyWidgetRecyclerviewAdapter.c, false, ((StandbyWidgetInfo) standbyWidgetRecyclerviewAdapter.b.get(i2)).getWidgetName());
                    return;
                }
                return;
            }
            return;
        }
        standbyWidgetRecyclerviewAdapter.c.remove(((StandbyWidgetInfo) standbyWidgetRecyclerviewAdapter.b.get(i2)).getWidgetName());
        ULog.Delegate delegate2 = ULog.f6446a;
        String str2 = standbyWidgetRecyclerviewAdapter.e;
        LinkedHashMap linkedHashMap2 = standbyWidgetRecyclerviewAdapter.c;
        delegate2.a(str2, "widgetsMap:" + linkedHashMap2);
        StandbyComponentChange standbyComponentChange2 = standbyWidgetRecyclerviewAdapter.d;
        if (standbyComponentChange2 != null) {
            standbyComponentChange2.a(standbyWidgetRecyclerviewAdapter.c, true, ((StandbyWidgetInfo) standbyWidgetRecyclerviewAdapter.b.get(i2)).getWidgetName());
        }
    }

    public static final void q(StandbyWidgetRecyclerviewAdapter standbyWidgetRecyclerviewAdapter, View view) {
        Intrinsics.checkNotNullParameter(standbyWidgetRecyclerviewAdapter, "this$0");
        Intrinsics.checkNotNull(view);
        standbyWidgetRecyclerviewAdapter.s(view);
    }

    public static final void r(StandbyWidgetRecyclerviewAdapter standbyWidgetRecyclerviewAdapter, int i2, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(standbyWidgetRecyclerviewAdapter, "this$0");
        ((StandbyWidgetInfo) standbyWidgetRecyclerviewAdapter.b.get(i2)).setChecked(z);
        if (z) {
            Intrinsics.checkNotNull(compoundButton);
            if (!standbyWidgetRecyclerviewAdapter.m(compoundButton)) {
                return;
            }
            if (!standbyWidgetRecyclerviewAdapter.c.isEmpty()) {
                compoundButton.setChecked(false);
                standbyWidgetRecyclerviewAdapter.t();
                return;
            }
            standbyWidgetRecyclerviewAdapter.c.put(((StandbyWidgetInfo) standbyWidgetRecyclerviewAdapter.b.get(i2)).getWidgetName(), 2);
            ULog.Delegate delegate = ULog.f6446a;
            String str = standbyWidgetRecyclerviewAdapter.e;
            LinkedHashMap linkedHashMap = standbyWidgetRecyclerviewAdapter.c;
            delegate.a(str, "widgetsMap：" + linkedHashMap);
            StandbyComponentChange standbyComponentChange = standbyWidgetRecyclerviewAdapter.d;
            if (standbyComponentChange != null) {
                standbyComponentChange.a(standbyWidgetRecyclerviewAdapter.c, false, ((StandbyWidgetInfo) standbyWidgetRecyclerviewAdapter.b.get(i2)).getWidgetName());
                return;
            }
            return;
        }
        standbyWidgetRecyclerviewAdapter.c.remove(((StandbyWidgetInfo) standbyWidgetRecyclerviewAdapter.b.get(i2)).getWidgetName());
        ULog.Delegate delegate2 = ULog.f6446a;
        String str2 = standbyWidgetRecyclerviewAdapter.e;
        LinkedHashMap linkedHashMap2 = standbyWidgetRecyclerviewAdapter.c;
        delegate2.a(str2, "widgetsMap:" + linkedHashMap2);
        StandbyComponentChange standbyComponentChange2 = standbyWidgetRecyclerviewAdapter.d;
        if (standbyComponentChange2 != null) {
            standbyComponentChange2.a(standbyWidgetRecyclerviewAdapter.c, true, ((StandbyWidgetInfo) standbyWidgetRecyclerviewAdapter.b.get(i2)).getWidgetName());
        }
    }

    public static final void u(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
    }

    public int getItemCount() {
        return this.b.size();
    }

    public int getItemViewType(int i2) {
        return ((StandbyWidgetInfo) this.b.get(i2)).getViewType();
    }

    public final boolean m(CompoundButton compoundButton) {
        ULog.Delegate delegate = ULog.f6446a;
        LinkedHashMap linkedHashMap = this.c;
        delegate.a("StandbyPositionFragment", "judgeWidgetMark:" + linkedHashMap);
        Ref.IntRef intRef = new Ref.IntRef();
        this.c.forEach(new s(new StandbyWidgetRecyclerviewAdapter$judgeWidgetMark$1(intRef)));
        if (intRef.element < 2) {
            return true;
        }
        compoundButton.setChecked(false);
        t();
        return false;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Object obj = this.b.get(i2);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        StandbyWidgetInfo standbyWidgetInfo = (StandbyWidgetInfo) obj;
        if (getItemViewType(i2) == 0) {
            RecyclerItemStandbyComponentBinding a2 = ((StandbyViewHolder) viewHolder).a();
            a2.b.setChecked(standbyWidgetInfo.isChecked());
            String widgetName = standbyWidgetInfo.getWidgetName();
            StandbyComponentBottomSheet.Companion companion = StandbyComponentBottomSheet.e;
            if (Intrinsics.areEqual((Object) widgetName, (Object) companion.h())) {
                CheckBox checkBox = a2.b;
                MainApplication.Companion companion2 = MainApplication.k;
                checkBox.setBackground(companion2.d().getResources().getDrawable(R.drawable.selector_standby_temperature, (Resources.Theme) null));
                a2.c.setText(companion2.d().getResources().getString(R.string.text_temperature));
            } else if (Intrinsics.areEqual((Object) widgetName, (Object) companion.d())) {
                CheckBox checkBox2 = a2.b;
                MainApplication.Companion companion3 = MainApplication.k;
                checkBox2.setBackground(companion3.d().getResources().getDrawable(R.drawable.selector_standby_step_count, (Resources.Theme) null));
                a2.c.setText(companion3.d().getResources().getString(R.string.text_foot_count));
            } else if (Intrinsics.areEqual((Object) widgetName, (Object) companion.l())) {
                CheckBox checkBox3 = a2.b;
                MainApplication.Companion companion4 = MainApplication.k;
                checkBox3.setBackground(companion4.d().getResources().getDrawable(R.drawable.selector_standby_date, (Resources.Theme) null));
                a2.c.setText(companion4.d().getResources().getString(R.string.text_date));
            }
            a2.b.setOnClickListener(new o(this));
            a2.b.setOnCheckedChangeListener(new p(this, i2));
            return;
        }
        RecyclerItemStandbyComponentMaxBinding a3 = ((StandbyViewHolderMaxWidth) viewHolder).a();
        a3.c.setText(standbyWidgetInfo.getWidgetName());
        a3.b.setChecked(standbyWidgetInfo.isChecked());
        if (Intrinsics.areEqual((Object) standbyWidgetInfo.getWidgetName(), (Object) StandbyComponentBottomSheet.e.j())) {
            CheckBox checkBox4 = a3.b;
            MainApplication.Companion companion5 = MainApplication.k;
            checkBox4.setBackground(companion5.d().getResources().getDrawable(R.drawable.selector_standby_weather, (Resources.Theme) null));
            a3.c.setText(companion5.d().getResources().getString(R.string.text_weather_state));
        }
        a3.b.setOnClickListener(new q(this));
        a3.b.setOnCheckedChangeListener(new r(this, i2));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i2 == 1) {
            RecyclerItemStandbyComponentMaxBinding c2 = RecyclerItemStandbyComponentMaxBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
            return new StandbyViewHolderMaxWidth(this, c2);
        }
        RecyclerItemStandbyComponentBinding c3 = RecyclerItemStandbyComponentBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c3, "inflate(...)");
        return new StandbyViewHolder(this, c3);
    }

    public final void s(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.g, new float[]{this.i, this.j});
        ofFloat.setDuration(this.f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, this.h, new float[]{this.i, this.j});
        ofFloat2.setDuration(this.f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.start();
    }

    public final void t() {
        AlertDialog.Builder cancelable = new AlertDialog.Builder(this.f6622a).setCancelable(false);
        MainApplication.Companion companion = MainApplication.k;
        cancelable.setMessage((CharSequence) companion.d().getResources().getString(R.string.standby_not_add_component)).setNeutralButton((CharSequence) companion.d().getResources().getString(R.string.standby_not_add_component_button_text), (DialogInterface.OnClickListener) new t()).show();
    }
}
