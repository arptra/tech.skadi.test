package com.upuphone.xr.sapp.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.upuphone.xr.sapp.R;

public class FragmentStarryNetDeviceListBindingImpl extends FragmentStarryNetDeviceListBinding {
    public static final ViewDataBinding.IncludedLayouts F = null;
    public static final SparseIntArray G;
    public final LinearLayout D;
    public long E;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        G = sparseIntArray;
        sparseIntArray.put(R.id.tv, 1);
        sparseIntArray.put(R.id.pb_scan_flag, 2);
        sparseIntArray.put(R.id.tv_scan, 3);
        sparseIntArray.put(R.id.rv_device_list, 4);
    }

    public FragmentStarryNetDeviceListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.w(dataBindingComponent, view, 5, F, G));
    }

    public void j() {
        synchronized (this) {
            this.E = 0;
        }
    }

    public boolean s() {
        synchronized (this) {
            try {
                return this.E != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void t() {
        synchronized (this) {
            this.E = 1;
        }
        A();
    }

    public boolean x(int i, Object obj, int i2) {
        return false;
    }

    public FragmentStarryNetDeviceListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[4], objArr[1], objArr[3]);
        this.E = -1;
        LinearLayout linearLayout = objArr[0];
        this.D = linearLayout;
        linearLayout.setTag((Object) null);
        B(view);
        t();
    }
}
