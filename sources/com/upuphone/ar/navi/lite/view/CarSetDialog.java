package com.upuphone.ar.navi.lite.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.honey.account.o4.j;
import com.honey.account.o4.k;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.car.keyboard.LicensePlateView;
import com.upuphone.ar.navi.lite.car.view.VehicleInput;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.DensityUtils;

public class CarSetDialog extends Dialog implements View.OnClickListener, LicensePlateView.OnKeyClickListener {
    public static final String y = ("NAVI-" + CarSetDialog.class.getSimpleName());
    public static boolean z = false;

    /* renamed from: a  reason: collision with root package name */
    public String f5819a;
    public String b;
    public String c;
    public View.OnClickListener d;
    public View.OnClickListener e;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public boolean j = true;
    public TextView k;
    public ImageView l;
    public LicensePlateView m;
    public VehicleInput n;
    public String o;
    public EditText p;
    public EditText q;
    public EditText r;
    public TextView s;
    public TextView t;
    public TextView u;
    public LinearLayout v;
    public CarTypeButton w;
    public CarTypeButton x;

    public CarSetDialog(Context context) {
        super(context);
    }

    public void a() {
        if (!z) {
            v();
        } else if (!TextUtils.isEmpty(this.q.getText().toString())) {
            v();
        }
    }

    public void b() {
    }

    public void c(String str) {
        if (str.equalsIgnoreCase("Del")) {
            this.n.b();
            if (z && TextUtils.isEmpty(this.q.getText().toString())) {
                this.u.setEnabled(false);
                this.u.setTextColor(getContext().getColor(R.color.scrollbar_color));
                this.u.getBackground().setAlpha(25);
                return;
            }
            return;
        }
        this.n.k(str);
    }

    public final void f() {
        for (EditText next : this.n.getBtnMap().values()) {
            int c2 = this.n.c(next);
            if (!(c2 == this.n.c(this.q) || c2 == this.n.c(this.p))) {
                if (z) {
                    next.setBackgroundDrawable(getContext().getDrawable(R.drawable.vehicle_input_item_bg_new_car));
                } else {
                    next.setBackgroundDrawable(getContext().getDrawable(R.drawable.vehicle_input_item_bg));
                }
            }
        }
    }

    public int g() {
        if (this.w.isSelected()) {
            return 2;
        }
        return this.x.isSelected() ? 4 : 0;
    }

    public VehicleInput h() {
        return this.n;
    }

    public final void i() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        Point point = new Point();
        defaultDisplay.getSize(point);
        attributes.width = (int) (((double) point.x) * 1.0d);
        getWindow().setGravity(this.j ? 80 : 17);
        getWindow().setAttributes(attributes);
    }

    public final void j() {
        this.k = (TextView) findViewById(R.id.car_set_tips);
        ImageView imageView = (ImageView) findViewById(R.id.NewEnergyCheck);
        this.l = imageView;
        imageView.setOnClickListener(this);
        ((TextView) findViewById(R.id.NewEnergyCheckText)).setOnClickListener(new j(this));
        this.n = (VehicleInput) findViewById(R.id.vehicle_input);
        LicensePlateView licensePlateView = (LicensePlateView) findViewById(R.id.plate_view);
        this.m = licensePlateView;
        licensePlateView.setOnKeyClickListener(this);
        this.n.setVehicleListener(this.m);
        this.n.setVehicleLicense(this.o);
        this.s = (TextView) findViewById(R.id.title);
        this.t = (TextView) findViewById(R.id.cancel);
        this.u = (TextView) findViewById(R.id.confirm);
        this.p = (EditText) findViewById(R.id.number_0);
        this.r = (EditText) findViewById(R.id.number_6);
        EditText editText = (EditText) findViewById(R.id.number_7);
        this.q = editText;
        editText.setOnTouchListener(new k(this));
        this.v = (LinearLayout) findViewById(R.id.energy_type_layout);
        this.w = (CarTypeButton) findViewById(R.id.energy_bev_btn);
        this.x = (CarTypeButton) findViewById(R.id.energy_phev_btn);
    }

    public final void k() {
        if (!TextUtils.isEmpty(this.f5819a)) {
            this.s.setText(this.f5819a);
        }
        if (!TextUtils.isEmpty(this.c)) {
            this.t.setText(this.c);
        }
        if (!TextUtils.isEmpty(this.b)) {
            this.u.setText(this.b);
        }
        if (this.f != 0) {
            this.u.setTextColor(getContext().getColor(this.f));
        }
        int i2 = this.h;
        if (i2 != 0) {
            this.u.setBackgroundResource(i2);
        }
        if (this.g != 0) {
            this.t.setTextColor(getContext().getColor(this.g));
        }
        int i3 = this.i;
        if (i3 != 0) {
            this.t.setBackgroundResource(i3);
        }
    }

    public final void l() {
        int d2 = CSharedPreferences.d(getContext().getApplicationContext());
        boolean z2 = true;
        int i2 = 0;
        boolean z3 = d2 == 2 || d2 == 4;
        Boolean valueOf = Boolean.valueOf(z3);
        CLog.b(y, "initViewStatus  #################  carType=" + d2 + " isEnergy=" + valueOf);
        this.v.setVisibility(z3 ? 0 : 8);
        this.w.setSelect(d2 == 2);
        this.w.setOnClickListener(this);
        CarTypeButton carTypeButton = this.x;
        if (d2 != 4) {
            z2 = false;
        }
        carTypeButton.setSelect(z2);
        this.x.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.t.setVisibility(TextUtils.isEmpty(this.c) ? 8 : 0);
        TextView textView = this.u;
        if (TextUtils.isEmpty(this.b)) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    public final boolean m() {
        String vehicleLicense = this.n.getVehicleLicense();
        if ("car_license_error".equalsIgnoreCase(vehicleLicense) || "energy_license_error".equalsIgnoreCase(vehicleLicense) || "imperfect_license_error".equalsIgnoreCase(vehicleLicense) || "car_license_clean".equalsIgnoreCase(vehicleLicense)) {
            return false;
        }
        String str = y;
        CLog.b(str, "isNumberValid  ##### energyTypeLayout.isShown()=" + this.v.isShown() + " isNewCar=" + z + " license=" + vehicleLicense);
        if (!this.v.isShown() || vehicleLicense.length() >= 8) {
            return !this.v.isShown() || this.w.isSelected() || this.x.isSelected();
        }
        return false;
    }

    public final /* synthetic */ void n(View view) {
        this.l.performClick();
    }

    public final /* synthetic */ boolean o(View view, MotionEvent motionEvent) {
        p(false);
        return true;
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener;
        int id = view.getId();
        if (id == R.id.confirm) {
            View.OnClickListener onClickListener2 = this.e;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        } else if (id == R.id.cancel && (onClickListener = this.d) != null) {
            onClickListener.onClick(view);
        } else if (id == R.id.NewEnergyCheck) {
            q();
        } else if (id == R.id.energy_bev_btn) {
            w(Boolean.TRUE);
        } else if (id == R.id.energy_phev_btn) {
            w(Boolean.FALSE);
        }
    }

    public void onCreate(Bundle bundle) {
        DensityUtils.e(getContext(), getWindow());
        super.onCreate(bundle);
        setContentView(R.layout.navi_car_set_dialog_layout);
        i();
        j();
        k();
        l();
        v();
    }

    public void p(boolean z2) {
        z = true;
        this.v.setVisibility(0);
        this.l.setImageResource(R.drawable.car_check_on);
        this.q.setTextSize(1, 15.0f);
        EditText editText = this.p;
        editText.setBackgroundResource(TextUtils.isEmpty(editText.getText().toString()) ? R.drawable.vehicle_input_energy_border : R.drawable.vehicle_input_energy_light_item_filled);
        this.q.setHint("");
        if (!z2) {
            VehicleInput vehicleInput = this.n;
            vehicleInput.g(vehicleInput.c(this.q));
        }
        if (TextUtils.isEmpty(this.q.getText().toString())) {
            this.u.setEnabled(false);
            this.u.setTextColor(getContext().getColor(R.color.scrollbar_color));
            this.u.getBackground().setAlpha(25);
        }
        f();
    }

    public final void q() {
        this.v.setVisibility(z ? 8 : 0);
        if (z) {
            this.w.setSelect(false);
            this.x.setSelect(false);
            if (!TextUtils.isEmpty(this.q.getText().toString())) {
                this.q.setText("");
                VehicleInput vehicleInput = this.n;
                vehicleInput.g(vehicleInput.c(this.r));
            } else {
                v();
                VehicleInput vehicleInput2 = this.n;
                vehicleInput2.g(vehicleInput2.c(this.p));
            }
            z = false;
            this.l.setImageResource(R.drawable.car_check_off);
            EditText editText = this.p;
            editText.setBackgroundResource(TextUtils.isEmpty(editText.getText().toString()) ? R.drawable.vehicle_input_border_gray : R.drawable.vehicle_input_light_item_filled);
            this.q.setHint(getContext().getString(R.string.new_energy_hint));
            this.q.setTextSize(1, 10.0f);
            f();
            return;
        }
        p(true);
        if (!TextUtils.isEmpty(this.r.getText().toString())) {
            VehicleInput vehicleInput3 = this.n;
            vehicleInput3.g(vehicleInput3.c(this.q));
        }
        f();
    }

    public void r(String str) {
        this.o = str;
    }

    public CarSetDialog s(String str, View.OnClickListener onClickListener) {
        this.c = str;
        this.d = onClickListener;
        return this;
    }

    public CarSetDialog t(String str, View.OnClickListener onClickListener) {
        this.b = str;
        this.e = onClickListener;
        return this;
    }

    public CarSetDialog u(String str) {
        this.f5819a = str;
        return this;
    }

    public final void v() {
        this.k.setVisibility(8);
        if (!z) {
            this.l.setImageResource(this.n.f() ? R.drawable.car_check_on : R.drawable.car_check_off);
            if (this.n.f()) {
                z = true;
            } else {
                z = false;
            }
        }
        this.u = (TextView) findViewById(R.id.confirm);
        boolean m2 = m();
        this.u.setEnabled(m2);
        this.u.setTextColor(m2 ? getContext().getColor(R.color.theme_color_1) : getContext().getColor(R.color.scrollbar_color));
        this.u.getBackground().setAlpha(m2 ? 255 : 25);
    }

    public final void w(Boolean bool) {
        this.w.setSelect(bool.booleanValue());
        this.x.setSelect(!bool.booleanValue());
        v();
    }
}
