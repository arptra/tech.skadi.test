package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.here.posclient.PositionEstimate;

public final class MemorySizeCalculator {

    /* renamed from: a  reason: collision with root package name */
    public final int f2528a;
    public final int b;
    public final Context c;
    public final int d;

    public static final class Builder {
        public static final int i = 1;

        /* renamed from: a  reason: collision with root package name */
        public final Context f2529a;
        public ActivityManager b;
        public ScreenDimensions c;
        public float d = 2.0f;
        public float e = ((float) i);
        public float f = 0.4f;
        public float g = 0.33f;
        public int h = PositionEstimate.Value.WLAN_AP_TIMESTAMPS;

        public Builder(Context context) {
            this.f2529a = context;
            this.b = (ActivityManager) context.getSystemService("activity");
            this.c = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (MemorySizeCalculator.e(this.b)) {
                this.e = 0.0f;
            }
        }

        public MemorySizeCalculator a() {
            return new MemorySizeCalculator(this);
        }
    }

    public static final class DisplayMetricsScreenDimensions implements ScreenDimensions {

        /* renamed from: a  reason: collision with root package name */
        public final DisplayMetrics f2530a;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.f2530a = displayMetrics;
        }

        public int a() {
            return this.f2530a.heightPixels;
        }

        public int b() {
            return this.f2530a.widthPixels;
        }
    }

    public interface ScreenDimensions {
        int a();

        int b();
    }

    public MemorySizeCalculator(Builder builder) {
        this.c = builder.f2529a;
        int i = e(builder.b) ? builder.h / 2 : builder.h;
        this.d = i;
        int c2 = c(builder.b, builder.f, builder.g);
        float b2 = (float) (builder.c.b() * builder.c.a() * 4);
        int round = Math.round(builder.e * b2);
        int round2 = Math.round(b2 * builder.d);
        int i2 = c2 - i;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.b = round2;
            this.f2528a = round;
        } else {
            float f = (float) i2;
            float f2 = builder.e;
            float f3 = builder.d;
            float f4 = f / (f2 + f3);
            this.b = Math.round(f3 * f4);
            this.f2528a = Math.round(f4 * builder.e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.b));
            sb.append(", pool size: ");
            sb.append(f(this.f2528a));
            sb.append(", byte array size: ");
            sb.append(f(i));
            sb.append(", memory class limited? ");
            sb.append(i3 > c2);
            sb.append(", max size: ");
            sb.append(f(c2));
            sb.append(", memoryClass: ");
            sb.append(builder.b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(builder.b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    public static int c(ActivityManager activityManager, float f, float f2) {
        float memoryClass = (float) (activityManager.getMemoryClass() * PositionEstimate.Value.SITUATION);
        if (e(activityManager)) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    public static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.f2528a;
    }

    public int d() {
        return this.b;
    }

    public final String f(int i) {
        return Formatter.formatFileSize(this.c, (long) i);
    }
}
