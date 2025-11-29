package com.upuphone.xr.sapp.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.upuphone.xr.sapp.R;

public class LayoutDoubleChannelControlBindingImpl extends LayoutDoubleChannelControlBinding {
    public static final ViewDataBinding.IncludedLayouts J = null;
    public static final SparseIntArray K;
    public final LinearLayout H;
    public long I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K = sparseIntArray;
        sparseIntArray.put(R.id.tvStarryChannel, 1);
        sparseIntArray.put(R.id.tvP2pChannelState, 2);
        sparseIntArray.put(R.id.launcher_debug, 3);
        sparseIntArray.put(R.id.launcher_go_home, 4);
        sparseIntArray.put(R.id.set_debug_filter, 5);
        sparseIntArray.put(R.id.debug_item, 6);
        sparseIntArray.put(R.id.bt_open_translation, 7);
        sparseIntArray.put(R.id.bt_reminder, 8);
    }

    public LayoutDoubleChannelControlBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.w(dataBindingComponent, view, 9, J, K));
    }

    public void j() {
        synchronized (this) {
            this.I = 0;
        }
    }

    public boolean s() {
        synchronized (this) {
            try {
                return this.I != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void t() {
        synchronized (this) {
            this.I = 1;
        }
        A();
    }

    public boolean x(int i, Object obj, int i2) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutDoubleChannelControlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[7], objArr[8], objArr[6], objArr[3], objArr[4], objArr[5], objArr[2], objArr[1]);
        this.I = -1;
        LinearLayout linearLayout = objArr[0];
        this.H = linearLayout;
        linearLayout.setTag((Object) null);
        View view2 = view;
        B(view);
        t();
    }
}
