package com.upuphone.ar.tici.phone.epoxy;

import android.view.ViewParent;
import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.EpoxyViewHolder;
import com.airbnb.epoxy.GeneratedModel;
import com.airbnb.epoxy.OnModelBoundListener;
import com.airbnb.epoxy.OnModelUnboundListener;
import com.airbnb.epoxy.OnModelVisibilityChangedListener;
import com.airbnb.epoxy.OnModelVisibilityStateChangedListener;
import com.upuphone.ar.tici.phone.data.SystemFileInfo;
import com.upuphone.ar.tici.phone.listener.SystemFileItemListener;

public class SystemFileModel_ extends SystemFileModel implements GeneratedModel<SystemFileHolder>, SystemFileModelBuilder {
    public OnModelBoundListener q;
    public OnModelUnboundListener r;
    public OnModelVisibilityStateChangedListener s;
    public OnModelVisibilityChangedListener t;

    /* renamed from: A0 */
    public void c0(SystemFileHolder systemFileHolder) {
        super.R(systemFileHolder);
        OnModelUnboundListener onModelUnboundListener = this.r;
        if (onModelUnboundListener != null) {
            onModelUnboundListener.a(this, systemFileHolder);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SystemFileModel_) || !super.equals(obj)) {
            return false;
        }
        SystemFileModel_ systemFileModel_ = (SystemFileModel_) obj;
        if ((this.q == null) != (systemFileModel_.q == null)) {
            return false;
        }
        if ((this.r == null) != (systemFileModel_.r == null)) {
            return false;
        }
        if ((this.s == null) != (systemFileModel_.s == null)) {
            return false;
        }
        if ((this.t == null) != (systemFileModel_.t == null)) {
            return false;
        }
        SystemFileInfo systemFileInfo = this.m;
        if (systemFileInfo == null ? systemFileModel_.m != null : !systemFileInfo.equals(systemFileModel_.m)) {
            return false;
        }
        if (i0() != systemFileModel_.i0()) {
            return false;
        }
        return (j0() == null) == (systemFileModel_.j0() == null) && k0() == systemFileModel_.k0();
    }

    public int hashCode() {
        int i = 1;
        int hashCode = ((((((((super.hashCode() * 31) + (this.q != null ? 1 : 0)) * 31) + (this.r != null ? 1 : 0)) * 31) + (this.s != null ? 1 : 0)) * 31) + (this.t != null ? 1 : 0)) * 31;
        SystemFileInfo systemFileInfo = this.m;
        int hashCode2 = (((hashCode + (systemFileInfo != null ? systemFileInfo.hashCode() : 0)) * 31) + i0()) * 31;
        if (j0() == null) {
            i = 0;
        }
        return ((hashCode2 + i) * 31) + (k0() ? 1 : 0);
    }

    /* renamed from: p0 */
    public SystemFileHolder W(ViewParent viewParent) {
        return new SystemFileHolder();
    }

    /* renamed from: q0 */
    public void d(SystemFileHolder systemFileHolder, int i) {
        OnModelBoundListener onModelBoundListener = this.q;
        if (onModelBoundListener != null) {
            onModelBoundListener.a(this, systemFileHolder, i);
        }
        S("The model was changed during the bind call.", i);
    }

    public void r(EpoxyController epoxyController) {
        super.r(epoxyController);
        s(epoxyController);
    }

    /* renamed from: r0 */
    public void k(EpoxyViewHolder epoxyViewHolder, SystemFileHolder systemFileHolder, int i) {
        S("The model was changed between being added to the controller and being bound.", i);
    }

    /* renamed from: s0 */
    public SystemFileModel_ E(long j) {
        super.E(j);
        return this;
    }

    /* renamed from: t0 */
    public SystemFileModel_ a(CharSequence charSequence) {
        super.F(charSequence);
        return this;
    }

    public String toString() {
        return "SystemFileModel_{systemFileInfo=" + this.m + ", itemBgRes=" + i0() + ", listener=" + j0() + ", supportLargeFile=" + k0() + "}" + super.toString();
    }

    /* renamed from: u0 */
    public SystemFileModel_ b(int i) {
        J();
        super.m0(i);
        return this;
    }

    /* renamed from: v0 */
    public SystemFileModel_ e(SystemFileItemListener systemFileItemListener) {
        J();
        super.n0(systemFileItemListener);
        return this;
    }

    /* renamed from: w0 */
    public void a0(float f, float f2, int i, int i2, SystemFileHolder systemFileHolder) {
        OnModelVisibilityChangedListener onModelVisibilityChangedListener = this.t;
        if (onModelVisibilityChangedListener != null) {
            onModelVisibilityChangedListener.a(this, systemFileHolder, f, f2, i, i2);
        }
        super.M(f, f2, i, i2, systemFileHolder);
    }

    /* renamed from: x0 */
    public void b0(int i, SystemFileHolder systemFileHolder) {
        OnModelVisibilityStateChangedListener onModelVisibilityStateChangedListener = this.s;
        if (onModelVisibilityStateChangedListener != null) {
            onModelVisibilityStateChangedListener.a(this, systemFileHolder, i);
        }
        super.N(i, systemFileHolder);
    }

    /* renamed from: y0 */
    public SystemFileModel_ h(boolean z) {
        J();
        super.o0(z);
        return this;
    }

    /* renamed from: z0 */
    public SystemFileModel_ o(SystemFileInfo systemFileInfo) {
        J();
        this.m = systemFileInfo;
        return this;
    }
}
