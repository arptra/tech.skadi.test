package com.google.mlkit.nl.languageid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_language_id_common.zze;
import com.google.android.gms.internal.mlkit_language_id_common.zzf;
import com.google.android.gms.internal.mlkit_language_id_common.zzg;
import java.util.Arrays;

@UsedByNative("language_id_jni.cc")
public final class IdentifiedLanguage {
    private final String zza;
    private final float zzb;

    @UsedByNative("language_id_jni.cc")
    @KeepForSdk
    public IdentifiedLanguage(@NonNull String str, float f) {
        this.zza = str;
        this.zzb = f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdentifiedLanguage)) {
            return false;
        }
        IdentifiedLanguage identifiedLanguage = (IdentifiedLanguage) obj;
        return Float.compare(identifiedLanguage.zzb, this.zzb) == 0 && zzg.zza(this.zza, identifiedLanguage.zza);
    }

    public float getConfidence() {
        return this.zzb;
    }

    @NonNull
    public String getLanguageTag() {
        return this.zza;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Float.valueOf(this.zzb)});
    }

    @NonNull
    public String toString() {
        zze zza2 = zzf.zza(this);
        zza2.zzb("languageTag", this.zza);
        zza2.zza("confidence", this.zzb);
        return zza2.toString();
    }
}
