package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nEncodersJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EncodersJvm.kt\nio/ktor/util/EncodersJvmKt$inflate$1\n+ 2 ByteReadChannel.kt\nio/ktor/utils/io/ByteReadChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,160:1\n232#2,2:161\n232#2,2:164\n1#3:163\n*S KotlinDebug\n*F\n+ 1 EncodersJvm.kt\nio/ktor/util/EncodersJvmKt$inflate$1\n*L\n86#1:161,2\n96#1:164,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.EncodersJvmKt$inflate$1", f = "EncodersJvm.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {68, 85, 161, 164, 103, 109, 121}, m = "invokeSuspend", n = {"$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "extraLen", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "n$iv", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
final class EncodersJvmKt$inflate$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $gzip;
    final /* synthetic */ ByteReadChannel $source;
    byte B$0;
    byte B$1;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    short S$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EncodersJvmKt$inflate$1(boolean z, ByteReadChannel byteReadChannel, Continuation<? super EncodersJvmKt$inflate$1> continuation) {
        super(2, continuation);
        this.$gzip = z;
        this.$source = byteReadChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        EncodersJvmKt$inflate$1 encodersJvmKt$inflate$1 = new EncodersJvmKt$inflate$1(this.$gzip, this.$source, continuation);
        encodersJvmKt$inflate$1.L$0 = obj;
        return encodersJvmKt$inflate$1;
    }

    @Nullable
    public final Object invoke(@NotNull WriterScope writerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((EncodersJvmKt$inflate$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: io.ktor.utils.io.WriterScope} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: java.nio.ByteBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.nio.ByteBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v31, resolved type: java.util.zip.Inflater} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: java.nio.ByteBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: java.nio.ByteBuffer} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0369, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x036a, code lost:
        r6 = r5;
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x036c, code lost:
        r3.element = r2 + ((java.lang.Number) r4).intValue();
        r11.position(r11.limit() - r9.getRemaining());
        r3 = r5;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0386, code lost:
        if (r0.$gzip == false) goto L_0x0408;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x038e, code lost:
        if (r11.remaining() != 8) goto L_0x03e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0390, code lost:
        r11.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        r0 = r11.getInt(r11.position());
        r1 = r11.getInt(r11.position() + 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x03ac, code lost:
        if (((int) r5.getValue()) != r0) goto L_0x03d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x03b0, code lost:
        if (r3.element != r1) goto L_0x03b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03d7, code lost:
        throw new java.lang.IllegalStateException(("Gzip size invalid. Expected " + r1 + ", actual " + r3.element).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x03e3, code lost:
        throw new java.lang.IllegalStateException("Gzip checksum invalid.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0407, code lost:
        throw new java.lang.IllegalStateException(("Expected 8 bytes in the trailer. Actual: " + r11.remaining() + " $").toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x040e, code lost:
        if ((!r11.hasRemaining()) == false) goto L_0x0424;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0410, code lost:
        r9.end();
        io.ktor.util.cio.ByteBufferPoolKt.a().recycle(r11);
        io.ktor.util.cio.ByteBufferPoolKt.a().recycle(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0423, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x042f, code lost:
        throw new java.lang.IllegalStateException("Check failed.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0430, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0431, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0432, code lost:
        r10 = r11;
        r11 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0154, code lost:
        r11 = (io.ktor.utils.io.core.ByteReadPacket) r11;
        r12 = io.ktor.utils.io.core.InputLittleEndianKt.a(r11);
        r13 = r11.readByte();
        r14 = r11.readByte();
        io.ktor.utils.io.core.InputKt.a(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0167, code lost:
        if ((r14 & 4) == 0) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0169, code lost:
        r11 = r0.$source;
        r0.L$0 = r10;
        r0.L$1 = r9;
        r0.L$2 = r7;
        r0.L$3 = r6;
        r0.L$4 = r2;
        r0.S$0 = r12;
        r0.B$0 = r13;
        r0.B$1 = r14;
        r0.label = 2;
        r11 = r11.G(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0181, code lost:
        if (r11 != r1) goto L_0x0184;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0183, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0184, code lost:
        r15 = r7;
        r7 = r9;
        r9 = r2;
        r2 = r14;
        r14 = r6;
        r6 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x018a, code lost:
        r10 = (long) ((java.lang.Number) r11).shortValue();
        r5 = r0.$source;
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.L$2 = r15;
        r0.L$3 = r14;
        r0.L$4 = r9;
        r0.S$0 = r12;
        r0.B$0 = r13;
        r0.B$1 = r2;
        r0.J$0 = r10;
        r0.label = 3;
        r5 = r5.k(r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x01ac, code lost:
        if (r5 != r1) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x01ae, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01af, code lost:
        r18 = r13;
        r13 = r9;
        r9 = r10;
        r11 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01bd, code lost:
        if (((java.lang.Number) r5).longValue() != r9) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01bf, code lost:
        r5 = r14;
        r14 = r2;
        r2 = r13;
        r13 = r11;
        r11 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01dc, code lost:
        throw new java.io.EOFException("Unable to discard " + r9 + " bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01dd, code lost:
        r5 = r6;
        r11 = r7;
        r7 = r9;
        r6 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01e3, code lost:
        if (r12 != -29921) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01e7, code lost:
        if (r13 != 8) goto L_0x025f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01ef, code lost:
        if ((!io.ktor.util.EncodersJvmKt.c(r14, 8)) == false) goto L_0x0253;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01f8, code lost:
        if ((!io.ktor.util.EncodersJvmKt.c(r14, 16)) == false) goto L_0x0247;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01ff, code lost:
        if (io.ktor.util.EncodersJvmKt.c(r14, 2) == false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0201, code lost:
        r8 = r0.$source;
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.L$2 = r11;
        r0.L$3 = r5;
        r0.L$4 = r2;
        r9 = 2;
        r0.J$0 = 2;
        r0.label = 4;
        r8 = r8.k(2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0218, code lost:
        if (r8 != r1) goto L_0x021b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x021a, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x021b, code lost:
        r13 = r6;
        r12 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0225, code lost:
        if (((java.lang.Number) r8).longValue() != r9) goto L_0x022c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0227, code lost:
        r9 = r5;
        r7 = r12;
        r10 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0243, code lost:
        throw new java.io.EOFException("Unable to discard " + r9 + " bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0244, code lost:
        r9 = r5;
        r10 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0252, code lost:
        throw new java.lang.IllegalStateException("Gzip file comment not supported".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x025e, code lost:
        throw new java.lang.IllegalStateException("Gzip file name not supported".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x027e, code lost:
        throw new java.lang.IllegalStateException(("Deflater method unsupported: " + r13 + '.').toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0299, code lost:
        throw new java.lang.IllegalStateException(("GZIP magic invalid: " + r12).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x02a2, code lost:
        r4 = r10;
        r10 = r11;
        r11 = r7;
        r3 = r2;
        r2 = new kotlin.jvm.internal.Ref.IntRef();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02b0, code lost:
        if (r0.$source.Q() != false) goto L_0x0336;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02b2, code lost:
        r5 = r0.$source;
        r0.L$0 = r4;
        r0.L$1 = r11;
        r0.L$2 = r10;
        r0.L$3 = r9;
        r0.L$4 = r3;
        r0.L$5 = r2;
        r0.L$6 = null;
        r0.label = 5;
        r5 = r5.u(r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x02ca, code lost:
        if (r5 != r1) goto L_0x02cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x02cc, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02d3, code lost:
        if (((java.lang.Number) r5).intValue() <= 0) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02d5, code lost:
        r11.flip();
        r9.setInput(r11.array(), r11.position(), r11.remaining());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02eb, code lost:
        if (r9.needsInput() != false) goto L_0x0331;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02f1, code lost:
        if (r9.finished() != false) goto L_0x0331;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02f3, code lost:
        r5 = r2.element;
        r6 = r4.b();
        r0.L$0 = r4;
        r0.L$1 = r11;
        r0.L$2 = r10;
        r0.L$3 = r9;
        r0.L$4 = r3;
        r0.L$5 = r2;
        r0.L$6 = r2;
        r0.I$0 = r5;
        r0.label = 6;
        r6 = io.ktor.util.EncodersJvmKt.d(r9, r6, r10, r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0310, code lost:
        if (r6 != r1) goto L_0x0313;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0312, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0313, code lost:
        r12 = r4;
        r4 = r2;
        r2 = r5;
        r5 = r3;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0318, code lost:
        r3.element = r2 + ((java.lang.Number) r6).intValue();
        r11.position(r11.limit() - r9.getRemaining());
        r2 = r4;
        r3 = r5;
        r4 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0331, code lost:
        r11.compact();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0336, code lost:
        r5 = r0.$source.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x033c, code lost:
        if (r5 != null) goto L_0x0430;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x033e, code lost:
        r11.flip();
        r5 = r3;
        r12 = r4;
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0348, code lost:
        if (r9.finished() != false) goto L_0x0384;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x034a, code lost:
        r2 = r3.element;
        r4 = r12.b();
        r0.L$0 = r12;
        r0.L$1 = r11;
        r0.L$2 = r10;
        r0.L$3 = r9;
        r0.L$4 = r5;
        r0.L$5 = r3;
        r0.L$6 = r3;
        r0.I$0 = r2;
        r0.label = 7;
        r4 = io.ktor.util.EncodersJvmKt.d(r9, r4, r10, r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0367, code lost:
        if (r4 != r1) goto L_0x036a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = " bytes"
            java.lang.String r4 = "Unable to discard "
            r5 = 2
            r8 = 1
            switch(r2) {
                case 0: goto L_0x0111;
                case 1: goto L_0x00f7;
                case 2: goto L_0x00ca;
                case 3: goto L_0x00a7;
                case 4: goto L_0x008a;
                case 5: goto L_0x0068;
                case 6: goto L_0x0043;
                case 7: goto L_0x0019;
                default: goto L_0x0011;
            }
        L_0x0011:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0019:
            int r2 = r0.I$0
            java.lang.Object r3 = r0.L$6
            kotlin.jvm.internal.Ref$IntRef r3 = (kotlin.jvm.internal.Ref.IntRef) r3
            java.lang.Object r4 = r0.L$5
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r5 = r0.L$4
            java.util.zip.CRC32 r5 = (java.util.zip.CRC32) r5
            java.lang.Object r9 = r0.L$3
            java.util.zip.Inflater r9 = (java.util.zip.Inflater) r9
            java.lang.Object r10 = r0.L$2
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            java.lang.Object r11 = r0.L$1
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11
            java.lang.Object r12 = r0.L$0
            io.ktor.utils.io.WriterScope r12 = (io.ktor.utils.io.WriterScope) r12
            kotlin.ResultKt.throwOnFailure(r21)     // Catch:{ all -> 0x0040 }
            r6 = r5
            r5 = r4
            r4 = r21
            goto L_0x036c
        L_0x0040:
            r0 = move-exception
            goto L_0x0434
        L_0x0043:
            int r2 = r0.I$0
            java.lang.Object r3 = r0.L$6
            kotlin.jvm.internal.Ref$IntRef r3 = (kotlin.jvm.internal.Ref.IntRef) r3
            java.lang.Object r4 = r0.L$5
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r5 = r0.L$4
            java.util.zip.CRC32 r5 = (java.util.zip.CRC32) r5
            java.lang.Object r9 = r0.L$3
            java.util.zip.Inflater r9 = (java.util.zip.Inflater) r9
            java.lang.Object r10 = r0.L$2
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            java.lang.Object r11 = r0.L$1
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11
            java.lang.Object r12 = r0.L$0
            io.ktor.utils.io.WriterScope r12 = (io.ktor.utils.io.WriterScope) r12
            kotlin.ResultKt.throwOnFailure(r21)     // Catch:{ all -> 0x0040 }
            r6 = r21
            goto L_0x0318
        L_0x0068:
            java.lang.Object r2 = r0.L$5
            kotlin.jvm.internal.Ref$IntRef r2 = (kotlin.jvm.internal.Ref.IntRef) r2
            java.lang.Object r3 = r0.L$4
            java.util.zip.CRC32 r3 = (java.util.zip.CRC32) r3
            java.lang.Object r4 = r0.L$3
            r9 = r4
            java.util.zip.Inflater r9 = (java.util.zip.Inflater) r9
            java.lang.Object r4 = r0.L$2
            r10 = r4
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            java.lang.Object r4 = r0.L$1
            r11 = r4
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.WriterScope r4 = (io.ktor.utils.io.WriterScope) r4
            kotlin.ResultKt.throwOnFailure(r21)     // Catch:{ all -> 0x0040 }
            r5 = r21
            goto L_0x02cd
        L_0x008a:
            long r9 = r0.J$0
            java.lang.Object r2 = r0.L$4
            java.util.zip.CRC32 r2 = (java.util.zip.CRC32) r2
            java.lang.Object r5 = r0.L$3
            java.util.zip.Inflater r5 = (java.util.zip.Inflater) r5
            java.lang.Object r11 = r0.L$2
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11
            java.lang.Object r12 = r0.L$1
            java.nio.ByteBuffer r12 = (java.nio.ByteBuffer) r12
            java.lang.Object r13 = r0.L$0
            io.ktor.utils.io.WriterScope r13 = (io.ktor.utils.io.WriterScope) r13
            kotlin.ResultKt.throwOnFailure(r21)
            r8 = r21
            goto L_0x021d
        L_0x00a7:
            long r9 = r0.J$0
            byte r2 = r0.B$1
            byte r11 = r0.B$0
            short r12 = r0.S$0
            java.lang.Object r13 = r0.L$4
            java.util.zip.CRC32 r13 = (java.util.zip.CRC32) r13
            java.lang.Object r14 = r0.L$3
            java.util.zip.Inflater r14 = (java.util.zip.Inflater) r14
            java.lang.Object r15 = r0.L$2
            java.nio.ByteBuffer r15 = (java.nio.ByteBuffer) r15
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.WriterScope r6 = (io.ktor.utils.io.WriterScope) r6
            kotlin.ResultKt.throwOnFailure(r21)
            r5 = r21
            goto L_0x01b5
        L_0x00ca:
            byte r2 = r0.B$1
            byte r6 = r0.B$0
            short r7 = r0.S$0
            java.lang.Object r9 = r0.L$4
            java.util.zip.CRC32 r9 = (java.util.zip.CRC32) r9
            java.lang.Object r10 = r0.L$3
            java.util.zip.Inflater r10 = (java.util.zip.Inflater) r10
            java.lang.Object r11 = r0.L$2
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11
            java.lang.Object r12 = r0.L$1
            java.nio.ByteBuffer r12 = (java.nio.ByteBuffer) r12
            java.lang.Object r13 = r0.L$0
            io.ktor.utils.io.WriterScope r13 = (io.ktor.utils.io.WriterScope) r13
            kotlin.ResultKt.throwOnFailure(r21)
            r14 = r10
            r15 = r11
            r11 = r21
            r18 = r13
            r13 = r6
            r6 = r18
            r19 = r12
            r12 = r7
            r7 = r19
            goto L_0x018a
        L_0x00f7:
            java.lang.Object r2 = r0.L$4
            java.util.zip.CRC32 r2 = (java.util.zip.CRC32) r2
            java.lang.Object r6 = r0.L$3
            java.util.zip.Inflater r6 = (java.util.zip.Inflater) r6
            java.lang.Object r7 = r0.L$2
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r9 = r0.L$1
            java.nio.ByteBuffer r9 = (java.nio.ByteBuffer) r9
            java.lang.Object r10 = r0.L$0
            io.ktor.utils.io.WriterScope r10 = (io.ktor.utils.io.WriterScope) r10
            kotlin.ResultKt.throwOnFailure(r21)
            r11 = r21
            goto L_0x0154
        L_0x0111:
            kotlin.ResultKt.throwOnFailure(r21)
            java.lang.Object r2 = r0.L$0
            r10 = r2
            io.ktor.utils.io.WriterScope r10 = (io.ktor.utils.io.WriterScope) r10
            io.ktor.utils.io.pool.ObjectPool r2 = io.ktor.util.cio.ByteBufferPoolKt.a()
            java.lang.Object r2 = r2.h0()
            r9 = r2
            java.nio.ByteBuffer r9 = (java.nio.ByteBuffer) r9
            io.ktor.utils.io.pool.ObjectPool r2 = io.ktor.util.cio.ByteBufferPoolKt.a()
            java.lang.Object r2 = r2.h0()
            r7 = r2
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.util.zip.Inflater r6 = new java.util.zip.Inflater
            r6.<init>(r8)
            java.util.zip.CRC32 r2 = new java.util.zip.CRC32
            r2.<init>()
            boolean r11 = r0.$gzip
            if (r11 == 0) goto L_0x029a
            io.ktor.utils.io.ByteReadChannel r11 = r0.$source
            r0.L$0 = r10
            r0.L$1 = r9
            r0.L$2 = r7
            r0.L$3 = r6
            r0.L$4 = r2
            r0.label = r8
            r12 = 10
            java.lang.Object r11 = r11.j(r12, r0)
            if (r11 != r1) goto L_0x0154
            return r1
        L_0x0154:
            io.ktor.utils.io.core.ByteReadPacket r11 = (io.ktor.utils.io.core.ByteReadPacket) r11
            short r12 = io.ktor.utils.io.core.InputLittleEndianKt.a(r11)
            byte r13 = r11.readByte()
            byte r14 = r11.readByte()
            io.ktor.utils.io.core.InputKt.a(r11)
            r11 = r14 & 4
            if (r11 == 0) goto L_0x01dd
            io.ktor.utils.io.ByteReadChannel r11 = r0.$source
            r0.L$0 = r10
            r0.L$1 = r9
            r0.L$2 = r7
            r0.L$3 = r6
            r0.L$4 = r2
            r0.S$0 = r12
            r0.B$0 = r13
            r0.B$1 = r14
            r0.label = r5
            java.lang.Object r11 = r11.G(r0)
            if (r11 != r1) goto L_0x0184
            return r1
        L_0x0184:
            r15 = r7
            r7 = r9
            r9 = r2
            r2 = r14
            r14 = r6
            r6 = r10
        L_0x018a:
            java.lang.Number r11 = (java.lang.Number) r11
            short r10 = r11.shortValue()
            long r10 = (long) r10
            io.ktor.utils.io.ByteReadChannel r5 = r0.$source
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r15
            r0.L$3 = r14
            r0.L$4 = r9
            r0.S$0 = r12
            r0.B$0 = r13
            r0.B$1 = r2
            r0.J$0 = r10
            r8 = 3
            r0.label = r8
            java.lang.Object r5 = r5.k(r10, r0)
            if (r5 != r1) goto L_0x01af
            return r1
        L_0x01af:
            r18 = r13
            r13 = r9
            r9 = r10
            r11 = r18
        L_0x01b5:
            java.lang.Number r5 = (java.lang.Number) r5
            long r16 = r5.longValue()
            int r5 = (r16 > r9 ? 1 : (r16 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01c5
            r5 = r14
            r14 = r2
            r2 = r13
            r13 = r11
            r11 = r15
            goto L_0x01e1
        L_0x01c5:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r9)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01dd:
            r5 = r6
            r11 = r7
            r7 = r9
            r6 = r10
        L_0x01e1:
            r8 = -29921(0xffffffffffff8b1f, float:NaN)
            if (r12 != r8) goto L_0x027f
            r8 = 8
            if (r13 != r8) goto L_0x025f
            boolean r9 = io.ktor.util.EncodersJvmKt.c(r14, r8)
            r8 = 1
            r9 = r9 ^ r8
            if (r9 == 0) goto L_0x0253
            r9 = 16
            boolean r9 = io.ktor.util.EncodersJvmKt.c(r14, r9)
            r9 = r9 ^ r8
            if (r9 == 0) goto L_0x0247
            r8 = 2
            boolean r8 = io.ktor.util.EncodersJvmKt.c(r14, r8)
            if (r8 == 0) goto L_0x0244
            io.ktor.utils.io.ByteReadChannel r8 = r0.$source
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r11
            r0.L$3 = r5
            r0.L$4 = r2
            r9 = 2
            r0.J$0 = r9
            r12 = 4
            r0.label = r12
            java.lang.Object r8 = r8.k(r9, r0)
            if (r8 != r1) goto L_0x021b
            return r1
        L_0x021b:
            r13 = r6
            r12 = r7
        L_0x021d:
            java.lang.Number r8 = (java.lang.Number) r8
            long r6 = r8.longValue()
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 != 0) goto L_0x022c
            r9 = r5
            r7 = r12
            r10 = r13
            goto L_0x029d
        L_0x022c:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r9)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0244:
            r9 = r5
            r10 = r6
            goto L_0x029d
        L_0x0247:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Gzip file comment not supported"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0253:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Gzip file name not supported"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x025f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Deflater method unsupported: "
            r0.append(r1)
            r0.append(r13)
            r1 = 46
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x027f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "GZIP magic invalid: "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x029a:
            r11 = r7
            r7 = r9
            r9 = r6
        L_0x029d:
            kotlin.jvm.internal.Ref$IntRef r3 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x0431 }
            r3.<init>()     // Catch:{ all -> 0x0431 }
            r4 = r10
            r10 = r11
            r11 = r7
            r18 = r3
            r3 = r2
            r2 = r18
        L_0x02aa:
            io.ktor.utils.io.ByteReadChannel r5 = r0.$source     // Catch:{ all -> 0x0040 }
            boolean r5 = r5.Q()     // Catch:{ all -> 0x0040 }
            if (r5 != 0) goto L_0x0336
            io.ktor.utils.io.ByteReadChannel r5 = r0.$source     // Catch:{ all -> 0x0040 }
            r0.L$0 = r4     // Catch:{ all -> 0x0040 }
            r0.L$1 = r11     // Catch:{ all -> 0x0040 }
            r0.L$2 = r10     // Catch:{ all -> 0x0040 }
            r0.L$3 = r9     // Catch:{ all -> 0x0040 }
            r0.L$4 = r3     // Catch:{ all -> 0x0040 }
            r0.L$5 = r2     // Catch:{ all -> 0x0040 }
            r6 = 0
            r0.L$6 = r6     // Catch:{ all -> 0x0040 }
            r6 = 5
            r0.label = r6     // Catch:{ all -> 0x0040 }
            java.lang.Object r5 = r5.u(r11, r0)     // Catch:{ all -> 0x0040 }
            if (r5 != r1) goto L_0x02cd
            return r1
        L_0x02cd:
            java.lang.Number r5 = (java.lang.Number) r5     // Catch:{ all -> 0x0040 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x0040 }
            if (r5 <= 0) goto L_0x02aa
            r11.flip()     // Catch:{ all -> 0x0040 }
            byte[] r5 = r11.array()     // Catch:{ all -> 0x0040 }
            int r6 = r11.position()     // Catch:{ all -> 0x0040 }
            int r7 = r11.remaining()     // Catch:{ all -> 0x0040 }
            r9.setInput(r5, r6, r7)     // Catch:{ all -> 0x0040 }
        L_0x02e7:
            boolean r5 = r9.needsInput()     // Catch:{ all -> 0x0040 }
            if (r5 != 0) goto L_0x0331
            boolean r5 = r9.finished()     // Catch:{ all -> 0x0040 }
            if (r5 != 0) goto L_0x0331
            int r5 = r2.element     // Catch:{ all -> 0x0040 }
            io.ktor.utils.io.ByteWriteChannel r6 = r4.b()     // Catch:{ all -> 0x0040 }
            r0.L$0 = r4     // Catch:{ all -> 0x0040 }
            r0.L$1 = r11     // Catch:{ all -> 0x0040 }
            r0.L$2 = r10     // Catch:{ all -> 0x0040 }
            r0.L$3 = r9     // Catch:{ all -> 0x0040 }
            r0.L$4 = r3     // Catch:{ all -> 0x0040 }
            r0.L$5 = r2     // Catch:{ all -> 0x0040 }
            r0.L$6 = r2     // Catch:{ all -> 0x0040 }
            r0.I$0 = r5     // Catch:{ all -> 0x0040 }
            r7 = 6
            r0.label = r7     // Catch:{ all -> 0x0040 }
            java.lang.Object r6 = io.ktor.util.EncodersJvmKt.d(r9, r6, r10, r3, r0)     // Catch:{ all -> 0x0040 }
            if (r6 != r1) goto L_0x0313
            return r1
        L_0x0313:
            r12 = r4
            r4 = r2
            r2 = r5
            r5 = r3
            r3 = r4
        L_0x0318:
            java.lang.Number r6 = (java.lang.Number) r6     // Catch:{ all -> 0x0040 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x0040 }
            int r2 = r2 + r6
            r3.element = r2     // Catch:{ all -> 0x0040 }
            int r2 = r11.limit()     // Catch:{ all -> 0x0040 }
            int r3 = r9.getRemaining()     // Catch:{ all -> 0x0040 }
            int r2 = r2 - r3
            r11.position(r2)     // Catch:{ all -> 0x0040 }
            r2 = r4
            r3 = r5
            r4 = r12
            goto L_0x02e7
        L_0x0331:
            r11.compact()     // Catch:{ all -> 0x0040 }
            goto L_0x02aa
        L_0x0336:
            io.ktor.utils.io.ByteReadChannel r5 = r0.$source     // Catch:{ all -> 0x0040 }
            java.lang.Throwable r5 = r5.f()     // Catch:{ all -> 0x0040 }
            if (r5 != 0) goto L_0x0430
            r11.flip()     // Catch:{ all -> 0x0040 }
            r5 = r3
            r12 = r4
            r3 = r2
        L_0x0344:
            boolean r2 = r9.finished()     // Catch:{ all -> 0x0040 }
            if (r2 != 0) goto L_0x0384
            int r2 = r3.element     // Catch:{ all -> 0x0040 }
            io.ktor.utils.io.ByteWriteChannel r4 = r12.b()     // Catch:{ all -> 0x0040 }
            r0.L$0 = r12     // Catch:{ all -> 0x0040 }
            r0.L$1 = r11     // Catch:{ all -> 0x0040 }
            r0.L$2 = r10     // Catch:{ all -> 0x0040 }
            r0.L$3 = r9     // Catch:{ all -> 0x0040 }
            r0.L$4 = r5     // Catch:{ all -> 0x0040 }
            r0.L$5 = r3     // Catch:{ all -> 0x0040 }
            r0.L$6 = r3     // Catch:{ all -> 0x0040 }
            r0.I$0 = r2     // Catch:{ all -> 0x0040 }
            r6 = 7
            r0.label = r6     // Catch:{ all -> 0x0040 }
            java.lang.Object r4 = io.ktor.util.EncodersJvmKt.d(r9, r4, r10, r5, r0)     // Catch:{ all -> 0x0040 }
            if (r4 != r1) goto L_0x036a
            return r1
        L_0x036a:
            r6 = r5
            r5 = r3
        L_0x036c:
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ all -> 0x0040 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x0040 }
            int r2 = r2 + r4
            r3.element = r2     // Catch:{ all -> 0x0040 }
            int r2 = r11.limit()     // Catch:{ all -> 0x0040 }
            int r3 = r9.getRemaining()     // Catch:{ all -> 0x0040 }
            int r2 = r2 - r3
            r11.position(r2)     // Catch:{ all -> 0x0040 }
            r3 = r5
            r5 = r6
            goto L_0x0344
        L_0x0384:
            boolean r0 = r0.$gzip     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0408
            int r0 = r11.remaining()     // Catch:{ all -> 0x0040 }
            r1 = 8
            if (r0 != r1) goto L_0x03e4
            java.nio.ByteOrder r0 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ all -> 0x0040 }
            r11.order(r0)     // Catch:{ all -> 0x0040 }
            int r0 = r11.position()     // Catch:{ all -> 0x0040 }
            int r0 = r11.getInt(r0)     // Catch:{ all -> 0x0040 }
            int r1 = r11.position()     // Catch:{ all -> 0x0040 }
            r2 = 4
            int r1 = r1 + r2
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x0040 }
            long r4 = r5.getValue()     // Catch:{ all -> 0x0040 }
            int r2 = (int) r4     // Catch:{ all -> 0x0040 }
            if (r2 != r0) goto L_0x03d8
            int r0 = r3.element     // Catch:{ all -> 0x0040 }
            if (r0 != r1) goto L_0x03b3
            goto L_0x0410
        L_0x03b3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0040 }
            r0.<init>()     // Catch:{ all -> 0x0040 }
            java.lang.String r2 = "Gzip size invalid. Expected "
            r0.append(r2)     // Catch:{ all -> 0x0040 }
            r0.append(r1)     // Catch:{ all -> 0x0040 }
            java.lang.String r1 = ", actual "
            r0.append(r1)     // Catch:{ all -> 0x0040 }
            int r1 = r3.element     // Catch:{ all -> 0x0040 }
            r0.append(r1)     // Catch:{ all -> 0x0040 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0040 }
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0040 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0040 }
            r1.<init>(r0)     // Catch:{ all -> 0x0040 }
            throw r1     // Catch:{ all -> 0x0040 }
        L_0x03d8:
            java.lang.String r0 = "Gzip checksum invalid."
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0040 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0040 }
            r1.<init>(r0)     // Catch:{ all -> 0x0040 }
            throw r1     // Catch:{ all -> 0x0040 }
        L_0x03e4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0040 }
            r0.<init>()     // Catch:{ all -> 0x0040 }
            java.lang.String r1 = "Expected 8 bytes in the trailer. Actual: "
            r0.append(r1)     // Catch:{ all -> 0x0040 }
            int r1 = r11.remaining()     // Catch:{ all -> 0x0040 }
            r0.append(r1)     // Catch:{ all -> 0x0040 }
            java.lang.String r1 = " $"
            r0.append(r1)     // Catch:{ all -> 0x0040 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0040 }
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0040 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0040 }
            r1.<init>(r0)     // Catch:{ all -> 0x0040 }
            throw r1     // Catch:{ all -> 0x0040 }
        L_0x0408:
            boolean r0 = r11.hasRemaining()     // Catch:{ all -> 0x0040 }
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0424
        L_0x0410:
            r9.end()
            io.ktor.utils.io.pool.ObjectPool r0 = io.ktor.util.cio.ByteBufferPoolKt.a()
            r0.recycle(r11)
            io.ktor.utils.io.pool.ObjectPool r0 = io.ktor.util.cio.ByteBufferPoolKt.a()
            r0.recycle(r10)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0424:
            java.lang.String r0 = "Check failed."
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0040 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0040 }
            r1.<init>(r0)     // Catch:{ all -> 0x0040 }
            throw r1     // Catch:{ all -> 0x0040 }
        L_0x0430:
            throw r5     // Catch:{ all -> 0x0040 }
        L_0x0431:
            r0 = move-exception
            r10 = r11
            r11 = r7
        L_0x0434:
            throw r0     // Catch:{ all -> 0x0435 }
        L_0x0435:
            r0 = move-exception
            r1 = r0
            r9.end()
            io.ktor.utils.io.pool.ObjectPool r0 = io.ktor.util.cio.ByteBufferPoolKt.a()
            r0.recycle(r11)
            io.ktor.utils.io.pool.ObjectPool r0 = io.ktor.util.cio.ByteBufferPoolKt.a()
            r0.recycle(r10)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.EncodersJvmKt$inflate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
