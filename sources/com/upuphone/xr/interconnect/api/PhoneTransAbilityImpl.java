package com.upuphone.xr.interconnect.api;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.remote.BinderClient;

public class PhoneTransAbilityImpl implements PhoneTransAbility {
    private static final int START_TRANS_ERROR = -1;
    private static final String TAG = "PhoneTransAbility";
    private ITransAbilityResponse mResponse = null;

    public interface ITransAbilityResponse {
        int getTransCurrentState();

        boolean isSupportLanguage(boolean z, int i, String str, String str2);

        boolean isTransStarted();

        int startTranslation(int i);

        int stopTranslation(int i);

        @Deprecated
        int switchLang(String str, String str2);

        int switchLang(boolean z, int i, String str, String str2);
    }

    public int getTransCurrentState() {
        ULog.i(TAG, "getTransCurrentState");
        ITransAbilityResponse iTransAbilityResponse = this.mResponse;
        if (iTransAbilityResponse != null) {
            return iTransAbilityResponse.getTransCurrentState();
        }
        return 0;
    }

    public boolean isSupportLanguage(boolean z, int i, String str, String str2) {
        ULog.i(TAG, "isSupportLanguage isAir=" + z + " ,transType=" + i + " ,src=" + str + " ,dst=" + str2);
        ITransAbilityResponse iTransAbilityResponse = this.mResponse;
        if (iTransAbilityResponse != null) {
            return iTransAbilityResponse.isSupportLanguage(z, i, str, str2);
        }
        return false;
    }

    public boolean isTransStarted() {
        StringBuilder sb = new StringBuilder();
        sb.append("isTransStarted response=");
        sb.append(this.mResponse != null);
        ULog.i(TAG, sb.toString());
        ITransAbilityResponse iTransAbilityResponse = this.mResponse;
        if (iTransAbilityResponse != null) {
            return iTransAbilityResponse.isTransStarted();
        }
        return false;
    }

    public void onClientDied(BinderClient binderClient) {
        if (binderClient.getPackageName().equals("com.upuphone.star.launcher")) {
            this.mResponse = null;
        }
    }

    public void registerTransResponse(ITransAbilityResponse iTransAbilityResponse) {
        this.mResponse = iTransAbilityResponse;
    }

    public int startTranslation(int i) {
        ULog.i(TAG, "startTranslation transType=" + i);
        ITransAbilityResponse iTransAbilityResponse = this.mResponse;
        if (iTransAbilityResponse != null) {
            return iTransAbilityResponse.startTranslation(i);
        }
        return -1;
    }

    public int stopTranslation(int i) {
        ULog.i(TAG, "stopTranslation transType=" + i);
        ITransAbilityResponse iTransAbilityResponse = this.mResponse;
        if (iTransAbilityResponse != null) {
            return iTransAbilityResponse.stopTranslation(i);
        }
        return 0;
    }

    @Deprecated
    public int switchLang(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("switchLang src=");
        sb.append(str);
        sb.append(" ,dst=");
        sb.append(str2);
        sb.append(" ,response=");
        sb.append(this.mResponse != null);
        ULog.i(TAG, sb.toString());
        ITransAbilityResponse iTransAbilityResponse = this.mResponse;
        if (iTransAbilityResponse != null) {
            return iTransAbilityResponse.switchLang(str, str2);
        }
        return -1;
    }

    public void unRegisterTransResponse() {
        this.mResponse = null;
    }

    public int switchLang(boolean z, int i, String str, String str2) {
        ULog.i(TAG, "switchLang isAir=" + z + " ,transType=" + i + " ,src=" + str + " ,dst=" + str2);
        ITransAbilityResponse iTransAbilityResponse = this.mResponse;
        if (iTransAbilityResponse != null) {
            return iTransAbilityResponse.switchLang(z, i, str, str2);
        }
        return -1;
    }
}
