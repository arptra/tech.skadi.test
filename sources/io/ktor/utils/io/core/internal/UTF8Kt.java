package io.ktor.utils.io.core.internal;

import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import okio.Utf8;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\f\n\u0002\b\u0005\u001aa\u0010\u000e\u001a\u00020\r2\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u00032$\u0010\t\u001a \b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nH@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001aA\u0010\u001c\u001a\u00020\u001b*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001aQ\u0010\"\u001a\u00020\u001b*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001aQ\u0010$\u001a\u00020\u001b*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010#\u001a\u0017\u0010&\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0003H\u0001¢\u0006\u0004\b&\u0010\u0013\u001a\u0017\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0003H\u0001¢\u0006\u0004\b(\u0010\u0013\u001a\u0017\u0010*\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u0003H\u0001¢\u0006\u0004\b*\u0010+\u001a\u0017\u0010-\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0003H\u0001¢\u0006\u0004\b-\u0010+\u001a\u0017\u0010.\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H\u0001¢\u0006\u0004\b.\u0010/\u001a\u0017\u00100\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H\u0001¢\u0006\u0004\b0\u0010/\u001a\u001f\u00104\u001a\u00020\u00032\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0000¢\u0006\u0004\b4\u00105\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "", "limit", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lio/ktor/utils/io/core/Input;", "", "nextChunk", "Lkotlin/Function1;", "", "afterRead", "", "b", "(Ljava/lang/Appendable;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "size", "", "l", "(I)Ljava/lang/Void;", "Lio/ktor/utils/io/bits/Memory;", "", "text", "from", "to", "dstOffset", "dstLimit", "Lio/ktor/utils/io/core/internal/EncodeResult;", "c", "(Ljava/nio/ByteBuffer;Ljava/lang/CharSequence;IIII)I", "index1", "lastCharIndex", "resultPosition1", "resultLimit", "d", "(Ljava/nio/ByteBuffer;Ljava/lang/CharSequence;IIIIII)I", "e", "byteCount", "j", "value", "k", "cp", "g", "(I)Z", "codePoint", "h", "i", "(I)I", "f", "", "high", "low", "a", "(CC)I", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nUTF8.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UTF8.kt\nio/ktor/utils/io/core/internal/UTF8Kt\n+ 2 Buffer.kt\nio/ktor/utils/io/core/BufferKt\n+ 3 Memory.kt\nio/ktor/utils/io/bits/MemoryKt\n+ 4 MemoryJvm.kt\nio/ktor/utils/io/bits/Memory\n+ 5 Input.kt\nio/ktor/utils/io/core/InputKt\n+ 6 Buffer.kt\nio/ktor/utils/io/core/Buffer\n*L\n1#1,379:1\n123#1,5:401\n128#1,2:411\n130#1,61:415\n193#1:478\n319#1,3:517\n322#1,4:522\n326#1,18:527\n309#1,7:545\n319#1,3:552\n322#1,4:557\n326#1,18:562\n372#2,5:380\n377#2,2:387\n372#2,5:406\n377#2,2:476\n372#2,5:506\n377#2,2:513\n84#3:385\n84#3:413\n84#3:511\n99#3:526\n99#3:561\n99#3:582\n99#3:585\n99#3:588\n99#3:591\n99#3:594\n99#3:597\n99#3:600\n99#3:603\n99#3:606\n26#4:386\n26#4:414\n26#4:512\n37#4,2:515\n37#4,2:520\n37#4,2:555\n37#4,2:580\n37#4,2:583\n37#4,2:586\n37#4,2:589\n37#4,2:592\n37#4,2:595\n37#4,2:598\n37#4,2:601\n37#4,2:604\n37#4,2:607\n852#5,8:389\n862#5,3:398\n866#5,11:479\n877#5,15:491\n69#6:397\n59#6:490\n*S KotlinDebug\n*F\n+ 1 UTF8.kt\nio/ktor/utils/io/core/internal/UTF8Kt\n*L\n42#1:401,5\n42#1:411,2\n42#1:415,61\n42#1:478\n255#1:517,3\n255#1:522,4\n255#1:527,18\n297#1:545,7\n301#1:552,3\n301#1:557,4\n301#1:562,18\n9#1:380,5\n9#1:387,2\n42#1:406,5\n42#1:476,2\n127#1:506,5\n127#1:513,2\n11#1:385\n42#1:413\n129#1:511\n255#1:526\n301#1:561\n325#1:582\n326#1:585\n330#1:588\n331#1:591\n332#1:594\n336#1:597\n337#1:600\n338#1:603\n339#1:606\n11#1:386\n42#1:414\n129#1:512\n211#1:515,2\n255#1:520,2\n301#1:555,2\n321#1:580,2\n325#1:583,2\n326#1:586,2\n330#1:589,2\n331#1:592,2\n332#1:595,2\n336#1:598,2\n337#1:601,2\n338#1:604,2\n339#1:607,2\n40#1:389,8\n40#1:398,3\n40#1:479,11\n40#1:491,15\n40#1:397\n40#1:490\n*E\n"})
public final class UTF8Kt {
    public static final int a(char c, char c2) {
        return ((c - Utf8.HIGH_SURROGATE_HEADER) << 10) | (c2 - CharCompanionObject.MIN_LOW_SURROGATE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX WARNING: type inference failed for: r14v9 */
    /* JADX WARNING: type inference failed for: r14v43 */
    /* JADX WARNING: type inference failed for: r3v40 */
    /* JADX WARNING: type inference failed for: r14v54 */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0209, code lost:
        r15 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        r8.element = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0229, code lost:
        r3.c(((r6 - r18) - r2.element) + r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        r8.element = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02ad, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:?, code lost:
        r8.element = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r8.element = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0153, code lost:
        r14 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0157, code lost:
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r14.c(r6 - r18);
        r3 = r14;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02bf A[Catch:{ all -> 0x0213, all -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x03e8  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0408  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x02ad A[EDGE_INSN: B:250:0x02ad->B:154:0x02ad ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x02ba A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(java.lang.Appendable r28, int r29, kotlin.jvm.functions.Function2 r30, kotlin.jvm.functions.Function1 r31, kotlin.coroutines.Continuation r32) {
        /*
            r0 = r32
            boolean r1 = r0 instanceof io.ktor.utils.io.core.internal.UTF8Kt$decodeUTF8LineLoopSuspend$1
            if (r1 == 0) goto L_0x0015
            r1 = r0
            io.ktor.utils.io.core.internal.UTF8Kt$decodeUTF8LineLoopSuspend$1 r1 = (io.ktor.utils.io.core.internal.UTF8Kt$decodeUTF8LineLoopSuspend$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            io.ktor.utils.io.core.internal.UTF8Kt$decodeUTF8LineLoopSuspend$1 r1 = new io.ktor.utils.io.core.internal.UTF8Kt$decodeUTF8LineLoopSuspend$1
            r1.<init>(r0)
        L_0x001a:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r5 = 1
            if (r3 == 0) goto L_0x005f
            if (r3 != r5) goto L_0x0057
            int r3 = r1.I$0
            java.lang.Object r6 = r1.L$6
            kotlin.jvm.internal.Ref$BooleanRef r6 = (kotlin.jvm.internal.Ref.BooleanRef) r6
            java.lang.Object r7 = r1.L$5
            kotlin.jvm.internal.Ref$BooleanRef r7 = (kotlin.jvm.internal.Ref.BooleanRef) r7
            java.lang.Object r8 = r1.L$4
            kotlin.jvm.internal.Ref$IntRef r8 = (kotlin.jvm.internal.Ref.IntRef) r8
            java.lang.Object r9 = r1.L$3
            kotlin.jvm.internal.Ref$IntRef r9 = (kotlin.jvm.internal.Ref.IntRef) r9
            java.lang.Object r10 = r1.L$2
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            java.lang.Object r12 = r1.L$0
            java.lang.Appendable r12 = (java.lang.Appendable) r12
            kotlin.ResultKt.throwOnFailure(r0)
            r26 = r7
            r7 = r1
            r1 = r3
            r3 = r11
            r11 = r9
            r9 = r26
            r27 = r8
            r8 = r6
            r6 = r10
            r10 = r27
            goto L_0x00af
        L_0x0057:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005f:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef
            r0.<init>()
            kotlin.jvm.internal.Ref$IntRef r3 = new kotlin.jvm.internal.Ref$IntRef
            r3.<init>()
            r3.element = r5
            kotlin.jvm.internal.Ref$BooleanRef r6 = new kotlin.jvm.internal.Ref$BooleanRef
            r6.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r7 = new kotlin.jvm.internal.Ref$BooleanRef
            r7.<init>()
            r11 = r0
            r10 = r3
            r9 = r6
            r8 = r7
            r0 = r28
            r3 = r30
            r6 = r31
            r7 = r1
            r1 = r29
        L_0x0085:
            boolean r12 = r8.element
            if (r12 != 0) goto L_0x00b4
            int r12 = r10.element
            if (r12 == 0) goto L_0x00b4
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)
            r7.L$0 = r0
            r7.L$1 = r3
            r7.L$2 = r6
            r7.L$3 = r11
            r7.L$4 = r10
            r7.L$5 = r9
            r7.L$6 = r8
            r7.I$0 = r1
            r7.label = r5
            java.lang.Object r12 = r3.invoke(r12, r7)
            if (r12 != r2) goto L_0x00aa
            return r2
        L_0x00aa:
            r26 = r12
            r12 = r0
            r0 = r26
        L_0x00af:
            r13 = r0
            io.ktor.utils.io.core.Input r13 = (io.ktor.utils.io.core.Input) r13
            if (r13 != 0) goto L_0x00b7
        L_0x00b4:
            r13 = 0
            goto L_0x03ec
        L_0x00b7:
            long r14 = r13.r0()
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = io.ktor.utils.io.core.internal.UnsafeKt.b(r13, r5)
            if (r0 != 0) goto L_0x00cf
            r17 = r2
            r29 = r3
            r31 = r6
            r30 = r7
            r2 = r13
            r19 = r14
            r13 = 0
            goto L_0x03b7
        L_0x00cf:
            r28 = r0
            r0 = r5
        L_0x00d2:
            int r16 = r28.k()     // Catch:{ all -> 0x03e1 }
            int r17 = r28.i()     // Catch:{ all -> 0x03e1 }
            int r4 = r16 - r17
            if (r4 < r0) goto L_0x0373
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x032c }
            r0.<init>()     // Catch:{ all -> 0x032c }
            kotlin.jvm.internal.Ref$IntRef r4 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x032c }
            r4.<init>()     // Catch:{ all -> 0x032c }
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x032c }
            r5.<init>()     // Catch:{ all -> 0x032c }
            r17 = r2
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x032c }
            r2.<init>()     // Catch:{ all -> 0x032c }
            r29 = r3
            java.nio.ByteBuffer r3 = r28.h()     // Catch:{ all -> 0x032c }
            int r18 = r28.i()     // Catch:{ all -> 0x032c }
            r30 = r7
            int r7 = r28.k()     // Catch:{ all -> 0x032c }
            r31 = r6
            r6 = r18
        L_0x0108:
            if (r6 >= r7) goto L_0x0332
            r19 = r14
            byte r14 = r3.get(r6)     // Catch:{ all -> 0x032c }
            r15 = r14 & 255(0xff, float:3.57E-43)
            r21 = r3
            r3 = r14 & 128(0x80, float:1.794E-43)
            r22 = r13
            java.lang.String r13 = " exceeded"
            r23 = r10
            java.lang.String r10 = "Too many characters in line: limit "
            r24 = r14
            r14 = 13
            r25 = -1
            if (r3 != 0) goto L_0x01a1
            int r3 = r4.element     // Catch:{ all -> 0x0166 }
            if (r3 != 0) goto L_0x0196
            char r3 = (char) r15
            if (r3 != r14) goto L_0x0143
            boolean r3 = r9.element     // Catch:{ all -> 0x0140 }
            if (r3 == 0) goto L_0x013a
            r14 = 1
            r8.element = r14     // Catch:{ all -> 0x0135 }
            goto L_0x0153
        L_0x0135:
            r0 = move-exception
        L_0x0136:
            r3 = r28
            goto L_0x036c
        L_0x013a:
            r14 = 1
            r9.element = r14     // Catch:{ all -> 0x0135 }
            r14 = r28
            goto L_0x0178
        L_0x0140:
            r0 = move-exception
            r14 = 1
            goto L_0x0136
        L_0x0143:
            r14 = 1
            r15 = 10
            if (r3 != r15) goto L_0x014d
            r8.element = r14     // Catch:{ all -> 0x0135 }
            r0.element = r14     // Catch:{ all -> 0x0135 }
            goto L_0x0153
        L_0x014d:
            boolean r15 = r9.element     // Catch:{ all -> 0x0166 }
            if (r15 == 0) goto L_0x016a
            r8.element = r14     // Catch:{ all -> 0x0166 }
        L_0x0153:
            int r6 = r6 - r18
            r14 = r28
            r14.c(r6)     // Catch:{ all -> 0x0162 }
            r3 = r14
        L_0x015b:
            r10 = r23
            r2 = r25
        L_0x015f:
            r13 = 0
            goto L_0x0343
        L_0x0162:
            r0 = move-exception
        L_0x0163:
            r3 = r14
            goto L_0x036c
        L_0x0166:
            r0 = move-exception
            r14 = r28
            goto L_0x0163
        L_0x016a:
            r14 = r28
            int r15 = r11.element     // Catch:{ all -> 0x0162 }
            if (r15 == r1) goto L_0x017e
            int r15 = r15 + 1
            r11.element = r15     // Catch:{ all -> 0x0162 }
            char r3 = (char) r3     // Catch:{ all -> 0x0162 }
            r12.append(r3)     // Catch:{ all -> 0x0162 }
        L_0x0178:
            r24 = r4
            r3 = r14
        L_0x017b:
            r13 = 0
            goto L_0x031c
        L_0x017e:
            io.ktor.utils.io.charsets.TooLongLineException r0 = new io.ktor.utils.io.charsets.TooLongLineException     // Catch:{ all -> 0x0162 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0162 }
            r2.<init>()     // Catch:{ all -> 0x0162 }
            r2.append(r10)     // Catch:{ all -> 0x0162 }
            r2.append(r1)     // Catch:{ all -> 0x0162 }
            r2.append(r13)     // Catch:{ all -> 0x0162 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0162 }
            r0.<init>(r1)     // Catch:{ all -> 0x0162 }
            throw r0     // Catch:{ all -> 0x0162 }
        L_0x0196:
            r14 = r28
            j(r3)     // Catch:{ all -> 0x0162 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0162 }
            r0.<init>()     // Catch:{ all -> 0x0162 }
            throw r0     // Catch:{ all -> 0x0162 }
        L_0x01a1:
            r3 = r28
            int r14 = r4.element     // Catch:{ all -> 0x01c4 }
            if (r14 != 0) goto L_0x01e5
            r5.element = r15     // Catch:{ all -> 0x01c4 }
            r10 = 128(0x80, float:1.794E-43)
            r13 = 1
        L_0x01ac:
            r14 = 7
            if (r13 >= r14) goto L_0x01c7
            int r14 = r5.element     // Catch:{ all -> 0x01c4 }
            r15 = r14 & r10
            if (r15 == 0) goto L_0x01c7
            int r15 = ~r10     // Catch:{ all -> 0x01c4 }
            r14 = r14 & r15
            r5.element = r14     // Catch:{ all -> 0x01c4 }
            int r10 = r10 >> 1
            int r14 = r4.element     // Catch:{ all -> 0x01c4 }
            r15 = 1
            int r14 = r14 + r15
            r4.element = r14     // Catch:{ all -> 0x01c4 }
            int r13 = r13 + 1
            goto L_0x01ac
        L_0x01c4:
            r0 = move-exception
            goto L_0x036c
        L_0x01c7:
            int r10 = r4.element     // Catch:{ all -> 0x01c4 }
            r2.element = r10     // Catch:{ all -> 0x01c4 }
            int r10 = r4.element     // Catch:{ all -> 0x01c4 }
            int r10 = r10 + -1
            r4.element = r10     // Catch:{ all -> 0x01c4 }
            int r10 = r2.element     // Catch:{ all -> 0x01c4 }
            int r13 = r7 - r6
            if (r10 <= r13) goto L_0x01e2
            int r6 = r6 - r18
            r3.c(r6)     // Catch:{ all -> 0x01c4 }
            int r2 = r2.element     // Catch:{ all -> 0x01c4 }
            r10 = r23
            goto L_0x015f
        L_0x01e2:
            r24 = r4
            goto L_0x017b
        L_0x01e5:
            int r14 = r5.element     // Catch:{ all -> 0x01c4 }
            int r14 = r14 << 6
            r15 = r24 & 127(0x7f, float:1.78E-43)
            r14 = r14 | r15
            r5.element = r14     // Catch:{ all -> 0x01c4 }
            int r14 = r4.element     // Catch:{ all -> 0x01c4 }
            int r14 = r14 + -1
            r4.element = r14     // Catch:{ all -> 0x01c4 }
            if (r14 != 0) goto L_0x01e2
            int r14 = r5.element     // Catch:{ all -> 0x01c4 }
            boolean r14 = g(r14)     // Catch:{ all -> 0x01c4 }
            if (r14 == 0) goto L_0x025b
            int r14 = r5.element     // Catch:{ all -> 0x01c4 }
            char r14 = (char) r14
            r15 = 13
            if (r14 != r15) goto L_0x0217
            boolean r10 = r9.element     // Catch:{ all -> 0x0213 }
            if (r10 == 0) goto L_0x020d
            r15 = 1
            r8.element = r15     // Catch:{ all -> 0x01c4 }
            goto L_0x0229
        L_0x020d:
            r15 = 1
            r9.element = r15     // Catch:{ all -> 0x01c4 }
            r24 = r4
            goto L_0x0240
        L_0x0213:
            r0 = move-exception
            r15 = 1
            goto L_0x036c
        L_0x0217:
            r24 = r4
            r4 = 10
            r15 = 1
            if (r14 != r4) goto L_0x0223
            r8.element = r15     // Catch:{ all -> 0x01c4 }
            r0.element = r15     // Catch:{ all -> 0x01c4 }
            goto L_0x0229
        L_0x0223:
            boolean r4 = r9.element     // Catch:{ all -> 0x01c4 }
            if (r4 == 0) goto L_0x0234
            r8.element = r15     // Catch:{ all -> 0x01c4 }
        L_0x0229:
            int r6 = r6 - r18
            int r2 = r2.element     // Catch:{ all -> 0x01c4 }
            int r6 = r6 - r2
            int r6 = r6 + r15
            r3.c(r6)     // Catch:{ all -> 0x01c4 }
            goto L_0x015b
        L_0x0234:
            int r4 = r11.element     // Catch:{ all -> 0x01c4 }
            if (r4 == r1) goto L_0x0243
            int r4 = r4 + 1
            r11.element = r4     // Catch:{ all -> 0x01c4 }
            char r4 = (char) r14     // Catch:{ all -> 0x01c4 }
            r12.append(r4)     // Catch:{ all -> 0x01c4 }
        L_0x0240:
            r13 = 0
            goto L_0x02de
        L_0x0243:
            io.ktor.utils.io.charsets.TooLongLineException r0 = new io.ktor.utils.io.charsets.TooLongLineException     // Catch:{ all -> 0x01c4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c4 }
            r2.<init>()     // Catch:{ all -> 0x01c4 }
            r2.append(r10)     // Catch:{ all -> 0x01c4 }
            r2.append(r1)     // Catch:{ all -> 0x01c4 }
            r2.append(r13)     // Catch:{ all -> 0x01c4 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x01c4 }
            r0.<init>(r1)     // Catch:{ all -> 0x01c4 }
            throw r0     // Catch:{ all -> 0x01c4 }
        L_0x025b:
            r24 = r4
            int r4 = r5.element     // Catch:{ all -> 0x01c4 }
            boolean r4 = h(r4)     // Catch:{ all -> 0x01c4 }
            if (r4 == 0) goto L_0x0311
            int r4 = r5.element     // Catch:{ all -> 0x01c4 }
            int r4 = f(r4)     // Catch:{ all -> 0x01c4 }
            char r4 = (char) r4
            r14 = 13
            if (r4 != r14) goto L_0x0280
            boolean r4 = r9.element     // Catch:{ all -> 0x027c }
            if (r4 == 0) goto L_0x0278
            r14 = 1
            r8.element = r14     // Catch:{ all -> 0x01c4 }
            goto L_0x0290
        L_0x0278:
            r14 = 1
            r9.element = r14     // Catch:{ all -> 0x01c4 }
            goto L_0x029e
        L_0x027c:
            r0 = move-exception
            r14 = 1
            goto L_0x036c
        L_0x0280:
            r14 = 1
            r15 = 10
            if (r4 != r15) goto L_0x028a
            r8.element = r14     // Catch:{ all -> 0x01c4 }
            r0.element = r14     // Catch:{ all -> 0x01c4 }
            goto L_0x0290
        L_0x028a:
            boolean r15 = r9.element     // Catch:{ all -> 0x01c4 }
            if (r15 == 0) goto L_0x0292
            r8.element = r14     // Catch:{ all -> 0x01c4 }
        L_0x0290:
            r14 = 1
            goto L_0x02c5
        L_0x0292:
            int r14 = r11.element     // Catch:{ all -> 0x01c4 }
            if (r14 == r1) goto L_0x02f9
            int r14 = r14 + 1
            r11.element = r14     // Catch:{ all -> 0x01c4 }
            char r4 = (char) r4     // Catch:{ all -> 0x01c4 }
            r12.append(r4)     // Catch:{ all -> 0x01c4 }
        L_0x029e:
            int r4 = r5.element     // Catch:{ all -> 0x01c4 }
            int r4 = i(r4)     // Catch:{ all -> 0x01c4 }
            char r4 = (char) r4
            r14 = 13
            if (r4 != r14) goto L_0x02b5
            boolean r4 = r9.element     // Catch:{ all -> 0x027c }
            if (r4 == 0) goto L_0x02b1
            r14 = 1
            r8.element = r14     // Catch:{ all -> 0x01c4 }
            goto L_0x02c5
        L_0x02b1:
            r14 = 1
            r9.element = r14     // Catch:{ all -> 0x01c4 }
            goto L_0x0240
        L_0x02b5:
            r14 = 1
            r15 = 10
            if (r4 != r15) goto L_0x02bf
            r8.element = r14     // Catch:{ all -> 0x01c4 }
            r0.element = r14     // Catch:{ all -> 0x01c4 }
            goto L_0x02c5
        L_0x02bf:
            boolean r15 = r9.element     // Catch:{ all -> 0x01c4 }
            if (r15 == 0) goto L_0x02d0
            r8.element = r14     // Catch:{ all -> 0x01c4 }
        L_0x02c5:
            int r6 = r6 - r18
            int r2 = r2.element     // Catch:{ all -> 0x01c4 }
            int r6 = r6 - r2
            int r6 = r6 + r14
            r3.c(r6)     // Catch:{ all -> 0x01c4 }
            goto L_0x015b
        L_0x02d0:
            int r14 = r11.element     // Catch:{ all -> 0x01c4 }
            if (r14 == r1) goto L_0x02e1
            int r14 = r14 + 1
            r11.element = r14     // Catch:{ all -> 0x01c4 }
            char r4 = (char) r4     // Catch:{ all -> 0x01c4 }
            r12.append(r4)     // Catch:{ all -> 0x01c4 }
            goto L_0x0240
        L_0x02de:
            r5.element = r13     // Catch:{ all -> 0x01c4 }
            goto L_0x031c
        L_0x02e1:
            io.ktor.utils.io.charsets.TooLongLineException r0 = new io.ktor.utils.io.charsets.TooLongLineException     // Catch:{ all -> 0x01c4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c4 }
            r2.<init>()     // Catch:{ all -> 0x01c4 }
            r2.append(r10)     // Catch:{ all -> 0x01c4 }
            r2.append(r1)     // Catch:{ all -> 0x01c4 }
            r2.append(r13)     // Catch:{ all -> 0x01c4 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x01c4 }
            r0.<init>(r1)     // Catch:{ all -> 0x01c4 }
            throw r0     // Catch:{ all -> 0x01c4 }
        L_0x02f9:
            io.ktor.utils.io.charsets.TooLongLineException r0 = new io.ktor.utils.io.charsets.TooLongLineException     // Catch:{ all -> 0x01c4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c4 }
            r2.<init>()     // Catch:{ all -> 0x01c4 }
            r2.append(r10)     // Catch:{ all -> 0x01c4 }
            r2.append(r1)     // Catch:{ all -> 0x01c4 }
            r2.append(r13)     // Catch:{ all -> 0x01c4 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x01c4 }
            r0.<init>(r1)     // Catch:{ all -> 0x01c4 }
            throw r0     // Catch:{ all -> 0x01c4 }
        L_0x0311:
            int r0 = r5.element     // Catch:{ all -> 0x01c4 }
            k(r0)     // Catch:{ all -> 0x01c4 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x01c4 }
            r0.<init>()     // Catch:{ all -> 0x01c4 }
            throw r0     // Catch:{ all -> 0x01c4 }
        L_0x031c:
            int r6 = r6 + 1
            r28 = r3
            r14 = r19
            r3 = r21
            r13 = r22
            r10 = r23
            r4 = r24
            goto L_0x0108
        L_0x032c:
            r0 = move-exception
            r3 = r28
            r22 = r13
            goto L_0x036c
        L_0x0332:
            r3 = r28
            r23 = r10
            r22 = r13
            r19 = r14
            r13 = 0
            int r7 = r7 - r18
            r3.c(r7)     // Catch:{ all -> 0x01c4 }
            r2 = r13
            r10 = r23
        L_0x0343:
            r10.element = r2     // Catch:{ all -> 0x01c4 }
            int r0 = r0.element     // Catch:{ all -> 0x01c4 }
            if (r0 <= 0) goto L_0x034c
            r3.c(r0)     // Catch:{ all -> 0x01c4 }
        L_0x034c:
            boolean r0 = r8.element     // Catch:{ all -> 0x01c4 }
            if (r0 == 0) goto L_0x0352
            r0 = r13
            goto L_0x0359
        L_0x0352:
            int r0 = r10.element     // Catch:{ all -> 0x01c4 }
            r2 = 1
            int r0 = kotlin.ranges.RangesKt.coerceAtLeast((int) r0, (int) r2)     // Catch:{ all -> 0x01c4 }
        L_0x0359:
            r10.element = r0     // Catch:{ all -> 0x01c4 }
            int r2 = r3.k()     // Catch:{ all -> 0x0366 }
            int r4 = r3.i()     // Catch:{ all -> 0x0366 }
            int r4 = r2 - r4
            goto L_0x0382
        L_0x0366:
            r0 = move-exception
            r2 = r22
        L_0x0369:
            r4 = 1
            goto L_0x03e6
        L_0x036c:
            r3.k()     // Catch:{ all -> 0x0366 }
            r3.i()     // Catch:{ all -> 0x0366 }
            throw r0     // Catch:{ all -> 0x0366 }
        L_0x0373:
            r17 = r2
            r29 = r3
            r31 = r6
            r30 = r7
            r22 = r13
            r19 = r14
            r13 = 0
            r3 = r28
        L_0x0382:
            if (r4 != 0) goto L_0x038f
            r2 = r22
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.c(r2, r3)     // Catch:{ all -> 0x038b }
            goto L_0x03aa
        L_0x038b:
            r0 = move-exception
            r4 = r13
            goto L_0x03e6
        L_0x038f:
            r2 = r22
            if (r4 < r0) goto L_0x03a3
            int r4 = r3.f()     // Catch:{ all -> 0x038b }
            int r5 = r3.g()     // Catch:{ all -> 0x038b }
            int r4 = r4 - r5
            r5 = 8
            if (r4 >= r5) goto L_0x03a1
            goto L_0x03a3
        L_0x03a1:
            r4 = r3
            goto L_0x03aa
        L_0x03a3:
            io.ktor.utils.io.core.internal.UnsafeKt.a(r2, r3)     // Catch:{ all -> 0x038b }
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.b(r2, r0)     // Catch:{ all -> 0x038b }
        L_0x03aa:
            if (r4 != 0) goto L_0x03ae
            r14 = r13
            goto L_0x03b2
        L_0x03ae:
            if (r0 > 0) goto L_0x03d1
            r3 = r4
            r14 = 1
        L_0x03b2:
            if (r14 == 0) goto L_0x03b7
            io.ktor.utils.io.core.internal.UnsafeKt.a(r2, r3)
        L_0x03b7:
            long r2 = r2.r0()
            long r14 = r19 - r2
            int r0 = (int) r14
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            r6 = r31
            r6.invoke(r0)
            r3 = r29
            r7 = r30
            r0 = r12
            r2 = r17
            r5 = 1
            goto L_0x0085
        L_0x03d1:
            r3 = r29
            r7 = r30
            r6 = r31
            r13 = r2
            r28 = r4
            r2 = r17
            r14 = r19
            r5 = 1
            goto L_0x00d2
        L_0x03e1:
            r0 = move-exception
            r3 = r28
            r2 = r13
            goto L_0x0369
        L_0x03e6:
            if (r4 == 0) goto L_0x03eb
            io.ktor.utils.io.core.internal.UnsafeKt.a(r2, r3)
        L_0x03eb:
            throw r0
        L_0x03ec:
            int r0 = r10.element
            r1 = 1
            if (r0 > r1) goto L_0x0408
            boolean r0 = r9.element
            if (r0 == 0) goto L_0x03f7
            r8.element = r1
        L_0x03f7:
            int r0 = r11.element
            if (r0 > 0) goto L_0x0402
            boolean r0 = r8.element
            if (r0 == 0) goto L_0x0400
            goto L_0x0402
        L_0x0400:
            r4 = r13
            goto L_0x0403
        L_0x0402:
            r4 = r1
        L_0x0403:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r0
        L_0x0408:
            l(r0)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.internal.UTF8Kt.b(java.lang.Appendable, int, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final int c(ByteBuffer byteBuffer, CharSequence charSequence, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$encodeUTF8");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        int min = Math.min(i2, i + 65535);
        int coerceAtMost = RangesKt.coerceAtMost(i4, 65535);
        int i5 = i;
        int i6 = i3;
        while (i6 < coerceAtMost && i5 < min) {
            int i7 = i5 + 1;
            char charAt = charSequence.charAt(i5);
            char c = charAt & CharCompanionObject.MAX_VALUE;
            if ((charAt & 65408) != 0) {
                return d(byteBuffer, charSequence, i5, min, i, i6, coerceAtMost, i3);
            }
            byteBuffer.put(i6, (byte) c);
            i5 = i7;
            i6++;
        }
        return EncodeResult.d(UShort.m301constructorimpl((short) (i5 - i)), UShort.m301constructorimpl((short) (i6 - i3)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: char} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int d(java.nio.ByteBuffer r11, java.lang.CharSequence r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        /*
            r0 = r11
            r1 = r12
            r3 = r14
            int r2 = r17 + -3
            r4 = r13
            r5 = r16
        L_0x0008:
            int r6 = r2 - r5
            if (r6 <= 0) goto L_0x00c0
            if (r4 < r3) goto L_0x0010
            goto L_0x00c0
        L_0x0010:
            int r6 = r4 + 1
            char r7 = r12.charAt(r4)
            boolean r8 = java.lang.Character.isHighSurrogate(r7)
            r9 = 63
            if (r8 == 0) goto L_0x0039
            if (r6 == r3) goto L_0x0036
            char r8 = r12.charAt(r6)
            boolean r8 = java.lang.Character.isLowSurrogate(r8)
            if (r8 != 0) goto L_0x002b
            goto L_0x0036
        L_0x002b:
            int r4 = r4 + 2
            char r6 = r12.charAt(r6)
            int r7 = a(r7, r6)
            goto L_0x003a
        L_0x0036:
            r4 = r6
            r7 = r9
            goto L_0x003a
        L_0x0039:
            r4 = r6
        L_0x003a:
            r6 = 128(0x80, float:1.794E-43)
            if (r7 < 0) goto L_0x0046
            if (r7 >= r6) goto L_0x0046
            byte r6 = (byte) r7
            r11.put(r5, r6)
            r6 = 1
            goto L_0x00b4
        L_0x0046:
            r8 = 2048(0x800, float:2.87E-42)
            if (r6 > r7) goto L_0x0061
            if (r7 >= r8) goto L_0x0061
            int r8 = r7 >> 6
            r8 = r8 & 31
            r8 = r8 | 192(0xc0, float:2.69E-43)
            byte r8 = (byte) r8
            r11.put(r5, r8)
            int r8 = r5 + 1
            r7 = r7 & 63
            r6 = r6 | r7
            byte r6 = (byte) r6
            r11.put(r8, r6)
            r6 = 2
            goto L_0x00b4
        L_0x0061:
            r10 = 65536(0x10000, float:9.18355E-41)
            if (r8 > r7) goto L_0x0086
            if (r7 >= r10) goto L_0x0086
            int r8 = r7 >> 12
            r8 = r8 & 15
            r8 = r8 | 224(0xe0, float:3.14E-43)
            byte r8 = (byte) r8
            r11.put(r5, r8)
            int r8 = r5 + 1
            int r10 = r7 >> 6
            r9 = r9 & r10
            r9 = r9 | r6
            byte r9 = (byte) r9
            r11.put(r8, r9)
            int r8 = r5 + 2
            r7 = r7 & 63
            r6 = r6 | r7
            byte r6 = (byte) r6
            r11.put(r8, r6)
            r6 = 3
            goto L_0x00b4
        L_0x0086:
            if (r10 > r7) goto L_0x00b7
            r8 = 1114112(0x110000, float:1.561203E-39)
            if (r7 >= r8) goto L_0x00b7
            int r8 = r7 >> 18
            r8 = r8 & 7
            r8 = r8 | 240(0xf0, float:3.36E-43)
            byte r8 = (byte) r8
            r11.put(r5, r8)
            int r8 = r5 + 1
            int r10 = r7 >> 12
            r10 = r10 & r9
            r10 = r10 | r6
            byte r10 = (byte) r10
            r11.put(r8, r10)
            int r8 = r5 + 2
            int r10 = r7 >> 6
            r9 = r9 & r10
            r9 = r9 | r6
            byte r9 = (byte) r9
            r11.put(r8, r9)
            int r8 = r5 + 3
            r7 = r7 & 63
            r6 = r6 | r7
            byte r6 = (byte) r6
            r11.put(r8, r6)
            r6 = 4
        L_0x00b4:
            int r5 = r5 + r6
            goto L_0x0008
        L_0x00b7:
            k(r7)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x00c0:
            if (r5 != r2) goto L_0x00d0
            r0 = r11
            r1 = r12
            r2 = r4
            r3 = r14
            r4 = r15
            r6 = r17
            r7 = r18
            int r0 = e(r0, r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x00d0:
            int r4 = r4 - r15
            short r0 = (short) r4
            short r0 = kotlin.UShort.m301constructorimpl(r0)
            int r5 = r5 - r18
            short r1 = (short) r5
            short r1 = kotlin.UShort.m301constructorimpl(r1)
            int r0 = io.ktor.utils.io.core.internal.EncodeResult.d(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.internal.UTF8Kt.d(java.nio.ByteBuffer, java.lang.CharSequence, int, int, int, int, int, int):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: char} */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ea, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fd, code lost:
        return io.ktor.utils.io.core.internal.EncodeResult.d(kotlin.UShort.m301constructorimpl((short) (r3 - r20)), kotlin.UShort.m301constructorimpl((short) (r4 - r23)));
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int e(java.nio.ByteBuffer r16, java.lang.CharSequence r17, int r18, int r19, int r20, int r21, int r22, int r23) {
        /*
            r0 = r16
            r1 = r17
            r2 = r19
            r3 = r18
            r4 = r21
        L_0x000a:
            int r5 = r22 - r4
            if (r5 <= 0) goto L_0x00eb
            if (r3 < r2) goto L_0x0012
            goto L_0x00eb
        L_0x0012:
            int r6 = r3 + 1
            char r7 = r1.charAt(r3)
            boolean r8 = java.lang.Character.isHighSurrogate(r7)
            r9 = 63
            if (r8 != 0) goto L_0x0022
            r3 = r6
            goto L_0x003c
        L_0x0022:
            if (r6 == r2) goto L_0x003a
            char r8 = r1.charAt(r6)
            boolean r8 = java.lang.Character.isLowSurrogate(r8)
            if (r8 != 0) goto L_0x002f
            goto L_0x003a
        L_0x002f:
            int r3 = r3 + 2
            char r6 = r1.charAt(r6)
            int r7 = a(r7, r6)
            goto L_0x003c
        L_0x003a:
            r3 = r6
            r7 = r9
        L_0x003c:
            r8 = 1114112(0x110000, float:1.561203E-39)
            r10 = 3
            r11 = 65536(0x10000, float:9.18355E-41)
            r12 = 2048(0x800, float:2.87E-42)
            r13 = 2
            r14 = 1
            r15 = 128(0x80, float:1.794E-43)
            if (r14 > r7) goto L_0x004d
            if (r7 >= r15) goto L_0x004d
            r6 = r14
            goto L_0x005e
        L_0x004d:
            if (r15 > r7) goto L_0x0053
            if (r7 >= r12) goto L_0x0053
            r6 = r13
            goto L_0x005e
        L_0x0053:
            if (r12 > r7) goto L_0x0059
            if (r7 >= r11) goto L_0x0059
            r6 = r10
            goto L_0x005e
        L_0x0059:
            if (r11 > r7) goto L_0x00e2
            if (r7 >= r8) goto L_0x00e2
            r6 = 4
        L_0x005e:
            if (r6 <= r5) goto L_0x0064
            int r3 = r3 + -1
            goto L_0x00eb
        L_0x0064:
            if (r7 < 0) goto L_0x006e
            if (r7 >= r15) goto L_0x006e
            byte r5 = (byte) r7
            r0.put(r4, r5)
            r6 = r14
            goto L_0x00d6
        L_0x006e:
            if (r15 > r7) goto L_0x0087
            if (r7 >= r12) goto L_0x0087
            int r5 = r7 >> 6
            r5 = r5 & 31
            r5 = r5 | 192(0xc0, float:2.69E-43)
            byte r5 = (byte) r5
            r0.put(r4, r5)
            int r5 = r4 + 1
            r6 = r7 & 63
            r6 = r6 | r15
            byte r6 = (byte) r6
            r0.put(r5, r6)
            r6 = r13
            goto L_0x00d6
        L_0x0087:
            if (r12 > r7) goto L_0x00aa
            if (r7 >= r11) goto L_0x00aa
            int r5 = r7 >> 12
            r5 = r5 & 15
            r5 = r5 | 224(0xe0, float:3.14E-43)
            byte r5 = (byte) r5
            r0.put(r4, r5)
            int r5 = r4 + 1
            int r6 = r7 >> 6
            r6 = r6 & r9
            r6 = r6 | r15
            byte r6 = (byte) r6
            r0.put(r5, r6)
            int r5 = r4 + 2
            r6 = r7 & 63
            r6 = r6 | r15
            byte r6 = (byte) r6
            r0.put(r5, r6)
            r6 = r10
            goto L_0x00d6
        L_0x00aa:
            if (r11 > r7) goto L_0x00d9
            if (r7 >= r8) goto L_0x00d9
            int r5 = r7 >> 18
            r5 = r5 & 7
            r5 = r5 | 240(0xf0, float:3.36E-43)
            byte r5 = (byte) r5
            r0.put(r4, r5)
            int r5 = r4 + 1
            int r6 = r7 >> 12
            r6 = r6 & r9
            r6 = r6 | r15
            byte r6 = (byte) r6
            r0.put(r5, r6)
            int r5 = r4 + 2
            int r6 = r7 >> 6
            r6 = r6 & r9
            r6 = r6 | r15
            byte r6 = (byte) r6
            r0.put(r5, r6)
            int r5 = r4 + 3
            r6 = r7 & 63
            r6 = r6 | r15
            byte r6 = (byte) r6
            r0.put(r5, r6)
            r6 = 4
        L_0x00d6:
            int r4 = r4 + r6
            goto L_0x000a
        L_0x00d9:
            k(r7)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x00e2:
            k(r7)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x00eb:
            int r3 = r3 - r20
            short r0 = (short) r3
            short r0 = kotlin.UShort.m301constructorimpl(r0)
            int r4 = r4 - r23
            short r1 = (short) r4
            short r1 = kotlin.UShort.m301constructorimpl(r1)
            int r0 = io.ktor.utils.io.core.internal.EncodeResult.d(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.internal.UTF8Kt.e(java.nio.ByteBuffer, java.lang.CharSequence, int, int, int, int, int, int):int");
    }

    public static final int f(int i) {
        return (i >>> 10) + Utf8.HIGH_SURROGATE_HEADER;
    }

    public static final boolean g(int i) {
        return (i >>> 16) == 0;
    }

    public static final boolean h(int i) {
        return i <= 1114111;
    }

    public static final int i(int i) {
        return (i & 1023) + 56320;
    }

    public static final Void j(int i) {
        throw new MalformedUTF8InputException("Expected " + i + " more character bytes");
    }

    public static final Void k(int i) {
        throw new IllegalArgumentException("Malformed code-point " + i + " found");
    }

    public static final Void l(int i) {
        throw new EOFException("Premature end of stream: expected " + i + " bytes to decode UTF-8 char");
    }
}
