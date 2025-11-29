package com.upuphone.starryiccoaproto;

import java.util.HashMap;

public class UCarControlProtocol extends UCarProtocol {
    public static void e() {
        UCarProtocol.d(CmdCategory.CONTROL, new HashMap<Integer, String>() {
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
            }
        });
    }
}
