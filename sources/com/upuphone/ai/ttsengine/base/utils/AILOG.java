package com.upuphone.ai.ttsengine.base.utils;

import android.util.Log;
import com.upuphone.star.core.log.ULog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AILOG {
    public static final Map c;

    /* renamed from: a  reason: collision with root package name */
    public String f5522a = "";
    public String b = "AILOG[TTS]:";

    static {
        HashMap hashMap = new HashMap();
        c = hashMap;
        hashMap.put(2, "VERBOSE");
        hashMap.put(3, "DEBUG");
        hashMap.put(4, "INFO");
        hashMap.put(5, "WARN");
        hashMap.put(6, "ERROR");
    }

    public AILOG(String str) {
        this.b += str;
        this.f5522a = str;
    }

    public static AILOG a(String str) {
        return new AILOG(str);
    }

    public void b(Object obj) {
        d(obj);
    }

    public void c(String str, Object... objArr) {
        if (this.f5522a.equals(str)) {
            f(objArr);
        } else {
            e(str, objArr);
        }
    }

    public final void d(Object obj) {
        String obj2 = obj.toString();
        if (obj2.length() > 2000) {
            int length = obj2.length();
            int i = length < 2000 ? length : 2000;
            int i2 = 0;
            while (i2 < i && i <= length) {
                ULog.d(this.b, obj2.substring(i2, i));
                int i3 = length - i;
                if (i3 >= 2000) {
                    i3 = 2000;
                }
                int i4 = i3 + i;
                i2 = i;
                i = i4;
            }
            return;
        }
        ULog.d(this.b, obj2);
    }

    public final void e(String str, Object... objArr) {
        try {
            ULog.d(this.b, l(str, objArr));
        } catch (Exception unused) {
            String str2 = this.b;
            ULog.d(str2, str + "，" + Arrays.toString(objArr));
        }
    }

    public final void f(Object... objArr) {
        String arrays = Arrays.toString(objArr);
        if (arrays.length() > 2000) {
            int length = arrays.length();
            int i = length < 2000 ? length : 2000;
            int i2 = 0;
            while (i2 < i && i <= length) {
                Log.d(this.b, arrays.substring(i2, i));
                int i3 = length - i;
                if (i3 >= 2000) {
                    i3 = 2000;
                }
                int i4 = i3 + i;
                i2 = i;
                i = i4;
            }
            return;
        }
        ULog.d(this.b, arrays);
    }

    public void g(String str, Object obj) {
        if (this.f5522a.equals(str)) {
            i(obj);
        } else {
            j(str, obj);
        }
    }

    public void h(String str, Object... objArr) {
        if (this.f5522a.equals(str)) {
            k(objArr);
        } else {
            j(str, objArr);
        }
    }

    public final void i(Object obj) {
        String obj2 = obj.toString();
        if (obj2.length() > 2000) {
            int length = obj2.length();
            int i = length < 2000 ? length : 2000;
            int i2 = 0;
            while (i2 < i && i <= length) {
                ULog.f(this.b, obj2.substring(i2, i));
                int i3 = length - i;
                if (i3 >= 2000) {
                    i3 = 2000;
                }
                int i4 = i3 + i;
                i2 = i;
                i = i4;
            }
            return;
        }
        ULog.f(this.b, obj2);
    }

    public final void j(String str, Object... objArr) {
        try {
            ULog.f(this.b, l(str, objArr));
        } catch (Exception unused) {
            String str2 = this.b;
            ULog.f(str2, str + "，" + Arrays.toString(objArr));
        }
    }

    public final void k(Object... objArr) {
        String arrays = Arrays.toString(objArr);
        if (arrays.length() > 2000) {
            int length = arrays.length();
            int i = length < 2000 ? length : 2000;
            int i2 = 0;
            while (i2 < i && i <= length) {
                ULog.f(this.b, arrays.substring(i2, i));
                int i3 = length - i;
                if (i3 >= 2000) {
                    i3 = 2000;
                }
                int i4 = i3 + i;
                i2 = i;
                i = i4;
            }
            return;
        }
        ULog.f(this.b, arrays);
    }

    public final String l(String str, Object... objArr) {
        if (str.contains("%")) {
            return String.format(str, objArr);
        }
        if (objArr == null || objArr.length <= 0) {
            return str;
        }
        return str + "，" + Arrays.toString(objArr);
    }

    public void m(String str, Object... objArr) {
        if (this.f5522a.equals(str)) {
            o(objArr);
        } else {
            n(str, objArr);
        }
    }

    public final void n(String str, Object... objArr) {
        try {
            ULog.i(this.b, l(str, objArr));
        } catch (Exception unused) {
            String str2 = this.b;
            ULog.i(str2, str + "，" + Arrays.toString(objArr));
        }
    }

    public final void o(Object... objArr) {
        String arrays = Arrays.toString(objArr);
        if (arrays.length() > 2000) {
            int length = arrays.length();
            int i = length < 2000 ? length : 2000;
            int i2 = 0;
            while (i2 < i && i <= length) {
                ULog.i(this.b, arrays.substring(i2, i));
                int i3 = length - i;
                if (i3 >= 2000) {
                    i3 = 2000;
                }
                int i4 = i3 + i;
                i2 = i;
                i = i4;
            }
            return;
        }
        ULog.i(this.b, arrays);
    }

    public void p(String str, Object... objArr) {
        if (this.f5522a.equals(str)) {
            r(objArr);
        } else {
            q(str, objArr);
        }
    }

    public final void q(String str, Object... objArr) {
        try {
            ULog.m(this.b, l(str, objArr));
        } catch (Exception unused) {
            String str2 = this.b;
            ULog.m(str2, str + "，" + Arrays.toString(objArr));
        }
    }

    public final void r(Object... objArr) {
        String arrays = Arrays.toString(objArr);
        if (arrays.length() > 2000) {
            int length = arrays.length();
            int i = length < 2000 ? length : 2000;
            int i2 = 0;
            while (i2 < i && i <= length) {
                ULog.m(this.b, arrays.substring(i2, i));
                int i3 = length - i;
                if (i3 >= 2000) {
                    i3 = 2000;
                }
                int i4 = i3 + i;
                i2 = i;
                i = i4;
            }
            return;
        }
        ULog.m(this.b, arrays);
    }
}
