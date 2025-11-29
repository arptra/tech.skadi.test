package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class ActivityRoleVprintBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6727a;
    public final FragmentContainerView b;

    public ActivityRoleVprintBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView) {
        this.f6727a = constraintLayout;
        this.b = fragmentContainerView;
    }

    public static ActivityRoleVprintBinding a(View view) {
        int i = R.id.role_vprint_container;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.a(view, i);
        if (fragmentContainerView != null) {
            return new ActivityRoleVprintBinding((ConstraintLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityRoleVprintBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityRoleVprintBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_role_vprint, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6727a;
    }
}
