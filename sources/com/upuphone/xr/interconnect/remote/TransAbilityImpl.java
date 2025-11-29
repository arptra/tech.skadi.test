package com.upuphone.xr.interconnect.remote;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.PhoneTransAbility;
import com.upuphone.xr.interconnect.common.ITransAbility;
import com.upuphone.xr.interconnect.ipc.IpcClientManager;

public class TransAbilityImpl extends ITransAbility.Stub {
    private final PhoneTransAbility mPhoneTransAbility;

    public TransAbilityImpl() {
        PhoneTransAbility phoneTransAbility = InterconnectManager.getInstance().getPhoneTransAbility();
        this.mPhoneTransAbility = phoneTransAbility;
        IpcClientManager.INSTANCE.addListener(phoneTransAbility);
    }

    public int getTransCurrentState() throws RemoteException {
        return this.mPhoneTransAbility.getTransCurrentState();
    }

    public boolean isSupportLanguage(boolean z, int i, String str, String str2) throws RemoteException {
        return this.mPhoneTransAbility.isSupportLanguage(z, i, str, str2);
    }

    public boolean isTransStarted() throws RemoteException {
        return this.mPhoneTransAbility.isTransStarted();
    }

    public int startTranslation(int i) throws RemoteException {
        return this.mPhoneTransAbility.startTranslation(i);
    }

    public int stopTranslation(int i) throws RemoteException {
        return this.mPhoneTransAbility.stopTranslation(i);
    }

    public int switchLang(String str, String str2) throws RemoteException {
        return this.mPhoneTransAbility.switchLang(str, str2);
    }

    public int switchLanguage(boolean z, int i, String str, String str2) throws RemoteException {
        return this.mPhoneTransAbility.switchLang(z, i, str, str2);
    }
}
