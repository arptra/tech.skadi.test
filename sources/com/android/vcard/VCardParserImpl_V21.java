package com.android.vcard;

import android.util.Log;
import com.android.vcard.exception.VCardAgentNotSupportedException;
import com.android.vcard.exception.VCardException;
import com.android.vcard.exception.VCardInvalidCommentLineException;
import com.android.vcard.exception.VCardInvalidLineException;
import com.android.vcard.exception.VCardVersionException;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.MzContactsContract;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class VCardParserImpl_V21 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2391a;
    public final List b;
    public boolean c;
    public String d;
    public String e;
    public CustomBufferedReader f;
    public final Set g;
    public final Set h;

    public static final class CustomBufferedReader extends BufferedReader {

        /* renamed from: a  reason: collision with root package name */
        public long f2392a;
        public boolean b;
        public String c;

        public CustomBufferedReader(Reader reader) {
            super(reader);
        }

        public String a() {
            if (!this.b) {
                long currentTimeMillis = System.currentTimeMillis();
                String readLine = super.readLine();
                this.f2392a += System.currentTimeMillis() - currentTimeMillis;
                this.c = readLine;
                this.b = true;
            }
            return this.c;
        }

        public String readLine() {
            if (this.b) {
                String str = this.c;
                this.c = null;
                this.b = false;
                return str;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String readLine = super.readLine();
            this.f2392a += System.currentTimeMillis() - currentTimeMillis;
            return readLine;
        }
    }

    public VCardParserImpl_V21() {
        this(VCardConfig.b);
    }

    public static String K(char c2) {
        if (c2 == '\\' || c2 == ';' || c2 == ':' || c2 == ',') {
            return String.valueOf(c2);
        }
        return null;
    }

    public final boolean A(char c2) {
        if (c2 < 'a' || c2 > 'z') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    public boolean B(String str) {
        if (e().contains(str.toUpperCase()) || str.startsWith("X-") || this.g.contains(str)) {
            return true;
        }
        this.g.add(str);
        Log.w("vCard", "Property name unsupported by vCard 2.1: " + str);
        return true;
    }

    public String C(String str) {
        return str;
    }

    public void D(InputStream inputStream) {
        if (inputStream != null) {
            this.f = new CustomBufferedReader(new InputStreamReader(inputStream, this.f2391a));
            System.currentTimeMillis();
            for (VCardInterpreter c2 : this.b) {
                c2.c();
            }
            while (true) {
                synchronized (this) {
                    try {
                        if (!this.c) {
                            if (!H()) {
                                break;
                            }
                        } else {
                            Log.i("vCard", "Cancel request has come. exitting parse operation.");
                            break;
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
            for (VCardInterpreter d2 : this.b) {
                d2.d();
            }
            return;
        }
        throw new NullPointerException("InputStream must not be null.");
    }

    public boolean E() {
        this.d = "8BIT";
        VCardProperty b2 = b(i());
        String upperCase = b2.d().toUpperCase();
        String g2 = b2.g();
        if (upperCase.equals("BEGIN")) {
            if (g2.equalsIgnoreCase("VCARD")) {
                u();
                return false;
            }
            throw new VCardException("Unknown BEGIN type: " + g2);
        } else if (!upperCase.equals("END")) {
            F(b2, upperCase);
            return false;
        } else if (g2.equalsIgnoreCase("VCARD")) {
            return true;
        } else {
            throw new VCardException("Unknown END type: " + g2);
        }
    }

    public final void F(VCardProperty vCardProperty, String str) {
        String g2 = vCardProperty.g();
        if (str.equals("AGENT")) {
            p(vCardProperty);
        } else if (!B(str)) {
            throw new VCardException("Unknown property name: \"" + str + "\"");
        } else if (!str.equals("VERSION") || g2.equals(n())) {
            x(vCardProperty, str);
        } else {
            throw new VCardVersionException("Incompatible version: " + g2 + " != " + n());
        }
    }

    public void G() {
        boolean z;
        try {
            z = E();
        } catch (VCardInvalidCommentLineException unused) {
            Log.e("vCard", "Invalid line which looks like some comment was found. Ignored.");
            z = false;
        }
        while (!z) {
            try {
                z = E();
            } catch (VCardInvalidCommentLineException unused2) {
                Log.e("vCard", "Invalid line which looks like some comment was found. Ignored.");
            }
        }
    }

    public final boolean H() {
        this.d = "8BIT";
        this.e = "UTF-8";
        if (!J(true)) {
            return false;
        }
        for (VCardInterpreter e2 : this.b) {
            e2.e();
        }
        G();
        for (VCardInterpreter b2 : this.b) {
            b2.b();
        }
        return true;
    }

    public String I() {
        return this.f.a();
    }

    public boolean J(boolean z) {
        while (true) {
            String h2 = h();
            if (h2 == null) {
                return false;
            }
            if (h2.trim().length() > 0) {
                String[] split = h2.split(AccountConstantKt.CODE_SEPARTOR, 2);
                if (split.length == 2 && split[0].trim().equalsIgnoreCase("BEGIN") && split[1].trim().equalsIgnoreCase("VCARD")) {
                    return true;
                }
                if (!z) {
                    throw new VCardException("Expected String \"BEGIN:VCARD\" did not come (Instead, \"" + h2 + "\" came)");
                } else if (!z) {
                    throw new VCardException("Reached where must not be reached.");
                }
            }
        }
    }

    public void a(VCardInterpreter vCardInterpreter) {
        this.b.add(vCardInterpreter);
    }

    public VCardProperty b(String str) {
        String str2 = str;
        VCardProperty vCardProperty = new VCardProperty();
        int length = str.length();
        if (length <= 0 || str2.charAt(0) != '#') {
            boolean z = false;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str2.charAt(i2);
                String str3 = "";
                if (z) {
                    if (!z) {
                        if (z && charAt == '\"') {
                            if ("2.1".equalsIgnoreCase(n())) {
                                Log.w("vCard", "Double-quoted params found in vCard 2.1. Silently allow it");
                            }
                        }
                    } else if (charAt == '\"') {
                        if ("2.1".equalsIgnoreCase(n())) {
                            Log.w("vCard", "Double-quoted params found in vCard 2.1. Silently allow it");
                        }
                        z = true;
                    } else if (charAt == ';') {
                        w(vCardProperty, str2.substring(i, i2));
                        i = i2 + 1;
                    } else if (charAt == ':') {
                        w(vCardProperty, str2.substring(i, i2));
                        if (i2 < length - 1) {
                            str3 = str2.substring(i2 + 1);
                        }
                        vCardProperty.k(str3);
                        return vCardProperty;
                    }
                } else if (charAt == ':') {
                    vCardProperty.j(str2.substring(i, i2));
                    if (i2 < length - 1) {
                        str3 = str2.substring(i2 + 1);
                    }
                    vCardProperty.k(str3);
                    return vCardProperty;
                } else if (charAt == '.') {
                    String substring = str2.substring(i, i2);
                    if (substring.length() == 0) {
                        Log.w("vCard", "Empty group found. Ignoring.");
                    } else {
                        vCardProperty.a(substring);
                    }
                    i = i2 + 1;
                } else if (charAt == ';') {
                    vCardProperty.j(str2.substring(i, i2));
                    i = i2 + 1;
                }
                z = true;
            }
            throw new VCardInvalidLineException("Invalid line: \"" + str2 + "\"");
        }
        throw new VCardInvalidCommentLineException();
    }

    public Set c() {
        return VCardParser_V21.e;
    }

    public String d(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        while (true) {
            String I = I();
            if (I != null) {
                String k = k(I);
                if (e().contains(k) || "X-ANDROID-CUSTOM".equals(k)) {
                    Log.w("vCard", "Found a next property during parsing a BASE64 string, which must not contain semi-colon or colon. Treat the line as next property.");
                    Log.w("vCard", "Problematic line: " + I.trim());
                } else {
                    h();
                    if (I.length() == 0) {
                        break;
                    }
                    sb.append(I.trim());
                }
            } else {
                throw new VCardException("File ended during parsing BASE64 binary");
            }
        }
        return sb.toString();
    }

    public Set e() {
        return VCardParser_V21.b;
    }

    public Set f() {
        return VCardParser_V21.c;
    }

    public Set g() {
        return VCardParser_V21.d;
    }

    public String h() {
        return this.f.readLine();
    }

    public String i() {
        String h2;
        do {
            h2 = h();
            if (h2 == null) {
                throw new VCardException("Reached end of buffer.");
            }
        } while (h2.trim().length() <= 0);
        return h2;
    }

    public final String j(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        while (true) {
            String I = I();
            if (I != null && I.length() != 0 && k(I) == null) {
                h();
                sb.append(" ");
                sb.append(I);
            }
        }
        return sb.toString();
    }

    public final String k(String str) {
        int indexOf = str.indexOf(AccountConstantKt.CODE_SEPARTOR);
        if (indexOf <= -1) {
            return null;
        }
        int indexOf2 = str.indexOf(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
        if (indexOf == -1) {
            indexOf = indexOf2;
        } else if (indexOf2 != -1) {
            indexOf = Math.min(indexOf, indexOf2);
        }
        return str.substring(0, indexOf).toUpperCase();
    }

    public final String l(String str) {
        if (!str.trim().endsWith("=")) {
            return str;
        }
        int length = str.length();
        do {
        } while (str.charAt(length - 1) != '=');
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, length));
        sb.append("\r\n");
        while (true) {
            String h2 = h();
            if (h2 == null) {
                throw new VCardException("File ended during parsing a Quoted-Printable String");
            } else if (h2.trim().endsWith("=")) {
                int length2 = h2.length();
                do {
                } while (h2.charAt(length2 - 1) != '=');
                sb.append(h2.substring(0, length2));
                sb.append("\r\n");
            } else {
                sb.append(h2);
                return sb.toString();
            }
        }
    }

    public int m() {
        return 0;
    }

    public String n() {
        return "2.1";
    }

    public final void o(VCardProperty vCardProperty, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (this.d.equals("QUOTED-PRINTABLE")) {
            String l = l(str);
            vCardProperty.k(l);
            for (String m : VCardUtils.b(l, m())) {
                arrayList.add(VCardUtils.m(m, false, str2, str3));
            }
        } else {
            for (String add : VCardUtils.b(VCardUtils.i(j(str), str2, str3), m())) {
                arrayList.add(add);
            }
        }
        vCardProperty.l(arrayList);
        for (VCardInterpreter a2 : this.b) {
            a2.a(vCardProperty);
        }
    }

    public void p(VCardProperty vCardProperty) {
        if (!vCardProperty.g().toUpperCase().contains("BEGIN:VCARD")) {
            for (VCardInterpreter a2 : this.b) {
                a2.a(vCardProperty);
            }
            return;
        }
        throw new VCardAgentNotSupportedException("AGENT Property is not supported now.");
    }

    public void q(VCardProperty vCardProperty, String str, String str2) {
        vCardProperty.b(str, str2);
    }

    public void r(VCardProperty vCardProperty, String str) {
        this.e = str;
        vCardProperty.b("CHARSET", str);
    }

    public void s(VCardProperty vCardProperty, String str) {
        if (c().contains(str) || str.startsWith("X-")) {
            vCardProperty.b("ENCODING", str);
            this.d = str.toUpperCase();
            return;
        }
        throw new VCardException("Unknown encoding \"" + str + "\"");
    }

    public void t(VCardProperty vCardProperty, String str) {
        String[] split = str.split(LunarCalendar.DATE_SEPARATOR);
        if (split.length == 2) {
            int i = 0;
            String str2 = split[0];
            int length = str2.length();
            int i2 = 0;
            while (i2 < length) {
                if (A(str2.charAt(i2))) {
                    i2++;
                } else {
                    throw new VCardException("Invalid Language: \"" + str + "\"");
                }
            }
            String str3 = split[1];
            int length2 = str3.length();
            while (i < length2) {
                if (A(str3.charAt(i))) {
                    i++;
                } else {
                    throw new VCardException("Invalid Language: \"" + str + "\"");
                }
            }
            vCardProperty.b("LANGUAGE", str);
            return;
        }
        throw new VCardException("Invalid Language: \"" + str + "\"");
    }

    public final void u() {
        for (VCardInterpreter e2 : this.b) {
            e2.e();
        }
        G();
        for (VCardInterpreter b2 : this.b) {
            b2.b();
        }
    }

    public void v(VCardProperty vCardProperty, String str) {
        y(vCardProperty, str);
    }

    public void w(VCardProperty vCardProperty, String str) {
        String[] split = str.split("=", 2);
        if (split.length == 2) {
            String upperCase = split[0].trim().toUpperCase();
            String trim = split[1].trim();
            if (upperCase.equals("TYPE")) {
                y(vCardProperty, trim);
            } else if (upperCase.equals("VALUE")) {
                z(vCardProperty, trim);
            } else if (upperCase.equals("ENCODING")) {
                s(vCardProperty, trim.toUpperCase());
            } else if (upperCase.equals("CHARSET")) {
                r(vCardProperty, trim);
            } else if (upperCase.equals("LANGUAGE")) {
                t(vCardProperty, trim);
            } else if (upperCase.startsWith("X-")) {
                q(vCardProperty, upperCase, trim);
            } else {
                throw new VCardException("Unknown type \"" + upperCase + "\"");
            }
        } else {
            v(vCardProperty, split[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x(com.android.vcard.VCardProperty r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r9 = r8.d()
            java.lang.String r9 = r9.toUpperCase()
            java.lang.String r0 = r8.g()
            java.lang.String r1 = "CHARSET"
            java.util.Collection r1 = r8.f(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0020
            java.util.Iterator r1 = r1.iterator()
            java.lang.Object r1 = r1.next()
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0021
        L_0x0020:
            r1 = r2
        L_0x0021:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L_0x0029
            java.lang.String r1 = "UTF-8"
        L_0x0029:
            java.lang.String r3 = "ADR"
            boolean r3 = r9.equals(r3)
            java.lang.String r4 = "ISO-8859-1"
            if (r3 != 0) goto L_0x0196
            java.lang.String r3 = "ORG"
            boolean r3 = r9.equals(r3)
            if (r3 != 0) goto L_0x0196
            java.lang.String r3 = "N"
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x0045
            goto L_0x0196
        L_0x0045:
            java.lang.String r3 = r7.d
            java.lang.String r5 = "QUOTED-PRINTABLE"
            boolean r3 = r3.equals(r5)
            r5 = 0
            if (r3 != 0) goto L_0x016d
            java.lang.String r3 = "FN"
            boolean r9 = r9.equals(r3)
            if (r9 == 0) goto L_0x0068
            java.lang.String r9 = "ENCODING"
            java.util.Collection r9 = r8.f(r9)
            if (r9 != 0) goto L_0x0068
            boolean r9 = com.android.vcard.VCardUtils.a(r0)
            if (r9 == 0) goto L_0x0068
            goto L_0x016d
        L_0x0068:
            java.lang.String r9 = r7.d
            java.lang.String r3 = "BASE64"
            boolean r9 = r9.equals(r3)
            java.lang.String r3 = "vCard"
            if (r9 != 0) goto L_0x011a
            java.lang.String r9 = r7.d
            java.lang.String r6 = "B"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x0080
            goto L_0x011a
        L_0x0080:
            java.lang.String r9 = r7.d
            java.lang.String r6 = "7BIT"
            boolean r9 = r9.equals(r6)
            if (r9 != 0) goto L_0x00b1
            java.lang.String r9 = r7.d
            java.lang.String r6 = "8BIT"
            boolean r9 = r9.equals(r6)
            if (r9 != 0) goto L_0x00b1
            java.lang.String r9 = r7.d
            java.lang.String r6 = "X-"
            boolean r9 = r9.startsWith(r6)
            if (r9 != 0) goto L_0x00b1
            java.lang.String r9 = r7.d
            java.lang.String r6 = r7.n()
            java.lang.Object[] r9 = new java.lang.Object[]{r9, r6}
            java.lang.String r6 = "The encoding \"%s\" is unsupported by vCard %s"
            java.lang.String r9 = java.lang.String.format(r6, r9)
            android.util.Log.w(r3, r9)
        L_0x00b1:
            int r9 = r7.m()
            if (r9 != 0) goto L_0x00f1
        L_0x00b7:
            java.lang.String r9 = r7.I()
            boolean r3 = android.text.TextUtils.isEmpty(r9)
            if (r3 != 0) goto L_0x00eb
            char r3 = r9.charAt(r5)
            r6 = 32
            if (r3 != r6) goto L_0x00eb
            java.lang.String r3 = "END:VCARD"
            java.lang.String r6 = r9.toUpperCase()
            boolean r3 = r3.contains(r6)
            if (r3 != 0) goto L_0x00eb
            r7.h()
            if (r2 != 0) goto L_0x00e2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
        L_0x00e2:
            r3 = 1
            java.lang.String r9 = r9.substring(r3)
            r2.append(r9)
            goto L_0x00b7
        L_0x00eb:
            if (r2 == 0) goto L_0x00f1
            java.lang.String r0 = r2.toString()
        L_0x00f1:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.String r0 = com.android.vcard.VCardUtils.i(r0, r4, r1)
            java.lang.String r0 = r7.C(r0)
            r9.add(r0)
            r8.l(r9)
            java.util.List r7 = r7.b
            java.util.Iterator r7 = r7.iterator()
        L_0x010a:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0195
            java.lang.Object r9 = r7.next()
            com.android.vcard.VCardInterpreter r9 = (com.android.vcard.VCardInterpreter) r9
            r9.a(r8)
            goto L_0x010a
        L_0x011a:
            java.lang.String r9 = r7.d(r0)     // Catch:{ OutOfMemoryError -> 0x0152 }
            byte[] r9 = android.util.Base64.decode(r9, r5)     // Catch:{ IllegalArgumentException -> 0x013b }
            r8.i(r9)     // Catch:{ IllegalArgumentException -> 0x013b }
            java.util.List r9 = r7.b     // Catch:{ OutOfMemoryError -> 0x0152 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ OutOfMemoryError -> 0x0152 }
        L_0x012b:
            boolean r0 = r9.hasNext()     // Catch:{ OutOfMemoryError -> 0x0152 }
            if (r0 == 0) goto L_0x0195
            java.lang.Object r0 = r9.next()     // Catch:{ OutOfMemoryError -> 0x0152 }
            com.android.vcard.VCardInterpreter r0 = (com.android.vcard.VCardInterpreter) r0     // Catch:{ OutOfMemoryError -> 0x0152 }
            r0.a(r8)     // Catch:{ OutOfMemoryError -> 0x0152 }
            goto L_0x012b
        L_0x013b:
            com.android.vcard.exception.VCardException r9 = new com.android.vcard.exception.VCardException     // Catch:{ OutOfMemoryError -> 0x0152 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x0152 }
            r1.<init>()     // Catch:{ OutOfMemoryError -> 0x0152 }
            java.lang.String r2 = "Decode error on base64 photo: "
            r1.append(r2)     // Catch:{ OutOfMemoryError -> 0x0152 }
            r1.append(r0)     // Catch:{ OutOfMemoryError -> 0x0152 }
            java.lang.String r0 = r1.toString()     // Catch:{ OutOfMemoryError -> 0x0152 }
            r9.<init>(r0)     // Catch:{ OutOfMemoryError -> 0x0152 }
            throw r9     // Catch:{ OutOfMemoryError -> 0x0152 }
        L_0x0152:
            java.lang.String r9 = "OutOfMemoryError happened during parsing BASE64 data!"
            android.util.Log.e(r3, r9)
            java.util.List r7 = r7.b
            java.util.Iterator r7 = r7.iterator()
        L_0x015d:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0195
            java.lang.Object r9 = r7.next()
            com.android.vcard.VCardInterpreter r9 = (com.android.vcard.VCardInterpreter) r9
            r9.a(r8)
            goto L_0x015d
        L_0x016d:
            java.lang.String r9 = r7.l(r0)
            java.lang.String r0 = com.android.vcard.VCardUtils.m(r9, r5, r4, r1)
            r8.k(r9)
            java.lang.String[] r9 = new java.lang.String[]{r0}
            r8.m(r9)
            java.util.List r7 = r7.b
            java.util.Iterator r7 = r7.iterator()
        L_0x0185:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0195
            java.lang.Object r9 = r7.next()
            com.android.vcard.VCardInterpreter r9 = (com.android.vcard.VCardInterpreter) r9
            r9.a(r8)
            goto L_0x0185
        L_0x0195:
            return
        L_0x0196:
            r7.o(r8, r0, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.vcard.VCardParserImpl_V21.x(com.android.vcard.VCardProperty, java.lang.String):void");
    }

    public void y(VCardProperty vCardProperty, String str) {
        if (!f().contains(str.toUpperCase()) && !str.startsWith("X-") && !this.g.contains(str)) {
            this.g.add(str);
            Log.w("vCard", String.format("TYPE unsupported by %s: ", new Object[]{Integer.valueOf(m()), str}));
        }
        vCardProperty.b("TYPE", str);
    }

    public void z(VCardProperty vCardProperty, String str) {
        if (!g().contains(str.toUpperCase()) && !str.startsWith("X-") && !this.h.contains(str)) {
            this.h.add(str);
            Log.w("vCard", String.format("The value unsupported by TYPE of %s: ", new Object[]{Integer.valueOf(m()), str}));
        }
        vCardProperty.b("VALUE", str);
    }

    public VCardParserImpl_V21(int i) {
        this.b = new ArrayList();
        this.g = new HashSet();
        this.h = new HashSet();
        this.f2391a = "ISO-8859-1";
    }
}
