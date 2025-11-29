package com.xjsd.ai.assistant.protocol;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import org.jetbrains.annotations.NotNull;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/AssistantSettingsType;", "", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface AssistantSettingsType {
    @NotNull
    public static final String ASR_RESULT_SCREEN = "asr_result_screen";
    @NotNull
    public static final String CHAT_GPT_CARD_DISPLAY = "chat_gpt_card_display";
    @NotNull
    public static final String CHAT_GPT_TTS_PLAY = "chat_gpt_tts_play";
    @NotNull
    public static final String CONTINUOUS_DIALOGUE = "continuous_dialogue";
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    @NotNull
    public static final String LOW_POWER_WAKEUP = "low_power_wakeup";
    @NotNull
    public static final String LOW_POWER_WAKEUP_SCREEN_OFF = "low_power_wakeup_screen_off";
    @NotNull
    public static final String TTS_TIMBRE = "tts_timbre";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/AssistantSettingsType$Companion;", "", "()V", "ASR_RESULT_SCREEN", "", "CHAT_GPT_CARD_DISPLAY", "CHAT_GPT_TTS_PLAY", "CONTINUOUS_DIALOGUE", "LOW_POWER_WAKEUP", "LOW_POWER_WAKEUP_SCREEN_OFF", "TTS_TIMBRE", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        @NotNull
        public static final String ASR_RESULT_SCREEN = "asr_result_screen";
        @NotNull
        public static final String CHAT_GPT_CARD_DISPLAY = "chat_gpt_card_display";
        @NotNull
        public static final String CHAT_GPT_TTS_PLAY = "chat_gpt_tts_play";
        @NotNull
        public static final String CONTINUOUS_DIALOGUE = "continuous_dialogue";
        @NotNull
        public static final String LOW_POWER_WAKEUP = "low_power_wakeup";
        @NotNull
        public static final String LOW_POWER_WAKEUP_SCREEN_OFF = "low_power_wakeup_screen_off";
        @NotNull
        public static final String TTS_TIMBRE = "tts_timbre";

        private Companion() {
        }
    }
}
