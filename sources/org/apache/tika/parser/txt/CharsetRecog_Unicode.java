package org.apache.tika.parser.txt;

abstract class CharsetRecog_Unicode extends CharsetRecognizer {

    public static class CharsetRecog_UTF_16_BE extends CharsetRecog_Unicode {
        public String b() {
            return "UTF-16BE";
        }

        public CharsetMatch c(CharsetDetector charsetDetector) {
            byte[] bArr = charsetDetector.g;
            int min = Math.min(bArr.length, 30);
            int i = 10;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= min - 1) {
                    break;
                }
                int e = CharsetRecog_Unicode.e(bArr[i3], bArr[i3 + 1]);
                if (i3 != 0 || e != 65279) {
                    i = CharsetRecog_Unicode.d(e, i);
                    if (i == 0 || i == 100) {
                        break;
                    }
                    i3 += 2;
                } else {
                    i = 100;
                    break;
                }
            }
            if (min >= 4 || i >= 100) {
                i2 = i;
            }
            if (i2 > 0) {
                return new CharsetMatch(charsetDetector, this, i2);
            }
            return null;
        }
    }

    public static class CharsetRecog_UTF_16_LE extends CharsetRecog_Unicode {
        public String b() {
            return "UTF-16LE";
        }

        public CharsetMatch c(CharsetDetector charsetDetector) {
            byte[] bArr = charsetDetector.g;
            int min = Math.min(bArr.length, 30);
            int i = 10;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= min - 1) {
                    break;
                }
                int e = CharsetRecog_Unicode.e(bArr[i3 + 1], bArr[i3]);
                if (i3 != 0 || e != 65279) {
                    i = CharsetRecog_Unicode.d(e, i);
                    if (i == 0 || i == 100) {
                        break;
                    }
                    i3 += 2;
                } else {
                    i = 100;
                    break;
                }
            }
            if (min >= 4 || i >= 100) {
                i2 = i;
            }
            if (i2 > 0) {
                return new CharsetMatch(charsetDetector, this, i2);
            }
            return null;
        }
    }

    public static abstract class CharsetRecog_UTF_32 extends CharsetRecog_Unicode {
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.apache.tika.parser.txt.CharsetMatch c(org.apache.tika.parser.txt.CharsetDetector r11) {
            /*
                r10 = this;
                byte[] r0 = r11.g
                int r1 = r11.h
                int r1 = r1 / 4
                int r1 = r1 * 4
                r2 = 0
                if (r1 != 0) goto L_0x000c
                return r2
            L_0x000c:
                r3 = 0
                int r4 = r10.f(r0, r3)
                r5 = 65279(0xfeff, float:9.1475E-41)
                if (r4 != r5) goto L_0x0018
                r4 = 1
                goto L_0x0019
            L_0x0018:
                r4 = r3
            L_0x0019:
                r5 = r3
                r6 = r5
                r7 = r6
            L_0x001c:
                if (r5 >= r1) goto L_0x003c
                int r8 = r10.f(r0, r5)
                if (r8 < 0) goto L_0x0037
                r9 = 1114111(0x10ffff, float:1.561202E-39)
                if (r8 >= r9) goto L_0x0037
                r9 = 55296(0xd800, float:7.7486E-41)
                if (r8 < r9) goto L_0x0034
                r9 = 57343(0xdfff, float:8.0355E-41)
                if (r8 > r9) goto L_0x0034
                goto L_0x0037
            L_0x0034:
                int r7 = r7 + 1
                goto L_0x0039
            L_0x0037:
                int r6 = r6 + 1
            L_0x0039:
                int r5 = r5 + 4
                goto L_0x001c
            L_0x003c:
                r0 = 100
                if (r4 == 0) goto L_0x0044
                if (r6 != 0) goto L_0x0044
            L_0x0042:
                r3 = r0
                goto L_0x005f
            L_0x0044:
                r1 = 80
                if (r4 == 0) goto L_0x004e
                int r4 = r6 * 10
                if (r7 <= r4) goto L_0x004e
            L_0x004c:
                r3 = r1
                goto L_0x005f
            L_0x004e:
                r4 = 3
                if (r7 <= r4) goto L_0x0054
                if (r6 != 0) goto L_0x0054
                goto L_0x0042
            L_0x0054:
                if (r7 <= 0) goto L_0x0059
                if (r6 != 0) goto L_0x0059
                goto L_0x004c
            L_0x0059:
                int r6 = r6 * 10
                if (r7 <= r6) goto L_0x005f
                r3 = 25
            L_0x005f:
                if (r3 != 0) goto L_0x0062
                goto L_0x0067
            L_0x0062:
                org.apache.tika.parser.txt.CharsetMatch r2 = new org.apache.tika.parser.txt.CharsetMatch
                r2.<init>(r11, r10, r3)
            L_0x0067:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.txt.CharsetRecog_Unicode.CharsetRecog_UTF_32.c(org.apache.tika.parser.txt.CharsetDetector):org.apache.tika.parser.txt.CharsetMatch");
        }

        public abstract int f(byte[] bArr, int i);
    }

    public static class CharsetRecog_UTF_32_BE extends CharsetRecog_UTF_32 {
        public String b() {
            return "UTF-32BE";
        }

        public int f(byte[] bArr, int i) {
            return ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
        }
    }

    public static class CharsetRecog_UTF_32_LE extends CharsetRecog_UTF_32 {
        public String b() {
            return "UTF-32LE";
        }

        public int f(byte[] bArr, int i) {
            return ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
        }
    }

    public static int d(int i, int i2) {
        if (i == 0) {
            i2 -= 10;
        } else if ((i >= 32 && i <= 255) || i == 10) {
            i2 += 10;
        }
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 100) {
            return 100;
        }
        return i2;
    }

    public static int e(byte b, byte b2) {
        return ((b & 255) << 8) | (b2 & 255);
    }
}
