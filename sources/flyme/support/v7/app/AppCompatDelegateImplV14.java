package flyme.support.v7.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import flyme.support.v7.app.AppCompatDelegateImplBase;
import flyme.support.v7.view.SupportActionModeWrapper;
import flyme.support.v7.widget.FitsWindowsContentLayout;
import java.lang.reflect.Field;

class AppCompatDelegateImplV14 extends AppCompatDelegateImplV11 {
    private static final String KEY_LOCAL_NIGHT_MODE = "appcompat:local_night_mode";
    private static final String LISTVIEW_MULTI_CHOICE_MODE_WRAPPER_CLASS_NAME = "android.widget.AbsListView$MultiChoiceModeWrapper";
    private static final String RECYCLERVIEW_MULTI_CHOICE_MODE_WRAPPER_CLASS_NAME = "flyme.support.v7.widget.MzRecyclerView$MultiChoiceModeWrapper";
    private static final String WINDOW_ACTION_MODE_CALLBACK_2_WRAPPER_CLASS_NAME = "com.android.internal.policy.PhoneWindow$DecorView$ActionModeCallback2Wrapper";
    private static final String WINDOW_ACTION_MODE_CALLBACK_WRAPPER_CLASS_NAME = "com.android.internal.policy.impl.PhoneWindow$DecorView$ActionModeCallbackWrapper";
    private static TwilightManager sTwilightManager;
    private boolean mApplyDayNightCalled;
    private boolean mHandleNativeActionModes = true;
    private int mLocalNightMode = -100;
    private FitsWindowsContentLayout.OnStartActionModeListener mOnContentStartActionModeListener = new FitsWindowsContentLayout.OnStartActionModeListener() {
        public ActionMode onContentStartingActionMode(ActionMode.Callback callback) {
            return AppCompatDelegateImplV14.this.mAppCompatWindowCallback.onWindowStartingActionMode(callback);
        }

        @TargetApi(23)
        public ActionMode onContentStartingActionMode(ActionMode.Callback callback, int i) {
            return AppCompatDelegateImplV14.this.mAppCompatWindowCallback.onWindowStartingActionMode(callback, i);
        }
    };

    public class AppCompatWindowCallbackV14 extends AppCompatDelegateImplBase.AppCompatWindowCallbackBase {
        public AppCompatWindowCallbackV14(Window.Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return AppCompatDelegateImplV14.this.isHandleNativeActionModesEnabled() ? startAsSupportActionMode(callback) : super.onWindowStartingActionMode(callback);
        }

        public final ActionMode startAsSupportActionMode(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImplV14.this.mContext, callback);
            flyme.support.v7.view.ActionMode startMultiChoiceActionMode = AppCompatDelegateImplV14.this.checkMultiChoiceMode(callback) ? AppCompatDelegateImplV14.this.startMultiChoiceActionMode(callbackWrapper) : null;
            if (startMultiChoiceActionMode == null) {
                startMultiChoiceActionMode = AppCompatDelegateImplV14.this.startSupportActionMode(callbackWrapper);
            }
            if (startMultiChoiceActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startMultiChoiceActionMode);
            }
            return null;
        }
    }

    public AppCompatDelegateImplV14(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    /* access modifiers changed from: private */
    public boolean checkMultiChoiceMode(ActionMode.Callback callback) {
        if (callback == null) {
            return false;
        }
        String name = callback.getClass().getName();
        if (name.equals(WINDOW_ACTION_MODE_CALLBACK_WRAPPER_CLASS_NAME) || name.equals(WINDOW_ACTION_MODE_CALLBACK_2_WRAPPER_CLASS_NAME)) {
            try {
                Field declaredField = callback.getClass().getDeclaredField("mWrapped");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(callback);
                if (obj != null) {
                    name = obj.getClass().getName();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return name.equals(LISTVIEW_MULTI_CHOICE_MODE_WRAPPER_CLASS_NAME) || name.equals(RECYCLERVIEW_MULTI_CHOICE_MODE_WRAPPER_CLASS_NAME);
    }

    private TwilightManager getTwilightManager() {
        if (sTwilightManager == null) {
            sTwilightManager = new TwilightManager(this.mContext.getApplicationContext());
        }
        return sTwilightManager;
    }

    private boolean updateConfigurationForNightMode(int i) {
        Resources resources = this.mContext.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        return true;
    }

    public boolean applyDayNight() {
        this.mApplyDayNightCalled = true;
        int i = this.mLocalNightMode;
        if (i == -100) {
            i = AppCompatDelegate.getDefaultNightMode();
        }
        int mapNightMode = mapNightMode(i);
        if (mapNightMode != -1) {
            return updateConfigurationForNightMode(mapNightMode);
        }
        return false;
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    public int mapNightMode(int i) {
        if (i != -100) {
            return i != 0 ? i : getTwilightManager().isNight() ? 2 : 1;
        }
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && this.mLocalNightMode == -100) {
            this.mLocalNightMode = bundle.getInt(KEY_LOCAL_NIGHT_MODE, -100);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i = this.mLocalNightMode;
        if (i != -100) {
            bundle.putInt(KEY_LOCAL_NIGHT_MODE, i);
        }
    }

    public void onSubDecorInstalled(ViewGroup viewGroup) {
        super.onSubDecorInstalled(viewGroup);
        View findViewById = viewGroup.findViewById(16908290);
        if (findViewById != null && (findViewById instanceof FitsWindowsContentLayout)) {
            ((FitsWindowsContentLayout) findViewById).setOnStartActionModeListener(this.mOnContentStartActionModeListener);
        }
    }

    public void setHandleNativeActionModesEnabled(boolean z) {
        this.mHandleNativeActionModes = z;
    }

    public void setLocalNightMode(int i) {
        if (i != -1 && i != 0 && i != 1 && i != 2) {
            Log.d("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
        } else if (this.mLocalNightMode != i) {
            this.mLocalNightMode = i;
            if (this.mApplyDayNightCalled) {
                applyDayNight();
            }
        }
    }

    public Window.Callback wrapWindowCallback(Window.Callback callback) {
        return new AppCompatWindowCallbackV14(callback);
    }
}
