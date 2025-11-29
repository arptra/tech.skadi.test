package com.android.vcard;

import android.text.TextUtils;
import android.util.Log;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.IOUtils;

public class VCardBuilder {
    public static final Set i = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"vnd.android.cursor.item/nickname", "vnd.android.cursor.item/contact_event", "vnd.android.cursor.item/relation"})));
    public static final Map j;

    /* renamed from: a  reason: collision with root package name */
    public final int f2367a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final String f;
    public StringBuilder g;
    public boolean h;

    public static class PostalStruct {
    }

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(1, 0);
        hashMap.put(2, 1);
        hashMap.put(3, 2);
        hashMap.put(0, 3);
    }

    public void a(String str, String str2) {
        b(str, str2, false, false);
    }

    public void b(String str, String str2, boolean z, boolean z2) {
        c(str, (List) null, str2, z, z2);
    }

    public void c(String str, List list, String str2, boolean z, boolean z2) {
        String str3;
        this.g.append(str);
        if (list != null && list.size() > 0) {
            this.g.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
            f(list);
        }
        if (z) {
            this.g.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
            this.g.append(this.f);
        }
        if (z2) {
            this.g.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
            this.g.append("ENCODING=QUOTED-PRINTABLE");
            str3 = g(str2);
        } else {
            str3 = h(str2);
        }
        this.g.append(AccountConstantKt.CODE_SEPARTOR);
        this.g.append(str3);
        this.g.append("\r\n");
    }

    public final void d(String str) {
        e(this.g, str);
    }

    public final void e(StringBuilder sb, String str) {
        if (VCardConfig.e(this.f2367a) || ((VCardConfig.d(this.f2367a) || this.d) && !this.c)) {
            sb.append("TYPE");
            sb.append("=");
        }
        sb.append(str);
    }

    public final void f(List list) {
        Iterator it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (VCardConfig.d(this.f2367a) || VCardConfig.e(this.f2367a)) {
                String q = VCardConfig.e(this.f2367a) ? VCardUtils.q(str) : VCardUtils.p(str);
                if (!TextUtils.isEmpty(q)) {
                    if (z) {
                        z = false;
                    } else {
                        this.g.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
                    }
                    d(q);
                }
            } else if (VCardUtils.l(str)) {
                if (z) {
                    z = false;
                } else {
                    this.g.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
                }
                d(str);
            }
        }
    }

    public final String g(String str) {
        byte[] bytes;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            bytes = str.getBytes(this.e);
        } catch (UnsupportedEncodingException unused) {
            Log.e("vCard", "Charset " + this.e + " cannot be used. Try default charset");
            bytes = str.getBytes();
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < bytes.length) {
            sb.append(String.format("=%02X", new Object[]{Byte.valueOf(bytes[i2])}));
            i2++;
            i3 += 3;
            if (i3 >= 67) {
                sb.append("=\r\n");
                i3 = 0;
            }
        }
        return sb.toString();
    }

    public final String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt != 10) {
                if (charAt != 13) {
                    if (charAt != ',') {
                        if (charAt != '>') {
                            if (charAt != '\\') {
                                if (charAt == ';') {
                                    sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                                    sb.append(';');
                                } else if (charAt != '<') {
                                    sb.append(charAt);
                                }
                            } else if (this.b) {
                                sb.append("\\\\");
                            }
                        }
                        if (this.c) {
                            sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb.append(charAt);
                        } else {
                            sb.append(charAt);
                        }
                    } else if (this.b) {
                        sb.append("\\,");
                    } else {
                        sb.append(charAt);
                    }
                } else if (i2 + 1 < length && str.charAt(i2) == 10) {
                }
            }
            sb.append("\\n");
        }
        return sb.toString();
    }

    public String toString() {
        if (!this.h) {
            if (this.c) {
                a("X-CLASS", "PUBLIC");
                a("X-REDUCTION", "");
                a("X-NO", "");
                a("X-DCM-HMN-MODE", "");
            }
            a("END", "VCARD");
            this.h = true;
        }
        return this.g.toString();
    }
}
