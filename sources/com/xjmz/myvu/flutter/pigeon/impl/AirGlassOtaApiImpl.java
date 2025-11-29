package com.xjmz.myvu.flutter.pigeon.impl;

import android.os.Build;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.httplib.SignUtils;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.xjmz.myvu.MYVUActivity;
import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassOtaApi;
import java.util.Map;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\r\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/AirGlassOtaApiImpl;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAirGlassOtaApi$AirGlassOtaApi;", "<init>", "()V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAirGlassOtaApi$Result;", "", "result", "", "c", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidAirGlassOtaApi$Result;)V", "", "", "params", "j", "(Ljava/util/Map;)Ljava/lang/String;", "i", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AirGlassOtaApiImpl implements AndroidAirGlassOtaApi.AirGlassOtaApi {

    /* renamed from: a  reason: collision with root package name */
    public static final AirGlassOtaApiImpl f8340a = new AirGlassOtaApiImpl();

    public void c(AndroidAirGlassOtaApi.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        MYVUActivity r = MainApplication.k.f().r();
        boolean c0 = GlassUpdateHelper.b.c0(r);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AirGlassOtaApiImpl", "checkIfUpdating, activity: " + r + ", isUpdating: " + c0);
        result.success(Boolean.valueOf(c0));
    }

    public String i() {
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, "MODEL");
        return str;
    }

    public String j(Map map) {
        Intrinsics.checkNotNullParameter(map, PayloadConstant.KEY_PARAMS);
        return SignUtils.signWithHMacSha256$default(SignUtils.INSTANCE, map, (SecretKey) null, 2, (Object) null);
    }
}
