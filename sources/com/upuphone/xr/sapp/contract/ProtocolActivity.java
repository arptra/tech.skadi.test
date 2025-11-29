package com.upuphone.xr.sapp.contract;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.honey.account.e8.e;
import com.honey.account.e8.f;
import com.honey.account.e8.g;
import com.honey.account.e8.h;
import com.honey.account.e8.i;
import com.honey.account.e8.j;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BaseActivity;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.ActivityProtocolBinding;
import com.upuphone.xr.sapp.databinding.LayoutLoadFailBinding;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import com.upuphone.xr.sapp.utils.WebViewStateDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.eclipse.jetty.util.URIUtil;

@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\b\b*\u0001?\u0018\u0000 C2\u00020\u0001:\u0002DEB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0003R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010)\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u0002008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00102R$\u0010<\u001a\u0002062\u0006\u00107\u001a\u0002068\u0002@BX\u000e¢\u0006\f\n\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010,R\u0014\u0010B\u001a\u00020?8\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006F"}, d2 = {"Lcom/upuphone/xr/sapp/contract/ProtocolActivity;", "Lcom/upuphone/xr/sapp/BaseActivity;", "<init>", "()V", "", "initView", "S0", "U0", "W0", "M0", "L0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onBackPressed", "onDestroy", "finish", "Lcom/upuphone/xr/sapp/databinding/ActivityProtocolBinding;", "b", "Lcom/upuphone/xr/sapp/databinding/ActivityProtocolBinding;", "binding", "Lcom/upuphone/xr/sapp/databinding/LayoutLoadFailBinding;", "c", "Lcom/upuphone/xr/sapp/databinding/LayoutLoadFailBinding;", "mErrorBinding", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "d", "Landroidx/activity/result/ActivityResultLauncher;", "fileChooserLauncher", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "e", "Landroid/webkit/ValueCallback;", "fileChooserCallback", "", "f", "Z", "enablePullRefresh", "g", "showTitle", "", "h", "Ljava/lang/String;", "mTitle", "i", "mUrl", "", "value", "j", "I", "V0", "(I)V", "mLoadingState", "k", "needRefresh", "com/upuphone/xr/sapp/contract/ProtocolActivity$networkCallback$1", "l", "Lcom/upuphone/xr/sapp/contract/ProtocolActivity$networkCallback$1;", "networkCallback", "m", "Companion", "WebViewEventListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nProtocolActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProtocolActivity.kt\ncom/upuphone/xr/sapp/contract/ProtocolActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,264:1\n256#2,2:265\n256#2,2:267\n256#2,2:269\n1#3:271\n26#4:272\n*S KotlinDebug\n*F\n+ 1 ProtocolActivity.kt\ncom/upuphone/xr/sapp/contract/ProtocolActivity\n*L\n55#1:265,2\n60#1:267,2\n108#1:269,2\n140#1:272\n*E\n"})
public final class ProtocolActivity extends BaseActivity {
    public static final Companion m = new Companion((DefaultConstructorMarker) null);
    public ActivityProtocolBinding b;
    public LayoutLoadFailBinding c;
    public ActivityResultLauncher d;
    public ValueCallback e;
    public boolean f = true;
    public boolean g = true;
    public String h = "";
    public String i = "";
    public int j;
    public boolean k;
    public final ProtocolActivity$networkCallback$1 l = new ProtocolActivity$networkCallback$1(this);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/contract/ProtocolActivity$Companion;", "", "()V", "DATA", "", "ENABLE_REFRESH", "SHOW_TITLE", "TAG", "TITLE", "URL", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/contract/ProtocolActivity$WebViewEventListener;", "", "(Lcom/upuphone/xr/sapp/contract/ProtocolActivity;)V", "closeWebPage", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class WebViewEventListener {
        public WebViewEventListener() {
        }

        @JavascriptInterface
        public final void closeWebPage() {
            ULog.f6446a.a("ProtocolActivity", "do closeWebPage");
            ProtocolActivity.this.L0();
        }
    }

    public static final void N0(ProtocolActivity protocolActivity, View view) {
        Intrinsics.checkNotNullParameter(protocolActivity, "this$0");
        protocolActivity.finish();
    }

    public static final void O0(ProtocolActivity protocolActivity) {
        Intrinsics.checkNotNullParameter(protocolActivity, "this$0");
        ULog.Delegate delegate = ULog.f6446a;
        String str = protocolActivity.i;
        delegate.a("ProtocolActivity", "refresh, reload url->" + str);
        protocolActivity.U0();
        ActivityProtocolBinding activityProtocolBinding = protocolActivity.b;
        if (activityProtocolBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding = null;
        }
        activityProtocolBinding.c.postDelayed(new i(protocolActivity), 10000);
    }

    public static final void P0(ProtocolActivity protocolActivity) {
        Intrinsics.checkNotNullParameter(protocolActivity, "this$0");
        ActivityProtocolBinding activityProtocolBinding = protocolActivity.b;
        ActivityProtocolBinding activityProtocolBinding2 = null;
        if (activityProtocolBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding = null;
        }
        if (activityProtocolBinding.c.h()) {
            ActivityProtocolBinding activityProtocolBinding3 = protocolActivity.b;
            if (activityProtocolBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityProtocolBinding2 = activityProtocolBinding3;
            }
            activityProtocolBinding2.c.setRefreshing(false);
        }
    }

    public static final void Q0(ProtocolActivity protocolActivity, ViewStub viewStub, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(protocolActivity, "this$0");
        LayoutLoadFailBinding a2 = LayoutLoadFailBinding.a(view);
        protocolActivity.c = a2;
        if (a2 != null && (textView = a2.c) != null) {
            textView.setOnClickListener(new j(protocolActivity));
        }
    }

    public static final void R0(ProtocolActivity protocolActivity, View view) {
        Intrinsics.checkNotNullParameter(protocolActivity, "this$0");
        if (protocolActivity.j == -1) {
            protocolActivity.startActivity(new Intent("android.settings.SETTINGS"));
        } else {
            protocolActivity.U0();
        }
    }

    private final void S0() {
        this.d = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new e(this));
        WebViewStateDelegate webViewStateDelegate = new WebViewStateDelegate(new ProtocolActivity$initWebView$webViewStateDelegate$1(this));
        ActivityProtocolBinding activityProtocolBinding = this.b;
        if (activityProtocolBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding = null;
        }
        WebView webView = activityProtocolBinding.e;
        Intrinsics.checkNotNullExpressionValue(webView, "webView");
        webViewStateDelegate.d(webView);
        U0();
    }

    public static final void T0(ProtocolActivity protocolActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(protocolActivity, "this$0");
        Intrinsics.checkNotNullParameter(activityResult, "result");
        Intent data = activityResult.getData();
        Uri data2 = data != null ? data.getData() : null;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ProtocolActivity", "fileChooserLauncher result: " + data2);
        ValueCallback valueCallback = protocolActivity.e;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(data2 != null ? new Uri[]{data2} : new Uri[0]);
        }
        protocolActivity.e = null;
    }

    /* access modifiers changed from: private */
    public final void U0() {
        V0(0);
        ActivityProtocolBinding activityProtocolBinding = this.b;
        if (activityProtocolBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding = null;
        }
        activityProtocolBinding.e.loadUrl(this.i);
    }

    /* access modifiers changed from: private */
    public final void V0(int i2) {
        this.j = i2;
        ActivityProtocolBinding activityProtocolBinding = this.b;
        TextView textView = null;
        if (activityProtocolBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding = null;
        }
        SwipeRefreshLayout swipeRefreshLayout = activityProtocolBinding.c;
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "refreshLayout");
        int i3 = 0;
        swipeRefreshLayout.setVisibility(i2 == 0 ? 0 : 8);
        if (i2 < 0) {
            ActivityProtocolBinding activityProtocolBinding2 = this.b;
            if (activityProtocolBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityProtocolBinding2 = null;
            }
            if (activityProtocolBinding2.d.getParent() != null) {
                ULog.f6446a.a("ProtocolActivity", "执行懒加载view stub");
                ActivityProtocolBinding activityProtocolBinding3 = this.b;
                if (activityProtocolBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityProtocolBinding3 = null;
                }
                activityProtocolBinding3.d.inflate();
            }
        }
        LayoutLoadFailBinding layoutLoadFailBinding = this.c;
        LinearLayout b2 = layoutLoadFailBinding != null ? layoutLoadFailBinding.getRoot() : null;
        if (b2 != null) {
            if (!(i2 < 0)) {
                i3 = 8;
            }
            b2.setVisibility(i3);
        }
        if (i2 == -2) {
            LayoutLoadFailBinding layoutLoadFailBinding2 = this.c;
            TextView textView2 = layoutLoadFailBinding2 != null ? layoutLoadFailBinding2.d : null;
            if (textView2 != null) {
                textView2.setText(getString(R.string.network_error_pls_retry_later));
            }
            LayoutLoadFailBinding layoutLoadFailBinding3 = this.c;
            if (layoutLoadFailBinding3 != null) {
                textView = layoutLoadFailBinding3.c;
            }
            if (textView != null) {
                textView.setText(getString(R.string.retry));
            }
        } else if (i2 == -1) {
            LayoutLoadFailBinding layoutLoadFailBinding4 = this.c;
            TextView textView3 = layoutLoadFailBinding4 != null ? layoutLoadFailBinding4.d : null;
            if (textView3 != null) {
                textView3.setText(getString(R.string.network_not_available_pls_check));
            }
            LayoutLoadFailBinding layoutLoadFailBinding5 = this.c;
            if (layoutLoadFailBinding5 != null) {
                textView = layoutLoadFailBinding5.c;
            }
            if (textView != null) {
                textView.setText(getString(R.string.network_setting));
            }
            this.k = true;
        }
    }

    private final void initView() {
        ActivityProtocolBinding activityProtocolBinding = this.b;
        ActivityProtocolBinding activityProtocolBinding2 = null;
        if (activityProtocolBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding = null;
        }
        activityProtocolBinding.c.setEnabled(this.f);
        if (this.g) {
            ActivityProtocolBinding activityProtocolBinding3 = this.b;
            if (activityProtocolBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityProtocolBinding3 = null;
            }
            TextView textView = activityProtocolBinding3.b;
            Intrinsics.checkNotNullExpressionValue(textView, "backTitle");
            textView.setVisibility(0);
            ActivityProtocolBinding activityProtocolBinding4 = this.b;
            if (activityProtocolBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityProtocolBinding4 = null;
            }
            activityProtocolBinding4.b.setText(this.h);
            ActivityProtocolBinding activityProtocolBinding5 = this.b;
            if (activityProtocolBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityProtocolBinding5 = null;
            }
            activityProtocolBinding5.b.setOnClickListener(new f(this));
        }
        ActivityProtocolBinding activityProtocolBinding6 = this.b;
        if (activityProtocolBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding6 = null;
        }
        activityProtocolBinding6.c.setOnRefreshListener(new g(this));
        ActivityProtocolBinding activityProtocolBinding7 = this.b;
        if (activityProtocolBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityProtocolBinding2 = activityProtocolBinding7;
        }
        activityProtocolBinding2.d.setOnInflateListener(new h(this));
    }

    public final void L0() {
        finish();
    }

    public final void M0() {
        ActivityProtocolBinding activityProtocolBinding = this.b;
        ActivityProtocolBinding activityProtocolBinding2 = null;
        if (activityProtocolBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding = null;
        }
        ViewParent parent = activityProtocolBinding.e.getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            ActivityProtocolBinding activityProtocolBinding3 = this.b;
            if (activityProtocolBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityProtocolBinding3 = null;
            }
            viewGroup.removeView(activityProtocolBinding3.e);
        }
        ActivityProtocolBinding activityProtocolBinding4 = this.b;
        if (activityProtocolBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityProtocolBinding2 = activityProtocolBinding4;
        }
        activityProtocolBinding2.e.destroy();
    }

    public final void W0() {
        ActivityProtocolBinding activityProtocolBinding = this.b;
        ActivityProtocolBinding activityProtocolBinding2 = null;
        if (activityProtocolBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding = null;
        }
        activityProtocolBinding.e.getSettings().setJavaScriptEnabled(true);
        ActivityProtocolBinding activityProtocolBinding3 = this.b;
        if (activityProtocolBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding3 = null;
        }
        activityProtocolBinding3.e.getSettings().setMixedContentMode(0);
        ActivityProtocolBinding activityProtocolBinding4 = this.b;
        if (activityProtocolBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding4 = null;
        }
        activityProtocolBinding4.e.getSettings().setCacheMode(1);
        ActivityProtocolBinding activityProtocolBinding5 = this.b;
        if (activityProtocolBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding5 = null;
        }
        activityProtocolBinding5.e.getSettings().setDomStorageEnabled(true);
        ActivityProtocolBinding activityProtocolBinding6 = this.b;
        if (activityProtocolBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding6 = null;
        }
        activityProtocolBinding6.e.getSettings().setAllowFileAccess(true);
        ActivityProtocolBinding activityProtocolBinding7 = this.b;
        if (activityProtocolBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding7 = null;
        }
        activityProtocolBinding7.e.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        WebViewEventListener webViewEventListener = new WebViewEventListener();
        ActivityProtocolBinding activityProtocolBinding8 = this.b;
        if (activityProtocolBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityProtocolBinding2 = activityProtocolBinding8;
        }
        activityProtocolBinding2.e.addJavascriptInterface(webViewEventListener, "SuperObj");
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.next_close_enter, R.anim.next_close_exit);
    }

    public void onBackPressed() {
        ActivityProtocolBinding activityProtocolBinding = this.b;
        ActivityProtocolBinding activityProtocolBinding2 = null;
        if (activityProtocolBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityProtocolBinding = null;
        }
        if (activityProtocolBinding.e.canGoBack()) {
            ActivityProtocolBinding activityProtocolBinding3 = this.b;
            if (activityProtocolBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityProtocolBinding2 = activityProtocolBinding3;
            }
            activityProtocolBinding2.e.goBack();
            return;
        }
        super.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        finish();
    }

    public void onCreate(Bundle bundle) {
        Bundle bundleExtra;
        super.onCreate(bundle);
        ActivityProtocolBinding c2 = ActivityProtocolBinding.c(LayoutInflater.from(this));
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.b = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c2 = null;
        }
        setContentView((View) c2.getRoot());
        Intent intent = getIntent();
        if (!(intent == null || (bundleExtra = intent.getBundleExtra("data")) == null)) {
            this.f = bundleExtra.getBoolean("enable_refresh", true);
            this.g = bundleExtra.getBoolean("show_title", true);
            String string = bundleExtra.getString("title", "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.h = string;
            String string2 = bundleExtra.getString("url", "");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            this.i = string2;
            initView();
            W0();
            S0();
        }
        NetworkUtils.f7898a.o(this, this.l);
    }

    public void onDestroy() {
        super.onDestroy();
        M0();
    }

    public void onResume() {
        super.onResume();
        if (StringsKt.startsWith$default(this.i, URIUtil.HTTP, false, 2, (Object) null) && !NetworkUtils.f7898a.g()) {
            ULog.f6446a.a("ProtocolActivity", "no network");
            V0(-1);
        }
    }
}
