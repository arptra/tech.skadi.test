package com.upuphone.xr.sapp.fragment;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentHelpFeedbackH5Binding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J.\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¨\u0006\u0017"}, d2 = {"com/upuphone/xr/sapp/fragment/H5HelpFeedbackFragment$initWebView$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onReceivedError", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "request", "Landroid/webkit/WebResourceRequest;", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class H5HelpFeedbackFragment$initWebView$1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebSettings f6972a;
    public final /* synthetic */ H5HelpFeedbackFragment b;

    public H5HelpFeedbackFragment$initWebView$1(WebSettings webSettings, H5HelpFeedbackFragment h5HelpFeedbackFragment) {
        this.f6972a = webSettings;
        this.b = h5HelpFeedbackFragment;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f6972a.setBlockNetworkImage(false);
        if (this.b.r) {
            this.b.K0().setVisibility(8);
        } else {
            this.b.K0().setVisibility(0);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        FragmentHelpFeedbackH5Binding F0 = this.b.j;
        FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding = null;
        if (F0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            F0 = null;
        }
        F0.j.setVisibility(8);
        FragmentHelpFeedbackH5Binding F02 = this.b.j;
        if (F02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            F02 = null;
        }
        F02.d.setVisibility(0);
        this.b.r = true;
        this.b.K0().setVisibility(0);
        ULog.f6446a.a("HelpFeedbackH5Fragment", "onReceivedError" + i + str);
        if (this.b.isAdded()) {
            if (i == -2) {
                Intrinsics.checkNotNull(str);
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) "ERR_INTERNET_DISCONNECTED", false, 2, (Object) null)) {
                    FragmentHelpFeedbackH5Binding F03 = this.b.j;
                    if (F03 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        F03 = null;
                    }
                    F03.e.setText(this.b.getString(R.string.network_setting));
                    FragmentHelpFeedbackH5Binding F04 = this.b.j;
                    if (F04 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentHelpFeedbackH5Binding = F04;
                    }
                    fragmentHelpFeedbackH5Binding.f.setText(this.b.getString(R.string.network_not_available_pls_check));
                    this.b.q = true;
                    return;
                }
            }
            FragmentHelpFeedbackH5Binding F05 = this.b.j;
            if (F05 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                F05 = null;
            }
            F05.e.setText(this.b.getString(R.string.retry));
            FragmentHelpFeedbackH5Binding F06 = this.b.j;
            if (F06 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentHelpFeedbackH5Binding = F06;
            }
            fragmentHelpFeedbackH5Binding.f.setText(this.b.getString(R.string.network_error_pls_retry_later));
            this.b.q = false;
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        ULog.Delegate delegate = ULog.f6446a;
        String str = null;
        Integer valueOf = webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null;
        if (webResourceResponse != null) {
            str = webResourceResponse.getReasonPhrase();
        }
        delegate.a("HelpFeedbackH5Fragment", "onReceivedHttpError code=" + valueOf + " msg=" + str + " ");
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        ULog.Delegate delegate = ULog.f6446a;
        String sslError2 = sslError != null ? sslError.toString() : null;
        delegate.a("HelpFeedbackH5Fragment", "onReceivedSslError" + sslError2);
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }
}
