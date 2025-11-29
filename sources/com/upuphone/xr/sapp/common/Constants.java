package com.upuphone.xr.sapp.common;

import com.upuphone.starrynet.api.StConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u001b\u0010\u000e\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/common/Constants;", "", "<init>", "()V", "", "", "b", "[Ljava/lang/String;", "()[Ljava/lang/String;", "SEND_FILE_PKGS", "c", "Lkotlin/Lazy;", "a", "()Ljava/lang/String;", "HTTP_HEAD", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class Constants {

    /* renamed from: a  reason: collision with root package name */
    public static final Constants f6657a = new Constants();
    public static final String[] b = {StConstant.PACKAGE_NAME_RUN_AS_ONE, "com.upuphone.starrynet"};
    public static final Lazy c = LazyKt.lazy(Constants$HTTP_HEAD$2.INSTANCE);

    public final String a() {
        return (String) c.getValue();
    }

    public final String[] b() {
        return b;
    }
}
