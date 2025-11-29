package org.libpag;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import org.extra.tools.a;

public class PAGDiskCache {
    static {
        a.e("pag");
    }

    private static String GetCacheDir() {
        Context a2 = a.a();
        if (a2 == null) {
            return "";
        }
        File externalCacheDir = ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? a2.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = a2.getCacheDir();
        }
        return externalCacheDir == null ? "" : externalCacheDir.getPath();
    }

    public static native long MaxDiskSize();

    public static native byte[] ReadFile(String str);

    public static native void RemoveAll();

    public static native void SetMaxDiskSize(long j);

    public static native boolean WriteFile(String str, byte[] bArr);
}
