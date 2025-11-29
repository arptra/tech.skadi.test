package com.xjsd.ai.assistant.env;

import com.xjsd.ai.assistant.annotation.AbilityKey;
import com.xjsd.ai.assistant.annotation.CloudEnv;
import com.xjsd.ai.assistant.core.Ability;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@AbilityKey("env")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H'¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/env/EnvAbility;", "Lcom/xjsd/ai/assistant/core/Ability;", "changeEnv", "", "env", "", "getCurrentEnv", "Lcom/xjsd/ai/assistant/env/Environment;", "getEnv", "lib_assistant_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface EnvAbility extends Ability {
    @Deprecated(message = "该接口已废弃，因为环境统一由主应用控制，修改环境无效")
    void changeEnv(@CloudEnv int i);

    @NotNull
    Environment getCurrentEnv();

    @Deprecated(message = "该接口已废弃，因为环境统一由主应用控制")
    int getEnv();

    /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    /* bridge */ /* synthetic */ void register() {
        super.register();
    }
}
