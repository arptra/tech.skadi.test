package com.geetest.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.geetest.sdk.utils.k;
import com.geetest.sdk.utils.l;
import java.util.Map;
import org.json.JSONObject;

public abstract class ac<T> {
    public static final String i = "ac";

    /* renamed from: a  reason: collision with root package name */
    public String f2902a;
    public Context b;
    public int c;
    public String d;
    public Object e;
    public byte[] f;
    public String g;
    public boolean h = false;

    public ac(String str, Context context) {
        this.f2902a = str;
        this.b = context;
    }

    public final String a() {
        return this.g;
    }

    public final String b(String str) {
        return c("%s %s", "absent", str);
    }

    public final String c(String str, Object... objArr) {
        String str2 = i;
        l.c(str2, this.g + " " + String.format(str, objArr));
        return "request data error";
    }

    public final void d(int i2) {
        if (i2 != 0) {
            throw new RuntimeException("unknown et.");
        }
    }

    public final void e(int i2, String str) {
        this.c = i2;
        this.d = str;
    }

    public final void f(int i2, String str, Object obj) {
        this.c = i2;
        this.d = str;
        this.e = obj;
    }

    public final void g(ae aeVar) {
        if (aeVar != null) {
            try {
                aeVar.a(this.c, this.d, this.e);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(boolean z) {
        this.h = z;
    }

    public abstract boolean i(int i2, af afVar, JSONObject jSONObject);

    public Context j() {
        return this.b;
    }

    public final String k(String str, Object... objArr) {
        String str2 = i;
        l.d(str2, this.g + " " + String.format(str, objArr));
        return "request net error";
    }

    public final void l(ae aeVar) {
        l.c(i, "request cancel");
    }

    public final void m(String str) {
        if (TextUtils.isEmpty(str)) {
            e(-2, "response null!");
            String str2 = i;
            l.c(str2, this.g + " parse error: response null!");
        } else if (str.startsWith("GT3_Error_Info: ")) {
            e(-2, str.replace("GT3_Error_Info: ", ""));
            String str3 = i;
            l.c(str3, this.g + " parse error: response null!");
        } else {
            String str4 = i;
            l.e(str4, this.g + " response body: " + str);
            String replace = str.replace("(", "").replace(")", "");
            if (TextUtils.isEmpty(replace)) {
                e(-2, "decrypt error: " + replace);
                return;
            }
            l.e(str4, this.g + " parsed response body: " + replace);
            try {
                JSONObject jSONObject = new JSONObject(replace);
                int optInt = jSONObject.optInt("result");
                af afVar = new af((Object) null, (Object) null);
                if (!i(optInt, afVar, jSONObject)) {
                    e(-2, (String) afVar.f2905a);
                } else {
                    f(optInt, (String) afVar.f2905a, afVar.b);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                e(-2, "parse json error：" + replace + " Exception: " + e2.toString());
                String str5 = i;
                l.c(str5, this.g + " parse error: " + e2.toString());
            }
        }
    }

    public abstract Map n();

    public final void o(String str) {
        this.g = str;
    }

    public String p() {
        return this.f2902a;
    }

    public boolean q() {
        return true;
    }

    public final byte[] r() {
        byte[] bArr;
        this.f = null;
        try {
            JSONObject s = s();
            String jSONObject = s != null ? s.toString() : t();
            l.e(i, this.g + " request body: " + jSONObject);
            if (this.h) {
                try {
                    bArr = k.b(jSONObject.getBytes());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    l.c(i, e2.toString());
                    bArr = null;
                }
                if (bArr != null) {
                    this.f = bArr;
                    return bArr;
                }
            }
            if (!TextUtils.isEmpty(jSONObject)) {
                byte[] bytes = jSONObject.getBytes();
                this.f = bytes;
                return bytes;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public JSONObject s() {
        return null;
    }

    public String t() {
        return null;
    }
}
