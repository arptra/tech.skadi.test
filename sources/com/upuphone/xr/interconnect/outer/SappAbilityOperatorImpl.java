package com.upuphone.xr.interconnect.outer;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.api.SappAbilityAction;
import com.upuphone.xr.interconnect.api.SappAbilityOperator;
import com.upuphone.xr.interconnect.api.SappAbilityType;
import com.upuphone.xr.interconnect.common.IAIModelResult;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import com.upuphone.xr.interconnect.common.ISappAbility;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class SappAbilityOperatorImpl implements SappAbilityOperator, SuperServiceStateListener {
    private static final String TAG = "SappAbilityOperatorImpl";
    private SuperServiceProvider mProvider;

    public boolean callAbility(@SappAbilityType String str, @SappAbilityAction String str2) {
        ISappAbility iSappAbility = this.mProvider.getISappAbility();
        if (iSappAbility == null) {
            return false;
        }
        try {
            return iSappAbility.callAbility(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onServiceConnected() {
    }

    public void onServiceDied() {
    }

    public void requestAIState(IAIModelResult iAIModelResult) {
        ISappAbility iSappAbility = this.mProvider.getISappAbility();
        if (iSappAbility != null) {
            try {
                iSappAbility.requestAIState(iAIModelResult);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void requestPermission(@NotNull List<String> list, IPermissonResult iPermissonResult) {
        ISappAbility iSappAbility = this.mProvider.getISappAbility();
        if (iSappAbility != null) {
            try {
                iSappAbility.requestPermission(list, iPermissonResult);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setProvider(SuperServiceProvider superServiceProvider) {
        this.mProvider = superServiceProvider;
    }

    public void submitAIState(String str, IAIModelResult iAIModelResult) {
        ISappAbility iSappAbility = this.mProvider.getISappAbility();
        if (iSappAbility != null) {
            try {
                iSappAbility.submitAIState(str, iAIModelResult);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
