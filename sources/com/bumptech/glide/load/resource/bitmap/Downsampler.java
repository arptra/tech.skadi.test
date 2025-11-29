package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.geetest.sdk.x;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
    public static final Option f = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    public static final Option g = Option.e("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
    public static final Option h = DownsampleStrategy.h;
    public static final Option i;
    public static final Option j;
    public static final Set k = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));
    public static final DecodeCallbacks l = new DecodeCallbacks() {
        public void a() {
        }

        public void b(BitmapPool bitmapPool, Bitmap bitmap) {
        }
    };
    public static final Set m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    public static final Queue n = Util.g(0);

    /* renamed from: a  reason: collision with root package name */
    public final BitmapPool f2624a;
    public final DisplayMetrics b;
    public final ArrayPool c;
    public final List d;
    public final HardwareConfigState e = HardwareConfigState.b();

    public interface DecodeCallbacks {
        void a();

        void b(BitmapPool bitmapPool, Bitmap bitmap);
    }

    static {
        Boolean bool = Boolean.FALSE;
        i = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        j = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
    }

    public Downsampler(List list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.d = list;
        this.b = (DisplayMetrics) Preconditions.d(displayMetrics);
        this.f2624a = (BitmapPool) Preconditions.d(bitmapPool);
        this.c = (ArrayPool) Preconditions.d(arrayPool);
    }

    public static int a(double d2) {
        int l2 = l(d2);
        int x = x(((double) l2) * d2);
        return x((d2 / ((double) (((float) x) / ((float) l2)))) * ((double) x));
    }

    public static void c(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) {
        int i7;
        int i8;
        int i9;
        int i10;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        BitmapFactory.Options options2 = options;
        if (i11 > 0 && i12 > 0) {
            if (r(i2)) {
                i7 = i11;
                i8 = i12;
            } else {
                i8 = i11;
                i7 = i12;
            }
            float b2 = downsampleStrategy2.b(i8, i7, i13, i14);
            if (b2 > 0.0f) {
                DownsampleStrategy.SampleSizeRounding a2 = downsampleStrategy2.a(i8, i7, i13, i14);
                if (a2 != null) {
                    float f2 = (float) i8;
                    float f3 = (float) i7;
                    int x = i8 / x((double) (b2 * f2));
                    int x2 = i7 / x((double) (b2 * f3));
                    DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
                    int max = Math.max(1, Integer.highestOneBit(a2 == sampleSizeRounding ? Math.max(x, x2) : Math.min(x, x2)));
                    if (a2 == sampleSizeRounding && ((float) max) < 1.0f / b2) {
                        max <<= 1;
                    }
                    options2.inSampleSize = max;
                    if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                        float min = (float) Math.min(max, 8);
                        i9 = (int) Math.ceil((double) (f2 / min));
                        i10 = (int) Math.ceil((double) (f3 / min));
                        int i15 = max / 8;
                        if (i15 > 0) {
                            i9 /= i15;
                            i10 /= i15;
                        }
                    } else if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                        float f4 = (float) max;
                        i9 = (int) Math.floor((double) (f2 / f4));
                        i10 = (int) Math.floor((double) (f3 / f4));
                    } else if (imageType.isWebp()) {
                        float f5 = (float) max;
                        i9 = Math.round(f2 / f5);
                        i10 = Math.round(f3 / f5);
                    } else if (i8 % max == 0 && i7 % max == 0) {
                        i9 = i8 / max;
                        i10 = i7 / max;
                    } else {
                        int[] m2 = m(imageReader, options2, decodeCallbacks, bitmapPool);
                        i9 = m2[0];
                        i10 = m2[1];
                    }
                    double b3 = (double) downsampleStrategy2.b(i9, i10, i13, i14);
                    options2.inTargetDensity = a(b3);
                    options2.inDensity = l(b3);
                    if (s(options)) {
                        options2.inScaled = true;
                    } else {
                        options2.inTargetDensity = 0;
                        options2.inDensity = 0;
                    }
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculate scaling, source: [" + i3 + x.f + i4 + "], degreesToRotate: " + i2 + ", target: [" + i13 + x.f + i14 + "], power of two scaled: [" + i9 + x.f + i10 + "], exact scale factor: " + b2 + ", power of 2 sample size: " + max + ", adjusted scale factor: " + b3 + ", target density: " + options2.inTargetDensity + ", density: " + options2.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            int i16 = i12;
            int i17 = i11;
            throw new IllegalArgumentException("Cannot scale with factor: " + b2 + " from: " + downsampleStrategy2 + ", source: [" + i17 + x.f + i16 + "], target: [" + i13 + x.f + i14 + "]");
        } else if (Log.isLoggable("Downsampler", 3)) {
            Log.d("Downsampler", "Unable to determine dimensions for: " + imageType2 + " with target [" + i13 + x.f + i14 + "]");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap i(com.bumptech.glide.load.resource.bitmap.ImageReader r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r7, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto L_0x000c
            r7.a()
            r5.a()
        L_0x000c:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.i()
            r4.lock()
            android.graphics.Bitmap r5 = r5.c(r6)     // Catch:{ IllegalArgumentException -> 0x0027 }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.i()
            r6.unlock()
            return r5
        L_0x0025:
            r5 = move-exception
            goto L_0x0050
        L_0x0027:
            r4 = move-exception
            java.io.IOException r1 = u(r4, r1, r2, r3, r6)     // Catch:{ all -> 0x0025 }
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch:{ all -> 0x0025 }
        L_0x0038:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x004f
            r8.c(r0)     // Catch:{ IOException -> 0x004e }
            r0 = 0
            r6.inBitmap = r0     // Catch:{ IOException -> 0x004e }
            android.graphics.Bitmap r5 = i(r5, r6, r7, r8)     // Catch:{ IOException -> 0x004e }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.i()
            r6.unlock()
            return r5
        L_0x004e:
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x004f:
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x0050:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.i()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.i(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    public static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + x.f + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options options;
        synchronized (Downsampler.class) {
            Queue queue = n;
            synchronized (queue) {
                options = (BitmapFactory.Options) queue.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                w(options);
            }
        }
        return options;
    }

    public static int l(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    public static int[] m(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) {
        options.inJustDecodeBounds = true;
        i(imageReader, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    public static boolean r(int i2) {
        return i2 == 90 || i2 == 270;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.inDensity;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean s(android.graphics.BitmapFactory.Options r1) {
        /*
            int r0 = r1.inTargetDensity
            if (r0 <= 0) goto L_0x000c
            int r1 = r1.inDensity
            if (r1 <= 0) goto L_0x000c
            if (r0 == r1) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.s(android.graphics.BitmapFactory$Options):boolean");
    }

    public static void t(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i2 + x.f + i3 + "] " + str + " with inBitmap " + n(options) + " for [" + i4 + x.f + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.a(j2));
    }

    public static IOException u(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    public static void v(BitmapFactory.Options options) {
        w(options);
        Queue queue = n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    public static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static int x(double d2) {
        return (int) (d2 + 0.5d);
    }

    public static void y(BitmapFactory.Options options, BitmapPool bitmapPool, int i2, int i3) {
        Bitmap.Config config = options.inPreferredConfig;
        if (config != Bitmap.Config.HARDWARE) {
            Bitmap.Config config2 = options.outConfig;
            if (config2 != null) {
                config = config2;
            }
            options.inBitmap = bitmapPool.e(i2, i3, config);
        }
    }

    public final void b(ImageReader imageReader, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        boolean z3;
        if (!this.e.g(i2, i3, options, z, z2)) {
            if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
                try {
                    z3 = imageReader.d().hasAlpha();
                } catch (IOException e2) {
                    if (Log.isLoggable("Downsampler", 3)) {
                        Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
                    }
                    z3 = false;
                }
                Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                options.inPreferredConfig = config;
                if (config == Bitmap.Config.RGB_565) {
                    options.inDither = true;
                    return;
                }
                return;
            }
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        }
    }

    public Resource d(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, Options options) {
        return e(new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.d, this.c), i2, i3, options, l);
    }

    public final Resource e(ImageReader imageReader, int i2, int i3, Options options, DecodeCallbacks decodeCallbacks) {
        Options options2 = options;
        byte[] bArr = (byte[]) this.c.c(65536, byte[].class);
        BitmapFactory.Options k2 = k();
        k2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options2.c(f);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options2.c(g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options2.c(DownsampleStrategy.h);
        boolean booleanValue = ((Boolean) options2.c(i)).booleanValue();
        Option option = j;
        try {
            return BitmapResource.e(h(imageReader, k2, downsampleStrategy, decodeFormat, preferredColorSpace, options2.c(option) != null && ((Boolean) options2.c(option)).booleanValue(), i2, i3, booleanValue, decodeCallbacks), this.f2624a);
        } finally {
            v(k2);
            this.c.put(bArr);
        }
    }

    public Resource f(InputStream inputStream, int i2, int i3, Options options, DecodeCallbacks decodeCallbacks) {
        return e(new ImageReader.InputStreamImageReader(inputStream, this.d, this.c), i2, i3, options, decodeCallbacks);
    }

    public Resource g(ByteBuffer byteBuffer, int i2, int i3, Options options) {
        return e(new ImageReader.ByteBufferReader(byteBuffer, this.d, this.c), i2, i3, options, l);
    }

    public final Bitmap h(ImageReader imageReader, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i2, int i3, boolean z2, DecodeCallbacks decodeCallbacks) {
        int i4;
        int i5;
        int i6;
        ColorSpace colorSpace;
        int i7;
        int i8;
        ImageReader imageReader2 = imageReader;
        BitmapFactory.Options options2 = options;
        PreferredColorSpace preferredColorSpace2 = preferredColorSpace;
        DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        long b2 = LogTime.b();
        int[] m2 = m(imageReader2, options2, decodeCallbacks2, this.f2624a);
        int i9 = m2[0];
        int i10 = m2[1];
        String str = options2.outMimeType;
        boolean z3 = (i9 == -1 || i10 == -1) ? false : z;
        int b3 = imageReader.b();
        int j2 = TransformationUtils.j(b3);
        boolean m3 = TransformationUtils.m(b3);
        int i11 = i2;
        if (i11 == Integer.MIN_VALUE) {
            i5 = i3;
            i4 = r(j2) ? i10 : i9;
        } else {
            i5 = i3;
            i4 = i11;
        }
        int i12 = i5 == Integer.MIN_VALUE ? r(j2) ? i9 : i10 : i5;
        ImageHeaderParser.ImageType d2 = imageReader.d();
        ImageHeaderParser.ImageType imageType = d2;
        c(d2, imageReader, decodeCallbacks, this.f2624a, downsampleStrategy, j2, i9, i10, i4, i12, options);
        String str2 = str;
        int i13 = i10;
        int i14 = i9;
        DecodeCallbacks decodeCallbacks3 = decodeCallbacks2;
        PreferredColorSpace preferredColorSpace3 = preferredColorSpace2;
        BitmapFactory.Options options3 = options2;
        int i15 = b3;
        ImageReader imageReader3 = imageReader2;
        b(imageReader, decodeFormat, z3, m3, options, i4, i12);
        if (z(imageType)) {
            if (i14 < 0 || i13 < 0 || !z2) {
                float f2 = s(options) ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                int i16 = options3.inSampleSize;
                float f3 = (float) i16;
                i8 = Math.round(((float) ((int) Math.ceil((double) (((float) i14) / f3)))) * f2);
                i7 = Math.round(((float) ((int) Math.ceil((double) (((float) i13) / f3)))) * f2);
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler", "Calculated target [" + i8 + x.f + i7 + "] for source [" + i14 + x.f + i13 + "], sampleSize: " + i16 + ", targetDensity: " + options3.inTargetDensity + ", density: " + options3.inDensity + ", density multiplier: " + f2);
                }
            } else {
                i8 = i4;
                i7 = i12;
            }
            if (i8 > 0 && i7 > 0) {
                y(options3, this.f2624a, i8, i7);
            }
        }
        if (preferredColorSpace3 != null) {
            options3.inPreferredColorSpace = ColorSpace.get((preferredColorSpace3 != PreferredColorSpace.DISPLAY_P3 || (colorSpace = options3.outColorSpace) == null || !colorSpace.isWideGamut()) ? ColorSpace.Named.SRGB : ColorSpace.Named.DISPLAY_P3);
        }
        Bitmap i17 = i(imageReader3, options3, decodeCallbacks3, this.f2624a);
        decodeCallbacks3.b(this.f2624a, i17);
        if (Log.isLoggable("Downsampler", 2)) {
            i6 = i15;
            t(i14, i13, str2, options, i17, i2, i3, b2);
        } else {
            i6 = i15;
        }
        if (i17 == null) {
            return null;
        }
        i17.setDensity(this.b.densityDpi);
        Bitmap o = TransformationUtils.o(this.f2624a, i17, i6);
        if (i17.equals(o)) {
            return o;
        }
        this.f2624a.c(i17);
        return o;
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }

    public final boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }
}
