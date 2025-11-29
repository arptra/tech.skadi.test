package com.upuphone.xr.sapp.utils;

import android.app.Activity;
import com.honey.account.HoneyAccountManager;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u0003J1\u0010\u0011\u001a\u00020\u00062\"\b\u0002\u0010\u0010\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/utils/AccountExt;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "", "c", "(Landroid/app/Activity;)V", "", "b", "()Z", "a", "Lkotlin/Function3;", "", "", "callback", "d", "(Lkotlin/jvm/functions/Function3;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AccountExt {

    /* renamed from: a  reason: collision with root package name */
    public static final AccountExt f7838a = new AccountExt();

    public final void a() {
        ULog.f6446a.a("AccountExt", "over sea no buidPolicyType");
    }

    public final boolean b() {
        return true;
    }

    public final void c(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ULog.f6446a.a("AccountExt", "over sea no real name");
    }

    public final void d(Function3 function3) {
        HoneyAccountManager.Companion.isSelfModifyPassword(new AccountExt$isSelfModifyPassword$1(function3));
    }
}
