package com.upuphone.ar.translation.statemachine.annotation;

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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ar/translation/statemachine/annotation/TranslationExtCode;", "", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface TranslationExtCode {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int EXP_APP_ENTER_BACKGROUND = 32;
    public static final int EXP_APP_ENTER_FOREGROUND = 33;
    public static final int EXP_ASSISTANT_OFF = 22;
    public static final int EXP_ASSISTANT_ON = 21;
    public static final int EXP_CALL_STATE_IDLE = 27;
    public static final int EXP_CALL_STATE_OFFHOOK = 29;
    public static final int EXP_CALL_STATE_RINGING = 28;
    public static final int EXP_GLASS_SCREEN_OFF = 35;
    public static final int EXP_GLASS_SCREEN_ON = 34;
    public static final int EXP_IN_CALL_TOAST = 23;
    public static final int EXP_STATE_CONNECT_CHANNEL_ERROR = 18;
    public static final int EXP_STATE_CONNECT_GOOD = 13;
    public static final int EXP_STATE_CONNECT_LOSS = 12;
    public static final int EXP_STATE_CONNECT_OFF = 11;
    public static final int EXP_STATE_CONNECT_ON = 10;
    public static final int EXP_STATE_HINT_WAITING = 17;
    public static final int EXP_STATE_MUTE_FIVE_MINS = 15;
    public static final int EXP_STATE_MUTE_FIVE_SECS = 19;
    public static final int EXP_STATE_MUTE_TWO_SECS = 14;
    public static final int EXP_STATE_NONE = -1;
    public static final int EXP_STATE_SHOW_WAITING = 16;
    public static final int EXP_STATE_VOICE_NOT_MUTE = 20;
    public static final int EXP_TELEPHONE_TRANS_LANGUAGE_NOT_SUPPORT = 31;
    public static final int EXP_TELEPHONE_TRANS_USER_REMINDER = 30;
    public static final int EXP_WECHAT_REPLY_OFF = 26;
    public static final int EXP_WECHAT_REPLY_ON = 25;
    public static final int EXP_WECHAT_REPLY_TOAST = 24;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/upuphone/ar/translation/statemachine/annotation/TranslationExtCode$Companion;", "", "()V", "EXP_APP_ENTER_BACKGROUND", "", "EXP_APP_ENTER_FOREGROUND", "EXP_ASSISTANT_OFF", "EXP_ASSISTANT_ON", "EXP_CALL_STATE_IDLE", "EXP_CALL_STATE_OFFHOOK", "EXP_CALL_STATE_RINGING", "EXP_GLASS_SCREEN_OFF", "EXP_GLASS_SCREEN_ON", "EXP_IN_CALL_TOAST", "EXP_STATE_CONNECT_CHANNEL_ERROR", "EXP_STATE_CONNECT_GOOD", "EXP_STATE_CONNECT_LOSS", "EXP_STATE_CONNECT_OFF", "EXP_STATE_CONNECT_ON", "EXP_STATE_HINT_WAITING", "EXP_STATE_MUTE_FIVE_MINS", "EXP_STATE_MUTE_FIVE_SECS", "EXP_STATE_MUTE_TWO_SECS", "EXP_STATE_NONE", "EXP_STATE_SHOW_WAITING", "EXP_STATE_VOICE_NOT_MUTE", "EXP_TELEPHONE_TRANS_LANGUAGE_NOT_SUPPORT", "EXP_TELEPHONE_TRANS_USER_REMINDER", "EXP_WECHAT_REPLY_OFF", "EXP_WECHAT_REPLY_ON", "EXP_WECHAT_REPLY_TOAST", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int EXP_APP_ENTER_BACKGROUND = 32;
        public static final int EXP_APP_ENTER_FOREGROUND = 33;
        public static final int EXP_ASSISTANT_OFF = 22;
        public static final int EXP_ASSISTANT_ON = 21;
        public static final int EXP_CALL_STATE_IDLE = 27;
        public static final int EXP_CALL_STATE_OFFHOOK = 29;
        public static final int EXP_CALL_STATE_RINGING = 28;
        public static final int EXP_GLASS_SCREEN_OFF = 35;
        public static final int EXP_GLASS_SCREEN_ON = 34;
        public static final int EXP_IN_CALL_TOAST = 23;
        public static final int EXP_STATE_CONNECT_CHANNEL_ERROR = 18;
        public static final int EXP_STATE_CONNECT_GOOD = 13;
        public static final int EXP_STATE_CONNECT_LOSS = 12;
        public static final int EXP_STATE_CONNECT_OFF = 11;
        public static final int EXP_STATE_CONNECT_ON = 10;
        public static final int EXP_STATE_HINT_WAITING = 17;
        public static final int EXP_STATE_MUTE_FIVE_MINS = 15;
        public static final int EXP_STATE_MUTE_FIVE_SECS = 19;
        public static final int EXP_STATE_MUTE_TWO_SECS = 14;
        public static final int EXP_STATE_NONE = -1;
        public static final int EXP_STATE_SHOW_WAITING = 16;
        public static final int EXP_STATE_VOICE_NOT_MUTE = 20;
        public static final int EXP_TELEPHONE_TRANS_LANGUAGE_NOT_SUPPORT = 31;
        public static final int EXP_TELEPHONE_TRANS_USER_REMINDER = 30;
        public static final int EXP_WECHAT_REPLY_OFF = 26;
        public static final int EXP_WECHAT_REPLY_ON = 25;
        public static final int EXP_WECHAT_REPLY_TOAST = 24;

        private Companion() {
        }
    }
}
