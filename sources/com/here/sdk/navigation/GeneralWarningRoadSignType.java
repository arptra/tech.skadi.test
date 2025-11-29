package com.here.sdk.navigation;

public enum GeneralWarningRoadSignType {
    UNKNOWN(0),
    OBJECT_OVERHANG(1),
    RISK_OF_GROUNDING(2),
    ANIMAL_CROSSING(3),
    ACCIDENT_HAZARD(4);
    
    public final int value;

    private GeneralWarningRoadSignType(int i) {
        this.value = i;
    }
}
