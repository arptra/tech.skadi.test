package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.xjmz.myvu.flutter.pigeon.AndroidAppUpdateApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/AndroidAppUpdateApiImpl;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppUpdateApi$AppUpdateApi;", "<init>", "()V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppUpdateApi$Result;", "", "result", "", "a", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidAppUpdateApi$Result;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AndroidAppUpdateApiImpl implements AndroidAppUpdateApi.AppUpdateApi {

    /* renamed from: a  reason: collision with root package name */
    public static final AndroidAppUpdateApiImpl f8341a = new AndroidAppUpdateApiImpl();

    public void a(AndroidAppUpdateApi.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        boolean u = AppUpdateHelper.f7841a.u();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AndroidAppUpdateApiImpl", "checkIfShowForceUpdateDialog: " + u);
        result.success(Boolean.valueOf(u));
    }
}
