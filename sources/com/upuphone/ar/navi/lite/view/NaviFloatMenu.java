package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;

public class NaviFloatMenu extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TextView f5828a;
    public TextView b;
    public TextView c;
    public INaviFloatMenu d;

    public interface INaviFloatMenu {
        void O(TextView textView);

        void S(TextView textView);

        void j(TextView textView);
    }

    public NaviFloatMenu(Context context) {
        super(context);
        a(context);
        b();
    }

    public final void a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.navi_float_menu_layout, this);
        TextView textView = (TextView) findViewById(R.id.menu_tts_play);
        this.f5828a = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.menu_refresh);
        this.b = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) findViewById(R.id.menu_settings);
        this.c = textView3;
        textView3.setOnClickListener(this);
    }

    public final void b() {
        boolean m = CSharedPreferences.m(getContext().getApplicationContext());
        Drawable drawable = getContext().getDrawable(m ? R.drawable.ic_volume_on : R.drawable.ic_volume_off);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.f5828a.setCompoundDrawablesRelative((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        this.f5828a.setText(m ? R.string.open_tts_broadcast : R.string.close_tts_broadcast);
        this.f5828a.setTextColor(getContext().getColor(m ? R.color.broadcast_color : R.color.not_network_color));
    }

    public TextView getMenuTtsPlay() {
        return this.f5828a;
    }

    public INaviFloatMenu getNaviFloatMenuListener() {
        return this.d;
    }

    public void onClick(View view) {
        INaviFloatMenu iNaviFloatMenu;
        int id = view.getId();
        if (id == R.id.menu_tts_play) {
            INaviFloatMenu iNaviFloatMenu2 = this.d;
            if (iNaviFloatMenu2 != null) {
                iNaviFloatMenu2.O(this.f5828a);
            }
        } else if (id == R.id.menu_refresh) {
            INaviFloatMenu iNaviFloatMenu3 = this.d;
            if (iNaviFloatMenu3 != null) {
                iNaviFloatMenu3.S(this.b);
            }
        } else if (id == R.id.menu_settings && (iNaviFloatMenu = this.d) != null) {
            iNaviFloatMenu.j(this.c);
        }
    }

    public void setMenuTtsPlay(TextView textView) {
        this.f5828a = textView;
    }

    public void setNaviFloatMenuListener(INaviFloatMenu iNaviFloatMenu) {
        this.d = iNaviFloatMenu;
    }

    public NaviFloatMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        b();
    }
}
