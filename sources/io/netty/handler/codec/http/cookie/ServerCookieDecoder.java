package io.netty.handler.codec.http.cookie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class ServerCookieDecoder extends CookieDecoder {
    public static final ServerCookieDecoder LAX = new ServerCookieDecoder(false);
    private static final String RFC2965_DOMAIN = "$Domain";
    private static final String RFC2965_PATH = "$Path";
    private static final String RFC2965_PORT = "$Port";
    private static final String RFC2965_VERSION = "$Version";
    public static final ServerCookieDecoder STRICT = new ServerCookieDecoder(true);

    private ServerCookieDecoder(boolean z) {
        super(z);
    }

    public Set<Cookie> decode(String str) {
        TreeSet treeSet = new TreeSet();
        decode(treeSet, str);
        return treeSet;
    }

    public List<Cookie> decodeAll(String str) {
        ArrayList arrayList = new ArrayList();
        decode(arrayList, str);
        return Collections.unmodifiableList(arrayList);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    private void decode(java.util.Collection<? super io.netty.handler.codec.http.cookie.Cookie> r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = "header"
            java.lang.Object r0 = io.netty.util.internal.ObjectUtil.checkNotNull(r14, r0)
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            r5 = 0
            r6 = 8
            r2 = 1
            r3 = 0
            java.lang.String r4 = "$Version"
            r1 = r14
            boolean r1 = r1.regionMatches(r2, r3, r4, r5, r6)
            r2 = 59
            if (r1 == 0) goto L_0x0027
            int r1 = r14.indexOf(r2)
            r4 = 1
            int r1 = r1 + r4
        L_0x0025:
            r7 = r1
            goto L_0x0029
        L_0x0027:
            r4 = r3
            r7 = r4
        L_0x0029:
            if (r7 != r0) goto L_0x002c
            return
        L_0x002c:
            char r1 = r14.charAt(r7)
            r5 = 9
            if (r1 == r5) goto L_0x00a5
            r5 = 10
            if (r1 == r5) goto L_0x00a5
            r5 = 11
            if (r1 == r5) goto L_0x00a5
            r5 = 12
            if (r1 == r5) goto L_0x00a5
            r5 = 13
            if (r1 == r5) goto L_0x00a5
            r5 = 32
            if (r1 == r5) goto L_0x00a5
            r5 = 44
            if (r1 == r5) goto L_0x00a5
            if (r1 != r2) goto L_0x0050
            goto L_0x00a5
        L_0x0050:
            r1 = r7
        L_0x0051:
            char r5 = r14.charAt(r1)
            r6 = -1
            if (r5 != r2) goto L_0x005c
            r8 = r1
        L_0x0059:
            r9 = r6
            r10 = r9
            goto L_0x007c
        L_0x005c:
            r8 = 61
            if (r5 != r8) goto L_0x0076
            int r5 = r1 + 1
            if (r5 != r0) goto L_0x0069
            r8 = r1
            r9 = r3
            r10 = r9
            r1 = r5
            goto L_0x007c
        L_0x0069:
            int r6 = r14.indexOf(r2, r5)
            if (r6 <= 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r6 = r0
        L_0x0071:
            r8 = r1
            r9 = r5
            r1 = r6
            r10 = r1
            goto L_0x007c
        L_0x0076:
            int r1 = r1 + 1
            if (r1 != r0) goto L_0x0051
            r8 = r0
            goto L_0x0059
        L_0x007c:
            if (r4 == 0) goto L_0x0099
            java.lang.String r5 = "$Path"
            r6 = 5
            boolean r5 = r14.regionMatches(r7, r5, r3, r6)
            if (r5 != 0) goto L_0x0025
            java.lang.String r5 = "$Domain"
            r11 = 7
            boolean r5 = r14.regionMatches(r7, r5, r3, r11)
            if (r5 != 0) goto L_0x0025
            java.lang.String r5 = "$Port"
            boolean r5 = r14.regionMatches(r7, r5, r3, r6)
            if (r5 == 0) goto L_0x0099
            goto L_0x0025
        L_0x0099:
            r5 = r12
            r6 = r14
            io.netty.handler.codec.http.cookie.DefaultCookie r5 = r5.initCookie(r6, r7, r8, r9, r10)
            if (r5 == 0) goto L_0x0025
            r13.add(r5)
            goto L_0x0025
        L_0x00a5:
            int r7 = r7 + 1
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.cookie.ServerCookieDecoder.decode(java.util.Collection, java.lang.String):void");
    }
}
