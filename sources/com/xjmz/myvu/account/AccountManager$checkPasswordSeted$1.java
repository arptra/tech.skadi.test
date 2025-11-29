package com.xjmz.myvu.account;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.account.interfaces.XJPasswordListener;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0017\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/xjmz/myvu/account/AccountManager$checkPasswordSeted$1", "Lcom/upuphone/xr/account/interfaces/XJPasswordListener;", "onError", "", "code", "", "msg", "", "onSuccess", "set", "", "(Ljava/lang/Boolean;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccountManager$checkPasswordSeted$1 implements XJPasswordListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8218a;
    public final /* synthetic */ Function1 b;

    public AccountManager$checkPasswordSeted$1(Context context, Function1 function1) {
        this.f8218a = context;
        this.b = function1;
    }

    public void onError(int i, String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("AccountManager", "checkPasswordSeted : error code = " + i + ",error msg = " + str);
        Function1 function1 = this.b;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    public void onSuccess(Boolean bool) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("AccountManager", "checkPasswordSeted : set = " + bool);
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.FALSE)) {
            AccountManager.f8217a.B(this.f8218a);
        }
        if (bool != null) {
            Function1 function1 = this.b;
            if (function1 != null) {
                function1.invoke(bool);
            }
            DataStoreUtils.e.a().o("has_set_password", bool);
        }
    }
}
