package androidx.media;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.media.AudioAttributesCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AudioFocusRequestCompat {
    public static final AudioAttributesCompat f = new AudioAttributesCompat.Builder().c(1).a();

    /* renamed from: a  reason: collision with root package name */
    public final int f1428a;
    public final AudioManager.OnAudioFocusChangeListener b;
    public final Handler c;
    public final AudioAttributesCompat d;
    public final boolean e;

    public static final class Builder {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusGainType {
    }

    public static class OnAudioFocusChangeListenerHandlerCompat implements Handler.Callback, AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f1429a;
        public final AudioManager.OnAudioFocusChangeListener b;

        public boolean handleMessage(Message message) {
            if (message.what != 2782386) {
                return false;
            }
            this.b.onAudioFocusChange(message.arg1);
            return true;
        }

        public void onAudioFocusChange(int i) {
            Handler handler = this.f1429a;
            handler.sendMessage(Message.obtain(handler, 2782386, i, 0));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AudioFocusRequestCompat audioFocusRequestCompat = (AudioFocusRequestCompat) obj;
        return this.f1428a == audioFocusRequestCompat.f1428a && this.e == audioFocusRequestCompat.e && ObjectsCompat.a(this.b, audioFocusRequestCompat.b) && ObjectsCompat.a(this.c, audioFocusRequestCompat.c) && ObjectsCompat.a(this.d, audioFocusRequestCompat.d);
    }

    public int hashCode() {
        return ObjectsCompat.b(Integer.valueOf(this.f1428a), this.b, this.c, this.d, Boolean.valueOf(this.e));
    }
}
