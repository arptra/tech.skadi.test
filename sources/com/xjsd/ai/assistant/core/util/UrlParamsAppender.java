package com.xjsd.ai.assistant.core.util;

import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;

public class UrlParamsAppender {
    public static String a() {
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility == null) {
            return null;
        }
        Boolean bool = Boolean.FALSE;
        boolean booleanValue = ((Boolean) cacheAbility.getCacheWithDefault("phoneIsOtaFeature", bool)).booleanValue();
        String str = (String) cacheAbility.getCacheWithDefault("phoneAssistantVersion", "1.0.0");
        String str2 = (String) cacheAbility.getCacheWithDefault("glassType", "1001");
        boolean booleanValue2 = ((Boolean) cacheAbility.getCacheWithDefault("cloudOptimized", bool)).booleanValue();
        String str3 = (String) cacheAbility.getCacheWithDefault("glassAssistantVersion", "1.0.0");
        boolean booleanValue3 = ((Boolean) cacheAbility.getCacheWithDefault("glassIsOtaFeature", bool)).booleanValue();
        StringBuilder sb = new StringBuilder();
        sb.append("PHONE-FEATURE-ID=");
        String str4 = "BASE";
        sb.append(booleanValue ? "OTA" : str4);
        sb.append("&PHONE-VOICE-VERSION=");
        sb.append(str);
        sb.append("&GLASS-PRODUCT=");
        sb.append(str2);
        sb.append("&GLASS-FEATURE-ID=");
        if (booleanValue3) {
            str4 = "OTA";
        }
        sb.append(str4);
        sb.append("&GLASS-VOICE-VERSION=");
        sb.append(str3);
        if (booleanValue2) {
            sb.append("&CLOUD-OPTIMIZATION");
        }
        return sb.toString();
    }
}
