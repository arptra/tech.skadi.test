package com.xjmz.myvu.account;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "success", "", "code", "", "message", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AccountManager$checkHasSetPassword$1 extends Lambda implements Function3<Boolean, Integer, String, Unit> {
    public static final AccountManager$checkHasSetPassword$1 INSTANCE = new AccountManager$checkHasSetPassword$1();

    public AccountManager$checkHasSetPassword$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue(), (String) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        DataStoreUtils.e.a().o("has_set_password", Boolean.valueOf(z));
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("AccountManager", "checkHadSetPassword-> 检测是否设置过密码 success：" + z);
    }
}
