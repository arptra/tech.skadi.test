package com.upuphone.ar.transcribe.ext;

import kotlin.Metadata;
import org.eclipse.jetty.util.component.AbstractLifeCycle;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\b\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0003¨\u0006\t"}, d2 = {"", "", "b", "(I)Ljava/lang/String;", "e", "d", "f", "a", "c", "ar-transcribe_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class InterconnectMsgCodExtKt {
    public static final String a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "UNKNOWN_CALL_STATE" : "CALL_STATE_OFFHOOK" : "CALL_STATE_RINGING" : "CALL_STATE_IDLE";
    }

    public static final String b(int i) {
        if (i == 1) {
            return "GLASS_TRANS_CLICK_START";
        }
        if (i == 4) {
            return "GLASS_TRANS_REMOTE_AUDIO";
        }
        if (i == 7) {
            return "GLASS_TRANS_EXIT";
        }
        if (i == 63) {
            return "PHONE_DIALOG_DISMISS";
        }
        if (i == 68) {
            return "PHONE_TRANS_EXIT_ACK";
        }
        if (i == 11) {
            return "GLASS_GLASS_SERVER_START_COMPLETE";
        }
        if (i == 12) {
            return "GLASS_DIALOG_DISMISS";
        }
        if (i == 57) {
            return "PHONE_SUBTITLE_SIZE_TYPE";
        }
        if (i == 58) {
            return "PHONE_SUBTITLE_SET_TYPE";
        }
        if (i == 60) {
            return "PHONE_TRANSLATE_LANGUAGE_SET";
        }
        if (i == 61) {
            return "PHONE_TRANS_START";
        }
        if (i == 65) {
            return "PHONE_PHONE_TRANS_SERVER_EXIT";
        }
        if (i == 66) {
            return "PHONE_PHONE_TRANS_SAVE_SUCCESS";
        }
        if (i == 101) {
            return "BASE_CONNECT_STATE";
        }
        if (i == 102) {
            return "BASE_DISCONNECT_STATE";
        }
        switch (i) {
            case 14:
                return "GLASS_ASSISTANT_OPEN";
            case 15:
                return "GLASS_ASSISTANT_EXIT";
            case 16:
                return "GLASS_WECHAT_REPLY";
            case 17:
                return "GLASS_WECHAT_REPLY_END";
            case 18:
                return "GLASS_PHONE_STATE_OFFHOOK";
            case 19:
                return "GLASS_PHONE_STATE_IDLE";
            case 20:
                return "GLASS_PHONE_STATE_RINGING";
            default:
                switch (i) {
                    case 51:
                        return "PHONE_RECORD_STATE";
                    case 52:
                        return "PHONE_TRANS_STATE";
                    case 53:
                        return "PHONE_TRANS_REMOTE_RESULT";
                    case 54:
                        return "PHONE_TRANS_PROXIMAL_RESULT";
                    case 55:
                        return "PHONE_TRANS_SERVER_RUNNING_STATE";
                    default:
                        return "UNKNOWN_COMMAND=" + i;
                }
        }
    }

    public static final String c(int i) {
        if (i == 1) {
            return "RECORD_STATE_INIT";
        }
        if (i == 2) {
            return "RECORD_STATE_START";
        }
        if (i == 3) {
            return "RECORD_STATE_STOP";
        }
        if (i == 4) {
            return "RECORD_STATE_RELEASE";
        }
        return "UNKNOWN_RECORD_STATE=" + i;
    }

    public static final String d(int i) {
        if (i == -1) {
            return "EXP_STATE_NONE";
        }
        switch (i) {
            case 10:
                return "EXP_STATE_CONNECT_ON";
            case 11:
                return "EXP_STATE_CONNECT_OFF";
            case 12:
                return "EXP_STATE_CONNECT_LOSS";
            case 13:
                return "EXP_STATE_CONNECT_GOOD";
            case 14:
                return "EXP_STATE_MUTE_TWO_SECS";
            case 15:
                return "EXP_STATE_MUTE_FIVE_MINS";
            case 16:
                return "EXP_STATE_SHOW_WAITING";
            case 17:
                return "EXP_STATE_HINT_WAITING";
            case 18:
                return "EXP_STATE_CONNECT_CHANNEL_ERROR";
            case 19:
                return "EXP_STATE_MUTE_FIVE_SECS";
            case 20:
                return "EXP_STATE_VOICE_NOT_MUTE";
            case 21:
                return "EXP_ASSISTANT_ON";
            case 22:
                return "EXP_ASSISTANT_OFF";
            case 23:
                return "EXP_IN_CALL_TOAST";
            case 24:
                return "EXP_WECHAT_REPLY_TOAST";
            case 25:
                return "EXP_WECHAT_REPLY_ON";
            case 26:
                return "EXP_WECHAT_REPLY_OFF";
            case 27:
                return "EXP_CALL_STATE_IDLE";
            case 28:
                return "EXP_CALL_STATE_RINGING";
            case 29:
                return "EXP_CALL_STATE_OFFHOOK";
            default:
                return "UNKNOWN_STATE_EXT=" + i;
        }
    }

    public static final String e(int i) {
        switch (i) {
            case 1:
                return "NOT_START";
            case 2:
                return "END";
            case 3:
                return "PREPARING";
            case 4:
                return AbstractLifeCycle.RUNNING;
            case 5:
                return "LISTENING";
            case 6:
                return AbstractLifeCycle.STOPPING;
            default:
                return "UNKNOWN_STATE=" + i;
        }
    }

    public static final String f(int i) {
        if (i == 1) {
            return "转写";
        }
        return "未知类型=" + i;
    }
}
