package com.geetest.captcha;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f2888a = new ArrayList();

    public final void a(z zVar) {
        if (zVar != null) {
            synchronized (this.f2888a) {
                if (!this.f2888a.contains(zVar)) {
                    this.f2888a.add(zVar);
                } else {
                    throw new IllegalStateException(("Observer " + zVar + " is already registered.").toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("The observer is null.".toString());
    }

    public final void b(String str, String str2, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "errorCode");
        Intrinsics.checkNotNullParameter(str2, "errorMsg");
        Intrinsics.checkNotNullParameter(jSONObject, "errorDesc");
        Iterator it = this.f2888a.iterator();
        while (it.hasNext()) {
            ((z) it.next()).a(str, str2, jSONObject);
        }
    }

    public final void c(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        Iterator it = this.f2888a.iterator();
        while (it.hasNext()) {
            ((z) it.next()).a(z, str);
        }
    }
}
