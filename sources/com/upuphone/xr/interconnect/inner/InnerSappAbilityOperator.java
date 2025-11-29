package com.upuphone.xr.interconnect.inner;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.SappAbilityAction;
import com.upuphone.xr.interconnect.api.SappAbilityOperator;
import com.upuphone.xr.interconnect.api.SappAbilityType;
import com.upuphone.xr.interconnect.common.IAIModelResult;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class InnerSappAbilityOperator implements SappAbilityOperator {
    public boolean callAbility(@SappAbilityType String str, @SappAbilityAction String str2) {
        return InterconnectManager.getInstance().getPhoneSappAbility().callAbility(str, str2);
    }

    public void requestAIState(IAIModelResult iAIModelResult) {
        InterconnectManager.getInstance().getPhoneSappAbility().requestAIState(iAIModelResult);
    }

    public void requestPermission(@NotNull List<String> list, IPermissonResult iPermissonResult) {
        InterconnectManager.getInstance().getPhoneSappAbility().requestPermission(list, iPermissonResult);
    }

    public void submitAIState(String str, IAIModelResult iAIModelResult) {
        InterconnectManager.getInstance().getPhoneSappAbility().submitAIState(str, iAIModelResult);
    }
}
