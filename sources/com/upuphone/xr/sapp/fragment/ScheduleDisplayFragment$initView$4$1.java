package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.databinding.FragmentScheduleDisplayBinding;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.view.GenericMenuView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/fragment/ScheduleDisplayFragment$initView$4$1", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItemClickListener;", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;", "item", "", "a", "(Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleDisplayFragment$initView$4$1 implements GenericMenuView.MenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScheduleDisplayFragment f7001a;

    public ScheduleDisplayFragment$initView$4$1(ScheduleDisplayFragment scheduleDisplayFragment) {
        this.f7001a = scheduleDisplayFragment;
    }

    public void a(GenericMenuView.MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        FragmentScheduleDisplayBinding D0 = this.f7001a.j;
        if (D0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            D0 = null;
        }
        D0.f.setText(menuItem.a());
        SuperNotificationManager.f7749a.N(menuItem.c());
    }
}
