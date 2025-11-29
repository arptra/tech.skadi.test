package com.geetest.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.geetest.sdk.dialog.views.GtWebView;
import com.geetest.sdk.dialog.views.WebviewBuilder;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.o;

public abstract class e extends Dialog {
    public static final String d = "e";

    /* renamed from: a  reason: collision with root package name */
    public View f2929a;
    public Context b;
    public a c;

    public interface a {
        void a();

        void b();

        void onWindowFocusChanged(boolean z);
    }

    public e(Context context) {
        super(context, o.h(context, "gt3_dialog_style"));
        this.b = context;
    }

    public abstract View a(LayoutInflater layoutInflater);

    public abstract void b();

    public void c(View view) {
    }

    public void d(a aVar) {
        this.c = aVar;
    }

    public void dismiss() {
        if (isShowing()) {
            Context context = this.b;
            if (!(context instanceof Activity)) {
                super.dismiss();
            } else if (!((Activity) context).isFinishing() && !((Activity) this.b).isDestroyed()) {
                super.dismiss();
            }
        }
    }

    public void e(View view) {
        this.f2929a = view;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(16777216, 16777216);
        } else {
            l.e(d, "getWindow为null，硬件加速开启失败！");
        }
        View a2 = a(LayoutInflater.from(getContext()));
        setContentView(this.f2929a);
        View view = this.f2929a;
        if (!(!(view instanceof GtWebView) || view == null || view.getLayoutParams() == null)) {
            ViewGroup.LayoutParams layoutParams = this.f2929a.getLayoutParams();
            layoutParams.width = WebviewBuilder.n;
            layoutParams.height = WebviewBuilder.o;
            this.f2929a.setLayoutParams(layoutParams);
        }
        c(a2);
    }

    public void onWindowFocusChanged(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.onWindowFocusChanged(z);
        }
    }

    public void show() {
        try {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a();
            }
            super.show();
            a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.b();
            }
            b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
