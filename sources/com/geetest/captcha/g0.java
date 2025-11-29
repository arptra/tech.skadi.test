package com.geetest.captcha;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final g0 f2856a = new g0();

    public final int a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        return b(context, str, "string");
    }

    public final int b(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        int identifier = applicationContext.getResources().getIdentifier(str, str2, context.getPackageName());
        if (identifier == 0) {
            h0 h0Var = h0.d;
            h0Var.e("ID.getIdentifier resource: " + str + ", type: " + str2 + ", undefined");
        }
        return identifier;
    }

    public final int c(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        return b(context, str, "style");
    }
}
