package com.xingin.xhssharesdk.i;

import com.xingin.xhssharesdk.XhsSdkInject;
import com.xingin.xhssharesdk.b.a;
import com.xingin.xhssharesdk.core.XhsShareSdk;

public final class h implements a {
    public final void a(String str) {
        if (XhsSdkInject.isDebugTracker()) {
            XhsShareSdk.b("XhsShare_SdkTrackerLog", str);
        }
    }
}
