package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.common.IAccountCallback;
import com.upuphone.xr.interconnect.common.ITokenCallback;

public interface AccountAbilityOperator {
    void exitApp();

    void getAccount(String str, IAccountCallback iAccountCallback);

    void getToken(boolean z, boolean z2, ITokenCallback iTokenCallback);
}
