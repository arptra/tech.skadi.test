package com.honey.account.view.home;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationUtil;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/honey/account/view/home/AccountHomepageActivity$onActivityResult$1", "Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationUtil$FactorValidateListener;", "failure", "", "code", "", "validateSuccess", "validateCode", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccountHomepageActivity$onActivityResult$1 implements FactorAuthenticationUtil.FactorValidateListener {
    final /* synthetic */ AccountHomepageActivity this$0;

    public AccountHomepageActivity$onActivityResult$1(AccountHomepageActivity accountHomepageActivity) {
        this.this$0 = accountHomepageActivity;
    }

    public void failure(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "code");
        Log.w("AccountHomepageActivity", "logout fail. code: " + str);
    }

    public void validateSuccess(@Nullable String str) {
        Log.i("AccountHomepageActivity", "logout success. code: " + str);
        if (str != null) {
            this.this$0.getViewModel().logout(str);
        }
    }
}
