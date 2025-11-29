package com.upuphone.ar.tici.phone.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\b#\u0018\u0000 !2\u00020\u0001:\u0001EB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030#H\u0000¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0015H\u0000¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0015H\u0000¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u001aH\u0000¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u001aH\u0000¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\rH\u0000¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0015H\u0000¢\u0006\u0004\b4\u0010'J\u0017\u00106\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u0015H\u0000¢\u0006\u0004\b6\u0010*J\u000f\u00107\u001a\u00020\u001aH\u0000¢\u0006\u0004\b7\u0010,J\u0017\u00109\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u001aH\u0000¢\u0006\u0004\b9\u0010/J\u000f\u0010:\u001a\u00020\u000fH\u0000¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\rH\u0000¢\u0006\u0004\b=\u00101J\u000f\u0010>\u001a\u00020\rH\u0000¢\u0006\u0004\b>\u00103J\u0017\u0010?\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\rH\u0000¢\u0006\u0004\b?\u00101J\u000f\u0010@\u001a\u00020\rH\u0000¢\u0006\u0004\b@\u00103J\u0017\u0010A\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u0015H\u0000¢\u0006\u0004\bA\u0010*J\u000f\u0010B\u001a\u00020\u0015H\u0000¢\u0006\u0004\bB\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/SpUtil;", "", "", "name", "<init>", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "m", "(Landroid/content/Context;)Landroid/content/SharedPreferences;", "key", "", "value", "", "q", "(Landroid/content/Context;Ljava/lang/String;Z)V", "default", "e", "(Landroid/content/Context;Ljava/lang/String;Z)Z", "", "g", "(Landroid/content/Context;Ljava/lang/String;I)I", "r", "(Landroid/content/Context;Ljava/lang/String;I)V", "", "i", "(Landroid/content/Context;Ljava/lang/String;J)J", "s", "(Landroid/content/Context;Ljava/lang/String;J)V", "t", "(Landroid/content/Context;Ljava/lang/String;)V", "b", "(Landroid/content/Context;)V", "", "d", "()Ljava/util/Map;", "n", "()I", "mode", "A", "(I)V", "o", "()J", "speed", "B", "(J)V", "x", "(Z)V", "j", "()Z", "k", "location", "y", "h", "ticiId", "v", "c", "()V", "result", "w", "p", "z", "l", "u", "f", "a", "Ljava/lang/String;", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSpUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpUtil.kt\ncom/upuphone/ar/tici/phone/utils/SpUtil\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,400:1\n39#2,12:401\n39#2,12:413\n39#2,12:425\n39#2,12:437\n39#2,12:449\n39#2,12:461\n*S KotlinDebug\n*F\n+ 1 SpUtil.kt\ncom/upuphone/ar/tici/phone/utils/SpUtil\n*L\n83#1:401,12\n97#1:413,12\n113#1:425,12\n129#1:437,12\n138#1:449,12\n156#1:461,12\n*E\n"})
public final class SpUtil {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static final ConcurrentHashMap c = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public final String f5998a;

    @SourceDebugExtension({"SMAP\nSpUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpUtil.kt\ncom/upuphone/ar/tici/phone/utils/SpUtil$Companion\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,400:1\n72#2,2:401\n1#3:403\n*S KotlinDebug\n*F\n+ 1 SpUtil.kt\ncom/upuphone/ar/tici/phone/utils/SpUtil$Companion\n*L\n72#1:401,2\n72#1:403\n*E\n"})
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0014\u0010\u001a\u001a\u00020\f8\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001b\u001a\u00020\f8\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u000eR\u0014\u0010\u001c\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0010R\u0014\u0010\u001e\u001a\u00020\u001d8\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001d8\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u001d8\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u001fR \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/SpUtil$Companion;", "", "<init>", "()V", "", "userId", "Lcom/upuphone/ar/tici/phone/utils/SpUtil;", "c", "(Ljava/lang/String;)Lcom/upuphone/ar/tici/phone/utils/SpUtil;", "b", "a", "()Lcom/upuphone/ar/tici/phone/utils/SpUtil;", "", "DEFAULT_TICI_SPEED", "J", "KEY_DB_MIGRATED", "Ljava/lang/String;", "KEY_GLASS_TICI_VERSION", "KEY_HAS_GLASS_TICI_RECORD", "KEY_LAST_TICI_ID", "KEY_NEED_SHOW_IMPORT_FILE_TIP", "KEY_SCREEN_LOCATION", "KEY_TICI_MODE", "KEY_TICI_RECEIVE_NOTIFICATION", "KEY_TICI_SPEED", "KEY_VOICE_DETECT_SWITCH", "MAX_TICI_SPEED", "MIN_TICI_SPEED", "SP_NAME", "", "TICI_MODE_AI", "I", "TICI_MODE_AUTO", "TICI_MODE_MANUAL", "Ljava/util/concurrent/ConcurrentHashMap;", "userSPCache", "Ljava/util/concurrent/ConcurrentHashMap;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SpUtil a() {
            return new SpUtil("tici_sp");
        }

        public final SpUtil b(String str) {
            Intrinsics.checkNotNullParameter(str, "userId");
            ConcurrentHashMap a2 = SpUtil.c;
            Object obj = a2.get(str);
            if (obj == null) {
                obj = new SpUtil("tici_sp_" + str);
                Object putIfAbsent = a2.putIfAbsent(str, obj);
                if (putIfAbsent != null) {
                    obj = putIfAbsent;
                }
            }
            Intrinsics.checkNotNullExpressionValue(obj, "getOrPut(...)");
            return (SpUtil) obj;
        }

        public final SpUtil c(String str) {
            return (str == null || str.length() == 0) ? a() : b(str);
        }

        public Companion() {
        }
    }

    public SpUtil(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f5998a = str;
    }

    public final void A(int i) {
        r(SpUtilKt.c(), "tici_mode", i);
    }

    public final void B(long j) {
        s(SpUtilKt.c(), "tici_speed_time", j);
    }

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences m = m(context);
        Intrinsics.checkNotNullExpressionValue(m, "getSp(...)");
        SharedPreferences.Editor edit = m.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.clear();
        edit.apply();
    }

    public final void c() {
        t(SpUtilKt.c(), "last_tici_id");
    }

    public final Map d() {
        Map<String, ?> all = m(SpUtilKt.c()).getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        return all;
    }

    public final boolean e(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        return m(context).getBoolean(str, z);
    }

    public final int f() {
        return g(SpUtilKt.c(), "tici_glass_tici_version", 0);
    }

    public final int g(Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        return m(context).getInt(str, i);
    }

    public final long h() {
        return i(SpUtilKt.c(), "last_tici_id", -1);
    }

    public final long i(Context context, String str, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        return m(context).getLong(str, j);
    }

    public final boolean j() {
        return e(SpUtilKt.c(), "tici_receive_notification", false);
    }

    public final int k() {
        return g(SpUtilKt.c(), "tici_screen_location", 0);
    }

    public final boolean l() {
        return e(SpUtilKt.c(), "need_show_import_file_tip", true);
    }

    public final SharedPreferences m(Context context) {
        return context.getApplicationContext().getSharedPreferences(this.f5998a, 0);
    }

    public final int n() {
        return g(SpUtilKt.c(), "tici_mode", 0);
    }

    public final long o() {
        return i(SpUtilKt.c(), "tici_speed_time", 10000);
    }

    public final boolean p() {
        return e(SpUtilKt.c(), "tici_db_migrated", false);
    }

    public final void q(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        SharedPreferences m = m(context);
        Intrinsics.checkNotNullExpressionValue(m, "getSp(...)");
        SharedPreferences.Editor edit = m.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putBoolean(str, z);
        edit.apply();
    }

    public final void r(Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        SharedPreferences m = m(context);
        Intrinsics.checkNotNullExpressionValue(m, "getSp(...)");
        SharedPreferences.Editor edit = m.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putInt(str, i);
        edit.apply();
    }

    public final void s(Context context, String str, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        SharedPreferences m = m(context);
        Intrinsics.checkNotNullExpressionValue(m, "getSp(...)");
        SharedPreferences.Editor edit = m.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putLong(str, j);
        edit.apply();
    }

    public final void t(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        SharedPreferences m = m(context);
        Intrinsics.checkNotNullExpressionValue(m, "getSp(...)");
        SharedPreferences.Editor edit = m.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.remove(str);
        edit.apply();
    }

    public final void u(int i) {
        r(SpUtilKt.c(), "tici_glass_tici_version", i);
    }

    public final void v(long j) {
        s(SpUtilKt.c(), "last_tici_id", j);
    }

    public final void w(boolean z) {
        q(SpUtilKt.c(), "tici_db_migrated", z);
    }

    public final void x(boolean z) {
        q(SpUtilKt.c(), "tici_receive_notification", z);
    }

    public final void y(int i) {
        r(SpUtilKt.c(), "tici_screen_location", i);
    }

    public final void z(boolean z) {
        q(SpUtilKt.c(), "need_show_import_file_tip", z);
    }
}
