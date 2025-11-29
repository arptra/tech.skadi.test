package com.upuphone.xr.interconnect.api;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.common.IAIModelResult;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import com.upuphone.xr.interconnect.remote.BinderClient;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class PhoneSappAbilityImpl implements PhoneSappAbility {
    private static final String TAG = "PhoneSappAbilityImpl";
    private IAbilityClientResponse mResponse;

    public interface IAbilityClientResponse {
        boolean doAbilityResponse(@SappAbilityType String str, @SappAbilityAction String str2);

        void requestAIState(IAIModelResult iAIModelResult);

        void requestPermission(List<String> list, IPermissonResult iPermissonResult);

        void submitAIState(@AIType String str, IAIModelResult iAIModelResult);
    }

    public void addAbilityClient(IAbilityClientResponse iAbilityClientResponse) {
        this.mResponse = iAbilityClientResponse;
    }

    public boolean callAbility(@SappAbilityType String str, @SappAbilityAction String str2) {
        ULog.d(TAG, "do callAbility type is: " + str + " and action is: " + str2);
        if (this.mResponse != null) {
            ULog.d(TAG, "do callAbility");
            return this.mResponse.doAbilityResponse(str, str2);
        }
        ULog.d(TAG, "do callAbility error");
        return false;
    }

    public void onClientDied(BinderClient binderClient) {
        if (binderClient.getPackageName().equals("com.upuphone.star.launcher")) {
            this.mResponse = null;
        }
    }

    public void removeAbilityClient() {
        this.mResponse = null;
    }

    public void requestAIState(IAIModelResult iAIModelResult) {
        ULog.d(TAG, "do requestAIState");
        if (this.mResponse != null) {
            ULog.d(TAG, "do requestAIState in");
            this.mResponse.requestAIState(iAIModelResult);
            return;
        }
        ULog.d(TAG, "do requestAIState error");
    }

    public void requestPermission(@NotNull List<String> list, IPermissonResult iPermissonResult) {
        ULog.d(TAG, "do requestPermission permissionList is: " + list);
        if (this.mResponse != null) {
            ULog.d(TAG, "do requestPermission");
            this.mResponse.requestPermission(list, iPermissonResult);
            return;
        }
        ULog.d(TAG, "do requestPermission error");
    }

    public void submitAIState(String str, IAIModelResult iAIModelResult) {
        ULog.d(TAG, "do submitAIState state is: " + str);
        if (this.mResponse != null) {
            ULog.d(TAG, "do submitAIState");
            this.mResponse.submitAIState(str, iAIModelResult);
            return;
        }
        ULog.d(TAG, "do submitAIState error");
    }
}
