package com.xjmz.myvu.flutter;

import com.upuphone.xr.sapp.entity.AccountInfo;
import com.xjmz.myvu.flutter.pigeon.AndroidAccountApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AccountInfo;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAccountApi$Account;", "a", "(Lcom/upuphone/xr/sapp/entity/AccountInfo;)Lcom/xjmz/myvu/flutter/pigeon/AndroidAccountApi$Account;", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class AccountInfoExtKt {
    public static final AndroidAccountApi.Account a(AccountInfo accountInfo) {
        Intrinsics.checkNotNullParameter(accountInfo, "<this>");
        AndroidAccountApi.Account.Builder c = new AndroidAccountApi.Account.Builder().g(accountInfo.getNickname()).c(accountInfo.getId());
        String mzUid = accountInfo.getMzUid();
        String str = "";
        if (mzUid == null) {
            mzUid = str;
        }
        AndroidAccountApi.Account.Builder f = c.e(mzUid).b(accountInfo.getIcon()).f(accountInfo.getPhone());
        String mzToken = accountInfo.getMzToken();
        if (mzToken != null) {
            str = mzToken;
        }
        AndroidAccountApi.Account a2 = f.d(str).a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        return a2;
    }
}
