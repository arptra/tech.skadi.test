package com.honey.account.controller;

import android.content.Context;
import com.honey.account.AccountHelper;
import com.honey.account.bridge.LoginBridgeKt;
import com.honey.account.data.RememberMeToVerificationCodeData;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/honey/account/data/RememberMeToVerificationCodeData;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class LoginController$getRememberMeToVerificationCode$2 extends Lambda implements Function0<RememberMeToVerificationCodeData> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $phone;
    final /* synthetic */ String $verificationCode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginController$getRememberMeToVerificationCode$2(Context context, String str, String str2) {
        super(0);
        this.$context = context;
        this.$phone = str;
        this.$verificationCode = str2;
    }

    @NotNull
    public final RememberMeToVerificationCodeData invoke() {
        String rememberMe;
        RememberMeToVerificationCodeData networkRequestRememberMeToVerificationCode = LoginBridgeKt.networkRequestRememberMeToVerificationCode(this.$context, this.$phone, this.$verificationCode, AccountHelper.INSTANCE.getMBelong(), Locale.getDefault().getLanguage() + '_' + Locale.getDefault().getCountry());
        if (!(networkRequestRememberMeToVerificationCode.getCode() != 200 || (rememberMe = networkRequestRememberMeToVerificationCode.getRememberMe()) == null || rememberMe.length() == 0)) {
            LoginController loginController = LoginController.INSTANCE;
            Context context = this.$context;
            String rememberMe2 = networkRequestRememberMeToVerificationCode.getRememberMe();
            Intrinsics.checkNotNull(rememberMe2);
            loginController.setRememberMe(context, rememberMe2);
        }
        return networkRequestRememberMeToVerificationCode;
    }
}
