package com.xingin.xhssharesdk.i;

import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.model.sharedata.XhsNote;
import com.xingin.xhssharesdk.q.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f8180a;
    public final b b;
    public boolean c = false;

    public a(XhsNote xhsNote) {
        String generateSessionId = XhsShareSdkTools.generateSessionId(xhsNote);
        this.f8180a = generateSessionId;
        this.b = new b(generateSessionId);
    }
}
