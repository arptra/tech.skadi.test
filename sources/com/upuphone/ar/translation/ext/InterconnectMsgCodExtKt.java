package com.upuphone.ar.translation.ext;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0013\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0013\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a\u0013\u0010\t\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\u0003\u001a\u0013\u0010\n\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\u0003\u001a\u0013\u0010\f\u001a\u00020\u000b*\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000e\u001a\u00020\u000b*\u00020\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\r\u001a\u0013\u0010\u000f\u001a\u00020\u000b*\u00020\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"", "", "e", "(I)Ljava/lang/String;", "j", "i", "k", "a", "f", "g", "h", "", "d", "(I)Z", "b", "c", "ar-translator_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class InterconnectMsgCodExtKt {
    public static final String a(int i) {
        if (i == 0) {
            return "[" + i + "|CALL_STATE_IDLE]";
        } else if (i == 1) {
            return "[" + i + "|CALL_STATE_RINGING]";
        } else if (i != 2) {
            return "[" + i + "|UNKNOWN_CALL_STATE]";
        } else {
            return "[" + i + "|CALL_STATE_OFFHOOK]";
        }
    }

    public static final boolean b(int i) {
        return i == 28 || i == 21 || i == 25 || i == 35;
    }

    public static final boolean c(int i) {
        return i == 27 || i == 22 || i == 26 || i == 34;
    }

    public static final boolean d(int i) {
        return i == -1 || i == 23 || i == 24 || i == 15 || i == 31;
    }

    public static final String e(int i) {
        if (i == 1) {
            return "[" + i + "|GLASS_TRANS_CLICK_START]";
        } else if (i == 7) {
            return "[" + i + "|GLASS_TRANS_EXIT]";
        } else if (i == 58) {
            return "[" + i + "|PHONE_SUBTITLE_SET_TYPE]";
        } else if (i == 63) {
            return "[" + i + "|PHONE_DIALOG_DISMISS]";
        } else if (i == 68) {
            return "[" + i + "|PHONE_TRANS_EXIT_ACK]";
        } else if (i == 3) {
            return "[" + i + "|GLASS_TRANS_PROXIMAL_AUDIO]";
        } else if (i == 4) {
            return "[" + i + "|GLASS_TRANS_REMOTE_AUDIO]";
        } else if (i == 11) {
            return "[" + i + "|GLASS_GLASS_SERVER_START_COMPLETE]";
        } else if (i == 12) {
            return "[" + i + "|GLASS_DIALOG_DISMISS]";
        } else if (i == 60) {
            return "[" + i + "|PHONE_TRANSLATE_LANGUAGE_SET]";
        } else if (i == 61) {
            return "[" + i + "|PHONE_TRANS_START]";
        } else if (i == 65) {
            return "[" + i + "|PHONE_PHONE_TRANS_SERVER_EXIT]";
        } else if (i == 66) {
            return "[" + i + "|PHONE_PHONE_TRANS_SAVE_SUCCESS]";
        } else if (i == 101) {
            return "[" + i + "|BASE_CONNECT_STATE]";
        } else if (i != 102) {
            switch (i) {
                case 14:
                    return "[" + i + "|GLASS_ASSISTANT_OPEN]";
                case 15:
                    return "[" + i + "|GLASS_ASSISTANT_EXIT]";
                case 16:
                    return "[" + i + "|GLASS_WECHAT_REPLY]";
                case 17:
                    return "[" + i + "|GLASS_WECHAT_REPLY_END]";
                case 18:
                    return "[" + i + "|GLASS_PHONE_STATE_OFFHOOK]";
                case 19:
                    return "[" + i + "|GLASS_PHONE_STATE_IDLE]";
                case 20:
                    return "[" + i + "|GLASS_PHONE_STATE_RINGING]";
                case 21:
                    return "[" + i + "|GLASS_SCREEN_STATE]";
                default:
                    switch (i) {
                        case 51:
                            return "[" + i + "|PHONE_RECORD_STATE]";
                        case 52:
                            return "[" + i + "|PHONE_TRANS_STATE]";
                        case 53:
                            return "[" + i + "|PHONE_TRANS_REMOTE_RESULT]";
                        case 54:
                            return "[" + i + "|PHONE_TRANS_PROXIMAL_RESULT]";
                        case 55:
                            return "[" + i + "|PHONE_TRANS_SERVER_RUNNING_STATE]";
                        default:
                            return "[" + i + "|UNKNOWN_MSG_CMD]";
                    }
            }
        } else {
            return "[" + i + "|BASE_DISCONNECT_STATE]";
        }
    }

    public static final String f(int i) {
        if (i == 1) {
            return "[" + i + "|RECORD_STATE_INIT]";
        } else if (i == 2) {
            return "[" + i + "|RECORD_STATE_START]";
        } else if (i == 3) {
            return "[" + i + "|RECORD_STATE_STOP]";
        } else if (i != 4) {
            return "[" + i + "|UNKNOWN_RECORD_STATE]";
        } else {
            return "[" + i + "|RECORD_STATE_RELEASE]";
        }
    }

    public static final String g(int i) {
        if (i == 0) {
            return "[" + i + "|SCREEN_INVALID]";
        } else if (i == 1) {
            return "[" + i + "|SCREEN_ON]";
        } else if (i != 2) {
            return "[" + i + "|UNKNOWN_SCREEN_STATE]";
        } else {
            return "[" + i + "|SCREEN_OFF]";
        }
    }

    public static final String h(int i) {
        if (i == 1) {
            return "[" + i + "|PROXIMAL_HIDE]";
        } else if (i == 2) {
            return "[" + i + "|PROXIMAL_ORIGINAL_SHOW]";
        } else if (i == 3) {
            return "[" + i + "|REMOTE_ORIGINAL_TRANSLATE_SHOW]";
        } else if (i != 4) {
            return "[" + i + "|UNKNOWN_SUBTITLE_TYPE]";
        } else {
            return "[" + i + "|REMOTE_TRANSLATE_SHOW]";
        }
    }

    public static final String i(int i) {
        if (i != -1) {
            switch (i) {
                case 10:
                    return "[" + i + "|EXP_STATE_CONNECT_ON]";
                case 11:
                    return "[" + i + "|EXP_STATE_CONNECT_OFF]";
                case 12:
                    return "[" + i + "|EXP_STATE_CONNECT_LOSS]";
                case 13:
                    return "[" + i + "|EXP_STATE_CONNECT_GOOD]";
                case 14:
                    return "[" + i + "|EXP_STATE_MUTE_TWO_SECS]";
                case 15:
                    return "[" + i + "|EXP_STATE_MUTE_FIVE_MINS]";
                case 16:
                    return "[" + i + "|EXP_STATE_SHOW_WAITING]";
                case 17:
                    return "[" + i + "|EXP_STATE_HINT_WAITING]";
                case 18:
                    return "[" + i + "|EXP_STATE_CONNECT_CHANNEL_ERROR]";
                case 19:
                    return "[" + i + "|EXP_STATE_MUTE_FIVE_SECS]";
                case 20:
                    return "[" + i + "|EXP_STATE_VOICE_NOT_MUTE]";
                case 21:
                    return "[" + i + "|EXP_ASSISTANT_ON]";
                case 22:
                    return "[" + i + "|EXP_ASSISTANT_OFF]";
                case 23:
                    return "[" + i + "|EXP_IN_CALL_TOAST]";
                case 24:
                    return "[" + i + "|EXP_WECHAT_REPLY_TOAST]";
                case 25:
                    return "[" + i + "|EXP_WECHAT_REPLY_ON]";
                case 26:
                    return "[" + i + "|EXP_WECHAT_REPLY_OFF]";
                case 27:
                    return "[" + i + "|EXP_CALL_STATE_IDLE]";
                case 28:
                    return "[" + i + "|EXP_CALL_STATE_RINGING]";
                case 29:
                    return "[" + i + "|EXP_CALL_STATE_OFFHOOK]";
                case 30:
                    return "[" + i + "|EXP_TELEPHONE_TRANS_USER_REMINDER]";
                case 31:
                    return "[" + i + "|EXP_TELEPHONE_TRANS_LANGUAGE_NOT_SUPPORT]";
                case 32:
                    return "[" + i + "|EXT_APP_ENTER_BACKGROUND]";
                case 33:
                    return "[" + i + "|EXT_APP_ENTER_FOREGROUND]";
                case 34:
                    return "[" + i + "|EXT_GLASS_SCREEN_ON]";
                case 35:
                    return "[" + i + "|EXT_GLASS_SCREEN_OFF]";
                default:
                    return "[" + i + "|UNKNOWN_EXP_STATE]";
            }
        } else {
            return "[" + i + "|EXP_STATE_NONE]";
        }
    }

    public static final String j(int i) {
        switch (i) {
            case 1:
                return "[" + i + "|NOT_START]";
            case 2:
                return "[" + i + "|END]";
            case 3:
                return "[" + i + "|PREPARING]";
            case 4:
                return "[" + i + "|RUNNING]";
            case 5:
                return "[" + i + "|LISTENING]";
            case 6:
                return "[" + i + "|STOPPING]";
            default:
                return "[" + i + "|UNKNOWN_STATE]";
        }
    }

    public static final String k(int i) {
        if (i == 1) {
            return "[" + i + "|ZHUAN_XIE]";
        } else if (i == 2) {
            return "[" + i + "|TONG_CHUAN]";
        } else if (i == 3) {
            return "[" + i + "|DUI_HUA]";
        } else if (i != 4) {
            return "[" + i + "|UNKNOWN_TRANS_TYPE]";
        } else {
            return "[" + i + "|TELEPHONE_TRANS]";
        }
    }
}
