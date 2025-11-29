package com.geetest.sdk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.geetest.sdk.dialog.views.GtWebView;
import com.geetest.sdk.dialog.views.WebviewBuilder;
import com.geetest.sdk.utils.i;
import com.geetest.sdk.utils.l;

public class g extends f {
    public Context g;

    public g(Context context) {
        super(context);
        this.g = context;
    }

    public View a(LayoutInflater layoutInflater) {
        return null;
    }

    public void c(View view) {
        super.c(view);
    }

    public void i(View view) {
        try {
            Context context = this.g;
            if (context == null) {
                l.c("BaseStatusDialog", "The context is unexpectedly empty !");
                return;
            }
            i.a(context);
            i.b(this.g);
            setContentView(view);
            if (!(view instanceof GtWebView)) {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = com.geetest.sdk.utils.g.c(this.g);
                attributes.height = com.geetest.sdk.utils.g.a(this.g);
                window.setAttributes(attributes);
            } else if (view != null && view.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = WebviewBuilder.n;
                layoutParams.height = WebviewBuilder.o;
                Window window2 = getWindow();
                WindowManager.LayoutParams attributes2 = window2.getAttributes();
                attributes2.width = WebviewBuilder.n;
                attributes2.height = WebviewBuilder.o;
                window2.setAttributes(attributes2);
                view.setLayoutParams(layoutParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
