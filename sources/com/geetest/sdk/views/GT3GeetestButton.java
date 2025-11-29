package com.geetest.sdk.views;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.geetest.sdk.GT3GeetestUtils;
import com.geetest.sdk.NoProguard;
import com.geetest.sdk.b;
import com.geetest.sdk.model.beans.GT3ViewColor;
import com.geetest.sdk.model.beans.Gt3GeetestText;
import com.geetest.sdk.model.beans.d;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.utils.o;
import com.geetest.sdk.utils.p;
import com.honey.account.constant.AccountConstantKt;
import java.util.ArrayList;

public class GT3GeetestButton extends LinearLayout implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public GT3GeetestView f2975a;
    public TextView b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public Context f;
    public GT3GeetestUtils g;
    public boolean h = true;
    public b i;
    public boolean j = true;
    public boolean k = false;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;

    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f2976a;

        public a(GT3GeetestButton gT3GeetestButton, Context context) {
            this.f2976a = context;
        }

        public void onClick(View view) {
            try {
                this.f2976a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.geetest.com/first_page")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements b.C0012b {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                GT3GeetestButton.this.f2975a.f();
                GT3GeetestButton.this.f2975a.g();
                GT3GeetestButton gT3GeetestButton = GT3GeetestButton.this;
                gT3GeetestButton.setBackgroundResource(o.a(gT3GeetestButton.f, "gt3_lin_click_shape"));
                if (GT3GeetestButton.this.m) {
                    GT3GeetestButton.this.e.setImageResource(o.f(GT3GeetestButton.this.f, "gt3logogray"));
                }
                GT3GeetestButton.this.b.setText(Gt3GeetestText.e());
                GT3GeetestButton.this.b.setTextColor(-13092808);
                GT3GeetestButton.this.b.setAlpha(1.0f);
            }
        }

        /* renamed from: com.geetest.sdk.views.GT3GeetestButton$b$b  reason: collision with other inner class name */
        public class C0015b implements Runnable {
            public C0015b() {
            }

            public void run() {
                GT3GeetestButton gT3GeetestButton = GT3GeetestButton.this;
                gT3GeetestButton.setBackgroundResource(o.a(gT3GeetestButton.f, "gt3_lin_click_shape"));
                if (GT3GeetestButton.this.m) {
                    GT3GeetestButton.this.e.setImageResource(o.f(GT3GeetestButton.this.f, "gt3logogray"));
                }
                GT3GeetestButton.this.b.setText(Gt3GeetestText.e());
                GT3GeetestButton.this.b.setTextColor(-13092808);
                GT3GeetestButton.this.b.setAlpha(1.0f);
                GT3GeetestButton.this.f2975a.h();
            }
        }

        public class c implements Runnable {
            public c() {
            }

            public void run() {
                GT3GeetestButton.this.f2975a.j();
                GT3GeetestButton gT3GeetestButton = GT3GeetestButton.this;
                gT3GeetestButton.setBackgroundResource(o.a(gT3GeetestButton.f, "gt3_lin_bg_shape"));
                if (GT3GeetestButton.this.m) {
                    GT3GeetestButton.this.e.setImageResource(o.f(GT3GeetestButton.this.f, "gt3logogray"));
                }
                GT3GeetestButton.this.b.setText(Gt3GeetestText.a());
                GT3GeetestButton.this.b.setTextColor(-13092808);
                GT3GeetestButton.this.b.setAlpha(1.0f);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            public void run() {
                GT3GeetestButton.this.f2975a.i();
                GT3GeetestButton gT3GeetestButton = GT3GeetestButton.this;
                gT3GeetestButton.setBackgroundResource(o.a(gT3GeetestButton.f, "gt3_lin_wait_shape"));
                GT3GeetestButton.this.b.setTextColor(-6842473);
                GT3GeetestButton.this.b.setText(Gt3GeetestText.k());
                GT3GeetestButton.this.b.setAlpha(1.0f);
            }
        }

        public class e implements Runnable {
            public e() {
            }

            public void run() {
                GT3GeetestButton.this.f2975a.k();
                GT3GeetestButton gT3GeetestButton = GT3GeetestButton.this;
                gT3GeetestButton.setBackgroundResource(o.a(gT3GeetestButton.f, "gt3_lin_success_shape"));
                GT3GeetestButton.this.b.setText(Gt3GeetestText.h());
                GT3GeetestButton.this.b.setTextColor(-15162286);
                GT3GeetestButton.this.b.setAlpha(1.0f);
                if (GT3GeetestButton.this.m) {
                    GT3GeetestButton.this.e.setImageResource(o.f(GT3GeetestButton.this.f, "gt3logogreen"));
                }
                boolean unused = GT3GeetestButton.this.j = true;
                GT3GeetestButton.this.c.setVisibility(8);
            }
        }

        public class f implements Runnable {
            public f() {
            }

            public void run() {
                GT3GeetestButton.this.f2975a.h();
                GT3GeetestButton gT3GeetestButton = GT3GeetestButton.this;
                gT3GeetestButton.setBackgroundResource(o.a(gT3GeetestButton.f, "gt3_lin_click_shape"));
                if (GT3GeetestButton.this.m) {
                    GT3GeetestButton.this.e.setImageResource(o.f(GT3GeetestButton.this.f, "gt3logogray"));
                }
                GT3GeetestButton.this.b.setText(Gt3GeetestText.e());
                GT3GeetestButton.this.b.setTextColor(-13092808);
                GT3GeetestButton.this.b.setAlpha(1.0f);
                boolean unused = GT3GeetestButton.this.j = true;
            }
        }

        public class g implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f2984a;
            public final /* synthetic */ String b;

            public g(String str, String str2) {
                this.f2984a = str;
                this.b = str2;
            }

            public void run() {
                GT3GeetestButton.this.f2975a.e();
                GT3GeetestButton gT3GeetestButton = GT3GeetestButton.this;
                gT3GeetestButton.setBackgroundResource(o.a(gT3GeetestButton.f, "gt3_lin_file_shape"));
                if (GT3GeetestButton.this.m) {
                    GT3GeetestButton.this.e.setImageResource(o.f(GT3GeetestButton.this.f, "gt3logogray"));
                }
                GT3GeetestButton.this.d.setText(this.f2984a);
                GT3GeetestButton.this.d.setVisibility(0);
                if (!TextUtils.isEmpty(this.f2984a) && this.f2984a.startsWith(AccountConstantKt.DEFAULT_SEGMENT) && !TextUtils.isEmpty(this.b)) {
                    GT3GeetestButton.this.b.setText(this.b);
                } else if (TextUtils.equals("", this.f2984a)) {
                    GT3GeetestButton.this.b.setText(this.b);
                } else {
                    GT3GeetestButton.this.b.setText(Gt3GeetestText.f());
                }
                GT3GeetestButton.this.c.setVisibility(0);
                GT3GeetestButton.this.c.setText(Gt3GeetestText.j());
                GT3GeetestButton.this.b.setTextColor(-10395295);
                GT3GeetestButton.this.b.setAlpha(1.0f);
                boolean unused = GT3GeetestButton.this.j = true;
            }
        }

        public class h implements Runnable {
            public h() {
            }

            public void run() {
                GT3GeetestButton.this.e.setClickable(true);
            }
        }

        public class i implements Runnable {
            public i() {
            }

            public void run() {
                GT3GeetestButton.this.e.setClickable(false);
            }
        }

        public b() {
        }

        public void a() {
            boolean unused = GT3GeetestButton.this.o = true;
            if (!GT3GeetestButton.q(GT3GeetestButton.this.f).isFinishing() && GT3GeetestButton.this.f != null) {
                GT3GeetestButton.q(GT3GeetestButton.this.f).runOnUiThread(new e());
            }
        }

        public void b() {
            boolean unused = GT3GeetestButton.this.m = true;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                GT3GeetestButton.this.e.setClickable(true);
            } else if (!GT3GeetestButton.q(GT3GeetestButton.this.f).isFinishing() && GT3GeetestButton.this.f != null) {
                GT3GeetestButton.q(GT3GeetestButton.this.f).runOnUiThread(new h());
            }
        }

        public void c() {
            if (!GT3GeetestButton.q(GT3GeetestButton.this.f).isFinishing() && GT3GeetestButton.this.f != null) {
                GT3GeetestButton.q(GT3GeetestButton.this.f).runOnUiThread(new d());
            }
        }

        public void d() {
            boolean unused = GT3GeetestButton.this.o = false;
            boolean unused2 = GT3GeetestButton.this.k = false;
            if (!GT3GeetestButton.q(GT3GeetestButton.this.f).isFinishing() && GT3GeetestButton.this.f != null) {
                GT3GeetestButton.q(GT3GeetestButton.this.f).runOnUiThread(new c());
            }
        }

        public void e(String str, String str2) {
            boolean unused = GT3GeetestButton.this.n = true;
            boolean unused2 = GT3GeetestButton.this.o = true;
            if (!GT3GeetestButton.q(GT3GeetestButton.this.f).isFinishing() && GT3GeetestButton.this.f != null) {
                GT3GeetestButton.q(GT3GeetestButton.this.f).runOnUiThread(new g(str2, str));
            }
        }

        public void f() {
            boolean unused = GT3GeetestButton.this.n = true;
            boolean unused2 = GT3GeetestButton.this.k = true;
            boolean unused3 = GT3GeetestButton.this.l = true;
        }

        public void g() {
            boolean unused = GT3GeetestButton.this.m = false;
            if (!GT3GeetestButton.q(GT3GeetestButton.this.f).isFinishing() && GT3GeetestButton.this.f != null) {
                GT3GeetestButton.q(GT3GeetestButton.this.f).runOnUiThread(new i());
            }
        }

        public void h() {
            boolean unused = GT3GeetestButton.this.n = true;
            boolean unused2 = GT3GeetestButton.this.o = true;
        }

        public void i() {
            boolean unused = GT3GeetestButton.this.n = false;
        }

        public void j() {
            if (!GT3GeetestButton.q(GT3GeetestButton.this.f).isFinishing() && GT3GeetestButton.this.f != null) {
                GT3GeetestButton.q(GT3GeetestButton.this.f).runOnUiThread(new f());
            }
        }

        public void k() {
            boolean unused = GT3GeetestButton.this.n = true;
            if (GT3GeetestButton.this.h) {
                boolean unused2 = GT3GeetestButton.this.k = false;
                if (!GT3GeetestButton.q(GT3GeetestButton.this.f).isFinishing() && GT3GeetestButton.this.f != null) {
                    GT3GeetestButton.q(GT3GeetestButton.this.f).runOnUiThread(new a());
                    return;
                }
                return;
            }
            boolean unused3 = GT3GeetestButton.this.k = false;
            if (!GT3GeetestButton.q(GT3GeetestButton.this.f).isFinishing() && GT3GeetestButton.this.f != null) {
                GT3GeetestButton.q(GT3GeetestButton.this.f).runOnUiThread(new C0015b());
            }
        }
    }

    public GT3GeetestButton(Context context) {
        super(context);
        new ArrayList();
        p(context);
    }

    public static Activity q(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return q(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public void onDraw(Canvas canvas) {
        int b2 = g.b(this.f, (float) new d().b());
        postInvalidate();
        super.onDraw(canvas);
        if (!p.a(this.f)) {
            this.f2975a.e();
            setBackgroundResource(o.a(this.f, "gt3_lin_file_shape"));
            if (this.m) {
                this.e.setImageResource(o.f(this.f, "gt3logogray"));
            }
            this.b.setText(Gt3GeetestText.d());
            this.d.setText("201");
            this.d.setVisibility(0);
            this.c.setVisibility(0);
            this.c.setText(Gt3GeetestText.j());
            this.b.setTextColor(-13092808);
            this.b.setAlpha(1.0f);
        }
        if (this.k) {
            Path path = new Path();
            Paint paint = new Paint(1536);
            paint.setAntiAlias(true);
            paint.setColor(new GT3ViewColor().b());
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(1.0f);
            path.moveTo((float) (getWidth() - b2), 0.0f);
            path.lineTo((float) getWidth(), 0.0f);
            path.lineTo((float) getWidth(), (float) b2);
            path.close();
            canvas.drawPath(path, paint);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.j) {
            this.j = false;
            this.d.setVisibility(8);
            this.c.setText(Gt3GeetestText.j());
            this.c.setVisibility(8);
            try {
                GT3GeetestUtils gT3GeetestUtils = this.g;
                if (gT3GeetestUtils != null) {
                    gT3GeetestUtils.c().d().e(true);
                    this.g.c().d().n();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p(Context context) {
        this.f = context;
        if (TextUtils.isEmpty(Gt3GeetestText.a())) {
            Gt3GeetestText.l(context);
        }
        View inflate = ((LayoutInflater) context.getApplicationContext().getSystemService("layout_inflater")).inflate(o.e(context, "gt3_ll_geetest_view"), this);
        this.f2975a = (GT3GeetestView) inflate.findViewById(o.d(context, "geetest_view"));
        this.c = (TextView) inflate.findViewById(o.d(context, "tv_test_geetest_cof"));
        this.d = (TextView) inflate.findViewById(o.d(context, "tv_test_geetest_cord"));
        this.b = (TextView) inflate.findViewById(o.d(context, "tv_test_geetest"));
        ImageView imageView = (ImageView) inflate.findViewById(o.d(context, "iv_geetest_logo"));
        this.e = imageView;
        imageView.setOnClickListener(new a(this, context));
        this.f2975a.b();
        setBackgroundResource(o.a(context, "gt3_lin_bg_shape"));
        b bVar = new b();
        this.i = bVar;
        bVar.k();
    }

    public void setGeetestUtils(GT3GeetestUtils gT3GeetestUtils) {
        this.g = gT3GeetestUtils;
        gT3GeetestUtils.c().d().c(this.i);
    }

    public GT3GeetestButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new ArrayList();
        p(context);
    }

    public GT3GeetestButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new ArrayList();
        p(context);
    }
}
