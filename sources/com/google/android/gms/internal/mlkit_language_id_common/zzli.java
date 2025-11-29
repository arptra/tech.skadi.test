package com.google.android.gms.internal.mlkit_language_id_common;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.nl.languageid.internal.zzf;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class zzli {
    @Nullable
    private static zzu zza;
    private static final zzw zzb = zzw.zzc("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzlh zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzli(Context context, SharedPrefManager sharedPrefManager, zzlh zzlh, String str) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzlh;
        zzlu.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new zzle(this));
        MLTaskExecutor instance = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = instance.scheduleCallable(new zzlf(sharedPrefManager));
        zzw zzw = zzb;
        this.zzj = zzw.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzw.get(str)) : -1;
    }

    @NonNull
    private static synchronized zzu zzf() {
        synchronized (zzli.class) {
            try {
                zzu zzu = zza;
                if (zzu != null) {
                    return zzu;
                }
                LocaleListCompat a2 = ConfigurationCompat.a(Resources.getSystem().getConfiguration());
                zzr zzr = new zzr();
                for (int i = 0; i < a2.g(); i++) {
                    zzr.zzb(CommonUtils.languageTagFromLocale(a2.d(i)));
                }
                zzu zzc2 = zzr.zzc();
                zza = zzc2;
                return zzc2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    private final String zzg() {
        return this.zzg.isSuccessful() ? (String) this.zzg.getResult() : LibraryVersion.getInstance().getVersion(this.zzi);
    }

    public final /* synthetic */ String zza() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    public final /* synthetic */ void zzb(zzla zzla, zzhy zzhy, String str) {
        zzla.zzb(zzhy);
        String zzd2 = zzla.zzd();
        zzkc zzkc = new zzkc();
        zzkc.zzb(this.zzc);
        zzkc.zzc(this.zzd);
        zzkc.zzh(zzf());
        zzkc.zzg(Boolean.TRUE);
        zzkc.zzl(zzd2);
        zzkc.zzj(str);
        zzkc.zzi(this.zzh.isSuccessful() ? (String) this.zzh.getResult() : this.zzf.getMlSdkInstanceId());
        zzkc.zzd(10);
        zzkc.zzk(Integer.valueOf(this.zzj));
        zzla.zzc(zzkc);
        this.zze.zza(zzla);
    }

    public final void zzc(zzla zzla, zzhy zzhy) {
        zzd(zzla, zzhy, zzg());
    }

    public final void zzd(zzla zzla, zzhy zzhy, String str) {
        MLTaskExecutor.workerThreadExecutor().execute(new zzlg(this, zzla, zzhy, str));
    }

    @WorkerThread
    public final void zze(zzf zzf2, zzhy zzhy) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzk.get(zzhy) == null || elapsedRealtime - ((Long) this.zzk.get(zzhy)).longValue() > TimeUnit.SECONDS.toMillis(30)) {
            this.zzk.put(zzhy, Long.valueOf(elapsedRealtime));
            zzd(zzf2.zza(), zzhy, zzg());
        }
    }
}
