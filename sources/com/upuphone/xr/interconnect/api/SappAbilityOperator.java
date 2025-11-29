package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.common.IAIModelResult;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface SappAbilityOperator {
    boolean callAbility(@SappAbilityType String str, @SappAbilityAction String str2);

    void requestAIState(IAIModelResult iAIModelResult);

    void requestPermission(@NotNull List<String> list, IPermissonResult iPermissonResult);

    void submitAIState(@AIType String str, IAIModelResult iAIModelResult);
}
