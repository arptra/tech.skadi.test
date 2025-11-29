package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.IGlassInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ[\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/utils/VersionMatchHelper;", "", "<init>", "()V", "", "isSupportOversea", "isSupportAir", "isSupportAirPro", "", "airTv", "airOverseaTv", "airProTv", "airProOverseaTv", "f", "(ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "d", "targetVersion", "a", "(Ljava/lang/String;)Z", "h", "b", "()Z", "isAir", "c", "isAirPro", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VersionMatchHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final VersionMatchHelper f7930a = new VersionMatchHelper();

    public static /* synthetic */ boolean e(VersionMatchHelper versionMatchHelper, boolean z, boolean z2, boolean z3, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        boolean z4 = true;
        boolean z5 = (i & 2) != 0 ? true : z2;
        if ((i & 4) == 0) {
            z4 = z3;
        }
        return versionMatchHelper.d(z, z5, z4, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4);
    }

    public static /* synthetic */ boolean g(VersionMatchHelper versionMatchHelper, boolean z, boolean z2, boolean z3, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        boolean z4 = true;
        boolean z5 = (i & 2) != 0 ? true : z2;
        if ((i & 4) == 0) {
            z4 = z3;
        }
        return versionMatchHelper.f(z, z5, z4, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4);
    }

    public final boolean a(String str) {
        IGlassInfo a2 = SdkContext.f6675a.e().a();
        if (a2 == null) {
            return false;
        }
        String c = GlassInfoExtKt.c(GlassInfoExtKt.d(a2.getRomVersion()));
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VersionMatchHelper", "afterSupport glassVersion:" + c + " targetVersion:" + str);
        return GlassInfoExtKt.j(c, str) > 0;
    }

    public final boolean b() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().isAir();
    }

    public final boolean c() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().isAirPro();
    }

    public final boolean d(boolean z, boolean z2, boolean z3, String str, String str2, String str3, String str4) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VersionMatchHelper", "isSupportAfter " + z + " isSupportAir:" + z2 + " isSupportAirPro:" + z3 + ",airTv:" + str + " ,airOverseaTv:" + str2 + " ,airProTv:" + str3 + " ,airProOverseaTv:" + str4);
        if (!z) {
            Boolean bool = BuildConfig.f6575a;
            Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
            if (bool.booleanValue()) {
                return false;
            }
        }
        Boolean bool2 = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool2, "COUNTRY_INTL");
        if (bool2.booleanValue()) {
            str = str2;
        }
        if (b() && !z2) {
            return false;
        }
        if (b() && str != null) {
            return h(str);
        }
        Intrinsics.checkNotNullExpressionValue(bool2, "COUNTRY_INTL");
        if (bool2.booleanValue()) {
            str3 = str4;
        }
        if (c() && !z3) {
            return false;
        }
        if (!c() || str3 == null) {
            return true;
        }
        return h(str3);
    }

    public final boolean f(boolean z, boolean z2, boolean z3, String str, String str2, String str3, String str4) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VersionMatchHelper", "isSupportAfter " + z + " isSupportAir:" + z2 + " isSupportAirPro:" + z3 + ",airTv:" + str + " ,airOverseaTv:" + str2 + " ,airProTv:" + str3 + " ,airProOverseaTv:" + str4);
        if (!z) {
            Boolean bool = BuildConfig.f6575a;
            Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
            if (bool.booleanValue()) {
                return false;
            }
        }
        Boolean bool2 = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool2, "COUNTRY_INTL");
        if (bool2.booleanValue()) {
            str = str2;
        }
        if (b() && !z2) {
            return false;
        }
        if (b() && str != null) {
            return a(str);
        }
        Intrinsics.checkNotNullExpressionValue(bool2, "COUNTRY_INTL");
        if (bool2.booleanValue()) {
            str3 = str4;
        }
        if (c() && !z3) {
            return false;
        }
        if (!c() || str3 == null) {
            return true;
        }
        return a(str3);
    }

    public final boolean h(String str) {
        IGlassInfo a2 = SdkContext.f6675a.e().a();
        if (a2 == null) {
            return false;
        }
        String c = GlassInfoExtKt.c(GlassInfoExtKt.d(a2.getRomVersion()));
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VersionMatchHelper", "afterSupport glassVersion:" + c + " targetVersion:" + str);
        return GlassInfoExtKt.j(c, str) >= 0;
    }
}
