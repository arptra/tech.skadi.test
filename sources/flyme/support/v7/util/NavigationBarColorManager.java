package flyme.support.v7.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;

public class NavigationBarColorManager {
    private static String MZ_NAVIGATION_BAR_BACKGROUND_COLOR = "mz_navigation_bar_background_color";
    private static String MZ_NAVIGATION_BAR_DARK_ICON = "mz_navigation_bar_dark_icon";
    private static String TAG = "NavigationBarColor";
    private static NavigationBarColorManager mSingle;
    private ContentObserver colorContentObserver = new ContentObserver(new Handler()) {
        public void onChange(boolean z) {
            NavigationBarColorManager.this.initNavigationBarColor();
        }
    };
    private CallBack mCallBack;
    private Context mContext;
    boolean mNavigationBarDefaultBlackIcon = false;
    private int mNavigationBarDefaultColor = -16777216;

    public interface CallBack {
        void onColorChange(int i, boolean z);
    }

    private NavigationBarColorManager(Context context) {
        this.mContext = context;
        initNavigationBarColorChange();
    }

    public static NavigationBarColorManager getSingle(Context context) {
        NavigationBarColorManager navigationBarColorManager;
        synchronized (NavigationBarColorManager.class) {
            try {
                if (mSingle == null) {
                    mSingle = new NavigationBarColorManager(context.getApplicationContext());
                }
                navigationBarColorManager = mSingle;
            } catch (Throwable th) {
                throw th;
            }
        }
        return navigationBarColorManager;
    }

    /* access modifiers changed from: private */
    public void initNavigationBarColor() {
        try {
            int i = Settings.System.getInt(this.mContext.getContentResolver(), MZ_NAVIGATION_BAR_BACKGROUND_COLOR, -1184275);
            boolean z = true;
            if (Settings.System.getInt(this.mContext.getContentResolver(), MZ_NAVIGATION_BAR_DARK_ICON, 1) == 0) {
                z = false;
            }
            if (this.mNavigationBarDefaultColor == i) {
                if (z != this.mNavigationBarDefaultBlackIcon) {
                }
                String str = TAG;
                Log.d(str, "initNavigationBarColor color" + i + ",dark=" + z);
            }
            this.mNavigationBarDefaultColor = i;
            this.mNavigationBarDefaultBlackIcon = z;
            CallBack callBack = this.mCallBack;
            if (callBack != null) {
                callBack.onColorChange(i, z);
            }
            String str2 = TAG;
            Log.d(str2, "initNavigationBarColor color" + i + ",dark=" + z);
        } catch (Throwable th) {
            Log.e(TAG, "get navigation bar background color erro", th);
        }
    }

    private void initNavigationBarColorChange() {
        Log.d(TAG, "initNavigationBarColorChange");
        ContentResolver contentResolver = this.mContext.getContentResolver();
        contentResolver.registerContentObserver(Settings.System.getUriFor(MZ_NAVIGATION_BAR_BACKGROUND_COLOR), false, this.colorContentObserver);
        contentResolver.registerContentObserver(Settings.System.getUriFor(MZ_NAVIGATION_BAR_DARK_ICON), false, this.colorContentObserver);
        initNavigationBarColor();
    }

    public boolean getNavigationBarDefaultBlackIcon() {
        return this.mNavigationBarDefaultBlackIcon;
    }

    public int getNavigationBarDefaultColor() {
        return this.mNavigationBarDefaultColor;
    }

    public void setCallBack(CallBack callBack) {
        this.mCallBack = callBack;
        if (callBack != null) {
            callBack.onColorChange(this.mNavigationBarDefaultColor, this.mNavigationBarDefaultBlackIcon);
        }
    }
}
