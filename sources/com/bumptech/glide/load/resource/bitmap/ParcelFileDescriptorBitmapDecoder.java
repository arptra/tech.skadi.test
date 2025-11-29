package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

@RequiresApi
public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final Downsampler f2634a;

    public ParcelFileDescriptorBitmapDecoder(Downsampler downsampler) {
        this.f2634a = downsampler;
    }

    /* renamed from: c */
    public Resource b(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, Options options) {
        return this.f2634a.d(parcelFileDescriptor, i, i2, options);
    }

    /* renamed from: d */
    public boolean a(ParcelFileDescriptor parcelFileDescriptor, Options options) {
        return e(parcelFileDescriptor) && this.f2634a.o(parcelFileDescriptor);
    }

    public final boolean e(ParcelFileDescriptor parcelFileDescriptor) {
        String str = Build.MANUFACTURER;
        return (!"HUAWEI".equalsIgnoreCase(str) && !"HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912;
    }
}
