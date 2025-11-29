package com.upuphone.ar.tici.phone;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.honey.account.p4.a;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000b\u0010\u000fJ#\u0010\u000b\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u000b\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/upuphone/ar/tici/phone/BaseTiciActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "layoutResID", "setContentView", "(I)V", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/content/Context;", "newBase", "attachBaseContext", "(Landroid/content/Context;)V", "root", "Landroidx/core/view/WindowInsetsCompat;", "windowInsets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)V", "getContentView", "()Landroid/view/View;", "setupContentView", "a", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public abstract class BaseTiciActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f5875a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/tici/phone/BaseTiciActivity$Companion;", "", "()V", "DEFAULT_FONT_SCALE", "", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final WindowInsetsCompat o0(BaseTiciActivity baseTiciActivity, View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(baseTiciActivity, "this$0");
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        baseTiciActivity.onApplyWindowInsets(view, windowInsetsCompat);
        return WindowInsetsCompat.b;
    }

    public void attachBaseContext(Context context) {
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

    public final View getContentView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return null;
        }
        return viewGroup.getChildAt(0);
    }

    public void onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, "root");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        Insets f = windowInsetsCompat.f(WindowInsetsCompat.Type.f());
        Intrinsics.checkNotNullExpressionValue(f, "getInsets(...)");
        CommonExtKt.e("onApplyWindowInsets, insets: " + f + ", view: " + view, "BaseTiciActivity");
        view.setPadding(f.f712a, f.b, f.c, f.d);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowCompat.b(getWindow(), false);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        setupContentView(getContentView());
    }

    public final void setupContentView(View view) {
        if (view != null) {
            FlymeUtils.a(view, this);
            boolean z = (getResources().getConfiguration().uiMode & 48) == 32;
            WindowInsetsControllerCompat a2 = WindowCompat.a(getWindow(), view);
            a2.c(!z);
            a2.d(!z);
            ViewCompat.M0(view, new a(this));
        }
    }

    public void setContentView(@Nullable View view) {
        super.setContentView(view);
        setupContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        setupContentView(view);
    }
}
