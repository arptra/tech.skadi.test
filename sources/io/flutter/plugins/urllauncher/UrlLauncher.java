package io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import io.flutter.plugins.urllauncher.Messages;
import java.util.Collections;
import java.util.Map;

final class UrlLauncher implements Messages.UrlLauncherApi {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "UrlLauncher";
    @Nullable
    private Activity activity;
    @NonNull
    private final Context applicationContext;
    @NonNull
    private final IntentResolver intentResolver;

    @VisibleForTesting
    public interface IntentResolver {
        String getHandlerComponentName(@NonNull Intent intent);
    }

    @VisibleForTesting
    public UrlLauncher(@NonNull Context context, @NonNull IntentResolver intentResolver2) {
        this.applicationContext = context;
        this.intentResolver = intentResolver2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean containsRestrictedHeader(java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            r0 = 1
            r1 = 0
            java.util.Set r5 = r5.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x000a:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0057
            java.lang.Object r2 = r5.next()
            java.lang.String r2 = (java.lang.String) r2
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r2 = r2.toLowerCase(r3)
            r2.hashCode()
            r3 = -1
            int r4 = r2.hashCode()
            switch(r4) {
                case -1423461112: goto L_0x0049;
                case -1229727188: goto L_0x003e;
                case 785670158: goto L_0x0033;
                case 802785917: goto L_0x0028;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x0053
        L_0x0028:
            java.lang.String r4 = "accept-language"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0031
            goto L_0x0053
        L_0x0031:
            r3 = 3
            goto L_0x0053
        L_0x0033:
            java.lang.String r4 = "content-type"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x003c
            goto L_0x0053
        L_0x003c:
            r3 = 2
            goto L_0x0053
        L_0x003e:
            java.lang.String r4 = "content-language"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0047
            goto L_0x0053
        L_0x0047:
            r3 = r0
            goto L_0x0053
        L_0x0049:
            java.lang.String r4 = "accept"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r3 = r1
        L_0x0053:
            switch(r3) {
                case 0: goto L_0x000a;
                case 1: goto L_0x000a;
                case 2: goto L_0x000a;
                case 3: goto L_0x000a;
                default: goto L_0x0056;
            }
        L_0x0056:
            return r0
        L_0x0057:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.urllauncher.UrlLauncher.containsRestrictedHeader(java.util.Map):boolean");
    }

    private void ensureActivity() {
        if (this.activity == null) {
            throw new Messages.FlutterError("NO_ACTIVITY", "Launching a URL requires a foreground activity.", (Object) null);
        }
    }

    @NonNull
    private static Bundle extractBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String next : map.keySet()) {
            bundle.putString(next, map.get(next));
        }
        return bundle;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$0(Context context, Intent intent) {
        ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
        if (resolveActivity == null) {
            return null;
        }
        return resolveActivity.toShortString();
    }

    private static boolean openCustomTab(@NonNull Context context, @NonNull Uri uri, @NonNull Bundle bundle, @NonNull Messages.BrowserOptions browserOptions) {
        CustomTabsIntent a2 = new CustomTabsIntent.Builder().e(browserOptions.getShowTitle().booleanValue()).a();
        a2.f418a.putExtra("com.android.browser.headers", bundle);
        try {
            a2.a(context, uri);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    @NonNull
    public Boolean canLaunchUrl(@NonNull String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        String handlerComponentName = this.intentResolver.getHandlerComponentName(intent);
        return handlerComponentName == null ? Boolean.FALSE : Boolean.valueOf(!"{com.android.fallback/com.android.fallback.Fallback}".equals(handlerComponentName));
    }

    public void closeWebView() {
        this.applicationContext.sendBroadcast(new Intent(WebViewActivity.ACTION_CLOSE));
    }

    @NonNull
    public Boolean launchUrl(@NonNull String str, @NonNull Map<String, String> map) {
        ensureActivity();
        try {
            this.activity.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", extractBundle(map)));
            return Boolean.TRUE;
        } catch (ActivityNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    @NonNull
    public Boolean openUrlInApp(@NonNull String str, @NonNull Boolean bool, @NonNull Messages.WebViewOptions webViewOptions, @NonNull Messages.BrowserOptions browserOptions) {
        ensureActivity();
        Bundle extractBundle = extractBundle(webViewOptions.getHeaders());
        if (bool.booleanValue() && !containsRestrictedHeader(webViewOptions.getHeaders())) {
            if (openCustomTab(this.activity, Uri.parse(str), extractBundle, browserOptions)) {
                return Boolean.TRUE;
            }
        }
        try {
            this.activity.startActivity(WebViewActivity.createIntent(this.activity, str, webViewOptions.getEnableJavaScript().booleanValue(), webViewOptions.getEnableDomStorage().booleanValue(), extractBundle));
            return Boolean.TRUE;
        } catch (ActivityNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    public void setActivity(@Nullable Activity activity2) {
        this.activity = activity2;
    }

    @NonNull
    public Boolean supportsCustomTabs() {
        return Boolean.valueOf(CustomTabsClient.a(this.applicationContext, Collections.emptyList()) != null);
    }

    public UrlLauncher(@NonNull Context context) {
        this(context, new a(context));
    }
}
