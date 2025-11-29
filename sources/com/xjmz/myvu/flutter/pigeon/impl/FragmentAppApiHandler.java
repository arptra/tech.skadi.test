package com.xjmz.myvu.flutter.pigeon.impl;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.FeedbackActivity;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.tips.TipsKey;
import com.upuphone.xr.sapp.tips.TipsManager;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.UserGuideHelper;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesModel;
import com.xjmz.myvu.MYVUActivity;
import com.xjmz.myvu.account.AccountManager;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/FragmentAppApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/impl/AppApiHandler;", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "deviceControlModel", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/upuphone/xr/sapp/vm/DeviceControlModel;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$AppRequest;", "request", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$Result;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$AppReply;", "result", "", "i", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$AppRequest;Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$Result;)V", "", "name", "w", "(Ljava/lang/String;)V", "y", "()V", "v", "x", "d", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "e", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "", "", "f", "Ljava/util/Map;", "navFragmentMap", "g", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FragmentAppApiHandler extends AppApiHandler {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public final Fragment d;
    public final DeviceControlModel e;
    public final Map f = MapsKt.mapOf(TuplesKt.to("glass_settings_page", Integer.valueOf(R.id.glassManagerFragment)), TuplesKt.to("touchpad_page", Integer.valueOf(R.id.touchpadFragment)), TuplesKt.to("ai_assistant", Integer.valueOf(R.id.voiceAssistantsFragment)), TuplesKt.to("mine_page", Integer.valueOf(R.id.mineFragment)), TuplesKt.to("bind_air_glass_page", Integer.valueOf(R.id.addGlassFragment)), TuplesKt.to("ring1", Integer.valueOf(R.id.ringManagerFragment)), TuplesKt.to("view_glasses_settings_page", Integer.valueOf(R.id.vuGlassesManagerFragment)), TuplesKt.to("account_center", Integer.valueOf(R.id.accountFragment)), TuplesKt.to("app_setting", Integer.valueOf(R.id.settingFragment)), TuplesKt.to("help_and_feedback", Integer.valueOf(R.id.helpFeedbackFragment)), TuplesKt.to("device_connect_helper", Integer.valueOf(R.id.deviceConnectHelpFragment)));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/FragmentAppApiHandler$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FragmentAppApiHandler(androidx.fragment.app.Fragment r12, com.upuphone.xr.sapp.vm.DeviceControlModel r13) {
        /*
            r11 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "deviceControlModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            android.content.Context r0 = r12.requireContext()
            java.lang.String r1 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r11.<init>(r0)
            r11.d = r12
            r11.e = r13
            int r12 = com.upuphone.xr.sapp.R.id.glassManagerFragment
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "glass_settings_page"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r13, r12)
            int r12 = com.upuphone.xr.sapp.R.id.touchpadFragment
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "touchpad_page"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r13, r12)
            int r12 = com.upuphone.xr.sapp.R.id.voiceAssistantsFragment
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "ai_assistant"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r13, r12)
            int r12 = com.upuphone.xr.sapp.R.id.mineFragment
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "mine_page"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r13, r12)
            int r12 = com.upuphone.xr.sapp.R.id.addGlassFragment
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "bind_air_glass_page"
            kotlin.Pair r4 = kotlin.TuplesKt.to(r13, r12)
            int r12 = com.upuphone.xr.sapp.R.id.ringManagerFragment
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "ring1"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r13, r12)
            int r12 = com.upuphone.xr.sapp.R.id.vuGlassesManagerFragment
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "view_glasses_settings_page"
            kotlin.Pair r6 = kotlin.TuplesKt.to(r13, r12)
            int r12 = com.upuphone.xr.sapp.R.id.accountFragment
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "account_center"
            kotlin.Pair r7 = kotlin.TuplesKt.to(r13, r12)
            int r12 = com.upuphone.xr.sapp.R.id.settingFragment
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "app_setting"
            kotlin.Pair r8 = kotlin.TuplesKt.to(r13, r12)
            int r12 = com.upuphone.xr.sapp.R.id.helpFeedbackFragment
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "help_and_feedback"
            kotlin.Pair r9 = kotlin.TuplesKt.to(r13, r12)
            int r12 = com.upuphone.xr.sapp.R.id.deviceConnectHelpFragment
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "device_connect_helper"
            kotlin.Pair r10 = kotlin.TuplesKt.to(r13, r12)
            kotlin.Pair[] r12 = new kotlin.Pair[]{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10}
            java.util.Map r12 = kotlin.collections.MapsKt.mapOf(r12)
            r11.f = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.flutter.pigeon.impl.FragmentAppApiHandler.<init>(androidx.fragment.app.Fragment, com.upuphone.xr.sapp.vm.DeviceControlModel):void");
    }

    public void i(AndroidAppApi.AppRequest appRequest, AndroidAppApi.Result result) {
        Intrinsics.checkNotNullParameter(appRequest, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        super.i(appRequest, result);
        String b = appRequest.b();
        if (b != null) {
            switch (b.hashCode()) {
                case -347742939:
                    if (b.equals("problem_feedback")) {
                        x();
                        return;
                    }
                    break;
                case 805509447:
                    if (b.equals("view_glasses_ar_space")) {
                        VuGlassesModel b2 = VuGlassesModel.n.b();
                        if (b2 != null) {
                            b2.K(false);
                            return;
                        }
                        return;
                    }
                    break;
                case 837149884:
                    if (b.equals("view_glasses_settings_page")) {
                        if (!VuGlassControlModel.f8109a.z()) {
                            UToast.Companion companion = UToast.f6444a;
                            MainApplication.Companion companion2 = MainApplication.k;
                            MainApplication f2 = companion2.f();
                            String string = companion2.f().getString(R.string.view_glasses_not_connected_tip);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            companion.d(f2, string);
                            return;
                        } else if (VuGlassesHidUtil.f8104a.e() == 1) {
                            w(b);
                            return;
                        } else {
                            Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.c(), (CoroutineStart) null, new FragmentAppApiHandler$openNamedPage$1(this, b, (Continuation<? super FragmentAppApiHandler$openNamedPage$1>) null), 2, (Object) null);
                            return;
                        }
                    }
                    break;
                case 1258746155:
                    if (b.equals("help_and_feedback")) {
                        v(b);
                        return;
                    }
                    break;
                case 1923761544:
                    if (b.equals("user_guide")) {
                        y();
                        return;
                    }
                    break;
                case 2130540161:
                    if (b.equals("view_glasses_adapted_phone")) {
                        VuGlassesModel b3 = VuGlassesModel.n.b();
                        if (b3 != null) {
                            b3.I();
                            return;
                        }
                        return;
                    }
                    break;
            }
            w(b);
        }
    }

    public final void v(String str) {
        MYVUActivity r = MainApplication.k.f().r();
        AccountManager accountManager = AccountManager.f8217a;
        if (!accountManager.t() || r == null) {
            w(str);
        } else {
            accountManager.y(r);
        }
    }

    public final void w(String str) {
        Integer num = (Integer) this.f.get(str);
        if (num == null) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("FragmentAppApiHandler", "openFragment() not found: " + str);
            return;
        }
        MYVUActivity r = MainApplication.k.f().r();
        Unit unit = null;
        if (r != null) {
            MYVUActivity.r1(r, num.intValue(), (Bundle) null, 2, (Object) null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ULog.f6446a.a("FragmentAppApiHandler", "openNamedPage-> getMYVUActivity为空");
        }
    }

    public final void x() {
        FragmentActivity activity = this.d.getActivity();
        if (activity == null) {
            ULog.f6446a.c("FragmentAppApiHandler", "openProblemFeedback, activity is null");
            return;
        }
        activity.startActivity(new Intent(activity, FeedbackActivity.class));
        activity.overridePendingTransition(R.anim.next_open_enter, R.anim.next_open_exit);
    }

    public final void y() {
        String str;
        Bundle bundle = new Bundle();
        UserGuideHelper userGuideHelper = UserGuideHelper.f7928a;
        AndroidConnectApi.DeviceInfo deviceInfo = (AndroidConnectApi.DeviceInfo) this.e.P().getValue();
        if (deviceInfo == null || (str = deviceInfo.d()) == null) {
            str = "";
        }
        Intrinsics.checkNotNull(str);
        bundle.putString("URL_KEY", userGuideHelper.e(str));
        bundle.putBoolean("FULL_SCREEN", true);
        DataStoreUtils a2 = DataStoreUtils.e.a();
        AndroidConnectApi.DeviceInfo deviceInfo2 = (AndroidConnectApi.DeviceInfo) this.e.P().getValue();
        Unit unit = null;
        String d2 = deviceInfo2 != null ? deviceInfo2.d() : null;
        a2.o("TIPS_USER_GUIDE_" + d2, Boolean.TRUE);
        TipsManager.f7827a.d(TipsKey.TIPS_USER_GUIDE);
        MYVUActivity r = MainApplication.k.f().r();
        if (r != null) {
            r.q1(R.id.userGuideFragment, bundle);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ULog.f6446a.a("FragmentAppApiHandler", "openNamedPage-> getMYVUActivity为空");
        }
    }
}
