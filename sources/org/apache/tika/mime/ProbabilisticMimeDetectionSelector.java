package org.apache.tika.mime;

import java.util.List;
import org.apache.tika.detect.Detector;

public class ProbabilisticMimeDetectionSelector implements Detector {
    private static final float DEFAULT_EXTENSION_TRUST = 0.8f;
    private static final float DEFAULT_MAGIC_TRUST = 0.9f;
    private static final float DEFAULT_META_TRUST = 0.8f;
    private static final long serialVersionUID = 224589862960269260L;
    private final float changeRate;
    private float extension_neg;
    private float extension_trust;
    private float magic_neg;
    private float magic_trust;
    private float meta_neg;
    private float meta_trust;
    private final MimeTypes mimeTypes;
    private float priorExtensionFileType;
    private float priorMagicFileType;
    private float priorMetaFileType;
    private final MediaType rootMediaType;
    private float threshold;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public float f9154a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public float j;
    }

    public ProbabilisticMimeDetectionSelector() {
        this(MimeTypes.getDefaultMimeTypes(), (Builder) null);
    }

    private MediaType applyProbilities(List<MimeType> list, MimeType mimeType, MimeType mimeType2) {
        float f;
        MediaType mediaType;
        MediaType mediaType2;
        int i;
        List<MimeType> list2 = list;
        MimeType mimeType3 = mimeType;
        MimeType mimeType4 = mimeType2;
        MediaType mediaType3 = null;
        MediaType type = mimeType3 == null ? null : mimeType.getType();
        if (mimeType4 != null) {
            mediaType3 = mimeType2.getType();
        }
        int size = list.size();
        float f2 = this.magic_trust;
        float f3 = this.magic_neg;
        float f4 = this.extension_trust;
        float f5 = this.extension_neg;
        float f6 = this.meta_trust;
        float f7 = this.meta_neg;
        if (type == null || type.compareTo(this.rootMediaType) == 0) {
            f4 = 1.0f;
            f5 = 1.0f;
        }
        if (mediaType3 == null || mediaType3.compareTo(this.rootMediaType) == 0) {
            f6 = 1.0f;
            f7 = 1.0f;
        }
        MediaType mediaType4 = this.rootMediaType;
        float f8 = -1.0f;
        if (!list.isEmpty()) {
            int i2 = 0;
            while (i2 < size) {
                MediaType type2 = list2.get(i2).getType();
                int i3 = size;
                MediaTypeRegistry mediaTypeRegistry = this.mimeTypes.getMediaTypeRegistry();
                float f9 = f2;
                if (type2 == null || !type2.equals(this.rootMediaType)) {
                    if (type != null) {
                        if (type.equals(type2) || mediaTypeRegistry.isSpecializationOf(type, type2)) {
                            list2.set(i2, mimeType3);
                        } else if (mediaTypeRegistry.isSpecializationOf(type2, type)) {
                            type = type2;
                        }
                    }
                    if (mediaType3 != null) {
                        if (mediaType3.equals(type2) || mediaTypeRegistry.isSpecializationOf(mediaType3, type2)) {
                            list2.set(i2, mimeType4);
                        } else if (mediaTypeRegistry.isSpecializationOf(type2, mediaType3)) {
                            mediaType3 = type2;
                        }
                    }
                    f2 = f9;
                } else {
                    f2 = 1.0f;
                    f3 = 1.0f;
                }
                float[] fArr = new float[3];
                float[] fArr2 = new float[3];
                MediaType mediaType5 = mediaType4;
                float[] fArr3 = new float[3];
                MediaType type3 = list2.get(i2).getType();
                if (i2 > 0) {
                    float f10 = this.changeRate;
                    f = 1.0f;
                    f2 *= 1.0f - f10;
                    f3 *= f10 + 1.0f;
                } else {
                    f = 1.0f;
                }
                if (type3 == null || f2 == f) {
                    fArr[0] = 0.1f;
                } else {
                    fArr2[0] = f2;
                    fArr3[0] = f3;
                    if (mediaType3 == null || f6 == f) {
                        fArr2[1] = f;
                        fArr3[1] = f;
                    } else if (type3.equals(mediaType3)) {
                        fArr2[1] = f6;
                        fArr3[1] = f7;
                    } else {
                        fArr2[1] = f - f6;
                        fArr3[1] = f - f7;
                    }
                    if (type == null || f4 == f) {
                        fArr2[2] = f;
                        fArr3[2] = f;
                    } else if (type3.equals(type)) {
                        fArr2[2] = f4;
                        fArr3[2] = f5;
                    } else {
                        fArr2[2] = f - f4;
                        fArr3[2] = f - f5;
                    }
                }
                int i4 = i2;
                float[] fArr4 = new float[3];
                float[] fArr5 = fArr3;
                float[] fArr6 = new float[3];
                if (mimeType4 == null || f6 == f) {
                    fArr[1] = 0.1f;
                } else {
                    fArr4[1] = f6;
                    fArr6[1] = f7;
                    if (type3 == null || f2 == f) {
                        fArr4[0] = f;
                        fArr6[0] = f;
                    } else if (mediaType3.equals(type3)) {
                        fArr4[0] = f2;
                        fArr6[0] = f3;
                    } else {
                        fArr4[0] = f - f2;
                        fArr6[0] = f - f3;
                    }
                    if (type == null || f4 == f) {
                        fArr4[2] = f;
                        fArr6[2] = f;
                    } else if (mediaType3.equals(type)) {
                        fArr4[2] = f4;
                        fArr6[2] = f5;
                    } else {
                        fArr4[2] = f - f4;
                        fArr6[2] = f - f5;
                    }
                }
                float[] fArr7 = new float[3];
                float[] fArr8 = fArr6;
                float[] fArr9 = new float[3];
                if (type == null || f4 == f) {
                    fArr[2] = 0.1f;
                } else {
                    fArr7[2] = f4;
                    fArr9[2] = f5;
                    if (type3 == null || f2 == f) {
                        fArr7[0] = f;
                        fArr9[0] = f;
                    } else if (type3.equals(type)) {
                        fArr7[0] = f2;
                        fArr9[0] = f3;
                    } else {
                        fArr7[0] = f - f2;
                        fArr9[0] = f - f3;
                    }
                    if (mediaType3 == null || f6 == f) {
                        fArr7[1] = f;
                        fArr9[1] = f;
                    } else if (mediaType3.equals(type)) {
                        fArr7[1] = f6;
                        fArr9[1] = f7;
                    } else {
                        fArr7[1] = f - f6;
                        fArr9[1] = f - f7;
                    }
                }
                float f11 = this.priorMagicFileType;
                float f12 = f - f11;
                if (fArr[0] == 0.0f) {
                    mediaType = type;
                    float f13 = f12;
                    int i5 = 3;
                    mediaType2 = mediaType3;
                    int i6 = 0;
                    while (i6 < i5) {
                        float f14 = fArr2[i6];
                        f11 *= f14;
                        if (f14 != f) {
                            f13 *= fArr5[i6];
                        }
                        i6++;
                        i5 = 3;
                        f = 1.0f;
                    }
                    i = 0;
                    fArr[0] = f11 / (f11 + f13);
                } else {
                    mediaType2 = mediaType3;
                    mediaType = type;
                    i = 0;
                }
                float f15 = fArr[i];
                if (f8 < f15) {
                    f8 = f15;
                    mediaType5 = type3;
                }
                float f16 = this.priorMetaFileType;
                float f17 = 1.0f;
                float f18 = 1.0f - f16;
                if (fArr[1] == 0.0f) {
                    int i7 = i;
                    while (i7 < 3) {
                        float f19 = fArr4[i7];
                        f16 *= f19;
                        if (f19 != f17) {
                            f18 *= fArr8[i7];
                        }
                        i7++;
                        f17 = 1.0f;
                    }
                    fArr[1] = f16 / (f18 + f16);
                }
                float f20 = fArr[1];
                if (f8 < f20) {
                    f8 = f20;
                    mediaType5 = mediaType2;
                }
                float f21 = this.priorExtensionFileType;
                float f22 = 1.0f - f21;
                if (fArr[2] == 0.0f) {
                    for (int i8 = i; i8 < 3; i8++) {
                        float f23 = fArr7[i8];
                        f21 *= f23;
                        if (f23 != 1.0f) {
                            f22 *= fArr9[i8];
                        }
                    }
                    fArr[2] = f21 / (f22 + f21);
                }
                float f24 = fArr[2];
                if (f8 < f24) {
                    f8 = f24;
                    mediaType4 = mediaType;
                } else {
                    mediaType4 = mediaType5;
                }
                i2 = i4 + 1;
                list2 = list;
                mimeType3 = mimeType;
                mimeType4 = mimeType2;
                size = i3;
                mediaType3 = mediaType2;
                type = mediaType;
            }
            MediaType mediaType6 = mediaType4;
        }
        return f8 < this.threshold ? this.rootMediaType : mediaType4;
    }

    private void initializeDefaultProbabilityParameters() {
        this.priorMagicFileType = 0.5f;
        this.priorExtensionFileType = 0.5f;
        this.priorMetaFileType = 0.5f;
        this.magic_trust = DEFAULT_MAGIC_TRUST;
        this.extension_trust = 0.8f;
        this.meta_trust = 0.8f;
        this.magic_neg = 0.100000024f;
        this.extension_neg = 0.19999999f;
        this.meta_neg = 0.19999999f;
        this.threshold = 0.5001f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        r3 = r2.lastIndexOf(47) + 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062 A[SYNTHETIC, Splitter:B:24:0x0062] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.tika.mime.MediaType detect(java.io.InputStream r6, org.apache.tika.metadata.Metadata r7) throws java.io.IOException {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r6 == 0) goto L_0x0028
            org.apache.tika.mime.MimeTypes r1 = r5.mimeTypes
            int r1 = r1.getMinLength()
            r6.mark(r1)
            org.apache.tika.mime.MimeTypes r1 = r5.mimeTypes     // Catch:{ all -> 0x0023 }
            byte[] r1 = r1.readMagicHeader(r6)     // Catch:{ all -> 0x0023 }
            org.apache.tika.mime.MimeTypes r2 = r5.mimeTypes     // Catch:{ all -> 0x0023 }
            java.util.List r1 = r2.getMimeType((byte[]) r1)     // Catch:{ all -> 0x0023 }
            r0.addAll(r1)     // Catch:{ all -> 0x0023 }
            r6.reset()
            goto L_0x0028
        L_0x0023:
            r5 = move-exception
            r6.reset()
            throw r5
        L_0x0028:
            java.lang.String r6 = "resourceName"
            java.lang.String r6 = r7.get((java.lang.String) r6)
            r1 = 0
            if (r6 == 0) goto L_0x0059
            java.net.URI r2 = new java.net.URI     // Catch:{ URISyntaxException -> 0x0050 }
            r2.<init>(r6)     // Catch:{ URISyntaxException -> 0x0050 }
            java.lang.String r2 = r2.getPath()     // Catch:{ URISyntaxException -> 0x0050 }
            if (r2 == 0) goto L_0x004f
            r3 = 47
            int r3 = r2.lastIndexOf(r3)     // Catch:{ URISyntaxException -> 0x0050 }
            int r3 = r3 + 1
            int r4 = r2.length()     // Catch:{ URISyntaxException -> 0x0050 }
            if (r3 >= r4) goto L_0x004f
            java.lang.String r6 = r2.substring(r3)     // Catch:{ URISyntaxException -> 0x0050 }
            goto L_0x0050
        L_0x004f:
            r6 = r1
        L_0x0050:
            if (r6 == 0) goto L_0x0059
            org.apache.tika.mime.MimeTypes r2 = r5.mimeTypes
            org.apache.tika.mime.MimeType r6 = r2.getMimeType((java.lang.String) r6)
            goto L_0x005a
        L_0x0059:
            r6 = r1
        L_0x005a:
            java.lang.String r2 = "Content-Type"
            java.lang.String r7 = r7.get((java.lang.String) r2)
            if (r7 == 0) goto L_0x0068
            org.apache.tika.mime.MimeTypes r2 = r5.mimeTypes     // Catch:{ MimeTypeException -> 0x0068 }
            org.apache.tika.mime.MimeType r1 = r2.forName(r7)     // Catch:{ MimeTypeException -> 0x0068 }
        L_0x0068:
            org.apache.tika.mime.MediaType r5 = r5.applyProbilities(r0, r6, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.mime.ProbabilisticMimeDetectionSelector.detect(java.io.InputStream, org.apache.tika.metadata.Metadata):org.apache.tika.mime.MediaType");
    }

    public MediaTypeRegistry getMediaTypeRegistry() {
        return this.mimeTypes.getMediaTypeRegistry();
    }

    public ProbabilisticMimeDetectionSelector(Builder builder) {
        this(MimeTypes.getDefaultMimeTypes(), builder);
    }

    public ProbabilisticMimeDetectionSelector(MimeTypes mimeTypes2) {
        this(mimeTypes2, (Builder) null);
    }

    public ProbabilisticMimeDetectionSelector(MimeTypes mimeTypes2, Builder builder) {
        float f;
        float f2;
        this.mimeTypes = mimeTypes2;
        this.rootMediaType = MediaType.OCTET_STREAM;
        initializeDefaultProbabilityParameters();
        this.changeRate = 0.1f;
        if (builder != null) {
            if (builder.f9154a == 0.0f) {
                f = this.priorMagicFileType;
            } else {
                f = builder.f9154a;
            }
            this.priorMagicFileType = f;
            if (builder.b == 0.0f) {
                f2 = this.priorExtensionFileType;
            } else {
                f2 = builder.b;
            }
            this.priorExtensionFileType = f2;
            this.priorMetaFileType = builder.c == 0.0f ? this.priorMetaFileType : builder.c;
            this.magic_trust = builder.d == 0.0f ? this.magic_trust : builder.h;
            this.extension_trust = builder.e == 0.0f ? this.extension_trust : builder.e;
            this.meta_trust = builder.f == 0.0f ? this.meta_trust : builder.f;
            this.magic_neg = builder.g == 0.0f ? this.magic_neg : builder.g;
            this.extension_neg = builder.h == 0.0f ? this.extension_neg : builder.h;
            this.meta_neg = builder.i == 0.0f ? this.meta_neg : builder.i;
            this.threshold = builder.j == 0.0f ? this.threshold : builder.j;
        }
    }
}
