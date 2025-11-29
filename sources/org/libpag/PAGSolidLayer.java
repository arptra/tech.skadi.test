package org.libpag;

import org.extra.tools.a;

public class PAGSolidLayer extends PAGLayer {
    static {
        a.e("pag");
        nativeInit();
    }

    public PAGSolidLayer(long j) {
        super(j);
    }

    private static native void nativeInit();

    public native void setSolidColor(int i);

    public native int solidColor();
}
