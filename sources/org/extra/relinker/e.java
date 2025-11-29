package org.extra.relinker;

import android.os.Build;
import org.extra.relinker.c;

final class e implements c.b {
    public void a(String str) {
        System.loadLibrary(str);
    }

    public String b(String str) {
        return (!str.startsWith("lib") || !str.endsWith(".so")) ? System.mapLibraryName(str) : str;
    }

    public void c(String str) {
        System.load(str);
    }

    public String d(String str) {
        return str.substring(3, str.length() - 3);
    }

    public String[] a() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        if (!f.a(str)) {
            return new String[]{Build.CPU_ABI, str};
        }
        return new String[]{Build.CPU_ABI};
    }
}
