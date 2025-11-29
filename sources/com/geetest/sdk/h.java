package com.geetest.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.geetest.sdk.b;
import com.geetest.sdk.dialog.views.FailedView;
import com.geetest.sdk.dialog.views.GtWebView;
import com.geetest.sdk.dialog.views.LoadingView;
import com.geetest.sdk.dialog.views.SuccessView;
import com.geetest.sdk.dialog.views.WebviewBuilder;
import com.geetest.sdk.e;
import com.geetest.sdk.utils.l;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public Context f2930a;
    public GT3ConfigBean b;
    public g c;
    public g d;
    public LoadingView e;
    public GtWebView f;
    public C0013h g;
    public WebviewBuilder h;
    public b.C0012b i;
    public int j = 1;
    public boolean k;
    public i l = i.INIT;

    public class a implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GT3ConfigBean f2931a;

        public a(GT3ConfigBean gT3ConfigBean) {
            this.f2931a = gT3ConfigBean;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            try {
                if (h.this.c != null && !h.this.c.isShowing() && this.f2931a.h() != null) {
                    this.f2931a.h().onClosed(2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements DialogInterface.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GT3ConfigBean f2932a;

        public b(GT3ConfigBean gT3ConfigBean) {
            this.f2932a = gT3ConfigBean;
        }

        public void onCancel(DialogInterface dialogInterface) {
            if (h.this.i != null) {
                h.this.i.j();
            }
            if (this.f2932a.h() != null) {
                this.f2932a.h().onClosed(2);
            }
        }
    }

    public class c implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GT3ConfigBean f2933a;

        public c(GT3ConfigBean gT3ConfigBean) {
            this.f2933a = gT3ConfigBean;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 1 && !this.f2933a.q()) {
                if (h.this.i != null) {
                    h.this.i.j();
                }
                if (this.f2933a.h() != null) {
                    this.f2933a.h().onClosed(3);
                }
                h.this.i();
            }
            return true;
        }
    }

    public class d implements e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GT3ConfigBean f2934a;

        public d(GT3ConfigBean gT3ConfigBean) {
            this.f2934a = gT3ConfigBean;
        }

        public void a() {
            GT3Listener h = this.f2934a.h();
            if (h != null) {
                h.actionBeforeDialogShow(h.this.c);
            }
        }

        public void b() {
            GT3Listener h = this.f2934a.h();
            if (h != null) {
                h.actionAfterDialogShow(h.this.c);
            }
        }

        public void onWindowFocusChanged(boolean z) {
            GT3Listener h = this.f2934a.h();
            if (h != null) {
                h.onWindowFocusChanged(h.this.c, z);
            }
        }
    }

    public class e implements e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GT3ConfigBean f2935a;

        public e(GT3ConfigBean gT3ConfigBean) {
            this.f2935a = gT3ConfigBean;
        }

        public void a() {
            GT3Listener h = this.f2935a.h();
            if (h != null) {
                h.actionBeforeDialogShow(h.this.d);
            }
        }

        public void b() {
            GT3Listener h = this.f2935a.h();
            if (h != null) {
                h.actionAfterDialogShow(h.this.d);
            }
        }

        public void onWindowFocusChanged(boolean z) {
            GT3Listener h = this.f2935a.h();
            if (h != null) {
                h.onWindowFocusChanged(h.this.d, z);
            }
        }
    }

    public class f implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GT3ErrorBean f2936a;

        public f(GT3ErrorBean gT3ErrorBean) {
            this.f2936a = gT3ErrorBean;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            try {
                if (h.this.b != null && h.this.b.h() != null) {
                    h.this.b.h().onFailed(this.f2936a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class g implements DialogInterface.OnDismissListener {
        public g() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            try {
                if (h.this.b != null && h.this.b.h() != null) {
                    h.this.b.h().onSuccess("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.geetest.sdk.h$h  reason: collision with other inner class name */
    public class C0013h implements Runnable {
        public C0013h() {
        }

        public void run() {
            h.this.i();
            h.this.l();
        }
    }

    public enum i {
        NUMBER_ONE_CLOSE,
        SHOW_LOADING,
        SHOW_WEB,
        DISMISS,
        INIT
    }

    public h(Context context, GT3ConfigBean gT3ConfigBean) {
        this.f2930a = context;
        this.b = gT3ConfigBean;
        g gVar = new g(context);
        this.c = gVar;
        gVar.f(gT3ConfigBean.c());
        this.c.setCanceledOnTouchOutside(gT3ConfigBean.o());
        g gVar2 = new g(context);
        this.d = gVar2;
        gVar2.f(gT3ConfigBean.c());
        this.d.setCanceledOnTouchOutside(gT3ConfigBean.o());
        this.d.setOnDismissListener(new a(gT3ConfigBean));
        this.c.setOnCancelListener(new b(gT3ConfigBean));
        this.c.setOnKeyListener(new c(gT3ConfigBean));
        this.c.d(new d(gT3ConfigBean));
        this.d.d(new e(gT3ConfigBean));
    }

    public void b(int i2) {
        this.j = i2;
    }

    public void c(GT3ErrorBean gT3ErrorBean) {
        try {
            this.d.setOnDismissListener(new f(gT3ErrorBean));
            this.l = i.DISMISS;
            int n = n();
            if (n == 2) {
                i();
                b.C0012b bVar = this.i;
                if (bVar != null) {
                    bVar.e(gT3ErrorBean.b, gT3ErrorBean.f2897a);
                }
                GT3ConfigBean gT3ConfigBean = this.b;
                if (gT3ConfigBean != null && gT3ConfigBean.h() != null) {
                    this.b.h().onFailed(gT3ErrorBean);
                }
            } else if (n != 3) {
                try {
                    this.g = new C0013h();
                    this.d.i(new FailedView(this.f2930a, this, gT3ErrorBean, this.g, this.b));
                    this.d.show();
                    i();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                i();
                GT3ConfigBean gT3ConfigBean2 = this.b;
                if (gT3ConfigBean2 != null && gT3ConfigBean2.h() != null) {
                    this.b.h().onFailed(gT3ErrorBean);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void d(b.C0012b bVar) {
        this.i = bVar;
    }

    public void e(i iVar) {
        this.l = iVar;
    }

    public void f(com.geetest.sdk.model.beans.b bVar, ab abVar) {
        WebviewBuilder webviewBuilder = new WebviewBuilder(this.f2930a, this.c);
        this.h = webviewBuilder;
        webviewBuilder.g(bVar);
        this.h.e(this.b);
        this.h.f(abVar);
        this.f = this.h.c();
    }

    public void g(boolean z) {
        this.k = z;
    }

    public void i() {
        try {
            g gVar = this.c;
            if (gVar != null && gVar.isShowing()) {
                this.c.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void l() {
        try {
            g gVar = this.d;
            if (gVar != null && gVar.isShowing()) {
                this.d.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean m() {
        return !this.f.f();
    }

    public int n() {
        return this.j;
    }

    public g o() {
        return this.c;
    }

    public i p() {
        return this.l;
    }

    public boolean q() {
        return this.k;
    }

    public void r() {
        i();
        WebviewBuilder webviewBuilder = this.h;
        if (webviewBuilder != null) {
            webviewBuilder.i();
            this.h = null;
        }
    }

    public void s() {
        int n = n();
        if (n != 2 && n != 3) {
            LoadingView loadingView = new LoadingView(this.f2930a, this.b.i(), this.b);
            this.e = loadingView;
            this.d.e(loadingView);
            Context context = this.f2930a;
            if (context == null || !(context instanceof Activity) || ((Activity) context).isFinishing()) {
                l.c("DialogController", "showLoading-->error");
                return;
            }
            l.c("DialogController", "showLoading-->Success !");
            try {
                this.d.show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.l = i.SHOW_LOADING;
        }
    }

    public void t() {
        int n = n();
        if (n != 2 && n != 3) {
            this.c.e(this.f);
            Context context = this.f2930a;
            if (context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
                if (!this.c.isShowing()) {
                    com.geetest.sdk.utils.d.c = true;
                    g gVar = this.d;
                    if (gVar != null && gVar.isShowing()) {
                        try {
                            this.c.show();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.l = i.SHOW_WEB;
                } else {
                    this.c.i(this.f);
                }
            }
            com.geetest.sdk.utils.d.c = false;
            l();
        } else if (n() != 2 || q()) {
            this.c.e(this.f);
            Context context2 = this.f2930a;
            if (context2 != null && (context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                if (!this.c.isShowing()) {
                    com.geetest.sdk.utils.d.c = true;
                    try {
                        this.c.show();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    this.l = i.SHOW_WEB;
                } else {
                    this.c.i(this.f);
                }
            }
            com.geetest.sdk.utils.d.c = false;
        } else {
            throw new IllegalArgumentException("Mode configuration error !");
        }
    }

    public void u() {
        try {
            this.d.setOnDismissListener(new g());
            this.l = i.DISMISS;
            int n = n();
            if (n == 2) {
                i();
                b.C0012b bVar = this.i;
                if (bVar != null) {
                    bVar.a();
                }
                GT3ConfigBean gT3ConfigBean = this.b;
                if (gT3ConfigBean != null && gT3ConfigBean.h() != null) {
                    this.b.h().onSuccess("");
                }
            } else if (n != 3) {
                try {
                    this.d.i(new SuccessView(this.f2930a, this, this.b));
                    this.d.show();
                    i();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                i();
                GT3ConfigBean gT3ConfigBean2 = this.b;
                if (gT3ConfigBean2 != null && gT3ConfigBean2.h() != null) {
                    this.b.h().onSuccess("");
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
