package com.upuphone.ar.tici.phone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.honey.account.p4.l;
import com.upuphone.ar.tici.databinding.TiciFileTipsBinding;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.widget.TiciTitleBar;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\"\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciFileTipsActivity;", "Lcom/upuphone/ar/tici/phone/BaseTiciActivity;", "<init>", "()V", "", "initView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "isFreshStart", "H0", "(Z)V", "I0", "D0", "Landroid/app/Activity;", "activity", "", "requestCode", "J0", "(Landroid/app/Activity;I)V", "Lcom/upuphone/ar/tici/databinding/TiciFileTipsBinding;", "b", "Lkotlin/Lazy;", "F0", "()Lcom/upuphone/ar/tici/databinding/TiciFileTipsBinding;", "layout", "c", "Z", "needRefreshPage", "d", "I", "loadCount", "com/upuphone/ar/tici/phone/TiciFileTipsActivity$networkCallback$1", "e", "Lcom/upuphone/ar/tici/phone/TiciFileTipsActivity$networkCallback$1;", "networkCallback", "", "E0", "()Ljava/lang/String;", "formatUrl", "f", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTiciFileTipsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciFileTipsActivity.kt\ncom/upuphone/ar/tici/phone/TiciFileTipsActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,258:1\n262#2,2:259\n262#2,2:261\n*S KotlinDebug\n*F\n+ 1 TiciFileTipsActivity.kt\ncom/upuphone/ar/tici/phone/TiciFileTipsActivity\n*L\n93#1:259,2\n94#1:261,2\n*E\n"})
public final class TiciFileTipsActivity extends BaseTiciActivity {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);
    public final Lazy b = LazyKt.lazy(new TiciFileTipsActivity$layout$2(this));
    public boolean c;
    public int d;
    public final TiciFileTipsActivity$networkCallback$1 e = new TiciFileTipsActivity$networkCallback$1(this);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciFileTipsActivity$Companion;", "", "()V", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void G0(TiciFileTipsActivity ticiFileTipsActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiFileTipsActivity, "this$0");
        ticiFileTipsActivity.onBackPressed();
    }

    public static /* synthetic */ void K0(TiciFileTipsActivity ticiFileTipsActivity, Activity activity, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        ticiFileTipsActivity.J0(activity, i);
    }

    private final void initView() {
        TiciTitleBar ticiTitleBar = F0().c;
        ticiTitleBar.getFolderImg().setVisibility(8);
        ticiTitleBar.getSettingImg().setVisibility(8);
        ticiTitleBar.getBackImg().setOnClickListener(new l(this));
        WebView webView = F0().d;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        if (WebViewFeature.a("ALGORITHMIC_DARKENING")) {
            CommonExtKt.e("setAlgorithmicDarkeningAllowed=true", "TiciFileTipsActivity");
            WebSettingsCompat.b(webView.getSettings(), true);
        } else {
            CommonExtKt.d("setAlgorithmicDarkeningAllowed=false", "TiciFileTipsActivity", (Throwable) null, 2, (Object) null);
        }
        webView.setWebViewClient(new TiciFileTipsActivity$initView$2$1(this));
        webView.setWebChromeClient(new TiciFileTipsActivity$initView$2$2());
        F0().b.setListener(new TiciFileTipsActivity$initView$3(this));
    }

    public final void D0() {
        boolean g = NetworkUtils.f7898a.g();
        Lifecycle.State b2 = getLifecycle().b();
        boolean z = this.c;
        CommonExtKt.e("checkShouldRefreshPage, currentState:" + b2 + " ,needRefreshPage: " + z + ", hasNetwork: " + g, "TiciFileTipsActivity");
        if (getLifecycle().b().isAtLeast(Lifecycle.State.STARTED) && this.c && g) {
            this.c = false;
            H0(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0035, code lost:
        if (r6 == null) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String E0() {
        /*
            r6 = this;
            com.upuphone.ar.tici.phone.utils.TiciHostConfig r0 = com.upuphone.ar.tici.phone.utils.TiciHostConfig.f6003a
            java.lang.String r0 = r0.a()
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            android.os.LocaleList r6 = r6.getLocales()
            r1 = 0
            java.util.Locale r6 = r6.get(r1)
            if (r6 == 0) goto L_0x0037
            java.lang.String r1 = r6.getLanguage()
            java.lang.String r6 = r6.getCountry()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = "_"
            r2.append(r1)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            if (r6 != 0) goto L_0x003a
        L_0x0037:
            java.lang.String r6 = "zh_CN"
        L_0x003a:
            com.upuphone.ar.tici.phone.TiciApp r1 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r1 = r1.q()
            java.lang.String r1 = r1.getConnectedDeviceType()
            java.lang.String r2 = "brand"
            java.lang.String r3 = android.os.Build.BRAND
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r3)
            java.lang.String r3 = "model"
            java.lang.String r4 = android.os.Build.MODEL
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            java.lang.String r4 = "xrType"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r4, r1)
            java.lang.String r4 = "os"
            java.lang.String r5 = "Android"
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
            java.lang.String r5 = "lang"
            kotlin.Pair r6 = kotlin.TuplesKt.to(r5, r6)
            kotlin.Pair[] r6 = new kotlin.Pair[]{r2, r3, r1, r4, r6}
            java.util.Map r6 = kotlin.collections.MapsKt.mapOf(r6)
            java.lang.String r6 = com.upuphone.ar.tici.phone.utils.UrlExtKt.a(r0, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.TiciFileTipsActivity.E0():java.lang.String");
    }

    public final TiciFileTipsBinding F0() {
        return (TiciFileTipsBinding) this.b.getValue();
    }

    public final void H0(boolean z) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciFileTipsActivity$loadPage$1(this, z, (Continuation<? super TiciFileTipsActivity$loadPage$1>) null), 3, (Object) null);
    }

    public final void I0() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciFileTipsActivity$onLoadPageFail$1(this, (Continuation<? super TiciFileTipsActivity$onLoadPageFail$1>) null), 3, (Object) null);
    }

    public final void J0(Activity activity, int i) {
        try {
            activity.startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), i);
        } catch (Exception e2) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("TiciFileTipsActivity", "openNetworkSetting, error: " + e2);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CommonExtKt.e("onCreate", "TiciFileTipsActivity");
        setContentView((View) F0().getRoot());
        initView();
        H0(true);
        NetworkUtils.f7898a.o(this, this.e);
        getLifecycle().a(new TiciFileTipsActivity$onCreate$1(this));
    }
}
