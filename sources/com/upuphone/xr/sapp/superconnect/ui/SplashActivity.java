package com.upuphone.xr.sapp.superconnect.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.util.Consumer;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.t8.a;
import com.honey.account.t8.b;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BaseActivity;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.xjmz.myvu.MYVUActivity;
import flyme.support.v7.app.AlertDialog;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R$\u0010)\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00158\u0002@BX\u000e¢\u0006\f\n\u0004\b&\u0010#\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/upuphone/xr/sapp/superconnect/ui/SplashActivity;", "Lcom/upuphone/xr/sapp/BaseActivity;", "<init>", "()V", "", "initView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "", "languageCode", "F0", "(Landroid/content/Context;Ljava/lang/String;)V", "onResume", "onPause", "onDestroy", "D0", "C0", "", "z0", "()Z", "Lflyme/support/v7/app/AlertDialog;", "b", "Lflyme/support/v7/app/AlertDialog;", "incompatibleWarningDialog", "c", "channelMismatchDialog", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "mHandler", "e", "Z", "shouldCoverScreen", "value", "f", "E0", "(Z)V", "canJump", "g", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SplashActivity extends BaseActivity {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public AlertDialog b;
    public AlertDialog c;
    public final Handler d = new Handler(new a(this));
    public volatile boolean e = true;
    public boolean f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/superconnect/ui/SplashActivity$Companion;", "", "()V", "DELAY_TIME", "", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final boolean A0(SplashActivity splashActivity, Message message) {
        Intrinsics.checkNotNullParameter(splashActivity, "this$0");
        Intrinsics.checkNotNullParameter(message, "it");
        ULog.f6446a.a("boot-SplashActivity", "go to MainActivity");
        splashActivity.startActivity(new Intent(splashActivity, MYVUActivity.class));
        splashActivity.finish();
        return true;
    }

    public static final boolean B0(SplashActivity splashActivity) {
        Intrinsics.checkNotNullParameter(splashActivity, "this$0");
        return splashActivity.e;
    }

    private final void initView() {
        fitNavigationBar(true);
        fitSystemWindow(true);
        fitStatusBar(true);
    }

    public final void C0() {
        this.d.removeCallbacksAndMessages((Object) null);
        this.d.sendEmptyMessageDelayed(0, 500);
    }

    public final void D0() {
        ULog.Delegate delegate = ULog.f6446a;
        String str = Build.MANUFACTURER;
        delegate.a("boot-SplashActivity", "printSysInfos-> MANUFACTURER: " + str + ", apk: intl");
    }

    public final void E0(boolean z) {
        this.f = z;
        if (z) {
            ULog.f6446a.a("boot-SplashActivity", "必要条件检查完毕");
            C0();
        }
    }

    public final void F0(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "languageCode");
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        if (context instanceof Activity) {
            ((Activity) context).recreate();
        }
    }

    public void onCreate(Bundle bundle) {
        SplashScreen.b.a(this).c(new b(this));
        super.onCreate(bundle);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("boot-SplashActivity", "onCreate->start");
        setContentView(R.layout.activity_splash);
        initView();
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new SplashActivity$onCreate$2(this, (Continuation<? super SplashActivity$onCreate$2>) null), 3, (Object) null);
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        String country = Locale.getDefault().getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
        if (!Intrinsics.areEqual((Object) language, (Object) "ko") && Intrinsics.areEqual((Object) country, (Object) "KR")) {
            F0(this, "ko");
        }
        delegate.a("boot-SplashActivity", "onCreate->end currentLanguage:" + language + " currentCountry:" + country);
    }

    public void onDestroy() {
        super.onDestroy();
        ULog.f6446a.a("boot-SplashActivity", "do onDestroy");
        AlertDialog alertDialog = this.c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog alertDialog2 = this.b;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
    }

    public void onPause() {
        super.onPause();
        ULog.f6446a.a("boot-SplashActivity", "do onPause");
        this.d.removeCallbacksAndMessages((Object) null);
    }

    public void onResume() {
        super.onResume();
        ULog.f6446a.a("boot-SplashActivity", "do onResume");
        if (this.f) {
            C0();
        }
    }

    public final boolean z0() {
        if (PermissionAndStateCheckUtils.f7907a.i(this)) {
            ULog.f6446a.a("boot-SplashActivity", "checkUserPermission::permission ok");
            return true;
        }
        this.e = false;
        ContractEntry.f6691a.x(this, 0, (Consumer) null);
        return false;
    }
}
