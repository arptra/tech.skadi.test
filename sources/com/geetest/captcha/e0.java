package com.geetest.captcha;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    public static String f2852a = "加载遇到一点麻烦";
    public static String b = "证书错误";
    public static String c = "参数不合法";
    public static String d = "验证会话已取消";
    public static String e = "不支持的 WebView 组件";
    public static final e0 f = new e0();

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        g0 g0Var = g0.f2856a;
        String string = applicationContext.getString(g0Var.a(context, "gt4_web_callback_error"));
        Intrinsics.checkNotNullExpressionValue(string, "context.applicationConte…gt4_web_callback_error\"))");
        f2852a = string;
        Intrinsics.checkNotNullExpressionValue(context.getApplicationContext().getString(g0Var.a(context, "gt4_web_view_load_error")), "context.applicationConte…t4_web_view_load_error\"))");
        String string2 = context.getApplicationContext().getString(g0Var.a(context, "gt4_web_view_ssl_error"));
        Intrinsics.checkNotNullExpressionValue(string2, "context.applicationConte…gt4_web_view_ssl_error\"))");
        b = string2;
        String string3 = context.getApplicationContext().getString(g0Var.a(context, "gt4_parameter_config_error"));
        Intrinsics.checkNotNullExpressionValue(string3, "context.applicationConte…parameter_config_error\"))");
        c = string3;
        String string4 = context.getApplicationContext().getString(g0Var.a(context, "gt4_user_cancel"));
        Intrinsics.checkNotNullExpressionValue(string4, "context.applicationConte…text, \"gt4_user_cancel\"))");
        d = string4;
        String string5 = context.getApplicationContext().getString(g0Var.a(context, "gt4_device_not_supported"));
        Intrinsics.checkNotNullExpressionValue(string5, "context.applicationConte…4_device_not_supported\"))");
        e = string5;
    }
}
