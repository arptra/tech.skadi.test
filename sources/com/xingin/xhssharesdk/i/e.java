package com.xingin.xhssharesdk.i;

import com.xingin.xhssharesdk.XhsSdkInject;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import com.xingin.xhssharesdk.o.a;
import com.xingin.xhssharesdk.o.b;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public final class e {
    public static /* synthetic */ Map a(a aVar) {
        HashMap hashMap = new HashMap();
        try {
            aVar.a(hashMap);
        } catch (NoSuchAlgorithmException e) {
            XhsShareSdk.d("XhsShare_XhsShareApi", "Calculate md5 error!", e);
        }
        return hashMap;
    }

    public static void b(a aVar, b bVar) {
        b.a(XhsSdkInject.getCheckTokenRequestPath(), new com.honey.account.j9.e(aVar), new d(bVar));
    }
}
