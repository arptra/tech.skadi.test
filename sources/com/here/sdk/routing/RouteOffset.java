package com.here.sdk.routing;

public final class RouteOffset {
    public double offsetInMeters;
    public int sectionIndex;

    public RouteOffset(int i, double d) {
        this.sectionIndex = i;
        this.offsetInMeters = d;
    }
}
