package com.android.vcard;

import android.util.Log;
import com.android.vcard.exception.VCardException;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

class VCardParserImpl_V30 extends VCardParserImpl_V21 {
    public String i;
    public boolean j = false;

    public static String K(char c) {
        return (c == 'n' || c == 'N') ? StringUtils.LF : String.valueOf(c);
    }

    public static String N(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt != '\\' || i2 >= length - 1) {
                sb.append(charAt);
            } else {
                i2++;
                char charAt2 = str.charAt(i2);
                if (charAt2 == 'n' || charAt2 == 'N') {
                    sb.append(StringUtils.LF);
                } else {
                    sb.append(charAt2);
                }
            }
            i2++;
        }
        return sb.toString();
    }

    public String C(String str) {
        return N(str);
    }

    public String I() {
        String str = this.i;
        return str != null ? str : this.f.a();
    }

    public boolean J(boolean z) {
        return super.J(z);
    }

    public String L(String str) {
        return VCardUtils.i(str, "ISO-8859-1", "UTF-8");
    }

    public final void M(VCardProperty vCardProperty, String str, String str2) {
        int length = str2.length();
        StringBuilder sb = null;
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str2.charAt(i2);
            if (charAt == '\"') {
                if (z) {
                    vCardProperty.b(str, L(sb.toString()));
                    sb = null;
                    z = false;
                } else {
                    if (sb != null) {
                        if (sb.length() > 0) {
                            Log.w("vCard", "Unexpected Dquote inside property.");
                        } else {
                            vCardProperty.b(str, L(sb.toString()));
                        }
                    }
                    z = true;
                }
            } else if (charAt != ',' || z) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(charAt);
            } else if (sb == null) {
                Log.w("vCard", "Comma is used before actual string comes. (" + str2 + ")");
            } else {
                vCardProperty.b(str, L(sb.toString()));
                sb = null;
            }
        }
        if (z) {
            Log.d("vCard", "Dangling Dquote.");
        }
        if (sb == null) {
            return;
        }
        if (sb.length() == 0) {
            Log.w("vCard", "Unintended behavior. We must not see empty StringBuilder at the end of parameter value parsing.");
        } else {
            vCardProperty.b(str, L(sb.toString()));
        }
    }

    public String d(String str) {
        return str;
    }

    public Set e() {
        return VCardParser_V30.b;
    }

    public String h() {
        String str = this.i;
        if (str == null) {
            return this.f.readLine();
        }
        this.i = null;
        return str;
    }

    public String i() {
        String readLine;
        String str = null;
        StringBuilder sb = null;
        while (true) {
            readLine = this.f.readLine();
            if (readLine == null) {
                break;
            } else if (readLine.length() != 0) {
                if (readLine.charAt(0) != ' ' && readLine.charAt(0) != 9) {
                    if (sb != null || this.i != null) {
                        break;
                    }
                    this.i = readLine;
                } else {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    String str2 = this.i;
                    if (str2 != null) {
                        sb.append(str2);
                        this.i = null;
                    }
                    sb.append(readLine.substring(1));
                }
            }
        }
        if (sb != null) {
            str = sb.toString();
        } else {
            String str3 = this.i;
            if (str3 != null) {
                str = str3;
            }
        }
        this.i = readLine;
        if (str != null) {
            return str;
        }
        throw new VCardException("Reached end of buffer.");
    }

    public int m() {
        return 1;
    }

    public String n() {
        return "3.0";
    }

    public void p(VCardProperty vCardProperty) {
        if (!this.j) {
            Log.w("vCard", "AGENT in vCard 3.0 is not supported yet. Ignore it");
            this.j = true;
        }
    }

    public void q(VCardProperty vCardProperty, String str, String str2) {
        M(vCardProperty, str, str2);
    }

    public void v(VCardProperty vCardProperty, String str) {
        y(vCardProperty, str);
    }

    public void w(VCardProperty vCardProperty, String str) {
        try {
            super.w(vCardProperty, str);
        } catch (VCardException unused) {
            String[] split = str.split("=", 2);
            if (split.length == 2) {
                q(vCardProperty, split[0], split[1]);
                return;
            }
            throw new VCardException("Unknown params value: " + str);
        }
    }

    public void y(VCardProperty vCardProperty, String str) {
        M(vCardProperty, "TYPE", str);
    }
}
