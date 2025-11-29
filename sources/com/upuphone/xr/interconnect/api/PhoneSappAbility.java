package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.api.PhoneSappAbilityImpl;
import com.upuphone.xr.interconnect.common.IAIModelResult;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import com.upuphone.xr.interconnect.remote.BinderClientDiedCallback;
import java.util.List;

public interface PhoneSappAbility extends BinderClientDiedCallback {
    void addAbilityClient(PhoneSappAbilityImpl.IAbilityClientResponse iAbilityClientResponse);

    boolean callAbility(@SappAbilityType String str, @SappAbilityAction String str2);

    void removeAbilityClient();

    void requestAIState(IAIModelResult iAIModelResult);

    void requestPermission(List<String> list, IPermissonResult iPermissonResult);

    void submitAIState(@AIType String str, IAIModelResult iAIModelResult);
}
