package com.google.android.gms.internal.mlkit_language_id_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzbz implements ObjectEncoder {
    static final zzbz zza = new zzbz();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zzai zzai = new zzai();
        zzai.zza(1);
        zzb = builder.withProperty(zzai.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("hasResult");
        zzai zzai2 = new zzai();
        zzai2.zza(2);
        zzc = builder2.withProperty(zzai2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("isColdCall");
        zzai zzai3 = new zzai();
        zzai3.zza(3);
        zzd = builder3.withProperty(zzai3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("imageInfo");
        zzai zzai4 = new zzai();
        zzai4.zza(4);
        zze = builder4.withProperty(zzai4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("options");
        zzai zzai5 = new zzai();
        zzai5.zza(5);
        zzf = builder5.withProperty(zzai5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("detectedBarcodeFormats");
        zzai zzai6 = new zzai();
        zzai6.zza(6);
        zzg = builder6.withProperty(zzai6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("detectedBarcodeValueTypes");
        zzai zzai7 = new zzai();
        zzai7.zza(7);
        zzh = builder7.withProperty(zzai7.zzb()).build();
    }

    private zzbz() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzay zzay = (zzay) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
