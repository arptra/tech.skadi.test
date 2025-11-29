package com.here.sdk.venue.data;

enum GeometryShapeType {
    POINT(0),
    PATH(1),
    ROTRECT(2);
    
    final int value;

    private GeometryShapeType(int i) {
        this.value = i;
    }
}
