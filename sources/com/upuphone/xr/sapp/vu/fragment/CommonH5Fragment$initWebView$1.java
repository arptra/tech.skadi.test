package com.upuphone.xr.sapp.vu.fragment;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import com.honey.account.c9.b;
import com.honey.account.c9.c;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentCommonH5Binding;
import com.upuphone.xr.sapp.utils.AppUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J.\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\r"}, d2 = {"com/upuphone/xr/sapp/vu/fragment/CommonH5Fragment$initWebView$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onReceivedError", "errorCode", "", "description", "failingUrl", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CommonH5Fragment$initWebView$1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebSettings f8062a;
    public final /* synthetic */ CommonH5Fragment b;

    public CommonH5Fragment$initWebView$1(WebSettings webSettings, CommonH5Fragment commonH5Fragment) {
        this.f8062a = webSettings;
        this.b = commonH5Fragment;
    }

    public static final void c(CommonH5Fragment commonH5Fragment, View view) {
        Intrinsics.checkNotNullParameter(commonH5Fragment, "this$0");
        AppUtils appUtils = AppUtils.f7842a;
        FragmentActivity requireActivity = commonH5Fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        AppUtils.q(appUtils, requireActivity, 0, 2, (Object) null);
    }

    public static final void d(CommonH5Fragment commonH5Fragment, View view) {
        Intrinsics.checkNotNullParameter(commonH5Fragment, "this$0");
        commonH5Fragment.o0();
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f8062a.setBlockNetworkImage(false);
        if (this.b.e) {
            this.b.m0().setVisibility(8);
        } else {
            this.b.m0().setVisibility(0);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        FragmentCommonH5Binding h0 = this.b.f;
        FragmentCommonH5Binding fragmentCommonH5Binding = null;
        if (h0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            h0 = null;
        }
        h0.g.setVisibility(8);
        FragmentCommonH5Binding h02 = this.b.f;
        if (h02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            h02 = null;
        }
        h02.c.setVisibility(0);
        this.b.e = true;
        this.b.m0().setVisibility(0);
        ULog.f6446a.a("CommonH5Fragment", "onReceivedError" + i + str);
        if (this.b.isAdded()) {
            if (i == -2) {
                Intrinsics.checkNotNull(str);
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) "ERR_INTERNET_DISCONNECTED", false, 2, (Object) null)) {
                    FragmentCommonH5Binding h03 = this.b.f;
                    if (h03 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        h03 = null;
                    }
                    h03.d.setOnClickListener(new b(this.b));
                    FragmentCommonH5Binding h04 = this.b.f;
                    if (h04 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        h04 = null;
                    }
                    h04.d.setText(this.b.getString(R.string.network_setting));
                    FragmentCommonH5Binding h05 = this.b.f;
                    if (h05 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentCommonH5Binding = h05;
                    }
                    fragmentCommonH5Binding.e.setText(this.b.getString(R.string.network_not_available_pls_check));
                    return;
                }
            }
            FragmentCommonH5Binding h06 = this.b.f;
            if (h06 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                h06 = null;
            }
            h06.d.setText(this.b.getString(R.string.retry));
            FragmentCommonH5Binding h07 = this.b.f;
            if (h07 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                h07 = null;
            }
            h07.e.setText(this.b.getString(R.string.network_error_pls_retry_later));
            FragmentCommonH5Binding h08 = this.b.f;
            if (h08 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentCommonH5Binding = h08;
            }
            fragmentCommonH5Binding.d.setOnClickListener(new c(this.b));
        }
    }
}
