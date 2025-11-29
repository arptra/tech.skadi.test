package flyme.support.v7.app.palette;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.upuphone.runasone.uupcast.CaptureType;
import flyme.support.v7.app.ActionBar;
import flyme.support.v7.app.LitePopup;
import flyme.support.v7.app.LitePopupActivity;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.util.PermissionUtil;
import java.lang.ref.WeakReference;
import java.util.Objects;

public class FlymePalettePopupActivity extends LitePopupActivity {
    /* access modifiers changed from: private */
    public static Activity sActivity;
    /* access modifiers changed from: private */
    public static OnColorPickListener sColorPickListener;

    public static abstract class ActivityLifecycleCallbacksAdapter implements Application.ActivityLifecycleCallbacks {
        private ActivityLifecycleCallbacksAdapter() {
        }

        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        public void onActivityPaused(@NonNull Activity activity) {
        }

        public void onActivityResumed(@NonNull Activity activity) {
        }

        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        public void onActivityStarted(@NonNull Activity activity) {
        }

        public void onActivityStopped(@NonNull Activity activity) {
        }
    }

    public interface OnColorPickListener {
        void onColorPickDragged(int i);

        void onColorPickSelected(int i);

        void onPaletteChange(int i);
    }

    public static void start(Activity activity, OnColorPickListener onColorPickListener) {
        start(activity, 0, onColorPickListener);
    }

    public static void startWithPickColor(Context context, int i) {
        Intent intent = new Intent(context, FlymePalettePopupActivity.class);
        intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        intent.putExtra("pick_color", i);
        context.startActivity(intent);
    }

    private static void updateScreenShot() {
        View rootView = sActivity.getWindow().getDecorView().getRootView();
        rootView.setDrawingCacheEnabled(true);
        ColorPickWindowHelper.getInstance().setScreenShotBmp(Bitmap.createBitmap(rootView.getDrawingCache()));
        rootView.setDrawingCacheEnabled(false);
    }

    public void finish() {
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.palette_activity_layout);
        ActionBar supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        LitePopup litePopup = getLitePopup();
        if (litePopup != null) {
            litePopup.setStyle(1);
        }
        ColorPickerView colorPickerView = (ColorPickerView) findViewById(R.id.color_pick_view);
        colorPickerView.setColorPickListener(sColorPickListener);
        int intExtra = getIntent().getIntExtra("pick_color", 0);
        if (intExtra != 0) {
            colorPickerView.updatePointByColor(intExtra);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_palette_icon, menu);
        return true;
    }

    public void onDismissed() {
        super.onDismissed();
    }

    @RequiresApi
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != R.id.palette_open_pick) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            if (!PermissionUtil.hasOverlayPermission(this)) {
                PermissionUtil.requestOverlayPermission(this);
            } else if (sActivity == null) {
                ColorPickWindowHelper.getInstance().release();
                return true;
            } else {
                updateScreenShot();
                ColorPickWindowHelper.getInstance().showColorPickWindow(this, sColorPickListener);
                finish();
            }
            return true;
        }
    }

    public static void start(Activity activity, @ColorInt int i, OnColorPickListener onColorPickListener) {
        if (sColorPickListener == null) {
            sColorPickListener = (OnColorPickListener) new WeakReference(onColorPickListener).get();
        }
        if (sActivity == null) {
            sActivity = (Activity) new WeakReference(activity).get();
        }
        Intent intent = new Intent(sActivity, FlymePalettePopupActivity.class);
        if (i != 0) {
            intent.putExtra("pick_color", i);
        }
        sActivity.startActivity(intent);
        sActivity.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacksAdapter() {
            public void onActivityDestroyed(@NonNull Activity activity) {
                Activity unused = FlymePalettePopupActivity.sActivity = null;
                OnColorPickListener unused2 = FlymePalettePopupActivity.sColorPickListener = null;
            }

            public void onActivityStopped(@NonNull Activity activity) {
                ColorPickWindowHelper.getInstance().release();
            }
        });
        updateScreenShot();
    }
}
