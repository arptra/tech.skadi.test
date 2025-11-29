package com.xjsd.ai.assistant.core.api.track;

import com.xjsd.ai.assistant.annotation.AbilityKey;
import com.xjsd.ai.assistant.core.Ability;
import java.util.Map;

@AbilityKey("track")
public interface TrackAbility extends Ability {
    /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    void track(String str, Map<String, Object> map);
}
