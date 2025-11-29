package com.upuphone.xr.sapp.contract;

import android.content.Intent;
import android.webkit.ValueCallback;
import androidx.activity.result.ActivityResultLauncher;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.databinding.ActivityProtocolBinding;
import com.upuphone.xr.sapp.utils.WebViewStateDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J!\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0016\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/upuphone/xr/sapp/contract/ProtocolActivity$initWebView$webViewStateDelegate$1", "Lcom/upuphone/xr/sapp/utils/WebViewStateDelegate$OnWebViewStateListener;", "", "title", "", "b", "(Ljava/lang/String;)V", "", "newProgress", "onProgress", "(I)V", "url", "d", "errorState", "a", "(Ljava/lang/String;I)V", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "filePathCallback", "Landroid/content/Intent;", "intent", "c", "(Landroid/webkit/ValueCallback;Landroid/content/Intent;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ProtocolActivity$initWebView$webViewStateDelegate$1 implements WebViewStateDelegate.OnWebViewStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProtocolActivity f6698a;

    public ProtocolActivity$initWebView$webViewStateDelegate$1(ProtocolActivity protocolActivity) {
        this.f6698a = protocolActivity;
    }

    public void a(String str, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ProtocolActivity", "onReceiveError: " + i);
        this.f6698a.V0(i);
    }

    public void b(String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ProtocolActivity", "onReceiveTitle: " + str);
        if (this.f6698a.j == 0) {
            ActivityProtocolBinding B0 = this.f6698a.b;
            if (B0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                B0 = null;
            }
            B0.b.setText(str);
        }
    }

    public void c(ValueCallback valueCallback, Intent intent) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ProtocolActivity", "onShowFileChooser: filePathCallback=" + valueCallback + ", intent=" + intent);
        this.f6698a.e = valueCallback;
        if (this.f6698a.e != null && intent != null) {
            ActivityResultLauncher D0 = this.f6698a.d;
            if (D0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileChooserLauncher");
                D0 = null;
            }
            D0.a(intent);
        }
    }

    public void d(String str) {
        if (str != null) {
            this.f6698a.i = str;
        }
    }

    public void onProgress(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ProtocolActivity", "onProgress: " + i);
        if (i == 100) {
            ActivityProtocolBinding B0 = this.f6698a.b;
            ActivityProtocolBinding activityProtocolBinding = null;
            if (B0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                B0 = null;
            }
            if (B0.c.h()) {
                delegate.a("ProtocolActivity", "refresh over");
                ActivityProtocolBinding B02 = this.f6698a.b;
                if (B02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityProtocolBinding = B02;
                }
                activityProtocolBinding.c.setRefreshing(false);
            }
        }
    }
}
