package com.upuphone.xr.interconnect.inner;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.PhoneTransAbility;
import com.upuphone.xr.interconnect.api.TransAbilityOperator;

public class InnerTransAbilityOperator implements TransAbilityOperator {
    private final PhoneTransAbility mTransAbility = InterconnectManager.getInstance().getPhoneTransAbility();

    public int getTransCurrentState() {
        return this.mTransAbility.getTransCurrentState();
    }

    public boolean isSupportLanguage(boolean z, int i, String str, String str2) {
        return this.mTransAbility.isSupportLanguage(z, i, str, str2);
    }

    public boolean isTransStarted() {
        return this.mTransAbility.isTransStarted();
    }

    public int startTranslation(int i) {
        return this.mTransAbility.startTranslation(i);
    }

    public int stopTranslation(int i) {
        return this.mTransAbility.stopTranslation(i);
    }

    @Deprecated
    public int switchLang(String str, String str2) {
        return this.mTransAbility.switchLang(str, str2);
    }

    public int switchLang(boolean z, int i, String str, String str2) {
        return this.mTransAbility.switchLang(z, i, str, str2);
    }
}
