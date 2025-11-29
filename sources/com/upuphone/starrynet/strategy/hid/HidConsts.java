package com.upuphone.starrynet.strategy.hid;

import com.upuphone.starrynet.strategy.message.payload.handler.RingDataUtil;
import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheResponse;

public class HidConsts {
    public static final byte[] COMBO_DESCRIPTOR = {5, 1, 9, 2, -95, 1, 9, 1, -95, 0, RingSecurityPair.OPCODE_PHONE_START_REMOVE_BOND, 2, 5, 9, 25, 1, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 3, 21, 0, 37, 1, -107, 3, 117, 1, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, 2, -107, 1, 117, 5, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, 3, 5, 1, 9, 48, 9, 49, 9, 56, 21, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, 37, Byte.MAX_VALUE, 117, 8, -107, 3, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, 6, -64, -64, 5, 1, 9, 6, -95, 1, RingSecurityPair.OPCODE_PHONE_START_REMOVE_BOND, 1, 5, 8, 25, 1, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 5, -111, 2, -107, 1, 117, 3, -111, 3, -107, 6, 117, 8, 21, 0, 37, 101, 5, 7, 25, 0, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 101, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, 0, -64};
    public static final byte KEYBOARD_REPORT_ID = 1;
    public static final byte MOUSE_REPORT_ID = 2;
    public static final byte[] TOUCHPAD_DESCRIPTOR = {5, 13, 9, 4, -95, 1, RingSecurityPair.OPCODE_PHONE_START_REMOVE_BOND, 1, 9, 34, -95, 0, 9, 66, 21, 0, 37, 1, 117, 1, -107, 1, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, 2, -107, 7, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, 3, 37, 8, 117, 8, 9, 81, -107, 1, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, 2, 5, 1, 38, 0, 15, 117, 16, -107, 1, 9, 48, 53, 0, 70, 0, 0, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, 2, 9, 49, 70, 0, 0, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, 2, -64, 5, 13, 9, 84, -107, 1, 117, 8, 21, 0, 37, 8, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, 2, -64};
    public static final byte TOUCH_REPORT_ID = 1;

    public static String getDescription(byte b) {
        return b == 5 ? "StTouch" : "StCombo";
    }

    public static byte[] getDescriptor(byte b) {
        return b == 5 ? TOUCHPAD_DESCRIPTOR : COMBO_DESCRIPTOR;
    }

    public static String getName(byte b) {
        return b == 5 ? "StTouchDevice" : "StComboDevice";
    }

    public static String getProvider(byte b) {
        return b == 5 ? "StTouchPd" : "StComboPd";
    }
}
