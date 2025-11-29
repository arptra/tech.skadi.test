package com.upuphone.ar.transcribe.audio.annotation;

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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ar/transcribe/audio/annotation/AudioDataState;", "", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface AudioDataState {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int STATE_MUTE_FIVE_MINUTES = 4;
    public static final int STATE_MUTE_FIVE_SECONDS = 3;
    public static final int STATE_MUTE_TWO_SECONDS = 2;
    public static final int STATE_MUTE_ZERO_SECONDS = 1;
    public static final int STATE_VOICE_START = 5;
    public static final int STATE_VOICE_STOP = 6;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/transcribe/audio/annotation/AudioDataState$Companion;", "", "()V", "STATE_MUTE_FIVE_MINUTES", "", "STATE_MUTE_FIVE_SECONDS", "STATE_MUTE_TWO_SECONDS", "STATE_MUTE_ZERO_SECONDS", "STATE_VOICE_START", "STATE_VOICE_STOP", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int STATE_MUTE_FIVE_MINUTES = 4;
        public static final int STATE_MUTE_FIVE_SECONDS = 3;
        public static final int STATE_MUTE_TWO_SECONDS = 2;
        public static final int STATE_MUTE_ZERO_SECONDS = 1;
        public static final int STATE_VOICE_START = 5;
        public static final int STATE_VOICE_STOP = 6;

        private Companion() {
        }
    }
}
