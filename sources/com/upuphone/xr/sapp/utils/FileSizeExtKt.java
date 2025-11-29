package com.upuphone.xr.sapp.utils;

import kotlin.Metadata;
import org.apache.commons.io.FileUtils;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "size", "", "a", "(J)Ljava/lang/String;", "lib_common_release"}, k = 2, mv = {1, 9, 0})
public final class FileSizeExtKt {
    public static final String a(long j) {
        if (j > 1072668082176L) {
            String d = MathExtKt.d(MathExtKt.b(Double.valueOf(((double) j) / ((double) FileUtils.ONE_TB))));
            return d + "TB";
        } else if (j > 1047527424) {
            String d2 = MathExtKt.d(MathExtKt.b(Double.valueOf(((double) j) / ((double) FileUtils.ONE_GB))));
            return d2 + "GB";
        } else if (j >= 1048576) {
            double d3 = ((double) j) / ((double) 1048576);
            if (d3 > 100.0d) {
                String d4 = MathExtKt.d(MathExtKt.c(Double.valueOf(d3)));
                return d4 + "MB";
            }
            String d5 = MathExtKt.d(MathExtKt.a(Double.valueOf(d3)));
            return d5 + "MB";
        } else if (j > 1022976) {
            String d6 = MathExtKt.d(MathExtKt.b(Double.valueOf(((double) j) / ((double) 1048576))));
            return d6 + "MB";
        } else if (j >= 1024) {
            String d7 = MathExtKt.d(MathExtKt.c(Double.valueOf(((double) j) / ((double) 1024))));
            return d7 + "KB";
        } else if (j > 999) {
            String d8 = MathExtKt.d(MathExtKt.b(Double.valueOf(((double) j) / ((double) 1024))));
            return d8 + "KB";
        } else if (((int) j) == 0) {
            return "0KB";
        } else {
            return j + "B";
        }
    }
}
