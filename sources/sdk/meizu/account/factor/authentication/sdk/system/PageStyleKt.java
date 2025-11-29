package sdk.meizu.account.factor.authentication.sdk.system;

import android.app.UiModeManager;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.R;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"fitStatusBarWithUiMode", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "sdk_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PageStyleKt {
    public static final void fitStatusBarWithUiMode(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        ColorDrawable colorDrawable = new ColorDrawable(appCompatActivity.getColor(R.color.colorSurfaceBright));
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.n(colorDrawable);
        }
        android.app.ActionBar actionBar = appCompatActivity.getActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(colorDrawable);
        }
        Window window = appCompatActivity.getWindow();
        window.setStatusBarColor(appCompatActivity.getColor(R.color.colorSurfaceBright));
        window.setNavigationBarColor(window.getStatusBarColor());
        boolean z = ((UiModeManager) appCompatActivity.getSystemService(UiModeManager.class)).getNightMode() == 2;
        WindowInsetsControllerCompat a2 = WindowCompat.a(window, window.getDecorView());
        Intrinsics.checkNotNullExpressionValue(a2, "getInsetsController(...)");
        a2.c(!z);
        a2.d(!z);
    }
}
