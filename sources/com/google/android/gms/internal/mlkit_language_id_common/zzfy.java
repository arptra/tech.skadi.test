package com.google.android.gms.internal.mlkit_language_id_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.honey.account.view.web.WebJs;
import java.io.IOException;

final class zzfy implements ObjectEncoder {
    static final zzfy zza = new zzfy();
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

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("deviceInfo");
        zzai zzai = new zzai();
        zzai.zza(1);
        zzb = builder.withProperty(zzai.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("nnapiInfo");
        zzai zzai2 = new zzai();
        zzai2.zza(2);
        zzc = builder2.withProperty(zzai2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("gpuInfo");
        zzai zzai3 = new zzai();
        zzai3.zza(3);
        zzd = builder3.withProperty(zzai3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("pipelineIdentifier");
        zzai zzai4 = new zzai();
        zzai4.zza(4);
        zze = builder4.withProperty(zzai4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("acceptedConfigurations");
        zzai zzai5 = new zzai();
        zzai5.zza(5);
        zzf = builder5.withProperty(zzai5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder(WebJs.ACTION);
        zzai zzai6 = new zzai();
        zzai6.zza(6);
        zzg = builder6.withProperty(zzai6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("status");
        zzai zzai7 = new zzai();
        zzai7.zza(7);
        zzh = builder7.withProperty(zzai7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("customErrors");
        zzai zzai8 = new zzai();
        zzai8.zza(8);
        zzi = builder8.withProperty(zzai8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("benchmarkStatus");
        zzai zzai9 = new zzai();
        zzai9.zza(9);
        zzj = builder9.withProperty(zzai9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("validationTestResult");
        zzai zzai10 = new zzai();
        zzai10.zza(10);
        zzk = builder10.withProperty(zzai10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("timestampUs");
        zzai zzai11 = new zzai();
        zzai11.zza(11);
        zzl = builder11.withProperty(zzai11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("elapsedUs");
        zzai zzai12 = new zzai();
        zzai12.zza(12);
        zzm = builder12.withProperty(zzai12.zzb()).build();
    }

    private zzfy() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzkq zzkq = (zzkq) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
