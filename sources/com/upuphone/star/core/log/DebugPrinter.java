package com.upuphone.star.core.log;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/star/core/log/DebugPrinter;", "Lcom/upuphone/star/core/log/Printer;", "<init>", "()V", "", "priority", "", "tag", "message", "", "j", "(ILjava/lang/String;Ljava/lang/String;)V", "", "i", "(Ljava/lang/String;I)Z", "logger_release"}, k = 1, mv = {1, 7, 1})
public class DebugPrinter extends Printer {
    public boolean i(String str, int i) {
        return true;
    }

    public void j(int i, String str, String str2) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(str2, "message");
        if (str2.length() >= 4000) {
            int length = str2.length();
            int i2 = 0;
            while (i2 < length) {
                int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, 10, i2, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    indexOf$default = length;
                }
                while (true) {
                    coerceAtMost = RangesKt.coerceAtMost(indexOf$default, i2 + 4000);
                    String substring = str2.substring(i2, coerceAtMost);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    if (i == 7) {
                        Log.wtf(str, substring);
                    } else {
                        Log.println(i, str, substring);
                    }
                    if (coerceAtMost >= indexOf$default) {
                        break;
                    }
                    i2 = coerceAtMost;
                }
                i2 = coerceAtMost + 1;
            }
        } else if (i == 7) {
            Log.wtf(str, str2);
        } else {
            Log.println(i, str, str2);
        }
    }
}
