package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class ImageHeaderParserUtils {

    public interface OrientationReader {
        int a(ImageHeaderParser imageHeaderParser);
    }

    public interface TypeReader {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    public static int a(List list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final ArrayPool arrayPool) {
        return d(list, new OrientationReader() {
            /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public int a(com.bumptech.glide.load.ImageHeaderParser r5) {
                /*
                    r4 = this;
                    r0 = 0
                    com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x0029 }
                    java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0029 }
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r3 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this     // Catch:{ all -> 0x0029 }
                    android.os.ParcelFileDescriptor r3 = r3.a()     // Catch:{ all -> 0x0029 }
                    java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0029 }
                    r2.<init>(r3)     // Catch:{ all -> 0x0029 }
                    com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r3 = r3     // Catch:{ all -> 0x0029 }
                    r1.<init>(r2, r3)     // Catch:{ all -> 0x0029 }
                    com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r0 = r3     // Catch:{ all -> 0x0026 }
                    int r5 = r5.c(r1, r0)     // Catch:{ all -> 0x0026 }
                    r1.release()
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r4 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this
                    r4.a()
                    return r5
                L_0x0026:
                    r5 = move-exception
                    r0 = r1
                    goto L_0x002a
                L_0x0029:
                    r5 = move-exception
                L_0x002a:
                    if (r0 == 0) goto L_0x002f
                    r0.release()
                L_0x002f:
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r4 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this
                    r4.a()
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass6.a(com.bumptech.glide.load.ImageHeaderParser):int");
            }
        });
    }

    public static int b(List list, final InputStream inputStream, final ArrayPool arrayPool) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        return d(list, new OrientationReader() {
            public int a(ImageHeaderParser imageHeaderParser) {
                try {
                    return imageHeaderParser.c(inputStream, arrayPool);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static int c(List list, final ByteBuffer byteBuffer, final ArrayPool arrayPool) {
        if (byteBuffer == null) {
            return -1;
        }
        return d(list, new OrientationReader() {
            public int a(ImageHeaderParser imageHeaderParser) {
                try {
                    return imageHeaderParser.a(byteBuffer, arrayPool);
                } finally {
                    ByteBufferUtil.d(byteBuffer);
                }
            }
        });
    }

    public static int d(List list, OrientationReader orientationReader) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int a2 = orientationReader.a((ImageHeaderParser) list.get(i));
            if (a2 != -1) {
                return a2;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType e(List list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final ArrayPool arrayPool) {
        return h(list, new TypeReader() {
            /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.bumptech.glide.load.ImageHeaderParser.ImageType a(com.bumptech.glide.load.ImageHeaderParser r5) {
                /*
                    r4 = this;
                    r0 = 0
                    com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x0027 }
                    java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0027 }
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r3 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this     // Catch:{ all -> 0x0027 }
                    android.os.ParcelFileDescriptor r3 = r3.a()     // Catch:{ all -> 0x0027 }
                    java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0027 }
                    r2.<init>(r3)     // Catch:{ all -> 0x0027 }
                    com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r3 = r3     // Catch:{ all -> 0x0027 }
                    r1.<init>(r2, r3)     // Catch:{ all -> 0x0027 }
                    com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = r5.b(r1)     // Catch:{ all -> 0x0024 }
                    r1.release()
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r4 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this
                    r4.a()
                    return r5
                L_0x0024:
                    r5 = move-exception
                    r0 = r1
                    goto L_0x0028
                L_0x0027:
                    r5 = move-exception
                L_0x0028:
                    if (r0 == 0) goto L_0x002d
                    r0.release()
                L_0x002d:
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r4 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this
                    r4.a()
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass3.a(com.bumptech.glide.load.ImageHeaderParser):com.bumptech.glide.load.ImageHeaderParser$ImageType");
            }
        });
    }

    public static ImageHeaderParser.ImageType f(List list, final InputStream inputStream, ArrayPool arrayPool) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        return h(list, new TypeReader() {
            public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
                try {
                    return imageHeaderParser.b(inputStream);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static ImageHeaderParser.ImageType g(List list, final ByteBuffer byteBuffer) {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : h(list, new TypeReader() {
            public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
                try {
                    return imageHeaderParser.d(byteBuffer);
                } finally {
                    ByteBufferUtil.d(byteBuffer);
                }
            }
        });
    }

    public static ImageHeaderParser.ImageType h(List list, TypeReader typeReader) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType a2 = typeReader.a((ImageHeaderParser) list.get(i));
            if (a2 != ImageHeaderParser.ImageType.UNKNOWN) {
                return a2;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
