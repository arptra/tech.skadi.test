package org.eclipse.jetty.util.security;

import com.google.common.primitives.SignedBytes;
import com.upuphone.starrynet.strategy.message.payload.handler.RingDataUtil;
import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.PrintStream;
import okio.Utf8;

public class UnixCrypt {
    private static final byte[] A64TOI = new byte[128];
    private static final long[][] CF6464;
    private static final byte[] CIFP = {1, 2, 3, 4, 17, 18, 19, 20, 5, 6, 7, 8, 21, 22, 23, 24, 9, 10, 11, 12, 25, 26, 27, 28, 13, 14, 15, 16, 29, 30, 31, 32, 33, 34, 35, BinaryMemcacheOpcodes.GATKQ, 49, 50, 51, 52, 37, 38, 39, RingDataUtil.OPCODE_SET_GET_RING_NAME, 53, 54, 55, 56, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 42, 43, HttpConstants.COMMA, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, 45, 46, 47, 48, 61, 62, Utf8.REPLACEMENT_BYTE, SignedBytes.MAX_POWER_OF_TWO};
    private static final byte[] ExpandTr = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
    private static final long[][] IE3264;
    private static final byte[] IP = {HttpConstants.COLON, 50, 42, 34, 26, 18, 10, 2, 60, 52, HttpConstants.COMMA, BinaryMemcacheOpcodes.GATKQ, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, SignedBytes.MAX_POWER_OF_TWO, 56, 48, RingDataUtil.OPCODE_SET_GET_RING_NAME, 32, 24, 16, 8, 57, 49, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 33, 25, 17, 9, 1, HttpConstants.SEMICOLON, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, Utf8.REPLACEMENT_BYTE, 55, 47, 39, 31, 23, 15, 7};
    private static final byte[] ITOA64 = {46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, RingSecurityPair.OPCODE_RING_PAIR, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] P32Tr = {16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25};
    private static final byte[] PC1 = {57, 49, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 33, 25, 17, 9, 1, HttpConstants.COLON, 50, 42, 34, 26, 18, 10, 2, HttpConstants.SEMICOLON, 51, 43, 35, 27, 19, 11, 3, 60, 52, HttpConstants.COMMA, BinaryMemcacheOpcodes.GATKQ, Utf8.REPLACEMENT_BYTE, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};
    private static final long[][] PC1ROT;
    private static final byte[] PC2 = {9, 18, 14, 17, 11, 24, 1, 5, 22, 25, 3, 28, 15, 6, 21, 10, 35, 38, 23, 19, 12, 4, 26, 8, 43, 54, 16, 7, 27, 20, 13, 2, 0, 0, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 52, 31, 37, 47, 55, 0, 0, 30, RingDataUtil.OPCODE_SET_GET_RING_NAME, 51, 45, 33, 48, 0, 0, HttpConstants.COMMA, 49, 39, 56, 34, 53, 0, 0, 46, 42, 50, BinaryMemcacheOpcodes.GATKQ, 29, 32};
    private static final long[][][] PC2ROT;
    private static final byte[] Rotates = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};
    private static final byte[][] S = {new byte[]{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7, 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8, 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0, 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}, new byte[]{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10, 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5, 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15, 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}, new byte[]{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8, 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1, 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7, 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}, new byte[]{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15, 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9, 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4, 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}, new byte[]{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9, 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6, 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14, 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}, new byte[]{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11, 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8, 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6, 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}, new byte[]{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1, 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6, 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2, 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}, new byte[]{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7, 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2, 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8, 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};
    private static final long[][] SPE;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v53, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v55, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v56, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x016f, code lost:
        if (r11 <= 0) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0171, code lost:
        r11 = r11 - 1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 2
            r2 = 64
            r3 = 32
            r5 = 16
            r6 = 8
            r7 = 1
            r8 = 3
            byte[] r9 = new byte[r2]
            r9 = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7} // fill-array
            IP = r9
            r9 = 48
            byte[] r9 = new byte[r9]
            r9 = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1} // fill-array
            ExpandTr = r9
            r9 = 56
            byte[] r9 = new byte[r9]
            r9 = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4} // fill-array
            PC1 = r9
            byte[] r9 = new byte[r5]
            r9 = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1} // fill-array
            Rotates = r9
            r9 = 0
            byte[] r10 = new byte[r2]
            r10 = {9, 18, 14, 17, 11, 24, 1, 5, 22, 25, 3, 28, 15, 6, 21, 10, 35, 38, 23, 19, 12, 4, 26, 8, 43, 54, 16, 7, 27, 20, 13, 2, 0, 0, 41, 52, 31, 37, 47, 55, 0, 0, 30, 40, 51, 45, 33, 48, 0, 0, 44, 49, 39, 56, 34, 53, 0, 0, 46, 42, 50, 36, 29, 32} // fill-array
            PC2 = r10
            byte[] r11 = new byte[r2]
            r11 = {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7, 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8, 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0, 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13} // fill-array
            byte[] r12 = new byte[r2]
            r12 = {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10, 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5, 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15, 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9} // fill-array
            byte[] r13 = new byte[r2]
            r13 = {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8, 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1, 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7, 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12} // fill-array
            byte[] r14 = new byte[r2]
            r14 = {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15, 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9, 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4, 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14} // fill-array
            byte[] r15 = new byte[r2]
            r15 = {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9, 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6, 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14, 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3} // fill-array
            byte[] r10 = new byte[r2]
            r10 = {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11, 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8, 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6, 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13} // fill-array
            byte[] r4 = new byte[r2]
            r4 = {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1, 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6, 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2, 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12} // fill-array
            byte[] r1 = new byte[r2]
            r1 = {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7, 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2, 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8, 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11} // fill-array
            r16 = r10
            r17 = r4
            r18 = r1
            byte[][] r1 = new byte[][]{r11, r12, r13, r14, r15, r16, r17, r18}
            S = r1
            byte[] r1 = new byte[r3]
            r1 = {16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25} // fill-array
            P32Tr = r1
            byte[] r1 = new byte[r2]
            r1 = {1, 2, 3, 4, 17, 18, 19, 20, 5, 6, 7, 8, 21, 22, 23, 24, 9, 10, 11, 12, 25, 26, 27, 28, 13, 14, 15, 16, 29, 30, 31, 32, 33, 34, 35, 36, 49, 50, 51, 52, 37, 38, 39, 40, 53, 54, 55, 56, 41, 42, 43, 44, 57, 58, 59, 60, 45, 46, 47, 48, 61, 62, 63, 64} // fill-array
            CIFP = r1
            byte[] r1 = new byte[r2]
            r1 = {46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122} // fill-array
            ITOA64 = r1
            r1 = 128(0x80, float:1.794E-43)
            byte[] r1 = new byte[r1]
            A64TOI = r1
            int[] r1 = new int[r0]
            r1[r7] = r5
            r1[r9] = r5
            java.lang.Class r4 = java.lang.Long.TYPE
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r4, r1)
            long[][] r1 = (long[][]) r1
            PC1ROT = r1
            int[] r1 = new int[r8]
            r1[r0] = r5
            r1[r7] = r5
            r1[r9] = r0
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r4, r1)
            long[][][] r1 = (long[][][]) r1
            PC2ROT = r1
            int[] r1 = new int[r0]
            r1[r7] = r5
            r1[r9] = r6
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r4, r1)
            long[][] r1 = (long[][]) r1
            IE3264 = r1
            int[] r1 = new int[r0]
            r1[r7] = r2
            r1[r9] = r6
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r4, r1)
            long[][] r1 = (long[][]) r1
            SPE = r1
            int[] r1 = new int[r0]
            r1[r7] = r5
            r1[r9] = r5
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r4, r1)
            long[][] r1 = (long[][]) r1
            CF6464 = r1
            byte[] r1 = new byte[r2]
            byte[] r4 = new byte[r2]
            r5 = r9
        L_0x00d1:
            if (r5 >= r2) goto L_0x00de
            byte[] r10 = A64TOI
            byte[] r11 = ITOA64
            byte r11 = r11[r5]
            byte r12 = (byte) r5
            r10[r11] = r12
            int r5 = r5 + r7
            goto L_0x00d1
        L_0x00de:
            r5 = r9
        L_0x00df:
            if (r5 >= r2) goto L_0x00e5
            r1[r5] = r9
            int r5 = r5 + r7
            goto L_0x00df
        L_0x00e5:
            r5 = r9
        L_0x00e6:
            if (r5 >= r2) goto L_0x0110
            byte[] r10 = PC2
            byte r10 = r10[r5]
            if (r10 != 0) goto L_0x00ef
            goto L_0x010e
        L_0x00ef:
            byte[] r11 = Rotates
            byte r11 = r11[r9]
            int r12 = r11 + -1
            int r10 = r10 + r12
            int r12 = r10 % 28
            if (r12 >= r11) goto L_0x00fc
            int r10 = r10 + -28
        L_0x00fc:
            byte[] r11 = PC1
            byte r10 = r11[r10]
            if (r10 <= 0) goto L_0x010b
            int r10 = r10 + -1
            r11 = r10 | 7
            r10 = r10 & 7
            int r11 = r11 - r10
            int r10 = r11 + 1
        L_0x010b:
            byte r10 = (byte) r10
            r1[r5] = r10
        L_0x010e:
            int r5 = r5 + r7
            goto L_0x00e6
        L_0x0110:
            long[][] r5 = PC1ROT
            init_perm(r5, r1, r6)
            r5 = r9
        L_0x0116:
            if (r5 >= r0) goto L_0x0153
            r10 = r9
        L_0x0119:
            if (r10 >= r2) goto L_0x0121
            r4[r10] = r9
            r1[r10] = r9
            int r10 = r10 + r7
            goto L_0x0119
        L_0x0121:
            r10 = r9
        L_0x0122:
            if (r10 >= r2) goto L_0x0133
            byte[] r11 = PC2
            byte r11 = r11[r10]
            if (r11 != 0) goto L_0x012b
            goto L_0x0131
        L_0x012b:
            int r11 = r11 - r7
            int r12 = r10 + 1
            byte r12 = (byte) r12
            r4[r11] = r12
        L_0x0131:
            int r10 = r10 + r7
            goto L_0x0122
        L_0x0133:
            r10 = r9
        L_0x0134:
            if (r10 >= r2) goto L_0x014a
            byte[] r11 = PC2
            byte r11 = r11[r10]
            if (r11 != 0) goto L_0x013d
            goto L_0x0148
        L_0x013d:
            int r11 = r11 + r5
            int r12 = r11 % 28
            if (r12 > r5) goto L_0x0144
            int r11 = r11 + -28
        L_0x0144:
            byte r11 = r4[r11]
            r1[r10] = r11
        L_0x0148:
            int r10 = r10 + r7
            goto L_0x0134
        L_0x014a:
            long[][][] r10 = PC2ROT
            r10 = r10[r5]
            init_perm(r10, r1, r6)
            int r5 = r5 + r7
            goto L_0x0116
        L_0x0153:
            r5 = r9
        L_0x0154:
            if (r5 >= r6) goto L_0x0188
            r10 = r9
        L_0x0157:
            if (r10 >= r6) goto L_0x0186
            if (r10 >= r0) goto L_0x015d
            r11 = r9
            goto L_0x016a
        L_0x015d:
            byte[] r11 = IP
            byte[] r12 = ExpandTr
            int r13 = r5 * 6
            int r13 = r13 + r10
            int r13 = r13 - r0
            byte r12 = r12[r13]
            int r12 = r12 - r7
            byte r11 = r11[r12]
        L_0x016a:
            if (r11 <= r3) goto L_0x016f
            int r11 = r11 + -32
            goto L_0x0173
        L_0x016f:
            if (r11 <= 0) goto L_0x0173
            int r11 = r11 + -1
        L_0x0173:
            if (r11 <= 0) goto L_0x017e
            int r11 = r11 + -1
            r12 = r11 | 7
            r11 = r11 & 7
            int r12 = r12 - r11
            int r11 = r12 + 1
        L_0x017e:
            int r12 = r5 * 8
            int r12 = r12 + r10
            byte r11 = (byte) r11
            r1[r12] = r11
            int r10 = r10 + r7
            goto L_0x0157
        L_0x0186:
            int r5 = r5 + r7
            goto L_0x0154
        L_0x0188:
            long[][] r5 = IE3264
            init_perm(r5, r1, r6)
            r5 = r9
        L_0x018e:
            if (r5 >= r2) goto L_0x01aa
            byte[] r10 = IP
            byte[] r11 = CIFP
            byte r11 = r11[r5]
            int r11 = r11 - r7
            byte r10 = r10[r11]
            if (r10 <= 0) goto L_0x01a4
            int r10 = r10 + -1
            r11 = r10 | 7
            r10 = r10 & 7
            int r11 = r11 - r10
            int r10 = r11 + 1
        L_0x01a4:
            int r10 = r10 - r7
            int r5 = r5 + r7
            byte r11 = (byte) r5
            r1[r10] = r11
            goto L_0x018e
        L_0x01aa:
            long[][] r5 = CF6464
            init_perm(r5, r1, r6)
            r5 = r9
        L_0x01b0:
            r10 = 48
            if (r5 >= r10) goto L_0x01c1
            byte[] r10 = P32Tr
            byte[] r11 = ExpandTr
            byte r11 = r11[r5]
            int r11 = r11 - r7
            byte r10 = r10[r11]
            r1[r5] = r10
            int r5 = r5 + r7
            goto L_0x01b0
        L_0x01c1:
            r5 = r9
        L_0x01c2:
            if (r5 >= r6) goto L_0x0246
            r10 = r9
        L_0x01c5:
            if (r10 >= r2) goto L_0x023f
            r11 = r10 & 1
            int r11 = r11 << 5
            int r12 = r10 >> 1
            r12 = r12 & r7
            int r12 = r12 << r8
            r11 = r11 | r12
            int r12 = r10 >> 2
            r12 = r12 & r7
            int r12 = r12 << r0
            r11 = r11 | r12
            int r12 = r10 >> 3
            r12 = r12 & r7
            int r12 = r12 << r7
            r11 = r11 | r12
            r12 = 4
            int r13 = r10 >> 4
            r13 = r13 & r7
            r11 = r11 | r13
            int r13 = r10 >> 5
            r13 = r13 & r7
            int r13 = r13 << r12
            r11 = r11 | r13
            byte[][] r12 = S
            r12 = r12[r5]
            byte r11 = r12[r11]
            int r12 = r11 >> 3
            r12 = r12 & r7
            int r13 = r11 >> 2
            r13 = r13 & r7
            int r13 = r13 << r7
            r12 = r12 | r13
            int r13 = r11 >> 1
            r13 = r13 & r7
            int r13 = r13 << r0
            r12 = r12 | r13
            r11 = r11 & r7
            int r11 = r11 << r8
            r11 = r11 | r12
            r12 = r9
        L_0x01fb:
            if (r12 >= r3) goto L_0x0201
            r4[r12] = r9
            int r12 = r12 + r7
            goto L_0x01fb
        L_0x0201:
            r13 = r9
            r12 = 4
        L_0x0203:
            if (r13 >= r12) goto L_0x0210
            int r14 = r5 * 4
            int r14 = r14 + r13
            int r15 = r11 >> r13
            r15 = r15 & r7
            byte r15 = (byte) r15
            r4[r14] = r15
            int r13 = r13 + r7
            goto L_0x0203
        L_0x0210:
            r13 = 0
            r11 = 24
        L_0x0214:
            int r15 = r11 + -1
            if (r15 < 0) goto L_0x0230
            long r13 = r13 << r7
            byte r16 = r1[r15]
            int r16 = r16 + -1
            byte r0 = r4[r16]
            long r8 = (long) r0
            long r8 = r8 << r3
            long r8 = r8 | r13
            int r11 = r11 + 23
            byte r0 = r1[r11]
            int r0 = r0 - r7
            byte r0 = r4[r0]
            long r13 = (long) r0
            long r13 = r13 | r8
            r11 = r15
            r0 = 2
            r8 = 3
            r9 = 0
            goto L_0x0214
        L_0x0230:
            long[][] r0 = SPE
            r0 = r0[r5]
            long r8 = to_six_bit((long) r13)
            r0[r10] = r8
            int r10 = r10 + r7
            r0 = 2
            r8 = 3
            r9 = 0
            goto L_0x01c5
        L_0x023f:
            r12 = 4
            int r5 = r5 + r7
            r0 = 2
            r8 = 3
            r9 = 0
            goto L_0x01c2
        L_0x0246:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.security.UnixCrypt.<clinit>():void");
    }

    private UnixCrypt() {
    }

    public static String crypt(String str, String str2) {
        byte[] bArr = new byte[13];
        if (str == null || str2 == null) {
            return "*";
        }
        int length = str.length();
        int i = 0;
        long j = 0;
        while (i < 8) {
            j = (j << 8) | ((long) (i < length ? str.charAt(i) * 2 : 0));
            i++;
        }
        long[] des_setkey = des_setkey(j);
        byte b = 0;
        int i2 = 2;
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            }
            char charAt = i2 < str2.length() ? str2.charAt(i2) : '.';
            bArr[i2] = (byte) charAt;
            b = (b << 6) | (A64TOI[charAt] & 255);
        }
        long des_cipher = des_cipher(0, b, 25, des_setkey);
        int i3 = 12;
        bArr[12] = ITOA64[(((int) des_cipher) << 2) & 63];
        char c = 4;
        while (true) {
            des_cipher >>= c;
            i3--;
            if (i3 < 2) {
                return new String(bArr, 0, 13);
            }
            bArr[i3] = ITOA64[((int) des_cipher) & 63];
            c = 6;
        }
    }

    private static long des_cipher(long j, int i, int i2, long[] jArr) {
        int i3 = to_six_bit(i);
        long j2 = j & 6148914691236517205L;
        long j3 = (j & -6148914694099828736L) | ((j >> 1) & 1431655765);
        char c = ' ';
        long j4 = 4294967295L;
        long[][] jArr2 = IE3264;
        long perm3264 = perm3264((int) (((((j2 << 32) | (j2 << 1)) & -4294967296L) | ((j3 | (j3 >> 32)) & 4294967295L)) >> 32), jArr2);
        long j5 = perm3264;
        long perm32642 = perm3264((int) perm3264, jArr2);
        int i4 = i2;
        while (true) {
            i4--;
            if (i4 >= 0) {
                int i5 = 0;
                while (i5 < 8) {
                    int i6 = i5 << 1;
                    long j6 = (long) i3;
                    long j7 = ((perm32642 >> c) ^ perm32642) & j6 & j4;
                    long j8 = jArr[i6] ^ ((j7 | (j7 << c)) ^ perm32642);
                    long[][] jArr3 = SPE;
                    long[] jArr4 = jArr3[0];
                    long j9 = jArr4[(int) ((j8 >> 58) & 63)];
                    long[] jArr5 = jArr3[1];
                    long j10 = j5;
                    long[] jArr6 = jArr3[2];
                    int i7 = i5;
                    long j11 = (j9 ^ jArr5[(int) ((j8 >> 50) & 63)]) ^ jArr6[(int) ((j8 >> 42) & 63)];
                    long[] jArr7 = jArr3[3];
                    long j12 = j11 ^ jArr7[(int) ((j8 >> 34) & 63)];
                    long[] jArr8 = jArr3[4];
                    long j13 = j12 ^ jArr8[(int) ((j8 >> 26) & 63)];
                    long[] jArr9 = jArr3[5];
                    long j14 = j13 ^ jArr9[(int) ((j8 >> 18) & 63)];
                    long[] jArr10 = jArr3[6];
                    long j15 = j14 ^ jArr10[(int) ((j8 >> 10) & 63)];
                    long[] jArr11 = jArr3[7];
                    long j16 = j10 ^ (j15 ^ jArr11[(int) ((j8 >> 2) & 63)]);
                    long j17 = ((j16 >> 32) ^ j16) & j6 & 4294967295L;
                    long j18 = ((j17 | (j17 << 32)) ^ j16) ^ jArr[i6 + 1];
                    perm32642 ^= jArr11[(int) ((j18 >> 2) & 63)] ^ (jArr10[(int) ((j18 >> 10) & 63)] ^ (((((jArr4[(int) ((j18 >> 58) & 63)] ^ jArr5[(int) ((j18 >> 50) & 63)]) ^ jArr6[(int) ((j18 >> 42) & 63)]) ^ jArr7[(int) ((j18 >> 34) & 63)]) ^ jArr8[(int) ((j18 >> 26) & 63)]) ^ jArr9[(int) ((j18 >> 18) & 63)]));
                    i5 = i7 + 1;
                    j5 = j16;
                    j4 = 4294967295L;
                    c = ' ';
                }
                long j19 = j4;
                long j20 = j5 ^ perm32642;
                perm32642 ^= j20;
                j5 = j20 ^ perm32642;
                c = ' ';
            } else {
                return perm6464(((perm32642 << 1) & 4042322160L) | (252645135 & (perm32642 >> 35)) | ((((j5 >> 35) & 252645135) | ((j5 << 1) & 4042322160L)) << 32), CF6464);
            }
        }
    }

    private static long[] des_setkey(long j) {
        long perm6464 = perm6464(j, PC1ROT);
        long[] jArr = new long[16];
        jArr[0] = perm6464 & -217020518463700993L;
        for (int i = 1; i < 16; i++) {
            jArr[i] = perm6464;
            perm6464 = perm6464(perm6464, PC2ROT[Rotates[i] - 1]);
            jArr[i] = perm6464 & -217020518463700993L;
        }
        return jArr;
    }

    private static void init_perm(long[][] jArr, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i * 8; i2++) {
            int i3 = bArr[i2] - 1;
            if (i3 >= 0) {
                int i4 = i3 >> 2;
                int i5 = 1 << (i3 & 3);
                for (int i6 = 0; i6 < 16; i6++) {
                    int i7 = (i2 & 7) + ((7 - (i2 >> 3)) << 3);
                    if ((i6 & i5) != 0) {
                        long[] jArr2 = jArr[i4];
                        jArr2[i6] = jArr2[i6] | (1 << i7);
                    }
                }
            }
        }
    }

    public static void main(String[] strArr) {
        if (strArr.length != 2) {
            System.err.println("Usage - java org.eclipse.util.UnixCrypt <key> <salt>");
            System.exit(1);
        }
        PrintStream printStream = System.err;
        printStream.println("Crypt=" + crypt(strArr[0], strArr[1]));
    }

    private static long perm3264(int i, long[][] jArr) {
        long j = 0;
        int i2 = 4;
        while (true) {
            i2--;
            if (i2 < 0) {
                return j;
            }
            int i3 = i2 << 1;
            j = j | jArr[i3][i & 15] | jArr[i3 + 1][(i & 255) >> 4];
            i >>= 8;
        }
    }

    private static long perm6464(long j, long[][] jArr) {
        long j2 = 0;
        int i = 8;
        while (true) {
            i--;
            if (i < 0) {
                return j2;
            }
            int i2 = (int) (255 & j);
            j >>= 8;
            int i3 = i << 1;
            j2 = j2 | jArr[i3][i2 & 15] | jArr[i3 + 1][i2 >> 4];
        }
    }

    private static int to_six_bit(int i) {
        return ((i >> 16) & 252) | ((i << 26) & -67108864) | ((i << 12) & 16515072) | ((i >> 2) & 64512);
    }

    private static long to_six_bit(long j) {
        return ((j >> 16) & 1082331758844L) | ((j << 26) & -288230371923853312L) | ((j << 12) & 70931694147600384L) | ((j >> 2) & 277076930264064L);
    }
}
