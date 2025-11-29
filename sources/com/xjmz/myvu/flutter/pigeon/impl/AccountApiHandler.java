package com.xjmz.myvu.flutter.pigeon.impl;

import androidx.fragment.app.Fragment;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.entity.AccountInfo;
import com.xjmz.myvu.flutter.AccountInfoExtKt;
import com.xjmz.myvu.flutter.pigeon.AndroidAccountApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/AccountApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAccountApi$AccountApi;", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAccountApi$NullableResult;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAccountApi$Account;", "result", "", "a", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidAccountApi$NullableResult;)V", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "b", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AccountApiHandler implements AndroidAccountApi.AccountApi {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Fragment f8338a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/AccountApiHandler$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public AccountApiHandler(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.f8338a = fragment;
    }

    public void a(AndroidAccountApi.NullableResult nullableResult) {
        Intrinsics.checkNotNullParameter(nullableResult, "result");
        AccountInfo a2 = MzAccountManager.c.a();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("AccountApiHandler", "getAccountInfo() called: " + a2);
        if (a2 == null) {
            nullableResult.success((Object) null);
        } else {
            nullableResult.success(AccountInfoExtKt.a(a2));
        }
    }
}
