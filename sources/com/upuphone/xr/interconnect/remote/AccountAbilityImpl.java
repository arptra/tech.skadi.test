package com.upuphone.xr.interconnect.remote;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.phone.PhoneAccountAbility;
import com.upuphone.xr.interconnect.common.IAccountAbility;
import com.upuphone.xr.interconnect.common.IAccountCallback;
import com.upuphone.xr.interconnect.common.ITokenCallback;
import com.upuphone.xr.interconnect.ipc.IpcClientManager;

public class AccountAbilityImpl extends IAccountAbility.Stub {
    private final PhoneAccountAbility accountAbility;

    public AccountAbilityImpl() {
        PhoneAccountAbility phoneAccountAbility = InterconnectManager.getInstance().getPhoneAccountAbility();
        this.accountAbility = phoneAccountAbility;
        IpcClientManager.INSTANCE.addListener(phoneAccountAbility);
    }

    public void exitApp() throws RemoteException {
        this.accountAbility.exitApp();
    }

    public void getAccount(String str, IAccountCallback iAccountCallback) throws RemoteException {
        this.accountAbility.getAccount(str, iAccountCallback);
    }

    public void getToken(boolean z, boolean z2, ITokenCallback iTokenCallback) throws RemoteException {
        this.accountAbility.getToken(z, z2, iTokenCallback);
    }
}
