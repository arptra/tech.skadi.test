package com.luck.picture.lib.app;

import android.content.Context;
import com.luck.picture.lib.engine.PictureSelectorEngine;

public class PictureAppMaster implements IApp {
    public static PictureAppMaster b;

    /* renamed from: a  reason: collision with root package name */
    public IApp f9379a;

    public static PictureAppMaster c() {
        if (b == null) {
            synchronized (PictureAppMaster.class) {
                try {
                    if (b == null) {
                        b = new PictureAppMaster();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public PictureSelectorEngine a() {
        IApp iApp = this.f9379a;
        if (iApp == null) {
            return null;
        }
        return iApp.a();
    }

    public Context b() {
        IApp iApp = this.f9379a;
        if (iApp == null) {
            return null;
        }
        return iApp.b();
    }
}
