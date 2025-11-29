package com.upuphone.xr.sapp.fragment;

import androidx.activity.OnBackPressedCallback;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/upuphone/xr/sapp/fragment/ReminderPermissionSteer$callBack$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ReminderPermissionSteer$callBack$1 extends OnBackPressedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReminderPermissionSteer f6999a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReminderPermissionSteer$callBack$1(ReminderPermissionSteer reminderPermissionSteer) {
        super(true);
        this.f6999a = reminderPermissionSteer;
    }

    public void handleOnBackPressed() {
        ULog.f6446a.g("ReminderPermissionSteer", "jump To appSpaceFragment");
        StaticMethodUtilsKt.x(this.f6999a, R.id.glassManagerFragment);
    }
}
