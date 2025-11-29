package com.geetest.captcha;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.geetest.captcha.GTCaptcha4Client;
import io.flutter.plugin.platform.PlatformPlugin;
import kotlin.jvm.internal.Intrinsics;

public final class h extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public View f2857a;
    public GTCaptcha4Client.OnDialogShowListener b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context, g0.f2856a.c(context, "gt4_captcha_dialog_style"));
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(PlatformPlugin.DEFAULT_SYSTEM_UI);
        }
        Window window2 = getWindow();
        Integer num = null;
        WindowManager.LayoutParams attributes = window2 != null ? window2.getAttributes() : null;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        int i = resources.getDisplayMetrics().widthPixels;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Intrinsics.checkNotNullParameter(context2, "context");
        Resources resources2 = context2.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "context.resources");
        int i2 = resources2.getDisplayMetrics().heightPixels;
        if (attributes != null) {
            attributes.width = i;
        }
        if (attributes != null) {
            attributes.height = i2;
        }
        h0 h0Var = h0.d;
        StringBuilder sb = new StringBuilder();
        sb.append("ScreenWidth: ");
        sb.append(i);
        sb.append(", ScreenHeight: ");
        sb.append(i2);
        sb.append(", ");
        sb.append("DialogWidth: ");
        sb.append(attributes != null ? Integer.valueOf(attributes.width) : null);
        sb.append(", DialogHeight: ");
        if (attributes != null) {
            num = Integer.valueOf(attributes.height);
        }
        sb.append(num);
        h0Var.e(sb.toString());
        if (attributes != null) {
            attributes.gravity = 17;
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setAttributes(attributes);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intrinsics.checkNotNullExpressionValue(LayoutInflater.from(getContext()), "inflater");
        View view = this.f2857a;
        if (view != null) {
            setContentView(view);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        GTCaptcha4Client.OnDialogShowListener onDialogShowListener = this.b;
        if (onDialogShowListener != null) {
            onDialogShowListener.d(this, z);
        }
    }

    public void show() {
        GTCaptcha4Client.OnDialogShowListener onDialogShowListener = this.b;
        if (onDialogShowListener != null) {
            onDialogShowListener.b(this);
        }
        super.show();
        GTCaptcha4Client.OnDialogShowListener onDialogShowListener2 = this.b;
        if (onDialogShowListener2 != null) {
            onDialogShowListener2.a(this);
        }
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Context context, String str) {
        super(context, g0.f2856a.c(context, str));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "dialogStyle");
    }
}
