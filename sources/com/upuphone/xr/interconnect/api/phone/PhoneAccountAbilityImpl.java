package com.upuphone.xr.interconnect.api.phone;

import com.upuphone.xr.interconnect.common.IAccountCallback;
import com.upuphone.xr.interconnect.common.ITokenCallback;
import com.upuphone.xr.interconnect.remote.BinderClient;

public class PhoneAccountAbilityImpl implements PhoneAccountAbility {
    IAccountAbilityResponse accountAbilityResponse;

    public interface IAccountAbilityResponse {
        void exitApp();

        void getAccount(String str, IAccountCallback iAccountCallback);

        void getToken(boolean z, boolean z2, ITokenCallback iTokenCallback);
    }

    public void exitApp() {
        IAccountAbilityResponse iAccountAbilityResponse = this.accountAbilityResponse;
        if (iAccountAbilityResponse != null) {
            iAccountAbilityResponse.exitApp();
        }
    }

    public void getAccount(String str, IAccountCallback iAccountCallback) {
        IAccountAbilityResponse iAccountAbilityResponse = this.accountAbilityResponse;
        if (iAccountAbilityResponse != null) {
            iAccountAbilityResponse.getAccount(str, iAccountCallback);
        }
    }

    public void getToken(boolean z, boolean z2, ITokenCallback iTokenCallback) {
        IAccountAbilityResponse iAccountAbilityResponse = this.accountAbilityResponse;
        if (iAccountAbilityResponse != null) {
            iAccountAbilityResponse.getToken(z, z2, iTokenCallback);
        }
    }

    public void onClientDied(BinderClient binderClient) {
        if (binderClient.getPackageName().equals("com.upuphone.star.launcher")) {
            this.accountAbilityResponse = null;
        }
    }

    public void registerAccountResponse(IAccountAbilityResponse iAccountAbilityResponse) {
        this.accountAbilityResponse = iAccountAbilityResponse;
    }

    public void removeAccountResponse() {
        this.accountAbilityResponse = null;
    }
}
