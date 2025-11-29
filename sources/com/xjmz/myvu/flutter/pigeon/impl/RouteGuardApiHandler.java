package com.xjmz.myvu.flutter.pigeon.impl;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.star.core.log.ULog;
import com.xjmz.myvu.account.AccountManager;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/RouteGuardApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$RouteGuardApi;", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "", "router", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$Result;", "", "result", "", "b", "(Ljava/lang/String;Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$Result;)V", "a", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RouteGuardApiHandler implements AndroidAppApi.RouteGuardApi {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Fragment f8353a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/RouteGuardApiHandler$Companion;", "", "()V", "BINDING_DEVICE", "", "PERSON_CENTER", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public RouteGuardApiHandler(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.f8353a = fragment;
    }

    public void b(String str, AndroidAppApi.Result result) {
        Intrinsics.checkNotNullParameter(str, "router");
        Intrinsics.checkNotNullParameter(result, "result");
        AccountManager accountManager = AccountManager.f8217a;
        boolean t = accountManager.t();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("RouteGuardApiHandler", "flutterPagePush router:" + str + " needSetPassword:" + t);
        if (!Intrinsics.areEqual((Object) str, (Object) "/binding_device") || !t) {
            result.success(Boolean.TRUE);
            return;
        }
        result.success(Boolean.FALSE);
        FragmentActivity requireActivity = this.f8353a.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        accountManager.y(requireActivity);
    }
}
