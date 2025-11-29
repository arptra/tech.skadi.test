package com.upuphone.xr.sapp.fragment;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.databinding.FragmentHelpFeedbackH5Binding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/fragment/H5HelpFeedbackFragment$initWebView$webChromeClient$1", "Landroid/webkit/WebChromeClient;", "onProgressChanged", "", "view", "Landroid/webkit/WebView;", "newProgress", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class H5HelpFeedbackFragment$initWebView$webChromeClient$1 extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5HelpFeedbackFragment f6973a;

    public H5HelpFeedbackFragment$initWebView$webChromeClient$1(H5HelpFeedbackFragment h5HelpFeedbackFragment) {
        this.f6973a = h5HelpFeedbackFragment;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (i == 100) {
            FragmentHelpFeedbackH5Binding F0 = this.f6973a.j;
            FragmentHelpFeedbackH5Binding fragmentHelpFeedbackH5Binding = null;
            if (F0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                F0 = null;
            }
            if (F0.j.h()) {
                FragmentHelpFeedbackH5Binding F02 = this.f6973a.j;
                if (F02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentHelpFeedbackH5Binding = F02;
                }
                fragmentHelpFeedbackH5Binding.j.setRefreshing(false);
                ULog.f6446a.a("HelpFeedbackH5Fragment", "refreshlayout stop");
            }
        }
    }
}
