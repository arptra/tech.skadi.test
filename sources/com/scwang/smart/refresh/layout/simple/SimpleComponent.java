package com.scwang.smart.refresh.layout.simple;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshComponent;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshKernel;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;

public abstract class SimpleComponent extends RelativeLayout implements RefreshComponent {

    /* renamed from: a  reason: collision with root package name */
    public View f9866a;
    public SpinnerStyle b;
    public RefreshComponent c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleComponent(View view) {
        this(view, view instanceof RefreshComponent ? (RefreshComponent) view : null);
    }

    public boolean a(boolean z) {
        RefreshComponent refreshComponent = this.c;
        return (refreshComponent instanceof RefreshFooter) && ((RefreshFooter) refreshComponent).a(z);
    }

    public void b(RefreshLayout refreshLayout, int i, int i2) {
        RefreshComponent refreshComponent = this.c;
        if (refreshComponent != null && refreshComponent != this) {
            refreshComponent.b(refreshLayout, i, i2);
        }
    }

    public void c(RefreshLayout refreshLayout, int i, int i2) {
        RefreshComponent refreshComponent = this.c;
        if (refreshComponent != null && refreshComponent != this) {
            refreshComponent.c(refreshLayout, i, i2);
        }
    }

    public void d(float f, int i, int i2) {
        RefreshComponent refreshComponent = this.c;
        if (refreshComponent != null && refreshComponent != this) {
            refreshComponent.d(f, i, i2);
        }
    }

    public boolean e() {
        RefreshComponent refreshComponent = this.c;
        return (refreshComponent == null || refreshComponent == this || !refreshComponent.e()) ? false : true;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof RefreshComponent) {
            return getView() == ((RefreshComponent) obj).getView();
        }
        return false;
    }

    public int f(RefreshLayout refreshLayout, boolean z) {
        RefreshComponent refreshComponent = this.c;
        if (refreshComponent == null || refreshComponent == this) {
            return 0;
        }
        return refreshComponent.f(refreshLayout, z);
    }

    public void g(RefreshKernel refreshKernel, int i, int i2) {
        RefreshComponent refreshComponent = this.c;
        if (refreshComponent == null || refreshComponent == this) {
            View view = this.f9866a;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                    refreshKernel.e(this, ((SmartRefreshLayout.LayoutParams) layoutParams).f9860a);
                    return;
                }
                return;
            }
            return;
        }
        refreshComponent.g(refreshKernel, i, i2);
    }

    @NonNull
    public SpinnerStyle getSpinnerStyle() {
        int i;
        SpinnerStyle spinnerStyle = this.b;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        RefreshComponent refreshComponent = this.c;
        if (refreshComponent != null && refreshComponent != this) {
            return refreshComponent.getSpinnerStyle();
        }
        View view = this.f9866a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                SpinnerStyle spinnerStyle2 = ((SmartRefreshLayout.LayoutParams) layoutParams).b;
                this.b = spinnerStyle2;
                if (spinnerStyle2 != null) {
                    return spinnerStyle2;
                }
            }
            if (layoutParams != null && ((i = layoutParams.height) == 0 || i == -1)) {
                for (SpinnerStyle spinnerStyle3 : SpinnerStyle.i) {
                    if (spinnerStyle3.c) {
                        this.b = spinnerStyle3;
                        return spinnerStyle3;
                    }
                }
            }
        }
        SpinnerStyle spinnerStyle4 = SpinnerStyle.d;
        this.b = spinnerStyle4;
        return spinnerStyle4;
    }

    @NonNull
    public View getView() {
        View view = this.f9866a;
        return view == null ? this : view;
    }

    public void h(boolean z, float f, int i, int i2, int i3) {
        RefreshComponent refreshComponent = this.c;
        if (refreshComponent != null && refreshComponent != this) {
            refreshComponent.h(z, f, i, i2, i3);
        }
    }

    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        RefreshComponent refreshComponent = this.c;
        if (refreshComponent != null && refreshComponent != this) {
            if ((this instanceof RefreshFooter) && (refreshComponent instanceof RefreshHeader)) {
                if (refreshState.isFooter) {
                    refreshState = refreshState.toHeader();
                }
                if (refreshState2.isFooter) {
                    refreshState2 = refreshState2.toHeader();
                }
            } else if ((this instanceof RefreshHeader) && (refreshComponent instanceof RefreshFooter)) {
                if (refreshState.isHeader) {
                    refreshState = refreshState.toFooter();
                }
                if (refreshState2.isHeader) {
                    refreshState2 = refreshState2.toFooter();
                }
            }
            RefreshComponent refreshComponent2 = this.c;
            if (refreshComponent2 != null) {
                refreshComponent2.onStateChanged(refreshLayout, refreshState, refreshState2);
            }
        }
    }

    public void setPrimaryColors(@ColorInt int... iArr) {
        RefreshComponent refreshComponent = this.c;
        if (refreshComponent != null && refreshComponent != this) {
            refreshComponent.setPrimaryColors(iArr);
        }
    }

    public SimpleComponent(View view, RefreshComponent refreshComponent) {
        super(view.getContext(), (AttributeSet) null, 0);
        this.f9866a = view;
        this.c = refreshComponent;
        if ((this instanceof RefreshFooter) && (refreshComponent instanceof RefreshHeader) && refreshComponent.getSpinnerStyle() == SpinnerStyle.h) {
            refreshComponent.getView().setScaleY(-1.0f);
        } else if (this instanceof RefreshHeader) {
            RefreshComponent refreshComponent2 = this.c;
            if ((refreshComponent2 instanceof RefreshFooter) && refreshComponent2.getSpinnerStyle() == SpinnerStyle.h) {
                refreshComponent.getView().setScaleY(-1.0f);
            }
        }
    }

    public SimpleComponent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
