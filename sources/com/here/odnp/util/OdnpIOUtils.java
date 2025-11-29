package com.here.odnp.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class OdnpIOUtils {
    private static final int BUFFER_LENGTH = 1024;
    private static final String TAG = "odnp.util.OdnpIOUtils";

    public static boolean close(Closeable closeable) {
        if (closeable == null) {
            return true;
        }
        try {
            closeable.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    public static boolean close(InputStream inputStream) {
        if (inputStream == null) {
            return true;
        }
        try {
            inputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean close(OutputStream outputStream) {
        if (outputStream == null) {
            return true;
        }
        try {
            outputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
