package com.upuphone.ar.translation.statemachine.machine;

import com.upuphone.ar.translation.statemachine.annotation.MSG;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "", "a", "(I)Ljava/lang/String;", "ar-translator_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class StateMachineExtKt {
    public static final String a(int i) {
        String str;
        if (i == 100) {
            str = "[FORCE_ENTER_END:" + i + "]";
        } else if (i == 6001) {
            str = "[MSG_ASSISTANT_OPEN:" + i + "]";
        } else if (i == 6003) {
            str = "[MSG_ASSISTANT_EXIT:" + i + "]";
        } else if (i == 8001) {
            str = "[MSG_END_STATE_EXTCODE:" + i + "]";
        } else if (i == 1001) {
            str = "[MSG_SINGLE_TOUCHPAD:" + i + "]";
        } else if (i == 1002) {
            str = "[MSG_DOUBLE_TOUCHPAD:" + i + "]";
        } else if (i == 5000) {
            str = "[MSG_CONNECTED_ON:" + i + "]";
        } else if (i == 5001) {
            str = "[MSG_CONNECTED_OFF:" + i + "]";
        } else if (i == 5003) {
            str = "[MSG_CONNECTED_LOSS_PACKAGE:" + i + "]";
        } else if (i != 5004) {
            switch (i) {
                case 1006:
                    str = "[MSG_PHONE_CALL_STATE_OFFHOOK:" + i + "]";
                    break;
                case 1007:
                    str = "[MSG_PHONE_CALL_STATE_IDLE:" + i + "]";
                    break;
                case 1008:
                    str = "[MSG_PHONE_CALL_STATE_RINGING:" + i + "]";
                    break;
                default:
                    switch (i) {
                        case 1010:
                            str = "[MSG_WECHAT_REPLY:" + i + "]";
                            break;
                        case 1011:
                            str = "[MSG_WECHAT_REPLY_END:" + i + "]";
                            break;
                        case MSG.MSG_TELEPHONE_TRANS_LANGUAGE_NOT_SUPPORT:
                            str = "[MSG_TELEPHONE_TRANS_LANGUAGE_NOT_SUPPORT:" + i + "]";
                            break;
                        case MSG.MSG_GLASS_SCREEN_STATE:
                            str = "[MSG_GLASS_SCREEN_STATE:" + i + "]";
                            break;
                        default:
                            switch (i) {
                                case MSG.MSG_PREPARING_SUCCESS:
                                    str = "[MSG_PREPARING_SUCCESS:" + i + "]";
                                    break;
                                case MSG.MSG_IFLY_CONNECT_FAILED:
                                    str = "[MSG_IFLY_CONNECT_FAILED:" + i + "]";
                                    break;
                                case MSG.MSG_PREPARING_RETRY:
                                    str = "[MSG_PREPARING_RETRY:" + i + "]";
                                    break;
                                case MSG.MSG_PREPARING_SHOW_WAITING:
                                    str = "[MSG_PREPARING_SHOW_WAITING:" + i + "]";
                                    break;
                                case MSG.MSG_PREPARING_HINT_WAITING:
                                    str = "[MSG_PREPARING_HINT_WAITING:" + i + "]";
                                    break;
                                default:
                                    switch (i) {
                                        case MSG.MSG_VOICE_MUTE:
                                            str = "[MSG_VOICE_MUTE:" + i + "]";
                                            break;
                                        case MSG.MSG_VOICE_NOT_MUTE:
                                            str = "[MSG_VOICE_NOT_MUTE:" + i + "]";
                                            break;
                                        case MSG.MSG_VOICE_REDUCE_TWO_SECS:
                                            str = "[MSG_VOICE_REDUCE_TWO_SECS:" + i + "]";
                                            break;
                                        case MSG.MSG_VOICE_REDUCE_FIVE_SECS:
                                            str = "[MSG_VOICE_REDUCE_FIVE_SECS:" + i + "]";
                                            break;
                                        case MSG.MSG_VOICE_REDUCE_FIVE_MINS:
                                            str = "[MSG_VOICE_REDUCE_FIVE_MINS:" + i + "]";
                                            break;
                                        default:
                                            switch (i) {
                                                case MSG.REMOTE_MSG_TRANSLATE_RESULT_SHOW:
                                                    str = "[REMOTE_MSG_TRANSLATE_RESULT_SHOW:" + i + "]";
                                                    break;
                                                case MSG.PROXIMAL_MSG_TRANSLATE_RESULT_SHOW:
                                                    str = "[PROXIMAL_MSG_TRANSLATE_RESULT_SHOW:" + i + "]";
                                                    break;
                                                case MSG.SERVER_MSG_TRANSLATE_RUNNING_STATE:
                                                    str = "[SERVER_MSG_TRANSLATE_RUNNING_STATE:" + i + "]";
                                                    break;
                                                default:
                                                    str = "[MSG_UNKNOWN:" + i + "]";
                                                    break;
                                            }
                                    }
                            }
                    }
            }
        } else {
            str = "[MSG_CONNECTED_STATUS_GOOD:" + i + "]";
        }
        return "StateMachine" + str;
    }
}
