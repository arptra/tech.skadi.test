package org.libpag;

import org.extra.tools.a;

public class PAGShapeLayer extends PAGLayer {
    static {
        a.e("pag");
        nativeInit();
    }

    public PAGShapeLayer(long j) {
        super(j);
    }

    private static native void nativeInit();
}
