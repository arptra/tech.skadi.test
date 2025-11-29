package org.eclipse.jetty.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
import org.eclipse.jetty.util.Utf8Appendable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class UrlEncoded extends MultiMap implements Cloneable {
    public static final String ENCODING = System.getProperty("org.eclipse.jetty.util.UrlEncoding.charset", "UTF-8");
    private static final Logger LOG = Log.getLogger((Class<?>) UrlEncoded.class);

    public UrlEncoded(UrlEncoded urlEncoded) {
        super(urlEncoded);
    }

    public static void decode88591To(InputStream inputStream, MultiMap multiMap, int i, int i2) throws IOException {
        int read;
        int read2;
        int read3;
        synchronized (multiMap) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String str = null;
                int i3 = 0;
                while (true) {
                    int read4 = inputStream.read();
                    if (read4 >= 0) {
                        char c = (char) read4;
                        if (c == '%') {
                            int read5 = inputStream.read();
                            if (117 == read5) {
                                int read6 = inputStream.read();
                                if (read6 >= 0 && (read2 = inputStream.read()) >= 0 && (read3 = inputStream.read()) >= 0) {
                                    stringBuffer.append(Character.toChars((TypeUtil.convertHexDigit(read5) << 12) + (TypeUtil.convertHexDigit(read6) << 8) + (TypeUtil.convertHexDigit(read2) << 4) + TypeUtil.convertHexDigit(read3)));
                                }
                            } else if (read5 >= 0 && (read = inputStream.read()) >= 0) {
                                stringBuffer.append((char) ((TypeUtil.convertHexDigit(read5) << 4) + TypeUtil.convertHexDigit(read)));
                            }
                        } else if (c == '&') {
                            String stringBuffer2 = stringBuffer.length() == 0 ? "" : stringBuffer.toString();
                            stringBuffer.setLength(0);
                            if (str != null) {
                                multiMap.add(str, stringBuffer2);
                            } else if (stringBuffer2 != null && stringBuffer2.length() > 0) {
                                multiMap.add(stringBuffer2, "");
                            }
                            if (i2 > 0) {
                                if (multiMap.size() > i2) {
                                    throw new IllegalStateException(String.format("Form with too many keys [%d > %d]", new Object[]{Integer.valueOf(multiMap.size()), Integer.valueOf(i2)}));
                                }
                            }
                            str = null;
                        } else if (c == '+') {
                            stringBuffer.append(' ');
                        } else if (c != '=') {
                            stringBuffer.append(c);
                        } else if (str != null) {
                            stringBuffer.append(c);
                        } else {
                            str = stringBuffer.toString();
                            stringBuffer.setLength(0);
                        }
                        if (i >= 0) {
                            i3++;
                            if (i3 > i) {
                                throw new IllegalStateException("Form too large");
                            }
                        }
                    } else if (str != null) {
                        String stringBuffer3 = stringBuffer.length() == 0 ? "" : stringBuffer.toString();
                        stringBuffer.setLength(0);
                        multiMap.add(str, stringBuffer3);
                    } else if (stringBuffer.length() > 0) {
                        multiMap.add(stringBuffer.toString(), "");
                    }
                }
            } finally {
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: org.eclipse.jetty.util.Utf8StringBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: java.lang.StringBuffer} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v69 */
    /* JADX WARNING: type inference failed for: r0v79 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0177, code lost:
        r0 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x017d, code lost:
        if ('u' != r1.charAt(r0)) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x017f, code lost:
        r4 = r4 + 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0181, code lost:
        if (r4 >= r3) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0183, code lost:
        r8.getStringBuffer().append(new java.lang.String(java.lang.Character.toChars(org.eclipse.jetty.util.TypeUtil.parseInt(r1, r7 + 2, 4, 16))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x019b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x019e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        r8.getStringBuffer().append(65533);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01a8, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01aa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01ab, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01ad, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01ae, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        r8.append((byte) org.eclipse.jetty.util.TypeUtil.parseInt(r1, r0, 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01b9, code lost:
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01ba, code lost:
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01bc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01bd, code lost:
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01bf, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01c0, code lost:
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01c2, code lost:
        LOG.debug(r0);
        r8.getStringBuffer().append(65533);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01cf, code lost:
        r7 = LOG;
        r7.warn(r0.toString(), new java.lang.Object[0]);
        r7.debug(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01de, code lost:
        r8.getStringBuffer().append(65533);
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01e9, code lost:
        if (r0 == 0) goto L_0x020b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01eb, code lost:
        r0.getStringBuffer().append(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x00fc, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x00fc, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x020b, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x020b, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r12 != r7) goto L_0x00e6;
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        if (r0 != 0) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        r0 = new java.lang.StringBuffer(r3);
        r0.append(r1, r2, r15);
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        r15 = r0;
        r8 = new byte[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        if (r12 < 0) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        if (r12 > r10) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        if (r12 != r7) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005f, code lost:
        if ((r14 + 2) >= r3) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
        r0 = r2 + r14;
        r7 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
        if ('u' != r1.charAt(r7)) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
        r7 = r14 + 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006d, code lost:
        if (r7 >= r3) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r0 = new java.lang.String(java.lang.Character.toChars(org.eclipse.jetty.util.TypeUtil.parseInt(r1, r0 + 2, 4, 16))).getBytes(r4);
        java.lang.System.arraycopy(r0, 0, r8, r9, r0.length);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0087, code lost:
        r9 = r9 + r0.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0089, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008a, code lost:
        r14 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008c, code lost:
        r7 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r8[r9] = okio.Utf8.REPLACEMENT_BYTE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0090, code lost:
        r9 = r7;
        r7 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0093, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0094, code lost:
        r9 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0096, code lost:
        r14 = r14 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r8[r9] = (byte) org.eclipse.jetty.util.TypeUtil.parseInt(r1, r7, 2, 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a0, code lost:
        r9 = r9 + 1;
        r7 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a3, code lost:
        r14 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        LOG.ignore(r0);
        r0 = r9 + 1;
        r8[r9] = okio.Utf8.REPLACEMENT_BYTE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00af, code lost:
        r9 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b1, code lost:
        r8[r9] = okio.Utf8.REPLACEMENT_BYTE;
        r9 = r9 + 1;
        r14 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ba, code lost:
        if (r12 != '+') goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00bc, code lost:
        r0 = r9 + 1;
        r8[r9] = 32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c2, code lost:
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c5, code lost:
        r0 = r9 + 1;
        r8[r9] = (byte) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00cb, code lost:
        if (r14 >= r3) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ce, code lost:
        r12 = r1.charAt(r2 + r14);
        r7 = '%';
        r10 = 255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00da, code lost:
        r14 = r14 - 1;
        r15.append(new java.lang.String(r8, 0, r9, r4));
        r0 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00e6, code lost:
        if (r0 == 0) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00e8, code lost:
        r0.append(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x015f, code lost:
        if (r8 != '%') goto L_0x01e8;
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0161, code lost:
        if (r0 != 0) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0163, code lost:
        r0 = new org.eclipse.jetty.util.Utf8StringBuffer(r3);
        r0.getStringBuffer().append(r1, r2, r7);
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x016f, code lost:
        r8 = r0;
        r15 = r4 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0175, code lost:
        if (r15 >= r3) goto L_0x01de;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x00cd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ce A[Catch:{ UnsupportedEncodingException -> 0x003d }, LOOP:1: B:23:0x0055->B:63:0x00ce, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String decodeString(java.lang.String r16, int r17, int r18, java.lang.String r19) {
        /*
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = 4
            r6 = 117(0x75, float:1.64E-43)
            r0 = 0
            r7 = 37
            r8 = 32
            r9 = 43
            r10 = 255(0xff, float:3.57E-43)
            r11 = 16
            r13 = 0
            if (r4 == 0) goto L_0x0125
            boolean r14 = org.eclipse.jetty.util.StringUtil.isUTF8(r19)
            if (r14 == 0) goto L_0x0021
            goto L_0x0125
        L_0x0021:
            r14 = r13
        L_0x0022:
            if (r14 >= r3) goto L_0x0108
            int r15 = r2 + r14
            char r12 = r1.charAt(r15)     // Catch:{ UnsupportedEncodingException -> 0x003d }
            if (r12 < 0) goto L_0x00ec
            if (r12 <= r10) goto L_0x0030
            goto L_0x00ec
        L_0x0030:
            if (r12 != r9) goto L_0x0045
            if (r0 != 0) goto L_0x0040
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ UnsupportedEncodingException -> 0x003d }
            r0.<init>(r3)     // Catch:{ UnsupportedEncodingException -> 0x003d }
            r0.append(r1, r2, r15)     // Catch:{ UnsupportedEncodingException -> 0x003d }
            goto L_0x0040
        L_0x003d:
            r0 = move-exception
            goto L_0x011f
        L_0x0040:
            r0.append(r8)     // Catch:{ UnsupportedEncodingException -> 0x003d }
            goto L_0x00fc
        L_0x0045:
            if (r12 != r7) goto L_0x00e6
            if (r0 != 0) goto L_0x0051
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ UnsupportedEncodingException -> 0x003d }
            r0.<init>(r3)     // Catch:{ UnsupportedEncodingException -> 0x003d }
            r0.append(r1, r2, r15)     // Catch:{ UnsupportedEncodingException -> 0x003d }
        L_0x0051:
            r15 = r0
            byte[] r8 = new byte[r3]     // Catch:{ UnsupportedEncodingException -> 0x003d }
            r9 = r13
        L_0x0055:
            if (r12 < 0) goto L_0x00da
            if (r12 > r10) goto L_0x00da
            if (r12 != r7) goto L_0x00b8
            int r0 = r14 + 2
            r12 = 63
            if (r0 >= r3) goto L_0x00b1
            int r0 = r2 + r14
            int r7 = r0 + 1
            char r10 = r1.charAt(r7)     // Catch:{ NumberFormatException -> 0x00a5 }
            if (r6 != r10) goto L_0x0096
            int r7 = r14 + 6
            if (r7 >= r3) goto L_0x008c
            int r0 = r0 + 2
            java.lang.String r10 = new java.lang.String     // Catch:{ NumberFormatException -> 0x0089 }
            int r0 = org.eclipse.jetty.util.TypeUtil.parseInt((java.lang.String) r1, (int) r0, (int) r5, (int) r11)     // Catch:{ NumberFormatException -> 0x0089 }
            char[] r0 = java.lang.Character.toChars(r0)     // Catch:{ NumberFormatException -> 0x0089 }
            r10.<init>(r0)     // Catch:{ NumberFormatException -> 0x0089 }
            byte[] r0 = r10.getBytes(r4)     // Catch:{ NumberFormatException -> 0x0089 }
            int r10 = r0.length     // Catch:{ NumberFormatException -> 0x0089 }
            java.lang.System.arraycopy(r0, r13, r8, r9, r10)     // Catch:{ NumberFormatException -> 0x0089 }
            int r0 = r0.length     // Catch:{ NumberFormatException -> 0x0089 }
            int r9 = r9 + r0
            goto L_0x00a3
        L_0x0089:
            r0 = move-exception
            r14 = r7
            goto L_0x00a6
        L_0x008c:
            int r7 = r9 + 1
            r8[r9] = r12     // Catch:{ NumberFormatException -> 0x0093 }
            r9 = r7
            r7 = r3
            goto L_0x00a3
        L_0x0093:
            r0 = move-exception
            r9 = r7
            goto L_0x00a6
        L_0x0096:
            int r14 = r14 + 3
            r10 = 2
            int r0 = org.eclipse.jetty.util.TypeUtil.parseInt((java.lang.String) r1, (int) r7, (int) r10, (int) r11)     // Catch:{ NumberFormatException -> 0x00a5 }
            byte r0 = (byte) r0     // Catch:{ NumberFormatException -> 0x00a5 }
            r8[r9] = r0     // Catch:{ NumberFormatException -> 0x00a5 }
            int r9 = r9 + 1
            r7 = r14
        L_0x00a3:
            r14 = r7
            goto L_0x00cb
        L_0x00a5:
            r0 = move-exception
        L_0x00a6:
            org.eclipse.jetty.util.log.Logger r7 = LOG     // Catch:{ UnsupportedEncodingException -> 0x003d }
            r7.ignore(r0)     // Catch:{ UnsupportedEncodingException -> 0x003d }
            int r0 = r9 + 1
            r8[r9] = r12     // Catch:{ UnsupportedEncodingException -> 0x003d }
        L_0x00af:
            r9 = r0
            goto L_0x00cb
        L_0x00b1:
            int r0 = r9 + 1
            r8[r9] = r12     // Catch:{ UnsupportedEncodingException -> 0x003d }
            r9 = r0
            r14 = r3
            goto L_0x00cb
        L_0x00b8:
            r7 = 43
            if (r12 != r7) goto L_0x00c5
            int r0 = r9 + 1
            r7 = 32
            r8[r9] = r7     // Catch:{ UnsupportedEncodingException -> 0x003d }
        L_0x00c2:
            int r14 = r14 + 1
            goto L_0x00af
        L_0x00c5:
            int r0 = r9 + 1
            byte r7 = (byte) r12     // Catch:{ UnsupportedEncodingException -> 0x003d }
            r8[r9] = r7     // Catch:{ UnsupportedEncodingException -> 0x003d }
            goto L_0x00c2
        L_0x00cb:
            if (r14 < r3) goto L_0x00ce
            goto L_0x00da
        L_0x00ce:
            int r0 = r2 + r14
            char r12 = r1.charAt(r0)     // Catch:{ UnsupportedEncodingException -> 0x003d }
            r7 = 37
            r10 = 255(0xff, float:3.57E-43)
            goto L_0x0055
        L_0x00da:
            int r14 = r14 + -1
            java.lang.String r0 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x003d }
            r0.<init>(r8, r13, r9, r4)     // Catch:{ UnsupportedEncodingException -> 0x003d }
            r15.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x003d }
            r0 = r15
            goto L_0x00fc
        L_0x00e6:
            if (r0 == 0) goto L_0x00fc
            r0.append(r12)     // Catch:{ UnsupportedEncodingException -> 0x003d }
            goto L_0x00fc
        L_0x00ec:
            if (r0 != 0) goto L_0x00f9
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ UnsupportedEncodingException -> 0x003d }
            r0.<init>(r3)     // Catch:{ UnsupportedEncodingException -> 0x003d }
            int r15 = r15 + 1
            r0.append(r1, r2, r15)     // Catch:{ UnsupportedEncodingException -> 0x003d }
            goto L_0x00fc
        L_0x00f9:
            r0.append(r12)     // Catch:{ UnsupportedEncodingException -> 0x003d }
        L_0x00fc:
            int r14 = r14 + 1
            r7 = 37
            r8 = 32
            r9 = 43
            r10 = 255(0xff, float:3.57E-43)
            goto L_0x0022
        L_0x0108:
            if (r0 != 0) goto L_0x011a
            if (r2 != 0) goto L_0x0113
            int r0 = r16.length()     // Catch:{ UnsupportedEncodingException -> 0x003d }
            if (r0 != r3) goto L_0x0113
            return r1
        L_0x0113:
            int r0 = r2 + r3
            java.lang.String r0 = r1.substring(r2, r0)     // Catch:{ UnsupportedEncodingException -> 0x003d }
            return r0
        L_0x011a:
            java.lang.String r0 = r0.toString()     // Catch:{ UnsupportedEncodingException -> 0x003d }
            return r0
        L_0x011f:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L_0x0125:
            r4 = r13
        L_0x0126:
            if (r4 >= r3) goto L_0x020f
            int r7 = r2 + r4
            char r8 = r1.charAt(r7)
            if (r8 < 0) goto L_0x0134
            r9 = 255(0xff, float:3.57E-43)
            if (r8 <= r9) goto L_0x013b
        L_0x0134:
            r10 = 2
            r12 = 32
            r14 = 37
            goto L_0x01f3
        L_0x013b:
            r10 = 43
            if (r8 != r10) goto L_0x015b
            if (r0 != 0) goto L_0x014d
            org.eclipse.jetty.util.Utf8StringBuffer r0 = new org.eclipse.jetty.util.Utf8StringBuffer
            r0.<init>(r3)
            java.lang.StringBuffer r8 = r0.getStringBuffer()
            r8.append(r1, r2, r7)
        L_0x014d:
            java.lang.StringBuffer r7 = r0.getStringBuffer()
            r12 = 32
            r7.append(r12)
            r10 = 2
            r14 = 37
            goto L_0x020b
        L_0x015b:
            r12 = 32
            r14 = 37
            if (r8 != r14) goto L_0x01e8
            if (r0 != 0) goto L_0x016f
            org.eclipse.jetty.util.Utf8StringBuffer r0 = new org.eclipse.jetty.util.Utf8StringBuffer
            r0.<init>(r3)
            java.lang.StringBuffer r8 = r0.getStringBuffer()
            r8.append(r1, r2, r7)
        L_0x016f:
            r8 = r0
            int r15 = r4 + 2
            r9 = 65533(0xfffd, float:9.1831E-41)
            if (r15 >= r3) goto L_0x01de
            int r0 = r7 + 1
            char r10 = r1.charAt(r0)     // Catch:{ NotUtf8Exception -> 0x019e, NumberFormatException -> 0x019b }
            if (r6 != r10) goto L_0x01b0
            int r4 = r4 + 5
            if (r4 >= r3) goto L_0x01a1
            int r7 = r7 + 2
            java.lang.String r0 = new java.lang.String     // Catch:{ NotUtf8Exception -> 0x019e, NumberFormatException -> 0x019b }
            int r7 = org.eclipse.jetty.util.TypeUtil.parseInt((java.lang.String) r1, (int) r7, (int) r5, (int) r11)     // Catch:{ NotUtf8Exception -> 0x019e, NumberFormatException -> 0x019b }
            char[] r7 = java.lang.Character.toChars(r7)     // Catch:{ NotUtf8Exception -> 0x019e, NumberFormatException -> 0x019b }
            r0.<init>(r7)     // Catch:{ NotUtf8Exception -> 0x019e, NumberFormatException -> 0x019b }
            java.lang.StringBuffer r7 = r8.getStringBuffer()     // Catch:{ NotUtf8Exception -> 0x019e, NumberFormatException -> 0x019b }
            r7.append(r0)     // Catch:{ NotUtf8Exception -> 0x019e, NumberFormatException -> 0x019b }
        L_0x0199:
            r10 = 2
            goto L_0x01ba
        L_0x019b:
            r0 = move-exception
        L_0x019c:
            r10 = 2
            goto L_0x01c2
        L_0x019e:
            r0 = move-exception
        L_0x019f:
            r10 = 2
            goto L_0x01cf
        L_0x01a1:
            java.lang.StringBuffer r0 = r8.getStringBuffer()     // Catch:{ NotUtf8Exception -> 0x01ad, NumberFormatException -> 0x01aa }
            r0.append(r9)     // Catch:{ NotUtf8Exception -> 0x01ad, NumberFormatException -> 0x01aa }
            r4 = r3
            goto L_0x0199
        L_0x01aa:
            r0 = move-exception
            r4 = r3
            goto L_0x019c
        L_0x01ad:
            r0 = move-exception
            r4 = r3
            goto L_0x019f
        L_0x01b0:
            r10 = 2
            int r0 = org.eclipse.jetty.util.TypeUtil.parseInt((java.lang.String) r1, (int) r0, (int) r10, (int) r11)     // Catch:{ NotUtf8Exception -> 0x01bf, NumberFormatException -> 0x01bc }
            byte r0 = (byte) r0     // Catch:{ NotUtf8Exception -> 0x01bf, NumberFormatException -> 0x01bc }
            r8.append(r0)     // Catch:{ NotUtf8Exception -> 0x01bf, NumberFormatException -> 0x01bc }
            r4 = r15
        L_0x01ba:
            r0 = r8
            goto L_0x020b
        L_0x01bc:
            r0 = move-exception
            r4 = r15
            goto L_0x01c2
        L_0x01bf:
            r0 = move-exception
            r4 = r15
            goto L_0x01cf
        L_0x01c2:
            org.eclipse.jetty.util.log.Logger r7 = LOG
            r7.debug(r0)
            java.lang.StringBuffer r0 = r8.getStringBuffer()
            r0.append(r9)
            goto L_0x01ba
        L_0x01cf:
            org.eclipse.jetty.util.log.Logger r7 = LOG
            java.lang.String r9 = r0.toString()
            java.lang.Object[] r15 = new java.lang.Object[r13]
            r7.warn((java.lang.String) r9, (java.lang.Object[]) r15)
            r7.debug(r0)
            goto L_0x01ba
        L_0x01de:
            r10 = 2
            java.lang.StringBuffer r0 = r8.getStringBuffer()
            r0.append(r9)
            r4 = r3
            goto L_0x01ba
        L_0x01e8:
            r10 = 2
            if (r0 == 0) goto L_0x020b
            java.lang.StringBuffer r7 = r0.getStringBuffer()
            r7.append(r8)
            goto L_0x020b
        L_0x01f3:
            if (r0 != 0) goto L_0x0204
            org.eclipse.jetty.util.Utf8StringBuffer r0 = new org.eclipse.jetty.util.Utf8StringBuffer
            r0.<init>(r3)
            java.lang.StringBuffer r8 = r0.getStringBuffer()
            int r7 = r7 + 1
            r8.append(r1, r2, r7)
            goto L_0x020b
        L_0x0204:
            java.lang.StringBuffer r7 = r0.getStringBuffer()
            r7.append(r8)
        L_0x020b:
            int r4 = r4 + 1
            goto L_0x0126
        L_0x020f:
            if (r0 != 0) goto L_0x0221
            if (r2 != 0) goto L_0x021a
            int r0 = r16.length()
            if (r0 != r3) goto L_0x021a
            return r1
        L_0x021a:
            int r0 = r2 + r3
            java.lang.String r0 = r1.substring(r2, r0)
            return r0
        L_0x0221:
            java.lang.String r0 = r0.toReplacedString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.UrlEncoded.decodeString(java.lang.String, int, int, java.lang.String):java.lang.String");
    }

    public static void decodeTo(String str, MultiMap multiMap, String str2) {
        decodeTo(str, multiMap, str2, -1);
    }

    public static void decodeUtf16To(InputStream inputStream, MultiMap multiMap, int i, int i2) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-16");
        StringWriter stringWriter = new StringWriter(8192);
        IO.copy((Reader) inputStreamReader, (Writer) stringWriter, (long) i);
        decodeTo(stringWriter.getBuffer().toString(), multiMap, "UTF-16", i2);
    }

    public static void decodeUtf8To(byte[] bArr, int i, int i2, MultiMap multiMap) {
        decodeUtf8To(bArr, i, i2, multiMap, new Utf8StringBuilder());
    }

    public static String encodeString(String str) {
        return encodeString(str, ENCODING);
    }

    public Object clone() {
        return new UrlEncoded(this);
    }

    public void decode(String str) {
        decodeTo(str, this, ENCODING, -1);
    }

    public String encode() {
        return encode(ENCODING, false);
    }

    public UrlEncoded() {
        super(6);
    }

    public static void decodeTo(String str, MultiMap multiMap, String str2, int i) {
        String str3;
        String str4;
        if (str2 == null) {
            str2 = ENCODING;
        }
        synchronized (multiMap) {
            int i2 = -1;
            String str5 = null;
            int i3 = 0;
            boolean z = false;
            while (i3 < str.length()) {
                try {
                    char charAt = str.charAt(i3);
                    if (charAt != '%') {
                        if (charAt == '&') {
                            int i4 = (i3 - i2) - 1;
                            if (i4 == 0) {
                                str4 = "";
                            } else {
                                int i5 = i2 + 1;
                                str4 = z ? decodeString(str, i5, i4, str2) : str.substring(i5, i3);
                            }
                            if (str5 != null) {
                                multiMap.add(str5, str4);
                            } else if (str4 != null && str4.length() > 0) {
                                multiMap.add(str4, "");
                            }
                            if (i > 0) {
                                if (multiMap.size() > i) {
                                    throw new IllegalStateException(String.format("Form with too many keys [%d > %d]", new Object[]{Integer.valueOf(multiMap.size()), Integer.valueOf(i)}));
                                }
                            }
                            str5 = null;
                        } else if (charAt != '+') {
                            if (charAt == '=') {
                                if (str5 == null) {
                                    str5 = z ? decodeString(str, i2 + 1, (i3 - i2) - 1, str2) : str.substring(i2 + 1, i3);
                                }
                            }
                            i3++;
                        }
                        z = false;
                        i2 = i3;
                        i3++;
                    }
                    z = true;
                    i3++;
                } finally {
                }
            }
            if (str5 != null) {
                int length = (str.length() - i2) - 1;
                if (length == 0) {
                    str3 = "";
                } else {
                    int i6 = i2 + 1;
                    str3 = z ? decodeString(str, i6, length, str2) : str.substring(i6);
                }
                multiMap.add(str5, str3);
            } else if (i2 < str.length()) {
                String decodeString = z ? decodeString(str, i2 + 1, (str.length() - i2) - 1, str2) : str.substring(i2 + 1);
                if (decodeString != null && decodeString.length() > 0) {
                    multiMap.add(decodeString, "");
                }
            }
        }
    }

    public static void decodeUtf8To(byte[] bArr, int i, int i2, MultiMap multiMap, Utf8StringBuilder utf8StringBuilder) {
        StringBuilder stringBuilder;
        int i3;
        synchronized (multiMap) {
            int i4 = i2 + i;
            String str = null;
            while (i < i4) {
                try {
                    byte b = bArr[i];
                    char c = (char) (b & 255);
                    if (c != '%') {
                        if (c == '&') {
                            String utf8StringBuilder2 = utf8StringBuilder.length() == 0 ? "" : utf8StringBuilder.toString();
                            utf8StringBuilder.reset();
                            if (str != null) {
                                multiMap.add(str, utf8StringBuilder2);
                            } else if (utf8StringBuilder2 != null && utf8StringBuilder2.length() > 0) {
                                multiMap.add(utf8StringBuilder2, "");
                            }
                            str = null;
                        } else if (c == '+') {
                            utf8StringBuilder.append((byte) 32);
                        } else if (c != '=') {
                            try {
                                utf8StringBuilder.append(b);
                            } catch (Utf8Appendable.NotUtf8Exception e) {
                                e = e;
                            }
                        } else if (str != null) {
                            utf8StringBuilder.append(b);
                        } else {
                            str = utf8StringBuilder.toString();
                            utf8StringBuilder.reset();
                        }
                        i++;
                    } else {
                        if (i + 2 < i4) {
                            int i5 = i + 1;
                            byte b2 = bArr[i5];
                            if (117 != b2) {
                                i += 2;
                                utf8StringBuilder.append((byte) ((TypeUtil.convertHexDigit(b2) << 4) + TypeUtil.convertHexDigit(bArr[i])));
                                i++;
                            } else if (i + 5 < i4) {
                                try {
                                    stringBuilder = utf8StringBuilder.getStringBuilder();
                                    i3 = i + 2;
                                } catch (Utf8Appendable.NotUtf8Exception e2) {
                                    int i6 = i5;
                                    e = e2;
                                    i = i6;
                                    Logger logger = LOG;
                                    logger.warn(e.toString(), new Object[0]);
                                    logger.debug(e);
                                    i++;
                                }
                                try {
                                    int i7 = i + 3;
                                    try {
                                        int convertHexDigit = (TypeUtil.convertHexDigit(bArr[i3]) << 12) + (TypeUtil.convertHexDigit(bArr[i7]) << 8) + (TypeUtil.convertHexDigit(bArr[i + 4]) << 4);
                                        i += 5;
                                        stringBuilder.append(Character.toChars(convertHexDigit + TypeUtil.convertHexDigit(bArr[i])));
                                    } catch (Utf8Appendable.NotUtf8Exception e3) {
                                        e = e3;
                                        i = i7;
                                        Logger logger2 = LOG;
                                        logger2.warn(e.toString(), new Object[0]);
                                        logger2.debug(e);
                                        i++;
                                    }
                                } catch (Utf8Appendable.NotUtf8Exception e4) {
                                    e = e4;
                                    i = i3;
                                    Logger logger22 = LOG;
                                    logger22.warn(e.toString(), new Object[0]);
                                    logger22.debug(e);
                                    i++;
                                }
                                i++;
                            } else {
                                utf8StringBuilder.getStringBuilder().append(65533);
                            }
                        } else {
                            utf8StringBuilder.getStringBuilder().append(65533);
                        }
                        i = i4;
                        i++;
                    }
                } finally {
                }
            }
            if (str != null) {
                String replacedString = utf8StringBuilder.length() == 0 ? "" : utf8StringBuilder.toReplacedString();
                utf8StringBuilder.reset();
                multiMap.add(str, replacedString);
            } else if (utf8StringBuilder.length() > 0) {
                multiMap.add(utf8StringBuilder.toReplacedString(), "");
            }
        }
    }

    public static String encodeString(String str, String str2) {
        byte[] bArr;
        int i;
        int i2;
        if (str2 == null) {
            str2 = ENCODING;
        }
        try {
            bArr = str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        byte[] bArr2 = new byte[(bArr.length * 3)];
        boolean z = true;
        int i3 = 0;
        for (byte b : bArr) {
            if (b == 32) {
                bArr2[i3] = 43;
                i3++;
                z = false;
            } else if ((b < 97 || b > 122) && ((b < 65 || b > 90) && (b < 48 || b > 57))) {
                int i4 = i3 + 1;
                bArr2[i3] = 37;
                byte b2 = (byte) ((b & 240) >> 4);
                if (b2 >= 10) {
                    i = i3 + 2;
                    bArr2[i4] = (byte) (b2 + 55);
                } else {
                    i = i3 + 2;
                    bArr2[i4] = (byte) (b2 + 48);
                }
                byte b3 = (byte) (b & 15);
                if (b3 >= 10) {
                    i2 = i + 1;
                    bArr2[i] = (byte) (b3 + 55);
                } else {
                    i2 = i + 1;
                    bArr2[i] = (byte) (b3 + 48);
                }
                z = false;
                i3 = i2;
            } else {
                bArr2[i3] = b;
                i3++;
            }
        }
        if (z) {
            return str;
        }
        try {
            return new String(bArr2, 0, i3, str2);
        } catch (UnsupportedEncodingException unused2) {
            return new String(bArr2, 0, i3);
        }
    }

    public void decode(String str, String str2) {
        decodeTo(str, this, str2, -1);
    }

    public String encode(String str) {
        return encode(str, false);
    }

    public UrlEncoded(String str) {
        super(6);
        decode(str, ENCODING);
    }

    public synchronized String encode(String str, boolean z) {
        return encode(this, str, z);
    }

    public static String encode(MultiMap multiMap, String str, boolean z) {
        if (str == null) {
            str = ENCODING;
        }
        StringBuilder sb = new StringBuilder(128);
        Iterator it = multiMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String obj = entry.getKey().toString();
            Object value = entry.getValue();
            int size = LazyList.size(value);
            if (size == 0) {
                sb.append(encodeString(obj, str));
                if (z) {
                    sb.append('=');
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (i > 0) {
                        sb.append(Typography.amp);
                    }
                    Object obj2 = LazyList.get(value, i);
                    sb.append(encodeString(obj, str));
                    if (obj2 != null) {
                        String obj3 = obj2.toString();
                        if (obj3.length() > 0) {
                            sb.append('=');
                            sb.append(encodeString(obj3, str));
                        } else if (z) {
                            sb.append('=');
                        }
                    } else if (z) {
                        sb.append('=');
                    }
                }
            }
            if (it.hasNext()) {
                sb.append(Typography.amp);
            }
        }
        return sb.toString();
    }

    public UrlEncoded(String str, String str2) {
        super(6);
        decode(str, str2);
    }

    public static void decodeTo(InputStream inputStream, MultiMap multiMap, String str, int i, int i2) throws IOException {
        int read;
        int read2;
        int read3;
        if (str == null) {
            str = ENCODING;
        }
        if ("UTF-8".equalsIgnoreCase(str)) {
            decodeUtf8To(inputStream, multiMap, i, i2);
        } else if ("ISO-8859-1".equals(str)) {
            decode88591To(inputStream, multiMap, i, i2);
        } else if ("UTF-16".equalsIgnoreCase(str)) {
            decodeUtf16To(inputStream, multiMap, i, i2);
        } else {
            synchronized (multiMap) {
                try {
                    ByteArrayOutputStream2 byteArrayOutputStream2 = new ByteArrayOutputStream2();
                    String str2 = null;
                    int i3 = 0;
                    while (true) {
                        int read4 = inputStream.read();
                        if (read4 > 0) {
                            char c = (char) read4;
                            if (c == '%') {
                                int read5 = inputStream.read();
                                if (117 == read5) {
                                    int read6 = inputStream.read();
                                    if (read6 >= 0 && (read2 = inputStream.read()) >= 0 && (read3 = inputStream.read()) >= 0) {
                                        byteArrayOutputStream2.write(new String(Character.toChars((TypeUtil.convertHexDigit(read5) << 12) + (TypeUtil.convertHexDigit(read6) << 8) + (TypeUtil.convertHexDigit(read2) << 4) + TypeUtil.convertHexDigit(read3))).getBytes(str));
                                    }
                                } else if (read5 >= 0 && (read = inputStream.read()) >= 0) {
                                    byteArrayOutputStream2.write((TypeUtil.convertHexDigit(read5) << 4) + TypeUtil.convertHexDigit(read));
                                }
                            } else if (c == '&') {
                                String byteArrayOutputStream = byteArrayOutputStream2.size() == 0 ? "" : byteArrayOutputStream2.toString(str);
                                byteArrayOutputStream2.setCount(0);
                                if (str2 != null) {
                                    multiMap.add(str2, byteArrayOutputStream);
                                } else if (byteArrayOutputStream != null && byteArrayOutputStream.length() > 0) {
                                    multiMap.add(byteArrayOutputStream, "");
                                }
                                if (i2 > 0) {
                                    if (multiMap.size() > i2) {
                                        throw new IllegalStateException(String.format("Form with too many keys [%d > %d]", new Object[]{Integer.valueOf(multiMap.size()), Integer.valueOf(i2)}));
                                    }
                                }
                                str2 = null;
                            } else if (c == '+') {
                                byteArrayOutputStream2.write(32);
                            } else if (c != '=') {
                                byteArrayOutputStream2.write(read4);
                            } else if (str2 != null) {
                                byteArrayOutputStream2.write(read4);
                            } else {
                                str2 = byteArrayOutputStream2.size() == 0 ? "" : byteArrayOutputStream2.toString(str);
                                byteArrayOutputStream2.setCount(0);
                            }
                            i3++;
                            if (i >= 0) {
                                if (i3 > i) {
                                    throw new IllegalStateException("Form too large");
                                }
                            }
                        } else {
                            int size = byteArrayOutputStream2.size();
                            if (str2 != null) {
                                String byteArrayOutputStream3 = size == 0 ? "" : byteArrayOutputStream2.toString(str);
                                byteArrayOutputStream2.setCount(0);
                                multiMap.add(str2, byteArrayOutputStream3);
                            } else if (size > 0) {
                                multiMap.add(byteArrayOutputStream2.toString(str), "");
                            }
                        }
                    }
                } finally {
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0010  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f9 A[Catch:{ all -> 0x0027 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0109 A[Catch:{ all -> 0x0027 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x011d A[Catch:{ all -> 0x0027 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void decodeUtf8To(java.io.InputStream r10, org.eclipse.jetty.util.MultiMap r11, int r12, int r13) throws java.io.IOException {
        /*
            monitor-enter(r11)
            org.eclipse.jetty.util.Utf8StringBuilder r0 = new org.eclipse.jetty.util.Utf8StringBuilder     // Catch:{ all -> 0x0027 }
            r0.<init>()     // Catch:{ all -> 0x0027 }
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = r2
        L_0x000a:
            int r5 = r10.read()     // Catch:{ all -> 0x0027 }
            if (r5 < 0) goto L_0x0107
            char r6 = (char) r5
            r7 = 37
            if (r6 == r7) goto L_0x0092
            r7 = 38
            if (r6 == r7) goto L_0x0045
            r7 = 43
            if (r6 == r7) goto L_0x003e
            r7 = 61
            if (r6 == r7) goto L_0x002d
            byte r5 = (byte) r5
            r0.append(r5)     // Catch:{ NotUtf8Exception -> 0x002a }
            goto L_0x00f7
        L_0x0027:
            r10 = move-exception
            goto L_0x012e
        L_0x002a:
            r5 = move-exception
            goto L_0x00e9
        L_0x002d:
            if (r3 == 0) goto L_0x0035
            byte r5 = (byte) r5     // Catch:{ NotUtf8Exception -> 0x002a }
            r0.append(r5)     // Catch:{ NotUtf8Exception -> 0x002a }
            goto L_0x00f7
        L_0x0035:
            java.lang.String r3 = r0.toString()     // Catch:{ NotUtf8Exception -> 0x002a }
            r0.reset()     // Catch:{ NotUtf8Exception -> 0x002a }
            goto L_0x00f7
        L_0x003e:
            r5 = 32
            r0.append(r5)     // Catch:{ NotUtf8Exception -> 0x002a }
            goto L_0x00f7
        L_0x0045:
            int r5 = r0.length()     // Catch:{ NotUtf8Exception -> 0x002a }
            if (r5 != 0) goto L_0x004e
            java.lang.String r5 = ""
            goto L_0x0052
        L_0x004e:
            java.lang.String r5 = r0.toString()     // Catch:{ NotUtf8Exception -> 0x002a }
        L_0x0052:
            r0.reset()     // Catch:{ NotUtf8Exception -> 0x002a }
            if (r3 == 0) goto L_0x005b
            r11.add(r3, r5)     // Catch:{ NotUtf8Exception -> 0x002a }
            goto L_0x0068
        L_0x005b:
            if (r5 == 0) goto L_0x0068
            int r6 = r5.length()     // Catch:{ NotUtf8Exception -> 0x002a }
            if (r6 <= 0) goto L_0x0068
            java.lang.String r6 = ""
            r11.add(r5, r6)     // Catch:{ NotUtf8Exception -> 0x002a }
        L_0x0068:
            if (r13 <= 0) goto L_0x0090
            int r3 = r11.size()     // Catch:{ NotUtf8Exception -> 0x008d }
            if (r3 > r13) goto L_0x0071
            goto L_0x0090
        L_0x0071:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ NotUtf8Exception -> 0x008d }
            java.lang.String r5 = "Form with too many keys [%d > %d]"
            int r6 = r11.size()     // Catch:{ NotUtf8Exception -> 0x008d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ NotUtf8Exception -> 0x008d }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)     // Catch:{ NotUtf8Exception -> 0x008d }
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r7}     // Catch:{ NotUtf8Exception -> 0x008d }
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch:{ NotUtf8Exception -> 0x008d }
            r3.<init>(r5)     // Catch:{ NotUtf8Exception -> 0x008d }
            throw r3     // Catch:{ NotUtf8Exception -> 0x008d }
        L_0x008d:
            r5 = move-exception
            r3 = r2
            goto L_0x00e9
        L_0x0090:
            r3 = r2
            goto L_0x00f7
        L_0x0092:
            int r5 = r10.read()     // Catch:{ NotUtf8Exception -> 0x002a }
            r6 = 117(0x75, float:1.64E-43)
            if (r6 != r5) goto L_0x00d1
            int r6 = r10.read()     // Catch:{ NotUtf8Exception -> 0x002a }
            if (r6 < 0) goto L_0x00f7
            int r7 = r10.read()     // Catch:{ NotUtf8Exception -> 0x002a }
            if (r7 < 0) goto L_0x00f7
            int r8 = r10.read()     // Catch:{ NotUtf8Exception -> 0x002a }
            if (r8 < 0) goto L_0x00f7
            java.lang.StringBuilder r9 = r0.getStringBuilder()     // Catch:{ NotUtf8Exception -> 0x002a }
            int r5 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((int) r5)     // Catch:{ NotUtf8Exception -> 0x002a }
            int r5 = r5 << 12
            int r6 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((int) r6)     // Catch:{ NotUtf8Exception -> 0x002a }
            int r6 = r6 << 8
            int r5 = r5 + r6
            int r6 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((int) r7)     // Catch:{ NotUtf8Exception -> 0x002a }
            int r6 = r6 << 4
            int r5 = r5 + r6
            int r6 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((int) r8)     // Catch:{ NotUtf8Exception -> 0x002a }
            int r5 = r5 + r6
            char[] r5 = java.lang.Character.toChars(r5)     // Catch:{ NotUtf8Exception -> 0x002a }
            r9.append(r5)     // Catch:{ NotUtf8Exception -> 0x002a }
            goto L_0x00f7
        L_0x00d1:
            if (r5 < 0) goto L_0x00f7
            int r6 = r10.read()     // Catch:{ NotUtf8Exception -> 0x002a }
            if (r6 < 0) goto L_0x00f7
            int r5 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((int) r5)     // Catch:{ NotUtf8Exception -> 0x002a }
            int r5 = r5 << 4
            int r6 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((int) r6)     // Catch:{ NotUtf8Exception -> 0x002a }
            int r5 = r5 + r6
            byte r5 = (byte) r5     // Catch:{ NotUtf8Exception -> 0x002a }
            r0.append(r5)     // Catch:{ NotUtf8Exception -> 0x002a }
            goto L_0x00f7
        L_0x00e9:
            org.eclipse.jetty.util.log.Logger r6 = LOG     // Catch:{ all -> 0x0027 }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x0027 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ all -> 0x0027 }
            r6.warn((java.lang.String) r7, (java.lang.Object[]) r8)     // Catch:{ all -> 0x0027 }
            r6.debug(r5)     // Catch:{ all -> 0x0027 }
        L_0x00f7:
            if (r12 < 0) goto L_0x000a
            int r4 = r4 + 1
            if (r4 > r12) goto L_0x00ff
            goto L_0x000a
        L_0x00ff:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0027 }
            java.lang.String r12 = "Form too large"
            r10.<init>(r12)     // Catch:{ all -> 0x0027 }
            throw r10     // Catch:{ all -> 0x0027 }
        L_0x0107:
            if (r3 == 0) goto L_0x011d
            int r10 = r0.length()     // Catch:{ all -> 0x0027 }
            if (r10 != 0) goto L_0x0112
            java.lang.String r10 = ""
            goto L_0x0116
        L_0x0112:
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x0027 }
        L_0x0116:
            r0.reset()     // Catch:{ all -> 0x0027 }
            r11.add(r3, r10)     // Catch:{ all -> 0x0027 }
            goto L_0x012c
        L_0x011d:
            int r10 = r0.length()     // Catch:{ all -> 0x0027 }
            if (r10 <= 0) goto L_0x012c
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x0027 }
            java.lang.String r12 = ""
            r11.add(r10, r12)     // Catch:{ all -> 0x0027 }
        L_0x012c:
            monitor-exit(r11)     // Catch:{ all -> 0x0027 }
            return
        L_0x012e:
            monitor-exit(r11)     // Catch:{ all -> 0x0027 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.UrlEncoded.decodeUtf8To(java.io.InputStream, org.eclipse.jetty.util.MultiMap, int, int):void");
    }
}
