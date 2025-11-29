package com.upuphone.xr.sapp.utils;

import android.bluetooth.BluetoothManager;
import android.content.ComponentName;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.entity.PermissionDesp;
import com.upuphone.xr.sapp.monitor.sport.mz.PedoUtil;
import com.xjmz.myvu.ext.ConnectExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b(\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u0011\u0010\n\u001a\u00020\t*\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e*\u00020\f2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u0005*\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u00020\u0013*\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0005*\u00020\f¢\u0006\u0004\b\u0016\u0010\u0012J\u0011\u0010\u0017\u001a\u00020\u0005*\u00020\f¢\u0006\u0004\b\u0017\u0010\u0012J\u0011\u0010\u0018\u001a\u00020\u0005*\u00020\f¢\u0006\u0004\b\u0018\u0010\u0012J\u0017\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u0012J\u0011\u0010\u001b\u001a\u00020\u0005*\u00020\f¢\u0006\u0004\b\u001b\u0010\u0012J\u0011\u0010\u001c\u001a\u00020\u0005*\u00020\f¢\u0006\u0004\b\u001c\u0010\u0012R!\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\u001f\u0010 R!\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001e\u001a\u0004\b\"\u0010 R!\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b$\u0010 R!\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b&\u0010 R!\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u001e\u001a\u0004\b(\u0010 R!\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b*\u0010 R!\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b,\u0010 R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001e\u001a\u0004\b.\u0010 R!\u00102\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010 R!\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b3\u0010 R!\u00107\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b5\u0010\u001e\u001a\u0004\b6\u0010 R!\u00109\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b.\u0010\u001e\u001a\u0004\b8\u0010 R!\u0010:\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b,\u0010\u001e\u001a\u0004\b5\u0010 R!\u0010<\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8FX\u0002¢\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b;\u0010 R\u0011\u0010?\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0011\u0010A\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b@\u0010>R\u0013\u0010D\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/upuphone/xr/sapp/utils/PermissionAndStateCheckUtils;", "", "<init>", "()V", "Landroidx/fragment/app/Fragment;", "", "d", "(Landroidx/fragment/app/Fragment;)Z", "e", "", "a", "(Landroidx/fragment/app/Fragment;)Ljava/lang/String;", "Landroid/content/Context;", "permission", "Lcom/upuphone/xr/sapp/entity/PermissionDesp;", "s", "(Landroid/content/Context;Ljava/lang/String;)Lcom/upuphone/xr/sapp/entity/PermissionDesp;", "k", "(Landroid/content/Context;)Z", "", "h", "(Landroidx/fragment/app/Fragment;)V", "g", "f", "b", "mContext", "i", "C", "c", "", "Lkotlin/Lazy;", "z", "()[Ljava/lang/String;", "thirdStarryBTPermissions", "A", "thirdStarryLocationPermissions", "t", "backgroundLocationPermissions", "getThirdStarryPermissions", "thirdStarryPermissions", "o", "appPermissionFlyme", "p", "appPermissionNotify", "n", "appContactPermission", "m", "appCallLogPermission", "j", "q", "appPhoneAndDialPermission", "r", "appReadCalendarPermission", "l", "y", "recordAudioPermission", "u", "cameraPermission", "albumPermission", "v", "floatWindowPermission", "B", "()Z", "isGPSEnabled", "w", "hasFineLocationPermission", "x", "()Ljava/lang/Boolean;", "hasNearbyWifiDevicesPermission", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPermissionAndStateCheckUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionAndStateCheckUtils.kt\ncom/upuphone/xr/sapp/utils/PermissionAndStateCheckUtils\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,534:1\n37#2,2:535\n*S KotlinDebug\n*F\n+ 1 PermissionAndStateCheckUtils.kt\ncom/upuphone/xr/sapp/utils/PermissionAndStateCheckUtils\n*L\n415#1:535,2\n*E\n"})
public final class PermissionAndStateCheckUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final PermissionAndStateCheckUtils f7907a = new PermissionAndStateCheckUtils();
    public static final Lazy b = LazyKt.lazy(PermissionAndStateCheckUtils$thirdStarryBTPermissions$2.INSTANCE);
    public static final Lazy c = LazyKt.lazy(PermissionAndStateCheckUtils$thirdStarryLocationPermissions$2.INSTANCE);
    public static final Lazy d = LazyKt.lazy(PermissionAndStateCheckUtils$backgroundLocationPermissions$2.INSTANCE);
    public static final Lazy e = LazyKt.lazy(PermissionAndStateCheckUtils$thirdStarryPermissions$2.INSTANCE);
    public static final Lazy f = LazyKt.lazy(PermissionAndStateCheckUtils$appPermissionFlyme$2.INSTANCE);
    public static final Lazy g = LazyKt.lazy(PermissionAndStateCheckUtils$appPermissionNotify$2.INSTANCE);
    public static final Lazy h = LazyKt.lazy(PermissionAndStateCheckUtils$appContactPermission$2.INSTANCE);
    public static final Lazy i = LazyKt.lazy(PermissionAndStateCheckUtils$appCallLogPermission$2.INSTANCE);
    public static final Lazy j = LazyKt.lazy(PermissionAndStateCheckUtils$appPhoneAndDialPermission$2.INSTANCE);
    public static final Lazy k = LazyKt.lazy(PermissionAndStateCheckUtils$appReadCalendarPermission$2.INSTANCE);
    public static final Lazy l = LazyKt.lazy(PermissionAndStateCheckUtils$recordAudioPermission$2.INSTANCE);
    public static final Lazy m = LazyKt.lazy(PermissionAndStateCheckUtils$cameraPermission$2.INSTANCE);
    public static final Lazy n = LazyKt.lazy(PermissionAndStateCheckUtils$albumPermission$2.INSTANCE);
    public static final Lazy o = LazyKt.lazy(PermissionAndStateCheckUtils$floatWindowPermission$2.INSTANCE);

    public static /* synthetic */ boolean j(PermissionAndStateCheckUtils permissionAndStateCheckUtils, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = GlobalExtKt.f();
        }
        return permissionAndStateCheckUtils.i(context);
    }

    public final String[] A() {
        return (String[]) c.getValue();
    }

    public final boolean B() {
        Object systemService = GlobalExtKt.f().getSystemService("location");
        LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
        if (locationManager != null) {
            return locationManager.isProviderEnabled("gps");
        }
        return false;
    }

    public final boolean C(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            return powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
        }
        return false;
    }

    public final String a(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        boolean z = true;
        boolean z2 = ConnectExtKt.d() != null && !BuildConfig.f6575a.booleanValue();
        boolean z3 = (ConnectExtKt.c() == null && ConnectExtKt.a() == null) ? false : true;
        if (ConnectExtKt.a() == null) {
            z = false;
        }
        if ((z2 || z3) && !StaticMethodUtilsKt.a(fragment, A())) {
            return A()[0];
        }
        if (z3 && !StaticMethodUtilsKt.a(fragment, z())) {
            return z()[0];
        }
        if (!z) {
            return (!z2 || StaticMethodUtilsKt.a(fragment, l())) ? "" : l()[0];
        }
        if (d(fragment)) {
            return "flyme_link_top_show";
        }
        if (e(fragment)) {
            return "super_notify_keeplive";
        }
        if (!StaticMethodUtilsKt.a(fragment, n())) {
            return n()[0];
        }
        if (!StaticMethodUtilsKt.a(fragment, m()) && !BuildConfig.f6575a.booleanValue()) {
            return m()[0];
        }
        if (!StaticMethodUtilsKt.a(fragment, q())) {
            return q()[0];
        }
        if (!StaticMethodUtilsKt.a(fragment, r())) {
            return r()[0];
        }
        if (!StaticMethodUtilsKt.a(fragment, p())) {
            return p()[0];
        }
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        if (!g(requireContext)) {
            return "notification_user_permission";
        }
        PedoUtil pedoUtil = PedoUtil.f7798a;
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        if (!pedoUtil.d(context)) {
            return "meizu_sport_not_install";
        }
        Context context2 = fragment.getContext();
        Intrinsics.checkNotNull(context2);
        return pedoUtil.c(context2) == null ? "meizu_sport_not_authorize" : "";
    }

    public final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        return ((BluetoothManager) systemService).getAdapter().isEnabled();
    }

    public final boolean c(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return Settings.canDrawOverlays(context);
    }

    public final boolean d(Fragment fragment) {
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        boolean l2 = StaticMethodUtilsKt.l(requireContext);
        Context requireContext2 = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        C(requireContext2);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("checkFlymeLinkPermission", "checkFlymeLinkPermission::enhancedServiceOpen is: " + l2 + " and flymeLinkShow is");
        if (!l2) {
            StaticMethodUtilsKt.R(fragment);
        }
        return !l2;
    }

    public final boolean e(Fragment fragment) {
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        boolean C = C(requireContext);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("checkIgnoringBatteryOptimizations", "checkIgnoringBatteryOptimizations is: " + C + " ");
        if (!C) {
            Boolean bool = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        return ((LocationManager) systemService).isProviderEnabled("gps");
    }

    public final boolean g(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        int i2 = 0;
        try {
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
            if (string == null) {
                return false;
            }
            String[] strArr = (String[]) StringsKt.split$default((CharSequence) string, new String[]{AccountConstantKt.CODE_SEPARTOR}, false, 0, 6, (Object) null).toArray(new String[0]);
            int length = strArr.length;
            boolean z = false;
            while (i2 < length) {
                try {
                    ComponentName unflattenFromString = ComponentName.unflattenFromString(strArr[i2]);
                    if (unflattenFromString != null && TextUtils.equals(packageName, unflattenFromString.getPackageName())) {
                        z = true;
                    }
                    i2++;
                } catch (Exception unused) {
                }
            }
            return z;
        } catch (Exception unused2) {
            return false;
        }
    }

    public final void h(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        if (!g(requireContext)) {
            StaticMethodUtilsKt.t(fragment, R.id.reminderPermissionSteer);
        }
    }

    public final boolean i(Context context) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        return ((Boolean) DataStoreUtils.e.a().g("sp_user_agreement_state", Boolean.FALSE, context)).booleanValue();
    }

    public final boolean k(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return NotificationManagerCompat.g(context).a();
    }

    public final String[] l() {
        return (String[]) n.getValue();
    }

    public final String[] m() {
        return (String[]) i.getValue();
    }

    public final String[] n() {
        return (String[]) h.getValue();
    }

    public final String[] o() {
        return (String[]) f.getValue();
    }

    public final String[] p() {
        return (String[]) g.getValue();
    }

    public final String[] q() {
        return (String[]) j.getValue();
    }

    public final String[] r() {
        return (String[]) k.getValue();
    }

    public final PermissionDesp s(Context context, String str) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, "permission");
        if (ArraysKt.contains((T[]) n(), str)) {
            str3 = context.getString(R.string.contact_permission_title);
            Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
            str2 = context.getString(R.string.contact_permission_content);
            Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
        } else if (ArraysKt.contains((T[]) m(), str)) {
            str3 = context.getString(R.string.calllog_permission_tittle);
            Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
            str2 = context.getString(R.string.callog_permisson_content);
            Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
        } else if (ArraysKt.contains((T[]) q(), str)) {
            str3 = context.getString(R.string.make_call_permission_title);
            Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
            if (Build.VERSION.SDK_INT > 33 || AppUtils.f7842a.j()) {
                str2 = context.getString(R.string.make_call_permission_content) + context.getString(R.string.make_call_permission_content_sim);
            } else {
                str2 = context.getString(R.string.make_call_permission_content);
                Intrinsics.checkNotNull(str2);
            }
        } else if (ArraysKt.contains((T[]) r(), str)) {
            str3 = context.getResources().getString(R.string.permission_read_calendar);
            Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
            str2 = ExtendsKt.a("permission_read_calendar_tips");
        } else if (ArraysKt.contains((T[]) A(), str)) {
            str3 = context.getString(R.string.permission_reminder_title_location);
            Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
            if (Build.VERSION.SDK_INT < 31) {
                str2 = GlobalExtKt.f().getString(R.string.flyme_internal_app_permission_location_text_android_r);
                Intrinsics.checkNotNull(str2);
            } else {
                str2 = GlobalExtKt.f().getString(R.string.flyme_internal_app_permission_location_text);
                Intrinsics.checkNotNull(str2);
            }
        } else if (ArraysKt.contains((T[]) z(), str)) {
            str3 = context.getString(R.string.permission_reminder_title_bluetooth);
            Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
            str2 = context.getString(R.string.bt_content);
            Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
        } else if (ArraysKt.contains((T[]) l(), str)) {
            str3 = context.getString(R.string.view_permission_reminder_title_gallery);
            Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
            str2 = OSHelper.f7904a.e() ? GlobalExtKt.h(R.string.flyme_internal_app_permission_storage_text) : GlobalExtKt.h(R.string.flyme_internal_app_permission_media_visual_text);
        } else if (Intrinsics.areEqual((Object) str, (Object) "super_notify_keeplive")) {
            PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
            if (phoneTypeUtils.e()) {
                str3 = context.getString(R.string.ignore_batt_title_xiaomi);
                Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
                str2 = context.getString(R.string.ignore_batt_content_xiaomi);
                Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
            } else if (phoneTypeUtils.c()) {
                str3 = context.getString(R.string.ignore_batt_title_huawei);
                Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
                str2 = context.getString(R.string.ignore_batt_content_huawei);
                Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
            } else {
                str3 = context.getString(R.string.ignore_batt_title_normol);
                Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
                str2 = context.getString(R.string.ignore_batt_content_normol);
                Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
            }
        } else {
            if (Intrinsics.areEqual((Object) str, (Object) "meizu_sport_not_authorize")) {
                PhoneTypeUtils phoneTypeUtils2 = PhoneTypeUtils.f7912a;
                if (phoneTypeUtils2.i()) {
                    str3 = context.getString(R.string.meizu_go_title);
                    Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
                    str2 = context.getString(R.string.meizu_go_content);
                    Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
                } else if (phoneTypeUtils2.c()) {
                    str3 = context.getString(R.string.sh_title);
                    Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
                    str2 = context.getString(R.string.sh_content);
                    Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) "meizu_sport_not_install")) {
                PhoneTypeUtils phoneTypeUtils3 = PhoneTypeUtils.f7912a;
                if (phoneTypeUtils3.i()) {
                    str3 = context.getString(R.string.download_meizu_title);
                    Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
                    str2 = context.getString(R.string.download_meizu_content);
                    Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
                } else if (phoneTypeUtils3.c()) {
                    str3 = context.getString(R.string.download_sh);
                    Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
                    str2 = context.getString(R.string.download_content);
                    Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
                }
            } else if (ArraysKt.contains((T[]) p(), str)) {
                str3 = context.getString(R.string.permission_reminder_title_notification);
                Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
                str2 = context.getString(R.string.notification_connect_note);
                Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
            } else if (Intrinsics.areEqual((Object) str, (Object) "notification_user_permission")) {
                str3 = context.getString(R.string.notification_title);
                Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
                str2 = context.getString(R.string.notification_content);
                Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
            } else if (Intrinsics.areEqual((Object) str, (Object) "permission_ai_model")) {
                str3 = context.getString(R.string.assistant_user_guide_title);
                Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
                str2 = context.getString(R.string.ai_model_permission_content);
                Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
            } else if (Intrinsics.areEqual((Object) str, (Object) "flyme_link_top_show")) {
                str3 = context.getString(R.string.flyme_link_top_title);
                Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
                str2 = context.getString(R.string.flyme_link_top_content);
                Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
            }
            str3 = "";
            str2 = str3;
        }
        return new PermissionDesp(str3, str2);
    }

    public final String[] t() {
        return (String[]) d.getValue();
    }

    public final String[] u() {
        return (String[]) m.getValue();
    }

    public final String[] v() {
        return (String[]) o.getValue();
    }

    public final boolean w() {
        return ContextCompat.checkSelfPermission(GlobalExtKt.f(), "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public final Boolean x() {
        if (Build.VERSION.SDK_INT < 33) {
            return null;
        }
        return Boolean.valueOf(ContextCompat.checkSelfPermission(GlobalExtKt.f(), "android.permission.NEARBY_WIFI_DEVICES") == 0);
    }

    public final String[] y() {
        return (String[]) l.getValue();
    }

    public final String[] z() {
        return (String[]) b.getValue();
    }
}
