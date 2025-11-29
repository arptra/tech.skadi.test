package com.upuphone.ar.tici.phone.utils;

import android.content.Context;
import com.upuphone.xr.sapp.context.SdkContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/TiciDataTrack;", "", "<init>", "()V", "", "eventName", "", "attr", "", "c", "(Ljava/lang/String;Ljava/util/Map;)V", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)I", "b", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciDataTrack {

    /* renamed from: a  reason: collision with root package name */
    public static final TiciDataTrack f6001a = new TiciDataTrack();

    public final int a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SpUtilKt.j();
    }

    public final int b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SpUtilKt.g() ? 1 : 0;
    }

    public final void c(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "attr");
        SdkContext.f6675a.d().a(str, map);
    }
}
