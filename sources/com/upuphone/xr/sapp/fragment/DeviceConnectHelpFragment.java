package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.collection.ArrayMapKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.h8.t1;
import com.honey.account.h8.u1;
import com.honey.account.h8.v1;
import com.honey.account.h8.w1;
import com.honey.account.h8.x1;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentDeviceConnectHelpBinding;
import com.upuphone.xr.sapp.entity.H5Info;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J)\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0003R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/DeviceConnectHelpFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "ignoringBatteryOptimizations", "autoStart", "lock", "L0", "(ZZZ)V", "F0", "Lcom/upuphone/xr/sapp/databinding/FragmentDeviceConnectHelpBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentDeviceConnectHelpBinding;", "binding", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDeviceConnectHelpFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceConnectHelpFragment.kt\ncom/upuphone/xr/sapp/fragment/DeviceConnectHelpFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,200:1\n256#2,2:201\n256#2,2:203\n256#2,2:205\n*S KotlinDebug\n*F\n+ 1 DeviceConnectHelpFragment.kt\ncom/upuphone/xr/sapp/fragment/DeviceConnectHelpFragment\n*L\n90#1:201,2\n136#1:203,2\n138#1:205,2\n*E\n"})
public final class DeviceConnectHelpFragment extends BaseFragment {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public FragmentDeviceConnectHelpBinding j;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/DeviceConnectHelpFragment$Companion;", "", "()V", "BATTERY_RESULT_DELAY_TIME", "", "PERMISSION_BATTERY_REQUEST_CODE", "", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void G0(DeviceConnectHelpFragment deviceConnectHelpFragment, View view) {
        Intrinsics.checkNotNullParameter(deviceConnectHelpFragment, "this$0");
        Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        String packageName = deviceConnectHelpFragment.m0().getPackageName();
        intent.setData(Uri.parse("package:" + packageName));
        deviceConnectHelpFragment.startActivityForResult(intent, 101);
    }

    public static final void H0(DeviceConnectHelpFragment deviceConnectHelpFragment, View view) {
        Intrinsics.checkNotNullParameter(deviceConnectHelpFragment, "this$0");
        Bundle bundle = new Bundle();
        PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
        bundle.putParcelable("h5_info", new H5Info(phoneTypeUtils.b(), "lock-background", phoneTypeUtils.a()));
        StaticMethodUtilsKt.v(deviceConnectHelpFragment, R.id.h5Fragment, bundle);
    }

    public static final void I0(DeviceConnectHelpFragment deviceConnectHelpFragment, View view) {
        Intrinsics.checkNotNullParameter(deviceConnectHelpFragment, "this$0");
        Bundle bundle = new Bundle();
        PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
        bundle.putParcelable("h5_info", new H5Info(phoneTypeUtils.b(), "automatic-start", phoneTypeUtils.a()));
        StaticMethodUtilsKt.v(deviceConnectHelpFragment, R.id.h5Fragment, bundle);
    }

    public static final void J0(DeviceConnectHelpFragment deviceConnectHelpFragment, View view) {
        Intrinsics.checkNotNullParameter(deviceConnectHelpFragment, "this$0");
        StaticMethodUtilsKt.q(deviceConnectHelpFragment);
    }

    public static final void K0(DeviceConnectHelpFragment deviceConnectHelpFragment) {
        Intrinsics.checkNotNullParameter(deviceConnectHelpFragment, "this$0");
        boolean C = PermissionAndStateCheckUtils.f7907a.C(deviceConnectHelpFragment.m0());
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        DataStoreUtils a2 = companion.a();
        Boolean bool = Boolean.FALSE;
        boolean booleanValue = ((Boolean) DataStoreUtils.i(a2, "automatic-start", bool, (Context) null, 4, (Object) null)).booleanValue();
        boolean booleanValue2 = ((Boolean) DataStoreUtils.i(companion.a(), "lock-background", bool, (Context) null, 4, (Object) null)).booleanValue();
        FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding = deviceConnectHelpFragment.j;
        if (fragmentDeviceConnectHelpBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceConnectHelpBinding = null;
        }
        fragmentDeviceConnectHelpBinding.g.setStartIconState(C);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DeviceConnectHelpFragment", "onResume::ignoringBatteryOptimizations is: " + C + " autoStart is: " + booleanValue + " lock is: " + booleanValue2);
        deviceConnectHelpFragment.L0(C, booleanValue, booleanValue2);
    }

    private final void initView() {
        Context m0 = m0();
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding = null;
        if (bool.booleanValue()) {
            PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
            if (!phoneTypeUtils.l() && !phoneTypeUtils.j()) {
                FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding2 = this.j;
                if (fragmentDeviceConnectHelpBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentDeviceConnectHelpBinding2 = null;
                }
                ConstraintLayout constraintLayout = fragmentDeviceConnectHelpBinding2.c;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "helpAutostartMain");
                constraintLayout.setVisibility(8);
            }
        }
        PhoneTypeUtils phoneTypeUtils2 = PhoneTypeUtils.f7912a;
        if (phoneTypeUtils2.c()) {
            FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding3 = this.j;
            if (fragmentDeviceConnectHelpBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentDeviceConnectHelpBinding3 = null;
            }
            fragmentDeviceConnectHelpBinding3.g.setCardTitleText(m0.getString(R.string.ignore_battery_saving_huawei));
            FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding4 = this.j;
            if (fragmentDeviceConnectHelpBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentDeviceConnectHelpBinding4 = null;
            }
            fragmentDeviceConnectHelpBinding4.g.setCardSubTitle(m0.getString(R.string.ignore_batt_content_huawei));
        } else if (phoneTypeUtils2.e()) {
            FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding5 = this.j;
            if (fragmentDeviceConnectHelpBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentDeviceConnectHelpBinding5 = null;
            }
            fragmentDeviceConnectHelpBinding5.g.setCardTitleText(m0.getString(R.string.ignore_battery_saving_xiaomi));
            FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding6 = this.j;
            if (fragmentDeviceConnectHelpBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentDeviceConnectHelpBinding6 = null;
            }
            fragmentDeviceConnectHelpBinding6.g.setCardSubTitle(m0.getString(R.string.ignore_batt_content_xiaomi));
        } else {
            FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding7 = this.j;
            if (fragmentDeviceConnectHelpBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentDeviceConnectHelpBinding7 = null;
            }
            fragmentDeviceConnectHelpBinding7.g.setCardTitleText(m0.getString(R.string.ignore_battery_saving));
            FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding8 = this.j;
            if (fragmentDeviceConnectHelpBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentDeviceConnectHelpBinding8 = null;
            }
            fragmentDeviceConnectHelpBinding8.g.setCardSubTitle(m0.getString(R.string.ignore_battery_saving_desc));
        }
        Context m02 = m0();
        boolean C = m02 != null ? PermissionAndStateCheckUtils.f7907a.C(m02) : false;
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        DataStoreUtils a2 = companion.a();
        Boolean bool2 = Boolean.FALSE;
        boolean booleanValue = ((Boolean) DataStoreUtils.i(a2, "automatic-start", bool2, (Context) null, 4, (Object) null)).booleanValue();
        boolean booleanValue2 = ((Boolean) DataStoreUtils.i(companion.a(), "lock-background", bool2, (Context) null, 4, (Object) null)).booleanValue();
        ULog.f6446a.a("DeviceConnectHelpFragment", "initView::ignoringBatteryOptimizations is: " + C + " autoStart is: " + booleanValue + " lock is: " + booleanValue2);
        L0(C, booleanValue, booleanValue2);
        FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding9 = this.j;
        if (fragmentDeviceConnectHelpBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceConnectHelpBinding9 = null;
        }
        fragmentDeviceConnectHelpBinding9.g.setStartIconState(C);
        FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding10 = this.j;
        if (fragmentDeviceConnectHelpBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceConnectHelpBinding10 = null;
        }
        fragmentDeviceConnectHelpBinding10.f.setStartIconState(booleanValue);
        FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding11 = this.j;
        if (fragmentDeviceConnectHelpBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentDeviceConnectHelpBinding = fragmentDeviceConnectHelpBinding11;
        }
        fragmentDeviceConnectHelpBinding.h.setStartIconState(booleanValue2);
        new DeviceConnectHelpFragment$initView$1$webView$1(m0).loadUrl("https://xr-nbs-fat.myvu.cn/xr-menu/help/lock-background?brand=" + phoneTypeUtils2.b() + "&model=" + phoneTypeUtils2.a());
        int intValue = ((Number) DataStoreUtils.i(companion.a(), "app_device_connection_assistant", 1, (Context) null, 4, (Object) null)).intValue();
        DataTrackUtil.f7875a.i("app_device_connection_assistant", MapsKt.toMap(ArrayMapKt.a(TuplesKt.to("times", String.valueOf(intValue)))));
        companion.a().o("app_device_connection_assistant", Integer.valueOf(intValue + 1));
    }

    public final void F0() {
        FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding = this.j;
        FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding2 = null;
        if (fragmentDeviceConnectHelpBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceConnectHelpBinding = null;
        }
        fragmentDeviceConnectHelpBinding.g.getBinding().j.setOnClickListener(new u1(this));
        FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding3 = this.j;
        if (fragmentDeviceConnectHelpBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceConnectHelpBinding3 = null;
        }
        fragmentDeviceConnectHelpBinding3.h.getBinding().j.setOnClickListener(new v1(this));
        FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding4 = this.j;
        if (fragmentDeviceConnectHelpBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceConnectHelpBinding4 = null;
        }
        fragmentDeviceConnectHelpBinding4.f.getBinding().j.setOnClickListener(new w1(this));
        FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding5 = this.j;
        if (fragmentDeviceConnectHelpBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentDeviceConnectHelpBinding2 = fragmentDeviceConnectHelpBinding5;
        }
        fragmentDeviceConnectHelpBinding2.b.setOnClickListener(new x1(this));
    }

    public final void L0(boolean z, boolean z2, boolean z3) {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        int i = 8;
        boolean z4 = true;
        FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding = null;
        if (bool.booleanValue()) {
            FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding2 = this.j;
            if (fragmentDeviceConnectHelpBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentDeviceConnectHelpBinding = fragmentDeviceConnectHelpBinding2;
            }
            TextView textView = fragmentDeviceConnectHelpBinding.j;
            Intrinsics.checkNotNullExpressionValue(textView, "tvTips");
            if (z && z3) {
                z4 = false;
            }
            if (z4) {
                i = 0;
            }
            textView.setVisibility(i);
            return;
        }
        FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding3 = this.j;
        if (fragmentDeviceConnectHelpBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentDeviceConnectHelpBinding = fragmentDeviceConnectHelpBinding3;
        }
        TextView textView2 = fragmentDeviceConnectHelpBinding.j;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvTips");
        if (z && z2 && z3) {
            z4 = false;
        }
        if (z4) {
            i = 0;
        }
        textView2.setVisibility(i);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DeviceConnectHelpFragment", "requestCode:" + i + ",resultCode:" + i2 + ",data:" + intent);
        if (i == 101) {
            boolean C = PermissionAndStateCheckUtils.f7907a.C(m0());
            DataStoreUtils.Companion companion = DataStoreUtils.e;
            DataStoreUtils a2 = companion.a();
            Boolean bool = Boolean.FALSE;
            boolean booleanValue = ((Boolean) DataStoreUtils.i(a2, "automatic-start", bool, (Context) null, 4, (Object) null)).booleanValue();
            boolean booleanValue2 = ((Boolean) DataStoreUtils.i(companion.a(), "lock-background", bool, (Context) null, 4, (Object) null)).booleanValue();
            FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding = this.j;
            if (fragmentDeviceConnectHelpBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentDeviceConnectHelpBinding = null;
            }
            fragmentDeviceConnectHelpBinding.g.setStartIconState(C);
            delegate.a("DeviceConnectHelpFragment", "onActivityResult::ignoringBatteryOptimizations is: " + C + " autoStart is: " + booleanValue + " lock is: " + booleanValue2);
            DataTrackUtil.f7875a.i("app_device_connection_assistant", MapsKt.toMap(ArrayMapKt.a(TuplesKt.to("ignore_battery_optimisation", "1"))));
            L0(C, booleanValue, booleanValue2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentDeviceConnectHelpBinding c = FragmentDeviceConnectHelpBinding.c(layoutInflater, viewGroup, false);
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
        FragmentDeviceConnectHelpBinding fragmentDeviceConnectHelpBinding = this.j;
        if (fragmentDeviceConnectHelpBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceConnectHelpBinding = null;
        }
        fragmentDeviceConnectHelpBinding.getRoot().postDelayed(new t1(this), 1000);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        F0();
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        if (!((Boolean) DataStoreUtils.i(companion.a(), "check_device_help_action", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue()) {
            companion.a().o("check_device_help_action", Boolean.TRUE);
            companion.a().o("check_device_help_time", Long.valueOf(System.currentTimeMillis()));
        }
    }
}
