package com.xingin.xhssharesdk.j;

import android.content.Context;
import android.net.Uri;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import java.io.File;
import java.lang.reflect.Method;

public final class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public Method f8189a;

    public final Uri a(Context context, String str, File file) {
        Method method = this.f8189a;
        if (method == null) {
            return null;
        }
        try {
            return (Uri) method.invoke((Object) null, new Object[]{context, str, file});
        } catch (Throwable th) {
            XhsShareSdk.d("XhsShare_AndroidSupportFileProvider", "getUriForFile error.", th);
            return null;
        }
    }
}
