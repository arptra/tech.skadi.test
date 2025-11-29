package com.upuphone.xr.sapp.utils;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.context.SdkContext;
import com.xjmz.myvu.ext.ConnectExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\nR\u001b\u0010\u000f\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/utils/UserGuideHelper;", "", "<init>", "()V", "", "deviceType", "d", "(Ljava/lang/String;)Ljava/lang/String;", "e", "b", "()Ljava/lang/String;", "a", "f", "Lkotlin/Lazy;", "c", "appearanceState", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class UserGuideHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final UserGuideHelper f7928a = new UserGuideHelper();
    public static final Lazy b = LazyKt.lazy(UserGuideHelper$appearanceState$2.INSTANCE);

    public final String a() {
        String o = NetConfig.f6666a.o();
        PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
        String b2 = phoneTypeUtils.b();
        String a2 = phoneTypeUtils.a();
        return o + "/#/guide/novice?brand=" + b2 + "&model=" + a2 + "&xrModels=XGA020C&os=Android";
    }

    public final String b() {
        Boolean a2 = SdkContext.f6675a.g().a();
        int i = 1;
        boolean booleanValue = a2 != null ? a2.booleanValue() : true;
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            i = -1;
        } else if (!booleanValue) {
            i = 0;
        }
        String language = GlobalExtKt.f().getResources().getConfiguration().getLocales().get(0).getLanguage();
        String country = GlobalExtKt.f().getResources().getConfiguration().getLocales().get(0).getCountry();
        if (!bool.booleanValue()) {
            String v = NetConfig.f6666a.v("sXrMenu");
            PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
            return v + "/guide/novice?brand=" + phoneTypeUtils.b() + "&model=" + phoneTypeUtils.a() + "&xrType=star air&os=Android&lang=" + language + AccountConstantKt.DEFAULT_SEGMENT + country + "&appearance=" + c() + "&ringVerStatus=" + i;
        }
        String o = NetConfig.f6666a.o();
        PhoneTypeUtils phoneTypeUtils2 = PhoneTypeUtils.f7912a;
        return o + "/#/guide/novice?brand=" + phoneTypeUtils2.b() + "&model=" + phoneTypeUtils2.a() + "&xrModels=XGA010C&os=Android";
    }

    public final String c() {
        return (String) b.getValue();
    }

    public final String d(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceType");
        return ConnectExtKt.f(str) ? GlobalExtKt.h(R.string.guide_title_air) : ConnectExtKt.g(str) ? GlobalExtKt.h(R.string.guide_title_pro) : ConnectExtKt.h(str) ? GlobalExtKt.h(R.string.guide_title_ring) : GlobalExtKt.h(R.string.guide_title_air);
    }

    public final String e(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceType");
        return ConnectExtKt.f(str) ? b() : ConnectExtKt.g(str) ? a() : ConnectExtKt.h(str) ? f() : b();
    }

    public final String f() {
        String o = NetConfig.f6666a.o();
        PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
        String b2 = phoneTypeUtils.b();
        String a2 = phoneTypeUtils.a();
        return o + "/#/guide/novice?brand=" + b2 + "&model=" + a2 + "&xrModels=XAR020C&os=Android";
    }
}
