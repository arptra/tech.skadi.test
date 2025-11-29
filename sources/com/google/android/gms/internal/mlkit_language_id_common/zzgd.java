package com.google.android.gms.internal.mlkit_language_id_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzgd implements ObjectEncoder {
    static final zzgd zza = new zzgd();
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
        zzai zzai = new zzai();
        zzai.zza(1);
        zzb = builder.withProperty(zzai.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        zzai zzai2 = new zzai();
        zzai2.zza(2);
        zzc = builder2.withProperty(zzai2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzai zzai3 = new zzai();
        zzai3.zza(3);
        zzd = builder3.withProperty(zzai3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzai zzai4 = new zzai();
        zzai4.zza(4);
        zze = builder4.withProperty(zzai4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzai zzai5 = new zzai();
        zzai5.zza(5);
        zzf = builder5.withProperty(zzai5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzai zzai6 = new zzai();
        zzai6.zza(6);
        zzg = builder6.withProperty(zzai6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzai zzai7 = new zzai();
        zzai7.zza(7);
        zzh = builder7.withProperty(zzai7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzai zzai8 = new zzai();
        zzai8.zza(8);
        zzi = builder8.withProperty(zzai8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzai zzai9 = new zzai();
        zzai9.zza(9);
        zzj = builder9.withProperty(zzai9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzai zzai10 = new zzai();
        zzai10.zza(10);
        zzk = builder10.withProperty(zzai10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzai zzai11 = new zzai();
        zzai11.zza(11);
        zzl = builder11.withProperty(zzai11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzai zzai12 = new zzai();
        zzai12.zza(12);
        zzm = builder12.withProperty(zzai12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzai zzai13 = new zzai();
        zzai13.zza(13);
        zzn = builder13.withProperty(zzai13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        zzai zzai14 = new zzai();
        zzai14.zza(14);
        zzo = builder14.withProperty(zzai14.zzb()).build();
    }

    private zzgd() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzke zzke = (zzke) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzke.zzg());
        objectEncoderContext.add(zzc, (Object) zzke.zzh());
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) zzke.zzj());
        objectEncoderContext.add(zzf, (Object) zzke.zzk());
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, (Object) zzke.zza());
        objectEncoderContext.add(zzj, (Object) zzke.zzi());
        objectEncoderContext.add(zzk, (Object) zzke.zzb());
        objectEncoderContext.add(zzl, (Object) zzke.zzd());
        objectEncoderContext.add(zzm, (Object) zzke.zzc());
        objectEncoderContext.add(zzn, (Object) zzke.zze());
        objectEncoderContext.add(zzo, (Object) zzke.zzf());
    }
}
