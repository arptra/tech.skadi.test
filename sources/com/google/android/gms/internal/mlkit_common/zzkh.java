package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzkh implements ObjectEncoder {
    static final zzkh zza = new zzkh();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;
    private static final FieldDescriptor zzk;
    private static final FieldDescriptor zzl;
    private static final FieldDescriptor zzm;
    private static final FieldDescriptor zzn;
    private static final FieldDescriptor zzo;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("appId");
        zzay zzay = new zzay();
        zzay.zza(1);
        zzb = builder.withProperty(zzay.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        zzay zzay2 = new zzay();
        zzay2.zza(2);
        zzc = builder2.withProperty(zzay2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzay zzay3 = new zzay();
        zzay3.zza(3);
        zzd = builder3.withProperty(zzay3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzay zzay4 = new zzay();
        zzay4.zza(4);
        zze = builder4.withProperty(zzay4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzay zzay5 = new zzay();
        zzay5.zza(5);
        zzf = builder5.withProperty(zzay5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzay zzay6 = new zzay();
        zzay6.zza(6);
        zzg = builder6.withProperty(zzay6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzay zzay7 = new zzay();
        zzay7.zza(7);
        zzh = builder7.withProperty(zzay7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzay zzay8 = new zzay();
        zzay8.zza(8);
        zzi = builder8.withProperty(zzay8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzay zzay9 = new zzay();
        zzay9.zza(9);
        zzj = builder9.withProperty(zzay9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzay zzay10 = new zzay();
        zzay10.zza(10);
        zzk = builder10.withProperty(zzay10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzay zzay11 = new zzay();
        zzay11.zza(11);
        zzl = builder11.withProperty(zzay11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzay zzay12 = new zzay();
        zzay12.zza(12);
        zzm = builder12.withProperty(zzay12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzay zzay13 = new zzay();
        zzay13.zza(13);
        zzn = builder13.withProperty(zzay13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        zzay zzay14 = new zzay();
        zzay14.zza(14);
        zzo = builder14.withProperty(zzay14.zzb()).build();
    }

    private zzkh() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzqv zzqv = (zzqv) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzqv.zzg());
        objectEncoderContext.add(zzc, (Object) zzqv.zzh());
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) zzqv.zzj());
        objectEncoderContext.add(zzf, (Object) zzqv.zzk());
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, (Object) zzqv.zza());
        objectEncoderContext.add(zzj, (Object) zzqv.zzi());
        objectEncoderContext.add(zzk, (Object) zzqv.zzb());
        objectEncoderContext.add(zzl, (Object) zzqv.zzd());
        objectEncoderContext.add(zzm, (Object) zzqv.zzc());
        objectEncoderContext.add(zzn, (Object) zzqv.zze());
        objectEncoderContext.add(zzo, (Object) zzqv.zzf());
    }
}
