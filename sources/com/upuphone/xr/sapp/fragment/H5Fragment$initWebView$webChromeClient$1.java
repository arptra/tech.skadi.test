package com.upuphone.xr.sapp.fragment;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.databinding.FragmentH5Binding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/upuphone/xr/sapp/fragment/H5Fragment$initWebView$webChromeClient$1", "Landroid/webkit/WebChromeClient;", "onHideCustomView", "", "onProgressChanged", "view", "Landroid/webkit/WebView;", "newProgress", "", "onShowCustomView", "Landroid/view/View;", "callback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class H5Fragment$initWebView$webChromeClient$1 extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Fragment f6971a;

    public H5Fragment$initWebView$webChromeClient$1(H5Fragment h5Fragment) {
        this.f6971a = h5Fragment;
    }

    public void onHideCustomView() {
        super.onHideCustomView();
        ULog.f6446a.a("H5Fragment", "onHideCustomView");
        this.f6971a.H0();
    }

    public void onProgressChanged(WebView webView, int i) {
        if (i == 100) {
            FragmentH5Binding u0 = this.f6971a.f6969a;
            FragmentH5Binding fragmentH5Binding = null;
            if (u0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                u0 = null;
            }
            if (u0.l.h()) {
                FragmentH5Binding u02 = this.f6971a.f6969a;
                if (u02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentH5Binding = u02;
                }
                fragmentH5Binding.l.setRefreshing(false);
                ULog.f6446a.a("H5Fragment", "refreshlayout stop");
            }
        }
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
        ULog.f6446a.a("H5Fragment", "onShowCustomView");
        this.f6971a.U0(view, customViewCallback);
    }
}
