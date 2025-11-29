package org.apache.tika.parser.txt;

class CharsetRecog_UTF8 extends CharsetRecognizer {
    public String b() {
        return "UTF-8";
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x008d A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0060 A[EDGE_INSN: B:59:0x0060->B:32:0x0060 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.tika.parser.txt.CharsetMatch c(org.apache.tika.parser.txt.CharsetDetector r14) {
        /*
            r13 = this;
            byte[] r0 = r14.g
            int r1 = r14.h
            r2 = 2
            r3 = 1
            r4 = 0
            r5 = 3
            if (r1 < r5) goto L_0x0024
            byte r1 = r0[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r6 = 239(0xef, float:3.35E-43)
            if (r1 != r6) goto L_0x0024
            byte r1 = r0[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r6 = 187(0xbb, float:2.62E-43)
            if (r1 != r6) goto L_0x0024
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r6 = 191(0xbf, float:2.68E-43)
            if (r1 != r6) goto L_0x0024
            r1 = r3
            goto L_0x0025
        L_0x0024:
            r1 = r4
        L_0x0025:
            r6 = r4
            r7 = r6
            r8 = r7
        L_0x0028:
            int r9 = r14.h
            if (r6 >= r9) goto L_0x0062
            byte r9 = r0[r6]
            r10 = r9 & 128(0x80, float:1.794E-43)
            if (r10 != 0) goto L_0x0033
            goto L_0x0060
        L_0x0033:
            r10 = r9 & 224(0xe0, float:3.14E-43)
            r11 = 192(0xc0, float:2.69E-43)
            if (r10 != r11) goto L_0x003b
            r9 = r3
            goto L_0x004a
        L_0x003b:
            r10 = r9 & 240(0xf0, float:3.36E-43)
            r12 = 224(0xe0, float:3.14E-43)
            if (r10 != r12) goto L_0x0043
            r9 = r2
            goto L_0x004a
        L_0x0043:
            r9 = r9 & 248(0xf8, float:3.48E-43)
            r10 = 240(0xf0, float:3.36E-43)
            if (r9 != r10) goto L_0x0057
            r9 = r5
        L_0x004a:
            int r6 = r6 + r3
            int r10 = r14.h
            if (r6 < r10) goto L_0x0050
            goto L_0x0060
        L_0x0050:
            byte r10 = r0[r6]
            r10 = r10 & r11
            r12 = 128(0x80, float:1.794E-43)
            if (r10 == r12) goto L_0x005a
        L_0x0057:
            int r7 = r7 + 1
            goto L_0x0060
        L_0x005a:
            int r9 = r9 + -1
            if (r9 != 0) goto L_0x004a
            int r8 = r8 + 1
        L_0x0060:
            int r6 = r6 + r3
            goto L_0x0028
        L_0x0062:
            r0 = 100
            if (r1 == 0) goto L_0x006a
            if (r7 != 0) goto L_0x006a
        L_0x0068:
            r4 = r0
            goto L_0x008b
        L_0x006a:
            r2 = 80
            if (r1 == 0) goto L_0x0074
            int r1 = r7 * 10
            if (r8 <= r1) goto L_0x0074
        L_0x0072:
            r4 = r2
            goto L_0x008b
        L_0x0074:
            if (r8 <= r5) goto L_0x0079
            if (r7 != 0) goto L_0x0079
            goto L_0x0068
        L_0x0079:
            if (r8 <= 0) goto L_0x007e
            if (r7 != 0) goto L_0x007e
            goto L_0x0072
        L_0x007e:
            if (r8 != 0) goto L_0x0085
            if (r7 != 0) goto L_0x0085
            r4 = 15
            goto L_0x008b
        L_0x0085:
            int r7 = r7 * 10
            if (r8 <= r7) goto L_0x008b
            r4 = 25
        L_0x008b:
            if (r4 != 0) goto L_0x008f
            r13 = 0
            goto L_0x0095
        L_0x008f:
            org.apache.tika.parser.txt.CharsetMatch r0 = new org.apache.tika.parser.txt.CharsetMatch
            r0.<init>(r14, r13, r4)
            r13 = r0
        L_0x0095:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.txt.CharsetRecog_UTF8.c(org.apache.tika.parser.txt.CharsetDetector):org.apache.tika.parser.txt.CharsetMatch");
    }
}
