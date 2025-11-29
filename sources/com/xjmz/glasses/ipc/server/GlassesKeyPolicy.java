package com.xjmz.glasses.ipc.server;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import com.xjmz.openxr.usb.hid.HidManager;

public class GlassesKeyPolicy {
    public static final String c = "GlassesKeyPolicy";

    /* renamed from: a  reason: collision with root package name */
    public final AudioManager f8209a;
    public final HidManager b;

    public GlassesKeyPolicy(Context context, HidManager hidManager) {
        this.f8209a = (AudioManager) context.getSystemService("audio");
        this.b = hidManager;
    }

    public boolean a(int i, int i2) {
        if (i == 3 && i2 == 3) {
            if (!b()) {
                this.b.I(2);
            } else if (c()) {
                this.b.I(2);
                return false;
            } else {
                this.b.I(3);
            }
        }
        return true;
    }

    public final boolean b() {
        return this.b.m() == 2;
    }

    public final boolean c() {
        int mode = this.f8209a.getMode();
        String str = c;
        Log.i(str, "current audio mode: " + mode);
        return mode == 2 || mode == 1;
    }
}
