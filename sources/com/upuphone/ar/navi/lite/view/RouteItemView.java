package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.util.NaviUtil;

public class RouteItemView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f5843a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public int f;
    public int g = 0;

    public RouteItemView(Context context) {
        super(context);
        g(context);
        h();
    }

    private void g(Context context) {
        this.f5843a = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.route_item_view_layout, this);
    }

    private void h() {
        this.b = (TextView) findViewById(R.id.label);
        this.c = (TextView) findViewById(R.id.time);
        this.d = (TextView) findViewById(R.id.distance);
        TextView textView = (TextView) findViewById(R.id.lights);
        this.e = textView;
        textView.setVisibility(NaviUtil.s0() ? 8 : 0);
    }

    public int getNaviMode() {
        return this.g;
    }

    public int getRouteId() {
        return this.f;
    }

    public void setDistance(String str) {
        this.d.setText(str);
    }

    public void setItemSelect(boolean z) {
        if (z) {
            this.f5843a.setBackgroundResource(R.drawable.route_item_selected_bg);
            this.b.setTextColor(getResources().getColor(R.color.text_blue, (Resources.Theme) null));
            this.b.getPaint().setFakeBoldText(true);
            this.c.setTextColor(getResources().getColor(R.color.text_blue, (Resources.Theme) null));
            this.c.getPaint().setFakeBoldText(true);
            this.d.setTextColor(getResources().getColor(R.color.text_blue, (Resources.Theme) null));
            this.d.getPaint().setFakeBoldText(true);
            this.e.setTextColor(getResources().getColor(R.color.text_blue, (Resources.Theme) null));
            this.e.getPaint().setFakeBoldText(true);
            this.e.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.traffic_light_select, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.f5843a.setBackgroundColor(getResources().getColor(17170445, (Resources.Theme) null));
        this.b.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
        this.b.getPaint().setFakeBoldText(false);
        this.c.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
        this.c.getPaint().setFakeBoldText(false);
        this.d.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
        this.d.getPaint().setFakeBoldText(false);
        this.e.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
        this.e.getPaint().setFakeBoldText(false);
        this.e.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.traffic_light_normal, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setLabel(String str) {
        this.b.setText(str);
    }

    public void setLights(String str) {
        this.e.setText(str);
    }

    public void setNaviMode(int i) {
        this.g = i;
    }

    public void setRouteId(int i) {
        this.f = i;
    }

    public void setTime(String str) {
        this.c.setText(str);
    }

    public void setDistance(int i) {
        this.d.setText(i);
    }

    public void setLabel(int i) {
        this.b.setText(i);
    }

    public void setLights(int i) {
        this.e.setText(i);
    }

    public void setTime(int i) {
        this.c.setText(i);
    }

    public RouteItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context);
        h();
    }

    public RouteItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g(context);
        h();
    }
}
