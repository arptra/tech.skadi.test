package com.here.sdk.mapview;

public final class RenderSize {

    public enum Unit {
        PIXELS(0),
        DENSITY_INDEPENDENT_PIXELS(1),
        METERS(2);
        
        public final int value;

        private Unit(int i) {
            this.value = i;
        }
    }
}
