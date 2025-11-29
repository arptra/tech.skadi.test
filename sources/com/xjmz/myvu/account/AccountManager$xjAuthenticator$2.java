package com.xjmz.myvu.account;

import android.os.Process;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.account.XJAuthenticator;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.utils.AccountExt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/account/XJAuthenticator;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AccountManager$xjAuthenticator$2 extends Lambda implements Function0<XJAuthenticator> {
    public static final AccountManager$xjAuthenticator$2 INSTANCE = new AccountManager$xjAuthenticator$2();

    public AccountManager$xjAuthenticator$2() {
        super(0);
    }

    @NotNull
    public final XJAuthenticator invoke() {
        MainApplication.Companion companion = MainApplication.k;
        if (!companion.j()) {
            ULog.f6446a.c("AccountManager", "没有同意用户协议初始化账号, 直接退出");
            companion.f().p();
            Process.killProcess(Process.myPid());
        }
        MainApplication f = companion.f();
        NetConfig.Companion companion2 = NetConfig.f6666a;
        XJAuthenticator xJAuthenticator = new XJAuthenticator(f, companion2.p(), companion2.f(), companion2.g(), companion2.d(), companion2.e(), companion2.h());
        ULog.f6446a.g("AccountManager", "xjAuthenticator-> init");
        xJAuthenticator.showWxLogin(Boolean.FALSE);
        try {
            AccountExt.f7838a.a();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("AccountManager", "buidPolicyType error: e: " + message);
        }
        return xJAuthenticator;
    }
}
