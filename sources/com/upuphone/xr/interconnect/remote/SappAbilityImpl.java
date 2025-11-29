package com.upuphone.xr.interconnect.remote;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.PhoneSappAbility;
import com.upuphone.xr.interconnect.api.SappAbilityAction;
import com.upuphone.xr.interconnect.api.SappAbilityType;
import com.upuphone.xr.interconnect.common.IAIModelResult;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import com.upuphone.xr.interconnect.common.ISappAbility;
import com.upuphone.xr.interconnect.ipc.IpcClientManager;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class SappAbilityImpl extends ISappAbility.Stub {
    private final PhoneSappAbility sappAbility;

    public SappAbilityImpl() {
        PhoneSappAbility phoneSappAbility = InterconnectManager.getInstance().getPhoneSappAbility();
        this.sappAbility = phoneSappAbility;
        IpcClientManager.INSTANCE.addListener(phoneSappAbility);
    }

    public boolean callAbility(@SappAbilityType String str, @SappAbilityAction String str2) throws RemoteException {
        return this.sappAbility.callAbility(str, str2);
    }

    public void requestAIState(IAIModelResult iAIModelResult) throws RemoteException {
        this.sappAbility.requestAIState(iAIModelResult);
    }

    public void requestPermission(@NotNull List<String> list, IPermissonResult iPermissonResult) throws RemoteException {
        this.sappAbility.requestPermission(list, iPermissonResult);
    }

    public void submitAIState(String str, IAIModelResult iAIModelResult) throws RemoteException {
        this.sappAbility.submitAIState(str, iAIModelResult);
    }
}
