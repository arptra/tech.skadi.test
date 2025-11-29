package com.honey.account.controller;

import android.content.Context;
import com.honey.account.AccountHelper;
import com.honey.account.OnLogoutListener;
import com.honey.account.utils.sharedpreferences.SharedPreferencesUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/honey/account/controller/LogoutController;", "", "()V", "logout", "", "context", "Landroid/content/Context;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LogoutController {
    @NotNull
    public static final LogoutController INSTANCE = new LogoutController();

    private LogoutController() {
    }

    public final void logout(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferencesUtilsKt.clearAll(context);
        OnLogoutListener mOnLogoutListener = AccountHelper.INSTANCE.getMOnLogoutListener();
        if (mOnLogoutListener != null) {
            mOnLogoutListener.onLogout();
        }
    }
}
