package com.xjsd.ai.assistant.chatgpt.model;

import com.xjsd.ai.assistant.connect.InterconnectAbility;
import com.xjsd.ai.assistant.core.AbilityManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xjsd/ai/assistant/connect/InterconnectAbility;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DeviceRequestAssembler$connectAbility$2 extends Lambda implements Function0<InterconnectAbility> {
    public static final DeviceRequestAssembler$connectAbility$2 INSTANCE = new DeviceRequestAssembler$connectAbility$2();

    public DeviceRequestAssembler$connectAbility$2() {
        super(0);
    }

    @Nullable
    public final InterconnectAbility invoke() {
        return (InterconnectAbility) AbilityManager.b.b(InterconnectAbility.class);
    }
}
