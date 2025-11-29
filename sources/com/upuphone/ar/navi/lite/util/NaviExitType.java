package com.upuphone.ar.navi.lite.util;

public enum NaviExitType {
    NONE(0),
    PHONE_MANUAL_EXIT(1),
    PHONE_NAVI_COMPLETE_EXIT(2),
    GLASS_MANUAL_EXIT(3),
    PHONE_ABNORMAL_EXIT(4),
    GLASS_ABNORMAL_EXIT(5);
    
    private int type;

    private NaviExitType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}
