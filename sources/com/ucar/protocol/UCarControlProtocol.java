package com.ucar.protocol;

import com.google.protobuf.InvalidProtocolBufferException;
import com.ucar.databus.proto.UCarProto;
import java.util.HashMap;

public class UCarControlProtocol extends UCarProtocol {
    public static UCarProto.AddNotification A(UCarMessage uCarMessage) {
        k(36, uCarMessage, MessageType.SEND_SYNC);
        try {
            return UCarProto.AddNotification.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseAddNotificationMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.AppListChanged B(UCarMessage uCarMessage) {
        k(32, uCarMessage, MessageType.SEND_SYNC);
        try {
            return UCarProto.AppListChanged.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseAppListChangedMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.AppStateChanged C(UCarMessage uCarMessage) {
        k(31, uCarMessage, MessageType.SEND_SYNC);
        try {
            return UCarProto.AppStateChanged.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseAppStateChangedMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.AudioPlayerControl D(UCarMessage uCarMessage) {
        j(17, uCarMessage);
        try {
            return UCarProto.AudioPlayerControl.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseAudioPlayerControl error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.BluetoothMacInfo E(UCarMessage uCarMessage) {
        j(22, uCarMessage);
        try {
            return UCarProto.BluetoothMacInfo.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseBluetoothMacInfo error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.CallInfo F(UCarMessage uCarMessage) {
        k(34, uCarMessage, MessageType.SEND);
        try {
            return UCarProto.CallInfo.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseCallInfoMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.DeleteNotification G(UCarMessage uCarMessage) {
        k(38, uCarMessage, MessageType.SEND_SYNC);
        try {
            return UCarProto.DeleteNotification.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseDeleteNotificationMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.GetAppDetailInfoResponse H(UCarMessage uCarMessage) {
        k(29, uCarMessage, MessageType.RES);
        try {
            return UCarProto.GetAppDetailInfoResponse.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseGetAppDetailInfoResponseMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.GetAppListResponse I(UCarMessage uCarMessage) {
        k(27, uCarMessage, MessageType.RES);
        try {
            return UCarProto.GetAppListResponse.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseGetAppListResponseMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.Heartbeat J(UCarMessage uCarMessage) {
        j(1, uCarMessage);
        try {
            return UCarProto.Heartbeat.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseHeartbeatMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.NotifyAudioPlayerState K(UCarMessage uCarMessage) {
        j(8, uCarMessage);
        try {
            return UCarProto.NotifyAudioPlayerState.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseNotifyAudioPlayerStateMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.NotifyMicrophoneState L(UCarMessage uCarMessage) {
        j(6, uCarMessage);
        try {
            return UCarProto.NotifyMicrophoneState.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseNotifyMicrophoneStateMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.NotifyMirrorState M(UCarMessage uCarMessage) {
        j(7, uCarMessage);
        try {
            return UCarProto.NotifyMirrorState.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseNotifyMirrorStateMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.NotifyMusicInfo N(UCarMessage uCarMessage) {
        j(10, uCarMessage);
        try {
            return UCarProto.NotifyMusicInfo.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseNotifyMusicInfoMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.NotifyNavigationInfo O(UCarMessage uCarMessage) {
        j(11, uCarMessage);
        try {
            return UCarProto.NotifyNavigationInfo.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseNotifyNavigationInfoMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.NotifyPhoneState P(UCarMessage uCarMessage) {
        j(9, uCarMessage);
        try {
            return UCarProto.NotifyPhoneState.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseNotifyPhoneStateMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.POIAddress Q(UCarMessage uCarMessage) {
        k(33, uCarMessage, MessageType.SEND);
        try {
            return UCarProto.POIAddress.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parsePOIAddressMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.SetCameraState R(UCarMessage uCarMessage) {
        j(20, uCarMessage);
        try {
            return UCarProto.SetCameraState.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseSetCameraStateMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.TouchPadVibrator S(UCarMessage uCarMessage) {
        k(39, uCarMessage, MessageType.SEND);
        try {
            return UCarProto.TouchPadVibrator.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseTouchPadVibratorMessage error: " + e.getMessage(), e);
        }
    }

    public static void j(int i, UCarMessage uCarMessage) {
        UCarProtocol.b(DataFormat.PB3, CmdCategory.CONTROL, i, uCarMessage);
    }

    public static void k(int i, UCarMessage uCarMessage, MessageType messageType) {
        UCarProtocol.c(DataFormat.PB3, CmdCategory.CONTROL, i, uCarMessage, messageType);
    }

    public static UCarMessage l(UCarProto.AwakenVoiceAssistant awakenVoiceAssistant) {
        return UCarProtocol.d(z().f(SourceDevice.CAR).e(16).a(awakenVoiceAssistant));
    }

    public static UCarMessage m(UCarProto.NotifyCameraStateChanged notifyCameraStateChanged) {
        return UCarProtocol.d(z().f(SourceDevice.CAR).e(21).a(notifyCameraStateChanged));
    }

    public static UCarMessage n(UCarProto.ClickNotification clickNotification) {
        return UCarProtocol.d(z().f(SourceDevice.CAR).e(37).a(clickNotification));
    }

    public static UCarMessage o(UCarProto.CustomKeyEvent customKeyEvent) {
        return UCarProtocol.d(z().f(SourceDevice.CAR).e(12).a(customKeyEvent));
    }

    public static UCarMessage p(UCarProto.Disconnect disconnect) {
        return UCarProtocol.d(z().f(SourceDevice.CAR).e(23).a(disconnect));
    }

    public static UCarMessage q(UCarProto.GetUCarConfigResponse getUCarConfigResponse, int i) {
        return UCarProtocol.d(z().f(SourceDevice.CAR).d(MessageType.RES).e(25).a(getUCarConfigResponse).A(i));
    }

    public static UCarMessage r(UCarProto.Heartbeat heartbeat) {
        return z().f(UCarProtocol.f()).e(1).a(heartbeat);
    }

    public static UCarMessage s(UCarProto.NotifyAddCamera notifyAddCamera) {
        return UCarProtocol.d(z().f(SourceDevice.CAR).e(18).a(notifyAddCamera));
    }

    public static UCarMessage t(UCarProto.NotifyCallHungUp notifyCallHungUp) {
        return UCarProtocol.d(z().f(SourceDevice.CAR).e(14).a(notifyCallHungUp));
    }

    public static UCarMessage u() {
        return UCarProtocol.d(z().f(SourceDevice.CAR).e(5).a(UCarProto.NotifyCarToBackground.newBuilder().setTimestamp(System.currentTimeMillis()).build()));
    }

    public static UCarMessage v(UCarProto.NotifyRemoveCamera notifyRemoveCamera) {
        return UCarProtocol.d(z().f(SourceDevice.CAR).e(19).a(notifyRemoveCamera));
    }

    public static UCarMessage w(UCarProto.NotifySwitchDayOrNight notifySwitchDayOrNight) {
        return UCarProtocol.d(z().f(SourceDevice.CAR).e(15).a(notifySwitchDayOrNight));
    }

    public static UCarMessage x(UCarProto.VRCmdToPhone vRCmdToPhone) {
        return UCarProtocol.d(z().f(SourceDevice.CAR).e(13).a(vRCmdToPhone));
    }

    public static void y() {
        UCarProtocol.h(CmdCategory.CONTROL, new HashMap<Integer, String>() {
            {
                put(1, "heartbeat");
                put(2, "get_port_request");
                put(3, "get_port_response");
                put(4, "notify_car_to_foreground");
                put(5, "notify_car_to_background");
                put(6, "notify_microphone_state");
                put(7, "notify_mirror_state");
                put(8, "notify_audio_player_state");
                put(9, "notify_phone_state");
                put(10, "notify_music_info");
                put(11, "notify_navigation_info");
                put(12, "custom_key_event");
                put(13, "vr_cmd_to_phone");
                put(14, "notify_call_hung_up");
                put(15, "notify_switch_day_or_night");
                put(16, "awaken_voice_assistant");
                put(17, "audio_player_control");
                put(18, "notify_add_camera");
                put(19, "notify_remove_camera");
                put(20, "set_camera_state");
                put(21, "camera_state");
                put(22, "bluetooth_mac_info");
                put(23, "disconnect");
                put(24, "get_ucar_config_request");
                put(25, "get_ucar_config_response");
                put(26, "get_app_list_request");
                put(27, "get_app_list_response");
                put(28, "get_app_detail_info_request");
                put(29, "get_app_detail_info_response");
                put(30, "invoke_app");
                put(31, "app_state_changed");
                put(32, "app_list_changed");
                put(33, "poi_address");
                put(34, "call_info");
                put(35, "pick_up_call");
                put(36, "add_notification");
                put(37, "click_notification");
                put(38, "delete_notification");
                put(39, "touch_pad_vibrator");
                put(40, "notify_car_vr_state");
            }
        });
    }

    public static UCarMessageBuilder z() {
        return UCarMessage.q().b(CmdCategory.CONTROL);
    }
}
