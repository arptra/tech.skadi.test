package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.honey.account.hb.y2;
import com.honey.account.hb.z2;

public class JavaScriptChannel {
    private final JavaScriptChannelFlutterApiImpl flutterApi;
    final String javaScriptChannelName;
    private final Handler platformThreadHandler;

    public JavaScriptChannel(@NonNull JavaScriptChannelFlutterApiImpl javaScriptChannelFlutterApiImpl, @NonNull String str, @NonNull Handler handler) {
        this.flutterApi = javaScriptChannelFlutterApiImpl;
        this.javaScriptChannelName = str;
        this.platformThreadHandler = handler;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$postMessage$0(Void voidR) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$1(String str) {
        this.flutterApi.postMessage(this, str, new y2());
    }

    @JavascriptInterface
    public void postMessage(@NonNull String str) {
        z2 z2Var = new z2(this, str);
        if (this.platformThreadHandler.getLooper() == Looper.myLooper()) {
            z2Var.run();
        } else {
            this.platformThreadHandler.post(z2Var);
        }
    }
}
