package com.xjmz.myvu.modules.home;

import android.content.Intent;
import android.net.Uri;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.HuaWeiFeatureParser;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HomeFragment$checkPermissionTips$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $permission;
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$checkPermissionTips$1(String str, HomeFragment homeFragment) {
        super(0);
        this.$permission = str;
        this.this$0 = homeFragment;
    }

    public final void invoke() {
        if (Intrinsics.areEqual((Object) this.$permission, (Object) "meizu_sport_not_authorize") && PhoneTypeUtils.f7912a.c()) {
            HuaWeiFeatureParser.b().i(this.this$0.requireActivity());
        } else if (Intrinsics.areEqual((Object) this.$permission, (Object) "notification_user_permission")) {
            try {
                this.this$0.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
            } catch (Exception e) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.o("HomeFragment", "jumpNotifyListenerPage e:" + e);
                StaticMethodUtilsKt.p(this.this$0);
            }
        } else if (Intrinsics.areEqual((Object) this.$permission, (Object) "super_notify_keeplive")) {
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            String packageName = this.this$0.requireContext().getPackageName();
            intent.setData(Uri.parse("package:" + packageName));
            this.this$0.startActivityForResult(intent, 101);
        } else if (Intrinsics.areEqual((Object) this.$permission, (Object) "flyme_link_top_show")) {
            StaticMethodUtilsKt.R(this.this$0);
        } else {
            StaticMethodUtilsKt.p(this.this$0);
        }
    }
}
