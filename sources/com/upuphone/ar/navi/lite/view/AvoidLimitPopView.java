package com.upuphone.ar.navi.lite.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.o4.c;
import com.honey.account.o4.d;
import com.honey.account.o4.e;
import com.honey.account.o4.f;
import com.honey.account.o4.g;
import com.honey.account.o4.h;
import com.honey.account.o4.i;
import com.meizu.common.widget.Switch;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.DensityUtils;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.star.common.phone.UToast;

public class AvoidLimitPopView implements View.OnClickListener, View.OnTouchListener {
    public static final String n = ("NAVI-" + AvoidLimitPopView.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f5816a;
    public View b;
    public Activity c;
    public OnClickListener d;
    public ImageView e;
    public TextView f;
    public Switch g;
    public ImageView h;
    public ConstraintLayout i;
    public TextView j;
    public ImageView k;
    public TextView l;
    public ImageView m;

    public interface OnClickListener {
        void f(boolean z);

        void g(View view, int i);
    }

    public AvoidLimitPopView(Context context, OnClickListener onClickListener) {
        LayoutInflater from = LayoutInflater.from(context);
        this.d = onClickListener;
        this.c = (Activity) context;
        this.b = from.inflate(R.layout.avoid_limit_pop_view_layout, (ViewGroup) null);
        m();
        n();
        A();
    }

    public final void A() {
        String c2 = CSharedPreferences.c(this.c.getApplicationContext());
        boolean z = !TextUtils.isEmpty(c2);
        if (!z) {
            CSharedPreferences.p(this.c.getApplicationContext(), "avoid_limite", false);
        }
        int i2 = 8;
        this.i.setVisibility(z ? 0 : 8);
        ImageView imageView = this.h;
        if (z) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        this.l.setText(l(c2, z));
        boolean b2 = CSharedPreferences.b(this.c.getApplicationContext(), "avoid_limite", false);
        this.g.setChecked(b2);
        B(b2);
    }

    public final void B(boolean z) {
        this.i.setBackgroundResource(z ? R.drawable.car_license_panel_bg_s : R.drawable.car_license_panel_bg);
        this.m.setImageResource(z ? R.drawable.edit_s_icon : R.drawable.edit_icon);
        this.j.setVisibility(z ? 0 : 8);
    }

    public final void h() {
        int i2 = 0;
        boolean u1 = NaviUtil.u1(this.c, false, "avoid_limite");
        String c2 = CSharedPreferences.c(this.c.getApplicationContext());
        boolean z = !TextUtils.isEmpty(c2);
        CLog.b(n, "avoidLimit  Enter. hasLicense=" + z + " license=" + c2 + " b=" + u1);
        this.i.setVisibility(z ? 0 : 8);
        ImageView imageView = this.h;
        if (!z) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        B(u1);
        if (z || !u1) {
            OnClickListener onClickListener = this.d;
            if (onClickListener != null && z) {
                onClickListener.g(this.b, 2);
                return;
            }
            return;
        }
        y("");
    }

    public final void i(CarSetDialog carSetDialog) {
        if (!TextUtils.isEmpty(CSharedPreferences.c(this.c.getApplicationContext()))) {
            this.g.setChecked(CSharedPreferences.b(this.c.getApplicationContext(), "avoid_limite", false), true);
        } else {
            CSharedPreferences.p(this.c.getApplicationContext(), "avoid_limite", false);
            this.g.setChecked(false, true);
            this.i.setVisibility(8);
            this.h.setVisibility(8);
        }
        carSetDialog.dismiss();
    }

    public final void j(CarSetDialog carSetDialog) {
        String vehicleLicense = carSetDialog.h().getVehicleLicense();
        if ("car_license_error".equalsIgnoreCase(vehicleLicense)) {
            UToast.f(this.c.getApplicationContext(), this.c.getString(R.string.car_license_error));
        } else if ("energy_license_error".equalsIgnoreCase(vehicleLicense)) {
            UToast.f(this.c.getApplicationContext(), this.c.getString(R.string.energy_license_error));
        } else if ("imperfect_license_error".equalsIgnoreCase(vehicleLicense) || "car_license_clean".equalsIgnoreCase(vehicleLicense)) {
            UToast.f(this.c.getApplicationContext(), this.c.getString(R.string.input_completed_car_plate));
        } else {
            CSharedPreferences.r(this.c.getApplicationContext(), carSetDialog.g());
            CSharedPreferences.q(this.c.getApplicationContext(), vehicleLicense);
            boolean z = !TextUtils.isEmpty(vehicleLicense);
            int i2 = 8;
            this.i.setVisibility(z ? 0 : 8);
            ImageView imageView = this.h;
            if (z) {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            CSharedPreferences.p(this.c.getApplicationContext(), "avoid_limite", z);
            this.g.setChecked(z, true);
            this.l.setText(l(vehicleLicense, z));
            carSetDialog.dismiss();
            OnClickListener onClickListener = this.d;
            if (onClickListener != null) {
                onClickListener.g(this.b, 0);
            }
        }
    }

    public final void k() {
        CSharedPreferences.q(this.c.getApplicationContext(), "");
        CSharedPreferences.r(this.c.getApplicationContext(), 0);
        this.i.setVisibility(8);
        this.h.setVisibility(8);
        this.l.setText("");
        CSharedPreferences.p(this.c.getApplicationContext(), "avoid_limite", false);
        this.g.setChecked(false, true);
        OnClickListener onClickListener = this.d;
        if (onClickListener != null) {
            onClickListener.g(this.b, 1);
        }
    }

    public final String l(String str, boolean z) {
        if (!z) {
            return str;
        }
        String substring = str.substring(0, 1);
        String substring2 = str.substring(1, str.length());
        String str2 = substring + FastRecordHistoryDetailActivity.TAG_SPLIT + substring2;
        CLog.b(n, "getLicens  Enter. prefix=" + substring + " suffix=" + substring2 + " result=" + str2 + " hasLicense=" + z);
        return str2;
    }

    public final void m() {
        ImageView imageView = (ImageView) this.b.findViewById(R.id.limiteClose);
        this.e = imageView;
        imageView.setOnClickListener(this);
        this.f = (TextView) this.b.findViewById(R.id.avoidLimiteMenu);
        Switch switchR = (Switch) this.b.findViewById(R.id.limiteSwitch);
        this.g = switchR;
        switchR.setOnClickListener(new h(this));
        w(this.g);
        ((ConstraintLayout) this.b.findViewById(R.id.avoid_limite_menu_group)).setOnClickListener(new i(this));
        this.h = (ImageView) this.b.findViewById(R.id.licenseCar);
        this.i = (ConstraintLayout) this.b.findViewById(R.id.carLicenseLayout);
        this.j = (TextView) this.b.findViewById(R.id.licenseSelect);
        ImageView imageView2 = (ImageView) this.b.findViewById(R.id.removeLicense);
        this.k = imageView2;
        imageView2.setOnClickListener(this);
        this.l = (TextView) this.b.findViewById(R.id.carLicense);
        ImageView imageView3 = (ImageView) this.b.findViewById(R.id.editLicense);
        this.m = imageView3;
        imageView3.setOnClickListener(this);
    }

    public final void n() {
        this.f5816a = new PopupWindow(this.b, -1, -2, true);
        this.f5816a.setBackgroundDrawable(new ColorDrawable(0));
        this.b.setOnTouchListener(this);
        this.f5816a.setOnDismissListener(new e(this));
    }

    public final /* synthetic */ void o(View view) {
        h();
    }

    public void onClick(View view) {
        boolean z = true;
        if (view.getId() == R.id.removeLicense) {
            v(1);
        } else if (view.getId() == R.id.editLicense) {
            v(0);
        } else {
            this.f5816a.dismiss();
            z = false;
        }
        OnClickListener onClickListener = this.d;
        if (onClickListener != null) {
            onClickListener.f(z);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f5816a.dismiss();
        }
        return true;
    }

    public final /* synthetic */ void p(View view) {
        this.g.performClick();
    }

    public final /* synthetic */ void q() {
        OnClickListener onClickListener = this.d;
        if (onClickListener != null) {
            onClickListener.f(false);
        }
    }

    public final /* synthetic */ void r(CarSetDialog carSetDialog, View view) {
        CarSetDialog.z = false;
        i(carSetDialog);
    }

    public final /* synthetic */ void s(CarSetDialog carSetDialog, View view) {
        CarSetDialog.z = false;
        j(carSetDialog);
    }

    public final /* synthetic */ void u(CustomDialog customDialog, View view) {
        customDialog.dismiss();
        k();
    }

    public void v(int i2) {
        String str = n;
        CLog.b(str, "onCarMenuClick  Enter. index=" + i2);
        String c2 = CSharedPreferences.c(this.c.getApplicationContext());
        if (i2 == 0) {
            y(c2);
        } else if (i2 == 1) {
            z();
        }
    }

    public final void w(Switch switchR) {
        switchR.setTrackOnColor(com.meizu.common.R.color.mz_theme_color_blue);
        switchR.setTrackOffColor(R.color.navi_mz_switch_disable_color);
    }

    public void x(View view) {
        this.f5816a.showAsDropDown(view, 0, DensityUtils.a(this.c.getApplicationContext(), 110.0f));
        this.d.f(true);
    }

    public final void y(String str) {
        CarSetDialog carSetDialog = new CarSetDialog(this.c);
        carSetDialog.setCancelable(false);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        carSetDialog.r(str);
        carSetDialog.u(this.c.getString(R.string.car_edit)).s(this.c.getString(R.string.navi_cancel), new f(this, carSetDialog)).t(this.c.getString(R.string.car_save_ok), new g(this, carSetDialog)).show();
    }

    public final void z() {
        CustomDialog customDialog = new CustomDialog(this.c);
        customDialog.c(true);
        customDialog.j(this.c.getString(R.string.car_avoid_delete_content)).i(this.c.getString(R.string.car_avoid_delete_message)).e(this.c.getString(R.string.navi_cancel), new c(customDialog)).h(R.color.avoid_limit_color_red).g(R.drawable.avoid_limit_rect_red).f(this.c.getString(R.string.menu_delete), new d(this, customDialog)).show();
    }
}
