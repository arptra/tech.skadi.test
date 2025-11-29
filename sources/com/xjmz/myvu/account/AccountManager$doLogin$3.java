package com.xjmz.myvu.account;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AccountManager$doLogin$3 extends Lambda implements Function0<Unit> {
    public static final AccountManager$doLogin$3 INSTANCE = new AccountManager$doLogin$3();

    public AccountManager$doLogin$3() {
        super(0);
    }

    public final void invoke() {
        ULog.f6446a.g("AccountManager", "doLogin-> intent为空, 不能跳转");
    }
}
