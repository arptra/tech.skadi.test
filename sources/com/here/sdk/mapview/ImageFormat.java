package com.here.sdk.mapview;

public enum ImageFormat {
    PNG(0),
    SVG(1);
    
    public final int value;

    private ImageFormat(int i) {
        this.value = i;
    }
}
