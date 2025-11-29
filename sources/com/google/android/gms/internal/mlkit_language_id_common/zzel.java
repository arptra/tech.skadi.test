package com.google.android.gms.internal.mlkit_language_id_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzel implements ObjectEncoder {
    static final zzel zza = new zzel();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("name");
        zzai zzai = new zzai();
        zzai.zza(1);
        zzb = builder.withProperty(zzai.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("type");
        zzai zzai2 = new zzai();
        zzai2.zza(2);
        zzc = builder2.withProperty(zzai2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("version");
        zzai zzai3 = new zzai();
        zzai3.zza(3);
        zzd = builder3.withProperty(zzai3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("featureLevel");
        zzai zzai4 = new zzai();
        zzai4.zza(4);
        zze = builder4.withProperty(zzai4.zzb()).build();
    }

    private zzel() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzkm zzkm = (zzkm) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
