package com.ucar.vehiclesdk.player;

import android.content.Context;
import android.media.AudioManager;
import com.easy.logger.EasyLog;

public class MediaSessionProvider {

    /* renamed from: a  reason: collision with root package name */
    public final String f5470a;
    public int b;
    public int c;
    public Context d;

    public static class MediaSessionProviderHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final MediaSessionProvider f5471a = new MediaSessionProvider();
    }

    public static int c() {
        return e().a();
    }

    public static int d() {
        return e().b();
    }

    public static MediaSessionProvider e() {
        return f((Context) null);
    }

    public static MediaSessionProvider f(Context context) {
        MediaSessionProvider a2 = MediaSessionProviderHolder.f5471a;
        if (a2.d == null) {
            a2.d = context;
        }
        return a2;
    }

    public final synchronized int a() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        AudioManager audioManager = (AudioManager) this.d.getSystemService("audio");
        if (audioManager != null) {
            this.c = audioManager.generateAudioSessionId();
            EasyLog.e("MediaSessionProvider", "ai session id is " + this.c);
            return this.c;
        }
        throw new UnsupportedOperationException("can't get audio service");
    }

    public final synchronized int b() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        AudioManager audioManager = (AudioManager) this.d.getSystemService("audio");
        if (audioManager != null) {
            this.b = audioManager.generateAudioSessionId();
            EasyLog.e("MediaSessionProvider", "call session id is " + this.b);
            return this.b;
        }
        throw new UnsupportedOperationException("can't get audio service");
    }

    public MediaSessionProvider() {
        this.f5470a = "MediaSessionProvider";
        this.b = 0;
        this.c = 0;
    }
}
