package io.flutter.plugins.webviewflutter;

import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.honey.account.hb.a3;
import com.honey.account.hb.b3;
import com.honey.account.hb.c3;
import com.honey.account.hb.d3;
import com.honey.account.hb.e3;
import com.honey.account.hb.f3;
import com.honey.account.hb.g3;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.List;
import java.util.Objects;

public class WebChromeClientFlutterApiImpl extends GeneratedAndroidWebView.WebChromeClientFlutterApi {
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;
    private final WebViewFlutterApiImpl webViewFlutterApi;

    /* renamed from: io.flutter.plugins.webviewflutter.WebChromeClientFlutterApiImpl$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$webkit$ConsoleMessage$MessageLevel;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.webkit.ConsoleMessage$MessageLevel[] r0 = android.webkit.ConsoleMessage.MessageLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel = r0
                android.webkit.ConsoleMessage$MessageLevel r1 = android.webkit.ConsoleMessage.MessageLevel.TIP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$webkit$ConsoleMessage$MessageLevel     // Catch:{ NoSuchFieldError -> 0x001d }
                android.webkit.ConsoleMessage$MessageLevel r1 = android.webkit.ConsoleMessage.MessageLevel.LOG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$android$webkit$ConsoleMessage$MessageLevel     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.webkit.ConsoleMessage$MessageLevel r1 = android.webkit.ConsoleMessage.MessageLevel.WARNING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$android$webkit$ConsoleMessage$MessageLevel     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.webkit.ConsoleMessage$MessageLevel r1 = android.webkit.ConsoleMessage.MessageLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$android$webkit$ConsoleMessage$MessageLevel     // Catch:{ NoSuchFieldError -> 0x003e }
                android.webkit.ConsoleMessage$MessageLevel r1 = android.webkit.ConsoleMessage.MessageLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.webviewflutter.WebChromeClientFlutterApiImpl.AnonymousClass1.<clinit>():void");
        }
    }

    public WebChromeClientFlutterApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        super(binaryMessenger2);
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
        this.webViewFlutterApi = new WebViewFlutterApiImpl(binaryMessenger2, instanceManager2);
    }

    private long getIdentifierForClient(WebChromeClient webChromeClient) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webChromeClient);
        if (identifierForStrongReference != null) {
            return identifierForStrongReference.longValue();
        }
        throw new IllegalStateException("Could not find identifier for WebChromeClient.");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onGeolocationPermissionsShowPrompt$3(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onPermissionRequest$4(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onProgressChanged$0(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onShowCustomView$5(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onShowCustomView$6(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onShowFileChooser$1(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onShowFileChooser$2(Void voidR) {
    }

    private static GeneratedAndroidWebView.ConsoleMessageLevel toConsoleMessageLevel(ConsoleMessage.MessageLevel messageLevel) {
        int i = AnonymousClass1.$SwitchMap$android$webkit$ConsoleMessage$MessageLevel[messageLevel.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? GeneratedAndroidWebView.ConsoleMessageLevel.UNKNOWN : GeneratedAndroidWebView.ConsoleMessageLevel.DEBUG : GeneratedAndroidWebView.ConsoleMessageLevel.ERROR : GeneratedAndroidWebView.ConsoleMessageLevel.WARNING : GeneratedAndroidWebView.ConsoleMessageLevel.LOG : GeneratedAndroidWebView.ConsoleMessageLevel.TIP;
    }

    public void onConsoleMessage(@NonNull WebChromeClient webChromeClient, @NonNull ConsoleMessage consoleMessage, @NonNull GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply<Void> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webChromeClient);
        Objects.requireNonNull(identifierForStrongReference);
        super.onConsoleMessage(identifierForStrongReference, new GeneratedAndroidWebView.ConsoleMessage.Builder().setLineNumber(Long.valueOf((long) consoleMessage.lineNumber())).setMessage(consoleMessage.message()).setLevel(toConsoleMessageLevel(consoleMessage.messageLevel())).setSourceId(consoleMessage.sourceId()).build(), reply);
    }

    public void onGeolocationPermissionsHidePrompt(@NonNull WebChromeClient webChromeClient, @NonNull GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply<Void> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webChromeClient);
        Objects.requireNonNull(identifierForStrongReference);
        super.onGeolocationPermissionsHidePrompt(identifierForStrongReference, reply);
    }

    public void onGeolocationPermissionsShowPrompt(@NonNull WebChromeClient webChromeClient, @NonNull String str, @NonNull GeolocationPermissions.Callback callback, @NonNull GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply<Void> reply) {
        new GeolocationPermissionsCallbackFlutterApiImpl(this.binaryMessenger, this.instanceManager).create(callback, new e3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webChromeClient);
        Objects.requireNonNull(identifierForStrongReference);
        Long identifierForStrongReference2 = this.instanceManager.getIdentifierForStrongReference(callback);
        Objects.requireNonNull(identifierForStrongReference2);
        onGeolocationPermissionsShowPrompt(identifierForStrongReference, identifierForStrongReference2, str, reply);
    }

    public void onHideCustomView(@NonNull WebChromeClient webChromeClient, @NonNull GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply<Void> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webChromeClient);
        Objects.requireNonNull(identifierForStrongReference);
        super.onHideCustomView(identifierForStrongReference, reply);
    }

    public void onJsAlert(@NonNull WebChromeClient webChromeClient, @NonNull String str, @NonNull String str2, @NonNull GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply<Void> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webChromeClient);
        Objects.requireNonNull(identifierForStrongReference);
        super.onJsAlert(identifierForStrongReference, str, str2, reply);
    }

    public void onJsConfirm(@NonNull WebChromeClient webChromeClient, @NonNull String str, @NonNull String str2, @NonNull GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply<Boolean> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webChromeClient);
        Objects.requireNonNull(identifierForStrongReference);
        super.onJsConfirm(identifierForStrongReference, str, str2, reply);
    }

    public void onJsPrompt(@NonNull WebChromeClient webChromeClient, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply<String> reply) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webChromeClient);
        Objects.requireNonNull(identifierForStrongReference);
        super.onJsPrompt(identifierForStrongReference, str, str2, str3, reply);
    }

    @RequiresApi
    public void onPermissionRequest(@NonNull WebChromeClient webChromeClient, @NonNull PermissionRequest permissionRequest, @NonNull GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply<Void> reply) {
        new PermissionRequestFlutterApiImpl(this.binaryMessenger, this.instanceManager).create(permissionRequest, permissionRequest.getResources(), new c3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webChromeClient);
        Objects.requireNonNull(identifierForStrongReference);
        Long identifierForStrongReference2 = this.instanceManager.getIdentifierForStrongReference(permissionRequest);
        Objects.requireNonNull(identifierForStrongReference2);
        super.onPermissionRequest(identifierForStrongReference, identifierForStrongReference2, reply);
    }

    public void onProgressChanged(@NonNull WebChromeClient webChromeClient, @NonNull WebView webView, @NonNull Long l, @NonNull GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new d3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        super.onProgressChanged(Long.valueOf(getIdentifierForClient(webChromeClient)), identifierForStrongReference, l, reply);
    }

    public void onShowCustomView(@NonNull WebChromeClient webChromeClient, @NonNull View view, @NonNull WebChromeClient.CustomViewCallback customViewCallback, @NonNull GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply<Void> reply) {
        new ViewFlutterApiImpl(this.binaryMessenger, this.instanceManager).create(view, new f3());
        new CustomViewCallbackFlutterApiImpl(this.binaryMessenger, this.instanceManager).create(customViewCallback, new g3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webChromeClient);
        Objects.requireNonNull(identifierForStrongReference);
        Long identifierForStrongReference2 = this.instanceManager.getIdentifierForStrongReference(view);
        Objects.requireNonNull(identifierForStrongReference2);
        Long identifierForStrongReference3 = this.instanceManager.getIdentifierForStrongReference(customViewCallback);
        Objects.requireNonNull(identifierForStrongReference3);
        onShowCustomView(identifierForStrongReference, identifierForStrongReference2, identifierForStrongReference3, reply);
    }

    @RequiresApi
    public void onShowFileChooser(@NonNull WebChromeClient webChromeClient, @NonNull WebView webView, @NonNull WebChromeClient.FileChooserParams fileChooserParams, @NonNull GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply<List<String>> reply) {
        this.webViewFlutterApi.create(webView, new a3());
        new FileChooserParamsFlutterApiImpl(this.binaryMessenger, this.instanceManager).create(fileChooserParams, new b3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webChromeClient);
        Objects.requireNonNull(identifierForStrongReference);
        Long identifierForStrongReference2 = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference2);
        Long identifierForStrongReference3 = this.instanceManager.getIdentifierForStrongReference(fileChooserParams);
        Objects.requireNonNull(identifierForStrongReference3);
        onShowFileChooser(identifierForStrongReference, identifierForStrongReference2, identifierForStrongReference3, reply);
    }
}
