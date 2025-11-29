package com.upuphone.xr.sapp.utils;

import android.content.res.Resources;
import com.upuphone.xr.interconnect.InterconnectManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "a", "(Ljava/lang/String;)Ljava/lang/String;", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class ExtendsKt {
    public static final String a(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            String str2 = InterconnectManager.getInstance().getStarryNetDeviceManager().isAirPro() ? "_airpro" : InterconnectManager.getInstance().getStarryNetDeviceManager().isAir() ? "_air" : "_star";
            Resources resources = GlobalExtKt.f().getResources();
            obj = Result.m20constructorimpl(resources.getString(resources.getIdentifier(str + str2, "string", GlobalExtKt.f().getPackageName())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m26isFailureimpl(obj)) {
            obj = null;
        }
        String str3 = (String) obj;
        return str3 == null ? "" : str3;
    }
}
