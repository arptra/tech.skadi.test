package com.upuphone.ar.navi.lite.map;

import android.graphics.Paint;
import java.util.Arrays;

public class ImageOverlay extends Overlay implements IOverlay {
    public byte[] l;
    public Paint m;

    public String toString() {
        return "{" + "\"resource\":" + Arrays.toString(this.l) + ",\"paint\":" + this.m + '}';
    }
}
