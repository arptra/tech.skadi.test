package com.upuphone.ar.navi.lite.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.util.DensityUtils;

public class CarEditPopMenu implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f5818a;
    public View b;
    public Activity c;
    public OnClickListener d;
    public TextView e;
    public TextView f;

    public interface OnClickListener {
        void f(boolean z);

        void g(View view, int i);
    }

    public CarEditPopMenu(Context context, OnClickListener onClickListener) {
        LayoutInflater from = LayoutInflater.from(context);
        this.d = onClickListener;
        this.c = (Activity) context;
        this.b = from.inflate(R.layout.car_manager_pop_menu_layout, (ViewGroup) null);
        a();
        b();
    }

    public final void a() {
        TextView textView = (TextView) this.b.findViewById(R.id.carInfoModify);
        this.e = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) this.b.findViewById(R.id.carInfoDelete);
        this.f = textView2;
        textView2.setOnClickListener(this);
    }

    public final void b() {
        this.f5818a = new PopupWindow(this.b, DensityUtils.a(this.c, 80.0f), DensityUtils.a(this.c, 108.0f), true);
        this.f5818a.setBackgroundDrawable(new ColorDrawable(0));
        this.b.setOnTouchListener(this);
    }

    public void c(View view, int i) {
        this.f5818a.showAsDropDown(view, ((ViewGroup) this.c.findViewById(16908290)).getChildAt(0).getWidth() - DensityUtils.a(this.c, 170.0f), -i);
        this.d.f(true);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.carInfoModify) {
            this.d.g(view, 0);
            this.d.f(true);
        } else if (view.getId() == R.id.carInfoDelete) {
            this.d.g(view, 1);
            this.d.f(true);
        } else {
            this.d.f(false);
        }
        this.f5818a.dismiss();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int top2 = this.b.findViewById(R.id.pop_layout).getTop();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 1 && y < top2) {
            this.f5818a.dismiss();
        }
        return true;
    }
}
