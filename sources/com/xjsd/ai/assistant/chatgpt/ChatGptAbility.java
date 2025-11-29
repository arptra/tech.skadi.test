package com.xjsd.ai.assistant.chatgpt;

import com.xjsd.ai.assistant.annotation.AbilityKey;
import com.xjsd.ai.assistant.chatgpt.model.LlmResponse;
import com.xjsd.ai.assistant.chatgpt.model.minimax.LlmRecommend;
import com.xjsd.ai.assistant.core.Ability;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@AbilityKey("chatgpt")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\tH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J.\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00100\tH&J&\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00120\tH\u0016¨\u0006\u0013"}, d2 = {"Lcom/xjsd/ai/assistant/chatgpt/ChatGptAbility;", "Lcom/xjsd/ai/assistant/core/Ability;", "cancel", "", "id", "", "getChatGptModelList", "sessionId", "callback", "Ljava/util/function/Consumer;", "", "getRecordsPagePath", "handleExit", "talkChatGptForAnswer", "query", "rawQuery", "Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;", "talkChatGptForRecommend", "Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ChatGptAbility extends Ability {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    void cancel(@NotNull String str);

    void getChatGptModelList(@NotNull String str, @NotNull Consumer<List<String>> consumer);

    @NotNull
    String getRecordsPagePath();

    void handleExit();

    /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    void talkChatGptForAnswer(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Consumer<LlmResponse> consumer);

    void talkChatGptForRecommend(@NotNull String str, @NotNull String str2, @NotNull Consumer<LlmRecommend> consumer);
}
