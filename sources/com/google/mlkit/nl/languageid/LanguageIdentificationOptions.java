package com.google.mlkit.nl.languageid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executor;

public class LanguageIdentificationOptions {
    @NonNull
    public static final LanguageIdentificationOptions zza = new Builder().build();
    @Nullable
    private final Float zzb;
    @Nullable
    private final Executor zzc;

    public static class Builder {
        @Nullable
        private Float zza;
        @Nullable
        private Executor zzb;

        @NonNull
        public LanguageIdentificationOptions build() {
            return new LanguageIdentificationOptions(this.zza, this.zzb, (zza) null);
        }

        @NonNull
        public Builder setConfidenceThreshold(float f) {
            boolean z = false;
            if (f >= 0.0f && f <= 1.0f) {
                z = true;
            }
            Float valueOf = Float.valueOf(f);
            Preconditions.checkArgument(z, "Threshold value %f should be between 0 and 1", valueOf);
            this.zza = valueOf;
            return this;
        }

        @NonNull
        public Builder setExecutor(@NonNull Executor executor) {
            Preconditions.checkArgument(executor != null, "Custom executor should not be null");
            this.zzb = executor;
            return this;
        }
    }

    public /* synthetic */ LanguageIdentificationOptions(Float f, Executor executor, zza zza2) {
        this.zzb = f;
        this.zzc = executor;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LanguageIdentificationOptions)) {
            return false;
        }
        LanguageIdentificationOptions languageIdentificationOptions = (LanguageIdentificationOptions) obj;
        return Objects.equal(languageIdentificationOptions.zzb, this.zzb) && Objects.equal(languageIdentificationOptions.zzc, this.zzc);
    }

    @KeepForSdk
    @Nullable
    public Float getConfidenceThreshold() {
        return this.zzb;
    }

    @KeepForSdk
    @Nullable
    public Executor getExecutor() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, this.zzc);
    }
}
