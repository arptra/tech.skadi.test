package com.upuphone.ar.transcribe.interconnect.annotation;

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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004B\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/interconnect/annotation/InterConnectMsgCmd;", "", "BaseState", "Glass2Phone", "Phone2Glass", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface InterConnectMsgCmd {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/transcribe/interconnect/annotation/InterConnectMsgCmd$BaseState;", "", "()V", "CONNECT_STATE", "", "DISCONNECT_STATE", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BaseState {
        public static final int CONNECT_STATE = 101;
        public static final int DISCONNECT_STATE = 102;
        @NotNull
        public static final BaseState INSTANCE = new BaseState();

        private BaseState() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/upuphone/ar/transcribe/interconnect/annotation/InterConnectMsgCmd$Glass2Phone;", "", "()V", "ASSISTANT_EXIT", "", "ASSISTANT_OPEN", "DIALOG_DISMISS", "GLASS_SERVER_START_COMPLETE", "PHONE_STATE_IDLE", "PHONE_STATE_OFFHOOK", "PHONE_STATE_RINGING", "SCREEN_STATE", "TRANS_CLICK_START", "TRANS_EXIT", "TRANS_PROXIMAL_AUDIO", "TRANS_REMOTE_AUDIO", "WECHAT_REPLY", "WECHAT_REPLY_END", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Glass2Phone {
        public static final int ASSISTANT_EXIT = 15;
        public static final int ASSISTANT_OPEN = 14;
        public static final int DIALOG_DISMISS = 12;
        public static final int GLASS_SERVER_START_COMPLETE = 11;
        @NotNull
        public static final Glass2Phone INSTANCE = new Glass2Phone();
        public static final int PHONE_STATE_IDLE = 19;
        public static final int PHONE_STATE_OFFHOOK = 18;
        public static final int PHONE_STATE_RINGING = 20;
        public static final int SCREEN_STATE = 21;
        public static final int TRANS_CLICK_START = 1;
        public static final int TRANS_EXIT = 7;
        public static final int TRANS_PROXIMAL_AUDIO = 3;
        public static final int TRANS_REMOTE_AUDIO = 4;
        public static final int WECHAT_REPLY = 16;
        public static final int WECHAT_REPLY_END = 17;

        private Glass2Phone() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/upuphone/ar/transcribe/interconnect/annotation/InterConnectMsgCmd$Phone2Glass;", "", "()V", "DIALOG_DISMISS", "", "PHONE_TRANS_SAVE_SUCCESS", "PHONE_TRANS_SERVER_EXIT", "RECORD_STATE", "SUBTITLE_SET_TYPE", "SUBTITLE_SIZE_TYPE", "TRANSLATE_LANGUAGE_SET", "TRANS_EXIT_ACK", "TRANS_PROXIMAL_RESULT", "TRANS_REMOTE_RESULT", "TRANS_SCREEN_TYPE_CHANGE", "TRANS_SERVER_RUNNING_STATE", "TRANS_START", "TRANS_STATE", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Phone2Glass {
        public static final int DIALOG_DISMISS = 63;
        @NotNull
        public static final Phone2Glass INSTANCE = new Phone2Glass();
        public static final int PHONE_TRANS_SAVE_SUCCESS = 66;
        public static final int PHONE_TRANS_SERVER_EXIT = 65;
        public static final int RECORD_STATE = 51;
        public static final int SUBTITLE_SET_TYPE = 58;
        public static final int SUBTITLE_SIZE_TYPE = 57;
        public static final int TRANSLATE_LANGUAGE_SET = 60;
        public static final int TRANS_EXIT_ACK = 68;
        public static final int TRANS_PROXIMAL_RESULT = 54;
        public static final int TRANS_REMOTE_RESULT = 53;
        public static final int TRANS_SCREEN_TYPE_CHANGE = 69;
        public static final int TRANS_SERVER_RUNNING_STATE = 55;
        public static final int TRANS_START = 61;
        public static final int TRANS_STATE = 52;

        private Phone2Glass() {
        }
    }
}
