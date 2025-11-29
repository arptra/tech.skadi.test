package com.upuphone.xr.sapp.fragment;

import com.xjsd.ai.assistant.chatgpt.ChatGptAbility;
import com.xjsd.ai.assistant.core.AbilityManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xjsd/ai/assistant/chatgpt/ChatGptAbility;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ChatGptHistoryH5Fragment$gptAbility$2 extends Lambda implements Function0<ChatGptAbility> {
    public static final ChatGptHistoryH5Fragment$gptAbility$2 INSTANCE = new ChatGptHistoryH5Fragment$gptAbility$2();

    public ChatGptHistoryH5Fragment$gptAbility$2() {
        super(0);
    }

    @Nullable
    public final ChatGptAbility invoke() {
        return (ChatGptAbility) AbilityManager.b.b(ChatGptAbility.class);
    }
}
