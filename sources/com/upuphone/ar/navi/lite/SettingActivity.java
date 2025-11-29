package com.upuphone.ar.navi.lite;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import com.honey.account.d4.a1;
import com.honey.account.d4.b1;
import com.honey.account.d4.c1;
import com.honey.account.d4.d1;
import com.honey.account.d4.e1;
import com.honey.account.d4.f1;
import com.honey.account.d4.g1;
import com.honey.account.d4.h1;
import com.honey.account.d4.i1;
import com.honey.account.d4.j1;
import com.honey.account.d4.k1;
import com.honey.account.d4.l1;
import com.honey.account.d4.m1;
import com.honey.account.d4.n1;
import com.honey.account.d4.o1;
import com.honey.account.d4.p1;
import com.honey.account.d4.q1;
import com.honey.account.d4.r1;
import com.honey.account.d4.s1;
import com.honey.account.d4.t1;
import com.honey.account.d4.x0;
import com.honey.account.d4.y0;
import com.honey.account.d4.z0;
import com.meizu.common.R;
import com.meizu.common.widget.Switch;
import com.upuphone.ar.navi.lite.base.BaseViewModel;
import com.upuphone.ar.navi.lite.databinding.ActivitySettingBindingImpl;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.manger.ActivityManager;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.manger.StarryNetManger;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.view.CarEditPopMenu;
import com.upuphone.ar.navi.lite.view.CarSetDialog;
import com.upuphone.ar.navi.lite.view.CustomDialog;
import com.upuphone.ar.navi.lite.view.TravelModeWindow;
import com.upuphone.star.common.phone.UToast;

public class SettingActivity extends BaseActivity implements View.OnClickListener, TravelModeWindow.OnClickListener, CarEditPopMenu.OnClickListener {
    public static final String J = ("NAVI-" + SettingActivity.class.getSimpleName());
    public Switch A;
    public Switch B;
    public Switch C;
    public Switch D;
    public Switch E;
    public Switch F;
    public View G;
    public int H = 0;
    public long I = 0;
    public TextView h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public Switch m;
    public TextView n;
    public TextView o;
    public ImageView p;
    public Switch q;
    public ConstraintLayout r;
    public ImageView s;
    public ImageView t;
    public ConstraintLayout u;
    public ImageView v;
    public ImageView w;
    public ConstraintLayout x;
    public ImageView y;
    public ImageView z;

    /* access modifiers changed from: private */
    public /* synthetic */ void H1(View view) {
        this.B.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I1(View view) {
        p1();
    }

    private void initState() {
        Switch switchR = (Switch) findViewById(R.id.message_mask_set_switch);
        this.B = switchR;
        Y1(switchR);
        int i2 = 0;
        this.B.setChecked(CSharedPreferences.b(this, "msg_mask", false));
        Switch switchR2 = (Switch) findViewById(R.id.brightness_set_switch);
        this.C = switchR2;
        Y1(switchR2);
        this.C.setChecked(CSharedPreferences.b(this, "navi_brightness", true));
        Z1(CSharedPreferences.j(this));
        String c = CSharedPreferences.c(getApplicationContext());
        boolean z2 = !TextUtils.isEmpty(c);
        if (!z2) {
            CSharedPreferences.p(this, "avoid_limite", false);
        }
        boolean b = CSharedPreferences.b(this, "avoid_limite", false);
        this.m.setChecked(b);
        String str = J;
        CLog.b(str, "avoidLimit  avoidLimit. avoidLimit isOpen=" + b + " license=" + c + " hasLicense=" + z2);
        this.n.setVisibility(b ? 0 : 8);
        this.o.setVisibility(b ? 0 : 8);
        ImageView imageView = this.p;
        if (!b) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        TextView textView = this.o;
        if (!z2) {
            c = "";
        }
        textView.setText(c);
        String c2 = CSharedPreferences.c(this);
        TextView textView2 = this.o;
        if (TextUtils.isEmpty(c2)) {
            c2 = getString(R.string.car_license_setting);
        }
        textView2.setText(c2);
        CLog.b(str, "initState  VoiceState=" + CSharedPreferences.m(this));
        this.q.setChecked(CSharedPreferences.m(this));
        this.D.setChecked(CSharedPreferences.b(this, "navi_traffic_state", true));
        this.E.setChecked(CSharedPreferences.b(this, "auto_down", true));
        this.F.setChecked(CSharedPreferences.b(this, "gps_mode", true));
    }

    private void initView() {
        ((TextView) findViewById(R.id.navi_debug_menu)).setOnClickListener(new x0(this));
        Switch switchR = (Switch) findViewById(R.id.message_mask_set_switch);
        this.B = switchR;
        Y1(switchR);
        this.B.setOnClickListener(new y0(this));
        ((ConstraintLayout) findViewById(R.id.message_mask_set_group)).setOnClickListener(new z0(this));
        TextView textView = (TextView) findViewById(R.id.common_address);
        this.h = textView;
        textView.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.common_address_array);
        this.i = imageView;
        imageView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.travel_mode);
        this.j = textView2;
        textView2.setOnClickListener(this);
        this.k = (TextView) findViewById(R.id.travel_mode_desp);
        ImageView imageView2 = (ImageView) findViewById(R.id.travel_mode_array);
        this.l = imageView2;
        imageView2.setOnClickListener(this);
        int i2 = 8;
        boolean z2 = false;
        ((ConstraintLayout) findViewById(R.id.avoid_limite_set_group)).setVisibility(NaviUtil.s0() ? 8 : 0);
        Switch switchR2 = (Switch) findViewById(R.id.avoid_limite_switch);
        this.m = switchR2;
        Y1(switchR2);
        this.m.setOnClickListener(new a1(this));
        ((TextView) findViewById(R.id.avoid_limite)).setOnClickListener(new b1(this));
        TextView textView3 = (TextView) findViewById(R.id.car_setting);
        this.n = textView3;
        textView3.setOnClickListener(this);
        this.o = (TextView) findViewById(R.id.car_setting_desp);
        ImageView imageView3 = (ImageView) findViewById(R.id.car_setting_more);
        this.p = imageView3;
        imageView3.setOnClickListener(this);
        Switch switchR3 = (Switch) findViewById(R.id.voice_switch);
        this.q = switchR3;
        Y1(switchR3);
        this.q.setOnClickListener(new c1(this));
        ((LinearLayout) findViewById(R.id.voice_set_group)).setOnClickListener(new d1(this));
        Switch switchR4 = (Switch) findViewById(R.id.brightness_set_switch);
        this.C = switchR4;
        Y1(switchR4);
        this.C.setOnClickListener(new e1(this));
        this.C.setVisibility(StarryNetManger.getInstance().isAirPro() ? 8 : 0);
        if (StarryNetManger.getInstance().isAirPro()) {
            NaviUtil.u1(this, false, "navi_brightness");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.brightness_set_group);
        constraintLayout.setOnClickListener(new f1(this));
        if (StarryNetManger.getInstance().isAirPro()) {
            constraintLayout.setVisibility(8);
        } else {
            if (!NaviUtil.s0()) {
                i2 = 0;
            }
            constraintLayout.setVisibility(i2);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R.id.display_lower_layout);
        this.r = constraintLayout2;
        constraintLayout2.setOnClickListener(this);
        this.s = (ImageView) findViewById(R.id.check_lower);
        this.t = (ImageView) findViewById(R.id.check_lower_icon);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) findViewById(R.id.display_middle_layout);
        this.u = constraintLayout3;
        constraintLayout3.setOnClickListener(this);
        this.v = (ImageView) findViewById(R.id.check_middle);
        this.w = (ImageView) findViewById(R.id.check_middle_icon);
        ConstraintLayout constraintLayout4 = (ConstraintLayout) findViewById(R.id.display_upper_layout);
        this.x = constraintLayout4;
        constraintLayout4.setOnClickListener(this);
        this.y = (ImageView) findViewById(R.id.check_upper);
        this.z = (ImageView) findViewById(R.id.check_upper_icon);
        Switch switchR5 = (Switch) findViewById(R.id.cross_check_switch);
        this.A = switchR5;
        Y1(switchR5);
        this.A.setOnClickListener(new g1(this));
        ((ConstraintLayout) findViewById(R.id.cross_check_layout)).setOnClickListener(new i1(this));
        Switch switchR6 = (Switch) findViewById(R.id.traffic_switch);
        this.D = switchR6;
        Y1(switchR6);
        this.D.setOnClickListener(new m1(this));
        ((ConstraintLayout) findViewById(R.id.traffic_set_group)).setOnClickListener(new n1(this));
        Switch switchR7 = (Switch) findViewById(R.id.wifi_download_switch);
        this.E = switchR7;
        Y1(switchR7);
        this.E.setOnClickListener(new o1(this));
        ((ConstraintLayout) findViewById(R.id.wifi_download_set_group)).setOnClickListener(new p1(this));
        Switch switchR8 = (Switch) findViewById(R.id.realtime_navi_switch);
        this.F = switchR8;
        Y1(switchR8);
        this.F.setOnClickListener(new q1(this));
        ((ConstraintLayout) findViewById(R.id.navi_mode_set_group)).setOnClickListener(new r1(this));
        Switch switchR9 = (Switch) findViewById(R.id.location_mode_switch);
        Y1(switchR9);
        switchR9.setOnClickListener(new s1(this));
        if (LocationManager.f().i() != 0) {
            z2 = true;
        }
        switchR9.setChecked(z2);
        ((ConstraintLayout) findViewById(R.id.location_mode_set_group)).setOnClickListener(new t1(switchR9));
        this.G = findViewById(R.id.mask);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w1(View view) {
        t1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x1(View view) {
        NaviUtil.u1(this, false, "msg_mask");
    }

    public final /* synthetic */ void A1(View view) {
        this.D.performClick();
    }

    public final /* synthetic */ void B1(View view) {
        NaviUtil.u1(this, true, "auto_down");
    }

    public final /* synthetic */ void C1(View view) {
        this.E.performClick();
    }

    public final /* synthetic */ void D1(View view) {
        NaviUtil.u1(this, true, "gps_mode");
    }

    public final /* synthetic */ void E1(View view) {
        this.F.performClick();
    }

    public final /* synthetic */ void F1(View view) {
        W1();
    }

    public final /* synthetic */ void J1(View view) {
        this.m.performClick();
    }

    public final /* synthetic */ void K1(View view) {
        c2();
    }

    public final /* synthetic */ void L1(View view) {
        this.q.performClick();
    }

    public final /* synthetic */ void M1(View view) {
        NaviUtil.u1(this, true, "navi_brightness");
    }

    public final /* synthetic */ void N1(View view) {
        this.C.performClick();
    }

    public final /* synthetic */ void O1(View view) {
        NaviUtil.u1(this, false, "navi_show_cross");
    }

    public final /* synthetic */ void P1(CarSetDialog carSetDialog, View view) {
        CarSetDialog.z = false;
        q1(carSetDialog);
    }

    public final /* synthetic */ void Q1(CarSetDialog carSetDialog, View view) {
        CarSetDialog.z = false;
        r1(carSetDialog);
    }

    public final /* synthetic */ void S1(CustomDialog customDialog, View view) {
        customDialog.dismiss();
        s1();
    }

    public final void T1() {
        new TravelModeWindow(this, this).e();
    }

    public final void U1() {
        startActivity(new Intent(this, AddressActivity.class));
    }

    public final void V1() {
        CarEditPopMenu carEditPopMenu = new CarEditPopMenu(this, this);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.avoid_limite_set_group);
        carEditPopMenu.c(constraintLayout, ((constraintLayout.getBottom() - constraintLayout.getTop()) / 2) - 30);
    }

    public final void W1() {
        LocationManager.f().p(LocationManager.f().i() == 0 ? 2 : 0);
    }

    public final void X1(int i2) {
        if (i2 == 0) {
            this.r.setBackgroundResource(R.drawable.display_bg_s);
            this.s.setImageResource(R.drawable.check_on);
            this.u.setBackgroundResource(R.drawable.display_bg_n);
            this.v.setImageResource(R.drawable.check_off);
            this.x.setBackgroundResource(R.drawable.display_bg_n);
            this.y.setImageResource(R.drawable.check_off);
        } else if (1 == i2) {
            this.r.setBackgroundResource(R.drawable.display_bg_n);
            this.s.setImageResource(R.drawable.check_off);
            this.u.setBackgroundResource(R.drawable.display_bg_s);
            this.v.setImageResource(R.drawable.check_on);
            this.x.setBackgroundResource(R.drawable.display_bg_n);
            this.y.setImageResource(R.drawable.check_off);
        } else if (2 == i2) {
            this.r.setBackgroundResource(R.drawable.display_bg_n);
            this.s.setImageResource(R.drawable.check_off);
            this.u.setBackgroundResource(R.drawable.display_bg_n);
            this.v.setImageResource(R.drawable.check_off);
            this.x.setBackgroundResource(R.drawable.display_bg_s);
            this.y.setImageResource(R.drawable.check_on);
        }
    }

    public final void Y1(Switch switchR) {
        switchR.setTrackOnColor(R.color.mz_theme_color_blue);
        switchR.setTrackOffColor(R.color.navi_mz_switch_disable_color);
    }

    public final void Z1(int i2) {
        if (i2 == 2) {
            this.k.setText(getString(R.string.walk));
        } else if (i2 == 0) {
            this.k.setText(getString(R.string.drive));
        } else if (i2 == 1) {
            this.k.setText(getString(R.string.ride));
        }
    }

    public final void a2(String str) {
        CarSetDialog carSetDialog = new CarSetDialog(this);
        carSetDialog.setCancelable(false);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        carSetDialog.r(str);
        carSetDialog.u(getString(R.string.car_edit)).s(getString(R.string.navi_cancel), new k1(this, carSetDialog)).t(getString(R.string.car_save_ok), new l1(this, carSetDialog)).show();
        this.G.setVisibility(0);
    }

    public final void b2() {
        CustomDialog customDialog = new CustomDialog(this);
        customDialog.c(true);
        customDialog.j(getString(R.string.car_delete_content)).i(getString(R.string.car_delete_message)).e(getString(17039360), new h1(customDialog)).f(getString(17039370), new j1(this, customDialog)).show();
    }

    public final void c2() {
        boolean m2 = CSharedPreferences.m(this);
        String str = J;
        CLog.b(str, "updateVoiceState  ######## voiceState=" + m2 + " NaviUtil.isIsNaving()=" + NaviUtil.u0());
        if (NaviUtil.u0()) {
            NaviManager.getInstance(this).setNaviSpeak(!m2);
        } else {
            CSharedPreferences.o(getApplicationContext(), "voice_state", !m2);
        }
        if (NaviOperatorManager.getInstance(getApplicationContext()).getNaviVoiceStateChanged() != null) {
            NaviOperatorManager.getInstance(getApplicationContext()).getNaviVoiceStateChanged().NaviVoiceStateChanged(!m2);
        }
        CLog.b(str, "updateVoiceState &&&&&&&&&&& VoiceState=" + CSharedPreferences.m(this));
    }

    public void f(boolean z2) {
        String str = J;
        CLog.b(str, "showCarPopWinow  Enter. show=" + z2);
        this.G.setVisibility(z2 ? 0 : 8);
    }

    public void g(View view, int i2) {
        String str = J;
        CLog.b(str, "onCarMenuClick  Enter. index=" + i2);
        String c = CSharedPreferences.c(getApplicationContext());
        if (i2 == 0) {
            a2(c);
            this.G.setVisibility(0);
        } else if (i2 == 1) {
            b2();
            this.G.setVisibility(0);
        }
    }

    public void h(View view, int i2, String str) {
        CSharedPreferences.x(this, i2);
        Z1(i2);
    }

    public void initViewModel() {
        this.c = new BaseViewModel(getString(R.string.action_bar_navi_setting));
    }

    public void onClick(View view) {
        if (view.getId() == R.id.common_address || view.getId() == R.id.common_address_array) {
            U1();
        } else if (view.getId() == R.id.travel_mode || view.getId() == R.id.travel_mode_array) {
            T1();
        } else if (view.getId() == R.id.car_setting || view.getId() == R.id.car_setting_more) {
            V1();
        } else if (view.getId() == R.id.display_lower_layout) {
            X1(0);
            CSharedPreferences.s(this, 0);
        } else if (view.getId() == R.id.display_middle_layout) {
            X1(1);
            CSharedPreferences.s(this, 1);
        } else if (view.getId() == R.id.display_upper_layout) {
            X1(2);
            CSharedPreferences.s(this, 2);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityManager.getInstance().add(this);
        NaviManager.getInstance(getApplicationContext());
        initView();
        initState();
        u1();
        v1();
        F0();
        ((ActivitySettingBindingImpl) DataBindingUtil.e(this, R.layout.activity_setting)).D(this.c);
    }

    public void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().remove(this);
        if (NaviOperatorManager.getInstance(getApplicationContext()).getEnterType() == 3 && !NaviUtil.u0() && !NaviUtil.B0()) {
            StarryNetManger.getInstance().unRegister();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        View view = this.G;
        if (view != null && z2) {
            view.setVisibility(8);
        }
    }

    public final void p1() {
        int i2 = 0;
        boolean u1 = NaviUtil.u1(this, false, "avoid_limite");
        String c = CSharedPreferences.c(getApplicationContext());
        boolean z2 = !TextUtils.isEmpty(c);
        CLog.b(J, "avoidLimit  Enter. hasLicense=" + z2 + " license=" + c + " b=" + u1);
        if (!u1) {
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
        } else {
            this.n.setVisibility(z2 ? 0 : 8);
            this.o.setVisibility(z2 ? 0 : 8);
            ImageView imageView = this.p;
            if (!z2) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
        if (!z2 && u1) {
            a2("");
        }
    }

    public final void q1(CarSetDialog carSetDialog) {
        boolean z2 = !TextUtils.isEmpty(CSharedPreferences.c(getApplicationContext()));
        CLog.b(J, "avoidLimit  Enter. hasLicense=" + z2 + " license=");
        if (z2) {
            this.m.setChecked(CSharedPreferences.b(this, "avoid_limite", false), true);
        } else {
            CSharedPreferences.p(this, "avoid_limite", false);
            this.m.setChecked(false, true);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
        }
        this.G.setVisibility(8);
        carSetDialog.dismiss();
    }

    public final void r1(CarSetDialog carSetDialog) {
        int i2 = 8;
        this.G.setVisibility(8);
        String vehicleLicense = carSetDialog.h().getVehicleLicense();
        if ("car_license_error".equalsIgnoreCase(vehicleLicense)) {
            UToast.f(getApplicationContext(), getString(R.string.car_license_error));
        } else if ("energy_license_error".equalsIgnoreCase(vehicleLicense)) {
            UToast.f(getApplicationContext(), getString(R.string.energy_license_error));
        } else if ("imperfect_license_error".equalsIgnoreCase(vehicleLicense) || "car_license_clean".equalsIgnoreCase(vehicleLicense)) {
            UToast.f(getApplicationContext(), getString(R.string.input_completed_car_plate));
        } else {
            CSharedPreferences.r(this, carSetDialog.g());
            CSharedPreferences.q(this, vehicleLicense);
            boolean z2 = !TextUtils.isEmpty(vehicleLicense);
            this.n.setVisibility(z2 ? 0 : 8);
            this.o.setVisibility(z2 ? 0 : 8);
            ImageView imageView = this.p;
            if (z2) {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            CSharedPreferences.p(this, "avoid_limite", z2);
            this.m.setChecked(z2, true);
            this.o.setText(vehicleLicense);
            carSetDialog.dismiss();
        }
    }

    public final void s1() {
        CSharedPreferences.q(this, "");
        CSharedPreferences.r(this, 0);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.o.setText("");
        CSharedPreferences.p(this, "avoid_limite", false);
        this.m.setChecked(false, true);
    }

    public final void t1() {
        this.I = this.H == 0 ? System.currentTimeMillis() : this.I;
        long currentTimeMillis = System.currentTimeMillis() - this.I;
        int i2 = this.H + 1;
        this.H = i2;
        if (currentTimeMillis > 1000) {
            this.H = 0;
            this.I = 0;
        } else if (i2 >= 3) {
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.navi_mode_set_group);
            int i3 = 8;
            constraintLayout.setVisibility(constraintLayout.isShown() ? 8 : 0);
            if (!NaviUtil.s0()) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R.id.location_mode_set_group);
                if (!constraintLayout2.isShown()) {
                    i3 = 0;
                }
                constraintLayout2.setVisibility(i3);
            }
            this.H = 0;
            this.I = 0;
        }
    }

    public final void u1() {
        int i2 = 0;
        boolean b = CSharedPreferences.b(this, "navi_show_cross", false);
        String str = J;
        CLog.b(str, "initCrossDisplay  Enter. showCross=" + b + " isAirDevice=" + StarryNetManger.getInstance().isAirDevice());
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.cross_check_layout);
        if (StarryNetManger.getInstance().isAirDevice() || NaviUtil.s0()) {
            i2 = 8;
        }
        constraintLayout.setVisibility(i2);
        Switch switchR = (Switch) findViewById(R.id.cross_check_switch);
        this.A = switchR;
        Y1(switchR);
        this.A.setChecked(b);
    }

    public final void v1() {
        int e = CSharedPreferences.e(this);
        String str = J;
        CLog.b(str, "initPostionDisplay  Enter. displayPosition=" + e);
        if (e == 0) {
            X1(0);
        } else if (e == 1) {
            X1(1);
        } else if (e == 2) {
            X1(2);
        }
    }

    public void y(boolean z2) {
        this.G.setVisibility(z2 ? 0 : 8);
    }

    public final /* synthetic */ void y1(View view) {
        this.A.performClick();
    }

    public final /* synthetic */ void z1(View view) {
        NaviUtil.u1(this, true, "navi_traffic_state");
    }
}
