package com.upuphone.ai.ttsengine.base.player;

import android.app.Application;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import com.honey.account.n3.a;
import com.honey.account.n3.b;
import com.honey.account.n3.c;
import com.upuphone.ai.ttsengine.base.helper.TtsPlayListener;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.base.utils.PackageUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0012R\u001c\u0010\u001a\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/player/Mp3Player;", "Lcom/upuphone/ai/ttsengine/base/player/AbstractPlayer;", "Landroid/app/Application;", "context", "", "callingType", "", "disableBt", "<init>", "(Landroid/app/Application;IZ)V", "", "g", "(Landroid/app/Application;)V", "", "filePath", "w", "(Ljava/lang/String;)V", "o", "()V", "k", "i", "p", "j", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "Landroid/media/MediaPlayer;", "Landroid/media/MediaPlayer;", "mediaPlayer", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class Mp3Player extends AbstractPlayer {
    public final AILOG i = AILOG.a("Mp3Player");
    public MediaPlayer j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Mp3Player(Application application, int i2, boolean z) {
        super(i2, z);
        Intrinsics.checkNotNullParameter(application, "context");
        g(application);
    }

    public static final void t(Mp3Player mp3Player, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(mp3Player, "this$0");
        mp3Player.i.c("really started", new Object[0]);
    }

    public static final void u(Mp3Player mp3Player, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(mp3Player, "this$0");
        mp3Player.i.c("play completed", new Object[0]);
        mp3Player.p();
        TtsPlayListener e = mp3Player.e();
        if (e != null) {
            e.a();
        }
    }

    public static final boolean v(Mp3Player mp3Player, MediaPlayer mediaPlayer, int i2, int i3) {
        Intrinsics.checkNotNullParameter(mp3Player, "this$0");
        AILOG ailog = mp3Player.i;
        ailog.h("play error what: " + i2 + ", extra: " + i3, new Object[0]);
        mp3Player.p();
        mp3Player.j();
        TtsPlayListener e = mp3Player.e();
        if (e == null) {
            return true;
        }
        e.e();
        return true;
    }

    public void g(Application application) {
        AudioDeviceInfo[] devices;
        AudioDeviceInfo audioDeviceInfo;
        Intrinsics.checkNotNullParameter(application, "context");
        super.g(application);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.j = mediaPlayer;
        mediaPlayer.setAudioAttributes(a());
        MediaPlayer mediaPlayer2 = this.j;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setOnPreparedListener(new a(this));
        }
        MediaPlayer mediaPlayer3 = this.j;
        if (mediaPlayer3 != null) {
            mediaPlayer3.setOnCompletionListener(new b(this));
        }
        MediaPlayer mediaPlayer4 = this.j;
        if (mediaPlayer4 != null) {
            mediaPlayer4.setOnErrorListener(new c(this));
        }
        if (!PackageUtils.b(application) && !d()) {
            AudioManager c = c();
            Unit unit = null;
            if (!(c == null || (devices = c.getDevices(2)) == null)) {
                int length = devices.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        audioDeviceInfo = null;
                        break;
                    }
                    audioDeviceInfo = devices[i2];
                    int type = audioDeviceInfo.getType();
                    AudioManager c2 = c();
                    if (type == ((c2 == null || !c2.isBluetoothScoOn()) ? 8 : 7)) {
                        break;
                    }
                    i2++;
                }
                if (audioDeviceInfo != null) {
                    MediaPlayer mediaPlayer5 = this.j;
                    if (mediaPlayer5 != null) {
                        mediaPlayer5.setPreferredDevice(audioDeviceInfo);
                    }
                    this.i.c("set preferred device: " + audioDeviceInfo.getProductName(), new Object[0]);
                    unit = Unit.INSTANCE;
                }
            }
            if (unit == null) {
                this.i.h("Didn't find a2dp or sco device", new Object[0]);
            }
        }
    }

    public void i() {
        this.i.c("pause", new Object[0]);
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
        TtsPlayListener e = e();
        if (e != null) {
            e.b();
        }
    }

    public void j() {
        this.i.c("release", new Object[0]);
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.j = null;
    }

    public void k() {
        this.i.c("resume", new Object[0]);
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        TtsPlayListener e = e();
        if (e != null) {
            e.c();
        }
    }

    public void o() {
        AILOG ailog = this.i;
        MediaPlayer mediaPlayer = this.j;
        ailog.c("start: " + mediaPlayer, new Object[0]);
        super.o();
        MediaPlayer mediaPlayer2 = this.j;
        if (mediaPlayer2 != null) {
            mediaPlayer2.prepare();
        }
        MediaPlayer mediaPlayer3 = this.j;
        if (mediaPlayer3 != null) {
            mediaPlayer3.start();
        }
        TtsPlayListener e = e();
        if (e != null) {
            e.d();
        }
    }

    public void p() {
        this.i.c("stop", new Object[0]);
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public final void w(String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.setDataSource(str);
        }
    }
}
