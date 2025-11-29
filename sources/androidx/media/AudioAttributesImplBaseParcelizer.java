package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f1426a = versionedParcel.p(audioAttributesImplBase.f1426a, 1);
        audioAttributesImplBase.b = versionedParcel.p(audioAttributesImplBase.b, 2);
        audioAttributesImplBase.c = versionedParcel.p(audioAttributesImplBase.c, 3);
        audioAttributesImplBase.d = versionedParcel.p(audioAttributesImplBase.d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.F(audioAttributesImplBase.f1426a, 1);
        versionedParcel.F(audioAttributesImplBase.b, 2);
        versionedParcel.F(audioAttributesImplBase.c, 3);
        versionedParcel.F(audioAttributesImplBase.d, 4);
    }
}
