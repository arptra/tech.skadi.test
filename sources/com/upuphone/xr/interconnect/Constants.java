package com.upuphone.xr.interconnect;

public final class Constants {
    public static final int CODE_ACQUIRE_P2P_FAIL = -4;
    public static final int CODE_ACQUIRE_P2P_NO_CONNECTOR = -2;
    public static final int CODE_ACQUIRE_P2P_NO_DEVICE = -1;
    public static final int CODE_ACQUIRE_P2P_SUCCESS = 0;
    public static final int CODE_ACQUIRE_P2P_TIMEOUT = -3;
    public static final int CODE_SEND_FILE_FAIL_NO_DEVICE = -1;
    public static final int CODE_SEND_FILE_FAIL_NO_SHARE_ABILITY = -5;
    public static final int CODE_SEND_FILE_FAIL_P2P_ERROR = -4;
    public static final int CODE_SEND_FILE_FAIL_P2P_TIMEOUT = -3;
    public static final int CODE_SEND_FILE_FAIL_PARAMS_ERROR = -2;
    public static final int CODE_SEND_FILE_FAIL_SHARE_ABILITY_ERROR = -6;
    public static final int CODE_SEND_MSG_FAIL_NO_DEVICE = -1;
    public static final int CODE_SEND_MSG_FAIL_NO_RELAY_ABILITY = -2;
    public static final int CODE_SEND_MSG_FAIL_RELAY_ERROR = -6;
    public static final int CODE_SEND_MSG_FAIL_UNKNOWN_ERROR = -7;
    public static final int CODE_SEND_MSG_FAIL_VERSION_NOT_SENT = -5;
    public static final int CODE_SEND_MSG_FAIL_VERSION_UNKNOWN = -3;
    public static final int CODE_SEND_MSG_FAIL_VERSION_UNSUPPORTED = -4;
    public static final int CODE_SEND_MSG_SUCCESS = 0;
    public static final String DATA_Characteristic = "0000fff6-0000-1000-8000-00805f9b34fb";
    public static final String DELIMITER = "&#*end*#&";
    public static final String DELIMITER_ESCAPE = "&#\\*end\\*#&";
    public static final int DEVICE_BR_EDR_BOND_STATE_BONDED = 48;
    public static final int DEVICE_BR_EDR_BOND_STATE_BONDING = 32;
    public static final int DEVICE_BR_EDR_BOND_STATE_NONE = 16;
    public static final String GLASS_DEVICE_ARI = "air";
    public static final String GLASS_DEVICE_ARI_INTL_MODEL_ID = "5001";
    public static final String GLASS_DEVICE_ARI_MODEL_ID = "1003";
    public static final String GLASS_DEVICE_ARI_PRO = "ari_pro";
    public static final String GLASS_DEVICE_ARI_PRO_INTL_MODEL_ID = "5002";
    public static final String GLASS_DEVICE_ARI_PRO_MODEL_ID = "1004";
    public static final String GLASS_DEVICE_CONCEPT = "concept";
    public static final String GLASS_DEVICE_STAR = "star";
    public static final String GLASS_DEVICE_STAR_CONCEPT_MODEL_ID = "1001";
    public static final String GLASS_DEVICE_STAR_MODEL_ID = "1002";
    public static final String LOG_PREFIX = "SAS@";
    public static final String NOTIY_Characteristic = "0000fff7-0000-1000-8000-00805f9b34fb";
    public static final long P2P_CONNECT_TIMEOUT_CHECK_DELAY = 15000;
    public static final String RECEIVE_PKG_INNER = "com.upuphone.xr.interconnect";
    public static final int RING_DEVICE_CONNECTED = 1;
    public static final String SERVICE_DATA = "0000fff0-0000-1000-8000-00805f9b34fb";
    public static final String SUPER_APP_PKG_NAME = "com.upuphone.star.launcher";

    private Constants() {
    }
}
