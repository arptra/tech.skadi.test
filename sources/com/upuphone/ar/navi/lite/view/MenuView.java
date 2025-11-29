package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.R;

public class MenuView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f5826a;

    public MenuView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.menue_item_view_layout, this);
        this.f5826a = (TextView) findViewById(R.id.name);
    }

    public final void b(AttributeSet attributeSet) {
        String str;
        int i = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MenuView);
            str = obtainStyledAttributes.getString(R.styleable.MenuView_menu_name);
            i = obtainStyledAttributes.getResourceId(R.styleable.MenuView_menu_icon, 0);
            obtainStyledAttributes.recycle();
        } else {
            str = "";
        }
        this.f5826a = (TextView) findViewById(R.id.name);
        if (!TextUtils.isEmpty(str)) {
            this.f5826a.setText(str);
        }
        this.f5826a.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(i, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setText(String str) {
        this.f5826a.setText(str);
    }

    public void setTextColor(int i) {
        this.f5826a.setTextColor(i);
    }

    public MenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        b(attributeSet);
    }
}
