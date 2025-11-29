package com.upuphone.ar.fastrecord.phone.ui.activity;

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
import com.honey.account.u3.a;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.star.common.phone.UBaseActivity;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¨\u0006\u001c"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordBaseActivity;", "Lcom/upuphone/star/common/phone/UBaseActivity;", "()V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "disableInMzNightMode", "view", "Landroid/view/View;", "getContentView", "onApplyWindowInsets", "root", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "params", "Landroid/view/ViewGroup$LayoutParams;", "layoutResID", "", "setStatusBar", "isDarkMode", "", "setupContentView", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class FastRecordBaseActivity extends UBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float DEFAULT_FONT_SCALE = 1.0f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordBaseActivity$Companion;", "", "()V", "DEFAULT_FONT_SCALE", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void disableInMzNightMode(View view) {
    }

    private final View getContentView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return null;
        }
        return viewGroup.getChildAt(0);
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
            LogExt.logI("contentView is null", "ShortHandBaseActivity");
        }
    }

    private final void setupContentView(View view) {
        if (view != null) {
            FlymeUtils.a(view, this);
            boolean z = (getResources().getConfiguration().uiMode & 48) == 32;
            WindowInsetsControllerCompat a2 = WindowCompat.a(getWindow(), view);
            a2.c(!z);
            a2.d(!z);
            ViewCompat.M0(view, new a(this));
        }
    }

    /* access modifiers changed from: private */
    public static final WindowInsetsCompat setupContentView$lambda$6$lambda$5(FastRecordBaseActivity fastRecordBaseActivity, View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(fastRecordBaseActivity, "this$0");
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        fastRecordBaseActivity.onApplyWindowInsets(view, windowInsetsCompat);
        return WindowInsetsCompat.b;
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

    public void onApplyWindowInsets(@NotNull View view, @NotNull WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, "root");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        Insets f = windowInsetsCompat.f(WindowInsetsCompat.Type.f());
        Intrinsics.checkNotNullExpressionValue(f, "getInsets(...)");
        view.setPadding(f.f712a, f.b, f.c, f.d);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        fitStatusBar(false);
        fitNavigationBar(false);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        disableInMzNightMode(getContentView());
        setupContentView(getContentView());
    }

    public void setContentView(@Nullable View view) {
        super.setContentView(view);
        disableInMzNightMode(view);
        setupContentView(view);
    }

    public void setContentView(@Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        disableInMzNightMode(view);
        setupContentView(view);
    }
}
