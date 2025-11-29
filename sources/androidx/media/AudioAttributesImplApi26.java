package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImplApi21;

@RequiresApi
@RestrictTo
public class AudioAttributesImplApi26 extends AudioAttributesImplApi21 {

    public static class Builder extends AudioAttributesImplApi21.Builder {
        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi26(this.f1425a.build());
        }

        /* renamed from: e */
        public Builder d(int i) {
            this.f1425a.setUsage(i);
            return this;
        }
    }

    public AudioAttributesImplApi26() {
    }

    public AudioAttributesImplApi26(AudioAttributes audioAttributes) {
        super(audioAttributes, -1);
    }
}
