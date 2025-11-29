package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.honey.account.o4.n;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import org.slf4j.Marker;

public class NaviStrategyView extends LinearLayout implements View.OnClickListener {
    public static final String i = ("NAVI-" + NaviStrategyView.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public StrategyButton f5834a;
    public StrategyButton b;
    public StrategyButton c;
    public StrategyButton d;
    public StrategyButton e;
    public StrategyButton f;
    public StrategyButton g;
    public StrategyChangeListener h;

    public interface StrategyChangeListener {
        void r();

        void y(int i);
    }

    public NaviStrategyView(Context context) {
        super(context);
        d(context);
        f();
        e();
    }

    private int getStrategySelect() {
        if (this.f5834a.isSelected()) {
            return 10;
        }
        if (this.b.isSelected()) {
            if (this.c.isSelected()) {
                return 20;
            }
            if (this.d.isSelected()) {
                return this.e.isSelected() ? 18 : 15;
            }
            if (this.e.isSelected()) {
                return 17;
            }
            if (this.f.isSelected()) {
                return 1011;
            }
            if (this.g.isSelected()) {
                return MSG.MSG_TELEPHONE_TRANS_LANGUAGE_NOT_SUPPORT;
            }
            String str = i;
            CLog.b(str, "getStrategySelect  avoidCongestion.isSelected() " + this.b.isSelected());
            return 1014;
        } else if (this.c.isSelected()) {
            return 19;
        } else {
            if (this.d.isSelected()) {
                return this.e.isSelected() ? 16 : 13;
            }
            if (this.e.isSelected()) {
                return 14;
            }
            return this.f.isSelected() ? MSG.MSG_GLASS_SCREEN_STATE : this.g.isSelected() ? 4 : 10;
        }
    }

    public final void b() {
        if (!this.b.isSelected() && !this.c.isSelected() && !this.d.isSelected() && !this.e.isSelected() && !this.f.isSelected() && !this.g.isSelected()) {
            this.f5834a.setSelect(true);
        }
    }

    public final void c() {
        StrategyChangeListener strategyChangeListener = this.h;
        if (strategyChangeListener != null) {
            strategyChangeListener.r();
        }
        setVisibility(8);
    }

    public final void d(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.navi_strategy_view_layout, this);
    }

    public final void e() {
        int f2 = CSharedPreferences.f(getContext(), "navi_strategy", 10);
        String str = i;
        CLog.b(str, "setInitSelection  strategy:" + f2);
        if (f2 == 10) {
            this.f5834a.setSelect(true);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_s, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(false);
            this.c.setSelect(false);
            this.d.setSelect(false);
            this.e.setSelect(false);
            this.f.setSelect(false);
            this.g.setSelect(false);
        } else if (f2 == 20) {
            this.f5834a.setSelect(false);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(true);
            this.c.setSelect(true);
            this.d.setSelect(false);
            this.e.setSelect(false);
            this.f.setSelect(false);
            this.g.setSelect(false);
        } else if (f2 == 18) {
            this.f5834a.setSelect(false);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(true);
            this.c.setSelect(false);
            this.d.setSelect(true);
            this.e.setSelect(true);
            this.f.setSelect(false);
            this.g.setSelect(false);
        } else if (f2 == 15) {
            this.f5834a.setSelect(false);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(true);
            this.c.setSelect(false);
            this.d.setSelect(true);
            this.e.setSelect(false);
            this.f.setSelect(false);
            this.g.setSelect(false);
        } else if (f2 == 17) {
            this.f5834a.setSelect(false);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(true);
            this.c.setSelect(false);
            this.d.setSelect(false);
            this.e.setSelect(true);
            this.f.setSelect(false);
            this.g.setSelect(false);
        } else if (f2 == 1011) {
            this.f5834a.setSelect(false);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(true);
            this.c.setSelect(false);
            this.d.setSelect(false);
            this.e.setSelect(false);
            this.f.setSelect(true);
            this.g.setSelect(false);
        } else if (f2 == 1012) {
            this.f5834a.setSelect(false);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(true);
            this.c.setSelect(false);
            this.d.setSelect(false);
            this.e.setSelect(false);
            this.f.setSelect(false);
            this.g.setSelect(true);
        } else if (f2 == 19) {
            this.f5834a.setSelect(false);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(false);
            this.c.setSelect(true);
            this.d.setSelect(false);
            this.e.setSelect(false);
            this.f.setSelect(false);
            this.g.setSelect(false);
        } else if (f2 == 16) {
            this.f5834a.setSelect(false);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(false);
            this.c.setSelect(false);
            this.d.setSelect(true);
            this.e.setSelect(true);
            this.f.setSelect(false);
            this.g.setSelect(false);
        } else if (f2 == 13) {
            this.f5834a.setSelect(false);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(false);
            this.c.setSelect(false);
            this.d.setSelect(true);
            this.e.setSelect(false);
            this.f.setSelect(false);
            this.g.setSelect(false);
        } else if (f2 == 14) {
            this.f5834a.setSelect(false);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(false);
            this.c.setSelect(false);
            this.d.setSelect(false);
            this.e.setSelect(true);
            this.f.setSelect(false);
            this.g.setSelect(false);
        } else if (f2 == 1013) {
            this.f5834a.setSelect(false);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(false);
            this.c.setSelect(false);
            this.d.setSelect(false);
            this.e.setSelect(false);
            this.f.setSelect(true);
            this.g.setSelect(false);
        } else if (f2 == 1014) {
            this.f5834a.setSelect(false);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(true);
            this.c.setSelect(false);
            this.d.setSelect(false);
            this.e.setSelect(false);
            this.f.setSelect(false);
            this.g.setSelect(false);
        } else if (f2 == 4) {
            this.f5834a.setSelect(false);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(false);
            this.c.setSelect(false);
            this.d.setSelect(false);
            this.e.setSelect(false);
            this.f.setSelect(false);
            this.g.setSelect(true);
        }
    }

    public final void f() {
        ((TextView) findViewById(R.id.route_preference)).setOnClickListener(new n(this));
        StrategyButton strategyButton = (StrategyButton) findViewById(R.id.recommend);
        this.f5834a = strategyButton;
        strategyButton.setOnClickListener(this);
        StrategyButton strategyButton2 = (StrategyButton) findViewById(R.id.avoid_congestion);
        this.b = strategyButton2;
        strategyButton2.setOnClickListener(this);
        StrategyButton strategyButton3 = (StrategyButton) findViewById(R.id.high_speed_priority);
        this.c = strategyButton3;
        strategyButton3.setOnClickListener(this);
        StrategyButton strategyButton4 = (StrategyButton) findViewById(R.id.no_high_speed);
        this.d = strategyButton4;
        strategyButton4.setOnClickListener(this);
        StrategyButton strategyButton5 = (StrategyButton) findViewById(R.id.low_fees);
        this.e = strategyButton5;
        strategyButton5.setOnClickListener(this);
        StrategyButton strategyButton6 = (StrategyButton) findViewById(R.id.road_priority);
        this.f = strategyButton6;
        strategyButton6.setOnClickListener(this);
        StrategyButton strategyButton7 = (StrategyButton) findViewById(R.id.fastest);
        this.g = strategyButton7;
        strategyButton7.setOnClickListener(this);
    }

    public final /* synthetic */ void g(View view) {
        c();
    }

    public String getNaviStrategyDesp() {
        String string = getContext().getApplicationContext().getString(R.string.recommend);
        int f2 = CSharedPreferences.f(getContext(), "navi_strategy", 10);
        if (f2 == 10) {
            string = getContext().getApplicationContext().getString(R.string.recommend);
        } else if (f2 == 20) {
            string = getContext().getApplicationContext().getString(R.string.avoid_congestion) + Marker.ANY_NON_NULL_MARKER + getContext().getApplicationContext().getString(R.string.high_speed_priority);
        } else if (f2 == 18) {
            string = getContext().getApplicationContext().getString(R.string.avoid_congestion) + Marker.ANY_NON_NULL_MARKER + getContext().getApplicationContext().getString(R.string.no_highway) + Marker.ANY_NON_NULL_MARKER + getContext().getApplicationContext().getString(R.string.charge_less);
        } else if (f2 == 15) {
            string = getContext().getApplicationContext().getString(R.string.avoid_congestion) + Marker.ANY_NON_NULL_MARKER + getContext().getApplicationContext().getString(R.string.no_highway);
        } else if (f2 == 17) {
            string = getContext().getApplicationContext().getString(R.string.avoid_congestion) + Marker.ANY_NON_NULL_MARKER + getContext().getApplicationContext().getString(R.string.charge_less);
        } else if (f2 == 1011) {
            string = getContext().getApplicationContext().getString(R.string.avoid_congestion) + Marker.ANY_NON_NULL_MARKER + getContext().getApplicationContext().getString(R.string.road_priority);
        } else if (f2 == 1012) {
            string = getContext().getApplicationContext().getString(R.string.avoid_congestion) + Marker.ANY_NON_NULL_MARKER + getContext().getApplicationContext().getString(R.string.fastest);
        } else if (f2 == 19) {
            string = getContext().getApplicationContext().getString(R.string.high_speed_priority);
        } else if (f2 == 16) {
            string = getContext().getApplicationContext().getString(R.string.no_highway) + Marker.ANY_NON_NULL_MARKER + getContext().getApplicationContext().getString(R.string.charge_less);
        } else if (f2 == 13) {
            string = getContext().getApplicationContext().getString(R.string.no_highway);
        } else if (f2 == 14) {
            string = getContext().getApplicationContext().getString(R.string.charge_less);
        } else if (f2 == 1013) {
            string = getContext().getApplicationContext().getString(R.string.road_priority);
        } else if (f2 == 1014) {
            string = getContext().getApplicationContext().getString(R.string.avoid_congestion);
        } else if (f2 == 4) {
            string = getContext().getApplicationContext().getString(R.string.fastest);
        }
        CLog.b(i, "setInitSelection  strategy:" + f2 + " strategyDesp=" + string);
        return string;
    }

    public StrategyChangeListener getStrategyChangeListener() {
        return this.h;
    }

    public void h() {
        int strategySelect = getStrategySelect();
        String str = i;
        CLog.b(str, "saveStrategy  strategy:" + strategySelect);
        CSharedPreferences.t(getContext(), "navi_strategy", strategySelect);
        StrategyChangeListener strategyChangeListener = this.h;
        if (strategyChangeListener != null) {
            strategyChangeListener.y(strategySelect);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.recommend) {
            this.f5834a.setSelect(true);
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_s, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            this.b.setSelect(false);
            this.c.setSelect(false);
            this.d.setSelect(false);
            this.e.setSelect(false);
            this.f.setSelect(false);
            this.g.setSelect(false);
        } else if (id == R.id.avoid_congestion) {
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            StrategyButton strategyButton = this.b;
            strategyButton.setSelect(!strategyButton.isSelected());
            this.f5834a.setSelect(false);
            b();
        } else if (id == R.id.high_speed_priority) {
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            StrategyButton strategyButton2 = this.c;
            strategyButton2.setSelect(!strategyButton2.isSelected());
            this.f5834a.setSelect(false);
            this.d.setSelect(false);
            this.e.setSelect(false);
            this.f.setSelect(false);
            this.g.setSelect(false);
            b();
        } else if (id == R.id.no_high_speed) {
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            StrategyButton strategyButton3 = this.d;
            strategyButton3.setSelect(!strategyButton3.isSelected());
            this.f5834a.setSelect(false);
            this.c.setSelect(false);
            this.f.setSelect(false);
            this.g.setSelect(false);
            b();
        } else if (id == R.id.low_fees) {
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            StrategyButton strategyButton4 = this.e;
            strategyButton4.setSelect(!strategyButton4.isSelected());
            this.f5834a.setSelect(false);
            this.c.setSelect(false);
            this.f.setSelect(false);
            this.g.setSelect(false);
            b();
        } else if (id == R.id.road_priority) {
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            StrategyButton strategyButton5 = this.f;
            strategyButton5.setSelect(!strategyButton5.isSelected());
            this.f5834a.setSelect(false);
            this.c.setSelect(false);
            this.d.setSelect(false);
            this.e.setSelect(false);
            this.g.setSelect(false);
            b();
        } else if (id == R.id.fastest) {
            this.f5834a.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.recommend_icon_n, (Resources.Theme) null), (Drawable) null, (Drawable) null);
            StrategyButton strategyButton6 = this.g;
            strategyButton6.setSelect(!strategyButton6.isSelected());
            this.f5834a.setSelect(false);
            this.c.setSelect(false);
            this.d.setSelect(false);
            this.e.setSelect(false);
            this.f.setSelect(false);
            b();
        }
        h();
    }

    public void setStrategyChangeListener(StrategyChangeListener strategyChangeListener) {
        this.h = strategyChangeListener;
    }

    public NaviStrategyView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
        f();
        e();
    }
}
