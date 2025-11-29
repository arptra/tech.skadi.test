package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.honey.account.h8.a;
import com.honey.account.h8.b;
import com.honey.account.h8.c;
import com.honey.account.h8.d;
import com.honey.account.h8.e;
import com.honey.account.h8.f;
import com.honey.account.h8.g;
import com.honey.account.h8.h;
import com.honey.account.h8.i;
import com.honey.account.h8.j;
import com.honey.account.h8.k;
import com.honey.account.h8.l;
import com.honey.account.h8.m;
import com.honey.account.h8.n;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordEditTitleInputFilter;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.annotation.ConnectCheck;
import com.upuphone.xr.annotation.FastClickCheck;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.ProtocolType;
import com.upuphone.xr.sapp.databinding.AlertDialogTextEntrySinglelineBinding;
import com.upuphone.xr.sapp.databinding.FragmentAboutGlassBinding;
import com.upuphone.xr.sapp.entity.ConnectState;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DeviceHelper;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import com.upuphone.xr.sapp.view.CardItemView;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.xjmz.myvu.flutter.FlutterExtKt;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import flyme.support.v7.app.AlertDialog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\f\u0010\u0003J\u0019\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u0003R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/AboutGlassFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "i1", "R0", "initView", "onClickCertification", "onClickGlassName", "j1", "onClickFactoryReset", "onClickGlassUpdate", "", "checkGlassUpdateState", "S0", "(Z)Z", "V0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "Lcom/upuphone/xr/sapp/entity/ConnectState;", "j", "Lcom/upuphone/xr/sapp/entity/ConnectState;", "mConnectState", "Lcom/upuphone/xr/sapp/databinding/FragmentAboutGlassBinding;", "k", "Lcom/upuphone/xr/sapp/databinding/FragmentAboutGlassBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "l", "Lkotlin/Lazy;", "U0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "Lflyme/support/v7/app/AlertDialog;", "m", "Lflyme/support/v7/app/AlertDialog;", "dialog", "n", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAboutGlassFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AboutGlassFragment.kt\ncom/upuphone/xr/sapp/fragment/AboutGlassFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 ContextExt.kt\ncom/upuphone/xr/sapp/utils/ContextExtKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,281:1\n32#2,12:282\n19#3,9:294\n256#4,2:303\n256#4,2:305\n256#4,2:307\n*S KotlinDebug\n*F\n+ 1 AboutGlassFragment.kt\ncom/upuphone/xr/sapp/fragment/AboutGlassFragment\n*L\n56#1:282,12\n202#1:294,9\n229#1:303,2\n230#1:305,2\n231#1:307,2\n*E\n"})
public final class AboutGlassFragment extends BaseFragment {
    public static final Companion n = new Companion((DefaultConstructorMarker) null);
    public ConnectState j = ConnectState.CONNECTED;
    public FragmentAboutGlassBinding k;
    public final Lazy l;
    public AlertDialog m;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/AboutGlassFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public AboutGlassFragment() {
        Class<DeviceControlModel> cls = DeviceControlModel.class;
        this.l = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    public static /* synthetic */ boolean T0(AboutGlassFragment aboutGlassFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aboutGlassFragment.S0(z);
    }

    public static final void W0(AboutGlassFragment aboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutGlassFragment, "this$0");
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            ContractEntry contractEntry = ContractEntry.f6691a;
            FragmentActivity requireActivity = aboutGlassFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            ContractEntry.w(contractEntry, requireActivity, ProtocolType.GLASS_AIR_UP, (String) null, 4, (Object) null);
            return;
        }
        ContractEntry contractEntry2 = ContractEntry.f6691a;
        FragmentActivity requireActivity2 = aboutGlassFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        ContractEntry.w(contractEntry2, requireActivity2, ProtocolType.GLASS_STAR_UP, (String) null, 4, (Object) null);
    }

    public static final void X0(AboutGlassFragment aboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutGlassFragment, "this$0");
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            ContractEntry contractEntry = ContractEntry.f6691a;
            FragmentActivity requireActivity = aboutGlassFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            ContractEntry.w(contractEntry, requireActivity, ProtocolType.GLASS_AIR_PP, (String) null, 4, (Object) null);
            return;
        }
        ContractEntry contractEntry2 = ContractEntry.f6691a;
        FragmentActivity requireActivity2 = aboutGlassFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        ContractEntry.w(contractEntry2, requireActivity2, ProtocolType.GLASS_STAR_PP, (String) null, 4, (Object) null);
    }

    public static final void Y0(AboutGlassFragment aboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutGlassFragment, "this$0");
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            ContractEntry contractEntry = ContractEntry.f6691a;
            FragmentActivity requireActivity = aboutGlassFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            ContractEntry.w(contractEntry, requireActivity, ProtocolType.GLASS_AIR_PICL, (String) null, 4, (Object) null);
            return;
        }
        ContractEntry contractEntry2 = ContractEntry.f6691a;
        FragmentActivity requireActivity2 = aboutGlassFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        ContractEntry.w(contractEntry2, requireActivity2, ProtocolType.GLASS_STAR_PICL, (String) null, 4, (Object) null);
    }

    public static final void Z0(AboutGlassFragment aboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutGlassFragment, "this$0");
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            ContractEntry contractEntry = ContractEntry.f6691a;
            FragmentActivity requireActivity = aboutGlassFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            ContractEntry.w(contractEntry, requireActivity, ProtocolType.GLASS_AIR_TISL, (String) null, 4, (Object) null);
            return;
        }
        ContractEntry contractEntry2 = ContractEntry.f6691a;
        FragmentActivity requireActivity2 = aboutGlassFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        ContractEntry.w(contractEntry2, requireActivity2, ProtocolType.GLASS_STAR_TISL, (String) null, 4, (Object) null);
    }

    public static final void a1(AboutGlassFragment aboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutGlassFragment, "this$0");
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            ContractEntry contractEntry = ContractEntry.f6691a;
            FragmentActivity requireActivity = aboutGlassFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            ContractEntry.w(contractEntry, requireActivity, ProtocolType.GLASS_AIR_PCPI, (String) null, 4, (Object) null);
            return;
        }
        ContractEntry contractEntry2 = ContractEntry.f6691a;
        FragmentActivity requireActivity2 = aboutGlassFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        ContractEntry.w(contractEntry2, requireActivity2, ProtocolType.GLASS_STAR_PCPI, (String) null, 4, (Object) null);
    }

    public static final void b1(AboutGlassFragment aboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutGlassFragment, "this$0");
        FragmentKt.a(aboutGlassFragment).T();
    }

    public static final void c1(AboutGlassFragment aboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutGlassFragment, "this$0");
        aboutGlassFragment.onClickGlassName();
    }

    public static final void d1(AboutGlassFragment aboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutGlassFragment, "this$0");
        aboutGlassFragment.onClickFactoryReset();
    }

    public static final void e1(AboutGlassFragment aboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutGlassFragment, "this$0");
        aboutGlassFragment.onClickCertification();
    }

    public static final void f1(AboutGlassFragment aboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutGlassFragment, "this$0");
        XrSdkBondDeviceUtil xrSdkBondDeviceUtil = XrSdkBondDeviceUtil.INSTANCE;
        FragmentActivity requireActivity = aboutGlassFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        StarryNetDevice bondedDevice = xrSdkBondDeviceUtil.getBondedDevice(requireActivity);
        String deviceId = bondedDevice != null ? bondedDevice.getDeviceId() : null;
        if (deviceId == null) {
            deviceId = "";
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("AboutGlassFragment", "debounceClick deviceId = " + deviceId);
        DeviceHelper deviceHelper = DeviceHelper.f7878a;
        FragmentActivity requireActivity2 = aboutGlassFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        deviceHelper.a(requireActivity2, deviceId, AboutGlassFragment$initView$5$1.INSTANCE);
    }

    public static final void g1(AboutGlassFragment aboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutGlassFragment, "this$0");
        if (!GlassUpdateHelper.b.c0(aboutGlassFragment.requireActivity())) {
            StaticMethodUtilsKt.t(aboutGlassFragment, R.id.glassInfoFragment);
        }
    }

    public static final void h1(AboutGlassFragment aboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutGlassFragment, "this$0");
        aboutGlassFragment.onClickGlassUpdate();
    }

    private final void initView() {
        ULog.f6446a.a("AboutGlassFragment", "initView");
        FragmentAboutGlassBinding fragmentAboutGlassBinding = this.k;
        FragmentAboutGlassBinding fragmentAboutGlassBinding2 = null;
        if (fragmentAboutGlassBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding = null;
        }
        fragmentAboutGlassBinding.f.setOnClickListener(new g(this));
        FragmentAboutGlassBinding fragmentAboutGlassBinding3 = this.k;
        if (fragmentAboutGlassBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding3 = null;
        }
        fragmentAboutGlassBinding3.h.setCardSubTitle(ControlUtils.f7858a.f());
        FragmentAboutGlassBinding fragmentAboutGlassBinding4 = this.k;
        if (fragmentAboutGlassBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding4 = null;
        }
        fragmentAboutGlassBinding4.h.c();
        FragmentAboutGlassBinding fragmentAboutGlassBinding5 = this.k;
        if (fragmentAboutGlassBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding5 = null;
        }
        fragmentAboutGlassBinding5.h.setOnClickListener(new h(this));
        FragmentAboutGlassBinding fragmentAboutGlassBinding6 = this.k;
        if (fragmentAboutGlassBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding6 = null;
        }
        fragmentAboutGlassBinding6.e.setOnClickListener(new i(this));
        FragmentAboutGlassBinding fragmentAboutGlassBinding7 = this.k;
        if (fragmentAboutGlassBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding7 = null;
        }
        fragmentAboutGlassBinding7.i.setOnClickListener(new j(this));
        FragmentAboutGlassBinding fragmentAboutGlassBinding8 = this.k;
        if (fragmentAboutGlassBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding8 = null;
        }
        CardItemView cardItemView = fragmentAboutGlassBinding8.p;
        Intrinsics.checkNotNullExpressionValue(cardItemView, "unboundDevice");
        ViewExtKt.b(cardItemView, new k(this));
        FragmentAboutGlassBinding fragmentAboutGlassBinding9 = this.k;
        if (fragmentAboutGlassBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding9 = null;
        }
        fragmentAboutGlassBinding9.l.setOnClickListener(new l(this));
        FragmentAboutGlassBinding fragmentAboutGlassBinding10 = this.k;
        if (fragmentAboutGlassBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentAboutGlassBinding2 = fragmentAboutGlassBinding10;
        }
        fragmentAboutGlassBinding2.k.setOnClickListener(new m(this));
    }

    public static final void k1(AboutGlassFragment aboutGlassFragment, Ref.ObjectRef objectRef, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(aboutGlassFragment, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$editText");
        ControlUtils.f7858a.W(aboutGlassFragment.m0().getPackageName(), (String) objectRef.element);
    }

    public static final void l1(DialogInterface dialogInterface, int i) {
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickCertification() {
        String str;
        AndroidConnectApi.DeviceInfo deviceInfo = (AndroidConnectApi.DeviceInfo) U0().P().getValue();
        if (deviceInfo == null || (str = deviceInfo.d()) == null) {
            str = "";
        }
        FlutterExtKt.a(this, "/regulatory_certification_page?deviceType=" + str);
    }

    @Keep
    @FastClickCheck
    private final void onClickFactoryReset() {
        if (T0(this, false, 1, (Object) null)) {
            StaticMethodUtilsKt.t(this, R.id.factoryResetFragment);
        }
    }

    @Keep
    @FastClickCheck
    private final void onClickGlassName() {
        if (T0(this, false, 1, (Object) null)) {
            j1();
        }
    }

    @Keep
    @FastClickCheck
    private final void onClickGlassUpdate() {
        FragmentActivity activity;
        if (S0(false) && (activity = getActivity()) != null) {
            activity.startActivity(new Intent(activity, GlassUpdateInfoActivity.class));
        }
    }

    public final void R0() {
        U0().L().observe(getViewLifecycleOwner(), new AboutGlassFragment$sam$androidx_lifecycle_Observer$0(new AboutGlassFragment$addObserve$1(this)));
        GlassUpdateHelper.b.P0().observe(getViewLifecycleOwner(), new AboutGlassFragment$sam$androidx_lifecycle_Observer$0(new AboutGlassFragment$addObserve$2(this)));
    }

    public final boolean S0(boolean z) {
        Context m0 = m0();
        if (this.j == ConnectState.UNCONNECTED) {
            UToast.Companion companion = UToast.f6444a;
            String string = getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(m0, string);
            return false;
        } else if (!z || !GlassUpdateHelper.b.b1()) {
            return !AppUpdateHelper.f7841a.u();
        } else {
            StaticMethodUtilsKt.O(this);
            return false;
        }
    }

    public final DeviceControlModel U0() {
        return (DeviceControlModel) this.l.getValue();
    }

    public final void V0() {
        ULog.f6446a.a("AboutGlassFragment", "initPrivacyProtocol");
        FragmentAboutGlassBinding fragmentAboutGlassBinding = this.k;
        FragmentAboutGlassBinding fragmentAboutGlassBinding2 = null;
        if (fragmentAboutGlassBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding = null;
        }
        TextView textView = fragmentAboutGlassBinding.c;
        Intrinsics.checkNotNullExpressionValue(textView, "accountPersonalInfoList");
        Boolean bool = BuildConfig.f6575a;
        int i = 8;
        textView.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        FragmentAboutGlassBinding fragmentAboutGlassBinding3 = this.k;
        if (fragmentAboutGlassBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding3 = null;
        }
        TextView textView2 = fragmentAboutGlassBinding3.d;
        Intrinsics.checkNotNullExpressionValue(textView2, "accountThirdShareList");
        textView2.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        FragmentAboutGlassBinding fragmentAboutGlassBinding4 = this.k;
        if (fragmentAboutGlassBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding4 = null;
        }
        TextView textView3 = fragmentAboutGlassBinding4.b;
        Intrinsics.checkNotNullExpressionValue(textView3, "aboutChildrenInfoProtect");
        if (!bool.booleanValue()) {
            i = 0;
        }
        textView3.setVisibility(i);
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            FragmentAboutGlassBinding fragmentAboutGlassBinding5 = this.k;
            if (fragmentAboutGlassBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAboutGlassBinding5 = null;
            }
            fragmentAboutGlassBinding5.n.setBackground(AppCompatResources.b(requireContext(), R.drawable.common_single_item_bg_bottom));
        }
        FragmentAboutGlassBinding fragmentAboutGlassBinding6 = this.k;
        if (fragmentAboutGlassBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding6 = null;
        }
        fragmentAboutGlassBinding6.j.setOnClickListener(new n(this));
        FragmentAboutGlassBinding fragmentAboutGlassBinding7 = this.k;
        if (fragmentAboutGlassBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding7 = null;
        }
        fragmentAboutGlassBinding7.n.setOnClickListener(new b(this));
        FragmentAboutGlassBinding fragmentAboutGlassBinding8 = this.k;
        if (fragmentAboutGlassBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding8 = null;
        }
        fragmentAboutGlassBinding8.c.setOnClickListener(new c(this));
        FragmentAboutGlassBinding fragmentAboutGlassBinding9 = this.k;
        if (fragmentAboutGlassBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutGlassBinding9 = null;
        }
        fragmentAboutGlassBinding9.d.setOnClickListener(new d(this));
        FragmentAboutGlassBinding fragmentAboutGlassBinding10 = this.k;
        if (fragmentAboutGlassBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentAboutGlassBinding2 = fragmentAboutGlassBinding10;
        }
        fragmentAboutGlassBinding2.b.setOnClickListener(new e(this));
    }

    public final void i1() {
        U0().L().removeObservers(this);
        GlassUpdateHelper.b.P0().removeObservers(this);
    }

    public final void j1() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ControlUtils controlUtils = ControlUtils.f7858a;
        objectRef.element = controlUtils.f();
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(R.string.word_name);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.app_confirm, (DialogInterface.OnClickListener) new a(this, objectRef));
        builder.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new f());
        AlertDialog create = builder.create();
        AlertDialogTextEntrySinglelineBinding c = AlertDialogTextEntrySinglelineBinding.c(create.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.b.getEditText().append(controlUtils.f());
        c.b.getEditText().setFilters((InputFilter[]) new FastRecordEditTitleInputFilter[]{ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a()) ? new FastRecordEditTitleInputFilter(14) : new FastRecordEditTitleInputFilter(30)});
        c.b.getEditText().addTextChangedListener(new AboutGlassFragment$showInputDialog$2$1(objectRef, create));
        create.setView(c.getRoot());
        this.m = create;
        create.show();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentAboutGlassBinding c = FragmentAboutGlassBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.k = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onPause() {
        super.onPause();
        i1();
    }

    public void onResume() {
        super.onResume();
        R0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ControlUtils controlUtils = ControlUtils.f7858a;
        String packageName = requireContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        controlUtils.h(packageName);
        initView();
        V0();
    }
}
