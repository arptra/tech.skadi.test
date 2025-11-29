package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.protocol.NaviInfoBean;
import com.upuphone.ar.navi.lite.util.NaviUtil;

public class NavInfoView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public NextTurnTipView f5827a;
    public TextView b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public TextView f;

    public NavInfoView(Context context) {
        super(context);
        a(context);
        b();
    }

    public final void a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.nav_info_view_layout, this);
    }

    public final void b() {
        this.f5827a = (NextTurnTipView) findViewById(R.id.nextTurnTipView);
        this.b = (TextView) findViewById(R.id.nextRoadName);
        this.c = (TextView) findViewById(R.id.nextRoadDistance);
        this.d = (TextView) findViewById(R.id.distance_unit);
        ImageView imageView = (ImageView) findViewById(R.id.gps_signl_img);
        this.e = imageView;
        int i = 0;
        imageView.setVisibility(NaviUtil.s0() ? 8 : 0);
        TextView textView = (TextView) findViewById(R.id.gps_signl_dep);
        this.f = textView;
        if (NaviUtil.s0()) {
            i = 8;
        }
        textView.setVisibility(i);
        ImageView imageView2 = (ImageView) findViewById(R.id.turn_img);
    }

    public void c(NaviInfoBean naviInfoBean) {
        if (naviInfoBean != null) {
            setNaviInfo(naviInfoBean);
            setGpsInfo(naviInfoBean.getGpsStatus());
        }
    }

    public void setGpsInfo(int i) {
        String str = "";
        if (NaviUtil.s0()) {
            this.e.setImageResource(R.drawable.gps_normal);
            this.f.setText(str);
            return;
        }
        this.e.setImageResource(i == 1 ? R.drawable.gps_normal : R.drawable.gps_weak);
        TextView textView = this.f;
        if (i != 1) {
            str = getContext().getString(R.string.gps_signal_weak);
        }
        textView.setText(str);
    }

    public void setNaviInfo(NaviInfoBean naviInfoBean) {
        this.f5827a.setIconType(naviInfoBean.getIconType());
        this.b.setText(naviInfoBean.getNextRoadName());
        this.b.setFocusable(true);
        this.b.setSelected(true);
        String[] q = NaviUtil.q(getContext(), naviInfoBean.getNextRoadDistance());
        this.c.setText(q[0]);
        this.d.setText(q[1]);
    }

    public NavInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        b();
    }

    public NavInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
        b();
    }
}
