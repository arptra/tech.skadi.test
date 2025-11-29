package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.honey.account.h8.da;
import com.honey.account.h8.ea;
import com.honey.account.h8.fa;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentUserGuideBinding;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.StatusBarUtil;
import com.upuphone.xr.sapp.utils.WebViewHybridCall;
import com.upuphone.xr.sapp.utils.WebViewPool;
import com.upuphone.xr.sapp.view.BaseWebView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\b\u0007*\u0001<\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001AB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0004J+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u0019\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0004R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010+\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00106R\u0018\u0010;\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u00102R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/UserGuideFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/upuphone/xr/sapp/utils/WebViewHybridCall$IWebCallback;", "<init>", "()V", "", "showLoading", "q", "E", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroyView", "", "url", "y0", "(Ljava/lang/String;)V", "type", "errorMsg", "Lkotlin/Function0;", "click", "E0", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "D0", "Lcom/upuphone/xr/sapp/databinding/FragmentUserGuideBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/FragmentUserGuideBinding;", "binding", "Lcom/upuphone/xr/sapp/utils/WebViewHybridCall;", "b", "Lkotlin/Lazy;", "B0", "()Lcom/upuphone/xr/sapp/utils/WebViewHybridCall;", "mWebViewHybridCall", "Lcom/upuphone/xr/sapp/view/BaseWebView;", "c", "A0", "()Lcom/upuphone/xr/sapp/view/BaseWebView;", "mWebView", "d", "Ljava/lang/String;", "pageUrl", "", "e", "Z", "isLoadError", "f", "fullScreen", "g", "loadUrl", "com/upuphone/xr/sapp/fragment/UserGuideFragment$webViewClient$1", "h", "Lcom/upuphone/xr/sapp/fragment/UserGuideFragment$webViewClient$1;", "webViewClient", "i", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nUserGuideFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserGuideFragment.kt\ncom/upuphone/xr/sapp/fragment/UserGuideFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,237:1\n256#2,2:238\n*S KotlinDebug\n*F\n+ 1 UserGuideFragment.kt\ncom/upuphone/xr/sapp/fragment/UserGuideFragment\n*L\n154#1:238,2\n*E\n"})
public final class UserGuideFragment extends Fragment implements WebViewHybridCall.IWebCallback {
    public static final Companion i = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public FragmentUserGuideBinding f7012a;
    public final Lazy b = LazyKt.lazy(UserGuideFragment$mWebViewHybridCall$2.INSTANCE);
    public final Lazy c = LazyKt.lazy(new UserGuideFragment$mWebView$2(this));
    public String d;
    public boolean e;
    public boolean f;
    public String g = "";
    public UserGuideFragment$webViewClient$1 h = new UserGuideFragment$webViewClient$1(this);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/UserGuideFragment$Companion;", "", "()V", "FULL_SCREEN", "", "TAG", "TITLE_KEY", "URL_KEY", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final BaseWebView A0() {
        return (BaseWebView) this.c.getValue();
    }

    public static final void C0(UserGuideFragment userGuideFragment, View view) {
        Intrinsics.checkNotNullParameter(userGuideFragment, "this$0");
        StaticMethodUtilsKt.q(userGuideFragment);
    }

    public static final void F0(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$click");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    public final void showLoading() {
        FragmentUserGuideBinding fragmentUserGuideBinding = this.f7012a;
        LinearLayout linearLayout = null;
        LinearLayout linearLayout2 = fragmentUserGuideBinding != null ? fragmentUserGuideBinding.i : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        FragmentUserGuideBinding fragmentUserGuideBinding2 = this.f7012a;
        LinearLayout linearLayout3 = fragmentUserGuideBinding2 != null ? fragmentUserGuideBinding2.j : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        FragmentUserGuideBinding fragmentUserGuideBinding3 = this.f7012a;
        if (fragmentUserGuideBinding3 != null) {
            linearLayout = fragmentUserGuideBinding3.h;
        }
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public static final void z0(UserGuideFragment userGuideFragment) {
        Intrinsics.checkNotNullParameter(userGuideFragment, "this$0");
        StaticMethodUtilsKt.q(userGuideFragment);
    }

    public final WebViewHybridCall B0() {
        return (WebViewHybridCall) this.b.getValue();
    }

    public final void D0() {
        FragmentUserGuideBinding fragmentUserGuideBinding = this.f7012a;
        LinearLayout linearLayout = null;
        LinearLayout linearLayout2 = fragmentUserGuideBinding != null ? fragmentUserGuideBinding.i : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        FragmentUserGuideBinding fragmentUserGuideBinding2 = this.f7012a;
        LinearLayout linearLayout3 = fragmentUserGuideBinding2 != null ? fragmentUserGuideBinding2.j : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        FragmentUserGuideBinding fragmentUserGuideBinding3 = this.f7012a;
        if (fragmentUserGuideBinding3 != null) {
            linearLayout = fragmentUserGuideBinding3.h;
        }
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void E() {
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string = getString(R.string.use_network_toast);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(requireContext, string);
    }

    public final void E0(String str, String str2, Function0 function0) {
        LinearLayout linearLayout;
        FragmentUserGuideBinding fragmentUserGuideBinding = this.f7012a;
        TextView textView = null;
        LinearLayout linearLayout2 = fragmentUserGuideBinding != null ? fragmentUserGuideBinding.i : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        FragmentUserGuideBinding fragmentUserGuideBinding2 = this.f7012a;
        LinearLayout linearLayout3 = fragmentUserGuideBinding2 != null ? fragmentUserGuideBinding2.j : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        FragmentUserGuideBinding fragmentUserGuideBinding3 = this.f7012a;
        LinearLayout linearLayout4 = fragmentUserGuideBinding3 != null ? fragmentUserGuideBinding3.h : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(0);
        }
        FragmentUserGuideBinding fragmentUserGuideBinding4 = this.f7012a;
        TextView textView2 = fragmentUserGuideBinding4 != null ? fragmentUserGuideBinding4.d : null;
        if (textView2 != null) {
            textView2.setText(str);
        }
        FragmentUserGuideBinding fragmentUserGuideBinding5 = this.f7012a;
        if (fragmentUserGuideBinding5 != null) {
            textView = fragmentUserGuideBinding5.e;
        }
        if (textView != null) {
            textView.setText(str2);
        }
        FragmentUserGuideBinding fragmentUserGuideBinding6 = this.f7012a;
        if (fragmentUserGuideBinding6 != null && (linearLayout = fragmentUserGuideBinding6.h) != null) {
            linearLayout.setOnClickListener(new fa(function0));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (this.f7012a == null) {
            this.f7012a = FragmentUserGuideBinding.c(layoutInflater, viewGroup, false);
        }
        ULog.f6446a.a("UserGuideFragment", "onCreateView -> inflate view");
        FragmentUserGuideBinding fragmentUserGuideBinding = this.f7012a;
        Intrinsics.checkNotNull(fragmentUserGuideBinding);
        ConstraintLayout b2 = fragmentUserGuideBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        return b2;
    }

    public void onDestroyView() {
        super.onDestroyView();
        B0().a((WebViewHybridCall.IWebCallback) null);
        WebViewPool.e.a().i(A0());
        this.f7012a = null;
        ULog.f6446a.a("UserGuideFragment", "onDestroyView");
    }

    public void onResume() {
        super.onResume();
        if (this.e) {
            ULog.Delegate delegate = ULog.f6446a;
            String str = this.d;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageUrl");
                str = null;
            }
            delegate.a("UserGuideFragment", "onResume::initWebView url is: " + str);
            BaseWebView A0 = A0();
            String str3 = this.d;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageUrl");
            } else {
                str2 = str3;
            }
            A0.loadUrl(str2);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String str = null;
        if (arguments != null) {
            String string = arguments.getString("URL_KEY", "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.d = string;
            String string2 = arguments.getString("TITLE_KEY", "");
            FragmentUserGuideBinding fragmentUserGuideBinding = this.f7012a;
            ConstraintLayout constraintLayout = fragmentUserGuideBinding != null ? fragmentUserGuideBinding.c : null;
            if (constraintLayout != null) {
                Intrinsics.checkNotNull(constraintLayout);
                Intrinsics.checkNotNull(string2);
                constraintLayout.setVisibility(string2.length() > 0 ? 0 : 8);
            }
            this.f = arguments.getBoolean("FULL_SCREEN", false);
            FragmentUserGuideBinding fragmentUserGuideBinding2 = this.f7012a;
            TextView textView2 = fragmentUserGuideBinding2 != null ? fragmentUserGuideBinding2.b : null;
            if (textView2 != null) {
                textView2.setText(string2);
            }
        }
        B0().a(this);
        FragmentUserGuideBinding fragmentUserGuideBinding3 = this.f7012a;
        if (!(fragmentUserGuideBinding3 == null || (frameLayout = fragmentUserGuideBinding3.f) == null)) {
            frameLayout.addView(A0(), new RelativeLayout.LayoutParams(-1, -1));
        }
        FragmentUserGuideBinding fragmentUserGuideBinding4 = this.f7012a;
        if (!(fragmentUserGuideBinding4 == null || (textView = fragmentUserGuideBinding4.b) == null)) {
            textView.setOnClickListener(new da(this));
        }
        A0().setLifecycleOwner(this);
        WebSettings settings = A0().getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        A0().setLayerType(2, (Paint) null);
        settings.setJavaScriptEnabled(true);
        A0().setWebViewClient(this.h);
        A0().setBackgroundColor(0);
        settings.setDomStorageEnabled(true);
        settings.setBlockNetworkImage(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = this.d;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageUrl");
            str2 = null;
        }
        delegate.a("UserGuideFragment", "initWebView url is: " + str2);
        BaseWebView A0 = A0();
        String str3 = this.d;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageUrl");
        } else {
            str = str3;
        }
        A0.loadUrl(str);
        A0().addJavascriptInterface(B0(), "SuperObj");
    }

    public void q() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new ea(this));
        }
    }

    public final void y0(String str) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        if (this.f) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("UserGuideFragment", "checkImmersive fullScreen " + str);
            if (str == null) {
                return;
            }
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "meizu.com", false, 2, (Object) null)) {
                FragmentUserGuideBinding fragmentUserGuideBinding = this.f7012a;
                if (fragmentUserGuideBinding != null && (frameLayout2 = fragmentUserGuideBinding.f) != null) {
                    frameLayout2.setPaddingRelative(0, 0, 0, 0);
                    return;
                }
                return;
            }
            StatusBarUtil statusBarUtil = StatusBarUtil.f7922a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            int a2 = statusBarUtil.a(requireContext);
            FragmentUserGuideBinding fragmentUserGuideBinding2 = this.f7012a;
            if (fragmentUserGuideBinding2 != null && (frameLayout = fragmentUserGuideBinding2.f) != null) {
                frameLayout.setPaddingRelative(0, a2, 0, 0);
            }
        }
    }
}
