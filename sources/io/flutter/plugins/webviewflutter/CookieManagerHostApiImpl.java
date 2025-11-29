package io.flutter.plugins.webviewflutter;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebView;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.honey.account.hb.a;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.Objects;

public class CookieManagerHostApiImpl implements GeneratedAndroidWebView.CookieManagerHostApi {
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;
    private final CookieManagerProxy proxy;
    @NonNull
    private final AndroidSdkChecker sdkChecker;

    @VisibleForTesting
    public interface AndroidSdkChecker {
        @ChecksSdkIntAtLeast
        boolean sdkIsAtLeast(int i);
    }

    @VisibleForTesting
    public static class CookieManagerProxy {
        @NonNull
        public CookieManager getInstance() {
            return CookieManager.getInstance();
        }
    }

    public CookieManagerHostApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        this(binaryMessenger2, instanceManager2, new CookieManagerProxy());
    }

    @NonNull
    private CookieManager getCookieManagerInstance(@NonNull Long l) {
        CookieManager cookieManager = (CookieManager) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(cookieManager);
        return cookieManager;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    private boolean removeCookiesPreL(CookieManager cookieManager) {
        boolean hasCookies = cookieManager.hasCookies();
        if (hasCookies) {
            cookieManager.removeAllCookie();
        }
        return hasCookies;
    }

    public void attachInstance(@NonNull Long l) {
        this.instanceManager.addDartCreatedInstance(this.proxy.getInstance(), l.longValue());
    }

    public void removeAllCookies(@NonNull Long l, @NonNull GeneratedAndroidWebView.Result<Boolean> result) {
        if (this.sdkChecker.sdkIsAtLeast(21)) {
            CookieManager cookieManagerInstance = getCookieManagerInstance(l);
            Objects.requireNonNull(result);
            cookieManagerInstance.removeAllCookies(new a(result));
            return;
        }
        result.success(Boolean.valueOf(removeCookiesPreL(getCookieManagerInstance(l))));
    }

    public void setAcceptThirdPartyCookies(@NonNull Long l, @NonNull Long l2, @NonNull Boolean bool) {
        if (this.sdkChecker.sdkIsAtLeast(21)) {
            CookieManager cookieManagerInstance = getCookieManagerInstance(l);
            WebView webView = (WebView) this.instanceManager.getInstance(l2.longValue());
            Objects.requireNonNull(webView);
            cookieManagerInstance.setAcceptThirdPartyCookies(webView, bool.booleanValue());
            return;
        }
        throw new UnsupportedOperationException("`setAcceptThirdPartyCookies` is unsupported on versions below `Build.VERSION_CODES.LOLLIPOP`.");
    }

    public void setCookie(@NonNull Long l, @NonNull String str, @NonNull String str2) {
        getCookieManagerInstance(l).setCookie(str, str2);
    }

    @VisibleForTesting
    public CookieManagerHostApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2, @NonNull CookieManagerProxy cookieManagerProxy) {
        this(binaryMessenger2, instanceManager2, cookieManagerProxy, new a());
    }

    @VisibleForTesting
    public CookieManagerHostApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2, @NonNull CookieManagerProxy cookieManagerProxy, @NonNull AndroidSdkChecker androidSdkChecker) {
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
        this.proxy = cookieManagerProxy;
        this.sdkChecker = androidSdkChecker;
    }
}
