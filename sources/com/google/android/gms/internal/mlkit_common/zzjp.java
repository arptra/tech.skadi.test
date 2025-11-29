package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzjp implements ObjectEncoder {
    static final zzjp zza = new zzjp();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("languageOption");
        zzay zzay = new zzay();
        zzay.zza(3);
        builder.withProperty(zzay.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isUsingLegacyApi");
        zzay zzay2 = new zzay();
        zzay2.zza(4);
        builder2.withProperty(zzay2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("sdkVersion");
        zzay zzay3 = new zzay();
        zzay3.zza(5);
        builder3.withProperty(zzay3.zzb()).build();
    }

    private zzjp() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzqf zzqf = (zzqf) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
