package org.eclipse.jetty.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import kotlin.jvm.internal.CharCompanionObject;
import org.apache.commons.io.IOUtils;

public class QuotedStringTokenizer extends StringTokenizer {
    private static final String __delim = "\t\n\r";
    private static final char[] escapes;
    private String _delim;
    private boolean _double;
    private boolean _hasToken;
    private int _i;
    private int _lastStart;
    private boolean _returnDelimiters;
    private boolean _returnQuotes;
    private boolean _single;
    private String _string;
    private StringBuffer _token;

    static {
        char[] cArr = new char[32];
        escapes = cArr;
        Arrays.fill(cArr, CharCompanionObject.MAX_VALUE);
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[12] = 'f';
        cArr[13] = 'r';
    }

    public QuotedStringTokenizer(String str, String str2, boolean z, boolean z2) {
        super("");
        this._delim = __delim;
        this._returnQuotes = false;
        this._returnDelimiters = false;
        this._hasToken = false;
        this._i = 0;
        this._lastStart = 0;
        this._double = true;
        this._single = true;
        this._string = str;
        if (str2 != null) {
            this._delim = str2;
        }
        this._returnDelimiters = z;
        this._returnQuotes = z2;
        if (this._delim.indexOf(39) >= 0 || this._delim.indexOf(34) >= 0) {
            throw new Error("Can't use quotes as delimiters: " + this._delim);
        }
        this._token = new StringBuffer(this._string.length() > 1024 ? 512 : this._string.length() / 2);
    }

    private static boolean isValidEscaping(char c) {
        return c == 'n' || c == 'r' || c == 't' || c == 'f' || c == 'b' || c == '\\' || c == '/' || c == '\"' || c == 'u';
    }

    public static String quote(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "\"\"";
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 8);
        quote(stringBuffer, str);
        return stringBuffer.toString();
    }

    public static String quoteIfNeeded(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "\"\"";
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\\' || charAt == '\"' || charAt == '\'' || Character.isWhitespace(charAt) || str2.indexOf(charAt) >= 0) {
                StringBuffer stringBuffer = new StringBuffer(str.length() + 8);
                quote(stringBuffer, str);
                return stringBuffer.toString();
            }
        }
        return str;
    }

    public static String unquote(String str) {
        return unquote(str, false);
    }

    public static String unquoteOnly(String str) {
        return unquoteOnly(str, false);
    }

    public int countTokens() {
        return -1;
    }

    public boolean getDouble() {
        return this._double;
    }

    public boolean getSingle() {
        return this._single;
    }

    public boolean hasMoreElements() {
        return hasMoreTokens();
    }

    public boolean hasMoreTokens() {
        if (this._hasToken) {
            return true;
        }
        this._lastStart = this._i;
        boolean z = false;
        boolean z2 = false;
        while (this._i < this._string.length()) {
            String str = this._string;
            int i = this._i;
            this._i = i + 1;
            char charAt = str.charAt(i);
            if (z) {
                if (!z) {
                    if (z) {
                        this._hasToken = true;
                        if (z2) {
                            this._token.append(charAt);
                        } else if (charAt == '\'') {
                            if (this._returnQuotes) {
                                this._token.append(charAt);
                            }
                        } else if (charAt == '\\') {
                            if (this._returnQuotes) {
                                this._token.append(charAt);
                            }
                            z2 = true;
                        } else {
                            this._token.append(charAt);
                        }
                    } else if (z) {
                        this._hasToken = true;
                        if (z2) {
                            this._token.append(charAt);
                        } else if (charAt == '\"') {
                            if (this._returnQuotes) {
                                this._token.append(charAt);
                            }
                        } else if (charAt == '\\') {
                            if (this._returnQuotes) {
                                this._token.append(charAt);
                            }
                            z2 = true;
                        } else {
                            this._token.append(charAt);
                        }
                    }
                    z2 = false;
                } else {
                    this._hasToken = true;
                    if (this._delim.indexOf(charAt) >= 0) {
                        if (this._returnDelimiters) {
                            this._i--;
                        }
                        return this._hasToken;
                    } else if (charAt == '\'' && this._single) {
                        if (this._returnQuotes) {
                            this._token.append(charAt);
                        }
                        z = true;
                    } else if (charAt != '\"' || !this._double) {
                        this._token.append(charAt);
                    } else {
                        if (this._returnQuotes) {
                            this._token.append(charAt);
                        }
                        z = true;
                    }
                }
            } else if (this._delim.indexOf(charAt) >= 0) {
                if (this._returnDelimiters) {
                    this._token.append(charAt);
                    this._hasToken = true;
                    return true;
                }
            } else if (charAt == '\'' && this._single) {
                if (this._returnQuotes) {
                    this._token.append(charAt);
                }
                z = true;
            } else if (charAt != '\"' || !this._double) {
                this._token.append(charAt);
                this._hasToken = true;
            } else {
                if (this._returnQuotes) {
                    this._token.append(charAt);
                }
                z = true;
            }
            z = true;
        }
        return this._hasToken;
    }

    public Object nextElement() throws NoSuchElementException {
        return nextToken();
    }

    public String nextToken() throws NoSuchElementException {
        StringBuffer stringBuffer;
        if (!hasMoreTokens() || (stringBuffer = this._token) == null) {
            throw new NoSuchElementException();
        }
        String stringBuffer2 = stringBuffer.toString();
        this._token.setLength(0);
        this._hasToken = false;
        return stringBuffer2;
    }

    public void setDouble(boolean z) {
        this._double = z;
    }

    public void setSingle(boolean z) {
        this._single = z;
    }

    public static String unquote(String str, boolean z) {
        char charAt;
        if (str == null) {
            return null;
        }
        if (str.length() < 2 || (charAt = str.charAt(0)) != str.charAt(str.length() - 1)) {
            return str;
        }
        if (charAt != '\"' && charAt != '\'') {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() - 2);
        boolean z2 = false;
        int i = 1;
        while (i < str.length() - 1) {
            char charAt2 = str.charAt(i);
            if (z2) {
                if (charAt2 == '\"') {
                    sb.append('\"');
                } else if (charAt2 == '/') {
                    sb.append('/');
                } else if (charAt2 == '\\') {
                    sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                } else if (charAt2 == 'b') {
                    sb.append(8);
                } else if (charAt2 == 'f') {
                    sb.append(12);
                } else if (charAt2 == 'n') {
                    sb.append(10);
                } else if (charAt2 == 'r') {
                    sb.append(13);
                } else if (charAt2 == 't') {
                    sb.append(9);
                } else if (charAt2 != 'u') {
                    if (z && !isValidEscaping(charAt2)) {
                        sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                    }
                    sb.append(charAt2);
                } else {
                    int convertHexDigit = (TypeUtil.convertHexDigit((byte) str.charAt(i)) << 24) + (TypeUtil.convertHexDigit((byte) str.charAt(i + 1)) << 16);
                    int i2 = i + 3;
                    i += 4;
                    sb.append((char) (convertHexDigit + (TypeUtil.convertHexDigit((byte) str.charAt(i + 2)) << 8) + TypeUtil.convertHexDigit((byte) str.charAt(i2))));
                }
                z2 = false;
            } else if (charAt2 == '\\') {
                z2 = true;
            } else {
                sb.append(charAt2);
            }
            i++;
        }
        return sb.toString();
    }

    public static String unquoteOnly(String str, boolean z) {
        char charAt;
        if (str == null) {
            return null;
        }
        if (str.length() < 2 || (charAt = str.charAt(0)) != str.charAt(str.length() - 1)) {
            return str;
        }
        if (charAt != '\"' && charAt != '\'') {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() - 2);
        boolean z2 = false;
        for (int i = 1; i < str.length() - 1; i++) {
            char charAt2 = str.charAt(i);
            if (z2) {
                if (z && !isValidEscaping(charAt2)) {
                    sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                }
                sb.append(charAt2);
                z2 = false;
            } else if (charAt2 == '\\') {
                z2 = true;
            } else {
                sb.append(charAt2);
            }
        }
        return sb.toString();
    }

    public static void quote(Appendable appendable, String str) {
        try {
            appendable.append('\"');
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt >= ' ') {
                    if (charAt == '\"' || charAt == '\\') {
                        appendable.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                    }
                    appendable.append(charAt);
                } else {
                    char c = escapes[charAt];
                    if (c == 65535) {
                        appendable.append(IOUtils.DIR_SEPARATOR_WINDOWS).append('u').append('0').append('0');
                        if (charAt < 16) {
                            appendable.append('0');
                        }
                        appendable.append(Integer.toString(charAt, 16));
                    } else {
                        appendable.append(IOUtils.DIR_SEPARATOR_WINDOWS).append(c);
                    }
                }
            }
            appendable.append('\"');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String nextToken(String str) throws NoSuchElementException {
        this._delim = str;
        this._i = this._lastStart;
        this._token.setLength(0);
        this._hasToken = false;
        return nextToken();
    }

    public static boolean quoteIfNeeded(Appendable appendable, String str, String str2) {
        for (int i = 0; i < str.length(); i++) {
            if (str2.indexOf(str.charAt(i)) >= 0) {
                quote(appendable, str);
                return true;
            }
        }
        try {
            appendable.append(str);
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public QuotedStringTokenizer(String str, String str2, boolean z) {
        this(str, str2, z, false);
    }

    public QuotedStringTokenizer(String str, String str2) {
        this(str, str2, false, false);
    }

    public QuotedStringTokenizer(String str) {
        this(str, (String) null, false, false);
    }
}
