package com.upuphone.ar.translation.phone.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.honey.account.d5.b;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.helper.MuteAudioHelper;
import com.upuphone.star.common.phone.UBaseActivity;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0004H\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0019\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\fH\u0002¨\u0006\u001f"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/TranslatorBaseActivity;", "Lcom/upuphone/star/common/phone/UBaseActivity;", "()V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "getContentView", "Landroid/view/View;", "handleContentView", "view", "isUpdateBottomMargin", "", "onApplyWindowInsets", "v", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onImeCallback", "imeVisible", "bottomMargin", "", "setContentView", "params", "Landroid/view/ViewGroup$LayoutParams;", "layoutResID", "setStatusBar", "isDarkMode", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranslatorBaseActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorBaseActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorBaseActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,158:1\n329#2,4:159\n329#2,4:163\n*S KotlinDebug\n*F\n+ 1 TranslatorBaseActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorBaseActivity\n*L\n87#1:159,4\n99#1:163,4\n*E\n"})
public abstract class TranslatorBaseActivity extends UBaseActivity {
    private final View getContentView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return null;
        }
        return viewGroup.getChildAt(0);
    }

    private final void handleContentView(View view) {
        if (view != null) {
            FlymeUtils.a(view, this);
            ViewCompat.M0(view, new b(this));
        }
    }

    /* access modifiers changed from: private */
    public static final WindowInsetsCompat handleContentView$lambda$1$lambda$0(TranslatorBaseActivity translatorBaseActivity, View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(translatorBaseActivity, "this$0");
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        translatorBaseActivity.onApplyWindowInsets(view, windowInsetsCompat);
        return WindowInsetsCompat.b;
    }

    private final void setStatusBar(boolean z) {
        Unit unit;
        fitStatusBar(true);
        setNavigationBarColor(0);
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        if (viewGroup != null) {
            WindowInsetsControllerCompat a2 = WindowCompat.a(getWindow(), viewGroup);
            a2.d(!z);
            a2.c(!z);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LogExt.j("contentView is null", "TranslationBaseActivity");
        }
    }

    public void attachBaseContext(@Nullable Context context) {
        Context context2;
        if (context != null) {
            Configuration configuration = context.getResources().getConfiguration();
            configuration.fontScale = 1.0f;
            context2 = context.createConfigurationContext(configuration);
        } else {
            context2 = null;
        }
        super.attachBaseContext(context2);
    }

    public boolean isUpdateBottomMargin() {
        return true;
    }

    public void onApplyWindowInsets(@NotNull View view, @NotNull WindowInsetsCompat windowInsetsCompat) {
        int i;
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        boolean q = windowInsetsCompat.q(WindowInsetsCompat.Type.a());
        Insets f = windowInsetsCompat.f(WindowInsetsCompat.Type.a());
        Intrinsics.checkNotNullExpressionValue(f, "getInsets(...)");
        Insets f2 = windowInsetsCompat.f(WindowInsetsCompat.Type.d());
        Intrinsics.checkNotNullExpressionValue(f2, "getInsets(...)");
        boolean q2 = windowInsetsCompat.q(WindowInsetsCompat.Type.d());
        if (q) {
            i = f.d;
            if (isUpdateBottomMargin()) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.bottomMargin = i;
                    view.setLayoutParams(marginLayoutParams);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            }
        } else {
            int i2 = q2 ? f2.d : 0;
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.bottomMargin = i2;
                view.setLayoutParams(marginLayoutParams2);
                i = 0;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        onImeCallback(q, i);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStatusBar(ContextExtKt.e(this));
        TranslationApp.pushActivity$ar_translator_intlRelease(this);
    }

    public void onDestroy() {
        super.onDestroy();
        MuteAudioHelper.c(true);
        TranslationApp.popActivity$ar_translator_intlRelease();
    }

    public void onImeCallback(boolean z, int i) {
    }

    public void setContentView(int i) {
        super.setContentView(i);
        handleContentView(getContentView());
    }

    public void setContentView(@Nullable View view) {
        super.setContentView(view);
        handleContentView(view);
    }

    public void setContentView(@Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        handleContentView(view);
    }
}
