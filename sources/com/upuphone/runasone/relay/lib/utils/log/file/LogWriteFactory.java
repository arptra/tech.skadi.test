package com.upuphone.runasone.relay.lib.utils.log.file;

import android.content.Context;

public final class LogWriteFactory {
    public static final int FILE_WRITE = 1;
    public static final int MMAP_WRITE = 2;

    private LogWriteFactory() {
    }

    public static ILogWrite getInstance(Context context, int i) {
        if (1 == i) {
            return new FileWrite(context);
        }
        if (2 == i) {
            return new MapBufferWirte(context);
        }
        return null;
    }
}
