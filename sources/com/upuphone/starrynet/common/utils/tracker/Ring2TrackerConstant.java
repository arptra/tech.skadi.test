package com.upuphone.starrynet.common.utils.tracker;

public class Ring2TrackerConstant {
    public static final String EVENT_NAME_RING2_MATCH_FAIL = "starrynet_ring2_match_fail";
    public static final int MSG_BT_OFF = 1101;
    public static final int MSG_CHECK_BLE_ACL_TIMEOUT = 1006;
    public static final int MSG_CHECK_BLE_BOND_TIMEOUT = 1008;
    public static final int MSG_CHECK_BLE_HID_TIMEOUT = 1010;
    public static final int MSG_CHECK_BLE_SERVICE_READY_TIMEOUT = 1007;
    public static final int MSG_CHECK_STARRY_BOND_TIMEOUT = 1011;
    public static final int MSG_CONNECT_TIMEOUT = 1100;
    public static final int MSG_PAIR_STATE_AUTH_FAIL = 1009;
    public static final int MSG_RING_EVENT_HANDLER = 1102;
    public static final int MSG_STATE_ACL_DISCONNECTED = 1001;
    public static final int MSG_STATE_AUTH_FAIL = 2;
    public static final int MSG_STATE_AUTH_SUCCESS = 1;
    public static final int MSG_STATE_BT_STATE_CHANGE_OFF = 1003;
    public static final int MSG_STATE_CONNECT_SUCCESS = 0;
    public static final int MSG_STATE_HID_HOST_DISCONNECTED = 1002;
    public static final int MSG_STATE_STATE_GATT_FAIL = 1004;
    public static final int MSG_STATE_STATE_UN_BOND = 1005;
    public static final String SAVE_IOT_DEVICE_ID = "save_iot_device_id";
    public static final String SAVE_IOT_DEVICE_MODEL = "save_iot_device_model";
    public static final String SAVE_IOT_DEVICE_ROM = "save_iot_device_rom";
    public static final int WAY_BY_EXCEPTION = 5;
    public static final int WAY_BY_OTHER = 3;
    public static final int WAY_BY_PHONE = 1;
    public static final int WAY_BY_RING2 = 0;
    public static final int WAY_BY_RING2_OFFLINE = 2;
    public static final int WAY_BY_SETTINGS_OFFLINE = 4;

    public enum EnumConnectState {
        MSG_STATE_ACL_DISCONNECTED(1001, "MSG_STATE_ACL_DISCONNECTED"),
        MSG_STATE_HID_HOST_DISCONNECTED(1002, "MSG_STATE_HID_HOST_DISCONNECTED"),
        MSG_STATE_BT_STATE_CHANGE_OFF(1003, "MSG_STATE_BT_STATE_CHANGE_OFF"),
        MSG_STATE_STATE_GATT_FAIL(1004, "MSG_STATE_STATE_GATT_FAIL"),
        MSG_STATE_STATE_UN_BOND(1005, "MSG_STATE_STATE_UN_BOND"),
        MSG_CHECK_BLE_ACL_TIMEOUT(1006, "MSG_CHECK_BLE_ACL_TIMEOUT"),
        MSG_CHECK_BLE_SERVICE_READY_TIMEOUT(1007, "MSG_CHECK_BLE_SERVICE_READY_TIMEOUT"),
        MSG_CHECK_BLE_BOND_TIMEOUT(1008, "MSG_CHECK_BLE_BOND_TIMEOUT"),
        MSG_PAIR_STATE_AUTH_FAIL(1009, "MSG_PAIR_STATE_AUTH_FAIL"),
        MSG_CHECK_BLE_HID_TIMEOUT(1010, "MSG_CHECK_BLE_HID_TIMEOUT"),
        MSG_CHECK_STARRY_BOND_TIMEOUT(1011, "MSG_CHECK_STARRY_BOND_TIMEOUT"),
        MSG_CONNECT_TIMEOUT(Ring2TrackerConstant.MSG_CONNECT_TIMEOUT, "MSG_CONNECT_TIMEOUT"),
        MSG_BT_OFF(Ring2TrackerConstant.MSG_BT_OFF, "MSG_BT_OFF"),
        MSG_RING_EVENT_HANDLER(Ring2TrackerConstant.MSG_RING_EVENT_HANDLER, "MSG_RING_EVENT_HANDLER");
        
        public String msg;
        public int msgCode;

        private EnumConnectState(int i, String str) {
            this.msgCode = i;
            this.msg = str;
        }

        public static EnumConnectState fromCode(int i) {
            for (EnumConnectState enumConnectState : values()) {
                if (enumConnectState.msgCode == i) {
                    return enumConnectState;
                }
            }
            return null;
        }
    }
}
