package com.upuphone.ai.ttsengine.base.player;

import android.app.Application;
import android.media.AudioAttributes;
import android.media.AudioManager;
import com.upuphone.ai.ttsengine.base.helper.TtsPlayListener;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.base.utils.PackageUtils;
import com.upuphone.ai.ttsengine.base.utils.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 22\u00020\u0001:\u00018B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH&¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\nH&¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\nH&¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\nH&¢\u0006\u0004\b\u0015\u0010\u000eJ\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u00048\u0004X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010\t\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\fR$\u0010*\u001a\u0004\u0018\u00010$8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b\u001d\u0010'\"\u0004\b(\u0010)R$\u00101\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b%\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u00104R\u0014\u00107\u001a\u00020\u00028DX\u0004¢\u0006\u0006\u001a\u0004\b,\u00106¨\u00069"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/player/AbstractPlayer;", "", "", "callingType", "", "disableBt", "<init>", "(IZ)V", "Landroid/app/Application;", "context", "", "g", "(Landroid/app/Application;)V", "o", "()V", "Landroid/media/AudioAttributes;", "a", "()Landroid/media/AudioAttributes;", "k", "i", "p", "j", "b", "I", "Z", "d", "()Z", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "c", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "Landroid/media/AudioManager;", "e", "Landroid/media/AudioManager;", "()Landroid/media/AudioManager;", "l", "(Landroid/media/AudioManager;)V", "audioManager", "Lcom/upuphone/ai/ttsengine/base/helper/TtsPlayListener;", "f", "Lcom/upuphone/ai/ttsengine/base/helper/TtsPlayListener;", "()Lcom/upuphone/ai/ttsengine/base/helper/TtsPlayListener;", "m", "(Lcom/upuphone/ai/ttsengine/base/helper/TtsPlayListener;)V", "playListener", "h", "n", "(Z)V", "isPlaying", "()I", "playerTypeBySco", "Companion", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class AbstractPlayer {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f5509a;
    public final boolean b;
    public final AILOG c = AILOG.a("AbstractPlayer");
    public Application d;
    public AudioManager e;
    public TtsPlayListener f;
    public volatile boolean g;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/player/AbstractPlayer$Companion;", "", "()V", "TYPE_NORMAL", "", "TYPE_SCO", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public AbstractPlayer(int i, boolean z) {
        this.f5509a = i;
        this.b = z;
    }

    public final AudioAttributes a() {
        String a2 = PackageUtils.a(this.d, "XR_CHANNEL");
        if (Intrinsics.areEqual((Object) a2, (Object) "music") && f() == 0) {
            a2 = "sco";
        }
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        if (Intrinsics.areEqual((Object) a2, (Object) "sco")) {
            builder.setLegacyStreamType(3);
            builder.setUsage(2);
            builder.setContentType(2);
        } else {
            int i = this.f5509a;
            if (i == 1 || i == 4 || i == 2) {
                builder.setLegacyStreamType(3);
                builder.setUsage(2);
                builder.setContentType(4);
            } else if (i == 3) {
                builder.setLegacyStreamType(3);
                builder.setUsage(2);
                builder.setContentType(1);
            } else if (Intrinsics.areEqual((Object) a2, (Object) "music")) {
                builder.setLegacyStreamType(3);
                builder.setUsage(0);
                builder.setContentType(2);
            } else {
                builder.setLegacyStreamType(9);
                builder.setUsage(0);
                builder.setContentType(4);
            }
        }
        AudioAttributes build = builder.build();
        AILOG ailog = this.c;
        int f2 = f();
        int i2 = this.f5509a;
        ailog.c("deviceType=" + a2 + ", isScoOn: " + f2 + ", callingType: " + i2 + ", attribute: " + build, new Object[0]);
        Intrinsics.checkNotNullExpressionValue(build, "apply(...)");
        return build;
    }

    public final void b() {
        AudioManager audioManager;
        AudioManager audioManager2 = this.e;
        boolean z = audioManager2 != null && audioManager2.isStreamMute(3);
        AILOG ailog = this.c;
        int i = this.f5509a;
        AudioManager audioManager3 = this.e;
        Integer num = null;
        Integer valueOf = audioManager3 != null ? Integer.valueOf(audioManager3.getMode()) : null;
        AudioManager audioManager4 = this.e;
        Boolean valueOf2 = audioManager4 != null ? Boolean.valueOf(audioManager4.isSpeakerphoneOn()) : null;
        ailog.c("is music stream mute: " + z + ", calling type: " + i + ", mode:  " + valueOf + ", isSpeakerOn: " + valueOf2, new Object[0]);
        AILOG ailog2 = this.c;
        AudioManager audioManager5 = this.e;
        if (audioManager5 != null) {
            num = Integer.valueOf(audioManager5.getStreamVolume(3));
        }
        ailog2.c("music volume: " + num, new Object[0]);
        if (f() == 1) {
            if (!z && this.f5509a != 1) {
                if (SystemUtils.f5531a.b()) {
                    AudioManager audioManager6 = this.e;
                    if (audioManager6 != null && audioManager6.getMode() == 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.c.c("Un mute music stream for tts", new Object[0]);
            AudioManager audioManager7 = this.e;
            if (audioManager7 != null) {
                audioManager7.adjustStreamVolume(3, 100, 0);
            }
            if (!this.b) {
                SystemUtils systemUtils = SystemUtils.f5531a;
                if (!systemUtils.c() && !systemUtils.e() && (audioManager = this.e) != null) {
                    audioManager.setMode(0);
                }
            }
        }
    }

    public final AudioManager c() {
        return this.e;
    }

    public final boolean d() {
        return this.b;
    }

    public final TtsPlayListener e() {
        return this.f;
    }

    public final int f() {
        if (PackageUtils.b(this.d)) {
            return 1;
        }
        AudioManager audioManager = this.e;
        return (audioManager != null ? audioManager.isBluetoothScoOn() : false) ^ true ? 1 : 0;
    }

    public void g(Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.d = application;
        Object systemService = application.getSystemService("audio");
        this.e = systemService instanceof AudioManager ? (AudioManager) systemService : null;
    }

    public final boolean h() {
        return this.g;
    }

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public final void l(AudioManager audioManager) {
        this.e = audioManager;
    }

    public final void m(TtsPlayListener ttsPlayListener) {
        this.f = ttsPlayListener;
    }

    public final void n(boolean z) {
        this.g = z;
    }

    public void o() {
        b();
    }

    public abstract void p();
}
