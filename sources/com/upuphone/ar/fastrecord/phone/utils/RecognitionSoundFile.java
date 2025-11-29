package com.upuphone.ar.fastrecord.phone.utils;

import com.here.posclient.PositionEstimate;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u0014\u0010\u0007\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0013@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecognitionSoundFile;", "", "filePath", "", "count", "", "(Ljava/lang/String;I)V", "TAG", "getTAG", "()Ljava/lang/String;", "channels", "decodeBytes", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "<set-?>", "", "duration", "getDuration", "()J", "", "frameGains", "getFrameGains", "()[I", "frameLens", "frameOffsets", "framesTimes", "", "numFrames", "getNumFrames", "()I", "sampleRate", "readFile", "", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecognitionSoundFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecognitionSoundFile.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecognitionSoundFile\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,225:1\n1#2:226\n731#3,9:227\n37#4,2:236\n*S KotlinDebug\n*F\n+ 1 RecognitionSoundFile.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecognitionSoundFile\n*L\n49#1:227,9\n49#1:236,2\n*E\n"})
public final class RecognitionSoundFile {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String[] SUPPORTED_EXTENSIONS = {"mp3", "wav", "3gpp", "3gp", "amr", "aac", "m4a", "ogg"};
    @NotNull
    private final String TAG = "RecognitionSoundFile";
    private int channels;
    private ByteBuffer decodeBytes = ByteBuffer.allocate(PositionEstimate.Value.SITUATION);
    private long duration;
    @NotNull
    private int[] frameGains = new int[0];
    @NotNull
    private int[] frameLens = new int[0];
    @NotNull
    private int[] frameOffsets = new int[0];
    @NotNull
    private long[] framesTimes = new long[0];
    private int numFrames = 1;
    private int sampleRate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecognitionSoundFile$Companion;", "", "()V", "SUPPORTED_EXTENSIONS", "", "", "[Ljava/lang/String;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RecognitionSoundFile(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        try {
            Result.Companion companion = Result.Companion;
            readFile(str, i);
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x0250 A[EDGE_INSN: B:125:0x0250->B:83:0x0250 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x029b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readFile(java.lang.String r27, int r28) {
        /*
            r26 = this;
            r1 = r26
            r2 = r28
            java.io.File r0 = new java.io.File
            r3 = r27
            r0.<init>(r3)
            boolean r3 = r0.exists()
            if (r3 == 0) goto L_0x0377
            boolean r3 = r0.isDirectory()
            if (r3 == 0) goto L_0x0019
            goto L_0x0377
        L_0x0019:
            java.lang.String r3 = r0.getName()
            java.lang.String r4 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r5 = "getDefault(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r3 = r3.toLowerCase(r4)
            java.lang.String r4 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            kotlin.text.Regex r4 = new kotlin.text.Regex
            java.lang.String r5 = "\\."
            r4.<init>((java.lang.String) r5)
            r5 = 0
            java.util.List r3 = r4.split(r3, r5)
            boolean r4 = r3.isEmpty()
            r6 = 1
            if (r4 != 0) goto L_0x006d
            int r4 = r3.size()
            java.util.ListIterator r4 = r3.listIterator(r4)
        L_0x0050:
            boolean r7 = r4.hasPrevious()
            if (r7 == 0) goto L_0x006d
            java.lang.Object r7 = r4.previous()
            java.lang.String r7 = (java.lang.String) r7
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0063
            goto L_0x0050
        L_0x0063:
            int r4 = r4.nextIndex()
            int r4 = r4 + r6
            java.util.List r3 = kotlin.collections.CollectionsKt.take(r3, r4)
            goto L_0x0071
        L_0x006d:
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0071:
            java.lang.String[] r4 = new java.lang.String[r5]
            java.lang.Object[] r3 = r3.toArray(r4)
            java.lang.String[] r3 = (java.lang.String[]) r3
            int r4 = r3.length
            r7 = 2
            if (r4 >= r7) goto L_0x0085
            java.lang.String r0 = "File state exception"
            java.lang.String r1 = r1.TAG
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r1)
            return
        L_0x0085:
            java.lang.String[] r4 = SUPPORTED_EXTENSIONS
            int r8 = r3.length
            int r8 = r8 - r6
            r3 = r3[r8]
            boolean r3 = kotlin.collections.ArraysKt.contains((T[]) r4, r3)
            if (r3 != 0) goto L_0x0099
            java.lang.String r0 = "File extension not supported"
            java.lang.String r1 = r1.TAG
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r1)
            return
        L_0x0099:
            int r3 = r2 + 2
            long[] r3 = new long[r3]
            r1.framesTimes = r3
            android.media.MediaExtractor r3 = new android.media.MediaExtractor
            r3.<init>()
            java.lang.String r4 = r0.getAbsolutePath()
            r3.setDataSource(r4)
            int r4 = r3.getTrackCount()
            r8 = 0
            r9 = r5
            r10 = r8
        L_0x00b2:
            java.lang.String r11 = "mime"
            if (r9 >= r4) goto L_0x00d9
            android.media.MediaFormat r10 = r3.getTrackFormat(r9)
            java.lang.String r12 = r10.getString(r11)
            if (r12 == 0) goto L_0x00cb
            java.lang.String r13 = "audio/"
            boolean r12 = kotlin.text.StringsKt.startsWith$default(r12, r13, r5, r7, r8)
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            goto L_0x00cc
        L_0x00cb:
            r12 = r8
        L_0x00cc:
            boolean r12 = com.upuphone.ar.fastrecord.phone.utils.RecordExtKt.default$default((java.lang.Boolean) r12, (boolean) r5, (int) r6, (java.lang.Object) r8)
            if (r12 == 0) goto L_0x00d6
            r3.selectTrack(r9)
            goto L_0x00d9
        L_0x00d6:
            int r9 = r9 + 1
            goto L_0x00b2
        L_0x00d9:
            if (r10 == 0) goto L_0x00e6
            java.lang.String r4 = "channel-count"
            int r4 = r10.getInteger(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00e7
        L_0x00e6:
            r4 = r8
        L_0x00e7:
            int r4 = com.upuphone.ar.fastrecord.phone.utils.RecordExtKt.default$default((java.lang.Integer) r4, (int) r5, (int) r6, (java.lang.Object) r8)
            r1.channels = r4
            if (r10 == 0) goto L_0x00fa
            java.lang.String r4 = "sample-rate"
            int r4 = r10.getInteger(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00fb
        L_0x00fa:
            r4 = r8
        L_0x00fb:
            int r4 = com.upuphone.ar.fastrecord.phone.utils.RecordExtKt.default$default((java.lang.Integer) r4, (int) r5, (int) r6, (java.lang.Object) r8)
            r1.sampleRate = r4
            if (r10 == 0) goto L_0x010e
            java.lang.String r4 = "durationUs"
            long r12 = r10.getLong(r4)
            java.lang.Long r4 = java.lang.Long.valueOf(r12)
            goto L_0x010f
        L_0x010e:
            r4 = r8
        L_0x010f:
            r12 = 0
            long r12 = com.upuphone.ar.fastrecord.phone.utils.RecordExtKt.default$default((java.lang.Long) r4, (long) r12, (int) r6, (java.lang.Object) r8)
            r4 = 1000(0x3e8, float:1.401E-42)
            long r14 = (long) r4
            long r12 = r12 / r14
            r1.duration = r12
            float r9 = (float) r12
            r12 = 1148846080(0x447a0000, float:1000.0)
            float r9 = r9 / r12
            int r12 = r1.sampleRate
            float r12 = (float) r12
            float r9 = r9 * r12
            r12 = 1056964608(0x3f000000, float:0.5)
            float r9 = r9 + r12
            int r9 = (int) r9
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.lang.String r11 = r10.getString(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            android.media.MediaCodec r11 = android.media.MediaCodec.createDecoderByType(r11)
            java.lang.String r12 = "createDecoderByType(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            r11.configure(r10, r8, r8, r5)
            r11.start()
            java.nio.ByteBuffer[] r10 = r11.getInputBuffers()
            java.lang.String r12 = "getInputBuffers(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            java.nio.ByteBuffer[] r12 = r11.getOutputBuffers()
            java.lang.String r15 = "getOutputBuffers(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
            android.media.MediaCodec$BufferInfo r14 = new android.media.MediaCodec$BufferInfo
            r14.<init>()
            long r16 = r0.length()
            r19 = r9
            long r8 = (long) r2
            long r8 = r16 / r8
            r13 = r5
            r21 = r13
            r22 = r21
            r20 = r12
            r23 = 0
            r12 = r22
        L_0x016b:
            r6 = 100
            int r16 = r11.dequeueInputBuffer(r6)
            if (r21 != 0) goto L_0x01e1
            if (r16 < 0) goto L_0x01e1
            r4 = r10[r16]
            int r4 = r3.readSampleData(r4, r5)
            if (r4 >= 0) goto L_0x01a0
            r17 = -1
            r4 = 4
            r21 = 0
            r24 = 0
            r5 = r12
            r12 = r11
            r6 = r13
            r13 = r16
            r7 = r14
            r14 = r21
            r25 = r15
            r15 = r24
            r16 = r17
            r18 = r4
            r12.queueInputBuffer(r13, r14, r15, r16, r18)
            r13 = r6
            r15 = r8
            r14 = r22
            r8 = 100
            r21 = 1
            goto L_0x01eb
        L_0x01a0:
            r5 = r12
            r6 = r13
            r7 = r14
            r25 = r15
            long r17 = r3.getSampleTime()
            long[] r12 = r1.framesTimes
            int r12 = r12.length
            if (r6 < r12) goto L_0x01b5
            java.lang.String r12 = "SoundFile00 ReadFile1 t >= count errer!"
            java.lang.String r13 = r1.TAG
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r12, r13)
        L_0x01b5:
            int r6 = r6 + 1
            long[] r12 = r1.framesTimes
            int r13 = r12.length
            if (r13 <= r6) goto L_0x01be
            r12[r6] = r17
        L_0x01be:
            r14 = 0
            r24 = 0
            r12 = r11
            r13 = r16
            r15 = r4
            r16 = r17
            r18 = r24
            r12.queueInputBuffer(r13, r14, r15, r16, r18)
            long r12 = (long) r6
            long r12 = r12 * r8
        L_0x01ce:
            r3.advance()
            int r14 = r22 + r4
            r15 = r8
            long r8 = (long) r14
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 <= 0) goto L_0x01dd
            r13 = r6
        L_0x01da:
            r8 = 100
            goto L_0x01eb
        L_0x01dd:
            r22 = r14
            r8 = r15
            goto L_0x01ce
        L_0x01e1:
            r5 = r12
            r6 = r13
            r7 = r14
            r25 = r15
            r15 = r8
            r13 = r6
            r14 = r22
            goto L_0x01da
        L_0x01eb:
            int r4 = r11.dequeueOutputBuffer(r7, r8)
            if (r4 < 0) goto L_0x027c
            int r12 = r7.size
            if (r12 <= 0) goto L_0x027c
            if (r5 >= r12) goto L_0x01fc
            byte[] r5 = new byte[r12]
            r6 = r5
            r5 = r12
            goto L_0x01fe
        L_0x01fc:
            r6 = r23
        L_0x01fe:
            r8 = r20[r4]
            r9 = 0
            r8.get(r6, r9, r12)
            r8 = r20[r4]
            r8.clear()
            java.nio.ByteBuffer r8 = r1.decodeBytes
            int r8 = r8.remaining()
            int r9 = r7.size
            if (r8 >= r9) goto L_0x0265
            java.nio.ByteBuffer r8 = r1.decodeBytes
            int r8 = r8.position()
            r12 = r10
            double r9 = (double) r8
            r18 = r12
            r17 = r13
            long r12 = r0.length()
            double r12 = (double) r12
            r22 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r12 = r12 * r22
            r22 = r3
            double r2 = (double) r14
            double r12 = r12 / r2
            double r9 = r9 * r12
            r2 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            double r9 = r9 * r2
            int r2 = (int) r9
            int r3 = r2 - r8
            int r9 = r7.size
            r10 = 5242880(0x500000, float:7.34684E-39)
            int r12 = r9 + r10
            if (r3 >= r12) goto L_0x0241
            int r9 = r9 + r8
            int r2 = r9 + r10
        L_0x0241:
            r3 = 10
        L_0x0243:
            if (r3 <= 0) goto L_0x024d
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)     // Catch:{ OutOfMemoryError -> 0x024a }
            goto L_0x024e
        L_0x024a:
            int r3 = r3 + -1
            goto L_0x0243
        L_0x024d:
            r2 = 0
        L_0x024e:
            if (r3 != 0) goto L_0x0253
        L_0x0250:
            r5 = 2
            goto L_0x02bf
        L_0x0253:
            java.nio.ByteBuffer r3 = r1.decodeBytes
            r3.rewind()
            if (r2 == 0) goto L_0x025f
            java.nio.ByteBuffer r3 = r1.decodeBytes
            r2.put(r3)
        L_0x025f:
            r1.decodeBytes = r2
            r2.position(r8)
            goto L_0x026b
        L_0x0265:
            r22 = r3
            r18 = r10
            r17 = r13
        L_0x026b:
            java.nio.ByteBuffer r2 = r1.decodeBytes
            int r3 = r7.size
            r8 = 0
            r2.put(r6, r8, r3)
            r11.releaseOutputBuffer(r4, r8)
            r12 = r5
            r23 = r6
            r3 = r25
            goto L_0x0295
        L_0x027c:
            r22 = r3
            r18 = r10
            r17 = r13
            r2 = -3
            if (r4 != r2) goto L_0x0292
            java.nio.ByteBuffer[] r2 = r11.getOutputBuffers()
            r3 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r20 = r2
        L_0x0290:
            r12 = r5
            goto L_0x0295
        L_0x0292:
            r3 = r25
            goto L_0x0290
        L_0x0295:
            int r2 = r7.flags
            r2 = r2 & 4
            if (r2 != 0) goto L_0x0250
            java.nio.ByteBuffer r2 = r1.decodeBytes
            int r2 = r2.position()
            int r4 = r1.channels
            r5 = 2
            int r4 = r4 * r5
            int r2 = r2 / r4
            r4 = r19
            if (r2 < r4) goto L_0x02ab
            goto L_0x02bf
        L_0x02ab:
            r2 = r28
            r19 = r4
            r8 = r15
            r13 = r17
            r10 = r18
            r4 = 1000(0x3e8, float:1.401E-42)
            r5 = 0
            r15 = r3
            r3 = r22
            r22 = r14
            r14 = r7
            goto L_0x016b
        L_0x02bf:
            java.nio.ByteBuffer r2 = r1.decodeBytes
            int r2 = r2.position()
            int r3 = r1.channels
            int r3 = r3 * r5
            int r2 = r2 / r3
            java.nio.ByteBuffer r3 = r1.decodeBytes
            r3.rewind()
            java.nio.ByteBuffer r3 = r1.decodeBytes
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN
            r3.order(r4)
            java.nio.ByteBuffer r3 = r1.decodeBytes
            java.nio.ShortBuffer r3 = r3.asShortBuffer()
            long r4 = r0.length()
            r0 = 8
            long r6 = (long) r0
            long r4 = r4 * r6
            float r0 = (float) r4
            int r4 = r1.sampleRate
            float r4 = (float) r4
            float r2 = (float) r2
            float r4 = r4 / r2
            float r0 = r0 * r4
            r4 = 1000(0x3e8, float:1.401E-42)
            float r5 = (float) r4
            float r0 = r0 / r5
            int r4 = (int) r0
            r5 = r22
            r9 = 0
            android.media.MediaFormat r0 = r5.getTrackFormat(r9)     // Catch:{ Exception -> 0x02fd }
            java.lang.String r6 = "bitrate"
            int r0 = r0.getInteger(r6)     // Catch:{ Exception -> 0x02fd }
            goto L_0x0304
        L_0x02fd:
            r0 = move-exception
            r0.printStackTrace()
            r0 = 40000(0x9c40, float:5.6052E-41)
        L_0x0304:
            r5.release()
            r11.stop()
            r11.release()
            r5 = r28
            r1.numFrames = r5
            float r6 = (float) r5
            float r2 = r2 / r6
            int r2 = (int) r2
            int[] r6 = new int[r5]
            r1.frameGains = r6
            int[] r6 = new int[r5]
            r1.frameLens = r6
            int[] r6 = new int[r5]
            r1.frameOffsets = r6
            r6 = 1000(0x3e8, float:1.401E-42)
            int r4 = r4 * r6
            int r4 = r4 / r0
            float r0 = (float) r4
            float r6 = (float) r2
            int r7 = r1.sampleRate
            float r7 = (float) r7
            float r7 = r6 / r7
            float r0 = r0 * r7
            int r0 = (int) r0
            r7 = r9
        L_0x032e:
            if (r7 >= r5) goto L_0x0374
            r8 = -1
            r10 = r9
        L_0x0332:
            if (r10 >= r2) goto L_0x0355
            int r11 = r1.channels
            r12 = r9
            r13 = r12
        L_0x0338:
            if (r12 >= r11) goto L_0x034c
            int r14 = r3.remaining()
            if (r14 <= 0) goto L_0x0349
            short r14 = r3.get()
            int r14 = java.lang.Math.abs(r14)
            int r13 = r13 + r14
        L_0x0349:
            int r12 = r12 + 1
            goto L_0x0338
        L_0x034c:
            int r11 = r1.channels
            int r13 = r13 / r11
            if (r8 >= r13) goto L_0x0352
            r8 = r13
        L_0x0352:
            int r10 = r10 + 1
            goto L_0x0332
        L_0x0355:
            int[] r10 = r1.frameGains
            double r11 = (double) r8
            double r11 = java.lang.Math.sqrt(r11)
            int r8 = (int) r11
            r10[r7] = r8
            int[] r8 = r1.frameLens
            r8[r7] = r0
            int[] r8 = r1.frameOffsets
            int r10 = r7 * r4
            float r10 = (float) r10
            int r11 = r1.sampleRate
            float r11 = (float) r11
            float r11 = r6 / r11
            float r10 = r10 * r11
            int r10 = (int) r10
            r8[r7] = r10
            int r7 = r7 + 1
            goto L_0x032e
        L_0x0374:
            r3.rewind()
        L_0x0377:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecognitionSoundFile.readFile(java.lang.String, int):void");
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final int[] getFrameGains() {
        return this.frameGains;
    }

    public final int getNumFrames() {
        return this.numFrames;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }
}
