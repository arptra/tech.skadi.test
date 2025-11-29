package org.greenrobot.eventbus.android;

import android.util.Log;
import java.util.logging.Level;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.Logger;

public class AndroidLogger implements Logger {

    /* renamed from: a  reason: collision with root package name */
    public final String f3382a;

    public AndroidLogger(String str) {
        this.f3382a = str;
    }

    public void a(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(c(level), this.f3382a, str);
        }
    }

    public void b(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            int c = c(level);
            String str2 = this.f3382a;
            Log.println(c, str2, str + StringUtils.LF + Log.getStackTraceString(th));
        }
    }

    public final int c(Level level) {
        int intValue = level.intValue();
        if (intValue < 800) {
            return intValue < 500 ? 2 : 3;
        }
        if (intValue < 900) {
            return 4;
        }
        return intValue < 1000 ? 5 : 6;
    }
}
