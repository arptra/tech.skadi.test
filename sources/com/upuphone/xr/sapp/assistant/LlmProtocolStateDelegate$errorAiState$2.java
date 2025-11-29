package com.upuphone.xr.sapp.assistant;

import com.upuphone.xr.sapp.entity.AIModelResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/sapp/entity/AIModelResult;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class LlmProtocolStateDelegate$errorAiState$2 extends Lambda implements Function0<AIModelResult> {
    public static final LlmProtocolStateDelegate$errorAiState$2 INSTANCE = new LlmProtocolStateDelegate$errorAiState$2();

    public LlmProtocolStateDelegate$errorAiState$2() {
        super(0);
    }

    @NotNull
    public final AIModelResult invoke() {
        return new AIModelResult(false, -2, true);
    }
}
