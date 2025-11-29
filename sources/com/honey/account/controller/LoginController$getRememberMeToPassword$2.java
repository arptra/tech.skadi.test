package com.honey.account.controller;

import android.content.Context;
import com.honey.account.AccountHelper;
import com.honey.account.bridge.LoginBridgeKt;
import com.honey.account.data.RememberMeToPasswordData;
import com.honey.account.utils.system.PackageUtilsKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/honey/account/data/RememberMeToPasswordData;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class LoginController$getRememberMeToPassword$2 extends Lambda implements Function0<RememberMeToPasswordData> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $password;
    final /* synthetic */ String $phone;
    final /* synthetic */ String $vCode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginController$getRememberMeToPassword$2(Context context, String str, String str2, String str3) {
        super(0);
        this.$context = context;
        this.$phone = str;
        this.$password = str2;
        this.$vCode = str3;
    }

    @NotNull
    public final RememberMeToPasswordData invoke() {
        String rememberMe;
        AccountHelper accountHelper = AccountHelper.INSTANCE;
        RememberMeToPasswordData networkRequestRememberMeToPassword = LoginBridgeKt.networkRequestRememberMeToPassword(this.$context, this.$phone, this.$password, "other_device_auth", PackageUtilsKt.getAppVersionName(this.$context), accountHelper.getMBelong(), Locale.getDefault().getLanguage() + '_' + Locale.getDefault().getCountry(), accountHelper.getMAppId(), accountHelper.getMSecret(), this.$vCode);
        if (!(networkRequestRememberMeToPassword.getCode() != 200 || (rememberMe = networkRequestRememberMeToPassword.getRememberMe()) == null || rememberMe.length() == 0)) {
            LoginController loginController = LoginController.INSTANCE;
            Context context = this.$context;
            String rememberMe2 = networkRequestRememberMeToPassword.getRememberMe();
            Intrinsics.checkNotNull(rememberMe2);
            loginController.setRememberMe(context, rememberMe2);
        }
        return networkRequestRememberMeToPassword;
    }
}
