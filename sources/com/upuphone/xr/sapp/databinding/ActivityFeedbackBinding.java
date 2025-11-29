package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class ActivityFeedbackBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6721a;
    public final FragmentContainerView b;

    public ActivityFeedbackBinding(LinearLayout linearLayout, FragmentContainerView fragmentContainerView) {
        this.f6721a = linearLayout;
        this.b = fragmentContainerView;
    }

    public static ActivityFeedbackBinding a(View view) {
        int i = R.id.my_feedback_navi;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.a(view, i);
        if (fragmentContainerView != null) {
            return new ActivityFeedbackBinding((LinearLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityFeedbackBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityFeedbackBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_feedback, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6721a;
    }
}
