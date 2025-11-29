package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    public static final Option d = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Option.CacheKeyUpdater<Long>() {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f2644a = ByteBuffer.allocate(8);

        /* renamed from: b */
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f2644a) {
                this.f2644a.position(0);
                messageDigest.update(this.f2644a.putLong(l.longValue()).array());
            }
        }
    });
    public static final Option e = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Option.CacheKeyUpdater<Integer>() {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f2645a = ByteBuffer.allocate(4);

        /* renamed from: b */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f2645a) {
                    this.f2645a.position(0);
                    messageDigest.update(this.f2645a.putInt(num.intValue()).array());
                }
            }
        }
    });
    public static final MediaMetadataRetrieverFactory f = new MediaMetadataRetrieverFactory();
    public static final List g = Collections.unmodifiableList(Arrays.asList(new String[]{"TP1A", "TD1A.220804.031"}));

    /* renamed from: a  reason: collision with root package name */
    public final MediaInitializer f2643a;
    public final BitmapPool b;
    public final MediaMetadataRetrieverFactory c;

    @RequiresApi
    public static final class AssetFileDescriptorInitializer implements MediaInitializer<AssetFileDescriptor> {
        public AssetFileDescriptorInitializer() {
        }

        /* renamed from: c */
        public void a(MediaExtractor mediaExtractor, AssetFileDescriptor assetFileDescriptor) {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* renamed from: d */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    @RequiresApi
    public static final class ByteBufferInitializer implements MediaInitializer<ByteBuffer> {
        public final MediaDataSource c(final ByteBuffer byteBuffer) {
            return new MediaDataSource() {
                public void close() {
                }

                public long getSize() {
                    return (long) byteBuffer.limit();
                }

                public int readAt(long j, byte[] bArr, int i, int i2) {
                    if (j >= ((long) byteBuffer.limit())) {
                        return -1;
                    }
                    byteBuffer.position((int) j);
                    int min = Math.min(i2, byteBuffer.remaining());
                    byteBuffer.get(bArr, i, min);
                    return min;
                }
            };
        }

        /* renamed from: d */
        public void a(MediaExtractor mediaExtractor, ByteBuffer byteBuffer) {
            mediaExtractor.setDataSource(c(byteBuffer));
        }

        /* renamed from: e */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(c(byteBuffer));
        }
    }

    @VisibleForTesting
    public interface MediaInitializer<T> {
        void a(MediaExtractor mediaExtractor, Object obj);

        void b(MediaMetadataRetriever mediaMetadataRetriever, Object obj);
    }

    @VisibleForTesting
    public static class MediaMetadataRetrieverFactory {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    public static final class ParcelFileDescriptorInitializer implements MediaInitializer<ParcelFileDescriptor> {
        /* renamed from: c */
        public void a(MediaExtractor mediaExtractor, ParcelFileDescriptor parcelFileDescriptor) {
            mediaExtractor.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }

        /* renamed from: d */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        public VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    public VideoDecoder(BitmapPool bitmapPool, MediaInitializer mediaInitializer) {
        this(bitmapPool, mediaInitializer, f);
    }

    public static ResourceDecoder c(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new AssetFileDescriptorInitializer());
    }

    public static ResourceDecoder d(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ByteBufferInitializer());
    }

    public static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, Bitmap bitmap) {
        if (!j()) {
            return bitmap;
        }
        try {
            if (i(mediaMetadataRetriever) && Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) == 180) {
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                }
                Matrix matrix = new Matrix();
                matrix.postRotate(180.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
        } catch (NumberFormatException unused) {
            if (Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Exception trying to extract HDR transfer function or rotation");
            }
        }
        return bitmap;
    }

    public static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    public static Bitmap h(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                int i4 = parseInt2;
                parseInt2 = parseInt;
                parseInt = i4;
            }
            float b2 = downsampleStrategy.b(parseInt, parseInt2, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(((float) parseInt) * b2), Math.round(b2 * ((float) parseInt2)));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    public static boolean i(MediaMetadataRetriever mediaMetadataRetriever) {
        String extractMetadata = mediaMetadataRetriever.extractMetadata(36);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
        int parseInt = Integer.parseInt(extractMetadata);
        return (parseInt == 7 || parseInt == 6) && Integer.parseInt(extractMetadata2) == 6;
    }

    public static boolean j() {
        if (Build.MODEL.startsWith("Pixel") && Build.VERSION.SDK_INT == 33) {
            return k();
        }
        int i = Build.VERSION.SDK_INT;
        return i >= 30 && i < 33;
    }

    public static boolean k() {
        for (String startsWith : g) {
            if (Build.ID.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static ResourceDecoder m(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ParcelFileDescriptorInitializer());
    }

    public boolean a(Object obj, Options options) {
        return true;
    }

    /* JADX INFO: finally extract failed */
    public Resource b(Object obj, int i, int i2, Options options) {
        long longValue = ((Long) options.c(d)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) options.c(e);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.c(DownsampleStrategy.h);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.g;
            }
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
            MediaMetadataRetriever a2 = this.c.a();
            try {
                this.f2643a.b(a2, obj);
                Bitmap f2 = f(obj, a2, longValue, num.intValue(), i, i2, downsampleStrategy2);
                a2.close();
                return BitmapResource.e(f2, this.b);
            } catch (Throwable th) {
                a2.close();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    public final Bitmap f(Object obj, MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        if (!l(obj, mediaMetadataRetriever)) {
            Bitmap h = (i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f) ? null : h(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
            if (h == null) {
                h = g(mediaMetadataRetriever, j, i);
            }
            Bitmap e2 = e(mediaMetadataRetriever, h);
            if (e2 != null) {
                return e2;
            }
            throw new VideoDecoderException();
        }
        throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0059 A[Catch:{ all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean l(java.lang.Object r5, android.media.MediaMetadataRetriever r6) {
        /*
            r4 = this;
            java.lang.String r0 = "VideoDecoder"
            java.lang.String r1 = android.os.Build.DEVICE
            r2 = 0
            if (r1 == 0) goto L_0x006d
            java.lang.String r3 = ".+_cheets|cheets_.+"
            boolean r1 = r1.matches(r3)
            if (r1 == 0) goto L_0x006d
            r1 = 12
            r3 = 0
            java.lang.String r6 = r6.extractMetadata(r1)     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = "video/webm"
            boolean r6 = r1.equals(r6)     // Catch:{ all -> 0x0051 }
            if (r6 != 0) goto L_0x001f
            return r2
        L_0x001f:
            android.media.MediaExtractor r6 = new android.media.MediaExtractor     // Catch:{ all -> 0x0051 }
            r6.<init>()     // Catch:{ all -> 0x0051 }
            com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer r4 = r4.f2643a     // Catch:{ all -> 0x004a }
            r4.a(r6, r5)     // Catch:{ all -> 0x004a }
            int r4 = r6.getTrackCount()     // Catch:{ all -> 0x004a }
            r5 = r2
        L_0x002e:
            if (r5 >= r4) goto L_0x004d
            android.media.MediaFormat r1 = r6.getTrackFormat(r5)     // Catch:{ all -> 0x004a }
            java.lang.String r3 = "mime"
            java.lang.String r1 = r1.getString(r3)     // Catch:{ all -> 0x004a }
            java.lang.String r3 = "video/x-vnd.on2.vp8"
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0047
            r6.release()
            r4 = 1
            return r4
        L_0x0047:
            int r5 = r5 + 1
            goto L_0x002e
        L_0x004a:
            r4 = move-exception
            r3 = r6
            goto L_0x0052
        L_0x004d:
            r6.release()
            goto L_0x0066
        L_0x0051:
            r4 = move-exception
        L_0x0052:
            r5 = 3
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x005f }
            if (r5 == 0) goto L_0x0061
            java.lang.String r5 = "Exception trying to extract track info for a webm video on CrOS."
            android.util.Log.d(r0, r5, r4)     // Catch:{ all -> 0x005f }
            goto L_0x0061
        L_0x005f:
            r4 = move-exception
            goto L_0x0067
        L_0x0061:
            if (r3 == 0) goto L_0x0066
            r3.release()
        L_0x0066:
            return r2
        L_0x0067:
            if (r3 == 0) goto L_0x006c
            r3.release()
        L_0x006c:
            throw r4
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.VideoDecoder.l(java.lang.Object, android.media.MediaMetadataRetriever):boolean");
    }

    public VideoDecoder(BitmapPool bitmapPool, MediaInitializer mediaInitializer, MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.b = bitmapPool;
        this.f2643a = mediaInitializer;
        this.c = mediaMetadataRetrieverFactory;
    }
}
