package com.honey.account.controller;

import android.content.Context;
import com.honey.account.AccountHelper;
import com.honey.account.bridge.LoginBridgeKt;
import com.honey.account.data.AuthTokenData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/honey/account/data/AuthTokenData;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class LoginController$getAuthToken$2 extends Lambda implements Function0<AuthTokenData> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $rememberMe;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginController$getAuthToken$2(Context context, String str) {
        super(0);
        this.$context = context;
        this.$rememberMe = str;
    }

    @NotNull
    public final AuthTokenData invoke() {
        String accessToken;
        AccountHelper accountHelper = AccountHelper.INSTANCE;
        AuthTokenData networkRequestAuthToken = LoginBridgeKt.networkRequestAuthToken(this.$context, "trust", this.$rememberMe, "remember_me", accountHelper.getMClientId(), accountHelper.getMBelong(), accountHelper.getMClientSecret());
        if (!(networkRequestAuthToken.getCode() != 200 || (accessToken = networkRequestAuthToken.getAccessToken()) == null || accessToken.length() == 0)) {
            LoginController loginController = LoginController.INSTANCE;
            Context context = this.$context;
            String accessToken2 = networkRequestAuthToken.getAccessToken();
            Intrinsics.checkNotNull(accessToken2);
            loginController.setAuthToken(context, accessToken2);
        }
        return networkRequestAuthToken;
    }
}
