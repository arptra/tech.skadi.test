package org.apache.tika.detect;

import com.meizu.common.widget.MzContactsContract;
import java.io.CharArrayWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import org.apache.tika.mime.MediaType;

public class MagicDetector implements Detector {
    private final boolean isRegex;
    private final boolean isStringIgnoreCase;
    private final int length;
    private final byte[] mask;
    private final int offsetRangeBegin;
    private final int offsetRangeEnd;
    private final byte[] pattern;
    private final int patternLength;
    private final MediaType type;

    public MagicDetector(MediaType mediaType, byte[] bArr) {
        this(mediaType, bArr, 0);
    }

    private static byte[] decodeString(String str, String str2) {
        int i = 0;
        if (str.startsWith("0x")) {
            int length2 = (str.length() - 2) / 2;
            byte[] bArr = new byte[length2];
            while (i < length2) {
                int i2 = i * 2;
                bArr[i] = (byte) Integer.parseInt(str.substring(i2 + 2, i2 + 4), 16);
                i++;
            }
            return bArr;
        }
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        int i3 = 0;
        while (i3 < str.length()) {
            if (str.charAt(i3) == '\\') {
                int i4 = i3 + 1;
                if (str.charAt(i4) == '\\') {
                    charArrayWriter.write(92);
                } else if (str.charAt(i4) == 'x') {
                    charArrayWriter.write(Integer.parseInt(str.substring(i3 + 2, i3 + 4), 16));
                    i3 += 3;
                } else if (str.charAt(i4) == 'r') {
                    charArrayWriter.write(13);
                } else if (str.charAt(i4) == 'n') {
                    charArrayWriter.write(10);
                } else {
                    int i5 = i4;
                    while (i5 < i3 + 4 && i5 < str.length() && Character.isDigit(str.charAt(i5))) {
                        i5++;
                    }
                    charArrayWriter.write(Short.decode("0" + str.substring(i4, i5)).byteValue());
                    i3 = i5 + -1;
                }
                i3 = i4;
            } else {
                charArrayWriter.write(str.charAt(i3));
            }
            i3++;
        }
        char[] charArray = charArrayWriter.toCharArray();
        if ("unicodeLE".equals(str2)) {
            byte[] bArr2 = new byte[(charArray.length * 2)];
            while (i < charArray.length) {
                int i6 = i * 2;
                char c = charArray[i];
                bArr2[i6] = (byte) (c & 255);
                bArr2[i6 + 1] = (byte) (c >> 8);
                i++;
            }
            return bArr2;
        } else if ("unicodeBE".equals(str2)) {
            byte[] bArr3 = new byte[(charArray.length * 2)];
            while (i < charArray.length) {
                int i7 = i * 2;
                char c2 = charArray[i];
                bArr3[i7] = (byte) (c2 >> 8);
                bArr3[i7 + 1] = (byte) (c2 & 255);
                i++;
            }
            return bArr3;
        } else {
            int length3 = charArray.length;
            byte[] bArr4 = new byte[length3];
            while (i < length3) {
                bArr4[i] = (byte) charArray[i];
                i++;
            }
            return bArr4;
        }
    }

    private static byte[] decodeValue(String str, String str2) {
        int i;
        String str3;
        String str4 = str;
        String str5 = str2;
        if (str4 == null || str5 == null) {
            return null;
        }
        if (str4.startsWith("0x")) {
            str3 = str4.substring(2);
            i = 16;
        } else {
            str3 = str4;
            i = 8;
        }
        char c = 65535;
        switch (str2.hashCode()) {
            case -1211485747:
                if (str5.equals("host16")) {
                    c = 0;
                    break;
                }
                break;
            case -1211485689:
                if (str5.equals("host32")) {
                    c = 1;
                    break;
                }
                break;
            case -944685088:
                if (str5.equals("unicodeBE")) {
                    c = 2;
                    break;
                }
                break;
            case -944684778:
                if (str5.equals("unicodeLE")) {
                    c = 3;
                    break;
                }
                break;
            case -891985903:
                if (str5.equals("string")) {
                    c = 4;
                    break;
                }
                break;
            case -548372781:
                if (str5.equals("stringignorecase")) {
                    c = 5;
                    break;
                }
                break;
            case 3039496:
                if (str5.equals("byte")) {
                    c = 6;
                    break;
                }
                break;
            case 93733669:
                if (str5.equals("big16")) {
                    c = 7;
                    break;
                }
                break;
            case 93733727:
                if (str5.equals("big32")) {
                    c = 8;
                    break;
                }
                break;
            case 108392519:
                if (str5.equals("regex")) {
                    c = 9;
                    break;
                }
                break;
            case 1374987163:
                if (str5.equals("little16")) {
                    c = 10;
                    break;
                }
                break;
            case 1374987221:
                if (str5.equals("little32")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 10:
                int parseInt = Integer.parseInt(str3, i);
                return new byte[]{(byte) (parseInt & 255), (byte) (parseInt >> 8)};
            case 1:
            case 11:
                long parseLong = Long.parseLong(str3, i);
                return new byte[]{(byte) ((int) (255 & parseLong)), (byte) ((int) ((parseLong & 65280) >> 8)), (byte) ((int) ((parseLong & 16711680) >> 16)), (byte) ((int) ((parseLong & -16777216) >> 24))};
            case 2:
            case 3:
            case 4:
            case 9:
                return decodeString(str, str2);
            case 5:
                return decodeString(str4.toLowerCase(Locale.ROOT), str5);
            case 6:
                return str3.getBytes(StandardCharsets.UTF_8);
            case 7:
                int parseInt2 = Integer.parseInt(str3, i);
                return new byte[]{(byte) (parseInt2 >> 8), (byte) (parseInt2 & 255)};
            case 8:
                long parseLong2 = Long.parseLong(str3, i);
                return new byte[]{(byte) ((int) ((parseLong2 & -16777216) >> 24)), (byte) ((int) ((parseLong2 & 16711680) >> 16)), (byte) ((int) ((parseLong2 & 65280) >> 8)), (byte) ((int) (parseLong2 & 255))};
            default:
                return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.tika.detect.MagicDetector parse(org.apache.tika.mime.MediaType r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            r0 = 0
            if (r11 == 0) goto L_0x0010
            r1 = 58
            int r1 = r11.indexOf(r1)
            r2 = -1
            if (r1 != r2) goto L_0x0013
            int r0 = java.lang.Integer.parseInt(r11)
        L_0x0010:
            r7 = r0
            r8 = r7
            goto L_0x0027
        L_0x0013:
            java.lang.String r0 = r11.substring(r0, r1)
            int r0 = java.lang.Integer.parseInt(r0)
            int r1 = r1 + 1
            java.lang.String r11 = r11.substring(r1)
            int r11 = java.lang.Integer.parseInt(r11)
            r8 = r11
            r7 = r0
        L_0x0027:
            byte[] r3 = decodeValue(r12, r10)
            if (r13 == 0) goto L_0x0033
            byte[] r11 = decodeValue(r13, r10)
        L_0x0031:
            r4 = r11
            goto L_0x0035
        L_0x0033:
            r11 = 0
            goto L_0x0031
        L_0x0035:
            org.apache.tika.detect.MagicDetector r11 = new org.apache.tika.detect.MagicDetector
            java.lang.String r12 = "regex"
            boolean r5 = r10.equals(r12)
            java.lang.String r12 = "stringignorecase"
            boolean r6 = r10.equals(r12)
            r1 = r11
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.detect.MagicDetector.parse(org.apache.tika.mime.MediaType, java.lang.String, java.lang.String, java.lang.String, java.lang.String):org.apache.tika.detect.MagicDetector");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = r7.length + (r7.offsetRangeEnd - r1);
        r1 = new byte[r3];
        r4 = r8.read(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if (r4 <= 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        r0 = r0 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        if (r4 == -1) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        if (r0 >= (r7.offsetRangeEnd + r7.length)) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        r4 = r0 - r7.offsetRangeBegin;
        r4 = r8.read(r1, r4, r3 - r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
        if (r4 <= 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005d, code lost:
        if (r7.isRegex == false) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0061, code lost:
        if (r7.isStringIgnoreCase == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
        r0 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0065, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0066, code lost:
        r0 = java.util.regex.Pattern.compile(new java.lang.String(r7.pattern, java.nio.charset.StandardCharsets.UTF_8), r0).matcher(java.nio.charset.StandardCharsets.ISO_8859_1.decode(java.nio.ByteBuffer.wrap(r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0086, code lost:
        if (r9 > (r7.offsetRangeEnd - r7.offsetRangeBegin)) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0088, code lost:
        r0.region(r9, r7.length + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0092, code lost:
        if (r0.lookingAt() == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0094, code lost:
        r7 = r7.type;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0096, code lost:
        r8.reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0099, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009a, code lost:
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a2, code lost:
        if (r0 >= (r7.offsetRangeBegin + r7.length)) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a4, code lost:
        r7 = org.apache.tika.mime.MediaType.OCTET_STREAM;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a6, code lost:
        r8.reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a9, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00aa, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b0, code lost:
        if (r0 > (r7.offsetRangeEnd - r7.offsetRangeBegin)) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b2, code lost:
        r4 = 0;
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b5, code lost:
        if (r3 == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b9, code lost:
        if (r4 >= r7.length) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00bb, code lost:
        r3 = r1[r0 + r4] & r7.mask[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c6, code lost:
        if (r7.isStringIgnoreCase == false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c8, code lost:
        r3 = java.lang.Character.toLowerCase(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d0, code lost:
        if (r3 != r7.pattern[r4]) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d2, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00d4, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00d5, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00d8, code lost:
        if (r3 == false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00da, code lost:
        r7 = r7.type;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00dc, code lost:
        r8.reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00df, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e0, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r7 = org.apache.tika.mime.MediaType.OCTET_STREAM;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00e5, code lost:
        r8.reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00e8, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.tika.mime.MediaType detect(java.io.InputStream r8, org.apache.tika.metadata.Metadata r9) throws java.io.IOException {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0005
            org.apache.tika.mime.MediaType r7 = org.apache.tika.mime.MediaType.OCTET_STREAM
            return r7
        L_0x0005:
            int r9 = r7.offsetRangeEnd
            int r0 = r7.length
            int r9 = r9 + r0
            r8.mark(r9)
            r9 = 0
            r0 = r9
        L_0x000f:
            int r1 = r7.offsetRangeBegin     // Catch:{ all -> 0x0033 }
            r2 = -1
            if (r0 >= r1) goto L_0x0036
            int r1 = r1 - r0
            long r3 = (long) r1     // Catch:{ all -> 0x0033 }
            long r3 = r8.skip(r3)     // Catch:{ all -> 0x0033 }
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0024
            long r0 = (long) r0     // Catch:{ all -> 0x0033 }
            long r0 = r0 + r3
            int r0 = (int) r0     // Catch:{ all -> 0x0033 }
            goto L_0x000f
        L_0x0024:
            int r1 = r8.read()     // Catch:{ all -> 0x0033 }
            if (r1 == r2) goto L_0x002d
            int r0 = r0 + 1
            goto L_0x000f
        L_0x002d:
            org.apache.tika.mime.MediaType r7 = org.apache.tika.mime.MediaType.OCTET_STREAM     // Catch:{ all -> 0x0033 }
            r8.reset()
            return r7
        L_0x0033:
            r7 = move-exception
            goto L_0x00e9
        L_0x0036:
            int r3 = r7.length     // Catch:{ all -> 0x0033 }
            int r4 = r7.offsetRangeEnd     // Catch:{ all -> 0x0033 }
            int r4 = r4 - r1
            int r3 = r3 + r4
            byte[] r1 = new byte[r3]     // Catch:{ all -> 0x0033 }
            int r4 = r8.read(r1)     // Catch:{ all -> 0x0033 }
            if (r4 <= 0) goto L_0x0045
        L_0x0044:
            int r0 = r0 + r4
        L_0x0045:
            if (r4 == r2) goto L_0x005b
            int r4 = r7.offsetRangeEnd     // Catch:{ all -> 0x0033 }
            int r5 = r7.length     // Catch:{ all -> 0x0033 }
            int r4 = r4 + r5
            if (r0 >= r4) goto L_0x005b
            int r4 = r7.offsetRangeBegin     // Catch:{ all -> 0x0033 }
            int r4 = r0 - r4
            int r5 = r3 - r4
            int r4 = r8.read(r1, r4, r5)     // Catch:{ all -> 0x0033 }
            if (r4 <= 0) goto L_0x0045
            goto L_0x0044
        L_0x005b:
            boolean r2 = r7.isRegex     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x009d
            boolean r0 = r7.isStringIgnoreCase     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0065
            r0 = 2
            goto L_0x0066
        L_0x0065:
            r0 = r9
        L_0x0066:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0033 }
            byte[] r3 = r7.pattern     // Catch:{ all -> 0x0033 }
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0033 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0033 }
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r2, r0)     // Catch:{ all -> 0x0033 }
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.wrap(r1)     // Catch:{ all -> 0x0033 }
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch:{ all -> 0x0033 }
            java.nio.CharBuffer r1 = r2.decode(r1)     // Catch:{ all -> 0x0033 }
            java.util.regex.Matcher r0 = r0.matcher(r1)     // Catch:{ all -> 0x0033 }
        L_0x0081:
            int r1 = r7.offsetRangeEnd     // Catch:{ all -> 0x0033 }
            int r2 = r7.offsetRangeBegin     // Catch:{ all -> 0x0033 }
            int r1 = r1 - r2
            if (r9 > r1) goto L_0x00e3
            int r1 = r7.length     // Catch:{ all -> 0x0033 }
            int r1 = r1 + r9
            r0.region(r9, r1)     // Catch:{ all -> 0x0033 }
            boolean r1 = r0.lookingAt()     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x009a
            org.apache.tika.mime.MediaType r7 = r7.type     // Catch:{ all -> 0x0033 }
            r8.reset()
            return r7
        L_0x009a:
            int r9 = r9 + 1
            goto L_0x0081
        L_0x009d:
            int r2 = r7.offsetRangeBegin     // Catch:{ all -> 0x0033 }
            int r3 = r7.length     // Catch:{ all -> 0x0033 }
            int r2 = r2 + r3
            if (r0 >= r2) goto L_0x00aa
            org.apache.tika.mime.MediaType r7 = org.apache.tika.mime.MediaType.OCTET_STREAM     // Catch:{ all -> 0x0033 }
            r8.reset()
            return r7
        L_0x00aa:
            r0 = r9
        L_0x00ab:
            int r2 = r7.offsetRangeEnd     // Catch:{ all -> 0x0033 }
            int r3 = r7.offsetRangeBegin     // Catch:{ all -> 0x0033 }
            int r2 = r2 - r3
            if (r0 > r2) goto L_0x00e3
            r2 = 1
            r4 = r9
            r3 = r2
        L_0x00b5:
            if (r3 == 0) goto L_0x00d8
            int r5 = r7.length     // Catch:{ all -> 0x0033 }
            if (r4 >= r5) goto L_0x00d8
            int r3 = r0 + r4
            byte r3 = r1[r3]     // Catch:{ all -> 0x0033 }
            byte[] r5 = r7.mask     // Catch:{ all -> 0x0033 }
            byte r5 = r5[r4]     // Catch:{ all -> 0x0033 }
            r3 = r3 & r5
            boolean r5 = r7.isStringIgnoreCase     // Catch:{ all -> 0x0033 }
            if (r5 == 0) goto L_0x00cc
            int r3 = java.lang.Character.toLowerCase(r3)     // Catch:{ all -> 0x0033 }
        L_0x00cc:
            byte[] r5 = r7.pattern     // Catch:{ all -> 0x0033 }
            byte r5 = r5[r4]     // Catch:{ all -> 0x0033 }
            if (r3 != r5) goto L_0x00d4
            r3 = r2
            goto L_0x00d5
        L_0x00d4:
            r3 = r9
        L_0x00d5:
            int r4 = r4 + 1
            goto L_0x00b5
        L_0x00d8:
            if (r3 == 0) goto L_0x00e0
            org.apache.tika.mime.MediaType r7 = r7.type     // Catch:{ all -> 0x0033 }
            r8.reset()
            return r7
        L_0x00e0:
            int r0 = r0 + 1
            goto L_0x00ab
        L_0x00e3:
            org.apache.tika.mime.MediaType r7 = org.apache.tika.mime.MediaType.OCTET_STREAM     // Catch:{ all -> 0x0033 }
            r8.reset()
            return r7
        L_0x00e9:
            r8.reset()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.detect.MagicDetector.detect(java.io.InputStream, org.apache.tika.metadata.Metadata):org.apache.tika.mime.MediaType");
    }

    public int getLength() {
        return this.patternLength;
    }

    public String toString() {
        return "Magic Detection for " + this.type + " looking for " + this.pattern.length + " bytes = " + this.pattern + " mask = " + this.mask;
    }

    public MagicDetector(MediaType mediaType, byte[] bArr, int i) {
        this(mediaType, bArr, (byte[]) null, i, i);
    }

    public MagicDetector(MediaType mediaType, byte[] bArr, byte[] bArr2, int i, int i2) {
        this(mediaType, bArr, bArr2, false, i, i2);
    }

    public MagicDetector(MediaType mediaType, byte[] bArr, byte[] bArr2, boolean z, int i, int i2) {
        this(mediaType, bArr, bArr2, z, false, i, i2);
    }

    public MagicDetector(MediaType mediaType, byte[] bArr, byte[] bArr2, boolean z, boolean z2, int i, int i2) {
        if (mediaType == null) {
            throw new IllegalArgumentException("Matching media type is null");
        } else if (bArr == null) {
            throw new IllegalArgumentException("Magic match pattern is null");
        } else if (i < 0 || i2 < i) {
            throw new IllegalArgumentException("Invalid offset range: [" + i + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + i2 + "]");
        } else {
            this.type = mediaType;
            this.isRegex = z;
            this.isStringIgnoreCase = z2;
            int max = Math.max(bArr.length, bArr2 != null ? bArr2.length : 0);
            this.patternLength = max;
            if (z) {
                this.length = 8192;
            } else {
                this.length = max;
            }
            this.mask = new byte[max];
            this.pattern = new byte[max];
            for (int i3 = 0; i3 < this.patternLength; i3++) {
                if (bArr2 == null || i3 >= bArr2.length) {
                    this.mask[i3] = -1;
                } else {
                    this.mask[i3] = bArr2[i3];
                }
                if (i3 < bArr.length) {
                    this.pattern[i3] = (byte) (bArr[i3] & this.mask[i3]);
                } else {
                    this.pattern[i3] = 0;
                }
            }
            this.offsetRangeBegin = i;
            this.offsetRangeEnd = i2;
        }
    }
}
