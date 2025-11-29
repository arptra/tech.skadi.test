package com.upuphone.ar.navi.lite.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;

public class TravelModeWindow implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f5854a;
    public View b;
    public Activity c;
    public OnClickListener d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;

    public interface OnClickListener {
        void h(View view, int i, String str);

        void y(boolean z);
    }

    public TravelModeWindow(Context context, OnClickListener onClickListener) {
        LayoutInflater from = LayoutInflater.from(context);
        this.d = onClickListener;
        this.c = (Activity) context;
        this.b = from.inflate(R.layout.travel_mode_popwindow, (ViewGroup) null);
        b();
        c();
        a();
    }

    public final void a() {
        d(CSharedPreferences.j(this.c));
    }

    public final void b() {
        TextView textView = (TextView) this.b.findViewById(R.id.travel_mode_walk);
        this.e = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) this.b.findViewById(R.id.travel_mode_drive);
        this.f = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) this.b.findViewById(R.id.travel_mode_ride);
        this.g = textView3;
        textView3.setOnClickListener(this);
        TextView textView4 = (TextView) this.b.findViewById(R.id.menu_cancel);
        this.h = textView4;
        textView4.setOnClickListener(this);
    }

    public final void c() {
        this.f5854a = new PopupWindow(this.b, -2, -2, true);
        this.f5854a.setBackgroundDrawable(new ColorDrawable(0));
        this.b.setOnTouchListener(this);
    }

    public final void d(int i) {
        if (i == 2) {
            this.e.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, this.c.getResources().getDrawable(R.drawable.check_mark, (Resources.Theme) null), (Drawable) null);
            this.f.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.g.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.e.setBackgroundColor(219109589);
            this.f.setBackgroundColor(0);
            this.g.setBackgroundColor(0);
            this.e.setTextColor(-15771435);
            this.f.setTextColor(-1118482);
            this.g.setTextColor(-1118482);
        } else if (i == 0) {
            this.e.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, this.c.getResources().getDrawable(R.drawable.check_mark, (Resources.Theme) null), (Drawable) null);
            this.g.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.e.setTextColor(-1118482);
            this.f.setTextColor(-15771435);
            this.g.setTextColor(-1118482);
        } else if (i == 1) {
            this.e.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.g.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, this.c.getResources().getDrawable(R.drawable.check_mark, (Resources.Theme) null), (Drawable) null);
            this.e.setTextColor(-1118482);
            this.f.setTextColor(-1118482);
            this.g.setTextColor(-15771435);
        }
    }

    public void e() {
        this.f5854a.showAtLocation(((ViewGroup) this.c.findViewById(16908290)).getChildAt(0), 81, 0, 0);
        this.d.y(true);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.travel_mode_walk) {
            this.d.h(view, 2, this.f.getText().toString());
            d(2);
        } else if (view.getId() == R.id.travel_mode_drive) {
            this.d.h(view, 0, this.f.getText().toString());
            d(0);
        } else if (view.getId() == R.id.travel_mode_ride) {
            this.d.h(view, 1, this.f.getText().toString());
            d(1);
        }
        this.d.y(false);
        this.f5854a.dismiss();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int top2 = this.b.findViewById(R.id.pop_layout).getTop();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 1 && y < top2) {
            this.f5854a.dismiss();
        }
        return true;
    }
}
