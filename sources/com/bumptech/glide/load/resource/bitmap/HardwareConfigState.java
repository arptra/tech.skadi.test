package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.bumptech.glide.util.Util;
import com.meizu.net.pedometerprovider.manager.PedoManager;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public final class HardwareConfigState {
    public static final boolean e = false;
    public static final boolean f = true;
    public static final File g = new File("/proc/self/fd");
    public static volatile HardwareConfigState h;

    /* renamed from: a  reason: collision with root package name */
    public final int f2626a = PedoManager.HOUR_MAX_STEP;
    public int b;
    public boolean c = true;
    public final AtomicBoolean d = new AtomicBoolean(false);

    public static HardwareConfigState b() {
        if (h == null) {
            synchronized (HardwareConfigState.class) {
                try {
                    if (h == null) {
                        h = new HardwareConfigState();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return h;
    }

    public static boolean e() {
        return false;
    }

    public final boolean a() {
        return e && !this.d.get();
    }

    public final int c() {
        if (e()) {
            return 500;
        }
        return this.f2626a;
    }

    public final synchronized boolean d() {
        try {
            boolean z = true;
            int i = this.b + 1;
            this.b = i;
            if (i >= 50) {
                this.b = 0;
                int length = g.list().length;
                long c2 = (long) c();
                if (((long) length) >= c2) {
                    z = false;
                }
                this.c = z;
                if (!z && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + c2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c;
    }

    public boolean f(int i, int i2, boolean z, boolean z2) {
        if (!z) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        } else if (!f) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        } else if (a()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        } else if (z2) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        } else if (i < 0 || i2 < 0) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
            }
            return false;
        } else if (d()) {
            return true;
        } else {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
            }
            return false;
        }
    }

    public boolean g(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean f2 = f(i, i2, z, z2);
        if (f2) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return f2;
    }

    public void h() {
        Util.b();
        this.d.set(true);
    }
}
