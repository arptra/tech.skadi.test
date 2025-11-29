package com.upuphone.ar.navi.lite.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.upuphone.ar.navi.lite.BR;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.BaseViewModel;

public class ActivityAddressBindingImpl extends ActivityAddressBinding {
    public static final ViewDataBinding.IncludedLayouts T = null;
    public static final SparseIntArray U;
    public final ConstraintLayout R;
    public long S;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        U = sparseIntArray;
        sparseIntArray.put(R.id.top_action_bar, 1);
        sparseIntArray.put(R.id.common_setting_layout, 2);
        sparseIntArray.put(R.id.common_address_title, 3);
        sparseIntArray.put(R.id.home_address, 4);
        sparseIntArray.put(R.id.home_more, 5);
        sparseIntArray.put(R.id.company_address, 6);
        sparseIntArray.put(R.id.company_more, 7);
        sparseIntArray.put(R.id.navi_mode_set, 8);
        sparseIntArray.put(R.id.navi_mode_set_hint, 9);
        sparseIntArray.put(R.id.navi_mode_set_layout, 10);
        sparseIntArray.put(R.id.recommend_navi_mode, 11);
        sparseIntArray.put(R.id.navi_mode_drive, 12);
        sparseIntArray.put(R.id.navi_mode_ride, 13);
        sparseIntArray.put(R.id.navi_mode_walk, 14);
        sparseIntArray.put(R.id.address_empty, 15);
        sparseIntArray.put(R.id.address_list, 16);
        sparseIntArray.put(R.id.mask, 17);
    }

    public ActivityAddressBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.w(dataBindingComponent, view, 18, T, U));
    }

    public void C(BaseViewModel baseViewModel) {
        this.Q = baseViewModel;
    }

    public final boolean D(BaseViewModel baseViewModel, int i) {
        if (i != BR.f5634a) {
            return false;
        }
        synchronized (this) {
            this.S |= 1;
        }
        return true;
    }

    public void j() {
        synchronized (this) {
            this.S = 0;
        }
    }

    public boolean s() {
        synchronized (this) {
            try {
                return this.S != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void t() {
        synchronized (this) {
            this.S = 2;
        }
        A();
    }

    public boolean x(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return D((BaseViewModel) obj, i2);
    }

    public ActivityAddressBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, objArr[15], objArr[16], objArr[3], objArr[2], objArr[6], objArr[7], objArr[4], objArr[5], objArr[17], objArr[12], objArr[13], objArr[8], objArr[9], objArr[10], objArr[14], objArr[11], objArr[1]);
        this.S = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.R = constraintLayout;
        constraintLayout.setTag((Object) null);
        B(view);
        t();
    }
}
