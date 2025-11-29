package com.xjsd.ai.assistant.protocol;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface CmdCode {
    public static final int CODE_ASR_ACCESSIBILITY_SHOT = 200;
    public static final int CODE_ASR_FRO_SELF_TRANS = 101;
    public static final int CODE_ASR_FRO_THIRD_TRANS = 105;
    public static final int CODE_BUSINESS_DATA_TRANS = 103;
    public static final int CODE_CHAT_GPT_RECOMMEND = 123;
    public static final int CODE_CHAT_GPT_RESPONSE = 122;
    public static final int CODE_CONTROL_AUDIO_FOCUS = 300;
    public static final int CODE_DELAY_LISTENING = 118;
    public static final int CODE_HIT_NLU = 112;
    public static final int CODE_HOT_WORD_MANAGER = 107;
    public static final int CODE_HOT_WORD_UPLOAD = 108;
    public static final int CODE_LAUNCH_GLASS_ASSISTANT = 110;
    public static final int CODE_NOTIFY_AIR = 115;
    public static final int CODE_NOTIFY_CAR_WAKEUP_SUCCESS = 121;
    public static final int CODE_NOTIFY_DOMAIN_CHANGE = 113;
    public static final int CODE_NOTIFY_RECEIVE_NLU = 201;
    public static final int CODE_NOTIFY_RELEASE_AUDIO_FOCUS = 120;
    public static final int CODE_RECORD_DATA_TRANS = 109;
    public static final int CODE_RESET_VAD_STATUS = 119;
    public static final int CODE_RESET_VR_LISTENING_TIME = 124;
    public static final int CODE_START_VR_REQ = 3;
    public static final int CODE_START_VR_RES = 4;
    public static final int CODE_SYNC_ASSISTANT_SETTINGS = 111;
    public static final int CODE_SYNC_REJECT_ROUND_TIMES = 114;
    public static final int CODE_SYNC_SYS_INFO_REQ = 1;
    public static final int CODE_SYNC_SYS_INFO_RES = 2;
    public static final int CODE_SYNC_VR_STATE = 106;
    public static final int CODE_TTS_PLAY_REQ = 5;
    public static final int CODE_TTS_PLAY_RES = 6;
    public static final int CODE_TTS_PLAY_STATE = 117;
    public static final int CODE_VAD_EVENT_TRANS = 104;
    public static final int CODE_VAD_EVENT_TRANS_THIRD = 116;
    public static final int CODE_VOICE_WAKEUP_VR_REQ = 7;
    public static final int CODE_VUI_MODEL_TRANS = 102;
    public static final int CODE_WAKEUP_AUDIO = 402;
    public static final int CODE_WAKEUP_AUDIO_STATE = 401;
    public static final int CODE_WAKEUP_RECORDING = 400;
}
