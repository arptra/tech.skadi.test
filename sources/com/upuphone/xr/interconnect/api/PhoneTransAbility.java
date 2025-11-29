package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.api.PhoneTransAbilityImpl;
import com.upuphone.xr.interconnect.remote.BinderClientDiedCallback;

public interface PhoneTransAbility extends BinderClientDiedCallback {
    int getTransCurrentState();

    boolean isSupportLanguage(boolean z, int i, String str, String str2);

    boolean isTransStarted();

    void registerTransResponse(PhoneTransAbilityImpl.ITransAbilityResponse iTransAbilityResponse);

    int startTranslation(int i);

    int stopTranslation(int i);

    @Deprecated
    int switchLang(String str, String str2);

    int switchLang(boolean z, int i, String str, String str2);

    void unRegisterTransResponse();
}
