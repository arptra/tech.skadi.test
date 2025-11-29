package com.google.mlkit.nl.languageid.internal;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_language_id_common.zzhm;
import com.google.android.gms.internal.mlkit_language_id_common.zzhs;
import com.google.android.gms.internal.mlkit_language_id_common.zzhu;
import com.google.android.gms.internal.mlkit_language_id_common.zzhw;
import com.google.android.gms.internal.mlkit_language_id_common.zzhx;
import com.google.android.gms.internal.mlkit_language_id_common.zzhy;
import com.google.android.gms.internal.mlkit_language_id_common.zzhz;
import com.google.android.gms.internal.mlkit_language_id_common.zziu;
import com.google.android.gms.internal.mlkit_language_id_common.zziv;
import com.google.android.gms.internal.mlkit_language_id_common.zziy;
import com.google.android.gms.internal.mlkit_language_id_common.zzja;
import com.google.android.gms.internal.mlkit_language_id_common.zzjb;
import com.google.android.gms.internal.mlkit_language_id_common.zzjd;
import com.google.android.gms.internal.mlkit_language_id_common.zzla;
import com.google.android.gms.internal.mlkit_language_id_common.zzli;
import com.google.android.gms.internal.mlkit_language_id_common.zzlk;
import com.google.android.gms.internal.mlkit_language_id_common.zzll;
import com.google.android.gms.internal.mlkit_language_id_common.zzlt;
import com.google.android.gms.internal.mlkit_language_id_common.zzr;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.nl.languageid.IdentifiedLanguage;
import com.google.mlkit.nl.languageid.LanguageIdentificationOptions;
import com.google.mlkit.nl.languageid.LanguageIdentifier;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class LanguageIdentifierImpl implements LanguageIdentifier {
    private final LanguageIdentificationOptions zza;
    private final zzli zzb;
    private final zzlk zzc;
    private final Executor zzd;
    private final AtomicReference zze;
    private final CancellationTokenSource zzf = new CancellationTokenSource();
    private final zzhw zzg;

    @KeepForSdk
    public static final class Factory {
        private final zzli zza;
        private final zzg zzb;
        private final ExecutorSelector zzc;

        public Factory(zzg zzg, ExecutorSelector executorSelector) {
            this.zzb = zzg;
            this.zzc = executorSelector;
            this.zza = zzlt.zzb(true != zzg.zzf() ? "play-services-mlkit-language-id" : "language-id");
        }

        @NonNull
        @KeepForSdk
        public LanguageIdentifier create(@NonNull LanguageIdentificationOptions languageIdentificationOptions) {
            this.zzb.zze(languageIdentificationOptions);
            return LanguageIdentifierImpl.zza(languageIdentificationOptions, this.zzb, this.zza, this.zzc);
        }
    }

    private LanguageIdentifierImpl(LanguageIdentificationOptions languageIdentificationOptions, zzg zzg2, zzli zzli, Executor executor) {
        this.zza = languageIdentificationOptions;
        this.zzb = zzli;
        this.zzd = executor;
        this.zze = new AtomicReference(zzg2);
        this.zzg = zzg2.zzf() ? zzhw.TYPE_THICK : zzhw.TYPE_THIN;
        this.zzc = zzlk.zza(MlKitContext.getInstance().getApplicationContext());
    }

    @VisibleForTesting
    public static LanguageIdentifier zza(LanguageIdentificationOptions languageIdentificationOptions, zzg zzg2, zzli zzli, ExecutorSelector executorSelector) {
        LanguageIdentifierImpl languageIdentifierImpl = new LanguageIdentifierImpl(languageIdentificationOptions, zzg2, zzli, executorSelector.getExecutorToUse(languageIdentificationOptions.getExecutor()));
        zzli zzli2 = languageIdentifierImpl.zzb;
        zzhz zzhz = new zzhz();
        zzhz.zzc(languageIdentifierImpl.zzg);
        zziu zziu = new zziu();
        zziu.zzf(zzf(languageIdentifierImpl.zza.getConfidenceThreshold()));
        zzhz.zze(zziu.zzi());
        zzli2.zzc(zzll.zzg(zzhz, 1), zzhy.ON_DEVICE_LANGUAGE_IDENTIFICATION_CREATE);
        ((zzg) languageIdentifierImpl.zze.get()).pin();
        return languageIdentifierImpl;
    }

    private final void zze(long j, boolean z, @Nullable zzjd zzjd, @Nullable zzja zzja, zzhx zzhx) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zzb.zze(new zzf(this, elapsedRealtime, z, zzhx, zzjd, zzja), zzhy.ON_DEVICE_LANGUAGE_IDENTIFICATION_DETECT);
        long currentTimeMillis = System.currentTimeMillis();
        this.zzc.zzc(this.zzg == zzhw.TYPE_THICK ? 24603 : 24602, zzhx.zza(), currentTimeMillis - elapsedRealtime, currentTimeMillis);
    }

    private static final zzhu zzf(@Nullable Float f) {
        zzhs zzhs = new zzhs();
        zzhs.zza(Float.valueOf(f == null ? -1.0f : f.floatValue()));
        return zzhs.zzb();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void close() {
        zzg zzg2 = (zzg) this.zze.getAndSet((Object) null);
        if (zzg2 != null) {
            this.zzf.cancel();
            zzg2.unpin(this.zzd);
            zzli zzli = this.zzb;
            zzhz zzhz = new zzhz();
            zzhz.zzc(this.zzg);
            zziu zziu = new zziu();
            zziu.zzf(zzf(this.zza.getConfidenceThreshold()));
            zzhz.zze(zziu.zzi());
            zzli.zzc(zzll.zzg(zzhz, 1), zzhy.ON_DEVICE_LANGUAGE_IDENTIFICATION_CLOSE);
        }
    }

    @NonNull
    public final Feature[] getOptionalFeatures() {
        if (this.zzg == zzhw.TYPE_THICK) {
            return OptionalModuleUtils.EMPTY_FEATURES;
        }
        return new Feature[]{OptionalModuleUtils.FEATURE_LANGID};
    }

    @NonNull
    public final Task<String> identifyLanguage(@NonNull String str) {
        Preconditions.checkNotNull(str, "Text can not be null");
        zzg zzg2 = (zzg) this.zze.get();
        Preconditions.checkState(zzg2 != null, "LanguageIdentification has been closed");
        return zzg2.callAfterLoad(this.zzd, new zze(this, zzg2, str, true ^ zzg2.isLoaded()), this.zzf.getToken());
    }

    @NonNull
    public final Task<List<IdentifiedLanguage>> identifyPossibleLanguages(@NonNull String str) {
        Preconditions.checkNotNull(str, "Text can not be null");
        zzg zzg2 = (zzg) this.zze.get();
        Preconditions.checkState(zzg2 != null, "LanguageIdentification has been closed");
        return zzg2.callAfterLoad(this.zzd, new zzd(this, zzg2, str, true ^ zzg2.isLoaded()), this.zzf.getToken());
    }

    public final /* synthetic */ zzla zzb(long j, boolean z, zzhx zzhx, zzjd zzjd, zzja zzja) {
        zziu zziu = new zziu();
        zziu.zzf(zzf(this.zza.getConfidenceThreshold()));
        zzhm zzhm = new zzhm();
        zzhm.zza(Long.valueOf(j));
        zzhm.zzc(Boolean.valueOf(z));
        zzhm.zzb(zzhx);
        zziu.zze(zzhm.zzd());
        if (zzjd != null) {
            zziu.zzd(zzjd);
        }
        if (zzja != null) {
            zziu.zzc(zzja);
        }
        zzhz zzhz = new zzhz();
        zzhz.zzc(this.zzg);
        zzhz.zze(zziu.zzi());
        return zzll.zzf(zzhz);
    }

    public final /* synthetic */ String zzc(zzg zzg2, String str, boolean z) throws Exception {
        zzja zzc2;
        Float confidenceThreshold = this.zza.getConfidenceThreshold();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            String zzc3 = zzg2.zzc(str.substring(0, Math.min(str.length(), 200)), confidenceThreshold != null ? confidenceThreshold.floatValue() : 0.5f);
            if (zzc3 == null) {
                zzc2 = null;
            } else {
                zziy zziy = new zziy();
                zziv zziv = new zziv();
                zziv.zzb(zzc3);
                zziy.zzb(zziv.zzc());
                zzc2 = zziy.zzc();
            }
            zze(elapsedRealtime, z, (zzjd) null, zzc2, zzhx.NO_ERROR);
            return zzc3;
        } catch (RuntimeException e) {
            zze(elapsedRealtime, z, (zzjd) null, (zzja) null, zzhx.UNKNOWN_ERROR);
            throw e;
        }
    }

    public final /* synthetic */ List zzd(zzg zzg2, String str, boolean z) throws Exception {
        Float confidenceThreshold = this.zza.getConfidenceThreshold();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            List<IdentifiedLanguage> zzd2 = zzg2.zzd(str.substring(0, Math.min(str.length(), 200)), confidenceThreshold != null ? confidenceThreshold.floatValue() : 0.01f);
            zzr zzr = new zzr();
            for (IdentifiedLanguage identifiedLanguage : zzd2) {
                zziv zziv = new zziv();
                zziv.zzb(identifiedLanguage.getLanguageTag());
                zziv.zza(Float.valueOf(identifiedLanguage.getConfidence()));
                zzr.zzb(zziv.zzc());
            }
            zzjb zzjb = new zzjb();
            zzjb.zzb(zzr.zzc());
            zze(elapsedRealtime, z, zzjb.zzc(), (zzja) null, zzhx.NO_ERROR);
            return zzd2;
        } catch (RuntimeException e) {
            zze(elapsedRealtime, z, (zzjd) null, (zzja) null, zzhx.UNKNOWN_ERROR);
            throw e;
        }
    }
}
