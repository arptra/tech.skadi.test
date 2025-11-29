package com.xjsd.ai.assistant.skill.call.util;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Process;
import android.provider.Settings;
import com.xjsd.ai.assistant.common.util.DeviceBrandUtil;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\bJ\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ\u0017\u0010 \u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u001bJ\u001f\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/util/PopBackgroundPermissionUtil;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "h", "(Landroid/content/Context;)Z", "f", "g", "Landroid/app/Activity;", "", "requestCode", "", "m", "(Landroid/app/Activity;I)V", "opCode", "d", "(Landroid/content/Context;I)Z", "", "path", "c", "(Landroid/content/Context;Ljava/lang/String;)Z", "b", "Landroid/content/Intent;", "i", "(Landroid/content/Context;)Landroid/content/Intent;", "n", "k", "j", "l", "a", "intent", "e", "(Landroid/content/Context;Landroid/content/Intent;)Z", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PopBackgroundPermissionUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final PopBackgroundPermissionUtil f8680a = new PopBackgroundPermissionUtil();

    public final Intent a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        return intent;
    }

    public final boolean b(Context context) {
        try {
            Object systemService = context.getSystemService("appops");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AppOpsManager");
            Class<?> cls = Class.forName("com.huawei.android.app.AppOpsManagerEx");
            Class cls2 = Integer.TYPE;
            Object invoke = cls.getDeclaredMethod("checkHwOpNoThrow", new Class[]{AppOpsManager.class, cls2, cls2, String.class}).invoke(cls.newInstance(), new Object[]{(AppOpsManager) systemService, 100000, Integer.valueOf(Binder.getCallingUid()), context.getPackageName()});
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Int");
            boolean z = ((Integer) invoke).intValue() == 0;
            ILog.a("PopBackgroundPermissionUtil", "checkHwPermission: checkHwOpNoThrow, result->" + z);
            return z;
        } catch (Exception e) {
            ILog.h("PopBackgroundPermissionUtil", "checkHwPermission: checkHwOpNoThrow, exception", e);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003c, code lost:
        r3 = r2.getColumnIndex("currentstate");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(android.content.Context r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r8 = "checkVivoPermission: "
            java.lang.String r0 = "PopBackgroundPermissionUtil"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "content://com.vivo.permissionmanager.provider.permission/"
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            android.net.Uri r3 = android.net.Uri.parse(r1)
            java.lang.String r5 = "pkgname = ?"
            java.lang.String r1 = r9.getPackageName()
            java.lang.String[] r6 = new java.lang.String[]{r1}
            android.content.ContentResolver r2 = r9.getContentResolver()
            r4 = 0
            r7 = 0
            r9 = 1
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0073 }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ Exception -> 0x0073 }
            r2 = r1
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x004a }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x004a }
            boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x004a }
            if (r3 == 0) goto L_0x004c
            java.lang.String r3 = "currentstate"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ all -> 0x004a }
            r4 = -1
            if (r3 <= r4) goto L_0x004c
            int r2 = r2.getInt(r3)     // Catch:{ all -> 0x004a }
            goto L_0x004d
        L_0x004a:
            r2 = move-exception
            goto L_0x0075
        L_0x004c:
            r2 = r9
        L_0x004d:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004a }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r3)     // Catch:{ Exception -> 0x0073 }
            if (r2 != 0) goto L_0x0057
            r1 = r9
            goto L_0x0058
        L_0x0057:
            r1 = 0
        L_0x0058:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0073 }
            r2.<init>()     // Catch:{ Exception -> 0x0073 }
            r2.append(r8)     // Catch:{ Exception -> 0x0073 }
            r2.append(r10)     // Catch:{ Exception -> 0x0073 }
            java.lang.String r3 = ", result->"
            r2.append(r3)     // Catch:{ Exception -> 0x0073 }
            r2.append(r1)     // Catch:{ Exception -> 0x0073 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0073 }
            com.xjsd.ai.assistant.log.ILog.a(r0, r1)     // Catch:{ Exception -> 0x0073 }
            goto L_0x0092
        L_0x0073:
            r1 = move-exception
            goto L_0x007b
        L_0x0075:
            throw r2     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)     // Catch:{ Exception -> 0x0073 }
            throw r3     // Catch:{ Exception -> 0x0073 }
        L_0x007b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r8)
            r2.append(r10)
            java.lang.String r8 = ", exception"
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            com.xjsd.ai.assistant.log.ILog.h(r0, r8, r1)
        L_0x0092:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.call.util.PopBackgroundPermissionUtil.c(android.content.Context, java.lang.String):boolean");
    }

    public final boolean d(Context context, int i) {
        try {
            Object systemService = context.getSystemService("appops");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AppOpsManager");
            AppOpsManager appOpsManager = (AppOpsManager) systemService;
            Class<?> cls = appOpsManager.getClass();
            Class cls2 = Integer.TYPE;
            Object invoke = cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(i), Integer.valueOf(Process.myUid()), context.getPackageName()});
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Int");
            boolean z = ((Integer) invoke).intValue() == 0;
            ILog.a("PopBackgroundPermissionUtil", "checkXmPermission: opCode->" + i + ", result->" + z);
            return z;
        } catch (Exception e) {
            ILog.h("PopBackgroundPermissionUtil", "checkXmPermission: opCode->" + i + ", exception", e);
            return true;
        }
    }

    public final boolean e(Context context, Intent intent) {
        int size = context.getPackageManager().queryIntentActivities(intent, 65536).size();
        ComponentName component = intent.getComponent();
        ILog.a("PopBackgroundPermissionUtil", "查询activity, component->" + component + ", size->" + size);
        return size > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (b(r5) != false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (c(r5, "start_bg_activity") != false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        if (d(r5, 10021) != false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r4.h(r5)
            boolean r1 = com.xjsd.ai.assistant.common.util.DeviceBrandUtil.g()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x001f
            if (r0 == 0) goto L_0x001d
            r0 = 10021(0x2725, float:1.4042E-41)
            boolean r4 = r4.d(r5, r0)
            if (r4 == 0) goto L_0x001d
        L_0x001b:
            r0 = r3
            goto L_0x0040
        L_0x001d:
            r0 = r2
            goto L_0x0040
        L_0x001f:
            boolean r1 = com.xjsd.ai.assistant.common.util.DeviceBrandUtil.c()
            if (r1 == 0) goto L_0x002e
            if (r0 == 0) goto L_0x001d
            boolean r4 = r4.b(r5)
            if (r4 == 0) goto L_0x001d
            goto L_0x001b
        L_0x002e:
            boolean r1 = com.xjsd.ai.assistant.common.util.DeviceBrandUtil.f()
            if (r1 == 0) goto L_0x0040
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = "start_bg_activity"
            boolean r4 = r4.c(r5, r0)
            if (r4 == 0) goto L_0x001d
            goto L_0x001b
        L_0x0040:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "hasLaunchActivityFromBackgroundPermission: 授权结果->"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "PopBackgroundPermissionUtil"
            com.xjsd.ai.assistant.log.ILog.a(r5, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.call.util.PopBackgroundPermissionUtil.f(android.content.Context):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (c(r4, "control_locked_screen_action") != false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (d(r4, 10020) != false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = com.xjsd.ai.assistant.common.util.DeviceBrandUtil.g()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001d
            boolean r0 = r3.f(r4)
            if (r0 == 0) goto L_0x0041
            r0 = 10020(0x2724, float:1.4041E-41)
            boolean r3 = r3.d(r4, r0)
            if (r3 == 0) goto L_0x0041
        L_0x001b:
            r1 = r2
            goto L_0x0041
        L_0x001d:
            boolean r0 = com.xjsd.ai.assistant.common.util.DeviceBrandUtil.c()
            if (r0 == 0) goto L_0x0028
            boolean r1 = r3.f(r4)
            goto L_0x0041
        L_0x0028:
            boolean r0 = com.xjsd.ai.assistant.common.util.DeviceBrandUtil.f()
            if (r0 == 0) goto L_0x003d
            boolean r0 = r3.f(r4)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = "control_locked_screen_action"
            boolean r3 = r3.c(r4, r0)
            if (r3 == 0) goto L_0x0041
            goto L_0x001b
        L_0x003d:
            boolean r1 = r3.h(r4)
        L_0x0041:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "hasLaunchActivityWhenLockedPermission: 授权结果->"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "PopBackgroundPermissionUtil"
            com.xjsd.ai.assistant.log.ILog.a(r4, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.call.util.PopBackgroundPermissionUtil.g(android.content.Context):boolean");
    }

    public final boolean h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean canDrawOverlays = Settings.canDrawOverlays(context);
        ILog.a("PopBackgroundPermissionUtil", "hasSystemAlertWindowPermission: 授权结果->" + canDrawOverlays);
        return canDrawOverlays;
    }

    public final Intent i(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.security.privacycenter", "com.huawei.security.permission.ui.activity.PermissionSettingActivity");
        if (e(context, intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        if (e(context, intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        if (e(context, intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
        return e(context, intent) ? intent : l(context);
    }

    public final Intent j(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, context.getPackageName());
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        return e(context, intent) ? intent : l(context);
    }

    public final Intent k(Context context) {
        Intent intent = new Intent();
        intent.putExtra(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, context.getPackageName());
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
        if (e(context, intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
        if (e(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        return e(context, intent) ? intent : l(context);
    }

    public final Intent l(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        return e(context, intent) ? intent : a(context);
    }

    public final void m(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intent i2 = DeviceBrandUtil.c() ? i(activity) : DeviceBrandUtil.g() ? n(activity) : DeviceBrandUtil.e() ? k(activity) : DeviceBrandUtil.f() ? a(activity) : DeviceBrandUtil.d() ? j(activity) : a(activity);
        try {
            ComponentName component = i2.getComponent();
            ILog.a("PopBackgroundPermissionUtil", "启动activity, component->" + component);
            activity.startActivityForResult(i2, i);
        } catch (Exception e) {
            ComponentName component2 = i2.getComponent();
            ILog.h("PopBackgroundPermissionUtil", "启动activity, component->" + component2 + "异常", e);
            activity.startActivityForResult(a(activity), i);
        }
    }

    public final Intent n(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (e(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        return e(context, intent) ? intent : l(context);
    }
}
