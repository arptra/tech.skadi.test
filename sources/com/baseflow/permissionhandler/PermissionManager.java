package com.baseflow.permissionhandler;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.here.posclient.analytics.TrackerEvent;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class PermissionManager implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2402a;
    public RequestPermissionsSuccessCallback b;
    public Activity c;
    public int d;
    public Map e;

    @FunctionalInterface
    public interface CheckPermissionsSuccessCallback {
        void onSuccess(int i);
    }

    @FunctionalInterface
    public interface RequestPermissionsSuccessCallback {
        void a(Map map);
    }

    @FunctionalInterface
    public interface ShouldShowRequestPermissionRationaleSuccessCallback {
        void a(boolean z);
    }

    public PermissionManager(Context context) {
        this.f2402a = context;
    }

    public final int a() {
        List c2 = PermissionUtils.c(this.f2402a, 21);
        if (c2 != null && !c2.isEmpty()) {
            return 1;
        }
        Log.d("permissions_handler", "Bluetooth permission missing in manifest");
        return 0;
    }

    public final int b() {
        if (Build.VERSION.SDK_INT < 33) {
            return NotificationManagerCompat.g(this.f2402a).a() ? 1 : 0;
        }
        if (this.f2402a.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
            return 1;
        }
        return PermissionUtils.b(this.c, "android.permission.POST_NOTIFICATIONS");
    }

    public void c(int i, CheckPermissionsSuccessCallback checkPermissionsSuccessCallback) {
        checkPermissionsSuccessCallback.onSuccess(d(i));
    }

    public final int d(int i) {
        if (i == 17) {
            return b();
        }
        if (i == 21) {
            return a();
        }
        if ((i == 30 || i == 28 || i == 29) && Build.VERSION.SDK_INT < 31) {
            return a();
        }
        if ((i == 37 || i == 0) && !e()) {
            return 0;
        }
        List<String> c2 = PermissionUtils.c(this.f2402a, i);
        if (c2 == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i);
            return 1;
        } else if (c2.size() == 0) {
            Log.d("permissions_handler", "No permissions found in manifest for: " + c2 + i);
            return (i != 22 || Build.VERSION.SDK_INT >= 30) ? 0 : 2;
        } else {
            if (this.f2402a.getApplicationInfo().targetSdkVersion >= 23) {
                HashSet hashSet = new HashSet();
                for (String str : c2) {
                    if (i == 16) {
                        String packageName = this.f2402a.getPackageName();
                        PowerManager powerManager = (PowerManager) this.f2402a.getSystemService("power");
                        if (powerManager == null || !powerManager.isIgnoringBatteryOptimizations(packageName)) {
                            hashSet.add(0);
                        } else {
                            hashSet.add(1);
                        }
                    } else if (i == 22) {
                        if (Build.VERSION.SDK_INT < 30) {
                            hashSet.add(2);
                        }
                        hashSet.add(Integer.valueOf(Environment.isExternalStorageManager() ? 1 : 0));
                    } else if (i == 23) {
                        hashSet.add(Integer.valueOf(Settings.canDrawOverlays(this.f2402a) ? 1 : 0));
                    } else if (i == 24) {
                        hashSet.add(Integer.valueOf(this.f2402a.getPackageManager().canRequestPackageInstalls() ? 1 : 0));
                    } else if (i == 27) {
                        hashSet.add(Integer.valueOf(((NotificationManager) this.f2402a.getSystemService("notification")).isNotificationPolicyAccessGranted() ? 1 : 0));
                    } else if (i == 34) {
                        if (Build.VERSION.SDK_INT >= 31) {
                            hashSet.add(Integer.valueOf(((AlarmManager) this.f2402a.getSystemService(VuiModelType.ALARM)).canScheduleExactAlarms() ? 1 : 0));
                        } else {
                            hashSet.add(1);
                        }
                    } else if (i == 9 || i == 32) {
                        int checkSelfPermission = ContextCompat.checkSelfPermission(this.f2402a, str);
                        if ((Build.VERSION.SDK_INT >= 34 ? ContextCompat.checkSelfPermission(this.f2402a, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") : checkSelfPermission) == 0 && checkSelfPermission == -1) {
                            hashSet.add(3);
                        } else if (checkSelfPermission == 0) {
                            hashSet.add(1);
                        } else {
                            hashSet.add(Integer.valueOf(PermissionUtils.b(this.c, str)));
                        }
                    } else if (ContextCompat.checkSelfPermission(this.f2402a, str) != 0) {
                        hashSet.add(Integer.valueOf(PermissionUtils.b(this.c, str)));
                    }
                }
                if (!hashSet.isEmpty()) {
                    return PermissionUtils.j(hashSet).intValue();
                }
            }
            return 1;
        }
    }

    public final boolean e() {
        List c2 = PermissionUtils.c(this.f2402a, 37);
        boolean z = c2 != null && c2.contains("android.permission.WRITE_CALENDAR");
        boolean z2 = c2 != null && c2.contains("android.permission.READ_CALENDAR");
        if (z && z2) {
            return true;
        }
        if (!z) {
            Log.d("permissions_handler", "android.permission.WRITE_CALENDAR missing in manifest");
        }
        if (!z2) {
            Log.d("permissions_handler", "android.permission.READ_CALENDAR missing in manifest");
        }
        return false;
    }

    public final void f(String str, int i) {
        if (this.c != null) {
            Intent intent = new Intent(str);
            if (!str.equals("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS")) {
                intent.setData(Uri.parse("package:" + this.c.getPackageName()));
            }
            this.c.startActivityForResult(intent, i);
            this.d++;
        }
    }

    public void g(List list, RequestPermissionsSuccessCallback requestPermissionsSuccessCallback, ErrorCallback errorCallback) {
        if (this.d > 0) {
            errorCallback.a("PermissionHandler.PermissionManager", "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time).");
        } else if (this.c == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            errorCallback.a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
        } else {
            this.b = requestPermissionsSuccessCallback;
            this.e = new HashMap();
            this.d = 0;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (d(num.intValue()) != 1) {
                    List c2 = PermissionUtils.c(this.c, num.intValue());
                    if (c2 != null && !c2.isEmpty()) {
                        int i = Build.VERSION.SDK_INT;
                        if (num.intValue() == 16) {
                            f("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", 209);
                        } else if (i >= 30 && num.intValue() == 22) {
                            f("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", 210);
                        } else if (num.intValue() == 23) {
                            f("android.settings.action.MANAGE_OVERLAY_PERMISSION", TrackerEvent.RadioMapOnDemandOutdoor);
                        } else if (num.intValue() == 24) {
                            f("android.settings.MANAGE_UNKNOWN_APP_SOURCES", 212);
                        } else if (num.intValue() == 27) {
                            f("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS", 213);
                        } else if (i >= 31 && num.intValue() == 34) {
                            f("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", 214);
                        } else if (num.intValue() != 37 && num.intValue() != 0) {
                            arrayList.addAll(c2);
                            this.d += c2.size();
                        } else if (e()) {
                            arrayList.add("android.permission.WRITE_CALENDAR");
                            arrayList.add("android.permission.READ_CALENDAR");
                            this.d += 2;
                        } else {
                            this.e.put(num, 0);
                        }
                    } else if (!this.e.containsKey(num)) {
                        this.e.put(num, 0);
                        if (num.intValue() != 22 || Build.VERSION.SDK_INT >= 30) {
                            this.e.put(num, 0);
                        } else {
                            this.e.put(num, 2);
                        }
                    }
                } else if (!this.e.containsKey(num)) {
                    this.e.put(num, 1);
                }
            }
            if (arrayList.size() > 0) {
                ActivityCompat.e(this.c, (String[]) arrayList.toArray(new String[0]), 24);
            }
            RequestPermissionsSuccessCallback requestPermissionsSuccessCallback2 = this.b;
            if (requestPermissionsSuccessCallback2 != null && this.d == 0) {
                requestPermissionsSuccessCallback2.a(this.e);
            }
        }
    }

    public void h(Activity activity) {
        this.c = activity;
    }

    public void i(int i, ShouldShowRequestPermissionRationaleSuccessCallback shouldShowRequestPermissionRationaleSuccessCallback, ErrorCallback errorCallback) {
        Activity activity = this.c;
        if (activity == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            errorCallback.a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        List c2 = PermissionUtils.c(activity, i);
        if (c2 == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i);
            shouldShowRequestPermissionRationaleSuccessCallback.a(false);
        } else if (c2.isEmpty()) {
            Log.d("permissions_handler", "No permissions found in manifest for: " + i + " no need to show request rationale");
            shouldShowRequestPermissionRationaleSuccessCallback.a(false);
        } else {
            shouldShowRequestPermissionRationaleSuccessCallback.a(ActivityCompat.i(this.c, (String) c2.get(0)));
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        int i3;
        Activity activity = this.c;
        boolean z2 = false;
        if (activity == null) {
            return false;
        }
        if (this.e == null) {
            this.d = 0;
            return false;
        }
        if (i == 209) {
            String packageName = this.f2402a.getPackageName();
            PowerManager powerManager = (PowerManager) this.f2402a.getSystemService("power");
            if (powerManager != null && powerManager.isIgnoringBatteryOptimizations(packageName)) {
                z2 = true;
            }
            i3 = 16;
        } else if (i == 210) {
            if (Build.VERSION.SDK_INT < 30) {
                return false;
            }
            z = Environment.isExternalStorageManager();
            i3 = 22;
        } else if (i == 211) {
            z = Settings.canDrawOverlays(activity);
            i3 = 23;
        } else if (i == 212) {
            z = activity.getPackageManager().canRequestPackageInstalls();
            i3 = 24;
        } else if (i == 213) {
            z = ((NotificationManager) activity.getSystemService("notification")).isNotificationPolicyAccessGranted();
            i3 = 27;
        } else if (i != 214) {
            return false;
        } else {
            z = Build.VERSION.SDK_INT >= 31 ? ((AlarmManager) activity.getSystemService(VuiModelType.ALARM)).canScheduleExactAlarms() : true;
            i3 = 34;
        }
        this.e.put(Integer.valueOf(i3), Integer.valueOf(z ? 1 : 0));
        int i4 = this.d - 1;
        this.d = i4;
        RequestPermissionsSuccessCallback requestPermissionsSuccessCallback = this.b;
        if (requestPermissionsSuccessCallback != null && i4 == 0) {
            requestPermissionsSuccessCallback.a(this.e);
        }
        return true;
    }

    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int g;
        if (i != 24) {
            this.d = 0;
            return false;
        } else if (this.e == null) {
            return false;
        } else {
            if (strArr.length == 0 && iArr.length == 0) {
                Log.w("permissions_handler", "onRequestPermissionsResult is called without results. This is probably caused by interfering request codes. If you see this error, please file an issue in flutter-permission-handler, including a list of plugins used by this application: https://github.com/Baseflow/flutter-permission-handler/issues");
                return false;
            }
            List asList = Arrays.asList(strArr);
            int indexOf = asList.indexOf("android.permission.WRITE_CALENDAR");
            if (indexOf >= 0) {
                int k = PermissionUtils.k(this.c, "android.permission.WRITE_CALENDAR", iArr[indexOf]);
                this.e.put(36, Integer.valueOf(k));
                int indexOf2 = asList.indexOf("android.permission.READ_CALENDAR");
                if (indexOf2 >= 0) {
                    Integer i2 = PermissionUtils.i(Integer.valueOf(k), Integer.valueOf(PermissionUtils.k(this.c, "android.permission.READ_CALENDAR", iArr[indexOf2])));
                    i2.intValue();
                    this.e.put(37, i2);
                    this.e.put(0, i2);
                }
            }
            for (int i3 = 0; i3 < strArr.length; i3++) {
                String str = strArr[i3];
                if (!str.equals("android.permission.WRITE_CALENDAR") && !str.equals("android.permission.READ_CALENDAR") && (g = PermissionUtils.g(str)) != 20) {
                    int i4 = iArr[i3];
                    if (g == 8) {
                        this.e.put(8, PermissionUtils.i((Integer) this.e.get(8), Integer.valueOf(PermissionUtils.k(this.c, str, i4))));
                    } else if (g == 7) {
                        if (!this.e.containsKey(7)) {
                            this.e.put(7, Integer.valueOf(PermissionUtils.k(this.c, str, i4)));
                        }
                        if (!this.e.containsKey(14)) {
                            this.e.put(14, Integer.valueOf(PermissionUtils.k(this.c, str, i4)));
                        }
                    } else if (g == 4) {
                        int k2 = PermissionUtils.k(this.c, str, i4);
                        if (!this.e.containsKey(4)) {
                            this.e.put(4, Integer.valueOf(k2));
                        }
                    } else if (g == 3) {
                        int k3 = PermissionUtils.k(this.c, str, i4);
                        if (!this.e.containsKey(5)) {
                            this.e.put(5, Integer.valueOf(k3));
                        }
                        this.e.put(Integer.valueOf(g), Integer.valueOf(k3));
                    } else if (g == 9 || g == 32) {
                        this.e.put(Integer.valueOf(g), Integer.valueOf(d(g)));
                    } else if (!this.e.containsKey(Integer.valueOf(g))) {
                        this.e.put(Integer.valueOf(g), Integer.valueOf(PermissionUtils.k(this.c, str, i4)));
                    }
                }
            }
            int length = this.d - iArr.length;
            this.d = length;
            RequestPermissionsSuccessCallback requestPermissionsSuccessCallback = this.b;
            if (requestPermissionsSuccessCallback == null || length != 0) {
                return true;
            }
            requestPermissionsSuccessCallback.a(this.e);
            return true;
        }
    }
}
