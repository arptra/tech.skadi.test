package com.geetest.sdk;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.geetest.sdk.dialog.views.WebviewBuilder;
import com.geetest.sdk.utils.d;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.utils.l;

public abstract class f extends e {
    public Context e;
    public int f;

    public f(Context context) {
        super(context);
        this.e = context;
    }

    public void b() {
        h();
    }

    public void f(int i) {
        this.f = i;
    }

    public int g() {
        return this.f;
    }

    public final void h() {
        try {
            if (this.e == null) {
                l.c("BaseScreenDialog", "The context is unexpectedly empty !");
                return;
            }
            Window window = getWindow();
            if ((window.getDecorView().getSystemUiVisibility() & 4) == 4 || (window.getAttributes().flags & 1024) == 1024) {
                window.getDecorView().setSystemUiVisibility(5638);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (d.c) {
                attributes.width = WebviewBuilder.n;
                attributes.height = WebviewBuilder.o;
            } else {
                attributes.width = g.c(this.e);
                attributes.height = g.a(this.e);
            }
            attributes.gravity = 17;
            attributes.y = g.b(this.e, (float) g());
            window.setAttributes(attributes);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
