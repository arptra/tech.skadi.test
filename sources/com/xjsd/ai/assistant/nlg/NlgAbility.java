package com.xjsd.ai.assistant.nlg;

import com.xjsd.ai.assistant.annotation.AbilityKey;
import com.xjsd.ai.assistant.core.Ability;
import java.util.Map;

@AbilityKey("nlg")
public interface NlgAbility extends Ability {
    NlgTts getTts(String str, String str2, Map<String, String> map);

    String getTtsWithDefault(String str, String str2, Map<String, String> map, String str3);

    /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    /* bridge */ /* synthetic */ void register() {
        super.register();
    }
}
