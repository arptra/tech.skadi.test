package com.upuphone.xr.interconnect.outer;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.api.TransAbilityOperator;
import com.upuphone.xr.interconnect.common.ITransAbility;

public class TransAbilityOperatorImpl implements TransAbilityOperator, SuperServiceStateListener {
    private static final int START_TRANS_ERROR = -1;
    private SuperServiceProvider mProvider;

    public int getTransCurrentState() {
        ITransAbility transAbility = this.mProvider.getTransAbility();
        if (transAbility == null) {
            return 0;
        }
        try {
            return transAbility.getTransCurrentState();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean isSupportLanguage(boolean z, int i, String str, String str2) {
        ITransAbility transAbility = this.mProvider.getTransAbility();
        if (transAbility == null) {
            return false;
        }
        try {
            return transAbility.isSupportLanguage(z, i, str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isTransStarted() {
        ITransAbility transAbility = this.mProvider.getTransAbility();
        if (transAbility == null) {
            return false;
        }
        try {
            return transAbility.isTransStarted();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onServiceConnected() {
    }

    public void onServiceDied() {
    }

    public void setProvider(SuperServiceProvider superServiceProvider) {
        this.mProvider = superServiceProvider;
    }

    public int startTranslation(int i) {
        ITransAbility transAbility = this.mProvider.getTransAbility();
        if (transAbility == null) {
            return -1;
        }
        try {
            return transAbility.startTranslation(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int stopTranslation(int i) {
        ITransAbility transAbility = this.mProvider.getTransAbility();
        if (transAbility == null) {
            return 0;
        }
        try {
            return transAbility.stopTranslation(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Deprecated
    public int switchLang(String str, String str2) {
        ITransAbility transAbility = this.mProvider.getTransAbility();
        if (transAbility == null) {
            return -1;
        }
        try {
            return transAbility.switchLang(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int switchLang(boolean z, int i, String str, String str2) {
        ITransAbility transAbility = this.mProvider.getTransAbility();
        if (transAbility == null) {
            return -1;
        }
        try {
            return transAbility.switchLanguage(z, i, str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
