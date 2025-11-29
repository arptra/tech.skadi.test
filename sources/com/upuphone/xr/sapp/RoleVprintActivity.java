package com.upuphone.xr.sapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.databinding.ActivityRoleVprintBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/RoleVprintActivity;", "Lcom/upuphone/xr/sapp/BaseActivity;", "<init>", "()V", "", "", "u0", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "isDarkMode", "setStatusBar", "(Z)V", "s0", "()Z", "Lcom/upuphone/xr/sapp/databinding/ActivityRoleVprintBinding;", "b", "Lcom/upuphone/xr/sapp/databinding/ActivityRoleVprintBinding;", "mBinding", "c", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RoleVprintActivity extends BaseActivity {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);
    public ActivityRoleVprintBinding b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/RoleVprintActivity$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final void u0(String str) {
        ULog.f6446a.g("RoleVprintActivity", str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStatusBar(s0());
        ActivityRoleVprintBinding c2 = ActivityRoleVprintBinding.c(LayoutInflater.from(this));
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.b = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c2 = null;
        }
        setContentView((View) c2.getRoot());
    }

    public final boolean s0() {
        return (getResources().getConfiguration().uiMode & 48) == 32;
    }

    public final void setStatusBar(boolean z) {
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
            u0("contentView is null");
        }
    }
}
