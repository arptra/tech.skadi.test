package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.ParcelFileDescriptor;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Preconditions;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

interface ImageReader {

    public static final class ByteArrayReader implements ImageReader {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f2627a;
        public final List b;
        public final ArrayPool c;

        public void a() {
        }

        public int b() {
            return ImageHeaderParserUtils.c(this.b, ByteBuffer.wrap(this.f2627a), this.c);
        }

        public Bitmap c(BitmapFactory.Options options) {
            byte[] bArr = this.f2627a;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }

        public ImageHeaderParser.ImageType d() {
            return ImageHeaderParserUtils.g(this.b, ByteBuffer.wrap(this.f2627a));
        }
    }

    public static final class ByteBufferReader implements ImageReader {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f2628a;
        public final List b;
        public final ArrayPool c;

        public ByteBufferReader(ByteBuffer byteBuffer, List list, ArrayPool arrayPool) {
            this.f2628a = byteBuffer;
            this.b = list;
            this.c = arrayPool;
        }

        public void a() {
        }

        public int b() {
            return ImageHeaderParserUtils.c(this.b, ByteBufferUtil.d(this.f2628a), this.c);
        }

        public Bitmap c(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(e(), (Rect) null, options);
        }

        public ImageHeaderParser.ImageType d() {
            return ImageHeaderParserUtils.g(this.b, ByteBufferUtil.d(this.f2628a));
        }

        public final InputStream e() {
            return ByteBufferUtil.g(ByteBufferUtil.d(this.f2628a));
        }
    }

    public static final class FileReader implements ImageReader {

        /* renamed from: a  reason: collision with root package name */
        public final File f2629a;
        public final List b;
        public final ArrayPool c;

        public void a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0021 A[SYNTHETIC, Splitter:B:13:0x0021] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int b() {
            /*
                r4 = this;
                r0 = 0
                com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x001e }
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x001e }
                java.io.File r3 = r4.f2629a     // Catch:{ all -> 0x001e }
                r2.<init>(r3)     // Catch:{ all -> 0x001e }
                com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r3 = r4.c     // Catch:{ all -> 0x001e }
                r1.<init>(r2, r3)     // Catch:{ all -> 0x001e }
                java.util.List r0 = r4.b     // Catch:{ all -> 0x001b }
                com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r4 = r4.c     // Catch:{ all -> 0x001b }
                int r4 = com.bumptech.glide.load.ImageHeaderParserUtils.b(r0, r1, r4)     // Catch:{ all -> 0x001b }
                r1.close()     // Catch:{ IOException -> 0x001a }
            L_0x001a:
                return r4
            L_0x001b:
                r4 = move-exception
                r0 = r1
                goto L_0x001f
            L_0x001e:
                r4 = move-exception
            L_0x001f:
                if (r0 == 0) goto L_0x0024
                r0.close()     // Catch:{ IOException -> 0x0024 }
            L_0x0024:
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.ImageReader.FileReader.b():int");
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[SYNTHETIC, Splitter:B:13:0x001d] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Bitmap c(android.graphics.BitmapFactory.Options r5) {
            /*
                r4 = this;
                r0 = 0
                com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x001a }
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x001a }
                java.io.File r3 = r4.f2629a     // Catch:{ all -> 0x001a }
                r2.<init>(r3)     // Catch:{ all -> 0x001a }
                com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r4 = r4.c     // Catch:{ all -> 0x001a }
                r1.<init>(r2, r4)     // Catch:{ all -> 0x001a }
                android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r1, r0, r5)     // Catch:{ all -> 0x0017 }
                r1.close()     // Catch:{ IOException -> 0x0016 }
            L_0x0016:
                return r4
            L_0x0017:
                r4 = move-exception
                r0 = r1
                goto L_0x001b
            L_0x001a:
                r4 = move-exception
            L_0x001b:
                if (r0 == 0) goto L_0x0020
                r0.close()     // Catch:{ IOException -> 0x0020 }
            L_0x0020:
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.ImageReader.FileReader.c(android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0021 A[SYNTHETIC, Splitter:B:13:0x0021] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.bumptech.glide.load.ImageHeaderParser.ImageType d() {
            /*
                r4 = this;
                r0 = 0
                com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x001e }
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x001e }
                java.io.File r3 = r4.f2629a     // Catch:{ all -> 0x001e }
                r2.<init>(r3)     // Catch:{ all -> 0x001e }
                com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r3 = r4.c     // Catch:{ all -> 0x001e }
                r1.<init>(r2, r3)     // Catch:{ all -> 0x001e }
                java.util.List r0 = r4.b     // Catch:{ all -> 0x001b }
                com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r4 = r4.c     // Catch:{ all -> 0x001b }
                com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParserUtils.f(r0, r1, r4)     // Catch:{ all -> 0x001b }
                r1.close()     // Catch:{ IOException -> 0x001a }
            L_0x001a:
                return r4
            L_0x001b:
                r4 = move-exception
                r0 = r1
                goto L_0x001f
            L_0x001e:
                r4 = move-exception
            L_0x001f:
                if (r0 == 0) goto L_0x0024
                r0.close()     // Catch:{ IOException -> 0x0024 }
            L_0x0024:
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.ImageReader.FileReader.d():com.bumptech.glide.load.ImageHeaderParser$ImageType");
        }
    }

    public static final class InputStreamImageReader implements ImageReader {

        /* renamed from: a  reason: collision with root package name */
        public final InputStreamRewinder f2630a;
        public final ArrayPool b;
        public final List c;

        public InputStreamImageReader(InputStream inputStream, List list, ArrayPool arrayPool) {
            this.b = (ArrayPool) Preconditions.d(arrayPool);
            this.c = (List) Preconditions.d(list);
            this.f2630a = new InputStreamRewinder(inputStream, arrayPool);
        }

        public void a() {
            this.f2630a.c();
        }

        public int b() {
            return ImageHeaderParserUtils.b(this.c, this.f2630a.a(), this.b);
        }

        public Bitmap c(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(this.f2630a.a(), (Rect) null, options);
        }

        public ImageHeaderParser.ImageType d() {
            return ImageHeaderParserUtils.f(this.c, this.f2630a.a(), this.b);
        }
    }

    @RequiresApi
    public static final class ParcelFileDescriptorImageReader implements ImageReader {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayPool f2631a;
        public final List b;
        public final ParcelFileDescriptorRewinder c;

        public ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor, List list, ArrayPool arrayPool) {
            this.f2631a = (ArrayPool) Preconditions.d(arrayPool);
            this.b = (List) Preconditions.d(list);
            this.c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        public void a() {
        }

        public int b() {
            return ImageHeaderParserUtils.a(this.b, this.c, this.f2631a);
        }

        public Bitmap c(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.c.a().getFileDescriptor(), (Rect) null, options);
        }

        public ImageHeaderParser.ImageType d() {
            return ImageHeaderParserUtils.e(this.b, this.c, this.f2631a);
        }
    }

    void a();

    int b();

    Bitmap c(BitmapFactory.Options options);

    ImageHeaderParser.ImageType d();
}
