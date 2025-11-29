package com.upuphone.xr.interconnect.api;

public interface TransAbilityOperator {
    int getTransCurrentState();

    boolean isSupportLanguage(boolean z, int i, String str, String str2);

    boolean isTransStarted();

    int startTranslation(int i);

    int stopTranslation(int i);

    @Deprecated
    int switchLang(String str, String str2);

    int switchLang(boolean z, int i, String str, String str2);
}
