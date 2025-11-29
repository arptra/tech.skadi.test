package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;

public final class MessageFormatter {
    public static final FormattingTuple a(String str, Object[] objArr) {
        Throwable k = k(objArr);
        if (k != null) {
            objArr = s(objArr);
        }
        return b(str, objArr, k);
    }

    public static final FormattingTuple b(String str, Object[] objArr, Throwable th) {
        int i;
        if (str == null) {
            return new FormattingTuple((String) null, objArr, th);
        }
        if (objArr == null) {
            return new FormattingTuple(str);
        }
        StringBuilder sb = new StringBuilder(str.length() + 50);
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length) {
            int indexOf = str.indexOf("{}", i3);
            if (indexOf != -1) {
                if (!n(str, indexOf)) {
                    sb.append(str, i3, indexOf);
                    f(sb, objArr[i2], new HashMap());
                    i = indexOf + 2;
                } else if (!m(str, indexOf)) {
                    i2--;
                    sb.append(str, i3, indexOf - 1);
                    sb.append('{');
                    i = indexOf + 1;
                } else {
                    sb.append(str, i3, indexOf - 1);
                    f(sb, objArr[i2], new HashMap());
                    i = indexOf + 2;
                }
                i3 = i;
                i2++;
            } else if (i3 == 0) {
                return new FormattingTuple(str, objArr, th);
            } else {
                sb.append(str, i3, str.length());
                return new FormattingTuple(sb.toString(), objArr, th);
            }
        }
        sb.append(str, i3, str.length());
        return new FormattingTuple(sb.toString(), objArr, th);
    }

    public static void c(StringBuilder sb, boolean[] zArr) {
        sb.append('[');
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(zArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    public static void d(StringBuilder sb, byte[] bArr) {
        sb.append('[');
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(bArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    public static void e(StringBuilder sb, char[] cArr) {
        sb.append('[');
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(cArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    public static void f(StringBuilder sb, Object obj, Map map) {
        if (obj == null) {
            sb.append("null");
        } else if (!obj.getClass().isArray()) {
            q(sb, obj);
        } else if (obj instanceof boolean[]) {
            c(sb, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            d(sb, (byte[]) obj);
        } else if (obj instanceof char[]) {
            e(sb, (char[]) obj);
        } else if (obj instanceof short[]) {
            r(sb, (short[]) obj);
        } else if (obj instanceof int[]) {
            l(sb, (int[]) obj);
        } else if (obj instanceof long[]) {
            o(sb, (long[]) obj);
        } else if (obj instanceof float[]) {
            h(sb, (float[]) obj);
        } else if (obj instanceof double[]) {
            g(sb, (double[]) obj);
        } else {
            p(sb, (Object[]) obj, map);
        }
    }

    public static void g(StringBuilder sb, double[] dArr) {
        sb.append('[');
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(dArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    public static void h(StringBuilder sb, float[] fArr) {
        sb.append('[');
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(fArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    public static final FormattingTuple i(String str, Object obj) {
        return a(str, new Object[]{obj});
    }

    public static final FormattingTuple j(String str, Object obj, Object obj2) {
        return a(str, new Object[]{obj, obj2});
    }

    public static Throwable k(Object[] objArr) {
        return NormalizedParameters.a(objArr);
    }

    public static void l(StringBuilder sb, int[] iArr) {
        sb.append('[');
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(iArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    public static final boolean m(String str, int i) {
        return i >= 2 && str.charAt(i - 2) == '\\';
    }

    public static final boolean n(String str, int i) {
        return i != 0 && str.charAt(i - 1) == '\\';
    }

    public static void o(StringBuilder sb, long[] jArr) {
        sb.append('[');
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(jArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    public static void p(StringBuilder sb, Object[] objArr, Map map) {
        sb.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, (Object) null);
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                f(sb, objArr[i], map);
                if (i != length - 1) {
                    sb.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            sb.append("...");
        }
        sb.append(']');
    }

    public static void q(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            Util.d("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
            sb.append("[FAILED toString()]");
        }
    }

    public static void r(StringBuilder sb, short[] sArr) {
        sb.append('[');
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(sArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    public static Object[] s(Object[] objArr) {
        return NormalizedParameters.b(objArr);
    }
}
