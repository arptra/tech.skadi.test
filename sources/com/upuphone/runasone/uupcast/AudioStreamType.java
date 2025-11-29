package com.upuphone.runasone.uupcast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AudioStreamType {
    public static final int AUDIO_STREAM_AI_ASSISTANT = 32;
    public static final int AUDIO_STREAM_DTMF = 128;
    public static final int AUDIO_STREAM_MEDIA = 1;
    public static final int AUDIO_STREAM_NOTIFICATION = 64;
    public static final int AUDIO_STREAM_OTHER = 512;
    public static final int AUDIO_STREAM_RING = 4;
    public static final int AUDIO_STREAM_SYSTEM = 256;
    public static final int AUDIO_STREAM_TTS = 2;
    public static final int AUDIO_STREAM_VOICE_CALL = 16;
    public static final int AUDIO_STREAM_VOIP = 8;
}
