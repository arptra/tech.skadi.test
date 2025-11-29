package com.upuphone.xr.sapp.fragment;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentUserGuideBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/upuphone/xr/sapp/fragment/UserGuideFragment$webViewClient$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UserGuideFragment$webViewClient$1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserGuideFragment f7013a;

    public UserGuideFragment$webViewClient$1(UserGuideFragment userGuideFragment) {
        this.f7013a = userGuideFragment;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        ULog.f6446a.a("UserGuideFragment", "onPageFinished");
        if (!this.f7013a.e) {
            this.f7013a.D0();
            this.f7013a.y0(str);
        }
        WebSettings settings = this.f7013a.A0().getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        settings.setBlockNetworkImage(false);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f7013a.g = str;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("UserGuideFragment", "onPageStarted url" + str);
        this.f7013a.e = false;
        this.f7013a.showLoading();
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Intrinsics.checkNotNullParameter(webResourceRequest, "request");
        Intrinsics.checkNotNullParameter(webResourceError, "error");
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        ULog.Delegate delegate = ULog.f6446a;
        int errorCode = webResourceError.getErrorCode();
        CharSequence description = webResourceError.getDescription();
        delegate.a("UserGuideFragment", "onReceivedError" + errorCode + description);
        this.f7013a.A0().setVisibility(0);
        if (webResourceError.getErrorCode() == -2) {
            CharSequence description2 = webResourceError.getDescription();
            Intrinsics.checkNotNull(description2);
            TextView textView = null;
            if (StringsKt.contains$default(description2, (CharSequence) "ERR_INTERNET_DISCONNECTED", false, 2, (Object) null)) {
                FragmentUserGuideBinding k0 = this.f7013a.f7012a;
                TextView textView2 = k0 != null ? k0.d : null;
                if (textView2 != null) {
                    textView2.setText(this.f7013a.getString(R.string.network_setting));
                }
                FragmentUserGuideBinding k02 = this.f7013a.f7012a;
                if (k02 != null) {
                    textView = k02.e;
                }
                if (textView != null) {
                    textView.setText(this.f7013a.getString(R.string.network_not_available_pls_check));
                }
                this.f7013a.e = true;
                UserGuideFragment userGuideFragment = this.f7013a;
                String string = userGuideFragment.getString(R.string.network_setting);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = this.f7013a.getString(R.string.network_not_available_pls_check);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                userGuideFragment.E0(string, string2, new UserGuideFragment$webViewClient$1$onReceivedError$1(this.f7013a));
                return;
            }
        }
        int errorCode2 = webResourceError.getErrorCode();
        if (errorCode2 == -8 || errorCode2 == -6) {
            this.f7013a.e = true;
            UserGuideFragment userGuideFragment2 = this.f7013a;
            String string3 = userGuideFragment2.getString(R.string.retry);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = this.f7013a.getString(R.string.network_error_pls_retry_later);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            userGuideFragment2.E0(string3, string4, new UserGuideFragment$webViewClient$1$onReceivedError$2(this.f7013a));
        }
    }
}
