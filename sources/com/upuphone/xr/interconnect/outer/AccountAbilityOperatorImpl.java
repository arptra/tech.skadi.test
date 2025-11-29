package com.upuphone.xr.interconnect.outer;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.api.AccountAbilityOperator;
import com.upuphone.xr.interconnect.common.IAccountAbility;
import com.upuphone.xr.interconnect.common.IAccountCallback;
import com.upuphone.xr.interconnect.common.ITokenCallback;

public class AccountAbilityOperatorImpl implements AccountAbilityOperator, SuperServiceStateListener {
    private static final String TAG = "AccountAbilityOperatorImpl";
    private SuperServiceProvider mProvider;

    public void exitApp() {
        IAccountAbility iAccountAbility = this.mProvider.getIAccountAbility();
        if (iAccountAbility != null) {
            try {
                iAccountAbility.exitApp();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void getAccount(String str, IAccountCallback iAccountCallback) {
        IAccountAbility iAccountAbility = this.mProvider.getIAccountAbility();
        if (iAccountAbility != null) {
            try {
                iAccountAbility.getAccount(str, iAccountCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void getToken(boolean z, boolean z2, ITokenCallback iTokenCallback) {
        IAccountAbility iAccountAbility = this.mProvider.getIAccountAbility();
        if (iAccountAbility != null) {
            try {
                iAccountAbility.getToken(z, z2, iTokenCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void onServiceConnected() {
    }

    public void onServiceDied() {
    }

    public void setProvider(SuperServiceProvider superServiceProvider) {
        this.mProvider = superServiceProvider;
    }
}
