package flyme.support.v7.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import flyme.support.v7.util.ResourceUtils;

public class WebViewActivity extends AppCompatActivity {
    public static final String KEY_ENABLE_FORCE_DARK = "key_enable_force_dark";
    public static final String KEY_ENABLE_JAVA_SCRIPT = "KEY_ENABLE_JAVA_SCRIPT";
    public static final String KEY_TITLE = "KEY_TITLE";
    public static final String KEY_URL = "KEY_URL";
    /* access modifiers changed from: private */
    public static WebClientListener mListener;
    private boolean mForceDark;
    /* access modifiers changed from: private */
    public int mNavBarHeight = 0;
    private WebView mWebView;

    public interface WebClientListener {
        void onUrlLoading(WebView webView, String str);
    }

    private void initActionBar() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setTitle((CharSequence) getIntent().getStringExtra(KEY_TITLE));
        }
    }

    public static void openUrl(Context context, @Nullable String str, @NonNull String str2) {
        openUrl(context, str, str2, false);
    }

    @RequiresApi
    private void setNavigationBarIconColor(boolean z) {
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 16 : systemUiVisibility & -17);
    }

    public static void setOnWenClientListener(WebClientListener webClientListener) {
        if (mListener == null) {
            mListener = webClientListener;
        }
    }

    @RequiresApi
    private void setStatusBarIconColor(boolean z) {
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
    }

    private void updateForceDark(Configuration configuration) {
        int i = Build.VERSION.SDK_INT;
        WebSettings settings = this.mWebView.getSettings();
        boolean isUiModeNight = ResourceUtils.isUiModeNight(configuration);
        if (i >= 33) {
            settings.setAlgorithmicDarkeningAllowed(isUiModeNight);
        }
        if (isUiModeNight) {
            settings.setForceDark(2);
        } else {
            settings.setForceDark(0);
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public boolean isLightNavigationBar() {
        return true;
    }

    public boolean isLightStatusBar() {
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mForceDark) {
            updateForceDark(configuration);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStatusBarIconColor(isLightStatusBar());
        setNavigationBarIconColor(isLightNavigationBar());
        initActionBar();
        this.mWebView = new WebView(this);
        String stringExtra = getIntent().getStringExtra(KEY_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            Log.e("WebViewActivity ", "onCreate: url null");
            return;
        }
        this.mWebView.loadUrl(stringExtra);
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(getIntent().getBooleanExtra(KEY_ENABLE_JAVA_SCRIPT, true));
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        boolean booleanExtra = getIntent().getBooleanExtra(KEY_ENABLE_FORCE_DARK, false);
        this.mForceDark = booleanExtra;
        if (booleanExtra) {
            updateForceDark(getResources().getConfiguration());
        }
        this.mWebView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                webView.loadUrl("javascript:(function(){ document.body.style.paddingBottom = '" + WebViewActivity.this.mNavBarHeight + "px'})();");
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                try {
                    if (WebViewActivity.mListener == null) {
                        return true;
                    }
                    WebViewActivity.mListener.onUrlLoading(webView, str);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(this.mWebView, new FrameLayout.LayoutParams(-1, -1));
        ViewCompat.M0(frameLayout, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                view.setPadding(0, windowInsetsCompat.l(), 0, 0);
                int unused = WebViewActivity.this.mNavBarHeight = windowInsetsCompat.i();
                return windowInsetsCompat.c();
            }
        });
        this.mWebView.setOverScrollMode(2);
        setContentView((View) frameLayout);
    }

    public void onDestroy() {
        super.onDestroy();
        mListener = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public static void openUrl(Context context, @Nullable String str, @NonNull String str2, boolean z) {
        openUrl(context, str, str2, z, false);
    }

    public static void openUrl(Context context, @Nullable String str, @NonNull String str2, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            Log.e("WebViewActivity ", "openUrl: url null");
            return;
        }
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(KEY_TITLE, str);
        intent.putExtra(KEY_URL, str2);
        intent.putExtra(KEY_ENABLE_JAVA_SCRIPT, z);
        intent.putExtra(KEY_ENABLE_FORCE_DARK, z2);
        context.startActivity(intent);
    }
}
