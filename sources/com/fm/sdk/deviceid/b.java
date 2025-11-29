package com.fm.sdk.deviceid;

import android.content.Context;
import android.util.Log;
import com.bun.miitmdid.core.ErrorCode;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

public class b implements IIdentifierListener {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2833a = "b";
    public static volatile b b;
    public static boolean c;
    public static volatile String d;
    public static volatile String e;
    public static volatile String f;

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                try {
                    if (b == null) {
                        b = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void OnSupport(boolean z, IdSupplier idSupplier) {
        if (idSupplier != null) {
            c(idSupplier.isSupported());
            d = idSupplier.getOAID();
            e = idSupplier.getVAID();
            f = idSupplier.getAAID();
        }
    }

    public void b(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        int d2 = d(context);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (d2 == 1008612) {
            c(false);
        } else if (d2 == 1008613) {
            c(false);
        } else if (d2 == 1008611) {
            c(false);
        } else if (d2 == 1008614) {
            c(false);
        } else if (d2 == 1008615) {
            c(false);
        } else if (d2 == 0) {
            c(true);
        }
        String str = f2833a;
        Log.d(str, "return value: " + String.valueOf(d2) + ", getTime = " + currentTimeMillis2);
    }

    public void c(boolean z) {
        c = z;
    }

    public final int d(Context context) {
        try {
            return MdidSdkHelper.InitSdk(context, true, this);
        } catch (Throwable unused) {
            return ErrorCode.INIT_HELPER_CALL_ERROR;
        }
    }

    public boolean e() {
        return c;
    }

    public String f() {
        return d;
    }

    public String g() {
        return e;
    }

    public String h() {
        return f;
    }
}
