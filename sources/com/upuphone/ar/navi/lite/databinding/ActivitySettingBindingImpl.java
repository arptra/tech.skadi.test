package com.upuphone.ar.navi.lite.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.upuphone.ar.navi.lite.BR;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.BaseViewModel;

public class ActivitySettingBindingImpl extends ActivitySettingBinding {
    public static final ViewDataBinding.IncludedLayouts L0 = null;
    public static final SparseIntArray M0;
    public final RelativeLayout J0;
    public long K0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M0 = sparseIntArray;
        sparseIntArray.put(R.id.top_action_bar, 1);
        sparseIntArray.put(R.id.navi_debug_menu, 2);
        sparseIntArray.put(R.id.message_mask_set_group, 3);
        sparseIntArray.put(R.id.message_mask, 4);
        sparseIntArray.put(R.id.message_mask_desp, 5);
        sparseIntArray.put(R.id.message_mask_set_switch, 6);
        sparseIntArray.put(R.id.address_set_group, 7);
        sparseIntArray.put(R.id.common_address, 8);
        sparseIntArray.put(R.id.common_address_array, 9);
        sparseIntArray.put(R.id.travel_mode, 10);
        sparseIntArray.put(R.id.travel_mode_desp, 11);
        sparseIntArray.put(R.id.travel_mode_array, 12);
        sparseIntArray.put(R.id.avoid_limite_set_group, 13);
        sparseIntArray.put(R.id.avoid_limite, 14);
        sparseIntArray.put(R.id.avoid_limite_switch, 15);
        sparseIntArray.put(R.id.car_setting, 16);
        sparseIntArray.put(R.id.car_setting_desp, 17);
        sparseIntArray.put(R.id.car_setting_more, 18);
        sparseIntArray.put(R.id.voice_set_group, 19);
        sparseIntArray.put(R.id.navi_voice, 20);
        sparseIntArray.put(R.id.voice_switch, 21);
        sparseIntArray.put(R.id.brightness_set_group, 22);
        sparseIntArray.put(R.id.brightness_title, 23);
        sparseIntArray.put(R.id.brightness_desp, 24);
        sparseIntArray.put(R.id.brightness_set_switch, 25);
        sparseIntArray.put(R.id.navi_display_position, 26);
        sparseIntArray.put(R.id.navi_display_menu, 27);
        sparseIntArray.put(R.id.display_lower_layout, 28);
        sparseIntArray.put(R.id.check_lower, 29);
        sparseIntArray.put(R.id.check_lower_icon, 30);
        sparseIntArray.put(R.id.display_middle_layout, 31);
        sparseIntArray.put(R.id.check_middle, 32);
        sparseIntArray.put(R.id.check_middle_icon, 33);
        sparseIntArray.put(R.id.display_upper_layout, 34);
        sparseIntArray.put(R.id.check_upper, 35);
        sparseIntArray.put(R.id.check_upper_icon, 36);
        sparseIntArray.put(R.id.navi_display_menu_title, 37);
        sparseIntArray.put(R.id.cross_check_layout, 38);
        sparseIntArray.put(R.id.cross_check_desp, 39);
        sparseIntArray.put(R.id.cross_check_summary_desp, 40);
        sparseIntArray.put(R.id.cross_check_switch, 41);
        sparseIntArray.put(R.id.traffic_wifi_group_layout, 42);
        sparseIntArray.put(R.id.traffic_set_group, 43);
        sparseIntArray.put(R.id.traffic, 44);
        sparseIntArray.put(R.id.traffic_switch, 45);
        sparseIntArray.put(R.id.wifi_download_set_group, 46);
        sparseIntArray.put(R.id.wifi_download, 47);
        sparseIntArray.put(R.id.wifi_download_switch, 48);
        sparseIntArray.put(R.id.navi_mode_set_group, 49);
        sparseIntArray.put(R.id.navi_mode, 50);
        sparseIntArray.put(R.id.realtime_navi_switch, 51);
        sparseIntArray.put(R.id.location_mode_set_group, 52);
        sparseIntArray.put(R.id.location_mode, 53);
        sparseIntArray.put(R.id.location_mode_switch, 54);
        sparseIntArray.put(R.id.mask, 55);
    }

    public ActivitySettingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.w(dataBindingComponent, view, 56, L0, M0));
    }

    private boolean C(BaseViewModel baseViewModel, int i) {
        if (i != BR.f5634a) {
            return false;
        }
        synchronized (this) {
            this.K0 |= 1;
        }
        return true;
    }

    public void D(BaseViewModel baseViewModel) {
        this.I0 = baseViewModel;
    }

    public void j() {
        synchronized (this) {
            this.K0 = 0;
        }
    }

    public boolean s() {
        synchronized (this) {
            try {
                return this.K0 != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void t() {
        synchronized (this) {
            this.K0 = 2;
        }
        A();
    }

    public boolean x(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return C((BaseViewModel) obj, i2);
    }

    public ActivitySettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, objArr[7], objArr[14], objArr[13], objArr[15], objArr[24], objArr[22], objArr[25], objArr[23], objArr[16], objArr[17], objArr[18], objArr[29], objArr[30], objArr[32], objArr[33], objArr[35], objArr[36], objArr[8], objArr[9], objArr[39], objArr[38], objArr[40], objArr[41], objArr[28], objArr[31], objArr[34], objArr[53], objArr[52], objArr[54], objArr[55], objArr[4], objArr[5], objArr[3], objArr[6], objArr[2], objArr[27], objArr[37], objArr[26], objArr[50], objArr[49], objArr[20], objArr[51], objArr[1], objArr[44], objArr[43], objArr[45], objArr[42], objArr[10], objArr[12], objArr[11], objArr[19], objArr[21], objArr[47], objArr[46], objArr[48]);
        this.K0 = -1;
        RelativeLayout relativeLayout = objArr[0];
        this.J0 = relativeLayout;
        relativeLayout.setTag((Object) null);
        B(view);
        t();
    }
}
