package com.upuphone.xr.sapp.debug;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/debug/DebugConfigUtil;", "", "<init>", "()V", "Landroid/app/Application;", "context", "", "a", "(Landroid/app/Application;)V", "b", "Landroid/app/Application;", "mContext", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DebugConfigUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final DebugConfigUtil f6929a = new DebugConfigUtil();
    public static Application b;

    public final void a(Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        b = application;
    }
}
