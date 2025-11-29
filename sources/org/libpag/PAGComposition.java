package org.libpag;

import java.nio.ByteBuffer;
import org.extra.tools.a;

public class PAGComposition extends PAGLayer {
    static {
        a.e("pag");
        nativeInit();
    }

    public PAGComposition(long j) {
        super(j);
    }

    public static native PAGComposition Make(int i, int i2);

    private static native void nativeInit();

    public native void addLayer(PAGLayer pAGLayer);

    public native void addLayerAt(PAGLayer pAGLayer, int i);

    public native ByteBuffer audioBytes();

    public native PAGMarker[] audioMarkers();

    public native long audioStartTime();

    public native boolean contains(PAGLayer pAGLayer);

    public native PAGLayer getLayerAt(int i);

    public native int getLayerIndex(PAGLayer pAGLayer);

    public native PAGLayer[] getLayersByName(String str);

    public native PAGLayer[] getLayersUnderPoint(float f, float f2);

    public native int height();

    public native int numChildren();

    public native void removeAllLayers();

    public native PAGLayer removeLayer(PAGLayer pAGLayer);

    public native PAGLayer removeLayerAt(int i);

    public native void setContentSize(int i, int i2);

    public native void setLayerIndex(PAGLayer pAGLayer, int i);

    public native void swapLayer(PAGLayer pAGLayer, PAGLayer pAGLayer2);

    public native void swapLayerAt(int i, int i2);

    public native int width();
}
