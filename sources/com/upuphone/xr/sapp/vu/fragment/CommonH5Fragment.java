package com.upuphone.xr.sapp.vu.fragment;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.honey.account.c9.a;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.databinding.FragmentCommonH5Binding;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.WebViewPool;
import com.upuphone.xr.sapp.view.BaseWebView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u001b\u0010#\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/upuphone/xr/sapp/vu/fragment/CommonH5Fragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "o0", "n0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroy", "", "a", "Ljava/lang/String;", "url", "b", "title", "c", "appearanceState", "Lcom/upuphone/xr/sapp/view/BaseWebView;", "d", "Lkotlin/Lazy;", "m0", "()Lcom/upuphone/xr/sapp/view/BaseWebView;", "mWebView", "", "e", "Z", "isNetError", "Lcom/upuphone/xr/sapp/databinding/FragmentCommonH5Binding;", "f", "Lcom/upuphone/xr/sapp/databinding/FragmentCommonH5Binding;", "binding", "g", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CommonH5Fragment extends Fragment {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public String f8061a;
    public String b = "";
    public String c = "light";
    public final Lazy d = LazyKt.lazy(new CommonH5Fragment$mWebView$2(this));
    public boolean e;
    public FragmentCommonH5Binding f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/vu/fragment/CommonH5Fragment$Companion;", "", "()V", "H5_TITLE", "", "H5_URL", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final void initView() {
        FragmentCommonH5Binding fragmentCommonH5Binding = this.f;
        FragmentCommonH5Binding fragmentCommonH5Binding2 = null;
        if (fragmentCommonH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCommonH5Binding = null;
        }
        fragmentCommonH5Binding.b.setText(this.b);
        FragmentCommonH5Binding fragmentCommonH5Binding3 = this.f;
        if (fragmentCommonH5Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentCommonH5Binding2 = fragmentCommonH5Binding3;
        }
        fragmentCommonH5Binding2.g.addView(m0(), new RelativeLayout.LayoutParams(-1, -1));
        m0().setLifecycleOwner(this);
    }

    /* access modifiers changed from: private */
    public final BaseWebView m0() {
        return (BaseWebView) this.d.getValue();
    }

    private final void n0() {
        this.c = (getResources().getConfiguration().uiMode & 48) == 32 ? "dark" : "light";
        WebSettings settings = m0().getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        String str = null;
        m0().setLayerType(2, (Paint) null);
        settings.setJavaScriptEnabled(false);
        if (WebViewFeature.a("ALGORITHMIC_DARKENING")) {
            WebSettingsCompat.b(settings, true);
        } else {
            ULog.f6446a.o("CommonH5Fragment", "AlgorithmicDarkening is not Allowed");
        }
        m0().setWebChromeClient(new CommonH5Fragment$initWebView$webChromeClient$1());
        m0().setWebViewClient(new CommonH5Fragment$initWebView$1(settings, this));
        m0().setBackgroundColor(0);
        settings.setDomStorageEnabled(true);
        settings.setBlockNetworkImage(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = this.f8061a;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        } else {
            str = str2;
        }
        delegate.a("CommonH5Fragment", "initWebView url is: " + str);
    }

    /* access modifiers changed from: private */
    public final void o0() {
        FragmentCommonH5Binding fragmentCommonH5Binding = this.f;
        String str = null;
        if (fragmentCommonH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCommonH5Binding = null;
        }
        fragmentCommonH5Binding.g.setVisibility(0);
        FragmentCommonH5Binding fragmentCommonH5Binding2 = this.f;
        if (fragmentCommonH5Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCommonH5Binding2 = null;
        }
        fragmentCommonH5Binding2.c.setVisibility(8);
        BaseWebView m0 = m0();
        String str2 = this.f8061a;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        } else {
            str = str2;
        }
        m0.loadUrl(str);
        this.e = false;
    }

    public static final void s0(CommonH5Fragment commonH5Fragment, View view) {
        Intrinsics.checkNotNullParameter(commonH5Fragment, "this$0");
        StaticMethodUtilsKt.q(commonH5Fragment);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentCommonH5Binding c2 = FragmentCommonH5Binding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c2 = null;
        }
        ConstraintLayout b2 = c2.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        return b2;
    }

    public void onDestroy() {
        super.onDestroy();
        WebViewPool.e.a().i(m0());
    }

    public void onResume() {
        super.onResume();
        o0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        FragmentCommonH5Binding fragmentCommonH5Binding = null;
        String string = arguments != null ? arguments.getString("h5_url") : null;
        String str = "";
        if (string == null) {
            string = str;
        }
        this.f8061a = string;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("h5_title") : null;
        if (string2 != null) {
            str = string2;
        }
        this.b = str;
        initView();
        n0();
        FragmentCommonH5Binding fragmentCommonH5Binding2 = this.f;
        if (fragmentCommonH5Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentCommonH5Binding = fragmentCommonH5Binding2;
        }
        fragmentCommonH5Binding.b.setOnClickListener(new a(this));
    }
}
