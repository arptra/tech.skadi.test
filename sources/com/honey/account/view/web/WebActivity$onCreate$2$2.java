package com.honey.account.view.web;

import android.content.DialogInterface;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.honey.account.R;
import com.honey.account.o2.d;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/honey/account/view/web/WebActivity$onCreate$2$2", "Landroid/webkit/WebViewClient;", "onReceivedSslError", "", "view", "Landroid/webkit/WebView;", "handler", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "shouldOverrideUrlLoading", "", "request", "Landroid/webkit/WebResourceRequest;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WebActivity$onCreate$2$2 extends WebViewClient {
    final /* synthetic */ WebActivity this$0;

    public WebActivity$onCreate$2$2(WebActivity webActivity) {
        this.this$0 = webActivity;
    }

    /* access modifiers changed from: private */
    public static final void onReceivedSslError$lambda$0(SslErrorHandler sslErrorHandler, WebActivity webActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(webActivity, "this$0");
        if (sslErrorHandler != null) {
            sslErrorHandler.cancel();
        }
        webActivity.finish();
    }

    public void onReceivedSslError(@Nullable WebView webView, @Nullable SslErrorHandler sslErrorHandler, @Nullable SslError sslError) {
        new AlertDialog.Builder(this.this$0).setMessage(R.string.ssl_alert_title).setPositiveButton(R.string.cancel, (DialogInterface.OnClickListener) new d(sslErrorHandler, this.this$0)).create().show();
    }

    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest) {
        String str;
        Uri url;
        if (webView == null) {
            return true;
        }
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (str = url.toString()) == null) {
            str = "";
        }
        webView.loadUrl(str);
        return true;
    }
}
