package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.honey.account.h8.y1;
import com.honey.account.h8.z1;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentDlnaPhoneBinding;
import com.upuphone.xr.sapp.entity.BaseActionData;
import com.upuphone.xr.sapp.entity.BaseActionValue;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.utils.JsonUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.upuphone.xr.sapp.vm.WifiViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u001f\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0003J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0002¢\u0006\f\n\u0004\b5\u0010+\u001a\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010@\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010:¨\u0006E"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/DlnaPhoneFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "l0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "v0", "m0", "", "msg", "pkg", "C0", "(Ljava/lang/String;Ljava/lang/String;)V", "s0", "", "z0", "()Z", "B0", "A0", "Landroid/widget/TextView;", "textView", "D0", "(Landroid/widget/TextView;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentDlnaPhoneBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/FragmentDlnaPhoneBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "b", "Lkotlin/Lazy;", "u0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "c", "n0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "Lcom/upuphone/xr/sapp/vm/WifiViewModel;", "d", "o0", "()Lcom/upuphone/xr/sapp/vm/WifiViewModel;", "mWifiViewModel", "e", "Z", "wifiEnabled", "f", "wifiConnect", "g", "Ljava/lang/String;", "phoneSsid", "h", "isConnect", "i", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDlnaPhoneFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DlnaPhoneFragment.kt\ncom/upuphone/xr/sapp/fragment/DlnaPhoneFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,202:1\n32#2,12:203\n32#2,12:215\n172#3,9:227\n*S KotlinDebug\n*F\n+ 1 DlnaPhoneFragment.kt\ncom/upuphone/xr/sapp/fragment/DlnaPhoneFragment\n*L\n44#1:203,12\n45#1:215,12\n46#1:227,9\n*E\n"})
public final class DlnaPhoneFragment extends Fragment {
    public static final Companion i = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public FragmentDlnaPhoneBinding f6950a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(WifiViewModel.class), new DlnaPhoneFragment$special$$inlined$activityViewModels$default$1(this), new DlnaPhoneFragment$special$$inlined$activityViewModels$default$2((Function0) null, this), new DlnaPhoneFragment$special$$inlined$activityViewModels$default$3(this));
    public boolean e;
    public boolean f;
    public String g = "";
    public boolean h;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/DlnaPhoneFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public DlnaPhoneFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.b = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.c = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    private final void initView() {
        FragmentDlnaPhoneBinding fragmentDlnaPhoneBinding = this.f6950a;
        FragmentDlnaPhoneBinding fragmentDlnaPhoneBinding2 = null;
        if (fragmentDlnaPhoneBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDlnaPhoneBinding = null;
        }
        fragmentDlnaPhoneBinding.u.setOnClickListener(new y1(this));
        FragmentDlnaPhoneBinding fragmentDlnaPhoneBinding3 = this.f6950a;
        if (fragmentDlnaPhoneBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDlnaPhoneBinding3 = null;
        }
        fragmentDlnaPhoneBinding3.c.setOnClickListener(new z1(this));
        FragmentDlnaPhoneBinding fragmentDlnaPhoneBinding4 = this.f6950a;
        if (fragmentDlnaPhoneBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDlnaPhoneBinding4 = null;
        }
        TextView textView = fragmentDlnaPhoneBinding4.h;
        Intrinsics.checkNotNullExpressionValue(textView, "firstStepTitle");
        D0(textView);
        FragmentDlnaPhoneBinding fragmentDlnaPhoneBinding5 = this.f6950a;
        if (fragmentDlnaPhoneBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDlnaPhoneBinding5 = null;
        }
        TextView textView2 = fragmentDlnaPhoneBinding5.t;
        Intrinsics.checkNotNullExpressionValue(textView2, "secondStepTitle");
        D0(textView2);
        String language = requireContext().getResources().getConfiguration().locale.getLanguage();
        ULog.f6446a.g("DlnaPhoneFragment", "lg=" + language);
        if (Intrinsics.areEqual((Object) language, (Object) "en")) {
            FragmentDlnaPhoneBinding fragmentDlnaPhoneBinding6 = this.f6950a;
            if (fragmentDlnaPhoneBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentDlnaPhoneBinding6 = null;
            }
            fragmentDlnaPhoneBinding6.h.setTextSize(2, 20.0f);
            FragmentDlnaPhoneBinding fragmentDlnaPhoneBinding7 = this.f6950a;
            if (fragmentDlnaPhoneBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentDlnaPhoneBinding2 = fragmentDlnaPhoneBinding7;
            }
            fragmentDlnaPhoneBinding2.t.setTextSize(2, 20.0f);
            return;
        }
        FragmentDlnaPhoneBinding fragmentDlnaPhoneBinding8 = this.f6950a;
        if (fragmentDlnaPhoneBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDlnaPhoneBinding8 = null;
        }
        fragmentDlnaPhoneBinding8.h.setTextSize(2, 24.5f);
        FragmentDlnaPhoneBinding fragmentDlnaPhoneBinding9 = this.f6950a;
        if (fragmentDlnaPhoneBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentDlnaPhoneBinding2 = fragmentDlnaPhoneBinding9;
        }
        fragmentDlnaPhoneBinding2.t.setTextSize(2, 24.5f);
    }

    private final void l0() {
        u0().I().observe(getViewLifecycleOwner(), new DlnaPhoneFragment$sam$androidx_lifecycle_Observer$0(new DlnaPhoneFragment$addObserver$1(this)));
        n0().L().observe(getViewLifecycleOwner(), new DlnaPhoneFragment$sam$androidx_lifecycle_Observer$0(new DlnaPhoneFragment$addObserver$2(this)));
    }

    private final DeviceControlModel n0() {
        return (DeviceControlModel) this.c.getValue();
    }

    private final WifiViewModel o0() {
        return (WifiViewModel) this.d.getValue();
    }

    private final SuperViewModel u0() {
        return (SuperViewModel) this.b.getValue();
    }

    public static final void w0(DlnaPhoneFragment dlnaPhoneFragment, View view) {
        Intrinsics.checkNotNullParameter(dlnaPhoneFragment, "this$0");
        ULog.f6446a.g("DlnaPhoneFragment", "exit");
        StaticMethodUtilsKt.q(dlnaPhoneFragment);
    }

    public static final void y0(DlnaPhoneFragment dlnaPhoneFragment, View view) {
        Intrinsics.checkNotNullParameter(dlnaPhoneFragment, "this$0");
        if (!dlnaPhoneFragment.h) {
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = dlnaPhoneFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            String string = dlnaPhoneFragment.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(requireContext, string);
            return;
        }
        dlnaPhoneFragment.A0();
    }

    public final void A0() {
        ULog.f6446a.g("DlnaPhoneFragment", "openNetworkFragment");
        StaticMethodUtilsKt.v(this, R.id.wifiSettingFragment, new Bundle());
    }

    public final void B0() {
        u0().I().removeObservers(getViewLifecycleOwner());
    }

    public final void C0(String str, String str2) {
        StarryMessageHelper.f7799a.l(str, new DlnaPhoneFragment$sendMsgToGlass$1(), str2);
    }

    public final void D0(TextView textView) {
        float textSize = textView.getPaint().getTextSize() * ((float) textView.getText().length());
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("setViewGradient", "text width is: " + textSize);
        textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, textSize, 0.0f, getResources().getColor(R.color.color_dlna_gradient_star), getResources().getColor(R.color.color_dlna_gradient_end), Shader.TileMode.CLAMP));
    }

    public final void m0() {
        BaseActionData baseActionData = new BaseActionData();
        baseActionData.setAction("system");
        BaseActionValue baseActionValue = new BaseActionValue();
        baseActionValue.setAction("wifi_enable_state");
        baseActionData.setData(baseActionValue);
        C0(JsonUtils.f7893a.d(baseActionData), "com.upuphone.star.launcher");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentDlnaPhoneBinding c2 = FragmentDlnaPhoneBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6950a = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c2 = null;
        }
        return c2.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        B0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        v0();
        l0();
    }

    public final void s0() {
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("wifi") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        boolean isWifiEnabled = ((WifiManager) systemService).isWifiEnabled();
        this.e = isWifiEnabled;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DlnaPhoneFragment", "wifiEnabled: " + isWifiEnabled);
        if (this.e) {
            boolean z0 = z0();
            this.f = z0;
            delegate.a("DlnaPhoneFragment", "wifiConnect: " + z0);
            if (this.f) {
                String replace$default = StringsKt.replace$default(o0().f(), "\"", "", false, 4, (Object) null);
                this.g = replace$default;
                delegate.a("DlnaPhoneFragment", "phoneSsid: " + replace$default);
            }
        }
    }

    public final void v0() {
        s0();
        m0();
    }

    public final boolean z0() {
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("connectivity") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }
}
