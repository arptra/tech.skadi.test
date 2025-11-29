package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\n\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a-\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\r\u001a/\u0010\u0012\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/core/Input;", "", "dst", "", "offset", "length", "", "e", "(Lio/ktor/utils/io/core/Input;[BII)V", "Lio/ktor/utils/io/core/Buffer;", "d", "(Lio/ktor/utils/io/core/Input;Lio/ktor/utils/io/core/Buffer;I)V", "a", "(Lio/ktor/utils/io/core/Input;[BII)I", "Lio/ktor/utils/io/bits/Memory;", "destination", "", "destinationOffset", "c", "(Lio/ktor/utils/io/core/Input;Ljava/nio/ByteBuffer;JJ)J", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nInputArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InputArrays.kt\nio/ktor/utils/io/core/InputArraysKt\n+ 2 Input.kt\nio/ktor/utils/io/core/InputKt\n+ 3 Buffer.kt\nio/ktor/utils/io/core/Buffer\n*L\n1#1,215:1\n141#1,4:216\n145#1:226\n146#1,5:228\n153#1:246\n211#1,4:247\n191#1,4:251\n195#1,8:267\n206#1:302\n211#1,4:303\n191#1,4:307\n195#1,8:323\n206#1:358\n211#1,4:359\n191#1,4:363\n195#1,8:379\n206#1:414\n211#1,4:415\n191#1,4:419\n195#1,8:435\n206#1:470\n211#1,4:471\n191#1,4:475\n195#1,8:491\n206#1:526\n211#1,4:527\n141#1,4:531\n145#1:541\n146#1,5:543\n153#1:561\n211#1,4:562\n141#1,4:567\n145#1:577\n146#1,5:579\n153#1:597\n191#1,4:598\n195#1,8:614\n206#1:649\n191#1,4:650\n195#1,8:666\n206#1:701\n191#1,4:702\n195#1,8:718\n206#1:753\n191#1,4:754\n195#1,8:770\n206#1:805\n191#1,4:806\n195#1,8:822\n206#1:857\n141#1,4:858\n145#1:868\n146#1,5:870\n153#1:888\n165#1,4:890\n169#1:900\n170#1,6:902\n178#1:921\n823#2,6:220\n829#2,13:233\n852#2,8:255\n862#2,3:264\n866#2,11:275\n877#2,15:287\n852#2,8:311\n862#2,3:320\n866#2,11:331\n877#2,15:343\n852#2,8:367\n862#2,3:376\n866#2,11:387\n877#2,15:399\n852#2,8:423\n862#2,3:432\n866#2,11:443\n877#2,15:455\n852#2,8:479\n862#2,3:488\n866#2,11:499\n877#2,15:511\n823#2,6:535\n829#2,13:548\n823#2,6:571\n829#2,13:584\n852#2,8:602\n862#2,3:611\n866#2,11:622\n877#2,15:634\n852#2,8:654\n862#2,3:663\n866#2,11:674\n877#2,15:686\n852#2,8:706\n862#2,3:715\n866#2,11:726\n877#2,15:738\n852#2,8:758\n862#2,3:767\n866#2,11:778\n877#2,15:790\n852#2,8:810\n862#2,3:819\n866#2,11:830\n877#2,15:842\n823#2,6:862\n829#2,13:875\n823#2,6:894\n829#2,13:908\n823#2,6:922\n829#2,13:929\n823#2,6:942\n829#2,13:949\n852#2,8:962\n862#2,3:971\n866#2,11:975\n877#2,15:987\n69#3:227\n69#3:263\n59#3:286\n69#3:319\n59#3:342\n69#3:375\n59#3:398\n69#3:431\n59#3:454\n69#3:487\n59#3:510\n69#3:542\n74#3:566\n69#3:578\n69#3:610\n59#3:633\n69#3:662\n59#3:685\n69#3:714\n59#3:737\n69#3:766\n59#3:789\n69#3:818\n59#3:841\n69#3:869\n74#3:889\n69#3:901\n69#3:928\n69#3:948\n69#3:970\n69#3:974\n59#3:986\n*S KotlinDebug\n*F\n+ 1 InputArrays.kt\nio/ktor/utils/io/core/InputArraysKt\n*L\n7#1:216,4\n7#1:226\n7#1:228,5\n7#1:246\n9#1:247,4\n14#1:251,4\n14#1:267,8\n14#1:302\n16#1:303,4\n21#1:307,4\n21#1:323,8\n21#1:358\n23#1:359,4\n28#1:363,4\n28#1:379,8\n28#1:414\n30#1:415,4\n35#1:419,4\n35#1:435,8\n35#1:470\n37#1:471,4\n42#1:475,4\n42#1:491,8\n42#1:526\n44#1:527,4\n49#1:531,4\n49#1:541\n49#1:543,5\n49#1:561\n51#1:562,4\n68#1:567,4\n68#1:577\n68#1:579,5\n68#1:597\n75#1:598,4\n75#1:614,8\n75#1:649\n82#1:650,4\n82#1:666,8\n82#1:701\n89#1:702,4\n89#1:718,8\n89#1:753\n96#1:754,4\n96#1:770,8\n96#1:805\n103#1:806,4\n103#1:822,8\n103#1:857\n110#1:858,4\n110#1:868\n110#1:870,5\n110#1:888\n122#1:890,4\n122#1:900\n122#1:902,6\n122#1:921\n7#1:220,6\n7#1:233,13\n14#1:255,8\n14#1:264,3\n14#1:275,11\n14#1:287,15\n21#1:311,8\n21#1:320,3\n21#1:331,11\n21#1:343,15\n28#1:367,8\n28#1:376,3\n28#1:387,11\n28#1:399,15\n35#1:423,8\n35#1:432,3\n35#1:443,11\n35#1:455,15\n42#1:479,8\n42#1:488,3\n42#1:499,11\n42#1:511,15\n49#1:535,6\n49#1:548,13\n68#1:571,6\n68#1:584,13\n75#1:602,8\n75#1:611,3\n75#1:622,11\n75#1:634,15\n82#1:654,8\n82#1:663,3\n82#1:674,11\n82#1:686,15\n89#1:706,8\n89#1:715,3\n89#1:726,11\n89#1:738,15\n96#1:758,8\n96#1:767,3\n96#1:778,11\n96#1:790,15\n103#1:810,8\n103#1:819,3\n103#1:830,11\n103#1:842,15\n110#1:862,6\n110#1:875,13\n122#1:894,6\n122#1:908,13\n144#1:922,6\n144#1:929,13\n168#1:942,6\n168#1:949,13\n194#1:962,8\n194#1:971,3\n194#1:975,11\n194#1:987,15\n7#1:227\n14#1:263\n14#1:286\n21#1:319\n21#1:342\n28#1:375\n28#1:398\n35#1:431\n35#1:454\n42#1:487\n42#1:510\n49#1:542\n48#1:566\n68#1:578\n75#1:610\n75#1:633\n82#1:662\n82#1:685\n89#1:714\n89#1:737\n96#1:766\n96#1:789\n103#1:818\n103#1:841\n110#1:869\n109#1:889\n122#1:901\n145#1:928\n169#1:948\n194#1:970\n195#1:974\n194#1:986\n*E\n"})
public final class InputArraysKt {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int a(io.ktor.utils.io.core.Input r5, byte[] r6, int r7, int r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.b(r5, r0)
            if (r1 != 0) goto L_0x0013
            r2 = r8
            goto L_0x0035
        L_0x0013:
            r2 = r8
        L_0x0014:
            int r3 = r1.k()     // Catch:{ all -> 0x0037 }
            int r4 = r1.i()     // Catch:{ all -> 0x0037 }
            int r3 = r3 - r4
            int r3 = java.lang.Math.min(r2, r3)     // Catch:{ all -> 0x0037 }
            io.ktor.utils.io.core.BufferPrimitivesKt.d(r1, r6, r7, r3)     // Catch:{ all -> 0x0037 }
            int r2 = r2 - r3
            int r7 = r7 + r3
            if (r2 <= 0) goto L_0x0032
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.c(r5, r1)     // Catch:{ all -> 0x002f }
            if (r1 != 0) goto L_0x0014
            goto L_0x0035
        L_0x002f:
            r6 = move-exception
            r0 = 0
            goto L_0x0038
        L_0x0032:
            io.ktor.utils.io.core.internal.UnsafeKt.a(r5, r1)
        L_0x0035:
            int r8 = r8 - r2
            return r8
        L_0x0037:
            r6 = move-exception
        L_0x0038:
            if (r0 == 0) goto L_0x003d
            io.ktor.utils.io.core.internal.UnsafeKt.a(r5, r1)
        L_0x003d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.a(io.ktor.utils.io.core.Input, byte[], int, int):int");
    }

    public static /* synthetic */ int b(Input input, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return a(input, bArr, i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long c(io.ktor.utils.io.core.Input r18, java.nio.ByteBuffer r19, long r20, long r22) {
        /*
            r1 = r18
            java.lang.String r0 = "$this$readAvailable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "destination"
            r10 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r11 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = io.ktor.utils.io.core.internal.UnsafeKt.b(r1, r11)
            if (r0 != 0) goto L_0x0018
            r6 = r22
            goto L_0x005b
        L_0x0018:
            r14 = r20
            r6 = r22
            r8 = r0
        L_0x001d:
            int r0 = r8.k()     // Catch:{ all -> 0x006f }
            int r2 = r8.i()     // Catch:{ all -> 0x006f }
            int r0 = r0 - r2
            long r2 = (long) r0     // Catch:{ all -> 0x006f }
            long r2 = java.lang.Math.min(r6, r2)     // Catch:{ all -> 0x006f }
            int r0 = (int) r2     // Catch:{ all -> 0x006f }
            java.nio.ByteBuffer r2 = r8.h()     // Catch:{ all -> 0x006f }
            int r3 = r8.i()     // Catch:{ all -> 0x006f }
            long r4 = (long) r3
            long r11 = (long) r0
            r3 = r19
            r16 = r6
            r6 = r11
            r13 = r8
            r8 = r14
            io.ktor.utils.io.bits.Memory.e(r2, r3, r4, r6, r8)     // Catch:{ all -> 0x006c }
            r13.c(r0)     // Catch:{ all -> 0x006c }
            long r6 = r16 - r11
            long r14 = r14 + r11
            r2 = 0
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0058
            io.ktor.utils.io.core.internal.ChunkBuffer r8 = io.ktor.utils.io.core.internal.UnsafeKt.c(r1, r13)     // Catch:{ all -> 0x0055 }
            if (r8 != 0) goto L_0x0053
            goto L_0x005b
        L_0x0053:
            r11 = 1
            goto L_0x001d
        L_0x0055:
            r0 = move-exception
            r11 = 0
            goto L_0x0072
        L_0x0058:
            io.ktor.utils.io.core.internal.UnsafeKt.a(r1, r13)
        L_0x005b:
            long r2 = r22 - r6
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x006b
            boolean r0 = r18.c0()
            if (r0 == 0) goto L_0x006b
            r2 = -1
        L_0x006b:
            return r2
        L_0x006c:
            r0 = move-exception
        L_0x006d:
            r11 = 1
            goto L_0x0072
        L_0x006f:
            r0 = move-exception
            r13 = r8
            goto L_0x006d
        L_0x0072:
            if (r11 == 0) goto L_0x0077
            io.ktor.utils.io.core.internal.UnsafeKt.a(r1, r13)
        L_0x0077:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.c(io.ktor.utils.io.core.Input, java.nio.ByteBuffer, long, long):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void d(io.ktor.utils.io.core.Input r4, io.ktor.utils.io.core.Buffer r5, int r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.b(r4, r0)
            if (r1 != 0) goto L_0x0012
            goto L_0x0032
        L_0x0012:
            int r2 = r1.k()     // Catch:{ all -> 0x003e }
            int r3 = r1.i()     // Catch:{ all -> 0x003e }
            int r2 = r2 - r3
            int r2 = java.lang.Math.min(r6, r2)     // Catch:{ all -> 0x003e }
            io.ktor.utils.io.core.BufferPrimitivesKt.c(r1, r5, r2)     // Catch:{ all -> 0x003e }
            int r6 = r6 - r2
            if (r6 <= 0) goto L_0x002f
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.c(r4, r1)     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x0012
            goto L_0x0032
        L_0x002c:
            r5 = move-exception
            r0 = 0
            goto L_0x003f
        L_0x002f:
            io.ktor.utils.io.core.internal.UnsafeKt.a(r4, r1)
        L_0x0032:
            if (r6 > 0) goto L_0x0035
            return
        L_0x0035:
            io.ktor.utils.io.core.StringsKt.a(r6)
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        L_0x003e:
            r5 = move-exception
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            io.ktor.utils.io.core.internal.UnsafeKt.a(r4, r1)
        L_0x0044:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.d(io.ktor.utils.io.core.Input, io.ktor.utils.io.core.Buffer, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void e(io.ktor.utils.io.core.Input r4, byte[] r5, int r6, int r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.b(r4, r0)
            if (r1 != 0) goto L_0x0012
            goto L_0x0033
        L_0x0012:
            int r2 = r1.k()     // Catch:{ all -> 0x003f }
            int r3 = r1.i()     // Catch:{ all -> 0x003f }
            int r2 = r2 - r3
            int r2 = java.lang.Math.min(r7, r2)     // Catch:{ all -> 0x003f }
            io.ktor.utils.io.core.BufferPrimitivesKt.d(r1, r5, r6, r2)     // Catch:{ all -> 0x003f }
            int r7 = r7 - r2
            int r6 = r6 + r2
            if (r7 <= 0) goto L_0x0030
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.c(r4, r1)     // Catch:{ all -> 0x002d }
            if (r1 != 0) goto L_0x0012
            goto L_0x0033
        L_0x002d:
            r5 = move-exception
            r0 = 0
            goto L_0x0040
        L_0x0030:
            io.ktor.utils.io.core.internal.UnsafeKt.a(r4, r1)
        L_0x0033:
            if (r7 > 0) goto L_0x0036
            return
        L_0x0036:
            io.ktor.utils.io.core.StringsKt.a(r7)
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        L_0x003f:
            r5 = move-exception
        L_0x0040:
            if (r0 == 0) goto L_0x0045
            io.ktor.utils.io.core.internal.UnsafeKt.a(r4, r1)
        L_0x0045:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.e(io.ktor.utils.io.core.Input, byte[], int, int):void");
    }
}
