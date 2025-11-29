package com.upuphone.xr.sapp.utils;

import android.os.Build;
import androidx.core.content.ContextCompat;
import com.meizu.net.pedometerprovider.util.Constants;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u0010\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0011\u0010\u0012\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006R\u0011\u0010\u0014\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/utils/OSHelper;", "", "<init>", "()V", "", "g", "()Z", "f", "", "", "permission", "c", "([Ljava/lang/String;)Z", "d", "isBelowAndroid12", "e", "isBelowAndroid13", "b", "needLocationEnable", "a", "needBluetoothPermission", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nOSHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSHelper.kt\ncom/upuphone/xr/sapp/utils/OSHelper\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,98:1\n13309#2,2:99\n*S KotlinDebug\n*F\n+ 1 OSHelper.kt\ncom/upuphone/xr/sapp/utils/OSHelper\n*L\n62#1:99,2\n*E\n"})
public final class OSHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final OSHelper f7904a = new OSHelper();

    public final boolean a() {
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        return bool.booleanValue() && !d();
    }

    public final boolean b() {
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        return bool.booleanValue() && d();
    }

    public final boolean c(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permission");
        for (String checkSelfPermission : strArr) {
            if (ContextCompat.checkSelfPermission(MainApplication.k.f(), checkSelfPermission) != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean d() {
        return Build.VERSION.SDK_INT < 31;
    }

    public final boolean e() {
        return Build.VERSION.SDK_INT < 33;
    }

    public final boolean f() {
        Locale locale = Locale.getDefault();
        return Intrinsics.areEqual((Object) locale.getLanguage(), (Object) "zh") && Intrinsics.areEqual((Object) locale.getCountry(), (Object) Constants.CHINA_COUNTRY);
    }

    public final boolean g() {
        try {
            return !BuildConfig.b.booleanValue();
        } catch (Exception unused) {
            ULog.f6446a.c("OSHelper", "isFlyMeOS: Exception");
            return false;
        }
    }
}
