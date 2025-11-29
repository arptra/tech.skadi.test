package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;

@RequiresApi
@RestrictTo
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributes f1424a;
    public int b;

    public static class Builder implements AudioAttributesImpl.Builder {

        /* renamed from: a  reason: collision with root package name */
        public final AudioAttributes.Builder f1425a = new AudioAttributes.Builder();

        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi21(this.f1425a.build());
        }

        /* renamed from: c */
        public Builder b(int i) {
            this.f1425a.setLegacyStreamType(i);
            return this;
        }

        /* renamed from: d */
        public Builder a(int i) {
            if (i == 16) {
                i = 12;
            }
            this.f1425a.setUsage(i);
            return this;
        }
    }

    public AudioAttributesImplApi21() {
        this.b = -1;
    }

    public int a() {
        int i = this.b;
        return i != -1 ? i : AudioAttributesCompat.b(false, b(), c());
    }

    public int b() {
        return this.f1424a.getFlags();
    }

    public int c() {
        return this.f1424a.getUsage();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f1424a.equals(((AudioAttributesImplApi21) obj).f1424a);
    }

    public int hashCode() {
        return this.f1424a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f1424a;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes, int i) {
        this.f1424a = audioAttributes;
        this.b = i;
    }
}
