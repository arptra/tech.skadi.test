package io.netty.handler.codec.http;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.List;
import java.util.Set;

@Deprecated
public final class CookieDecoder {
    private static final String COMMENT = "Comment";
    private static final String COMMENTURL = "CommentURL";
    private static final String DISCARD = "Discard";
    private static final CookieDecoder LAX = new CookieDecoder(false);
    private static final String PORT = "Port";
    private static final CookieDecoder STRICT = new CookieDecoder(true);
    private static final String VERSION = "Version";
    private final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CookieDecoder.class);
    private final boolean strict;

    private CookieDecoder(boolean z) {
        this.strict = z;
    }

    public static Set<Cookie> decode(String str) {
        return decode(str, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Set<io.netty.handler.codec.http.Cookie> doDecode(java.lang.String r26) {
        /*
            r25 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 8
            r0.<init>(r1)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            r1 = r26
            extractKeyValuePairs(r1, r0, r2)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x001c
            java.util.Set r0 = java.util.Collections.emptySet()
            return r0
        L_0x001c:
            r1 = 0
            java.lang.Object r3 = r0.get(r1)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "Version"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0039
            java.lang.Object r3 = r2.get(r1)     // Catch:{ NumberFormatException -> 0x0036 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NumberFormatException -> 0x0036 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0036 }
            goto L_0x0037
        L_0x0036:
            r3 = r1
        L_0x0037:
            r6 = 1
            goto L_0x003b
        L_0x0039:
            r3 = r1
            r6 = r3
        L_0x003b:
            int r7 = r0.size()
            if (r7 > r6) goto L_0x0046
            java.util.Set r0 = java.util.Collections.emptySet()
            return r0
        L_0x0046:
            java.util.TreeSet r7 = new java.util.TreeSet
            r7.<init>()
        L_0x004b:
            int r8 = r0.size()
            if (r6 >= r8) goto L_0x0069
            java.lang.Object r8 = r0.get(r6)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.get(r6)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L_0x0061
            java.lang.String r9 = ""
        L_0x0061:
            r10 = r25
            io.netty.handler.codec.http.DefaultCookie r8 = r10.initCookie(r8, r9)
            if (r8 != 0) goto L_0x006c
        L_0x0069:
            r1 = r7
            goto L_0x0195
        L_0x006c:
            java.util.ArrayList r9 = new java.util.ArrayList
            r11 = 2
            r9.<init>(r11)
            int r11 = r6 + 1
            r12 = 0
            r13 = -9223372036854775808
            r5 = r1
            r10 = r5
            r18 = r7
            r15 = r12
            r16 = r13
            r13 = r15
            r14 = r13
        L_0x0080:
            int r7 = r0.size()
            if (r11 >= r7) goto L_0x015c
            java.lang.Object r7 = r0.get(r11)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r19 = r2.get(r11)
            r20 = r0
            r0 = r19
            java.lang.String r0 = (java.lang.String) r0
            r19 = r2
            java.lang.String r2 = "Discard"
            boolean r2 = r2.equalsIgnoreCase(r7)
            if (r2 == 0) goto L_0x00a3
            r1 = 1
            goto L_0x0152
        L_0x00a3:
            java.lang.String r2 = "Secure"
            boolean r2 = r2.equalsIgnoreCase(r7)
            if (r2 == 0) goto L_0x00ae
            r5 = 1
            goto L_0x0152
        L_0x00ae:
            java.lang.String r2 = "HTTPOnly"
            boolean r2 = r2.equalsIgnoreCase(r7)
            if (r2 == 0) goto L_0x00b9
            r10 = 1
            goto L_0x0152
        L_0x00b9:
            java.lang.String r2 = "Comment"
            boolean r2 = r2.equalsIgnoreCase(r7)
            if (r2 == 0) goto L_0x00c4
            r12 = r0
            goto L_0x0152
        L_0x00c4:
            java.lang.String r2 = "CommentURL"
            boolean r2 = r2.equalsIgnoreCase(r7)
            if (r2 == 0) goto L_0x00cf
            r13 = r0
            goto L_0x0152
        L_0x00cf:
            java.lang.String r2 = "Domain"
            boolean r2 = r2.equalsIgnoreCase(r7)
            if (r2 == 0) goto L_0x00da
            r14 = r0
            goto L_0x0152
        L_0x00da:
            java.lang.String r2 = "Path"
            boolean r2 = r2.equalsIgnoreCase(r7)
            if (r2 == 0) goto L_0x00e5
            r15 = r0
            goto L_0x0152
        L_0x00e5:
            java.lang.String r2 = "Expires"
            boolean r2 = r2.equalsIgnoreCase(r7)
            if (r2 == 0) goto L_0x0114
            java.util.Date r0 = io.netty.handler.codec.DateFormatter.parseHttpDate(r0)
            if (r0 == 0) goto L_0x0111
            long r16 = r0.getTime()
            long r21 = java.lang.System.currentTimeMillis()
            long r16 = r16 - r21
            r21 = 1000(0x3e8, double:4.94E-321)
            long r23 = r16 / r21
            long r16 = r16 % r21
            r21 = 0
            int r0 = (r16 > r21 ? 1 : (r16 == r21 ? 0 : -1))
            r2 = r1
            if (r0 == 0) goto L_0x010c
            r0 = 1
            goto L_0x010d
        L_0x010c:
            r0 = 0
        L_0x010d:
            long r0 = (long) r0
            long r16 = r23 + r0
            goto L_0x0112
        L_0x0111:
            r2 = r1
        L_0x0112:
            r1 = r2
            goto L_0x0152
        L_0x0114:
            r2 = r1
            java.lang.String r1 = "Max-Age"
            boolean r1 = r1.equalsIgnoreCase(r7)
            if (r1 == 0) goto L_0x0125
            int r0 = java.lang.Integer.parseInt(r0)
            long r0 = (long) r0
            r16 = r0
            goto L_0x0112
        L_0x0125:
            boolean r1 = r4.equalsIgnoreCase(r7)
            if (r1 == 0) goto L_0x0130
            int r3 = java.lang.Integer.parseInt(r0)
            goto L_0x0112
        L_0x0130:
            java.lang.String r1 = "Port"
            boolean r1 = r1.equalsIgnoreCase(r7)
            if (r1 == 0) goto L_0x0161
            java.lang.String r1 = ","
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r7 = 0
        L_0x0140:
            if (r7 >= r1) goto L_0x0112
            r21 = r0[r7]
            r22 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)     // Catch:{ NumberFormatException -> 0x014d }
            r9.add(r0)     // Catch:{ NumberFormatException -> 0x014d }
        L_0x014d:
            int r7 = r7 + 1
            r0 = r22
            goto L_0x0140
        L_0x0152:
            int r11 = r11 + 1
            int r6 = r6 + 1
            r2 = r19
            r0 = r20
            goto L_0x0080
        L_0x015c:
            r20 = r0
            r19 = r2
            r2 = r1
        L_0x0161:
            r8.setVersion(r3)
            r0 = r16
            r8.setMaxAge(r0)
            r8.setPath(r15)
            r8.setDomain(r14)
            r8.setSecure(r5)
            r8.setHttpOnly(r10)
            if (r3 <= 0) goto L_0x017a
            r8.setComment(r12)
        L_0x017a:
            r0 = 1
            if (r3 <= r0) goto L_0x0186
            r8.setCommentUrl(r13)
            r8.setPorts((java.lang.Iterable<java.lang.Integer>) r9)
            r8.setDiscard(r2)
        L_0x0186:
            r1 = r18
            r1.add(r8)
            int r6 = r6 + 1
            r7 = r1
            r2 = r19
            r0 = r20
            r1 = 0
            goto L_0x004b
        L_0x0195:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.CookieDecoder.doDecode(java.lang.String):java.util.Set");
    }

    private static void extractKeyValuePairs(String str, List<String> list, List<String> list2) {
        String str2;
        String substring;
        String str3;
        int length = str.length();
        int i = 0;
        while (i != length) {
            char charAt = str.charAt(i);
            if (!(charAt == ' ' || charAt == ',' || charAt == ';')) {
                switch (charAt) {
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        while (i != length) {
                            if (str.charAt(i) == '$') {
                                i++;
                            } else {
                                String str4 = null;
                                if (i == length) {
                                    str2 = null;
                                } else {
                                    int i2 = i;
                                    while (true) {
                                        char charAt2 = str.charAt(i2);
                                        if (charAt2 == ';') {
                                            substring = str.substring(i, i2);
                                        } else if (charAt2 != '=') {
                                            i2++;
                                            if (i2 == length) {
                                                substring = str.substring(i);
                                            }
                                        } else {
                                            String substring2 = str.substring(i, i2);
                                            i = i2 + 1;
                                            if (i == length) {
                                                str2 = "";
                                            } else {
                                                char charAt3 = str.charAt(i);
                                                if (charAt3 == '\"' || charAt3 == '\'') {
                                                    StringBuilder sb = new StringBuilder(str.length() - i);
                                                    int i3 = i2 + 2;
                                                    while (true) {
                                                        boolean z = false;
                                                        while (i3 != length) {
                                                            if (z) {
                                                                int i4 = i3 + 1;
                                                                char charAt4 = str.charAt(i3);
                                                                if (charAt4 == '\"' || charAt4 == '\'' || charAt4 == '\\') {
                                                                    sb.setCharAt(sb.length() - 1, charAt4);
                                                                } else {
                                                                    sb.append(charAt4);
                                                                }
                                                                i3 = i4;
                                                            } else {
                                                                int i5 = i3 + 1;
                                                                char charAt5 = str.charAt(i3);
                                                                if (charAt5 == charAt3) {
                                                                    str2 = sb.toString();
                                                                    str4 = substring2;
                                                                    i = i5;
                                                                } else {
                                                                    sb.append(charAt5);
                                                                    if (charAt5 == '\\') {
                                                                        z = true;
                                                                    }
                                                                    i3 = i5;
                                                                }
                                                            }
                                                        }
                                                        str2 = sb.toString();
                                                        i = i3;
                                                    }
                                                } else {
                                                    int indexOf = str.indexOf(59, i);
                                                    if (indexOf > 0) {
                                                        str3 = str.substring(i, indexOf);
                                                    } else {
                                                        str3 = str.substring(i);
                                                        indexOf = length;
                                                    }
                                                    str2 = str3;
                                                    i = indexOf;
                                                }
                                            }
                                            str4 = substring2;
                                        }
                                    }
                                    str2 = null;
                                    str4 = substring;
                                    i = i2;
                                }
                                list.add(str4);
                                list2.add(str2);
                                continue;
                            }
                        }
                        return;
                }
            }
            i++;
        }
    }

    private DefaultCookie initCookie(String str, String str2) {
        int firstInvalidCookieValueOctet;
        int firstInvalidCookieNameOctet;
        if (str == null || str.length() == 0) {
            this.logger.debug("Skipping cookie with null name");
            return null;
        } else if (str2 == null) {
            this.logger.debug("Skipping cookie with null value");
            return null;
        } else {
            CharSequence unwrapValue = CookieUtil.unwrapValue(str2);
            if (unwrapValue == null) {
                this.logger.debug("Skipping cookie because starting quotes are not properly balanced in '{}'", (Object) unwrapValue);
                return null;
            } else if (!this.strict || (firstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(str)) < 0) {
                boolean z = unwrapValue.length() != str2.length();
                if (!this.strict || (firstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(unwrapValue)) < 0) {
                    DefaultCookie defaultCookie = new DefaultCookie(str, unwrapValue.toString());
                    defaultCookie.setWrap(z);
                    return defaultCookie;
                }
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Skipping cookie because value '{}' contains invalid char '{}'", unwrapValue, Character.valueOf(unwrapValue.charAt(firstInvalidCookieValueOctet)));
                }
                return null;
            } else {
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Skipping cookie because name '{}' contains invalid char '{}'", str, Character.valueOf(str.charAt(firstInvalidCookieNameOctet)));
                }
                return null;
            }
        }
    }

    public static Set<Cookie> decode(String str, boolean z) {
        return (z ? STRICT : LAX).doDecode(str);
    }
}
