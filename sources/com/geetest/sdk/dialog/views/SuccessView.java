package com.geetest.sdk.dialog.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.h;
import com.geetest.sdk.model.beans.Gt3GeetestText;
import com.geetest.sdk.model.beans.f;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.utils.o;
import com.geetest.sdk.views.GT3View;

public class SuccessView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f2918a;
    public View b;
    public GT3ConfigBean c;
    public int d;
    public int e;
    public int f;
    public Paint g;
    public Path h;
    public RectF i;

    public class a implements GT3View.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f2919a;

        public a(SuccessView successView, h hVar) {
            this.f2919a = hVar;
        }

        public void a() {
            h hVar = this.f2919a;
            if (hVar != null) {
                hVar.l();
            }
        }
    }

    public SuccessView(Context context, h hVar, GT3ConfigBean gT3ConfigBean) {
        this(context, (AttributeSet) null, 0, hVar, gT3ConfigBean);
    }

    public final void a() {
        Paint paint = new Paint();
        this.g = paint;
        paint.setColor(0);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setAntiAlias(true);
        this.g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public final void b(Context context, h hVar, GT3ConfigBean gT3ConfigBean) {
        this.c = gT3ConfigBean;
        a();
        LayoutInflater.from(context).inflate(o.e(context, "gt3_success_progressdialog"), this, true);
        this.b = findViewById(o.d(context, "gt3_success_view2"));
        this.f2918a = (RelativeLayout) findViewById(o.d(context, "gt3_success_lll"));
        ((TextView) findViewById(o.d(context, "gt3_success_tv1"))).setText(Gt3GeetestText.g());
        ((TextView) findViewById(o.d(context, "gt3_success_tvvv"))).setText(Gt3GeetestText.i());
        if (f.b()) {
            this.f2918a.setVisibility(0);
            this.b.setVisibility(0);
        } else {
            this.f2918a.setVisibility(4);
            this.b.setVisibility(4);
        }
        GT3View gT3View = (GT3View) findViewById(o.d(context, "gt3_success_iv"));
        gT3View.b();
        gT3View.setGtListener(new a(this, hVar));
        try {
            setBackgroundResource(o.a(context, "gt3_dialog_shape"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            canvas.drawPath(this.h, this.g);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        try {
            super.onSizeChanged(i2, i3, i4, i5);
            this.d = i2;
            this.e = i3;
            if (this.c != null) {
                this.f = g.b(getContext(), (float) this.c.b());
            }
            this.i = new RectF(0.0f, 0.0f, (float) this.d, (float) this.e);
            Path path = new Path();
            this.h = path;
            path.setFillType(Path.FillType.INVERSE_WINDING);
            Path path2 = this.h;
            RectF rectF = this.i;
            int i6 = this.f;
            path2.addRoundRect(rectF, (float) i6, (float) i6, Path.Direction.CW);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public SuccessView(Context context, AttributeSet attributeSet, int i2, h hVar, GT3ConfigBean gT3ConfigBean) {
        super(context, attributeSet, i2);
        b(context, hVar, gT3ConfigBean);
    }
}
