package com.upuphone.xr.sapp.fragment;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.honey.account.h8.a5;
import com.honey.account.h8.b5;
import com.honey.account.h8.x4;
import com.honey.account.h8.y4;
import com.honey.account.h8.z4;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentHelpFeedbackH5Binding;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.WebViewPool;
import com.upuphone.xr.sapp.view.BaseWebView;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 62\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010&R\u0016\u00105\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u0010&¨\u00068"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/H5HelpFeedbackFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Q0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroy", "Lcom/upuphone/xr/sapp/databinding/FragmentHelpFeedbackH5Binding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentHelpFeedbackH5Binding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "k", "Lkotlin/Lazy;", "getViewModel", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/view/BaseWebView;", "l", "K0", "()Lcom/upuphone/xr/sapp/view/BaseWebView;", "mWebView", "", "m", "Z", "showTitle", "", "n", "Ljava/lang/String;", "title", "o", "url", "", "p", "I", "version", "q", "isNetLoss", "r", "isNetError", "s", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nH5HelpFeedbackFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 H5HelpFeedbackFragment.kt\ncom/upuphone/xr/sapp/fragment/H5HelpFeedbackFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,244:1\n32#2,12:245\n*S KotlinDebug\n*F\n+ 1 H5HelpFeedbackFragment.kt\ncom/upuphone/xr/sapp/fragment/H5HelpFeedbackFragment\n*L\n49#1:245,12\n*E\n"})
public final class H5HelpFeedbackFragment extends BaseFragment {
    public static final Companion s = new Companion((DefaultConstructorMarker) null);
    public FragmentHelpFeedbackH5Binding j;
    public final Lazy k;
    public final Lazy l = LazyKt.lazy(new H5HelpFeedbackFragment$mWebView$2(this));
    public boolean m;
    public String n = "";
    public String o = "";
    public int p;
    public boolean q = true;
    public boolean r;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/H5HelpFeedbackFragment$Companion;", "", "()V", "POLICY_INFOS", "", "POLICY_SHOW_TITLE", "POLICY_TITLE", "POLICY_URL", "POLICY_VERSION", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public H5HelpFeedbackFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.k = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    /* access modifiers changed from: private */
    public final BaseWebView K0() {
        return (BaseWebView) this.l.getValue();
    }

    public static final void L0(H5HelpFeedbackFragment h5HelpFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(h5HelpFeedbackFragment, "this$0");
        StaticMethodUtilsKt.q(h5HelpFeedbackFragment);
    }

    public static final void M0(H5HelpFeedbackFragment h5HelpFeedbackFragment) {
        Intrinsics.checkNotNullParameter(h5HelpFeedbackFragment, "this$0");
        h5HelpFeedbackFragment.K0().loadUrl(h5HelpFeedbackFragment.o);
        ULog.Delegate delegate = ULog.f6446a;
        String str = h5HelpFeedbackFragment.o;
        delegate.a("HelpFeedbackH5Fragment", "refreshlayout reload Url is: " + str);
        new Handler(Looper.getMainLooper()).postDelayed(new b5(h5HelpFeedbackFragment), 10000);
    }

    public static final void N0(H5HelpFeedbackFragment h5HelpFeedbackFragment) {
        Intrinsics.checkNotNullParameter(h5HelpFeedbackFragment, "this$0");
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding = h5HelpFeedbackFragment.j;
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding2 = null;
        if (fragmentHelpFeedbackH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHelpFeedbackH5Binding = null;
        }
        if (fragmentHelpFeedbackH5Binding.j.h()) {
            FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding3 = h5HelpFeedbackFragment.j;
            if (fragmentHelpFeedbackH5Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentHelpFeedbackH5Binding2 = fragmentHelpFeedbackH5Binding3;
            }
            fragmentHelpFeedbackH5Binding2.j.setRefreshing(false);
        }
    }

    public static final void O0(H5HelpFeedbackFragment h5HelpFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(h5HelpFeedbackFragment, "this$0");
        StaticMethodUtilsKt.t(h5HelpFeedbackFragment, R.id.feedBackFragment);
    }

    public static final void P0(H5HelpFeedbackFragment h5HelpFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(h5HelpFeedbackFragment, "this$0");
        if (h5HelpFeedbackFragment.q) {
            Intent intent = new Intent("android.settings.SETTINGS");
            FragmentActivity activity = h5HelpFeedbackFragment.getActivity();
            if (activity != null) {
                activity.startActivity(intent);
                return;
            }
            return;
        }
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding = h5HelpFeedbackFragment.j;
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding2 = null;
        if (fragmentHelpFeedbackH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHelpFeedbackH5Binding = null;
        }
        fragmentHelpFeedbackH5Binding.j.setVisibility(0);
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding3 = h5HelpFeedbackFragment.j;
        if (fragmentHelpFeedbackH5Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHelpFeedbackH5Binding2 = fragmentHelpFeedbackH5Binding3;
        }
        fragmentHelpFeedbackH5Binding2.d.setVisibility(8);
        h5HelpFeedbackFragment.K0().loadUrl(h5HelpFeedbackFragment.o);
        h5HelpFeedbackFragment.r = false;
    }

    private final void Q0() {
        WebSettings settings = K0().getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        if (WebViewFeature.a("ALGORITHMIC_DARKENING")) {
            WebSettingsCompat.b(settings, true);
        } else {
            ULog.f6446a.o("HelpFeedbackH5Fragment", "AlgorithmicDarkening is not Allowed");
        }
        K0().setLayerType(2, (Paint) null);
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(0);
        K0().setWebChromeClient(new H5HelpFeedbackFragment$initWebView$webChromeClient$1(this));
        K0().setWebViewClient(new H5HelpFeedbackFragment$initWebView$1(settings, this));
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setBlockNetworkImage(true);
        ULog.Delegate delegate = ULog.f6446a;
        String str = this.o;
        delegate.a("HelpFeedbackH5Fragment", "initWebView url is: " + str);
        K0().loadUrl(this.o);
    }

    private final void initView() {
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding = this.j;
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding2 = null;
        if (fragmentHelpFeedbackH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHelpFeedbackH5Binding = null;
        }
        fragmentHelpFeedbackH5Binding.j.addView(K0(), new RelativeLayout.LayoutParams(-1, -1));
        K0().setLifecycleOwner(this);
        if (this.m) {
            FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding3 = this.j;
            if (fragmentHelpFeedbackH5Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHelpFeedbackH5Binding3 = null;
            }
            fragmentHelpFeedbackH5Binding3.b.setVisibility(0);
            FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding4 = this.j;
            if (fragmentHelpFeedbackH5Binding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHelpFeedbackH5Binding4 = null;
            }
            fragmentHelpFeedbackH5Binding4.b.setText(this.n);
            FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding5 = this.j;
            if (fragmentHelpFeedbackH5Binding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHelpFeedbackH5Binding5 = null;
            }
            fragmentHelpFeedbackH5Binding5.b.setOnClickListener(new x4(this));
        }
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding6 = this.j;
        if (fragmentHelpFeedbackH5Binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHelpFeedbackH5Binding6 = null;
        }
        fragmentHelpFeedbackH5Binding6.j.setOnRefreshListener(new y4(this));
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding7 = this.j;
        if (fragmentHelpFeedbackH5Binding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHelpFeedbackH5Binding7 = null;
        }
        fragmentHelpFeedbackH5Binding7.h.setOnClickListener(new z4(this));
        if (this.p == 1) {
            FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding8 = this.j;
            if (fragmentHelpFeedbackH5Binding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHelpFeedbackH5Binding8 = null;
            }
            fragmentHelpFeedbackH5Binding8.h.setVisibility(8);
        }
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding9 = this.j;
        if (fragmentHelpFeedbackH5Binding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHelpFeedbackH5Binding2 = fragmentHelpFeedbackH5Binding9;
        }
        fragmentHelpFeedbackH5Binding2.e.setOnClickListener(new a5(this));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentHelpFeedbackH5Binding c = FragmentHelpFeedbackH5Binding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        return c.getRoot();
    }

    public void onDestroy() {
        super.onDestroy();
        K0().getSettings().setCacheMode(2);
        K0().clearCache(true);
        WebViewPool.e.a().i(K0());
    }

    public void onResume() {
        super.onResume();
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding = this.j;
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding2 = null;
        if (fragmentHelpFeedbackH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHelpFeedbackH5Binding = null;
        }
        fragmentHelpFeedbackH5Binding.j.setVisibility(0);
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding3 = this.j;
        if (fragmentHelpFeedbackH5Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHelpFeedbackH5Binding2 = fragmentHelpFeedbackH5Binding3;
        }
        fragmentHelpFeedbackH5Binding2.d.setVisibility(8);
        ULog.f6446a.a("HelpFeedbackH5Fragment", "initWebView url is: " + this.o);
        K0().loadUrl(this.o);
        this.r = false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("policy_infos")) != null) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("HelpFeedbackH5Fragment", "onViewCreated HelpFeedbackH5Fragment is: " + string);
            JSONObject jSONObject = new JSONObject(string);
            this.m = jSONObject.getBoolean("policy_show_title");
            String string2 = jSONObject.getString("policy_title");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            this.n = string2;
            String string3 = jSONObject.getString("policy_url");
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            this.o = string3;
            this.p = jSONObject.getInt("policy_version");
            initView();
            Q0();
        }
    }
}
