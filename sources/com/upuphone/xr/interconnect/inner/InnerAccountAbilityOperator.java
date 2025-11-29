package com.upuphone.xr.interconnect.inner;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.AccountAbilityOperator;
import com.upuphone.xr.interconnect.api.phone.PhoneAccountAbility;
import com.upuphone.xr.interconnect.common.IAccountCallback;
import com.upuphone.xr.interconnect.common.ITokenCallback;

public class InnerAccountAbilityOperator implements AccountAbilityOperator {
    private PhoneAccountAbility accountAbility = InterconnectManager.getInstance().getPhoneAccountAbility();

    public void exitApp() {
        this.accountAbility.exitApp();
    }

    public void getAccount(String str, IAccountCallback iAccountCallback) {
        this.accountAbility.getAccount(str, iAccountCallback);
    }

    public void getToken(boolean z, boolean z2, ITokenCallback iTokenCallback) {
        this.accountAbility.getToken(z, z2, iTokenCallback);
    }
}
