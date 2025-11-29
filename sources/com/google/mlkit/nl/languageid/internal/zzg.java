package com.google.mlkit.nl.languageid.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.ModelResource;
import com.google.mlkit.nl.languageid.IdentifiedLanguage;
import com.google.mlkit.nl.languageid.LanguageIdentificationOptions;
import com.google.mlkit.nl.languageid.LanguageIdentifier;
import com.upuphone.starrynet.common.StarryNetConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzg extends ModelResource {
    @Nullable
    private LanguageIdentifierDelegate zza;
    private LanguageIdentificationOptions zzb;
    private final Context zzc;
    private final LanguageIdentifierCreatorDelegate zzd;
    private final boolean zze;

    public zzg(Context context, LanguageIdentifierCreatorDelegate languageIdentifierCreatorDelegate) {
        this.zzc = context;
        this.zzd = languageIdentifierCreatorDelegate;
        this.zze = languageIdentifierCreatorDelegate.getPriority() == 100;
    }

    @WorkerThread
    public final void load() throws MlKitException {
        this.taskQueue.checkIsRunningOnCurrentThread();
        if (this.zza == null) {
            LanguageIdentifierDelegate create = this.zzd.create(this.zzc, this.zzb);
            this.zza = create;
            create.init();
        }
    }

    @WorkerThread
    public final void release() {
        this.taskQueue.checkIsRunningOnCurrentThread();
        LanguageIdentifierDelegate languageIdentifierDelegate = this.zza;
        if (languageIdentifierDelegate != null) {
            languageIdentifierDelegate.release();
            this.zza = null;
        }
    }

    @WorkerThread
    public final String zzc(String str, float f) throws MlKitException {
        String str2;
        if (this.zza == null) {
            load();
        }
        if (str.isEmpty()) {
            return LanguageIdentifier.UNDETERMINED_LANGUAGE_TAG;
        }
        Iterator<IdentifiedLanguage> it = ((LanguageIdentifierDelegate) Preconditions.checkNotNull(this.zza)).identifyPossibleLanguages(str, f).iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = "";
                break;
            }
            IdentifiedLanguage next = it.next();
            if (!StarryNetConstant.DEVICE_NAME_UNKNOWN.equals(next.getLanguageTag())) {
                str2 = next.getLanguageTag();
                break;
            }
        }
        return str2.isEmpty() ? LanguageIdentifier.UNDETERMINED_LANGUAGE_TAG : "iw".equals(str2) ? "he" : str2;
    }

    @WorkerThread
    public final List zzd(String str, float f) throws MlKitException {
        if (this.zza == null) {
            load();
        }
        ArrayList arrayList = new ArrayList();
        if (str.isEmpty()) {
            arrayList.add(new IdentifiedLanguage(LanguageIdentifier.UNDETERMINED_LANGUAGE_TAG, 1.0f));
            return arrayList;
        }
        for (IdentifiedLanguage next : ((LanguageIdentifierDelegate) Preconditions.checkNotNull(this.zza)).identifyPossibleLanguages(str, f)) {
            if (!StarryNetConstant.DEVICE_NAME_UNKNOWN.equals(next.getLanguageTag())) {
                arrayList.add(new IdentifiedLanguage("iw".equals(next.getLanguageTag()) ? "he" : next.getLanguageTag(), next.getConfidence()));
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new IdentifiedLanguage(LanguageIdentifier.UNDETERMINED_LANGUAGE_TAG, 1.0f));
        }
        return arrayList;
    }

    public final void zze(LanguageIdentificationOptions languageIdentificationOptions) {
        this.zzb = languageIdentificationOptions;
    }

    public final boolean zzf() {
        return this.zze;
    }
}
