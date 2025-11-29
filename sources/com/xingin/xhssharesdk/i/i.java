package com.xingin.xhssharesdk.i;

import android.text.TextUtils;
import com.xingin.xhssharesdk.XhsSdkInject;
import com.xingin.xhssharesdk.b.f;
import com.xingin.xhssharesdk.core.XhsShareSdk;

public final class i implements f.a {
    public final String a() {
        String str;
        if (TextUtils.isEmpty(XhsShareSdk.b)) {
            if (!TextUtils.isEmpty(XhsSdkInject.getUid())) {
                str = XhsSdkInject.getUid();
            } else {
                str = "" + System.currentTimeMillis();
            }
            XhsShareSdk.b = str;
        }
        return XhsShareSdk.b;
    }
}
