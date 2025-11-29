package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.honey.account.h8.t8;
import com.honey.account.h8.u8;
import com.honey.account.h8.v8;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.ImportScheduleActivity;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.adapter.ScheduleDisplayAdapter;
import com.upuphone.xr.sapp.databinding.FragmentScheduleDisplayBinding;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager;
import com.upuphone.xr.sapp.view.GenericMenuView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR!\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f8BX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/upuphone/xr/sapp/fragment/ScheduleDisplayFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "Lcom/upuphone/xr/sapp/databinding/FragmentScheduleDisplayBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentScheduleDisplayBinding;", "binding", "Lcom/upuphone/xr/sapp/view/GenericMenuView;", "k", "Lcom/upuphone/xr/sapp/view/GenericMenuView;", "dialog", "Lcom/upuphone/xr/sapp/adapter/ScheduleDisplayAdapter;", "l", "Lcom/upuphone/xr/sapp/adapter/ScheduleDisplayAdapter;", "adapter", "", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;", "m", "Lkotlin/Lazy;", "E0", "()Ljava/util/List;", "selectArray", "n", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nScheduleDisplayFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScheduleDisplayFragment.kt\ncom/upuphone/xr/sapp/fragment/ScheduleDisplayFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,111:1\n1855#2,2:112\n*S KotlinDebug\n*F\n+ 1 ScheduleDisplayFragment.kt\ncom/upuphone/xr/sapp/fragment/ScheduleDisplayFragment\n*L\n78#1:112,2\n*E\n"})
public final class ScheduleDisplayFragment extends BaseFragment {
    public static final Companion n = new Companion((DefaultConstructorMarker) null);
    public FragmentScheduleDisplayBinding j;
    public GenericMenuView k;
    public ScheduleDisplayAdapter l;
    public final Lazy m = LazyKt.lazy(new ScheduleDisplayFragment$selectArray$2(this));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/ScheduleDisplayFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void F0(ScheduleDisplayFragment scheduleDisplayFragment, View view) {
        Intrinsics.checkNotNullParameter(scheduleDisplayFragment, "this$0");
        FragmentKt.a(scheduleDisplayFragment).T();
    }

    public static final void G0(ScheduleDisplayFragment scheduleDisplayFragment, View view) {
        Intrinsics.checkNotNullParameter(scheduleDisplayFragment, "this$0");
        scheduleDisplayFragment.startActivity(new Intent(scheduleDisplayFragment.requireActivity(), ImportScheduleActivity.class));
        scheduleDisplayFragment.requireActivity().overridePendingTransition(R.anim.next_open_enter, R.anim.next_open_exit);
    }

    public static final void H0(ScheduleDisplayFragment scheduleDisplayFragment, View view) {
        Intrinsics.checkNotNullParameter(scheduleDisplayFragment, "this$0");
        Context requireContext = scheduleDisplayFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        GenericMenuView genericMenuView = new GenericMenuView(requireContext, scheduleDisplayFragment.E0(), true, new ScheduleDisplayFragment$initView$4$1(scheduleDisplayFragment), scheduleDisplayFragment.getString(R.string.schedule_display_time_title));
        scheduleDisplayFragment.k = genericMenuView;
        FragmentActivity requireActivity = scheduleDisplayFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        genericMenuView.h(requireActivity);
    }

    private final void initView() {
        ULog.f6446a.a("ScheduleDisplayFragment", "init View");
        int t = SuperNotificationManager.f7749a.t();
        FragmentScheduleDisplayBinding fragmentScheduleDisplayBinding = this.j;
        FragmentScheduleDisplayBinding fragmentScheduleDisplayBinding2 = null;
        if (fragmentScheduleDisplayBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentScheduleDisplayBinding = null;
        }
        fragmentScheduleDisplayBinding.h.setOverScrollEnable(false);
        for (GenericMenuView.MenuItem menuItem : E0()) {
            if (menuItem.c() == t) {
                FragmentScheduleDisplayBinding fragmentScheduleDisplayBinding3 = this.j;
                if (fragmentScheduleDisplayBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentScheduleDisplayBinding3 = null;
                }
                fragmentScheduleDisplayBinding3.f.setText(menuItem.a());
                menuItem.d(true);
            }
        }
        FragmentScheduleDisplayBinding fragmentScheduleDisplayBinding4 = this.j;
        if (fragmentScheduleDisplayBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentScheduleDisplayBinding4 = null;
        }
        fragmentScheduleDisplayBinding4.d.setOnClickListener(new t8(this));
        FragmentScheduleDisplayBinding fragmentScheduleDisplayBinding5 = this.j;
        if (fragmentScheduleDisplayBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentScheduleDisplayBinding5 = null;
        }
        fragmentScheduleDisplayBinding5.b.setOnClickListener(new u8(this));
        FragmentScheduleDisplayBinding fragmentScheduleDisplayBinding6 = this.j;
        if (fragmentScheduleDisplayBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentScheduleDisplayBinding2 = fragmentScheduleDisplayBinding6;
        }
        fragmentScheduleDisplayBinding2.i.setOnClickListener(new v8(this));
    }

    public final List E0() {
        return (List) this.m.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentScheduleDisplayBinding c = FragmentScheduleDisplayBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onResume() {
        super.onResume();
        ScheduleDisplayAdapter scheduleDisplayAdapter = new ScheduleDisplayAdapter(ScheduleAccountManager.f7776a.e());
        this.l = scheduleDisplayAdapter;
        scheduleDisplayAdapter.m(new ScheduleDisplayFragment$onResume$1(this));
        FragmentScheduleDisplayBinding fragmentScheduleDisplayBinding = this.j;
        FragmentScheduleDisplayBinding fragmentScheduleDisplayBinding2 = null;
        if (fragmentScheduleDisplayBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentScheduleDisplayBinding = null;
        }
        fragmentScheduleDisplayBinding.h.setLayoutManager(new LinearLayoutManager(requireContext()));
        FragmentScheduleDisplayBinding fragmentScheduleDisplayBinding3 = this.j;
        if (fragmentScheduleDisplayBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentScheduleDisplayBinding2 = fragmentScheduleDisplayBinding3;
        }
        fragmentScheduleDisplayBinding2.h.setAdapter(this.l);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
