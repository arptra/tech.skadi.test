package com.here.sdk.navigation;

public enum DirectionInformationUsageOption {
    NONE(0),
    ROAD_INFORMATION_ONLY(1),
    ROAD_INFORMATION_AND_SIGNPOST_DIRECTION(2);
    
    public final int value;

    private DirectionInformationUsageOption(int i) {
        this.value = i;
    }
}
