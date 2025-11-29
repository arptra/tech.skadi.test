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
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3LoadImageView;
import com.geetest.sdk.model.beans.Gt3GeetestText;
import com.geetest.sdk.model.beans.e;
import com.geetest.sdk.model.beans.f;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.o;
import com.geetest.sdk.views.GT3GifView;

public class LoadingView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f2917a;
    public Paint b;
    public Path c;

    public LoadingView(Context context, GT3LoadImageView gT3LoadImageView, GT3ConfigBean gT3ConfigBean) {
        this(context, (AttributeSet) null, 0, gT3LoadImageView, gT3ConfigBean);
    }

    public final int a(int i) {
        if (i == -2) {
            return -2;
        }
        return g.b(getContext(), (float) i);
    }

    public final void b() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(0);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setAntiAlias(true);
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public final void c(Context context, GT3LoadImageView gT3LoadImageView, GT3ConfigBean gT3ConfigBean) {
        this.f2917a = gT3ConfigBean.b();
        b();
        LayoutInflater.from(context).inflate(o.e(context, "gt3_wait_progressdialog"), this, true);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(o.d(context, "gt3_wait_ll"));
        FrameLayout frameLayout = (FrameLayout) findViewById(o.d(context, "gt3_wait_iv"));
        if (gT3LoadImageView == null) {
            GT3GifView gT3GifView = new GT3GifView(context);
            int a2 = new e().a();
            if (a2 != 0) {
                gT3GifView.setGifResource(a2);
            } else {
                gT3GifView.setGifResource(o.a(context, "gt3_new_bind_logo"));
            }
            gT3GifView.a();
            frameLayout.addView(gT3GifView, new FrameLayout.LayoutParams(g.b(context, 24.0f), g.b(context, 24.0f)));
            l.c("LoadingView", "custom view is null");
        } else if (gT3LoadImageView.b()) {
            GT3GifView gT3GifView2 = new GT3GifView(context);
            gT3GifView2.setGifResource(gT3LoadImageView.getIconRes());
            gT3GifView2.a();
            frameLayout.addView(gT3GifView2, new FrameLayout.LayoutParams(a(gT3LoadImageView.getLoadViewWidth()), a(gT3LoadImageView.getLoadViewHeight())));
            l.c("LoadingView", "custom gif res");
        } else {
            gT3LoadImageView.a();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(gT3LoadImageView.getLoadViewWidth()), a(gT3LoadImageView.getLoadViewHeight()));
            if (gT3LoadImageView.getParent() != null) {
                ((ViewGroup) gT3LoadImageView.getParent()).removeView(gT3LoadImageView);
            }
            frameLayout.addView(gT3LoadImageView, layoutParams);
            l.c("LoadingView", "custom view");
        }
        ((TextView) findViewById(o.d(context, "gt3_wait_tv2"))).setText(Gt3GeetestText.c());
        ((TextView) findViewById(o.d(context, "gt3_wait_tvvv"))).setText(Gt3GeetestText.i());
        View findViewById = findViewById(o.d(context, "gt3_wait_view1"));
        if (f.b()) {
            relativeLayout.setVisibility(0);
            findViewById.setVisibility(0);
        } else {
            relativeLayout.setVisibility(4);
            findViewById.setVisibility(4);
        }
        try {
            setBackgroundResource(o.a(context, "gt3_dialog_shape"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.c, this.b);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int b2 = g.b(getContext(), (float) this.f2917a);
        RectF rectF = new RectF(0.0f, 0.0f, (float) i, (float) i2);
        Path path = new Path();
        this.c = path;
        path.setFillType(Path.FillType.INVERSE_WINDING);
        float f = (float) b2;
        this.c.addRoundRect(rectF, f, f, Path.Direction.CW);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i, GT3LoadImageView gT3LoadImageView, GT3ConfigBean gT3ConfigBean) {
        super(context, attributeSet, i);
        c(context, gT3LoadImageView, gT3ConfigBean);
    }
}
