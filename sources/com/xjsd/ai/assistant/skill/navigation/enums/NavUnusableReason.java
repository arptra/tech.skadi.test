package com.xjsd.ai.assistant.skill.navigation.enums;

import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import com.xjsd.ai.assistant.template.TtsTemplate;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/xjsd/ai/assistant/skill/navigation/enums/NavUnusableReason;", "", "template", "Lcom/xjsd/ai/assistant/template/TtsTemplate;", "(Ljava/lang/String;ILcom/xjsd/ai/assistant/template/TtsTemplate;)V", "getTemplate", "()Lcom/xjsd/ai/assistant/template/TtsTemplate;", "NOT_AGREE_PROTOCOL", "NOT_OPEN_GPS", "LACK_BACKGROUND_LOCATION_PERMISSION", "LACK_ACCESS_NETWORK_STATE", "LACK_LOCATION_PERMISSION", "REGION_NOT_SUPPORT", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum NavUnusableReason {
    NOT_AGREE_PROTOCOL(TtsGlobalTemplate.GLOBAL02_R03),
    NOT_OPEN_GPS(TtsGlobalTemplate.GLOBAL02_R10),
    LACK_BACKGROUND_LOCATION_PERMISSION(TtsGlobalTemplate.GLOBAL01_P27),
    LACK_ACCESS_NETWORK_STATE(TtsGlobalTemplate.GLOBAL02_R01),
    LACK_LOCATION_PERMISSION(TtsGlobalTemplate.GLOBAL02_R02),
    REGION_NOT_SUPPORT(TtsGlobalTemplate.GLOBAL02_R04);
    
    @NotNull
    private final TtsTemplate template;

    static {
        NavUnusableReason[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
    }

    private NavUnusableReason(TtsTemplate ttsTemplate) {
        this.template = ttsTemplate;
    }

    @NotNull
    public static EnumEntries<NavUnusableReason> getEntries() {
        return $ENTRIES;
    }

    @NotNull
    public final TtsTemplate getTemplate() {
        return this.template;
    }
}
