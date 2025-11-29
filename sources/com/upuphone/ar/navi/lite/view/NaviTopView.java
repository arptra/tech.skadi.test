package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.o4.o;
import com.honey.account.o4.p;
import com.honey.account.o4.q;
import com.honey.account.o4.r;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.util.AnimationUtils;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.util.RegionUtils;

public class NaviTopView extends ConstraintLayout implements View.OnClickListener {
    public static final String l = ("NAVI-" + NaviTopView.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public AutoCompleteTextView f5835a;
    public AutoCompleteTextView b;
    public ImageView c;
    public TextView d;
    public CButton e;
    public CButton f;
    public LinearLayout g;
    public NaviTopViewActionistener h;
    public boolean i = false;
    public boolean j = false;
    public AutoCompleteTextView k;

    public interface NaviTopViewActionistener {
        void K(boolean z);

        void P();

        void R(AutoCompleteTextView autoCompleteTextView, CharSequence charSequence, boolean z);

        void g(int i);

        void k();

        void onEditorAction(TextView textView, int i, KeyEvent keyEvent);
    }

    public NaviTopView(Context context) {
        super(context);
        s(context);
        t();
        n();
    }

    private void s(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.nav_top_view_layout, this);
    }

    private void setNaviDriveSelect(boolean z) {
        this.d.setBackgroundColor(getResources().getColor(R.color.transparent, (Resources.Theme) null));
        if (z) {
            this.c.setImageResource(R.drawable.car);
            this.d.setTextColor(getResources().getColor(R.color.theme_color_1, (Resources.Theme) null));
            this.g.setBackgroundResource(R.drawable.btn_select);
            return;
        }
        this.c.setImageResource(R.drawable.car_icon);
        this.d.setTextColor(getResources().getColor(R.color.theme_white_alpha_color, (Resources.Theme) null));
        this.g.setBackgroundResource(R.drawable.btn_unselect);
    }

    private void t() {
        ((ImageView) findViewById(R.id.back_icon)).setOnClickListener(this);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.start_postion);
        this.f5835a = autoCompleteTextView;
        autoCompleteTextView.setText(R.string.my_position);
        this.f5835a.setSelectAllOnFocus(true);
        this.f5835a.setOnTouchListener(new o(this));
        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) findViewById(R.id.end_postion);
        this.b = autoCompleteTextView2;
        autoCompleteTextView2.setSelectAllOnFocus(true);
        this.b.setOnTouchListener(new p(this));
        ((ImageView) findViewById(R.id.path_step)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.from_to_change)).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.navi_drive_layout);
        this.g = linearLayout;
        linearLayout.setOnClickListener(this);
        int i2 = 8;
        int i3 = 0;
        this.g.setVisibility(RegionUtils.d() ? 8 : 0);
        this.c = (ImageView) findViewById(R.id.navi_drive_icon);
        TextView textView = (TextView) findViewById(R.id.navi_drive);
        this.d = textView;
        textView.setOnClickListener(this);
        this.d.setSelected(true);
        setNaviDriveSelect(true);
        ImageView imageView = (ImageView) findViewById(R.id.navi_top_down_arrow);
        if (!NaviUtil.s0()) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        CButton cButton = (CButton) findViewById(R.id.navi_bike);
        this.e = cButton;
        cButton.setOnClickListener(this);
        this.e.setSelect(false);
        this.e.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.bike_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
        this.e.setVisibility(q() ? 4 : 0);
        CButton cButton2 = (CButton) findViewById(R.id.navi_walk);
        this.f = cButton2;
        cButton2.setOnClickListener(this);
        this.f.setSelect(false);
        this.f.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.walk_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
        CButton cButton3 = this.f;
        if (q()) {
            i3 = 4;
        }
        cButton3.setVisibility(i3);
    }

    /* renamed from: A */
    public boolean x(TextView textView, int i2, KeyEvent keyEvent) {
        NaviTopViewActionistener naviTopViewActionistener = this.h;
        if (naviTopViewActionistener == null) {
            return false;
        }
        naviTopViewActionistener.onEditorAction(textView, i2, keyEvent);
        return false;
    }

    public void B() {
        AnimationUtils.b(this.f5835a);
        AnimationUtils.c(this.b);
    }

    public void C(String str) {
        this.f5835a.setText(R.string.my_position);
        this.b.setText(str);
    }

    public void D() {
        String obj = this.f5835a.getText().toString();
        this.f5835a.setText(this.b.getText().toString());
        this.b.setText(obj);
        AnimationUtils.a(this.f5835a);
        AnimationUtils.d(this.b);
    }

    public final void E(boolean z) {
        String c2 = CSharedPreferences.c(getContext().getApplicationContext());
        boolean z2 = !TextUtils.isEmpty(c2);
        boolean b2 = CSharedPreferences.b(getContext(), "avoid_limite", false);
        if (!z2 || !b2) {
            this.d.setText(R.string.drive_title);
        } else {
            this.d.setText(r(c2, z2));
        }
        if (z) {
            this.c.setImageResource(R.drawable.car);
        } else {
            this.c.setImageResource(R.drawable.car_icon);
        }
    }

    public void F(int i2) {
        if (i2 == 0) {
            this.f.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.walk_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            this.e.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.bike_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            this.c.setImageResource(R.drawable.car);
        } else if (i2 == 1) {
            this.f.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.walk_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            this.e.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.bike, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            this.c.setImageResource(R.drawable.car_icon);
        } else if (i2 != 2) {
            CLog.b(l, "setNavModeSelect  default.");
        } else {
            this.f.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.walk, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            this.e.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.bike_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            this.c.setImageResource(R.drawable.car_icon);
        }
    }

    public AutoCompleteTextView getCurEdit() {
        return this.k;
    }

    public AutoCompleteTextView getEndPostion() {
        return this.b;
    }

    public NaviTopViewActionistener getViewActionListener() {
        return this.h;
    }

    public final void n() {
        this.f5835a.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                NaviTopView naviTopView = NaviTopView.this;
                boolean unused = naviTopView.o(naviTopView.f5835a, charSequence, true);
            }
        });
        this.b.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                NaviTopView naviTopView = NaviTopView.this;
                boolean unused = naviTopView.o(naviTopView.b, charSequence, false);
            }
        });
        this.f5835a.setOnEditorActionListener(new q(this));
        this.b.setOnEditorActionListener(new r(this));
    }

    public final boolean o(AutoCompleteTextView autoCompleteTextView, CharSequence charSequence, boolean z) {
        this.j = z;
        this.k = autoCompleteTextView;
        if (this.h == null || !u()) {
            return false;
        }
        String str = l;
        CLog.b(str, "addressEditChanged isStartPos=" + z);
        this.h.R(autoCompleteTextView, charSequence, z);
        return false;
    }

    public void onClick(View view) {
        NaviTopViewActionistener naviTopViewActionistener;
        int id = view.getId();
        if (id == R.id.from_to_change) {
            NaviTopViewActionistener naviTopViewActionistener2 = this.h;
            if (naviTopViewActionistener2 != null) {
                naviTopViewActionistener2.k();
            }
        } else if (id == R.id.navi_drive || id == R.id.navi_drive_layout) {
            NaviTopViewActionistener naviTopViewActionistener3 = this.h;
            if (naviTopViewActionistener3 != null) {
                naviTopViewActionistener3.g(0);
            }
        } else if (id == R.id.navi_bike) {
            NaviTopViewActionistener naviTopViewActionistener4 = this.h;
            if (naviTopViewActionistener4 != null) {
                naviTopViewActionistener4.g(1);
            }
        } else if (id == R.id.navi_walk) {
            NaviTopViewActionistener naviTopViewActionistener5 = this.h;
            if (naviTopViewActionistener5 != null) {
                naviTopViewActionistener5.g(2);
            }
        } else if (id == R.id.back_icon && (naviTopViewActionistener = this.h) != null) {
            naviTopViewActionistener.P();
        }
    }

    public final boolean p(MotionEvent motionEvent, boolean z) {
        if (motionEvent.getAction() != 1 || this.h == null) {
            return false;
        }
        String str = l;
        CLog.b(str, "addressEditOnTouch isStartPos=" + z);
        this.j = z;
        this.k = z ? this.f5835a : this.b;
        setEditMode(true);
        this.h.K(z);
        return false;
    }

    public final boolean q() {
        return false;
    }

    public final String r(String str, boolean z) {
        if (!z) {
            return str;
        }
        String substring = str.substring(0, 2);
        String substring2 = str.substring(str.length() - 1, str.length());
        String str2 = substring + "**" + substring2;
        CLog.b(l, "getLicens  Enter. prefix=" + substring + " suffix=" + substring2 + " result=" + str2 + " hasLicense=" + z);
        return str2;
    }

    public void setCurEdit(AutoCompleteTextView autoCompleteTextView) {
        this.k = autoCompleteTextView;
    }

    public void setEditMode(boolean z) {
        this.i = z;
    }

    public void setEditSelectAllOnFocus(boolean z) {
        this.f5835a.setSelectAllOnFocus(z);
        this.b.setSelectAllOnFocus(z);
    }

    public void setEndPostion(AutoCompleteTextView autoCompleteTextView) {
        this.b = autoCompleteTextView;
    }

    public void setEndPostionName(String str) {
        this.b.setText(str);
    }

    public void setNavModeSelect(int i2) {
        if (i2 == 0) {
            setNaviDriveSelect(true);
            this.e.setSelect(false);
            this.f.setSelect(false);
            E(true);
        } else if (i2 == 1) {
            setNaviDriveSelect(false);
            this.e.setSelect(true);
            this.f.setSelect(false);
            E(false);
        } else if (i2 != 2) {
            CLog.b(l, "setNavModeSelect  default.");
        } else {
            setNaviDriveSelect(false);
            this.e.setSelect(false);
            this.f.setSelect(true);
            E(false);
        }
    }

    public void setStartEdit(boolean z) {
        this.j = z;
    }

    public void setStartPostion(String str) {
        this.f5835a.setText(str);
    }

    public void setViewActionListener(NaviTopViewActionistener naviTopViewActionistener) {
        this.h = naviTopViewActionistener;
    }

    public boolean u() {
        return this.i;
    }

    public boolean v() {
        return this.j;
    }

    public final /* synthetic */ boolean y(View view, MotionEvent motionEvent) {
        return p(motionEvent, true);
    }

    public final /* synthetic */ boolean z(View view, MotionEvent motionEvent) {
        return p(motionEvent, false);
    }

    public NaviTopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s(context);
        t();
        n();
    }

    public NaviTopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s(context);
        t();
        n();
    }
}
