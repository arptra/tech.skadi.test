package com.geetest.sdk.dialog.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3ErrorBean;
import com.geetest.sdk.h;
import com.geetest.sdk.model.beans.Gt3GeetestText;
import com.geetest.sdk.model.beans.f;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.utils.o;
import com.honey.account.constant.AccountConstantKt;

public class FailedView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f2914a;
    public View b;
    public TextView c;
    public TextView d;
    public GT3ConfigBean e;
    public int f;
    public int g;
    public int h;
    public Paint i;
    public Path j;
    public RectF k;

    public FailedView(Context context, h hVar, GT3ErrorBean gT3ErrorBean, h.C0013h hVar2, GT3ConfigBean gT3ConfigBean) {
        this(context, (AttributeSet) null, 0, hVar, gT3ErrorBean, hVar2, gT3ConfigBean);
    }

    public final void a() {
        Paint paint = new Paint();
        this.i = paint;
        paint.setColor(0);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setAntiAlias(true);
        this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public final void b(Context context, h hVar, GT3ErrorBean gT3ErrorBean, h.C0013h hVar2, GT3ConfigBean gT3ConfigBean) {
        this.e = gT3ConfigBean;
        a();
        LayoutInflater.from(context).inflate(o.e(context, "gt3_overtime_progressdialog"), this, true);
        this.b = findViewById(o.d(context, "gt3_ot_view3"));
        this.f2914a = (RelativeLayout) findViewById(o.d(context, "gt3_ot_llll"));
        this.c = (TextView) findViewById(o.d(context, "tv_test_geetest_cord"));
        this.d = (TextView) findViewById(o.d(context, "gt3_ot_tv1"));
        if (!TextUtils.isEmpty(gT3ErrorBean.f2897a)) {
            this.c.setText(gT3ErrorBean.f2897a);
        }
        if (TextUtils.isEmpty(gT3ErrorBean.f2897a) || !gT3ErrorBean.f2897a.startsWith(AccountConstantKt.DEFAULT_SEGMENT) || TextUtils.isEmpty(gT3ErrorBean.b)) {
            this.d.setText(Gt3GeetestText.f());
        } else {
            this.d.setText(gT3ErrorBean.b);
        }
        ((TextView) findViewById(o.d(context, "gt3_ot_tvvv"))).setText(Gt3GeetestText.i());
        if (f.b()) {
            this.f2914a.setVisibility(0);
            this.b.setVisibility(0);
        } else {
            this.f2914a.setVisibility(4);
            this.b.setVisibility(4);
        }
        try {
            postDelayed(hVar2, 1200);
            setBackgroundResource(o.a(context, "gt3_dialog_shape"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            canvas.drawPath(this.j, this.i);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f = i2;
        this.g = i3;
        if (this.e != null) {
            this.h = g.b(getContext(), (float) this.e.b());
        }
        this.k = new RectF(0.0f, 0.0f, (float) this.f, (float) this.g);
        Path path = new Path();
        this.j = path;
        path.setFillType(Path.FillType.INVERSE_WINDING);
        Path path2 = this.j;
        RectF rectF = this.k;
        float f2 = (float) this.h;
        path2.addRoundRect(rectF, f2, f2, Path.Direction.CW);
    }

    public FailedView(Context context, AttributeSet attributeSet, int i2, h hVar, GT3ErrorBean gT3ErrorBean, h.C0013h hVar2, GT3ConfigBean gT3ConfigBean) {
        super(context, attributeSet, i2);
        b(context, hVar, gT3ErrorBean, hVar2, gT3ConfigBean);
    }
}
