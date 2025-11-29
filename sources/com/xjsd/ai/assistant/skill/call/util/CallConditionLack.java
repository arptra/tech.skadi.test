package com.xjsd.ai.assistant.skill.call.util;

import com.xjsd.ai.assistant.template.TtsCallTemplate;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import com.xjsd.ai.assistant.template.TtsTemplate;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;", "", "template", "Lcom/xjsd/ai/assistant/template/TtsTemplate;", "(Ljava/lang/String;ILcom/xjsd/ai/assistant/template/TtsTemplate;)V", "getTemplate", "()Lcom/xjsd/ai/assistant/template/TtsTemplate;", "FLIGHT_MODE", "LACK_READ_PHONE_STATE_PERMISSION", "LOCK_SCREEN", "LOCK_SCREEN_618", "APP_IN_BACKGROUND", "APP_IN_BACKGROUND_618", "BLUETOOTH_SCO", "LACK_READ_CONTACT_PERMISSION", "LACK_CALL_PERMISSION", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum CallConditionLack {
    FLIGHT_MODE(TtsCallTemplate.CALL01_P02),
    LACK_READ_PHONE_STATE_PERMISSION(TtsCallTemplate.CALL01_P03),
    LOCK_SCREEN(TtsCallTemplate.CALL01_P05),
    LOCK_SCREEN_618(r1),
    APP_IN_BACKGROUND(TtsCallTemplate.CALL01_P06),
    APP_IN_BACKGROUND_618(r1),
    BLUETOOTH_SCO(TtsCallTemplate.CALL01_P08),
    LACK_READ_CONTACT_PERMISSION(TtsGlobalTemplate.GLOBAL02_R08),
    LACK_CALL_PERMISSION(TtsGlobalTemplate.GLOBAL02_R09);
    
    @NotNull
    private final TtsTemplate template;

    static {
        CallConditionLack[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
    }

    private CallConditionLack(TtsTemplate ttsTemplate) {
        this.template = ttsTemplate;
    }

    @NotNull
    public static EnumEntries<CallConditionLack> getEntries() {
        return $ENTRIES;
    }

    @NotNull
    public final TtsTemplate getTemplate() {
        return this.template;
    }
}
