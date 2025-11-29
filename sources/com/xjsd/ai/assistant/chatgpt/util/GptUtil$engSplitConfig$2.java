package com.xjsd.ai.assistant.chatgpt.util;

import com.xjsd.ai.assistant.chatgpt.util.GptUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xjsd/ai/assistant/chatgpt/util/GptUtil$SplitConfig;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GptUtil$engSplitConfig$2 extends Lambda implements Function0<GptUtil.SplitConfig> {
    public static final GptUtil$engSplitConfig$2 INSTANCE = new GptUtil$engSplitConfig$2();

    public GptUtil$engSplitConfig$2() {
        super(0);
    }

    @NotNull
    public final GptUtil.SplitConfig invoke() {
        return new GptUtil.SplitConfig(GptUtil.b, 20, 40);
    }
}
