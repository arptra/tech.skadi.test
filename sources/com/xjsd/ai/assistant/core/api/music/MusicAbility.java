package com.xjsd.ai.assistant.core.api.music;

import com.xjsd.ai.assistant.annotation.AbilityKey;
import com.xjsd.ai.assistant.core.Ability;
import java.util.function.Consumer;

@AbilityKey("music")
public interface MusicAbility extends Ability {
    void execute(MediaModel mediaModel, Consumer<MusicExecuteRes> consumer);

    /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    /* bridge */ /* synthetic */ void register() {
        super.register();
    }
}
