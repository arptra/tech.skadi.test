package com.meizu.common.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.DrawableRes;
import com.meizu.common.R;
import com.meizu.common.util.HighContrastRegister;
import com.meizu.common.util.ReflectUtils;
import dalvik.system.DexFile;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public final class HighContrastRegisterManager {
    private static final String SCAN_REGISTER_PACKAGE = "com.meizu.flyme.contrast";
    private static final String TAG = "HighContrast_Common";
    /* access modifiers changed from: private */
    public static HighContrastRegisterManager sInstance;
    private Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Object mHighContrastManager;

    private HighContrastRegisterManager(Application application) {
        this.mContext = application;
        this.mHighContrastManager = getMzHighContrastManager();
    }

    public static HighContrastRegisterManager getInstance() {
        HighContrastRegisterManager highContrastRegisterManager = sInstance;
        if (highContrastRegisterManager != null) {
            return highContrastRegisterManager;
        }
        throw new IllegalStateException("must initial with method init(Application) on Application#onCreate");
    }

    private Object getMzHighContrastManager() {
        try {
            return ReflectUtils.from("com.meizu.nightmode.MzHighContrastManager").method("getDefault", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static void init(Application application) {
        if (application == null || sInstance != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("init return application is null :");
            sb.append(application == null);
            Log.i(TAG, sb.toString());
            return;
        }
        sInstance = new HighContrastRegisterManager(application);
        Log.i(TAG, "sInstance init success");
        new Thread(new Runnable() {
            public void run() {
                HighContrastRegisterManager.sInstance.startColorThemeRegister();
            }
        }).start();
    }

    private void registerColorBlue() {
        registerBitmapResource(R.drawable.mz_fastscroller_color_blue);
        registerBitmapResource(R.drawable.mz_action_bar_tab_indicator_color_blue);
        registerBitmapResource(R.drawable.mz_guide_left_color_blue);
        registerBitmapResource(R.drawable.mz_guide_right_color_blue);
        registerBitmapResource(R.drawable.mz_guide_middle_down_color_blue);
        registerBitmapResource(R.drawable.mz_guide_middle_up_color_blue);
        registerBitmapResource(R.drawable.mz_btn_check_buttonless_on_normal_color_blue);
        registerBitmapResource(R.drawable.mz_btn_check_buttonless_on_disable_color_blue);
        registerBitmapResource(R.drawable.mz_checkbox_counter_color_blue);
        registerBitmapResource(R.drawable.mz_checkbox_counter_pressed_color_blue);
        registerBitmapResource(R.drawable.mz_edittext_new_selected_blue);
        registerBitmapResource(R.drawable.mz_input_select_handle_color_blue);
        registerBitmapResource(R.drawable.mz_progress_primary_color_blue);
        registerBitmapResource(R.drawable.mz_progressloading_success_color_blue);
        registerBitmapResource(R.drawable.mz_scrubber_primary_vertical_disable_color_blue);
        registerBitmapResource(R.drawable.mz_scrubber_primary_vertical_normal_color_blue);
        registerBitmapResource(R.drawable.mz_search_edittext_handle_left_color_blue);
        registerBitmapResource(R.drawable.mz_search_edittext_handle_right_color_blue);
        registerBitmapResource(R.drawable.mz_slider_btn_hover_color_blue);
        registerBitmapResource(R.drawable.mz_tab_selected_color_blue);
        registerBitmapResource(R.drawable.mz_text_cursor);
        registerBitmapResource(R.drawable.mz_text_select_handle_left_color_blue);
        registerBitmapResource(R.drawable.mz_text_select_handle_right_color_blue);
    }

    private List<Class> scanRegisterClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<String> entries = new DexFile(this.mContext.getPackageCodePath()).entries();
            while (entries.hasMoreElements()) {
                String nextElement = entries.nextElement();
                if (nextElement.contains(SCAN_REGISTER_PACKAGE)) {
                    Class<?> cls = Class.forName(nextElement);
                    if (cls.isAnnotationPresent(HighContrastRegister.class)) {
                        arrayList.add(cls);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void startColorThemeRegister() {
        registerColorBlue();
        for (Class next : scanRegisterClasses()) {
            try {
                ReflectUtils.from((Class<?>) next).method(((HighContrastRegister) next.getAnnotation(HighContrastRegister.class)).registerImpl(), new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception e) {
                Log.e(TAG, "" + e.getMessage());
            }
        }
    }

    public void registerBitmapResource(@DrawableRes int i) {
        try {
            ReflectUtils.from(this.mHighContrastManager).method("addBitmapResource", String.class).invoke(this.mHighContrastManager, this.mContext.getResources().getResourceName(i));
        } catch (Exception e) {
            Log.e(TAG, "" + e.getMessage());
        }
    }

    public void registerVectorResource(@DrawableRes int i) {
        try {
            ReflectUtils.from(this.mHighContrastManager).method("addVectorResource", String.class).invoke(this.mHighContrastManager, this.mContext.getResources().getResourceName(i));
        } catch (Exception e) {
            Log.e(TAG, "" + e.getMessage());
        }
    }
}
