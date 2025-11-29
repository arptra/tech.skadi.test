package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.model.INaviMenu;
import com.upuphone.ar.navi.lite.protocol.NaviInfoBean;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import java.lang.ref.WeakReference;

public class NaviMenuView extends ConstraintLayout implements View.OnClickListener {
    public static final String u = ("NAVI-" + NaviMenuView.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public View f5829a;
    public View b;
    public LinearLayout c;
    public TextView d;
    public ImageView e;
    public LinearLayout f;
    public TextView g;
    public ImageView h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public LinearLayout n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public INaviMenu s;
    public ViewHandler t = null;

    public static class ViewHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference f5830a;

        public ViewHandler(NaviMenuView naviMenuView) {
            this.f5830a = new WeakReference(naviMenuView);
        }

        public void handleMessage(Message message) {
            NaviMenuView naviMenuView = (NaviMenuView) this.f5830a.get();
            if (naviMenuView != null) {
                if (message.what != 200) {
                    CLog.b(NaviMenuView.u, "default  handleMessage");
                } else {
                    naviMenuView.j();
                }
            }
        }
    }

    public NaviMenuView(Context context) {
        super(context);
        h(context);
        this.t = new ViewHandler(this);
    }

    private void h(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.navi_bottom_menu_layout, this);
        this.f5829a = findViewById(R.id.left_line);
        this.b = findViewById(R.id.right_line);
        TextView textView = (TextView) findViewById(R.id.exit);
        this.d = textView;
        textView.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.exitMenu);
        this.c = linearLayout;
        linearLayout.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.exitImg);
        this.e = imageView;
        imageView.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.homeMenu);
        this.f = linearLayout2;
        linearLayout2.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.homeView);
        this.g = textView2;
        textView2.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.homeViewImg);
        this.h = imageView2;
        imageView2.setOnClickListener(this);
        this.i = (LinearLayout) findViewById(R.id.remainInfo);
        this.j = (TextView) findViewById(R.id.remainDistance);
        this.k = (TextView) findViewById(R.id.remainTime);
        TextView textView3 = (TextView) findViewById(R.id.lightCount);
        this.l = textView3;
        int i2 = 0;
        textView3.setVisibility(NaviUtil.s0() ? 8 : 0);
        this.m = (TextView) findViewById(R.id.arrivedTime);
        ImageView imageView3 = (ImageView) findViewById(R.id.lights);
        if (NaviUtil.s0()) {
            i2 = 8;
        }
        imageView3.setVisibility(i2);
        this.n = (LinearLayout) findViewById(R.id.exitNaviLayout);
        TextView textView4 = (TextView) findViewById(R.id.exitNavi);
        this.o = textView4;
        textView4.setOnClickListener(this);
        TextView textView5 = (TextView) findViewById(R.id.cancelNavi);
        this.p = textView5;
        textView5.setOnClickListener(this);
        TextView textView6 = (TextView) findViewById(R.id.continueNavi);
        this.q = textView6;
        textView6.setOnClickListener(this);
        this.r = (TextView) findViewById(R.id.naviComplete);
    }

    private void setNaviContinueVisible(Boolean bool) {
        this.q.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    private void setNaviExitVisible(Boolean bool) {
        this.n.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    private void setNaviInfoAllVisible(Boolean bool) {
        int i2 = 8;
        this.f5829a.setVisibility(bool.booleanValue() ? 0 : 8);
        this.b.setVisibility(bool.booleanValue() ? 0 : 8);
        this.c.setVisibility(bool.booleanValue() ? 0 : 8);
        this.d.setVisibility(bool.booleanValue() ? 0 : 8);
        this.e.setVisibility(bool.booleanValue() ? 0 : 8);
        this.f.setVisibility(bool.booleanValue() ? 0 : 8);
        this.g.setVisibility(bool.booleanValue() ? 0 : 8);
        this.h.setVisibility(bool.booleanValue() ? 0 : 8);
        this.i.setVisibility(bool.booleanValue() ? 0 : 8);
        TextView textView = this.m;
        if (bool.booleanValue()) {
            i2 = 0;
        }
        textView.setVisibility(i2);
    }

    private void setNaviInfoVisible(Boolean bool) {
        int i2 = 8;
        this.i.setVisibility(bool.booleanValue() ? 0 : 8);
        TextView textView = this.m;
        if (bool.booleanValue()) {
            i2 = 0;
        }
        textView.setVisibility(i2);
    }

    public TextView getCancelNavi() {
        return this.p;
    }

    public LinearLayout getExitMenu() {
        return this.c;
    }

    public INaviMenu getNaviMenu() {
        return this.s;
    }

    public void i() {
        this.r.setVisibility(8);
    }

    public void j() {
        this.t.removeMessages(200);
        Boolean bool = Boolean.TRUE;
        setNaviInfoAllVisible(bool);
        setNaviInfoVisible(bool);
        Boolean bool2 = Boolean.FALSE;
        setNaviContinueVisible(bool2);
        setNaviExitVisible(bool2);
    }

    public void k() {
        this.t.removeMessages(200);
        Boolean bool = Boolean.FALSE;
        setNaviInfoAllVisible(bool);
        setNaviContinueVisible(bool);
        setNaviExitVisible(bool);
        this.r.setVisibility(0);
    }

    public void l(NaviInfoBean naviInfoBean, int i2) {
        this.j.setText(NaviUtil.r(getContext(), naviInfoBean.getPathRetainDistance()));
        this.k.setText(NaviUtil.s(getContext(), naviInfoBean.getPathRemainTime()));
        long currentTimeMillis = System.currentTimeMillis() + (((long) naviInfoBean.getPathRemainTime()) * 1000);
        this.m.setText(NaviUtil.G(currentTimeMillis) + getContext().getString(R.string.arrive));
        if (i2 == 0) {
            this.m.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.car_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (i2 == 1) {
            this.m.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.bike_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (i2 == 2) {
            this.m.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.walk_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        TextView textView = this.l;
        textView.setText(naviInfoBean.getRouteRemainLightCount() + "");
    }

    public void onClick(View view) {
        INaviMenu iNaviMenu;
        int id = view.getId();
        if (id == R.id.exit || id == R.id.exitImg || id == R.id.exitMenu) {
            Boolean bool = Boolean.FALSE;
            setNaviInfoAllVisible(bool);
            setNaviContinueVisible(bool);
            setNaviExitVisible(Boolean.TRUE);
            this.t.sendEmptyMessageDelayed(200, 8000);
        } else if (id == R.id.exitNavi) {
            INaviMenu iNaviMenu2 = this.s;
            if (iNaviMenu2 != null) {
                iNaviMenu2.L();
            }
        } else if (id == R.id.cancelNavi) {
            j();
        } else if (id == R.id.continueNavi) {
            setNaviInfoAllVisible(Boolean.TRUE);
            Boolean bool2 = Boolean.FALSE;
            setNaviContinueVisible(bool2);
            setNaviExitVisible(bool2);
        } else if ((id == R.id.homeView || id == R.id.homeViewImg || id == R.id.homeMenu) && (iNaviMenu = this.s) != null) {
            iNaviMenu.Q();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CLog.b(u, " onDetachedFromWindow");
        this.t.removeMessages(200);
    }

    public void setCancelNavi(TextView textView) {
        this.p = textView;
    }

    public void setExitMenu(LinearLayout linearLayout) {
        this.c = linearLayout;
    }

    public void setNaviMenu(INaviMenu iNaviMenu) {
        this.s = iNaviMenu;
    }

    public NaviMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(context);
        this.t = new ViewHandler(this);
    }
}
