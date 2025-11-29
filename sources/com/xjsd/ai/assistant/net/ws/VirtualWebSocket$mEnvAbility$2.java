package com.xjsd.ai.assistant.net.ws;

import com.xjsd.ai.assistant.core.Ability;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.env.EnvAbility;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xjsd/ai/assistant/env/EnvAbility;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VirtualWebSocket$mEnvAbility$2 extends Lambda implements Function0<EnvAbility> {
    public static final VirtualWebSocket$mEnvAbility$2 INSTANCE = new VirtualWebSocket$mEnvAbility$2();

    public VirtualWebSocket$mEnvAbility$2() {
        super(0);
    }

    @NotNull
    public final EnvAbility invoke() {
        Ability b = AbilityManager.b.b(EnvAbility.class);
        Intrinsics.checkNotNull(b);
        return (EnvAbility) b;
    }
}
