package com.upuphone.xr.interconnect.api.phone;

import com.upuphone.xr.interconnect.api.phone.PhoneAccountAbilityImpl;
import com.upuphone.xr.interconnect.common.IAccountCallback;
import com.upuphone.xr.interconnect.common.ITokenCallback;
import com.upuphone.xr.interconnect.remote.BinderClientDiedCallback;

public interface PhoneAccountAbility extends BinderClientDiedCallback {
    void exitApp();

    void getAccount(String str, IAccountCallback iAccountCallback);

    void getToken(boolean z, boolean z2, ITokenCallback iTokenCallback);

    void registerAccountResponse(PhoneAccountAbilityImpl.IAccountAbilityResponse iAccountAbilityResponse);

    void removeAccountResponse();
}
