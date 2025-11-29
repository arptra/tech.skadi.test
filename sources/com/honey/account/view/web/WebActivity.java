package com.honey.account.view.web;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.ActionBar;
import com.honey.account.AccountHelper;
import com.honey.account.R;
import com.honey.account.controller.LoginController;
import com.honey.account.o2.a;
import com.honey.account.utils.network.NetworkUtilsKt;
import com.honey.account.utils.system.UiModeUtilsKt;
import com.meizu.common.widget.MzPAGEmptyLayout;
import dagger.hilt.android.AndroidEntryPoint;
import flyme.support.v7.app.AppCompatDelegate;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0015J\b\u0010\u0017\u001a\u00020\nH\u0014J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0010H\u0014J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/honey/account/view/web/WebActivity;", "Lcom/honey/account/view/BaseCompatActivity;", "()V", "pagEmptyLayout", "Lcom/meizu/common/widget/MzPAGEmptyLayout;", "webNightMode", "", "webView", "Landroid/webkit/WebView;", "callJs", "", "cbName", "param", "getResources", "Landroid/content/res/Resources;", "loadParam", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "showError", "updateForceDark", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class WebActivity extends Hilt_WebActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String ESIGN_TOKEN = "/action/trtc/pre";
    @NotNull
    private static final String TAG = "WebActivity";
    @NotNull
    private static final String TITLE = "param_title";
    @NotNull
    private static final String URL = "param_url";
    @Nullable
    private MzPAGEmptyLayout pagEmptyLayout;
    @NotNull
    private String webNightMode = "";
    /* access modifiers changed from: private */
    @Nullable
    public WebView webView;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/honey/account/view/web/WebActivity$Companion;", "", "()V", "ESIGN_TOKEN", "", "TAG", "TITLE", "URL", "openPage", "Landroid/content/Intent;", "url", "titleRes", "", "title", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent openPage(@NotNull String str, int i) {
            Intrinsics.checkNotNullParameter(str, "url");
            String string = AccountHelper.INSTANCE.getMApplicationContext().getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return openPage(str, string);
        }

        private Companion() {
        }

        @NotNull
        public final Intent openPage(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intent intent = new Intent();
            intent.putExtra(WebActivity.URL, str);
            intent.putExtra(WebActivity.TITLE, str2);
            intent.setFlags(536870912);
            AccountHelper accountHelper = AccountHelper.INSTANCE;
            intent.setPackage(accountHelper.getMApplicationContext().getPackageName());
            intent.setClass(accountHelper.getMApplicationContext(), WebActivity.class);
            return intent;
        }
    }

    private final void callJs(String str, String str2) {
        if (str != null && str.length() != 0) {
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new WebActivity$callJs$1(this, str, str2, (Continuation<? super WebActivity$callJs$1>) null), 3, (Object) null);
        }
    }

    private final Intent loadParam() {
        Intent intent = getIntent();
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra(URL);
        if (stringExtra == null || stringExtra.length() == 0) {
            showError();
        } else if (!NetworkUtilsKt.isNetworkConnected(this)) {
            MzPAGEmptyLayout mzPAGEmptyLayout = this.pagEmptyLayout;
            if (mzPAGEmptyLayout != null) {
                mzPAGEmptyLayout.startDelay(200);
            }
            MzPAGEmptyLayout mzPAGEmptyLayout2 = this.pagEmptyLayout;
            if (mzPAGEmptyLayout2 == null) {
                return intent;
            }
            mzPAGEmptyLayout2.setVisibility(0);
            return intent;
        } else {
            MzPAGEmptyLayout mzPAGEmptyLayout3 = this.pagEmptyLayout;
            if (mzPAGEmptyLayout3 != null) {
                mzPAGEmptyLayout3.setVisibility(8);
            }
            StringBuilder sb = new StringBuilder(stringExtra);
            sb.append("?");
            sb.append("platform=android");
            sb.append("&");
            sb.append("account_belong=" + AccountHelper.INSTANCE.getMBelong());
            sb.append("&");
            sb.append("access_token=");
            LoginController loginController = LoginController.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            sb.append(loginController.getAuthToken(applicationContext));
            sb.append("&");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("uc_theme=");
            sb2.append(UiModeUtilsKt.isNightMode(this) ? "dark" : "light");
            sb.append(sb2.toString());
            sb.append("&lang=");
            sb.append(Locale.getDefault().getLanguage() + '_' + Locale.getDefault().getCountry());
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
            WebView webView2 = this.webView;
            if (webView2 != null) {
                webView2.loadUrl(sb3);
            }
        }
        String stringExtra2 = intent.getStringExtra(TITLE);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return intent;
        }
        supportActionBar.x(stringExtra2);
        return intent;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$5$lambda$4(WebActivity webActivity, View view) {
        Intrinsics.checkNotNullParameter(webActivity, "this$0");
        webActivity.loadParam();
    }

    private final void showError() {
    }

    private final void updateForceDark() {
        String str = "light";
        String str2 = UiModeUtilsKt.isNightMode(this) ? "dark" : str;
        if (!Intrinsics.areEqual((Object) this.webNightMode, (Object) str2)) {
            this.webNightMode = str2;
            if (UiModeUtilsKt.isNightMode(this)) {
                str = "dark";
            }
            callJs("window.__ucinvoke__.switchTheme", str);
        }
    }

    @NotNull
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        if (configuration.fontScale > 1.12f) {
            configuration.fontScale = 1.12f;
            resources = createConfigurationContext(configuration).getResources();
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        Intrinsics.checkNotNull(resources);
        return resources;
    }

    public void onConfigurationChanged(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        int i = configuration.uiMode & 48;
        if (i == 16) {
            AppCompatDelegate.setDefaultNightMode(1);
            getWindow().getDecorView().setSystemUiVisibility(8192);
        } else if (i == 32) {
            AppCompatDelegate.setDefaultNightMode(2);
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
        Resources resources = getResources();
        Resources.Theme theme = getTheme();
        Intrinsics.checkNotNullExpressionValue(theme, "getTheme(...)");
        int color = resources.getColor(UiModeUtilsKt.getColorByAttr(theme, R.attr.colorSurface), getTheme());
        getWindow().setStatusBarColor(color);
        getWindow().setNavigationBarColor(color);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(R.drawable.honey_action_bar_icon);
            ActionBar supportActionBar2 = getSupportActionBar();
            SpannableString spannableString = new SpannableString(supportActionBar2 != null ? supportActionBar2.f() : null);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getColor(R.color.action_bar_text_color));
            CharSequence f = supportActionBar.f();
            spannableString.setSpan(foregroundColorSpan, 0, f != null ? f.length() : 0, 33);
            supportActionBar.x(spannableString);
            supportActionBar.n(new ColorDrawable(color));
        }
        updateForceDark();
    }

    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_web);
        MzPAGEmptyLayout mzPAGEmptyLayout = (MzPAGEmptyLayout) findViewById(R.id.internet_layout);
        WebView webView2 = null;
        if (mzPAGEmptyLayout != null) {
            mzPAGEmptyLayout.startDelay(200);
            mzPAGEmptyLayout.setButtonViewClickListener(new a(this));
        } else {
            mzPAGEmptyLayout = null;
        }
        this.pagEmptyLayout = mzPAGEmptyLayout;
        WebView webView3 = (WebView) findViewById(R.id.webview);
        if (webView3 != null) {
            webView3.setBackgroundColor(0);
            webView3.setOverScrollMode(2);
            webView3.setWebChromeClient(new WebActivity$onCreate$2$1(this, webView3));
            webView3.setWebViewClient(new WebActivity$onCreate$2$2(this));
            WebSettings settings = webView3.getSettings();
            settings.setTextZoom(100);
            settings.setSupportZoom(true);
            settings.setUseWideViewPort(true);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setAllowContentAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setLoadWithOverviewMode(true);
            settings.setMediaPlaybackRequiresUserGesture(false);
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setCacheMode(-1);
            settings.setMixedContentMode(1);
            settings.setAllowFileAccess(true);
            settings.setAllowContentAccess(true);
            webView3.addJavascriptInterface(new WebJs(webView3, this), "__ucjsbridge__");
            webView2 = webView3;
        }
        this.webView = webView2;
        updateForceDark();
        loadParam();
    }

    public void onDestroy() {
        super.onDestroy();
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.destroy();
        }
        this.webView = null;
    }

    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
    }
}
