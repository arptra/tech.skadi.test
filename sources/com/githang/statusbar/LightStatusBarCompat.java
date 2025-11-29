package com.githang.statusbar;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;

class LightStatusBarCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final ILightStatusBar f3000a;

    /* renamed from: com.githang.statusbar.LightStatusBarCompat$2  reason: invalid class name */
    public static class AnonymousClass2 implements ILightStatusBar {
        public void a(Window window, boolean z) {
        }
    }

    public interface ILightStatusBar {
        void a(Window window, boolean z);
    }

    public static class MIUILightStatusBarImpl implements ILightStatusBar {
        public MIUILightStatusBarImpl() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0040 A[SYNTHETIC, Splitter:B:21:0x0040] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0046 A[SYNTHETIC, Splitter:B:27:0x0046] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean b() {
            /*
                r0 = 0
                r1 = 0
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0044, all -> 0x003d }
                java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0044, all -> 0x003d }
                java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch:{ IOException -> 0x0044, all -> 0x003d }
                java.lang.String r5 = "build.prop"
                r3.<init>(r4, r5)     // Catch:{ IOException -> 0x0044, all -> 0x003d }
                r2.<init>(r3)     // Catch:{ IOException -> 0x0044, all -> 0x003d }
                java.util.Properties r1 = new java.util.Properties     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
                r1.<init>()     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
                r1.load(r2)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
                java.lang.String r3 = "ro.miui.ui.version.code"
                java.lang.String r3 = r1.getProperty(r3)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
                if (r3 != 0) goto L_0x0038
                java.lang.String r3 = "ro.miui.ui.version.name"
                java.lang.String r3 = r1.getProperty(r3)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
                if (r3 != 0) goto L_0x0038
                java.lang.String r3 = "ro.miui.internal.storage"
                java.lang.String r1 = r1.getProperty(r3)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
                if (r1 == 0) goto L_0x0039
                goto L_0x0038
            L_0x0033:
                r0 = move-exception
                r1 = r2
                goto L_0x003e
            L_0x0036:
                r1 = r2
                goto L_0x0044
            L_0x0038:
                r0 = 1
            L_0x0039:
                r2.close()     // Catch:{ IOException -> 0x003c }
            L_0x003c:
                return r0
            L_0x003d:
                r0 = move-exception
            L_0x003e:
                if (r1 == 0) goto L_0x0043
                r1.close()     // Catch:{ IOException -> 0x0043 }
            L_0x0043:
                throw r0
            L_0x0044:
                if (r1 == 0) goto L_0x0049
                r1.close()     // Catch:{ IOException -> 0x0049 }
            L_0x0049:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.githang.statusbar.LightStatusBarCompat.MIUILightStatusBarImpl.b():boolean");
        }

        public void a(Window window, boolean z) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Class cls3 = Integer.TYPE;
                cls.getMethod("setExtraFlags", new Class[]{cls3, cls3}).invoke(window, new Object[]{Integer.valueOf(z ? i : 0), Integer.valueOf(i)});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class MLightStatusBarImpl implements ILightStatusBar {
        public MLightStatusBarImpl() {
        }

        public void a(Window window, boolean z) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        }
    }

    public static class MeizuLightStatusBarImpl implements ILightStatusBar {
        public void a(Window window, boolean z) {
            Class<WindowManager.LayoutParams> cls = WindowManager.LayoutParams.class;
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Field declaredField = cls.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = cls.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i = declaredField.getInt((Object) null);
                int i2 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
                window.setAttributes(attributes);
                declaredField.setAccessible(false);
                declaredField2.setAccessible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static {
        if (MIUILightStatusBarImpl.b()) {
            f3000a = new MLightStatusBarImpl() {

                /* renamed from: a  reason: collision with root package name */
                public final ILightStatusBar f3001a = new MIUILightStatusBarImpl();

                public void a(Window window, boolean z) {
                    super.a(window, z);
                    this.f3001a.a(window, z);
                }
            };
        } else {
            f3000a = new MLightStatusBarImpl();
        }
    }

    public static void a(Window window, boolean z) {
        f3000a.a(window, z);
    }
}
