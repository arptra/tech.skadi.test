package org.libpag;

import org.extra.tools.a;

class NativeTask {
    static {
        a.e("pag");
    }

    public static native void Run(Runnable runnable);
}
