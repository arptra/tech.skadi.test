package com.upuphone.xr.sapp.fragment;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentH5Binding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J.\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\r"}, d2 = {"com/upuphone/xr/sapp/fragment/H5Fragment$initWebView$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onReceivedError", "errorCode", "", "description", "failingUrl", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class H5Fragment$initWebView$1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Fragment f6970a;
    public final /* synthetic */ WebSettings b;

    public H5Fragment$initWebView$1(H5Fragment h5Fragment, WebSettings webSettings) {
        this.f6970a = h5Fragment;
        this.b = webSettings;
    }

    public void onPageFinished(WebView webView, String str) {
        ULog.Delegate delegate = ULog.f6446a;
        int w0 = this.f6970a.i;
        delegate.a("H5Fragment", "onPageFinished webviewScrollY is: " + w0);
        super.onPageFinished(webView, str);
        this.b.setBlockNetworkImage(false);
        if (this.f6970a.l) {
            this.f6970a.D0().setVisibility(8);
        } else {
            this.f6970a.D0().setVisibility(0);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        FragmentH5Binding u0 = this.f6970a.f6969a;
        FragmentH5Binding fragmentH5Binding = null;
        if (u0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            u0 = null;
        }
        u0.l.setVisibility(8);
        FragmentH5Binding u02 = this.f6970a.f6969a;
        if (u02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            u02 = null;
        }
        u02.g.setVisibility(0);
        this.f6970a.l = true;
        this.f6970a.D0().setVisibility(0);
        ULog.f6446a.a("H5Fragment", "onReceivedError" + i + str);
        if (this.f6970a.isAdded()) {
            if (i == -2) {
                Intrinsics.checkNotNull(str);
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) "ERR_INTERNET_DISCONNECTED", false, 2, (Object) null)) {
                    FragmentH5Binding u03 = this.f6970a.f6969a;
                    if (u03 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        u03 = null;
                    }
                    u03.h.setText(this.f6970a.getString(R.string.network_setting));
                    FragmentH5Binding u04 = this.f6970a.f6969a;
                    if (u04 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentH5Binding = u04;
                    }
                    fragmentH5Binding.i.setText(this.f6970a.getString(R.string.network_not_available_pls_check));
                    this.f6970a.k = true;
                    return;
                }
            }
            FragmentH5Binding u05 = this.f6970a.f6969a;
            if (u05 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                u05 = null;
            }
            u05.h.setText(this.f6970a.getString(R.string.retry));
            FragmentH5Binding u06 = this.f6970a.f6969a;
            if (u06 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentH5Binding = u06;
            }
            fragmentH5Binding.i.setText(this.f6970a.getString(R.string.network_error_pls_retry_later));
            this.f6970a.k = false;
        }
    }
}
