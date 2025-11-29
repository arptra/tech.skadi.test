package com.upuphone.xr.sapp.fragment;

import android.content.Intent;
import android.webkit.ValueCallback;
import com.upuphone.xr.sapp.utils.WebViewStateDelegate;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/fragment/ChatGptHistoryH5Fragment$initWebView$webViewStateDelegate$1", "Lcom/upuphone/xr/sapp/utils/WebViewStateDelegate$OnWebViewStateListener;", "", "url", "", "errorState", "", "a", "(Ljava/lang/String;I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ChatGptHistoryH5Fragment$initWebView$webViewStateDelegate$1 implements WebViewStateDelegate.OnWebViewStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatGptHistoryH5Fragment f6946a;

    public ChatGptHistoryH5Fragment$initWebView$webViewStateDelegate$1(ChatGptHistoryH5Fragment chatGptHistoryH5Fragment) {
        this.f6946a = chatGptHistoryH5Fragment;
    }

    public void a(String str, int i) {
        this.f6946a.O0(i);
    }

    public void b(String str) {
        WebViewStateDelegate.OnWebViewStateListener.DefaultImpls.c(this, str);
    }

    public void c(ValueCallback valueCallback, Intent intent) {
        WebViewStateDelegate.OnWebViewStateListener.DefaultImpls.d(this, valueCallback, intent);
    }

    public void d(String str) {
        WebViewStateDelegate.OnWebViewStateListener.DefaultImpls.a(this, str);
    }

    public void onProgress(int i) {
        WebViewStateDelegate.OnWebViewStateListener.DefaultImpls.b(this, i);
    }
}
