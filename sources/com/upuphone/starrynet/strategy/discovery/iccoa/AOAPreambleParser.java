package com.upuphone.starrynet.strategy.discovery.iccoa;

import com.meizu.common.widget.MzContactsContract;

public class AOAPreambleParser {
    private static final int AOA_PREAMBLE_INDEX_CAR_ID = 0;
    private static final int AOA_PREAMBLE_INDEX_CAR_MODEL_ID = 1;
    private static final int AOA_PREAMBLE_INDEX_CAR_NAME = 2;
    private static final int AOA_PREAMBLE_INDEX_CAR_PIN = 3;
    private static final int AOA_PREAMBLE_INDEX_PROTO_VER = 4;
    private static final int AOA_PREAMBLE_INDEX_VENDOR_DATA = 5;
    private static final int AOA_PREAMBLE_PART_NUM = 6;
    private static final int CAR_PID_LENGTH = 4;
    private static final int CAR_VID_LENGTH = 4;
    private static String[] sRaw;

    public static String getCarId() {
        return sRaw[0];
    }

    public static String getCarName() {
        return sRaw[2];
    }

    public static String getPid() {
        return sRaw[1].substring(4, 8);
    }

    public static String getPinCode() {
        return sRaw[3];
    }

    public static String getVendorData() {
        return sRaw[5];
    }

    public static String getVersion() {
        return sRaw[4];
    }

    public static String getVid() {
        return sRaw[1].substring(0, 4);
    }

    public static boolean init(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
        sRaw = split;
        if (split.length >= 6) {
            return true;
        }
        sRaw = null;
        return false;
    }
}
