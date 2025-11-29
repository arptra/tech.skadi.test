package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.star.core.log.ULog;
import com.xjmz.myvu.flutter.pigeon.AndroidNavigatorRouteApi;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/NavigatorRouteApiImpl;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidNavigatorRouteApi$NavigatorRouteApi;", "<init>", "()V", "", "canPop", "", "f", "(Z)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NavigatorRouteApiImpl implements AndroidNavigatorRouteApi.NavigatorRouteApi {

    /* renamed from: a  reason: collision with root package name */
    public static final NavigatorRouteApiImpl f8350a = new NavigatorRouteApiImpl();

    public /* bridge */ /* synthetic */ void a(Boolean bool) {
        f(bool.booleanValue());
    }

    public void f(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("NavigatorRouteApiImpl", "notifyCanPop, canPop: " + z);
    }
}
