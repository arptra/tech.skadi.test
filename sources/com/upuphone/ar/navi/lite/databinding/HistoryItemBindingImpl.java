package com.upuphone.ar.navi.lite.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.upuphone.ar.navi.lite.BR;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.Record;

public class HistoryItemBindingImpl extends HistoryItemBinding {
    public static final ViewDataBinding.IncludedLayouts F = null;
    public static final SparseIntArray G;
    public final ConstraintLayout D;
    public long E;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        G = sparseIntArray;
        sparseIntArray.put(R.id.history_delete, 3);
    }

    public HistoryItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.w(dataBindingComponent, view, 4, F, G));
    }

    public final boolean C(Record record, int i) {
        if (i != BR.f5634a) {
            return false;
        }
        synchronized (this) {
            this.E |= 1;
        }
        return true;
    }

    public void j() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j = this.E;
            this.E = 0;
        }
        Record record = this.C;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        String str5 = null;
        if (i != 0) {
            if (record != null) {
                String g = record.g();
                String e = record.e();
                str3 = record.k();
                String str6 = e;
                str4 = g;
                str5 = record.q();
                str2 = str6;
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
            }
            str = (((str5 + '.') + str4) + '.') + str3;
            str5 = str2;
        } else {
            str = null;
        }
        if (i != 0) {
            TextViewBindingAdapter.b(this.A, str5);
            TextViewBindingAdapter.b(this.B, str);
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
            this.E = 2;
        }
        A();
    }

    public boolean x(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return C((Record) obj, i2);
    }

    public HistoryItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, objArr[3], objArr[1], objArr[2]);
        this.E = -1;
        this.A.setTag((Object) null);
        this.B.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.D = constraintLayout;
        constraintLayout.setTag((Object) null);
        B(view);
        t();
    }
}
