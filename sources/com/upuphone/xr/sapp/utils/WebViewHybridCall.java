package com.upuphone.xr.sapp.utils;

import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/utils/WebViewHybridCall;", "", "<init>", "()V", "", "closeWebPage", "videoPlay", "", "url", "openUrl", "(Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/utils/WebViewHybridCall$IWebCallback;", "a", "Lcom/upuphone/xr/sapp/utils/WebViewHybridCall$IWebCallback;", "getMCallback", "()Lcom/upuphone/xr/sapp/utils/WebViewHybridCall$IWebCallback;", "(Lcom/upuphone/xr/sapp/utils/WebViewHybridCall$IWebCallback;)V", "mCallback", "b", "Companion", "IWebCallback", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WebViewHybridCall {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public IWebCallback f7932a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/utils/WebViewHybridCall$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/utils/WebViewHybridCall$IWebCallback;", "", "", "q", "()V", "E", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface IWebCallback {
        void E();

        void q();
    }

    public final void a(IWebCallback iWebCallback) {
        this.f7932a = iWebCallback;
    }

    @JavascriptInterface
    public final void closeWebPage() {
        ULog.f6446a.a("WebViewHybridCall", "do closeWebPage");
        IWebCallback iWebCallback = this.f7932a;
        if (iWebCallback != null) {
            iWebCallback.q();
        }
    }

    @JavascriptInterface
    public final void openUrl(@Nullable String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WebViewHybridCall", "do openUrl->" + str);
        if (str != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            MainApplication f = MainApplication.k.f();
            if (intent.resolveActivity(f.getPackageManager()) != null) {
                intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                f.startActivity(intent);
            }
        }
    }

    @JavascriptInterface
    public final void videoPlay() {
        ULog.f6446a.a("WebViewHybridCall", "do videoPlay");
        IWebCallback iWebCallback = this.f7932a;
        if (iWebCallback != null) {
            iWebCallback.E();
        }
    }
}
