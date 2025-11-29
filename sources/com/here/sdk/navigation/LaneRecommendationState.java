package com.here.sdk.navigation;

public enum LaneRecommendationState {
    NOT_RECOMMENDED(0),
    RECOMMENDED(1),
    HIGHLY_RECOMMENDED(2);
    
    public final int value;

    private LaneRecommendationState(int i) {
        this.value = i;
    }
}
